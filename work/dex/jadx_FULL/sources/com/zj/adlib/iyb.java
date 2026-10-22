package com.zj.adlib;

import android.webkit.WebView;
import cn.hzjizhun.admin.base.utils.WebviewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class iyb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f42467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tzb f17299a;

    public iyb(tzb tzbVar, WebView webView) {
        this.f17299a = tzbVar;
        this.f42467a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebviewHelper.injectMIDIBlockerJS(this.f42467a);
        this.f17299a.f45035a.a("var tag = document.querySelector('video, audio');if(tag){tag.muted = true;   tag.addEventListener('play',function(){       tag.pause();       window.location = 'about:blank';   });var Audio = {};tag.setAttribute('webkit-playsinline',true);}");
    }
}
