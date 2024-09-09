package com.nano.composeapp.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created By Neeraj Yadav on 08/09/24
 */

@Composable
fun CardComponent(){
    Scaffold(
        topBar = {
            TopAppBar()
        },
        floatingActionButton = {
            FloatingButton()
        }
    ){ innerPadding -> //innerPadding plays role that screen display below TopAppBar
       Column(modifier = Modifier
           .padding(innerPadding)
           .verticalScroll(rememberScrollState())){
           CardText("Cards",FontWeight.Bold,TextStyle())
           SimpleCard(innerPadding)
           CardElevated()
           CardOutlined()
           CardText("Chips",FontWeight.Bold,TextStyle())
           ChipsComponent()
           CardText("Check Box",FontWeight.Bold,TextStyle())
           CheckBoxCompose()
       }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){
    CenterAlignedTopAppBar(
        title = { Text(text = "Screen of CCC") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Account" )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Menu")
            }
        }
    )
}

@Composable
fun FloatingButton(){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun SimpleCard(innerPadding:PaddingValues){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)

    ) {
        CardText("Use of brush to show linear gradient", FontWeight.Medium,TextStyle(brush = getLinearGradientBrushTextStyle()))
        CardText("Use of brush for radial gradient", FontWeight.Bold,TextStyle(brush = getRadialGradientBrushTextStyle()))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardElevated(){
    ElevatedCard(
        onClick = { /*TODO*/ },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp))
    {
        CardText("Use of brush for horizontal on elevated card", FontWeight.Light,TextStyle(getHorizontalGradientBrushTextStyle()))
        CardText("When it comes to creating demo content or sample data, the name “John Doe” is undoubtedly one of the most prevalent placeholders used worldwide.", FontWeight.ExtraBold,TextStyle(getVerticalGradientBrushTextStyle()))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardOutlined(){
    OutlinedCard(
        onClick = { /*TODO*/ },
        elevation = CardDefaults.outlinedCardElevation(
            focusedElevation = 8.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ))
    {
        CardText("The context of brush using sweep on outlined card", FontWeight.Thin,TextStyle(getSweepGradientBrushTextStyle()))
        CardText("The context of solid color setup", FontWeight.SemiBold,TextStyle(getSolidBrushTextStyle()))
    }
}
@Composable
fun CardText(text:String,weight: FontWeight,style: TextStyle){
    Text(
        modifier = Modifier.padding(8.dp),
        text = text,
        fontSize = 20.sp,
        fontWeight = weight,
        style = style
    )
}

@Composable
fun ChipsComponent(){
    Column {
        Row(){
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipAssist()
            }
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipFilter()
            }
        }
        Row(){
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipInput()
            }
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipSuggestion()
            }
        }
        Row(){
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipElevatedSuggestion()
            }
            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center){
                ChipElevatedAssist()
            }
        }
    }
}

@Composable
fun ChipAssist(){
    AssistChip(
        onClick = { /*TODO*/ },
        label = { Text(text = "Settings") },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Settings,
                 contentDescription = "Settings",
                 modifier = Modifier.size(AssistChipDefaults.IconSize))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipFilter(){
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "Location")},
        leadingIcon = if(selected){
            {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Location On",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }else{
            {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Location Off",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipInput(){
    var enabled by remember { mutableStateOf(false) }
    InputChip(
        selected = enabled,
        onClick = { enabled = !enabled },
        label = { Text(text = "User Input") },
        avatar = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "User",
                modifier = Modifier.size(InputChipDefaults.AvatarSize))
        },
        trailingIcon = if(enabled){
            {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "Close",
                    modifier = Modifier.size(InputChipDefaults.IconSize)
                )
            }
        }else{
            null
        }
    )
}

@Composable
fun ChipSuggestion(){
    SuggestionChip(
        label = { Text(text = "User Suggestion") },
        onClick = {}
    )
}

@Composable
fun ChipElevatedSuggestion(){
    ElevatedSuggestionChip(
        label = { Text(text = "Elevated Suggestion") },
        onClick = {}
    )
}

@Composable
fun ChipElevatedAssist(){
    var enabled by remember { mutableStateOf(false) }

    ElevatedAssistChip(
        label = { Text(text = "Elevated Assist") },
        onClick = {enabled = !enabled},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "User")
        },
        colors =  if(enabled){
            AssistChipDefaults.elevatedAssistChipColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                leadingIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }else{
            AssistChipDefaults.elevatedAssistChipColors(
                disabledContainerColor = Color.Gray,
                disabledLeadingIconContentColor = Color.Gray
            )
        }
    )
}

@Composable
fun CheckBoxCompose(){
    var checkedOne by remember { mutableStateOf(false) }
    var checkedTwo by remember { mutableStateOf(true) }
    var checkedThree by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(start = 15.dp)){
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = if(checkedOne){"Checked"}else{"Unchecked"})
            Checkbox(checked = checkedOne, onCheckedChange = {checkedOne = it})
        }

        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = if(checkedTwo){"Checked"}else{"Unchecked"})
            Checkbox(checked = checkedTwo, onCheckedChange = {checkedTwo = it})
        }

        Row(verticalAlignment = Alignment.CenterVertically){
            Text(
                text = when(checkedThree){
                    -1 -> "Intermediate"
                    0 -> "Unchecked"
                    1 -> "Checked"
                    else -> "Unchecked"
                }
            )
            TriStateCheckbox(
                state = when(checkedThree){
                    -1 -> ToggleableState.Indeterminate
                    0 -> ToggleableState.Off
                    1 -> ToggleableState.On
                    else -> ToggleableState.Off
                },
                onClick = {
                    if(checkedThree == 0){
                        checkedThree = 1
                    }else if(checkedThree == 1){
                        checkedThree = -1
                    }else if(checkedThree == -1){
                        checkedThree = 0
                    }else{
                        checkedThree = 0
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.inversePrimary,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }

}

private val linearGradientColor = listOf(Color.Red,Color.Green,Color.Magenta)

fun getLinearGradientBrushTextStyle():Brush{
    return Brush.linearGradient(colors = linearGradientColor)
}

private val radialGradientColor = listOf(Color.Cyan,Color.Red)

fun getRadialGradientBrushTextStyle():Brush{
    return Brush.radialGradient(colors = radialGradientColor)
}

private val horizontalGradientColor = listOf(Color.DarkGray,Color.Blue)

fun getHorizontalGradientBrushTextStyle():Brush{
    return Brush.horizontalGradient(colors = horizontalGradientColor)
}

private val verticalGradientColor = listOf(Color.Red,Color.DarkGray)

fun getVerticalGradientBrushTextStyle():Brush{
    return Brush.verticalGradient(colors = verticalGradientColor)
}

private val sweepGradientColor = listOf(Color.DarkGray,Color.Red)

fun getSweepGradientBrushTextStyle():Brush{
    return Brush.sweepGradient(colors = sweepGradientColor)
}

fun getSolidBrushTextStyle():Brush{
    return SolidColor(Color.Blue)
}

@Preview(showBackground = true)
@Composable
fun CardComposePreview(){
    CardComponent()
}