package com.kc.dw.core.webview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kc.dw.core.utils.LogUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k extends WebViewClient {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39443a;
    public HashMap<String, Integer> b = new HashMap<>();
    public volatile boolean c = false;

    public k(Context context) {
        this.f39443a = context;
    }

    public void a(WebView webView) {
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            Context context = webView.getContext();
            if (context instanceof Activity) {
                View viewFindViewById = ((Activity) context).findViewById(R.id.ms_webivew_loading);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
            } else {
                LogUtil.e("WebViewClient", "context is`not activity");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean a(Intent intent) {
        if (intent.resolveActivity(this.f39443a.getPackageManager()) != null) {
            intent.setFlags(268435456);
            ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(this.f39443a.getPackageManager(), 65536);
            if (activityInfoResolveActivityInfo != null && activityInfoResolveActivityInfo.exported) {
                intent.setFlags(intent.getFlags() & (-196));
                HashSet hashSet = new HashSet();
                hashSet.add("android.intent.action.CHOOSER");
                hashSet.add("android.intent.action.SEND");
                hashSet.add("android.intent.action.SEND_MULTIPLE");
                hashSet.add("android.media.action.IMAGE_CAPTURE");
                hashSet.add("android.media.action.IMAGE_CAPTURE_SECURE");
                hashSet.add("android.media.action.VIDEO_CAPTURE");
                if (hashSet.contains(intent.getAction())) {
                    return false;
                }
                this.f39443a.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        a(webView);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ComponentName callingActivity;
        if (str.startsWith("http")) {
            return false;
        }
        try {
            String scheme = Uri.parse(str).getScheme();
            HashMap<String, Integer> map = com.kc.dw.core.utils.b.f39349a;
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (scheme != null && scheme.equals(str2)) {
                        if (this.b.containsKey(str2)) {
                            Integer num = this.b.get(str2);
                            if (num != null) {
                                this.b.put(str2, Integer.valueOf(num.intValue() + 1));
                            }
                        } else {
                            this.b.put(str2, 0);
                        }
                        Integer num2 = com.kc.dw.core.utils.b.f39349a.get(str2);
                        Integer num3 = this.b.get(str2);
                        if (num2 != null && num3 != null && num3.intValue() < num2.intValue()) {
                        }
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            Context context = this.f39443a;
            if ((context instanceof Activity) && ((callingActivity = ((Activity) context).getCallingActivity()) == null || this.f39443a.getPackageName().equalsIgnoreCase(callingActivity.getPackageName()))) {
                a(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
