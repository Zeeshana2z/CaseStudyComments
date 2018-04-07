package com.target.casestudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.casestudy.model.Comments;
import com.target.casestudy.repository.CommentsRepo;
import com.target.casestudy.utils.CommentsUtil;

@Service
public class CommentsServiceImpl implements CommentsService{
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	private CommentsUtil commentsUtil = new CommentsUtil();

	@Override
	public List<Comments> getAllComments() {
		return commentsRepo.findAll();
	}

	@Override
	public Comments getComment(Long commentId) {
		return commentsRepo.findOne(commentId);
	}

	@Override
	public Comments saveOrUpdateComment(Comments comment) {
		//Check for objectionable words
		comment = commentsUtil.commentsValidator(comment);
		return commentsRepo.save(comment);
	}

	@Override
	public void deleteComment(Long commentId) {
		commentsRepo.delete(commentId);
	}

}
