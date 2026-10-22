package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/RecommendWorksBean;", "Landroid/os/Parcelable;", "categoryName", "", yj7.g.f20870c, "logoUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryNo", "getLogoUrl", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RecommendWorksBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RecommendWorksBean> CREATOR = new Creator();

    @NotNull
    private final String categoryName;

    @NotNull
    private final String categoryNo;

    @Nullable
    private final String logoUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecommendWorksBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendWorksBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RecommendWorksBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendWorksBean[] newArray(int i) {
            return new RecommendWorksBean[i];
        }
    }

    public RecommendWorksBean() {
        this(null, null, null, 7, null);
    }

    public RecommendWorksBean(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str2, yj7.g.f20870c);
        this.categoryName = str;
        this.categoryNo = str2;
        this.logoUrl = str3;
    }

    public static /* synthetic */ RecommendWorksBean copy$default(RecommendWorksBean recommendWorksBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recommendWorksBean.categoryName;
        }
        if ((i & 2) != 0) {
            str2 = recommendWorksBean.categoryNo;
        }
        if ((i & 4) != 0) {
            str3 = recommendWorksBean.logoUrl;
        }
        return recommendWorksBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final RecommendWorksBean copy(@NotNull String categoryName, @NotNull String categoryNo, @Nullable String logoUrl) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.f20870c);
        return new RecommendWorksBean(categoryName, categoryNo, logoUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendWorksBean)) {
            return false;
        }
        RecommendWorksBean recommendWorksBean = (RecommendWorksBean) other;
        return Intrinsics.areEqual(this.categoryName, recommendWorksBean.categoryName) && Intrinsics.areEqual(this.categoryNo, recommendWorksBean.categoryNo) && Intrinsics.areEqual(this.logoUrl, recommendWorksBean.logoUrl);
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public int hashCode() {
        int iHashCode = ((this.categoryName.hashCode() * 31) + this.categoryNo.hashCode()) * 31;
        String str = this.logoUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "RecommendWorksBean(categoryName=" + this.categoryName + ", categoryNo=" + this.categoryNo + ", logoUrl=" + this.logoUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.categoryName);
        parcel.writeString(this.categoryNo);
        parcel.writeString(this.logoUrl);
    }

    public /* synthetic */ RecommendWorksBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
