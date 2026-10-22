package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k extends BaseDataSource implements RtpDataChannel, RtspMessageChannel.InterleavedBinaryDataListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30982a = "RTP/AVP/TCP;unicast;interleaved=%d-%d";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedBlockingQueue<byte[]> f4432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f4433a;
    public int b;

    public k(long j) {
        super(true);
        this.f4431a = j;
        this.f4432a = new LinkedBlockingQueue<>();
        this.f4433a = new byte[0];
        this.b = -1;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) {
        this.b = dataSpec.f5026a.getPort();
        return -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtspMessageChannel.InterleavedBinaryDataListener
    public void d(byte[] bArr) {
        this.f4432a.add(bArr);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    public String e() {
        sb0.i(this.b != -1);
        return gj9.H(f30982a, Integer.valueOf(this.b), Integer.valueOf(this.b + 1));
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    public RtspMessageChannel.InterleavedBinaryDataListener f() {
        return this;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.RtpDataChannel
    public int getLocalPort() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int iMin = Math.min(i2, this.f4433a.length);
        System.arraycopy(this.f4433a, 0, bArr, i, iMin);
        int i3 = iMin + 0;
        byte[] bArr2 = this.f4433a;
        this.f4433a = Arrays.copyOfRange(bArr2, iMin, bArr2.length);
        if (i3 == i2) {
            return i3;
        }
        try {
            byte[] bArrPoll = this.f4432a.poll(this.f4431a, TimeUnit.MILLISECONDS);
            if (bArrPoll == null) {
                return -1;
            }
            int iMin2 = Math.min(i2 - i3, bArrPoll.length);
            System.arraycopy(bArrPoll, 0, bArr, i + i3, iMin2);
            if (iMin2 < bArrPoll.length) {
                this.f4433a = Arrays.copyOfRange(bArrPoll, iMin2, bArrPoll.length);
            }
            return i3 + iMin2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
