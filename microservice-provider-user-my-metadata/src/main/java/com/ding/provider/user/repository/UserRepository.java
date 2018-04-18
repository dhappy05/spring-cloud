package com.ding.provider.user.repository;

import com.ding.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ding on 2018/4/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
