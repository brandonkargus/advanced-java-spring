package platform.codingnomads.co.springdata.lab.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "areas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Area implements Serializable {

    private static final long serialVersionUID = 3585904632983478212L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "area_generator")
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Boolean summer;

    @Column(nullable = false)
    private Boolean winter;
}
