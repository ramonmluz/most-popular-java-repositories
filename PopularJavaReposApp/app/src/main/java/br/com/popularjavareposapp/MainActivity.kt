package br.com.popularjavareposapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.popularjavareposapp.ui.theme.PopularJavaReposAppTheme
import br.com.popularjavareposapp.ui.view.RepositoriesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepositoriesScreen()
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