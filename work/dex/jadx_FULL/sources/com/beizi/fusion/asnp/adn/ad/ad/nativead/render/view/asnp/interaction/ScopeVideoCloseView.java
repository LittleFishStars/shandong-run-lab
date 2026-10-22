package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.ub;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeVideoCloseView extends ScopeInteractionTextView implements ub {
    private Handler j;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 50) {
                ScopeVideoCloseView.this.setVisibility(0);
            }
        }
    }

    public ScopeVideoCloseView(@NonNull Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.ub
    public void delayExposure(long j) {
        if (j < 0) {
            setVisibility(8);
        } else if (j > 0) {
            setVisibility(4);
            if (this.j == null) {
                this.j = new a(getContext().getMainLooper());
            }
            this.j.sendEmptyMessageDelayed(50, j);
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        super.setExpressRoot(scopeExpressContainer);
        ScopeExpressContainer.d.a(scopeExpressContainer, (ub) this);
    }

    public ScopeVideoCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeVideoCloseView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
