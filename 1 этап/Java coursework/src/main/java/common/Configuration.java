package common;

public class Configuration
{
    public static final int oneHourFine = 100; // указываем в условных единицах
    public static final int oneCraneFine = 30000; // указываем в условных единицах

    public static final int maxNumberCraneOnOneShip = 2; // указываем в штуках
    public static final int numberSimulationDays = 30; // указываем в днях
    public static final int deltaOfTheShipArrivalAtThePort = 7; // указываем в днях
    public static final int maximumUnloadingDelay = 1; // указываем в днях
    public static final int sizeShapeName = 15; // указываем в кол-ве символов
    public static final int maxNumberShip = 500; // указываем в штуках

    public static final int maxWeightBulkCargo = 1200; // указываем в тоннах
    public static final int minWeightBulkCargo = 900; // указываем в тоннах

    public static final int maxWeightLiquidCargo = 1200; // указываем в тоннах
    public static final int minWeightLiquidCargo = 900; // указываем в тоннах

    public static final int maxNumberContainer = 1200; // указываем в штуках
    public static final int minNumberContainer = 900; // указываем в штуках

    public static final int performanceCraneForBulkCargo = 1200; // указываем в тоннах/час
    public static final int performanceCraneForLiquidCargo = 1200; //указываем в тоннах/час
    public static final int performanceCraneForContainer = 1200; // указываем в кол-во/час
}
