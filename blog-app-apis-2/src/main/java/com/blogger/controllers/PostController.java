package com.blogger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogger.config.AppConstants;
import com.blogger.entity.Post;
import com.blogger.payloads.ApiResponse;
import com.blogger.payloads.PostDto;
import com.blogger.payloads.PostResponse;
import com.blogger.services.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value= "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required=false)Integer pageNumber ,//all value replace by constance
			@RequestParam(value= "pageSize",defaultValue = AppConstants.PAGE_SIZE,required=false) Integer pageSize ,
			@RequestParam(value= "sortBy",defaultValue = AppConstants.SORT_BY,required=false) String sortBy,
			@RequestParam(value= "sortDir",defaultValue = AppConstants.SORT_DIR,required=false) String sortDir

			){
		 PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		 
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		
	}
	
	//getPostById
	@GetMapping("/posts/{postId}")
	public ResponseEntity <PostDto> getPostById(@PathVariable Integer postId) {
		
		PostDto postDto = this.postService.getPostById(postId);
		
		 return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
		
	}
	
	//delete
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("post is successfully deleted !!",true);
		
		
	}
	
	//update
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
		
		
		
	}
	
	
	// search 
	@GetMapping("/posts/search/{Keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("Keywords") String Keywords ){
		
		List<PostDto> result =this.postService.searchPosts(Keywords);
		
		return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
		
	}
	
	
	
}
