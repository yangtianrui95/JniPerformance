LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jni_pref
LOCAL_SRC_FILES := JniWrapper.c

include $(BUILD_SHARED_LIBRARY)