package com.czhj.sdk.common.network;

import com.czhj.volley.toolbox.HurlStack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29416a = "mp_tmpl_advertising_id";
    private static final String b = "mp_tmpl_do_not_track";

    @Override // com.czhj.volley.toolbox.HurlStack.UrlRewriter
    public String rewriteUrl(String str) {
        if (!str.contains(f29416a)) {
            str.contains(b);
        }
        return str;
    }
}
