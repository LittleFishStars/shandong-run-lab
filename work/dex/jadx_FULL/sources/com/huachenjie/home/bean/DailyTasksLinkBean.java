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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/home/bean/DailyTasksLinkBean;", "Landroid/os/Parcelable;", "linkType", "", "url", "", "(ILjava/lang/String;)V", "getLinkType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DailyTasksLinkBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyTasksLinkBean> CREATOR = new Creator();
    private final int linkType;

    @NotNull
    private final String url;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTasksLinkBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksLinkBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTasksLinkBean(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksLinkBean[] newArray(int i) {
            return new DailyTasksLinkBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DailyTasksLinkBean() {
        String str = null;
        this(0, str, 3, str);
    }

    public DailyTasksLinkBean(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.linkType = i;
        this.url = str;
    }

    public static /* synthetic */ DailyTasksLinkBean copy$default(DailyTasksLinkBean dailyTasksLinkBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dailyTasksLinkBean.linkType;
        }
        if ((i2 & 2) != 0) {
            str = dailyTasksLinkBean.url;
        }
        return dailyTasksLinkBean.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLinkType() {
        return this.linkType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final DailyTasksLinkBean copy(int linkType, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new DailyTasksLinkBean(linkType, url);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyTasksLinkBean)) {
            return false;
        }
        DailyTasksLinkBean dailyTasksLinkBean = (DailyTasksLinkBean) other;
        return this.linkType == dailyTasksLinkBean.linkType && Intrinsics.areEqual(this.url, dailyTasksLinkBean.url);
    }

    public final int getLinkType() {
        return this.linkType;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (Integer.hashCode(this.linkType) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "DailyTasksLinkBean(linkType=" + this.linkType + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.linkType);
        parcel.writeString(this.url);
    }

    public /* synthetic */ DailyTasksLinkBean(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }
}
