package com.byazt.dg;

import android.view.animation.Interpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 20})
public abstract class c<K, A> {
    public final ve<K> n;
    public com.byazt.vc.ve<A> ve;
    public final List<InterfaceC0385c> c = new ArrayList(1);
    public boolean uj = false;
    public float tt = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public A f28396a = null;
    public float sp = -1.0f;
    public float x = -1.0f;

    /* JADX INFO: renamed from: com.byazt.dg.c$c, reason: collision with other inner class name */
    public interface InterfaceC0385c {
        void c();
    }

    @com.byazt.zqa.c(c = {0, 1, 186, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT})
    public static final class n<T> implements ve<T> {
        public final com.byazt.vc.c<T> c;
        public float tt = -1.0f;

        public n(List<? extends com.byazt.vc.c<T>> list) {
            this.c = list.get(0);
        }

        @Override // com.byazt.dg.c.ve
        public boolean c() {
            return false;
        }

        @Override // com.byazt.dg.c.ve
        public boolean c(float f) {
            return !this.c.n();
        }

        @Override // com.byazt.dg.c.ve
        public com.byazt.vc.c<T> tt() {
            return this.c;
        }

        @Override // com.byazt.dg.c.ve
        public float uj() {
            return this.c.uj();
        }

        @Override // com.byazt.dg.c.ve
        public float ve() {
            return this.c.ve();
        }

        @Override // com.byazt.dg.c.ve
        public boolean tt(float f) {
            if (this.tt == f) {
                return true;
            }
            this.tt = f;
            return false;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 186, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static final class tt<T> implements ve<T> {
        private tt() {
        }

        @Override // com.byazt.dg.c.ve
        public boolean c() {
            return true;
        }

        @Override // com.byazt.dg.c.ve
        public boolean c(float f) {
            return false;
        }

        @Override // com.byazt.dg.c.ve
        public com.byazt.vc.c<T> tt() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.byazt.dg.c.ve
        public float uj() {
            return 1.0f;
        }

        @Override // com.byazt.dg.c.ve
        public float ve() {
            return 0.0f;
        }

        @Override // com.byazt.dg.c.ve
        public boolean tt(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 186, 187})
    public static final class uj<T> implements ve<T> {
        public final List<? extends com.byazt.vc.c<T>> c;
        public com.byazt.vc.c<T> ve = null;
        public float uj = -1.0f;
        public com.byazt.vc.c<T> tt = ve(0.0f);

        public uj(List<? extends com.byazt.vc.c<T>> list) {
            this.c = list;
        }

        private com.byazt.vc.c<T> ve(float f) {
            List<? extends com.byazt.vc.c<T>> list = this.c;
            com.byazt.vc.c<T> cVar = list.get(list.size() - 1);
            if (f >= cVar.ve()) {
                return cVar;
            }
            for (int size = this.c.size() - 2; size > 0; size--) {
                com.byazt.vc.c<T> cVar2 = this.c.get(size);
                if (this.tt != cVar2 && cVar2.c(f)) {
                    return cVar2;
                }
            }
            return this.c.get(0);
        }

        @Override // com.byazt.dg.c.ve
        public boolean c() {
            return false;
        }

        @Override // com.byazt.dg.c.ve
        public boolean c(float f) {
            if (this.tt.c(f)) {
                return !this.tt.n();
            }
            this.tt = ve(f);
            return true;
        }

        @Override // com.byazt.dg.c.ve
        public com.byazt.vc.c<T> tt() {
            return this.tt;
        }

        @Override // com.byazt.dg.c.ve
        public float uj() {
            List<? extends com.byazt.vc.c<T>> list = this.c;
            return list.get(list.size() - 1).uj();
        }

        @Override // com.byazt.dg.c.ve
        public boolean tt(float f) {
            com.byazt.vc.c<T> cVar = this.ve;
            com.byazt.vc.c<T> cVar2 = this.tt;
            if (cVar == cVar2 && this.uj == f) {
                return true;
            }
            this.ve = cVar2;
            this.uj = f;
            return false;
        }

        @Override // com.byazt.dg.c.ve
        public float ve() {
            return this.c.get(0).ve();
        }
    }

    public interface ve<T> {
        boolean c();

        boolean c(float f);

        com.byazt.vc.c<T> tt();

        boolean tt(float f);

        float uj();

        float ve();
    }

    public c(List<? extends com.byazt.vc.c<K>> list) {
        this.n = c(list);
    }

    private float i() {
        if (this.sp == -1.0f) {
            this.sp = this.n.ve();
        }
        return this.sp;
    }

    public float a() {
        if (this.x == -1.0f) {
            this.x = this.n.uj();
        }
        return this.x;
    }

    public abstract A c(com.byazt.vc.c<K> cVar, float f);

    public void c() {
        this.uj = true;
    }

    public float n() {
        com.byazt.vc.c<K> cVarVe = ve();
        if (cVarVe == null || cVarVe.n()) {
            return 0.0f;
        }
        return cVarVe.ve.getInterpolation(uj());
    }

    public A sp() {
        float fUj = uj();
        if (this.ve == null && this.n.tt(fUj)) {
            return this.f28396a;
        }
        com.byazt.vc.c<K> cVarVe = ve();
        Interpolator interpolator = cVarVe.uj;
        A aC = (interpolator == null || cVarVe.n == null) ? c(cVarVe, n()) : c(cVarVe, fUj, interpolator.getInterpolation(fUj), cVarVe.n.getInterpolation(fUj));
        this.f28396a = aC;
        return aC;
    }

    public void tt() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).c();
        }
    }

    public float uj() {
        if (this.uj) {
            return 0.0f;
        }
        com.byazt.vc.c<K> cVarVe = ve();
        if (cVarVe.n()) {
            return 0.0f;
        }
        return (this.tt - cVarVe.ve()) / (cVarVe.uj() - cVarVe.ve());
    }

    public com.byazt.vc.c<K> ve() {
        com.byazt.ga.n.c("BaseKeyframeAnimation#getCurrentKeyframe");
        com.byazt.vc.c<K> cVarTt = this.n.tt();
        com.byazt.ga.n.tt("BaseKeyframeAnimation#getCurrentKeyframe");
        return cVarTt;
    }

    public float x() {
        return this.tt;
    }

    public void c(InterfaceC0385c interfaceC0385c) {
        this.c.add(interfaceC0385c);
    }

    public void c(float f) {
        if (this.n.c()) {
            return;
        }
        if (f < i()) {
            f = i();
        } else if (f > a()) {
            f = a();
        }
        if (f == this.tt) {
            return;
        }
        this.tt = f;
        if (this.n.c(f)) {
            tt();
        }
    }

    public A c(com.byazt.vc.c<K> cVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> ve<T> c(List<? extends com.byazt.vc.c<T>> list) {
        if (list.isEmpty()) {
            return new tt();
        }
        if (list.size() == 1) {
            return new n(list);
        }
        return new uj(list);
    }
}
