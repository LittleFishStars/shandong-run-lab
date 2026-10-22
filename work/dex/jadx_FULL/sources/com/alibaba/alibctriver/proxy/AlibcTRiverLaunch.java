package com.alibaba.alibctriver.proxy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.BCErrorEnum;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.alibctriver.AlibcNavigateCenter;
import com.alibaba.alibctriver.AlibcTRiver;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.open.proxy.IRouterProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTRiverLaunch implements IRouterProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23690a = "AlibcTRiverLaunch";

    private void a(final String str, boolean z, String str2, final Context context, final Page page, final int i) {
        AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
        final Map<String, Object> mapObj2Map = AlibcProtocolUtils.obj2Map(alibcTradeContext.showParams, alibcTradeContext.taokeParams, str2, z, AlibcTRiver.a().c());
        if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str)) {
            ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(context, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibctriver.proxy.AlibcTRiverLaunch.1
                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void getLinkUrl(boolean z2, String str3, String str4, int i2) {
                    AlibcTRiverLaunch alibcTRiverLaunch = AlibcTRiverLaunch.this;
                    Context context2 = context;
                    int i3 = i;
                    Page page2 = page;
                    alibcTRiverLaunch.a(z2, i2, str3, context2, i3, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                }

                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void supportFail(String str3, String str4) {
                    AlibcTRiverLaunch.this.a(str3, str4);
                }
            });
        } else if (!z) {
            ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(context, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibctriver.proxy.AlibcTRiverLaunch.3
                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void getLinkUrl(boolean z2, String str3, String str4, int i2) {
                    AlibcTRiverLaunch alibcTRiverLaunch = AlibcTRiverLaunch.this;
                    Context context2 = context;
                    int i3 = i;
                    Page page2 = page;
                    alibcTRiverLaunch.a(z2, i2, str3, context2, i3, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                }

                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void supportFail(String str3, String str4) {
                    AlibcTRiverLaunch.this.a(str3, str4);
                }
            });
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            AlibcProtocolUtils.convertUrl(str, new NetworkRequestListener() { // from class: com.alibaba.alibctriver.proxy.AlibcTRiverLaunch.2
                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public void onError(int i2, NetworkResponse networkResponse) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    AlibcLogger.e(AlibcTRiverLaunch.f23690a, "covert fail: code = " + networkResponse.errorCode + ", msg = " + networkResponse.errorMsg);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                    jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, networkResponse.errorCode, networkResponse.errorMsg, jSONObject);
                    ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(context, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibctriver.proxy.AlibcTRiverLaunch.2.2
                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public void getLinkUrl(boolean z2, String str3, String str4, int i3) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AlibcTRiverLaunch alibcTRiverLaunch = AlibcTRiverLaunch.this;
                            Context context2 = context;
                            int i4 = i;
                            Page page2 = page;
                            alibcTRiverLaunch.a(z2, i3, str3, context2, i4, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                        }

                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public void supportFail(String str3, String str4) {
                            AlibcTRiverLaunch.this.a(str3, str4);
                        }
                    });
                }

                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public void onSuccess(int i2, NetworkResponse networkResponse) {
                    if (networkResponse != null) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        Map<String, Object> map = networkResponse.data;
                        if (map != null) {
                            String strValueOf = String.valueOf(map.get("result"));
                            AlibcLogger.i(AlibcTRiverLaunch.f23690a, "convert转换接口返回url: " + strValueOf);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                            jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) strValueOf);
                            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, "", "", jSONObject);
                            if (TextUtils.isEmpty(strValueOf)) {
                                return;
                            }
                            ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(context, strValueOf, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibctriver.proxy.AlibcTRiverLaunch.2.1
                                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                                public void getLinkUrl(boolean z2, String str3, String str4, int i3) {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    AlibcTRiverLaunch alibcTRiverLaunch = AlibcTRiverLaunch.this;
                                    Context context2 = context;
                                    int i4 = i;
                                    Page page2 = page;
                                    alibcTRiverLaunch.a(z2, i3, str3, context2, i4, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                                }

                                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                                public void supportFail(String str3, String str4) {
                                    AlibcTRiverLaunch.this.a(str3, str4);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.alibaba.triver.open.proxy.IRouterProxy
    public void downgrade(Context context, Page page, String str, int i) {
        AlibcLogger.e(f23690a, "down grade url: " + str);
        boolean zVerifyMiniappUrl = AlibcProtocolUtils.verifyMiniappUrl(str);
        String bizType = AlibcProtocolUtils.getBizType(str);
        HashMap map = new HashMap();
        map.put("url", str);
        if ("4g".equals(NetWorkUtils.getNetWorkType(context))) {
            AlibcLogger.errorLog("baichuan", "OPEN@UC_CORE_DOWNLOAD_FAIL", "BC_API_CALL", "4G环境且下载失败", map);
        } else if (i == 0) {
            AlibcLogger.errorLog("baichuan", "OPEN@UC_CORE_DOWNLOAD_FAIL", "BC_API_CALL", "UC内核下载失败", map);
        }
        a(str, zVerifyMiniappUrl, bizType, context, page, i);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IRouterProxy
    public void openURL(Context context, Page page, String str, Bundle bundle, Bundle bundle2) {
        if (TextUtils.isEmpty(str)) {
            AlibcLogger.e(f23690a, "navigateToOutside url is null");
        } else {
            if (AlibcInterceptCenter.shouldInterceptToLaunch(str, bundle, "outside")) {
                TRiverConstant.BC_LINK_CODE = BCErrorEnum.PAGE_INTERCEPTOR_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                return;
            }
            Iterator<AlibcNavigateCenter.IUrlNavigate> it = AlibcNavigateCenter.getNavigateUrlList().iterator();
            while (it.hasNext()) {
                it.next().openUrl(context, str);
            }
        }
    }

    @Override // com.alibaba.triver.open.proxy.IRouterProxy
    public void popToHome(Context context, Page page, Bundle bundle) {
        AlibcLogger.i(f23690a, "pop to home");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, String str, Context context, int i2, Bundle bundle) {
        UserTrackUtils.sendApplinkUserTrack(null, z, i, "", i2);
        if (z) {
            AlibcLogger.i(f23690a, "launch app success");
            return;
        }
        AlibcLogger.e(f23690a, "launch app fail: code = " + i);
        if ("tmall".equals(str)) {
            AlibcTradeContext.getInstance().context = context;
            AlibcContainerManager.loadUrl("h5", AlibcProtocolConstant.TMALL_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        } else {
            AlibcTradeContext.getInstance().context = context;
            AlibcContainerManager.loadUrl("h5", AlibcProtocolConstant.TAOBAO_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        AlibcLogger.i(f23690a, "code = " + str + ", msg = " + str2);
    }
}
