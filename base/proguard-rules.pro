# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#保持所有的AppCompatActivity的继承类不被混淆
-keep public class * extends androidx.appcompat.app.AppCompatActivity
#保持所有的Fragment的继承类不被混淆
-keep public class * extends androidx.fragment.app.Fragment
# 保持Parcelable不被混淆
-keep class * implements Android.os.Parcelable {
    public static final Android.os.Parcelable$Creator *;
}