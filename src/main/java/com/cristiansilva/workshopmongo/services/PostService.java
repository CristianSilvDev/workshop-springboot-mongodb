package com.cristiansilva.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristiansilva.workshopmongo.domain.Post;
import com.cristiansilva.workshopmongo.repository.PostRepository;
import com.cristiansilva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;


	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findbyTitle(String text){
		return postRepository.searchTitle(text); 
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 25 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
