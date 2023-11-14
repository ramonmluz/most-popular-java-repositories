package br.com.popularjavareposapp.ui.component

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.popularjavareposapp.ui.theme.onSurface100

@Composable
fun DividerComponent(
    modifier: Modifier = Modifier,
    color: Color = onSurface100,
) {
    Divider(
        modifier = modifier,
        thickness = 1.dp,
        color = color
    )
}