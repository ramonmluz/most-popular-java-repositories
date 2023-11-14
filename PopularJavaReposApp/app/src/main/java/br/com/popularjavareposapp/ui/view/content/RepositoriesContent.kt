package br.com.popularjavareposapp.ui.view.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.ui.component.DividerComponent
import br.com.popularjavareposapp.ui.theme.textColor
import br.com.popularjavareposapp.ui.viewmodel.RepositoryViewModel
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState
import org.koin.androidx.compose.getViewModel

@Composable
fun RepositoriesContent(viewModel: RepositoryViewModel = getViewModel()) {

    when (val state = viewModel.repositories.collectAsState().value) {
        is ResultViewState.Initial -> {
            viewModel.loadPopularJavaRepositories()
        }

        is ResultViewState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }

        is ResultViewState.Success -> {
            Repositories(state.data)
        }

        is ResultViewState.Error -> {
            // TODO
        }
    }
}

@Composable
private fun Repositories(repositories: List<RepositoryModel>) {
    LazyColumn(
        Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp)
    ) {
        items(repositories) { repositoryModel ->
            RepositoryCardContent(repositoryModel)
            DividerComponent()
        }
    }
}

@Composable
private fun RepositoryCardContent(repositoryModel: RepositoryModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .clickable { //TODO
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (modifier= Modifier.wrapContentWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    RepositoryNameText(repositoryModel = repositoryModel)
                }
            }
        }
    }
}

@Composable
private fun RepositoryNameText(repositoryModel: RepositoryModel) {
    Text(
        textAlign = TextAlign.Center,
        text = repositoryModel.name,
        fontSize = 18.sp,
        color = textColor,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}
