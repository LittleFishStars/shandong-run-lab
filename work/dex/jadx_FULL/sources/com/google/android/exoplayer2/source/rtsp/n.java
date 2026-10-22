package com.google.android.exoplayer2.source.rtsp;

import com.zj.adlib.d72;
import com.zj.adlib.ok7;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n implements RtpDataChannel.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30985a;

    public n(long j) {
        this.f30985a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel.Factory
    public RtpDataChannel a(int i) throws IOException {
        m mVar = new m(this.f30985a);
        m mVar2 = new m(this.f30985a);
        try {
            mVar.a(ok7.a(0));
            int localPort = mVar.getLocalPort();
            boolean z = localPort % 2 == 0;
            mVar2.a(ok7.a(z ? localPort + 1 : localPort - 1));
            if (z) {
                mVar.d(mVar2);
                return mVar;
            }
            mVar2.d(mVar);
            return mVar2;
        } catch (IOException e) {
            d72.a(mVar);
            d72.a(mVar2);
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel.Factory
    public RtpDataChannel.Factory b() {
        return new l(this.f30985a);
    }
}
