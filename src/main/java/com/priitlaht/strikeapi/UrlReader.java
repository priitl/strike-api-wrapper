package com.priitlaht.strikeapi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Priit Laht
 */
public class UrlReader {

  public static String read(String url) {
    StringBuilder result = new StringBuilder();
    try {
      HttpClient client = HttpClientBuilder.create().build();
      HttpGet httpGet = new HttpGet(url);
      httpGet.addHeader("accept", "application/json");
      HttpResponse response = client.execute(httpGet);
      BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        result.append(inputLine);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result.toString();
  }
}
