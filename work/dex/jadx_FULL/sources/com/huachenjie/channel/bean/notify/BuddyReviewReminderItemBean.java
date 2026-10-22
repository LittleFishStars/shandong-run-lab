package com.huachenjie.channel.bean.notify;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/bean/notify/BuddyReviewReminderItemBean;", "", "buddyCode", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getBuddyCode", "()Ljava/lang/String;", "getTitle", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyReviewReminderItemBean {

    @NotNull
    private final String buddyCode;

    @NotNull
    private final String title;

    /* JADX WARN: Illegal instructions before constructor call */
    public BuddyReviewReminderItemBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public BuddyReviewReminderItemBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "buddyCode");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.buddyCode = str;
        this.title = str2;
    }

    public static /* synthetic */ BuddyReviewReminderItemBean copy$default(BuddyReviewReminderItemBean buddyReviewReminderItemBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buddyReviewReminderItemBean.buddyCode;
        }
        if ((i & 2) != 0) {
            str2 = buddyReviewReminderItemBean.title;
        }
        return buddyReviewReminderItemBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final BuddyReviewReminderItemBean copy(@NotNull String buddyCode, @NotNull String title) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(title, "title");
        return new BuddyReviewReminderItemBean(buddyCode, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyReviewReminderItemBean)) {
            return false;
        }
        BuddyReviewReminderItemBean buddyReviewReminderItemBean = (BuddyReviewReminderItemBean) other;
        return Intrinsics.areEqual(this.buddyCode, buddyReviewReminderItemBean.buddyCode) && Intrinsics.areEqual(this.title, buddyReviewReminderItemBean.title);
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.buddyCode.hashCode() * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyReviewReminderItemBean(buddyCode=" + this.buddyCode + ", title=" + this.title + ')';
    }

    public /* synthetic */ BuddyReviewReminderItemBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
