package com.kc.dw.platform.ad_adapter.reward;

import com.kc.dw.activity.SsdRewardH5Activity;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.safe.l;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.webview.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {
    public c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f39530a = false;
    public final Object b = new Object();
    public volatile Boolean d = null;
    public volatile Boolean e = null;
    public final f f = new f(new f.a(this) { // from class: com.kc.dw.platform.ad_adapter.reward.b$$ExternalSyntheticLambda0
        public final b f$0;

        {
            this.f$0 = this;
        }

        @Override // com.kc.dw.core.webview.f.a
        public final void a(boolean z) {
            this.f$0.a(z);
        }
    });

    @Keep
    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39531a;

        /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.reward.b$a$a, reason: collision with other inner class name */
        @Keep
        public class C1072a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39532a;

            public C1072a(a aVar) {
                this.f39532a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                LogUtil.dev("RewardH5", "timeoutCheck");
                b.a(this.f39532a.f39531a);
            }
        }

        public a(b bVar) {
            this.f39531a = bVar;
        }

        @Override // com.kc.dw.core.safe.l
        public void a() {
            cancel();
            SdkHandler.getInstance().runOnUiThread(new C1072a(this));
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.reward.b$b, reason: collision with other inner class name */
    @Keep
    public class C1073b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39533a;

        /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.reward.b$b$a */
        @Keep
        public class a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1073b f39534a;

            public a(C1073b c1073b) {
                this.f39534a = c1073b;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                b.a(this.f39534a.f39533a);
            }
        }

        public C1073b(b bVar) {
            this.f39533a = bVar;
        }

        @Override // com.kc.dw.core.safe.l
        public void a() {
            cancel();
            SdkHandler.getInstance().runOnUiThread(new a(this));
        }
    }

    @Keep
    public interface c {
    }

    public b(c cVar) {
        this.c = cVar;
        try {
            new Timer().schedule(new a(this), 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(b bVar) {
        if (bVar.e == null) {
            bVar.e = Boolean.valueOf(Boolean.TRUE.equals(bVar.f.c));
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(bVar.e) || bool.equals(bVar.d)) {
            bVar.c(bool.equals(bVar.e));
        } else {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        if (this.e != null) {
            return;
        }
        this.e = Boolean.valueOf(z);
        if (this.e.booleanValue()) {
            LogUtil.dev("RewardH5", "onH5ReadyRes 2");
            z2 = true;
        } else {
            if (this.d == null) {
                return;
            }
            LogUtil.dev("RewardH5", "onH5ReadyRes 3");
            if (!this.d.booleanValue()) {
                LogUtil.dev("RewardH5", "onH5ReadyRes 5");
                a();
                return;
            } else {
                LogUtil.dev("RewardH5", "onH5ReadyRes 4");
                z2 = false;
            }
        }
        c(z2);
    }

    public final void a() {
        synchronized (this.b) {
            if (this.c != null) {
                LogUtil.dev("RewardH5", "final reward notifyFail");
                com.kc.dw.platform.ad_adapter.reward.c.b bVar = (com.kc.dw.platform.ad_adapter.reward.c.b) this.c;
                bVar.d.a(bVar.c, "video load error", com.kc.dw.core.exception.b.i);
                this.c = null;
            }
        }
    }

    public final void b() {
        try {
            if (this.f39530a) {
                return;
            }
            this.f39530a = true;
            new Timer().schedule(new C1073b(this), 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(boolean z) {
        boolean zBooleanValue;
        String str;
        if (this.d != null) {
            return;
        }
        this.d = Boolean.valueOf(z);
        LogUtil.dev("RewardH5", "nativeReadyRes:" + z);
        if (this.d.booleanValue()) {
            if (this.e == null) {
                str = "nativeReadyRes2";
                LogUtil.dev("RewardH5", str);
                b();
                return;
            } else {
                LogUtil.dev("RewardH5", "nativeReadyRes3");
                zBooleanValue = this.e.booleanValue();
                c(zBooleanValue);
            }
        }
        if (this.e == null) {
            str = "nativeReadyRes4";
            LogUtil.dev("RewardH5", str);
            b();
            return;
        }
        LogUtil.dev("RewardH5", "nativeReadyRes5");
        if (!this.e.booleanValue()) {
            LogUtil.dev("RewardH5", "nativeReadyRes7");
            a();
        } else {
            LogUtil.dev("RewardH5", "nativeReadyRes6");
            zBooleanValue = true;
            c(zBooleanValue);
        }
    }

    public final void c(boolean z) {
        synchronized (this.b) {
            if (this.c != null) {
                LogUtil.dev("RewardH5", "final reward notifySuccess:" + z);
                com.kc.dw.platform.ad_adapter.reward.c.b bVar = (com.kc.dw.platform.ad_adapter.reward.c.b) this.c;
                bVar.getClass();
                if (z) {
                    SsdRewardH5Activity.setRewardH5Data(bVar.f39535a[0], bVar.b);
                }
                SdkHandler.getInstance().runOnUiThread(new d(bVar));
                this.c = null;
            }
        }
    }

    public void d(boolean z) {
        f fVar = this.f;
        if (fVar.c != null) {
            return;
        }
        fVar.c = Boolean.valueOf(z);
        LogUtil.dev("RewardH5", "h5LoadedRes:" + z);
        if (fVar.c.booleanValue()) {
            synchronized (fVar.f39439a) {
                f.a aVar = fVar.b;
                if (aVar != null) {
                    aVar.a(true);
                    fVar.b = null;
                }
            }
            return;
        }
        synchronized (fVar.f39439a) {
            f.a aVar2 = fVar.b;
            if (aVar2 != null) {
                aVar2.a(false);
                fVar.b = null;
            }
        }
    }
}
