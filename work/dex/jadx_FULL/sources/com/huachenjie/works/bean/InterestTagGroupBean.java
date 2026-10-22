package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/InterestTagGroupBean;", "Landroid/os/Parcelable;", "typeName", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/works/bean/InterestTag;", "(Ljava/lang/String;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getTypeName", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InterestTagGroupBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<InterestTagGroupBean> CREATOR = new Creator();

    @NotNull
    private final List<InterestTag> list;

    @NotNull
    private final String typeName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InterestTagGroupBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InterestTagGroupBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(InterestTag.CREATOR.createFromParcel(parcel));
            }
            return new InterestTagGroupBean(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InterestTagGroupBean[] newArray(int i) {
            return new InterestTagGroupBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InterestTagGroupBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public InterestTagGroupBean(@NotNull String str, @NotNull List<InterestTag> list) {
        Intrinsics.checkNotNullParameter(str, "typeName");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.typeName = str;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InterestTagGroupBean copy$default(InterestTagGroupBean interestTagGroupBean, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = interestTagGroupBean.typeName;
        }
        if ((i & 2) != 0) {
            list = interestTagGroupBean.list;
        }
        return interestTagGroupBean.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final List<InterestTag> component2() {
        return this.list;
    }

    @NotNull
    public final InterestTagGroupBean copy(@NotNull String typeName, @NotNull List<InterestTag> list) {
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new InterestTagGroupBean(typeName, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterestTagGroupBean)) {
            return false;
        }
        InterestTagGroupBean interestTagGroupBean = (InterestTagGroupBean) other;
        return Intrinsics.areEqual(this.typeName, interestTagGroupBean.typeName) && Intrinsics.areEqual(this.list, interestTagGroupBean.list);
    }

    @NotNull
    public final List<InterestTag> getList() {
        return this.list;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        return (this.typeName.hashCode() * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "InterestTagGroupBean(typeName=" + this.typeName + ", list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.typeName);
        List<InterestTag> list = this.list;
        parcel.writeInt(list.size());
        Iterator<InterestTag> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ InterestTagGroupBean(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : list);
    }
}
