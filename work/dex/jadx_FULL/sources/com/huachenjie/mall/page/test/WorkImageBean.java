package com.huachenjie.mall.page.test;

import android.os.Parcel;
import android.os.Parcelable;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J\u0013\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00061"}, d2 = {"Lcom/huachenjie/mall/page/test/WorkImageBean;", "Landroid/os/Parcelable;", "smallPath", "", "path", AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, "", "name", "width", "", "height", "ratio", "", "delFlag", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIFZ)V", "getCover", "()Z", "getDelFlag", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getPath", "getRatio", "()F", "setRatio", "(F)V", "getSmallPath", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkImageBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<WorkImageBean> CREATOR = new a();
    private final boolean cover;
    private final boolean delFlag;
    private final int height;

    @NotNull
    private final String name;

    @NotNull
    private final String path;
    private float ratio;

    @NotNull
    private final String smallPath;
    private final int width;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<WorkImageBean> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WorkImageBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WorkImageBean(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WorkImageBean[] newArray(int i) {
            return new WorkImageBean[i];
        }
    }

    public WorkImageBean() {
        this(null, null, false, null, 0, 0, 0.0f, false, 255, null);
    }

    public WorkImageBean(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, int i, int i2, float f, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "smallPath");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.smallPath = str;
        this.path = str2;
        this.cover = z;
        this.name = str3;
        this.width = i;
        this.height = i2;
        this.ratio = f;
        this.delFlag = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSmallPath() {
        return this.smallPath;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCover() {
        return this.cover;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getRatio() {
        return this.ratio;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getDelFlag() {
        return this.delFlag;
    }

    @NotNull
    public final WorkImageBean copy(@NotNull String smallPath, @NotNull String path, boolean cover, @NotNull String name, int width, int height, float ratio, boolean delFlag) {
        Intrinsics.checkNotNullParameter(smallPath, "smallPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        return new WorkImageBean(smallPath, path, cover, name, width, height, ratio, delFlag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkImageBean)) {
            return false;
        }
        WorkImageBean workImageBean = (WorkImageBean) other;
        return Intrinsics.areEqual(this.smallPath, workImageBean.smallPath) && Intrinsics.areEqual(this.path, workImageBean.path) && this.cover == workImageBean.cover && Intrinsics.areEqual(this.name, workImageBean.name) && this.width == workImageBean.width && this.height == workImageBean.height && Float.compare(this.ratio, workImageBean.ratio) == 0 && this.delFlag == workImageBean.delFlag;
    }

    public final boolean getCover() {
        return this.cover;
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

    public final float getRatio() {
        return this.ratio;
    }

    @NotNull
    public final String getSmallPath() {
        return this.smallPath;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.smallPath.hashCode() * 31) + this.path.hashCode()) * 31;
        boolean z = this.cover;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((iHashCode + r1) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.ratio)) * 31;
        boolean z2 = this.delFlag;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    public final void setRatio(float f) {
        this.ratio = f;
    }

    @NotNull
    public String toString() {
        return "WorkImageBean(smallPath=" + this.smallPath + ", path=" + this.path + ", cover=" + this.cover + ", name=" + this.name + ", width=" + this.width + ", height=" + this.height + ", ratio=" + this.ratio + ", delFlag=" + this.delFlag + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.smallPath);
        parcel.writeString(this.path);
        parcel.writeInt(this.cover ? 1 : 0);
        parcel.writeString(this.name);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.ratio);
        parcel.writeInt(this.delFlag ? 1 : 0);
    }

    public /* synthetic */ WorkImageBean(String str, String str2, boolean z, String str3, int i, int i2, float f, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? false : z, (i3 & 8) == 0 ? str3 : "", (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? 0.0f : f, (i3 & 128) == 0 ? z2 : false);
    }
}
