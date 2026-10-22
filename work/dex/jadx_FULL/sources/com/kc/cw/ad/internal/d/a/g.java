package com.kc.cw.ad.internal.d.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f38958a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f38958a = j;
    }

    @Override // com.kc.cw.ad.internal.d.a.e, com.kc.cw.ad.internal.d.a.a
    public /* bridge */ /* synthetic */ void a(File file) throws IOException {
        super.a(file);
    }

    @Override // com.kc.cw.ad.internal.d.a.e
    public boolean a(File file, long j, int i) {
        return j <= this.f38958a;
    }
}
