package com.example.k2024_02_20_quiz_page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.k2024_02_20_quiz_page.controller.NextQuestion
import com.example.k2024_02_20_quiz_page.controller.ScoreController
import com.example.k2024_02_20_quiz_page.model.AllQuestions
import com.example.k2024_02_20_quiz_page.ui.theme.K2024_02_20_quiz_pageTheme

val allQuestions: AllQuestions = AllQuestions()

class MainActivity : ComponentActivity() {

    val nextQuestion: NextQuestion = NextQuestion()
    val scoreController: ScoreController = ScoreController("User")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            K2024_02_20_quiz_pageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizPage("User!", nextQuestion, scoreController)
                }
            }
        }
    }
}

@Composable
fun QuizPage(name: String, nextQuestion: NextQuestion, scoreController: ScoreController, modifier: Modifier = Modifier) {
    var questionNumber = remember { mutableStateOf(nextQuestion.getQuestionNumber()) }
    var quizDone = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        // Display question text or score based on quizDone state
        if (!quizDone.value) {
            Card(modifier = Modifier.fillMaxWidth(0.75F)
                .fillMaxHeight(0.35F)) {
                Text(allQuestions.getQuestion(questionNumber.value).questionText)
            }
        } else {
            Text(
                text = "Your score is: ${scoreController.getScore()} / ${allQuestions.getNumberOfQuestions()}"
            )
        }

        Row() {
            Column {
                Button(onClick = {
                    val currentQuestion = allQuestions.getQuestion(questionNumber.value)
                    if (currentQuestion.answer) {
                        scoreController.incrementScore(currentQuestion.difficulty)
                    }

                }) {
                    Text("True")
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = {
                    val currentQuestion = allQuestions.getQuestion(questionNumber.value)
                    if (!currentQuestion.answer) {
                        scoreController.incrementScore(currentQuestion.difficulty)
                    }

                }) {
                    Text("False")
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Column {
                Button(onClick = {
                    if (!quizDone.value) {
                        val currentQuestion = allQuestions.getQuestion(questionNumber.value)
                        if (currentQuestion.answer) {
                            scoreController.incrementScore(currentQuestion.difficulty)
                        }
                        questionNumber.value = nextQuestion.getNextIncQuestionNumber()
                    } else {
                        // Reset quiz when "Next" button is clicked after the quiz is done
                        quizDone.value = false
                        questionNumber.value = nextQuestion.getNextIncQuestionNumber()
                    }
                }) {
                    if (!quizDone.value) {
                        Text("Next")
                    } else {
                        Text("Restart")
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = {
                    // Set quizDone to true when "Done" button is clicked
                    quizDone.value = true
                }) {
                    Text("Done")
                }
            }
        }
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_02_20_quiz_pageTheme {
        Greeting("Android")
    }
}