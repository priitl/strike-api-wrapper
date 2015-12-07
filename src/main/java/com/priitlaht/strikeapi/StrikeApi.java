package com.priitlaht.strikeapi;


/**
 * @author Priit Laht
 */
public class StrikeApi {
  //test query
  private static final String API_URL = "http://getstrike.net/api/v2/torrents/search/?phrase=marvel";

  public static void main(String... args) {
    System.err.println(UrlReader.read(API_URL));
  }


}
