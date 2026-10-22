package com.zj.adlib;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v3c extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f45285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ LifecycleFragment f20174a;

    public v3c(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.f45285a = intent;
        this.f20174a = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f45285a;
        if (intent != null) {
            this.f20174a.startActivityForResult(intent, 2);
        }
    }
}
