package com.hailiang.advlib.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.hailiang.advlib.core.QMConfig;
import com.hailiang.advlib.core.c;
import com.hailiang.advlib.open.JFIdentifierManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import hl.hl.hla.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class AiClkAdManager {
    private static volatile AiClkAdManager sManager;
    private final AtomicBoolean isInit = new AtomicBoolean(false);
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private com.hailiang.advlib.core.a mFactory;
    private QMConfig mQmConfig;

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final QMConfig f32555a;
        final AiClkAdManager b;

        public a(AiClkAdManager aiClkAdManager, QMConfig qMConfig) {
            this.b = aiClkAdManager;
            this.f32555a = qMConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.executeInit(this.f32555a, false);
        }
    }

    @Keep
    public class b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final QMConfig f32556a;
        final AiClkAdManager b;

        public b(AiClkAdManager aiClkAdManager, QMConfig qMConfig) {
            this.b = aiClkAdManager;
            this.f32556a = qMConfig;
        }

        public void a() {
            this.b.mFactory = com.hailiang.advlib.core.a.a(this.f32556a);
            hl.hl.hl.hla.a.a().c(this.f32556a.getContext());
            this.b.performInitSuccess(this.f32556a);
        }
    }

    private AiClkAdManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeInit(QMConfig qMConfig, boolean z) {
        new e().a(qMConfig, new b(this, qMConfig), z);
    }

    public static AiClkAdManager getInstance() {
        if (sManager == null) {
            synchronized (AiClkAdManager.class) {
                try {
                    if (sManager == null) {
                        sManager = new AiClkAdManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sManager;
    }

    public static String getSdkVersion() {
        return "3.481.10.447";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performInitSuccess(QMConfig qMConfig) {
        this.isInitialized.set(true);
        if (qMConfig == null || qMConfig.getSdkInitListener() == null) {
            return;
        }
        qMConfig.getSdkInitListener().onSdkInitCompleted();
    }

    private void setCanUseOaid(QMConfig qMConfig) {
        try {
            JFIdentifierManager.getInstance().setIsCanUseOaid(qMConfig.getContext(), qMConfig.getCustomControl() == null || qMConfig.getCustomControl().isCanUseOaid());
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public void appListFromClientNotice() {
        com.hailiang.advlib.core.a aVar = this.mFactory;
        if (aVar == null) {
            Log.i("aiclk", "aiclk ad not init");
        } else {
            aVar.appListFromClientNotice();
        }
    }

    public void asyncInit(QMConfig qMConfig) {
        if (this.isInit.getAndSet(true)) {
            return;
        }
        hl.hl.hl.hla.a.a().a(false, qMConfig.isDebug());
        this.mQmConfig = qMConfig;
        JFIdentifierManager.getInstance().setOaid(qMConfig.getCustomControl() != null ? qMConfig.getCustomControl().getOaid() : "");
        setCanUseOaid(qMConfig);
        com.hailiang.advlib.common.e.a(new a(this, qMConfig));
    }

    public void closeInteractionAd(IMultiAdObject iMultiAdObject) {
        c.a(iMultiAdObject);
    }

    public IMultiAdRequest createAdRequest() {
        if (this.mFactory == null) {
            Log.i("aiclk", "aiclk ad not init");
            return null;
        }
        JFIdentifierManager.getInstance().acquireOAID(this.mQmConfig.getContext());
        return this.mFactory.createNativeMultiAdRequest();
    }

    @Deprecated
    public void init(Context context, String str) {
        init(new QMConfig.Builder().build(context));
    }

    public void init(QMConfig qMConfig) {
        if (this.isInit.getAndSet(true)) {
            return;
        }
        hl.hl.hl.hla.a.a().a(true, qMConfig.isDebug());
        this.mQmConfig = qMConfig;
        JFIdentifierManager.getInstance().setOaid(qMConfig.getCustomControl() != null ? qMConfig.getCustomControl().getOaid() : "");
        setCanUseOaid(qMConfig);
        executeInit(qMConfig, true);
    }

    public boolean isInitialized() {
        return this.isInitialized.get();
    }

    public void setAppList(List<PackageInfo> list) {
        com.hailiang.advlib.core.a aVar = this.mFactory;
        if (aVar == null) {
            Log.i("aiclk", "aiclk ad not init");
        } else {
            aVar.setAppList(list);
        }
    }

    public void setOaid(String str) {
        JFIdentifierManager.getInstance().setOaid(str);
    }

    public void setPersonalRecommend(boolean z) {
        c.a(z);
    }

    public void setTwistSwitch(boolean z) {
        c.b(z);
    }
}
