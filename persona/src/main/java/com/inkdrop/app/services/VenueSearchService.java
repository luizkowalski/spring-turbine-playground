package com.inkdrop.app.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VenueSearchService {

	@Autowired
	protected FoursquareApi foursquareApi;

	@HystrixCommand(fallbackMethod="searchFallback")
	public void searchVenue(String location) throws FoursquareApiException {
		log.info("Location: "+location);
		Result<VenuesSearchResult> venuesSearch = foursquareApi.venuesSearch(getSearchParams(location));
		if(venuesSearch.getMeta().getCode() != 200){
			log.error("Erro during search: "+venuesSearch.getMeta().getErrorDetail());
			throw new FoursquareApiException("Error during venue search: Error code "+venuesSearch.getMeta().getCode());
		}
		CompactVenue[] compactVenues = venuesSearch.getResult().getVenues();
		Arrays.asList(compactVenues).stream().forEach(v -> System.out.println(v.getName()));
//		for (CompactVenue venue : compactVenues) {
//			findOrCreateVenue(venue);
//		}

	}

//	private void findOrCreateVenue(CompactVenue venue) {
//
//	}

	private Map<String, String> getSearchParams(String location) {
		Map<String, String> params = new HashMap<>();
		params.put("near", location);
		params.put("radius", String.valueOf(100));
		params.put("m", "foursquare");
		params.put("v", "20160101");
		params.put("intent", "browse");

		return params;
	}

	public void searchFallback(String location){
		log.info("Circuit is OPEN");
	}
}
