package com.example.gccoffe.order.model;

import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private final String address;

    public Email(String address) {
        Assert.notNull(address,"address should not be null");
        Assert.isTrue(address.length()>=4 && address.length()<=50, "address length must be between 4 and 50 characters");
        Assert.isTrue(checkAddress(address),"Invalid email address");
        this.address = address;
    }

    // Email이 맞는지 확인
    private static boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b",address);
    }


    // equals & Hash 코드 -> Valid Object할때 Equals & Hash 코드를 사용
    // 고유 값을 갖는 email의 경우 email이 같으면 동일한 Object로 처리하기 위해 사용
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    // toString의 경우 StringBuilder or StringBuffer로 따로 추가 가능
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getAddress() {
        return address;
    }
}
