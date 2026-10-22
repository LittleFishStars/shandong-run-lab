package com.byazt.kt;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 67})
public class u {
    public final tt c;
    public c tt = new c();

    public interface tt {
        int c();

        int c(View view);

        View c(int i);

        int tt();

        int tt(View view);
    }

    public u(tt ttVar) {
        this.c = ttVar;
    }

    public View c(int i, int i2, int i3, int i4) {
        int iC = this.c.c();
        int iTt = this.c.tt();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewC = this.c.c(i);
            this.tt.c(iC, iTt, this.c.c(viewC), this.c.tt(viewC));
            if (i3 != 0) {
                this.tt.c();
                this.tt.c(i3);
                if (this.tt.tt()) {
                    return viewC;
                }
            }
            if (i4 != 0) {
                this.tt.c();
                this.tt.c(i4);
                if (this.tt.tt()) {
                    view = viewC;
                }
            }
            i += i5;
        }
        return view;
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 57})
    public static class c {
        public int c = 0;
        public int n;
        public int tt;
        public int uj;
        public int ve;

        public int c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void c(int i, int i2, int i3, int i4) {
            this.tt = i;
            this.ve = i2;
            this.uj = i3;
            this.n = i4;
        }

        public boolean tt() {
            int i = this.c;
            if ((i & 7) != 0 && (i & (c(this.uj, this.tt) << 0)) == 0) {
                return false;
            }
            int i2 = this.c;
            if ((i2 & 112) != 0 && (i2 & (c(this.uj, this.ve) << 4)) == 0) {
                return false;
            }
            int i3 = this.c;
            if ((i3 & 1792) != 0 && (i3 & (c(this.n, this.tt) << 8)) == 0) {
                return false;
            }
            int i4 = this.c;
            return (i4 & 28672) == 0 || (i4 & (c(this.n, this.ve) << 12)) != 0;
        }

        public void c(int i) {
            this.c = i | this.c;
        }

        public void c() {
            this.c = 0;
        }
    }
}
