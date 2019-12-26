package ru.rgordeev.httpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    public void getCurrencies(View view) {
        new HTTPConnection().execute();
    }

    public void cleanUp(View view) {

    }

    private class HTTPConnection extends AsyncTask<Void, Void, JsonElement> {

        @Override
        protected void onPostExecute(JsonElement jsonElement) {
            super.onPostExecute(jsonElement);
            String text = jsonElement == null ? "" : jsonElement.toString();

            output.setText(text);
        }

        @Override
        protected JsonElement doInBackground(Void... voids) {

            JsonElement result;
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.exchangeratesapi.io/latest")
                    .get()
                    .build();

            try {
                Response response = httpClient.newCall(request).execute();
                String text = response.body().string();
                result = new Gson().fromJson(text, JsonElement.class);
            } catch (IOException e) {
                e.printStackTrace();
                result = null;
            }

            return result;
        }
    }
}
