package com.zj.adlib;

import com.google.zxing.datamatrix.encoder.c;
import com.google.zxing.datamatrix.encoder.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class g1a extends c {
    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.Encoder
    public void a(v13 v13Var) {
        StringBuilder sb = new StringBuilder();
        while (v13Var.j()) {
            char cD = v13Var.d();
            v13Var.f45269a++;
            d(cD, sb);
            if (sb.length() % 3 == 0) {
                c.h(v13Var, sb);
                if (e.p(v13Var.e(), v13Var.f45269a, b()) != b()) {
                    v13Var.p(0);
                    break;
                }
            }
        }
        g(v13Var, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int d(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            e.g(c);
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public void g(v13 v13Var, StringBuilder sb) {
        v13Var.q();
        int iB = v13Var.h().b() - v13Var.a();
        v13Var.f45269a -= sb.length();
        if (v13Var.g() > 1 || iB > 1 || v13Var.g() != iB) {
            v13Var.s((char) 254);
        }
        if (v13Var.f() < 0) {
            v13Var.p(0);
        }
    }
}
