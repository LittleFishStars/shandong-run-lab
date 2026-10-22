package com.zj.adlib;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d3c extends zag {
    public final /* synthetic */ int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f41101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Intent f15922a;

    public d3c(Intent intent, Activity activity, int i) {
        this.f15922a = intent;
        this.f41101a = activity;
        this.K = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f15922a;
        if (intent != null) {
            this.f41101a.startActivityForResult(intent, this.K);
        }
    }
}
