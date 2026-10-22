package com.byazt.kpm;

import com.alipay.sdk.m.p.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 54})
public class ve<E> implements Cloneable {
    public static final Object c = new Object();
    public int n;
    public boolean tt;
    public Object[] uj;
    public long[] ve;

    public ve() {
        this(10);
    }

    private void uj() {
        int i = this.n;
        long[] jArr = this.ve;
        Object[] objArr = this.uj;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != c) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.tt = false;
        this.n = i2;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ve<E> clone() {
        try {
            ve<E> veVar = (ve) super.clone();
            veVar.ve = (long[]) this.ve.clone();
            veVar.uj = (Object[]) this.uj.clone();
            return veVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void delete(long j) {
        int iC = tt.c(this.ve, this.n, j);
        if (iC >= 0) {
            Object[] objArr = this.uj;
            Object obj = objArr[iC];
            Object obj2 = c;
            if (obj != obj2) {
                objArr[iC] = obj2;
                this.tt = true;
            }
        }
    }

    public String toString() {
        if (tt() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.n * 28);
        sb.append('{');
        for (int i = 0; i < this.n; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(tt(i));
            sb.append(a.h);
            E eVe = ve(i);
            if (eVe != this) {
                sb.append(eVe);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void tt(long j, E e) {
        int iC = tt.c(this.ve, this.n, j);
        if (iC >= 0) {
            this.uj[iC] = e;
            return;
        }
        int i = ~iC;
        int i2 = this.n;
        if (i < i2) {
            Object[] objArr = this.uj;
            if (objArr[i] == c) {
                this.ve[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.tt && i2 >= this.ve.length) {
            uj();
            i = ~tt.c(this.ve, this.n, j);
        }
        int i3 = this.n;
        if (i3 >= this.ve.length) {
            int iC2 = tt.c(i3 + 1);
            long[] jArr = new long[iC2];
            Object[] objArr2 = new Object[iC2];
            long[] jArr2 = this.ve;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.uj;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.ve = jArr;
            this.uj = objArr2;
        }
        int i4 = this.n;
        if (i4 - i != 0) {
            long[] jArr3 = this.ve;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.uj;
            System.arraycopy(objArr4, i, objArr4, i5, this.n - i);
        }
        this.ve[i] = j;
        this.uj[i] = e;
        this.n++;
    }

    public E ve(int i) {
        if (this.tt) {
            uj();
        }
        return (E) this.uj[i];
    }

    public ve(int i) {
        this.tt = false;
        if (i == 0) {
            this.ve = tt.tt;
            this.uj = tt.ve;
        } else {
            int iC = tt.c(i);
            this.ve = new long[iC];
            this.uj = new Object[iC];
        }
        this.n = 0;
    }

    public void ve() {
        int i = this.n;
        Object[] objArr = this.uj;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.n = 0;
        this.tt = false;
    }

    public E c(long j) {
        return c(j, null);
    }

    public E c(long j, E e) {
        E e2;
        int iC = tt.c(this.ve, this.n, j);
        return (iC < 0 || (e2 = (E) this.uj[iC]) == c) ? e : e2;
    }

    public void c(int i) {
        Object[] objArr = this.uj;
        Object obj = objArr[i];
        Object obj2 = c;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.tt = true;
        }
    }

    public int tt() {
        if (this.tt) {
            uj();
        }
        return this.n;
    }

    public long tt(int i) {
        if (this.tt) {
            uj();
        }
        return this.ve[i];
    }
}
