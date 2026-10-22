package cn.hzjizhun.admin.http.net;

import android.util.Log;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyHttpUtils {
    private static final String TAG = "EasyHttpUtils";
    public static boolean sisOpen = false;

    public static void d(String str) {
        if (sisOpen) {
            Log.d(TAG, c49.f40900a + str);
        }
    }

    public static void e(String str) {
        if (sisOpen) {
            Log.e(TAG, c49.f40900a + str);
        }
    }
}
