package com.byazt.yy;

import android.content.Context;
import com.byazt.dna.nu;
import com.byazt.iy.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 122, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 122, 123})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f29222a;
        public volatile Context c;
        public volatile boolean n;
        public volatile String tt;
        public volatile boolean uj;
        public volatile int ve;

        private n ve() {
            n nVarC = com.byazt.fu.c.c(this.c, this.tt, this.uj, this.f29222a);
            this.n = true;
            if (nVarC != null) {
                return nVarC;
            }
            this.n = false;
            return tt();
        }

        public c c(Context context) {
            if (context == null) {
                return this;
            }
            this.c = context.getApplicationContext();
            ve.c(this.c);
            return this;
        }

        public c tt(int i) {
            this.f29222a = i;
            return this;
        }

        private n tt() {
            return this.uj ? com.byazt.ti.c.c(this.tt) : ((nu) com.byazt.ut.uj.getService("kv_store_factory")).get(this.tt);
        }

        public c c(String str) {
            this.tt = str;
            return this;
        }

        public c c(int i) {
            this.ve = i;
            return this;
        }

        public c c(boolean z) {
            this.uj = z;
            return this;
        }

        public n c() {
            if (this.ve != 2) {
                return tt();
            }
            return ve();
        }
    }
}
