package com.huachenjie.common.arouter;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.zj.adlib.ai9;
import com.zj.adlib.qx6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Interceptor(name = "跳转页面需要认证拦截器", priority = 9)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/arouter/AuthInterceptor;", "Lcom/alibaba/android/arouter/facade/template/IInterceptor;", "()V", "init", "", "context", "Landroid/content/Context;", "process", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", RenderCallContext.TYPE_CALLBACK, "Lcom/alibaba/android/arouter/facade/callback/InterceptorCallback;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthInterceptor implements IInterceptor {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@Nullable Context context) {
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(@Nullable Postcard postcard, @Nullable InterceptorCallback callback) {
        qx6.f44321a.a(postcard);
        Integer numValueOf = postcard != null ? Integer.valueOf(postcard.getExtra() & 1) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= 0) {
            if (callback != null) {
                callback.onContinue(postcard);
                return;
            }
            return;
        }
        postcard.setTimeout(2);
        if (!ai9.m()) {
            ARouter.getInstance().build(RoutePathConstants.Common.b).greenChannel().navigation(ActivityLifecycleManager.l().m());
        } else if (callback != null) {
            callback.onContinue(postcard);
        }
    }
}
