package realproject.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobBoards"})
public class Employer extends User{
	
	@Column(name = "company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name = "website")
	@NotNull
	@NotBlank
	private String website;
	
	@Column(name = "phone")
	@NotNull
	@NotBlank
	private String phone;
	
	@Column(name = "verification")
	private boolean verification;

	@OneToMany(mappedBy = "employer",fetch = FetchType.LAZY)
	private List<JobBoard> jobBoards;

}
