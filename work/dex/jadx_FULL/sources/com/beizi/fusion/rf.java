package com.beizi.fusion;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.beizi.fusion.model.RequestInfo;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rf {
    private static rf b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27722a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s4 f27723a;
        private int b;

        /* JADX INFO: renamed from: com.beizi.fusion.rf$a$a, reason: collision with other inner class name */
        public class HandlerC0321a extends s4 {
            final /* synthetic */ Context b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0321a(Context context, Context context2) {
                super(context);
                this.b = context2;
            }

            @Override // com.beizi.fusion.s4
            public void a(Message message) {
                Context contextA;
                if (message == null) {
                    return;
                }
                try {
                    if (message.what == a.this.b && (contextA = a()) != null) {
                        if (System.currentTimeMillis() - co.a(this.b, "updateUserAgentTime") < 172800000) {
                            return;
                        }
                        WebView webView = new WebView(contextA);
                        WebView.setWebContentsDebuggingEnabled(false);
                        webView.getSettings().setSavePassword(false);
                        String userAgentString = webView.getSettings().getUserAgentString();
                        RequestInfo.getInstance(contextA).updateUserAgent(userAgentString);
                        s3.e(userAgentString);
                        co.a(contextA, TRiverConstants.KEY_ENVIRONMENT_USERAGENT, userAgentString);
                        co.a(contextA, "updateUserAgentTime", Long.valueOf(System.currentTimeMillis()));
                    }
                } catch (Exception unused) {
                }
            }
        }

        private a(Context context) {
            this.b = 100100;
            this.f27723a = new HandlerC0321a(context, context);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27723a == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = this.b;
            this.f27723a.sendMessage(messageObtain);
        }
    }

    public static synchronized rf a() {
        if (b == null) {
            synchronized (rf.class) {
                b = new rf();
            }
        }
        return b;
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(this.f27722a)) {
            this.f27722a = co.b(context, TRiverConstants.KEY_ENVIRONMENT_USERAGENT);
        }
        try {
            if (TextUtils.isEmpty(this.f27722a)) {
                this.f27722a = WebSettings.getDefaultUserAgent(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f27722a;
    }

    public void a(Context context) {
        if (TextUtils.isEmpty(this.f27722a)) {
            Executors.newSingleThreadScheduledExecutor().schedule(new a(context), 15000L, TimeUnit.MILLISECONDS);
        }
    }

    public void a(String str) {
        this.f27722a = str;
    }
}
