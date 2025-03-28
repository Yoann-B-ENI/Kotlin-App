package com.example.tp01.ui.theme

import android.content.Context
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp01.helpers.ProgressDialog

@Composable
fun MyMainButton(text: String, context: Context? = null, intent: Intent? = null,
                 onClick: ()-> Unit = {
                     if (context != null && intent != null){
                         context.startActivity(intent)
                     }
                 }) {
    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(3.dp, Color(1f, 1f, 1f, 1f)),
        colors = ButtonColors(
            containerColor = Color(0.1f, 0.1f, 0.1f, 1f),
            contentColor = Color(0.9f, 0.9f, 0.9f, 1f),
            disabledContainerColor = Color(0.2f, 0.2f, 0.2f, 0.5f),
            disabledContentColor = Color(0.8f, 0.8f, 0.8f, 0.5f)
        )
    ) {
        Text(text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun MySmallButton(text: String, context: Context? = null, intent: Intent? = null,
                  onClick: ()-> Unit = {
                      if (context != null && intent != null){
                          context.startActivity(intent)
                      }
                  }){
    // needs a box for a box scope alignment
    Box(modifier = Modifier.fillMaxWidth()){
        Button(onClick = onClick,
            modifier = Modifier.fillMaxWidth(fraction = 0.75f)
                .align(Alignment.Center),
            border = BorderStroke(3.dp, Color(1f, 1f, 1f, 0.5f)),
            colors = ButtonColors(
                containerColor = Color(0.1f, 0.1f, 0.1f, 0.7f),
                contentColor = Color(0.9f, 0.9f, 0.9f, 1f),
                disabledContainerColor = Color(0.2f, 0.2f, 0.2f, 0.5f),
                disabledContentColor = Color(0.8f, 0.8f, 0.8f, 0.5f)
            )
        ) {
            Text(text = text, fontStyle = FontStyle.Italic,
                color = Color.White)
        }
    }
}

@Composable
fun MyTextField(label: String, placeholderText: String,
                icon: ImageVector? = null,
                value: String = " ", onValueChange: (String) -> Unit = {},
                isPassword: Boolean = false) {
    Text(text = label,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Color.Black,
        style = TextStyle(
            shadow = Shadow(
                color = Color.White,
                offset = Offset(5f, 5f),
                blurRadius = 1f),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    )
    //
    TextField(value = value, onValueChange = onValueChange,
        placeholder = {
            Row {
                if (icon != null){
                    Icon(imageVector = icon,
                        contentDescription = "icon")
                }
                Text(text = placeholderText, fontStyle = FontStyle.Italic)
            }
        },
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color(1f, 1f, 1f, 0.75f),
            focusedContainerColor = Color(1f, 1f, 1f, 0.9f),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.DarkGray
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default
    )
    //
}

@Composable
fun MyWarning(text: String) {
    Box(modifier = Modifier.fillMaxWidth()
        .background(color = Color(0.8f, 0.8f, 0.8f, 0.5f))
        .border(BorderStroke(width = 1.dp, Color(1f,1f,1f,1f)))
    ){
        Text(text = text, fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(5.dp),
            color = Color.Black)
    }
}

@Composable
fun MyTitle(text: String) {
    Text(text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Color.Black,
        style = TextStyle(
            shadow = Shadow(
                color = Color.White,
                offset = Offset(5f, 5f),
                blurRadius = 1f),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    )
}


@Composable
fun MyMultiField(labels: Array<String>, placeholders: Array<String>,
                 weights: Array<Float>, icons: Array<ImageVector?>? = null,
                 values: Array<String>, onValueChanges: Array<(String) -> Unit>){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for ((i, elem) in labels.withIndex()){
            Box(
                modifier = Modifier.weight(weights[i])
            ){
                Column {
                    var iconParam: ImageVector? = null
                    if (icons != null) {iconParam = icons[i]}
                    else{iconParam = null}
                    MyTextField(
                        label = labels[i],
                        placeholderText = placeholders[i],
                        icon = iconParam,
                        value = values[i],
                        onValueChange = onValueChanges[i]
                    )
                }
            }
        } // end for elements
    }
}


@Composable
fun MyImageBackground(@DrawableRes id: Int){
    Image(
        painter = painterResource(id),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun MyPageTemplate(@DrawableRes bg_id: Int, content: @Composable() (ColumnScope.() -> Unit)
){
    TP01Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ){
                MyImageBackground(bg_id)
                Column (
                    modifier = Modifier.padding(30.dp)
                ){
                    content()
                    ProgressDialog()
                }
            }
        }
    }
}