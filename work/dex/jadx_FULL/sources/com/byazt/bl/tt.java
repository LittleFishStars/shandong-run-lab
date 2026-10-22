package com.byazt.bl;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import com.byazt.yj.eo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 177, 13})
public class tt implements eo {
    public int c;
    public int tt;
    public com.byazt.ep.ve<String, Bitmap> ve;

    public tt(int i, int i2) {
        this.tt = i;
        this.c = i2;
        this.ve = new com.byazt.ep.ve<String, Bitmap>(i) { // from class: com.byazt.bl.tt.1
            @Override // com.byazt.ep.ve
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int tt(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return tt.c(bitmap);
            }
        };
    }

    @Override // com.byazt.yj.c
    public boolean tt(String str) {
        return this.ve.c(str) != null;
    }

    @Override // com.byazt.yj.c
    public boolean c(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.ve.c(str, bitmap);
        return true;
    }

    @Override // com.byazt.yj.c
    public Bitmap c(String str) {
        return this.ve.c(str);
    }

    @Override // com.byazt.yj.c
    public void c() {
        c(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.byazt.yj.c
    public void c(double d) {
        this.ve.c((int) (((double) this.tt) * d));
    }

    public static int c(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
