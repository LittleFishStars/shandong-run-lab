package cj.mobile.wm;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v0 implements c1 {
    public static volatile v0 dexl;
    public final t0 dexa;
    public SharedPreferences dexb;
    public com.wangmai.insightvision.openadsdk.download.h dexd;
    public w0 dexc = null;
    public long dexe = 0;
    public final List<u0> dexf = new Vector();
    public final Vector<Pair<String, b1>> dexg = new Vector<>();
    public final Vector<b1> dexh = new Vector<>();
    public final ConcurrentHashMap<String, Notification.Builder> dexi = new ConcurrentHashMap<>();
    public final Set<u0> dexj = Collections.synchronizedSet(new HashSet());
    public final b1 dexk = new dexb();

    public class dexa implements o9.dexc {
        public dexa() {
        }

        @Override // cj.mobile.wm.o9.dexc
        public void a(int i) {
            f1.dexa("DownloadTaskManager", "onNetworkChanged: networkType = " + i);
            if (i == -1 || v0.this.dexj.isEmpty()) {
                return;
            }
            Iterator it = v0.this.dexj.iterator();
            while (it.hasNext()) {
                ((u0) it.next()).dexm();
            }
            v0.this.dexj.clear();
        }
    }

    public class dexb implements b1 {

        public class dexa implements Runnable {
            public final /* synthetic */ r0 dexa;
            public final /* synthetic */ Notification.Builder dexb;

            public dexa(r0 r0Var, Notification.Builder builder) {
                this.dexa = r0Var;
                this.dexb = builder;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.dexb.setProgress(0, 0, false).setContentText("下载完成").setContentIntent(PendingIntent.getActivity(InsightProxy.getApplication(), 0, he.dexb(InsightProxy.getApplication(), this.dexa.dexa() + File.separator + this.dexa.dexg()), 201326592)).setAutoCancel(true);
                v0.this.dexa(this.dexa.dexf().hashCode(), this.dexb.build());
            }
        }

        public dexb() {
        }

        private boolean dexa(r0 r0Var, Pair<String, b1> pair) {
            Object obj;
            return (r0Var == null || pair == null || (obj = pair.first) == null || pair.second == null || !ke.dexa((String) obj).equals(r0Var.dexf())) ? false : true;
        }

        @Override // cj.mobile.wm.b1
        public void dexa(r0 r0Var) {
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadCancel: " + r0Var);
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexa(r0Var);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexa(r0Var);
                }
            }
            if (((Notification.Builder) v0.this.dexi.get(r0Var.dexf())) != null) {
                v0.this.dexa(r0Var.dexf().hashCode());
            }
            v0.this.dexa("downloadCancel", r0Var, (HashMap<String, String>) null);
        }

        @Override // cj.mobile.wm.b1
        public void dexa(r0 r0Var, int i, String str) {
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadError: " + r0Var + ", code " + i + ", msg = " + str);
            if (!o9.dexc().dexa() && v0.this.dexc.a(i)) {
                u0 u0VarDexa = v0.this.dexa(r0Var);
                if (u0VarDexa != null) {
                    v0.this.dexj.add(u0VarDexa);
                    return;
                }
                return;
            }
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexa(r0Var, i, str);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexa(r0Var, i, str);
                }
            }
            if (((Notification.Builder) v0.this.dexi.get(r0Var.dexf())) != null) {
                v0.this.dexa(r0Var.dexf().hashCode());
            }
            HashMap map = new HashMap();
            map.put("code", String.valueOf(i));
            map.put("msg", String.valueOf(str));
            v0.this.dexa("downloadFailed", r0Var, (HashMap<String, String>) map);
        }

        @Override // cj.mobile.wm.b1
        public void dexa(r0 r0Var, long j, long j2) {
            Object obj;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - v0.this.dexe < 300) {
                return;
            }
            v0.this.dexe = jCurrentTimeMillis;
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexa(r0Var, j, j2);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexa(r0Var, j, j2);
                }
            }
            Notification.Builder builder = (Notification.Builder) v0.this.dexi.get(r0Var.dexf());
            if (builder != null) {
                int i = (int) ((j * 100) / j2);
                builder.setProgress(100, i, false).setContentText("已下载 " + i + "%");
                v0.this.dexa(r0Var.dexf().hashCode(), builder.build());
            }
        }

        @Override // cj.mobile.wm.b1
        public void dexa(r0 r0Var, boolean z) {
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadPause: " + z);
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexa(r0Var, z);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexa(r0Var, z);
                }
            }
            v0.this.dexa("downloadPause", r0Var, (HashMap<String, String>) null);
        }

        @Override // cj.mobile.wm.b1
        public void dexa(r0 r0Var, boolean z, long j, String str) {
            String strValueOf;
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadFinish: " + r0Var + ", fromCache = " + z + ", elapsed = " + j + ", " + str);
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexa(r0Var, z, j, str);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexa(r0Var, z, j, str);
                }
            }
            Notification.Builder builder = (Notification.Builder) v0.this.dexi.get(r0Var.dexf());
            if (builder != null) {
                InsightProxy.getInstance().getThreadPoolProxy().dexa("", new dexa(r0Var, builder));
            }
            HashMap map = new HashMap();
            long jDexi = r0Var.dexi();
            if (jDexi <= 0) {
                if (r0Var.dexb() > 0 && j > 0) {
                    strValueOf = String.valueOf(((r0Var.dexb() * 1.0f) / 1024.0f) / ((j * 1.0f) / 1000.0f));
                }
                v0.this.dexa("downloadFinish", r0Var, (HashMap<String, String>) map);
            }
            strValueOf = String.valueOf(jDexi);
            map.put("downloadSpeed", strValueOf);
            v0.this.dexa("downloadFinish", r0Var, (HashMap<String, String>) map);
        }

        @Override // cj.mobile.wm.b1
        public void dexb(r0 r0Var) {
            Object obj;
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexb(r0Var);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexb(r0Var);
                }
            }
            if (((Notification.Builder) v0.this.dexi.get(r0Var.dexf())) != null) {
                v0.this.dexa(r0Var.dexf().hashCode());
            }
            v0.this.dexa("downloadInstalled", r0Var, (HashMap<String, String>) null);
        }

        @Override // cj.mobile.wm.b1
        public void dexc(r0 r0Var) {
            Object obj;
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexc(r0Var);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexc(r0Var);
                }
            }
            v0.this.dexa("downloadInstallStart", r0Var, (HashMap<String, String>) null);
        }

        @Override // cj.mobile.wm.b1
        public void dexd(r0 r0Var) {
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadStart: " + r0Var);
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexd(r0Var);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexd(r0Var);
                }
            }
            Notification.Builder builder = (Notification.Builder) v0.this.dexi.get(r0Var.dexf());
            if (builder != null) {
                builder.setProgress(0, 0, true);
                v0.this.dexa(r0Var.dexf().hashCode(), builder.build());
            }
            v0.this.dexa("downloadStart", r0Var, (HashMap<String, String>) null);
        }

        @Override // cj.mobile.wm.b1
        public void dexe(r0 r0Var) {
            Object obj;
            f1.dexa("DownloadTaskManager", "onDownloadTaskCreate: " + r0Var);
            Iterator it = v0.this.dexh.iterator();
            while (it.hasNext()) {
                ((b1) it.next()).dexe(r0Var);
            }
            for (Pair<String, b1> pair : v0.this.dexg) {
                if (dexa(r0Var, pair) && (obj = pair.second) != null) {
                    ((b1) obj).dexe(r0Var);
                }
            }
            v0.this.dexa("downloadCreate", r0Var, (HashMap<String, String>) null);
        }
    }

    public v0() {
        dexe();
        dexd();
        t0 t0VarDexa = t0.dexa();
        this.dexa = t0VarDexa;
        t0VarDexa.dexa(this);
        this.dexc.a(dexa());
        o9.dexc().dexa(new dexa());
    }

    private Context dexa() {
        return InsightProxy.getApplication();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u0 dexa(r0 r0Var) {
        if (r0Var == null) {
            return null;
        }
        for (u0 u0Var : this.dexf) {
            if (u0Var.dexb() == r0Var) {
                return u0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(int i) {
        try {
            ((NotificationManager) InsightProxy.getApplication().getSystemService("notification")).cancel(i);
        } catch (Exception e) {
            f1.dexb("DownloadTaskManager", "notifyNotification exception: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(int i, Notification notification) {
        try {
            ((NotificationManager) InsightProxy.getApplication().getSystemService("notification")).notify(i, notification);
        } catch (Exception e) {
            f1.dexb("DownloadTaskManager", "notifyNotification exception: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(String str, r0 r0Var, HashMap<String, String> map) {
        if (this.dexd == null) {
            return;
        }
        if ("downloadFinish".equals(str)) {
            h1.dexa().dexa(this.dexd.e());
        } else if ("downloadStart".equals(str)) {
            h1.dexa().dexb(this.dexd.c());
        }
    }

    public static boolean dexa(r0 r0Var, com.wangmai.insightvision.openadsdk.download.h hVar) {
        if (r0Var == null || hVar == null) {
            return false;
        }
        String packageName = hVar.getPackageName();
        String strDexa = ke.dexa(hVar.getDownloadUrl());
        if (TextUtils.equals(packageName, r0Var.dexh()) || TextUtils.equals(r0Var.dexe(), hVar.getDownloadUrl())) {
            return true;
        }
        return (TextUtils.isEmpty(strDexa) || r0Var.dexf() == null || !strDexa.contains(r0Var.dexf())) ? false : true;
    }

    private r0 dexb(com.wangmai.insightvision.openadsdk.download.f fVar) {
        r0 r0Var = new r0();
        com.wangmai.insightvision.openadsdk.download.h hVarD = fVar.d();
        r0Var.dexd(hVarD.getDownloadUrl());
        this.dexd = hVarD;
        return r0Var;
    }

    public static v0 dexb() {
        if (dexl == null) {
            synchronized (v0.class) {
                if (dexl == null) {
                    dexl = new v0();
                }
            }
        }
        return dexl;
    }

    private void dexb(String str, String str2, Bitmap bitmap) {
        try {
            String strDexa = ke.dexa(str);
            Application application = InsightProxy.getApplication();
            String strDexc = dexc();
            NotificationManager notificationManager = (NotificationManager) application.getSystemService("notification");
            if (notificationManager.getNotificationChannel(strDexc) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(strDexc, str2, 2);
                notificationChannel.setDescription(str2);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            Notification.Builder autoCancel = new Notification.Builder(application, strDexc).setSmallIcon(application.getApplicationInfo().icon).setContentTitle(str2).setPriority(-1).setProgress(0, 0, true).setOnlyAlertOnce(true).setAutoCancel(false);
            if (bitmap != null) {
                autoCancel.setLargeIcon(bitmap);
            }
            this.dexi.put(strDexa, autoCancel);
        } catch (Exception e) {
            f1.dexb("DownloadTaskManager", "addNotificationCore exception: " + e.getMessage());
        }
    }

    private String dexc() {
        ((NotificationManager) InsightProxy.getApplication().getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("ykadinstall", "下载通知", 2));
        return "ykadinstall";
    }

    private void dexd() {
        this.dexc = new y0();
    }

    private void dexe() {
        if (this.dexb == null) {
            this.dexb = InsightProxy.getApplication().getSharedPreferences("YoukuAdDownloadInfo", 0);
        }
    }

    public u0 dexa(com.wangmai.insightvision.openadsdk.download.f fVar) {
        u0 z0Var = null;
        if (fVar != null && fVar.d() != null) {
            com.wangmai.insightvision.openadsdk.download.h hVarD = fVar.d();
            for (u0 u0Var : this.dexf) {
                if (dexa(u0Var.dexb(), hVarD) && z0Var == null) {
                    z0Var = u0Var;
                }
            }
            if (z0Var == null) {
                z0Var = new z0();
                z0Var.dexa(dexb(fVar)).dexa(this.dexk).dexd();
                this.dexf.add(z0Var);
                if (hVarD != null && !TextUtils.isEmpty(hVarD.getPackageName())) {
                    z0Var.dexb().dexe(hVarD.getPackageName());
                }
                z0Var.dexb().dexa(0);
                this.dexk.dexe(z0Var.dexb());
            } else if (TextUtils.isEmpty(hVarD.getPackageName())) {
                z0Var.dexb().dexe(hVarD.getPackageName());
            }
            z0Var.dexb().dexc(fVar.d().b());
        }
        return z0Var;
    }

    public void dexa(b1 b1Var) {
        if (b1Var == null || this.dexh.contains(b1Var)) {
            return;
        }
        this.dexh.add(b1Var);
    }

    public void dexa(String str, String str2, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        dexb(str, str2, bitmap);
    }

    public boolean dexa(u0 u0Var) {
        if (u0Var != null && u0Var.dexb() != null) {
            String strDexg = u0Var.dexb().dexg();
            if (this.dexb != null && !TextUtils.isEmpty(strDexg)) {
                return !"-1".equals(this.dexb.getString(strDexg, "-1"));
            }
        }
        return false;
    }

    public void dexb(b1 b1Var) {
        if (b1Var != null) {
            this.dexh.remove(b1Var);
        }
    }

    public void dexb(u0 u0Var) {
        if (u0Var == null || u0Var.dexb() == null) {
            return;
        }
        String strDexg = u0Var.dexb().dexg();
        if (this.dexb == null || TextUtils.isEmpty(strDexg)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.dexb.edit();
        editorEdit.putString(strDexg, "1");
        editorEdit.apply();
    }
}
