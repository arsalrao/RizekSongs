package com.raoarsalan.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

sealed class SpotifyDto {

    data class Search(
        @SerializedName("artists") val artists: SpotifyArtist,
        @SerializedName("tracks") val tracks: SpotifyTracks,
        @SerializedName("error") val error: SearchError? = null

    ) : SpotifyDto()

    data class SearchError(
        @SerializedName("status") val status: Int,
        @SerializedName("message") val msg: String
    ) : SpotifyDto()

    data class SpotifyArtist(
        @SerializedName("href") val href: String?,
        @SerializedName("items") val items: List<ArtistList>?,
        @SerializedName("limit") val limit: Int?,
        @SerializedName("next") val next: String?,
        @SerializedName("offset") val offset: Int?,
        @SerializedName("previous") val previous: String?,
        @SerializedName("total") val total: Int?,

        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("external_urls") val externalUrl: ExternalUrl?

    ) : SpotifyDto()

    data class ArtistList(
        @SerializedName("external_urls") val externalUrl: ExternalUrl?,
        @SerializedName("followers") val followers: Followers?,
        @SerializedName("genres") val genres: List<String>?,
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?
    ) : SpotifyDto()

    data class ExternalUrl(
        @SerializedName("spotify") val spotifyLink: String?
    ) : SpotifyDto()

    data class Followers(
        @SerializedName("href") val href: String?,
        @SerializedName("total") val total: Int?
    ) : SpotifyDto()


    data class SpotifyTracks(
        @SerializedName("href") val href: String?,
        @SerializedName("items") val items: List<TracksList>?,
        @SerializedName("limit") val limit: Int?,
        @SerializedName("next") val next: String?,
        @SerializedName("offset") val offset: Int?,
        @SerializedName("previous") val previous: String?,
        @SerializedName("total") val total: Int?
    ) : SpotifyDto()

    data class TracksList(
        @SerializedName("album") val album: Album?,
        @SerializedName("artists") val artistResponseList: List<SpotifyArtist>?,
        @SerializedName("available_markets") val availableMarketList: List<String>?,
        @SerializedName("disc_number") val discNumber: Int?,
        @SerializedName("duration_ms") val durationMs: Int?,
        @SerializedName("explicit") val explicit: Boolean?,
        @SerializedName("external_urls") val externalUrl: ExternalUrl?,
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("is_local") val isLocal: Boolean?,
        @SerializedName("name") val name: String?,
        @SerializedName("popularity") val popularity: Int?,
        @SerializedName("preview_url") val previewUrl: String?,
        @SerializedName("track_number") val trackNumber: Int?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?
    ) : SpotifyDto()

    data class Album(
        @SerializedName("album_type") val albumType: String?,
        @SerializedName("artists") val artistResponseList: List<SpotifyArtist>?,
        @SerializedName("available_markets") val availableMarketList: List<String>?,
        @SerializedName("external_urls") val externalUrl: ExternalUrl?,
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("images") val imagesList: List<AlbumPoster>?,
        @SerializedName("name") val name: String?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("release_date_precision") val releaseDayPrecision: String?,
        @SerializedName("total_tracks") val totalTracks: Int?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?
    ) : SpotifyDto()

    data class AlbumPoster(
        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("url") val url: String
    ) : SpotifyDto()
}
