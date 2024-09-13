package com.binarystudios.cameratranslator.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.binarystudios.cameratranslator.presentation.navgraph.NavGraph
import com.binarystudios.cameratranslator.presentation.common.TopBarTitle
import com.binarystudios.cameratranslator.presentation.common.ic_icon_camera
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun CameraTranslatorApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    // Check if the current route matches any of the screens where you want to hide the bars
    val shouldShowBars = currentRoute == "Text" // todo
    val translateViewModel : TranslateViewModel = hiltViewModel()
    Scaffold(
        topBar = { if (shouldShowBars) TopBar() },
        bottomBar = { if (shouldShowBars) BottomBar(navController) },
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            NavGraph(navHostController = navController, contentPaddingValues = it, translateViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            TopBarTitle(
                title = "Translate"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xfff9e9e3),
            titleContentColor = Color.Black
        ),
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Edit",
                    tint = Color.Black
                )
            }
        }
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BottomBar(navController: NavController) {
    val cameraPermissionState: PermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)
    val items = listOf(
        BottomNavigationItem(
            title = "Text",
            selectedIcon = Icons.Filled.MoreVert,
            unselectedIcon = Icons.Outlined.MoreVert
        ),
        BottomNavigationItem(
            title = "Camera",
            selectedIcon = ic_icon_camera,
            unselectedIcon = ic_icon_camera
        ),
        BottomNavigationItem(
            title = "Bookmark",
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                    if (item.title == "Camera" && !cameraPermissionState.status.isGranted) {
                        cameraPermissionState.launchPermissionRequest()
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (index == selectedItemIndex) Color(0xffc5382c) else Color(
                            0xff6d6b67
                        ),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if (index == selectedItemIndex) Color(0xffc5382c) else Color(0xff6d6b67)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xfff9e9e3)
                )
            )
        }
    }

}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun CameraTranslator() {
    CameraTranslatorApp()
}