package com.kwad.components.core.innerEc.live.b;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.b.a.b;
import com.kwad.components.core.innerEc.live.b.c.d;
import com.kwad.components.core.innerEc.live.b.c.g;
import com.kwad.components.core.innerEc.live.b.c.h;
import com.kwad.components.core.innerEc.live.b.c.i;
import com.kwad.components.core.innerEc.live.b.c.j;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.components.core.innerEc.live.slide.LiveDetailActivity;
import com.kwad.components.core.n.c;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILiveBindOwner;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends c {
    private int Uy = 0;
    private String Uz;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    public a() {
        setRetainInstance(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.c
    /* JADX INFO: renamed from: rJ, reason: merged with bridge method [inline-methods] */
    public b an() {
        b bVar = new b();
        ILiveBindOwner iLiveBindOwnerA = f.a(getActivity().getApplication(), this.Uz, rK(), new com.kwad.components.core.innerEc.live.b.b.a());
        bVar.UD = iLiveBindOwnerA;
        bVar.mAdResultData = this.mAdResultData;
        bVar.UC = this;
        bVar.UR = new com.kwad.components.core.innerEc.live.d.b();
        com.kwad.sdk.core.d.c.d("LiveDetailFragment", "jky onCreateCallerContext: callerContext.mTKLoadObserve is: " + bVar.UR);
        if (iLiveBindOwnerA != null) {
            bVar.UI = new com.kwad.components.core.innerEc.live.video.a.b(iLiveBindOwnerA.getLivePlayer());
            bVar.UH = iLiveBindOwnerA.getLongConnection();
        }
        bVar.UK = new com.kwad.components.core.innerEc.live.end.b();
        bVar.UH.init();
        bVar.UF = new com.kwad.components.core.innerEc.live.config.b(this.mAdTemplate);
        bVar.UG = new com.kwad.components.core.innerEc.live.end.b();
        bVar.UE = new com.kwad.components.core.widget.a.b(this, this.oC, 70);
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.UJ = new com.kwad.components.core.innerEc.live.c.a(getActivity(), bVar);
        return bVar;
    }

    private String rK() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, e.aN(this.mAdTemplate));
        return jSONObject.toString();
    }

    public final AdResultData iH() {
        return this.mAdResultData;
    }

    @Override // com.kwad.components.core.n.c
    public final void onActivityDestroy() {
        super.onActivityDestroy();
        com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onActivityDestroy:");
        this.mPresenter = null;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mAdResultData = com.kwad.components.core.c.f.oU().d(getArguments().getInt(LiveDetailActivity.KEY_AD_RESULT_CACHE_IDX, 0), true);
        com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onCreate:" + this.mAdResultData);
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            AdTemplate firstAdTemplate = adResultData.getFirstAdTemplate();
            this.mAdTemplate = firstAdTemplate;
            com.kwad.components.core.innerEc.logger.a.aT(firstAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onViewCreated: mAdResultData is null");
        }
    }

    @Override // com.kwad.components.core.n.c
    @NonNull
    public final Presenter onCreatePresenter() {
        com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onCreatePresenter:");
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.innerEc.live.b.c.e());
        presenter.a(new d());
        presenter.a(new i());
        presenter.a(new com.kwad.components.core.innerEc.live.b.c.b());
        presenter.a(new com.kwad.components.core.innerEc.live.b.c.c());
        presenter.a(new g());
        presenter.a(new h());
        presenter.a(new com.kwad.components.core.innerEc.live.b.c.a());
        presenter.a(new j());
        presenter.a(new com.kwad.components.core.innerEc.live.b.c.f());
        return presenter;
    }

    @Override // com.kwad.components.core.n.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onViewCreated:" + bundle);
        if (getArguments() == null) {
            com.kwad.sdk.core.d.c.e("LiveDetailFragment", "bundle is null");
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            this.Uz = e.g(adTemplate, this.Uy);
            com.kwad.components.core.innerEc.logger.a.aU(this.mAdTemplate);
            super.onViewCreated(view, bundle);
        } else {
            com.kwad.sdk.core.d.c.d("LiveDetailFragment", this + "onViewCreated: mAdTemplate is null");
        }
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rI() {
        return R.layout.ksad_live_play_fragment_layout;
    }
}
