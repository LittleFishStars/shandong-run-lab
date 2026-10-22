package com.aliyun.common.d;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.aliyun.common.a.a<a> {
    private final Bitmap c;

    public a(Bitmap bitmap) {
        super(null);
        this.c = bitmap;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.aliyun.common.e.a
    public void a() {
        com.aliyun.common.a.b<T> bVar = this.b;
        if (bVar != 0) {
            bVar.a((T) this);
        } else {
            if (this.c.isRecycled()) {
                return;
            }
            this.c.recycle();
        }
    }

    public Bitmap d() {
        return this.c;
    }
}
