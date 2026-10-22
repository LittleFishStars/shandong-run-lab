package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006("}, d2 = {"Lcom/huachenjie/run/bean/RunFinishBannerBean;", "Landroid/os/Parcelable;", "picUrl", "", "bannerNo", UserTrackConstant.JUMP_TYPE, "", "jumpContent", "width", "height", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "getBannerNo", "()Ljava/lang/String;", "getHeight", "()I", "getJumpContent", "getJumpType", "getPicUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getAspectRatio", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunFinishBannerBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunFinishBannerBean> CREATOR = new Creator();

    @NotNull
    private final String bannerNo;
    private final int height;

    @NotNull
    private final String jumpContent;
    private final int jumpType;

    @NotNull
    private final String picUrl;
    private final int width;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RunFinishBannerBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFinishBannerBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RunFinishBannerBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFinishBannerBean[] newArray(int i) {
            return new RunFinishBannerBean[i];
        }
    }

    public RunFinishBannerBean() {
        this(null, null, 0, null, 0, 0, 63, null);
    }

    public RunFinishBannerBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "picUrl");
        Intrinsics.checkNotNullParameter(str2, "bannerNo");
        Intrinsics.checkNotNullParameter(str3, "jumpContent");
        this.picUrl = str;
        this.bannerNo = str2;
        this.jumpType = i;
        this.jumpContent = str3;
        this.width = i2;
        this.height = i3;
    }

    public static /* synthetic */ RunFinishBannerBean copy$default(RunFinishBannerBean runFinishBannerBean, String str, String str2, int i, String str3, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = runFinishBannerBean.picUrl;
        }
        if ((i4 & 2) != 0) {
            str2 = runFinishBannerBean.bannerNo;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            i = runFinishBannerBean.jumpType;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            str3 = runFinishBannerBean.jumpContent;
        }
        String str5 = str3;
        if ((i4 & 16) != 0) {
            i2 = runFinishBannerBean.width;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = runFinishBannerBean.height;
        }
        return runFinishBannerBean.copy(str, str4, i5, str5, i6, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBannerNo() {
        return this.bannerNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getJumpContent() {
        return this.jumpContent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final RunFinishBannerBean copy(@NotNull String picUrl, @NotNull String bannerNo, int jumpType, @NotNull String jumpContent, int width, int height) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(bannerNo, "bannerNo");
        Intrinsics.checkNotNullParameter(jumpContent, "jumpContent");
        return new RunFinishBannerBean(picUrl, bannerNo, jumpType, jumpContent, width, height);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunFinishBannerBean)) {
            return false;
        }
        RunFinishBannerBean runFinishBannerBean = (RunFinishBannerBean) other;
        return Intrinsics.areEqual(this.picUrl, runFinishBannerBean.picUrl) && Intrinsics.areEqual(this.bannerNo, runFinishBannerBean.bannerNo) && this.jumpType == runFinishBannerBean.jumpType && Intrinsics.areEqual(this.jumpContent, runFinishBannerBean.jumpContent) && this.width == runFinishBannerBean.width && this.height == runFinishBannerBean.height;
    }

    public final double getAspectRatio() {
        int i;
        int i2 = this.width;
        if (i2 == 0 || (i = this.height) == 0) {
            return 1.0d;
        }
        return ((double) i2) / ((double) i);
    }

    @NotNull
    public final String getBannerNo() {
        return this.bannerNo;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getJumpContent() {
        return this.jumpContent;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((this.picUrl.hashCode() * 31) + this.bannerNo.hashCode()) * 31) + Integer.hashCode(this.jumpType)) * 31) + this.jumpContent.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    @NotNull
    public String toString() {
        return "RunFinishBannerBean(picUrl=" + this.picUrl + ", bannerNo=" + this.bannerNo + ", jumpType=" + this.jumpType + ", jumpContent=" + this.jumpContent + ", width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.picUrl);
        parcel.writeString(this.bannerNo);
        parcel.writeInt(this.jumpType);
        parcel.writeString(this.jumpContent);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public /* synthetic */ RunFinishBannerBean(String str, String str2, int i, String str3, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) == 0 ? str3 : "", (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }
}
