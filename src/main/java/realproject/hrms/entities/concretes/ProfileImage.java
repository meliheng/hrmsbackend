package realproject.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile_images")
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int id;

    @Column(name = "image_url",nullable = false)
    @NotNull
    @NotBlank
    private String imageUrl;

    @OneToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
