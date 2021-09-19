import Entities.City;
import HibernateSessionFactory.HibernateSessionFactory;
import Services.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entities.*;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class Main {

    private static List<City> cityList = new ArrayList<>();
    private static List<Street> streetList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Flat> flatList = new ArrayList<>();
    private static List<Human> humanList = new ArrayList<>();
    private static Session session;


    private static Session newSession(){
        return HibernateSessionFactory.getSessionFactory().openSession();
    }

    private static void showHumansFromList(List<Human> humanList){
        if (humanList.isEmpty()){
            System.out.println("Получен пустой список!");
            return;
        }

        for (Human elem: humanList)
            System.out.println(elem);

    }

    public static void main(String[] args) {

        session = newSession();

        //fillTables();

        showHumansInCertainFlat(12);
        //showFlatOwners(1);
        //showHumansInCertainCity(2);
        //showHumansInCertainHouse(3);
        //showHumansFromStreetList(new int[]{7, 9});
        //registerHumanInFlat(1, 4);
        //deleteHumanFromFlat(2);
        //moveResidentsToNewFlat(42, 8);
        //changesFlatsResidents(3,7);

        session.close();

    }

    private static void saveObjectInDataBase(List<?> list, ServiceStandart service){
        for (Object elem: list){
            service.serviceSave(elem);
        }
    }


    private static void fillTables() {
        fillCities();
        fillStreets();
        fillHouses();
        fillFlats();
        try {
            fillHumans();
        }
        catch (DataConvertException e){
            e.printStackTrace();
        }
        fillFlatsOwners();
        fillResidents();




    }

    private static void fillCities(){
        CityService cityService = new CityService();
        cityList.add(new City("Вологда"));
        cityList.add(new City("Череповец"));

        saveObjectInDataBase(cityList, cityService);
    }

    private static void fillStreets(){
        StreetService streetService = new StreetService();
        streetList.add(new Street("ул. Бухарестская", cityList.get(0)));
        streetList.add(new Street("ул. Галкинская", cityList.get(0)));
        streetList.add(new Street("ул. Ленина", cityList.get(0)));
        streetList.add(new Street("ул. Возрожения", cityList.get(0)));
        streetList.add(new Street("ул. Козлёнская", cityList.get(0)));
        streetList.add(new Street("ул. Дачная", cityList.get(1)));
        streetList.add(new Street("ул. Жукова", cityList.get(1)));
        streetList.add(new Street("ул. Гоголя", cityList.get(1)));
        streetList.add(new Street("ул. Крайняя", cityList.get(1)));
        streetList.add(new Street("ул. Гагарина", cityList.get(1)));

        saveObjectInDataBase(streetList, streetService);
    }

    private static void fillHouses(){
        HouseService houseService = new HouseService();

        houseList.add(new House("23", streetList.get(0)));
        houseList.add(new House("25", streetList.get(0)));
        houseList.add(new House("26", streetList.get(0)));
        houseList.add(new House("27", streetList.get(0)));
        houseList.add(new House("17", streetList.get(1)));
        houseList.add(new House("18", streetList.get(1)));
        houseList.add(new House("19", streetList.get(1)));
        houseList.add(new House("34A", streetList.get(2)));
        houseList.add(new House("35/2", streetList.get(2)));
        houseList.add(new House("37", streetList.get(2)));
        houseList.add(new House("38", streetList.get(2)));
        houseList.add(new House("7", streetList.get(3)));
        houseList.add(new House("8", streetList.get(3)));
        houseList.add(new House("9", streetList.get(3)));
        houseList.add(new House("87", streetList.get(4)));
        houseList.add(new House("88", streetList.get(4)));
        houseList.add(new House("89", streetList.get(4)));
        houseList.add(new House("17А", streetList.get(5)));
        houseList.add(new House("17Б", streetList.get(5)));
        houseList.add(new House("18", streetList.get(5)));
        houseList.add(new House("33", streetList.get(6)));
        houseList.add(new House("34", streetList.get(6)));
        houseList.add(new House("35", streetList.get(6)));
        houseList.add(new House("12", streetList.get(7)));
        houseList.add(new House("13", streetList.get(7)));
        houseList.add(new House("43", streetList.get(8)));
        houseList.add(new House("44", streetList.get(8)));
        houseList.add(new House("45", streetList.get(8)));
        houseList.add(new House("48А", streetList.get(9)));
        houseList.add(new House("48Б", streetList.get(9)));

        saveObjectInDataBase(houseList, houseService);
    }

    private static void fillHumans() throws DataConvertException {
        HumanService humanService = new HumanService();
        humanList.add(new Human("1234567890", "Иванов", "Иван", "Иванович", "01.02.2001"));
        humanList.add(new Human("1234567891", "Кудряшов", "Шарль", "Ярославович", "01.01.2001"));
        humanList.add(new Human("1234567810", "Антонова", "Елена", "Тимуровна", "12.02.2000"));
        humanList.add(new Human("1234567811", "Недбайло", "Ждан", "Викторович", "27.05.1998"));
        humanList.add(new Human("1234567812", "Капустин", "Оскар", "Евгеньевич", "15.07.1995"));
        humanList.add(new Human("1234567813", "Легойда", "Татьяна ", "Борисовна", "19.08.1995"));
        humanList.add(new Human("1234567814", "Юдин", "Устин", "Валериевич", "17.10.1987"));
        humanList.add(new Human("1234567815", "Голубев", "Юрий", "Юхимович", "18.10.1999"));
        humanList.add(new Human("1234567816", "Селезнёв", "Игнат", "Данилович", "20.11.2001"));
        humanList.add(new Human("1234567817", "Мишин", "Рафаил", "Шамиливеч", "20.05.2005"));
        humanList.add(new Human("1234567818", "Мишина", "Татьяна", "Ярославовична", "20.05.2000"));
        humanList.add(new Human("1234567819", "Каськив", "Зигмунд", "Виталиевич", "21.07.2002"));
        humanList.add(new Human("1234567820", "Мишин", "Шамиль", "Станиславович", "09.08.1986"));
        humanList.add(new Human("1234567821", "Сушиавили", "Хасан", null, "07.12.2008"));

        saveObjectInDataBase(humanList, humanService);
    }

    private static void fillFlats(){
        FlatService flatService = new FlatService();

        flatList.add(new Flat(1, houseList.get(0)));
        flatList.add(new Flat(2, houseList.get(0)));
        flatList.add(new Flat(3, houseList.get(0)));
        flatList.add(new Flat(4, houseList.get(1)));
        flatList.add(new Flat(5, houseList.get(1)));
        flatList.add(new Flat(6, houseList.get(2)));
        flatList.add(new Flat(7, houseList.get(2)));
        flatList.add(new Flat(8, houseList.get(3)));
        flatList.add(new Flat(9, houseList.get(3)));
        flatList.add(new Flat(10, houseList.get(3)));
        flatList.add(new Flat(11, houseList.get(4)));
        flatList.add(new Flat(12, houseList.get(4)));
        flatList.add(new Flat(13, houseList.get(5)));
        flatList.add(new Flat(14, houseList.get(6)));
        flatList.add(new Flat(15, houseList.get(7)));
        flatList.add(new Flat(16, houseList.get(7)));
        flatList.add(new Flat(17, houseList.get(8)));
        flatList.add(new Flat(18, houseList.get(8)));
        flatList.add(new Flat(19, houseList.get(9)));
        flatList.add(new Flat(20, houseList.get(9)));
        flatList.add(new Flat(21, houseList.get(10)));
        flatList.add(new Flat(22, houseList.get(10)));
        flatList.add(new Flat(23, houseList.get(11)));
        flatList.add(new Flat(24, houseList.get(11)));
        flatList.add(new Flat(25, houseList.get(12)));
        flatList.add(new Flat(26, houseList.get(12)));
        flatList.add(new Flat(27, houseList.get(13)));
        flatList.add(new Flat(28, houseList.get(13)));
        flatList.add(new Flat(29, houseList.get(14)));
        flatList.add(new Flat(30, houseList.get(14)));
        flatList.add(new Flat(31, houseList.get(15)));
        flatList.add(new Flat(32, houseList.get(15)));
        flatList.add(new Flat(33, houseList.get(16)));
        flatList.add(new Flat(34, houseList.get(16)));
        flatList.add(new Flat(35, houseList.get(17)));
        flatList.add(new Flat(36, houseList.get(17)));
        flatList.add(new Flat(37, houseList.get(18)));
        flatList.add(new Flat(38, houseList.get(18)));
        flatList.add(new Flat(39, houseList.get(19)));
        flatList.add(new Flat(40, houseList.get(19)));
        flatList.add(new Flat(41, houseList.get(20)));
        flatList.add(new Flat(42, houseList.get(20)));
        flatList.add(new Flat(43, houseList.get(20)));
        flatList.add(new Flat(44, houseList.get(21)));
        flatList.add(new Flat(45, houseList.get(21)));
        flatList.add(new Flat(46, houseList.get(22)));
        flatList.add(new Flat(47, houseList.get(22)));
        flatList.add(new Flat(48, houseList.get(23)));
        flatList.add(new Flat(49, houseList.get(24)));
        flatList.add(new Flat(50, houseList.get(25)));
        flatList.add(new Flat(51, houseList.get(25)));
        flatList.add(new Flat(52, houseList.get(25)));
        flatList.add(new Flat(53, houseList.get(25)));
        flatList.add(new Flat(54, houseList.get(26)));
        flatList.add(new Flat(55, houseList.get(26)));
        flatList.add(new Flat(56, houseList.get(27)));
        flatList.add(new Flat(57, houseList.get(27)));
        flatList.add(new Flat(58, houseList.get(28)));
        flatList.add(new Flat(59, houseList.get(28)));
        flatList.add(new Flat(60, houseList.get(29)));
        flatList.add(new Flat(61, houseList.get(29)));

        saveObjectInDataBase(flatList, flatService);

    }

    private static void fillFlatsOwners() {
        HumanService humanService = new HumanService();
        humanList.get(0).addFlatWhichHumanOwner(flatList.get(0));
        humanList.get(1).addFlatWhichHumanOwner(flatList.get(4));
        humanList.get(1).addFlatWhichHumanOwner(flatList.get(9));
        humanList.get(2).addFlatWhichHumanOwner(flatList.get(11));
        humanList.get(3).addFlatWhichHumanOwner(flatList.get(12));
        humanList.get(4).addFlatWhichHumanOwner(flatList.get(13));
        humanList.get(5).addFlatWhichHumanOwner(flatList.get(15));
        humanList.get(6).addFlatWhichHumanOwner(flatList.get(17));
        humanList.get(6).addFlatWhichHumanOwner(flatList.get(24));
        humanList.get(7).addFlatWhichHumanOwner(flatList.get(25));
        humanList.get(8).addFlatWhichHumanOwner(flatList.get(28));
        humanList.get(12).addFlatWhichHumanOwner(flatList.get(30));
        humanList.get(13).addFlatWhichHumanOwner(flatList.get(32));

        for (Human elem: humanList)
            humanService.serviceUpdate(elem);
    }

    private static void fillResidents(){
        FlatService flatService = new FlatService();
        flatList.get(0).addResident(humanList.get(0));
        flatList.get(4).addResident(humanList.get(1));
        flatList.get(5).addResident(humanList.get(2));
        flatList.get(11).addResident(humanList.get(9));
        flatList.get(11).addResident(humanList.get(10));
        flatList.get(11).addResident(humanList.get(12));
        flatList.get(15).addResident(humanList.get(6));
        flatList.get(17).addResident(humanList.get(7));
        flatList.get(24).addResident(humanList.get(8));
        flatList.get(25).addResident(humanList.get(9));
        flatList.get(28).addResident(humanList.get(10));
        flatList.get(30).addResident(humanList.get(11));
        flatList.get(47).addResident(humanList.get(13));

        for (Flat elem: flatList)
            flatService.serviceUpdate(elem);
    }


    private static void showHumansInCertainFlat(int flatID) {
        FlatService flatService = new FlatService();
        Flat flat = flatService.serviceGetByID(flatID);
        showHumansFromList(flat.getResidents());


    }

    private static void showFlatOwners(int flatID) {

    }

    private static void showHumansInCertainCity(int cityID) {

    }

    private static void showHumansInCertainHouse(int houseID)  {

    }

    private static void showHumansFromStreetList(int[] streetList) {

    }

    private static void registerHumanInFlat(int human_id, int flat_id)  {

    }

    private static void deleteHumanFromFlat(int human_id) {

    }

    private static void moveResidentsToNewFlat(int oldFlat, int newFlat) {

    }

    private static void changesFlatsResidents(int firstFlatID, int secondFlatID) {


    }

}
