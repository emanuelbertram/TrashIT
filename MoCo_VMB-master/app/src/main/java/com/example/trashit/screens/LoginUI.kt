package com.example.trashit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trashit.R
import com.example.trashit.ui.theme.*

@Composable
fun LoginUI(){

    var username by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var checkBoxOneState by remember{ mutableStateOf(true) }
    var checkBoxTwoState by remember{ mutableStateOf(true) }
    var isPasswordOpen by remember{ mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.trash_it_logo),
            contentDescription = "",
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = "Login your Account",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        )



        TextField(value = email, onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            leadingIcon = {
                Row (
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_mail), contentDescription = "Email",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(PrimaryColor)
                    )
                }
            },
            placeholder = {
                Text(text = "Email adress",
                    color = PlaceholderColor
                )
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        TextField(value = password, onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            leadingIcon = {
                Row (
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.ic_lock), contentDescription = "User",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(PrimaryColor)
                    )
                }
            },
            placeholder = {
                Text(text = "Password",
                    color = PlaceholderColor
                )
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            ),
            visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                    if(!isPasswordOpen){
                        Icon(painter = painterResource(id = R.drawable.ic_eye_open), contentDescription = "See",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }else{
                        Icon(painter = painterResource(id = R.drawable.ic_eye_close), contentDescription = "Dont",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)

                        )
                    }
                }
            }
        )
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = PrimaryColor,
                contentColor = Color.White,
            ),
            contentPadding = PaddingValues(vertical = 14.dp)
        ) {

            Text(text = "Login", fontFamily = FontFamily.Default)
        }


                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_google),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(26.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "Continue with Google", color = PrimaryColor, fontSize = 16.sp)
                        }
                    }

                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(vertical = 0.dp)
                    ) {
                        Text(
                            text = "Forgot Password ?",
                            color = Color.White,
                           // fontFamily = Poppins,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 26.dp)
                        )
                    }
                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(vertical = 0.dp)
                    ) {
                        Text(
                            text = "Don't have an Account ? Sign Up",
                            color = Color.White,
                            //fontFamily = Poppins,
                            fontSize = 12.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
