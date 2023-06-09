package com.cyl.repository;

import com.cyl.dataObject.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDO, String> {
    List<UserDO> findAll();
}
