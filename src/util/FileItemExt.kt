package com.omarahmed.util

import io.ktor.http.content.*
import java.io.File
import java.util.*

fun PartData.FileItem.saveFile(path: String): String {
    val fileBytes = streamProvider().readBytes()
    val fileExtension = originalFileName?.takeLastWhile { it != '.' }
    val fileName = "${UUID.randomUUID()}.$fileExtension"
    val folder = File(path)
    folder.mkdir()
    File("$path$fileName").writeBytes(fileBytes)
    return fileName
}