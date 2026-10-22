package com.ipd.dsp.internal.c2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Pair;
import android.widget.Toast;
import com.ipd.dsp.internal.c2.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38232a = "IPDWebView";

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities.isEmpty()) {
                return false;
            }
            k.a("IPDWebView", "intent [" + intent + "] matched: " + listQueryIntentActivities.size());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, String str) {
        k.a("IPDWebView", "shouldOverrideUrlLoading: " + str);
        if (activity.isFinishing()) {
            return true;
        }
        if (str.startsWith("alipay")) {
            a(activity, str, "未检测到支付宝客户端，请安装后重试");
            return true;
        }
        if (str.startsWith("weixin:")) {
            a(activity, str, "未检测到微信客户端，请安装后重试");
            return true;
        }
        if (str.startsWith("https://") || str.startsWith("http://")) {
            return false;
        }
        a(activity, str, null);
        return true;
    }

    public static void a(final Activity activity, String str, String str2) {
        try {
            final Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            intent.setFlags(268435456);
            if (a((Context) activity, intent)) {
                Runnable runnable = new Runnable() { // from class: com.zj.adlib.crb
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a(activity, intent);
                    }
                };
                Pair<String, Boolean> pair = com.ipd.dsp.internal.z0.a.p;
                if (pair != null && pair.second == Boolean.TRUE) {
                    new com.ipd.dsp.internal.s1.f(activity, runnable, null).b();
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
        } catch (Throwable th) {
            r.a(th);
        }
        if (str2 != null) {
            new AlertDialog.Builder(activity).setMessage(str2).setNegativeButton("返回", (DialogInterface.OnClickListener) null).show();
        }
    }

    public static /* synthetic */ void a(Activity activity, Intent intent) {
        com.ipd.dsp.internal.z0.a.p = new Pair<>((String) com.ipd.dsp.internal.z0.a.p.first, null);
        activity.startActivity(intent);
    }

    public static String a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                sb.append(new String(bArr, 0, i));
            } else {
                return sb.toString();
            }
        }
    }

    public static void a(final Activity activity, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268435456);
            Uri uri = Uri.parse(str);
            intent.setComponent(null);
            intent.setSelector(null);
            intent.setData(uri);
            if (a((Context) activity, intent)) {
                activity.startActivity(intent);
            } else {
                if (activity.isFinishing()) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.arb
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(activity, "拉起第三方浏览器失败", 0).show();
                    }
                });
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }
}
