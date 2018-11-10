package sunrec.com.sunrec.control;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sunrec.com.sunrec.model.Alert;
import sunrec.com.sunrec.model.Profile;

/**
 * Created by Ricardo Silva on 10/11/2018.
 */
public class RequestHandler {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private final String BASEURL = "https://sunrec.herokuapp.com/";
    private String token = "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDE5MjI5NTM1ODgsImlhdCI6MTU0MTgzNjU1MzU5Mywic3ViIjoiNWJlNjhlZjY0NTYwNzI0NjY4YmNlYmE1In0.SXhC2h0k_zW_o36zEEevjh3pJ2aBSUwEea7eArMFLQo";

    public void registerAlert(Alert alert) {
        Gson gson = new Gson();
        String json = gson.toJson(alert);
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"alerts")
                .header("Authorization", token)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                String debug = response.body().string();
//                if (response.isSuccessful()) {
//                    final String myResponse = response.body().string();
//
//                }
            }
        });
    }

    public void getAlerts(){
        String params = "?limit=999";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"alerts"+params)
                .header("Authorization", token)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String debug = response.body().string();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    System.out.println(myResponse);
                    // todo - tratar alertas para mandar o array
                }
            }
        });

    }

    public void voteUp(Alert alert) {
        String alertId = alert.get_id();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"alerts/"+alertId+"/vote")
                .header("Authorization", token)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String debug = response.body().string();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    System.out.println(myResponse);
                    // todo - tratar alertas para mandar o array
                }
            }
        });

    }

    public void resolve(Alert alert) {
        String alertId = alert.get_id();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"alerts/"+alertId+"/resolve")
                .header("Authorization", token)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String debug = response.body().string();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    System.out.println(myResponse);
                    // todo - tratar alertas para mandar o array
                }
            }
        });

    }

    public void getUserProfileById(String userId){
        String params = "?user=" + userId;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"profiles"+params)
                .header("Authorization", token)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String debug = response.body().string();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    System.out.println(myResponse);
                    // todo - tratar alertas para mandar o array
                }
            }
        });

    }

    public void updateProfile(Profile profile) {
        String profileId = profile.get_id();
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        RequestBody body = RequestBody.create(JSON, json);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASEURL+"profiles/"+profileId)
                .header("Authorization", token)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String debug = response.body().string();
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    System.out.println(myResponse);
                }
            }
        });
    }

}
