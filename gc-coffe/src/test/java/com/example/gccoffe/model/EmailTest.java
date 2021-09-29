package com.example.gccoffe.model;

import com.example.gccoffe.order.model.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void testInvalidEmail() {
        // 예외가 발생하게 만듦
        assertThrows(IllegalArgumentException.class,()-> {
            var email=new Email("aasdf");
        });
    }

    // 올바른 이메일인지 검증
    @Test
    public void testValidEmail() {
        // 생성자에서 패턴 검색
        var email=new Email("aasdf@gmail.com");
        assertTrue(email.getAddress().equals("aasdf@gmail.com"));
    }

    @Test
    public void testValidEmail2() {
        // 생성자에서 패턴 검색
        var email=new Email("aasdf@gmail.com");
        var email2=new Email("aasdf@gmail.com");
        assertEquals(email,email2);
    }




}