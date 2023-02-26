package kg.one.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kg.one.notes.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{
	
}
