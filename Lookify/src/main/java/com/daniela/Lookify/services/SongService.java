package com.daniela.Lookify.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.Lookify.models.Song;
import com.daniela.Lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository=songRepository;
	}
	

	
	public List<Song> allSongs(){
		return (List<Song>) songRepository.findAll();
	}
	
	public void addSong(Song song) {
		songRepository.save(song);
	}
	
	public void destroyBook(Long id) {
		if(id<songRepository.count()) {
			songRepository.delete(id);
		}
		
	}
	public Song findSongById(Long id) {
		return songRepository.findOne(id);
	}
	
	public void updateSond(Song song) {
		songRepository.save(song);
	}
	

}
