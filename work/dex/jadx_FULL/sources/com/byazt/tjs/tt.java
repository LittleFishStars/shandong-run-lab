package com.byazt.tjs;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1209, 13})
public class tt {
    public Uri c;
    public String tt;
    public Map<String, String> ve;

    public tt(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.c = webResourceRequest.getUrl();
            this.tt = webResourceRequest.getMethod();
            this.ve = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = Uri.parse(str);
        this.tt = "GET";
    }

    public Uri c() {
        return this.c;
    }

    public String tt() {
        return this.tt;
    }

    public Map<String, String> ve() {
        return this.ve;
    }
}
