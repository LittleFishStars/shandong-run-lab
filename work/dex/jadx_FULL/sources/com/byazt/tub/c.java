package com.byazt.tub;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.vn.RoundImageView;
import com.byazt.xj.ve;
import com.byazt.xky.tt;
import com.byazt.yj.gr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 20})
public class c extends ve<RoundImageView> {
    public String c;
    public int yo;

    public c(Context context) {
        super(context);
        this.yo = 25;
    }

    private void x() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        ((RoundImageView) this.n).setImageDrawable(null);
        if (!this.c.startsWith("local://")) {
            tt.c(this.c).type(2).to(new gr() { // from class: com.byazt.tub.c.2
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                    m.tt("UGBlurWidget", str, th);
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(com.byazt.yj.m mVar) {
                    Object result = mVar.getResult();
                    if (result == null || !(result instanceof Bitmap)) {
                        return;
                    }
                    c.this.c((Bitmap) result);
                }
            }, 4);
        } else {
            z.c(this.tt, this.c.replace("local://", ""), new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tub.c.1
                @Override // com.byazt.qr.c
                public void c(Bitmap bitmap) {
                    c.this.tt(bitmap);
                }
            }, 320);
        }
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public RoundImageView c() {
        RoundImageView roundImageView = new RoundImageView(this.tt);
        roundImageView.c(this);
        return roundImageView;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        x();
        ((RoundImageView) this.n).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.n).setBorderColor(this.b);
        ((RoundImageView) this.n).setCornerRadius(this.hd);
        ((RoundImageView) this.n).setBorderWidth(this.kp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bitmap bitmap) {
        final Bitmap bitmapC = com.byazt.or.tt.c(this.tt, bitmap, 25);
        if (bitmapC != null) {
            x.c(new Runnable() { // from class: com.byazt.tub.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.n != null) {
                        ((RoundImageView) c.this.n).setImageBitmap(bitmapC);
                    }
                }
            });
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        if (!str.equals("blurRate")) {
            if (str.equals("src")) {
                this.c = str2;
            }
        } else {
            try {
                this.yo = Integer.parseInt(str2);
            } catch (Exception e) {
                m.tt("UGBlurWidget", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final Bitmap bitmap) {
        x.c(new sp("UG_decode_img") { // from class: com.byazt.tub.c.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        c.this.c(bitmap2);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
