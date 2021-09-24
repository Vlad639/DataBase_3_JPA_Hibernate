import entities.City;
import services.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import entities.*;

public class Main {

    private static List<City> cityList = new ArrayList<>();
    private static List<Street> streetList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Flat> flatList = new ArrayList<>();
    private static List<Human> humanList = new ArrayList<>();

    private static HumanService humanService = new HumanService();
    private static FlatService flatService = new FlatService();

    private static void showHumansFromList(List<Human> humanList){
        if (humanList.isEmpty()){
            System.out.println("Получен пустой список!");
            return;
        }

        for (Human elem: humanList)
            System.out.println(elem);

    }

    public static void main(String[] args) {

        fillTables();

        showHumansInCertainFlat(12);
        //showFlatOwners(5);
        //showHumansInCertainCity(2);
        //showHumansInCertainHouse(3);
        //showHumansFromStreetList(new long[]{2, 9});
        //registerHumanInFlat(7, 3);
        //deleteHumanFromFlat(11);
        //moveResidentsToNewFlat(16, 20);
        //changesFlatsResidents(12, 6);

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
        } catch (ParseException e) {
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

    private static void fillHumans() throws ParseException {
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
        flatList.get(0).addOwner(humanList.get(0));
        flatList.get(4).addOwner(humanList.get(1));
        flatList.get(9).addOwner(humanList.get(1));
        flatList.get(11).addOwner(humanList.get(2));
        flatList.get(12).addOwner(humanList.get(3));
        flatList.get(13).addOwner(humanList.get(4));
        flatList.get(15).addOwner(humanList.get(5));
        flatList.get(17).addOwner(humanList.get(6));
        flatList.get(13).addOwner(humanList.get(4));
        flatList.get(24).addOwner(humanList.get(6));
        flatList.get(25).addOwner(humanList.get(7));
        flatList.get(28).addOwner(humanList.get(8));
        flatList.get(30).addOwner(humanList.get(12));
        flatList.get(32).addOwner(humanList.get(13));

        for (Flat elem: flatList)
            flatService.serviceUpdate(elem);

    }

    private static void fillResidents(){
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
        flatList.get(50).addResident(humanList.get(10));
        flatList.get(56).addResident(humanList.get(11));
        flatList.get(57).addResident(humanList.get(13));

        for (Flat elem: flatList)
            flatService.serviceUpdate(elem);
    }

    private static void showHumansInCertainFlat(long flatID) {
        Flat flat = flatService.serviceGetByID(flatID);
        showHumansFromList(flat.getResidents());
    }

    private static void showFlatOwners(long flatID) {
        Flat flat = flatService.serviceGetByID(flatID);
        showHumansFromList(flat.getOwners());
    }

    private static void showHumansInCertainCity(long cityID) {
        CityService cityService = new CityService();
        City city = cityService.serviceGetByID(cityID);
        List<Street> streetsFromCity = city.getStreets();
        List<House> housesFromAllStreets = new ArrayList<>();
        List<Flat> flatsFromAllHouses = new ArrayList<>();
        List<Human> humansFromAllFlats = new ArrayList<>();

        for (Street street: streetsFromCity)
            housesFromAllStreets.addAll(street.getHouses());

        for (House house: housesFromAllStreets)
            flatsFromAllHouses.addAll(house.getFlats());

        for (Flat flat: flatsFromAllHouses)
            humansFromAllFlats.addAll(flat.getResidents());

        showHumansFromList(humansFromAllFlats);
    }

    private static void showHumansInCertainHouse(long houseID)  {
        HouseService houseService = new HouseService();
        House house = houseService.serviceGetByID(houseID);
        List<Flat> flatsFromHouse = house.getFlats();
        List<Human> humansFromFlats = new ArrayList<>();

        for (Flat flat: flatsFromHouse)
            humansFromFlats.addAll(flat.getResidents());

        showHumansFromList(humansFromFlats);
    }

    private static void showHumansFromStreetList(long[] streetList) {
        StreetService streetService = new StreetService();

        List<House> housesFromAllStreets = new ArrayList<>();
        List<Flat> flatsFromAllHouses = new ArrayList<>();
        List<Human> humansFromAllFlats = new ArrayList<>();

        for (long streetID: streetList) {
            Street street = streetService.serviceGetByID(streetID);
            housesFromAllStreets.addAll(street.getHouses());
        }

        for (House house: housesFromAllStreets)
            flatsFromAllHouses.addAll(house.getFlats());

        for (Flat flat: flatsFromAllHouses)
            humansFromAllFlats.addAll(flat.getResidents());

        showHumansFromList(humansFromAllFlats);

    }

    private static void registerHumanInFlat(long human_id, long flat_id) {
        Human human = humanService.serviceGetByID(human_id);
        Flat flat = flatService.serviceGetByID(flat_id);

        flat.addResident(human);

        flatService.serviceUpdate(flat);
        humanService.serviceUpdate(human);
    }

    private static void deleteHumanFromFlat(long human_id) {
        Human human = humanService.serviceGetByID(human_id);

        human.setFlatsInWhichHumanLive(null);
        humanService.serviceUpdate(human);
    }

    private static void moveResidentsToNewFlat(long oldFlatID, long newFlatID) {
        Flat oldFlat = flatService.serviceGetByID(oldFlatID);
        Flat newFlat = flatService.serviceGetByID(newFlatID);

        List<Human> oldFlatResidents = oldFlat.getResidents();
        oldFlat.setResidents(null);
        newFlat.setResidents(oldFlatResidents);

        flatService.serviceUpdate(oldFlat);
        flatService.serviceUpdate(newFlat);

    }

    private static void changesFlatsResidents(long firstFlatID, long secondFlatID) {
        Flat firstFlat = flatService.serviceGetByID(firstFlatID);
        Flat secondFlat = flatService.serviceGetByID(secondFlatID);

        List<Human> firstFlatResidents = List.copyOf(firstFlat.getResidents());
        List<Human> secondFlatResidents = List.copyOf(secondFlat.getResidents());

        firstFlat.setResidents(secondFlatResidents);
        secondFlat.setResidents(firstFlatResidents);

        flatService.serviceUpdate(firstFlat);
        flatService.serviceUpdate(secondFlat);

    }

}
