package com.example.greedygameimagecachinglibrary.pojo

data class AllImageResponse(val kind: String, val data: ListImageData)
data class ListImageData(val dist:Int, val children:List<CompleteImageData>)
data class CompleteImageData(val kids:String, val data:SmallImageData)
data class SmallImageData(val thumbnail:String, val preview:ImagePreview)
data class ImagePreview(val images:List<Images>)
data class Images(val source:SingleImage, val resolutions:List<SingleImage>)
data class SingleImage(val url:String, val width:Int, val height:String)