package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0006\u0010 \u001a\u00020\u0003J\t\u0010!\u001a\u00020\u001bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/huachenjie/base/bean/LetterBean;", "Landroid/os/Parcelable;", "schoolLetterRelationCode", "", "schoolLetterTitle", "schoolLetterSummary", "schoolLetterContent", "linkUrl", "schoolLetterTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getLinkUrl", "()Ljava/lang/String;", "getSchoolLetterContent", "getSchoolLetterRelationCode", "getSchoolLetterSummary", "getSchoolLetterTime", "()J", "getSchoolLetterTitle", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "formatLetterTime", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LetterBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<LetterBean> CREATOR = new Creator();

    @NotNull
    private final String linkUrl;

    @NotNull
    private final String schoolLetterContent;

    @NotNull
    private final String schoolLetterRelationCode;

    @NotNull
    private final String schoolLetterSummary;
    private final long schoolLetterTime;

    @NotNull
    private final String schoolLetterTitle;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LetterBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LetterBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LetterBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LetterBean[] newArray(int i) {
            return new LetterBean[i];
        }
    }

    public LetterBean() {
        this(null, null, null, null, null, 0L, 63, null);
    }

    public LetterBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j) {
        Intrinsics.checkNotNullParameter(str, "schoolLetterRelationCode");
        Intrinsics.checkNotNullParameter(str2, "schoolLetterTitle");
        Intrinsics.checkNotNullParameter(str3, "schoolLetterSummary");
        Intrinsics.checkNotNullParameter(str4, "schoolLetterContent");
        Intrinsics.checkNotNullParameter(str5, "linkUrl");
        this.schoolLetterRelationCode = str;
        this.schoolLetterTitle = str2;
        this.schoolLetterSummary = str3;
        this.schoolLetterContent = str4;
        this.linkUrl = str5;
        this.schoolLetterTime = j;
    }

    public static /* synthetic */ LetterBean copy$default(LetterBean letterBean, String str, String str2, String str3, String str4, String str5, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = letterBean.schoolLetterRelationCode;
        }
        if ((i & 2) != 0) {
            str2 = letterBean.schoolLetterTitle;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = letterBean.schoolLetterSummary;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = letterBean.schoolLetterContent;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = letterBean.linkUrl;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            j = letterBean.schoolLetterTime;
        }
        return letterBean.copy(str, str6, str7, str8, str9, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolLetterRelationCode() {
        return this.schoolLetterRelationCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolLetterTitle() {
        return this.schoolLetterTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSchoolLetterSummary() {
        return this.schoolLetterSummary;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolLetterContent() {
        return this.schoolLetterContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSchoolLetterTime() {
        return this.schoolLetterTime;
    }

    @NotNull
    public final LetterBean copy(@NotNull String schoolLetterRelationCode, @NotNull String schoolLetterTitle, @NotNull String schoolLetterSummary, @NotNull String schoolLetterContent, @NotNull String linkUrl, long schoolLetterTime) {
        Intrinsics.checkNotNullParameter(schoolLetterRelationCode, "schoolLetterRelationCode");
        Intrinsics.checkNotNullParameter(schoolLetterTitle, "schoolLetterTitle");
        Intrinsics.checkNotNullParameter(schoolLetterSummary, "schoolLetterSummary");
        Intrinsics.checkNotNullParameter(schoolLetterContent, "schoolLetterContent");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        return new LetterBean(schoolLetterRelationCode, schoolLetterTitle, schoolLetterSummary, schoolLetterContent, linkUrl, schoolLetterTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LetterBean)) {
            return false;
        }
        LetterBean letterBean = (LetterBean) other;
        return Intrinsics.areEqual(this.schoolLetterRelationCode, letterBean.schoolLetterRelationCode) && Intrinsics.areEqual(this.schoolLetterTitle, letterBean.schoolLetterTitle) && Intrinsics.areEqual(this.schoolLetterSummary, letterBean.schoolLetterSummary) && Intrinsics.areEqual(this.schoolLetterContent, letterBean.schoolLetterContent) && Intrinsics.areEqual(this.linkUrl, letterBean.linkUrl) && this.schoolLetterTime == letterBean.schoolLetterTime;
    }

    @NotNull
    public final String formatLetterTime() {
        long j = this.schoolLetterTime;
        if (j == 0) {
            return "";
        }
        String strC = s72.c(j, "yyyy.MM.dd HH:mm:ss");
        Intrinsics.checkNotNullExpressionValue(strC, "formatDateTimeByFormat(s…e, \"yyyy.MM.dd HH:mm:ss\")");
        return strC;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    public final String getSchoolLetterContent() {
        return this.schoolLetterContent;
    }

    @NotNull
    public final String getSchoolLetterRelationCode() {
        return this.schoolLetterRelationCode;
    }

    @NotNull
    public final String getSchoolLetterSummary() {
        return this.schoolLetterSummary;
    }

    public final long getSchoolLetterTime() {
        return this.schoolLetterTime;
    }

    @NotNull
    public final String getSchoolLetterTitle() {
        return this.schoolLetterTitle;
    }

    public int hashCode() {
        return (((((((((this.schoolLetterRelationCode.hashCode() * 31) + this.schoolLetterTitle.hashCode()) * 31) + this.schoolLetterSummary.hashCode()) * 31) + this.schoolLetterContent.hashCode()) * 31) + this.linkUrl.hashCode()) * 31) + Long.hashCode(this.schoolLetterTime);
    }

    @NotNull
    public String toString() {
        return "LetterBean(schoolLetterRelationCode=" + this.schoolLetterRelationCode + ", schoolLetterTitle=" + this.schoolLetterTitle + ", schoolLetterSummary=" + this.schoolLetterSummary + ", schoolLetterContent=" + this.schoolLetterContent + ", linkUrl=" + this.linkUrl + ", schoolLetterTime=" + this.schoolLetterTime + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.schoolLetterRelationCode);
        parcel.writeString(this.schoolLetterTitle);
        parcel.writeString(this.schoolLetterSummary);
        parcel.writeString(this.schoolLetterContent);
        parcel.writeString(this.linkUrl);
        parcel.writeLong(this.schoolLetterTime);
    }

    public /* synthetic */ LetterBean(String str, String str2, String str3, String str4, String str5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? 0L : j);
    }
}
