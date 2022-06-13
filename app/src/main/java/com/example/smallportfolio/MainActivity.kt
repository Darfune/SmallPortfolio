package com.example.smallportfolio

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smallportfolio.ui.theme.SmallPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmallPortfolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateSmallPortfolio()
                }
            }
        }
    }
}

@Composable
fun CreateSmallPortfolio(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
    {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 8.dp) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(thickness = 4.dp, color = MaterialTheme.colors.primary)
                CreateSmallBio()
                CreatePortfolioButton()
            }
        }
    }
}
@Preview
@Composable
fun Content(){

}

@Composable
private fun CreatePortfolioButton() {
    Button(
        onClick = {
            Log.d("Clicked", "CreateSmallPortfolio: Clicked Button")
        }) {
        Text(
            text = "Portfolio",
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
private fun CreateSmallBio() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Name Surname",
            color = MaterialTheme.colors.secondaryVariant,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )
        Text(
            text = "In sodales neque in convallis iaculis",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            text = "@TwitterHandle",
            textAlign = TextAlign.Left,
            color = Color.Cyan
        )
    }

}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
//      border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 8.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image template",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DefaultPreview() {
    SmallPortfolioTheme {
        CreateSmallPortfolio()
    }
}