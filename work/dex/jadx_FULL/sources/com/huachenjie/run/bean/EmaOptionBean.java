package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/run/bean/EmaOptionBean;", "Landroid/os/Parcelable;", "optionNo", "", "content", "logoUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getLogoUrl", "getOptionNo", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmaOptionBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EmaOptionBean> CREATOR = new Creator();

    @NotNull
    private final String content;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String optionNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmaOptionBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaOptionBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EmaOptionBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaOptionBean[] newArray(int i) {
            return new EmaOptionBean[i];
        }
    }

    public EmaOptionBean() {
        this(null, null, null, 7, null);
    }

    public EmaOptionBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "optionNo");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        this.optionNo = str;
        this.content = str2;
        this.logoUrl = str3;
    }

    public static /* synthetic */ EmaOptionBean copy$default(EmaOptionBean emaOptionBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emaOptionBean.optionNo;
        }
        if ((i & 2) != 0) {
            str2 = emaOptionBean.content;
        }
        if ((i & 4) != 0) {
            str3 = emaOptionBean.logoUrl;
        }
        return emaOptionBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOptionNo() {
        return this.optionNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final EmaOptionBean copy(@NotNull String optionNo, @NotNull String content, @NotNull String logoUrl) {
        Intrinsics.checkNotNullParameter(optionNo, "optionNo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        return new EmaOptionBean(optionNo, content, logoUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmaOptionBean)) {
            return false;
        }
        EmaOptionBean emaOptionBean = (EmaOptionBean) other;
        return Intrinsics.areEqual(this.optionNo, emaOptionBean.optionNo) && Intrinsics.areEqual(this.content, emaOptionBean.content) && Intrinsics.areEqual(this.logoUrl, emaOptionBean.logoUrl);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getOptionNo() {
        return this.optionNo;
    }

    public int hashCode() {
        return (((this.optionNo.hashCode() * 31) + this.content.hashCode()) * 31) + this.logoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmaOptionBean(optionNo=" + this.optionNo + ", content=" + this.content + ", logoUrl=" + this.logoUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.optionNo);
        parcel.writeString(this.content);
        parcel.writeString(this.logoUrl);
    }

    public /* synthetic */ EmaOptionBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
