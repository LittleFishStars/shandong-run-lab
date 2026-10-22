package com.byazt.kt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 54})
public class ve extends sl {
    public static TimeInterpolator i;
    public ArrayList<RecyclerView.gu> da = new ArrayList<>();
    public ArrayList<RecyclerView.gu> sl = new ArrayList<>();
    public ArrayList<tt> t = new ArrayList<>();
    public ArrayList<c> u = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.gu>> c = new ArrayList<>();
    public ArrayList<ArrayList<tt>> tt = new ArrayList<>();
    public ArrayList<ArrayList<c>> ve = new ArrayList<>();
    public ArrayList<RecyclerView.gu> uj = new ArrayList<>();
    public ArrayList<RecyclerView.gu> n = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<RecyclerView.gu> f28752a = new ArrayList<>();
    public ArrayList<RecyclerView.gu> sp = new ArrayList<>();

    @com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt {
        public RecyclerView.gu c;
        public int n;
        public int tt;
        public int uj;
        public int ve;

        public tt(RecyclerView.gu guVar, int i, int i2, int i3, int i4) {
            this.c = guVar;
            this.tt = i;
            this.ve = i2;
            this.uj = i3;
            this.n = i4;
        }
    }

    private void sl(final RecyclerView.gu guVar) {
        final View view = guVar.c;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f28752a.add(guVar);
        viewPropertyAnimatorAnimate.setDuration(sp()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.kt.ve.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                ve.this.x(guVar);
                ve.this.f28752a.remove(guVar);
                ve.this.ve();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void t(RecyclerView.gu guVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        guVar.c.animate().setInterpolator(i);
        uj(guVar);
    }

    @Override // com.byazt.kt.RecyclerView.a
    public void c() {
        boolean z = !this.da.isEmpty();
        boolean z2 = !this.t.isEmpty();
        boolean z3 = !this.u.isEmpty();
        boolean z4 = !this.sl.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.gu> it = this.da.iterator();
            while (it.hasNext()) {
                sl(it.next());
            }
            this.da.clear();
            if (z2) {
                final ArrayList<tt> arrayList = new ArrayList<>();
                arrayList.addAll(this.t);
                this.tt.add(arrayList);
                this.t.clear();
                Runnable runnable = new Runnable() { // from class: com.byazt.kt.ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (tt ttVar : arrayList) {
                            ve.this.tt(ttVar.c, ttVar.tt, ttVar.ve, ttVar.uj, ttVar.n);
                        }
                        arrayList.clear();
                        ve.this.tt.remove(arrayList);
                    }
                };
                if (z) {
                    com.byazt.fq.sp.c(arrayList.get(0).c.c, runnable, sp());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<c> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.u);
                this.ve.add(arrayList2);
                this.u.clear();
                Runnable runnable2 = new Runnable() { // from class: com.byazt.kt.ve.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            ve.this.c((c) it2.next());
                        }
                        arrayList2.clear();
                        ve.this.ve.remove(arrayList2);
                    }
                };
                if (z) {
                    com.byazt.fq.sp.c(arrayList2.get(0).c.c, runnable2, sp());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.gu> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.sl);
                this.c.add(arrayList3);
                this.sl.clear();
                Runnable runnable3 = new Runnable() { // from class: com.byazt.kt.ve.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ve.this.ve((RecyclerView.gu) it2.next());
                        }
                        arrayList3.clear();
                        ve.this.c.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    com.byazt.fq.sp.c(arrayList3.get(0).c, runnable3, (z ? sp() : 0L) + Math.max(z2 ? n() : 0L, z3 ? x() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // com.byazt.kt.sl
    public boolean tt(RecyclerView.gu guVar) {
        t(guVar);
        guVar.c.setAlpha(0.0f);
        this.sl.add(guVar);
        return true;
    }

    @Override // com.byazt.kt.RecyclerView.a
    public void uj(RecyclerView.gu guVar) {
        View view = guVar.c;
        view.animate().cancel();
        int size = this.t.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.t.get(size).c == guVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                i(guVar);
                this.t.remove(size);
            }
        }
        c(this.u, guVar);
        if (this.da.remove(guVar)) {
            view.setAlpha(1.0f);
            x(guVar);
        }
        if (this.sl.remove(guVar)) {
            view.setAlpha(1.0f);
            da(guVar);
        }
        for (int size2 = this.ve.size() - 1; size2 >= 0; size2--) {
            ArrayList<c> arrayList = this.ve.get(size2);
            c(arrayList, guVar);
            if (arrayList.isEmpty()) {
                this.ve.remove(size2);
            }
        }
        for (int size3 = this.tt.size() - 1; size3 >= 0; size3--) {
            ArrayList<tt> arrayList2 = this.tt.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).c == guVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    i(guVar);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.tt.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.c.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.gu> arrayList3 = this.c.get(size5);
            if (arrayList3.remove(guVar)) {
                view.setAlpha(1.0f);
                da(guVar);
                if (arrayList3.isEmpty()) {
                    this.c.remove(size5);
                }
            }
        }
        this.f28752a.remove(guVar);
        this.uj.remove(guVar);
        this.sp.remove(guVar);
        this.n.remove(guVar);
        ve();
    }

    public void ve(final RecyclerView.gu guVar) {
        final View view = guVar.c;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.uj.add(guVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(a()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.kt.ve.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                ve.this.da(guVar);
                ve.this.uj.remove(guVar);
                ve.this.ve();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 24})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28754a;
        public RecyclerView.gu c;
        public int n;
        public RecyclerView.gu tt;
        public int uj;
        public int ve;

        private c(RecyclerView.gu guVar, RecyclerView.gu guVar2) {
            this.c = guVar;
            this.tt = guVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.c + ", newHolder=" + this.tt + ", fromX=" + this.ve + ", fromY=" + this.uj + ", toX=" + this.n + ", toY=" + this.f28754a + '}';
        }

        public c(RecyclerView.gu guVar, RecyclerView.gu guVar2, int i, int i2, int i3, int i4) {
            this(guVar, guVar2);
            this.ve = i;
            this.uj = i2;
            this.n = i3;
            this.f28754a = i4;
        }
    }

    public void tt(final RecyclerView.gu guVar, int i2, int i3, int i4, int i5) {
        final View view = guVar.c;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.n.add(guVar);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.kt.ve.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                ve.this.i(guVar);
                ve.this.n.remove(guVar);
                ve.this.ve();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    public void ve() {
        if (tt()) {
            return;
        }
        i();
    }

    private void tt(c cVar) {
        RecyclerView.gu guVar = cVar.c;
        if (guVar != null) {
            c(cVar, guVar);
        }
        RecyclerView.gu guVar2 = cVar.tt;
        if (guVar2 != null) {
            c(cVar, guVar2);
        }
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean tt() {
        return (this.sl.isEmpty() && this.u.isEmpty() && this.t.isEmpty() && this.da.isEmpty() && this.n.isEmpty() && this.f28752a.isEmpty() && this.uj.isEmpty() && this.sp.isEmpty() && this.tt.isEmpty() && this.c.isEmpty() && this.ve.isEmpty()) ? false : true;
    }

    @Override // com.byazt.kt.sl
    public boolean c(RecyclerView.gu guVar) {
        t(guVar);
        this.da.add(guVar);
        return true;
    }

    @Override // com.byazt.kt.sl
    public boolean c(RecyclerView.gu guVar, int i2, int i3, int i4, int i5) {
        View view = guVar.c;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) guVar.c.getTranslationY());
        t(guVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            i(guVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.t.add(new tt(guVar, translationX, translationY, i4, i5));
        return true;
    }

    @Override // com.byazt.kt.RecyclerView.a
    public void uj() {
        int size = this.t.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            tt ttVar = this.t.get(size);
            View view = ttVar.c.c;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            i(ttVar.c);
            this.t.remove(size);
        }
        for (int size2 = this.da.size() - 1; size2 >= 0; size2--) {
            x(this.da.get(size2));
            this.da.remove(size2);
        }
        int size3 = this.sl.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.gu guVar = this.sl.get(size3);
            guVar.c.setAlpha(1.0f);
            da(guVar);
            this.sl.remove(size3);
        }
        for (int size4 = this.u.size() - 1; size4 >= 0; size4--) {
            tt(this.u.get(size4));
        }
        this.u.clear();
        if (tt()) {
            for (int size5 = this.tt.size() - 1; size5 >= 0; size5--) {
                ArrayList<tt> arrayList = this.tt.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    tt ttVar2 = arrayList.get(size6);
                    View view2 = ttVar2.c.c;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    i(ttVar2.c);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.tt.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.c.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.gu> arrayList2 = this.c.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.gu guVar2 = arrayList2.get(size8);
                    guVar2.c.setAlpha(1.0f);
                    da(guVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.c.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.ve.size() - 1; size9 >= 0; size9--) {
                ArrayList<c> arrayList3 = this.ve.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    tt(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.ve.remove(arrayList3);
                    }
                }
            }
            c(this.f28752a);
            c(this.n);
            c(this.uj);
            c(this.sp);
            i();
        }
    }

    @Override // com.byazt.kt.sl
    public boolean c(RecyclerView.gu guVar, RecyclerView.gu guVar2, int i2, int i3, int i4, int i5) {
        if (guVar == guVar2) {
            return c(guVar, i2, i3, i4, i5);
        }
        float translationX = guVar.c.getTranslationX();
        float translationY = guVar.c.getTranslationY();
        float alpha = guVar.c.getAlpha();
        t(guVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        guVar.c.setTranslationX(translationX);
        guVar.c.setTranslationY(translationY);
        guVar.c.setAlpha(alpha);
        if (guVar2 != null) {
            t(guVar2);
            guVar2.c.setTranslationX(-i6);
            guVar2.c.setTranslationY(-i7);
            guVar2.c.setAlpha(0.0f);
        }
        this.u.add(new c(guVar, guVar2, i2, i3, i4, i5));
        return true;
    }

    public void c(final c cVar) {
        RecyclerView.gu guVar = cVar.c;
        final View view = guVar == null ? null : guVar.c;
        RecyclerView.gu guVar2 = cVar.tt;
        final View view2 = guVar2 != null ? guVar2.c : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(x());
            this.sp.add(cVar.c);
            duration.translationX(cVar.n - cVar.ve);
            duration.translationY(cVar.f28754a - cVar.uj);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.kt.ve.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    ve.this.c(cVar.c, true);
                    ve.this.sp.remove(cVar.c);
                    ve.this.ve();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.sp.add(cVar.tt);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(x()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.byazt.kt.ve.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    ve.this.c(cVar.tt, false);
                    ve.this.sp.remove(cVar.tt);
                    ve.this.ve();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    private void c(List<c> list, RecyclerView.gu guVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (c(cVar, guVar) && cVar.c == null && cVar.tt == null) {
                list.remove(cVar);
            }
        }
    }

    private boolean c(c cVar, RecyclerView.gu guVar) {
        boolean z = false;
        if (cVar.tt == guVar) {
            cVar.tt = null;
        } else {
            if (cVar.c != guVar) {
                return false;
            }
            cVar.c = null;
            z = true;
        }
        guVar.c.setAlpha(1.0f);
        guVar.c.setTranslationX(0.0f);
        guVar.c.setTranslationY(0.0f);
        c(guVar, z);
        return true;
    }

    public void c(List<RecyclerView.gu> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).c.animate().cancel();
        }
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean c(RecyclerView.gu guVar, List<Object> list) {
        return !list.isEmpty() || super.c(guVar, list);
    }
}
