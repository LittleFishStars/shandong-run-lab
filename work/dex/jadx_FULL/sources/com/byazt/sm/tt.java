package com.byazt.sm;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.byazt.cd.x;
import com.byazt.xj.ve;
import com.google.common.base.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 40, 13})
public class tt extends ve<UGTextView> {
    public int az;
    public String c;
    public int cf;

    @Deprecated
    public float di;
    public int ej;
    public float hg;
    public int ij;

    @Deprecated
    public TextUtils.TruncateAt is;
    public float iy;

    @Deprecated
    public float jg;
    public TextUtils.TruncateAt jt;
    public float k;
    public float kz;
    public int mq;
    public float nl;
    public boolean pl;
    public float sd;
    public int vi;
    public float vp;
    public float w;
    public int yo;

    public tt(Context context) {
        super(context);
        this.yo = -16777216;
        this.vp = 12.0f;
        this.kz = -1.0f;
        this.mq = Integer.MAX_VALUE;
        this.ij = GravityCompat.START;
        this.jt = TextUtils.TruncateAt.END;
        this.w = -1.0f;
        this.nl = 400.0f;
    }

    private void b() {
        float f = this.w;
        if (f <= 3.0f) {
            ((UGTextView) this.n).setLineSpacing(0.0f, f);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(x.c(this.tt, (f - (this.vp * 1.2f)) / 2.0f));
            int paddingTop = ((UGTextView) this.n).getPaddingTop() + iRound;
            int paddingBottom = ((UGTextView) this.n).getPaddingBottom() + iRound;
            T t = this.n;
            ((UGTextView) t).setPadding(((UGTextView) t).getPaddingLeft(), paddingTop, ((UGTextView) this.n).getPaddingRight(), paddingBottom);
            ((UGTextView) this.n).setLineHeight(Math.round(x.c(this.tt, this.w)));
        }
    }

    private int m(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }

    private TextUtils.TruncateAt sl(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.is = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.is = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.is = TextUtils.TruncateAt.START;
                break;
            default:
                this.is = null;
                break;
        }
        return this.is;
    }

    private TextUtils.TruncateAt u(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private void x() {
        ((UGTextView) this.n).setLineSpacing(0.0f, this.w);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private int yp(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals("bold")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("normal")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("italic")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            return b != 1 ? 0 : 2;
        }
        return 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int z(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    b = 0;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    b = 1;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b = 2;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b = 3;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    public void a(int i) {
        this.az = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.n).setPaintFlags(i);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UGTextView c() {
        UGTextView uGTextView = new UGTextView(this.tt);
        uGTextView.c(this);
        return uGTextView;
    }

    public void t(String str) {
        this.c = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.c = "";
        }
        ((UGTextView) this.n).setText(this.c);
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        if (TextUtils.equals("null", this.c)) {
            this.c = "";
        }
        t(this.c);
        ((UGTextView) this.n).setTextSize(1, this.vp);
        ((UGTextView) this.n).setTextColor(this.yo);
        ((UGTextView) this.n).setLines(this.cf);
        ((UGTextView) this.n).setMaxLines(this.mq);
        ((UGTextView) this.n).setGravity(this.ij);
        ((UGTextView) this.n).setIncludeFontPadding(false);
        ((UGTextView) this.n).setMinTextSize(x.c(this.tt, this.kz));
        a(this.az);
        if (h()) {
            c(this.jt);
        } else {
            c(this.is);
        }
        if (this.w > 0.0f) {
            if (h()) {
                b();
            } else {
                x();
            }
        }
        int i = Build.VERSION.SDK_INT;
        ((UGTextView) this.n).setBreakStrategy(0);
        if (!h()) {
            ((UGTextView) this.n).setShadowLayer(this.k, this.di, this.jg, this.ej);
        } else if (this.pl) {
            if (this.k <= 0.0f) {
                this.k = 1.0E-5f;
            }
            ((UGTextView) this.n).setShadowLayer(this.k, this.hg, this.sd, this.ej);
        }
        int i2 = this.vi;
        if (i2 == 1) {
            ((UGTextView) this.n).setTypeface(Typeface.DEFAULT, i2);
        } else if (i >= 28) {
            ((UGTextView) this.n).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.nl, i2 == 2));
        } else if (this.nl >= 500.0f) {
            ((UGTextView) this.n).setTypeface(Typeface.DEFAULT, 1);
        }
        if (x.c(this.tt, this.vp) > 0.0f) {
            ((UGTextView) this.n).setLetterSpacing(this.iy / x.c(this.tt, this.vp));
        }
    }

    public void c(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.n).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = 11;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 12;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = 13;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = a.p;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = a.q;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = a.r;
                }
                break;
            case 351195968:
                if (str.equals("minTextSize")) {
                    b = 17;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = a.u;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 19;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = a.x;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.k = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 1:
                this.ej = com.byazt.cd.c.c(str2);
                this.pl = true;
                break;
            case 2:
                this.hg = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 3:
                this.sd = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 4:
                this.ij = z(str2);
                break;
            case 5:
                this.yo = com.byazt.cd.c.c(str2);
                break;
            case 6:
                this.vi = yp(str2);
                break;
            case 8:
                this.vp = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 9:
                this.az = m(str2);
                break;
            case 10:
                this.di = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 11:
                this.jg = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 12:
                float fC = com.byazt.cd.ve.c(str2, -1.0f);
                this.nl = fC;
                if (fC < 1.0f || fC > 1000.0f) {
                    this.nl = 400.0f;
                }
                break;
            case 13:
                this.w = com.byazt.cd.ve.c(str2, 1.0f);
                break;
            case 14:
                this.c = str2;
                break;
            case 15:
                this.cf = com.byazt.cd.ve.c(str2, 0);
                break;
            case 16:
                this.jt = u(str2);
                break;
            case 17:
                this.kz = com.byazt.cd.ve.c(str2, -1.0f);
                break;
            case 18:
                int iC = com.byazt.cd.ve.c(str2, Integer.MAX_VALUE);
                this.mq = iC > 0 ? iC : Integer.MAX_VALUE;
                break;
            case 19:
                this.is = sl(str2);
                break;
            case 20:
                this.iy = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
        }
    }
}
