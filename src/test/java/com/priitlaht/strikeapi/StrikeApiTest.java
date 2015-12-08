package com.priitlaht.strikeapi;

import com.priitlaht.strikeapi.model.Category;
import com.priitlaht.strikeapi.model.Torrent;
import com.priitlaht.strikeapi.model.VideoQuality;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Priit Laht
 */
public class StrikeApiTest {
  private static final String DEFAULT_SEARCH_PHRASE = "marvel";
  private static final VideoQuality DEFAULT_VIDEO_QUALITY = VideoQuality.SD480P;
  private static final Category DEFAULT_CATEGORY = Category.TV;

  @Test
  public void testSearch() {
    List<Torrent> result = StrikeApi.search(DEFAULT_SEARCH_PHRASE);
    Assert.assertThat(result.isEmpty(), is(false));
    Torrent topTorrent = result.get(0);
    Assert.assertThat(topTorrent.getTitle().toUpperCase(), containsString(DEFAULT_SEARCH_PHRASE.toUpperCase()));
  }

  @Test
  public void testSearchByQuality() {
    List<Torrent> result = StrikeApi.search(DEFAULT_SEARCH_PHRASE, DEFAULT_VIDEO_QUALITY);
    Torrent topTorrent = result.get(0);
    Assert.assertThat(topTorrent.getTitle().toUpperCase(), containsString(DEFAULT_VIDEO_QUALITY.value.toUpperCase()));
  }

  @Test
  public void testSearchCategory() {
    List<Torrent> result = StrikeApi.searchCategory(DEFAULT_SEARCH_PHRASE, DEFAULT_CATEGORY);
    Torrent topTorrent = result.get(0);
    Assert.assertThat(topTorrent.getCategory().toUpperCase(), equalTo(DEFAULT_CATEGORY.name().toUpperCase()));
  }

  @Test
  public void testSearchCategoryAndQuality() {
    List<Torrent> result = StrikeApi.searchCategory(DEFAULT_SEARCH_PHRASE, DEFAULT_CATEGORY, DEFAULT_VIDEO_QUALITY);
    Torrent topTorrent = result.get(0);
    Assert.assertThat(topTorrent.getTitle().toUpperCase(), containsString(DEFAULT_VIDEO_QUALITY.value.toUpperCase()));
    Assert.assertThat(topTorrent.getCategory().toUpperCase(), equalTo(DEFAULT_CATEGORY.name().toUpperCase()));
  }

  @Test
  public void testTop() {
    List<Torrent> result = StrikeApi.top(DEFAULT_CATEGORY);
    Assert.assertThat(result.isEmpty(), is(false));
    Torrent topTorrent = result.get(0);
    Assert.assertThat(topTorrent.getCategory().toUpperCase(), equalTo(DEFAULT_CATEGORY.name().toUpperCase()));
    Assert.assertTrue(topTorrent.getSeeds() > 100);
  }

  @Test
  public void testFind() {
    List<Torrent> result = StrikeApi.search(DEFAULT_SEARCH_PHRASE);
    Assert.assertThat(result.isEmpty(), is(false));
    Torrent topTorrent = result.get(0);
    List<Torrent> findResult = StrikeApi.find(topTorrent.getHash());
    Assert.assertThat(findResult.isEmpty(), is(false));
    Torrent findTopTorrent = findResult.get(0);
    Assert.assertEquals(findTopTorrent.getHash(), topTorrent.getHash());
    Assert.assertEquals(findTopTorrent.getTitle(), topTorrent.getTitle());
  }

  @Test
  public void testRandomSearch() {
    List<Torrent> result = StrikeApi.search("jadhfgdhasgfyquwteqwxbxznccnxz42347213");
    Assert.assertThat(result.isEmpty(), is(true));
  }
}
