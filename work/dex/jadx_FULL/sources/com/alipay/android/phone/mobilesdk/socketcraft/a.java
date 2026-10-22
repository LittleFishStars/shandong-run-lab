package com.alipay.android.phone.mobilesdk.socketcraft;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteChannel f25282a;

    public a(ByteChannel byteChannel) {
        this.f25282a = byteChannel;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean a() {
        ByteChannel byteChannel = this.f25282a;
        if (byteChannel instanceof h) {
            return ((h) byteChannel).a();
        }
        return false;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public void b() {
        ByteChannel byteChannel = this.f25282a;
        if (byteChannel instanceof h) {
            ((h) byteChannel).b();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean c() {
        ByteChannel byteChannel = this.f25282a;
        if (byteChannel instanceof h) {
            return ((h) byteChannel).c();
        }
        return false;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25282a.close();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public boolean d() {
        ByteChannel byteChannel = this.f25282a;
        if (byteChannel instanceof SocketChannel) {
            return ((SocketChannel) byteChannel).isBlocking();
        }
        if (byteChannel instanceof h) {
            return ((h) byteChannel).d();
        }
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f25282a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.f25282a.read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return this.f25282a.write(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.h
    public int a(ByteBuffer byteBuffer) {
        ByteChannel byteChannel = this.f25282a;
        if (byteChannel instanceof h) {
            return ((h) byteChannel).a(byteBuffer);
        }
        return 0;
    }

    public a(h hVar) {
        this.f25282a = hVar;
    }
}
