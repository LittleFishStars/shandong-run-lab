package com.kc.dw.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.v;
import com.kc.dw.core.utils.w0;
import com.kc.dw.core.utils.z0;
import com.kc.dw.core.webview.jsbridge.bean.CheckAppInstallParam;
import com.kc.dw.core.webview.jsbridge.bean.GetH5AdInfoResBean;
import com.kc.dw.core.webview.jsbridge.bean.H5NotifyErrorParam;
import com.kc.dw.core.webview.jsbridge.bean.InvokeDeepLinkParam;
import com.kc.dw.core.webview.jsbridge.bean.OpenWebViewPageParam;
import com.kc.dw.core.webview.jsbridge.bean.UUIDParam;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAdSlot f39434a;
    public final com.kc.dw.platform.ad_adapter.c b;
    public final e c;
    public SoftReference<WebView> d;
    public i e;

    /* JADX INFO: renamed from: com.kc.dw.core.webview.a$a, reason: collision with other inner class name */
    @Keep
    public class C1051a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InvokeDeepLinkParam f39435a;
        public final int b;
        public final String c;
        public final a d;

        public C1051a(a aVar, InvokeDeepLinkParam invokeDeepLinkParam, int i, String str) {
            this.d = aVar;
            this.f39435a = invokeDeepLinkParam;
            this.b = i;
            this.c = str;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            WebView webView;
            a aVar = this.d;
            aVar.getClass();
            try {
                SoftReference<WebView> softReference = aVar.d;
                webView = softReference != null ? softReference.get() : null;
            } catch (Exception unused) {
            }
            try {
                webView.evaluateJavascript("javascript:ADMateJSBridge." + this.f39435a.getCallbackFunc() + "(" + ("{\"code\":" + this.b + ",\"msg\":\"" + this.c + "\"}") + ")", null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a(com.kc.dw.platform.ad_adapter.c cVar, WebView webView, e eVar) {
        this.b = cVar;
        this.c = eVar;
        AdSlot adSlotA = cVar != null ? cVar.a() : null;
        if (adSlotA instanceof BaseAdSlot) {
            BaseAdSlot baseAdSlot = (BaseAdSlot) adSlotA;
            this.f39434a = baseAdSlot;
            baseAdSlot.getReq_id();
        }
        if (webView != null) {
            this.d = new SoftReference<>(webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InvokeDeepLinkParam invokeDeepLinkParam, int i, String str) {
        if (TextUtils.isEmpty(invokeDeepLinkParam.getCallbackFunc())) {
            return;
        }
        SdkHandler.runOnMainThread(new C1051a(this, invokeDeepLinkParam, i, str));
    }

    public final <T> T a(String str, Class<T> cls) {
        try {
            return (T) v.f39411a.fromJson(str, (Class) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean a() {
        List<String> list;
        try {
            String str = this.c.c;
            if (!TextUtils.isEmpty(str) && (list = p0.r) != null && !list.isEmpty()) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2) && str.toLowerCase().startsWith(str2.toLowerCase())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JavascriptInterface
    public String checkAppInstall(String str) {
        CheckAppInstallParam checkAppInstallParam = (CheckAppInstallParam) a(str, CheckAppInstallParam.class);
        if (checkAppInstallParam == null) {
            return "";
        }
        checkAppInstallParam.getUuid();
        if (!a()) {
            return "";
        }
        return "{\"install_status\":" + (!TextUtils.isEmpty(checkAppInstallParam.getDeep_link()) ? com.kc.dw.core.utils.f.a(checkAppInstallParam.getDeep_link()) : false) + "}";
    }

    @JavascriptInterface
    public void closePage(String str) {
        UUIDParam uUIDParam;
        i iVar;
        if (TextUtils.isEmpty(str) || (uUIDParam = (UUIDParam) a(str, UUIDParam.class)) == null) {
            return;
        }
        uUIDParam.getUuid();
        if (a() && (iVar = this.e) != null) {
            iVar.onClosePage();
        }
    }

    @JavascriptInterface
    public String getAdInfo(String str) {
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam == null) {
            return "";
        }
        uUIDParam.getUuid();
        if (!a()) {
            return "";
        }
        return v.f39411a.toJson(GetH5AdInfoResBean.make(this.f39434a, w0.d(com.kc.dw.base.a.getContext())));
    }

    @JavascriptInterface
    public String getJSApiVersion(String str) {
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam == null) {
            return "";
        }
        uUIDParam.getUuid();
        return !a() ? "" : "{\"version\":3000400}";
    }

    @JavascriptInterface
    public void h5NotifyError(String str) {
        try {
            H5NotifyErrorParam h5NotifyErrorParam = (H5NotifyErrorParam) a(str, H5NotifyErrorParam.class);
            if (h5NotifyErrorParam != null) {
                h5NotifyErrorParam.getUuid();
                if (a()) {
                    try {
                        z0.a(this.f39434a, 15, h5NotifyErrorParam.getCode(), h5NotifyErrorParam.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void h5Readied(String str) {
        i iVar;
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a() && (iVar = this.e) != null) {
                iVar.onWebReady(true);
            }
        }
    }

    @JavascriptInterface
    public void invokeDeepLink(String str) {
        final InvokeDeepLinkParam invokeDeepLinkParam = (InvokeDeepLinkParam) a(str, InvokeDeepLinkParam.class);
        if (invokeDeepLinkParam != null) {
            invokeDeepLinkParam.getUuid();
            if (a()) {
                new com.kc.dw.core.webview.jsbridge.a(this.b).a(invokeDeepLinkParam, new com.kc.dw.core.webview.jsbridge.a.InterfaceC1052a(this, invokeDeepLinkParam) { // from class: com.kc.dw.core.webview.a$$ExternalSyntheticLambda0
                    public final a f$0;
                    public final InvokeDeepLinkParam f$1;

                    {
                        this.f$0 = this;
                        this.f$1 = invokeDeepLinkParam;
                    }

                    @Override // com.kc.dw.core.webview.jsbridge.a.InterfaceC1052a
                    public final void a(int i, String str2) {
                        this.f$0.a(this.f$1, i, str2);
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void onQuickRewardClick(String str) {
        UUIDParam uUIDParam;
        i iVar;
        if (TextUtils.isEmpty(str) || (uUIDParam = (UUIDParam) a(str, UUIDParam.class)) == null) {
            return;
        }
        uUIDParam.getUuid();
        if (a() && (iVar = this.e) != null) {
            iVar.onWebClicked();
        }
    }

    @JavascriptInterface
    public String openWebViewPage(String str) {
        String strA;
        String str2;
        OpenWebViewPageParam openWebViewPageParam = (OpenWebViewPageParam) a(str, OpenWebViewPageParam.class);
        String string = "";
        if (openWebViewPageParam != null) {
            openWebViewPageParam.getUuid();
            if (a()) {
                com.kc.dw.platform.ad_adapter.c cVar = this.b;
                com.kc.dw.core.webview.jsbridge.b bVar = new com.kc.dw.core.webview.jsbridge.b(cVar);
                try {
                    if (bVar.f39442a != null) {
                        if (TextUtils.isEmpty(openWebViewPageParam.getUrl())) {
                            str2 = "url 为空";
                        } else {
                            bVar.f39442a.setdUrl(new String[]{openWebViewPageParam.getUrl()});
                            com.kc.dw.core.utils.f.b(cVar, com.kc.dw.base.a.getContext(), bVar.f39442a, openWebViewPageParam.getOpen_type() == 1);
                            strA = com.kc.dw.core.webview.jsbridge.b.a(true, "");
                        }
                        return strA;
                    }
                    str2 = "初始化错误";
                    strA = com.kc.dw.core.webview.jsbridge.b.a(false, str2);
                    return strA;
                } catch (Exception e) {
                    e.printStackTrace();
                    StringBuilder sb = new StringBuilder();
                    sb.append("未知错误:");
                    try {
                        string = e.toString();
                    } catch (Exception unused) {
                    }
                    sb.append(string);
                    return com.kc.dw.core.webview.jsbridge.b.a(false, sb.toString());
                }
            }
        }
        return "";
    }
}
