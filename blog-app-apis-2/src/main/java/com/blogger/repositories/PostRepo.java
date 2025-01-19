package com.blogger.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogger.entity.Category;
import com.blogger.entity.Post;
import com.blogger.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
