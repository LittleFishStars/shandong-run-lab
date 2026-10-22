package com.kwad.components.core.innerEc.live.b.a;

import com.kwad.components.core.innerEc.live.a.e;
import com.kwad.components.core.innerEc.live.a.p;
import com.kwad.components.core.innerEc.live.config.net.g;
import com.kwad.components.core.innerEc.live.widget.h;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILiveBindOwner;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ILiveLongConnection;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public String Ty;
    public com.kwad.components.core.innerEc.live.base.a UA;
    public KsFragment UC;
    public ILiveBindOwner UD;
    public com.kwad.components.core.widget.a.b UE;
    public com.kwad.components.core.innerEc.live.config.b UF;
    public com.kwad.components.core.innerEc.live.end.a UG;
    public ILiveLongConnection UH;
    public com.kwad.components.core.innerEc.live.video.a.b UI;
    public com.kwad.components.core.innerEc.live.c.a UJ;
    public com.kwad.components.core.innerEc.live.end.a UK;
    public h UL;
    public com.kwad.sdk.g.b<Object, Object> UN;
    public com.kwad.sdk.g.b<Object, Object> UQ;
    public com.kwad.components.core.innerEc.live.d.b UR;
    public p US;
    public e UT;
    public AdResultData mAdResultData;
    public List<com.kwad.components.core.k.a> UB = new ArrayList();
    public g UM = new g();
    public List<com.kwad.sdk.g.b<Object, Object>> UO = new ArrayList();
    public String Tx = "0";
    public boolean UU = true;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.UJ.destroy();
        this.UD.release();
    }
}
