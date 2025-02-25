package com.example.sneakersshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.R
import com.example.sneakersshop.domain.AuthController

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val authController = AuthController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier.padding(20.dp)
        ) {

            Spacer(Modifier.size(90.dp))

            Text(
                text = stringResource(R.string.login_main_text1),
                fontSize = 32.sp,
            )

            Spacer(Modifier.size(8.dp))

            Text(
                text = stringResource(R.string.login_minor_text1),
                modifier = Modifier.width(315.dp),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.size(35.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Email")

                Spacer(Modifier.size(12.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(15.dp),
                            color = colorResource(R.color.background)
                        ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    )
                )

                Spacer(Modifier.size(26.dp))

                Text(text = "Пароль")

                Spacer(Modifier.size(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    trailingIcon = { Icon(
                        if (passwordVisibility) {
                            painterResource(R.drawable.eye_open)
                        } else {
                            painterResource(R.drawable.eye_close)
                        },
                        contentDescription = "",
                        tint = colorResource(R.color.hint_color),
                        modifier = Modifier.clickable { passwordVisibility = !passwordVisibility }
                    ) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(15.dp),
                            color = colorResource(R.color.background)
                        ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    )
                )

                Spacer(Modifier.size(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Восстановить",
                        fontSize = 12.sp,
                        color = colorResource(R.color.sub_text_dark)
                    )
                }
            }

            Spacer(Modifier.size(24.dp))

            Button(
                onClick = {
                    if(authController.signIn(email, password)) {
                        Log.d("SignInScreen:", "true")
                    } else {
                        Log.d("SignInScreen:", "false")
                    }
                },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp),
            ) {
                Text(text = "Войти")
            }

            Spacer(Modifier.size(209.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Вы впервые?",
                    color = colorResource(R.color.hint_color)
                )
                Text(
                    text = "Создать пользователя")
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}