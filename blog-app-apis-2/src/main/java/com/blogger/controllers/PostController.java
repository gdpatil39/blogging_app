package com.blogger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogger.entity.Post;
import com.blogger.payloads.PostDto;
import com.blogger.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	// create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId

	) {

		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

	}

	// getPostByUser

	@GetMapping("/user/{userId}/posts")

	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {

		List<PostDto> posts = this.postService.getPostsByUser(userId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}

	// getPostByCategory
	@GetMapping("/category/{categoryId}/posts")

	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {

		List<PostDto> posts = this.postService.getPostsBycategory(categoryId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}
	
	
	//get all post
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> allPost = this.postService.getallPost();
		
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
		
	}
	
	//getPostById
	@GetMapping("/posts/{postId}")
	public ResponseEntity <PostDto> getPostById(@PathVariable Integer postId) {
		
		PostDto postDto = this.postService.getPostById(postId);
		
		 return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
		
	}
	
}
