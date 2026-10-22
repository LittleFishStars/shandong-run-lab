package com.zj.adlib;

import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.CommonSwitchConfig;
import huachenjie.sdk.http.BaseEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observer;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/dq1;", "", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "e", "", "c", "d", "Lkotlin/Function0;", "onConfigCallback", "f", "a", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "mConfig", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class dq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public static CommonSwitchConfig mConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final dq1 f16058a = new dq1();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/dq1$a", "Lrx/Observer;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "", "e", "", TriverEmbedVideoView.b, "onCompleted", "data", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Observer<BaseEntity<CommonSwitchConfig>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f41251a;

        public a(Function0<Unit> function0) {
            this.f41251a = function0;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@Nullable BaseEntity<CommonSwitchConfig> data) {
            CommonSwitchConfig commonSwitchConfig;
            if (data == null || (commonSwitchConfig = (CommonSwitchConfig) data.data) == null) {
                return;
            }
            Function0<Unit> function0 = this.f41251a;
            dq1 dq1Var = dq1.f16058a;
            dq1.mConfig = commonSwitchConfig;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public void onCompleted() {
        }

        public void onError(@NotNull Throwable e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    @JvmStatic
    public static final void c() {
        mConfig = null;
    }

    @JvmStatic
    @Nullable
    public static final CommonSwitchConfig d() {
        return mConfig;
    }

    @JvmStatic
    @NotNull
    public static final CommonSwitchConfig e() {
        CommonSwitchConfig commonSwitchConfig = mConfig;
        return commonSwitchConfig == null ? new CommonSwitchConfig(null, 0L, false, null, false, false, false, false, null, null, false, 0, 4095, null) : commonSwitchConfig;
    }

    @JvmStatic
    public static final void f(@Nullable Function0<Unit> onConfigCallback) {
        if (mConfig != null) {
            return;
        }
        final a aVar = new a(onConfigCallback);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.cq1
            @Override // java.lang.Runnable
            public final void run() {
                dq1.h(aVar);
            }
        });
    }

    public static /* synthetic */ void g(Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        f(function0);
    }

    public static final void h(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        new BaseModel().c().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }
}
