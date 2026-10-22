package com.google.zxing.datamatrix.encoder;

import com.zj.adlib.v13;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class d implements Encoder {
    public static void c(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            e.g(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    public static String d(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }

    public static void e(v13 v13Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                v13Var.p(0);
                return;
            }
            boolean z = true;
            if (length == 1) {
                v13Var.q();
                int iB = v13Var.h().b() - v13Var.a();
                int iG = v13Var.g();
                if (iG > iB) {
                    v13Var.r(v13Var.a() + 1);
                    iB = v13Var.h().b() - v13Var.a();
                }
                if (iG <= iB && iB <= 2) {
                    v13Var.p(0);
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            String strD = d(charSequence);
            if (!(!v13Var.j()) || i > 2) {
                z = false;
            }
            if (i <= 2) {
                v13Var.r(v13Var.a() + i);
                if (v13Var.h().b() - v13Var.a() >= 3) {
                    v13Var.r(v13Var.a() + strD.length());
                    z = false;
                }
            }
            if (z) {
                v13Var.l();
                v13Var.f45269a -= i;
            } else {
                v13Var.t(strD);
            }
            v13Var.p(0);
        } catch (Throwable th) {
            v13Var.p(0);
            throw th;
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(v13 v13Var) {
        StringBuilder sb = new StringBuilder();
        while (v13Var.j()) {
            c(v13Var.d(), sb);
            v13Var.f45269a++;
            if (sb.length() >= 4) {
                v13Var.t(d(sb));
                sb.delete(0, 4);
                if (e.p(v13Var.e(), v13Var.f45269a, b()) != b()) {
                    v13Var.p(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(v13Var, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 4;
    }
}
