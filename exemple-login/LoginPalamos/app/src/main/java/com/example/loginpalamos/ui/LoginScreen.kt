package com.example.loginpalamos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitOutside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpalamos.R

@Composable
fun LoginScreen(){
    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier.matchParentSize(), // ocupa tot el Box
            contentScale = ContentScale.Crop
        )
        Column(
           verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1F))
            LoginBody()
            Spacer(modifier = Modifier.weight(1F))
            Text("Tots els drets reservats", fontSize = 12.sp)
        }
    }
}

@Composable
fun LoginBody(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        MissatgeBenvinguda()
        Spacer(modifier = Modifier.height(40.dp))

        AppButton("Inicia sessió")
        AppButton("Registra't")
        Spacer(modifier = Modifier.height(40.dp))
        Row{
            ExternalLogo(R.drawable.logo_gene)
            ExternalLogo(R.drawable.logo_europa)
            ExternalLogo(R.drawable.logo_clickedu)
        }
    }
}

@Composable
fun AppButton(text: String){
    Button(
        onClick = { /*TODO*/ },
    ) {
        Text(text)
    }
}
@Composable
fun MissatgeBenvinguda(lloc: String = "InsPalamos"){
    Text("Benvinguts a $lloc",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(( R.color.blau_ins)))
}

@Composable
fun Logo(){
    Image(
        modifier = Modifier.fillMaxWidth().width(100.dp).height(200.dp),
        painter = painterResource(R.drawable.logo_sq
        ),
        contentDescription = "Logo InsPalamos")

}

@Composable
fun ExternalLogo(logo: Int){
    Image(
        painter = painterResource(logo),
        contentDescription = null,
        modifier = Modifier
            .height(48.dp)
            .width(48.dp)
            .padding(8.dp)

            // .border(1.dp, Color.Red)
            )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}


@Preview(showBackground = true)
@Composable
fun ExternalLogoPreview(){
    ExternalLogo(R.drawable.logo_gene)
}


@Preview(showBackground = true)
@Composable
fun MissatgeBenvingudaPreview(){
    MissatgeBenvinguda("Palamos")
}

@Preview(showBackground = true)
@Composable
fun LoginBodyPreview(){
    LoginBody()
}

@Preview
@Composable
fun AppButtonPreview(){
    AppButton("Inicia sessió")
}