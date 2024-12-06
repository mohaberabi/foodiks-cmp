package com.mohaberabi.kmp.foodiks.core.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import coil3.compose.AsyncImage

import coil3.request.ImageRequest
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.pl
import org.jetbrains.compose.resources.painterResource


@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String? = null,
    requestBuilder: (ImageRequest.Builder.() -> ImageRequest.Builder)? = null,
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = modifier,
            painter = painterResource(Res.drawable.pl),
            contentDescription = contentDescription
        )
    } else {

        AsyncImage(

            modifier = modifier,
            error = painterResource(Res.drawable.pl),
            placeholder = painterResource(Res.drawable.pl),
            model = url,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
        )
    }

}