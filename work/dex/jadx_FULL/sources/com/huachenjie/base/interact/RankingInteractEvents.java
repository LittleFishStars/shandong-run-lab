package com.huachenjie.base.interact;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.blankj.utilcode.util.NetworkUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.base.interact.RankingInteractEvents;
import com.huachenjie.base.interact.bean.WorksInteractBean;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huachenjie.base.interact.database.WorksInteractDatabase;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.a;
import com.huachenjie.common.reconfig.net.exception.c;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.cq;
import com.zj.adlib.dq1;
import com.zj.adlib.v41;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b1\u00102J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u001b\u0010(\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010/¨\u00063"}, d2 = {"Lcom/huachenjie/base/interact/RankingInteractEvents;", "", "", "r", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "eventBean", "t", "v", "", "n", "", GoodsSpecificationPreviewActivity.z, "", "", "x", "Lkotlinx/coroutines/CoroutineScope;", "scope", "interactJson", "y", "m", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "a", "Ljava/util/concurrent/ScheduledExecutorService;", "singleExecutor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasTask", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", j.b, "()Lcom/google/gson/Gson;", "gson", "", "I", "MAX_RETRY_NUM", "b", "retryTimes", "q", "()Ljava/lang/String;", "signUserId", "Lcom/huachenjie/base/interact/bean/WorksInteractBean;", "c", "p", "()Lcom/huachenjie/base/interact/bean/WorksInteractBean;", "interactBean", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "uploadRunner", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRankingInteractEvents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RankingInteractEvents.kt\ncom/huachenjie/base/interact/RankingInteractEvents\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,196:1\n1855#2,2:197\n*S KotlinDebug\n*F\n+ 1 RankingInteractEvents.kt\ncom/huachenjie/base/interact/RankingInteractEvents\n*L\n135#1:197,2\n*E\n"})
public final class RankingInteractEvents {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int MAX_RETRY_NUM = 3;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static int retryTimes;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final RankingInteractEvents f7211a = new RankingInteractEvents();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static final ScheduledExecutorService singleExecutor = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final AtomicBoolean hasTask = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.huachenjie.base.interact.RankingInteractEvents$gson$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m221invoke() {
            return new Gson();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy signUserId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.interact.RankingInteractEvents$signUserId$2
        @NotNull
        public final String invoke() {
            return ai9.e().getUserId();
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final Lazy interactBean = LazyKt.lazy(new Function0<WorksInteractBean>() { // from class: com.huachenjie.base.interact.RankingInteractEvents$interactBean$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksInteractBean m222invoke() {
            return new WorksInteractBean(null, "", 1, null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Runnable uploadRunner = new Runnable() { // from class: com.zj.adlib.qa7
        @Override // java.lang.Runnable
        public final void run() {
            RankingInteractEvents.z();
        }
    };

    public static final void s() {
        WorksInteractDatabase.a aVar = WorksInteractDatabase.f7223a;
        List<WorksInteractEventBean> listB = aVar.a().b();
        if (listB.isEmpty()) {
            hasTask.set(false);
            return;
        }
        RankingInteractEvents rankingInteractEvents = f7211a;
        if (rankingInteractEvents.n()) {
            aVar.a().a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("signTimestamp", Long.valueOf(System.currentTimeMillis()));
            String strC = cq.c(rankingInteractEvents.q() + '|' + linkedHashMap.get("signTimestamp"), "YfYxpXfhBqSMpkn5x523TtPEydcS8JznrAnY5nRNSTA=");
            Intrinsics.checkNotNullExpressionValue(strC, "encrypt(\"${signUserId}|$…fig.RANKING_INTERACT_KEY)");
            linkedHashMap.put(UserTrackConstant.SIGN, strC);
            linkedHashMap.put("eventList", rankingInteractEvents.x(listB));
            v41.g((CoroutineContext) null, new RankingInteractEvents$initInteractEvents$1$1(rankingInteractEvents.o().toJson(linkedHashMap), null), 1, (Object) null);
        }
    }

    public static final void u(WorksInteractEventBean worksInteractEventBean) {
        Intrinsics.checkNotNullParameter(worksInteractEventBean, "$eventBean");
        RankingInteractEvents rankingInteractEvents = f7211a;
        rankingInteractEvents.m();
        worksInteractEventBean.setId(WorksInteractDatabase.f7223a.a().d(worksInteractEventBean));
        rankingInteractEvents.p().getEventList().add(worksInteractEventBean);
    }

    public static final void w(WorksInteractEventBean worksInteractEventBean) {
        Intrinsics.checkNotNullParameter(worksInteractEventBean, "$eventBean");
        WorksInteractDatabase.f7223a.a().c(worksInteractEventBean);
    }

    public static final void z() {
        RankingInteractEvents rankingInteractEvents = f7211a;
        if (rankingInteractEvents.p().getEventList().isEmpty()) {
            hasTask.set(false);
        } else if (rankingInteractEvents.n()) {
            v41.g((CoroutineContext) null, new RankingInteractEvents$uploadRunner$1$1(null), 1, (Object) null);
        }
    }

    public final void m() {
        AtomicBoolean atomicBoolean = hasTask;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        singleExecutor.schedule(uploadRunner, dq1.e().getUploadRefreshTime(), TimeUnit.SECONDS);
    }

    public final boolean n() {
        if (NetworkUtils.A()) {
            return true;
        }
        hasTask.set(false);
        m();
        return false;
    }

    public final Gson o() {
        return (Gson) gson.getValue();
    }

    @NotNull
    public final WorksInteractBean p() {
        return (WorksInteractBean) interactBean.getValue();
    }

    public final String q() {
        return (String) signUserId.getValue();
    }

    public final void r() {
        hasTask.set(true);
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.ra7
            @Override // java.lang.Runnable
            public final void run() {
                RankingInteractEvents.s();
            }
        });
    }

    public final void t(@NotNull final WorksInteractEventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.pa7
            @Override // java.lang.Runnable
            public final void run() {
                RankingInteractEvents.u(eventBean);
            }
        });
    }

    public final void v(@NotNull final WorksInteractEventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        p().getEventList().remove(eventBean);
        singleExecutor.submit(new Runnable() { // from class: com.zj.adlib.sa7
            @Override // java.lang.Runnable
            public final void run() {
                RankingInteractEvents.w(eventBean);
            }
        });
    }

    public final List<Map<String, Object>> x(List<WorksInteractEventBean> list) {
        ArrayList arrayList = new ArrayList();
        for (WorksInteractEventBean worksInteractEventBean : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String bizNo = worksInteractEventBean.getBizNo();
            if (bizNo == null) {
                bizNo = "";
            }
            linkedHashMap.put("likedUserNo", bizNo);
            linkedHashMap.put("status", Integer.valueOf(worksInteractEventBean.getEventType()));
            linkedHashMap.put("type", Integer.valueOf(worksInteractEventBean.getBizType() * (-1)));
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public final void y(final CoroutineScope scope, final String interactJson) {
        v41.e(scope, new a(new c(false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.interact.RankingInteractEvents$updateInteractEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (RankingInteractEvents.retryTimes < 3) {
                    RankingInteractEvents.f7211a.y(scope, interactJson);
                    RankingInteractEvents.retryTimes++;
                }
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new RankingInteractEvents$updateInteractEvent$2(interactJson, null), 2, (Object) null);
    }
}
