package io.flutter.plugin.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface PluginRegistry {

    public interface ActivityResultListener {
        boolean onActivityResult(int i, int i2, @Nullable Intent intent);
    }

    public interface NewIntentListener {
        boolean onNewIntent(@NonNull Intent intent);
    }

    @Deprecated
    public interface PluginRegistrantCallback {
        void registerWith(@NonNull PluginRegistry pluginRegistry);
    }

    @Deprecated
    public interface Registrar {
        @NonNull
        Context activeContext();

        @Nullable
        Activity activity();

        @NonNull
        Registrar addActivityResultListener(@NonNull ActivityResultListener activityResultListener);

        @NonNull
        Registrar addNewIntentListener(@NonNull NewIntentListener newIntentListener);

        @NonNull
        Registrar addRequestPermissionsResultListener(@NonNull RequestPermissionsResultListener requestPermissionsResultListener);

        @NonNull
        Registrar addUserLeaveHintListener(@NonNull UserLeaveHintListener userLeaveHintListener);

        @NonNull
        Registrar addViewDestroyListener(@NonNull ViewDestroyListener viewDestroyListener);

        @NonNull
        Registrar addWindowFocusChangedListener(@NonNull WindowFocusChangedListener windowFocusChangedListener);

        @NonNull
        Context context();

        @NonNull
        String lookupKeyForAsset(@NonNull String str);

        @NonNull
        String lookupKeyForAsset(@NonNull String str, @NonNull String str2);

        @NonNull
        BinaryMessenger messenger();

        @NonNull
        PlatformViewRegistry platformViewRegistry();

        @NonNull
        Registrar publish(@Nullable Object obj);

        @NonNull
        TextureRegistry textures();

        @NonNull
        FlutterView view();
    }

    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    @Deprecated
    public interface ViewDestroyListener {
        boolean onViewDestroy(@NonNull FlutterNativeView flutterNativeView);
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(boolean z);
    }

    @Deprecated
    boolean hasPlugin(@NonNull String str);

    @NonNull
    @Deprecated
    Registrar registrarFor(@NonNull String str);

    @Nullable
    @Deprecated
    <T> T valuePublishedByPlugin(@NonNull String str);
}
