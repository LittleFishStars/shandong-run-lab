package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStdShowShareButtonAfterFullscreen extends TBMiniAppVideoStd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f24849a;

    public TBMiniAppVideoStdShowShareButtonAfterFullscreen(Context context) {
        super(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(Context context) {
        super.a(context);
        ImageView imageView = (ImageView) findViewById(R.id.trv_share);
        this.f24849a = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public int getLayoutId() {
        return R.layout.triver_layout_standard_with_share_button;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.trv_share) {
            TriverToastUtils.showToast(getContext(), "Whatever the icon means");
        }
    }

    public TBMiniAppVideoStdShowShareButtonAfterFullscreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(a aVar, int i) {
        super.a(aVar, i);
        if (this.M == 2) {
            this.f24849a.setVisibility(0);
        } else {
            this.f24849a.setVisibility(4);
        }
    }
}
