package br.com.popularjavareposapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.popularjavareposapp.ui.theme.PopularJavaReposAppTheme
import br.com.popularjavareposapp.ui.view.RepositoriesScreen
import br.com.popularjavareposapp.ui.view.content.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val focusRequester = remember { FocusRequester() }
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(focusRequester = focusRequester) { navController.navigate("repositories") }
                }
                composable("repositories") {
                    RepositoriesScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PopularJavaReposAppTheme {
        RepositoriesScreen()
    }
}