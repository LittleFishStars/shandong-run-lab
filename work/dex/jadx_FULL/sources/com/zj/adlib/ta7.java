package com.zj.adlib;

import com.huachenjie.base.interact.RankingInteractEvents;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lcom/zj/adlib/ta7;", "", "", "bizNo", "", "bizType", "", "b", "c", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRankingInteractUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RankingInteractUtils.kt\ncom/huachenjie/base/interact/RankingInteractUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class ta7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ta7 f44881a = new ta7();

    public final WorksInteractEventBean a(String bizNo, int bizType) {
        Object next;
        Iterator<T> it = RankingInteractEvents.f7211a.p().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getBizNo(), bizNo) && worksInteractEventBean.getBizType() == bizType * (-1)) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final void b(@NotNull String bizNo, int bizType) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        WorksInteractEventBean worksInteractEventBeanA = a(bizNo, bizType);
        if (worksInteractEventBeanA != null) {
            if (worksInteractEventBeanA.getEventType() == 0) {
                RankingInteractEvents.f7211a.v(worksInteractEventBeanA);
            }
        } else {
            WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
            worksInteractEventBean.setBizNo(bizNo);
            worksInteractEventBean.setBizType(bizType * (-1));
            worksInteractEventBean.setEventType(1);
            RankingInteractEvents.f7211a.t(worksInteractEventBean);
        }
    }

    public final void c(@NotNull String bizNo, int bizType) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        WorksInteractEventBean worksInteractEventBeanA = a(bizNo, bizType);
        if (worksInteractEventBeanA != null) {
            if (worksInteractEventBeanA.getEventType() == 1) {
                RankingInteractEvents.f7211a.v(worksInteractEventBeanA);
            }
        } else {
            WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
            worksInteractEventBean.setBizNo(bizNo);
            worksInteractEventBean.setBizType(bizType * (-1));
            worksInteractEventBean.setEventType(0);
            RankingInteractEvents.f7211a.t(worksInteractEventBean);
        }
    }
}
