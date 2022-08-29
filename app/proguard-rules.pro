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
-keep class com.statusmaker_photoeditor_music.videoplayer.photo_ed.activities.EditImageActivity{*;}
-keep class org.wysaid.nativePort.** { *; }

-keep class com.arthenica.mobileffmpeg.Config {
    native <methods>;
    void log(long, int, byte[]);
    void statistics(long, int, float, float, long , int, double, double);
}

-keep class com.arthenica.mobileffmpeg.AbiDetect {
    native <methods>;
}

-keep class com.firebase.** { *; }
-keepattributes *Annotation*
-keepattributes Signature

-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.InstagramActivity { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.adapter.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.api.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.interfaces.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.model.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.model.story.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.model.story.TrayModel { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.statussaver.util.** { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.MainActivity { *; }
-keep class com.statusmaker_photoeditor_music.videoplayer.CustomStyledPlayerView { *; }