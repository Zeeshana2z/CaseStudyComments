package com.target.casestudy.services;

import java.util.List;

import com.target.casestudy.model.Comments;

public interface CommentsService {
	
	public List<Comments> getAllComments();
	
	public Comments getComment(Long commentId);
	
	public Comments saveOrUpdateComment(Comments comment);
	
	public void deleteComment(Long commentId);

}
