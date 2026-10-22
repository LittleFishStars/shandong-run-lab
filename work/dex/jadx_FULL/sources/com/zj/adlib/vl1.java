package com.zj.adlib;

import android.app.ActivityManager;
import android.os.Environment;
import androidx.annotation.RequiresApi;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.byazt.hv.TTDownloadField;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class vl1 {
    public vl1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @RequiresApi(api = 19)
    public static void a() {
        ((ActivityManager) Utils.a().getSystemService(TTDownloadField.TT_ACTIVITY)).clearApplicationUserData();
    }

    public static boolean b(String str) {
        return i.t(i.O(str));
    }

    public static boolean c() {
        return "mounted".equals(Environment.getExternalStorageState()) && i.t(Utils.a().getExternalCacheDir());
    }

    public static boolean d() {
        return i.t(Utils.a().getCacheDir());
    }

    public static boolean e(String str) {
        return Utils.a().deleteDatabase(str);
    }

    public static boolean f() {
        return i.t(new File(Utils.a().getFilesDir().getParent(), "databases"));
    }

    public static boolean g() {
        return i.t(Utils.a().getFilesDir());
    }

    public static boolean h() {
        return i.t(new File(Utils.a().getFilesDir().getParent(), "shared_prefs"));
    }
}
