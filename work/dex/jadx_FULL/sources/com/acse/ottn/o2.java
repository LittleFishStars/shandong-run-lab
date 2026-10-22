package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23120a = "MeizuUtils";

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void a(AppCompatActivity appCompatActivity, int i) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra(ALPParamConstant.PACKAGENAME, appCompatActivity.getPackageName());
            intent.setFlags(268435456);
            appCompatActivity.startActivityForResult(intent, i);
        } catch (Exception e) {
            try {
                h2.b(f23120a, "获取悬浮窗权限, 打开AppSecActivity失败, " + Log.getStackTraceString(e));
                i1.e(appCompatActivity, i);
            } catch (Exception e2) {
                h2.b(f23120a, "获取悬浮窗权限失败, 通用获取方法失败, " + Log.getStackTraceString(e2));
            }
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e) {
            h2.b(f23120a, Log.getStackTraceString(e));
            return false;
        }
    }
}
