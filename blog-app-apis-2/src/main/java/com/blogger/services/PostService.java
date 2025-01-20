package com.blogger.services;

import java.util.List;

import com.blogger.entity.Post;
import com.blogger.payloads.PostDto;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	//update
	
	Post updatePost(PostDto postDto ,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	List<Post> getallPost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsBycategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search 
	List<Post> searchPosts(String keyword);
	
	
	
	

}
