package com.alibaba.triver.point;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverAnalyticsPoint extends Extension {
    boolean onStart(Context context, Bundle bundle);

    void onStartSuccess(Context context, Bundle bundle);

    void showPrefetchActivity(Context context, Node node);
}
