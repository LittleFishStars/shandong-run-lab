package com.huachenjie.works.external.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/external/bean/WorkNativeAdBean;", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "()V", "adInfo", "Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;", "getAdInfo", "()Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;", "setAdInfo", "(Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkNativeAdBean extends WorkItemBean {

    @NotNull
    public static final Parcelable.Creator<WorkNativeAdBean> CREATOR = new Creator();

    @Nullable
    private JZUnifiedAdInfo adInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkNativeAdBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkNativeAdBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new WorkNativeAdBean();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkNativeAdBean[] newArray(int i) {
            return new WorkNativeAdBean[i];
        }
    }

    public WorkNativeAdBean() {
        super(false, 0, null, 4, 0, null, null, null, null, null, null, 0, 0, 0, 0, null, 65527, null);
    }

    @Nullable
    public final JZUnifiedAdInfo getAdInfo() {
        return this.adInfo;
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 4;
    }

    public final void setAdInfo(@Nullable JZUnifiedAdInfo jZUnifiedAdInfo) {
        this.adInfo = jZUnifiedAdInfo;
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
