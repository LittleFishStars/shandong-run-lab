package com.google.android.exoplayer2.source.rtsp;

import com.zj.adlib.ok7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l implements RtpDataChannel.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30983a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4434a;

    public l(long j) {
        this.f4434a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel.Factory
    public RtpDataChannel a(int i) {
        k kVar = new k(this.f4434a);
        kVar.a(ok7.a(i * 2));
        return kVar;
    }
}
