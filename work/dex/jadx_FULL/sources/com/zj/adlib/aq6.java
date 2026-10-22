package com.zj.adlib;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class aq6 extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f40585a = 120;
    public static final int d = 20;
    public static final int e = 21;
    public static final int f = 22;
    public static final int g = 128;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f15334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Inflater f15336a;
    public final om6 b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40586a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15338a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f15337a = new om6();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f15339a = new int[256];

        @Nullable
        public Cue d() {
            int iG;
            if (this.f40586a == 0 || this.b == 0 || this.e == 0 || this.f == 0 || this.f15337a.f() == 0 || this.f15337a.e() != this.f15337a.f() || !this.f15338a) {
                return null;
            }
            this.f15337a.S(0);
            int i = this.e * this.f;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int iG2 = this.f15337a.G();
                if (iG2 != 0) {
                    iG = i2 + 1;
                    iArr[i2] = this.f15339a[iG2];
                } else {
                    int iG3 = this.f15337a.G();
                    if (iG3 != 0) {
                        iG = ((iG3 & 64) == 0 ? iG3 & 63 : ((iG3 & 63) << 8) | this.f15337a.G()) + i2;
                        Arrays.fill(iArr, i2, iG, (iG3 & 128) == 0 ? 0 : this.f15339a[this.f15337a.G()]);
                    }
                }
                i2 = iG;
            }
            return new Cue.b().r(Bitmap.createBitmap(iArr, this.e, this.f, Bitmap.Config.ARGB_8888)).w(this.c / this.f40586a).x(0).t(this.d / this.b, 0).u(0).z(this.e / this.f40586a).s(this.f / this.b).a();
        }

        public final void e(om6 om6Var, int i) {
            int iJ;
            if (i < 4) {
                return;
            }
            om6Var.T(3);
            int i2 = i - 4;
            if ((om6Var.G() & 128) != 0) {
                if (i2 < 7 || (iJ = om6Var.J()) < 4) {
                    return;
                }
                this.e = om6Var.M();
                this.f = om6Var.M();
                this.f15337a.O(iJ - 4);
                i2 -= 7;
            }
            int iE = this.f15337a.e();
            int iF = this.f15337a.f();
            if (iE >= iF || i2 <= 0) {
                return;
            }
            int iMin = Math.min(i2, iF - iE);
            om6Var.k(this.f15337a.d(), iE, iMin);
            this.f15337a.S(iE + iMin);
        }

        public final void f(om6 om6Var, int i) {
            if (i < 19) {
                return;
            }
            this.f40586a = om6Var.M();
            this.b = om6Var.M();
            om6Var.T(11);
            this.c = om6Var.M();
            this.d = om6Var.M();
        }

        public final void g(om6 om6Var, int i) {
            if (i % 5 != 2) {
                return;
            }
            om6Var.T(2);
            Arrays.fill(this.f15339a, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int iG = om6Var.G();
                int iG2 = om6Var.G();
                int iG3 = om6Var.G();
                int iG4 = om6Var.G();
                int iG5 = om6Var.G();
                double d = iG2;
                double d2 = iG3 + com.alipay.sdk.m.p.a.g;
                double d3 = iG4 + com.alipay.sdk.m.p.a.g;
                this.f15339a[iG] = (gj9.s((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (iG5 << 24) | (gj9.s((int) ((1.402d * d2) + d), 0, 255) << 16) | gj9.s((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.f15338a = true;
        }

        public void h() {
            this.f40586a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.f15337a.O(0);
            this.f15338a = false;
        }
    }

    public aq6() {
        super("PgsDecoder");
        this.f15335a = new om6();
        this.b = new om6();
        this.f15334a = new a();
    }

    @Nullable
    public static Cue n(om6 om6Var, a aVar) {
        int iF = om6Var.f();
        int iG = om6Var.G();
        int iM = om6Var.M();
        int iE = om6Var.e() + iM;
        Cue cueD = null;
        if (iE > iF) {
            om6Var.S(iF);
            return null;
        }
        if (iG != 128) {
            switch (iG) {
                case 20:
                    aVar.g(om6Var, iM);
                    break;
                case 21:
                    aVar.e(om6Var, iM);
                    break;
                case 22:
                    aVar.f(om6Var, iM);
                    break;
            }
        } else {
            cueD = aVar.d();
            aVar.h();
        }
        om6Var.S(iE);
        return cueD;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.f15335a.Q(bArr, i);
        m(this.f15335a);
        this.f15334a.h();
        ArrayList arrayList = new ArrayList();
        while (this.f15335a.a() >= 3) {
            Cue cueN = n(this.f15335a, this.f15334a);
            if (cueN != null) {
                arrayList.add(cueN);
            }
        }
        return new bq6(Collections.unmodifiableList(arrayList));
    }

    public final void m(om6 om6Var) {
        if (om6Var.a() <= 0 || om6Var.h() != 120) {
            return;
        }
        if (this.f15336a == null) {
            this.f15336a = new Inflater();
        }
        if (gj9.G0(om6Var, this.b, this.f15336a)) {
            om6Var.Q(this.b.d(), this.b.f());
        }
    }
}
