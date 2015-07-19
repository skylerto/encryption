package Scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by skylerlayne on 2015-07-18.
 */
public class SSHGrabber {

    public String username;
    public String key;

    public SSHGrabber(String username){
        this.username = username;
    }

    public String grab(){
        String key = "";
        try {
            URL url = new URL("https://github.com/" + this.username + ".keys");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                for (String line; (line = reader.readLine()) != null;) {
                    this.key = line;
                    return line;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return key;
    }

    public String parse(String key){
        String fin = key.substring(key.indexOf(" ") + 1, key.length());
        return fin;
    }

    public static void main(String[] args) {
        SSHGrabber grabber = new SSHGrabber("skylerto");
        grabber.parse(grabber.grab());
    }

}
