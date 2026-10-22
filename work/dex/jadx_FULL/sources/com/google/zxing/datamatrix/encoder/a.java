package com.google.zxing.datamatrix.encoder;

import com.zj.adlib.v13;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a implements Encoder {
    public static char c(char c, char c2) {
        if (e.h(c) && e.h(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(v13 v13Var) {
        if (e.a(v13Var.e(), v13Var.f45269a) >= 2) {
            v13Var.s(c(v13Var.e().charAt(v13Var.f45269a), v13Var.e().charAt(v13Var.f45269a + 1)));
            v13Var.f45269a += 2;
            return;
        }
        char cD = v13Var.d();
        int iP = e.p(v13Var.e(), v13Var.f45269a, b());
        if (iP == b()) {
            if (!e.i(cD)) {
                v13Var.s((char) (cD + 1));
                v13Var.f45269a++;
                return;
            } else {
                v13Var.s(e.d);
                v13Var.s((char) ((cD - 128) + 1));
                v13Var.f45269a++;
                return;
            }
        }
        if (iP == 1) {
            v13Var.s(e.b);
            v13Var.p(1);
            return;
        }
        if (iP == 2) {
            v13Var.s(e.h);
            v13Var.p(2);
            return;
        }
        if (iP == 3) {
            v13Var.s(e.g);
            v13Var.p(3);
            return;
        }
        if (iP == 4) {
            v13Var.s(e.i);
            v13Var.p(4);
        } else if (iP == 5) {
            v13Var.s(e.c);
            v13Var.p(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iP);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 0;
    }
}
