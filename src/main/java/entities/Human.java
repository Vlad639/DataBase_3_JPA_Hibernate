package entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "public.\"Humans\"")
public class Human {
    @Id
    @Column(name = "human_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long humanID;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "public.\"Flats_owners\"",
            joinColumns = @JoinColumn(name = "human_link"),
            inverseJoinColumns = @JoinColumn(name = "flat_link")
    )
    private List<Flat> flatsInWhichHumanOwner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "public.\"Residents\"",
            joinColumns = @JoinColumn(name = "human_link"),
            inverseJoinColumns = @JoinColumn(name = "flat_link")
    )
    private List<Flat> flatsInWhichHumanLive;

    public List<Flat> getFlatsInWhichHumanOwner() {
        return flatsInWhichHumanOwner;
    }

    public void setFlatsInWhichHumanOwner(List<Flat> flatsInWhichHumanOwner) {
        this.flatsInWhichHumanOwner = flatsInWhichHumanOwner;
    }

    public List<Flat> getFlatsInWhichHumanLive() {
        return flatsInWhichHumanLive;
    }

    public void setFlatsInWhichHumanLive(List<Flat> flatsInWhichHumanLive) {
        this.flatsInWhichHumanLive = flatsInWhichHumanLive;
    }

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born_date")
    private Date bornDate;

    private Date toDate(String date) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
        return parser.parse(date);
    }

    public Human(String passportNumber, String secondName, String firstName, String lastName, String bornDate) throws ParseException {
        this.passportNumber = passportNumber;
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = toDate(bornDate);
    }


    private String getStringBornDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(bornDate);
    }

    @Override
    public String toString() {
        return "Human: " + humanID +" " +
                passportNumber + " " + secondName + " " + firstName +" " +lastName +" "+ getStringBornDate();
    }

    public Human(){}

    public Long getID(){
        return humanID;
    }


}
