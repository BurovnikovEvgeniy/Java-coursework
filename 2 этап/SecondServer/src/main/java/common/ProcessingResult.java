package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class ProcessingResult {
    private Vector<Integer> averageLengthUnloadingQueue;
    private Vector<Time> averageWaitingTimeInQueue;
    private Vector<Time> averageDelay;
    private Vector<Time> maxDelay;
    private Vector<Integer> totalNumberShipsUnloaded;
    private Vector<Integer> numberBulkShip;
    private Vector<Integer> numberLiquidShip;
    private Vector<Integer> numberContainerShip;
    private Vector<Integer> totalCost;
    private Vector<Integer> costBulk;
    private Vector<Integer> costLiquid;
    private Vector<Integer> costContainer;
    private Vector<Integer> numberBulkCrane;
    private Vector<Integer> numberLiquidCrane;
    private Vector<Integer> numberContainerCrane;

    ProcessingResult()
    {
        averageLengthUnloadingQueue = new Vector<>();
        averageDelay = new Vector<>();
        averageWaitingTimeInQueue = new Vector<>();
        maxDelay = new Vector<>();
        totalNumberShipsUnloaded = new Vector<>();
        numberBulkShip = new Vector<>();
        numberLiquidShip = new Vector<>();
        numberContainerShip = new Vector<>();
        totalCost = new Vector<>();
        costBulk = new Vector<>();
        costLiquid = new Vector<>();
        costContainer = new Vector<>();
        numberBulkCrane = new Vector<>();
        numberLiquidCrane = new Vector<>();
        numberContainerCrane = new Vector<>();
    }

    public Vector<Integer> getNumberBulkShip() {
        return numberBulkShip;
    }
    public Vector<Integer> getNumberLiquidShip() {
        return numberLiquidShip;
    }
    public Vector<Integer> getNumberContainerShip() {
        return numberContainerShip;
    }
    public Vector<Integer> getCostBulk() {
        return costBulk;
    }
    public Vector<Integer> getCostLiquid() {
        return costLiquid;
    }
    public Vector<Integer> getCostContainer() {
        return costContainer;
    }
    public Vector<Integer> getAverageLengthUnloadingQueue() {
        return averageLengthUnloadingQueue;
    }
    public Vector<Integer> getTotalCost() {
        return totalCost;
    }
    public Vector<Integer> getTotalNumberShipsUnloaded() {
        return totalNumberShipsUnloaded;
    }
    public Vector<Integer> getNumberBulkCrane() {
        return numberBulkCrane;
    }
    public Vector<Integer> getNumberContainerCrane() {
        return numberContainerCrane;
    }
    public Vector<Integer> getNumberLiquidCrane() {
        return numberLiquidCrane;
    }
    public Vector<Time> getAverageDelay() {
        return averageDelay;
    }
    public Vector<Time> getAverageWaitingTimeInQueue() {
        return averageWaitingTimeInQueue;
    }
    public Vector<Time> getMaxDelay() {
        return maxDelay;
    }

    public void setNumberBulkShip(Vector<Integer> numberBulkShip) {
        this.numberBulkShip = numberBulkShip;
    }
    public void setNumberLiquidShip(Vector<Integer> numberLiquidShip) {
        this.numberLiquidShip = numberLiquidShip;
    }
    public void setNumberContainerShip(Vector<Integer> numberContainerShip) {
        this.numberContainerShip = numberContainerShip;
    }
    public void setCostBulk(Vector<Integer> costBulk) {
        this.costBulk = costBulk;
    }
    public void setCostLiquid(Vector<Integer> costLiquid) {
        this.costLiquid = costLiquid;
    }
    public void setCostContainer(Vector<Integer> costContainer) {
        this.costContainer = costContainer;
    }
    public void setAverageDelay(Vector<Time> averageDelay) {
        this.averageDelay = averageDelay;
    }
    public void setAverageLengthUnloadingQueue(Vector<Integer> averageLengthUnloadingQueue) {
        this.averageLengthUnloadingQueue = averageLengthUnloadingQueue;
    }
    public void setAverageWaitingTimeInQueue(Vector<Time> averageWaitingTimeInQueue) {
        this.averageWaitingTimeInQueue = averageWaitingTimeInQueue;
    }
    public void setMaxDelay(Vector<Time> maxDelay) {
        this.maxDelay = maxDelay;
    }
    public void setTotalCost(Vector<Integer> totalCost) {
        this.totalCost = totalCost;
    }
    public void setTotalNumberShipsUnloaded(Vector<Integer> totalNumberShipsUnloaded) {
        this.totalNumberShipsUnloaded = totalNumberShipsUnloaded;
    }
    public void setNumberBulkCrane(Vector<Integer> numberBulkCrane) {
        this.numberBulkCrane = numberBulkCrane;
    }
    public void setNumberContainerCrane(Vector<Integer> numberContainerCrane) {
        this.numberContainerCrane = numberContainerCrane;
    }
    public void setNumberLiquidCrane(Vector<Integer> numberLiquidCrane) {
        this.numberLiquidCrane = numberLiquidCrane;
    }

    //!!!!!!!!!!!!!!!!!

    public void addAverageDelay(Time averageDelay) {
        this.averageDelay.add(averageDelay);
    }
    public void addAverageLengthUnloadingQueue(int averageLengthUnloadingQueue) {
        this.averageLengthUnloadingQueue.add(averageLengthUnloadingQueue);
    }
    public void addAverageWaitingTimeInQueue(Time averageWaitingTimeInQueue) {
        this.averageWaitingTimeInQueue.add(averageWaitingTimeInQueue);
    }
    public void addMaxDelay(Time maxDelay) {
        this.maxDelay.add(maxDelay);
    }
    public void addTotalCost(int totalCost) {
        this.totalCost.add(totalCost);
    }
    public void addTotalNumberShipsUnloaded(int totalNumberShipsUnloaded) {
        this.totalNumberShipsUnloaded.add(totalNumberShipsUnloaded);
    }
    public void addNumberBulkCrane(int numberBulkCrane) {
        this.numberBulkCrane.add(numberBulkCrane);
    }
    public void addNumberContainerCrane(int numberContainerCrane) {
        this.numberContainerCrane.add(numberContainerCrane);
    }
    public void addNumberLiquidCrane(int numberLiquidCrane) {
        this.numberLiquidCrane.add(numberLiquidCrane);
    }

    public void addCostBulk(int costBulk) {
        this.costBulk.add(costBulk);
    }

    public void addCostLiquid(int costLiquid) {
        this.costLiquid.add(costLiquid);
    }

    public void addCostContainer(int costContainer) {
        this.costContainer.add(costContainer);
    }

    public void addNumberBulkShip(int numberBulkShip) {
        this.numberBulkShip.add(numberBulkShip);
    }

    public void addNumberLiquidShip(int numberLiquidShip) {
        this.numberLiquidShip.add(numberLiquidShip);
    }

    public void addNumberContainerShip(int numberContainerShip) {
        this.numberContainerShip.add(numberContainerShip);
    }

    public static void saveResults(ProcessingResult result, String nameFile) throws IOException {
        if (result.totalNumberShipsUnloaded.size() == 0) return;
        int index = 0;
        int mimCost = Integer.MAX_VALUE;
        for (int i = 0; i < result.totalCost.size(); ++i) {
            if (result.totalCost.elementAt(i) < mimCost) {
                mimCost = result.totalCost.elementAt(i);
                index = i;
            }
        }
        Vector<ProcessingResult> res = new Vector<>();
        ProcessingResult minRes = new ProcessingResult();
        ProcessingResult optimalRes = new ProcessingResult();

        minRes.totalCost.add(result.totalCost.elementAt(index));
        minRes.costBulk.add(result.costBulk.elementAt(index));
        minRes.costLiquid.add(result.costLiquid.elementAt(index));
        minRes.costContainer.add(result.costContainer.elementAt(index));
        minRes.numberContainerCrane.add(result.numberContainerCrane.elementAt(index));
        minRes.numberBulkCrane.add(result.numberBulkCrane.elementAt(index));
        minRes.numberLiquidCrane.add(result.numberLiquidCrane.elementAt(index));
        minRes.numberBulkShip.add(result.numberBulkShip.elementAt(index));
        minRes.numberLiquidShip.add(result.numberLiquidShip.elementAt(index));
        minRes.numberContainerShip.add(result.numberContainerShip.elementAt(index));
        minRes.maxDelay.add(result.maxDelay.elementAt(index));
        minRes.averageDelay.add(result.averageDelay.elementAt(index));
        minRes.averageWaitingTimeInQueue.add(result.averageWaitingTimeInQueue.elementAt(index));
        minRes.averageLengthUnloadingQueue.add(result.averageLengthUnloadingQueue.elementAt(index));
        minRes.totalNumberShipsUnloaded.add(result.totalNumberShipsUnloaded.elementAt(index));

        optimalRes.totalCost.add(result.totalCost.elementAt(result.totalCost.size() - 1));
        optimalRes.costBulk.add(result.costBulk.elementAt(result.totalCost.size() - 1));
        optimalRes.costLiquid.add(result.costLiquid.elementAt(result.totalCost.size() - 1));
        optimalRes.costContainer.add(result.costContainer.elementAt(result.totalCost.size() - 1));
        optimalRes.numberContainerCrane.add(result.numberContainerCrane.elementAt(result.numberContainerCrane.size() - 1));
        optimalRes.numberBulkCrane.add(result.numberBulkCrane.elementAt(result.numberBulkCrane.size() - 1));
        optimalRes.numberLiquidCrane.add(result.numberLiquidCrane.elementAt(result.numberLiquidCrane.size() - 1));
        optimalRes.numberBulkShip.add(result.numberBulkShip.elementAt(result.numberBulkShip.size() - 1));
        optimalRes.numberLiquidShip.add(result.numberLiquidShip.elementAt(result.numberLiquidShip.size() - 1));
        optimalRes.numberContainerShip.add(result.numberContainerShip.elementAt(result.numberContainerShip.size() - 1));
        optimalRes.maxDelay.add(result.maxDelay.elementAt(result.maxDelay.size() - 1));
        optimalRes.averageDelay.add(result.averageDelay.elementAt(result.averageDelay.size() - 1));
        optimalRes.averageWaitingTimeInQueue.add(result.averageWaitingTimeInQueue.elementAt(result.averageWaitingTimeInQueue.size() - 1));
        optimalRes.averageLengthUnloadingQueue.add(result.averageLengthUnloadingQueue.elementAt(result.averageLengthUnloadingQueue.size() -1));
        optimalRes.totalNumberShipsUnloaded.add(result.totalNumberShipsUnloaded.elementAt(result.totalNumberShipsUnloaded.size() - 1));

        res.add(minRes);
        res.add(optimalRes);


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ow.writeValue(new File(nameFile), res);
    }

}
