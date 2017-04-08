package ytr.jniperformance;

/**
 * Created by ytr on 17-4-8.
 * <p>
 * We use floating-point operations to determine the performance of Jni,
 * this is a time-consuming operation in the computer.
 */

public class JniWrapper {

    static {
        System.loadLibrary("jni_pref");
    }

    /**
     * mock a time-consuming task.
     */
    native public static double calculationTask(int loopCount);
}
