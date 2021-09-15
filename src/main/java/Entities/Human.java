package Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "public.\"Humans\"")
public class Human {
    @Id
    @Column(name = "human_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long humanID;

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


    public Human(){}

    public Long getID(){
        return humanID;
    }


}
