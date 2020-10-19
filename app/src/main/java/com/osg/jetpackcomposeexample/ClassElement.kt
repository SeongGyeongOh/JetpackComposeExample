package com.osg.jetpackcomposeexample

data class ClassElement (
    val title: String? = null,
    val category: String? = null,
    val ownerID: String? = null,
    val price: Long? = null,
    val classInfo: String? = null,
    val status: String? = null,
    val isVisible: Boolean? = null,
    val isBest: Boolean? = null,
    val successPoint: Long? = null,
    val subTitle: String? = null,
    val totalRunningTime: Long? = null,
    val tags: List<String>? = null,
    val sections: List<Section>? = null,
    val created: String? = null,
    val updated: String? = null,
    val id: String? = null,
    val bannerImages: List<BannerImage>? = null,
    val bannerTitle: String? = null,
    val name: String? = null,
    val review: String? = null
)

data class BannerImage (
    val uid: String? = null,
    val lastModified: Long? = null,
    val lastModifiedDate: String? = null,
    val name: String? = null,
    val size: Long? = null,
    val type: String? = null,
    val percent: Long? = null,
    val originFileObj: OriginFileObj? = null,
    val thumbUrl: String? = null
)

data class OriginFileObj (
    val uid: String? = null
)

data class Section (
    val title: String? = null,
    val key: Long? = null,
    val status: String? = null,
    val filename: String? = null,
    val fileIDS: List<String>? = null,
    val video: Video? = null
)


data class Video (
    val url: String? = null,
    val verifyContent: String? = null
)
