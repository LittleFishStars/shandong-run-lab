package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/huachenjie/common/bean/FeedbackData;", "Landroid/os/Parcelable;", "content", "", "imgList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "auditResult", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getAuditResult", "()Ljava/lang/String;", "setAuditResult", "(Ljava/lang/String;)V", "getContent", "setContent", "getImgList", "()Ljava/util/ArrayList;", "setImgList", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FeedbackData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FeedbackData> CREATOR = new Creator();

    @Nullable
    private String auditResult;

    @Nullable
    private String content;

    @Nullable
    private ArrayList<String> imgList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FeedbackData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FeedbackData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedbackData(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FeedbackData[] newArray(int i) {
            return new FeedbackData[i];
        }
    }

    public FeedbackData(@Nullable String str, @Nullable ArrayList<String> arrayList, @Nullable String str2) {
        this.content = str;
        this.imgList = arrayList;
        this.auditResult = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackData copy$default(FeedbackData feedbackData, String str, ArrayList arrayList, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedbackData.content;
        }
        if ((i & 2) != 0) {
            arrayList = feedbackData.imgList;
        }
        if ((i & 4) != 0) {
            str2 = feedbackData.auditResult;
        }
        return feedbackData.copy(str, arrayList, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ArrayList<String> component2() {
        return this.imgList;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuditResult() {
        return this.auditResult;
    }

    @NotNull
    public final FeedbackData copy(@Nullable String content, @Nullable ArrayList<String> imgList, @Nullable String auditResult) {
        return new FeedbackData(content, imgList, auditResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackData)) {
            return false;
        }
        FeedbackData feedbackData = (FeedbackData) other;
        return Intrinsics.areEqual(this.content, feedbackData.content) && Intrinsics.areEqual(this.imgList, feedbackData.imgList) && Intrinsics.areEqual(this.auditResult, feedbackData.auditResult);
    }

    @Nullable
    public final String getAuditResult() {
        return this.auditResult;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ArrayList<String> getImgList() {
        return this.imgList;
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArrayList<String> arrayList = this.imgList;
        int iHashCode2 = (iHashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.auditResult;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAuditResult(@Nullable String str) {
        this.auditResult = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setImgList(@Nullable ArrayList<String> arrayList) {
        this.imgList = arrayList;
    }

    @NotNull
    public String toString() {
        return "FeedbackData(content=" + this.content + ", imgList=" + this.imgList + ", auditResult=" + this.auditResult + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.content);
        parcel.writeStringList(this.imgList);
        parcel.writeString(this.auditResult);
    }
}
