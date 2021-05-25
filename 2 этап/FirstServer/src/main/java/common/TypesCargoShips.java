package common;

import java.util.Random;

public class TypesCargoShips {
    private static Random r = new Random();
    public enum TypesCargo
    {
        BULK,
        LIQUID,
        CONTAINER
    }

    public static int getEngineForThisType(TypesCargo typesCargo)
    {
        if (typesCargo == TypesCargo.BULK) return (int)Math.ceil(((double)Configuration.performanceCraneForBulkCargo / 60));
        else if (typesCargo == TypesCargo.LIQUID) return (int)Math.ceil(((double)Configuration.performanceCraneForLiquidCargo / 60));
        else return (int)Math.ceil(((double)Configuration.performanceCraneForContainer / 60));
    }

    public static TypesCargo generateRandomTypesCargo()
    {
        return switch (r.nextInt(3)) {
            case 0 -> TypesCargo.BULK;
            case 1 -> TypesCargo.LIQUID;
            default -> TypesCargo.CONTAINER;
        };
    }
}
