# JniPerformance

>Jni performance test

Using dense floating-point calculations to test the performance differences between Jni and pure java,
it is found that the computational performance is similar.

使用密集的浮点数计算来测试Jni和原生java之间的性能差别,发现计算性能两者类似

**JniMethod**
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

**Java Method**
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
