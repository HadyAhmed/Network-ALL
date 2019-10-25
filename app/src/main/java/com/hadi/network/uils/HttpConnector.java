package com.hadi.network.uils;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnector {

    private static final String TAG = "HttpConnector";

    public static URL getMovies() {
        Uri.Builder uri = new Uri.Builder();
        uri.scheme("https")
                .authority("yts.lt")
                .appendPath("api")
                .appendPath("v2")
                .appendPath("list_movies.json");

        URL url = null;
        try {
            url = new URL(uri.toString());
            Log.i(TAG, "getMovies: " + url.toString());

        } catch (MalformedURLException e) {
            Log.e(TAG, "ytsUrl: ", e);
        }
        return url;
    }

    public static URL searchMovie(String movieName) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("yts.lt")
                .appendPath("api/v2/list_movies.json")
                .appendQueryParameter("query_term", movieName);

        URL url = null;
        try {
            url = new URL(builder.toString());
        } catch (MalformedURLException e) {
            Log.e(TAG, "searchMovie: ", e);
        }

        return url;
    }

    public static String httpConnection(URL url) throws IOException {
        String response = null;

        HttpURLConnection urlConnection = null;

        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();

            if (urlConnection.getResponseCode() == 200) {
                response = readFromStream(inputStream);
            }

        } catch (IOException e) {
            Log.e(TAG, "httpConnection: ", e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return response;
    }

    private static String readFromStream(InputStream inputStream) {
        // TODO: 10/25/2019 make the input stream reader here
        return null;
    }
}
