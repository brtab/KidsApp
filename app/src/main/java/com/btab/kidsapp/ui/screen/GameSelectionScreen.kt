package com.btab.kidsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.btab.kidsapp.R
import com.btab.kidsapp.model.GameName
import com.btab.kidsapp.model.Mode
import com.btab.kidsapp.ui.theme.KidsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameSelectionScreen(
    gameSelected: String,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = gameSelected
                    )
                }
            )
        }) { innerPadding ->
        SelectMode(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SelectMode(modifier: Modifier) {
    val modesList = Mode.entries
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = modifier
            .padding(horizontal = 10.dp)
    ) {
        items(modesList.size) { index ->
            Card(
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .clickable {

                    }) {
                Image(
                    painter = painterResource(id = R.drawable.icono),
                    contentDescription = ""
                )
                Text(
                    text = modesList[index].description,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GameSelectionScreenPreview() {
    KidsAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "gameSelected"
                        )
                    }
                )
            }) { innerPadding ->
            SelectMode(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}