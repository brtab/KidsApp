package com.btab.kidsapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.btab.kidsapp.model.GameName
import com.btab.kidsapp.ui.theme.KidsAppTheme

@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        GenerateList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun GenerateList(currentList: List<GameName> = GameName.entries, modifier: Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(currentList.size) { index ->
            Card(modifier = Modifier
                .padding(all = 2.dp)
                .clickable {

                }) {
                Text(
                    text = currentList[index].name,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KidsAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            GenerateList(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}