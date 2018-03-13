package com.example.android.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String urlString = "https://jsonplaceholder.typicode.com/users";
        urlConnection(urlString);
    }

    public String urlConnection(String urlString)
    {
        String line = "";
        try{
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            InputStreamReader isr = new InputStreamReader(connection.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            line = in.readLine();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Log.i("JSON", line);
        return line;
    }
}
