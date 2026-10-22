package com.huachenjie.mall.page.test;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001.BC\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b&\u0010%R\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/huachenjie/mall/page/test/WorkVideoBean;", "Landroid/os/Parcelable;", "", "component1", "component2", "", "component3", "component4", "component5", "", "component6", "path", "name", "width", "height", "status", "delFlag", OperatePopupWindow.g, "toString", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getName", "I", "getWidth", "()I", "getHeight", "getStatus", "Z", "getDelFlag", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIZ)V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
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
    public static final Parcelable.Creator<WorkVideoBean> CREATOR = new b();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<WorkVideoBean> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WorkVideoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WorkVideoBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
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
