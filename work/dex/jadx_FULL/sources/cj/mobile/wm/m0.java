package cj.mobile.wm;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.common.utils.IOUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class m0 extends Writer {
    public static final byte[] dexk;
    public static final byte[] dexl;
    public static final char[] dexn;
    public char[] dexa;
    public int dexb;
    public int dexc;
    public final Writer dexd;
    public static final ThreadLocal<char[]> dexe = new ThreadLocal<>();
    public static final int[] dexf = {9, 99, 999, AVMDLDataLoader.KeyIsEnableEventInfo, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    public static final char[] dexg = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] dexh = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final char[] dexi = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] dexj = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    public static final char[] dexm = new char[93];

    static {
        byte[] bArr = new byte[161];
        dexk = bArr;
        byte[] bArr2 = new byte[161];
        dexl = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            dexk[i] = 4;
            dexl[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            dexk[i2] = 4;
            dexl[i2] = 4;
        }
        char[] cArr = dexm;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = IOUtils.DIR_SEPARATOR_WINDOWS;
        dexn = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public m0(Writer writer, int i, com.wangmai.insightvision.openadsdk.d.j.a0[] a0VarArr) {
        this.dexd = writer;
        ThreadLocal<char[]> threadLocal = dexe;
        char[] cArr = threadLocal.get();
        this.dexa = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.dexa == null) {
            this.dexa = new char[1024];
        }
        for (com.wangmai.insightvision.openadsdk.d.j.a0 a0Var : a0VarArr) {
            i |= a0Var.y;
        }
        this.dexc = i;
    }

    public static void dexa(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            j = -j;
            c = '-';
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = dexi[i2];
            i = i3 - 1;
            cArr[i] = dexh[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = dexi[i6];
            i = i7 - 1;
            cArr[i] = dexh[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = dexg[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            } else {
                i4 = i8;
            }
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    private void dexc(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        int length = str.length();
        boolean z = true;
        int i = this.dexb + length + 1;
        if (i > this.dexa.length) {
            if (this.dexd != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i2);
                    byte[] bArr = dexk;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(34);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt2 = str.charAt(i3);
                    byte[] bArr2 = dexk;
                    if (cCharAt2 < bArr2.length && bArr2[cCharAt2] != 0) {
                        write(92);
                        cCharAt2 = dexm[cCharAt2];
                    }
                    write(cCharAt2);
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            dexa(i);
        }
        if (length == 0) {
            int i4 = this.dexb + 3;
            if (i4 > this.dexa.length) {
                dexa(i4);
            }
            char[] cArr = this.dexa;
            int i5 = this.dexb;
            int i6 = i5 + 1;
            cArr[i5] = '\"';
            int i7 = i6 + 1;
            cArr[i6] = '\"';
            this.dexb = i7 + 1;
            cArr[i7] = com.google.common.net.c.b;
            return;
        }
        int i8 = this.dexb;
        int i9 = i8 + length;
        str.getChars(0, length, this.dexa, i8);
        this.dexb = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.dexa;
            char c = cArr2[i10];
            byte[] bArr3 = dexk;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        dexa(i);
                    }
                    this.dexb = i;
                    char[] cArr3 = this.dexa;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.dexa;
                    cArr4[i10] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i11] = dexm[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        dexa(i);
                    }
                    this.dexb = i;
                    char[] cArr5 = this.dexa;
                    int i12 = i10 + 1;
                    System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.dexa;
                    System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.dexa;
                    cArr7[i8] = '\"';
                    cArr7[i12] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i13 = i12 + 1;
                    cArr7[i13] = dexm[c];
                    i9 += 2;
                    cArr7[this.dexb - 2] = '\"';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.dexa[this.dexb - 1] = com.google.common.net.c.b;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    private void dexd(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        int length = str.length();
        boolean z = true;
        int i = this.dexb + length + 1;
        if (i > this.dexa.length) {
            if (this.dexd != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i2);
                    byte[] bArr = dexl;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt2 = str.charAt(i3);
                    byte[] bArr2 = dexl;
                    if (cCharAt2 < bArr2.length && bArr2[cCharAt2] != 0) {
                        write(92);
                        cCharAt2 = dexm[cCharAt2];
                    }
                    write(cCharAt2);
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            dexa(i);
        }
        if (length == 0) {
            int i4 = this.dexb + 3;
            if (i4 > this.dexa.length) {
                dexa(i4);
            }
            char[] cArr = this.dexa;
            int i5 = this.dexb;
            int i6 = i5 + 1;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            cArr[i6] = '\'';
            this.dexb = i7 + 1;
            cArr[i7] = com.google.common.net.c.b;
            return;
        }
        int i8 = this.dexb;
        int i9 = i8 + length;
        str.getChars(0, length, this.dexa, i8);
        this.dexb = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.dexa;
            char c = cArr2[i10];
            byte[] bArr3 = dexl;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        dexa(i);
                    }
                    this.dexb = i;
                    char[] cArr3 = this.dexa;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.dexa;
                    cArr4[i10] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i11] = dexm[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        dexa(i);
                    }
                    this.dexb = i;
                    char[] cArr5 = this.dexa;
                    int i12 = i10 + 1;
                    System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.dexa;
                    System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.dexa;
                    cArr7[i8] = '\'';
                    cArr7[i12] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    int i13 = i12 + 1;
                    cArr7[i13] = dexm[c];
                    i9 += 2;
                    cArr7[this.dexb - 2] = '\'';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.dexa[i - 1] = com.google.common.net.c.b;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.dexd != null && this.dexb > 0) {
            flush();
        }
        char[] cArr = this.dexa;
        if (cArr.length <= 8192) {
            dexe.set(cArr);
        }
        this.dexa = null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public m0 append(char c) throws com.wangmai.insightvision.openadsdk.d.d {
        write(c);
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public m0 append(CharSequence charSequence) throws com.wangmai.insightvision.openadsdk.d.d {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public m0 append(CharSequence charSequence, int i, int i2) throws com.wangmai.insightvision.openadsdk.d.d {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i, i2).toString();
        write(string, 0, string.length());
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa() throws com.wangmai.insightvision.openadsdk.d.d {
        write("null");
    }

    public void dexa(int i) {
        char[] cArr = this.dexa;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.dexb);
        this.dexa = cArr2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(long j) throws com.wangmai.insightvision.openadsdk.d.d {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j2 = j < 0 ? -j : j;
        int i = 1;
        long j3 = 10;
        while (true) {
            if (i >= 19) {
                i = 0;
                break;
            } else {
                if (j2 < j3) {
                    break;
                }
                j3 *= 10;
                i++;
            }
        }
        int i2 = i != 0 ? i : 19;
        if (j < 0) {
            i2++;
        }
        int i3 = this.dexb + i2;
        if (i3 > this.dexa.length) {
            if (this.dexd != null) {
                char[] cArr = new char[i2];
                dexa(j, i2, cArr);
                write(cArr, 0, i2);
                return;
            }
            dexa(i3);
        }
        dexa(j, i3, this.dexa);
        this.dexb = i3;
    }

    public void dexa(com.wangmai.insightvision.openadsdk.d.j.a0 a0Var, boolean z) {
        int i;
        if (z) {
            i = a0Var.y | this.dexc;
        } else {
            i = (~a0Var.y) & this.dexc;
        }
        this.dexc = i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        if ((this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0) {
            dexb(str);
        } else {
            dexa(str, (char) 0, true);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:58:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db A[PHI: r4 r13
      0x00db: PHI (r4v21 int) = (r4v18 int), (r4v24 int) binds: [B:75:0x00d9, B:40:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r13v6 int) = (r13v4 int), (r13v9 int) binds: [B:75:0x00d9, B:40:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0 A[PHI: r4 r13 r14
      0x00e0: PHI (r4v23 int) = (r4v18 int), (r4v20 int), (r4v24 int) binds: [B:75:0x00d9, B:50:0x00a0, B:40:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r13v8 int) = (r13v4 int), (r13v5 int), (r13v9 int) binds: [B:75:0x00d9, B:50:0x00a0, B:40:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r14v14 int) = (r14v1 int), (r14v10 int), (r14v1 int) binds: [B:75:0x00d9, B:50:0x00a0, B:40:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    public void dexa(String str, char c, boolean z) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        boolean z2;
        if (str == null) {
            dexa();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i2 = this.dexb + length + 2;
        if (c != 0) {
            i2++;
        }
        char c2 = '/';
        if (i2 > this.dexa.length) {
            if (this.dexd != null) {
                write(34);
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char cCharAt = str.charAt(i3);
                    byte[] bArr = dexk;
                    if ((cCharAt < bArr.length && bArr[cCharAt] != 0) || (cCharAt == '/' && (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.p.y) != 0)) {
                        write(92);
                        cCharAt = dexm[cCharAt];
                    }
                    write(cCharAt);
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            dexa(i2);
        }
        int i4 = this.dexb;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.dexa;
        cArr[i4] = '\"';
        str.getChars(0, length, cArr, i5);
        this.dexb = i2;
        if (z) {
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            char c3 = 0;
            int i10 = i5;
            while (i10 < i6) {
                char c4 = this.dexa[i10];
                if (c4 == 8232) {
                    i9++;
                    i2 += 4;
                    if (i7 == -1) {
                        c3 = c4;
                        i7 = i10;
                        i8 = i7;
                    } else {
                        c3 = c4;
                        i8 = i10;
                    }
                } else if (c4 < ']') {
                    if (c4 == ' ') {
                        z2 = false;
                    } else if (c4 != c2) {
                        z2 = c4 <= '#' ? true : true;
                    } else if ((com.wangmai.insightvision.openadsdk.d.j.a0.p.y & this.dexc) == 0) {
                        if ((c4 <= '#' && c4 != '\\') || (c4 > 31 && c4 != '\\' && c4 != '\"')) {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        i9++;
                        byte[] bArr2 = dexk;
                        if (c4 < bArr2.length && bArr2[c4] == 4) {
                            i2 += 4;
                        }
                        if (i7 == -1) {
                            c3 = c4;
                            i7 = i10;
                            i8 = i7;
                        } else {
                            c3 = c4;
                            i8 = i10;
                        }
                    }
                } else if (c4 >= 127 && c4 < 160) {
                    if (i7 == -1) {
                        i7 = i10;
                    }
                    i9++;
                    i2 += 4;
                    c3 = c4;
                    i8 = i10;
                }
                i10++;
                c2 = '/';
            }
            if (i9 > 0) {
                int i11 = i2 + i9;
                if (i11 > this.dexa.length) {
                    dexa(i11);
                }
                this.dexb = i11;
                if (i9 == 1) {
                    if (c3 == 8232) {
                        int i12 = i8 + 1;
                        char[] cArr2 = this.dexa;
                        System.arraycopy(cArr2, i12, cArr2, i8 + 6, (i6 - i8) - 1);
                        char[] cArr3 = this.dexa;
                        cArr3[i8] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr3[i12] = 'u';
                        int i13 = i12 + 1;
                        cArr3[i13] = '2';
                        int i14 = i13 + 1;
                        cArr3[i14] = '0';
                        int i15 = i14 + 1;
                        cArr3[i15] = '2';
                        cArr3[i15 + 1] = '8';
                    } else {
                        byte[] bArr3 = dexk;
                        if (c3 >= bArr3.length || bArr3[c3] != 4) {
                            int i16 = i8 + 1;
                            char[] cArr4 = this.dexa;
                            System.arraycopy(cArr4, i16, cArr4, i8 + 2, (i6 - i8) - 1);
                            char[] cArr5 = this.dexa;
                            cArr5[i8] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr5[i16] = dexm[c3];
                        } else {
                            int i17 = i8 + 1;
                            char[] cArr6 = this.dexa;
                            System.arraycopy(cArr6, i17, cArr6, i8 + 6, (i6 - i8) - 1);
                            char[] cArr7 = this.dexa;
                            cArr7[i8] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            int i18 = i17 + 1;
                            cArr7[i17] = 'u';
                            int i19 = i18 + 1;
                            char[] cArr8 = dexn;
                            cArr7[i18] = cArr8[(c3 >>> '\f') & 15];
                            int i20 = i19 + 1;
                            cArr7[i19] = cArr8[(c3 >>> '\b') & 15];
                            cArr7[i20] = cArr8[(c3 >>> 4) & 15];
                            cArr7[i20 + 1] = cArr8[c3 & 15];
                        }
                    }
                } else if (i9 > 1) {
                    for (int i21 = i7 - i5; i21 < str.length(); i21++) {
                        char cCharAt2 = str.charAt(i21);
                        byte[] bArr4 = dexk;
                        if ((cCharAt2 >= bArr4.length || bArr4[cCharAt2] == 0) && (cCharAt2 != '/' || (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.p.y) == 0)) {
                            char[] cArr9 = this.dexa;
                            int i22 = i7 + 1;
                            if (cCharAt2 == 8232) {
                                cArr9[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
                                int i23 = i22 + 1;
                                cArr9[i22] = 'u';
                                int i24 = i23 + 1;
                                char[] cArr10 = dexn;
                                cArr9[i23] = cArr10[(cCharAt2 >>> '\f') & 15];
                                int i25 = i24 + 1;
                                cArr9[i24] = cArr10[(cCharAt2 >>> '\b') & 15];
                                int i26 = i25 + 1;
                                cArr9[i25] = cArr10[(cCharAt2 >>> 4) & 15];
                                cArr9[i26] = cArr10[cCharAt2 & 15];
                                i7 = i26 + 1;
                            } else {
                                cArr9[i7] = cCharAt2;
                                i7 = i22;
                            }
                        } else {
                            char[] cArr11 = this.dexa;
                            int i27 = i7 + 1;
                            cArr11[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            if (bArr4[cCharAt2] == 4) {
                                int i28 = i27 + 1;
                                cArr11[i27] = 'u';
                                int i29 = i28 + 1;
                                char[] cArr12 = dexn;
                                cArr11[i28] = cArr12[(cCharAt2 >>> '\f') & 15];
                                int i30 = i29 + 1;
                                cArr11[i29] = cArr12[(cCharAt2 >>> '\b') & 15];
                                int i31 = i30 + 1;
                                cArr11[i30] = cArr12[(cCharAt2 >>> 4) & 15];
                                i = i31 + 1;
                                cArr11[i31] = cArr12[cCharAt2 & 15];
                            } else {
                                i = i27 + 1;
                                cArr11[i27] = dexm[cCharAt2];
                            }
                            i7 = i;
                        }
                    }
                }
            }
        }
        if (c == 0) {
            this.dexa[this.dexb - 1] = '\"';
            return;
        }
        char[] cArr13 = this.dexa;
        int i32 = this.dexb;
        cArr13[i32 - 2] = '\"';
        cArr13[i32 - 1] = c;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(String str, boolean z) throws com.wangmai.insightvision.openadsdk.d.d {
        int i = this.dexc;
        if ((com.wangmai.insightvision.openadsdk.d.j.a0.b.y & i) == 0) {
            if ((i & com.wangmai.insightvision.openadsdk.d.j.a0.a.y) != 0) {
                dexa(str, com.google.common.net.c.b, z);
                return;
            } else {
                dexc(str);
                return;
            }
        }
        if ((com.wangmai.insightvision.openadsdk.d.j.a0.a.y & i) == 0) {
            dexd(str);
        } else {
            dexb(str);
            write(58);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(boolean z) throws com.wangmai.insightvision.openadsdk.d.d {
        write(z ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(byte[] bArr) throws com.wangmai.insightvision.openadsdk.d.d {
        int length = bArr.length;
        boolean z = (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0;
        char c = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = dex13.dexy;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.dexb;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        if (i4 > this.dexa.length) {
            if (this.dexd != null) {
                write(c);
                int i5 = 0;
                while (i5 < i) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                    i5 = i7 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = ((bArr[i] & 255) << 10) | (i9 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : '=');
                    write(61);
                }
                write(c);
                return;
            }
            dexa(i4);
        }
        this.dexb = i4;
        int i11 = i3 + 1;
        this.dexa[i3] = c;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.dexa;
            int i18 = i11 + 1;
            cArr2[i11] = cArr[(i17 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(i17 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i17 >>> 6) & 63];
            i11 = i20 + 1;
            cArr2[i20] = cArr[i17 & 63];
            i12 = i16;
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.dexa;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i21 == 2 ? cArr[i22 & 63] : '=';
            cArr3[i4 - 2] = com.alipay.sdk.m.p.a.h;
        }
        this.dexa[i4 - 1] = c;
    }

    public boolean dexa(com.wangmai.insightvision.openadsdk.d.j.a0 a0Var) {
        return (a0Var.y & this.dexc) != 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexb(int i) throws com.wangmai.insightvision.openadsdk.d.d {
        int i2;
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i3 = i < 0 ? -i : i;
        int i4 = 0;
        do {
            i2 = dexf[i4];
            i4++;
        } while (i3 > i2);
        if (i < 0) {
            i4++;
        }
        int i5 = this.dexb + i4;
        if (i5 > this.dexa.length) {
            if (this.dexd != null) {
                char[] cArr = new char[i4];
                dexa(i, i4, cArr);
                write(cArr, 0, i4);
                return;
            }
            dexa(i5);
        }
        dexa(i, i5, this.dexa);
        this.dexb = i5;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexb(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        int i = 0;
        if (str == null) {
            int i2 = this.dexb + 4;
            if (i2 > this.dexa.length) {
                dexa(i2);
            }
            "null".getChars(0, 4, this.dexa, this.dexb);
            this.dexb = i2;
            return;
        }
        int length = str.length();
        int i3 = this.dexb + length + 2;
        if (i3 > this.dexa.length) {
            if (this.dexd != null) {
                write(39);
                while (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.p.y) != 0)) {
                        write(92);
                        cCharAt = dexm[cCharAt];
                    }
                    write(cCharAt);
                    i++;
                }
                write(39);
                return;
            }
            dexa(i3);
        }
        int i4 = this.dexb;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.dexa;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.dexb = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.dexa[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.p.y) != 0)) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.dexa.length) {
            dexa(i9);
        }
        this.dexb = i9;
        if (i == 1) {
            char[] cArr2 = this.dexa;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.dexa;
            cArr3[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i10] = dexm[c];
        } else if (i > 1) {
            char[] cArr4 = this.dexa;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.dexa;
            cArr5[i7] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i11] = dexm[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char[] cArr6 = this.dexa;
                char c3 = cArr6[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.p.y) != 0)) {
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.dexa;
                    cArr7[i13] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i14] = dexm[c3];
                    i12++;
                }
            }
        }
        this.dexa[this.dexb - 1] = '\'';
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws com.wangmai.insightvision.openadsdk.d.d {
        Writer writer = this.dexd;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.dexa, 0, this.dexb);
            this.dexd.flush();
            this.dexb = 0;
        } catch (IOException e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage(), e);
        }
    }

    public String toString() {
        return new String(this.dexa, 0, this.dexb);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer
    public void write(int i) throws com.wangmai.insightvision.openadsdk.d.d {
        int i2 = 1;
        int i3 = this.dexb + 1;
        if (i3 <= this.dexa.length) {
            i2 = i3;
        } else if (this.dexd == null) {
            dexa(i3);
            i2 = i3;
        } else {
            flush();
        }
        this.dexa[this.dexb] = (char) i;
        this.dexb = i2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer
    public void write(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        if (str == null) {
            dexa();
        } else {
            write(str, 0, str.length());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws com.wangmai.insightvision.openadsdk.d.d {
        int i3;
        int i4 = this.dexb + i2;
        if (i4 > this.dexa.length) {
            if (this.dexd == null) {
                dexa(i4);
            } else {
                while (true) {
                    char[] cArr = this.dexa;
                    int length = cArr.length;
                    int i5 = this.dexb;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.dexb = this.dexa.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.dexa.length) {
                        break;
                    } else {
                        i = i3;
                    }
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.dexa, this.dexb);
        this.dexb = i4;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws com.wangmai.insightvision.openadsdk.d.d {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.dexb + i2;
        if (i4 > this.dexa.length) {
            if (this.dexd == null) {
                dexa(i4);
            } else {
                do {
                    char[] cArr2 = this.dexa;
                    int length = cArr2.length;
                    int i5 = this.dexb;
                    int i6 = length - i5;
                    System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.dexb = this.dexa.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.dexa.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.dexa, this.dexb, i2);
        this.dexb = i4;
    }
}
