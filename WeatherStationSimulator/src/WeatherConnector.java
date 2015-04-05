import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Stack;

public class WeatherConnector {
  private WeatherData wd; 
  private WeatherDataAdapter wda;
  private Stack wdList = new Stack();
  
  public WeatherConnector(WeatherData weatherData) {
    int h = 0, wS = 0, wC = 0;
    double t = 0, p = 0;
    
    try {
      // Registers driver and connects to database
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/weatherStation","weather","WeatherPassword!");
      Statement stmt = con.createStatement();

      // Pulls the entire table and its metadata
      stmt.execute("SELECT * FROM data ORDER BY id ASC");
      ResultSet rs = stmt.getResultSet();

      // Temporary storage of data pre-adapter
      while (rs.next()) {
        t = rs.getDouble("temperature");
        p = rs.getDouble("pressure");
        h = rs.getInt("humidity");
        wS = rs.getInt("windSpeed");
        this.wd = weatherData;
        this.wda = new WeatherDataAdapter(wd);
        this.wd = wda.convertFromSQL(t, p, h, wS);
        
        wdList.add(this.wd);
      }
      
      con.close();
    } catch(Exception e) {
      System.out.println( "SQL Execption: " + e);
      
      //Alert the user and quit the program if it cannot connect to database
      WeatherStation.infoBox("Unable to connect to database. Exiting.", "Error!");
      System.exit(1);
    }
    
  }
  
  public Float[] getData() {
    Float[] data = new Float[5];
    if (!wdList.isEmpty()) {
      this.wd = (WeatherData)wdList.firstElement();
      wdList.remove(0);
      data[0] = this.wd.getTemperature();
      data[1] = this.wd.getPressure();
      data[2] = this.wd.getHumidity();
      data[3] = this.wd.getWindSpeed();
      data[4] = this.wd.getWindChill();
      return data;
    } else {
      data[0] = (float)9999;
      return data;
    }
  }
  
  public Boolean addData(float t, float p, float h, float wS) {
    ArrayList al = wda.convertToSQL(t, p, h, wS);
    
    try {
      // Registers driver and connects to database
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/weatherStation","weather","WeatherPassword!");
      Statement stmt = con.createStatement();

      // Pulls the entire table and its metadata
      String query = "INSERT INTO data (temperature, pressure, humidity, windSpeed) " + 
                     "VALUES (" + al.get(0) + ", " + 
                     al.get(1) + ", " + al.get(2) + ", " + 
                     al.get(3) + ")";
      stmt.execute(query);
      
      this.wd.setMeasurements(t, p, h, wS);
      wdList.add(this.wd);
      
      con.close();
      return true;
    } catch(Exception e) {
      System.out.println( "SQL Execption: " + e);
    }
    return false;
  }
}