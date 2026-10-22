package com.ali.auth.third.ui.context;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.auth.third.core.context.KernelContext;
import com.zj.adlib.o61;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f23523a;
    public int b;

    /* JADX INFO: renamed from: com.ali.auth.third.ui.context.a$a, reason: collision with other inner class name */
    public class RunnableC0125a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23524a;

        public RunnableC0125a(String str) {
            this.f23524a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(TextUtils.isEmpty(this.f23524a) ? String.format("javascript:window.HavanaBridge.onSuccess(%s);", Integer.valueOf(a.this.b)) : String.format("javascript:window.HavanaBridge.onSuccess(%s,'%s');", Integer.valueOf(a.this.b), a.e(this.f23524a)));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23525a;

        public b(String str) {
            this.f23525a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(TextUtils.isEmpty(this.f23525a) ? String.format("javascript:window.HavanaBridge.onFailure(%s,'');", Integer.valueOf(a.this.b)) : String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", Integer.valueOf(a.this.b), a.e(this.f23525a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        WebView webView = this.f23523a;
        if (webView == null) {
            return;
        }
        webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        return str.replace(o61.h, "\\\\");
    }

    public Activity a() {
        return (Activity) this.f23523a.getContext();
    }

    public void a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            a(jSONObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void a(String str) {
        KernelContext.executorService.postUITask(new b(str));
    }

    public void b(String str) {
        KernelContext.executorService.postUITask(new RunnableC0125a(str));
    }
}
