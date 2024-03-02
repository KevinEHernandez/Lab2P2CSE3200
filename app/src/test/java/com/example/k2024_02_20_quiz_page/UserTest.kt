package com.example.lab_2
import com.example.lab_2.Model.UserID
import org.junit.Assert.assertEquals
import org.junit.Test

class UserTest {

    @Test
    fun testGetName() {
        val userID = UserID()
        userID.setName("Kevin")
        assertEquals("Kevin", userID.getName())
    }

    @Test
    fun testSetName() {
        val userID = UserID()
        userID.setName("Kev")
        assertEquals("Kev", userID.getName())
    }
}
