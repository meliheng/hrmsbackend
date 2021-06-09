package realproject.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education_informations")
public class EducationInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int educationId;

    @Column(name = "school_name",nullable = false)
    @NotNull
    @NotBlank
    private String schoolName;

    @Column(name = "education_department",nullable = false)
    @NotNull
    @NotBlank
    private String educationDepartment;

    @Column(name = "started_date",nullable = false)
    @NotNull
    @NotBlank
    private String startedDate;


    @ColumnDefault("'devam'")
    @Column(name = "graduated_date")
    private String graduatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
