package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView;
import com.beizi.fusion.he;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeMuteView extends ScopeInteractionImageView {
    private ScopeVideoView m;

    public ScopeMuteView(@NonNull Context context) {
        super(context);
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ScopeVideoView) {
                this.m = (ScopeVideoView) childAt;
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
        }
    }

    private void f() {
        ScopeExpressContainer expressRoot = getExpressRoot();
        if (expressRoot != null) {
            ScopeVideoView scopeVideoViewE = ScopeExpressContainer.d.e(expressRoot);
            if (scopeVideoViewE instanceof ScopeVideoView) {
                this.m = scopeVideoViewE;
            } else if (expressRoot.getChildCount() > 0) {
                a(expressRoot);
            }
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeImageView, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        f();
        super.fillContent(aVar);
    }

    public void switchVideoVoice() {
        ScopeVideoView scopeVideoView = this.m;
        if (scopeVideoView != null) {
            scopeVideoView.switchVoice(new ScopeVideoView.e() { // from class: com.zj.adlib.uw7
                @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.e
                public final void a(boolean z) {
                    this.f45241a.a(z);
                }
            });
        }
    }

    public ScopeMuteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeMuteView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            setImageResource(R.drawable.asnp_voice_off);
        } else {
            setImageResource(R.drawable.asnp_voice_on);
        }
    }
}
