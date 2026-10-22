package com.byazt.uc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 13})
public final class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29084a;
    public final String c;
    public int n;
    public char[] sp;
    public final int tt;
    public int uj;
    public int ve;

    public tt(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.c = name;
        this.tt = name.length();
    }

    private char a() {
        int i;
        int i2;
        int iC = c(this.ve);
        this.ve++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i = iC & 31;
            i2 = 1;
        } else if (iC <= 239) {
            i = iC & 15;
            i2 = 2;
        } else {
            i = iC & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.ve + 1;
            this.ve = i4;
            if (i4 == this.tt || this.sp[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.ve = i5;
            int iC2 = c(i5);
            this.ve++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (iC2 & 63);
        }
        return (char) i;
    }

    private String c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.ve;
            i2 = this.tt;
            if (i >= i2 || this.sp[i] != ' ') {
                break;
            }
            this.ve = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.uj = i;
        this.ve = i + 1;
        while (true) {
            i3 = this.ve;
            i4 = this.tt;
            if (i3 >= i4 || (c3 = this.sp[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.ve = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.c);
        }
        this.n = i3;
        if (this.sp[i3] == ' ') {
            while (true) {
                i6 = this.ve;
                i7 = this.tt;
                if (i6 >= i7 || (c2 = this.sp[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.ve = i6 + 1;
            }
            if (this.sp[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.c);
            }
        }
        do {
            i5 = this.ve + 1;
            this.ve = i5;
            if (i5 >= this.tt) {
                break;
            }
        } while (this.sp[i5] == ' ');
        int i8 = this.n;
        int i9 = this.uj;
        if (i8 - i9 > 4) {
            char[] cArr = this.sp;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.uj = i9 + 4;
            }
        }
        char[] cArr2 = this.sp;
        int i10 = this.uj;
        return new String(cArr2, i10, i8 - i10);
    }

    private char n() {
        int i = this.ve + 1;
        this.ve = i;
        if (i == this.tt) {
            throw new IllegalStateException("Unexpected end of DN: " + this.c);
        }
        char c = this.sp[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return a();
                }
        }
    }

    private String tt() {
        int i = this.ve + 1;
        this.ve = i;
        this.uj = i;
        this.n = i;
        while (true) {
            int i2 = this.ve;
            if (i2 == this.tt) {
                throw new IllegalStateException("Unexpected end of DN: " + this.c);
            }
            char[] cArr = this.sp;
            char c = cArr[i2];
            if (c == '\"') {
                this.ve = i2 + 1;
                while (true) {
                    int i3 = this.ve;
                    if (i3 >= this.tt || this.sp[i3] != ' ') {
                        break;
                    }
                    this.ve = i3 + 1;
                }
                char[] cArr2 = this.sp;
                int i4 = this.uj;
                return new String(cArr2, i4, this.n - i4);
            }
            if (c == '\\') {
                cArr[this.n] = n();
            } else {
                cArr[this.n] = c;
            }
            this.ve++;
            this.n++;
        }
    }

    private String uj() {
        int i;
        int i2;
        char c;
        int i3 = this.ve;
        this.uj = i3;
        this.n = i3;
        while (true) {
            int i4 = this.ve;
            if (i4 >= this.tt) {
                char[] cArr = this.sp;
                int i5 = this.uj;
                return new String(cArr, i5, this.n - i5);
            }
            char[] cArr2 = this.sp;
            char c2 = cArr2[i4];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 == '\\') {
                        int i6 = this.n;
                        this.n = i6 + 1;
                        cArr2[i6] = n();
                        this.ve++;
                    } else if (c2 != '+' && c2 != ',') {
                        int i7 = this.n;
                        this.n = i7 + 1;
                        cArr2[i7] = c2;
                        this.ve = i4 + 1;
                    }
                }
                int i8 = this.uj;
                return new String(cArr2, i8, this.n - i8);
            }
            int i9 = this.n;
            this.f29084a = i9;
            this.ve = i4 + 1;
            this.n = i9 + 1;
            cArr2[i9] = ' ';
            while (true) {
                i = this.ve;
                i2 = this.tt;
                if (i >= i2) {
                    break;
                }
                char[] cArr3 = this.sp;
                if (cArr3[i] != ' ') {
                    break;
                }
                int i10 = this.n;
                this.n = i10 + 1;
                cArr3[i10] = ' ';
                this.ve = i + 1;
            }
            if (i == i2 || (c = this.sp[i]) == ',' || c == '+' || c == ';') {
                char[] cArr4 = this.sp;
                int i11 = this.uj;
                return new String(cArr4, i11, this.f29084a - i11);
            }
        }
    }

    private String ve() {
        char[] cArr;
        char c;
        int i = this.ve;
        if (i + 4 >= this.tt) {
            throw new IllegalStateException("Unexpected end of DN: " + this.c);
        }
        this.uj = i;
        this.ve = i + 1;
        while (true) {
            int i2 = this.ve;
            if (i2 == this.tt || (c = (cArr = this.sp)[i2]) == '+' || c == ',' || c == ';') {
                this.n = i2;
                break;
            }
            if (c == ' ') {
                this.n = i2;
                this.ve = i2 + 1;
                while (true) {
                    int i3 = this.ve;
                    if (i3 >= this.tt || this.sp[i3] != ' ') {
                        break;
                    }
                    this.ve = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.ve = i2 + 1;
            }
        }
        int i4 = this.n;
        int i5 = this.uj;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.c);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) c(i8);
            i8 += 2;
        }
        return new String(this.sp, this.uj, i6);
    }

    private int c(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.tt) {
            char[] cArr = this.sp;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else {
                if (c < 'A' || c > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.c);
                }
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.c);
                }
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.c);
    }

    public String c(String str) {
        String strTt;
        this.ve = 0;
        this.uj = 0;
        this.n = 0;
        this.f29084a = 0;
        this.sp = this.c.toCharArray();
        String strC = c();
        if (strC == null) {
            return null;
        }
        do {
            int i = this.ve;
            if (i == this.tt) {
                return null;
            }
            char c = this.sp[i];
            if (c == '\"') {
                strTt = tt();
            } else if (c != '#') {
                strTt = (c == '+' || c == ',' || c == ';') ? "" : uj();
            } else {
                strTt = ve();
            }
            if (str.equalsIgnoreCase(strC)) {
                return strTt;
            }
            int i2 = this.ve;
            if (i2 >= this.tt) {
                return null;
            }
            char c2 = this.sp[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.c);
            }
            this.ve = i2 + 1;
            strC = c();
        } while (strC != null);
        throw new IllegalStateException("Malformed DN: " + this.c);
    }
}
