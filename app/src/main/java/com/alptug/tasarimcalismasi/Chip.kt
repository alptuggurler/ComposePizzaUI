package com.alptug.tasarimcalismasi

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.alptug.tasarimcalismasi.ui.theme.Anarenk
import com.alptug.tasarimcalismasi.ui.theme.AnarenkDark
import com.alptug.tasarimcalismasi.ui.theme.YaziRenk1

@Composable
fun Chip(text: String,darkTheme: Boolean = isSystemInDarkTheme()) {
    Button(
        onClick = { }, colors = ButtonDefaults.buttonColors(
            containerColor = if(darkTheme) AnarenkDark else Anarenk,
            contentColor = YaziRenk1,
        )
    ) {
        Text(text)
    }
}