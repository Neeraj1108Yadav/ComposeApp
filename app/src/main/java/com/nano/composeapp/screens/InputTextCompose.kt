package com.nano.composeapp.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.nano.composeapp.R
import com.nano.composeapp.sealed.IconButtonSource
import com.nano.composeapp.sealed.IconSource
import com.nano.composeapp.utils.IconButtonDisplay
import com.nano.composeapp.utils.IconDisplay

/**
 * Created By Neeraj Yadav on 10/09/24
 */

@Composable
fun LeadingIconTextField(modifier: Modifier,
                         icon:ImageVector,
                         shape: Shape,
                         placeholder: String,
                         contentDescription:String,
                         keyboard:KeyboardOptions,
                         keyboardAction:KeyboardActions){

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {newText->
            text = newText
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = contentDescription)
        },
        shape = shape,
        placeholder = { Text(text = placeholder)},
        keyboardOptions = keyboard,
        keyboardActions = keyboardAction,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(id = R.color.login_signup_placeholder),
            focusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
            unfocusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
            unfocusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
            focusedBorderColor = colorResource(id = R.color.login_signup_border),
            unfocusedBorderColor = colorResource(id = R.color.login_signup_border)
        ),
        textStyle = MaterialTheme.typography.bodyMedium
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBasicTextField(
                        value:String,
                        onTextChange: (text: String) -> Unit,
                        modifier: Modifier,
                        leadingIcon:IconSource? = null,
                        trailingIcon:IconSource? = null,
                        shape: Shape,
                        placeholder: String,
                        contentDescription:String,
                        keyboard:KeyboardOptions = KeyboardOptions.Default,
                        keyboardAction:KeyboardActions = KeyboardActions.Default,
                        visualTransformation:VisualTransformation = VisualTransformation.None){

    val interactionSource = remember{ MutableInteractionSource() }

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onTextChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboard,
        keyboardActions = keyboardAction,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(Color.White)
    ){innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            leadingIcon = {
                leadingIcon?.let {
                    IconDisplay(iconSource = leadingIcon,
                        contentDescription = contentDescription,
                        modifier = Modifier.padding(start = 20.dp))
                }
            },
            trailingIcon = {
                trailingIcon?.let{
                    IconDisplay(iconSource = trailingIcon,
                        contentDescription = contentDescription,
                        modifier = Modifier.padding(end = 20.dp))
                }
            },
            placeholder = { Text(text = placeholder)},
            colors = TextFieldDefaults.colors(
                focusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
                focusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
                focusedTrailingIconColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedTrailingIconColor = colorResource(id = R.color.login_signup_placeholder),
            ),
            contentPadding =  OutlinedTextFieldDefaults.contentPadding(
                start = 15.dp,
                end = 10.dp
            ),
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.login_signup_border),
                        unfocusedBorderColor = colorResource(id = R.color.login_signup_border),
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    shape = shape,
                    focusedBorderThickness = 3.dp,
                    unfocusedBorderThickness = 3.dp
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordBasicTextField(
                        value:String,
                        onTextChange: (text:String) -> Unit,
                        modifier: Modifier,
                        leadingIcon:IconSource? = null,
                        trailingIcon:IconButtonSource? = null,
                        shape: Shape,
                        placeholder: String,
                        contentDescription:String,
                        keyboard:KeyboardOptions = KeyboardOptions.Default,
                        keyboardAction:KeyboardActions = KeyboardActions.Default,
                        visualTransformation:VisualTransformation,
                        onTrailingIconClick: () ->Unit){

    val interactionSource = remember{ MutableInteractionSource() }

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onTextChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = keyboard,
        keyboardActions = keyboardAction,
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        cursorBrush = SolidColor(Color.White)
    ){innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            leadingIcon = {
                leadingIcon?.let {
                    IconDisplay(iconSource = leadingIcon,
                        contentDescription = contentDescription,
                        modifier = Modifier.padding(start = 20.dp))
                }
            },
            trailingIcon = {
                trailingIcon?.let{
                    IconButtonDisplay(
                        iconButtonSource = trailingIcon,
                        contentDescription = contentDescription,
                        modifier = Modifier.padding(end = 20.dp),
                        onIconButtonClick = onTrailingIconClick
                    )
                }
            },
            placeholder = { Text(text = placeholder)},
            colors = TextFieldDefaults.colors(
                focusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedPlaceholderColor = colorResource(id = R.color.login_signup_placeholder),
                focusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedLeadingIconColor = colorResource(id = R.color.login_signup_placeholder),
                focusedTrailingIconColor = colorResource(id = R.color.login_signup_placeholder),
                unfocusedTrailingIconColor = colorResource(id = R.color.login_signup_placeholder),
            ),
            contentPadding =  OutlinedTextFieldDefaults.contentPadding(
                start = 15.dp,
                end = 10.dp
            ),
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.login_signup_border),
                        unfocusedBorderColor = colorResource(id = R.color.login_signup_border),
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    shape = shape,
                    focusedBorderThickness = 3.dp,
                    unfocusedBorderThickness = 3.dp
                )
            }
        )
    }
}