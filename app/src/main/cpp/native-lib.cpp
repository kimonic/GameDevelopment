#include <jni.h>
#include <string>
extern "C"



JNIEXPORT jstring JNICALL
Java_kimonik_com_gamedevelopment_GuideActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "这是来自本地方法的内容!";
    return env->NewStringUTF(hello.c_str());
}
