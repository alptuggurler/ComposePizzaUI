package com.alptug.tasarimcalismasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alptug.tasarimcalismasi.ui.theme.Anarenk
import com.alptug.tasarimcalismasi.ui.theme.AnarenkDark
import com.alptug.tasarimcalismasi.ui.theme.TasarimCalismasiTheme
import com.alptug.tasarimcalismasi.ui.theme.YaziRenk1
import com.alptug.tasarimcalismasi.ui.theme.YaziRenk2
import com.alptug.tasarimcalismasi.ui.theme.YaziRenk2Dark
import com.alptug.tasarimcalismasi.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasarimCalismasiTheme {
                Anasayfa()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp
    val ekranGenisligi  = configuration.screenWidthDp
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pizza", fontFamily = pacifico) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if(darkTheme) AnarenkDark else Anarenk,
                    titleContentColor = YaziRenk1
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.pizzaBaslik), color = if(darkTheme) AnarenkDark else Anarenk,
                fontWeight = FontWeight.Bold, fontSize = (ekranGenisligi/10).sp
            )
            Image(painter = painterResource(id = R.drawable.yemek_resim3), contentDescription = "")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(stringResource(R.string.peynirYazi))
                Chip(stringResource(R.string.sucukYazi))
                Chip(stringResource(R.string.zeytinYazi))
                Chip(stringResource(R.string.biberYazi))
            }

            Text(
                stringResource(R.string.teslimatSure), color = if(darkTheme) YaziRenk2Dark else YaziRenk2,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )

            Text(
                stringResource(R.string.teslimatBaslik), color = if(darkTheme) AnarenkDark else Anarenk,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )

            Text(
                stringResource(R.string.pizzaAciklama),
                color =if(darkTheme) YaziRenk2Dark else YaziRenk2, fontSize = 22.sp, textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (ekranGenisligi/20).dp, end = (ekranGenisligi/20).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Text(
                    stringResource(R.string.fiyatYazi), color =if(darkTheme) AnarenkDark else Anarenk,
                    fontWeight = FontWeight.Bold, fontSize = 44.sp
                )

                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor =if(darkTheme) AnarenkDark else Anarenk,
                        contentColor = YaziRenk1,
                    )
                ) {
                    Text(stringResource(R.string.buttonYazi), fontSize = 18.sp)
                }

            }

        }
    }
}

@Preview(showBackground = true, locale = "tr",)
@Composable
fun GreetingPreview() {
    TasarimCalismasiTheme {
        Anasayfa()
    }
}