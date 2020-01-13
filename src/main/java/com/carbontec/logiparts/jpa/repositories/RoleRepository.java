package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
