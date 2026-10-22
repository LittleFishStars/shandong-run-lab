package com.beizi.fusion;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class qp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27701a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static qp f27702a = new qp();
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final iq f27703a;

        private c(Context context) {
            this.f27703a = new b(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.f27703a.sendMessage(messageObtain);
        }
    }

    private qp() {
        if (a.f27702a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static qp a() {
        return a.f27702a;
    }

    public String b(Context context) {
        if (!TextUtils.isEmpty(this.f27701a)) {
            return this.f27701a;
        }
        String strA = r5.a(context, r5.a("v2"), "UA_CIP", "");
        return !TextUtils.isEmpty(strA) ? f3.b(strA) : "";
    }

    public void a(String str) {
        this.f27701a = str;
    }

    public static class b extends iq {
        public b(Context context) {
            super(context);
        }

        private WebView a(Context context) {
            WebView webView = new WebView(context);
            WebView.setWebContentsDebuggingEnabled(false);
            webView.getSettings().setSavePassword(false);
            return webView;
        }

        @Override // com.beizi.fusion.iq
        public void a(Message message) {
            Context contextA;
            if (message == null || message.what != 1 || (contextA = a()) == null || l6.a(r5.a(contextA, r5.a("v2"), "UA_LAST", 0L), 2)) {
                return;
            }
            String userAgentString = a(contextA).getSettings().getUserAgentString();
            if (TextUtils.isEmpty(userAgentString)) {
                return;
            }
            r5.b(contextA, r5.a("v2"), "UA_CIP", f3.c(userAgentString));
            r5.b(contextA, r5.a("v2"), "UA_LAST", System.currentTimeMillis());
        }
    }

    public void a(Context context) {
        fb fbVar = (fb) cn.a().b(context);
        if (fbVar != null) {
            fbVar.a(new c(context), 5L, TimeUnit.SECONDS);
        }
    }
}
