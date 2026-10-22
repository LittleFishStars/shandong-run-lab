package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TailFrameBarAppPortraitHorizontal extends a {
    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_horizontal;
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void n(@NonNull AdTemplate adTemplate) {
        if (e.S(adTemplate)) {
            this.Ia.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.nV.setTextColor(Color.parseColor("#FFFFFF"));
            this.Ox.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Ia.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        super.n(adTemplate);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
