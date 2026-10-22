package com.zj.adlib;

import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.WorksConfig;
import huachenjie.sdk.http.BaseEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observer;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/zj/adlib/e0a;", "", "Lcom/huachenjie/base/bean/WorksConfig;", "d", "", "c", "e", "a", "Lcom/huachenjie/base/bean/WorksConfig;", "mConfig", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class e0a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public static WorksConfig mConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final e0a f16169a = new e0a();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/e0a$a", "Lrx/Observer;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/base/bean/WorksConfig;", "", "e", "", TriverEmbedVideoView.b, "onCompleted", "data", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Observer<BaseEntity<WorksConfig>> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@Nullable BaseEntity<WorksConfig> data) {
            WorksConfig worksConfig;
            if (data == null || (worksConfig = (WorksConfig) data.data) == null) {
                return;
            }
            e0a e0aVar = e0a.f16169a;
            e0a.mConfig = worksConfig;
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
    @NotNull
    public static final WorksConfig d() {
        WorksConfig worksConfig = mConfig;
        return worksConfig == null ? new WorksConfig(false, 0, false, 7, null) : worksConfig;
    }

    public static final void f(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        new BaseModel().a().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public final void e() {
        if (mConfig != null) {
            return;
        }
        final a aVar = new a();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.d0a
            @Override // java.lang.Runnable
            public final void run() {
                e0a.f(aVar);
            }
        });
    }
}
