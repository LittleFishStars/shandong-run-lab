package com.beizi.fusion.asnp.adn.ad.publish.ad.unified.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.beizi.fusion.cf;
import com.beizi.fusion.dm;
import com.beizi.fusion.lp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPUnifiedMediaView extends FrameLayout {
    public ASNPUnifiedMediaView(Context context) {
        super(context);
    }

    public cf getMediaController() {
        getTag(dm.a(getContext(), "scope_unified_media_ctrl"));
        return null;
    }

    public void setMediaConfig(lp lpVar) {
        setTag(dm.a(getContext(), "scope_unified_media_config"), lpVar);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
