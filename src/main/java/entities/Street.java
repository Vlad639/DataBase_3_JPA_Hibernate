package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "public.\"Streets\"")
public class Street {
    @Id
    @Column(name = "street_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long streetID;

    @Column(name = "street_name")
    private String streetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_link")
    private City cityLink;

   @OneToMany(mappedBy = "streetLink", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<House> houses;

    public List<House> getHouses() {
        return houses;
    }

    public Street(){}

    public Street(String name, City cityLink){
        streetName = name;
        this.cityLink = cityLink;
    }
}
