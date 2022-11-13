package io.github.rain6657.ktehviewer.utils.network

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


object EhApiService {
    private const val UserAgent: String =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36"

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://e-hentai.org")
        .build()

    interface EhApiService {
        @GET("/")
        suspend fun getHome(): String

        @GET("/s")
        suspend fun getImage(): String

        @GET("/g/{gid}/{token}/")
        suspend fun getGalleryDetailUrl(
            @Path("gid") gid: Number,
            @Path("token") token: String
        ): String

        @GET("/g/{ptoken}/{gid}-{index}")
        suspend fun getPageUrl(
            @Path("gid") gid: Number,
            @Path("ptoken") ptoken: String,
            @Path("index") index: Number
        ): String
    }

    object EhApi {
        val retrofitService: EhApiService by lazy { retrofit.create(EhApiService::class.java) }
    }
}