# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\Android\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#腾讯bugly第三库追踪 bug
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

#友盟统计
-keepclassmembers class * {
public<init> (org.json.JSONObject);
}
-keep public class [com.example.liujianhui.gohappy].R$*{
public static final int *;
}
#对于Android版本大于5.0
-keepclassmembers enum * {
publicstatic **[] values();
publicstatic ** valueOf(java.lang.String);
}


