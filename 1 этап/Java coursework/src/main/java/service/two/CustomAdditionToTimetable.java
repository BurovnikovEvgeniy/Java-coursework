package service.two;

import common.Configuration;
import common.Ship;
import common.Time;
import common.TypesCargoShips;
import service.one.Timetable;

import java.util.Scanner;

public class CustomAdditionToTimetable {
    public static void addCustomShipInTheTimetable(Timetable timetable)
    {
        String customInput = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Do you have data about a ship that is not in the list and want to add it ?");
            do {
                System.out.println("Y or N ?");
                customInput = in.nextLine();
            } while (!customInput.equalsIgnoreCase("n") && !customInput.equalsIgnoreCase("y"));
            if (customInput.equalsIgnoreCase("n")) {
                return;
            }
            String shipName;
            TypesCargoShips.TypesCargo cargo;
            int tonnage;
            Time arrivalTime;
            Time unloadTime;
            try {
                System.out.println("Enter the name of the ship :");
                shipName = in.nextLine();
                System.out.println("Enter the type of ship");
                customInput = in.nextLine();
                if (customInput.equalsIgnoreCase("BULK")) cargo = TypesCargoShips.TypesCargo.BULK;
                else if (customInput.equalsIgnoreCase("LIQUID")) cargo = TypesCargoShips.TypesCargo.LIQUID;
                else if (customInput.equalsIgnoreCase("CONTAINER")) cargo = TypesCargoShips.TypesCargo.CONTAINER;
                else
                {
                    throw new IllegalArgumentException("A nonexistent cargo type is entered");
                }
                System.out.println("Enter the tonnage for ship");
                tonnage = in.nextInt();
                Ship newShip = new Ship(shipName, cargo, tonnage);
                System.out.println("Enter the arrival time in the format dd:hh:mm");
                in.nextLine();
                customInput = in.nextLine();
                arrivalTime = Time.fromStringToTime(customInput);
                if (TypesCargoShips.TypesCargo.BULK == cargo)
                {
                    unloadTime = new Time((int)Math.ceil(tonnage / ((double) Configuration.performanceCraneForBulkCargo / 60)));
                }
                else if (TypesCargoShips.TypesCargo.LIQUID == cargo)
                {
                    unloadTime = new Time((int)Math.ceil(tonnage / ((double)Configuration.performanceCraneForLiquidCargo / 60)));
                }
                else
                {
                    unloadTime = new Time((int)Math.ceil(tonnage / ((double)Configuration.performanceCraneForContainer / 60)));
                }
                newShip.setArrivalTime(arrivalTime);
                newShip.setUnloadTime(unloadTime);
                timetable.addShipInTimetable(newShip);
            } catch (Exception e) {
                in.close();
                e.printStackTrace();
            }
        }

    }
}
