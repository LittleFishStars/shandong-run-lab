package com.zj.adlib;

import com.google.android.exoplayer2.source.dash.manifest.Representation;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class vz {
    public static final int c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Representation> f20347a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<rk2> f20348b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<rk2> f20349c;
    public final List<rk2> d;

    public vz(int i, int i2, List<Representation> list, List<rk2> list2, List<rk2> list3, List<rk2> list4) {
        this.f45491a = i;
        this.b = i2;
        this.f20347a = Collections.unmodifiableList(list);
        this.f20348b = Collections.unmodifiableList(list2);
        this.f20349c = Collections.unmodifiableList(list3);
        this.d = Collections.unmodifiableList(list4);
    }
}
