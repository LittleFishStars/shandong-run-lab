package com.kwad.components.offline.api.core.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseKsMediaPlayerView extends FrameLayout implements IKsMediaPlayerView {
    public BaseKsMediaPlayerView(Context context) {
        super(context);
    }

    public BaseKsMediaPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseKsMediaPlayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
