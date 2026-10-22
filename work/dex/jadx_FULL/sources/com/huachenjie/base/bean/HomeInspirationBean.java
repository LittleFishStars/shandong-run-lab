package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/base/bean/HomeInspirationBean;", "Landroid/os/Parcelable;", "total", "", "convertedAmount", "", "(ID)V", "getConvertedAmount", "()D", "getTotal", "()I", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "findAmount", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeInspirationBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<HomeInspirationBean> CREATOR = new Creator();
    private final double convertedAmount;
    private final int total;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<HomeInspirationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeInspirationBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HomeInspirationBean(parcel.readInt(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HomeInspirationBean[] newArray(int i) {
            return new HomeInspirationBean[i];
        }
    }

    public HomeInspirationBean() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public HomeInspirationBean(int i, double d) {
        this.total = i;
        this.convertedAmount = d;
    }

    public static /* synthetic */ HomeInspirationBean copy$default(HomeInspirationBean homeInspirationBean, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = homeInspirationBean.total;
        }
        if ((i2 & 2) != 0) {
            d = homeInspirationBean.convertedAmount;
        }
        return homeInspirationBean.copy(i, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getConvertedAmount() {
        return this.convertedAmount;
    }

    @NotNull
    public final HomeInspirationBean copy(int total, double convertedAmount) {
        return new HomeInspirationBean(total, convertedAmount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeInspirationBean)) {
            return false;
        }
        HomeInspirationBean homeInspirationBean = (HomeInspirationBean) other;
        return this.total == homeInspirationBean.total && Double.compare(this.convertedAmount, homeInspirationBean.convertedAmount) == 0;
    }

    @NotNull
    public final String findAmount() {
        String str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(this.convertedAmount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        return str;
    }

    public final double getConvertedAmount() {
        return this.convertedAmount;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.total) * 31) + Double.hashCode(this.convertedAmount);
    }

    @NotNull
    public String toString() {
        return "HomeInspirationBean(total=" + this.total + ", convertedAmount=" + this.convertedAmount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.total);
        parcel.writeDouble(this.convertedAmount);
    }

    public /* synthetic */ HomeInspirationBean(int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? -1.0d : d);
    }
}
