package com.blogger.services;

import java.util.List;

import com.blogger.entity.Post;
import com.blogger.payloads.PostDto;
import com.blogger.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto ,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsBycategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search 
	List<PostDto> searchPosts(String keyword);
	
	
	
	

}
