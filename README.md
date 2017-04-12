# JniPerformance

>Compare jni and java performance on the Android platform.

Using dense floating-point calculations to test the performance differences between Jni and pure java,
it is found that the computational performance is similar.

This test is **one-sided**, but the comparison of Jni and Java in the dense computing gap, in fact, Java than C / C + + have more run-time checks, such as "multi-state". These run-time check is the main reason for the performance gap , In normal circumstances C than Java run-time performance of about 70% higher.


使用密集的浮点数计算来测试Jni和原生java之间的性能差别,发现计算性能两者类似.

这个测试是片面的,只是比较Jni和Java在密集运算上的差距,实际上Java比C/C++有更多的运行时检查,比如"多态". 这些运行时检查是造成性能差距的主要原因,在正常情况下C比Java的运行时性能高70%左右.

**JniMethod:**
```
JNIEXPORT jdouble JNICALL Java_ytr_jniperformance_JniWrapper_calculationTask
        (JNIEnv *env, jclass clazz, jint loop_count) {
    int i;
    double circle = 1;
    //Floating point operations are time consuming and loop the largest number of integers.
    for (i = 0; i < loop_count; i++) {
        circle *= 3.1415962;
    }
    return circle;
}
```

**Java Method:**
```
 private static double calculationTask(int loop_count) {
        int i;
        double circle = 1;
        //Floating point operations are time consuming and loop the largest number of integers.
        for (i = 0; i < loop_count; i++) {
            circle *= 3.1415962;
        }
        return circle;
    }

```

**Screenshot:**

![img](https://github.com/yangtianrui95/JniPerformance/blob/master/jni_pref.png)
-----
