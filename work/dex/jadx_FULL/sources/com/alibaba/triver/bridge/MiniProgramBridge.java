package com.alibaba.triver.bridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.R;
import com.alibaba.triver.Triver;
import com.alibaba.triver.app.e;
import com.alibaba.triver.app.g;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.point.PushPagePoint;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.kit.api.proxy.ILogProxy;
import com.alibaba.triver.kit.api.proxy.IRouterProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.utils.b;
import com.ipd.dsp.internal.l.a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MiniProgramBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TargetAppStatusReceiver f24747a;

    public static class RestartAppExtension implements RestartAppPoint {
        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onFinalized() {
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onInitialized() {
        }

        @Override // com.alibaba.triver.bridge.MiniProgramBridge.RestartAppPoint
        public boolean restartApp(long j, Bundle bundle) {
            RVEnvironmentService rVEnvironmentService;
            RVAppRecord appRecord = RVMain.getAppRecord(j);
            if (appRecord == null || appRecord.getActivityClz() == null || appRecord.getRunningTaskInfo() == null || (rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)) == null) {
                return false;
            }
            WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
            return Triver.restartApp((topActivity == null || topActivity.get() == null) ? rVEnvironmentService.getApplicationContext() : topActivity.get(), appRecord, bundle, true);
        }
    }

    @Remote
    public interface RestartAppPoint extends Extension {
        boolean restartApp(long j, Bundle bundle);
    }

    public class TargetAppStatusReceiver extends BroadcastReceiver {
        private String b;
        private WeakReference<Page> c;

        public TargetAppStatusReceiver(String str, Page page) {
            this.b = str;
            this.c = new WeakReference<>(page);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Page page;
            if (intent != null) {
                if (!TextUtils.equals(this.b, intent.getStringExtra("appId")) || (page = this.c.get()) == null) {
                    return;
                }
                String stringExtra = intent.getStringExtra("targetAppStatus");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("targetAppStatus", (Object) stringExtra);
                EngineUtils.sendToRender(page.getRender(), "targetAppComplete", jSONObject, null);
                context.unregisterReceiver(MiniProgramBridge.this.f24747a);
                MiniProgramBridge.this.f24747a = null;
            }
        }
    }

    private boolean a(Bundle bundle) {
        if (bundle != null) {
            try {
                return bundle.containsKey(a.l) && !bundle.getBoolean(a.l, true);
            } catch (Exception e) {
                RVLogger.e(AlibcProtocolConstant.NAVIGATE_TO_OUTSIDE_TYPE, e.getMessage());
            }
        }
        return false;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse exitApp(@BindingNode(App.class) App app) {
        if (app == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        app.exit();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse exitTinyApp(@BindingNode(App.class) App app) {
        if (app == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        app.exit();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getRunScene(@BindingNode(App.class) App app) {
        String str;
        if (app == null || app.getAppContext() == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        AppInfoScene appInfoSceneExtractScene = AppInfoScene.extractScene(app.getStartParams());
        if (appInfoSceneExtractScene.ordinal() == AppInfoScene.DEBUG.ordinal()) {
            str = "develop";
        } else if (appInfoSceneExtractScene.ordinal() == AppInfoScene.ONLINE.ordinal()) {
            str = "release";
        } else {
            str = appInfoSceneExtractScene.ordinal() == AppInfoScene.TRIAL.ordinal() ? "trial" : null;
        }
        if (str == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("envVersion", (Object) str);
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse navigateBackMiniProgram(@BindingRequest JSONObject jSONObject, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        if (app == null || apiContext == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        boolean zRestartApp = ((RestartAppPoint) ExtensionPoint.as(RestartAppPoint.class).node(app).create()).restartApp(app.getStartParams().getLong("referToken"), (jSONObject == null || jSONObject.isEmpty() || jSONObject.get("param") == null) ? new Bundle() : JSONUtils.toBundle(jSONObject.getJSONObject("param")));
        app.exit();
        return zRestartApp ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse navigateToHomePage(@BindingNode(App.class) App app) {
        if (app == null || app.getAppContext() == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        new e(app).popToHome();
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse navigateToMiniProgram(@BindingRequest JSONObject jSONObject, @BindingParam({"appId"}) String str, @BindingParam({"path"}) String str2, @BindingParam({"query"}) String str3, @BindingParam({"transition"}) String str4, @BindingParam({RVStartParams.KEY_SUPER_SPLASH}) String str5, @BindingParam({"extQuery"}) String str6, @BindingNode(Page.class) Page page, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        boolean zNavigateToMiniProgram;
        if (apiContext == null || app == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        Uri uriA = b.a(apiContext.getActivity(), apiContext.getAppId(), app.getStartParams(), app.getSceneParams(), jSONObject, str, str3);
        Bundle bundleA = b.a(jSONObject, apiContext.getAppId(), app.getStartToken(), str2, str4, str5, (Bundle) null);
        if (uriA != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("page", (Object) str2);
            zNavigateToMiniProgram = ((PushPagePoint) ExtensionPoint.as(PushPagePoint.class).create()).navigateToMiniProgram(page, CommonUtils.appUrlQuery(uriA, jSONObject2).toString());
            if (!zNavigateToMiniProgram) {
                if (app.getStartParams() != null) {
                    bundleA.putBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, app.getStartParams().getBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE));
                    bundleA.putBundle(TRiverConstants.KEY_OVER_PARAMS, app.getStartParams().getBundle(TRiverConstants.KEY_OVER_PARAMS));
                }
                bundleA.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, SystemClock.elapsedRealtime());
                zNavigateToMiniProgram = Triver.openApp(apiContext.getAppContext(), uriA, bundleA);
            }
        } else {
            zNavigateToMiniProgram = false;
        }
        return zNavigateToMiniProgram ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse navigateToOutside(@BindingParam({"url"}) String str, @BindingParam({"params"}) JSONObject jSONObject, @BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext) {
        Bundle bundle;
        Bundle startParams;
        if (TextUtils.isEmpty(str) || apiContext == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        Uri uri = Uri.parse(str);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (page != null && (startParams = page.getStartParams()) != null) {
            builderBuildUpon.appendQueryParameter(TRiverConstants.KEY_SPM_ORIGIN_URL, startParams.getString(TRiverConstants.KEY_SPM_ORIGIN_URL, ""));
        }
        String string = uri.toString();
        IRouterProxy iRouterProxy = (IRouterProxy) RVProxy.get(IRouterProxy.class);
        if (iRouterProxy != null) {
            Bundle bundle2 = jSONObject != null ? JSONUtils.toBundle(jSONObject) : null;
            if (a(string, apiContext, page, iRouterProxy, jSONObject)) {
                return BridgeResponse.SUCCESS;
            }
            if (TROrangeController.enableCloseNavAnim() && a(bundle2)) {
                Activity activity = apiContext.getActivity();
                int i = R.anim.triver_anim_temp;
                bundle = ActivityOptionsCompat.makeCustomAnimation(activity, i, i).toBundle();
            } else {
                bundle = null;
            }
            iRouterProxy.openURL(apiContext.getActivity(), new g(page, new e(page.getApp())), string, bundle2, bundle);
        }
        return BridgeResponse.SUCCESS;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse openBrandZone(@BindingRequest JSONObject jSONObject, @BindingParam({"appId"}) String str, @BindingParam({"path"}) String str2, @BindingParam({"query"}) String str3, @BindingParam({"loadingParams"}) JSONObject jSONObject2, @BindingParam({RVStartParams.KEY_SUPER_SPLASH}) String str4, @BindingParam({"hideAppLoading"}) boolean z, @BindingParam({"needTargetAppStatus"}) boolean z2, @BindingParam({"transition"}) String str5, @BindingParam({"extQuery"}) String str6, @BindingNode(Page.class) Page page, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        if (apiContext == null || app == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("hideAppLoading", false);
        bundle.putBoolean("needTargetAppStatus", false);
        return b.a(apiContext.getActivity(), apiContext.getAppId(), app.getStartToken(), app.getStartParams(), app.getSceneParams(), jSONObject, str, str2, str3, TextUtils.isEmpty(str5) ? "drop" : str5, jSONObject2, str4, str6, bundle) ? BridgeResponse.SUCCESS : BridgeResponse.FORBIDDEN_ERROR;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.IDLE)
    @ActionFilter
    @AutoCallback
    public BridgeResponse preloadBrandZone(@BindingParam({"loadingParams"}) JSONObject jSONObject, @BindingApiContext ApiContext apiContext) {
        if (apiContext == null || apiContext.getActivity() == null) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (com.alibaba.triver.utils.CommonUtils.closePreloadBrandZone()) {
            return BridgeResponse.FORBIDDEN_ERROR;
        }
        if (jSONObject == null || jSONObject.isEmpty()) {
            return BridgeResponse.INVALID_PARAM;
        }
        String string = jSONObject.getString("loadingImage");
        String string2 = jSONObject.getString("loadingLogo");
        Bundle bundle = new Bundle();
        bundle.putString("loadingImage", string);
        bundle.putString("loadingLogo", string2);
        com.alibaba.triver.container.a.a().a(apiContext.getActivity(), bundle);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    @AutoCallback
    public BridgeResponse uploadLog(@BindingParam({"title"}) String str, @BindingParam({"content"}) String str2, @BindingParam({"feedbackId"}) String str3, @BindingApiContext ApiContext apiContext) {
        if (RVProxy.get(ILogProxy.class) == null) {
            return BridgeResponse.NOT_FOUND;
        }
        ((ILogProxy) RVProxy.get(ILogProxy.class)).uploadFeedBackLog(apiContext.getAppContext(), str, str2, str3);
        return BridgeResponse.SUCCESS;
    }

    private boolean a(final String str, final ApiContext apiContext, final Page page, final IRouterProxy iRouterProxy, JSONObject jSONObject) {
        if (!TROrangeController.enableMiniDetailTransition()) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("scaleParams");
            int iIntValue = jSONObject2.getInteger("x").intValue();
            int iIntValue2 = jSONObject2.getInteger("y").intValue();
            int iIntValue3 = jSONObject2.getInteger("width").intValue();
            int iIntValue4 = jSONObject2.getInteger("height").intValue();
            if (iIntValue3 != 0 && iIntValue4 != 0) {
                String queryParameter = uri.getQueryParameter("image");
                String queryParameter2 = uri.getQueryParameter("transition");
                if (!TextUtils.isEmpty(queryParameter) && TextUtils.equals("scale", queryParameter2)) {
                    final View viewInflate = LayoutInflater.from(apiContext.getActivity()).inflate(R.layout.triver_minidetail_layout, page.getPageContext().getPageContainer().getView(), true);
                    final LinearLayout linearLayout = (LinearLayout) apiContext.getActivity().findViewById(R.id.share_element_img_bg);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.alibaba.triver.utils.CommonUtils.dp2px(iIntValue3), com.alibaba.triver.utils.CommonUtils.dp2px(iIntValue4)));
                    linearLayout.setX(iIntValue);
                    linearLayout.setY(iIntValue2);
                    ViewCompat.setTransitionName(linearLayout, "similar_activity_transition");
                    final Bundle bundle = new Bundle();
                    bundle.putString("transition", queryParameter2);
                    bundle.putString("imageUrl", queryParameter);
                    try {
                        apiContext.getActivity().getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() { // from class: com.alibaba.triver.bridge.MiniProgramBridge.1
                            @Override // android.transition.Transition.TransitionListener
                            public void onTransitionCancel(Transition transition) {
                                viewInflate.setVisibility(8);
                                transition.removeListener(this);
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public void onTransitionEnd(Transition transition) {
                                viewInflate.setVisibility(8);
                                transition.removeListener(this);
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public void onTransitionPause(Transition transition) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public void onTransitionResume(Transition transition) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public void onTransitionStart(Transition transition) {
                            }
                        });
                        final ImageView imageView = (ImageView) apiContext.getActivity().findViewById(R.id.share_element_img);
                        ((IImageProxy) RVProxy.get(IImageProxy.class)).loadImage(queryParameter, null, new IImageProxy.ImageListener() { // from class: com.alibaba.triver.bridge.MiniProgramBridge.2
                            @Override // com.alibaba.triver.kit.api.proxy.IImageProxy.ImageListener
                            public void onImageFinish(Drawable drawable) {
                                imageView.setImageDrawable(drawable);
                                ActivityOptionsCompat activityOptionsCompatMakeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(apiContext.getActivity(), linearLayout, "similar_activity_transition");
                                IRouterProxy iRouterProxy2 = iRouterProxy;
                                Activity activity = apiContext.getActivity();
                                Page page2 = page;
                                iRouterProxy2.openURL(activity, new g(page2, new e(page2.getApp())), str, bundle, activityOptionsCompatMakeSceneTransitionAnimation.toBundle());
                            }
                        });
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused2) {
        }
    }
}
