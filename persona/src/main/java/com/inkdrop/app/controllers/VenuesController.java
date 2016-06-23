package com.inkdrop.app.controllers;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inkdrop.app.services.VenueSearchService;

import fi.foyt.foursquare.api.FoursquareApiException;

@RestController
@EnableAutoConfiguration
public class VenuesController {
	
	@Autowired
	protected VenueSearchService venueSearchService;
	
	@RequestMapping(method = RequestMethod.POST, path="/venues")
	public ResponseEntity<?> searchForVenues(@PathParam("location") String location) throws FoursquareApiException{
		venueSearchService.searchVenue(location);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
