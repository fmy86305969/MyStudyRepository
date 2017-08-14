LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= fmy
LOCAL_SRC_FILES:= demo.c

include $(BUILD_SHARED_LIBRARY)
