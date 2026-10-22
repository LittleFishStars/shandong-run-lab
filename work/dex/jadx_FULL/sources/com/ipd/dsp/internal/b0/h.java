package com.ipd.dsp.internal.b0;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a f38200a;
    public f<R> b;

    public static class a implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f38201a;

        public a(Animation animation) {
            this.f38201a = animation;
        }

        @Override // com.ipd.dsp.internal.b0.k.a
        public Animation a(Context context) {
            return this.f38201a;
        }
    }

    public static class b implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38202a;

        public b(int i) {
            this.f38202a = i;
        }

        @Override // com.ipd.dsp.internal.b0.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f38202a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // com.ipd.dsp.internal.b0.g
    public f<R> a(com.ipd.dsp.internal.f.a aVar, boolean z) {
        if (aVar == com.ipd.dsp.internal.f.a.MEMORY_CACHE || !z) {
            return e.a();
        }
        if (this.b == null) {
            this.b = new k(this.f38200a);
        }
        return this.b;
    }

    public h(int i) {
        this(new b(i));
    }

    public h(k.a aVar) {
        this.f38200a = aVar;
    }
}
