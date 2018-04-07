package com.target.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.casestudy.model.Comments;
import com.target.casestudy.services.CommentsService;

@RestController
public class CommentsRestController {
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("/comment")
	public ResponseEntity<List<Comments>> getAllComments(){
		return ResponseEntity.ok(commentsService.getAllComments());
	}
	
	@GetMapping("/comment/{id}")
	public ResponseEntity<Comments> getComment(@PathVariable Long id){
		Comments comment = commentsService.getComment(id);
		if(null != comment)
			return ResponseEntity.ok(comment);
		else
			return new ResponseEntity<Comments>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<Comments> createComment(@RequestBody Comments comment){
		Comments retComment = commentsService.saveOrUpdateComment(comment);
		if(retComment.getStatus()) {
			return ResponseEntity.ok(retComment);
		} else {
			return new ResponseEntity<Comments>(retComment, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/comment")
	public ResponseEntity<Comments> updateComment(@RequestBody Comments comment){
		Comments retComment = commentsService.saveOrUpdateComment(comment);
		if(retComment.getStatus()) {
			return ResponseEntity.ok(retComment);
		} else {
			return new ResponseEntity<Comments>(retComment, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Long id) {
		commentsService.deleteComment(id);
		return ResponseEntity.ok(null);
	}

}
