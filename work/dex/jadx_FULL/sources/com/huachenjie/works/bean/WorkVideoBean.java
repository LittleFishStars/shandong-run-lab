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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006*"}, d2 = {"Lcom/huachenjie/works/bean/WorkVideoBean;", "Landroid/os/Parcelable;", "path", "", "name", "width", "", "height", "status", "delFlag", "", "(Ljava/lang/String;Ljava/lang/String;IIIZ)V", "getDelFlag", "()Z", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getPath", "setPath", "(Ljava/lang/String;)V", "getStatus", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkVideoBean implements Parcelable {
    public static final int VIDEO_STATUS_NO_SHOW = 0;
    public static final int VIDEO_STATUS_PROCESS = 2;
    public static final int VIDEO_STATUS_SHOW = 1;
    private final boolean delFlag;
    private final int height;

    @NotNull
    private final String name;

    @NotNull
    private String path;
    private final int status;
    private final int width;

    @NotNull
    public static final Parcelable.Creator<WorkVideoBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkVideoBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkVideoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WorkVideoBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkVideoBean[] newArray(int i) {
            return new WorkVideoBean[i];
        }
    }

    public WorkVideoBean() {
        this(null, null, 0, 0, 0, false, 63, null);
    }

    public WorkVideoBean(@NotNull String str, @NotNull String str2, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.path = str;
        this.name = str2;
        this.width = i;
        this.height = i2;
        this.status = i3;
        this.delFlag = z;
    }

    public static /* synthetic */ WorkVideoBean copy$default(WorkVideoBean workVideoBean, String str, String str2, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = workVideoBean.path;
        }
        if ((i4 & 2) != 0) {
            str2 = workVideoBean.name;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            i = workVideoBean.width;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = workVideoBean.height;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = workVideoBean.status;
        }
        int i7 = i3;
        if ((i4 & 32) != 0) {
            z = workVideoBean.delFlag;
        }
        return workVideoBean.copy(str, str3, i5, i6, i7, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDelFlag() {
        return this.delFlag;
    }

    @NotNull
    public final WorkVideoBean copy(@NotNull String path, @NotNull String name, int width, int height, int status, boolean delFlag) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        return new WorkVideoBean(path, name, width, height, status, delFlag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkVideoBean)) {
            return false;
        }
        WorkVideoBean workVideoBean = (WorkVideoBean) other;
        return Intrinsics.areEqual(this.path, workVideoBean.path) && Intrinsics.areEqual(this.name, workVideoBean.name) && this.width == workVideoBean.width && this.height == workVideoBean.height && this.status == workVideoBean.status && this.delFlag == workVideoBean.delFlag;
    }

    public final boolean getDelFlag() {
        return this.delFlag;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((((this.path.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.status)) * 31;
        boolean z = this.delFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    @NotNull
    public String toString() {
        return "WorkVideoBean(path=" + this.path + ", name=" + this.name + ", width=" + this.width + ", height=" + this.height + ", status=" + this.status + ", delFlag=" + this.delFlag + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.path);
        parcel.writeString(this.name);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.status);
        parcel.writeInt(this.delFlag ? 1 : 0);
    }

    public /* synthetic */ WorkVideoBean(String str, String str2, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) == 0 ? str2 : "", (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? false : z);
    }
}
