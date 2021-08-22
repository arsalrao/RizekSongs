package com.raoarsalan.data.mapper.dtotoentitiy


import com.raoarsalan.data.datasource.remote.dto.SpotifyDto
import com.raoarsalan.domain.entity.response.SpotifyEntity
import java.util.*


fun SpotifyDto.ExternalUrl.map() = SpotifyEntity.ExternalUrl(
    spotifyLink = spotifyLink
)

fun SpotifyDto.Followers.map() = SpotifyEntity.Followers(
    href = href,
    total = total
)

fun List<SpotifyDto.ArtistList>.mapList(): List<SpotifyEntity.ArtistList> {

    val list = ArrayList<SpotifyEntity.ArtistList>()

    this.forEach { it ->
        val genres = ArrayList<String>()
        it.genres?.forEach {
            genres.add(it)
        }
        list.add(
            SpotifyEntity.ArtistList(
                externalUrl = it.externalUrl?.map(),
                followers = it.followers?.map(),
                genres = genres,
                href = it.href,
                id = it.id
            )
        )

    }

    return list
}

fun List<SpotifyDto.SpotifyArtist>.mapArtist(): List<SpotifyEntity.SpotifyArtist> {
    val list = ArrayList<SpotifyEntity.SpotifyArtist>()

    this.forEach { it ->
        list.add(
            SpotifyEntity.SpotifyArtist(
                href = it.href,
                items = it.items?.mapList(),
                limit = it.limit,
                next = it.next,
                offset = it.offset,
                previous = it.previous,
                total = it.total,
                id = it.id,
                name = it.name,
                type = it.type,
                uri = it.uri,
                externalUrl = it.externalUrl?.map()
            )
        )
    }

    return list
}

fun List<SpotifyDto.AlbumPoster>.map(): List<SpotifyEntity.AlbumPoster> {

    val list = ArrayList<SpotifyEntity.AlbumPoster>()

    this.forEach { it ->
        list.add(
            SpotifyEntity.AlbumPoster(
                height = it.height,
                width = it.width,
                url = it.url
            )
        )
    }

    return list

}


fun SpotifyDto.Album.map() = SpotifyEntity.Album(
    albumType = albumType,
    artist = artistResponseList?.mapArtist(),
    availableMarket = availableMarketList,
    externalUrl = externalUrl?.map(),
    href = href,
    id = id,
    images = imagesList?.map(),
    name = name,
    releaseDate = releaseDate,
    releaseDayPrecision = releaseDayPrecision,
    totalTracks = totalTracks,
    type = type,
    uri = uri
)

fun List<SpotifyDto.TracksList>.mapToTrackList(): List<SpotifyEntity.TracksList> {

    val list = ArrayList<SpotifyEntity.TracksList>()
    this.forEach { it ->
        list.add(
            SpotifyEntity.TracksList(
                externalUrl = it.externalUrl?.map(),
                href = it.href,
                id = it.id,
                album = it.album?.map(),
                artist = it.artistResponseList?.mapArtist(),
                availableMarket = it.availableMarketList,
                discNumber = it.discNumber,
                durationMs = it.durationMs,
                explicit = it.explicit,
                isLocal = it.isLocal,
                name = it.name,
                popularity = it.popularity,
                previewUrl = it.previewUrl,
                trackNumber = it.trackNumber,
                type = it.type,
                uri = it.uri
            )
        )
    }
    return list
}

fun SpotifyDto.SpotifyTracks.map() = SpotifyEntity.SpotifyTracks(
    href = href,
    items = items?.mapToTrackList(),
    limit = limit,
    next = next,
    offset = offset,
    previous = previous,
    total = total
)

fun SpotifyDto.SpotifyArtist.map() = SpotifyEntity.SpotifyArtist(
    href = href,
    items = items?.mapList(),
    limit = limit,
    next = next,
    offset = offset,
    previous = previous,
    total = total,
    id = id,
    name = name,
    type = type,
    uri = uri,
    externalUrl = externalUrl?.map()
)

fun SpotifyDto.Search.map() = SpotifyEntity.Search(

    artists = artists.map(),
    tracks = tracks.map(),
    error = error?.map()
)

fun SpotifyDto.SearchError?.map() = SpotifyEntity.SpotifyError(
    status = this!!.status,
    msg = msg
)