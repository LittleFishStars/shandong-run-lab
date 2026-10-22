package com.byazt.uk;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.byazt.quv.MainServerManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 87, 158})
public class sl {
    public static volatile sl c;
    public boolean tt;
    public final List<ZeusPluginStateListener> ve = new CopyOnWriteArrayList();
    public final List<u> uj = new ArrayList();
    public final Handler n = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f29088a = null;
    public Map<String, JSONObject> sp = new ConcurrentHashMap();

    private void a() {
        ProviderInfo[] providerInfoArr;
        GlobalParam.getInstance().getReporter().c("zeus_stage_plugin", "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(u15.f19942b)) ? "main" : providerInfo.processName.split(u15.f19942b)[1];
                            ProviderInfo providerInfo2 = Zeus.getServerManagerHashMap().get(str);
                            if ((providerInfo2 == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) && (providerInfo2 == null || !TextUtils.equals(str, "downloader") || TextUtils.isEmpty(providerInfo2.authority) || !providerInfo2.authority.contains("com.bytedance.sdk.openadsdk.adhost"))) {
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().c("zeus_stage_plugin", "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().c("zeus_stage_plugin", "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public static sl c() {
        if (c == null) {
            synchronized (sl.class) {
                if (c == null) {
                    c = new sl();
                }
            }
        }
        return c;
    }

    private void sp() {
        try {
            GlobalParam.getInstance().getReporter().c("zeus_stage_common", "invoke disableApiWarning");
            FieldUtils.writeField(com.byazt.th.c.c(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] x() {
        Object[] array;
        synchronized (this.uj) {
            array = !this.uj.isEmpty() ? this.uj.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public Map<String, JSONObject> n() {
        return this.sp;
    }

    public boolean tt() {
        return this.tt;
    }

    public t uj() {
        return this.f29088a;
    }

    public List<ZeusPluginStateListener> ve() {
        return this.ve;
    }

    public void tt(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.ve;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void tt(u uVar) {
        if (uVar == null) {
            return;
        }
        synchronized (this.uj) {
            this.uj.remove(uVar);
        }
    }

    public synchronized void c(Application application) {
        if (this.tt) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        c(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.byazt.th.n.tt(new Runnable() { // from class: com.byazt.uk.sl.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.uq.sl.tt();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.byazt.xe.n.c();
            }
            com.byazt.gvs.tt.c().c(new com.byazt.gvs.c() { // from class: com.byazt.uk.sl.2
                @Override // com.byazt.gvs.c
                public void c(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    com.byazt.blh.ve.c(str, jSONObject, jSONObject2, jSONObject3);
                }
            });
            if (!globalParam.isCloseFlipped()) {
                tt.c();
            }
            if (com.byazt.uq.i.m()) {
                com.byazt.th.n.c(new Runnable() { // from class: com.byazt.uk.sl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GlobalParam.getInstance().getReporter().c("zeus_stage_common", "invoke SystemConfig");
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable th) {
                            GlobalParam.getInstance().getReporter().c("zeus_stage_error", "invoke SystemConfig error : ".concat(String.valueOf(th)));
                        }
                    }
                });
            }
            if (com.byazt.uq.i.yp()) {
                sp();
            }
            a();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.tt = true;
            c(3100, 0, null, -1, null);
            return;
        }
        GlobalParam.getInstance().getReporter().c("zeus_stage_error", "context is null");
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public void c(ZeusPluginStateListener zeusPluginStateListener) {
        this.ve.add(zeusPluginStateListener);
    }

    public void c(u uVar) {
        if (uVar == null) {
            return;
        }
        synchronized (this.uj) {
            this.uj.add(uVar);
        }
    }

    public void c(final int i, final int i2, @Nullable final String str, final int i3, @Nullable final Throwable th) {
        for (final Object obj : x()) {
            this.n.post(new Runnable() { // from class: com.byazt.uk.sl.4
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    public void c(t tVar) {
        this.f29088a = tVar;
    }
}
