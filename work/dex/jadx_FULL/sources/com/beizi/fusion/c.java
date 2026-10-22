package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f27117a = new c();
    }

    private c() {
        if (b.f27117a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static c a() {
        return b.f27117a;
    }

    public static class a implements qc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qc f27116a;

        public a(qc qcVar) {
            this.f27116a = qcVar;
        }

        @Override // com.beizi.fusion.qc
        public void a() {
            qc qcVar = this.f27116a;
            if (qcVar != null) {
                qcVar.a();
            }
        }

        @Override // com.beizi.fusion.qc
        public void b() {
            qc qcVar = this.f27116a;
            if (qcVar != null) {
                qcVar.b();
            }
        }

        @Override // com.beizi.fusion.qc
        public void c() {
            qc qcVar = this.f27116a;
            if (qcVar != null) {
                qcVar.c();
            }
        }

        @Override // com.beizi.fusion.qc
        public void a(int i, String str) {
            qc qcVar = this.f27116a;
            if (qcVar != null) {
                qcVar.a(i, str);
            }
        }
    }

    public void a(Context context, v vVar, qc qcVar) {
        a aVar = new a(qcVar);
        om.d("ASNPAdSDK", "ASNP 版本 " + m0.c());
        try {
            om.d("ASNPAdSDK", "Common库 版本 5.4.0.1");
            if (!a(vVar)) {
                a(aVar, w.ERROR_CONFIG_APP_ID);
                return;
            }
            om.d("ASNPAdSDK", String.format("ASNP 初始化... appID:%s", vVar.e()));
            r9 r9Var = (r9) z.a().b(context.getApplicationContext());
            if (r9Var.a()) {
                a(aVar, w.ALREADY_INIT);
            } else {
                r9Var.a(vVar, aVar);
            }
        } catch (Throwable unused) {
            a(aVar, w.ERROR_SDK_SUPPORT_CLASS_MISSED);
        }
    }

    private void a(qc qcVar, w wVar) {
        if (qcVar != null) {
            if (wVar == w.INIT_DONE) {
                qcVar.a();
            } else if (wVar == w.ALREADY_INIT) {
                qcVar.b();
            } else {
                qcVar.a(wVar.b(), wVar.c());
            }
        }
    }

    private boolean a(v vVar) {
        if (vVar != null) {
            return !TextUtils.isEmpty(vVar.e());
        }
        return false;
    }
}
