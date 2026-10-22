package com.igexin.push.core.i.a;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<Bitmap> f38059a = null;
    private final String b = "GifBitmapProvider";

    @Override // com.igexin.push.core.i.a.d.a
    public final Bitmap a(int i, int i2, Bitmap.Config config, int i3) {
        if (this.f38059a == null) {
            ArrayList<Bitmap> arrayList = new ArrayList<>(2);
            this.f38059a = arrayList;
            arrayList.add(0, Bitmap.createBitmap(i, i2, config));
            this.f38059a.add(1, Bitmap.createBitmap(i, i2, config));
        }
        return this.f38059a.get(i3 % 2);
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void a() {
        ArrayList<Bitmap> arrayList = this.f38059a;
        if (arrayList != null) {
            for (Bitmap bitmap : arrayList) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            this.f38059a = null;
        }
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void a(Bitmap bitmap) {
        com.igexin.c.a.c.a.b("GifBitmapProvider", "release bitmap  ");
        bitmap.recycle();
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final byte[] a(int i) {
        return new byte[i];
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void b() {
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final int[] b(int i) {
        return new int[i];
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void c() {
    }
}
