package realproject.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_boards")
public class JobBoard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    @Column(name = "job_description",nullable = false)
    @NotBlank
    @NotNull
    private String jobDescription;

    @Column(name = "job_city",nullable = false)
    @NotBlank
    @NotNull
    private String jobCity;

    @Column(name = "job_salary")
    private String jobSalary;

    @Column(name = "number_of_person",nullable = false)
    @NotBlank
    @NotNull
    private String numberOfPerson;

    @Column(name = "created_date")
    private LocalDate createdDate=LocalDate.now();

    @Column(name = "last_apply_date")
    private LocalDate lastApplyDate;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default false")
    private Boolean isActive;

    @Column(name = "work_type",nullable = false)
    @NotBlank
    @NotNull
    private String workType;

    @Column(name = "work_period",nullable = false)
    @NotBlank
    @NotNull
    private String workPeriod;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}
