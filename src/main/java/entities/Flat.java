package entities;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "public.\"Flats_owners\"",
            joinColumns = @JoinColumn(name = "flat_link"),
            inverseJoinColumns = @JoinColumn(name = "human_link")
    )
    private List<Human> owners;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "public.\"Residents\"",
            joinColumns = @JoinColumn(name = "flat_link"),
            inverseJoinColumns = @JoinColumn(name = "human_link")
    )
    private List<Human> residents;

    @Column(name = "flat_number")
    private int flatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_link")
    private House houseLink;

    public Flat(){}


    public List<Human> getResidents(){
        return residents;
    }

    public void setResidents(List<Human> residents) {
        this.residents = residents;
    }

    public void addResident(Human resident){
        if (residents == null || residents.isEmpty())
            residents = new ArrayList<>();

        residents.add(resident);
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public List<Human> getOwners(){
        return owners;
    }

    public void addOwner(Human resident){
        if (owners == null)
            owners = new ArrayList<>();

        owners.add(resident);
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public Flat(int number, House houseLink){
        flatNumber = number;
        this.houseLink = houseLink;
    }
}
