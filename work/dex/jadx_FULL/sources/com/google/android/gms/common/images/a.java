package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import com.zj.adlib.c3c;
import com.zj.adlib.tb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageManager f31281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zag f5647a;

    public a(ImageManager imageManager, zag zagVar) {
        this.f31281a = imageManager;
        this.f5647a = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tb0.a("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f31281a.f5645a.get(this.f5647a);
        if (imageReceiver != null) {
            this.f31281a.f5645a.remove(this.f5647a);
            imageReceiver.zac(this.f5647a);
        }
        zag zagVar = this.f5647a;
        c3c c3cVar = zagVar.f5651a;
        Uri uri = c3cVar.f40894a;
        if (uri == null) {
            ImageManager imageManager = this.f31281a;
            zagVar.a(imageManager.f5642a, imageManager.f5644a, true);
            return;
        }
        Long l = (Long) this.f31281a.c.get(uri);
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                zag zagVar2 = this.f5647a;
                ImageManager imageManager2 = this.f31281a;
                zagVar2.a(imageManager2.f5642a, imageManager2.f5644a, true);
                return;
            }
            this.f31281a.c.remove(c3cVar.f40894a);
        }
        this.f5647a.zaa(null, false, true, false);
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.f31281a.b.get(c3cVar.f40894a);
        if (imageReceiver2 == null) {
            imageReceiver2 = this.f31281a.new ImageReceiver(c3cVar.f40894a);
            this.f31281a.b.put(c3cVar.f40894a, imageReceiver2);
        }
        imageReceiver2.zab(this.f5647a);
        zag zagVar3 = this.f5647a;
        if (!(zagVar3 instanceof c)) {
            this.f31281a.f5645a.put(zagVar3, imageReceiver2);
        }
        synchronized (ImageManager.f5640a) {
            if (!ImageManager.f5641a.contains(c3cVar.f40894a)) {
                ImageManager.f5641a.add(c3cVar.f40894a);
                imageReceiver2.zad();
            }
        }
    }
}
