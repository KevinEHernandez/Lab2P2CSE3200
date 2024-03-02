package com.example.lab_2
import com.example.lab_2.Model.Difficulty
import com.example.lab_2.Model.Score
import com.example.lab_2.Controller.scoreController
import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreTest {

    @Test
    fun testIncrementScore() {
        val scoreController = scoreController("John")
        scoreController.incrementScore(Difficulty.EASY)
        assertEquals(1.0, scoreController.getScore(), 0.01)

        scoreController.incrementScore(Difficulty.MEDIUM)
        assertEquals(3.0, scoreController.getScore(), 0.01)

        scoreController.incrementScore(Difficulty.HARD)
        assertEquals(6.0, scoreController.getScore(), 0.01)
    }
}
