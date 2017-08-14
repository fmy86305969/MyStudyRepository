#include <stdio.h>
#include <stdlib.h>
#include "com_example_fmy_framestudyapplication_HellowJni.h"

JNIEXPORT jstring JNICALL Java_com_example_fmy_framestudyapplication_HellowJni_getStrFromJNI
  (JNIEnv *env, jclass jclass){

    return (*env)->NewStringUTF(env,"hellow from jni");
  }


JNIEXPORT jstring JNICALL Java_com_example_fmy_framestudyapplication_HellowJni_getAdd
  (JNIEnv *env, jclass jclass, jint a, jint b){
    jint c = a+b;
    char buf[64]; // assumed large enough to cope with result
    sprintf(buf, "%d", c);  // error checking omitted
    return (*env)->NewStringUTF(env, buf);
  }