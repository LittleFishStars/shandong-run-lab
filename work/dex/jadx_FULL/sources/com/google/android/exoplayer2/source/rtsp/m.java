package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.common.primitives.Ints;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m implements RtpDataChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30984a = "RTP/AVP;unicast;client_port=%d-%d";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public m f4435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final UdpDataSource f4436a;

    public m(long j) {
        this.f4436a = new UdpDataSource(2000, Ints.d(j));
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        return this.f4436a.a(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        this.f4436a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f4436a.close();
        m mVar = this.f4435a;
        if (mVar != null) {
            mVar.close();
        }
    }

    public void d(m mVar) {
        sb0.a(this != mVar);
        this.f4435a = mVar;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    public String e() {
        int localPort = getLocalPort();
        sb0.i(localPort != -1);
        return gj9.H(f30984a, Integer.valueOf(localPort), Integer.valueOf(localPort + 1));
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    @Nullable
    public RtspMessageChannel.InterleavedBinaryDataListener f() {
        return null;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    public int getLocalPort() {
        int localPort = this.f4436a.getLocalPort();
        if (localPort == -1) {
            return -1;
        }
        return localPort;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f4436a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f4436a.read(bArr, i, i2);
        } catch (UdpDataSource.UdpDataSourceException e) {
            if (e.reason == 2002) {
                return -1;
            }
            throw e;
        }
    }
}
