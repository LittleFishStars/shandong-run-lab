package com.byazt.rrb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 771, 20})
public class c extends com.byazt.jn.c {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.jn.c
    public void sl(String str) {
        z.c(this.tt, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.rrb.c.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                c.this.tt(new BitmapDrawable(c.this.tt.getResources(), bitmap));
            }
        }, 320);
    }
}
