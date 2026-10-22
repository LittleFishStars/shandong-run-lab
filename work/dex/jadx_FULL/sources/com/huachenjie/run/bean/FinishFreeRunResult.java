package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/run/bean/FinishFreeRunResult;", "Landroid/os/Parcelable;", "inspiration", "Lcom/huachenjie/run/bean/InspirationBean;", "(Lcom/huachenjie/run/bean/InspirationBean;)V", "getInspiration", "()Lcom/huachenjie/run/bean/InspirationBean;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FinishFreeRunResult implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FinishFreeRunResult> CREATOR = new Creator();

    @Nullable
    private final InspirationBean inspiration;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FinishFreeRunResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FinishFreeRunResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FinishFreeRunResult(parcel.readInt() == 0 ? null : InspirationBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FinishFreeRunResult[] newArray(int i) {
            return new FinishFreeRunResult[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FinishFreeRunResult() {
        InspirationBean inspirationBean = null;
        this(inspirationBean, 1, inspirationBean);
    }

    public FinishFreeRunResult(@Nullable InspirationBean inspirationBean) {
        this.inspiration = inspirationBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final InspirationBean getInspiration() {
        return this.inspiration;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        InspirationBean inspirationBean = this.inspiration;
        if (inspirationBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            inspirationBean.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ FinishFreeRunResult(InspirationBean inspirationBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : inspirationBean);
    }
}
