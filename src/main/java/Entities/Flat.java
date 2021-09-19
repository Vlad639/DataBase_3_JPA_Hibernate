package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "public.\"Flats\"")
public class Flat {
    @Id
    @Column(name = "flat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatID;

    @ManyToMany
    @JoinTable(
            name = "public.\"Flats_owners\"",
            joinColumns = @JoinColumn(name = "flat_link"),
            inverseJoinColumns = @JoinColumn(name = "human_link")
    )
    private List<Human> ownersThisFlat;

    @ManyToMany
    @JoinTable(
            name = "public.\"Residents\"",
            joinColumns = @JoinColumn(name = "flat_link"),
            inverseJoinColumns = @JoinColumn(name = "human_link")
    )
    private List<Human> residents;

    @Column(name = "flat_number")
    private int flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_link")
    private House houseLink;

    public Flat(){}

    public List<Human> getResidents(){
        return residents;
    }

    public void addResident(Human resident){
        if (residents == null)
            residents = new ArrayList<>();

        residents.add(resident);
    }

    public Flat(int number, House houseLink){
        flatNumber = number;
        this.houseLink = houseLink;
    }
}
