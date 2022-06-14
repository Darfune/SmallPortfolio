package com.example.smallportfolio

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    val projectsButtonState1 = remember {
        mutableStateOf(false)
    }
    val projectsButtonState2 = remember {
        mutableStateOf(false)
    }
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

                CreatePortfolioButton(projectsButtonState1)
                CreatePortfolioButton(projectsButtonState2)
            }
        }
    }
}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width = 2.dp, color = Color.Magenta)) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){ item ->
            Card(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            elevation = 4.dp) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(8.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item,
                            fontWeight = FontWeight.Bold)
                        Text(text = "Project Description",
                            style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
private fun CreatePortfolioButton(projectsButtonState: MutableState<Boolean>) {
    Button(
        onClick = {
            projectsButtonState.value = !projectsButtonState.value
            Log.d("Clicked", "CreateSmallPortfolio: Clicked Button")
        }) {
        Text(
            text = "Projects",
            style = MaterialTheme.typography.button
        )
    }
    if (projectsButtonState.value){
        Content()
    }else{
        Box(){}
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
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
//      border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 8.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image template",
            modifier = modifier.size(135.dp),
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