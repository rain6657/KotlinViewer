package io.github.rain6657.ktehviewer.models

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.net.URL

class GalleryInfo {
    companion object {
        private val IMAGE_URL_PATTERN: String = "<img[^>]*src=\"()[^\"]*\" style"
        private val URL_STRICT_PATTERN: Regex =
            "https?://(?:e-hentai\\.org)/(?:g|mpv)/(\\d+)/([0-9a-f]{10})".toRegex()
        private val URL_PATTERN: Regex = "(\\d+)/([0-9a-f]{10})(?:[^0-9a-f]|$)".toRegex()
        private val THUMB_SIZE_PATTERN: Regex = "\"height:(\\\\d+)px;width:(\\\\d+)px\"".toRegex()
        fun getGalleryInfo() {

        }

        fun galleryInfoPhaser(response: String): GalleryInfo {
            var gi = GalleryInfo()
            return gi
        }

        fun galleryInfoPhaser(response: Element): GalleryInfo? {
            var gi = GalleryInfo()
            try {
                val glname = response.getElementsByClass("glname").first() ?: return null
                val a = glname!!.getElementsByTag("a").first()

                var res = URL_PATTERN.find(a!!.attr("href"))?.groups
                if (res.isNullOrEmpty()) {
                    return null
                }
                gi.gid = res[1]!!.value
                gi.token = res[2]!!.value

                var child = glname
                while (child!!.childrenSize() != 0) {
                    child = child.children()[0]
                }
                gi.title = child.text().trim()

//                val tbody =glname.getElementsByTag("tbody")
                val glthumb = glname.getElementsByClass("glthumb")
                val img = glthumb.select("div:nth-child(1)>img").first();
                res = THUMB_SIZE_PATTERN.find(img!!.attr("style"))?.groups
                if (res.isNullOrEmpty()) {
                    gi.thumbWidth = 0
                    gi.thumbHeight = 0
                } else {
                    gi.thumbWidth = res[2]!!.value.toInt()
                    gi.thumbHeight = res[1]!!.value.toInt()
                }
                val imgurl = img.attr("data-src") ?: img.attr("src") ?: null


            } catch (_: Exception) {
            }

//            val Matches = URL_PATTERN.toRegex().matches()
            return gi
        }
    }

    public var category: String = ""
    public var favorite: Int = 0
    public var fileSize: Double = 0.0
    public var gid: String? = null
    public var language: String = ""
    public var parent: URL? = null
    public var pagesNum: Int = 0
    public var rating: Double = 0.0
    public var ratingNum: Int = 0
    public var tags: List<String>? = null
    public var title: String = ""
    public var titleJPN: String = ""
    public var token: String = ""
    public var uploader: String = ""
    public var visible: Boolean = false
    public var thumbWidth: Int? = null
    public var thumbHeight: Int? = null


}