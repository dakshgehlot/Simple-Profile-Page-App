package com.example.profilepage

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilepage.ui.theme.ProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFefebe9)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ProfilePage()
                        Spacer(modifier = Modifier.height(75.dp))
                        PersonalDetails()
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "My Profile",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Spacer(
            modifier = Modifier
                .height(60.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(25.dp)
                .border(width = 5.dp, color = Color.Black, shape = RoundedCornerShape(50))
                .clip(RoundedCornerShape(50))
        )
        Text(
            text = "Daksh Gehlot",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            color = Color(0xFF2F2F2F)
        )
        Text(
            text = "Android Developer",
            fontWeight = FontWeight.Bold,
            color = Color(0xFFACAFBB),
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun PersonalDetails() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        PersonalDetailItem(icon = R.drawable.ic_baseline_call_24, content = "9571153111")
        PersonalDetailItem(icon = R.drawable.ic_baseline_public_24, content = "dakshgehlot1")
        PersonalDetailItem(
            icon = R.drawable.ic_baseline_email_24,
            content = "dakshgehlot30@gmail.com"
        )
    }
}

@Composable
fun PersonalDetailItem(@DrawableRes icon: Int, content: String){
    Row(
        modifier = Modifier
            .padding(bottom = 25.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(50.dp))
        Text(
            text = content,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfilePageTheme {
        ProfilePage()
    }
}