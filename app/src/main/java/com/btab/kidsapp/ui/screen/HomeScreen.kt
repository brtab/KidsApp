package com.btab.kidsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.btab.kidsapp.R
import com.btab.kidsapp.model.GameName
import com.btab.kidsapp.ui.navigation.Destination
import com.btab.kidsapp.ui.theme.KidsAppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    navGameSelectionScreen: (gameSelected: String) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        GenerateList(
            modifier = Modifier.padding(innerPadding),
            navGameSelectionScreen = navGameSelectionScreen
        )
    }
}

@Composable
fun GenerateList(modifier: Modifier, navGameSelectionScreen: (gameSelected: String) -> Unit) {

    val currentList = GameName.entries

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = modifier
            .padding(all = 10.dp)
            .wrapContentSize()
    ) {
        items(currentList.size) { index ->
            Card(
                modifier = modifier
                    .padding(all = 10.dp)
                    .clickable {
                        navGameSelectionScreen(currentList[index].description)
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.icono),
                    contentDescription = ""
                )
                Text(
                    text = currentList[index].description,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    KidsAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            GenerateList(
                modifier = Modifier.padding(innerPadding),
                navGameSelectionScreen = { }
            )
        }
    }
}