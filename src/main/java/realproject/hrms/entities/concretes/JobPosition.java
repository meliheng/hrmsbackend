package realproject.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobBoards"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "position_name")
	private String jobname;

	@OneToMany(mappedBy = "jobPosition",fetch = FetchType.LAZY)
	private List<JobBoard> jobBoards;

}
