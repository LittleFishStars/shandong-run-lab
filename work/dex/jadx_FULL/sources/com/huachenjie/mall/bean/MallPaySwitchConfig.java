package com.huachenjie.mall.bean;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mall/bean/MallPaySwitchConfig;", "Landroid/os/Parcelable;", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/mall/bean/MallPaySwitchSubConfig;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "showAliPay", "showWXPay", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMallPaySwitchConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallPaySwitchConfig.kt\ncom/huachenjie/mall/bean/MallPaySwitchConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
public final /* data */ class MallPaySwitchConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MallPaySwitchConfig> CREATOR = new Creator();

    @NotNull
    private final List<MallPaySwitchSubConfig> list;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MallPaySwitchConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MallPaySwitchConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MallPaySwitchSubConfig.CREATOR.createFromParcel(parcel));
            }
            return new MallPaySwitchConfig(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MallPaySwitchConfig[] newArray(int i) {
            return new MallPaySwitchConfig[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MallPaySwitchConfig() {
        List list = null;
        this(list, 1, list);
    }

    public MallPaySwitchConfig(@NotNull List<MallPaySwitchSubConfig> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallPaySwitchConfig copy$default(MallPaySwitchConfig mallPaySwitchConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mallPaySwitchConfig.list;
        }
        return mallPaySwitchConfig.copy(list);
    }

    @NotNull
    public final List<MallPaySwitchSubConfig> component1() {
        return this.list;
    }

    @NotNull
    public final MallPaySwitchConfig copy(@NotNull List<MallPaySwitchSubConfig> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new MallPaySwitchConfig(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MallPaySwitchConfig) && Intrinsics.areEqual(this.list, ((MallPaySwitchConfig) other).list);
    }

    @NotNull
    public final List<MallPaySwitchSubConfig> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    public final boolean showAliPay() {
        for (Object obj : this.list) {
            if (((MallPaySwitchSubConfig) obj).getCode() == 2) {
                if (obj != null) {
                    return true;
                }
                return false;
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final boolean showWXPay() {
        for (Object obj : this.list) {
            if (((MallPaySwitchSubConfig) obj).getCode() == 1) {
                if (obj != null) {
                    return true;
                }
                return false;
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "MallPaySwitchConfig(list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<MallPaySwitchSubConfig> list = this.list;
        parcel.writeInt(list.size());
        Iterator<MallPaySwitchSubConfig> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ MallPaySwitchConfig(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
