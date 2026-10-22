package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s implements BackgroundDetector.BackgroundStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f31253a;

    public s(a aVar) {
        this.f31253a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z) {
        a aVar = this.f31253a;
        aVar.f5521a.sendMessage(aVar.f5521a.obtainMessage(1, Boolean.valueOf(z)));
    }
}
