package com.byazt.qa;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 598, 46})
public class n extends com.byazt.xj.c<FlexboxLayout> {
    public int kz;
    public int mq;
    public int vi;
    public int vp;
    public int yo;

    @com.byazt.zqa.c(c = {0, 1, 598, 151})
    public static class c extends com.byazt.xj.c.C0576c {
        public int cu;
        public float d;
        public int eo;
        public int h;
        public float md;
        public int or;
        public float p;
        public int yv;
        public int zb;

        public c(com.byazt.xj.c cVar) {
            super(cVar);
            this.yv = 1;
            this.p = 0.0f;
            this.md = 0.0f;
            this.h = -1;
            this.d = -1.0f;
            this.eo = -1;
            this.zb = -1;
            this.or = 16777215;
            this.cu = 16777215;
        }

        private int n(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        private float tt(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                m.c(e);
                return 0.0f;
            }
        }

        private float uj(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                m.c(e);
                return -1.0f;
            }
        }

        private float ve(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                m.c(e);
                return 0.0f;
            }
        }

        @Override // com.byazt.xj.c.C0576c
        public String toString() {
            return "LayoutParams{mWidth=" + this.c + ", mHeight=" + this.tt + ", mMargin=" + this.n + ", mMarginLeft=" + this.f29179a + ", mMarginRight=" + this.sp + ", mMarginTop=" + this.x + ", mMarginBottom=" + this.i + ", mParams=" + this.gr + ", mOrder=" + this.yv + ", mFlexGrow=" + this.p + ", mFlexShrink=" + this.md + ", mAlignSelf=" + this.h + ", mFlexBasisPercent=" + this.d + ", mMinWidth=" + this.eo + ", mMinHeight=" + this.zb + ", mMaxWidth=" + this.or + ", mMaxHeight=" + this.cu + "} " + super.toString();
        }

        @Override // com.byazt.xj.c.C0576c
        public void c(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.c(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.d = uj(str2);
                    break;
                case "order":
                    this.yv = c(str2);
                    break;
                case "flexShrink":
                    this.md = ve(str2);
                    break;
                case "flexGrow":
                    this.p = tt(str2);
                    break;
                case "alignSelf":
                    this.h = n(str2);
                    break;
            }
        }

        @Override // com.byazt.xj.c.C0576c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.c c() {
            FlexboxLayout.c cVar = new FlexboxLayout.c((int) this.c, (int) this.tt);
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = (int) this.f29179a;
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = (int) this.sp;
            ((ViewGroup.MarginLayoutParams) cVar).topMargin = (int) this.x;
            ((ViewGroup.MarginLayoutParams) cVar).bottomMargin = (int) this.i;
            cVar.ve(this.yv);
            cVar.uj(this.h);
            cVar.c(this.p);
            cVar.tt(this.md);
            cVar.ve(this.d);
            return cVar;
        }

        private int c(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                m.c(e);
                return 1;
            }
        }
    }

    public n(Context context) {
        super(context);
    }

    private int t(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int u(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private int yp(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 4;
                break;
            case "baseline":
                b = 3;
                break;
            case "center":
                b = 2;
                break;
            case "flex_start":
                b = 0;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b != 2) {
            return b != 3 ? 4 : 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private int z(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 5;
                break;
            case "center":
                b = 2;
                break;
            case "space_around":
                b = 3;
                break;
            case "flex_start":
                b = 0;
                break;
            case "space_between":
                b = 4;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b == 2) {
            return 2;
        }
        if (b != 3) {
            return b != 4 ? 5 : 3;
        }
        return 4;
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout c() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.tt);
        flexboxLayout.c(this);
        return flexboxLayout;
    }

    public int sl(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((FlexboxLayout) this.n).setFlexDirection(this.yo);
        ((FlexboxLayout) this.n).setFlexWrap(this.vp);
        ((FlexboxLayout) this.n).setJustifyContent(this.kz);
        ((FlexboxLayout) this.n).setAlignItems(this.vi);
        ((FlexboxLayout) this.n).setAlignContent(this.mq);
    }

    @Override // com.byazt.xj.c
    public com.byazt.xj.c.C0576c x() {
        return new c(this);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.vi = yp(str2);
                break;
            case "flexDirection":
                this.yo = sl(str2);
                break;
            case "alignContent":
                this.mq = z(str2);
                break;
            case "flexWrap":
                this.vp = t(str2);
                break;
            case "justifyContent":
                this.kz = u(str2);
                break;
        }
    }
}
