package com.ipd.dsp.internal.w1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.w1.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38599a = "ZJWebClient";

    public static boolean a(Context context, Intent intent) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                if (!listQueryIntentActivities.isEmpty()) {
                    k.a(f38599a, "intent [" + intent + "] matched: " + listQueryIntentActivities.size());
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean b(String str) {
        k.a(f38599a, "shouldOverrideUrlLoading: " + str);
        if (str.startsWith("https://") || str.startsWith("http://")) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            if (!a(com.ipd.dsp.internal.l1.a.a().getContext(), intent)) {
                return true;
            }
            com.ipd.dsp.internal.l1.a.a().getContext().startActivity(intent);
            return true;
        } catch (Throwable th) {
            r.a(th);
            return true;
        }
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

    public static void a(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            intent.setComponent(null);
            intent.setSelector(null);
            Context context = com.ipd.dsp.internal.l1.a.a().getContext();
            if (a(context, intent)) {
                context.startActivity(intent);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.lta
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a();
                    }
                });
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static /* synthetic */ void a() {
        try {
            Context context = com.ipd.dsp.internal.l1.a.a().getContext();
            if (context != null) {
                Toast.makeText(context, "拉起第三方浏览器失败", 0).show();
            }
        } catch (Throwable unused) {
        }
    }
}
