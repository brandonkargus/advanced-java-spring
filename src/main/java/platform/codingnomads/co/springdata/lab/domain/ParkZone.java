package platform.codingnomads.co.springdata.lab.domain;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "park_zones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ParkZone implements Serializable {

    private static final long serialVersionUID = -6949478719441450371L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "park_zone_generator")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "trail_id",
            foreignKey = @ForeignKey(name = "fk_zones_trail_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Trail> trailList;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "area_id",
            foreignKey = @ForeignKey(name = "fk_zones_area_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Area> areaList;

    public ParkZone(String name) {
        this.name = name;
    }


}
