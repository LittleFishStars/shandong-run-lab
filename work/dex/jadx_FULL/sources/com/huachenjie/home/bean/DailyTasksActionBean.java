package com.huachenjie.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/home/bean/DailyTasksActionBean;", "Landroid/os/Parcelable;", "link", "Lcom/huachenjie/home/bean/DailyTasksLinkBean;", "threshold", "", "channelNo", "(Lcom/huachenjie/home/bean/DailyTasksLinkBean;Ljava/lang/String;Ljava/lang/String;)V", "getChannelNo", "()Ljava/lang/String;", "getLink", "()Lcom/huachenjie/home/bean/DailyTasksLinkBean;", "getThreshold", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DailyTasksActionBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyTasksActionBean> CREATOR = new Creator();

    @Nullable
    private final String channelNo;

    @Nullable
    private final DailyTasksLinkBean link;

    @Nullable
    private final String threshold;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTasksActionBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksActionBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTasksActionBean(parcel.readInt() == 0 ? null : DailyTasksLinkBean.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksActionBean[] newArray(int i) {
            return new DailyTasksActionBean[i];
        }
    }

    public DailyTasksActionBean() {
        this(null, null, null, 7, null);
    }

    public DailyTasksActionBean(@Nullable DailyTasksLinkBean dailyTasksLinkBean, @Nullable String str, @Nullable String str2) {
        this.link = dailyTasksLinkBean;
        this.threshold = str;
        this.channelNo = str2;
    }

    public static /* synthetic */ DailyTasksActionBean copy$default(DailyTasksActionBean dailyTasksActionBean, DailyTasksLinkBean dailyTasksLinkBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            dailyTasksLinkBean = dailyTasksActionBean.link;
        }
        if ((i & 2) != 0) {
            str = dailyTasksActionBean.threshold;
        }
        if ((i & 4) != 0) {
            str2 = dailyTasksActionBean.channelNo;
        }
        return dailyTasksActionBean.copy(dailyTasksLinkBean, str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DailyTasksLinkBean getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThreshold() {
        return this.threshold;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final DailyTasksActionBean copy(@Nullable DailyTasksLinkBean link, @Nullable String threshold, @Nullable String channelNo) {
        return new DailyTasksActionBean(link, threshold, channelNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyTasksActionBean)) {
            return false;
        }
        DailyTasksActionBean dailyTasksActionBean = (DailyTasksActionBean) other;
        return Intrinsics.areEqual(this.link, dailyTasksActionBean.link) && Intrinsics.areEqual(this.threshold, dailyTasksActionBean.threshold) && Intrinsics.areEqual(this.channelNo, dailyTasksActionBean.channelNo);
    }

    @Nullable
    public final String getChannelNo() {
        return this.channelNo;
    }

    @Nullable
    public final DailyTasksLinkBean getLink() {
        return this.link;
    }

    @Nullable
    public final String getThreshold() {
        return this.threshold;
    }

    public int hashCode() {
        DailyTasksLinkBean dailyTasksLinkBean = this.link;
        int iHashCode = (dailyTasksLinkBean == null ? 0 : dailyTasksLinkBean.hashCode()) * 31;
        String str = this.threshold;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelNo;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DailyTasksActionBean(link=" + this.link + ", threshold=" + this.threshold + ", channelNo=" + this.channelNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        DailyTasksLinkBean dailyTasksLinkBean = this.link;
        if (dailyTasksLinkBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dailyTasksLinkBean.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.threshold);
        parcel.writeString(this.channelNo);
    }

    public /* synthetic */ DailyTasksActionBean(DailyTasksLinkBean dailyTasksLinkBean, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dailyTasksLinkBean, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
