package com.nano.composeapp.components.bottomnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nano.composeapp.R
import com.nano.composeapp.sealed.BottomNavigationScreens
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun ProfileScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        ConstraintLayout(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ) {
            val (profileBox,buttonSave,infoColumn) = createRefs()

            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .constrainAs(profileBox) {
                        top.linkTo(parent.top)
                    }
            ){
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(infoColumn){
                        top.linkTo(profileBox.bottom, margin = 30.dp)
                    }
            ) {
                TextTitle(text = "Name")
                InputTextField("John Doe")

                TextTitle(text = "Email")
                InputTextField("johndoe@foodou.com")

                TextTitle(text = "Date of Birth")
                InputTextField("September 26, 1995")

                TextTitle(text = "Address")
                InputTextField("XYZ Street No. 23")
            }

            ElevatedButton(
                onClick = {  },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.food_theme)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonSave){
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                    fontFamily = notoSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TextTitle(text:String){
    Text(
        text = text,
        fontFamily = notoSansFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(id = R.color.text_color)
    )
}

@Composable
fun InputTextField(text:String){
    var textInput by remember { mutableStateOf(TextFieldValue(text)) }
    TextField(
        value = textInput,
        onValueChange = {newText ->
            textInput = newText
        },
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        enabled = true,
        singleLine = true,
        isError = false,
        keyboardOptions = KeyboardOptions.Default,
        shape = MaterialTheme.shapes.small.copy(
            topStart = CornerSize(30f),
            topEnd = CornerSize(30f),
            bottomStart = CornerSize(30f),
            bottomEnd = CornerSize(30f)
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = MaterialTheme.typography.bodyLarge
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}