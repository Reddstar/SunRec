package sunrec.com.sunrec;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import sunrec.com.sunrec.model.Alert;

/**
 * Created by Ricardo Silva on 10/11/2018.
 */
public class RequestHandler {
    private final String BASEURL = "https://sunrec.herokuapp.com/";

    public void registerAlert(Alert alert) throws IOException {
        Gson gson = new Gson();
        String alertString = gson.toJson(alert);
        URL url = new URL(BASEURL+"alerts");
        HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDE5MjI5NTM1ODgsImlhdCI6MTU0MTgzNjU1MzU5Mywic3ViIjoiNWJlNjhlZjY0NTYwNzI0NjY4YmNlYmE1In0.SXhC2h0k_zW_o36zEEevjh3pJ2aBSUwEea7eArMFLQo");
        OutputStreamWriter osw =  new OutputStreamWriter(conn.getOutputStream());
        osw.write(alertString);
        osw.flush();
    }



    public void profileByUserCode(String code){
    }
}
