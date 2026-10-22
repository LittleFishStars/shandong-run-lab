package com.acse.ottn.dsbridge;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.d3;
import com.acse.ottn.h2;
import com.acse.ottn.m0;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DWebView extends WebView {
    public static final String l = "_dsbridge";
    public static final String m = "dsBridge";
    public static boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f22948a;
    public String b;
    public int c;
    public WebChromeClient d;
    public volatile boolean e;
    public g f;
    public ArrayList<e> g;
    public InnerJavascriptInterface h;
    public Handler i;
    public Map<Integer, d3> j;
    public WebChromeClient k;

    public class InnerJavascriptInterface {

        public class a implements m0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f22957a;

            public a(String str) {
                this.f22957a = str;
            }

            @Override // com.acse.ottn.m0
            public void a() {
                a(null, true);
            }

            @Override // com.acse.ottn.m0
            public void b(Object obj) {
                a(obj, true);
            }

            @Override // com.acse.ottn.m0
            public void a(Object obj) {
                a(obj, false);
            }

            public final void a(Object obj, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", obj);
                    String str = this.f22957a;
                    if (str != null) {
                        String str2 = String.format("%s(%s.data);", str, jSONObject.toString());
                        if (z) {
                            str2 = str2 + "delete window." + this.f22957a;
                        }
                        DWebView.this.b(str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public InnerJavascriptInterface() {
        }

        public final void a(String str) {
            h2.a("dsBridge", str);
            if (DWebView.n) {
                DWebView.this.b(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0078  */
        /* JADX WARN: Code duplicated, block: B:27:0x0096  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:31:0x00be  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c3 A[Catch: Exception -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e9, blocks: (B:33:0x00c3, B:36:0x00d6), top: B:47:0x00c1 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00d6 A[Catch: Exception -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e9, blocks: (B:33:0x00c3, B:36:0x00d6), top: B:47:0x00c1 }] */
        /* JADX WARN: Instruction removed from duplicated block: B:25:0x0078, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:29:0x00a0, please report this as an issue */
        @JavascriptInterface
        @Keep
        public String call(String str, String str2) {
            boolean z;
            String[] strArrC = DWebView.this.c(str.trim());
            String str3 = strArrC[1];
            Object obj = DWebView.this.f22948a.get(strArrC[0]);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (obj == null) {
                a("Js bridge  called, but can't find a corresponded JavascriptInterface object , please check your code!");
                return jSONObject.toString();
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                Method method = null;
                String string = jSONObject2.has("_dscbstub") ? jSONObject2.getString("_dscbstub") : null;
                Object obj2 = jSONObject2.has("data") ? jSONObject2.get("data") : null;
                Class<?> cls = obj.getClass();
                try {
                    try {
                        method = cls.getMethod(str3, Object.class, m0.class);
                        z = true;
                    } catch (Exception unused) {
                        method = cls.getMethod(str3, Object.class);
                        z = false;
                        if (method == null) {
                            a("Not find method \"" + str3 + "\" implementation! please check if the  signature or namespace of the method is right ");
                            return jSONObject.toString();
                        }
                        if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                            a("Method " + str3 + " is not invoked, since  it is not declared with JavascriptInterface annotation! ");
                            return jSONObject.toString();
                        }
                        method.setAccessible(true);
                        try {
                            if (z) {
                                method.invoke(obj, obj2, new a(string));
                                return jSONObject.toString();
                            }
                            Object objInvoke = method.invoke(obj, obj2);
                            jSONObject.put("code", 0);
                            jSONObject.put("data", objInvoke);
                            return jSONObject.toString();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            a(String.format("Call failed：The parameter of \"%s\" in Java is invalid.", str3));
                            return jSONObject.toString();
                        }
                    }
                } catch (Exception unused2) {
                    z = false;
                }
                if (method == null) {
                    a("Not find method \"" + str3 + "\" implementation! please check if the  signature or namespace of the method is right ");
                    return jSONObject.toString();
                }
                if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    a("Method " + str3 + " is not invoked, since  it is not declared with JavascriptInterface annotation! ");
                    return jSONObject.toString();
                }
                method.setAccessible(true);
                if (z) {
                    method.invoke(obj, obj2, new a(string));
                    return jSONObject.toString();
                }
                Object objInvoke2 = method.invoke(obj, obj2);
                jSONObject.put("code", 0);
                jSONObject.put("data", objInvoke2);
                return jSONObject.toString();
            } catch (JSONException e3) {
                a(String.format("The argument of \"%s\" must be a JSON object string!", str3));
                e3.printStackTrace();
                return jSONObject.toString();
            }
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22958a;

        public a(String str) {
            this.f22958a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.a(this.f22958a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22959a;

        public b(String str) {
            this.f22959a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f22959a;
            if (str != null && str.startsWith(com.alibaba.ariver.remotedebug.b.k)) {
                DWebView.super.loadUrl(this.f22959a);
                return;
            }
            DWebView.this.g = new ArrayList();
            DWebView.super.loadUrl(this.f22959a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22960a;
        public final /* synthetic */ Map b;

        public c(String str, Map map) {
            this.f22960a = str;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f22960a;
            if (str != null && str.startsWith(com.alibaba.ariver.remotedebug.b.k)) {
                DWebView.super.loadUrl(this.f22960a, this.b);
                return;
            }
            DWebView.this.g = new ArrayList();
            DWebView.super.loadUrl(this.f22960a, this.b);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.g = new ArrayList();
            DWebView.super.reload();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22962a;
        public int b;
        public String c;

        public e(String str, int i, Object[] objArr) {
            this.f22962a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.b = i;
            this.c = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.c);
                jSONObject.put("callbackId", this.b);
                jSONObject.put("data", this.f22962a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    @Deprecated
    public interface f {
        @TargetApi(11)
        void a(ValueCallback valueCallback, String str);

        @TargetApi(16)
        void a(ValueCallback<Uri> valueCallback, String str, String str2);
    }

    public interface g {
        boolean onClose();
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22948a = new HashMap();
        this.c = 0;
        this.e = true;
        this.f = null;
        this.h = new InnerJavascriptInterface();
        this.i = new Handler(Looper.getMainLooper());
        this.j = new HashMap();
        this.k = new WebChromeClient() { // from class: com.acse.ottn.dsbridge.DWebView.6

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f22953a;

                public a(JsResult jsResult) {
                    this.f22953a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (DWebView.this.e) {
                        this.f22953a.confirm();
                    }
                }
            }

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f22954a;

                public b(JsResult jsResult) {
                    this.f22954a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.e) {
                        if (i == -1) {
                            this.f22954a.confirm();
                        } else {
                            this.f22954a.cancel();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f22955a;
                public final /* synthetic */ EditText b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.f22955a = jsPromptResult;
                    this.b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.e) {
                        if (i == -1) {
                            this.f22955a.confirm(this.b.getText().toString());
                        } else {
                            this.f22955a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.d != null ? DWebView.this.d.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.d != null ? DWebView.this.d.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i, String str2) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onConsoleMessage(str, i, str2);
                } else {
                    super.onConsoleMessage(str, i, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                return DWebView.this.d != null ? DWebView.this.d.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.e) {
                    jsResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DWebView.this.d != null ? DWebView.this.d.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.e) {
                    jsResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (!DWebView.this.e) {
                    jsPromptResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f2 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f2);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f2);
                editText.setPadding(i2 - ((int) (f2 * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.d != null ? DWebView.this.d.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DWebView.this.d != null ? DWebView.this.d.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.d instanceof f) {
                    ((f) DWebView.this.d).a(valueCallback, str);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.d instanceof f) {
                    ((f) DWebView.this.d).a(valueCallback, str, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.d != null) {
                    return DWebView.this.d.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }
        };
        c();
    }

    @Keep
    private void addInternalJavascriptObject() {
        a(new Object() { // from class: com.acse.ottn.dsbridge.DWebView.1

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$1$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DWebView.this.f == null || DWebView.this.f.onClose()) {
                        Context context = DWebView.this.getContext();
                        if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$1$b */
            public class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Object f22951a;

                public b(Object obj) {
                    this.f22951a = obj;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = (JSONObject) this.f22951a;
                    try {
                        int i = jSONObject.getInt("id");
                        boolean z = jSONObject.getBoolean("complete");
                        d3 d3Var = DWebView.this.j.get(Integer.valueOf(i));
                        Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
                        if (d3Var != null) {
                            d3Var.a(obj);
                            if (z) {
                                DWebView.this.j.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @JavascriptInterface
            @Keep
            public String closePage(Object obj) throws JSONException {
                DWebView.this.a(new a());
                return null;
            }

            @JavascriptInterface
            @Keep
            public void disableJavascriptDialogBlock(Object obj) throws JSONException {
                DWebView.this.e = !((JSONObject) obj).getBoolean("disable");
            }

            @JavascriptInterface
            @Keep
            public void dsinit(Object obj) {
                DWebView.this.b();
            }

            @JavascriptInterface
            @Keep
            public boolean hasNativeMethod(Object obj) throws JSONException {
                Method method;
                boolean z;
                JSONObject jSONObject = (JSONObject) obj;
                String strTrim = jSONObject.getString("name").trim();
                String strTrim2 = jSONObject.getString("type").trim();
                String[] strArrC = DWebView.this.c(strTrim);
                Object obj2 = DWebView.this.f22948a.get(strArrC[0]);
                if (obj2 != null) {
                    Class<?> cls = obj2.getClass();
                    try {
                        try {
                            method = cls.getMethod(strArrC[1], Object.class, m0.class);
                            z = true;
                        } catch (Exception unused) {
                            method = null;
                            z = false;
                        }
                    } catch (Exception unused2) {
                        method = cls.getMethod(strArrC[1], Object.class);
                        z = false;
                        if (method != null) {
                            return false;
                        }
                        return false;
                    }
                    if (method != null || ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                        return false;
                    }
                    if ("all".equals(strTrim2) || ((z && "asyn".equals(strTrim2)) || (!z && "syn".equals(strTrim2)))) {
                        return true;
                    }
                }
                return false;
            }

            @JavascriptInterface
            @Keep
            public void returnValue(Object obj) {
                DWebView.this.a(new b(obj));
            }
        }, "_dsb");
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        WebView.setWebContentsDebuggingEnabled(z);
        n = z;
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        super.clearCache(z);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File file = new File(this.b);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            a(file2);
        }
        if (file.exists()) {
            a(file);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(new b(str));
    }

    @Override // android.webkit.WebView
    public void reload() {
        a(new d());
    }

    public void setJavascriptCloseWindowListener(g gVar) {
        this.f = gVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.d = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a(new c(str, map));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public final void c() {
        this.b = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.k);
        addInternalJavascriptObject();
        super.addJavascriptInterface(this.h, "_dsbridge");
    }

    public void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f22948a.remove(str);
    }

    public void b(String str) {
        a(new a(str));
    }

    public final synchronized void b() {
        ArrayList<e> arrayList = this.g;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.g = null;
        }
    }

    public final void a(String str) {
        super.evaluateJavascript(str, null);
    }

    public void b(String str, d3<Boolean> d3Var) {
        a("_hasJavascriptMethod", new Object[]{str}, d3Var);
    }

    public final void a(e eVar) {
        b(String.format("window._handleMessageFromNative(%s)", eVar.toString()));
    }

    public DWebView(Context context) {
        super(context);
        this.f22948a = new HashMap();
        this.c = 0;
        this.e = true;
        this.f = null;
        this.h = new InnerJavascriptInterface();
        this.i = new Handler(Looper.getMainLooper());
        this.j = new HashMap();
        this.k = new WebChromeClient() { // from class: com.acse.ottn.dsbridge.DWebView.6

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f22953a;

                public a(JsResult jsResult) {
                    this.f22953a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (DWebView.this.e) {
                        this.f22953a.confirm();
                    }
                }
            }

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f22954a;

                public b(JsResult jsResult) {
                    this.f22954a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.e) {
                        if (i == -1) {
                            this.f22954a.confirm();
                        } else {
                            this.f22954a.cancel();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.acse.ottn.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f22955a;
                public final /* synthetic */ EditText b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.f22955a = jsPromptResult;
                    this.b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.e) {
                        if (i == -1) {
                            this.f22955a.confirm(this.b.getText().toString());
                        } else {
                            this.f22955a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.d != null ? DWebView.this.d.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.d != null ? DWebView.this.d.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i, String str2) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onConsoleMessage(str, i, str2);
                } else {
                    super.onConsoleMessage(str, i, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                return DWebView.this.d != null ? DWebView.this.d.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.e) {
                    jsResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                return DWebView.this.d != null ? DWebView.this.d.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.e) {
                    jsResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (!DWebView.this.e) {
                    jsPromptResult.confirm();
                }
                if (DWebView.this.d != null && DWebView.this.d.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f2 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f2);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f2);
                editText.setPadding(i2 - ((int) (f2 * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.d != null ? DWebView.this.d.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return DWebView.this.d != null ? DWebView.this.d.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (DWebView.this.d instanceof f) {
                    ((f) DWebView.this.d).a(valueCallback, str);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (DWebView.this.d instanceof f) {
                    ((f) DWebView.this.d).a(valueCallback, str, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.d != null) {
                    return DWebView.this.d.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                if (DWebView.this.d != null) {
                    DWebView.this.d.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }
        };
        c();
    }

    public synchronized <T> void a(String str, Object[] objArr, d3<T> d3Var) {
        int i = this.c + 1;
        this.c = i;
        e eVar = new e(str, i, objArr);
        if (d3Var != null) {
            this.j.put(Integer.valueOf(eVar.b), d3Var);
        }
        ArrayList<e> arrayList = this.g;
        if (arrayList != null) {
            arrayList.add(eVar);
        } else {
            a(eVar);
        }
    }

    public void a(String str, Object[] objArr) {
        a(str, objArr, (d3) null);
    }

    public final String[] c(String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, iLastIndexOf);
            str = str.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        return new String[]{strSubstring, str};
    }

    public <T> void a(String str, d3<T> d3Var) {
        a(str, (Object[]) null, d3Var);
    }

    public void a(Object obj, String str) {
        if (str == null) {
            str = "";
        }
        if (obj != null) {
            this.f22948a.put(str, obj);
        }
    }

    public void a(boolean z) {
        this.e = !z;
    }

    public void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            file.delete();
            return;
        }
        h2.b("Webview", "delete file no exists " + file.getAbsolutePath());
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.i.post(runnable);
        }
    }
}
