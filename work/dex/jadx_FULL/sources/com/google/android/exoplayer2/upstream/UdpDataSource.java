package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class UdpDataSource extends BaseDataSource {
    public static final int d = 2000;
    public static final int e = 8000;
    public static final int f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Uri f31124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DatagramPacket f5076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DatagramSocket f5077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public InetAddress f5078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MulticastSocket f5079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f5080a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5081b;
    public int c;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.f5026a;
        this.f31124a = uri;
        String str = (String) sb0.g(uri.getHost());
        int port = this.f31124a.getPort();
        transferInitializing(dataSpec);
        try {
            this.f5078a = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f5078a, port);
            if (this.f5078a.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f5079a = multicastSocket;
                multicastSocket.joinGroup(this.f5078a);
                this.f5077a = this.f5079a;
            } else {
                this.f5077a = new DatagramSocket(inetSocketAddress);
            }
            this.f5077a.setSoTimeout(this.b);
            this.f5081b = true;
            transferStarted(dataSpec);
            return -1L;
        } catch (IOException e2) {
            throw new UdpDataSourceException(e2, 2001);
        } catch (SecurityException e3) {
            throw new UdpDataSourceException(e3, 2006);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f31124a = null;
        MulticastSocket multicastSocket = this.f5079a;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) sb0.g(this.f5078a));
            } catch (IOException unused) {
            }
            this.f5079a = null;
        }
        DatagramSocket datagramSocket = this.f5077a;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f5077a = null;
        }
        this.f5078a = null;
        this.c = 0;
        if (this.f5081b) {
            this.f5081b = false;
            transferEnded();
        }
    }

    public int getLocalPort() {
        DatagramSocket datagramSocket = this.f5077a;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f31124a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.c == 0) {
            try {
                ((DatagramSocket) sb0.g(this.f5077a)).receive(this.f5076a);
                int length = this.f5076a.getLength();
                this.c = length;
                bytesTransferred(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(e2, 2002);
            } catch (IOException e3) {
                throw new UdpDataSourceException(e3, 2001);
            }
        }
        int length2 = this.f5076a.getLength();
        int i3 = this.c;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.f5080a, length2 - i3, bArr, i, iMin);
        this.c -= iMin;
        return iMin;
    }

    public UdpDataSource(int i) {
        this(i, 8000);
    }

    public UdpDataSource(int i, int i2) {
        super(true);
        this.b = i2;
        byte[] bArr = new byte[i];
        this.f5080a = bArr;
        this.f5076a = new DatagramPacket(bArr, 0, i);
    }
}
