package com.example.k2024_02_20_quiz_page.model

class AllQuestions {
    val allQuestions = arrayListOf<Question<Boolean>>(
        Question<Boolean>("Adios is hello in Spanish", false, Difficulty.EASY),
        Question<Boolean>("I love you", true, Difficulty.EASY),
        Question<Boolean>("This is a statement", true, Difficulty.EASY)
        )

    fun getNumberOfQuestions() : Int {
        return allQuestions.size
    }

    fun getQuestion(i: Int) : Question<Boolean> {
        return allQuestions[i]
    }

}