package io.github.rain6657.ktehviewer.models


import io.github.rain6657.ktehviewer.models.GalleryInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


class GalleryList {
    companion object {
        private val PATTERN_PREV_URL: Regex = ".*\\?prev=(\\d+)".toRegex()
        private val PATTERN_NEXT_URL: Regex = ".*\\?next=(\\d+)".toRegex()

        fun parse(body: String): GalleryList {
            val dom: Document = Jsoup.parse(body)
            var gl = GalleryList()

//            try {
//                val sn = dom.getElementsByClass("searchnav").first()
//                val prevurl = sn?.getElementById("uprev")?.attr("href")
//                if (prevurl != null) {
//                    gl.prevUrl = PATTERN_PREV_URL.matchEntire(prevurl)?.groups?.get(1)?.value?.toULong() ?: 0u
//                }
//                val nexturl = sn?.getElementById("unext")?.attr("href")
//                if (nexturl != null) {
//                    gl.nextUrl = PATTERN_NEXT_URL.matchEntire(nexturl)?.groups?.get(1)?.value?.toULong() ?: 0u
//                }
//            } catch (_: Exception) {
//            }

            try {
                val itg = dom.getElementsByClass("itg").first()
                val es: Elements = if ("table".equals(itg!!.tagName(), true)) {
                    itg.child(0).children()
                } else {
                    itg.children()
                }
                for (i in es) {
                    val gi = GalleryInfo.galleryInfoPhaser(i)
                    if (gi != null) {
                        gl.list.add(gi)
                    }
                }
            } catch (_: Exception) {
            }
            return gl
        }
    }

    var list: MutableList<GalleryInfo> = mutableListOf<GalleryInfo>()
    var nextUrl: ULong = 0u
    var prevUrl: ULong = 0u
    var maxDate: String? = null
    var minDate: String? = null


}