package com.priitlaht.strikeapi;


import com.priitlaht.strikeapi.model.Category;
import com.priitlaht.strikeapi.model.Torrent;
import com.priitlaht.strikeapi.model.VideoQuality;
import com.priitlaht.strikeapi.util.TorrentParser;
import com.priitlaht.strikeapi.util.UrlReader;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * @author Priit Laht
 */
public class StrikeApi {
  private static final String API_URL = "http://getstrike.net/api/v2/torrents";

  public static List<Torrent> search(String searchPhrase) {
    NameValuePair searchParameter = new BasicNameValuePair("phrase", searchPhrase);
    return TorrentParser.parse(UrlReader.read(API_URL + "/search/", searchParameter));
  }

  public static List<Torrent> search(String searchPhrase, VideoQuality quality) {
    NameValuePair searchParameter = new BasicNameValuePair("phrase", searchPhrase + " " + quality.value);
    return TorrentParser.parse(UrlReader.read(API_URL + "/search/", searchParameter));
  }

  public static List<Torrent> searchCategory(String searchPhrase, Category category) {
    NameValuePair searchParameter = new BasicNameValuePair("phrase", searchPhrase);
    NameValuePair categoryParameter = new BasicNameValuePair("category", category.name());
    return TorrentParser.parse(UrlReader.read(API_URL + "/search/", searchParameter, categoryParameter));
  }

  public static List<Torrent> searchCategory(String searchPhrase, Category category, VideoQuality quality) {
    NameValuePair searchParameter = new BasicNameValuePair("phrase", searchPhrase + " " + quality.value);
    NameValuePair categoryParameter = new BasicNameValuePair("category", category.name());
    return TorrentParser.parse(UrlReader.read(API_URL + "/search/", searchParameter, categoryParameter));
  }

  public static List<Torrent> top(Category category) {
    NameValuePair categoryParameter = new BasicNameValuePair("category", category.name());
    return TorrentParser.parse(UrlReader.read(API_URL + "/top/", categoryParameter));
  }

  public static List<Torrent> find(String hash) {
    NameValuePair hashParameter = new BasicNameValuePair("hashes", hash);
    return TorrentParser.parse(UrlReader.read(API_URL + "/info/", hashParameter));
  }

}
