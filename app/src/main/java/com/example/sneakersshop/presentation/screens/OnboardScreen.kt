package com.example.sneakersshop.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.R

@Composable
fun OnboardScreen() {
    val imageList = listOf(
        R.drawable.onboard_sneaker1,
        R.drawable.onboard_sneaker2,
        R.drawable.onboard_sneaker3,
    )
    val mainTextList = listOf(
        R.string.abob,
        R.string.onboard_main_text1,
        R.string.onboard_main_text2,
    )
    val minorTextList = listOf(
        R.string.abob,
        R.string.onboard_minor_text1,
        R.string.onboard_minor_text2,
    )
    var visibility by remember { mutableStateOf(false) }
    var counterStep by remember { mutableStateOf(0) }
    val btnText = if (visibility) "Далее" else "Начать"
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF48B2E7), Color(0xFF44A9DC), Color(0xFF2B6B8B))
                )
            ),
        color = Color.Transparent
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {

            Spacer(Modifier.size(29.dp))

            Text(
                text = stringResource(R.string.onboard_text),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.width(267.dp)
            )

            Spacer(Modifier.size(130.dp))
            Image(
                painter = painterResource(imageList[counterStep]),
                contentDescription = "",
                modifier = Modifier.width(375.dp).height(302.dp)
            )
            Text(text = stringResource(mainTextList[counterStep]))

            Spacer(Modifier.size(12.dp))

            Text(text = stringResource(minorTextList[counterStep]))

            Spacer(Modifier.size(135.dp))
            Button(
                onClick = {
                    if (counterStep < 3) counterStep++
                    visibility = true

                },
                colors = ButtonColors(
                    containerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black
                ),
                shape = RoundedCornerShape(13.dp),
                modifier = Modifier.width(335.dp).height(50.dp)
            ) {
                Text(text = btnText)
            }

        }
    }
}

@Preview
@Composable
fun PreviewOnboardScreen() {
    OnboardScreen()
}