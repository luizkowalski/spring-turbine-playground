package com.inkdrop.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.inkdrop.app.models.Venue;

public interface VenuesRepository extends CrudRepository<Venue, Long> {
	Venue findByFqid(String fqid);
}
