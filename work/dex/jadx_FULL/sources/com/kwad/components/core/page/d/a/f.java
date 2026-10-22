package com.kwad.components.core.page.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.components.core.page.d.a.a {
    private boolean aeA;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public interface a {
        void bx(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        b bVar = this.adZ;
        if (bVar != null) {
            bVar.a(this.aeA, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view) {
        com.kwad.components.core.page.a.b bVar = this.adZ.aeb;
        if (bVar != null) {
            bVar.tR();
        }
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.adZ.mPageTitle)) {
            return this.adZ.mPageTitle;
        }
        List<AdInfo> list = this.adZ.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.adZ.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.helper.a.cs(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate));
    }

    private void uf() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.adZ.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ak(true);
        this.mTitleBarHelper.a(new com.kwad.components.core.b.a.InterfaceC1190a() { // from class: com.kwad.components.core.page.d.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void w(View view) {
                f.this.B(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void x(View view) {
                f.this.C(view);
            }
        });
        ViewGroup viewGroupIb = this.mTitleBarHelper.ib();
        AdTemplate adTemplate = this.adZ.mAdTemplate;
        int i = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.helper.a.cL(adTemplate) && !com.kwad.sdk.core.response.helper.b.dP(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate))) {
            i = 8;
        }
        viewGroupIb.setVisibility(i);
        this.adZ.a(new a() { // from class: com.kwad.components.core.page.d.a.f.2
            @Override // com.kwad.components.core.page.d.a.f.a
            public final void bx(int i2) {
                f.this.mTitleBarHelper.ib().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        b bVar = this.adZ;
        this.aeA = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.helper.a.aY(com.kwad.sdk.core.response.helper.e.eO(bVar.mAdTemplate)));
        uf();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
