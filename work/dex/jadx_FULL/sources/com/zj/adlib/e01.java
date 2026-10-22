package com.zj.adlib;

import android.content.ContentResolver;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e01 {
    public e01() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int a() {
        try {
            return Settings.System.getInt(Utils.a().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(@NonNull Window window) {
        float f = window.getAttributes().screenBrightness;
        return f < 0.0f ? a() : (int) (f * 255.0f);
    }

    public static boolean c() {
        try {
            return Settings.System.getInt(Utils.a().getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean d(boolean z) {
        return Settings.System.putInt(Utils.a().getContentResolver(), "screen_brightness_mode", z ? 1 : 0);
    }

    public static boolean e(@IntRange(from = 0, to = 255) int i) {
        ContentResolver contentResolver = Utils.a().getContentResolver();
        boolean zPutInt = Settings.System.putInt(contentResolver, "screen_brightness", i);
        contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
        return zPutInt;
    }

    public static void f(@NonNull Window window, @IntRange(from = 0, to = 255) int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = i / 255.0f;
        window.setAttributes(attributes);
    }
}
