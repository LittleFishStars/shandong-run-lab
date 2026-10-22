package com.zj.adlib;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.a;
import com.google.common.base.b;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xd9 extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f45800a = 65279;
    public static final char b = 65534;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final float f20637b = 0.85f;
    public static final String c = "Tx3gDecoder";
    public static final String d = "Serif";
    public static final String e = "sans-serif";
    public static final int g = 1937013100;
    public static final int h = 1952608120;
    public static final int i = 8;
    public static final int j = 2;
    public static final int k = 2;
    public static final int l = 12;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 4;
    public static final int p = 16711680;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float f20638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f20639a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f20640b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f20641c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f20642d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final int f20643e;
    public final int f;

    public xd9(List<byte[]> list) {
        super(c);
        this.f20639a = new om6();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f20642d = 0;
            this.f20643e = -1;
            this.f20640b = "sans-serif";
            this.f20641c = false;
            this.f20638a = 0.85f;
            this.f = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f20642d = bArr[24];
        this.f20643e = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f20640b = d.equals(gj9.J(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i2 = bArr[25] * a.x;
        this.f = i2;
        boolean z = (bArr[0] & 32) != 0;
        this.f20641c = z;
        if (z) {
            this.f20638a = gj9.r(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i2, 0.0f, 0.95f);
        } else {
            this.f20638a = 0.85f;
        }
    }

    public static void n(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void o(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    public static void p(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z = (i2 & 1) != 0;
            boolean z2 = (i2 & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            boolean z3 = (i2 & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
        }
    }

    public static void q(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, 16711713);
        }
    }

    public static String r(om6 om6Var) throws SubtitleDecoderException {
        char cG;
        n(om6Var.a() >= 2);
        int iM = om6Var.M();
        if (iM == 0) {
            return "";
        }
        return (om6Var.a() < 2 || !((cG = om6Var.g()) == 65279 || cG == 65534)) ? om6Var.E(iM, b.c) : om6Var.E(iM, b.f);
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        this.f20639a.Q(bArr, i2);
        String strR = r(this.f20639a);
        if (strR.isEmpty()) {
            return yd9.f46008a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strR);
        p(spannableStringBuilder, this.f20642d, 0, 0, spannableStringBuilder.length(), p);
        o(spannableStringBuilder, this.f20643e, -1, 0, spannableStringBuilder.length(), p);
        q(spannableStringBuilder, this.f20640b, 0, spannableStringBuilder.length());
        float fR = this.f20638a;
        while (this.f20639a.a() >= 8) {
            int iE = this.f20639a.e();
            int iO = this.f20639a.o();
            int iO2 = this.f20639a.o();
            if (iO2 == 1937013100) {
                n(this.f20639a.a() >= 2);
                int iM = this.f20639a.M();
                for (int i3 = 0; i3 < iM; i3++) {
                    m(this.f20639a, spannableStringBuilder);
                }
            } else if (iO2 == 1952608120 && this.f20641c) {
                n(this.f20639a.a() >= 2);
                fR = gj9.r(this.f20639a.M() / this.f, 0.0f, 0.95f);
            }
            this.f20639a.S(iE + iO);
        }
        return new yd9(new Cue.b().A(spannableStringBuilder).t(fR, 0).u(0).a());
    }

    public final void m(om6 om6Var, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        n(om6Var.a() >= 12);
        int iM = om6Var.M();
        int iM2 = om6Var.M();
        om6Var.T(2);
        int iG = om6Var.G();
        om6Var.T(1);
        int iO = om6Var.o();
        if (iM2 > spannableStringBuilder.length()) {
            Log.n(c, "Truncating styl end (" + iM2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iM2 = spannableStringBuilder.length();
        }
        if (iM < iM2) {
            int i2 = iM2;
            p(spannableStringBuilder, iG, this.f20642d, iM, i2, 0);
            o(spannableStringBuilder, iO, this.f20643e, iM, i2, 0);
            return;
        }
        Log.n(c, "Ignoring styl with start (" + iM + ") >= end (" + iM2 + ").");
    }
}
