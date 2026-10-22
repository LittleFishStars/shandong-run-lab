package com.kwad.components.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.WebPageActivity;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(WebPageActivity.class)
@Keep
public class WebPageActivityProxy extends com.kwad.components.core.proxy.f {
    private static final String TAG = "WebPageActivityProxy";
    private int mLandingPageType;
    private f mMerchantLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private ViewGroup mRootContainer;

    private void initContentView() {
        com.kwad.sdk.core.d.c.d(TAG, "initContentView call mLandingPageType: " + this.mLandingPageType);
        this.mRootContainer = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        AdWebViewActivityProxy.a aVarUa = new AdWebViewActivityProxy.a.C1220a().aY(this.mPageTitle).aZ(this.mPageUrl).bv(this.mLandingPageType).ua();
        f fVar = new f(this.mContext);
        fVar.c(this.mContext, aVarUa);
        fVar.b(getActivity());
        this.mMerchantLandingPageView = fVar;
        this.mRootContainer.addView(fVar);
    }

    public static void launch(Context context, AdWebViewActivityProxy.a aVar) {
        com.kwad.sdk.core.d.c.d(TAG, "launch: pageUrl: " + aVar.tT() + ", context: " + context);
        if (context == null || TextUtils.isEmpty(aVar.tT())) {
            return;
        }
        try {
            com.kwad.sdk.service.c.putComponentProxy(WebPageActivity.class, WebPageActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) WebPageActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra(AdWebViewActivityProxy.KEY_PAGE_TITLE, aVar.tS());
            intent.putExtra(AdWebViewActivityProxy.KEY_LANDING_PAGE_TYPE, aVar.tU());
            intent.putExtra(AdWebViewActivityProxy.KEY_PAGE_URL, aVar.tT());
            com.kwad.sdk.core.d.c.d(TAG, "launch: startActivity: " + aVar.tT());
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.d(TAG, "launch: startActivity error " + th.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            if (!o.Gs().Fu()) {
                throw th;
            }
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void setWebPagePageUI() {
        by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.page.WebPageActivityProxy.1
            @Override // java.lang.Runnable
            public final void run() {
                int[] iArr = new int[1];
                boolean zA = com.kwad.components.core.innerEc.live.i.c.a(WebPageActivityProxy.this.getActivity(), WebPageActivityProxy.this.getWindow(), iArr);
                int i = iArr[0];
                com.kwad.sdk.core.d.c.e(WebPageActivityProxy.TAG, "jky web page postOnUiThread isNavBarVisible: " + zA);
                View viewFindViewById = WebPageActivityProxy.this.findViewById(android.R.id.content);
                Rect rect = new Rect();
                viewFindViewById.getWindowVisibleDisplayFrame(rect);
                int iG = com.kwad.sdk.c.a.a.g(WebPageActivityProxy.this.getActivity());
                boolean z = iG >= rect.bottom;
                com.kwad.sdk.core.d.c.e(WebPageActivityProxy.TAG, "jky web page postOnUiThread getWindowVisibleDisplayFrame rect: " + rect + ", screenHeight: " + iG + " ,needSetPadding: " + z);
                if (!bd.Wc() && z) {
                    int iL = com.kwad.sdk.c.a.a.l(WebPageActivityProxy.this.getActivity());
                    com.kwad.sdk.core.d.c.d(WebPageActivityProxy.TAG, "naviBarHeight = " + iL + ", naviBarHeightFromViewHeight: " + i);
                    viewFindViewById.setPadding(0, 0, 0, Math.max(i, iL));
                } else if (!z) {
                    viewFindViewById.setPadding(0, 0, 0, 0);
                }
                WebPageActivityProxy.this.getWindow().setNavigationBarColor(-16777216);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "WebPage";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.mPageTitle = getIntent().getStringExtra(AdWebViewActivityProxy.KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(AdWebViewActivityProxy.KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(AdWebViewActivityProxy.KEY_PAGE_URL);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        setContentView(R.layout.ksad_activity_merchant);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return false;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        e.b(getWindow());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        setWebPagePageUI();
    }

    @Override // com.kwad.components.core.proxy.f
    public int onSetActivityTheme() {
        return -1;
    }
}
