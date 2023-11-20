package br.com.popularjavareposapp.ui.view.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.popularjavareposapp.R
import br.com.popularjavareposapp.model.RepositoryModel
import br.com.popularjavareposapp.ui.component.DividerComponent
import br.com.popularjavareposapp.ui.theme.gamboge
import br.com.popularjavareposapp.ui.theme.steelBlue
import br.com.popularjavareposapp.ui.theme.textColor
import br.com.popularjavareposapp.ui.viewmodel.RepositoryViewModel
import br.com.popularjavareposapp.ui.viewmodel.result.ResultViewState
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import org.koin.androidx.compose.getViewModel
import kotlin.random.Random

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
        Modifier.fillMaxWidth(), contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(repositories) { repositoryModel ->
            RepositoryCardContent(repositoryModel)
            DividerComponent()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun RepositoryCardContent(repositoryModel: RepositoryModel) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {

        val (infoGroup, userGroup) = createRefs()

        ConstraintLayout(
            modifier = Modifier
                .width(250.dp)
                .constrainAs(infoGroup) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            val (
                repositoryNameId,
                descriptionId,
                imageForkId,
                forksId,
                imageStartId,
                starId,
            ) = createRefs()

            Text(
                text = repositoryModel.name,
                textAlign = TextAlign.Left,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 18.sp,
                color = steelBlue,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs(repositoryNameId) {
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = repositoryModel.description,
                textAlign = TextAlign.Left,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier
                    .constrainAs(descriptionId) {
                        top.linkTo(repositoryNameId.bottom)
                    }
                    .wrapContentHeight()

            )

            Image(
                painter = painterResource(id = R.drawable.ic_fork),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(imageForkId) {
                        top.linkTo(descriptionId.bottom, 8.dp)
                    }
            )

            Text(
                text = repositoryModel.forks.toString(),
                textAlign = TextAlign.Left,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 18.sp,
                color = gamboge,
                modifier = Modifier.constrainAs(forksId) {
                    //top.linkTo(descriptionId.bottom)
                    linkTo(start = imageForkId.end, end = parent.end, bias = 0F)
                    linkTo(top = imageForkId.top, bottom = imageForkId.bottom)
                    start.linkTo(imageForkId.end, 4.dp)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(imageStartId) {
                        top.linkTo(descriptionId.bottom, 8.dp)
                        start.linkTo(forksId.end, margin = 16.dp)
                    }
            )

            Text(
                text = repositoryModel.stargazers.toString(),
                textAlign = TextAlign.Left,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 18.sp,
                color = gamboge,
                modifier = Modifier.constrainAs(starId) {
                    linkTo(start = imageStartId.end, end = parent.end, bias = 0F)
                    linkTo(top = imageStartId.top, bottom = imageStartId.bottom)
                    start.linkTo(imageStartId.end, 4.dp)
                }
            )
        }

        ConstraintLayout(
            modifier = Modifier.constrainAs(userGroup) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(infoGroup.end)
            }
        ) {
            val imageUserId = createRef()
            GlideImage(
                model = repositoryModel.user.photo,
                contentDescription = "",
                loading = placeholder(painterResource(R.drawable.ic_launcher_background)),
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .constrainAs(imageUserId) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}
