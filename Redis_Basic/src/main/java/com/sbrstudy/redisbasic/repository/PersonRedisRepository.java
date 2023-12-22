package com.sbrstudy.redisbasic.repository;

import com.sbrstudy.redisbasic.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person,String> {
}
