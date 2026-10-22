package com.byazt.kt;

import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 13})
public class tt {
    public final InterfaceC0457tt c;
    public final c tt = new c();
    public final List<View> ve = new ArrayList();

    /* JADX INFO: renamed from: com.byazt.kt.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0457tt {
        int c();

        int c(View view);

        void c(int i);

        void c(View view, int i);

        void c(View view, int i, ViewGroup.LayoutParams layoutParams);

        View tt(int i);

        RecyclerView.gu tt(View view);

        void tt();

        void uj(View view);

        void ve(int i);

        void ve(View view);
    }

    public tt(InterfaceC0457tt interfaceC0457tt) {
        this.c = interfaceC0457tt;
    }

    private int a(int i) {
        if (i < 0) {
            return -1;
        }
        int iC = this.c.c();
        int i2 = i;
        while (i2 < iC) {
            int iN = i - (i2 - this.tt.n(i2));
            if (iN == 0) {
                while (this.tt.ve(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iN;
        }
        return -1;
    }

    private void sp(View view) {
        this.ve.add(view);
        this.c.ve(view);
    }

    private boolean x(View view) {
        if (!this.ve.remove(view)) {
            return false;
        }
        this.c.uj(view);
        return true;
    }

    public void c(View view, boolean z) {
        c(view, -1, z);
    }

    public void n(int i) {
        int iA = a(i);
        this.tt.uj(iA);
        this.c.ve(iA);
    }

    public String toString() {
        return this.tt.toString() + ", hidden list:" + this.ve.size();
    }

    public View tt(int i) {
        return this.c.tt(a(i));
    }

    public View uj(int i) {
        return this.c.tt(i);
    }

    public View ve(int i) {
        int size = this.ve.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.ve.get(i2);
            RecyclerView.gu guVarTt = this.c.tt(view);
            if (guVarTt.uj() == i && !guVarTt.yp() && !guVarTt.nu()) {
                return view;
            }
        }
        return null;
    }

    @com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public long c = 0;
        public c tt;

        private void tt() {
            if (this.tt == null) {
                this.tt = new c();
            }
        }

        public void c(int i) {
            if (i < 64) {
                this.c |= 1 << i;
            } else {
                tt();
                this.tt.c(i - 64);
            }
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                tt();
                this.tt.insert(i - 64, z);
                return;
            }
            long j = this.c;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.c = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                c(i);
            } else {
                tt(i);
            }
            if (z2 || this.tt != null) {
                tt();
                this.tt.insert(0, z2);
            }
        }

        public int n(int i) {
            c cVar = this.tt;
            if (cVar == null) {
                return i >= 64 ? Long.bitCount(this.c) : Long.bitCount(this.c & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.c & ((1 << i) - 1)) : cVar.n(i - 64) + Long.bitCount(this.c);
        }

        public String toString() {
            if (this.tt == null) {
                return Long.toBinaryString(this.c);
            }
            return this.tt.toString() + "xx" + Long.toBinaryString(this.c);
        }

        public boolean uj(int i) {
            if (i >= 64) {
                tt();
                return this.tt.uj(i - 64);
            }
            long j = 1 << i;
            long j2 = this.c;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.c = j3;
            long j4 = j - 1;
            this.c = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            c cVar = this.tt;
            if (cVar != null) {
                if (cVar.ve(0)) {
                    c(63);
                }
                this.tt.uj(0);
            }
            return z;
        }

        public boolean ve(int i) {
            if (i < 64) {
                return (this.c & (1 << i)) != 0;
            }
            tt();
            return this.tt.ve(i - 64);
        }

        public void tt(int i) {
            if (i >= 64) {
                c cVar = this.tt;
                if (cVar != null) {
                    cVar.tt(i - 64);
                    return;
                }
                return;
            }
            this.c &= ~(1 << i);
        }

        public void c() {
            this.c = 0L;
            c cVar = this.tt;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void c(View view, int i, boolean z) {
        int iC = i < 0 ? this.c.c() : a(i);
        this.tt.insert(iC, z);
        if (z) {
            sp(view);
        }
        this.c.c(view, iC);
    }

    public void uj(View view) {
        int iC = this.c.c(view);
        if (iC < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.tt.c(iC);
        sp(view);
    }

    public int tt() {
        return this.c.c() - this.ve.size();
    }

    public boolean a(View view) {
        int iC = this.c.c(view);
        if (iC == -1) {
            x(view);
            return true;
        }
        if (!this.tt.ve(iC)) {
            return false;
        }
        this.tt.uj(iC);
        x(view);
        this.c.c(iC);
        return true;
    }

    public void n(View view) {
        int iC = this.c.c(view);
        if (iC >= 0) {
            if (this.tt.ve(iC)) {
                this.tt.tt(iC);
                x(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
    }

    public int tt(View view) {
        int iC = this.c.c(view);
        if (iC == -1 || this.tt.ve(iC)) {
            return -1;
        }
        return iC - this.tt.n(iC);
    }

    public int ve() {
        return this.c.c();
    }

    public boolean ve(View view) {
        return this.ve.contains(view);
    }

    public void c(View view) {
        int iC = this.c.c(view);
        if (iC >= 0) {
            if (this.tt.uj(iC)) {
                x(view);
            }
            this.c.c(iC);
        }
    }

    public void c(int i) {
        int iA = a(i);
        View viewTt = this.c.tt(iA);
        if (viewTt != null) {
            if (this.tt.uj(iA)) {
                x(viewTt);
            }
            this.c.c(iA);
        }
    }

    public void c() {
        this.tt.c();
        for (int size = this.ve.size() - 1; size >= 0; size--) {
            this.c.uj(this.ve.get(size));
            this.ve.remove(size);
        }
        this.c.tt();
    }

    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iA;
        if (i < 0) {
            iA = this.c.c();
        } else {
            iA = a(i);
        }
        this.tt.insert(iA, z);
        if (z) {
            sp(view);
        }
        this.c.c(view, iA, layoutParams);
    }
}
