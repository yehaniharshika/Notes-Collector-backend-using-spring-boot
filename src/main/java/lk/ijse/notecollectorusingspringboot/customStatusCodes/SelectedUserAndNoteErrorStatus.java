package lk.ijse.notecollectorusingspringboot.customStatusCodes;

import lk.ijse.notecollectorusingspringboot.dto.NoteStatus;
import lk.ijse.notecollectorusingspringboot.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus,NoteStatus {
    private int statusCode;
    private String statusMessage;
}
