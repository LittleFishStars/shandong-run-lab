package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class j0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f26627a;
    public boolean b = true;
    public InputStream c;

    public j0(v vVar) {
        this.f26627a = vVar;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        o oVar;
        if (this.c == null) {
            if (!this.b || (oVar = (o) this.f26627a.a()) == null) {
                return -1;
            }
            this.b = false;
            this.c = oVar.b();
        }
        while (true) {
            int i = this.c.read();
            if (i >= 0) {
                return i;
            }
            o oVar2 = (o) this.f26627a.a();
            if (oVar2 == null) {
                this.c = null;
                return -1;
            }
            this.c = oVar2.b();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        o oVar;
        int i3 = 0;
        if (this.c == null) {
            if (!this.b || (oVar = (o) this.f26627a.a()) == null) {
                return -1;
            }
            this.b = false;
            this.c = oVar.b();
        }
        while (true) {
            int i4 = this.c.read(bArr, i + i3, i2 - i3);
            if (i4 >= 0) {
                i3 += i4;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                o oVar2 = (o) this.f26627a.a();
                if (oVar2 == null) {
                    this.c = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.c = oVar2.b();
            }
        }
    }
}
