import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class, ExperimentalFoundationApi::class
)

@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            content = { innerPadding ->
                LazyColumn(
                    // consume insets as scaffold doesn't do it by default
                    modifier = Modifier
                        .consumeWindowInsets(innerPadding)
                        .padding(16.dp),
                    contentPadding = innerPadding
                ) {
                    item {
                        Box (modifier = Modifier
                            .fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row (verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .padding(end = 5.dp)
                                            .size(20.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF489AAB.toInt())) // #8F8F8F
                                    )

                                    Text(
                                        text = "Presta Capital",
                                        color = Color.Black,
                                        fontSize = 20.sp
                                    )
                                }

                                IconButton(
                                    onClick = {

                                    },
                                    content = {
                                        Image(
                                            modifier = Modifier.size(30.dp),
                                            imageVector = Icons.Filled.AccountCircle,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                    item {
                        Box (modifier = Modifier
                            .padding(top = 10.dp, start = 5.dp)
                            .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Hello Morgan",
                                    color = Color.Black,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                    item {
                        val state = rememberLazyListState()
                        LazyRow (modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                            state = state,
                            flingBehavior = rememberSnapFlingBehavior(lazyListState = state),
                            content = {
                                items(3) {
                                    Box (modifier = Modifier
                                        .padding(PaddingValues(start = 1.dp,end = 16.dp))
                                        .fillParentMaxWidth(0.95f)
                                    ) {
                                        CardListItem(
                                            name = "$it",
                                            onClick = {

                                            }
                                        )
                                    }
                                }
                            }
                        )
                    }
                    item {
                        Box (modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                        ) {
                            LazyRow (
                                modifier = Modifier
                                    .align(Alignment.Center)
                            ) {
                                items(3) {
                                    when (it) {
                                        0 -> {
                                            Box(
                                                modifier = Modifier
                                                    .padding(5.dp)
                                                    .width(20.dp)
                                                    .height(10.dp)
                                                    .clip(RoundedCornerShape(10.dp))
                                                    .background(Color(0xFF489AAB.toInt()))
                                            )
                                        }
                                        1 -> {
                                            Box(
                                                modifier = Modifier
                                                    .padding(5.dp)
                                                    .size(10.dp)
                                                    .clip(CircleShape)
                                                    .background(Color(0xFFE5E5E5.toInt()))
                                            )
                                        }
                                        2 -> {
                                            Box(
                                                modifier = Modifier
                                                    .padding(5.dp)
                                                    .size(10.dp)
                                                    .clip(CircleShape)
                                                    .background(Color(0xFFE5E5E5.toInt()))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun CardListItem(name: String, onClick: (String) -> Unit) {
    ElevatedCard {
        Box (modifier = Modifier.background(Color(0xFFFFFFFF.toInt()))) {
            Column (
                modifier = Modifier.padding(
                    top = 23.dp,
                    start = 24.dp,
                    end = 19.5.dp,
                    bottom = 33.dp,
                )
            ) {
                Row (modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Total Savings",
                        color= Color(0xFF8F8F8F.toInt()), // #002C56
                        fontSize = 16.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color(0xFFE5F1F5.toInt()))
                            .size(30.dp),
                        onClick = {
                            onClick(name)
                        },
                        content = {
                            Image(
                                modifier = Modifier.size(25.dp),
                                imageVector = Icons.Filled.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    )
                }
                Row (modifier = Modifier
                    .padding(top = 0.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Kes 100,983.32",
                        color= Color(0xFF002C56.toInt()),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Black
                    )
                }
                Row (modifier = Modifier
                    .padding(top = 11.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Last Savings",
                        color= Color(0xFF8F8F8F.toInt()), // #002C56
                        fontSize = 16.sp
                    )
                }
                Row (modifier = Modifier
                    .padding(top = 1.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Kes 5,000 - 5 days ago",
                        color= Color(0xFF002C56.toInt()), // #002C56
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
expect fun getPlatform(): String