/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.userapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ACER
 */


class UserTest {

    @Test
    void testGetEmail() {
        User user = new User("u001", "test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    void testSetEmail() {
        User user = new User("u002", "old@example.com");
        user.setEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    void testGetUserId() {
        User user = new User("u003", "user@example.com");
        assertEquals("u003", user.getUserId());
    }

    @Test
    void testCapNhatEmail_HopLe() {
        User user = new User("u004", "init@example.com");
        user.capNhatEmail("valid@example.com");
        assertEquals("valid@example.com", user.getEmail());
    }

    @Test
    void testCapNhatEmail_KhongHopLe() {
        User user = new User("u005", "init@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.capNhatEmail("invalid-email");
        });
        assertEquals("Error: Invalid email!", exception.getMessage());
    }

    @Test
    void testCapNhatEmail_Null() {
        User user = new User("u006", "init@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.capNhatEmail(null);
        });
        assertEquals("Error: Invalid email!", exception.getMessage());
    }
}
