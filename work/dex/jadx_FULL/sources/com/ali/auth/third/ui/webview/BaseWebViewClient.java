package com.ali.auth.third.ui.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.ui.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BaseWebViewClient extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected WeakReference<Activity> f23542a;
    protected boolean b = true;
    protected boolean c = false;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f23543a;

        public a(SslErrorHandler sslErrorHandler) {
            this.f23543a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23543a.proceed();
            BaseWebViewClient.this.c = true;
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f23544a;

        public b(SslErrorHandler sslErrorHandler) {
            this.f23544a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23544a.cancel();
            BaseWebViewClient.this.c = false;
        }
    }

    public BaseWebViewClient(Activity activity) {
        this.f23542a = new WeakReference<>(activity);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f23542a.get();
        if (!this.b) {
            if (this.c) {
                sslErrorHandler.proceed();
                return;
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                return;
            }
        }
        String string = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_title);
        String string2 = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_info);
        String string3 = webView.getContext().getResources().getString(R.string.aliuser_common_ok);
        a aVar = new a(sslErrorHandler);
        String string4 = webView.getContext().getResources().getString(R.string.aliuser_cancel);
        b bVar = new b(sslErrorHandler);
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setPositiveButton(string3, aVar);
        builder.setNeutralButton(string4, bVar);
        try {
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(string);
            alertDialogCreate.setMessage(string2);
            alertDialogCreate.show();
            this.b = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
