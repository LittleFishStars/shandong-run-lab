package com.zj.adlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fx7 {
    public fx7() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void A(@NonNull Activity activity) {
        boolean zP = p(activity);
        Window window = activity.getWindow();
        if (zP) {
            window.clearFlags(1024);
        } else {
            window.addFlags(1024);
        }
    }

    public static int c() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static float d() {
        return ((WindowManager) Utils.a().getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    public static int e() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static float f() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int g() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    public static int h() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int i(@NonNull Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int j() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static float k() {
        return Resources.getSystem().getDisplayMetrics().xdpi;
    }

    public static float l() {
        return Resources.getSystem().getDisplayMetrics().ydpi;
    }

    public static int m() {
        try {
            return Settings.System.getInt(Utils.a().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return -123;
        }
    }

    public static boolean p(@NonNull Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean q() {
        return Utils.a().getResources().getConfiguration().orientation == 2;
    }

    public static boolean r() {
        return Utils.a().getResources().getConfiguration().orientation == 1;
    }

    public static boolean s() {
        KeyguardManager keyguardManager = (KeyguardManager) Utils.a().getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static Bitmap t(@NonNull Activity activity) {
        return u(activity, false);
    }

    public static Bitmap u(@NonNull Activity activity, boolean z) {
        Bitmap bitmapE1 = i.e1(activity.getWindow().getDecorView());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        if (!z) {
            return Bitmap.createBitmap(bitmapE1, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int iD0 = i.d0();
        return Bitmap.createBitmap(bitmapE1, 0, iD0, displayMetrics.widthPixels, displayMetrics.heightPixels - iD0);
    }

    public static void v(@NonNull Activity activity) {
        activity.getWindow().addFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void w(@NonNull Activity activity) {
        activity.setRequestedOrientation(0);
    }

    public static void x(@NonNull Activity activity) {
        activity.getWindow().clearFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void y(@NonNull Activity activity) {
        activity.setRequestedOrientation(1);
    }

    @RequiresPermission(Permission.WRITE_SETTINGS)
    public static void z(int i) {
        Settings.System.putInt(Utils.a().getContentResolver(), "screen_off_timeout", i);
    }

    public int a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return j() - iArr[0];
    }

    public int b(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return h() - iArr[1];
    }

    public int n(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public int o(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }
}
