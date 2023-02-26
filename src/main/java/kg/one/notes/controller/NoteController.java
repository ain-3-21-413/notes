package kg.one.notes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.one.notes.dto.CreateNoteDto;
import kg.one.notes.dto.UpdateNoteDto;
import kg.one.notes.entity.Note;
import kg.one.notes.mapper.NoteMapper;
import kg.one.notes.service.NoteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/note")
@RestController
public class NoteController {
	
	private final NoteService service;
	private final NoteMapper mapper;

	@PostMapping
	public ResponseEntity<Note> createNote(@RequestBody CreateNoteDto createNoteDto) {
		Note note = mapper.createNoteDtoToNote(createNoteDto);
		return ResponseEntity.ok(service.createNote(note));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Note> getNote(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.getNote(id));
	}

	@GetMapping
	public ResponseEntity<List<Note>> getAllNotes() {
		return ResponseEntity.ok(service.getAllNotes());
	}

	@PutMapping
	public ResponseEntity<Note> updateNote(@RequestBody UpdateNoteDto updateNoteDto) {
		int id = updateNoteDto.getId();
		String content = updateNoteDto.getContent();
		return ResponseEntity.ok(service.updateNote(id, content));
	}

	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable("id") int id) {
		service.deleteNote(id);
	}

}
