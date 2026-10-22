package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.VideoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeAdCloseView extends ScopeCapsuleCloseView {
    public ScopeAdCloseView(@NonNull Context context) {
        super(context);
    }

    private void e() {
        setText("");
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.asnp_interaction_icon_close, null));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iMin = Math.min(layoutParams.width, layoutParams.height);
        layoutParams.width = iMin;
        layoutParams.height = iMin;
        setLayoutParams(layoutParams);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeCapsuleCloseView
    public void c() {
        e();
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getInteractionModel() == null || !this.d.getInteractionModel().isAutoSkip()) {
            return;
        }
        super.c();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeCapsuleCloseView
    public void d() {
        e();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeCapsuleCloseView
    public int getCountDownTime() {
        VideoModel video;
        AssetModel assetModel = this.e;
        return (assetModel == null || (video = assetModel.getVideo()) == null || video.getDuration() <= 0) ? super.getCountDownTime() : video.getDuration();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeCapsuleCloseView
    public int getDefaultCountDownTime() {
        return 0;
    }

    public ScopeAdCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeAdCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
