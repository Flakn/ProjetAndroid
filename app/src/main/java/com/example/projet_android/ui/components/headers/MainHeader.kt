package com.example.projet_android.ui.components.headers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.projet_android.ui.components.titles.ActivityTitle

@Composable
fun MainHeader(scaffoldPadding: PaddingValues, modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActivityTitle("D&D Manager")
    }
}
