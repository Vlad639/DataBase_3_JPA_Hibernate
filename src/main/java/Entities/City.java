package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "public.\"Cities\"")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityID;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "cityLink", cascade = CascadeType.ALL)
    private List<Street> streets;

    public City(){}

    public List<Street> getStreets() {
        return streets;
    }

    public City(String name){
        cityName = name;
    }

    public Long getID(){
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityID + " " +cityName;
    }


}
