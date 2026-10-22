package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.triver.embed.video.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStdMp3 extends TBMiniAppVideoStd {
    public TBMiniAppVideoStdMp3(Context context) {
        super(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public int getLayoutId() {
        return R.layout.triver_jz_layout_standard_mp3;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void h() {
        super.h();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void i() {
        super.i();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void j() {
        super.j();
        this.ay.setVisibility(0);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void k() {
        super.k();
        this.ay.setVisibility(0);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void l() {
        super.l();
        this.ay.setVisibility(0);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void m() {
        super.m();
        this.ay.setVisibility(0);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void n() {
        super.n();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void o() {
        super.o();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == R.id.trv_thumb && ((i = this.L) == 3 || i == 5)) {
            W();
        } else {
            if (view.getId() == R.id.trv_fullscreen) {
                return;
            }
            super.onClick(view);
        }
    }

    public TBMiniAppVideoStdMp3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
