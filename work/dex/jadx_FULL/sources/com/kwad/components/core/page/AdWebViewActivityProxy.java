package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.c.h;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
public class AdWebViewActivityProxy extends com.kwad.components.core.proxy.f {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_AUTH_INNER_EC_CACHE_LISTENER_IDX = "key_auth_inner_ec_cache_listener_idx";
    private static final String KEY_H5_AUTH_URL = "key_h5_auth_url";
    public static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    public static final String KEY_IS_HALF_PAGE = "key_is_half_page";
    public static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String TAG = "AdWebViewActivityProxy";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private h mAuthInnerEcCacheListener;
    private boolean mAutoShow;
    private com.kwad.components.core.r.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private View mFinalLandingView;
    private String mH5AuthUrl;
    private c mH5LoginPageView;
    private boolean mHasShowShowConfirmDialog;
    private boolean mIsHalfPage;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private d mLandingPageView;
    private f mMerchantLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private ViewGroup mRootContainer;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.b mLandPageViewListener = new com.kwad.components.core.page.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
        @Override // com.kwad.components.core.page.a.b
        public final void tQ() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.b
        public final void tR() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.uc();
                return;
            }
            if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate != null && AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate == null || !com.kwad.sdk.core.response.helper.a.aU(com.kwad.sdk.core.response.helper.e.eO(AdWebViewActivityProxy.this.mAdTemplate)) || com.kwad.components.core.r.a.wm().wn() != 1 || !com.kwad.components.core.r.a.wm().ws() || com.kwad.components.core.r.a.wm().wp()) {
                if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.showDialog();
                    return;
                } else {
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
            }
            if (com.kwad.components.core.r.a.wm().wo() || !com.kwad.sdk.core.config.e.JM()) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
            adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
            com.kwad.components.core.r.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
        }
    };
    private com.kwad.components.core.webview.tachikoma.f.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.f.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.6
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void H(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hm() {
            com.kwad.components.core.r.a.wm().bb(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hu() {
            com.kwad.components.core.r.a.wm().bb(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hv() {
        }
    };

    public static class a {
        private AdTemplate adTemplate;
        private String adn;
        private String ado;
        private AdResultData adp;
        private boolean adq;
        private boolean adr;
        private int ads;
        private boolean adt;
        private String adu;
        private boolean adv;
        private com.kwad.components.core.innerEc.a.a adw;

        /* JADX INFO: renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a, reason: collision with other inner class name */
        public static class C1220a {
            private AdTemplate adTemplate;
            private String adn;
            private String ado;
            private AdResultData adp;
            private boolean adr;
            private int ads = 0;
            private boolean adt;
            private String adu;
            private boolean adv;
            private com.kwad.components.core.innerEc.a.a adw;
            private boolean adx;

            public final C1220a aQ(boolean z) {
                this.adx = z;
                return this;
            }

            public final C1220a aR(boolean z) {
                this.adr = z;
                return this;
            }

            public final C1220a aS(boolean z) {
                this.adt = z;
                return this;
            }

            public final C1220a aY(String str) {
                this.adn = str;
                return this;
            }

            public final C1220a aZ(String str) {
                this.ado = str;
                return this;
            }

            public final C1220a ba(String str) {
                this.adu = str;
                return this;
            }

            public final C1220a bv(int i) {
                this.ads = i;
                return this;
            }

            public final C1220a q(AdResultData adResultData) {
                this.adp = adResultData;
                return this;
            }

            public final a ua() {
                AdResultData adResultData = this.adp;
                a aVar = adResultData != null ? new a(this.adn, this.ado, adResultData, this.adx, this.adr, this.adt, this.ads, (byte) 0) : new a(this.adn, this.ado, this.adTemplate, this.adx, this.adr, this.adt, this.ads, (byte) 0);
                aVar.adu = this.adu;
                aVar.adv = this.adv;
                com.kwad.components.core.innerEc.a.a aVar2 = this.adw;
                if (aVar2 != null) {
                    aVar.a(aVar2);
                }
                return aVar;
            }

            public final C1220a aY(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }
        }

        public /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String tS() {
            return this.adn;
        }

        public final String tT() {
            return this.ado;
        }

        public final int tU() {
            return this.ads;
        }

        public final boolean tV() {
            return this.adq;
        }

        public final boolean tW() {
            return this.adt;
        }

        public final boolean tX() {
            return this.adr;
        }

        public final String tY() {
            return this.adu;
        }

        public final com.kwad.components.core.innerEc.a.a tZ() {
            return this.adw;
        }

        public /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        public final void a(com.kwad.components.core.innerEc.a.a aVar) {
            this.adw = aVar;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adp = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
        }

        private a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.adn = str;
            this.ado = str2;
            this.adq = z;
            this.adr = z2;
            this.adt = z3;
            this.ads = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLandingPageView(View view) {
        ViewGroup viewGroup = this.mRootContainer;
        if (viewGroup == null || view == null) {
            return;
        }
        viewGroup.addView(view);
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new com.kwad.components.core.page.widget.a.InterfaceC1224a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.8
            @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    private int getLandingPageTypeFromIntent() {
        return getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.r.b getTkDialogFragment() {
        com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
        bVar.a(this.mAdResultData);
        bVar.bP(com.kwad.sdk.core.response.helper.b.es(this.mAdTemplate));
        bVar.bo(false);
        bVar.bp(true);
        return com.kwad.components.core.r.b.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.e.JM()) {
            return false;
        }
        if (!br.isNullString(com.kwad.sdk.core.response.helper.a.cM(this.mAdTemplate)) && com.kwad.sdk.core.response.helper.a.cL(this.mAdTemplate)) {
            z = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            } else {
                com.kwad.components.core.r.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.r.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z;
    }

    private void initContentView() {
        com.kwad.sdk.core.d.c.d(TAG, "initContentView call mLandingPageType: " + this.mLandingPageType);
        this.mRootContainer = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        int i = this.mLandingPageType;
        boolean z = i == 2 || i == 3;
        a aVarUa = new a.C1220a().aY(this.mPageTitle).aZ(this.mPageUrl).ba(this.mH5AuthUrl).aY(this.mAdTemplate).aQ(this.mShowPermission).aR(this.mAutoShow).bv(this.mLandingPageType).aS(this.mDisableShowConfirmDialog).ua();
        if (z) {
            f fVar = new f(this.mContext);
            fVar.c(this.mContext, aVarUa);
            fVar.b(getActivity());
            this.mFinalLandingView = fVar;
            this.mMerchantLandingPageView = fVar;
        } else {
            d dVarB = d.b(this.mContext, aVarUa);
            this.mLandingPageView = dVarB;
            dVarB.setLandPageViewListener(this.mLandPageViewListener);
            this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
            this.mFinalLandingView = this.mLandingPageView;
        }
        if (this.mLandingPageType == 3) {
            c cVarA = c.a(this.mContext, aVarUa);
            this.mH5LoginPageView = cVarA;
            cVarA.setH5AuthListener(new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
                @Override // com.kwad.components.core.page.a.a
                public final void aP(boolean z2) {
                    com.kwad.sdk.core.d.c.d(AdWebViewActivityProxy.TAG, "mH5LoginPageView onGetUserInfoFail");
                    if (AdWebViewActivityProxy.this.mAuthInnerEcCacheListener != null) {
                        AdWebViewActivityProxy.this.mAuthInnerEcCacheListener.l(z2 ? 2001 : 2000, "h5 get code error");
                    }
                }

                @Override // com.kwad.components.core.page.a.a
                public final void tN() {
                    com.kwad.sdk.core.d.c.d(AdWebViewActivityProxy.TAG, "mH5LoginPageView onGetCodeSuccess");
                    if (AdWebViewActivityProxy.this.mAuthInnerEcCacheListener != null) {
                        h unused = AdWebViewActivityProxy.this.mAuthInnerEcCacheListener;
                    }
                }

                @Override // com.kwad.components.core.page.a.a
                public final void tO() {
                    com.kwad.sdk.core.d.c.d(AdWebViewActivityProxy.TAG, "mH5LoginPageView onGetUserInfoSuccess");
                    AdWebViewActivityProxy.this.mAdTemplate.isDoAuth = true;
                    if (AdWebViewActivityProxy.this.mAuthInnerEcCacheListener != null) {
                        h unused = AdWebViewActivityProxy.this.mAuthInnerEcCacheListener;
                    }
                    if (TextUtils.isEmpty(AdWebViewActivityProxy.this.mPageUrl)) {
                        AdWebViewActivityProxy.this.finish();
                        return;
                    }
                    AdWebViewActivityProxy.this.mH5LoginPageView.setVisibility(8);
                    AdWebViewActivityProxy.this.mRootContainer.removeView(AdWebViewActivityProxy.this.mH5LoginPageView);
                    com.kwad.sdk.core.d.c.d(AdWebViewActivityProxy.TAG, "after loading auth load landingView :" + AdWebViewActivityProxy.this.mFinalLandingView);
                    AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                    adWebViewActivityProxy.addLandingPageView(adWebViewActivityProxy.mFinalLandingView);
                }

                @Override // com.kwad.components.core.page.a.a
                public final void tP() {
                    com.kwad.sdk.core.d.c.d(AdWebViewActivityProxy.TAG, "mH5LoginPageView onGetUserInfoCancel");
                    if (AdWebViewActivityProxy.this.mAuthInnerEcCacheListener != null) {
                        AdWebViewActivityProxy.this.mAuthInnerEcCacheListener.oW();
                    }
                }
            });
            this.mRootContainer.addView(this.mH5LoginPageView);
            return;
        }
        com.kwad.sdk.core.d.c.d(TAG, "direct add landingView :" + this.mFinalLandingView);
        addLandingPageView(this.mFinalLandingView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.helper.e.S(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.e.JU() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.e.JV() && !this.mAdTemplate.mIsFromContent;
    }

    private boolean isMerchantH5() {
        int landingPageTypeFromIntent = getLandingPageTypeFromIntent();
        com.kwad.sdk.core.d.c.d(TAG, "isMerchantH5: " + landingPageTypeFromIntent);
        return landingPageTypeFromIntent == 2;
    }

    private boolean isNeedAndroid15Adapt(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 35 && context.getApplicationInfo().targetSdkVersion >= 35;
        } catch (Throwable unused) {
        }
    }

    public static void launch(Context context, a aVar) {
        com.kwad.sdk.core.d.c.d(TAG, "launch: pageUrl: " + aVar.ado);
        boolean z = TextUtils.isEmpty(aVar.ado) && TextUtils.isEmpty(aVar.adu);
        if (context == null || z) {
            return;
        }
        try {
            com.kwad.sdk.commercial.f.a.k(aVar.getAdTemplate(), aVar.tU(), aVar.tT());
            com.kwad.sdk.service.c.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra(KEY_PAGE_TITLE, aVar.adn);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.ads);
            intent.putExtra(KEY_PAGE_URL, aVar.ado);
            intent.putExtra(KEY_H5_AUTH_URL, aVar.adu);
            intent.putExtra(KEY_IS_HALF_PAGE, aVar.adv);
            intent.putExtra(KEY_IS_AUTO_SHOW, aVar.adr);
            intent.putExtra(KEY_SHOW_PERMISSION, aVar.adq);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.tW());
            final com.kwad.components.core.innerEc.a.a aVarTZ = aVar.tZ();
            if (aVarTZ != null) {
                intent.putExtra(KEY_AUTH_INNER_EC_CACHE_LISTENER_IDX, com.kwad.components.core.c.f.oU().a(new h() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
                    @Override // com.kwad.components.core.c.h
                    public final void l(int i, String str) {
                        aVarTZ.rn();
                    }

                    @Override // com.kwad.components.core.c.h
                    public final void oW() {
                        aVarTZ.oW();
                    }
                }));
            }
            AdResultData adResultDataEz = aVar.adp;
            if (adResultDataEz == null) {
                adResultDataEz = com.kwad.sdk.core.response.helper.c.ez(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(adResultDataEz));
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            com.kwad.sdk.commercial.f.a.a(aVar.getAdTemplate(), aVar.tU(), aVar.tT(), by.y(th));
            if (!o.Gs().Fu()) {
                throw th;
            }
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData adResultDataD = com.kwad.components.core.c.f.oU().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = adResultDataD;
        if (adResultDataD == null) {
            return false;
        }
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultDataD);
        this.mAdTemplate = adTemplateR;
        return adTemplateR != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
        this.mH5AuthUrl = getIntent().getStringExtra(KEY_H5_AUTH_URL);
        this.mIsHalfPage = getIntent().getBooleanExtra(KEY_IS_HALF_PAGE, false);
        this.mAuthInnerEcCacheListener = com.kwad.components.core.c.f.oU().e(getIntent().getIntExtra(KEY_AUTH_INNER_EC_CACHE_LISTENER_IDX, 0), true);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        setContentView(isMerchantH5() ? R.layout.ksad_activity_merchant : R.layout.ksad_activity_landpage);
        initContentView();
        if (isMerchantH5() && this.mRootView != null && isNeedAndroid15Adapt(this.mContext)) {
            this.mRootView.post(new bi() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (com.kwad.sdk.utils.e.r(AdWebViewActivityProxy.this.getActivity())) {
                        AdWebViewActivityProxy.this.mRootView.setPadding(0, 0, 0, com.kwad.sdk.utils.e.q(AdWebViewActivityProxy.this.getActivity()));
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return isMerchantH5();
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        if (isMerchantH5()) {
            getActivity().setTheme(android.R.style.Theme.Light.NoTitleBar);
        }
        com.kwad.sdk.commercial.f.a.l(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mH5LoginPageView;
        if (cVar != null && cVar.getVisibility() == 0) {
            finish();
            return;
        }
        int i = this.mLandingPageType;
        if (i == 2 || i == 3) {
            finish();
            return;
        }
        d dVar = this.mLandingPageView;
        if (dVar != null && dVar.getCanInterceptBackClick()) {
            this.mLandingPageView.uc();
            return;
        }
        if (this.mDisableShowConfirmDialog) {
            finish();
            return;
        }
        if (handleMiddlePageDialog()) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.aU(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) && com.kwad.components.core.r.a.wm().wn() == 1 && com.kwad.components.core.r.a.wm().ws() && !com.kwad.components.core.r.a.wm().wp()) {
            if (com.kwad.components.core.r.a.wm().wo() || !com.kwad.sdk.core.config.e.JM()) {
                super.onBackPressed();
                return;
            }
            com.kwad.components.core.r.b tkDialogFragment = getTkDialogFragment();
            this.mDialogFragment = tkDialogFragment;
            com.kwad.components.core.r.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
            return;
        }
        if (isFormAdExitInterceptEnable()) {
            try {
                if (this.mKsExitInterceptDialogV2 == null) {
                    this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new com.kwad.components.core.page.widget.a.InterfaceC1224a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.7
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void a(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void b(DialogInterface dialogInterface) {
                            if (!AdWebViewActivityProxy.this.destroyed) {
                                try {
                                    AdWebViewActivityProxy.super.onBackPressed();
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.c.printStackTrace(th);
                                }
                            }
                            com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 105);
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC1224a
                        public final void c(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.t(AdWebViewActivityProxy.this.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    });
                }
                com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                this.mKsExitInterceptDialogV2.show();
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (isMerchantH5()) {
            e.b(getWindow());
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.r.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            Dialog dialog2 = this.mKsExitInterceptDialogV2;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mKsExitInterceptDialogV2.dismiss();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.interactLandingPageShowing = false;
                adTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.f
    public int onSetActivityTheme() {
        if (isMerchantH5()) {
            return -1;
        }
        return super.onSetActivityTheme();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C1220a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).ua());
    }
}
