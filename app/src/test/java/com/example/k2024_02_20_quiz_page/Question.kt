package com.example.lab_2
import com.example.lab_2.Model.allQuestions
import com.example.lab_2.Model.Difficulty
import com.example.lab_2.Model.Question
import com.example.lab_2.Controller.nextQuestion
import org.junit.Assert
import org.junit.Test

class QuestionTest {

    @Test
    fun testAllQuestions() {
        val allQuestions = allQuestions()
        Assert.assertEquals(3, allQuestions.getNumberOfQuestions())

        val question = allQuestions.getQuestion(2)
        Assert.assertEquals("This is true", question.questionText)
        Assert.assertEquals(true, question.answer)
        Assert.assertEquals(Difficulty.EASY, question.difficulty)

        val question = allQuestions.getQuestion(3)
        Assert.assertEquals("This is false", question.questionText)
        Assert.assertEquals(false, question.answer)
        Assert.assertEquals(Difficulty.HARD, question.difficulty)
    }

    @Test
    fun testQuestion() {
        val question = Question("True & Hard", true, Difficulty.HARD)
        Assert.assertEquals("True & Hard", question.questionText)
        Assert.assertEquals(true, question.answer)
        Assert.assertEquals(Difficulty.HARD, question.difficulty)
    }

    @Test
    fun testNextQuestion() {
        val nextQuestion = nextQuestion()

        Assert.assertEquals(1, nextQuestion.getNextLinearQuestion())
        Assert.assertEquals(2, nextQuestion.getNextLinearQuestion())
        Assert.assertEquals(3, nextQuestion.getNextLinearQuestion())
        Assert.assertEquals(0, nextQuestion.getNextLinearQuestion())

    }
}
