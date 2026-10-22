package com.ipd.dsp.internal.b0;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f38205a;

    public interface a {
        Animation a(Context context);
    }

    public k(a aVar) {
        this.f38205a = aVar;
    }

    @Override // com.ipd.dsp.internal.b0.f
    public boolean a(R r, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f38205a.a(view.getContext()));
        return false;
    }
}
