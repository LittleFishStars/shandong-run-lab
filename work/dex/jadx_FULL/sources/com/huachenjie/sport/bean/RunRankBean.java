package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0005J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/sport/bean/RunRankBean;", "", "rankNumber", "", UserConstants.USER_PARAMS.b, "", AvatarFragment.AVATAR_URL, "duration", "", "(ILjava/lang/String;Ljava/lang/String;J)V", "getAvatarUrl", "()Ljava/lang/String;", "getDuration", "()J", "getNickName", "getRankNumber", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "formatDuration", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunRankBean {

    @NotNull
    private final String avatarUrl;
    private final long duration;

    @NotNull
    private final String nickName;
    private final int rankNumber;

    public RunRankBean() {
        this(0, null, null, 0L, 15, null);
    }

    public RunRankBean(int i, @NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str2, AvatarFragment.AVATAR_URL);
        this.rankNumber = i;
        this.nickName = str;
        this.avatarUrl = str2;
        this.duration = j;
    }

    public static /* synthetic */ RunRankBean copy$default(RunRankBean runRankBean, int i, String str, String str2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = runRankBean.rankNumber;
        }
        if ((i2 & 2) != 0) {
            str = runRankBean.nickName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = runRankBean.avatarUrl;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            j = runRankBean.duration;
        }
        return runRankBean.copy(i, str3, str4, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRankNumber() {
        return this.rankNumber;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final RunRankBean copy(int rankNumber, @NotNull String nickName, @NotNull String avatarUrl, long duration) {
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
        return new RunRankBean(rankNumber, nickName, avatarUrl, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunRankBean)) {
            return false;
        }
        RunRankBean runRankBean = (RunRankBean) other;
        return this.rankNumber == runRankBean.rankNumber && Intrinsics.areEqual(this.nickName, runRankBean.nickName) && Intrinsics.areEqual(this.avatarUrl, runRankBean.avatarUrl) && this.duration == runRankBean.duration;
    }

    @NotNull
    public final String formatDuration() {
        String strH = s72.h(this.duration);
        Intrinsics.checkNotNullExpressionValue(strH, "formatSecondTime(duration)");
        return strH;
    }

    @NotNull
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final int getRankNumber() {
        return this.rankNumber;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.rankNumber) * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + Long.hashCode(this.duration);
    }

    @NotNull
    public String toString() {
        return "RunRankBean(rankNumber=" + this.rankNumber + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", duration=" + this.duration + ')';
    }

    public /* synthetic */ RunRankBean(int i, String str, String str2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "--" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? 0L : j);
    }
}
