package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.PetModelBean;
import com.huachenjie.common.bean.SpineSuitModelBean;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003JO\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020)HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020)HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/huachenjie/base/bean/SpineWebBean;", "Landroid/os/Parcelable;", "spineBean", "Lcom/huachenjie/common/bean/SpineSuitModelBean;", "petSpineBean", "Lcom/huachenjie/common/bean/PetModelBean;", "onlyPet", "", "params", "", "", "homeLotteryBean", "Lcom/huachenjie/base/bean/LotteryDrawBean;", "(Lcom/huachenjie/common/bean/SpineSuitModelBean;Lcom/huachenjie/common/bean/PetModelBean;ZLjava/util/Map;Lcom/huachenjie/base/bean/LotteryDrawBean;)V", "getHomeLotteryBean", "()Lcom/huachenjie/base/bean/LotteryDrawBean;", "setHomeLotteryBean", "(Lcom/huachenjie/base/bean/LotteryDrawBean;)V", "getOnlyPet", "()Z", "setOnlyPet", "(Z)V", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getPetSpineBean", "()Lcom/huachenjie/common/bean/PetModelBean;", "setPetSpineBean", "(Lcom/huachenjie/common/bean/PetModelBean;)V", "getSpineBean", "()Lcom/huachenjie/common/bean/SpineSuitModelBean;", "setSpineBean", "(Lcom/huachenjie/common/bean/SpineSuitModelBean;)V", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SpineWebBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SpineWebBean> CREATOR = new Creator();

    @Nullable
    private LotteryDrawBean homeLotteryBean;
    private boolean onlyPet;

    @Nullable
    private Map<String, String> params;

    @Nullable
    private PetModelBean petSpineBean;

    @Nullable
    private SpineSuitModelBean spineBean;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpineWebBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpineWebBean createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SpineSuitModelBean spineSuitModelBean = (SpineSuitModelBean) parcel.readParcelable(SpineWebBean.class.getClassLoader());
            PetModelBean petModelBean = (PetModelBean) parcel.readParcelable(SpineWebBean.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            return new SpineWebBean(spineSuitModelBean, petModelBean, z, linkedHashMap, parcel.readInt() != 0 ? LotteryDrawBean.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpineWebBean[] newArray(int i) {
            return new SpineWebBean[i];
        }
    }

    public SpineWebBean() {
        this(null, null, false, null, null, 31, null);
    }

    public SpineWebBean(@Nullable SpineSuitModelBean spineSuitModelBean, @Nullable PetModelBean petModelBean, boolean z, @Nullable Map<String, String> map, @Nullable LotteryDrawBean lotteryDrawBean) {
        this.spineBean = spineSuitModelBean;
        this.petSpineBean = petModelBean;
        this.onlyPet = z;
        this.params = map;
        this.homeLotteryBean = lotteryDrawBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpineWebBean copy$default(SpineWebBean spineWebBean, SpineSuitModelBean spineSuitModelBean, PetModelBean petModelBean, boolean z, Map map, LotteryDrawBean lotteryDrawBean, int i, Object obj) {
        if ((i & 1) != 0) {
            spineSuitModelBean = spineWebBean.spineBean;
        }
        if ((i & 2) != 0) {
            petModelBean = spineWebBean.petSpineBean;
        }
        PetModelBean petModelBean2 = petModelBean;
        if ((i & 4) != 0) {
            z = spineWebBean.onlyPet;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            map = spineWebBean.params;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            lotteryDrawBean = spineWebBean.homeLotteryBean;
        }
        return spineWebBean.copy(spineSuitModelBean, petModelBean2, z2, map2, lotteryDrawBean);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SpineSuitModelBean getSpineBean() {
        return this.spineBean;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PetModelBean getPetSpineBean() {
        return this.petSpineBean;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOnlyPet() {
        return this.onlyPet;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.params;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final LotteryDrawBean getHomeLotteryBean() {
        return this.homeLotteryBean;
    }

    @NotNull
    public final SpineWebBean copy(@Nullable SpineSuitModelBean spineBean, @Nullable PetModelBean petSpineBean, boolean onlyPet, @Nullable Map<String, String> params, @Nullable LotteryDrawBean homeLotteryBean) {
        return new SpineWebBean(spineBean, petSpineBean, onlyPet, params, homeLotteryBean);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpineWebBean)) {
            return false;
        }
        SpineWebBean spineWebBean = (SpineWebBean) other;
        return Intrinsics.areEqual(this.spineBean, spineWebBean.spineBean) && Intrinsics.areEqual(this.petSpineBean, spineWebBean.petSpineBean) && this.onlyPet == spineWebBean.onlyPet && Intrinsics.areEqual(this.params, spineWebBean.params) && Intrinsics.areEqual(this.homeLotteryBean, spineWebBean.homeLotteryBean);
    }

    @Nullable
    public final LotteryDrawBean getHomeLotteryBean() {
        return this.homeLotteryBean;
    }

    public final boolean getOnlyPet() {
        return this.onlyPet;
    }

    @Nullable
    public final Map<String, String> getParams() {
        return this.params;
    }

    @Nullable
    public final PetModelBean getPetSpineBean() {
        return this.petSpineBean;
    }

    @Nullable
    public final SpineSuitModelBean getSpineBean() {
        return this.spineBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        SpineSuitModelBean spineSuitModelBean = this.spineBean;
        int iHashCode = (spineSuitModelBean == null ? 0 : spineSuitModelBean.hashCode()) * 31;
        PetModelBean petModelBean = this.petSpineBean;
        int iHashCode2 = (iHashCode + (petModelBean == null ? 0 : petModelBean.hashCode())) * 31;
        boolean z = this.onlyPet;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        Map<String, String> map = this.params;
        int iHashCode3 = (i + (map == null ? 0 : map.hashCode())) * 31;
        LotteryDrawBean lotteryDrawBean = this.homeLotteryBean;
        return iHashCode3 + (lotteryDrawBean != null ? lotteryDrawBean.hashCode() : 0);
    }

    public final void setHomeLotteryBean(@Nullable LotteryDrawBean lotteryDrawBean) {
        this.homeLotteryBean = lotteryDrawBean;
    }

    public final void setOnlyPet(boolean z) {
        this.onlyPet = z;
    }

    public final void setParams(@Nullable Map<String, String> map) {
        this.params = map;
    }

    public final void setPetSpineBean(@Nullable PetModelBean petModelBean) {
        this.petSpineBean = petModelBean;
    }

    public final void setSpineBean(@Nullable SpineSuitModelBean spineSuitModelBean) {
        this.spineBean = spineSuitModelBean;
    }

    @NotNull
    public String toString() {
        return "SpineWebBean(spineBean=" + this.spineBean + ", petSpineBean=" + this.petSpineBean + ", onlyPet=" + this.onlyPet + ", params=" + this.params + ", homeLotteryBean=" + this.homeLotteryBean + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.spineBean, flags);
        parcel.writeParcelable(this.petSpineBean, flags);
        parcel.writeInt(this.onlyPet ? 1 : 0);
        Map<String, String> map = this.params;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
        LotteryDrawBean lotteryDrawBean = this.homeLotteryBean;
        if (lotteryDrawBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            lotteryDrawBean.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ SpineWebBean(SpineSuitModelBean spineSuitModelBean, PetModelBean petModelBean, boolean z, Map map, LotteryDrawBean lotteryDrawBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : spineSuitModelBean, (i & 2) != 0 ? null : petModelBean, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : lotteryDrawBean);
    }
}
