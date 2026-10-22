package com.huachenjie.channel.bean.notify;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/bean/notify/BuddyReviewReminderBean;", "", "pendingApplyCount", "", "buddyList", "", "Lcom/huachenjie/channel/bean/notify/BuddyReviewReminderItemBean;", "(ILjava/util/List;)V", "getBuddyList", "()Ljava/util/List;", "getPendingApplyCount", "()I", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyReviewReminderBean {

    @Nullable
    private final List<BuddyReviewReminderItemBean> buddyList;
    private final int pendingApplyCount;

    /* JADX WARN: Illegal instructions before constructor call */
    public BuddyReviewReminderBean() {
        List list = null;
        this(0, list, 3, list);
    }

    public BuddyReviewReminderBean(int i, @Nullable List<BuddyReviewReminderItemBean> list) {
        this.pendingApplyCount = i;
        this.buddyList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuddyReviewReminderBean copy$default(BuddyReviewReminderBean buddyReviewReminderBean, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = buddyReviewReminderBean.pendingApplyCount;
        }
        if ((i2 & 2) != 0) {
            list = buddyReviewReminderBean.buddyList;
        }
        return buddyReviewReminderBean.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPendingApplyCount() {
        return this.pendingApplyCount;
    }

    @Nullable
    public final List<BuddyReviewReminderItemBean> component2() {
        return this.buddyList;
    }

    @NotNull
    public final BuddyReviewReminderBean copy(int pendingApplyCount, @Nullable List<BuddyReviewReminderItemBean> buddyList) {
        return new BuddyReviewReminderBean(pendingApplyCount, buddyList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyReviewReminderBean)) {
            return false;
        }
        BuddyReviewReminderBean buddyReviewReminderBean = (BuddyReviewReminderBean) other;
        return this.pendingApplyCount == buddyReviewReminderBean.pendingApplyCount && Intrinsics.areEqual(this.buddyList, buddyReviewReminderBean.buddyList);
    }

    @Nullable
    public final List<BuddyReviewReminderItemBean> getBuddyList() {
        return this.buddyList;
    }

    public final int getPendingApplyCount() {
        return this.pendingApplyCount;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.pendingApplyCount) * 31;
        List<BuddyReviewReminderItemBean> list = this.buddyList;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "BuddyReviewReminderBean(pendingApplyCount=" + this.pendingApplyCount + ", buddyList=" + this.buddyList + ')';
    }

    public /* synthetic */ BuddyReviewReminderBean(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list);
    }
}
