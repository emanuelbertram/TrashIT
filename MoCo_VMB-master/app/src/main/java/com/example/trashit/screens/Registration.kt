package com.example.trashit.screens

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trashit.R
import com.example.trashit.ui.theme.PlaceholderColor
import com.example.trashit.ui.theme.PrimaryColor
import com.example.trashit.ui.theme.Shapes
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import java.security.AllPermission


@Composable
fun RegistrationScreen(){

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
            text = "Create your account",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        )


        TextField(value = username, onValueChange = { username = it },
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
                    Icon(painter = painterResource(id = R.drawable.ic_user), contentDescription = "User",
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
                Text(text = "Username",
                color = PlaceholderColor
                )
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
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

        Row (
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
                ){
            Checkbox(
                checked = checkBoxOneState, onCheckedChange = {checkBoxOneState = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color.White,
                    checkmarkColor = PrimaryColor
                ),
                modifier = Modifier.clip(shape = Shapes.medium)
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "Log In with Email",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        /*Row (
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked = checkBoxTwoState, onCheckedChange = {checkBoxTwoState = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color.White,
                    checkmarkColor = PrimaryColor
                ),
                modifier = Modifier.clip(shape = Shapes.medium)
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "Email me about special pricing",
                color = Color.White,
                fontSize = 12.sp
            )
        }*/

        Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            contentPadding = PaddingValues(vertical = 14.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            )
        ) {
            Text(
                text = "Sign Up with Email",
                color = PrimaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        //GoogleButtonPreview()

        TextButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Already have an account? Sign In",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )

        }
    }
}

fun getGoogleSignInClient(context: Context): GoogleSignInClient {
    val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()

    return GoogleSignIn.getClient(context,signInOptions)

}

@ExperimentalMaterialApi
@Composable
fun GoogleSignInButtonUi(
    text : String = "",
    loadingText: String = "" ,
    onClicked:() -> Unit){

    var clicked by remember { mutableStateOf(false)}
    Surface(
        onClick = {clicked = !clicked},
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp,color = Color.LightGray),
        color = MaterialTheme.colors.surface
    ) {
        Row (modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
            .animateContentSize(
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ),verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center){
            Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google sign button", tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)

            if (clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier.height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
                onClicked()
            }

        }
    }



}

@ExperimentalMaterialApi
@Composable
@Preview
fun GoogleButtonPreview(){
    GoogleSignInButtonUi(
        text = "Sign Up With Google",
        loadingText = "Signing In....",
        onClicked = {}
    )
}
