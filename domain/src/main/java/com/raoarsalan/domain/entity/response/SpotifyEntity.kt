package com.raoarsalan.domain.entity.response

sealed class SpotifyEntity {


    data class Search(
        val artists: SpotifyArtist,
        val tracks: SpotifyTracks,
        val error: SpotifyError?
    ) : SpotifyEntity()

    data class SpotifyError(
        val status: Int,
        val msg: String
    )

    data class SpotifyArtist(
        val href: String?,
        val items: List<ArtistList>?,
        val limit: Int?,
        val next: String?,
        val offset: Int?,
        val previous: String?,
        val total: Int?,

        val id: String?,
        val name: String?,
        val type: String?,
        val uri: String?,
        val externalUrl: ExternalUrl?

    ) : SpotifyEntity()

    data class ArtistList(
        val externalUrl: ExternalUrl?,
        val followers: Followers?,
        val genres: List<String>?,
        val href: String?,
        val id: String?
    ) : SpotifyEntity()

    data class ExternalUrl(
        val spotifyLink: String?
    ) : SpotifyEntity()

    data class Followers(
        val href: String?,
        val total: Int?
    ) : SpotifyEntity()


    data class SpotifyTracks(
        val href: String?,
        val items: List<TracksList>?,
        val limit: Int?,
        val next: String?,
        val offset: Int?,
        val previous: String?,
        val total: Int?
    ) : SpotifyEntity()

    data class TracksList(
        val album: Album?,
        val artist: List<SpotifyArtist>?,
        val availableMarket: List<String>?,
        val discNumber: Int?,
        val durationMs: Int?,
        val explicit: Boolean?,
        val externalUrl: ExternalUrl?,
        val href: String?,
        val id: String?,
        val isLocal: Boolean?,
        val name: String?,
        val popularity: Int?,
        val previewUrl: String?,
        val trackNumber: Int?,
        val type: String?,
        val uri: String?
    ) : SpotifyEntity()

    data class Album(
        val albumType: String?,
        val artist: List<SpotifyArtist>?,
        val availableMarket: List<String>?,
        val externalUrl: ExternalUrl?,
        val href: String?,
        val id: String?,
        val images: List<AlbumPoster>?,
        val name: String?,
        val releaseDate: String?,
        val releaseDayPrecision: String?,
        val totalTracks: Int?,
        val type: String?,
        val uri: String?
    ) : SpotifyEntity()

    data class AlbumPoster(
        val height: Int,
        val width: Int,
        val url: String
    ) : SpotifyEntity()
}
