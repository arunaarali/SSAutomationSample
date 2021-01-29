package stoic_studio.utility;

public final class WaitUtility {

    /**
     * Method waits util the expected condition is set true else wait till the end of wait time to exit the
     *
     * @param condition   method
     * @param maxWaitTime in seconds.
     * @return
     */
    public static boolean waitUntil(WaitUtility.CheckCondition condition, int maxWaitTime) {
        long waitUntilTime = System.currentTimeMillis() + (long) (maxWaitTime * 1000);
        while (!condition.test()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
            if (System.currentTimeMillis() > waitUntilTime) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sample thread time sleep
     *
     * @param maxWaitTime in seconds.
     */
    public static void sleep(int maxWaitTime) {
        long waitUntilTime = System.currentTimeMillis() + (long) (maxWaitTime * 1000);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
        }
        while (System.currentTimeMillis() <= waitUntilTime) ;
    }

    /**
     * Interface running a boolean method, which will be used in WaitUtility class.
     */
    public interface CheckCondition {
        boolean test();
    }
}
