package com.byazt.xj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.cd.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1471, 20})
public class c<E extends ViewGroup> extends ve {
    public List<ve<View>> c;

    public c(Context context) {
        this(context, null);
    }

    public void c(ve veVar) {
        if (veVar == null) {
            return;
        }
        this.c.add(veVar);
        View viewI = veVar.i();
        if (viewI != null) {
            ((ViewGroup) this.n).addView(viewI);
        }
    }

    public List<ve<View>> sp() {
        return this.c;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
    }

    @Override // com.byazt.xj.ve
    public ve ve(String str) {
        ve<T> veVarA;
        if (!TextUtils.isEmpty(str) && da(str) != null) {
            return this;
        }
        for (ve<View> veVar : this.c) {
            if (veVar != null && (veVarA = veVar.a(str)) != 0) {
                return veVarA;
            }
        }
        return null;
    }

    public C0576c x() {
        return new C0576c(this);
    }

    public c(Context context, c cVar) {
        super(context, cVar);
        this.c = new ArrayList();
    }

    @Override // com.byazt.xj.ve
    public ve tt(String str) {
        ve<T> veVarN;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.t)) {
            return this;
        }
        for (ve<View> veVar : this.c) {
            if (veVar != null && (veVarN = veVar.n(str)) != 0) {
                return veVarN;
            }
        }
        return null;
    }

    public void c(ve veVar, ViewGroup.LayoutParams layoutParams) {
        if (veVar == null) {
            return;
        }
        this.c.add(veVar);
        View viewI = veVar.i();
        if (viewI != null) {
            ((ViewGroup) this.n).addView(viewI, layoutParams);
        }
    }

    @Override // com.byazt.xj.ve
    public ve c(String str) {
        ve<T> veVarUj;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.sl)) {
            return this;
        }
        for (ve<View> veVar : this.c) {
            if (veVar != null && (veVarUj = veVar.uj(str)) != 0) {
                return veVarUj;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.byazt.xj.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1471, 44})
    public static class C0576c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f29179a;
        public float da;
        public ViewGroup.LayoutParams gr;
        public boolean gt;
        public boolean gu;
        public float i;
        public boolean m;
        public boolean my;
        public float n;
        public boolean nu;
        public boolean qy;
        public boolean rh;
        public boolean rl;
        public float sl;
        public float sp;
        public float t;
        public float u;
        public float x;
        public float yp;
        public boolean z;
        public c zm;
        public float c = -2.0f;
        public float tt = -2.0f;
        public float ve = 0.0f;
        public float uj = 0.0f;

        public C0576c(c cVar) {
            this.zm = cVar;
        }

        public void c(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            switch (str) {
                case "paddingLeft":
                    this.sl = x.c(context, str2);
                    this.m = true;
                    break;
                case "minWidth":
                    this.ve = x.c(context, str2);
                    break;
                case "height":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.tt = -1.0f;
                        break;
                    } else {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.tt = x.c(context, str2);
                        } else {
                            this.tt = -2.0f;
                        }
                        break;
                    }
                    break;
                case "margin":
                    this.n = x.c(context, str2);
                    break;
                case "marginTop":
                    this.x = x.c(context, str2);
                    this.qy = true;
                    break;
                case "padding":
                    this.da = x.c(context, str2);
                    this.z = true;
                    break;
                case "marginBottom":
                    this.i = x.c(context, str2);
                    this.gu = true;
                    break;
                case "minHeight":
                    this.uj = x.c(context, str2);
                    break;
                case "paddingTop":
                    this.t = x.c(context, str2);
                    this.rh = true;
                    break;
                case "width":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.c = -1.0f;
                        break;
                    } else {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.c = x.c(context, str2);
                        } else {
                            this.c = -2.0f;
                        }
                        break;
                    }
                    break;
                case "paddingBottom":
                    this.yp = x.c(context, str2);
                    this.my = true;
                    break;
                case "paddingRight":
                    this.u = x.c(context, str2);
                    this.nu = true;
                    break;
                case "marginRight":
                    this.sp = x.c(context, str2);
                    this.rl = true;
                    break;
                case "marginLeft":
                    this.f29179a = x.c(context, str2);
                    this.gt = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.c + ", mHeight=" + this.tt + ", mMargin=" + this.n + ", mMarginLeft=" + this.f29179a + ", mMarginRight=" + this.sp + ", mMarginTop=" + this.x + ", mMarginBottom=" + this.i + ", mParams=" + this.gr + '}';
        }

        public ViewGroup.LayoutParams c() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.c, (int) this.tt);
            marginLayoutParams.leftMargin = (int) (this.gt ? this.f29179a : this.n);
            marginLayoutParams.rightMargin = (int) (this.rl ? this.sp : this.n);
            marginLayoutParams.topMargin = (int) (this.qy ? this.x : this.n);
            marginLayoutParams.bottomMargin = (int) (this.gu ? this.i : this.n);
            return marginLayoutParams;
        }
    }
}
