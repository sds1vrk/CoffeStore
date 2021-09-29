package com.kdt.lecture.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void test() {
        //GIVEN
        Customer customer=new Customer();
        customer.setId(2L);

        customer.setFirstName("TEST");
        customer.setLastName("ABC");

        //WHEN
        customerRepository.save(customer);

        //THEN
        Customer entity=customerRepository.findById(2L).get();
        log.info("{} {}",entity.getLastName(),entity.getFirstName());

    }


}