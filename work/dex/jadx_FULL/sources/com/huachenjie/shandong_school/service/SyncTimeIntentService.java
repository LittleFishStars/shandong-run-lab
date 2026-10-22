package com.huachenjie.shandong_school.service;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import androidx.core.app.MyJobIntentService;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.gq1;
import com.zj.adlib.lo7;
import com.zj.adlib.n76;
import com.zj.adlib.r90;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/shandong_school/service/SyncTimeIntentService;", "Landroidx/core/app/MyJobIntentService;", "Landroid/content/Intent;", "intent", "", "onHandleWork", "a", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class SyncTimeIntentService extends MyJobIntentService {
    public static final int K = 1000;
    public static final int L = 1002;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.service.SyncTimeIntentService$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/shandong_school/service/SyncTimeIntentService$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "work", "", "a", "", "JOB_ID", "I", "MAX_ALLOW_TIME_OFFSET", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent work) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(work, "work");
            JobIntentService.enqueueWork(context, (Class<?>) SyncTimeIntentService.class, 1002, work);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/shandong_school/service/SyncTimeIntentService$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<JSONObject> {
        public b() {
            super(false);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data == null || !data.containsKey("reduceTimes")) {
                return;
            }
            long longValue = data.getLongValue("reduceTimes");
            if (longValue > 1000) {
                r90.i0(longValue);
            } else {
                r90.i0(0L);
            }
            lo7.e().g().n().a = r90.D();
        }
    }

    public final void a() {
        n76.d(new gq1().C()).i(new b());
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        a();
    }
}
