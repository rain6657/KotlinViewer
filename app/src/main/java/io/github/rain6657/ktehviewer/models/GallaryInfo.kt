package io.github.rain6657.ktehviewer.models

import io.github.rain6657.ktehviewer.R
import java.net.URL

class GallaryInfo {
    companion object {
        public const val IMAGE_URL_PATTERN: String = "<img[^>]*src=\"()[^\"]*\" style"

        fun getGallaryInfo() {

        }

        fun GallaryInfoPhaser(response: String) {


        }
    }

    public val category: String = ""
    public val favorite: Int = 0
    public val fileSize: Double = 0.0
    public val gid: ULong? = null
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


}