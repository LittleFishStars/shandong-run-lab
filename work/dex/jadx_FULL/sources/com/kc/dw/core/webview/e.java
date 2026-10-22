package com.kc.dw.core.webview;

import android.text.TextUtils;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f39438a = new ConcurrentHashMap<>();
    public final List<String> b = Collections.synchronizedList(new ArrayList());
    public String c;
    public volatile com.kc.dw.core.webview.listener.c d;

    public e(String str) {
        this.c = str;
    }

    public int a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !this.f39438a.containsKey(str)) {
                return -1;
            }
            return this.f39438a.get(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void a(com.kc.dw.core.webview.listener.a aVar) {
        if (aVar instanceof com.kc.dw.core.webview.listener.c) {
            this.d = (com.kc.dw.core.webview.listener.c) aVar;
        }
    }

    public void a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && a(str) == -1) {
                LogUtil.dev("H5LoadSate", "recordErrorUrl:" + str);
                this.f39438a.put(str, Integer.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
