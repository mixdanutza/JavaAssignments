package com.daniela.Lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.Lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
}
