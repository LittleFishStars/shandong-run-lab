package com.alibaba.alibctriver.extensions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.triver.point.TriverLifecyclePoint;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BcLifeCycleExtension implements TriverLifecyclePoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23679a = "BcLifeCycleExtension";
    private Context b;
    private AtomicInteger c = new AtomicInteger(0);

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onCreate() {
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onDestroy(String str, String str2, Bundle bundle) {
        AlibcLogger.i(f23679a, "execute onDestroy");
        this.c.getAndDecrement();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onMoveBackground(String str, String str2, Bundle bundle) {
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onMoveForeground(String str, String str2, Bundle bundle) {
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onPause(String str, String str2, Bundle bundle) {
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onResume(String str, String str2, Bundle bundle) {
        AlibcLogger.i(f23679a, "TriverMainActivity onResume");
        if (this.c.get() <= 0 && this.b != null) {
            this.c.getAndIncrement();
            Context context = this.b;
            AlibcProtocolUtils.executePreLaunch(context, context.getPackageName(), System.currentTimeMillis());
        }
    }

    @Override // com.alibaba.triver.point.TriverLifecyclePoint
    public void onStartApp(Context context, Uri uri, Bundle bundle) {
        AlibcLogger.i(f23679a, "execute onStartApp");
        this.b = context;
    }
}
