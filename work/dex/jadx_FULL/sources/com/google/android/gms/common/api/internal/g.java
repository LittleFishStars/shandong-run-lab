package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.i3c;
import com.zj.adlib.yw6;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f31241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5553a = false;

    public g(r rVar) {
        this.f31241a = rVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void a(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void b(@Nullable Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void c(int i) {
        this.f31241a.s(null);
        this.f31241a.f5598a.a(i, this.f5553a);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        e(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl e(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.f31241a.f5595a.f5580a.a(apiMethodImpl);
            p pVar = this.f31241a.f5595a;
            Api.Client client = (Api.Client) pVar.f5586a.get(apiMethodImpl.t());
            yw6.m(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.f31241a.b.containsKey(apiMethodImpl.t())) {
                apiMethodImpl.u(client);
            } else {
                apiMethodImpl.a(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f31241a.t(new e(this, this));
        }
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void f() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void g() {
        if (this.f5553a) {
            this.f5553a = false;
            this.f31241a.t(new f(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean h() {
        if (this.f5553a) {
            return false;
        }
        Set set = this.f31241a.f5595a.f5592c;
        if (set == null || set.isEmpty()) {
            this.f31241a.s(null);
            return true;
        }
        this.f5553a = true;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((i3c) it.next()).k();
        }
        return false;
    }

    public final void j() {
        if (this.f5553a) {
            this.f5553a = false;
            this.f31241a.f5595a.f5580a.b();
            h();
        }
    }
}
