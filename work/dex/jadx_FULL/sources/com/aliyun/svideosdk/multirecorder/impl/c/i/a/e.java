package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements c<Bitmap> {
    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public String a() {
        return "TextureView";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(View view, c.a<Bitmap> aVar) {
        aVar.a(((TextureView) view).getBitmap());
    }
}
