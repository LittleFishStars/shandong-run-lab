package com.alibaba.alibcwebview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcH5Interceptor implements AlibcInterceptCenter.IUrlInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23700a = "AlibcH5Interceptor";

    @Override // com.alibaba.alibcprotocol.manager.AlibcInterceptCenter.IUrlInterceptor
    public boolean interceptor(RouteRequest routeRequest, Bundle bundle) {
        AlibcTradeContext alibcTradeContext;
        WeakReference<Activity> weakReference;
        WeakReference<WebView> weakReference2;
        String string;
        if (routeRequest != null && (weakReference = (alibcTradeContext = AlibcTradeContext.getInstance()).mActivity) != null && weakReference.get() != null && (weakReference2 = alibcTradeContext.mWebView) != null && weakReference2.get() != null) {
            Map<String, String> map = alibcTradeContext.trackParams;
            a aVar = new a(routeRequest.getRawUrl());
            if (map == null || map.size() <= 0) {
                string = aVar.c;
            } else {
                Map map2 = aVar.f23701a;
                if (map2 == null) {
                    map2 = new HashMap(16);
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue()) && !map2.containsKey(entry.getKey())) {
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(entry.getValue());
                        map2.put(entry.getKey(), arrayList);
                    }
                }
                int iIndexOf = aVar.c.indexOf("?");
                StringBuilder sb = new StringBuilder();
                if (-1 != iIndexOf) {
                    sb.append(aVar.c.substring(0, iIndexOf));
                } else {
                    int iIndexOf2 = aVar.c.indexOf("#");
                    if (-1 != iIndexOf2) {
                        sb.append(aVar.c.subSequence(0, iIndexOf2));
                    } else {
                        sb.append(aVar.c);
                    }
                }
                String strA = a.a(map2);
                if (strA != null) {
                    sb.append("?");
                    sb.append(strA);
                }
                if (aVar.b != null) {
                    sb.append("#");
                    sb.append(aVar.b);
                }
                string = sb.toString();
            }
            if (!TextUtils.isEmpty(string) && !string.equals(routeRequest.getRawUrl())) {
                String pageType = routeRequest.getPageType();
                if ("h5".equals(pageType)) {
                    AlibcContainerManager.loadUrl(pageType, routeRequest.getRawUrl(), bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
                    AlibcLogger.i(f23700a, "reload url: " + routeRequest.getRawUrl());
                    return true;
                }
            }
        }
        return false;
    }
}
