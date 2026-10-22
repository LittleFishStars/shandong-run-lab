package com.alibaba.triver.bridge;

import android.graphics.Color;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.view.EmbedPageContext;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.R;
import com.alibaba.triver.container.b;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverPullRefreshBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24762a = "TriverPullRefreshBridge";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void restorePullToRefresh(@BindingApiContext ApiContext apiContext, @BindingParam({RVParams.LONG_CAN_PULL_DOWN}) Boolean bool, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_pulldown_no_support)));
            }
        } else if (!(page.getPageContext().getPageContainer() instanceof b)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_pulldown_no_support)));
            }
        } else {
            ((b) page.getPageContext().getPageContainer()).b();
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8 A[Catch: Exception -> 0x00b3, TryCatch #2 {Exception -> 0x00b3, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0015, B:10:0x0022, B:12:0x0038, B:14:0x0041, B:15:0x004e, B:18:0x0060, B:20:0x0068, B:22:0x0076, B:24:0x0082, B:26:0x0097, B:29:0x009e, B:33:0x00a8, B:31:0x00a3, B:38:0x00b7), top: B:44:0x0005, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setBackgroundColor(@BindingApiContext ApiContext apiContext, @BindingParam({"backgroundColor"}) String str, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page != null) {
            try {
                if (page.getPageContext() != null && page.getPageContext().getPageContainer() != null) {
                    if (page.getPageContext().getPageContainer() instanceof b) {
                        Object objFindViewById = page.getPageContext().getPageContainer().getView().findViewById(R.id.triver_webview_id);
                        if ((objFindViewById instanceof WMLTRWebView) && ((WMLTRWebView) objFindViewById).getCoreView() != null) {
                            ((WMLTRWebView) objFindViewById).getCoreView().setBackgroundColor(Color.parseColor(str));
                        }
                        boolean zA = ((b) page.getPageContext().getPageContainer()).a(str);
                        if (bridgeCallback != null && zA) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                            return;
                        } else {
                            if (bridgeCallback != null) {
                                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(6, InternationalUtil.getString(apiContext, R.string.triver_bridge_java_error)));
                                return;
                            }
                            return;
                        }
                    }
                    if (page.getPageContext().getPageContainer() instanceof EmbedPageContext) {
                        try {
                            page.getPageContext().getPageContainer().getView().setBackgroundColor(Color.parseColor(str));
                            if (bridgeCallback != null) {
                                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                                return;
                            }
                            return;
                        } catch (IllegalArgumentException e) {
                            RVLogger.e(f24762a, e);
                            if (bridgeCallback != null) {
                                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(6, "设置异常，请检查入参"));
                                return;
                            }
                            return;
                        } catch (NullPointerException e2) {
                            RVLogger.e(f24762a, e2);
                            if (bridgeCallback != null) {
                                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(6, "设置异常，请检查入参"));
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Exception e3) {
                RVLogger.e(f24762a, e3);
                if (bridgeCallback != null) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(1, InternationalUtil.getString(apiContext, R.string.triver_bridge_error_prefix) + e3));
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(1, InternationalUtil.getString(apiContext, R.string.triver_bridge_bgcolor_setting_error)));
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setBackgroundTextStyle(@BindingApiContext ApiContext apiContext, @BindingParam({"textStyle"}) String str, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null || !(page.getPageContext().getPageContainer() instanceof b)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(1, InternationalUtil.getString(apiContext, R.string.triver_bridge_loading_page_bgcolor_setting_error)));
                return;
            }
            return;
        }
        HashMap mapB = ((b) page.getPageContext().getPageContainer()).b(str);
        boolean zBooleanValue = ((Boolean) mapB.get("success")).booleanValue();
        if (bridgeCallback != null && zBooleanValue) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else if (bridgeCallback != null) {
            String string = InternationalUtil.getString(apiContext, R.string.triver_bridge_loading_page_bgcolor_setting_error);
            if (mapB.containsKey("errorMsg")) {
                string = String.valueOf(mapB.get("errorMsg"));
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(3, string));
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setCanPullDown(@BindingApiContext ApiContext apiContext, @BindingParam({RVParams.LONG_CAN_PULL_DOWN}) boolean z, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null || !(page.getPageContext().getPageContainer() instanceof b)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_setting_error)));
            }
        } else {
            ((b) page.getPageContext().getPageContainer()).a(z, page);
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void startPullDownRefresh(@BindingApiContext ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        boolean zBooleanValue = (page == null || page.getStartParams() == null) ? false : ((Boolean) page.getStartParams().get(RVParams.LONG_PULL_REFRESH)).booleanValue();
        boolean zBooleanValue2 = page.getStartParams() != null ? ((Boolean) page.getStartParams().get(RVParams.LONG_CAN_PULL_DOWN)).booleanValue() : true;
        if (!zBooleanValue && bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_pull_refresh_error)));
            return;
        }
        if (!zBooleanValue2 && bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_canpulldown_error)));
            return;
        }
        if (page.getPageContext() == null || page.getPageContext().getPageContainer() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_pulldown_error)));
            }
        } else if (!(page.getPageContext().getPageContainer() instanceof b)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, InternationalUtil.getString(apiContext, R.string.triver_bridge_pulldown_error)));
            }
        } else {
            ((b) page.getPageContext().getPageContainer()).a();
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }
}
