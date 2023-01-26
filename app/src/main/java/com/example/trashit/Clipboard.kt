package com.example.trashit

import android.annotation.SuppressLint
import android.content.*
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.style.TextAppearanceSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import org.w3c.dom.Text


class Clip : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    // on the below line we are
                    // specifying the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are specifying the top bar.
                        topBar = {

                            // inside top bar we are
                            // specifying background color.
                            TopAppBar(backgroundColor = Color.Gray,

                                // along with that we are
                                // specifying title for our top bar.
                                title = {

                                    // in the top bar we are
                                    // specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are calling method to display UI
                        clipboardManager(context = LocalContext.current)
                    }
                }

        }
    }
}

// on below line creating a method to display UI.
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun clipboardManager(context: Context) {

    // on below line creating
    // a variable for message.
    val message = remember {
        mutableStateOf("")
    }

    // on below line we are creating a column,
    Column(
        // on below line we
        // are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "Clip Board Manager in Android",
            // on below line we are specifying text color,
            // font size and font weight
            color = Color.Green ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // on below line we are creating a
        // text field for our message number.
        TextField(
            // on below line we are specifying
            // value for our message text field.
            value = message.value,
            // on below line we are adding on
            // value change for text field.
            onValueChange = { message.value = it },
            // on below line we are adding place holder
            // as text as "Enter your email"
            placeholder = { Text(text = "Enter your message") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                // Initializing the ClipboardManager and Clip data
                val clipboardManager =
                    context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                // clip data is initialized with the text variable declared above
                var clipData: ClipData = ClipData.newPlainText("text", message.value)

                // Clipboard saves this clip object
                clipboardManager.setPrimaryClip(clipData)

                // A toast is shown for user reference that
                // the text is copied to the clipboard
                Toast.makeText(context, "Copied to Clipboard", Toast.LENGTH_SHORT).show()

            },
            // on below line adding a
            // modifier for our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            // on below line adding a text for our button.
            Text(text = "Copy text to clipboard")
        }
    }
}
