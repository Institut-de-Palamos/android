package com.example.loginpalamos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpalamos.ClasseItem
import com.example.loginpalamos.R
import com.example.loginpalamos.data.local.LocalBD


@Composable
fun HorariScreen(
    modifier: Modifier = Modifier,
    classes: List<ClasseItem> = LocalBD.sampleClasses()
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(classes) { classe ->
            ClasseCard(classe = classe)
        }
    }
}

@Composable
fun ClasseCard(classe: ClasseItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (classe.esLliure) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(classe.iconaRes),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "${classe.hora}  |  ${classe.assignatura}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        } else {
            // Card completa de classe
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = classe.hora, fontSize = 13.sp, color = Color.Gray)

                    // Badge de tasques
                    val (badgeText, badgeColor) = when {
                        classe.tasquesPendents == 1 -> "1 Tasca Pendent" to Color(0xFFF59E0B)
                        classe.tasquesPendents > 1 -> "${classe.tasquesPendents} Tasques Pendents" to Color(0xFFEF4444)
                        else -> "Sense Tasques" to Color(0xFF10B981)
                    }

                    Surface(
                        color = badgeColor,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = badgeText,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(classe.iconaRes),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = classe.assignatura, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(text = "Aula: ${classe.aula}", fontSize = 13.sp, color = Color.Gray)
                        Text(text = "Professor: ${classe.professor}", fontSize = 13.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HorariScreenPreview() {
    HorariScreen()
}

@Composable
@Preview(showBackground = true)
fun ClasseCardPreview() {
    ClasseCard(
        classe = ClasseItem(
            hora = "08:00 - 09:00",
            assignatura = "Matemàtiques",
            iconaRes = R.drawable.maths,
            aula = "A101",
            professor = "Joan Garcia",
            tasquesPendents = 1
        )
    )
}

@Composable
@Preview(showBackground = true)
fun ClasseCardPreview2() {
    ClasseCard(
        classe = ClasseItem(
            hora = "10:00 - 10:30",
            assignatura = "Pati",
            iconaRes = R.drawable.pati,
            esLliure = true
        )
    )
}
