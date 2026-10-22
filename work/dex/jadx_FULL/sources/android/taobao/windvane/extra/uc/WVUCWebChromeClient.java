package android.taobao.windvane.extra.uc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.b.g;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.d.b;
import android.taobao.windvane.runtimepermission.a;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.hjq.permissions.Permission;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.uc.webview.export.GeolocationPermissions;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.JsResult;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCWebChromeClient extends WebChromeClient {
    public static final int FilePathCallbackID = 15;
    private static final String KEY_CANCEL;
    private static final String KEY_CONFIRM;
    private static final String KEY_FROM;
    private static final String TAG = "WVUCWebChromeClient";
    protected Context mContext;
    public b mWebView = null;
    public ValueCallback<Uri[]> mFilePathCallback = null;

    /* JADX INFO: renamed from: android.taobao.windvane.extra.uc.WVUCWebChromeClient$11, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        KEY_FROM = EnvUtil.isCN() ? "来自于：" : "From: ";
        KEY_CONFIRM = EnvUtil.isCN() ? "确定" : "OK";
        KEY_CANCEL = EnvUtil.isCN() ? OptionsPickerHelper.e : "Cancel";
    }

    public WVUCWebChromeClient() {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        b bVar;
        if (g.a().a(2001).f21196a) {
            return true;
        }
        String strMessage = consoleMessage.message();
        if (strMessage != null) {
            if (!TextUtils.isEmpty(strMessage) && strMessage.startsWith("hybrid://") && (bVar = this.mWebView) != null) {
                if (bVar.getBridgeDelegate() != null) {
                    this.mWebView.getBridgeDelegate().hybridCall(this.mWebView, strMessage);
                    return true;
                }
                TaoLog.i(IBridgeDelegateService.TAG, "no jsbridge service found");
                return false;
            }
            if (strMessage.startsWith("wvNativeCallback")) {
                String strSubstring = strMessage.substring(strMessage.indexOf(WVNativeCallbackUtil.SEPERATER) + 1);
                int iIndexOf = strSubstring.indexOf(WVNativeCallbackUtil.SEPERATER);
                String strSubstring2 = strSubstring.substring(0, iIndexOf);
                String strSubstring3 = strSubstring.substring(iIndexOf + 1);
                ValueCallback<String> nativeCallback = WVNativeCallbackUtil.getNativeCallback(strSubstring2);
                if (nativeCallback != null) {
                    nativeCallback.onReceiveValue(strSubstring3);
                    WVNativeCallbackUtil.clearNativeCallback(strSubstring2);
                } else {
                    TaoLog.e(TAG, "NativeCallback failed: " + strSubstring3);
                }
                return true;
            }
        }
        if (TaoLog.getLogStatus()) {
            int i = AnonymousClass11.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
            if (i == 1) {
                TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else if (i == 2) {
                TaoLog.e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else if (i != 3) {
                TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else {
                TaoLog.w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        if ((webView.getContext() instanceof Activity) && ((Activity) webView.getContext()).isFinishing()) {
            jsResult.confirm();
            return true;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
            builder.setTitle(KEY_FROM + Uri.parse(str).getHost()).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        } catch (Throwable th) {
            TaoLog.e(TAG, th.getMessage());
            jsResult.confirm();
        }
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        if ((webView.getContext() instanceof Activity) && ((Activity) webView.getContext()).isFinishing()) {
            jsResult.confirm();
            return true;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
            builder.setTitle(KEY_FROM + Uri.parse(str).getHost()).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setNeutralButton(KEY_CANCEL, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        } catch (Throwable th) {
            TaoLog.e(TAG, th.getMessage());
            jsResult.confirm();
        }
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if ((webView.getContext() instanceof Activity) && ((Activity) webView.getContext()).isFinishing()) {
            jsPromptResult.confirm("");
            return true;
        }
        if (str3 != null && str3.equals("wv_hybrid:")) {
            b bVar = (b) webView;
            IBridgeDelegateService bridgeDelegate = bVar.getBridgeDelegate();
            if (bridgeDelegate == null) {
                TaoLog.i(IBridgeDelegateService.TAG, "no jsbridge service found");
                return false;
            }
            bridgeDelegate.hybridCall(bVar, str2);
            jsPromptResult.confirm("");
            return true;
        }
        try {
            EditText editText = new EditText(webView.getContext());
            editText.setText(str3);
            String host = Uri.parse(str).getHost();
            AlertDialog alertDialogCreate = new AlertDialog.Builder(webView.getContext()).setTitle(KEY_FROM + host).setView(editText).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.confirm();
                }
            }).setNegativeButton(KEY_CANCEL, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.cancel();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.8
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsPromptResult.cancel();
                }
            }).create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        } catch (Throwable th) {
            TaoLog.e(TAG, th.getMessage());
            jsPromptResult.confirm();
        }
        return true;
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!WVUrlUtil.isCommonUrl(str)) {
            super.onReceivedTitle(webView, str);
            return;
        }
        TaoLog.i(TAG, "ignore default title : " + str);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        TaoLog.d(TAG, " onShowFileChooser");
        if (fileChooserParams != null && valueCallback != null) {
            this.mFilePathCallback = valueCallback;
            try {
                ((Activity) ((WVUCWebView) webView)._getContext()).startActivityForResult(Intent.createChooser(fileChooserParams.createIntent(), "choose"), 15);
                return true;
            } catch (Throwable th) {
                TaoLog.e(TAG, th.getMessage());
                th.printStackTrace();
            }
        }
        return false;
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback) {
        TaoLog.d(TAG, " openFileChooser");
        Context context = this.mContext;
        if (context == null) {
            TaoLog.e(TAG, "context is null");
            return;
        }
        try {
            a.a(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", Permission.CAMERA}).a(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.2
                @Override // java.lang.Runnable
                public void run() {
                    TaoLog.d(WVUCWebChromeClient.TAG, " openFileChooser permission granted");
                    WVUCWebChromeClient.super.openFileChooser(valueCallback);
                }
            }).b(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TaoLog.d(WVUCWebChromeClient.TAG, " openFileChooser permission denied");
                }
            }).b();
        } catch (Exception e) {
            TaoLog.e(TAG, e.getMessage());
        }
    }

    public WVUCWebChromeClient(Context context) {
        this.mContext = context;
    }
}
