package com.phorn.khmerdubai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material.icons.filled.ClosedCaption
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            KhmerDubAI()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KhmerDubAI() {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    MaterialTheme {

        Scaffold(

            topBar = {

                TopAppBar(
                    title = {
                        Text("KhmerDub AI")
                    }
                )
            },

            bottomBar = {

                NavigationBar {

                    NavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = {
                            selectedTab = 0
                        },
                        icon = {
                            Icon(
                                Icons.Default.Movie,
                                contentDescription = "Video"
                            )
                        },
                        label = {
                            Text("Video")
                        }
                    )

                    NavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = {
                            selectedTab = 1
                        },
                        icon = {
                            Icon(
                                Icons.Default.ClosedCaption,
                                contentDescription = "Subtitle"
                            )
                        },
                        label = {
                            Text("Subtitle")
                        }
                    )

                    NavigationBarItem(
                        selected = selectedTab == 2,
                        onClick = {
                            selectedTab = 2
                        },
                        icon = {
                            Icon(
                                Icons.Default.AudioFile,
                                contentDescription = "Voice"
                            )
                        },
                        label = {
                            Text("Voice")
                        }
                    )
                }
            }

        ) { padding ->

            when (selectedTab) {

                0 -> HomeScreen(
                    modifier = Modifier.padding(padding)
                )

                1 -> SubtitleScreen(
                    modifier = Modifier.padding(padding)
                )

                2 -> VoiceScreen(
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "🎬",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "KhmerDub AI",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = "AI Video Dubbing to Khmer",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )


        Card(

            modifier = Modifier
                .fillMaxWidth(),

            shape = RoundedCornerShape(20.dp)

        ) {

            Column(

                modifier = Modifier.padding(20.dp)

            ) {

                Text(
                    text = "Start Dubbing",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "ជ្រើសរើសវីដេអូ ហើយបម្លែងសំឡេងទៅជាភាសាខ្មែរ"
                )

                Spacer(
                    modifier = Modifier.height(18.dp)
                )

                Button(

                    onClick = {
                        // Video picker will be added later
                    },

                    modifier = Modifier.fillMaxWidth()

                ) {

                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text("Select Video")
                }
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        FeatureCard(
            icon = Icons.Default.Translate,
            title = "AI Translation",
            description = "បកប្រែសំឡេងទៅជាភាសាខ្មែរ"
        )


        FeatureCard(
            icon = Icons.Default.AudioFile,
            title = "Khmer AI Voice",
            description = "បង្កើតសំឡេង AI ជាភាសាខ្មែរ"
        )


        FeatureCard(
            icon = Icons.Default.ClosedCaption,
            title = "Khmer Subtitle",
            description = "បង្កើត Subtitle ភាសាខ្មែរ"
        )
    }
}


@Composable
fun FeatureCard(

    icon: androidx.compose.ui.graphics.vector.ImageVector,

    title: String,

    description: String

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),

        shape = RoundedCornerShape(16.dp)

    ) {

        Row(

            modifier = Modifier.padding(15.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null,

                modifier = Modifier.size(32.dp)
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Column {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


@Composable
fun SubtitleScreen(
    modifier: Modifier = Modifier
) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(
            text = "Khmer Subtitle",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "នៅទីនេះយើងនឹងបន្ថែម AI Transcript និង Khmer Subtitle។"
        )
    }
}


@Composable
fun VoiceScreen(
    modifier: Modifier = Modifier
) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(
            text = "Khmer AI Voice",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "នៅទីនេះយើងនឹងបន្ថែម Khmer Text-to-Speech។"
        )
    }
}
