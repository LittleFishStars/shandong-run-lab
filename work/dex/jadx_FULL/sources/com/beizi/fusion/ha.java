package com.beizi.fusion;

import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ha extends aa {
    @Override // com.beizi.fusion.dc
    public void a(View view, int i) {
        this.f27001a.a(x9.a.AD_CLICK, view, Integer.valueOf(i));
        NativeModel nativeModel = this.b;
        LinkModel link = nativeModel != null ? nativeModel.getLink() : null;
        if (link != null) {
            a(link, view, i);
        }
    }

    public abstract void a(LinkModel linkModel, View view, int i);
}
