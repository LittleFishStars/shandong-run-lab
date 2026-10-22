package com.byazt.fq;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1576, 15})
public class uj {
    public ViewParent c;
    public int[] n;
    public ViewParent tt;
    public boolean uj;
    public final View ve;

    public uj(View view) {
        this.ve = view;
    }

    private ViewParent uj(int i) {
        if (i == 0) {
            return this.c;
        }
        if (i != 1) {
            return null;
        }
        return this.tt;
    }

    public void c(boolean z) {
        if (this.uj) {
            sp.da(this.ve);
        }
        this.uj = z;
    }

    public boolean tt() {
        return c(0);
    }

    public void ve() {
        ve(0);
    }

    public boolean tt(int i) {
        return c(i, 0);
    }

    public void ve(int i) {
        ViewParent viewParentUj = uj(i);
        if (viewParentUj != null) {
            x.c(viewParentUj, this.ve, i);
            c(i, (ViewParent) null);
        }
    }

    public boolean c() {
        return this.uj;
    }

    public boolean c(int i) {
        return uj(i) != null;
    }

    public boolean c(int i, int i2) {
        if (c(i2)) {
            return true;
        }
        if (!c()) {
            return false;
        }
        View view = this.ve;
        for (ViewParent parent = this.ve.getParent(); parent != null; parent = parent.getParent()) {
            if (x.c(parent, view, this.ve, i, i2)) {
                c(i2, parent);
                x.tt(parent, view, this.ve, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean c(int i, int i2, int i3, int i4, int[] iArr) {
        return c(i, i2, i3, i4, iArr, 0);
    }

    public boolean c(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentUj;
        int i6;
        int i7;
        if (!c() || (viewParentUj = uj(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.ve.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        x.c(viewParentUj, this.ve, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.ve.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2) {
        return c(i, i2, iArr, iArr2, 0);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentUj;
        int i4;
        int i5;
        if (!c() || (viewParentUj = uj(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.ve.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.n == null) {
                this.n = new int[2];
            }
            iArr = this.n;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        x.c(viewParentUj, this.ve, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.ve.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean c(float f, float f2, boolean z) {
        ViewParent viewParentUj;
        if (!c() || (viewParentUj = uj(0)) == null) {
            return false;
        }
        return x.c(viewParentUj, this.ve, f, f2, z);
    }

    public boolean c(float f, float f2) {
        ViewParent viewParentUj;
        if (!c() || (viewParentUj = uj(0)) == null) {
            return false;
        }
        return x.c(viewParentUj, this.ve, f, f2);
    }

    private void c(int i, ViewParent viewParent) {
        if (i == 0) {
            this.c = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.tt = viewParent;
        }
    }
}
