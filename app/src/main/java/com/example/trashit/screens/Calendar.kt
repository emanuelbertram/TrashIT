package com.example.trashit.screens

import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.TimeUnit
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.work.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MINUTES
import kotlin.time.DurationUnit


@Composable
fun CalendarScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Calendar",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

    }

}

@Composable
fun Calendar() {

/*
    // Projection array. Creating indices for this array instead of doing
    // dynamic lookups improves performance.
    val EVENT_PROJECTION: Array<String> = arrayOf(
        CalendarContract.Calendars._ID,                     // 0
        CalendarContract.Calendars.ACCOUNT_NAME,            // 1
        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,   // 2
        CalendarContract.Calendars.OWNER_ACCOUNT            // 3
    )

    // The indices for the projection array above.
    val PROJECTION_ID_INDEX: Int = 0
    val PROJECTION_ACCOUNT_NAME_INDEX: Int = 1
    val PROJECTION_DISPLAY_NAME_INDEX: Int = 2
    val PROJECTION_OWNER_ACCOUNT_INDEX: Int = 3

    // Run query
    val uri: Uri = CalendarContract.Calendars.CONTENT_URI
    val selection: String = "((${CalendarContract.Calendars.ACCOUNT_NAME} = ?) AND (" +
            "${CalendarContract.Calendars.ACCOUNT_TYPE} = ?) AND (" +
            "${CalendarContract.Calendars.OWNER_ACCOUNT} = ?))"
    val selectionArgs: Array<String> = arrayOf("hera@example.com", "com.example", "hera@example.com")
    //val cur: Cursor = contentResolver.query(uri, EVENT_PROJECTION, selection, selectionArgs, null)
*/

/*
    val cal: GregorianCalendar = GregorianCalendar()
    cal.time = Date()
    cal.add(Calendar.MONTH, 2)
    val time = cal.time.time
    val builder = CalendarContract.CONTENT_URI.buildUpon()
    builder.appendPath("time")
    builder.appendPath(java.lang.Long.toString(time))
    val intent = Intent(Intent.ACTION_VIEW, builder.build())
    startActivity(intent)

    val intent2 = Intent(Intent.ACTION_INSERT, Events.CONTENT_URI)
    startActivity(intent2)

 */
}

fun startActivity(intent: Intent) {

    /*
    WorkManager
        .getInstance(myContext)
        .enqueue(uploadWorkRequest)
*/
}






@Composable
@Preview
fun CalendarScreenPreview() {
    CalendarScreen()
}



