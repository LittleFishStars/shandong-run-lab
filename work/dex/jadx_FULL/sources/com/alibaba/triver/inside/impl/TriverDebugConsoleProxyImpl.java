package com.alibaba.triver.inside.impl;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.console.RVDebugConsoleProxy;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverDebugConsoleProxyImpl implements RVDebugConsoleProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24992a = "toggle_button_visible";
    private static final String b = "68687029";

    @Override // com.alibaba.ariver.console.RVDebugConsoleProxy
    public int getConsoleToggleButtonColor(Activity activity) {
        return Color.parseColor("#ff5000");
    }

    @Override // com.alibaba.ariver.console.RVDebugConsoleProxy
    public int getDebugConsoleViewHeight(Activity activity) {
        return (DimensionUtil.getScreenHeight(activity) * 2) / 3;
    }

    @Override // com.alibaba.ariver.console.RVDebugConsoleProxy
    public boolean getToggleButtonVisible(String str) {
        return Boolean.parseBoolean(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(str, f24992a));
    }

    @Override // com.alibaba.ariver.console.RVDebugConsoleProxy
    public void initConsoleView(Activity activity, long j, final com.alibaba.ariver.console.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putLong(com.alibaba.ariver.remotedebug.b.f, j);
        RVMain.createPage(activity, b, true, bundle, null, new com.alibaba.ariver.integration.b() { // from class: com.alibaba.triver.inside.impl.TriverDebugConsoleProxyImpl.1
            @Override // com.alibaba.ariver.integration.b
            public void a(Page page) {
                if (page != null) {
                    a aVar2 = new a(page);
                    com.alibaba.ariver.console.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(aVar2);
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.console.RVDebugConsoleProxy
    public void setToggleButtonVisible(String str, boolean z) {
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(str, f24992a, String.valueOf(z));
    }
}
