package com.zj.adlib;

import com.google.zxing.aztec.encoder.c;
import com.google.zxing.common.CharacterSetECI;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class j04 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42478a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f17303a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f17304a = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[][] f17305b;
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[][] f17306c;
    public static final int d = 3;
    public static final int e = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Charset f17307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f17308a;

    public class a implements Comparator<c> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return cVar.f() - cVar2.f();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f17305b = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            f17305b[0][i] = (i - 65) + 2;
        }
        f17305b[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            f17305b[1][i2] = (i2 - 97) + 2;
        }
        f17305b[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            f17305b[2][i3] = (i3 - 48) + 2;
        }
        int[] iArr2 = f17305b[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            f17305b[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr4[i5];
            if (i6 > 0) {
                f17305b[4][i6] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f17306c = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f17306c;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public j04(byte[] bArr) {
        this.f17308a = bArr;
        this.f17307a = null;
    }

    public static Collection<c> b(Iterable<c> iterable) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        for (c cVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                c cVar2 = (c) it.next();
                if (cVar2.i(cVar)) {
                    z = false;
                    break;
                }
                if (cVar.i(cVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.addFirst(cVar);
            }
        }
        return linkedList;
    }

    public static void d(c cVar, int i, int i2, Collection<c> collection) {
        c cVarD = cVar.d(i);
        collection.add(cVarD.j(4, i2));
        if (cVar.g() != 4) {
            collection.add(cVarD.k(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(cVarD.j(2, 16 - i2).j(2, 1));
        }
        if (cVar.e() > 0) {
            collection.add(cVar.a(i).a(i + 1));
        }
    }

    public static Collection<c> f(Iterable<c> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<c> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i, i2, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    public qv0 a() {
        int i;
        c cVarB = c.f32501a;
        Charset charset = this.f17307a;
        if (charset != null) {
            CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECI(charset);
            if (characterSetECI == null) {
                throw new IllegalArgumentException("No ECI code for character set " + this.f17307a);
            }
            cVarB = cVarB.b(characterSetECI.getValue());
        }
        Collection<c> collectionSingletonList = Collections.singletonList(cVarB);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f17308a;
            if (i2 >= bArr.length) {
                return ((c) Collections.min(collectionSingletonList, new a())).l(this.f17308a);
            }
            int i3 = i2 + 1;
            byte b2 = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b3 = bArr[i2];
            if (b3 != 13) {
                if (b3 != 44) {
                    if (b3 != 46) {
                        if (b3 == 58 && b2 == 32) {
                            i = 5;
                        } else {
                            i = 0;
                        }
                    } else if (b2 == 32) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                } else if (b2 == 32) {
                    i = 4;
                } else {
                    i = 0;
                }
            } else if (b2 == 10) {
                i = 2;
            } else {
                i = 0;
            }
            if (i > 0) {
                collectionSingletonList = f(collectionSingletonList, i2, i);
                i2 = i3;
            } else {
                collectionSingletonList = e(collectionSingletonList, i2);
            }
            i2++;
        }
    }

    public final void c(c cVar, int i, Collection<c> collection) {
        char c2 = (char) (this.f17308a[i] & 255);
        boolean z = f17305b[cVar.g()][c2] > 0;
        c cVarD = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = f17305b[i2][c2];
            if (i3 > 0) {
                if (cVarD == null) {
                    cVarD = cVar.d(i);
                }
                if (!z || i2 == cVar.g() || i2 == 2) {
                    collection.add(cVarD.j(i2, i3));
                }
                if (!z && f17306c[cVar.g()][i2] >= 0) {
                    collection.add(cVarD.k(i2, i3));
                }
            }
        }
        if (cVar.e() > 0 || f17305b[cVar.g()][c2] == 0) {
            collection.add(cVar.a(i));
        }
    }

    public final Collection<c> e(Iterable<c> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<c> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i, linkedList);
        }
        return b(linkedList);
    }

    public j04(byte[] bArr, Charset charset) {
        this.f17308a = bArr;
        this.f17307a = charset;
    }
}
