package kg.one.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kg.one.notes.entity.Note;
import kg.one.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoteService {

	private final NoteRepository repository;

	public Note createNote(Note note) {
		return repository.save(note);
	}

	public Note getNote(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<Note> getAllNotes() {
		return repository.findAll();
	}

	public Note updateNote(int id, String content) {
		Note note = repository.findById(id).orElseThrow(() -> new RuntimeException());
		note.setContent(content);
		return repository.save(note);
	}

	public void deleteNote(int id) {
		repository.deleteById(id);
	}

}
