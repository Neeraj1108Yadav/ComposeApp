package com.nano.composeapp.screens.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.nano.composeapp.R
import com.nano.composeapp.screens.InputBasicTextField
import com.nano.composeapp.screens.PasswordBasicTextField
import com.nano.composeapp.screens.TextLabel
import com.nano.composeapp.screens.TextTitle
import com.nano.composeapp.sealed.IconButtonSource
import com.nano.composeapp.sealed.IconSource
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 10/09/24
 */


@Composable
fun LoginScreen(){
    Scaffold {innerPadding ->
        Surface(onClick = {},
            modifier = Modifier.padding(innerPadding),
            color = colorResource(id = R.color.login_signup_bg)) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                var passwordVisible by remember { mutableStateOf(false) }
                var password by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                var rememberCheck by remember { mutableStateOf(false) }

                val topGuideLine = createGuidelineFromTop(80.dp)
                val bottomGuideline = createGuidelineFromBottom(30.dp)
                val startGuideline = createGuidelineFromStart(20.dp)
                val endGuideline = createGuidelineFromEnd(20.dp)

                val (parentColumn,bottomRow) = createRefs()

                val columnModifier = Modifier.constrainAs(parentColumn){
                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    bottom.linkTo(bottomGuideline)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }


                val iconTrailing = if(passwordVisible){
                    IconButtonSource.PainterIcon(painterResource(id = R.drawable.visibility))
                }else{
                    IconButtonSource.PainterIcon(painterResource(id = R.drawable.visibility_off))
                }

                val loginModifier = Modifier.fillMaxWidth()

                Column(modifier = columnModifier) {
                    TextTitle(title = "Log In",loginModifier)
                    InputBasicTextField(
                        value = username,
                        onTextChange = {
                            username = it
                            Log.d("Login","UserName : $username - ${username.hashCode()}")
                        },
                        modifier = Modifier.fillMaxWidth().padding(top = 60.dp),
                        leadingIcon = IconSource.VectorIcon(Icons.Rounded.Person),
                        shape = MaterialTheme.shapes.extraLarge,
                        placeholder = "Username",
                        contentDescription = "user"
                    )

                    PasswordBasicTextField(
                        value = password,
                        onTextChange = {
                            password = it
                            Log.d("Login","Password : $password - ${password.hashCode()}")
                        },
                        modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                        leadingIcon = IconSource.VectorIcon(Icons.Rounded.Lock),
                        trailingIcon = iconTrailing,
                        shape = MaterialTheme.shapes.extraLarge,
                        placeholder = "Password",
                        contentDescription = "password",
                        onTrailingIconClick = { passwordVisible = !passwordVisible },
                        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)){

                        Checkbox(
                            checked = rememberCheck,
                            onCheckedChange = { rememberCheck = it},
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = Color.White,
                                checkedColor = Color.White,
                                checkmarkColor = Color.Black,
                            )
                        )
                        Text(
                            text = "Remember me",
                            fontSize = 18.sp,
                            fontFamily = notoSansFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.login_signup_placeholder)
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.login_signup_button),
                            contentColor = colorResource(id = R.color.login_signup_placeholder)
                        )){

                        TextLabel(
                            text = "Log In",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.login_signup_placeholder)
                        )

                    }

                    Text(
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                        text = "Forgot Password",
                        fontSize = 20.sp,
                        fontFamily = notoSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.login_signup_border),
                        textAlign = TextAlign.Center
                    )
                }

                val bottomRowModifier = Modifier.constrainAs(bottomRow){
                    bottom.linkTo(bottomGuideline)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    width = Dimension.fillToConstraints
                }

                Row(modifier = bottomRowModifier,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    TextLabel(
                        text = "Don't have an account?",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.login_signup_placeholder)
                    )

                    TextLabel(
                        text = "Sign Up",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.login_signup_border)
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}