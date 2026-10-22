package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private IAdLiveEndRequest js;
    private long ky;

    @Nullable
    private p ta;

    @Nullable
    private View yh;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @NonNull
        private static AdLiveEndResultData X(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* JADX INFO: renamed from: cS, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.js);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ BaseResultData parseData(String str) {
            return X(str);
        }
    };
    private final m wP = new m() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.jl();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.jm();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.ky = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.jm();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iU() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        bVar.el(24);
        bVar.b(c1273a);
        com.kwad.components.ad.reward.j.b.a(true, this.uj.mAdTemplate, null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl() {
        if (this.js == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.uj.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (b.this.ta == null) {
                            b bVar = b.this;
                            bVar.ta = new p(bVar.uj);
                        }
                        b.this.ta.j(b.this.uj.mRootContainer);
                        b.this.ta.b(r.ah(b.this.uj.mAdTemplate));
                        b.this.ta.a(b.this.uj, adLiveEndResultData.mQLivePushEndInfo, b.this.ky);
                        b.this.uj.ta = b.this.ta;
                        if (b.this.uj.mContext.getResources().getConfiguration().orientation == 2) {
                            b bVar2 = b.this;
                            bVar2.yh = bVar2.findViewById(R.id.ksad_live_end_page_layout_root_landscape);
                        } else {
                            b bVar3 = b.this;
                            bVar3.yh = bVar3.findViewById(R.id.ksad_live_end_page_layout_root);
                        }
                        b.this.yh.setVisibility(0);
                        b.this.iU();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i, String str) {
                super.onError(aVar, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jm() {
        View view = this.yh;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        com.kwad.components.core.offline.a.c.a aVar;
        super.ay();
        if (this.uj.sz.ls()) {
            this.uj.sz.a(this.wP);
            String strBn = com.kwad.sdk.core.response.helper.a.bn(e.eO(this.uj.mAdTemplate));
            if (TextUtils.isEmpty(strBn) || (aVar = (com.kwad.components.core.offline.a.c.a) d.f(com.kwad.components.core.offline.a.c.a.class)) == null) {
                return;
            }
            this.js = aVar.getAdLiveEndRequest(strBn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.uj.sz.ls()) {
            this.uj.sz.b(this.wP);
        }
    }
}
