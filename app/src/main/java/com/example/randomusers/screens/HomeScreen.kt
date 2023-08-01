package com.example.randomusers.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.randomusers.model.presentationlayer.UserInfo
import com.example.randomusers.navigation.Destination
import com.example.randomusers.viewmodel.UserResultViewModel

/**
 * @author: tonghann.teng
 * @since: 7/25/23
 */
@Composable
fun HomeScreen(
    navController: NavHostController, viewModel: UserResultViewModel
) {

    val userResult = viewModel.userResult.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        val userInfo = UserInfo.mapUserModelToUserInfo(userModel = userResult)
        if (userInfo.isNotEmpty()) {
            items(userInfo.size) {
                UserRow(
                    viewModel = viewModel,
                    userInfo = userInfo[it],
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun UserRow(
    viewModel: UserResultViewModel,
    userInfo: UserInfo,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 4.dp)
            .fillMaxWidth()
            .clickable {
                viewModel.setUserDetails(userInfo = userInfo)
                navController.navigate(Destination.Details.route)
            },
        shape = RoundedCornerShape(CornerSize(5.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = userInfo.picture),
                contentDescription = "image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
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
}
