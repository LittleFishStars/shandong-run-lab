package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, d2 = {"Lcom/huachenjie/sport/bean/UserRunRankBean;", "", FreeRunActivity.y, "", "rankNumber", UserConstants.USER_PARAMS.b, "", AvatarFragment.AVATAR_URL, "duration", "", "(IILjava/lang/String;Ljava/lang/String;J)V", "getAvatarUrl", "()Ljava/lang/String;", "getDuration", "()J", "getNickName", "getRankNumber", "()I", "getTargetDistance", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "formatDistance", "formatDuration", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserRunRankBean {

    @NotNull
    private final String avatarUrl;
    private final long duration;

    @NotNull
    private final String nickName;
    private final int rankNumber;
    private final int targetDistance;

    public UserRunRankBean() {
        this(0, 0, null, null, 0L, 31, null);
    }

    public UserRunRankBean(int i, int i2, @NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str2, AvatarFragment.AVATAR_URL);
        this.targetDistance = i;
        this.rankNumber = i2;
        this.nickName = str;
        this.avatarUrl = str2;
        this.duration = j;
    }

    public static /* synthetic */ UserRunRankBean copy$default(UserRunRankBean userRunRankBean, int i, int i2, String str, String str2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = userRunRankBean.targetDistance;
        }
        if ((i3 & 2) != 0) {
            i2 = userRunRankBean.rankNumber;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = userRunRankBean.nickName;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            str2 = userRunRankBean.avatarUrl;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            j = userRunRankBean.duration;
        }
        return userRunRankBean.copy(i, i4, str3, str4, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTargetDistance() {
        return this.targetDistance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRankNumber() {
        return this.rankNumber;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final UserRunRankBean copy(int targetDistance, int rankNumber, @NotNull String nickName, @NotNull String avatarUrl, long duration) {
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
        return new UserRunRankBean(targetDistance, rankNumber, nickName, avatarUrl, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserRunRankBean)) {
            return false;
        }
        UserRunRankBean userRunRankBean = (UserRunRankBean) other;
        return this.targetDistance == userRunRankBean.targetDistance && this.rankNumber == userRunRankBean.rankNumber && Intrinsics.areEqual(this.nickName, userRunRankBean.nickName) && Intrinsics.areEqual(this.avatarUrl, userRunRankBean.avatarUrl) && this.duration == userRunRankBean.duration;
    }

    @NotNull
    public final String formatDistance() {
        try {
            String strE = ll7.f43096a.e(Integer.valueOf(this.targetDistance), true, true);
            return strE == null ? "" : strE;
        } catch (Exception unused) {
            return String.valueOf(this.targetDistance);
        }
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

    public final int getTargetDistance() {
        return this.targetDistance;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.targetDistance) * 31) + Integer.hashCode(this.rankNumber)) * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + Long.hashCode(this.duration);
    }

    @NotNull
    public String toString() {
        return "UserRunRankBean(targetDistance=" + this.targetDistance + ", rankNumber=" + this.rankNumber + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", duration=" + this.duration + ')';
    }

    public /* synthetic */ UserRunRankBean(int i, int i2, String str, String str2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? "--" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? 0L : j);
    }
}
