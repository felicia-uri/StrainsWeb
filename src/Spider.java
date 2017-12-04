import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Spider {
  public static void main(String[] args) throws IOException, InterruptedException {

    for (int i = 1; i < 5; i++) {
      URL url = new URL("https://www.cannabisreports.com/api/v1.0/strains?page="+i);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer content = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      System.out.println(content);
      Thread.sleep(1000);
    }
  }


}
