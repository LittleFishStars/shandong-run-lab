package com.huachenjie.mall.page.test;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/page/test/AttachmentBean;", "Landroid/os/Parcelable;", "imageList", "", "Lcom/huachenjie/mall/page/test/WorkImageBean;", "video", "Lcom/huachenjie/mall/page/test/WorkVideoBean;", "(Ljava/util/List;Lcom/huachenjie/mall/page/test/WorkVideoBean;)V", "getImageList", "()Ljava/util/List;", "getVideo", "()Lcom/huachenjie/mall/page/test/WorkVideoBean;", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttachmentBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AttachmentBean> CREATOR = new a();

    @NotNull
    private final List<WorkImageBean> imageList;

    @NotNull
    private final WorkVideoBean video;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AttachmentBean> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AttachmentBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(WorkImageBean.CREATOR.createFromParcel(parcel));
            }
            return new AttachmentBean(arrayList, WorkVideoBean.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AttachmentBean[] newArray(int i) {
            return new AttachmentBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public AttachmentBean(@NotNull List<WorkImageBean> list, @NotNull WorkVideoBean workVideoBean) {
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(workVideoBean, "video");
        this.imageList = list;
        this.video = workVideoBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentBean copy$default(AttachmentBean attachmentBean, List list, WorkVideoBean workVideoBean, int i, Object obj) {
        if ((i & 1) != 0) {
            list = attachmentBean.imageList;
        }
        if ((i & 2) != 0) {
            workVideoBean = attachmentBean.video;
        }
        return attachmentBean.copy(list, workVideoBean);
    }

    @NotNull
    public final List<WorkImageBean> component1() {
        return this.imageList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkVideoBean getVideo() {
        return this.video;
    }

    @NotNull
    public final AttachmentBean copy(@NotNull List<WorkImageBean> imageList, @NotNull WorkVideoBean video) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(video, "video");
        return new AttachmentBean(imageList, video);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentBean)) {
            return false;
        }
        AttachmentBean attachmentBean = (AttachmentBean) other;
        return Intrinsics.areEqual(this.imageList, attachmentBean.imageList) && Intrinsics.areEqual(this.video, attachmentBean.video);
    }

    @NotNull
    public final List<WorkImageBean> getImageList() {
        return this.imageList;
    }

    @NotNull
    public final WorkVideoBean getVideo() {
        return this.video;
    }

    public int hashCode() {
        return (this.imageList.hashCode() * 31) + this.video.hashCode();
    }

    @NotNull
    public String toString() {
        return "AttachmentBean(imageList=" + this.imageList + ", video=" + this.video + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<WorkImageBean> list = this.imageList;
        parcel.writeInt(list.size());
        Iterator<WorkImageBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        this.video.writeToParcel(parcel, flags);
    }

    public /* synthetic */ AttachmentBean(List list, WorkVideoBean workVideoBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new WorkVideoBean(null, null, 0, 0, 0, false, 63, null) : workVideoBean);
    }
}
