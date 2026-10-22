package com.alibaba.triver.open.impl;

import android.taobao.windvane.b.b;
import android.taobao.windvane.b.g;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.engine.d;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends d {
    public a(String str, Node node) {
        super(str, node);
    }

    @Override // com.alibaba.triver.engine.d, com.alibaba.ariver.engine.BaseEngineImpl, com.alibaba.ariver.engine.api.RVEngine
    public void init(InitParams initParams, final EngineInitCallback engineInitCallback) {
        super.init(initParams, new EngineInitCallback() { // from class: com.alibaba.triver.open.impl.a.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback
            public void initResult(boolean z, @Nullable String str) {
                if (z) {
                    engineInitCallback.initResult(true, str);
                    return;
                }
                try {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    g.a().a(new b() { // from class: com.alibaba.triver.open.impl.a.1.1
                        @Override // android.taobao.windvane.b.b
                        public void a() {
                            super.a();
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await(TROrangeController.waitUCInitTime() * 6, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        RVLogger.w(Log.getStackTraceString(e));
                    }
                    if (WVUCWebView.getUCSDKSupport()) {
                        engineInitCallback.initResult(true, "init uc");
                    } else {
                        engineInitCallback.initResult(false, "init failed 4G timeout");
                    }
                } catch (Throwable th) {
                    engineInitCallback.initResult(false, "init failed on exception" + th.getLocalizedMessage());
                    RVLogger.w(Log.getStackTraceString(th));
                }
            }
        });
    }
}
