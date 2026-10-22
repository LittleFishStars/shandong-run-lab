package com.byazt.vig;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.vn.tt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1490, 20})
public class c extends tt {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.vn.tt
    public void c(final ImageView imageView, String str) {
        z.c(this.tt, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.vig.c.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                imageView.setImageDrawable(com.byazt.vn.c.c(bitmap));
            }
        }, 320);
    }
}
