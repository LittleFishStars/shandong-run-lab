package com.byazt.mk;

import com.aliyun.openapiutil.Client;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.b85;
import com.zj.adlib.o61;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 34})
public class a implements Serializable, Comparable<a> {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final a tt = c(new byte[0]);
    public transient String n;
    public transient int uj;
    public final byte[] ve;

    public a(byte[] bArr) {
        this.ve = bArr;
    }

    public static a c(byte... bArr) {
        if (bArr != null) {
            return new a((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public a a() {
        int i = 0;
        while (true) {
            byte[] bArr = this.ve;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new a(bArr2);
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int iSp = aVar.sp();
            byte[] bArr = this.ve;
            if (iSp == bArr.length && aVar.c(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.uj;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.ve);
        this.uj = iHashCode;
        return iHashCode;
    }

    public String n() {
        byte[] bArr = this.ve;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = c;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & com.google.common.base.a.q];
        }
        return new String(cArr);
    }

    public int sp() {
        return this.ve.length;
    }

    public String toString() {
        if (this.ve.length == 0) {
            return "[size=0]";
        }
        String strC = c();
        int iC = c(strC, 64);
        if (iC == -1) {
            if (this.ve.length <= 64) {
                return "[hex=" + n() + "]";
            }
            return "[size=" + this.ve.length + " hex=" + c(0, 64).n() + "…]";
        }
        String strReplace = strC.substring(0, iC).replace(o61.h, "\\\\").replace("\n", "\\n").replace(b85.b, "\\r");
        if (iC >= strC.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.ve.length + " text=" + strReplace + "…]";
    }

    public String tt() {
        return tt.c(this.ve);
    }

    public a uj() {
        return ve(Client.HASH_SHA256);
    }

    public a ve() {
        return ve("SHA-1");
    }

    public byte[] x() {
        return (byte[]) this.ve.clone();
    }

    public static a tt(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((c(str.charAt(i2)) << 4) + c(str.charAt(i2 + 1)));
        }
        return c(bArr);
    }

    private a ve(String str) {
        try {
            return c(MessageDigest.getInstance(str).digest(this.ve));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static a c(String str) {
        if (str != null) {
            a aVar = new a(str.getBytes(rl.c));
            aVar.n = str;
            return aVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String c() {
        String str = this.n;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.ve, rl.c);
        this.n = str2;
        return str2;
    }

    private static int c(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c2)));
            }
        }
        return (c2 - c3) + 10;
    }

    public a c(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.ve;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.ve.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new a(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        int iSp = sp();
        int iSp2 = aVar.sp();
        int iMin = Math.min(iSp, iSp2);
        for (int i = 0; i < iMin; i++) {
            int iC = c(i) & 255;
            int iC2 = aVar.c(i) & 255;
            if (iC != iC2) {
                return iC < iC2 ? -1 : 1;
            }
        }
        if (iSp == iSp2) {
            return 0;
        }
        return iSp < iSp2 ? -1 : 1;
    }

    public byte c(int i) {
        return this.ve[i];
    }

    public void c(ve veVar) {
        byte[] bArr = this.ve;
        veVar.ve(bArr, 0, bArr.length);
    }

    public boolean c(int i, a aVar, int i2, int i3) {
        return aVar.c(i2, this.ve, i, i3);
    }

    public boolean c(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.ve;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && rl.c(bArr2, i, bArr, i2, i3);
    }

    public final boolean c(a aVar) {
        return c(0, aVar, 0, aVar.sp());
    }

    public static int c(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
