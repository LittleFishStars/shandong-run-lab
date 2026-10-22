package com.huachenjie.home.bean.reward;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.home.R;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/huachenjie/home/bean/reward/HomeRewardBean;", "Landroid/os/Parcelable;", "taskNo", "", "status", "", "reward", "gameIcon", "Lcom/huachenjie/home/bean/reward/HomeRewardGameIconBean;", "(Ljava/lang/String;IILcom/huachenjie/home/bean/reward/HomeRewardGameIconBean;)V", "getGameIcon", "()Lcom/huachenjie/home/bean/reward/HomeRewardGameIconBean;", "getReward", "()I", "getStatus", "getTaskNo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getInspirationName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeRewardBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<HomeRewardBean> CREATOR = new Creator();

    @Nullable
    private final HomeRewardGameIconBean gameIcon;
    private final int reward;
    private final int status;

    @NotNull
    private final String taskNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<HomeRewardBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeRewardBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HomeRewardBean(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? null : HomeRewardGameIconBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeRewardBean[] newArray(int i) {
            return new HomeRewardBean[i];
        }
    }

    public HomeRewardBean() {
        this(null, 0, 0, null, 15, null);
    }

    public HomeRewardBean(@NotNull String str, int i, int i2, @Nullable HomeRewardGameIconBean homeRewardGameIconBean) {
        Intrinsics.checkNotNullParameter(str, "taskNo");
        this.taskNo = str;
        this.status = i;
        this.reward = i2;
        this.gameIcon = homeRewardGameIconBean;
    }

    public static /* synthetic */ HomeRewardBean copy$default(HomeRewardBean homeRewardBean, String str, int i, int i2, HomeRewardGameIconBean homeRewardGameIconBean, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = homeRewardBean.taskNo;
        }
        if ((i3 & 2) != 0) {
            i = homeRewardBean.status;
        }
        if ((i3 & 4) != 0) {
            i2 = homeRewardBean.reward;
        }
        if ((i3 & 8) != 0) {
            homeRewardGameIconBean = homeRewardBean.gameIcon;
        }
        return homeRewardBean.copy(str, i, i2, homeRewardGameIconBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTaskNo() {
        return this.taskNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getReward() {
        return this.reward;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final HomeRewardGameIconBean getGameIcon() {
        return this.gameIcon;
    }

    @NotNull
    public final HomeRewardBean copy(@NotNull String taskNo, int status, int reward, @Nullable HomeRewardGameIconBean gameIcon) {
        Intrinsics.checkNotNullParameter(taskNo, "taskNo");
        return new HomeRewardBean(taskNo, status, reward, gameIcon);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeRewardBean)) {
            return false;
        }
        HomeRewardBean homeRewardBean = (HomeRewardBean) other;
        return Intrinsics.areEqual(this.taskNo, homeRewardBean.taskNo) && this.status == homeRewardBean.status && this.reward == homeRewardBean.reward && Intrinsics.areEqual(this.gameIcon, homeRewardBean.gameIcon);
    }

    @Nullable
    public final HomeRewardGameIconBean getGameIcon() {
        return this.gameIcon;
    }

    @NotNull
    public final String getInspirationName() {
        String strF = ys8.f(R.string.home_record_inspiration_name, Integer.valueOf(this.reward));
        Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.home_…inspiration_name, reward)");
        return strF;
    }

    public final int getReward() {
        return this.reward;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTaskNo() {
        return this.taskNo;
    }

    public int hashCode() {
        int iHashCode = ((((this.taskNo.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.reward)) * 31;
        HomeRewardGameIconBean homeRewardGameIconBean = this.gameIcon;
        return iHashCode + (homeRewardGameIconBean == null ? 0 : homeRewardGameIconBean.hashCode());
    }

    @NotNull
    public String toString() {
        return "HomeRewardBean(taskNo=" + this.taskNo + ", status=" + this.status + ", reward=" + this.reward + ", gameIcon=" + this.gameIcon + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.taskNo);
        parcel.writeInt(this.status);
        parcel.writeInt(this.reward);
        HomeRewardGameIconBean homeRewardGameIconBean = this.gameIcon;
        if (homeRewardGameIconBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            homeRewardGameIconBean.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ HomeRewardBean(String str, int i, int i2, HomeRewardGameIconBean homeRewardGameIconBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : homeRewardGameIconBean);
    }
}
