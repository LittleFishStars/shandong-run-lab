package com.byazt.la;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.gr;
import com.byazt.aas.my;
import com.byazt.ete.yf;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 719, 20})
public class c {
    public static final c c = new c();
    public int[] i;
    public yf sp;
    public boolean x;
    public String tt = "";
    public String ve = "";
    public String uj = "";
    public String n = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f28767a = new JSONArray();

    private c() {
    }

    public static c c() {
        return c;
    }

    private String tt() {
        String strVe = my.ve();
        this.tt = strVe;
        return strVe;
    }

    private Long uj() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.n = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private Long ve() {
        Long lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.ve = lValueOf.toString();
        return lValueOf;
    }

    private ActivityManager.MemoryInfo tt(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.uj = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    public void c(Context context) {
        if (!gt.tt().rl()) {
            this.x = false;
            return;
        }
        if (this.x) {
            return;
        }
        try {
            tt();
            uj();
            ve();
            tt(context);
            ve(context);
            this.sp = gr.sl();
            this.x = true;
        } catch (Exception e) {
            m.c(e);
        }
    }

    private JSONArray ve(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put("com.ss.android.ugc.aweme", "a");
            map.put("com.ss.android.ugc.aweme.lite", bolts.c.c);
            map.put("com.dragon.read", "r");
            map.put("com.ss.android.article.news", "n");
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.f28767a = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    public void c(yf yfVar) {
        this.sp = yfVar;
    }

    public void c(int[] iArr) {
        this.i = iArr;
    }

    public void c(JSONObject jSONObject) {
        if (gt.tt().rl()) {
            try {
                yf yfVar = this.sp;
                if (yfVar != null) {
                    JSONObject jSONObjectVe = yfVar.ve();
                    jSONObjectVe.put("sl", 0);
                    jSONObject.put("u_t", jSONObjectVe);
                }
                jSONObject.put("boot_time_sec", this.n);
                jSONObject.put("memory", this.uj);
                jSONObject.put("disk", this.ve);
                jSONObject.put("client_tun", this.tt);
                jSONObject.put("pkg_info", this.f28767a);
                int[] iArr = this.i;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
    }
}
