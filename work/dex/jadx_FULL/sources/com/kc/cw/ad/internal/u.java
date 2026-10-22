package com.kc.cw.ad.internal;

import android.os.Handler;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39063a = 0;
    private final String b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private boolean g;
    private com.kc.cw.ad.internal.c.d.a h;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.u$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements com.kc.cw.ad.internal.c.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final u f39064a;

        public AnonymousClass1(u uVar) {
            this.f39064a = uVar;
        }

        @Override // com.kc.cw.ad.internal.c.d.a
        public void a(int i, boolean z, String str) {
            if (z) {
                if (this.f39064a.h != null) {
                    this.f39064a.h.a(i, z, str);
                    return;
                }
                return;
            }
            if (this.f39064a.f39063a > 0) {
                new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.u.1.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final AnonymousClass1 f39065a;

                    {
                        this.f39065a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f39065a.f39064a.a();
                        u.c(this.f39065a.f39064a);
                    }
                }, 200L);
            }
            if (this.f39064a.f39063a == 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", this.f39064a.f);
                    jSONObject.put("http_status_code", i);
                    this.f39064a.a(jSONObject.toString());
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        }
    }

    public u(String str, String str2, String str3, long j, String str4, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = str4;
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        o.a(new l(QdActivityType.IMP.equals(this.b) ? "IMPFAIL" : "CLKFAIL", this.c, this.d, System.currentTimeMillis() - this.e, str));
    }

    public static /* synthetic */ int c(u uVar) {
        int i = uVar.f39063a;
        uVar.f39063a = i - 1;
        return i;
    }

    public void a() {
        i iVar = new i(this.f);
        if (this.g) {
            iVar.a(new AnonymousClass1(this));
        } else {
            com.kc.cw.ad.internal.c.d.a aVar = this.h;
            if (aVar != null) {
                aVar.a(200, true, "");
            }
        }
        iVar.b();
    }

    public void a(com.kc.cw.ad.internal.c.d.a aVar) {
        this.h = aVar;
    }
}
