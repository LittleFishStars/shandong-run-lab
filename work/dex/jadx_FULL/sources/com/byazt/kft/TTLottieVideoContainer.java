package com.byazt.kft;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 1476})
public class TTLottieVideoContainer extends FrameLayout implements com.byazt.jr.tt {
    public com.byazt.jr.tt.c c;

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.byazt.jr.tt
    public void c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.jr.tt
    public void c(com.byazt.jr.c cVar) {
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.jr.tt
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.jr.tt.c cVar) {
        this.c = cVar;
    }
}
