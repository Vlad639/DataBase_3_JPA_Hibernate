package Entities;

import javax.persistence.*;
import java.util.ArrayList;
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

    private Date toDate(String date) throws DataConvertException {
        String[] words = date.split("\\.");
        int day = Integer.parseInt(words[0]);
        int month = Integer.parseInt(words[1])-1;
        int year = Integer.parseInt(words[2]) - 1900;

        if (day < 1 || day > 31) throw new DataConvertException("Неверный день!");
        if (month < 0 || month > 11) throw new DataConvertException("Неверный месяц!");
        return new Date(year, month, day);
    }

    public Human(String passportNumber, String secondName, String firstName, String lastName, String bornDate) throws DataConvertException {
        this.passportNumber = passportNumber;
        this.secondName = secondName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = toDate(bornDate);
    }


    private String getDateWithoutTime(Date date) {
        String dateString = date.toString().replace(" 00:00:00.0", "");
        String[] words = dateString.split("-");

        String day = words[2];
        String month = words[1];
        String year = words[0];

        return day + "." + month + "." + year;
    }

    @Override
    public String toString() {
        return "Human: " + humanID +" " +
                passportNumber + " " + secondName + " " + firstName +" " +lastName +" "+ getDateWithoutTime(bornDate);
    }

    public Human(){}

    public Long getID(){
        return humanID;
    }


}
