package common;

public class Configuration {
    public static int oneHourFine = 100; // указываем в условных единицах
    public static int oneCraneFine = 30000; // указываем в условных единицах

    public static int maxNumberCraneOnOneShip = 2; // указываем в штуках
    public static int numberSimulationDays = 30; // указываем в днях
    public static int deltaOfTheShipArrivalAtThePort = 7; // указываем в днях
    public static int maximumUnloadingDelay = 1; // указываем в днях
    public static int sizeShapeName = 15; // указываем в кол-ве символов
    public static int maxNumberShip = 500; // указываем в штуках

    public static int maxWeightBulkCargo = 1200; // указываем в тоннах
    public static int minWeightBulkCargo = 900; // указываем в тоннах

    public static int maxWeightLiquidCargo = 1200; // указываем в тоннах
    public static int minWeightLiquidCargo = 900; // указываем в тоннах

    public static int maxNumberContainer = 1200; // указываем в штуках
    public static int minNumberContainer = 900; // указываем в штуках

    public static int performanceCraneForBulkCargo = 12; // указываем в тоннах/час
    public static int performanceCraneForLiquidCargo = 12; //указываем в тоннах/час
    public static int performanceCraneForContainer = 12; // указываем в кол-во/час

    public Configuration() {
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

