package com.carbontec.logiparts.jpa.repositories;

import com.carbontec.logiparts.jpa.entities.Privilege;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository  extends CrudRepository<Privilege, Integer> {
    Privilege findByName(String name);
}
