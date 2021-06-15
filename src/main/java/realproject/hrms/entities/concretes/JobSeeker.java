package realproject.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seekers")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformations","jobExperiences","foreignLanguages","socialMediaLinks","skills","coverLetter"})
public class JobSeeker extends User{
	
	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name = "date_of_birth")
	@NotNull
	@NotBlank
	private LocalDate dateOfBirth;
	
	@Column(name = "nationality_id")
	@NotNull
	@NotBlank
	private String nationalityId;

	@OneToMany(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private List<EducationInformation> educationInformations;

	@OneToMany(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private List<ForeignLanguage> foreignLanguages;

	@OneToMany(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private List<SocialMediaLink> socialMediaLinks;

	@OneToMany(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private List<Skill> skills;

	@OneToOne(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private CoverLetter coverLetter;

	@OneToOne(mappedBy = "jobSeeker",fetch = FetchType.LAZY)
	private ProfileImage profileImage;

}
