package com.example.cleancryptoapp.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.example.cleancryptoapp.presentation.coin_detail.components.CoinTagItem
import com.example.cleancryptoapp.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        state.coin?.let{ coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)){
                item{
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if(coin.isActive) "active" else "inactive",
                            color = if(coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = coin.description, style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Tags", style = MaterialTheme.typography.h3)
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTagItem(tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Team Members", style = MaterialTheme.typography.h3)
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coin.team){ member ->
                    TeamListItem(teamMember = member)
                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()) {
            Snackbar {
                Text(state.error)
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}