package com.zj.adlib;

import com.google.zxing.datamatrix.encoder.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class o39 extends c {
    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.Encoder
    public int b() {
        return 2;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int d(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'a' && c <= 'z') {
            sb.append((char) ((c - 'a') + 14));
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
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c == '`') {
            sb.append((char) 2);
            sb.append((char) 0);
            return 2;
        }
        if (c <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c - 'A') + 1));
            return 2;
        }
        if (c > 127) {
            sb.append("\u0001\u001e");
            return d((char) (c - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) ((c - '{') + 27));
        return 2;
    }
}
