package com.byazt.oq;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 20})
public class c implements Interpolator {
    public PointF c;
    public PointF n;
    public PointF tt;
    public PointF uj;
    public PointF ve;

    public c(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.ve = new PointF();
        this.uj = new PointF();
        this.n = new PointF();
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = pointF2.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.c = pointF;
        this.tt = pointF2;
    }

    private float uj(float f) {
        PointF pointF = this.n;
        PointF pointF2 = this.c;
        float f2 = pointF2.x * 3.0f;
        pointF.x = f2;
        PointF pointF3 = this.uj;
        float f3 = ((this.tt.x - pointF2.x) * 3.0f) - f2;
        pointF3.x = f3;
        PointF pointF4 = this.ve;
        float f4 = (1.0f - pointF.x) - f3;
        pointF4.x = f4;
        return f * (pointF.x + ((pointF3.x + (f4 * f)) * f));
    }

    private float ve(float f) {
        return this.n.x + (f * ((this.uj.x * 2.0f) + (this.ve.x * 3.0f * f)));
    }

    public float c(float f) {
        PointF pointF = this.n;
        PointF pointF2 = this.c;
        float f2 = pointF2.y * 3.0f;
        pointF.y = f2;
        PointF pointF3 = this.uj;
        float f3 = ((this.tt.y - pointF2.y) * 3.0f) - f2;
        pointF3.y = f3;
        PointF pointF4 = this.ve;
        float f4 = (1.0f - pointF.y) - f3;
        pointF4.y = f4;
        return f * (pointF.y + ((pointF3.y + (f4 * f)) * f));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return c(tt(f));
    }

    public float tt(float f) {
        float fVe = f;
        for (int i = 1; i < 14; i++) {
            float fUj = uj(fVe) - f;
            if (Math.abs(fUj) < 0.001d) {
                break;
            }
            fVe -= fUj / ve(fVe);
        }
        return fVe;
    }

    public c(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }
}
