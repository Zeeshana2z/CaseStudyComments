package com.target.casestudy.utils;

import java.util.Arrays;

import com.target.casestudy.model.Comments;

public class CommentsUtil {
	
	String[] objWords = {"hi" , "hello"};
	
	public Comments commentsValidator(Comments comment) {
		if(stringContainsItemFromList(comment.getComments() , objWords)) {
			comment.setStatus(false);
			comment.setRemark("Contains Objectionable Words");
		} else {
			comment.setStatus(true);
			comment.setRemark("Validated");
		}
		return comment;
	}
	
	public boolean stringContainsItemFromList(String comment, String[] objWords) {
	    return Arrays.stream(objWords).parallel().anyMatch(comment::contains);
	}

}
