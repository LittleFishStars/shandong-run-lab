package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gg8 implements ResourceReleaser<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static gg8 f41903a;

    public static gg8 b() {
        if (f41903a == null) {
            f41903a = new gg8();
        }
        return f41903a;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }
}
