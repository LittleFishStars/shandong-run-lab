package com.ipd.dsp.internal.b0;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f38204a;

    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f38204a = aVar;
    }

    @Override // com.ipd.dsp.internal.b0.f
    public boolean a(R r, f.a aVar) {
        if (aVar.getView() == null) {
            return false;
        }
        this.f38204a.a(aVar.getView());
        return false;
    }
}
