package com.ipd.dsp.internal.v0;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o extends j {
    public static final float n = 0.2f;
    public final e k;
    public final com.ipd.dsp.internal.w0.b l;
    public b m;

    public o(e eVar, com.ipd.dsp.internal.w0.b bVar) {
        super(eVar, bVar);
        this.k = eVar;
        this.l = bVar;
    }

    public void a(b bVar) {
        this.m = bVar;
    }

    public final String b(d dVar) throws k {
        String strB = this.k.b();
        boolean zIsEmpty = TextUtils.isEmpty(strB);
        long jAvailable = this.l.b() ? this.l.available() : this.k.length();
        boolean z = jAvailable >= 0;
        boolean z2 = dVar.c;
        long j = z2 ? jAvailable - dVar.b : jAvailable;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.b), Long.valueOf(jAvailable - 1), Long.valueOf(jAvailable)) : "");
        sb.append(zIsEmpty ? "" : a("Content-Type: %s\n", strB));
        sb.append("\n");
        return sb.toString();
    }

    public void a(d dVar, Socket socket) throws k, IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes(StandardCharsets.UTF_8));
        long j = dVar.b;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    public final boolean a(d dVar) throws k {
        long length = this.k.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.c && ((float) dVar.b) > ((float) this.l.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    public final void b(OutputStream outputStream, long j) throws k, IOException {
        e eVar = new e(this.k);
        try {
            eVar.a(j);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = eVar.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            eVar.close();
        }
    }

    public final String a(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public final void a(OutputStream outputStream, long j) throws k, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, j, 8192);
            if (iA != -1) {
                outputStream.write(bArr, 0, iA);
                j += (long) iA;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    @Override // com.ipd.dsp.internal.v0.j
    public void a(int i) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.l.b, this.k.c(), i);
        }
    }
}
