package com.fl.saas;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.adx.base.activity.S2SRewardVideoActivity;
import com.fl.saas.adx.base.exception.FLError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class N0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C1415j f30078a;
    private InterfaceC1426o0 b;
    private boolean c;

    public N0(boolean z) {
        this.c = z;
    }

    public void a() {
        this.f30078a = null;
        this.b = null;
    }

    public C1415j b() {
        return this.f30078a;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        if (b() == null) {
            return false;
        }
        if (!TextUtils.isEmpty(b().t1)) {
            return true;
        }
        if (b().S > 0) {
            return !TextUtils.isEmpty(b().p1);
        }
        return false;
    }

    public void e() {
        InterfaceC1426o0 interfaceC1426o0 = this.b;
        if (interfaceC1426o0 == null || this.f30078a.q1 != 1) {
            return;
        }
        interfaceC1426o0.a("");
    }

    public void f() {
        InterfaceC1426o0 interfaceC1426o0 = this.b;
        if (interfaceC1426o0 != null) {
            interfaceC1426o0.onClose();
        }
    }

    public void g() {
        InterfaceC1426o0 interfaceC1426o0 = this.b;
        if (interfaceC1426o0 != null) {
            C1415j c1415j = this.f30078a;
            interfaceC1426o0.a(c1415j != null ? c1415j.d : 0);
        }
    }

    public void h() {
        InterfaceC1426o0 interfaceC1426o0 = this.b;
        if (interfaceC1426o0 != null) {
            C1415j c1415j = this.f30078a;
            interfaceC1426o0.b(c1415j != null ? c1415j.d : 0);
        }
    }

    public N0 a(List list, InterfaceC1426o0 interfaceC1426o0) {
        if (list != null && list.size() > 0) {
            C1415j c1415j = (C1415j) list.get(0);
            if (interfaceC1426o0 != null) {
                this.b = interfaceC1426o0;
                if (c1415j != null) {
                    this.f30078a = c1415j;
                    interfaceC1426o0.a(this);
                } else {
                    a("视频地址为空");
                }
            }
        }
        return this;
    }

    public void a(int i, String str) {
        InterfaceC1426o0 interfaceC1426o0 = this.b;
        if (interfaceC1426o0 != null) {
            interfaceC1426o0.a(FLError.create(i, str));
        }
    }

    public void a(String str) {
        a(0, str);
    }

    public void a(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) S2SRewardVideoActivity.class);
            C1415j c1415j = this.f30078a;
            if (c1415j != null) {
                intent.putExtra("draw_type", c1415j.N0);
            }
            S2SRewardVideoActivity.setAdInfo(this);
            activity.startActivity(intent);
        }
    }
}
