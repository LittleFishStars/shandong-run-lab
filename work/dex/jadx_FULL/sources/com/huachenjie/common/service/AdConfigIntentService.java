package com.huachenjie.common.service;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import androidx.core.app.MyJobIntentService;
import com.huachenjie.common.bean.AdConfig;
import com.huachenjie.common.bean.AdPositionConfig;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.r90;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/service/AdConfigIntentService;", "Landroidx/core/app/MyJobIntentService;", "Landroid/content/Intent;", "intent", "", "onHandleWork", "a", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class AdConfigIntentService extends MyJobIntentService {
    public static final int K = 1006;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.common.service.AdConfigIntentService$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/service/AdConfigIntentService$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "work", "", "a", "", "JOB_ID", "I", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent work) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(work, "work");
            JobIntentService.enqueueWork(context, (Class<?>) AdConfigIntentService.class, 1006, work);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/common/service/AdConfigIntentService$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/AdConfig;", "data", "", "onCCSuccess", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<AdConfig> {
        public b() {
            super(false);
        }

        public void onCCSuccess(@Nullable AdConfig data) {
            if (data != null) {
                r90.H(data.getCompliance());
                r90.K(data.getAdInfoList());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/common/service/AdConfigIntentService$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/AdPositionConfig;", "data", "", "onCCSuccess", "common_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAdConfigIntentService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdConfigIntentService.kt\ncom/huachenjie/common/service/AdConfigIntentService$queryAdPositionConfig$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
    public static final class c extends BizSubscriber<AdPositionConfig> {
        public c() {
            super(false);
        }

        public void onCCSuccess(@Nullable AdPositionConfig data) {
            if (data != null) {
                r90.I(data);
            }
        }
    }

    public final void a() {
        n76.d(new gq1().g()).i(new b());
    }

    public final void b() {
        n76.d(new gq1().x()).i(new c());
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        a();
        b();
    }
}
