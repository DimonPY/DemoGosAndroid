package ru.example.demogos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val HomeBackground = Color(0xFF00162F)
private val BottomBackground = Color(0xFF25262E)
private val CardBackground = Color(0xFF17283E)
private val BorderBlue = Color(0xFF008DFF)
private val PassportRed = Color(0xFFD0002A)
private val PassportPaper = Color(0xFFFFEEEE)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                DemoGosApp()
            }
        }
    }
}

@Composable
private fun DemoGosApp() {
    var screen by rememberSaveable { mutableStateOf(Screen.HOME) }

    when (screen) {
        Screen.HOME -> HomeScreen(
            onPassportClick = { screen = Screen.PASSPORT }
        )

        Screen.PASSPORT -> PassportDemoScreen(
            onBack = { screen = Screen.HOME }
        )
    }
}

private enum class Screen {
    HOME, PASSPORT
}

@Composable
private fun HomeScreen(
    onPassportClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = HomeBackground,
        bottomBar = {
            BottomNavigation()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.statusBars)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(39.dp)
                )

                Spacer(Modifier.width(12.dp))

                Text(
                    "ДМИТРИЙ",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "›",
                    color = Color.White,
                    fontSize = 35.sp,
                    modifier = Modifier.padding(start = 7.dp)
                )

                Spacer(Modifier.weight(1f))

                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(31.dp)
                )

                Spacer(Modifier.width(26.dp))

                Box {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(31.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.Red)
                            .align(Alignment.TopEnd)
                    )
                }

                Spacer(Modifier.width(20.dp))

                Text(
                    "ГОСКАН",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 28.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TopChip("Поступление в колледж")
                TopChip("Водительские права")
                TopChip("Защита близких от взлома")
                TopChip("Оформление налогового вычета")
            }

            Spacer(Modifier.height(18.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp),
                color = CardBackground,
                shape = RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, Color(0xFF30445D))
            ) {
                Column(
                    modifier = Modifier.padding(35.dp, 34.dp)
                ) {
                    Text(
                        "Нет начислений",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "уточните данные",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(Modifier.height(28.dp))

            Text(
                "Документы для предъявления",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 50.dp)
            )

            Spacer(Modifier.height(18.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DocumentTile(
                    title = "Паспорт",
                    icon = Icons.Default.Badge,
                    onClick = onPassportClick,
                    enabled = true
                )
                DocumentTile(
                    title = "СНИЛС",
                    icon = Icons.Default.Security,
                    onClick = {},
                    enabled = false
                )
                DocumentTile(
                    title = "Ж/д билеты",
                    icon = Icons.Default.Train,
                    onClick = {},
                    enabled = false
                )
                DocumentTile(
                    title = "Все",
                    icon = Icons.Default.Description,
                    onClick = {},
                    enabled = false
                )
            }

            Spacer(Modifier.height(34.dp))

            Text(
                "Сервисы и приложения",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 50.dp)
            )

            Spacer(Modifier.height(18.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ServiceTile("Здоровье", Icons.Default.Bolt)
                ServiceTile("Авто", Icons.Default.Smartphone)
                ServiceTile("Госключ", Icons.Default.Key)
                ServiceTile("Другие", Icons.Default.GridView)
            }

            Spacer(Modifier.height(35.dp))
        }
    }
}

@Composable
private fun TopChip(text: String) {
    Surface(
        color = Color(0xFF1E222C),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(1.dp, Color(0xFF454956))
    ) {
        Text(
            text,
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 13.dp)
        )
    }
}

@Composable
private fun DocumentTile(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(82.dp)
    ) {
        Surface(
            onClick = onClick,
            enabled = enabled,
            modifier = Modifier.size(74.dp),
            shape = RoundedCornerShape(18.dp),
            color = if (enabled) Color(0xFFFF2B17) else Color(0xFF3C3E46)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        Text(
            title,
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ServiceTile(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(78.dp)
    ) {
        Surface(
            modifier = Modifier.size(70.dp),
            shape = RoundedCornerShape(18.dp),
            color = Color(0xFF252833),
            border = BorderStroke(1.dp, Color(0xFF555965))
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    icon,
                    contentDescription = null,
                    tint = Color(0xFF5B8CFF),
                    modifier = Modifier.size(36.dp)
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        Text(
            title,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun BottomNavigation() {
    NavigationBar(
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
        containerColor = BottomBackground,
        tonalElevation = 0.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            },
            label = { Text("главная") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(Icons.Default.GridView, contentDescription = null)
            },
            label = { Text("услуги") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(Icons.Default.VerifiedUser, contentDescription = null)
            },
            label = { Text("") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(Icons.Default.AccountBalanceWallet, contentDescription = null)
            },
            label = { Text("платежи") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(Icons.Default.Description, contentDescription = null)
            },
            label = { Text("документы") }
        )
    }
}

@Composable
private fun PassportDemoScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(PassportRed)
                .padding(horizontal = 10.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Text(
                "Паспорт — ДЕМО",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF050505))
                .padding(15.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = PassportPaper,
                shape = RoundedCornerShape(23.dp)
            ) {
                Box {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .background(
                                    PassportRed,
                                    RoundedCornerShape(
                                        topStart = 23.dp,
                                        topEnd = 23.dp,
                                        bottomStart = 5.dp,
                                        bottomEnd = 5.dp
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "ДЕМО-ВЕРСИЯ",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(Modifier.height(18.dp))

                        Text(
                            "НЕ ЯВЛЯЕТСЯ ДОКУМЕНТОМ",
                            color = Color(0xFFB00020),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(Modifier.height(18.dp))

                        Row(verticalAlignment = Alignment.Top) {
                            Box(
                                modifier = Modifier
                                    .size(155.dp, 185.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xFFE4E0E0)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Default.AccountCircle,
                                    contentDescription = null,
                                    tint = Color(0xFFBDB8B8),
                                    modifier = Modifier.size(120.dp)
                                )
                            }

                            Spacer(Modifier.width(18.dp))

                            Column {
                                DemoField("Кем выдан", "ДЕМО-ПОДРАЗДЕЛЕНИЕ")
                                Spacer(Modifier.height(13.dp))
                                DemoField("Дата выдачи", "31.01.2024")
                                Spacer(Modifier.height(13.dp))
                                DemoField("Код подразделения", "000-000")
                            }
                        }

                        Spacer(Modifier.height(20.dp))

                        DemoField("ФИО", "Дмитрий [ДЕМО]")
                        Spacer(Modifier.height(16.dp))

                        Row {
                            Column(Modifier.weight(1f)) {
                                DemoField("Пол", "МУЖСКОЙ")
                            }
                            Column(Modifier.weight(1f)) {
                                DemoField("Дата рождения", "16.01.2008")
                            }
                        }

                        Spacer(Modifier.height(18.dp))

                        DemoField("Место рождения", "Г. МОСКВА, РОССИЯ")

                        Spacer(Modifier.height(20.dp))

                        Text(
                            "Все данные на этом экране являются демонстрационными.",
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    }

                    Text(
                        "ДЕМО",
                        color = Color(0x33200000),
                        fontSize = 72.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 260.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DemoField(
    label: String,
    value: String
) {
    Column {
        Text(
            label,
            color = Color(0xFF6D6D6D),
            fontSize = 13.sp
        )
        Text(
            value,
            color = Color(0xFF151515),
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
