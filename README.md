# Strike API

This library provides a java-wrapper around the [JSON API](https://getstrike.net/api/) provided by [getstrike.net](https://getstrike.net/), 
which is a free website for finding torrents.

## Installation

Just add it as dependency to your project. It's available via [jCenter](https://bintray.com/bintray/jcenter)

### Maven

```
<dependency>
    <groupId>com.priitlaht</groupId>
    <artifactId>strikeapi</artifactId>
    <version>1.0</version>
</dependency>
```
Read the [Set me up](https://bintray.com/bintray/jcenter) section first, if you haven't added jCenter as a repository to your pom.xml yet.

### Gradle

```
repositories {
    jcenter()
}

dependencies{
    compile group: 'com.priitlaht', name: 'strikeapi', version:'1.0'
}
```

## Usage

### Find

```java
/**
 * Find top torrents by hash.
 *
 * @param hash  Torrent hash
 */
List<Torrent> torrents = StrikeApi.find(topTorrent.getHash());
```

### Search

```java
/**
 * Search torrents by title.
 *
 * @param searchPhrase
 */
List<Torrent> torrents = StrikeApi.search("marvel");

/**
 * Search torrents by title and category.
 *
 * @param searchPhrase
 * @param category  Torrent category enum
 */
List<Torrent> torrents = StrikeApi.searchCategory("marvel", Category.OTHER);

/**
 * Search torrents by title, category and quality.
 *
 * @param searchPhrase
 * @param category  Torrent category enum
 * @param quality   Torrent video quality enum
 */
List<Torrent> torrents = StrikeApi.searchCategory("marvel", Category.TV, VideoQuality.HD720P);
```

### Top torrents

```java
/**
 * Find top torrents in category.
 *
 * @param category  Torrent category enum
 */
List<Torrent> torrents = StrikeApi.top(Category.MOVIE);
```

## License

[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
