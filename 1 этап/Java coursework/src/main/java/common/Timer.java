package common;

import java.util.Vector;

public class Timer implements Runnable {
    public int commonTime;
    private boolean peek;
    private long counterShipInQueue;
    Vector<Ship> ships;

    public Timer(Vector<Ship> ships)
    {
        this.counterShipInQueue = 0;
        this.ships = ships;
        this.commonTime = 0;
        this.peek = false;
    }

    public int getCommonTime() {
        return commonTime;
    }

    public int getTotalAverageQueueLength()
    {
        return (int)(Math.ceil((double)counterShipInQueue / commonTime));
    }


    public boolean getPeek()
    {
        return peek;
    }
    @Override
    public void run() {
        if (!peek)
            this.commonTime++;
            for (Ship s: ships)
            {
                if (s.arrivalTime.getTime() <= commonTime && s.getShipDelayOnCrane().getTime() == 0)
                {
                    ++counterShipInQueue;
                }
            }
        if (this.commonTime >= Configuration.numberSimulationDays * 24 * 60) peek = true;
    }
}
