package com.huachenjie.common.webview;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bumptech.glide.Glide;
import com.zj.adlib.fv5;
import com.zj.adlib.ov5;
import com.zj.adlib.p59;
import com.zj.adlib.wf3;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class MyWebView extends WebView {
    public MyWebView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(WebView.HitTestResult hitTestResult, DialogInterface dialogInterface, int i) {
        l(hitTestResult.getExtra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i(View view) {
        final WebView.HitTestResult hitTestResult = getHitTestResult();
        if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
            return false;
        }
        new AlertDialog.Builder(getContext()).setItems(new String[]{"保存图片"}, new DialogInterface.OnClickListener() { // from class: com.zj.adlib.iv5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f17286a.h(hitTestResult, dialogInterface, i);
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, String str2, String str3, String str4, long j) {
        e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str) {
        try {
            File file = Glide.with(getContext()).asFile().load(str).submit().get();
            if (file != null && file.exists()) {
                if (wf3.n(file.getPath(), getContext())) {
                    fv5.b("保存成功");
                } else {
                    fv5.b("保存失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void e(String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(url));
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.jv5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f42680a.i(view);
            }
        });
    }

    public final void g() {
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        removeJavascriptInterface("searchBoxJavaBridge_");
        getSettings().setMixedContentMode(2);
        getSettings().setCacheMode(-1);
        getSettings().setGeolocationEnabled(true);
        getSettings().setGeolocationDatabasePath(getContext().getFilesDir().getPath());
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowContentAccess(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setSaveFormData(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        setSupportZoom(false);
        setWebViewClient(new ov5());
        setDownloadListener(new DownloadListener() { // from class: com.zj.adlib.kv5
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                this.f42918a.j(str, str2, str3, str4, j);
            }
        });
        f();
    }

    public final void l(final String pic) {
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.lv5
            @Override // java.lang.Runnable
            public final void run() {
                this.f43165a.k(pic);
            }
        });
    }

    public void setAllowFileAccess(boolean allow) {
        getSettings().setAllowFileAccess(allow);
        getSettings().setAllowFileAccessFromFileURLs(allow);
        getSettings().setAllowUniversalAccessFromFileURLs(allow);
    }

    public void setSupportZoom(boolean support) {
        WebSettings settings = getSettings();
        settings.setSupportZoom(support);
        if (support) {
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
        }
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.webViewStyle);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        g();
    }
}
