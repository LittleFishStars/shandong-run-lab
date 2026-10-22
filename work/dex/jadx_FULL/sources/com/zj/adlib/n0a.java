package com.zj.adlib;

import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.interact.WorksInteractEvents;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J.\u0010 \u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J.\u0010!\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010#\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010$\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010%\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J.\u0010&\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J.\u0010'\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010(\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010*\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010+\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J.\u0010-\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J.\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010/\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015¨\u00062"}, d2 = {"Lcom/zj/adlib/n0a;", "", "", "appCode", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "d", yj7.g.WORKS_NO, "c", "j", "commentNo", y6b.f, "e", "f", "postNo", y6b.g, "i", "", "source", "", "b", "F", "", "defaultState", t.d, "worksAuthorNo", "a", "y", "k", "x", "E", "r", "commentUserNo", "u", "B", j.b, "s", j.o, "n", "t", "A", "m", "postAuthorNo", "v", "C", "q", "w", "D", "p", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class n0a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n0a f43422a = new n0a();

    public final void A(@NotNull String worksNo, @NotNull String worksAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanF = f(worksNo, commentNo);
        if (worksInteractEventBeanF != null && worksInteractEventBeanF.isLikeCommentAlumniSay()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanF);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikeCommentAlumniSayEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void B(@NotNull String worksNo, @NotNull String worksAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanG = g(worksNo, commentNo);
        if (worksInteractEventBeanG != null && worksInteractEventBeanG.isLikeComment()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanG);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikeCommentEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(2);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void C(@NotNull String postNo, @NotNull String postAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(postAuthorNo, "postAuthorNo");
        WorksInteractEventBean worksInteractEventBeanH = h(postNo);
        if (worksInteractEventBeanH != null && worksInteractEventBeanH.isLikePostWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanH);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(postNo);
        worksInteractEventBean.setBizNo(postNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(postAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikePostWorksEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(20);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void D(@NotNull String postNo, @NotNull String postAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(postAuthorNo, "postAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanI = i(postNo, commentNo);
        if (worksInteractEventBeanI != null && worksInteractEventBeanI.isLikePostWorksComment()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanI);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(postNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(postAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikePostWorksCommentEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(20);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void E(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanJ = j(worksNo);
        if (worksInteractEventBeanJ != null && worksInteractEventBeanJ.isLikeWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanJ);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikeWorksEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(1);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void F(@NotNull String appCode, int source) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        WorksInteractEventBean worksInteractEventBeanD = d(appCode);
        if (worksInteractEventBeanD != null && worksInteractEventBeanD.isFollowFriend()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanD);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setBizNo(appCode);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnFollowEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(3);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void a(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanC = c(worksNo);
        if (worksInteractEventBeanC != null && !worksInteractEventBeanC.isCollectWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanC);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getCollectEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(1);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void b(@NotNull String appCode, int source) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        WorksInteractEventBean worksInteractEventBeanD = d(appCode);
        if (worksInteractEventBeanD != null && !worksInteractEventBeanD.isFollowFriend()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanD);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setBizNo(appCode);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setEventType(worksInteractEventBean.getFollowEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(3);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final WorksInteractEventBean c(String worksNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getBizNo(), worksNo) && worksInteractEventBean.getEventType() >= 210 && worksInteractEventBean.getEventType() <= 213) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean d(String appCode) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getBizNo(), appCode) && worksInteractEventBean.getBizType() == 3) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean e(String worksNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getWorksNo(), worksNo) && worksInteractEventBean.getEventType() >= 330 && worksInteractEventBean.getEventType() <= 333) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean f(String worksNo, String commentNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getWorksNo(), worksNo) && Intrinsics.areEqual(worksInteractEventBean.getBizNo(), commentNo) && worksInteractEventBean.getEventType() >= 430 && worksInteractEventBean.getEventType() <= 435) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean g(String worksNo, String commentNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getWorksNo(), worksNo) && Intrinsics.areEqual(worksInteractEventBean.getBizNo(), commentNo) && worksInteractEventBean.getEventType() >= 410 && worksInteractEventBean.getEventType() <= 415) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean h(String postNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getBizNo(), postNo) && worksInteractEventBean.getEventType() >= 340 && worksInteractEventBean.getEventType() <= 345) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean i(String postNo, String commentNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getWorksNo(), postNo) && Intrinsics.areEqual(worksInteractEventBean.getBizNo(), commentNo) && worksInteractEventBean.getEventType() >= 440 && worksInteractEventBean.getEventType() <= 445) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final WorksInteractEventBean j(String worksNo) {
        Object next;
        Iterator<T> it = WorksInteractEvents.f7217a.o().getEventList().iterator();
        while (it.hasNext()) {
            next = it.next();
            WorksInteractEventBean worksInteractEventBean = (WorksInteractEventBean) next;
            if (Intrinsics.areEqual(worksInteractEventBean.getBizNo(), worksNo) && worksInteractEventBean.getEventType() >= 310 && worksInteractEventBean.getEventType() <= 313) {
                return (WorksInteractEventBean) next;
            }
        }
        next = null;
        return (WorksInteractEventBean) next;
    }

    public final boolean k(@NotNull String worksNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        WorksInteractEventBean worksInteractEventBeanC = c(worksNo);
        return worksInteractEventBeanC != null ? worksInteractEventBeanC.isCollectWorks() : defaultState;
    }

    public final boolean l(@NotNull String appCode, boolean defaultState) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        WorksInteractEventBean worksInteractEventBeanD = d(appCode);
        return worksInteractEventBeanD != null ? worksInteractEventBeanD.isFollowFriend() : defaultState;
    }

    public final boolean m(@NotNull String worksNo, @NotNull String commentNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        WorksInteractEventBean worksInteractEventBeanF = f(worksNo, commentNo);
        return worksInteractEventBeanF != null ? worksInteractEventBeanF.isLikeCommentAlumniSay() : defaultState;
    }

    public final boolean n(@NotNull String worksNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        WorksInteractEventBean worksInteractEventBeanE = e(worksNo);
        return worksInteractEventBeanE != null ? worksInteractEventBeanE.isLikeAlumniSay() : defaultState;
    }

    public final boolean o(@NotNull String worksNo, @NotNull String commentNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        WorksInteractEventBean worksInteractEventBeanG = g(worksNo, commentNo);
        return worksInteractEventBeanG != null ? worksInteractEventBeanG.isLikeComment() : defaultState;
    }

    public final boolean p(@NotNull String postNo, @NotNull String commentNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        WorksInteractEventBean worksInteractEventBeanI = i(postNo, commentNo);
        return worksInteractEventBeanI != null ? worksInteractEventBeanI.isLikePostWorksComment() : defaultState;
    }

    public final boolean q(@NotNull String postNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        WorksInteractEventBean worksInteractEventBeanH = h(postNo);
        return worksInteractEventBeanH != null ? worksInteractEventBeanH.isLikePostWorks() : defaultState;
    }

    public final boolean r(@NotNull String worksNo, boolean defaultState) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        WorksInteractEventBean worksInteractEventBeanJ = j(worksNo);
        return worksInteractEventBeanJ != null ? worksInteractEventBeanJ.isLikeWorks() : defaultState;
    }

    public final void s(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanE = e(worksNo);
        if (worksInteractEventBeanE != null && !worksInteractEventBeanE.isLikeAlumniSay()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanE);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikeAlumniSayEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(10);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void t(@NotNull String worksNo, @NotNull String worksAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanF = f(worksNo, commentNo);
        if (worksInteractEventBeanF != null && !worksInteractEventBeanF.isLikeCommentAlumniSay()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanF);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikeCommentAlumniSayEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(2);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void u(@NotNull String worksNo, @NotNull String worksAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanG = g(worksNo, commentNo);
        if (worksInteractEventBeanG != null && !worksInteractEventBeanG.isLikeComment()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanG);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikeCommentEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(2);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void v(@NotNull String postNo, @NotNull String postAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(postAuthorNo, "postAuthorNo");
        WorksInteractEventBean worksInteractEventBeanH = h(postNo);
        if (worksInteractEventBeanH != null && !worksInteractEventBeanH.isLikePostWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanH);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(postNo);
        worksInteractEventBean.setBizNo(postNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(postAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikePostWorksEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(20);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void w(@NotNull String postNo, @NotNull String postAuthorNo, @NotNull String commentNo, @NotNull String commentUserNo, int source) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(postAuthorNo, "postAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(commentUserNo, "commentUserNo");
        WorksInteractEventBean worksInteractEventBeanI = i(postNo, commentNo);
        if (worksInteractEventBeanI != null && !worksInteractEventBeanI.isLikePostWorksComment()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanI);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(postNo);
        worksInteractEventBean.setBizNo(commentNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(postAuthorNo);
        worksInteractEventBean.setCommentUserNo(commentUserNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikePostWorksCommentEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(20);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void x(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanJ = j(worksNo);
        if (worksInteractEventBeanJ != null && !worksInteractEventBeanJ.isLikeWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanJ);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getLikeWorksEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(1);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void y(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanC = c(worksNo);
        if (worksInteractEventBeanC != null && worksInteractEventBeanC.isCollectWorks()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanC);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnCollectEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(1);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }

    public final void z(@NotNull String worksNo, @NotNull String worksAuthorNo, int source) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(worksAuthorNo, "worksAuthorNo");
        WorksInteractEventBean worksInteractEventBeanE = e(worksNo);
        if (worksInteractEventBeanE != null && worksInteractEventBeanE.isLikeAlumniSay()) {
            WorksInteractEvents.f7217a.u(worksInteractEventBeanE);
            return;
        }
        WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
        worksInteractEventBean.setWorksNo(worksNo);
        worksInteractEventBean.setBizNo(worksNo);
        worksInteractEventBean.setSource(source);
        worksInteractEventBean.setWorksAuthorNo(worksAuthorNo);
        worksInteractEventBean.setEventType(worksInteractEventBean.getUnLikeAlumniSayEventType());
        worksInteractEventBean.setEventTime(System.currentTimeMillis());
        worksInteractEventBean.setBizType(10);
        WorksInteractEvents.f7217a.s(worksInteractEventBean);
    }
}
