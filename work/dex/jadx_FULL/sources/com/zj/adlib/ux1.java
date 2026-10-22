package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import javax.inject.Inject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ux1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f45242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f20145a;
    public final Clock b;

    @Inject
    public ux1(Context context, @WallTime Clock clock, @Monotonic Clock clock2) {
        this.f45242a = context;
        this.f20145a = clock;
        this.b = clock2;
    }

    public CreationContext a(String str) {
        return CreationContext.b(this.f45242a, this.f20145a, this.b, str);
    }
}
