package com.huachenjie.base.bean;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/base/bean/RunFaceCheckExtendBean;", "Landroid/os/Parcelable;", "progress", "", "filePath", "fileUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getFileUrl", "getProgress", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunFaceCheckExtendBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunFaceCheckExtendBean> CREATOR = new Creator();

    @Nullable
    private final String filePath;

    @Nullable
    private final String fileUrl;

    @Nullable
    private final String progress;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RunFaceCheckExtendBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFaceCheckExtendBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RunFaceCheckExtendBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFaceCheckExtendBean[] newArray(int i) {
            return new RunFaceCheckExtendBean[i];
        }
    }

    public RunFaceCheckExtendBean() {
        this(null, null, null, 7, null);
    }

    public RunFaceCheckExtendBean(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.progress = str;
        this.filePath = str2;
        this.fileUrl = str3;
    }

    public static /* synthetic */ RunFaceCheckExtendBean copy$default(RunFaceCheckExtendBean runFaceCheckExtendBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = runFaceCheckExtendBean.progress;
        }
        if ((i & 2) != 0) {
            str2 = runFaceCheckExtendBean.filePath;
        }
        if ((i & 4) != 0) {
            str3 = runFaceCheckExtendBean.fileUrl;
        }
        return runFaceCheckExtendBean.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProgress() {
        return this.progress;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @NotNull
    public final RunFaceCheckExtendBean copy(@Nullable String progress, @Nullable String filePath, @Nullable String fileUrl) {
        return new RunFaceCheckExtendBean(progress, filePath, fileUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunFaceCheckExtendBean)) {
            return false;
        }
        RunFaceCheckExtendBean runFaceCheckExtendBean = (RunFaceCheckExtendBean) other;
        return Intrinsics.areEqual(this.progress, runFaceCheckExtendBean.progress) && Intrinsics.areEqual(this.filePath, runFaceCheckExtendBean.filePath) && Intrinsics.areEqual(this.fileUrl, runFaceCheckExtendBean.fileUrl);
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @Nullable
    public final String getProgress() {
        return this.progress;
    }

    public int hashCode() {
        String str = this.progress;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.filePath;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RunFaceCheckExtendBean(progress=" + this.progress + ", filePath=" + this.filePath + ", fileUrl=" + this.fileUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.progress);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fileUrl);
    }

    public /* synthetic */ RunFaceCheckExtendBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }
}
