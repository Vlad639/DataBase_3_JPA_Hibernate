package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "public.\"Houses\"")
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseID;

    @Column(name = "house_number")
    private String houseNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_link")
    private Street streetLink;

    @OneToMany(mappedBy = "houseLink", cascade = CascadeType.ALL)
    private List<Flat> flats;

    public House(){}

    public House(String number, Street streetLink){
        houseNumber = number;
        this.streetLink = streetLink;
    }
}
