package com.byazt.nw;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.byazt.sa.uj;
import com.byazt.xj.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 1547})
public class Swiper extends BaseSwiper<ve> {
    public uj uj;

    public Swiper(Context context) {
        super(context);
    }

    public void c(uj ujVar) {
        this.uj = ujVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.uj;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.uj;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.uj;
        if (ujVar != null) {
            ujVar.uj();
        }
        super.onLayout(z, i, i2, i3, i4);
        uj ujVar2 = this.uj;
        if (ujVar2 != null) {
            ujVar2.c(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.uj;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        } else {
            super.onMeasure(i, i2);
        }
        uj ujVar2 = this.uj;
        if (ujVar2 != null) {
            ujVar2.ve();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.uj;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.uj;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // com.byazt.nw.BaseSwiper
    public View sl(int i) {
        return ((ve) this.c.get(i)).i();
    }
}
