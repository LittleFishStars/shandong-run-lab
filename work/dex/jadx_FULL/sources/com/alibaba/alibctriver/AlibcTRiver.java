package com.alibaba.alibctriver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.alibcprotocol.BCErrorEnum;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.alibctriver.proxy.AlibcTriverLogger;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.point.PushPagePoint;
import com.alibaba.triver.open.TriverRenderCallback;
import com.alibaba.triver.open.TriverSDK;
import com.alibaba.triver.open.container.OpenEmbedViewHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTRiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23645a = "AlibcTRiver";
    private boolean b;

    public static class PushPagePointImpl implements PushPagePoint {
        @Override // com.alibaba.triver.kit.api.point.PushPagePoint
        public boolean navigateToMiniProgram(Page page, String str) {
            if (TextUtils.isEmpty(str)) {
                AlibcLogger.e(AlibcTRiver.f23645a, "navigateToOutside url is null");
                return false;
            }
            boolean zVerifyMiniappUrl = AlibcProtocolUtils.verifyMiniappUrl(str);
            Bundle bundle = page.getApp().getStartParams().getBundle(TRiverConstants.KEY_OVER_PARAMS);
            if (zVerifyMiniappUrl) {
                return AlibcInterceptCenter.shouldInterceptToLaunch(str, bundle, AlibcProtocolConstant.INTERCEPT_TYPE_MINIPROGRAM);
            }
            if (AlibcInterceptCenter.shouldInterceptToLaunch(str, bundle, AlibcProtocolConstant.INTERCEPT_TYPE_MINIPROGRAM)) {
                return false;
            }
            for (AlibcNavigateCenter.IUrlNavigate iUrlNavigate : AlibcNavigateCenter.getNavigateUrlList()) {
                if (page.getPageContext() != null && page.getPageContext().getActivity() != null) {
                    iUrlNavigate.openUrl(page.getPageContext().getActivity(), str);
                }
            }
            return true;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onFinalized() {
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onInitialized() {
        }

        @Override // com.alibaba.triver.kit.api.point.PushPagePoint
        public boolean pushPage(Page page, String str) {
            if (!AlibcInterceptCenter.shouldInterceptToLaunch(str, page.getApp().getStartParams().getBundle(TRiverConstants.KEY_OVER_PARAMS), "page")) {
                return false;
            }
            TRiverConstant.BC_LINK_CODE = BCErrorEnum.PAGE_INTERCEPTOR_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
            return true;
        }

        @Override // com.alibaba.triver.kit.api.point.PushPagePoint
        public boolean switchTab(TinyApp tinyApp, String str) {
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AlibcTRiver f23651a = new AlibcTRiver();

        private b() {
        }
    }

    public static AlibcTRiver a() {
        return b.f23651a;
    }

    public a b() {
        if (this.b) {
            return new a(2);
        }
        try {
            AlibcTriverSDK.init(AlibcBaseTradeCommon.context, new AlibcTriverSDK.a() { // from class: com.alibaba.alibctriver.AlibcTRiver.1
                @Override // com.alibaba.alibctriver.AlibcTriverSDK.a
                public void a() {
                    AlibcLogger.i(AlibcTRiver.f23645a, "triver sdk init success");
                }

                @Override // com.alibaba.alibctriver.AlibcTriverSDK.a
                public void a(String str, String str2) {
                    AlibcLogger.e(AlibcTRiver.f23645a, "triver sdk init fail: code = " + str + ", msg = " + str2);
                }
            });
            this.b = true;
            return new a(0);
        } catch (Exception e) {
            AlibcLogger.e(f23645a, "triver sdk init exception: " + e.getMessage());
            a aVar = new a(1);
            aVar.f = e.getMessage();
            aVar.e = 7;
            return aVar;
        }
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
        if (alibcTradeContext != null) {
            AlibcProtocolUtils.addTaokeParams(bundle, alibcTradeContext.taokeParams);
            AlibcProtocolUtils.addBizParams(bundle, alibcTradeContext.bizParams);
            AlibcProtocolUtils.addShowParams(bundle, alibcTradeContext.showParams);
        }
        return bundle;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f23650a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public int d;
        public int e;
        public String f;

        public a(int i) {
            this.d = i;
        }

        public a(int i, String str) {
            this.d = 1;
            this.e = i;
            this.f = str;
        }
    }

    private AlibcTRiver() {
    }

    public void a(Context context, String str, String str2) {
        Uri uri = Uri.parse(str);
        Bundle bundleC = c();
        bundleC.putString(RVParams.SESSION_ID, str2);
        AlibcTradeContext.getInstance().mActivity = null;
        AlibcTradeContext.getInstance().context = null;
        AlibcTriverSDK.openApp(context, uri, bundleC, new TriverSDK.a() { // from class: com.alibaba.alibctriver.AlibcTRiver.2
            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void a(Context context2) {
                RVProxy.set(RVLogger.Proxy.class, new AlibcTriverLogger());
                super.a(context2);
            }

            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void b(Context context2) {
                super.b(context2);
                AlibcTriverSDK.initPreload();
            }

            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void c(Context context2) {
                super.c(context2);
            }

            @Override // com.alibaba.triver.open.TriverSDK.a, com.alibaba.triver.open.TriverSDK.c
            public void d(Context context2) {
                AlibcTriverSDK.initTbLive();
            }
        });
    }

    public void a(FragmentActivity fragmentActivity, Uri uri, final AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        Bundle bundleC = c();
        if (alibcComponentReRenderCallback.getRestoreBundle() != null) {
            bundleC.putAll(alibcComponentReRenderCallback.getRestoreBundle());
        }
        TriverSDK.renderApp(fragmentActivity, uri, bundleC, new TriverRenderCallback() { // from class: com.alibaba.alibctriver.AlibcTRiver.3
            @Override // com.alibaba.triver.open.TriverRenderCallback
            public int getHeight() {
                AlibcComponentReRenderCallback alibcComponentReRenderCallback2 = alibcComponentReRenderCallback;
                if (alibcComponentReRenderCallback2 != null) {
                    return alibcComponentReRenderCallback2.getHeight();
                }
                return 0;
            }

            @Override // com.alibaba.triver.open.TriverRenderCallback
            public int getWidth() {
                AlibcComponentReRenderCallback alibcComponentReRenderCallback2 = alibcComponentReRenderCallback;
                if (alibcComponentReRenderCallback2 != null) {
                    return alibcComponentReRenderCallback2.getWidth();
                }
                return 0;
            }

            @Override // com.alibaba.triver.open.TriverRenderCallback
            public void onFailure(String str, String str2) {
                AlibcComponentReRenderCallback alibcComponentReRenderCallback2 = alibcComponentReRenderCallback;
                if (alibcComponentReRenderCallback2 != null) {
                    alibcComponentReRenderCallback2.onFailure(str, str2);
                }
            }

            @Override // com.alibaba.triver.open.TriverRenderCallback
            public void onRefresh() {
                AlibcComponentReRenderCallback alibcComponentReRenderCallback2 = alibcComponentReRenderCallback;
                if (alibcComponentReRenderCallback2 != null) {
                    alibcComponentReRenderCallback2.onRefresh();
                }
            }

            @Override // com.alibaba.triver.open.TriverRenderCallback
            public void onSuccess(final OpenEmbedViewHolder openEmbedViewHolder) {
                AlibcComponentReRenderCallback alibcComponentReRenderCallback2 = alibcComponentReRenderCallback;
                if (alibcComponentReRenderCallback2 != null) {
                    if (openEmbedViewHolder != null) {
                        alibcComponentReRenderCallback2.onSuccess(new AlibcComponentViewHolder() { // from class: com.alibaba.alibctriver.AlibcTRiver.3.1
                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public View getContentView() {
                                return openEmbedViewHolder.getContentView();
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public Bundle getRestoreBundle() {
                                return openEmbedViewHolder.getRestoreBundle();
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public void onActivityResult(int i, int i2, Intent intent) {
                                openEmbedViewHolder.onActivityResult(i, i, intent);
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public void onDestroy() {
                                openEmbedViewHolder.onDestroy();
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public void onPause() {
                                openEmbedViewHolder.onPause();
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public void onResume() {
                                openEmbedViewHolder.onResume();
                            }

                            @Override // com.alibaba.alibcprotocol.container.callback.AlibcComponentViewHolder
                            public void onStop() {
                                openEmbedViewHolder.onStop();
                            }
                        });
                    } else {
                        alibcComponentReRenderCallback2.onFailure("AC_UNKNOWN", "");
                    }
                }
            }
        });
    }
}
