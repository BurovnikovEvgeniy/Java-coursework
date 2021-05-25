package common;

public class Configuration
{
    public static int oneHourFine; // указываем в условных единицах
    public static int oneCraneFine; // указываем в условных единицах

    public static int maxNumberCraneOnOneShip; // указываем в штуках
    public static int numberSimulationDays; // указываем в днях
    public static int deltaOfTheShipArrivalAtThePort; // указываем в днях
    public static int maximumUnloadingDelay; // указываем в днях
    public static int sizeShapeName; // указываем в кол-ве символов
    public static int maxNumberShip; // указываем в штуках

    public static int maxWeightBulkCargo; // указываем в тоннах
    public static int minWeightBulkCargo; // указываем в тоннах

    public static int maxWeightLiquidCargo; // указываем в тоннах
    public static int minWeightLiquidCargo; // указываем в тоннах

    public static int maxNumberContainer; // указываем в штуках
    public static int minNumberContainer; // указываем в штуках

    public static int performanceCraneForBulkCargo; // указываем в тоннах/час
    public static int performanceCraneForLiquidCargo; //указываем в тоннах/час
    public static int performanceCraneForContainer; // указываем в кол-во/час

    public Configuration() {
    }

    public static void show()
    {
        System.out.println(oneHourFine);
        System.out.println(oneCraneFine);
        System.out.println(maxNumberCraneOnOneShip);
        System.out.println(numberSimulationDays);
        System.out.println(deltaOfTheShipArrivalAtThePort);
        System.out.println(maximumUnloadingDelay);
        System.out.println(sizeShapeName);
        System.out.println(maxNumberShip);
        System.out.println(maxWeightBulkCargo);
        System.out.println(minWeightBulkCargo);
        System.out.println(maxWeightLiquidCargo);
        System.out.println(minWeightLiquidCargo);
        System.out.println(maxNumberContainer);
        System.out.println(minNumberContainer);
        System.out.println(performanceCraneForBulkCargo);
        System.out.println(performanceCraneForLiquidCargo);
        System.out.println(performanceCraneForContainer);
    }

    public int getOneHourFine() {
        return oneHourFine;
    }

    public int getOneCraneFine() {
        return oneCraneFine;
    }

    public int getMaxNumberCraneOnOneShip() {
        return maxNumberCraneOnOneShip;
    }

    public int getNumberSimulationDays() {
        return numberSimulationDays;
    }

    public int getDeltaOfTheShipArrivalAtThePort() {
        return deltaOfTheShipArrivalAtThePort;
    }

    public int getMaximumUnloadingDelay() {
        return maximumUnloadingDelay;
    }

    public int getSizeShapeName() {
        return sizeShapeName;
    }

    public int getMaxNumberShip() {
        return maxNumberShip;
    }

    public int getMaxWeightBulkCargo() {
        return maxWeightBulkCargo;
    }

    public int getMinWeightBulkCargo() {
        return minWeightBulkCargo;
    }

    public int getMaxWeightLiquidCargo() {
        return maxWeightLiquidCargo;
    }

    public int getMinWeightLiquidCargo() {
        return minWeightLiquidCargo;
    }

    public int getMaxNumberContainer() {
        return maxNumberContainer;
    }

    public int getMinNumberContainer() {
        return minNumberContainer;
    }

    public int getPerformanceCraneForBulkCargo() {
        return performanceCraneForBulkCargo;
    }

    public int getPerformanceCraneForLiquidCargo() {
        return performanceCraneForLiquidCargo;
    }

    public int getPerformanceCraneForContainer() {
        return performanceCraneForContainer;
    }

    public void setOneHourFine(int oneHourFine) {
        Configuration.oneHourFine = oneHourFine;
    }

    public void setOneCraneFine(int oneCraneFine) {
        Configuration.oneCraneFine = oneCraneFine;
    }

    public void setMaxNumberCraneOnOneShip(int maxNumberCraneOnOneShip) {
        Configuration.maxNumberCraneOnOneShip = maxNumberCraneOnOneShip;
    }

    public void setNumberSimulationDays(int numberSimulationDays) {
        Configuration.numberSimulationDays = numberSimulationDays;
    }

    public void setDeltaOfTheShipArrivalAtThePort(int deltaOfTheShipArrivalAtThePort) {
        Configuration.deltaOfTheShipArrivalAtThePort = deltaOfTheShipArrivalAtThePort;
    }

    public void setMaximumUnloadingDelay(int maximumUnloadingDelay) {
        Configuration.maximumUnloadingDelay = maximumUnloadingDelay;
    }

    public void setSizeShapeName(int sizeShapeName) {
        Configuration.sizeShapeName = sizeShapeName;
    }

    public void setMaxNumberShip(int maxNumberShip) {
        Configuration.maxNumberShip = maxNumberShip;
    }

    public void setMaxWeightBulkCargo(int maxWeightBulkCargo) {
        Configuration.maxWeightBulkCargo = maxWeightBulkCargo;
    }

    public void setMinWeightBulkCargo(int minWeightBulkCargo) {
        Configuration.minWeightBulkCargo = minWeightBulkCargo;
    }

    public void setMaxWeightLiquidCargo(int maxWeightLiquidCargo) {
        Configuration.maxWeightLiquidCargo = maxWeightLiquidCargo;
    }

    public void setMinWeightLiquidCargo(int minWeightLiquidCargo) {
        Configuration.minWeightLiquidCargo = minWeightLiquidCargo;
    }

    public void setMaxNumberContainer(int maxNumberContainer) {
        Configuration.maxNumberContainer = maxNumberContainer;
    }

    public void setMinNumberContainer(int minNumberContainer) {
        Configuration.minNumberContainer = minNumberContainer;
    }

    public void setPerformanceCraneForBulkCargo(int performanceCraneForBulkCargo) {
        Configuration.performanceCraneForBulkCargo = performanceCraneForBulkCargo;
    }

    public void setPerformanceCraneForLiquidCargo(int performanceCraneForLiquidCargo) {
        Configuration.performanceCraneForLiquidCargo = performanceCraneForLiquidCargo;
    }

    public void setPerformanceCraneForContainer(int performanceCraneForContainer) {
        Configuration.performanceCraneForContainer = performanceCraneForContainer;
    }
}
