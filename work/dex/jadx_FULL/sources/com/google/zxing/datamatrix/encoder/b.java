package com.google.zxing.datamatrix.encoder;

import com.zj.adlib.v13;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b implements Encoder {
    public static char c(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(v13 v13Var) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (v13Var.j()) {
            sb.append(v13Var.d());
            v13Var.f45269a++;
            if (e.p(v13Var.e(), v13Var.f45269a, b()) != b()) {
                v13Var.p(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = v13Var.a() + length + 1;
        v13Var.r(iA);
        boolean z = v13Var.h().b() - iA > 0;
        if (v13Var.j() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            v13Var.s(c(sb.charAt(i), v13Var.a() + 1));
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 5;
    }
}
