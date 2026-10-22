package com.google.zxing.datamatrix.encoder;

import com.zj.adlib.v13;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class c implements Encoder {
    public static String f(CharSequence charSequence) {
        int iCharAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void h(v13 v13Var, StringBuilder sb) {
        v13Var.t(f(sb));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void a(v13 v13Var) {
        StringBuilder sb = new StringBuilder();
        while (v13Var.j()) {
            char cD = v13Var.d();
            v13Var.f45269a++;
            int iD = d(cD, sb);
            int iA = v13Var.a() + ((sb.length() / 3) * 2);
            v13Var.r(iA);
            int iB = v13Var.h().b() - iA;
            if (!v13Var.j()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && iB != 2) {
                    iD = c(v13Var, sb, sb2, iD);
                }
                while (sb.length() % 3 == 1 && (iD > 3 || iB != 1)) {
                    iD = c(v13Var, sb, sb2, iD);
                }
                break;
            }
            if (sb.length() % 3 == 0 && e.p(v13Var.e(), v13Var.f45269a, b()) != b()) {
                v13Var.p(0);
                break;
            }
        }
        g(v13Var, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 1;
    }

    public final int c(v13 v13Var, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        v13Var.f45269a--;
        int iD = d(v13Var.d(), sb2);
        v13Var.l();
        return iD;
    }

    public int d(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        }
        if (c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c > 127) {
            sb.append("\u0001\u001e");
            return d((char) (c - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c - '`'));
        return 2;
    }

    public void e(v13 v13Var) {
        StringBuilder sb = new StringBuilder();
        int i = v13Var.f45269a;
        int length = 0;
        int iD = 0;
        while (v13Var.j()) {
            char cD = v13Var.d();
            v13Var.f45269a++;
            iD = d(cD, sb);
            if (sb.length() % 3 == 0) {
                i = v13Var.f45269a;
                length = sb.length();
            }
        }
        if (length != sb.length()) {
            int iA = v13Var.a() + ((sb.length() / 3) * 2) + 1;
            v13Var.r(iA);
            int iB = v13Var.h().b() - iA;
            int length2 = sb.length() % 3;
            if ((length2 == 2 && iB != 2) || (length2 == 1 && (iD > 3 || iB != 1))) {
                sb.setLength(length);
                v13Var.f45269a = i;
            }
        }
        if (sb.length() > 0) {
            v13Var.s(e.b);
        }
        g(v13Var, sb);
    }

    public void g(v13 v13Var, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int iA = v13Var.a() + length;
        v13Var.r(iA);
        int iB = v13Var.h().b() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                h(v13Var, sb);
            }
            if (v13Var.j()) {
                v13Var.s((char) 254);
            }
        } else if (iB == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                h(v13Var, sb);
            }
            if (v13Var.j()) {
                v13Var.s((char) 254);
            }
            v13Var.f45269a--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                h(v13Var, sb);
            }
            if (iB > 0 || v13Var.j()) {
                v13Var.s((char) 254);
            }
        }
        v13Var.p(0);
    }
}
