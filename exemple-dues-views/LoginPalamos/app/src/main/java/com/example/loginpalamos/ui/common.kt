package com.example.loginpalamos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpalamos.R


@Composable
fun AppButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier.padding(3.dp)
    ) {
        Text(text)
    }
}


@Composable
fun Logo(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.fillMaxWidth().width(50.dp).height(100.dp),
        painter = painterResource(R.drawable.logo_sq
        ),
        contentDescription = "Logo InsPalamos")

}


@Composable
fun ExternalLogo(logo: Int, modifier: Modifier = Modifier){
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
fun ExternalLogoPreview(){
    ExternalLogo(R.drawable.logo_gene)
}



@Preview
@Composable
fun AppButtonPreview(){
    AppButton("Inicia sessió", {})
}