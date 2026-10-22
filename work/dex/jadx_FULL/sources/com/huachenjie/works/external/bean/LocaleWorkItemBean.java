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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/external/bean/LocaleWorkItemBean;", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "()V", "id", "", "getId", "()J", "setId", "(J)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "mediaPath", "", "getMediaPath", "()Ljava/lang/String;", "setMediaPath", "(Ljava/lang/String;)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocaleWorkItemBean extends WorkItemBean {

    @NotNull
    public static final Parcelable.Creator<LocaleWorkItemBean> CREATOR = new Creator();
    private long id;

    @NotNull
    private String mediaPath;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LocaleWorkItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocaleWorkItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new LocaleWorkItemBean();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocaleWorkItemBean[] newArray(int i) {
            return new LocaleWorkItemBean[i];
        }
    }

    public LocaleWorkItemBean() {
        super(false, 0, null, 1, 0, null, null, null, null, null, null, 0, 0, 0, 0, null, 65527, null);
        this.mediaPath = "";
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    @NotNull
    public final String getMediaPath() {
        return this.mediaPath;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setMediaPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaPath = str;
    }

    @Override // com.huachenjie.works.external.bean.WorkItemBean, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
