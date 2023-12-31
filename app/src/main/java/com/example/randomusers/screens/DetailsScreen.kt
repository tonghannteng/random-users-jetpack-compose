package com.example.randomusers.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.randomusers.model.presentationlayer.UserInfo
import com.example.randomusers.viewmodel.UserResultViewModel

/**
 * @author: tonghann.teng
 * @since: 7/25/23
 */
@Composable
fun DetailsScreen(
    viewModel: UserResultViewModel
) {
    val userDetails = viewModel.userDetails.collectAsState().value
    if (userDetails != null) {
        UserDetailsScreen(userInfo = userDetails)
    }
}

@Composable
fun UserDetailsScreen(userInfo: UserInfo) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = userInfo.picture),
                contentDescription = "image",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            )

            Text(
                modifier = Modifier.padding(5.dp),
                text = userInfo.fullName,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                modifier = Modifier.padding(5.dp),
                text = userInfo.email,
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = userInfo.phone,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}
