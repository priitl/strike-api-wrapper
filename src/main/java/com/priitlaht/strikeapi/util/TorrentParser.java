package com.priitlaht.strikeapi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.priitlaht.strikeapi.model.Torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance;

/**
 * @author Priit Laht
 */
public class TorrentParser {
  private static final String TORRENT_NODE_NAME = "torrents";
  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Torrent> parse(String json) {
    List<Torrent> result = new ArrayList<Torrent>();
    try {
      JsonNode node = objectMapper.readValue(json, JsonNode.class).findValue(TORRENT_NODE_NAME);
      List<Torrent> torrents = objectMapper.convertValue(node, defaultInstance().constructCollectionType(List.class, Torrent.class));
      if (torrents != null) {
        result.addAll(torrents);
      }
      return result;
    } catch (IOException e) {
      return result;
    }
  }
}
