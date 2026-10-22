package com.efs.sdk.base.core.config.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f29591a = new Random();
    public IConfigRefreshAction b;
    public boolean c;
    public RemoteConfig d;
    public Map<IConfigCallback, String[]> e;
    public Map<IConfigCallback, String[]> f;
    private Handler g;
    private d h;
    private long i;
    private boolean j;
    private int k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29595a = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private void f() {
        boolean zA;
        try {
            zA = this.h.a(this.d);
        } catch (Throwable unused) {
            zA = false;
        }
        if (zA) {
            return;
        }
        this.g.sendEmptyMessageDelayed(3, 3000L);
    }

    @NonNull
    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.b;
        return iConfigRefreshAction == null ? com.efs.sdk.base.core.config.remote.a.a() : iConfigRefreshAction;
    }

    private boolean h() {
        d.b();
        long j = 0;
        try {
            d dVar = this.h;
            dVar.c();
            if (dVar.f29597a != null) {
                j = dVar.f29597a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        boolean z = System.currentTimeMillis() - j >= (this.d.d * 60) * 1000;
        Log.i("efs.config", "isUpdate ".concat(String.valueOf(z)));
        return z;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message messageObtain = Message.obtain(null, 1, new JSONObject(this.d.mSDKConfigMap).toString());
                Message messageObtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
                messageObtain.recycle();
                messageObtain2.recycle();
            }
            Iterator<IEfsReporterObserver> it = ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers().iterator();
            while (it.hasNext()) {
                it.next().onConfigChange();
            }
        } catch (Throwable th) {
            Log.e("efs.config", th);
        }
    }

    private void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.remote.b.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.f.keySet()) {
                        String[] strArr = (String[]) b.this.f.get(iConfigCallback);
                        HashMap map = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (b.this.d.mSDKConfigMap.containsKey(str)) {
                                    map.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "[from server] configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(map);
                    }
                    b.this.f.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        RemoteConfig remoteConfig;
        int i = message.what;
        if (i == 0) {
            boolean zA = d.a();
            Log.i("efs.config", "delete old config is ".concat(String.valueOf(zA)));
            if (zA) {
                this.g.sendEmptyMessage(1);
            } else {
                d dVar = this.h;
                dVar.c();
                if (dVar.f29597a == null) {
                    remoteConfig = null;
                } else {
                    RemoteConfig remoteConfigA = RemoteConfig.a();
                    remoteConfigA.mConfigVersion = dVar.f29597a.getInt("cver", -1);
                    Set<String> setKeySet = dVar.f29597a.getAll().keySet();
                    HashMap map = new HashMap();
                    for (String str : setKeySet) {
                        String string = dVar.f29597a.getString(str, "");
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str, string);
                        }
                    }
                    remoteConfigA.a(map);
                    remoteConfigA.a(dVar.f29597a.getString(UserTrackConstant.SIGN, ""));
                    remoteConfig = remoteConfigA;
                }
                if (remoteConfig == null) {
                    Log.i("efs.config", "first load local config false.");
                } else if (a(remoteConfig)) {
                    Log.i("efs.config", "current config to same.");
                } else {
                    this.d = remoteConfig;
                    String str2 = "load config from storage";
                    if (-1 != remoteConfig.mConfigVersion) {
                        i();
                        Log.i("efs.config.register", "call back");
                        d();
                        j();
                        str2 = "load config from storage and notify observer";
                    }
                    Log.i("efs.config", str2);
                }
            }
        } else if (i == 1) {
            int i2 = message.arg1;
            if (i2 <= this.d.mConfigVersion) {
                Log.i("efs.config", "current config version is " + i2 + ", no need to refresh");
                Log.i("efs.config", "current config version(" + this.d.mConfigVersion + ") is " + i2 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i == 2) {
            try {
                if (h.a.f29572a.a()) {
                    if (h()) {
                        Log.i("efs.config", "update config");
                        e();
                    } else {
                        Log.i("efs.config", "No update is required, less than 8h since the last update");
                        try {
                            int i3 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(ControllerCenter.getGlobalEnvStruct().mAppContext, "apm_setting_cver", "-1"));
                            Log.d("efs.config", "APM_CVER_FROM_COMMON from UMEnvelopeBuild.imprintProperty is " + i3 + " and mRemoteConfig.getConfigVersion() is " + this.d.mConfigVersion);
                            if (i3 > this.d.mConfigVersion) {
                                this.g.sendEmptyMessage(4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    ImprintHandler.getImprintService(ControllerCenter.getGlobalEnvStruct().mAppContext).registImprintCallback("apm_setting_cver", new UMImprintChangeCallback() { // from class: com.efs.sdk.base.core.config.remote.b.1
                        public final void onImprintValueChanged(String str3, String str4) {
                            try {
                                int i4 = Integer.parseInt(str4);
                                if (b.this.k == i4) {
                                    Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is equals to mCverFromCommonListener");
                                    return;
                                }
                                b.this.k = i4;
                                Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is " + i4 + " and mRemoteConfig.getConfigVersion() is " + b.this.d.mConfigVersion);
                                if (i4 > b.this.d.mConfigVersion) {
                                    b.this.g.sendEmptyMessage(4);
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else if (i == 3) {
            f();
        } else if (i == 4) {
            e();
        }
        return true;
    }

    private b() {
        this.c = true;
        this.e = new HashMap();
        this.f = new HashMap();
        this.j = false;
        this.k = -1;
        this.g = new Handler(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper(), this);
        this.h = new d();
        this.d = RemoteConfig.a();
        this.i = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
        this.j = ControllerCenter.getGlobalEnvStruct().isOpenCodeLog();
    }

    private void e() {
        if (!h.a.f29572a.a()) {
            Log.i("efs.config", "has no permission to refresh config from remote");
            return;
        }
        if (!this.c) {
            Log.i("efs.config", "disable refresh config from remote");
            return;
        }
        String strRefresh = g().refresh();
        Log.i("efs.config", "from server. efs config is ".concat(String.valueOf(strRefresh)));
        if (TextUtils.isEmpty(strRefresh)) {
            Log.e("efs.config", "config is empty");
        } else {
            a(strRefresh);
        }
    }

    public final void b() {
        this.g.sendEmptyMessage(0);
        this.g.sendEmptyMessageDelayed(2, this.i);
    }

    public final Map<String, String> c() {
        return new HashMap(this.d.mSDKConfigMap);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.remote.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.e.keySet()) {
                        String[] strArr = (String[]) b.this.e.get(iConfigCallback);
                        HashMap map = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (b.this.d.mSDKConfigMap.containsKey(str)) {
                                    map.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(map);
                    }
                    b.this.e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static b a() {
        return a.f29595a;
    }

    public final void a(int i) {
        if (i <= this.d.mConfigVersion) {
            Log.i("efs.config", "current config version is " + i + ", no need to refresh");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i;
        messageObtain.what = 1;
        this.g.sendMessage(messageObtain);
    }

    public final String a(String str, String str2) {
        String str3 = this.d.mSDKConfigMap.containsKey(str) ? this.d.mSDKConfigMap.get(str) : str2;
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String a(boolean z) {
        if (z) {
            return "https://" + this.d.c;
        }
        return this.d.b + this.d.c;
    }

    public final void a(String str) {
        RemoteConfig remoteConfigA = RemoteConfig.a();
        if (c.a(str, remoteConfigA)) {
            if (a(remoteConfigA)) {
                return;
            }
            this.d = remoteConfigA;
            f();
            i();
            d();
            j();
            return;
        }
        this.g.sendEmptyMessageDelayed(1, 3000L);
    }

    private boolean a(RemoteConfig remoteConfig) {
        if (this.j) {
            return false;
        }
        if (this.d.mConfigVersion >= remoteConfig.mConfigVersion) {
            return true;
        }
        Log.i("efs.config", "current config version (" + this.d.mConfigVersion + ") is older than another (" + remoteConfig.mConfigVersion + ")");
        return false;
    }
}
