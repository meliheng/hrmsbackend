package realproject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobBoardDto {

    private int id;

    private String companyName;

    private String jobPositionName;

    private String numberOfPerson;

    private LocalDate createdDate;

    private LocalDate lastApplyDate;
}
