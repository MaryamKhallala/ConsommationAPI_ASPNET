package com.example.controller;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReaderMiddleWare {
    public static String loadDataFromLink(Context context, URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String body = null;
        StringBuffer str = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null){
                sb.append(line).append('\n');
            }

            body = sb.toString();

            Log.d("HTTP-GET", body);
        }catch (Exception e){
            System.err.println("==Err==: "+ e);
        }

        return body;
    }


}
