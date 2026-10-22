package com.igexin.c.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BufferedOutputStream f37824a;

    public i(OutputStream outputStream) throws IOException {
        this.f37824a = new BufferedOutputStream(outputStream);
    }

    private i(Socket socket) throws IOException {
        this.f37824a = new BufferedOutputStream(socket.getOutputStream());
    }

    private void a() throws IOException {
        this.f37824a.close();
    }

    private void a(byte[] bArr) throws IOException {
        this.f37824a.write(bArr, 0, bArr.length);
        this.f37824a.flush();
    }

    private void a(byte[] bArr, int i, int i2) throws IOException {
        this.f37824a.write(bArr, i, i2);
        this.f37824a.flush();
    }
}
