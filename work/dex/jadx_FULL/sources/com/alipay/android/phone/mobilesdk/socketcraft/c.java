package com.alipay.android.phone.mobilesdk.socketcraft;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static boolean a(ByteBuffer byteBuffer, f fVar, ByteChannel byteChannel) throws IOException {
        byteBuffer.clear();
        int i = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (i != -1) {
            return i != 0;
        }
        fVar.n();
        return false;
    }

    public static boolean a(ByteBuffer byteBuffer, f fVar, h hVar) {
        byteBuffer.clear();
        int iA = hVar.a(byteBuffer);
        byteBuffer.flip();
        if (iA == -1) {
            fVar.n();
            return false;
        }
        return hVar.c();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(f fVar, ByteChannel byteChannel) throws IOException {
        h hVar;
        ByteBuffer byteBufferPeek = fVar.i.peek();
        if (byteBufferPeek == null) {
            if (byteChannel instanceof h) {
                hVar = (h) byteChannel;
                if (hVar.a()) {
                    hVar.b();
                }
            }
            if (fVar.i.isEmpty() && fVar.h() && fVar.j() != null && fVar.j().d() != null && fVar.j().d() == WebSocket.Role.SERVER) {
                synchronized (fVar) {
                    fVar.m();
                }
            }
            return hVar == null || !((h) byteChannel).a();
        }
        do {
            byteChannel.write(byteBufferPeek);
            if (byteBufferPeek.remaining() > 0) {
                return false;
            }
            fVar.i.poll();
            byteBufferPeek = fVar.i.peek();
        } while (byteBufferPeek != null);
        hVar = null;
        if (fVar.i.isEmpty()) {
            synchronized (fVar) {
                fVar.m();
            }
        }
        if (hVar == null) {
            return true;
        }
    }
}
