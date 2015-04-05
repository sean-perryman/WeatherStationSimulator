import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Stack;

public class WeatherConnector {
  private WeatherData wd; 
  private WeatherDataAdapter wda;
  private Stack wdList = new Stack();
  
  public WeatherConnector(WeatherData weatherData) {
    int id = 0, h = 0, wS = 0, wC = 0;
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
        wC = rs.getInt("windChill");
        this.wd = weatherData;
        this.wda = new WeatherDataAdapter(wd);
        this.wd = wda.convertFromSQL(t, p, h, wS, wC);
        
        wdList.add(this.wd);
      }
      
      con.close();
    } catch(Exception e) {
      System.out.println( "SQL Execption: " + e);
    }
    
  }
  
  public Float[] getData() {
    Float[] data = new Float[5];
    if (!wdList.isEmpty()) {
      this.wd = (WeatherData)wdList.pop();
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
}