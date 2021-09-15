package Entities;

import javax.persistence.*;

@Entity
@Table(name = "public.\"Flats\"")
public class Flat {
    @Id
    @Column(name = "flat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatID;

    @Column(name = "flat_number")
    private int flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_link")
    private House houseLink;

    public Flat(){}

    public Flat(int number, House houseLink){
        flatNumber = number;
        this.houseLink = houseLink;
    }
}
