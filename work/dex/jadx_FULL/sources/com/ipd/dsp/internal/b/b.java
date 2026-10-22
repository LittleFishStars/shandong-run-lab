package com.ipd.dsp.internal.b;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.a0.o;
import com.ipd.dsp.internal.a0.p;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b<T> implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38189a;
    public final d b;
    public final h c;
    public final a<T> d;
    public final InterfaceC0859b<T> e;
    public int f;
    public int g;
    public int i;
    public int h = -1;
    public boolean j = true;

    public interface a<U> {
        @Nullable
        g<?> a(@NonNull U u);

        @NonNull
        List<U> a(int i);
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0859b<T> {
        @Nullable
        int[] a(@NonNull T t, int i, int i2);
    }

    public static final class c implements p<Object> {
        public int f;
        public int g;

        @Nullable
        public com.ipd.dsp.internal.z.e h;

        @Override // com.ipd.dsp.internal.a0.p
        @Nullable
        public com.ipd.dsp.internal.z.e getRequest() {
            return this.h;
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void getSize(@NonNull o oVar) {
            oVar.a(this.g, this.f);
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onDestroy() {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onResourceReady(@NonNull Object obj, @Nullable com.ipd.dsp.internal.b0.f<? super Object> fVar) {
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onStart() {
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onStop() {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void removeCallback(@NonNull o oVar) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar) {
            this.h = eVar;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<c> f38190a;

        public d(int i) {
            this.f38190a = com.ipd.dsp.internal.d0.o.a(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f38190a.offer(new c());
            }
        }

        public c a(int i, int i2) {
            c cVarPoll = this.f38190a.poll();
            this.f38190a.offer(cVarPoll);
            cVarPoll.g = i;
            cVarPoll.f = i2;
            return cVarPoll;
        }
    }

    public b(@NonNull h hVar, @NonNull a<T> aVar, @NonNull InterfaceC0859b<T> interfaceC0859b, int i) {
        this.c = hVar;
        this.d = aVar;
        this.e = interfaceC0859b;
        this.f38189a = i;
        this.b = new d(i + 1);
    }

    public final void a(int i, boolean z) {
        if (this.j != z) {
            this.j = z;
            a();
        }
        a(i, (z ? this.f38189a : -this.f38189a) + i);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.i == 0 && i3 == 0) {
            return;
        }
        this.i = i3;
        int i4 = this.h;
        if (i > i4) {
            a(i2 + i, true);
        } else if (i < i4) {
            a(i, false);
        }
        this.h = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void a(int i, int i2) {
        int iMin;
        int iMax;
        if (i < i2) {
            iMax = Math.max(this.f, i);
            iMin = i2;
        } else {
            iMin = Math.min(this.g, i);
            iMax = i2;
        }
        int iMin2 = Math.min(this.i, iMin);
        int iMin3 = Math.min(this.i, Math.max(0, iMax));
        if (i < i2) {
            for (int i3 = iMin3; i3 < iMin2; i3++) {
                a((List) this.d.a(i3), i3, true);
            }
        } else {
            for (int i4 = iMin2 - 1; i4 >= iMin3; i4--) {
                a((List) this.d.a(i4), i4, false);
            }
        }
        this.g = iMin3;
        this.f = iMin2;
    }

    public final void a(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                a(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            a(list.get(i3), i, i3);
        }
    }

    public final void a(@Nullable T t, int i, int i2) {
        int[] iArrA;
        g<?> gVarA;
        if (t == null || (iArrA = this.e.a(t, i, i2)) == null || (gVarA = this.d.a(t)) == null) {
            return;
        }
        gVarA.b(this.b.a(iArrA[0], iArrA[1]));
    }

    public final void a() {
        for (int i = 0; i < this.b.f38190a.size(); i++) {
            this.c.a((p<?>) this.b.a(0, 0));
        }
    }
}
