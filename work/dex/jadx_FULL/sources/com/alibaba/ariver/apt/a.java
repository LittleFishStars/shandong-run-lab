package com.alibaba.ariver.apt;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.Visit;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppInteractionPoint;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.biz.DisclaimerPoint;
import com.alibaba.ariver.app.api.point.biz.PostNotificationPoint;
import com.alibaba.ariver.app.api.point.biz.SceneParamChangePoint;
import com.alibaba.ariver.app.api.point.biz.SnapshotPoint;
import com.alibaba.ariver.app.api.point.biz.StartParamChangePoint;
import com.alibaba.ariver.app.api.point.biz.VisitUrlPoint;
import com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint;
import com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint;
import com.alibaba.ariver.app.api.point.dialog.CreateActionSheetParam;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.CreatePromptParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.app.api.point.dialog.PromptPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.error.BlankScreenPoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowLoadingPoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.app.api.point.view.KeyBoardVisiblePoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint;
import com.alibaba.ariver.app.api.point.view.TitleBarShowFavoritesPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$10, reason: invalid class name */
    public static class AnonymousClass10 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23843a;

        public AnonymousClass10(Method method) {
            this.f23843a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new SceneParamChangePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$107$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.biz.SceneParamChangePoint
                public boolean onSceneParamChange(String str, Object obj) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23843a, new Object[]{str, obj})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$100, reason: invalid class name */
    public static class AnonymousClass100 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23844a;

        public AnonymousClass100(Method method) {
            this.f23844a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageExitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$91$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
                public void onPageExit(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23844a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$101, reason: invalid class name */
    public static class AnonymousClass101 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23845a;

        public AnonymousClass101(Method method) {
            this.f23845a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageShowPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$92$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageShowPoint
                public void onPageShow(Page page, JSONObject jSONObject) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23845a, new Object[]{page, jSONObject});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$102, reason: invalid class name */
    public static class AnonymousClass102 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23846a;

        public AnonymousClass102(Method method) {
            this.f23846a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageStartedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$93$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
                public void onStarted(String str) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23846a, new Object[]{str});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$103, reason: invalid class name */
    public static class AnonymousClass103 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23847a;

        public AnonymousClass103(Method method) {
            this.f23847a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageExitInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$94$1
                @Override // com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint
                public boolean interceptPageExit(Page page) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23847a, new Object[]{page})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$104, reason: invalid class name */
    public static class AnonymousClass104 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23848a;

        public AnonymousClass104(Method method) {
            this.f23848a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageInitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$95$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageInitPoint
                public void onPageInit(String str, Bundle bundle, Bundle bundle2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23848a, new Object[]{str, bundle, bundle2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$105, reason: invalid class name */
    public static class AnonymousClass105 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23849a;
        final /* synthetic */ Method b;

        public AnonymousClass105(Method method, Method method2) {
            this.f23849a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageShowLoadingPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$96$1
                @Override // com.alibaba.ariver.app.api.point.page.PageShowLoadingPoint
                public void hideLoading() {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageShowLoadingPoint
                public void showLoading() {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23849a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$106, reason: invalid class name */
    public static class AnonymousClass106 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23850a;

        public AnonymousClass106(Method method) {
            this.f23850a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PagePausePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$97$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
                public void onPagePause(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23850a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$107, reason: invalid class name */
    public static class AnonymousClass107 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23851a;

        public AnonymousClass107(Method method) {
            this.f23851a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageEnterPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$98$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
                public void onPageEnter(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23851a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$108, reason: invalid class name */
    public static class AnonymousClass108 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23852a;

        public AnonymousClass108(Method method) {
            this.f23852a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageResumePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$99$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
                public void onPageResume(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23852a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$11, reason: invalid class name */
    public static class AnonymousClass11 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23853a;

        public AnonymousClass11(Method method) {
            this.f23853a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new DisclaimerPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$108$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.biz.DisclaimerPoint
                public void showDisclaimer(int i) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23853a, new Object[]{Integer.valueOf(i)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$3, reason: invalid class name */
    public static class AnonymousClass3 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23854a;

        public AnonymousClass3(Method method) {
            this.f23854a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageDestroyPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$100$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageDestroyPoint
                public void onPageDestroy(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23854a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$4, reason: invalid class name */
    public static class AnonymousClass4 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23855a;

        public AnonymousClass4(Method method) {
            this.f23855a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageBackPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$101$1
                @Override // com.alibaba.ariver.app.api.point.page.PageBackPoint
                public void onBackPerformed(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23855a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$5, reason: invalid class name */
    public static class AnonymousClass5 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23856a;

        public AnonymousClass5(Method method) {
            this.f23856a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new BlankScreenPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$102$1
                @Override // com.alibaba.ariver.app.api.point.error.BlankScreenPoint
                public void onBlankScreen(Page page, JSONObject jSONObject) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23856a, new Object[]{page, jSONObject});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$6, reason: invalid class name */
    public static class AnonymousClass6 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23857a;

        public AnonymousClass6(Method method) {
            this.f23857a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PostNotificationPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$103$1
                @Override // com.alibaba.ariver.app.api.point.biz.PostNotificationPoint
                public void handlePostNotification(String str, JSONObject jSONObject, Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23857a, new Object[]{str, jSONObject, page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$60, reason: invalid class name */
    public static class AnonymousClass60 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23858a;

        public AnonymousClass60(Method method) {
            this.f23858a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppInteractionPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$55$1
                @Override // com.alibaba.ariver.app.api.point.app.AppInteractionPoint
                public void onAppInteraction(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23858a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$61, reason: invalid class name */
    public static class AnonymousClass61 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23859a;

        public AnonymousClass61(Method method) {
            this.f23859a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppCreatePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$56$1
                @Override // com.alibaba.ariver.app.api.point.app.AppCreatePoint
                public void onAppCreate(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23859a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$62, reason: invalid class name */
    public static class AnonymousClass62 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23860a;

        public AnonymousClass62(Method method) {
            this.f23860a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppOnConfigurationChangedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$57$1
                @Override // com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint
                public void onConfigurationChanged(App app, Configuration configuration, String str) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23860a, new Object[]{app, configuration, str});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$63, reason: invalid class name */
    public static class AnonymousClass63 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23861a;

        public AnonymousClass63(Method method) {
            this.f23861a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppRestartPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$58$1
                @Override // com.alibaba.ariver.app.api.point.app.AppRestartPoint
                public AppRestartResult onAppRestart(App app, Bundle bundle, Bundle bundle2) {
                    try {
                        return (AppRestartResult) invocationHandler.invoke(this, this.this$0.f23861a, new Object[]{app, bundle, bundle2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$64, reason: invalid class name */
    public static class AnonymousClass64 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23862a;

        public AnonymousClass64(Method method) {
            this.f23862a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppLoadPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$59$1
                @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint
                public void loadApp(String str, Bundle bundle, Bundle bundle2, AppLoadPoint.LoadResultCallback loadResultCallback) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23862a, new Object[]{str, bundle, bundle2, loadResultCallback});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$66, reason: invalid class name */
    public static class AnonymousClass66 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23863a;

        public AnonymousClass66(Method method) {
            this.f23863a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new BackKeyDownPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$60$1
                @Override // com.alibaba.ariver.app.api.point.app.BackKeyDownPoint
                public Boolean intercept(App app) {
                    try {
                        return (Boolean) invocationHandler.invoke(this, this.this$0.f23863a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$67, reason: invalid class name */
    public static class AnonymousClass67 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23864a;

        public AnonymousClass67(Method method) {
            this.f23864a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppPausePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$61$1
                @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
                public void onAppPause(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23864a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$68, reason: invalid class name */
    public static class AnonymousClass68 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23865a;

        public AnonymousClass68(Method method) {
            this.f23865a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppLoadInterceptorPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$62$1
                @Override // com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint
                public void intercept(String str, Bundle bundle, Bundle bundle2, AppLoadResult appLoadResult) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23865a, new Object[]{str, bundle, bundle2, appLoadResult});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$69, reason: invalid class name */
    public static class AnonymousClass69 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23866a;

        public AnonymousClass69(Method method) {
            this.f23866a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppExitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$63$1
                @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
                public void onAppExit(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23866a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$7, reason: invalid class name */
    public static class AnonymousClass7 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23867a;
        final /* synthetic */ Method b;
        final /* synthetic */ Method c;

        public AnonymousClass7(Method method, Method method2, Method method3) {
            this.f23867a = method;
            this.b = method2;
            this.c = method3;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new SnapshotPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$104$1
                @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
                public void addScreenshotListener(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23867a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
                public void registerReceiever(BroadcastReceiver broadcastReceiver) {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[]{broadcastReceiver});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
                public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
                    try {
                        invocationHandler.invoke(this, this.this$0.c, new Object[]{broadcastReceiver});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$70, reason: invalid class name */
    public static class AnonymousClass70 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23868a;

        public AnonymousClass70(Method method) {
            this.f23868a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PushWindowPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$64$1
                @Override // com.alibaba.ariver.app.api.point.app.PushWindowPoint
                public boolean handlePushWindow(Page page, String str, Bundle bundle, Bundle bundle2) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23868a, new Object[]{page, str, bundle, bundle2})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$71, reason: invalid class name */
    public static class AnonymousClass71 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23869a;

        public AnonymousClass71(Method method) {
            this.f23869a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppResumePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$65$1
                @Override // com.alibaba.ariver.app.api.point.app.AppResumePoint
                public void onAppResume(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23869a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$72, reason: invalid class name */
    public static class AnonymousClass72 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23870a;

        public AnonymousClass72(Method method) {
            this.f23870a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppOnLoadResultPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$66$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint
                public void onLoadResult(App app, AppLoadResult appLoadResult) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23870a, new Object[]{app, appLoadResult});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$73, reason: invalid class name */
    public static class AnonymousClass73 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23871a;

        public AnonymousClass73(Method method) {
            this.f23871a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppLeaveHintPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$67$1
                @Override // com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint
                public void onAppLeaveHint(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23871a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$74, reason: invalid class name */
    public static class AnonymousClass74 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23872a;

        public AnonymousClass74(Method method) {
            this.f23872a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppStartPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$68$1
                @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
                public void onAppStart(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23872a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$75, reason: invalid class name */
    public static class AnonymousClass75 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23873a;

        public AnonymousClass75(Method method) {
            this.f23873a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppDestroyPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$69$1
                @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
                public void onAppDestroy(App app) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23873a, new Object[]{app});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$77, reason: invalid class name */
    public static class AnonymousClass77 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23874a;

        public AnonymousClass77(Method method) {
            this.f23874a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarDisclaimerClickPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$70$1
                @Override // com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint
                public void onDisclaimerClick() {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23874a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$78, reason: invalid class name */
    public static class AnonymousClass78 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23875a;

        public AnonymousClass78(Method method) {
            this.f23875a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarShowFavoritesPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$71$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarShowFavoritesPoint
                public void showFavorites(boolean z) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23875a, new Object[]{Boolean.valueOf(z)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$79, reason: invalid class name */
    public static class AnonymousClass79 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23876a;

        public AnonymousClass79(Method method) {
            this.f23876a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TabBarInfoQueryPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$72$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint
                public void queryTabBarInfo(TabBarInfoQueryPoint.OnTabBarInfoQueryListener onTabBarInfoQueryListener) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23876a, new Object[]{onTabBarInfoQueryListener});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$8, reason: invalid class name */
    public static class AnonymousClass8 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23877a;

        public AnonymousClass8(Method method) {
            this.f23877a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new VisitUrlPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$105$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.biz.VisitUrlPoint
                public void onVisit(Visit visit) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23877a, new Object[]{visit});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$80, reason: invalid class name */
    public static class AnonymousClass80 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23878a;

        public AnonymousClass80(Method method) {
            this.f23878a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarCloseClickPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$73$1
                @Override // com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint
                public void onCloseClick() {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23878a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$81, reason: invalid class name */
    public static class AnonymousClass81 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23879a;

        public AnonymousClass81(Method method) {
            this.f23879a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarOptionClickPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$74$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint
                public void onOptionClick(int i, boolean z) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23879a, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$82, reason: invalid class name */
    public static class AnonymousClass82 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23880a;
        final /* synthetic */ Method b;

        public AnonymousClass82(Method method, Method method2) {
            this.f23880a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ToastPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$75$1
                @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
                public void hideToast() {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
                public void showToast(Context context, String str, int i, String str2, int i2, int i3) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23880a, new Object[]{context, str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$83, reason: invalid class name */
    public static class AnonymousClass83 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23881a;

        public AnonymousClass83(Method method) {
            this.f23881a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarShowClosePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$76$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint
                public void showClose(boolean z) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23881a, new Object[]{Boolean.valueOf(z)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$84, reason: invalid class name */
    public static class AnonymousClass84 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23882a;
        final /* synthetic */ Method b;

        public AnonymousClass84(Method method, Method method2) {
            this.f23882a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarTitleClickPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$77$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint
                public void onSubTitleClick() {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint
                public void onTitleClick() {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23882a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$85, reason: invalid class name */
    public static class AnonymousClass85 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23883a;

        public AnonymousClass85(Method method) {
            this.f23883a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new KeyBoardVisiblePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$78$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.KeyBoardVisiblePoint
                public void onKeyboardVisible(String str, String str2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23883a, new Object[]{str, str2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$86, reason: invalid class name */
    public static class AnonymousClass86 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23884a;

        public AnonymousClass86(Method method) {
            this.f23884a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarTransparentPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$79$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint
                public void onTrasparentTitle(String str) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23884a, new Object[]{str});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$88, reason: invalid class name */
    public static class AnonymousClass88 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23885a;

        public AnonymousClass88(Method method) {
            this.f23885a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new TitleBarSegCheckPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$80$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint
                public void onSegItemChecked(int i) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23885a, new Object[]{Integer.valueOf(i)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$89, reason: invalid class name */
    public static class AnonymousClass89 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23886a;

        public AnonymousClass89(Method method) {
            this.f23886a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new EngineInitFailedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$81$1
                @Override // com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint
                public EngineInitFailedPoint.Action onEngineInitFailed() {
                    try {
                        return (EngineInitFailedPoint.Action) invocationHandler.invoke(this, this.this$0.f23886a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$9, reason: invalid class name */
    public static class AnonymousClass9 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23887a;

        public AnonymousClass9(Method method) {
            this.f23887a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new StartParamChangePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$106$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.biz.StartParamChangePoint
                public boolean onStartParamChange(String str, Object obj) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23887a, new Object[]{str, obj})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$90, reason: invalid class name */
    public static class AnonymousClass90 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23888a;

        public AnonymousClass90(Method method) {
            this.f23888a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new EngineInitSuccessPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$82$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint
                public void onInitSuccess() {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23888a, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$91, reason: invalid class name */
    public static class AnonymousClass91 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23889a;

        public AnonymousClass91(Method method) {
            this.f23889a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PromptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$83$1
                @Override // com.alibaba.ariver.app.api.point.dialog.PromptPoint
                public Dialog createDialog(Activity activity, CreatePromptParam createPromptParam) {
                    try {
                        return (Dialog) invocationHandler.invoke(this, this.this$0.f23889a, new Object[]{activity, createPromptParam});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$92, reason: invalid class name */
    public static class AnonymousClass92 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23890a;

        public AnonymousClass92(Method method) {
            this.f23890a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new DialogPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$84$1
                @Override // com.alibaba.ariver.app.api.point.dialog.DialogPoint
                public Dialog createDialog(Activity activity, CreateDialogParam createDialogParam) {
                    try {
                        return (Dialog) invocationHandler.invoke(this, this.this$0.f23890a, new Object[]{activity, createDialogParam});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$93, reason: invalid class name */
    public static class AnonymousClass93 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23891a;
        final /* synthetic */ Method b;

        public AnonymousClass93(Method method, Method method2) {
            this.f23891a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AgreementConfirmPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$85$1
                @Override // com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint
                public boolean hasPermission(App app, String str) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23891a, new Object[]{app, str})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint
                public void onAgreementClick(App app, String str) {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[]{app, str});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$94, reason: invalid class name */
    public static class AnonymousClass94 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23892a;
        final /* synthetic */ Method b;
        final /* synthetic */ Method c;

        public AnonymousClass94(Method method, Method method2, Method method3) {
            this.f23892a = method;
            this.b = method2;
            this.c = method3;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ActionSheetPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$86$1
                @Override // com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint
                public Dialog getActionSheet(CreateActionSheetParam createActionSheetParam) {
                    try {
                        return (Dialog) invocationHandler.invoke(this, this.this$0.f23892a, new Object[]{createActionSheetParam});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint
                public void onRelease() {
                    try {
                        invocationHandler.invoke(this, this.this$0.c, new Object[0]);
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint
                public void updateActionSheetContent(ArrayList<String> arrayList) {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[]{arrayList});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$95, reason: invalid class name */
    public static class AnonymousClass95 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23893a;

        public AnonymousClass95(Method method) {
            this.f23893a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ActivityHelperOnCreateFinishedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$87$1
                @Override // com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint
                public void onActivityHelperOnCreateFinished(App app, FragmentActivity fragmentActivity, StartClientBundle startClientBundle) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23893a, new Object[]{app, fragmentActivity, startClientBundle});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$96, reason: invalid class name */
    public static class AnonymousClass96 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23894a;

        public AnonymousClass96(Method method) {
            this.f23894a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new BackPressedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$88$1
                @Override // com.alibaba.ariver.app.api.point.page.BackPressedPoint
                public Boolean handleBackPressed(Page page) {
                    try {
                        return (Boolean) invocationHandler.invoke(this, this.this$0.f23894a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$97, reason: invalid class name */
    public static class AnonymousClass97 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23895a;

        public AnonymousClass97(Method method) {
            this.f23895a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PagePushInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$89$1
                @Override // com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint
                public String interceptPushPage(App app, String str, Bundle bundle) {
                    try {
                        return (String) invocationHandler.invoke(this, this.this$0.f23895a, new Object[]{app, str, bundle});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.a$99, reason: invalid class name */
    public static class AnonymousClass99 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23896a;

        public AnonymousClass99(Method method) {
            this.f23896a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageHidePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_app_api_ExtOpt$90$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.app.api.point.page.PageHidePoint
                public void onPageHide(Page page) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23896a, new Object[]{page});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    public static void a() {
        ExtensionOpt.setupMethodInvokeOptimizer(AppInteractionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppInteraction".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppInteractionPoint) extension).onAppInteraction((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppCreatePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.21
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppCreate".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppCreatePoint) extension).onAppCreate((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppOnConfigurationChangedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.32
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onConfigurationChanged".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((AppOnConfigurationChangedPoint) extension).onConfigurationChanged((App) objArr[0], (Configuration) objArr[1], (String) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppRestartPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.43
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onAppRestart".equals(str) && objArr.length == 3) {
                    return ((AppRestartPoint) extension).onAppRestart((App) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.54
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"loadApp".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((AppLoadPoint) extension).loadApp((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2], (AppLoadPoint.LoadResultCallback) objArr[3]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BackKeyDownPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.65
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("intercept".equals(str) && objArr.length == 1) {
                    return ((BackKeyDownPoint) extension).intercept((App) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppPausePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.76
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppPause".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppPausePoint) extension).onAppPause((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLoadInterceptorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.87
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"intercept".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((AppLoadInterceptorPoint) extension).intercept((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2], (AppLoadResult) objArr[3]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppExitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.98
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppExit".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppExitPoint) extension).onAppExit((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PushWindowPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("handlePushWindow".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((PushWindowPoint) extension).handlePushWindow((Page) objArr[0], (String) objArr[1], (Bundle) objArr[2], (Bundle) objArr[3]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppResumePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppResume".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppResumePoint) extension).onAppResume((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppOnLoadResultPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.13
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onLoadResult".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((AppOnLoadResultPoint) extension).onLoadResult((App) objArr[0], (AppLoadResult) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppLeaveHintPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.14
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppLeaveHint".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppLeaveHintPoint) extension).onAppLeaveHint((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppStartPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.15
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppStart".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppStartPoint) extension).onAppStart((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppDestroyPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.16
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppDestroy".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppDestroyPoint) extension).onAppDestroy((App) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarDisclaimerClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.17
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onDisclaimerClick".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((TitleBarDisclaimerClickPoint) extension).onDisclaimerClick();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarShowFavoritesPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.18
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!RVParams.LONG_SHOW_FAVORITES.equals(str) || objArr.length != 1) {
                    return null;
                }
                ((TitleBarShowFavoritesPoint) extension).showFavorites(((Boolean) objArr[0]).booleanValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TabBarInfoQueryPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.19
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"queryTabBarInfo".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((TabBarInfoQueryPoint) extension).queryTabBarInfo((TabBarInfoQueryPoint.OnTabBarInfoQueryListener) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarCloseClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.20
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onCloseClick".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((TitleBarCloseClickPoint) extension).onCloseClick();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarOptionClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.22
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onOptionClick".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((TitleBarOptionClickPoint) extension).onOptionClick(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ToastPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.23
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("showToast".equals(str) && objArr.length == 6) {
                    ((ToastPoint) extension).showToast((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue());
                }
                if (!"hideToast".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((ToastPoint) extension).hideToast();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarShowClosePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.24
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"showClose".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((TitleBarShowClosePoint) extension).showClose(((Boolean) objArr[0]).booleanValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarTitleClickPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.25
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onTitleClick".equals(str) && objArr.length == 0) {
                    ((TitleBarTitleClickPoint) extension).onTitleClick();
                }
                if (!"onSubTitleClick".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((TitleBarTitleClickPoint) extension).onSubTitleClick();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(KeyBoardVisiblePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.26
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onKeyboardVisible".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((KeyBoardVisiblePoint) extension).onKeyboardVisible((String) objArr[0], (String) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarTransparentPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.27
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onTrasparentTitle".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((TitleBarTransparentPoint) extension).onTrasparentTitle((String) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(TitleBarSegCheckPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.28
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onSegItemChecked".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((TitleBarSegCheckPoint) extension).onSegItemChecked(((Integer) objArr[0]).intValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EngineInitFailedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.29
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onEngineInitFailed".equals(str) && objArr.length == 0) {
                    return ((EngineInitFailedPoint) extension).onEngineInitFailed();
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EngineInitSuccessPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.30
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onInitSuccess".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((EngineInitSuccessPoint) extension).onInitSuccess();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PromptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.31
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("createDialog".equals(str) && objArr.length == 2) {
                    return ((PromptPoint) extension).createDialog((Activity) objArr[0], (CreatePromptParam) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(DialogPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.33
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("createDialog".equals(str) && objArr.length == 2) {
                    return ((DialogPoint) extension).createDialog((Activity) objArr[0], (CreateDialogParam) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AgreementConfirmPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.34
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("hasPermission".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((AgreementConfirmPoint) extension).hasPermission((App) objArr[0], (String) objArr[1]));
                }
                if (!"onAgreementClick".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((AgreementConfirmPoint) extension).onAgreementClick((App) objArr[0], (String) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ActionSheetPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.35
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getActionSheet".equals(str) && objArr.length == 1) {
                    return ((ActionSheetPoint) extension).getActionSheet((CreateActionSheetParam) objArr[0]);
                }
                if ("updateActionSheetContent".equals(str) && objArr.length == 1) {
                    ((ActionSheetPoint) extension).updateActionSheetContent((ArrayList) objArr[0]);
                }
                if (!"onRelease".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((ActionSheetPoint) extension).onRelease();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ActivityHelperOnCreateFinishedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.36
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onActivityHelperOnCreateFinished".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((ActivityHelperOnCreateFinishedPoint) extension).onActivityHelperOnCreateFinished((App) objArr[0], (FragmentActivity) objArr[1], (StartClientBundle) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BackPressedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.37
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("handleBackPressed".equals(str) && objArr.length == 1) {
                    return ((BackPressedPoint) extension).handleBackPressed((Page) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PagePushInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.38
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("interceptPushPage".equals(str) && objArr.length == 3) {
                    return ((PagePushInterceptPoint) extension).interceptPushPage((App) objArr[0], (String) objArr[1], (Bundle) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageHidePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.39
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageHide".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageHidePoint) extension).onPageHide((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageExitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.40
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageExit".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageExitPoint) extension).onPageExit((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageShowPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.41
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageShow".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((PageShowPoint) extension).onPageShow((Page) objArr[0], (JSONObject) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageStartedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.42
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onStarted".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageStartedPoint) extension).onStarted((String) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageExitInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.44
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("interceptPageExit".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((PageExitInterceptPoint) extension).interceptPageExit((Page) objArr[0]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.45
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageInit".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((PageInitPoint) extension).onPageInit((String) objArr[0], (Bundle) objArr[1], (Bundle) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageShowLoadingPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.46
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (RVParams.LONG_SHOW_LOADING.equals(str) && objArr.length == 0) {
                    ((PageShowLoadingPoint) extension).showLoading();
                }
                if (!"hideLoading".equals(str) || objArr.length != 0) {
                    return null;
                }
                ((PageShowLoadingPoint) extension).hideLoading();
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PagePausePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.47
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPagePause".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PagePausePoint) extension).onPagePause((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageEnterPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.48
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageEnter".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageEnterPoint) extension).onPageEnter((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageResumePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.49
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageResume".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageResumePoint) extension).onPageResume((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageDestroyPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.50
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPageDestroy".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageDestroyPoint) extension).onPageDestroy((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageBackPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.51
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onBackPerformed".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((PageBackPoint) extension).onBackPerformed((Page) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BlankScreenPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.52
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onBlankScreen".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((BlankScreenPoint) extension).onBlankScreen((Page) objArr[0], (JSONObject) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PostNotificationPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.53
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"handlePostNotification".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((PostNotificationPoint) extension).handlePostNotification((String) objArr[0], (JSONObject) objArr[1], (Page) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(SnapshotPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.55
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("addScreenshotListener".equals(str) && objArr.length == 1) {
                    ((SnapshotPoint) extension).addScreenshotListener((Page) objArr[0]);
                }
                if ("registerReceiever".equals(str) && objArr.length == 1) {
                    ((SnapshotPoint) extension).registerReceiever((BroadcastReceiver) objArr[0]);
                }
                if (!"unregisterReceiver".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((SnapshotPoint) extension).unregisterReceiver((BroadcastReceiver) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(VisitUrlPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.56
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onVisit".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((VisitUrlPoint) extension).onVisit((Visit) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(StartParamChangePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.57
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onStartParamChange".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((StartParamChangePoint) extension).onStartParamChange((String) objArr[0], objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(SceneParamChangePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.58
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onSceneParamChange".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((SceneParamChangePoint) extension).onSceneParamChange((String) objArr[0], objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(DisclaimerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.a.59
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"showDisclaimer".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((DisclaimerPoint) extension).showDisclaimer(((Integer) objArr[0]).intValue());
                return null;
            }
        });
    }

    public static void b() {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static void c() {
        try {
            ExtensionPoint.registerProxyGenerator(AppInteractionPoint.class, new AnonymousClass60(AppInteractionPoint.class.getDeclaredMethod("onAppInteraction", App.class)));
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppInteractionPoint error, ignored", th);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppCreatePoint.class, new AnonymousClass61(AppCreatePoint.class.getDeclaredMethod("onAppCreate", App.class)));
        } catch (Throwable th2) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppCreatePoint error, ignored", th2);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppOnConfigurationChangedPoint.class, new AnonymousClass62(AppOnConfigurationChangedPoint.class.getDeclaredMethod("onConfigurationChanged", App.class, Configuration.class, String.class)));
        } catch (Throwable th3) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint error, ignored", th3);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppRestartPoint.class, new AnonymousClass63(AppRestartPoint.class.getDeclaredMethod("onAppRestart", App.class, Bundle.class, Bundle.class)));
        } catch (Throwable th4) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppRestartPoint error, ignored", th4);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppLoadPoint.class, new AnonymousClass64(AppLoadPoint.class.getDeclaredMethod("loadApp", String.class, Bundle.class, Bundle.class, AppLoadPoint.LoadResultCallback.class)));
        } catch (Throwable th5) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppLoadPoint error, ignored", th5);
        }
        try {
            ExtensionPoint.registerProxyGenerator(BackKeyDownPoint.class, new AnonymousClass66(BackKeyDownPoint.class.getDeclaredMethod("intercept", App.class)));
        } catch (Throwable th6) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.BackKeyDownPoint error, ignored", th6);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppPausePoint.class, new AnonymousClass67(AppPausePoint.class.getDeclaredMethod("onAppPause", App.class)));
        } catch (Throwable th7) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppPausePoint error, ignored", th7);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppLoadInterceptorPoint.class, new AnonymousClass68(AppLoadInterceptorPoint.class.getDeclaredMethod("intercept", String.class, Bundle.class, Bundle.class, AppLoadResult.class)));
        } catch (Throwable th8) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint error, ignored", th8);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppExitPoint.class, new AnonymousClass69(AppExitPoint.class.getDeclaredMethod("onAppExit", App.class)));
        } catch (Throwable th9) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppExitPoint error, ignored", th9);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PushWindowPoint.class, new AnonymousClass70(PushWindowPoint.class.getDeclaredMethod("handlePushWindow", Page.class, String.class, Bundle.class, Bundle.class)));
        } catch (Throwable th10) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.PushWindowPoint error, ignored", th10);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppResumePoint.class, new AnonymousClass71(AppResumePoint.class.getDeclaredMethod("onAppResume", App.class)));
        } catch (Throwable th11) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppResumePoint error, ignored", th11);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppOnLoadResultPoint.class, new AnonymousClass72(AppOnLoadResultPoint.class.getDeclaredMethod("onLoadResult", App.class, AppLoadResult.class)));
        } catch (Throwable th12) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint error, ignored", th12);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppLeaveHintPoint.class, new AnonymousClass73(AppLeaveHintPoint.class.getDeclaredMethod("onAppLeaveHint", App.class)));
        } catch (Throwable th13) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint error, ignored", th13);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppStartPoint.class, new AnonymousClass74(AppStartPoint.class.getDeclaredMethod("onAppStart", App.class)));
        } catch (Throwable th14) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppStartPoint error, ignored", th14);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppDestroyPoint.class, new AnonymousClass75(AppDestroyPoint.class.getDeclaredMethod("onAppDestroy", App.class)));
        } catch (Throwable th15) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.app.AppDestroyPoint error, ignored", th15);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarDisclaimerClickPoint.class, new AnonymousClass77(TitleBarDisclaimerClickPoint.class.getDeclaredMethod("onDisclaimerClick", new Class[0])));
        } catch (Throwable th16) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarDisclaimerClickPoint error, ignored", th16);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarShowFavoritesPoint.class, new AnonymousClass78(TitleBarShowFavoritesPoint.class.getDeclaredMethod(RVParams.LONG_SHOW_FAVORITES, Boolean.TYPE)));
        } catch (Throwable th17) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarShowFavoritesPoint error, ignored", th17);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TabBarInfoQueryPoint.class, new AnonymousClass79(TabBarInfoQueryPoint.class.getDeclaredMethod("queryTabBarInfo", TabBarInfoQueryPoint.OnTabBarInfoQueryListener.class)));
        } catch (Throwable th18) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint error, ignored", th18);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarCloseClickPoint.class, new AnonymousClass80(TitleBarCloseClickPoint.class.getDeclaredMethod("onCloseClick", new Class[0])));
        } catch (Throwable th19) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint error, ignored", th19);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarOptionClickPoint.class, new AnonymousClass81(TitleBarOptionClickPoint.class.getDeclaredMethod("onOptionClick", Integer.TYPE, Boolean.TYPE)));
        } catch (Throwable th20) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint error, ignored", th20);
        }
        try {
            Class cls = Integer.TYPE;
            ExtensionPoint.registerProxyGenerator(ToastPoint.class, new AnonymousClass82(ToastPoint.class.getDeclaredMethod("showToast", Context.class, String.class, cls, String.class, cls, cls), ToastPoint.class.getDeclaredMethod("hideToast", new Class[0])));
        } catch (Throwable th21) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.ToastPoint error, ignored", th21);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarShowClosePoint.class, new AnonymousClass83(TitleBarShowClosePoint.class.getDeclaredMethod("showClose", Boolean.TYPE)));
        } catch (Throwable th22) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarShowClosePoint error, ignored", th22);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarTitleClickPoint.class, new AnonymousClass84(TitleBarTitleClickPoint.class.getDeclaredMethod("onTitleClick", new Class[0]), TitleBarTitleClickPoint.class.getDeclaredMethod("onSubTitleClick", new Class[0])));
        } catch (Throwable th23) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarTitleClickPoint error, ignored", th23);
        }
        try {
            ExtensionPoint.registerProxyGenerator(KeyBoardVisiblePoint.class, new AnonymousClass85(KeyBoardVisiblePoint.class.getDeclaredMethod("onKeyboardVisible", String.class, String.class)));
        } catch (Throwable th24) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.KeyBoardVisiblePoint error, ignored", th24);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarTransparentPoint.class, new AnonymousClass86(TitleBarTransparentPoint.class.getDeclaredMethod("onTrasparentTitle", String.class)));
        } catch (Throwable th25) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarTransparentPoint error, ignored", th25);
        }
        try {
            ExtensionPoint.registerProxyGenerator(TitleBarSegCheckPoint.class, new AnonymousClass88(TitleBarSegCheckPoint.class.getDeclaredMethod("onSegItemChecked", Integer.TYPE)));
        } catch (Throwable th26) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.view.TitleBarSegCheckPoint error, ignored", th26);
        }
        try {
            ExtensionPoint.registerProxyGenerator(EngineInitFailedPoint.class, new AnonymousClass89(EngineInitFailedPoint.class.getDeclaredMethod("onEngineInitFailed", new Class[0])));
        } catch (Throwable th27) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint error, ignored", th27);
        }
        try {
            ExtensionPoint.registerProxyGenerator(EngineInitSuccessPoint.class, new AnonymousClass90(EngineInitSuccessPoint.class.getDeclaredMethod("onInitSuccess", new Class[0])));
        } catch (Throwable th28) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint error, ignored", th28);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PromptPoint.class, new AnonymousClass91(PromptPoint.class.getDeclaredMethod("createDialog", Activity.class, CreatePromptParam.class)));
        } catch (Throwable th29) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.dialog.PromptPoint error, ignored", th29);
        }
        try {
            ExtensionPoint.registerProxyGenerator(DialogPoint.class, new AnonymousClass92(DialogPoint.class.getDeclaredMethod("createDialog", Activity.class, CreateDialogParam.class)));
        } catch (Throwable th30) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.dialog.DialogPoint error, ignored", th30);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AgreementConfirmPoint.class, new AnonymousClass93(AgreementConfirmPoint.class.getDeclaredMethod("hasPermission", App.class, String.class), AgreementConfirmPoint.class.getDeclaredMethod("onAgreementClick", App.class, String.class)));
        } catch (Throwable th31) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.dialog.AgreementConfirmPoint error, ignored", th31);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ActionSheetPoint.class, new AnonymousClass94(ActionSheetPoint.class.getDeclaredMethod("getActionSheet", CreateActionSheetParam.class), ActionSheetPoint.class.getDeclaredMethod("updateActionSheetContent", ArrayList.class), ActionSheetPoint.class.getDeclaredMethod("onRelease", new Class[0])));
        } catch (Throwable th32) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.dialog.ActionSheetPoint error, ignored", th32);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ActivityHelperOnCreateFinishedPoint.class, new AnonymousClass95(ActivityHelperOnCreateFinishedPoint.class.getDeclaredMethod("onActivityHelperOnCreateFinished", App.class, FragmentActivity.class, StartClientBundle.class)));
        } catch (Throwable th33) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint error, ignored", th33);
        }
        try {
            ExtensionPoint.registerProxyGenerator(BackPressedPoint.class, new AnonymousClass96(BackPressedPoint.class.getDeclaredMethod("handleBackPressed", Page.class)));
        } catch (Throwable th34) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.BackPressedPoint error, ignored", th34);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PagePushInterceptPoint.class, new AnonymousClass97(PagePushInterceptPoint.class.getDeclaredMethod("interceptPushPage", App.class, String.class, Bundle.class)));
        } catch (Throwable th35) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint error, ignored", th35);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageHidePoint.class, new AnonymousClass99(PageHidePoint.class.getDeclaredMethod("onPageHide", Page.class)));
        } catch (Throwable th36) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageHidePoint error, ignored", th36);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageExitPoint.class, new AnonymousClass100(PageExitPoint.class.getDeclaredMethod("onPageExit", Page.class)));
        } catch (Throwable th37) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageExitPoint error, ignored", th37);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageShowPoint.class, new AnonymousClass101(PageShowPoint.class.getDeclaredMethod("onPageShow", Page.class, JSONObject.class)));
        } catch (Throwable th38) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageShowPoint error, ignored", th38);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageStartedPoint.class, new AnonymousClass102(PageStartedPoint.class.getDeclaredMethod("onStarted", String.class)));
        } catch (Throwable th39) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageStartedPoint error, ignored", th39);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageExitInterceptPoint.class, new AnonymousClass103(PageExitInterceptPoint.class.getDeclaredMethod("interceptPageExit", Page.class)));
        } catch (Throwable th40) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint error, ignored", th40);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageInitPoint.class, new AnonymousClass104(PageInitPoint.class.getDeclaredMethod("onPageInit", String.class, Bundle.class, Bundle.class)));
        } catch (Throwable th41) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageInitPoint error, ignored", th41);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageShowLoadingPoint.class, new AnonymousClass105(PageShowLoadingPoint.class.getDeclaredMethod(RVParams.LONG_SHOW_LOADING, new Class[0]), PageShowLoadingPoint.class.getDeclaredMethod("hideLoading", new Class[0])));
        } catch (Throwable th42) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageShowLoadingPoint error, ignored", th42);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PagePausePoint.class, new AnonymousClass106(PagePausePoint.class.getDeclaredMethod("onPagePause", Page.class)));
        } catch (Throwable th43) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PagePausePoint error, ignored", th43);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageEnterPoint.class, new AnonymousClass107(PageEnterPoint.class.getDeclaredMethod("onPageEnter", Page.class)));
        } catch (Throwable th44) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageEnterPoint error, ignored", th44);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageResumePoint.class, new AnonymousClass108(PageResumePoint.class.getDeclaredMethod("onPageResume", Page.class)));
        } catch (Throwable th45) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageResumePoint error, ignored", th45);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageDestroyPoint.class, new AnonymousClass3(PageDestroyPoint.class.getDeclaredMethod("onPageDestroy", Page.class)));
        } catch (Throwable th46) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageDestroyPoint error, ignored", th46);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageBackPoint.class, new AnonymousClass4(PageBackPoint.class.getDeclaredMethod("onBackPerformed", Page.class)));
        } catch (Throwable th47) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.page.PageBackPoint error, ignored", th47);
        }
        try {
            ExtensionPoint.registerProxyGenerator(BlankScreenPoint.class, new AnonymousClass5(BlankScreenPoint.class.getDeclaredMethod("onBlankScreen", Page.class, JSONObject.class)));
        } catch (Throwable th48) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.error.BlankScreenPoint error, ignored", th48);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PostNotificationPoint.class, new AnonymousClass6(PostNotificationPoint.class.getDeclaredMethod("handlePostNotification", String.class, JSONObject.class, Page.class)));
        } catch (Throwable th49) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.PostNotificationPoint error, ignored", th49);
        }
        try {
            ExtensionPoint.registerProxyGenerator(SnapshotPoint.class, new AnonymousClass7(SnapshotPoint.class.getDeclaredMethod("addScreenshotListener", Page.class), SnapshotPoint.class.getDeclaredMethod("registerReceiever", BroadcastReceiver.class), SnapshotPoint.class.getDeclaredMethod("unregisterReceiver", BroadcastReceiver.class)));
        } catch (Throwable th50) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.SnapshotPoint error, ignored", th50);
        }
        try {
            ExtensionPoint.registerProxyGenerator(VisitUrlPoint.class, new AnonymousClass8(VisitUrlPoint.class.getDeclaredMethod("onVisit", Visit.class)));
        } catch (Throwable th51) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.VisitUrlPoint error, ignored", th51);
        }
        try {
            ExtensionPoint.registerProxyGenerator(StartParamChangePoint.class, new AnonymousClass9(StartParamChangePoint.class.getDeclaredMethod("onStartParamChange", String.class, Object.class)));
        } catch (Throwable th52) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.StartParamChangePoint error, ignored", th52);
        }
        try {
            ExtensionPoint.registerProxyGenerator(SceneParamChangePoint.class, new AnonymousClass10(SceneParamChangePoint.class.getDeclaredMethod("onSceneParamChange", String.class, Object.class)));
        } catch (Throwable th53) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.SceneParamChangePoint error, ignored", th53);
        }
        try {
            ExtensionPoint.registerProxyGenerator(DisclaimerPoint.class, new AnonymousClass11(DisclaimerPoint.class.getDeclaredMethod("showDisclaimer", Integer.TYPE)));
        } catch (Throwable th54) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.app.api.point.biz.DisclaimerPoint error, ignored", th54);
        }
    }
}
