package com.kc.cw.ad.internal.d;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class g extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f38962a;
    private final com.kc.cw.ad.internal.d.a.b b;
    private b c;

    public g(j jVar, com.kc.cw.ad.internal.d.a.b bVar) {
        super(jVar, bVar);
        this.b = bVar;
        this.f38962a = jVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) throws IOException, p {
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

    private boolean a(e eVar) throws p {
        long jA = this.f38962a.a();
        return (((jA > 0L ? 1 : (jA == 0L ? 0 : -1)) > 0) && eVar.c && ((float) eVar.b) > ((float) this.b.a()) + (((float) jA) * 0.2f)) ? false : true;
    }

    private String b(e eVar) throws IOException, p {
        String strC = this.f38962a.c();
        boolean zIsEmpty = TextUtils.isEmpty(strC);
        long jA = this.b.d() ? this.b.a() : this.f38962a.a();
        boolean z = jA >= 0;
        boolean z2 = eVar.c;
        long j = z2 ? jA - eVar.b : jA;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(eVar.b), Long.valueOf(jA - 1), Long.valueOf(jA)) : "");
        sb.append(zIsEmpty ^ true ? a("Content-Type: %s\n", strC) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) throws IOException, p {
        j jVar = new j(this.f38962a);
        try {
            jVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = jVar.a(bArr);
                if (iA == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, iA);
            }
        } finally {
            jVar.b();
        }
    }

    @Override // com.kc.cw.ad.internal.d.o
    public void a(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.f38955a, this.f38962a.d(), i);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(e eVar, Socket socket) throws IOException, p {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(eVar).getBytes("UTF-8"));
        long j = eVar.b;
        if (a(eVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
