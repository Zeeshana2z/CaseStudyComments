package com.target.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.casestudy.model.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long>{

}
