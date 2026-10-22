package com.huachenjie.works.external.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/external/bean/WorkBroadcastFloorItemBean;", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "()V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkBroadcastFloorItemBean extends WorkItemBean {

    @NotNull
    public static final Parcelable.Creator<WorkBroadcastFloorItemBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorkBroadcastFloorItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkBroadcastFloorItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new WorkBroadcastFloorItemBean();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorkBroadcastFloorItemBean[] newArray(int i) {
            return new WorkBroadcastFloorItemBean[i];
        }
    }

    public WorkBroadcastFloorItemBean() {
        super(false, 0, null, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, null, 65535, null);
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 6;
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
