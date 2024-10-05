package lk.ijse.notecollectorusingspringboot.service;

import lk.ijse.notecollectorusingspringboot.dto.NoteStatus;
import lk.ijse.notecollectorusingspringboot.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);

}
