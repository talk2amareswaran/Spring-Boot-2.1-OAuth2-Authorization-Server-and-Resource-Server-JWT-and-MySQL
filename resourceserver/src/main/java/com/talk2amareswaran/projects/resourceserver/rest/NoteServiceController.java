package com.talk2amareswaran.projects.resourceserver.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.projects.resourceserver.model.AccessTokenMapper;

import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@RestController
public class NoteServiceController {

	
	@PreAuthorize("hasRole('CREATE_NOTE')")
	@RequestMapping(value="/note", method=RequestMethod.POST)
	public String createNote() {
		
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper)
				((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		System.out.println("ID:"+accessTokenMapper.getId());
		System.out.println("Name:"+accessTokenMapper.getName());
		System.out.println("Email ID:"+accessTokenMapper.getUserName());
		
		return "Note has been created successfully";
	}
	
	@PreAuthorize("hasRole('EDIT_NOTE')")
	@RequestMapping(value="/note", method=RequestMethod.PUT)
	public String updateNote() {
		return "Note has been updated successfully";
	}
	
	@PreAuthorize("hasRole('DELETE_NOTE')")
	@RequestMapping(value="/note", method=RequestMethod.DELETE)
	public String deleteNote() {
		return "Note has been deleted successfully";
	}
	
	@PreAuthorize("hasRole('VIEW_ALL_NOTE')")
	@RequestMapping(value="/note", method=RequestMethod.GET)
	public String viewAllNotes() {
		return "Notes ALL API response";
	}
	
	@PreAuthorize("hasRole('VIEW_NOTE')")
	@RequestMapping(value="/noteById", method=RequestMethod.GET)
	public String viewNotesByID() {
		return "Notes By ID response";
	}
	
	
	
	
}
