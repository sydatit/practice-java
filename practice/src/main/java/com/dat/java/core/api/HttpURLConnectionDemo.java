package com.dat.java.core.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();


    }
}
