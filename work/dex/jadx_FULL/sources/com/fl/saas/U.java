package com.fl.saas;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class U extends AbstractC1446y0 {
    private final X i;
    private final L j;
    private InterfaceC1429q k;

    public U(X x, L l) {
        super(x, l);
        this.j = l;
        this.i = x;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String b(P p) {
        String strC = this.i.c();
        boolean z = !TextUtils.isEmpty(strC);
        long jB = this.j.c() ? this.j.b() : this.i.a();
        boolean z2 = jB >= 0;
        boolean z3 = p.c;
        long j = z3 ? jB - p.b : jB;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(p.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(p.b), Long.valueOf(jB - 1), Long.valueOf(jB)) : "");
        sb.append(z ? a("Content-Type: %s\n", strC) : "");
        sb.append("\n");
        return sb.toString();
    }

    private boolean a(P p) {
        long jA = this.i.a();
        return (((jA > 0L ? 1 : (jA == 0L ? 0 : -1)) > 0) && p.c && ((float) p.b) > ((float) this.j.b()) + (((float) jA) * 0.2f)) ? false : true;
    }

    private void b(OutputStream outputStream, long j) {
        X x = new X(this.i);
        try {
            x.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = x.a(bArr);
                if (iA == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, iA);
            }
        } finally {
            x.close();
        }
    }

    @Override // com.fl.saas.AbstractC1446y0
    public void a(int i) {
        InterfaceC1429q interfaceC1429q = this.k;
        if (interfaceC1429q != null) {
            interfaceC1429q.a(this.j.b, this.i.d(), i);
        }
    }

    public void a(P p, Socket socket) throws IOException, C1448z0 {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(p).getBytes("UTF-8"));
        long j = p.b;
        if (a(p)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    public void a(InterfaceC1429q interfaceC1429q) {
        this.k = interfaceC1429q;
    }

    private void a(OutputStream outputStream, long j) throws IOException, C1448z0 {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, j, 8192);
            if (iA == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, iA);
                j += (long) iA;
            }
        }
    }
}
