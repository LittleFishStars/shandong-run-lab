package com.huachenjie.base.dsbridge_webview;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
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
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.zj.adlib.i4a;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DWebView extends WebView {
    public static boolean c = false;
    public static final String g = "_dsbridge";
    public static final String h = "dsBridge";
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f32894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueCallback<Uri[]> f7163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WebChromeClient f7164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Lifecycle f7165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CompletionHandler<Object> f7166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ChooseImageListener f7167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final InnerJavascriptInterface f7168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public JavascriptCloseWindowListener f7169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPickerLauncher f7170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<e> f7171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, Object> f7172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f7173a;
    public final WebChromeClient b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f7174b;
    public String f;
    Map<Integer, OnReturnValue> handlerMap;

    public interface ChooseImageListener {
        void onCancel();

        void onResult(List<String> paths);
    }

    @Deprecated
    public interface FileChooser {
        @TargetApi(11)
        void openFileChooser(ValueCallback valueCallback, String acceptType);

        @TargetApi(16)
        void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture);
    }

    public class InnerJavascriptInterface {

        public class a implements CompletionHandler {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f7181a;

            public a(final String val$cb) {
                this.f7181a = val$cb;
            }

            @Override // com.huachenjie.base.dsbridge_webview.CompletionHandler
            public void a(Object retValue) {
                c(retValue, true);
            }

            @Override // com.huachenjie.base.dsbridge_webview.CompletionHandler
            public void b(Object value) {
                c(value, false);
            }

            public final void c(Object retValue, boolean complete) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", retValue);
                    String str = this.f7181a;
                    if (str != null) {
                        String str2 = String.format("%s(%s.data);", str, jSONObject);
                        if (complete) {
                            str2 = str2 + "delete window." + this.f7181a;
                        }
                        DWebView.this.evaluateJavascript(str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.huachenjie.base.dsbridge_webview.CompletionHandler
            public void complete() {
                c(null, true);
            }
        }

        public InnerJavascriptInterface() {
        }

        public final void a(String error) {
            Log.d("dsBridge", error);
            if (DWebView.c) {
                DWebView.this.evaluateJavascript(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + error.replaceAll("\\'", "\\\\'")));
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
        public String call(String methodName, String argStr) {
            boolean z;
            String[] strArrZ = DWebView.this.z(methodName.trim());
            String str = strArrZ[1];
            Object obj = DWebView.this.f7172a.get(strArrZ[0]);
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
                JSONObject jSONObject2 = new JSONObject(argStr);
                Method method = null;
                String string = jSONObject2.has("_dscbstub") ? jSONObject2.getString("_dscbstub") : null;
                Object obj2 = jSONObject2.has("data") ? jSONObject2.get("data") : null;
                Class<?> cls = obj.getClass();
                try {
                    try {
                        method = cls.getMethod(str, Object.class, CompletionHandler.class);
                        z = true;
                    } catch (Exception unused) {
                        method = cls.getMethod(str, Object.class);
                        z = false;
                        if (method == null) {
                            a("Not find method \"" + str + "\" implementation! please check if the  signature or namespace of the method is right ");
                            return jSONObject.toString();
                        }
                        if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                            a("Method " + str + " is not invoked, since  it is not declared with JavascriptInterface annotation! ");
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
                            a(String.format("Call failed：The parameter of \"%s\" in Java is invalid.", str));
                            return jSONObject.toString();
                        }
                    }
                } catch (Exception unused2) {
                    z = false;
                }
                if (method == null) {
                    a("Not find method \"" + str + "\" implementation! please check if the  signature or namespace of the method is right ");
                    return jSONObject.toString();
                }
                if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) == null) {
                    a("Method " + str + " is not invoked, since  it is not declared with JavascriptInterface annotation! ");
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
                a(String.format("The argument of \"%s\" must be a JSON object string!", str));
                e3.printStackTrace();
                return jSONObject.toString();
            }
        }
    }

    public interface JavascriptCloseWindowListener {
        boolean a(Object object);
    }

    public class a implements Runnable {
        public final /* synthetic */ String f;

        public a(final String val$script) {
            this.f = val$script;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.r(this.f);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String f;

        public b(final String val$url) {
            this.f = val$url;
        }

        @Override // java.lang.Runnable
        public void run() {
            i4a.a("loadUrl:" + this.f);
            String str = this.f;
            if (str != null && str.startsWith(com.alibaba.ariver.remotedebug.b.k)) {
                DWebView.super.loadUrl(this.f);
                return;
            }
            DWebView.this.f7171a = new ArrayList();
            DWebView.super.loadUrl(this.f);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f7182a;
        public final /* synthetic */ String f;

        public c(final String val$url, final Map val$additionalHttpHeaders) {
            this.f = val$url;
            this.f7182a = val$additionalHttpHeaders;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f;
            if (str != null && str.startsWith(com.alibaba.ariver.remotedebug.b.k)) {
                DWebView.super.loadUrl(this.f, this.f7182a);
                return;
            }
            DWebView.this.f7171a = new ArrayList();
            DWebView.super.loadUrl(this.f, this.f7182a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.f7171a = new ArrayList();
            DWebView.super.reload();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32908a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f7183a;
        public final String b;

        public e(String handlerName, int id, Object[] args) {
            this.f7183a = new JSONArray((Collection) Arrays.asList(args == null ? new Object[0] : args)).toString();
            this.f32908a = id;
            this.b = handlerName;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", this.b);
                jSONObject.put("callbackId", this.f32908a);
                jSONObject.put("data", this.f7183a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public DWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7172a = new HashMap();
        this.f7168a = new InnerJavascriptInterface();
        this.f32894a = new Handler(Looper.getMainLooper());
        this.handlerMap = new HashMap();
        this.K = 0;
        this.f7173a = true;
        this.f7169a = null;
        this.f7174b = false;
        this.b = new WebChromeClient() { // from class: com.huachenjie.base.dsbridge_webview.DWebView.1

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$a */
            public class a implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f32896a;

                public a(final JsResult val$result) {
                    this.f32896a = val$result;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if (DWebView.this.f7173a) {
                        this.f32896a.confirm();
                    }
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$b */
            public class b implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f32897a;

                public b(final JsResult val$result) {
                    this.f32897a = val$result;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    if (DWebView.this.f7173a) {
                        if (which == -1) {
                            this.f32897a.confirm();
                        } else {
                            this.f32897a.cancel();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$c */
            public class c implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f32898a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ EditText f7177a;

                public c(final JsPromptResult val$result, final EditText val$editText) {
                    this.f32898a = val$result;
                    this.f7177a = val$editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    if (DWebView.this.f7173a) {
                        if (which == -1) {
                            this.f32898a.confirm(this.f7177a.getText().toString());
                        } else {
                            this.f32898a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.getVisitedHistory(callback);
                } else {
                    super.getVisitedHistory(callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView window) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onCloseWindow(window);
                } else {
                    super.onCloseWindow(window);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onConsoleMessage(message, lineNumber, sourceID);
                } else {
                    super.onConsoleMessage(message, lineNumber, sourceID);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onCreateWindow(view, isDialog, isUserGesture, resultMsg) : super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onGeolocationPermissionsShowPrompt(origin, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(origin, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, final String message, final JsResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if ((DWebView.this.f7164a != null && DWebView.this.f7164a.onJsAlert(view, url, message, result)) || DWebView.this.getContext() == null) {
                    return true;
                }
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setMessage(message).setCancelable(false).setPositiveButton(R.string.ok, new a(result)).create());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onJsBeforeUnload(view, url, message, result) : super.onJsBeforeUnload(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if (DWebView.this.f7164a != null && DWebView.this.f7164a.onJsConfirm(view, url, message, result)) {
                    return true;
                }
                b bVar = new b(result);
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setMessage(message).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).create());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, final String message, String defaultValue, final JsPromptResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if (DWebView.this.f7164a != null && DWebView.this.f7164a.onJsPrompt(view, url, message, defaultValue, result)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(defaultValue);
                if (defaultValue != null) {
                    editText.setSelection(defaultValue.length());
                }
                float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(result, editText);
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setTitle(message).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).create());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f);
                editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest request) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onPermissionRequest(request);
                } else {
                    super.onPermissionRequest(request);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest request) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onPermissionRequestCanceled(request);
                } else {
                    super.onPermissionRequestCanceled(request);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onProgressChanged(view, newProgress);
                } else {
                    super.onProgressChanged(view, newProgress);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView view, Bitmap icon) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedIcon(view, icon);
                } else {
                    super.onReceivedIcon(view, icon);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedTitle(view, title);
                } else {
                    super.onReceivedTitle(view, title);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedTouchIconUrl(view, url, precomposed);
                } else {
                    super.onReceivedTouchIconUrl(view, url, precomposed);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView view) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onRequestFocus(view);
                } else {
                    super.onRequestFocus(view);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onShowCustomView(view, callback);
                } else {
                    super.onShowCustomView(view, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                int i = fileChooserParams.getMode() == 1 ? 9 : 1;
                if (DWebView.this.x() == null || DWebView.this.f7170a == null) {
                    filePathCallback.onReceiveValue(new Uri[0]);
                    return true;
                }
                DWebView.this.f7163a = filePathCallback;
                DWebView.this.f7170a.T("为了能够正常上传图片，我们需要访问您终端设备的相机权限", i, 1080, 1024);
                return true;
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String acceptType) {
                if (DWebView.this.f7164a instanceof FileChooser) {
                    ((FileChooser) DWebView.this.f7164a).openFileChooser(valueCallback, acceptType);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
                if (DWebView.this.f7164a instanceof FileChooser) {
                    ((FileChooser) DWebView.this.f7164a).openFileChooser(valueCallback, acceptType, capture);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f7164a != null) {
                    return DWebView.this.f7164a.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onShowCustomView(view, requestedOrientation, callback);
                } else {
                    super.onShowCustomView(view, requestedOrientation, callback);
                }
            }
        };
        y();
    }

    public static Uri[] C(List<String> paths) {
        Uri[] uriArr = new Uri[paths.size()];
        for (int i = 0; i < paths.size(); i++) {
            uriArr[i] = Uri.fromFile(new File(paths.get(i)));
        }
        return uriArr;
    }

    @Keep
    private void addInternalJavascriptObject() {
        addJavascriptObject(new Object() { // from class: com.huachenjie.base.dsbridge_webview.DWebView.2

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$2$a */
            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Object f7179a;

                public a(final Object val$object) {
                    this.f7179a = val$object;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DWebView.this.f7169a == null || DWebView.this.f7169a.a(this.f7179a)) {
                        Context context = DWebView.this.getContext();
                        if (context instanceof Activity) {
                            ((Activity) context).onBackPressed();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$2$b */
            public class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Object f7180a;

                public b(final Object val$obj) {
                    this.f7180a = val$obj;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = (JSONObject) this.f7180a;
                    try {
                        int i = jSONObject.getInt("id");
                        boolean z = jSONObject.getBoolean("complete");
                        OnReturnValue onReturnValue = DWebView.this.handlerMap.get(Integer.valueOf(i));
                        Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
                        if (onReturnValue != null) {
                            onReturnValue.a(obj);
                            if (z) {
                                DWebView.this.handlerMap.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @JavascriptInterface
            @Keep
            public String closePage(Object object) throws JSONException {
                DWebView.this.A(new a(object));
                return null;
            }

            @JavascriptInterface
            @Keep
            public void disableJavascriptDialogBlock(Object object) throws JSONException {
                DWebView.this.f7173a = !((JSONObject) object).getBoolean("disable");
            }

            @JavascriptInterface
            @Keep
            public void dsinit(Object jsonObject) {
                DWebView.this.v();
            }

            @JavascriptInterface
            @Keep
            public boolean hasNativeMethod(Object args) throws JSONException {
                Method method;
                boolean z;
                JSONObject jSONObject = (JSONObject) args;
                String strTrim = jSONObject.getString("name").trim();
                String strTrim2 = jSONObject.getString("type").trim();
                String[] strArrZ = DWebView.this.z(strTrim);
                Object obj = DWebView.this.f7172a.get(strArrZ[0]);
                if (obj == null) {
                    return false;
                }
                Class<?> cls = obj.getClass();
                try {
                    try {
                        method = cls.getMethod(strArrZ[1], Object.class, CompletionHandler.class);
                        z = true;
                    } catch (Exception unused) {
                        method = null;
                        z = false;
                    }
                } catch (Exception unused2) {
                    method = cls.getMethod(strArrZ[1], Object.class);
                    z = false;
                    return method == null ? false : false;
                }
                if (method == null && ((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) != null) {
                    return "all".equals(strTrim2) || (z && "asyn".equals(strTrim2)) || (!z && "syn".equals(strTrim2));
                }
            }

            @JavascriptInterface
            @Keep
            public void returnValue(final Object obj) {
                DWebView.this.A(new b(obj));
            }
        }, "_dsb");
    }

    public static void setWebContentsDebuggingEnabled(boolean enabled) {
        WebView.setWebContentsDebuggingEnabled(enabled);
        c = enabled;
    }

    public static List<String> w(MediaPickerResult result) {
        List<String> listG;
        return ((result instanceof MediaPickerResult.Success) && (listG = ((MediaPickerResult.Success) result).g()) != null) ? listG : Collections.emptyList();
    }

    public final void A(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f32894a.post(runnable);
        }
    }

    public final void B(Dialog dialog) {
        Context context = getContext();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        dialog.show();
    }

    public void addJavascriptObject(Object object, String namespace) {
        if (namespace == null) {
            namespace = "";
        }
        if (object != null) {
            this.f7172a.put(namespace, object);
        }
    }

    public void cacheWechatAuth(CompletionHandler<Object> handler) {
        this.f7166a = handler;
    }

    public synchronized <T> void callHandler(String method, Object[] args, final OnReturnValue<T> handler) {
        int i = this.K + 1;
        this.K = i;
        e eVar = new e(method, i, args);
        if (handler != null) {
            this.handlerMap.put(Integer.valueOf(eVar.f32908a), handler);
        }
        ArrayList<e> arrayList = this.f7171a;
        if (arrayList != null) {
            arrayList.add(eVar);
        } else {
            t(eVar);
        }
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean includeDiskFiles) {
        super.clearCache(includeDiskFiles);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File file = new File(this.f);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            deleteFile(file2);
        }
        if (file.exists()) {
            deleteFile(file);
        }
    }

    public void deleteFile(File file) {
        if (!file.exists()) {
            Log.e("Webview", "delete file no exists " + file.getAbsolutePath());
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public void disableJavascriptDialogBlock(boolean disable) {
        this.f7173a = !disable;
    }

    public void evaluateJavascript(final String script) {
        A(new a(script));
    }

    public Object getJavascriptObject(String namespace) {
        return this.f7172a.get(namespace);
    }

    public Lifecycle getLifecycle() {
        return this.f7165a;
    }

    public void hasJavascriptMethod(String handlerName, OnReturnValue<Boolean> existCallback) {
        callHandler("_hasJavascriptMethod", new Object[]{handlerName}, existCallback);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String url) {
        A(new b(url));
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        return (this.f7174b && event.getAction() == 1) ? callOnClick() : super.onTouchEvent(event);
    }

    public void onWechatAuth(String code) {
        if (this.f7166a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("access_token", code);
            } catch (Exception unused) {
            }
            this.f7166a.a(jSONObject);
        }
        this.f7166a = null;
    }

    public final void r(String script) {
        super.evaluateJavascript(script, null);
    }

    @Override // android.webkit.WebView
    public void reload() {
        A(new d());
    }

    public void removeJavascriptObject(String namespace) {
        if (namespace == null) {
            namespace = "";
        }
        this.f7172a.remove(namespace);
    }

    public final void s(FragmentActivity activity) {
        if (this.f7170a != null) {
            return;
        }
        this.f7170a = MediaPicker.w(activity, new MediaPickerListener() { // from class: com.zj.adlib.m52
            @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
            public final void b(MediaPickerResult mediaPickerResult) {
                this.f43224a.u(mediaPickerResult);
            }
        });
    }

    public void setJavascriptCloseWindowListener(JavascriptCloseWindowListener listener) {
        this.f7169a = listener;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.f7165a = lifecycle;
        FragmentActivity fragmentActivityX = x();
        if (fragmentActivityX != null) {
            s(fragmentActivityX);
        }
    }

    public void setNeedCallClick(boolean needCallClick) {
        this.f7174b = needCallClick;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient client) {
        this.f7164a = client;
    }

    public void showChooseImage(int count, int imageMaxSize, ChooseImageListener listener) {
        FragmentActivity fragmentActivityX = x();
        if (fragmentActivityX != null) {
            s(fragmentActivityX);
        }
        MediaPickerLauncher mediaPickerLauncher = this.f7170a;
        if (mediaPickerLauncher == null) {
            listener.onCancel();
        } else {
            this.f7167a = listener;
            mediaPickerLauncher.T("为了能够正常上传图片，我们需要访问您终端设备的相机权限", count, 0, imageMaxSize);
        }
    }

    public final void t(e info) {
        evaluateJavascript(String.format("window._handleMessageFromNative(%s)", info.toString()));
    }

    public final void u(MediaPickerResult result) {
        List<String> listW = w(result);
        ChooseImageListener chooseImageListener = this.f7167a;
        if (chooseImageListener != null) {
            this.f7167a = null;
            if (listW.isEmpty()) {
                chooseImageListener.onCancel();
                return;
            } else {
                chooseImageListener.onResult(listW);
                return;
            }
        }
        ValueCallback<Uri[]> valueCallback = this.f7163a;
        this.f7163a = null;
        if (valueCallback == null) {
            return;
        }
        valueCallback.onReceiveValue(listW.isEmpty() ? new Uri[0] : C(listW));
    }

    public final synchronized void v() {
        ArrayList<e> arrayList = this.f7171a;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                t(it.next());
            }
            this.f7171a = null;
        }
    }

    public final FragmentActivity x() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
        }
        return null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public final void y() {
        if (isInEditMode()) {
            return;
        }
        this.f = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        super.setWebChromeClient(this.b);
        addInternalJavascriptObject();
        super.addJavascriptInterface(this.f7168a, "_dsbridge");
    }

    public final String[] z(String method) {
        String strSubstring;
        int iLastIndexOf = method.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = method.substring(0, iLastIndexOf);
            method = method.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        return new String[]{strSubstring, method};
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String url, final Map<String, String> additionalHttpHeaders) {
        A(new c(url, additionalHttpHeaders));
    }

    public void setWebChromeClient(WebChromeClient client, boolean isUseDefaultMethod) {
        if (isUseDefaultMethod) {
            super.setWebChromeClient(client);
        } else {
            this.f7164a = client;
        }
    }

    public void callHandler(String method, Object[] args) {
        callHandler(method, args, null);
    }

    public <T> void callHandler(String method, OnReturnValue<T> handler) {
        callHandler(method, null, handler);
    }

    public DWebView(Context context) {
        super(context);
        this.f7172a = new HashMap();
        this.f7168a = new InnerJavascriptInterface();
        this.f32894a = new Handler(Looper.getMainLooper());
        this.handlerMap = new HashMap();
        this.K = 0;
        this.f7173a = true;
        this.f7169a = null;
        this.f7174b = false;
        this.b = new WebChromeClient() { // from class: com.huachenjie.base.dsbridge_webview.DWebView.1

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$a */
            public class a implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f32896a;

                public a(final JsResult val$result) {
                    this.f32896a = val$result;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if (DWebView.this.f7173a) {
                        this.f32896a.confirm();
                    }
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$b */
            public class b implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsResult f32897a;

                public b(final JsResult val$result) {
                    this.f32897a = val$result;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    if (DWebView.this.f7173a) {
                        if (which == -1) {
                            this.f32897a.confirm();
                        } else {
                            this.f32897a.cancel();
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.base.dsbridge_webview.DWebView$1$c */
            public class c implements DialogInterface.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ JsPromptResult f32898a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ EditText f7177a;

                public c(final JsPromptResult val$result, final EditText val$editText) {
                    this.f32898a = val$result;
                    this.f7177a = val$editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    if (DWebView.this.f7173a) {
                        if (which == -1) {
                            this.f32898a.confirm(this.f7177a.getText().toString());
                        } else {
                            this.f32898a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.getVisitedHistory(callback);
                } else {
                    super.getVisitedHistory(callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView window) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onCloseWindow(window);
                } else {
                    super.onCloseWindow(window);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onConsoleMessage(message, lineNumber, sourceID);
                } else {
                    super.onConsoleMessage(message, lineNumber, sourceID);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onCreateWindow(view, isDialog, isUserGesture, resultMsg) : super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onGeolocationPermissionsShowPrompt(origin, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(origin, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, final String message, final JsResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if ((DWebView.this.f7164a != null && DWebView.this.f7164a.onJsAlert(view, url, message, result)) || DWebView.this.getContext() == null) {
                    return true;
                }
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setMessage(message).setCancelable(false).setPositiveButton(R.string.ok, new a(result)).create());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onJsBeforeUnload(view, url, message, result) : super.onJsBeforeUnload(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if (DWebView.this.f7164a != null && DWebView.this.f7164a.onJsConfirm(view, url, message, result)) {
                    return true;
                }
                b bVar = new b(result);
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setMessage(message).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).create());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, final String message, String defaultValue, final JsPromptResult result) {
                if (!DWebView.this.f7173a) {
                    result.confirm();
                }
                if (DWebView.this.f7164a != null && DWebView.this.f7164a.onJsPrompt(view, url, message, defaultValue, result)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(defaultValue);
                if (defaultValue != null) {
                    editText.setSelection(defaultValue.length());
                }
                float f = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(result, editText);
                DWebView.this.B(new AlertDialog.Builder(DWebView.this.getContext()).setTitle(message).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).create());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f);
                editText.setPadding(i2 - ((int) (f * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                return DWebView.this.f7164a != null ? DWebView.this.f7164a.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequest(PermissionRequest request) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onPermissionRequest(request);
                } else {
                    super.onPermissionRequest(request);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public void onPermissionRequestCanceled(PermissionRequest request) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onPermissionRequestCanceled(request);
                } else {
                    super.onPermissionRequestCanceled(request);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onProgressChanged(view, newProgress);
                } else {
                    super.onProgressChanged(view, newProgress);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView view, Bitmap icon) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedIcon(view, icon);
                } else {
                    super.onReceivedIcon(view, icon);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedTitle(view, title);
                } else {
                    super.onReceivedTitle(view, title);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onReceivedTouchIconUrl(view, url, precomposed);
                } else {
                    super.onReceivedTouchIconUrl(view, url, precomposed);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView view) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onRequestFocus(view);
                } else {
                    super.onRequestFocus(view);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onShowCustomView(view, callback);
                } else {
                    super.onShowCustomView(view, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                int i = fileChooserParams.getMode() == 1 ? 9 : 1;
                if (DWebView.this.x() == null || DWebView.this.f7170a == null) {
                    filePathCallback.onReceiveValue(new Uri[0]);
                    return true;
                }
                DWebView.this.f7163a = filePathCallback;
                DWebView.this.f7170a.T("为了能够正常上传图片，我们需要访问您终端设备的相机权限", i, 1080, 1024);
                return true;
            }

            @Keep
            @TargetApi(11)
            public void openFileChooser(ValueCallback valueCallback, String acceptType) {
                if (DWebView.this.f7164a instanceof FileChooser) {
                    ((FileChooser) DWebView.this.f7164a).openFileChooser(valueCallback, acceptType);
                }
            }

            @Keep
            @TargetApi(16)
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
                if (DWebView.this.f7164a instanceof FileChooser) {
                    ((FileChooser) DWebView.this.f7164a).openFileChooser(valueCallback, acceptType, capture);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (DWebView.this.f7164a != null) {
                    return DWebView.this.f7164a.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(14)
            public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
                if (DWebView.this.f7164a != null) {
                    DWebView.this.f7164a.onShowCustomView(view, requestedOrientation, callback);
                } else {
                    super.onShowCustomView(view, requestedOrientation, callback);
                }
            }
        };
        y();
    }
}
