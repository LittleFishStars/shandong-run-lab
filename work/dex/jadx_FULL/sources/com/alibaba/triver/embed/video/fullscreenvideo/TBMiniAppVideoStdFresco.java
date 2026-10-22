package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.alibaba.triver.embed.video.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStdFresco extends TBMiniAppVideoStd {
    public TBMiniAppVideoStdFresco(Context context) {
        super(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(Context context) {
        super.a(context);
        this.aw = (ProgressBar) findViewById(R.id.trv_bottom_progress);
        this.av = (ImageView) findViewById(R.id.trv_back);
        this.ax = (ProgressBar) findViewById(R.id.trv_loading);
        this.az = (ImageView) findViewById(R.id.trv_back_tiny);
        this.av.setOnClickListener(this);
        this.az.setOnClickListener(this);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public int getLayoutId() {
        return R.layout.triver_layout_standard_fresco;
    }

    public TBMiniAppVideoStdFresco(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(a aVar, int i) {
        super.a(aVar, i);
        int i2 = this.M;
        if (i2 == 2) {
            this.Q.setImageResource(R.mipmap.jz_shrink);
            this.av.setVisibility(0);
            this.az.setVisibility(4);
        } else if (i2 == 1) {
            this.Q.setImageResource(R.mipmap.jz_enlarge);
            this.av.setVisibility(8);
            this.az.setVisibility(4);
        } else if (i2 == 3) {
            this.az.setVisibility(0);
            a(4, 4, 4, 4, 4, 4, 4);
        }
    }
}
