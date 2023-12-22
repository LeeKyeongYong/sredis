package com.sbrstudy.redisbasic;

import com.sbrstudy.redisbasic.entity.Person;
import com.sbrstudy.redisbasic.repository.PersonRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisBasicApplicationTests {

    @Autowired
    private PersonRedisRepository repos;
    @Test
    void contextLoads() {

        Person person =new Person("ho",20);

        //저장한다.
        repos.save(person);

        //'ekyspace:id' 값을 가져온다.
        repos.findById(person.getId());

        //Person Entity의 @RedisHash에 정의 되어 있는 Keyspace (people)에 속한 키의 갯수를 구함
        repos.count();


    }

    @Test
    void reload(){
        Person retrievedPerson = repos.findById("ac67442a-df8f-4cba-9149-c5765e047f0c").orElse(null);

        if (retrievedPerson != null) {
            int age = retrievedPerson.getAge();
            System.out.println("Retrieved age: " + age);
        } else {
            System.out.println("Person not found");
        }

    }

}
