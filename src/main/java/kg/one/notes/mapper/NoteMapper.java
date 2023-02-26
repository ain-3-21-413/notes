package kg.one.notes.mapper;

import org.springframework.stereotype.Service;

import kg.one.notes.dto.CreateNoteDto;
import kg.one.notes.entity.Note;

@Service
public class NoteMapper {

	public Note createNoteDtoToNote(CreateNoteDto dto) {
		Note note = Note.builder()
			.title(dto.getTitle())
			.content(dto.getContent())
			.build();
		return note;
	}
}
