package com.example.simplebluetoothchat.presentation

import androidx.activity.compose.setContent
import com.example.simplebluetoothchat.ui.theme.SimpleBluetoothChatTheme
import android.os.Bundle
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.simplebluetoothchat.presentation.bluetooth_manager.ChatBluetoothManager
import com.example.simplebluetoothchat.presentation.screen.chat.ChatScreen
import com.example.simplebluetoothchat.presentation.screen.chat.ChatViewModel
import com.example.simplebluetoothchat.presentation.screen.chat.main.MainScreen
import com.example.simplebluetoothchat.presentation.screen.chat.main.MainViewModel
import com.example.simplebluetoothchat.presentation.ui.navigation.MainNavigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleBluetoothChatTheme{


                BoxWithConstraints {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = MainNavigation.Main.route,
                        builder = {

                            addMainScreen(
                                navController = navController,
                                width = constraints.maxWidth / 2,
                                chatBluetoothManager = chatBluetoothManager
                            )
                            addChatScreen(
                                navController = navController,
                                width = constraints.maxWidth / 2,
                            )
                        }
                    )

                }


            }
        }
    }


    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    private fun NavGraphBuilder.addMainScreen(
        navController: NavHostController,
        width: Int,
        chatBluetoothManager: ChatBluetoothManager
    ) {

        composable(
            route = MainNavigation.Main.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ) {

            val viewModel: MainViewModel = hiltViewModel()
            MainScreen(
                state = viewModel.state.value,
                events = viewModel::onTriggerEvent,
                chatBluetoothManager = chatBluetoothManager,
                navigateToChatScreen = {
                    navController.popBackStack()
                    navController.navigate("${MainNavigation.Chat.route}")
                },
            )
        }
    }


    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    private fun NavGraphBuilder.addChatScreen(navController: NavHostController, width: Int) {

        composable(
            route = MainNavigation.Chat.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ) {

            val viewModel: ChatViewModel = hiltViewModel()
            ChatScreen(
                state = viewModel.state.value,
                events = viewModel::onTriggerEvent,
                chatBluetoothManager = chatBluetoothManager,
            ){
                navController.popBackStack()
            }
        }

    }


}