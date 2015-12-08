package com.priitlaht.strikeapi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.priitlaht.strikeapi.model.Torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Priit Laht
 */
public class TorrentParser {
  private static final String TORRENT_NODE_NAME = "torrents";
  private static ObjectMapper objectMapper = new ObjectMapper();

  public static List<Torrent> parse(String json) {
    List<Torrent> result = new ArrayList<Torrent>();
    try {
      JsonNode node = objectMapper.readValue(json, JsonNode.class);
      JsonNode torrentsNode = node.get(TORRENT_NODE_NAME);
      if (torrentsNode != null) {
        for (JsonNode torrentNode : torrentsNode) {
          result.add(toTorrent(torrentNode));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static Torrent toTorrent(JsonNode torrentNode) {
    Torrent torrent = new Torrent();
    torrent.setHash(torrentNode.get("torrent_hash").asText());
    torrent.setTitle(torrentNode.get("torrent_title").asText());
    torrent.setCategory(torrentNode.get("torrent_category").asText());
    torrent.setSubcategory(torrentNode.get("sub_category").asText());
    torrent.setSeeds(safeParseInt(torrentNode.get("seeds").asText()));
    torrent.setLeeches(safeParseInt(torrentNode.get("leeches").asText()));
    torrent.setFileCount(safeParseInt(torrentNode.get("file_count").asText()));
    torrent.setSize(safeParseInt(torrentNode.get("size").asText()));
    torrent.setUploadDate(new Date(safeParseTimestamp(torrentNode.get("upload_date").asText())));
    torrent.setMagnetUri(torrentNode.get("magnet_uri").asText());
    return torrent;
  }

  private static Integer safeParseInt(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  private static Long safeParseTimestamp(String value) {
    try {
      return Long.parseLong(value) * 1000;
    } catch (NumberFormatException e) {
      return new Date().getTime();
    }
  }
}
