package common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.TypesCargoShips.TypesCargo;

public class Ship implements Comparable <Ship>{

    String shipName;
    TypesCargo cargo;
    int tonnage;
    Time arrivalTime; // время прихода корабля к порту
    Time unloadTime; // время разрузки корабля при разгрузке одним краном (НЕ ФАКТИЧЕСКОЕ, ЭТО МАКСИМАЛЬНОЕ ВРЕМЯ)
    @JsonIgnore
    Time waitingTime; // время ожидания разгрузки корабля
    @JsonIgnore
    int numberUnloadingCranes;
    @JsonIgnore
    Time shipDelayOnCrane;
    @JsonIgnore
    Time endOfUnloading;

    Ship() {
        this.shipName = "No name";
        this.cargo = null;
        this.tonnage = 0;
        this.waitingTime = new Time();
        this.numberUnloadingCranes = 0;
        this.shipDelayOnCrane = new Time();
        this.endOfUnloading = new Time();
    }
    public Ship(String name, TypesCargo cargo, int tonnage) {
        this.shipName = name;
        this.cargo = cargo;
        this.tonnage = tonnage;
        this.waitingTime = new Time();
        this.numberUnloadingCranes = 0;
        this.shipDelayOnCrane = new Time();
        this.endOfUnloading = new Time();
    }
    public Ship(Ship ship)
    {
        this.shipName = ship.shipName;
        this.cargo = ship.cargo;
        this.tonnage = ship.tonnage;
        this.arrivalTime = new Time(ship.arrivalTime.getTime());
        this.unloadTime = new Time(ship.unloadTime.getTime());
        this.waitingTime = new Time(ship.waitingTime.getTime());
        this.numberUnloadingCranes = ship.numberUnloadingCranes;
        this.shipDelayOnCrane = new Time(ship.shipDelayOnCrane.getTime());
        this.endOfUnloading = new Time(ship.endOfUnloading.getTime());
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipName() {
        return shipName;
    }

    public void setTypeCargo(TypesCargo cargo) {
        this.cargo = cargo;
    }
    public TypesCargo getTypeCargo() {
        return cargo;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }
    public int getTonnage() {
        return tonnage;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }
    public Time getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(Time unloadTime) {
        this.unloadTime = unloadTime;
    }
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public common.Time getWaitingTime() {
        return waitingTime;
    }

    public void addWaitingTime(Time time) {
        this.waitingTime.addTime(time.getTime());
    }

    public void addWaitingTime(int minutes) {
        this.waitingTime.addTime(minutes);
    }

    public void setEndOfUnloading(Time endOfUnloading) {
        this.endOfUnloading = endOfUnloading;
    }

    public void setShipDelayOnCrane(Time shipDelayOnCrane) {
        this.shipDelayOnCrane = shipDelayOnCrane;
    }

    public Time getEndOfUnloading() {
        return endOfUnloading;
    }

    public Time getShipDelayOnCrane() {
        return shipDelayOnCrane;
    }

    public int unload(int tonnageUnload)
    {
        if (this.tonnage - tonnageUnload > 0)
        {
            this.tonnage -= tonnageUnload;
            return tonnageUnload;
        }
        else
        {
            int resTonnage = this.tonnage;
            this.tonnage = 0;
            return resTonnage;
        }
    }
    public boolean checkUnload()
    {
        if (tonnage == 0)
            return true;
        return false;
    }

    public int getNumberUnloadingCranes() {
        return numberUnloadingCranes;
    }

    public void decNumberUnloadingCranes(int dec)
    {
        this.numberUnloadingCranes -= dec;
    }

    public void incNumberUnloadingCranes() throws IllegalArgumentException {
        if (this.numberUnloadingCranes == 2)
        {
            throw new IllegalArgumentException("One crane cannot be unloaded by more than two cranes");
        }
        ++this.numberUnloadingCranes;
    }

    public int calculateAmountFine()
    {
        if (waitingTime.getTime() - (int)Math.ceil(((double)unloadTime.getTime() / 2)) > 0)
        {
            int temp = ((int)(Math.ceil((double)(waitingTime.getTime()
                    - (int)Math.ceil(((double)unloadTime.getTime() / 2))) / 60)));
            temp *= Configuration.oneHourFine;
            return temp;

        }
        return 0;
    }

    public String showDataForStatistic()
    {
        String timeStartUnload = new Time(this.getArrivalTime().getTime() + this.getWaitingTime().getTime()).toString();
        String str = this.shipName + " " + this.getTypeCargo() + " " + this.getArrivalTime().toString()
                + " " + this.getWaitingTime().toString()
                + " " + timeStartUnload + " " + endOfUnloading.toString() + " " + this.shipDelayOnCrane.toString();
        System.out.println(str);
        return str;
    }


    @Override
    public String toString() {
        return shipName + " " + cargo + " " + tonnage + " " + arrivalTime + " " + unloadTime;
    }

    @Override
    public int compareTo(Ship o) {
        return Integer.compare(this.arrivalTime.getTime(), o.arrivalTime.getTime());
    }
}
