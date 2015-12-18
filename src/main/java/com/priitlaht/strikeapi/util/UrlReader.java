package com.priitlaht.strikeapi.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Priit Laht
 */
public class UrlReader {

  public String read(String url, NameValuePair... parameters) {
    try {
      HttpClient client = HttpClientBuilder.create().build();
      HttpResponse response = client.execute(buildGetMethod(url, parameters));
      HttpEntity entity = response.getEntity();
      return EntityUtils.toString(entity, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return "";
  }

  private HttpGet buildGetMethod(String url, NameValuePair... parameters) throws URISyntaxException {
    URIBuilder builder = new URIBuilder(url);
    builder.setParameters(parameters);
    HttpGet httpGet = new HttpGet(builder.build());
    httpGet.addHeader("accept", "application/json");
    return httpGet;
  }
}
