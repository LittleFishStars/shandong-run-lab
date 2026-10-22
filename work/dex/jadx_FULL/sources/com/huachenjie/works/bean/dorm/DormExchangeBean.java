package com.huachenjie.works.bean.dorm;

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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "Landroid/os/Parcelable;", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/works/bean/dorm/DormExchangeCardBean;", "perksRemark", "", "memberLogoUrl", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getList", "()Ljava/util/List;", "getMemberLogoUrl", "()Ljava/lang/String;", "getPerksRemark", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormExchangeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DormExchangeBean> CREATOR = new Creator();

    @NotNull
    private final List<DormExchangeCardBean> list;

    @NotNull
    private final String memberLogoUrl;

    @NotNull
    private final String perksRemark;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DormExchangeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DormExchangeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(DormExchangeCardBean.CREATOR.createFromParcel(parcel));
            }
            return new DormExchangeBean(arrayList, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DormExchangeBean[] newArray(int i) {
            return new DormExchangeBean[i];
        }
    }

    public DormExchangeBean() {
        this(null, null, null, 7, null);
    }

    public DormExchangeBean(@NotNull List<DormExchangeCardBean> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        Intrinsics.checkNotNullParameter(str, "perksRemark");
        Intrinsics.checkNotNullParameter(str2, "memberLogoUrl");
        this.list = list;
        this.perksRemark = str;
        this.memberLogoUrl = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DormExchangeBean copy$default(DormExchangeBean dormExchangeBean, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dormExchangeBean.list;
        }
        if ((i & 2) != 0) {
            str = dormExchangeBean.perksRemark;
        }
        if ((i & 4) != 0) {
            str2 = dormExchangeBean.memberLogoUrl;
        }
        return dormExchangeBean.copy(list, str, str2);
    }

    @NotNull
    public final List<DormExchangeCardBean> component1() {
        return this.list;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPerksRemark() {
        return this.perksRemark;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMemberLogoUrl() {
        return this.memberLogoUrl;
    }

    @NotNull
    public final DormExchangeBean copy(@NotNull List<DormExchangeCardBean> list, @NotNull String perksRemark, @NotNull String memberLogoUrl) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        Intrinsics.checkNotNullParameter(perksRemark, "perksRemark");
        Intrinsics.checkNotNullParameter(memberLogoUrl, "memberLogoUrl");
        return new DormExchangeBean(list, perksRemark, memberLogoUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormExchangeBean)) {
            return false;
        }
        DormExchangeBean dormExchangeBean = (DormExchangeBean) other;
        return Intrinsics.areEqual(this.list, dormExchangeBean.list) && Intrinsics.areEqual(this.perksRemark, dormExchangeBean.perksRemark) && Intrinsics.areEqual(this.memberLogoUrl, dormExchangeBean.memberLogoUrl);
    }

    @NotNull
    public final List<DormExchangeCardBean> getList() {
        return this.list;
    }

    @NotNull
    public final String getMemberLogoUrl() {
        return this.memberLogoUrl;
    }

    @NotNull
    public final String getPerksRemark() {
        return this.perksRemark;
    }

    public int hashCode() {
        return (((this.list.hashCode() * 31) + this.perksRemark.hashCode()) * 31) + this.memberLogoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "DormExchangeBean(list=" + this.list + ", perksRemark=" + this.perksRemark + ", memberLogoUrl=" + this.memberLogoUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<DormExchangeCardBean> list = this.list;
        parcel.writeInt(list.size());
        Iterator<DormExchangeCardBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.perksRemark);
        parcel.writeString(this.memberLogoUrl);
    }

    public /* synthetic */ DormExchangeBean(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }
}
