package ru.rgordeev.httpexample;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.rgordeev.httpexample.model.Currencies;
import ru.rgordeev.httpexample.model.Film;
import ru.rgordeev.httpexample.model.Person;

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

    private class HTTPConnection extends AsyncTask<Void, Void, Person> {

        @Override
        protected void onPostExecute(Person person) {
            output.setText(String.format("%s", person.toString()));
        }

        @Override
        protected Person doInBackground(Void... voids) {

            Person result;
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://swapi.dev/api/people/1")
                    .get()
                    .build();



            try {
                Response response = httpClient.newCall(request).execute();
                String text = response.body().string();
                Gson gson = new GsonBuilder().setFieldNamingStrategy(LOWER_CASE_WITH_UNDERSCORES).create();
                result = gson.fromJson(text, Person.class);

                for (String filmUrl: result.getFilms()) {
                    Request requestFilm = new Request.Builder()
                            .url(filmUrl)
                            .get()
                            .build();
                    Response responseFilm = httpClient.newCall(requestFilm).execute();
                    String textFilm = responseFilm.body().string();
                    Film film = gson.fromJson(textFilm, Film.class);
                    result.getFilmObjects().add(film);
                }
            } catch (IOException e) {
                e.printStackTrace();
                result = null;
            }

            return result;
        }
    }
}
