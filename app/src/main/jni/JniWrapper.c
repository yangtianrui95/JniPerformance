#include "ytr_jniperformance_JniWrapper.h"
#include <stdio.h>

/*
 * Class:     ytr_jniperformance_JniWrapper
 * Method:    calculationTask
 * Signature: (I)V
 */
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