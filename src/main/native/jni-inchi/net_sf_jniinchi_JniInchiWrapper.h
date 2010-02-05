/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class net_sf_jniinchi_JniInchiWrapper */

#ifndef _Included_net_sf_jniinchi_JniInchiWrapper
#define _Included_net_sf_jniinchi_JniInchiWrapper
#ifdef __cplusplus
extern "C" {
#endif
#undef net_sf_jniinchi_JniInchiWrapper_MAX_LOCK_TIMEOUT
#define net_sf_jniinchi_JniInchiWrapper_MAX_LOCK_TIMEOUT 15L
/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    LibInchiGetVersion
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_sf_jniinchi_JniInchiWrapper_LibInchiGetVersion
  (JNIEnv *, jclass);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_net_sf_jniinchi_JniInchiWrapper_init
  (JNIEnv *, jobject);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    GetINCHI
 * Signature: (Lnet/sf/jniinchi/JniInchiInput;)Lnet/sf/jniinchi/JniInchiOutput;
 */
JNIEXPORT jobject JNICALL Java_net_sf_jniinchi_JniInchiWrapper_GetINCHI
  (JNIEnv *, jobject, jobject);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    GetINCHIfromINCHI
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Lnet/sf/jniinchi/JniInchiOutput;
 */
JNIEXPORT jobject JNICALL Java_net_sf_jniinchi_JniInchiWrapper_GetINCHIfromINCHI
  (JNIEnv *, jobject, jstring, jstring);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    GetStructFromINCHI
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Lnet/sf/jniinchi/JniInchiOutputStructure;
 */
JNIEXPORT jobject JNICALL Java_net_sf_jniinchi_JniInchiWrapper_GetStructFromINCHI
  (JNIEnv *, jobject, jstring, jstring);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    GetINCHIKeyFromINCHI
 * Signature: (Ljava/lang/String;)Lnet/sf/jniinchi/JniInchiOutputKey;
 */
JNIEXPORT jobject JNICALL Java_net_sf_jniinchi_JniInchiWrapper_GetINCHIKeyFromINCHI
  (JNIEnv *, jobject, jstring);

/*
 * Class:     net_sf_jniinchi_JniInchiWrapper
 * Method:    CheckINCHIKey
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_net_sf_jniinchi_JniInchiWrapper_CheckINCHIKey
  (JNIEnv *, jobject, jstring);

#ifdef __cplusplus
}
#endif
#endif
