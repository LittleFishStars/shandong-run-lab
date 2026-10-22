package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bJ\t\u0010\u0012\u001a\u00020\u000bHÖ\u0001J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/run/bean/RunFinishBannerData;", "Landroid/os/Parcelable;", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/run/bean/RunFinishBannerBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "findBannerByIndex", "index", "hashCode", "showBannerByIndex", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunFinishBannerBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunFinishBannerBean.kt\ncom/huachenjie/run/bean/RunFinishBannerData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final /* data */ class RunFinishBannerData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunFinishBannerData> CREATOR = new Creator();

    @NotNull
    private final List<RunFinishBannerBean> list;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RunFinishBannerData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFinishBannerData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(RunFinishBannerBean.CREATOR.createFromParcel(parcel));
            }
            return new RunFinishBannerData(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunFinishBannerData[] newArray(int i) {
            return new RunFinishBannerData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RunFinishBannerData() {
        List list = null;
        this(list, 1, list);
    }

    public RunFinishBannerData(@NotNull List<RunFinishBannerBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RunFinishBannerData copy$default(RunFinishBannerData runFinishBannerData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = runFinishBannerData.list;
        }
        return runFinishBannerData.copy(list);
    }

    @NotNull
    public final List<RunFinishBannerBean> component1() {
        return this.list;
    }

    @NotNull
    public final RunFinishBannerData copy(@NotNull List<RunFinishBannerBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new RunFinishBannerData(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RunFinishBannerData) && Intrinsics.areEqual(this.list, ((RunFinishBannerData) other).list);
    }

    @NotNull
    public final RunFinishBannerBean findBannerByIndex(int index) {
        List<RunFinishBannerBean> list = this.list;
        return (index < 0 || index > CollectionsKt.getLastIndex(list)) ? new RunFinishBannerBean(null, null, 0, null, 0, 0, 63, null) : list.get(index);
    }

    @NotNull
    public final List<RunFinishBannerBean> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public final boolean showBannerByIndex(int index) {
        return index >= 0 && index < this.list.size();
    }

    @NotNull
    public String toString() {
        return "RunFinishBannerData(list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<RunFinishBannerBean> list = this.list;
        parcel.writeInt(list.size());
        Iterator<RunFinishBannerBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ RunFinishBannerData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
