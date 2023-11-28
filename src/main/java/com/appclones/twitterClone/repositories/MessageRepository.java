package com.appclones.twitterClone.repositories;

import com.appclones.twitterClone.model.Messages;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Integer> {
        List<Messages> findBySenderAndReceiver(Users sender,Users receiver);
}
