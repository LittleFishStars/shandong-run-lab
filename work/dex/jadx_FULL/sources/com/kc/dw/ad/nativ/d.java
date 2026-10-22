package com.kc.dw.ad.nativ;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.a0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface d extends com.kc.dw.platform.ad_adapter.c {
    @Override // com.kc.dw.platform.ad_adapter.c
    i a();

    void a(Context context, ViewGroup viewGroup, List<View> list, com.kc.dw.platform.ad_adapter.recycler.f fVar);

    void a(ViewGroup viewGroup, h hVar, com.kc.dw.core.service.logrecord.util.a aVar);

    void b();

    int getAdPatternType();

    String getDesc();

    String getIconUrl();

    String[] getImgUrls();

    @Override // com.kc.dw.platform.ad_adapter.c
    int getInteractionType();

    a0 getMediaView();

    String getTitle();
}
