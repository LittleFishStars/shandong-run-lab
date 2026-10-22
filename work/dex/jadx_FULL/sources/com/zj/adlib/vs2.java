package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vs2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45438a = 16;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20295a = "DvbParser";
    public static final int b = 17;
    public static final int c = 18;
    public static final int d = 19;
    public static final int e = 20;
    public static final int f = 0;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 16;
    public static final int l = 17;
    public static final int m = 18;
    public static final int n = 32;
    public static final int o = 33;
    public static final int p = 34;
    public static final int q = 240;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f20299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Canvas f20300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f20301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f20302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f20303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h f20304a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f20305b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f20296a = {0, 7, 8, com.google.common.base.a.q};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f20297b = {0, 119, -120, -1};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f20298c = {0, 17, 34, com.alibaba.ariver.resource.parser.a.e.l, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45439a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f20306a;
        public final int[] b;
        public final int[] c;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f45439a = i;
            this.f20306a = iArr;
            this.b = iArr2;
            this.c = iArr3;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45440a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f45440a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45441a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f20307a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f20308a;
        public final byte[] b;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f45441a = i;
            this.f20307a = z;
            this.f20308a = bArr;
            this.b = bArr2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45442a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<e> f20309a;
        public final int b;
        public final int c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f45442a = i;
            this.b = i2;
            this.c = i3;
            this.f20309a = sparseArray;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45443a;
        public final int b;

        public e(int i, int i2) {
            this.f45443a = i;
            this.b = i2;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45444a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<g> f20310a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f20311a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f45444a = i;
            this.f20311a = z;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.f20310a = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f20310a;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.f20310a.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45445a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f45445a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45446a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public b f20313a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public d f20314a;
        public final int b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<f> f20312a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final SparseArray<a> f20315b = new SparseArray<>();
        public final SparseArray<c> c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();

        public h(int i, int i2) {
            this.f45446a = i;
            this.b = i2;
        }

        public void a() {
            this.f20312a.clear();
            this.f20315b.clear();
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f20313a = null;
            this.f20314a = null;
        }
    }

    public vs2(int i2, int i3) {
        Paint paint = new Paint();
        this.f20301a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f20305b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f20300a = new Canvas();
        this.f20303a = new b(719, 575, 0, 719, 0, 575);
        this.f20302a = new a(0, c(), d(), e());
        this.f20304a = new h(i2, i3);
    }

    public static byte[] a(int i2, int i3, nm6 nm6Var) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) nm6Var.h(i3);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int i2;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (i3 < 8) {
                iArr[i3] = f(63, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) == 0 ? 0 : 255);
            } else {
                int i4 = i3 & 136;
                int i5 = com.google.common.math.c.f6376a;
                if (i4 == 0) {
                    int i6 = ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0);
                    int i7 = ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0);
                    i2 = (i3 & 4) == 0 ? 0 : 85;
                    if ((i3 & 64) == 0) {
                        i5 = 0;
                    }
                    iArr[i3] = f(255, i6, i7, i2 + i5);
                } else if (i4 == 8) {
                    int i8 = ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0);
                    int i9 = ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0);
                    i2 = (i3 & 4) == 0 ? 0 : 85;
                    if ((i3 & 64) == 0) {
                        i5 = 0;
                    }
                    iArr[i3] = f(127, i8, i9, i2 + i5);
                } else if (i4 == 128) {
                    iArr[i3] = f(255, ((i3 & 1) != 0 ? 43 : 0) + 127 + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + 127 + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + 127 + ((i3 & 64) == 0 ? 0 : 85));
                } else if (i4 == 136) {
                    iArr[i3] = f(255, ((i3 & 1) != 0 ? 43 : 0) + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + ((i3 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public static int g(nm6 nm6Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        int i4;
        int iH;
        int iH2;
        int i5 = i2;
        boolean z = false;
        while (true) {
            int iH3 = nm6Var.h(2);
            if (iH3 != 0) {
                z = z;
                i4 = 1;
            } else {
                if (nm6Var.g()) {
                    iH = nm6Var.h(3) + 3;
                    iH2 = nm6Var.h(2);
                } else {
                    if (nm6Var.g()) {
                        i4 = 1;
                    } else {
                        int iH4 = nm6Var.h(2);
                        if (iH4 == 0) {
                            z = true;
                        } else if (iH4 == 1) {
                            i4 = 2;
                        } else if (iH4 == 2) {
                            iH = nm6Var.h(4) + 12;
                            iH2 = nm6Var.h(2);
                        } else if (iH4 != 3) {
                            z = z;
                        } else {
                            iH = nm6Var.h(8) + 29;
                            iH2 = nm6Var.h(2);
                        }
                        iH3 = 0;
                        i4 = 0;
                    }
                    iH3 = 0;
                }
                z = z;
                i4 = iH;
                iH3 = iH2;
            }
            if (i4 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
            }
            i5 += i4;
            if (z) {
                return i5;
            }
            z = z;
        }
    }

    public static int h(nm6 nm6Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        int i4;
        int iH;
        int iH2;
        int i5 = i2;
        boolean z = false;
        while (true) {
            int iH3 = nm6Var.h(4);
            if (iH3 != 0) {
                z = z;
                i4 = 1;
            } else if (nm6Var.g()) {
                if (nm6Var.g()) {
                    int iH4 = nm6Var.h(2);
                    if (iH4 == 0) {
                        i4 = 1;
                    } else if (iH4 == 1) {
                        i4 = 2;
                    } else if (iH4 == 2) {
                        iH = nm6Var.h(4) + 9;
                        iH2 = nm6Var.h(4);
                    } else if (iH4 != 3) {
                        z = z;
                        iH3 = 0;
                        i4 = 0;
                    } else {
                        iH = nm6Var.h(8) + 25;
                        iH2 = nm6Var.h(4);
                    }
                    iH3 = 0;
                } else {
                    iH = nm6Var.h(2) + 4;
                    iH2 = nm6Var.h(4);
                }
                z = z;
                i4 = iH;
                iH3 = iH2;
            } else {
                int iH5 = nm6Var.h(3);
                if (iH5 != 0) {
                    i4 = iH5 + 2;
                    iH3 = 0;
                } else {
                    z = true;
                    iH3 = 0;
                    i4 = 0;
                }
            }
            if (i4 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
            }
            i5 += i4;
            if (z) {
                return i5;
            }
            z = z;
        }
    }

    public static int i(nm6 nm6Var, int[] iArr, @Nullable byte[] bArr, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        boolean z;
        int iH;
        int i4 = i2;
        boolean z2 = false;
        while (true) {
            int iH2 = nm6Var.h(8);
            if (iH2 != 0) {
                z = z2;
                iH = 1;
            } else if (nm6Var.g()) {
                z = z2;
                iH = nm6Var.h(7);
                iH2 = nm6Var.h(8);
            } else {
                int iH3 = nm6Var.h(7);
                if (iH3 != 0) {
                    z = z2;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    z = true;
                    iH2 = 0;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i4, i3, i4 + iH, i3 + 1, paint);
            }
            i4 += iH;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        nm6 nm6Var = new nm6(bArr);
        int iG = i3;
        int i5 = i4;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (nm6Var.b() != 0) {
            int iH = nm6Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i2 != 3) {
                            if (i2 == 2) {
                                bArr3 = bArrA3 == null ? f20296a : bArrA3;
                            } else {
                                bArr2 = null;
                            }
                            iG = g(nm6Var, iArr, bArr2, iG, i5, paint, canvas);
                            nm6Var.c();
                        } else {
                            bArr3 = bArrA == null ? f20297b : bArrA;
                        }
                        bArr2 = bArr3;
                        iG = g(nm6Var, iArr, bArr2, iG, i5, paint, canvas);
                        nm6Var.c();
                        break;
                    case 17:
                        iG = h(nm6Var, iArr, i2 == 3 ? bArrA2 == null ? f20298c : bArrA2 : null, iG, i5, paint, canvas);
                        nm6Var.c();
                        break;
                    case 18:
                        iG = i(nm6Var, iArr, null, iG, i5, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrA3 = a(4, 4, nm6Var);
                                break;
                            case 33:
                                bArrA = a(4, 8, nm6Var);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, nm6Var);
                                break;
                        }
                        break;
                }
            } else {
                i5 += 2;
                iG = i3;
            }
        }
    }

    public static void k(c cVar, a aVar, int i2, int i3, int i4, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i2 == 3) {
            iArr = aVar.c;
        } else {
            iArr = i2 == 2 ? aVar.b : aVar.f20306a;
        }
        int[] iArr2 = iArr;
        j(cVar.f20308a, iArr2, i2, i3, i4, paint, canvas);
        j(cVar.b, iArr2, i2, i3, i4 + 1, paint, canvas);
    }

    public static a l(nm6 nm6Var, int i2) {
        int[] iArr;
        int iH;
        int i3;
        int iH2;
        int iH3;
        int iH4;
        int i4 = 8;
        int iH5 = nm6Var.h(8);
        nm6Var.s(8);
        int i5 = 2;
        int i6 = i2 - 2;
        int[] iArrC = c();
        int[] iArrD = d();
        int[] iArrE = e();
        while (i6 > 0) {
            int iH6 = nm6Var.h(i4);
            int iH7 = nm6Var.h(i4);
            int i7 = i6 - 2;
            if ((iH7 & 128) != 0) {
                iArr = iArrC;
            } else {
                iArr = (iH7 & 64) != 0 ? iArrD : iArrE;
            }
            if ((iH7 & 1) != 0) {
                iH3 = nm6Var.h(i4);
                iH4 = nm6Var.h(i4);
                iH = nm6Var.h(i4);
                iH2 = nm6Var.h(i4);
                i3 = i7 - 4;
            } else {
                int iH8 = nm6Var.h(6) << i5;
                int iH9 = nm6Var.h(4) << 4;
                iH = nm6Var.h(4) << 4;
                i3 = i7 - 2;
                iH2 = nm6Var.h(i5) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH2 = 255;
                iH4 = 0;
                iH = 0;
            }
            double d2 = iH3;
            double d3 = iH4 + com.alipay.sdk.m.p.a.g;
            double d4 = iH + com.alipay.sdk.m.p.a.g;
            iArr[iH6] = f((byte) (255 - (iH2 & 255)), gj9.s((int) (d2 + (1.402d * d3)), 0, 255), gj9.s((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), gj9.s((int) (d2 + (d4 * 1.772d)), 0, 255));
            i6 = i3;
            iH5 = iH5;
            i4 = 8;
            i5 = 2;
        }
        return new a(iH5, iArrC, iArrD, iArrE);
    }

    public static b m(nm6 nm6Var) {
        int i2;
        int i3;
        int i4;
        int iH;
        nm6Var.s(4);
        boolean zG = nm6Var.g();
        nm6Var.s(3);
        int iH2 = nm6Var.h(16);
        int iH3 = nm6Var.h(16);
        if (zG) {
            int iH4 = nm6Var.h(16);
            int iH5 = nm6Var.h(16);
            int iH6 = nm6Var.h(16);
            iH = nm6Var.h(16);
            i4 = iH5;
            i3 = iH6;
            i2 = iH4;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = iH2;
            iH = iH3;
        }
        return new b(iH2, iH3, i2, i4, i3, iH);
    }

    public static c n(nm6 nm6Var) {
        byte[] bArr;
        int iH = nm6Var.h(16);
        nm6Var.s(4);
        int iH2 = nm6Var.h(2);
        boolean zG = nm6Var.g();
        nm6Var.s(1);
        byte[] bArr2 = gj9.f16790a;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = nm6Var.h(16);
                int iH4 = nm6Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    nm6Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    nm6Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        nm6Var.s(nm6Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    public static d o(nm6 nm6Var, int i2) {
        int iH = nm6Var.h(8);
        int iH2 = nm6Var.h(4);
        int iH3 = nm6Var.h(2);
        nm6Var.s(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iH4 = nm6Var.h(8);
            nm6Var.s(8);
            i3 -= 6;
            sparseArray.put(iH4, new e(nm6Var.h(16), nm6Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    public static f p(nm6 nm6Var, int i2) {
        int iH;
        int iH2;
        int iH3 = nm6Var.h(8);
        nm6Var.s(4);
        boolean zG = nm6Var.g();
        nm6Var.s(3);
        int i3 = 16;
        int iH4 = nm6Var.h(16);
        int iH5 = nm6Var.h(16);
        int iH6 = nm6Var.h(3);
        int iH7 = nm6Var.h(3);
        int i4 = 2;
        nm6Var.s(2);
        int iH8 = nm6Var.h(8);
        int iH9 = nm6Var.h(8);
        int iH10 = nm6Var.h(4);
        int iH11 = nm6Var.h(2);
        nm6Var.s(2);
        int i5 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int iH12 = nm6Var.h(i3);
            int iH13 = nm6Var.h(i4);
            int iH14 = nm6Var.h(i4);
            int iH15 = nm6Var.h(12);
            int i6 = iH11;
            nm6Var.s(4);
            int iH16 = nm6Var.h(12);
            i5 -= 6;
            if (iH13 == 1 || iH13 == 2) {
                i5 -= 2;
                iH = nm6Var.h(8);
                iH2 = nm6Var.h(8);
            } else {
                iH = 0;
                iH2 = 0;
            }
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH, iH2));
            iH11 = i6;
            i4 = 2;
            i3 = 16;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    public static void q(nm6 nm6Var, h hVar) {
        f fVar;
        int iH = nm6Var.h(8);
        int iH2 = nm6Var.h(16);
        int iH3 = nm6Var.h(16);
        int iD = nm6Var.d() + iH3;
        if (iH3 * 8 > nm6Var.b()) {
            Log.n(f20295a, "Data field length exceeds limit");
            nm6Var.s(nm6Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f45446a) {
                    d dVar = hVar.f20314a;
                    d dVarO = o(nm6Var, iH3);
                    if (dVarO.c != 0) {
                        hVar.f20314a = dVarO;
                        hVar.f20312a.clear();
                        hVar.f20315b.clear();
                        hVar.c.clear();
                    } else if (dVar != null && dVar.b != dVarO.b) {
                        hVar.f20314a = dVarO;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f20314a;
                if (iH2 == hVar.f45446a && dVar2 != null) {
                    f fVarP = p(nm6Var, iH3);
                    if (dVar2.c == 0 && (fVar = hVar.f20312a.get(fVarP.f45444a)) != null) {
                        fVarP.a(fVar);
                    }
                    hVar.f20312a.put(fVarP.f45444a, fVarP);
                }
                break;
            case 18:
                if (iH2 == hVar.f45446a) {
                    a aVarL = l(nm6Var, iH3);
                    hVar.f20315b.put(aVarL.f45439a, aVarL);
                } else if (iH2 == hVar.b) {
                    a aVarL2 = l(nm6Var, iH3);
                    hVar.d.put(aVarL2.f45439a, aVarL2);
                }
                break;
            case 19:
                if (iH2 == hVar.f45446a) {
                    c cVarN = n(nm6Var);
                    hVar.c.put(cVarN.f45441a, cVarN);
                } else if (iH2 == hVar.b) {
                    c cVarN2 = n(nm6Var);
                    hVar.e.put(cVarN2.f45441a, cVarN2);
                }
                break;
            case 20:
                if (iH2 == hVar.f45446a) {
                    hVar.f20313a = m(nm6Var);
                }
                break;
        }
        nm6Var.t(iD - nm6Var.d());
    }

    public List<Cue> b(byte[] bArr, int i2) {
        nm6 nm6Var = new nm6(bArr, i2);
        while (nm6Var.b() >= 48 && nm6Var.h(8) == 15) {
            q(nm6Var, this.f20304a);
        }
        h hVar = this.f20304a;
        d dVar = hVar.f20314a;
        if (dVar == null) {
            return Collections.emptyList();
        }
        b bVar = hVar.f20313a;
        if (bVar == null) {
            bVar = this.f20303a;
        }
        Bitmap bitmap = this.f20299a;
        if (bitmap == null || bVar.f45440a + 1 != bitmap.getWidth() || bVar.b + 1 != this.f20299a.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.f45440a + 1, bVar.b + 1, Bitmap.Config.ARGB_8888);
            this.f20299a = bitmapCreateBitmap;
            this.f20300a.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = dVar.f20309a;
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            this.f20300a.save();
            e eVarValueAt = sparseArray.valueAt(i3);
            f fVar = this.f20304a.f20312a.get(sparseArray.keyAt(i3));
            int i4 = eVarValueAt.f45443a + bVar.c;
            int i5 = eVarValueAt.b + bVar.e;
            this.f20300a.clipRect(i4, i5, Math.min(fVar.b + i4, bVar.d), Math.min(fVar.c + i5, bVar.f));
            a aVar = this.f20304a.f20315b.get(fVar.f);
            if (aVar == null && (aVar = this.f20304a.d.get(fVar.f)) == null) {
                aVar = this.f20302a;
            }
            int i6 = 0;
            for (SparseArray<g> sparseArray2 = fVar.f20310a; i6 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i6);
                g gVarValueAt = sparseArray2.valueAt(i6);
                c cVar = this.f20304a.c.get(iKeyAt);
                c cVar2 = cVar == null ? this.f20304a.e.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    k(cVar2, aVar, fVar.e, gVarValueAt.c + i4, i5 + gVarValueAt.d, cVar2.f20307a ? null : this.f20301a, this.f20300a);
                }
                i6++;
            }
            if (fVar.f20311a) {
                int i7 = fVar.e;
                this.f20305b.setColor(i7 == 3 ? aVar.c[fVar.g] : i7 == 2 ? aVar.b[fVar.h] : aVar.f20306a[fVar.i]);
                this.f20300a.drawRect(i4, i5, fVar.b + i4, fVar.c + i5, this.f20305b);
            }
            arrayList.add(new Cue.b().r(Bitmap.createBitmap(this.f20299a, i4, i5, fVar.b, fVar.c)).w(i4 / bVar.f45440a).x(0).t(i5 / bVar.b, 0).u(0).z(fVar.b / bVar.f45440a).s(fVar.c / bVar.b).a());
            this.f20300a.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f20300a.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f20304a.a();
    }
}
