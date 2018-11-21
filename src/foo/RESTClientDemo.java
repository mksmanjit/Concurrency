package foo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RESTClientDemo {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dev-451813.oktapreview.com/oauth2/default/v1/token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("authorization",
                    "Basic MG9hZG5lcDhyelJwcGI4WGUwaDc6bHNnLWhjYkh1eVA3VngtSDFhYmR0WC0ydDE2N1YwYXA3dGpFVW92MA==");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("content-Type", "application/x-www-form-urlencoded");
            
            String input = "grant_type=password&username=mksmanjit@gmail.com&password=M@njit3531&scope=offline_access";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            
            JSONParser parser = new JSONParser();
            JSONObject json = null;
            try {
                json = (JSONObject) parser.parse(br.readLine());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(json.get("access_token"));
            conn.disconnect();

        } catch(MalformedURLException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
     }

    }

}
