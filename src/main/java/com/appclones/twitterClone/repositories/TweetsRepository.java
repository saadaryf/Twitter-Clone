package com.appclones.twitterClone.repositories;

import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetsRepository extends JpaRepository<Tweets,Integer> {
    List<Tweets> findAllTweetsByUserId(Integer user_id);

}
