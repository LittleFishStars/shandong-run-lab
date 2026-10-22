package com.huachenjie.base.interact;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.base.interact.WorksInteractEvents;
import com.huachenjie.base.interact.bean.WorksInteractBean;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huachenjie.base.interact.database.WorksInteractDatabase;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.a;
import com.huachenjie.common.reconfig.net.exception.c;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.cq;
import com.zj.adlib.dq1;
import com.zj.adlib.v41;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002R\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010!\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR#\u0010$\u001a\n \u0011*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010+¨\u0006/"}, d2 = {"Lcom/huachenjie/base/interact/WorksInteractEvents;", "", "", "q", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "eventBean", "s", "u", "", "m", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "interactJson", "w", t.d, "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "a", "Ljava/util/concurrent/ScheduledExecutorService;", "singleExecutor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasTask", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "n", "()Lcom/google/gson/Gson;", "gson", "", "I", "MAX_RETRY_NUM", "b", "retryTimes", "p", "()Ljava/lang/String;", "interactSign", "Lcom/huachenjie/base/interact/bean/WorksInteractBean;", "c", j.b, "()Lcom/huachenjie/base/interact/bean/WorksInteractBean;", "interactBean", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "uploadRunner", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class WorksInteractEvents {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int MAX_RETRY_NUM = 3;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static int retryTimes;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final WorksInteractEvents f7217a = new WorksInteractEvents();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static final ScheduledExecutorService singleExecutor = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final AtomicBoolean hasTask = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.huachenjie.base.interact.WorksInteractEvents$gson$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m224invoke() {
            return new Gson();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy interactSign = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.interact.WorksInteractEvents$interactSign$2
        public final String invoke() {
            return cq.c(ai9.e().getUserId(), "jR+UtgNv5geHQTLe7EbxU1O+T7jt+mngRKVOF4+o5ag=");
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final Lazy interactBean = LazyKt.lazy(new Function0<WorksInteractBean>() { // from class: com.huachenjie.base.interact.WorksInteractEvents$interactBean$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksInteractBean m225invoke() {
            String strP = WorksInteractEvents.f7217a.p();
            Intrinsics.checkNotNullExpressionValue(strP, "interactSign");
            return new WorksInteractBean(null, strP, 1, null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Runnable uploadRunner = new Runnable() { // from class: com.zj.adlib.m0a
        @Override // java.lang.Runnable
        public final void run() {
            WorksInteractEvents.x();
        }
    };

    public static final void r() {
        WorksInteractDatabase.a aVar = WorksInteractDatabase.f7223a;
        List<WorksInteractEventBean> listF = aVar.a().f();
        if (listF.isEmpty()) {
            hasTask.set(false);
            return;
        }
        WorksInteractEvents worksInteractEvents = f7217a;
        if (worksInteractEvents.m()) {
            aVar.a().e();
            Gson gsonN = worksInteractEvents.n();
            String strP = worksInteractEvents.p();
            List mutableList = CollectionsKt.toMutableList(listF);
            Intrinsics.checkNotNullExpressionValue(strP, "interactSign");
            v41.g((CoroutineContext) null, new WorksInteractEvents$initInteractEvents$1$1(gsonN.toJson(new WorksInteractBean(mutableList, strP)), null), 1, (Object) null);
        }
    }

    public static final void t(WorksInteractEventBean worksInteractEventBean) {
        Intrinsics.checkNotNullParameter(worksInteractEventBean, "$eventBean");
        WorksInteractEvents worksInteractEvents = f7217a;
        worksInteractEvents.l();
        worksInteractEventBean.setId(WorksInteractDatabase.f7223a.a().d(worksInteractEventBean));
        worksInteractEvents.o().getEventList().add(worksInteractEventBean);
    }

    public static final void v(WorksInteractEventBean worksInteractEventBean) {
        Intrinsics.checkNotNullParameter(worksInteractEventBean, "$eventBean");
        WorksInteractDatabase.f7223a.a().c(worksInteractEventBean);
    }

    public static final void x() {
        WorksInteractEvents worksInteractEvents = f7217a;
        if (worksInteractEvents.o().getEventList().isEmpty()) {
            hasTask.set(false);
        } else if (worksInteractEvents.m()) {
            v41.g((CoroutineContext) null, new WorksInteractEvents$uploadRunner$1$1(null), 1, (Object) null);
        }
    }

    public final void l() {
        AtomicBoolean atomicBoolean = hasTask;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        singleExecutor.schedule(uploadRunner, dq1.e().getUploadRefreshTime(), TimeUnit.SECONDS);
    }

    public final boolean m() {
        if (NetworkUtils.A()) {
            return true;
        }
        hasTask.set(false);
        l();
        return false;
    }

    public final Gson n() {
        return (Gson) gson.getValue();
    }

    @NotNull
    public final WorksInteractBean o() {
        return (WorksInteractBean) interactBean.getValue();
    }

    public final String p() {
        return (String) interactSign.getValue();
    }

    public final void q() {
        hasTask.set(true);
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.k0a
            @Override // java.lang.Runnable
            public final void run() {
                WorksInteractEvents.r();
            }
        });
    }

    public final void s(@NotNull final WorksInteractEventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.j0a
            @Override // java.lang.Runnable
            public final void run() {
                WorksInteractEvents.t(eventBean);
            }
        });
    }

    public final void u(@NotNull final WorksInteractEventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        o().getEventList().remove(eventBean);
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.l0a
            @Override // java.lang.Runnable
            public final void run() {
                WorksInteractEvents.v(eventBean);
            }
        });
    }

    public final void w(final CoroutineScope scope, final String interactJson) {
        v41.e(scope, new a(new c(false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.interact.WorksInteractEvents$updateInteractEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (WorksInteractEvents.retryTimes < 3) {
                    WorksInteractEvents.f7217a.w(scope, interactJson);
                    WorksInteractEvents.retryTimes++;
                }
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new WorksInteractEvents$updateInteractEvent$2(interactJson, null), 2, (Object) null);
    }
}
