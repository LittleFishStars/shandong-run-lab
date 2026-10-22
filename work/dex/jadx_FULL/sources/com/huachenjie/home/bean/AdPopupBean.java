package com.huachenjie.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.czhj.sdk.common.Constants;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/huachenjie/home/bean/AdPopupBean;", "Landroid/os/Parcelable;", "imageUrl", "", "enableRecommendList", "", Constants.CLICK_TYPE, "", "clickTarget", "hasPopup", "(Ljava/lang/String;ZILjava/lang/String;Z)V", "getClickTarget", "()Ljava/lang/String;", "getClickType", "()I", "getEnableRecommendList", "()Z", "getHasPopup", "getImageUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdPopupBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AdPopupBean> CREATOR = new Creator();

    @NotNull
    private final String clickTarget;
    private final int clickType;
    private final boolean enableRecommendList;
    private final boolean hasPopup;

    @NotNull
    private final String imageUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AdPopupBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdPopupBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AdPopupBean(parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdPopupBean[] newArray(int i) {
            return new AdPopupBean[i];
        }
    }

    public AdPopupBean() {
        this(null, false, 0, null, false, 31, null);
    }

    public AdPopupBean(@NotNull String str, boolean z, int i, @NotNull String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "clickTarget");
        this.imageUrl = str;
        this.enableRecommendList = z;
        this.clickType = i;
        this.clickTarget = str2;
        this.hasPopup = z2;
    }

    public static /* synthetic */ AdPopupBean copy$default(AdPopupBean adPopupBean, String str, boolean z, int i, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adPopupBean.imageUrl;
        }
        if ((i2 & 2) != 0) {
            z = adPopupBean.enableRecommendList;
        }
        boolean z3 = z;
        if ((i2 & 4) != 0) {
            i = adPopupBean.clickType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = adPopupBean.clickTarget;
        }
        String str3 = str2;
        if ((i2 & 16) != 0) {
            z2 = adPopupBean.hasPopup;
        }
        return adPopupBean.copy(str, z3, i3, str3, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEnableRecommendList() {
        return this.enableRecommendList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getClickType() {
        return this.clickType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClickTarget() {
        return this.clickTarget;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasPopup() {
        return this.hasPopup;
    }

    @NotNull
    public final AdPopupBean copy(@NotNull String imageUrl, boolean enableRecommendList, int clickType, @NotNull String clickTarget, boolean hasPopup) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        return new AdPopupBean(imageUrl, enableRecommendList, clickType, clickTarget, hasPopup);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPopupBean)) {
            return false;
        }
        AdPopupBean adPopupBean = (AdPopupBean) other;
        return Intrinsics.areEqual(this.imageUrl, adPopupBean.imageUrl) && this.enableRecommendList == adPopupBean.enableRecommendList && this.clickType == adPopupBean.clickType && Intrinsics.areEqual(this.clickTarget, adPopupBean.clickTarget) && this.hasPopup == adPopupBean.hasPopup;
    }

    @NotNull
    public final String getClickTarget() {
        return this.clickTarget;
    }

    public final int getClickType() {
        return this.clickType;
    }

    public final boolean getEnableRecommendList() {
        return this.enableRecommendList;
    }

    public final boolean getHasPopup() {
        return this.hasPopup;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.imageUrl.hashCode() * 31;
        boolean z = this.enableRecommendList;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((iHashCode + r1) * 31) + Integer.hashCode(this.clickType)) * 31) + this.clickTarget.hashCode()) * 31;
        boolean z2 = this.hasPopup;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    @NotNull
    public String toString() {
        return "AdPopupBean(imageUrl=" + this.imageUrl + ", enableRecommendList=" + this.enableRecommendList + ", clickType=" + this.clickType + ", clickTarget=" + this.clickTarget + ", hasPopup=" + this.hasPopup + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.enableRecommendList ? 1 : 0);
        parcel.writeInt(this.clickType);
        parcel.writeString(this.clickTarget);
        parcel.writeInt(this.hasPopup ? 1 : 0);
    }

    public /* synthetic */ AdPopupBean(String str, boolean z, int i, String str2, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i, (i2 & 8) == 0 ? str2 : "", (i2 & 16) != 0 ? false : z2);
    }
}
