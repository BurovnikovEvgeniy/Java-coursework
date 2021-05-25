package service.three;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Configuration;
import common.Ship;
import common.Time;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class ProcessingResult {
    private Vector<Integer> totalNumberShipsUnloaded;
    private Vector<Integer> averageLengthUnloadingQueue;
    private Vector<Time> averageWaitingTimeInQueue;
    private Vector<Time> averageDelay;
    private Vector<Time> maxDelay;
    private Vector<Integer> totalCost;
    private Vector<Integer> unloadedBulkShip;
    private Vector<Integer> unloadedLiquidShip;
    private Vector<Integer> unloadedContainerShip;

    ProcessingResult()
    {
        totalNumberShipsUnloaded = new Vector<>();
        averageLengthUnloadingQueue = new Vector<>();
        averageDelay = new Vector<>();
        averageWaitingTimeInQueue = new Vector<>();
        maxDelay = new Vector<>();
        totalCost = new Vector<>();
        unloadedBulkShip = new Vector<>();
        unloadedLiquidShip = new Vector<>();
        unloadedContainerShip = new Vector<>();
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
    public Vector<Integer> getUnloadedBulkShip() {
        return unloadedBulkShip;
    }
    public Vector<Integer> getUnloadedContainerShip() {
        return unloadedContainerShip;
    }
    public Vector<Integer> getUnloadedLiquidShip() {
        return unloadedLiquidShip;
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
    public void setUnloadedBulkShip(Vector<Integer> unloadedBulkShip) {
        this.unloadedBulkShip = unloadedBulkShip;
    }
    public void setUnloadedContainerShip(Vector<Integer> unloadedContainerShip) {
        this.unloadedContainerShip = unloadedContainerShip;
    }
    public void setUnloadedLiquidShip(Vector<Integer> unloadedLiquidShip) {
        this.unloadedLiquidShip = unloadedLiquidShip;
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
    public void addUnloadedBulkShip(int unloadedBulkShip) {
        this.unloadedBulkShip.add(unloadedBulkShip);
    }
    public void addUnloadedContainerShip(int unloadedContainerShip) {
        this.unloadedContainerShip.add(unloadedContainerShip);
    }
    public void addUnloadedLiquidShip(int unloadedLiquidShip) {
        this.unloadedLiquidShip.add(unloadedLiquidShip);
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
        minRes.unloadedContainerShip.add(result.unloadedContainerShip.elementAt(index));
        minRes.unloadedBulkShip.add(result.unloadedBulkShip.elementAt(index));
        minRes.unloadedLiquidShip.add(result.unloadedLiquidShip.elementAt(index));
        minRes.maxDelay.add(result.maxDelay.elementAt(index));
        minRes.averageDelay.add(result.averageDelay.elementAt(index));
        minRes.averageWaitingTimeInQueue.add(result.averageWaitingTimeInQueue.elementAt(index));
        minRes.averageLengthUnloadingQueue.add(result.averageLengthUnloadingQueue.elementAt(index));
        minRes.totalNumberShipsUnloaded.add(result.totalNumberShipsUnloaded.elementAt(index));

        optimalRes.totalCost.add(result.totalCost.elementAt(result.totalCost.size() - 1));
        optimalRes.unloadedContainerShip.add(result.unloadedContainerShip.elementAt(result.unloadedContainerShip.size() - 1));
        optimalRes.unloadedBulkShip.add(result.unloadedBulkShip.elementAt(result.unloadedBulkShip.size() - 1));
        optimalRes.unloadedLiquidShip.add(result.unloadedLiquidShip.elementAt(result.unloadedLiquidShip.size() - 1));
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
