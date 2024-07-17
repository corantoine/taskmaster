package messages;

import java.time.LocalDateTime;

import lombok.Data;

//@Getter
//@Setter
@Data
public class TaskMessageDto {
    private int userId;
    private String taskName;
    private LocalDateTime dueDate;
    private boolean completionState;
}
