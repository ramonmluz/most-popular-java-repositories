package br.com.popularjavareposapp.ui.view.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.popularjavareposapp.ui.theme.PopularJavaReposAppTheme
import br.com.popularjavareposapp.ui.view.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(focusRequester: FocusRequester, navigate: () -> Unit) {

    PopularJavaReposAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                LoginContent(focusRequester, navigate)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun LoginContent(focusRequester: FocusRequester,  navigate: () -> Unit) {

    var text by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            placeholder = { },
            value = text,
            onValueChange = { text = it },
            shape = RectangleShape,
            label = { Text(text = "E-mail") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
        )
        OutlinedTextField(
            placeholder = { },
            value = password,
            onValueChange = { password = it },
            shape = RectangleShape,
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = navigate,
            border = ButtonDefaults.outlinedButtonBorder,
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .size(48.dp)
        ) {
            Text("Enviar")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun preview() {
    PopularJavaReposAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                LoginContent(FocusRequester(), {})
            }
        }
    }
}
