package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
