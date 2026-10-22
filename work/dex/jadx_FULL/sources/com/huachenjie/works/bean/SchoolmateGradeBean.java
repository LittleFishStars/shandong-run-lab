package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/SchoolmateGradeBean;", "Landroid/os/Parcelable;", "gradeCode", "", "gradeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGradeCode", "()Ljava/lang/String;", "getGradeName", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolmateGradeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SchoolmateGradeBean> CREATOR = new Creator();

    @NotNull
    private final String gradeCode;

    @NotNull
    private final String gradeName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SchoolmateGradeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SchoolmateGradeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SchoolmateGradeBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SchoolmateGradeBean[] newArray(int i) {
            return new SchoolmateGradeBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SchoolmateGradeBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public SchoolmateGradeBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "gradeCode");
        Intrinsics.checkNotNullParameter(str2, "gradeName");
        this.gradeCode = str;
        this.gradeName = str2;
    }

    public static /* synthetic */ SchoolmateGradeBean copy$default(SchoolmateGradeBean schoolmateGradeBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schoolmateGradeBean.gradeCode;
        }
        if ((i & 2) != 0) {
            str2 = schoolmateGradeBean.gradeName;
        }
        return schoolmateGradeBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGradeCode() {
        return this.gradeCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGradeName() {
        return this.gradeName;
    }

    @NotNull
    public final SchoolmateGradeBean copy(@NotNull String gradeCode, @NotNull String gradeName) {
        Intrinsics.checkNotNullParameter(gradeCode, "gradeCode");
        Intrinsics.checkNotNullParameter(gradeName, "gradeName");
        return new SchoolmateGradeBean(gradeCode, gradeName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolmateGradeBean)) {
            return false;
        }
        SchoolmateGradeBean schoolmateGradeBean = (SchoolmateGradeBean) other;
        return Intrinsics.areEqual(this.gradeCode, schoolmateGradeBean.gradeCode) && Intrinsics.areEqual(this.gradeName, schoolmateGradeBean.gradeName);
    }

    @NotNull
    public final String getGradeCode() {
        return this.gradeCode;
    }

    @NotNull
    public final String getGradeName() {
        return this.gradeName;
    }

    public int hashCode() {
        return (this.gradeCode.hashCode() * 31) + this.gradeName.hashCode();
    }

    @NotNull
    public String toString() {
        return "SchoolmateGradeBean(gradeCode=" + this.gradeCode + ", gradeName=" + this.gradeName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.gradeCode);
        parcel.writeString(this.gradeName);
    }

    public /* synthetic */ SchoolmateGradeBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
