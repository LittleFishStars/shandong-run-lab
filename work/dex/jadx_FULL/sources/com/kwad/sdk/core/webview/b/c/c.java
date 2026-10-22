package com.kwad.sdk.core.webview.b.c;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    private static final List<String> bcW;

    static {
        ArrayList arrayList = new ArrayList();
        bcW = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add("image/png");
        arrayList.add(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add(ze1.g);
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    }

    public static boolean fU(String str) {
        return bcW.contains(str);
    }
}
