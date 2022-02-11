package platform.codingnomads.co.springdata.lab.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "trails")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class Trail implements Serializable {

    private static final long serialVersionUID = -2624055642258734917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "trail_generator")
    private Long id;

    @Column
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "origin_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_trails_origin_area_id")
    )
    private Area origin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_trails_destination_area_id")
    )
    private Area destination;

    public Trail(Area origin, Area destination) {
        this.origin = origin;
        this.destination = destination;
        this.code = origin.getCode() + "-" + destination.getCode();
    }
}
