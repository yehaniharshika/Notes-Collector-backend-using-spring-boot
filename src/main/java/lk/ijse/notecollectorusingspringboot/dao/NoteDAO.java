package lk.ijse.notecollectorusingspringboot.dao;

import lk.ijse.notecollectorusingspringboot.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<NoteEntity,String> {
}
