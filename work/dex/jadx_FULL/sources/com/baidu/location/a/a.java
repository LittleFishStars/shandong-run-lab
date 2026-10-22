package com.baidu.location.a;

import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements LBSAuthManagerListener {
    private static Object b = new Object();
    private static a c;
    private int d = 0;
    private Context e = null;
    private long f = 0;
    private String g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26329a = 0;

    public static a a() {
        a aVar;
        synchronized (b) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public static String b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        this.e = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.f = System.currentTimeMillis();
    }

    public void a(Context context, String str) {
        LBSAuthManager.getInstance(context).setKey(str);
    }

    public String b() {
        return this.g;
    }

    public boolean c() {
        int i = this.d;
        boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
        if (this.e != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f;
            if (!z ? jCurrentTimeMillis < 0 || jCurrentTimeMillis > 10000 : jCurrentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
                this.f = System.currentTimeMillis();
            }
        }
        return z;
    }

    public synchronized void d() {
        try {
            wait(150L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void e() {
        notifyAll();
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        this.d = i;
        e();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token") && jSONObject.getString("token") != null) {
                    this.g = jSONObject.getString("token");
                }
                if (!jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                    return;
                }
                this.f26329a = jSONObject.getInt("ak_permission");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
