package com.example.nobug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.nobug.ui.form.ResultScreen
import com.example.nobug.ui.form.StressAnxietyDepressionForm

import com.example.nobug.ui.theme.NoBugTheme
import com.example.nobug.ui.viewmodel.SurveyViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val viewModel: SurveyViewModel = viewModel()

    NavGraph(navController = navController, viewModel = viewModel)
}

@Composable
fun NavGraph(navController: NavHostController, viewModel: SurveyViewModel) {
    NavHost(navController = navController, startDestination = "form") {
        composable("form") {
            StressAnxietyDepressionForm(viewModel = viewModel,
                onHomeBack = {},// Trở về màn hình chính
                onSubmit = {
                navController.navigate("result")
            })
        }


        composable("result") {


                ResultScreen(
                    resultResponse = viewModel.resultResponse.value,
                    onNextStage = { navController.navigate("form") },
                    onReturnHome = {}
                )

        }
    }
}