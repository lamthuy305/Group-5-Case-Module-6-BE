package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "update user_role set role_id = ?1 where user_id = ?2", nativeQuery = true)
    User updateRole(Long roleId, Long userId);

    @Query(value = "select * from users", nativeQuery = true)
    Iterable<User> checkUser();
}
