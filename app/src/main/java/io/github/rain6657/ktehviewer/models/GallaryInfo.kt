package io.github.rain6657.ktehviewer.models

import io.github.rain6657.ktehviewer.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GallaryInfo {
    companion object {
        public const val IMAGE_URL_PATTERN: String = "<img[^>]*src=\"()[^\"]*\" style"
    }

    public val category: String = ""
    public val favorite: Int = 0
    public val fileSize: Double = 0.0
    public val gid: UInt? = null
    public val language: String = ""
    public val parent: URL? = null
    public val pagesNum: Int = 0
    public val rating: Double = 0.0
    public val ratingNum: Int = 0
    public val tags: List<String> = listOf()
    public val title: String = ""
    public val titleJPN: String = ""
    public val token: String = ""
    public val uploader: String = ""
    public val visible: Boolean = false

    constructor(url: URL) {

    }

//    fun GallaryInfoPhase(url: URL?): String {
//        val userAgent: String =
//            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36"
//
//
//        val defaultUrl: URL = if (url == null) {
//            URL("https://e-hentai.org/g/1402939/29abffcb09/")
//        } else {
//            url
//        }
//
//        val connection = defaultUrl.openConnection() as HttpURLConnection
//        connection.requestMethod = "GET"
//        connection.readTimeout = 8000
//        connection.connectTimeout = 8000
//        val out = BufferedReader(InputStreamReader(connection.inputStream))
//        val res = StringBuilder()
//
//        out.use {
//            out.forEachLine {
//                res.append(it)
//            }
//        }
//        connection.disconnect()
//
//        return res.toString()
//    }

}