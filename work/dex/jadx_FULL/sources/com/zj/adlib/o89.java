package com.zj.adlib;

import okhttp3.Interceptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class o89 implements Interceptor {
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x00a5
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) throws java.io.IOException {
        /*
            r8 = this;
            okhttp3.Request r0 = r9.request()
            boolean r1 = com.zj.adlib.ai9.l()
            if (r1 != 0) goto Lf
            okhttp3.Response r9 = r9.proceed(r0)
            return r9
        Lf:
            okhttp3.Response r9 = r9.proceed(r0)
            okhttp3.ResponseBody r0 = r9.body()
            okhttp3.MediaType r1 = r0.contentType()
            java.lang.String r0 = r0.string()     // Catch: java.lang.Exception -> La7
            java.lang.Class<huachenjie.sdk.http.BaseEntity> r2 = huachenjie.sdk.http.BaseEntity.class
            java.lang.Object r2 = com.alibaba.fastjson.JSON.parseObject(r0, r2)     // Catch: java.lang.Exception -> La5
            huachenjie.sdk.http.BaseEntity r2 = (huachenjie.sdk.http.BaseEntity) r2     // Catch: java.lang.Exception -> La5
            int r3 = r2.code     // Catch: java.lang.Exception -> La5
            r4 = 1005(0x3ed, float:1.408E-42)
            if (r3 == r4) goto L90
            r4 = 1503(0x5df, float:2.106E-42)
            java.lang.String r5 = "content"
            java.lang.String r6 = "title"
            java.lang.String r7 = "/compat/logout"
            if (r3 == r4) goto L66
            r4 = 1504(0x5e0, float:2.108E-42)
            if (r3 == r4) goto L3c
            goto Lac
        L3c:
            boolean r3 = com.zj.adlib.ai9.l()     // Catch: java.lang.Exception -> La5
            if (r3 == 0) goto Lac
            com.alibaba.android.arouter.launcher.ARouter r3 = com.alibaba.android.arouter.launcher.ARouter.getInstance()     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r3 = r3.build(r7)     // Catch: java.lang.Exception -> La5
            com.huachenjie.common.util.ActivityLifecycleManager r4 = com.huachenjie.common.util.ActivityLifecycleManager.l()     // Catch: java.lang.Exception -> La5
            android.app.Activity r4 = r4.m()     // Catch: java.lang.Exception -> La5
            int r7 = com.huachenjie.common.R.string.login_other_title     // Catch: java.lang.Exception -> La5
            java.lang.String r4 = r4.getString(r7)     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r3 = r3.withString(r6, r4)     // Catch: java.lang.Exception -> La5
            java.lang.String r2 = r2.message     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r2 = r3.withString(r5, r2)     // Catch: java.lang.Exception -> La5
            r2.navigation()     // Catch: java.lang.Exception -> La5
            goto Lac
        L66:
            boolean r3 = com.zj.adlib.ai9.l()     // Catch: java.lang.Exception -> La5
            if (r3 == 0) goto Lac
            com.alibaba.android.arouter.launcher.ARouter r3 = com.alibaba.android.arouter.launcher.ARouter.getInstance()     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r3 = r3.build(r7)     // Catch: java.lang.Exception -> La5
            com.huachenjie.common.util.ActivityLifecycleManager r4 = com.huachenjie.common.util.ActivityLifecycleManager.l()     // Catch: java.lang.Exception -> La5
            android.app.Activity r4 = r4.m()     // Catch: java.lang.Exception -> La5
            int r7 = com.huachenjie.common.R.string.token_expired_title     // Catch: java.lang.Exception -> La5
            java.lang.String r4 = r4.getString(r7)     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r3 = r3.withString(r6, r4)     // Catch: java.lang.Exception -> La5
            java.lang.String r2 = r2.message     // Catch: java.lang.Exception -> La5
            com.alibaba.android.arouter.facade.Postcard r2 = r3.withString(r5, r2)     // Catch: java.lang.Exception -> La5
            r2.navigation()     // Catch: java.lang.Exception -> La5
            goto Lac
        L90:
            com.alibaba.android.arouter.launcher.ARouter r2 = com.alibaba.android.arouter.launcher.ARouter.getInstance()     // Catch: java.lang.Exception -> La5
            java.lang.String r3 = "/common/upgrade"
            com.alibaba.android.arouter.facade.Postcard r2 = r2.build(r3)     // Catch: java.lang.Exception -> La5
            java.lang.String r3 = "requestUpgradeInfo"
            r4 = 1
            com.alibaba.android.arouter.facade.Postcard r2 = r2.withBoolean(r3, r4)     // Catch: java.lang.Exception -> La5
            r2.navigation()     // Catch: java.lang.Exception -> La5
            goto Lac
        La5:
            r2 = move-exception
            goto La9
        La7:
            r2 = move-exception
            r0 = 0
        La9:
            r2.printStackTrace()
        Lac:
            okhttp3.ResponseBody r0 = okhttp3.ResponseBody.create(r1, r0)     // Catch: java.lang.Exception -> Lbd
            okhttp3.Response$Builder r1 = r9.newBuilder()     // Catch: java.lang.Exception -> Lbd
            okhttp3.Response$Builder r0 = r1.body(r0)     // Catch: java.lang.Exception -> Lbd
            okhttp3.Response r9 = r0.build()     // Catch: java.lang.Exception -> Lbd
            return r9
        Lbd:
            r0 = move-exception
            r0.printStackTrace()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zj.adlib.o89.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
