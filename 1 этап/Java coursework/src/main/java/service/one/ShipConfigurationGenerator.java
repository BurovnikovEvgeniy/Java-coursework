package service.one;

import common.Ship;
import common.Time;
import common.TypesCargoShips;
import common.Configuration;

import java.util.Random;


public class ShipConfigurationGenerator {
    private static Random r = new Random();
    public static Ship generateRandomShip()
    {
        final TypesCargoShips.TypesCargo typesCargo = TypesCargoShips.generateRandomTypesCargo();
        int tonnage = 0;
        int unloadTime = 0;
        if (TypesCargoShips.TypesCargo.BULK == typesCargo)
        {
            tonnage = Configuration.minWeightBulkCargo
                    + r.nextInt(Configuration.maxWeightBulkCargo - Configuration.minWeightBulkCargo + 1);
            unloadTime = (int)Math.ceil(tonnage / ((double)Configuration.performanceCraneForBulkCargo / 60));
        }
        else if (TypesCargoShips.TypesCargo.LIQUID == typesCargo)
        {
            tonnage = Configuration.minWeightLiquidCargo
                    + r.nextInt(Configuration.maxWeightLiquidCargo - Configuration.minWeightLiquidCargo + 1);
            unloadTime = (int)Math.ceil(tonnage / ((double)Configuration.performanceCraneForLiquidCargo / 60));
        }
        else
        {
            tonnage = Configuration.minNumberContainer
                    + r.nextInt(Configuration.maxNumberContainer - Configuration.minNumberContainer + 1);
            unloadTime = (int)Math.ceil(tonnage / ((double)Configuration.performanceCraneForContainer / 60));
        }

        Ship ship = new Ship(ShipNameGenerator.generateRandomName(Configuration.sizeShapeName),
        typesCargo , tonnage);
        ship.setArrivalTime(ArrivalTimeGenerator.getArrivalData(Configuration.numberSimulationDays, 24, 60));
        ship.setUnloadTime(new Time(unloadTime));
        return ship;
    }
}
