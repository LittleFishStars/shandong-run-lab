package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/common/bean/StudentSchoolAuthBean;", "Landroid/os/Parcelable;", "schoolCode", "", "schoolName", "logoUrl", "loginUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginUrl", "()Ljava/lang/String;", "getLogoUrl", "getSchoolCode", "getSchoolName", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StudentSchoolAuthBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<StudentSchoolAuthBean> CREATOR = new Creator();

    @NotNull
    private final String loginUrl;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String schoolCode;

    @NotNull
    private final String schoolName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StudentSchoolAuthBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StudentSchoolAuthBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StudentSchoolAuthBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StudentSchoolAuthBean[] newArray(int i) {
            return new StudentSchoolAuthBean[i];
        }
    }

    public StudentSchoolAuthBean() {
        this(null, null, null, null, 15, null);
    }

    public StudentSchoolAuthBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "schoolName");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(str4, "loginUrl");
        this.schoolCode = str;
        this.schoolName = str2;
        this.logoUrl = str3;
        this.loginUrl = str4;
    }

    public static /* synthetic */ StudentSchoolAuthBean copy$default(StudentSchoolAuthBean studentSchoolAuthBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = studentSchoolAuthBean.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = studentSchoolAuthBean.schoolName;
        }
        if ((i & 4) != 0) {
            str3 = studentSchoolAuthBean.logoUrl;
        }
        if ((i & 8) != 0) {
            str4 = studentSchoolAuthBean.loginUrl;
        }
        return studentSchoolAuthBean.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolName() {
        return this.schoolName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @NotNull
    public final StudentSchoolAuthBean copy(@NotNull String schoolCode, @NotNull String schoolName, @NotNull String logoUrl, @NotNull String loginUrl) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(schoolName, "schoolName");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(loginUrl, "loginUrl");
        return new StudentSchoolAuthBean(schoolCode, schoolName, logoUrl, loginUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StudentSchoolAuthBean)) {
            return false;
        }
        StudentSchoolAuthBean studentSchoolAuthBean = (StudentSchoolAuthBean) other;
        return Intrinsics.areEqual(this.schoolCode, studentSchoolAuthBean.schoolCode) && Intrinsics.areEqual(this.schoolName, studentSchoolAuthBean.schoolName) && Intrinsics.areEqual(this.logoUrl, studentSchoolAuthBean.logoUrl) && Intrinsics.areEqual(this.loginUrl, studentSchoolAuthBean.loginUrl);
    }

    @NotNull
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolName() {
        return this.schoolName;
    }

    public int hashCode() {
        return (((((this.schoolCode.hashCode() * 31) + this.schoolName.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.loginUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "StudentSchoolAuthBean(schoolCode=" + this.schoolCode + ", schoolName=" + this.schoolName + ", logoUrl=" + this.logoUrl + ", loginUrl=" + this.loginUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.schoolCode);
        parcel.writeString(this.schoolName);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.loginUrl);
    }

    public /* synthetic */ StudentSchoolAuthBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
