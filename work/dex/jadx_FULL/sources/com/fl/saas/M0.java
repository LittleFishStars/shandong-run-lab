package com.fl.saas;

import com.fl.saas.adx.base.exception.FLError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC1426o0 f30076a;
    private N0 b;
    private final boolean c;

    public class a implements InterfaceC1424n0 {
        public a() {
        }

        @Override // com.fl.saas.InterfaceC1424n0
        public void a(List list) {
            M0 m0 = M0.this;
            m0.b = new N0(m0.c);
            M0.this.b.a(list, M0.this.f30076a);
        }

        @Override // com.fl.saas.InterfaceC1424n0
        public void onAdFailed(FLError fLError) {
            if (M0.this.f30076a == null || fLError == null || fLError.getCode() == 1001) {
                return;
            }
            M0.this.f30076a.b(fLError);
        }
    }

    public M0(InterfaceC1426o0 interfaceC1426o0, boolean z) {
        this.f30076a = interfaceC1426o0;
        this.c = z;
    }

    public void a() {
        N0 n0 = this.b;
        if (n0 != null) {
            n0.a();
        }
    }

    public void a(String str, String str2, boolean z) {
        R0.a().a(str, str2, z, new a());
    }
}
