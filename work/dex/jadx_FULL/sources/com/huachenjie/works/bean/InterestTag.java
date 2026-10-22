package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\nR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/huachenjie/works/bean/InterestTag;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "Landroid/os/Parcelable;", "isHeader", "", "tagNo", "", "tagName", "selected", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "()Z", "getSelected", "setSelected", "(Z)V", "getTagName", "()Ljava/lang/String;", "getTagNo", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InterestTag implements SectionEntity, Parcelable {

    @NotNull
    public static final Parcelable.Creator<InterestTag> CREATOR = new Creator();
    private final boolean isHeader;
    private boolean selected;

    @NotNull
    private final String tagName;

    @NotNull
    private final String tagNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InterestTag> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InterestTag createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InterestTag(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InterestTag[] newArray(int i) {
            return new InterestTag[i];
        }
    }

    public InterestTag() {
        this(false, null, null, false, 15, null);
    }

    public InterestTag(boolean z, @NotNull String str, @NotNull String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "tagNo");
        Intrinsics.checkNotNullParameter(str2, "tagName");
        this.isHeader = z;
        this.tagNo = str;
        this.tagName = str2;
        this.selected = z2;
    }

    public static /* synthetic */ InterestTag copy$default(InterestTag interestTag, boolean z, String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = interestTag.getIsHeader();
        }
        if ((i & 2) != 0) {
            str = interestTag.tagNo;
        }
        if ((i & 4) != 0) {
            str2 = interestTag.tagName;
        }
        if ((i & 8) != 0) {
            z2 = interestTag.selected;
        }
        return interestTag.copy(z, str, str2, z2);
    }

    public final boolean component1() {
        return getIsHeader();
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTagNo() {
        return this.tagNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final InterestTag copy(boolean isHeader, @NotNull String tagNo, @NotNull String tagName, boolean selected) {
        Intrinsics.checkNotNullParameter(tagNo, "tagNo");
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        return new InterestTag(isHeader, tagNo, tagName, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterestTag)) {
            return false;
        }
        InterestTag interestTag = (InterestTag) other;
        return getIsHeader() == interestTag.getIsHeader() && Intrinsics.areEqual(this.tagNo, interestTag.tagNo) && Intrinsics.areEqual(this.tagName, interestTag.tagName) && this.selected == interestTag.selected;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getTagName() {
        return this.tagName;
    }

    @NotNull
    public final String getTagNo() {
        return this.tagNo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean isHeader = getIsHeader();
        ?? r0 = isHeader;
        if (isHeader) {
            r0 = 1;
        }
        int iHashCode = ((((r0 * 31) + this.tagNo.hashCode()) * 31) + this.tagName.hashCode()) * 31;
        boolean z = this.selected;
        return iHashCode + (z ? 1 : z);
    }

    @Override // com.chad.library.adapter.base.entity.SectionEntity
    /* JADX INFO: renamed from: isHeader, reason: from getter */
    public boolean getIsHeader() {
        return this.isHeader;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    @NotNull
    public String toString() {
        return "InterestTag(isHeader=" + getIsHeader() + ", tagNo=" + this.tagNo + ", tagName=" + this.tagName + ", selected=" + this.selected + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isHeader ? 1 : 0);
        parcel.writeString(this.tagNo);
        parcel.writeString(this.tagName);
        parcel.writeInt(this.selected ? 1 : 0);
    }

    public /* synthetic */ InterestTag(boolean z, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? false : z2);
    }
}
