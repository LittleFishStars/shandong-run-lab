package com.alipay.android.phone.mobilesdk.socketcraft;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements h, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static ByteBuffer f25286a = ByteBuffer.allocate(0);
    static final /* synthetic */ boolean m = true;
    protected ExecutorService b;
    protected List<Future<?>> c;
    protected ByteBuffer d;
    protected ByteBuffer e;
    protected ByteBuffer f;
    protected SocketChannel g;
    protected SelectionKey h;
    protected SSLEngine i;
    protected SSLEngineResult j;
    protected SSLEngineResult k;
    protected int l = 0;

    public b(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.g = socketChannel;
        this.i = sSLEngine;
        this.b = executorService;
        SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.k = sSLEngineResult;
        this.j = sSLEngineResult;
        this.c = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.h = selectionKey;
        }
        a(sSLEngine.getSession());
        this.g.write(b(f25286a));
        j();
    }

    private void a(Future<?> future) {
        boolean z = false;
        while (true) {
            try {
                try {
                    future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized ByteBuffer b(ByteBuffer byteBuffer) {
        this.e.compact();
        this.k = this.i.wrap(byteBuffer, this.e);
        this.e.flip();
        return this.e;
    }

    private int c(ByteBuffer byteBuffer) {
        if (this.d.hasRemaining()) {
            return a(this.d, byteBuffer);
        }
        if (!this.d.hasRemaining()) {
            this.d.clear();
        }
        if (!this.f.hasRemaining()) {
            return 0;
        }
        k();
        int iA = a(this.d, byteBuffer);
        if (this.j.getStatus() == SSLEngineResult.Status.CLOSED) {
            return -1;
        }
        if (iA > 0) {
            return iA;
        }
        return 0;
    }

    private synchronized void j() {
        if (this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.c.isEmpty()) {
            Iterator<Future<?>> it = this.c.iterator();
            while (it.hasNext()) {
                Future<?> next = it.next();
                if (!next.isDone()) {
                    if (d()) {
                        a(next);
                    }
                    return;
                }
                it.remove();
            }
        }
        if (this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!d() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.f.compact();
                if (this.g.read(this.f) == -1) {
                    throw new IOException("connection closed unexpectedly by peer");
                }
                this.f.flip();
            }
            this.d.compact();
            k();
            if (this.j.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                a(this.i.getSession());
                return;
            }
        }
        e();
        if (this.c.isEmpty() || this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.g.write(b(f25286a));
            if (this.k.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                a(this.i.getSession());
                return;
            }
        }
        if (!m && this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            throw new AssertionError();
        }
        this.l = 1;
    }

    private synchronized ByteBuffer k() {
        while (true) {
            int iRemaining = this.d.remaining();
            SSLEngineResult sSLEngineResultUnwrap = this.i.unwrap(this.f, this.d);
            this.j = sSLEngineResultUnwrap;
            if (sSLEngineResultUnwrap.getStatus() != SSLEngineResult.Status.OK || (iRemaining == this.d.remaining() && this.i.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                break;
            }
        }
        this.d.flip();
        return this.d;
    }

    private boolean l() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.i.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.i.closeOutbound();
        this.i.getSession().invalidate();
        if (this.g.isOpen()) {
            this.g.write(b(f25286a));
        }
        this.g.close();
        this.b.shutdownNow();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean d() {
        return this.g.isBlocking();
    }

    public void e() {
        while (true) {
            Runnable delegatedTask = this.i.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            } else {
                this.c.add(this.b.submit(delegatedTask));
            }
        }
    }

    public boolean f() {
        return this.g.isConnected();
    }

    public boolean g() {
        return this.g.finishConnect();
    }

    public Socket h() {
        return this.g.socket();
    }

    public boolean i() {
        return this.i.isInboundDone();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.g.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (!l()) {
            if (d()) {
                while (!l()) {
                    j();
                }
            } else {
                j();
                if (!l()) {
                    return 0;
                }
            }
        }
        int iC = c(byteBuffer);
        if (iC != 0) {
            return iC;
        }
        if (!m && this.d.position() != 0) {
            throw new AssertionError();
        }
        this.d.clear();
        if (this.f.hasRemaining()) {
            this.f.compact();
        } else {
            this.f.clear();
        }
        if ((d() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.g.read(this.f) == -1) {
            return -1;
        }
        this.f.flip();
        k();
        int iA = a(this.d, byteBuffer);
        return (iA == 0 && d()) ? read(byteBuffer) : iA;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!l()) {
            j();
            return 0;
        }
        int iWrite = this.g.write(b(byteBuffer));
        if (this.k.getStatus() != SSLEngineResult.Status.CLOSED) {
            return iWrite;
        }
        throw new EOFException("Connection is closed");
    }

    public void a(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int iMax = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            this.d = ByteBuffer.allocate(iMax);
            this.e = ByteBuffer.allocate(packetBufferSize);
            this.f = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != iMax) {
                this.d = ByteBuffer.allocate(iMax);
            }
            if (this.e.capacity() != packetBufferSize) {
                this.e = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.f.capacity() != packetBufferSize) {
                this.f = ByteBuffer.allocate(packetBufferSize);
            }
        }
        this.d.rewind();
        this.d.flip();
        this.f.rewind();
        this.f.flip();
        this.e.rewind();
        this.e.flip();
        this.l++;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public void b() throws IOException {
        write(this.e);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean c() {
        if (this.d.hasRemaining()) {
            return true;
        }
        return (!this.f.hasRemaining() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.j.getStatus() == SSLEngineResult.Status.CLOSED) ? false : true;
    }

    public SelectableChannel a(boolean z) {
        return this.g.configureBlocking(z);
    }

    public boolean a(SocketAddress socketAddress) {
        return this.g.connect(socketAddress);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean a() {
        return this.e.hasRemaining() || !l();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public int a(ByteBuffer byteBuffer) {
        return c(byteBuffer);
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iRemaining = byteBuffer.remaining();
        int iRemaining2 = byteBuffer2.remaining();
        if (iRemaining > iRemaining2) {
            int iMin = Math.min(iRemaining, iRemaining2);
            for (int i = 0; i < iMin; i++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return iMin;
        }
        byteBuffer2.put(byteBuffer);
        return iRemaining;
    }
}
