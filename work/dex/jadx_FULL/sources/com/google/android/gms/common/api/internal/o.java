package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotOnlyInitialized
    public final r f31249a;

    public o(r rVar) {
        this.f31249a = rVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void a(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void b(@Nullable Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void c(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f31249a.f5595a.f5587a.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl e(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void f() {
        Iterator it = this.f31249a.f5601a.values().iterator();
        while (it.hasNext()) {
            ((Api.Client) it.next()).disconnect();
        }
        this.f31249a.f5595a.f5591b = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void g() {
        this.f31249a.r();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean h() {
        return true;
    }
}
