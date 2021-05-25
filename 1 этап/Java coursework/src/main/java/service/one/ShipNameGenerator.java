package service.one;

import java.util.Random;

public class ShipNameGenerator {
    private static Random r = new Random();

    public static String generateRandomName(int sizeName)
    {
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < sizeName; ++i)
        {
            name.insert(0, (char)(65 + r.nextInt(26) + r.nextInt(2) * (7 + r.nextInt(26))));
        }
        return new String(name);
    }
}
