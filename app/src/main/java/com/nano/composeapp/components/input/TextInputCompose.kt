package com.nano.composeapp.components.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.composeapp.R

/**
 * Created By Neeraj Yadav on 02/09/24
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputCompose(
    onClickBack: () -> Unit
){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Input Fields") },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow")
                    }
                }
            )
        }
    ){ innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){

            Text(
                text = stringResource(R.string.input_field_types),
                fontSize = 18.sp,
                modifier = Modifier.padding(15.dp)
            )

            SimpleInputText()

            SimpleInputWithIndicator()

            TextInputLabelPlaceHolder()

            OutlineInputField()

            OutlineInputFieldILeadingIcon()

            OutlineInputFieldITrailingIcon()

            Row(modifier = Modifier.padding(top = 10.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    InputTextShapeExtraSmall()
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    InputTextShapeSmall()
                }
            }

            Row(modifier = Modifier.padding(top = 10.dp)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    InputTextShapeLarge()
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)){
                    InputTextShapeExtraLarge()
                }
            }

            InputTextShapeMedium()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextInputComposePreview(){
    TextInputCompose({})
}