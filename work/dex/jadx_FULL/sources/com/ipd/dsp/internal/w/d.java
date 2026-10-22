package com.ipd.dsp.internal.w;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements b {
    public final Context f;
    public final b.a g;

    public d(@NonNull Context context, @NonNull b.a aVar) {
        this.f = context.getApplicationContext();
        this.g = aVar;
    }

    public final void a() {
        p.a(this.f).a(this.g);
    }

    public final void b() {
        p.a(this.f).b(this.g);
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStart() {
        a();
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStop() {
        b();
    }
}
