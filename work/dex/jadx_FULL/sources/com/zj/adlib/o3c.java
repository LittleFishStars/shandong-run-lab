package com.zj.adlib;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o3c extends zag {
    public final /* synthetic */ int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f43660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f18550a;

    public o3c(Intent intent, Fragment fragment, int i) {
        this.f43660a = intent;
        this.f18550a = fragment;
        this.K = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f43660a;
        if (intent != null) {
            this.f18550a.startActivityForResult(intent, this.K);
        }
    }
}
