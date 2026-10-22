package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.bi;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends b {
    public f(@NonNull Context context) {
        super(context);
        setmIsShowComplianceView(false);
        setRadiusDp(4);
    }

    @Override // com.kwad.components.ad.feed.widget.b, com.kwad.components.core.widget.b
    public final void bC() {
        super.bC();
        View viewFindViewById = findViewById(R.id.ksad_feed_biserial_image);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.ad.feed.widget.b
    public final void cr() {
        this.hX.post(new bi() { // from class: com.kwad.components.ad.feed.widget.f.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ViewGroup.LayoutParams layoutParams = f.this.hZ.getLayoutParams();
                layoutParams.width = f.this.getWidth();
                f.this.hZ.setRatio(1.7857142686843872d);
                f.this.hZ.setLayoutParams(layoutParams);
                List<String> listBg = com.kwad.sdk.core.response.helper.a.bg(f.this.mAdInfo);
                if (listBg.size() <= 0) {
                    com.kwad.sdk.core.d.c.e("FeedBiserialImageView", "getImageUrlList size less than one");
                    return;
                }
                f.this.hP = SystemClock.elapsedRealtime();
                KSImageLoader.loadFeeImage(f.this.hX, listBg.get(0), f.this.mAdTemplate, f.this.hU);
            }
        });
    }

    @Override // com.kwad.components.ad.feed.widget.b
    public final int getDefaultClickArea() {
        return 3;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_biserial_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.KD()) {
            return;
        }
        setBackgroundColor(-1);
    }
}
