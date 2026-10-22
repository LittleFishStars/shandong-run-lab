package com.zj.adlib;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k3c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Status f42738a = new Status(8, "The connection to Google Play services was lost");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Set f17579a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j3c f17578a = new j3c(this);

    public final void a(BasePendingResult basePendingResult) {
        this.f17579a.add(basePendingResult);
        basePendingResult.r(this.f17578a);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f17579a.toArray(new BasePendingResult[0])) {
            basePendingResult.r(null);
            if (basePendingResult.q()) {
                this.f17579a.remove(basePendingResult);
            }
        }
    }
}
