package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTitleModel;
import com.beizi.fusion.je;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeRegionTextView extends ScopeInteractionTextView implements je {
    private boolean j;

    public ScopeRegionTextView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView
    public void a() {
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getViewModel() == null) {
            super.a();
            return;
        }
        StatusTitleModel interactiveTitle = this.d.getViewModel().getInteractiveTitle();
        if (interactiveTitle != null) {
            String normal = "";
            if (this.j) {
                StatusParamModel download = interactiveTitle.getDownload();
                if (download != null) {
                    normal = download.getNormal();
                }
            } else {
                StatusParamModel normal2 = interactiveTitle.getNormal();
                if (normal2 != null) {
                    normal = normal2.getNormal();
                }
            }
            if (TextUtils.isEmpty(normal)) {
                return;
            }
            setText(normal);
        }
    }

    @Override // com.beizi.fusion.je
    public void setRenderWithDownload(boolean z) {
        this.j = z;
    }

    @Override // com.beizi.fusion.je
    public void updateByInteractiveStatus(String str) {
    }

    public ScopeRegionTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeRegionTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
