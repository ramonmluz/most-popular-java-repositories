@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.popularjavareposapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.popularjavareposapp.R
import br.com.popularjavareposapp.data.Repository
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.model.RepositoryResponse
import br.com.popularjavareposapp.model.User
import br.com.popularjavareposapp.network.result.ResponseResult
import br.com.popularjavareposapp.ui.theme.PopularJavaReposAppTheme
import br.com.popularjavareposapp.ui.view.content.RepositoriesContent
import br.com.popularjavareposapp.ui.viewmodel.RepositoryViewModel
import br.com.popularjavareposapp.usecase.RepositoryUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepositoriesScreen() {
    PopularJavaReposAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                RepositoriesContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.java_repos_github))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun RepositoriesPreview() {
    PopularJavaReposAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                val repository = object : Repository {
                    override suspend fun loadPopularJavaRepositories(pageNumber: String): ResponseResult<RepositoryResponse> {
                        return ResponseResult.Success(getRepositories())
                    }
                }
                val useCase = remember { RepositoryUseCase(repository) }
                val viewModel = remember { RepositoryViewModel(useCase) }
                RepositoriesContent(viewModel = viewModel)
            }
        }
    }
}

private fun getRepositories(): RepositoryResponse {
    val repositories = listOf(
        RepositoryModel(
            0,
            "Nome do Reposítório",
            LoremIpsum(12).values.first(),
            5,
            5,
            user = User("username", "")
        ),
        RepositoryModel(
            0,
            "Nome do Reposítório",
            LoremIpsum(12).values.first(),
            5,
            5,
            user = User("username", "")
        ),
        RepositoryModel(
            0,
            "Nome do Reposítório",
            LoremIpsum(12).values.first(),
            5,
            5,
            user = User("username", "")
        ),
    )
    return RepositoryResponse(repositories)
}
