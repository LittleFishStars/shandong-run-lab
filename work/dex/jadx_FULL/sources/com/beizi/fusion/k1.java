package com.beizi.fusion;

import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeMuteView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k1 extends aa {
    @Override // com.beizi.fusion.dc
    public void a(View view, int i) {
        if (view instanceof ScopeMuteView) {
            ((ScopeMuteView) view).switchVideoVoice();
        }
    }
}
