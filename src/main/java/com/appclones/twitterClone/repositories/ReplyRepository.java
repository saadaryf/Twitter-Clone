package com.appclones.twitterClone.repositories;

import com.appclones.twitterClone.model.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Replies,Integer> {

}
