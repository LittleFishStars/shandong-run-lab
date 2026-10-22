package com.huachenjie.base.bean;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Ji\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\u0006\u0010/\u001a\u00020\u0005J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Lcom/huachenjie/base/bean/JackpotBean;", "Landroid/os/Parcelable;", "jackpotType", "", "jackpotName", "", "awardList", "", "Lcom/huachenjie/base/bean/AwardBean;", "jackpotNo", "jackpotRemarks", "jackpotUse", "lotteryDesc", "awardNo", "totalInspiration", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getAwardList", "()Ljava/util/List;", "getAwardNo", "()Ljava/lang/String;", "setAwardNo", "(Ljava/lang/String;)V", "getJackpotName", "getJackpotNo", "getJackpotRemarks", "getJackpotType", "()I", "getJackpotUse", "getLotteryDesc", "getTotalInspiration", "setTotalInspiration", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getLotteryType", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JackpotBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<JackpotBean> CREATOR = new Creator();

    @NotNull
    private final List<AwardBean> awardList;

    @NotNull
    private String awardNo;

    @NotNull
    private final String jackpotName;

    @NotNull
    private final String jackpotNo;

    @NotNull
    private final String jackpotRemarks;
    private final int jackpotType;
    private final int jackpotUse;

    @NotNull
    private final String lotteryDesc;
    private int totalInspiration;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<JackpotBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JackpotBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(AwardBean.CREATOR.createFromParcel(parcel));
            }
            return new JackpotBean(i, string, arrayList, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JackpotBean[] newArray(int i) {
            return new JackpotBean[i];
        }
    }

    public JackpotBean() {
        this(0, null, null, null, null, 0, null, null, 0, 511, null);
    }

    public JackpotBean(int i, @NotNull String str, @NotNull List<AwardBean> list, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull String str5, int i3) {
        Intrinsics.checkNotNullParameter(str, "jackpotName");
        Intrinsics.checkNotNullParameter(list, "awardList");
        Intrinsics.checkNotNullParameter(str2, "jackpotNo");
        Intrinsics.checkNotNullParameter(str3, "jackpotRemarks");
        Intrinsics.checkNotNullParameter(str4, "lotteryDesc");
        Intrinsics.checkNotNullParameter(str5, "awardNo");
        this.jackpotType = i;
        this.jackpotName = str;
        this.awardList = list;
        this.jackpotNo = str2;
        this.jackpotRemarks = str3;
        this.jackpotUse = i2;
        this.lotteryDesc = str4;
        this.awardNo = str5;
        this.totalInspiration = i3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getJackpotType() {
        return this.jackpotType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJackpotName() {
        return this.jackpotName;
    }

    @NotNull
    public final List<AwardBean> component3() {
        return this.awardList;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getJackpotNo() {
        return this.jackpotNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getJackpotRemarks() {
        return this.jackpotRemarks;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getJackpotUse() {
        return this.jackpotUse;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLotteryDesc() {
        return this.lotteryDesc;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAwardNo() {
        return this.awardNo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getTotalInspiration() {
        return this.totalInspiration;
    }

    @NotNull
    public final JackpotBean copy(int jackpotType, @NotNull String jackpotName, @NotNull List<AwardBean> awardList, @NotNull String jackpotNo, @NotNull String jackpotRemarks, int jackpotUse, @NotNull String lotteryDesc, @NotNull String awardNo, int totalInspiration) {
        Intrinsics.checkNotNullParameter(jackpotName, "jackpotName");
        Intrinsics.checkNotNullParameter(awardList, "awardList");
        Intrinsics.checkNotNullParameter(jackpotNo, "jackpotNo");
        Intrinsics.checkNotNullParameter(jackpotRemarks, "jackpotRemarks");
        Intrinsics.checkNotNullParameter(lotteryDesc, "lotteryDesc");
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        return new JackpotBean(jackpotType, jackpotName, awardList, jackpotNo, jackpotRemarks, jackpotUse, lotteryDesc, awardNo, totalInspiration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JackpotBean)) {
            return false;
        }
        JackpotBean jackpotBean = (JackpotBean) other;
        return this.jackpotType == jackpotBean.jackpotType && Intrinsics.areEqual(this.jackpotName, jackpotBean.jackpotName) && Intrinsics.areEqual(this.awardList, jackpotBean.awardList) && Intrinsics.areEqual(this.jackpotNo, jackpotBean.jackpotNo) && Intrinsics.areEqual(this.jackpotRemarks, jackpotBean.jackpotRemarks) && this.jackpotUse == jackpotBean.jackpotUse && Intrinsics.areEqual(this.lotteryDesc, jackpotBean.lotteryDesc) && Intrinsics.areEqual(this.awardNo, jackpotBean.awardNo) && this.totalInspiration == jackpotBean.totalInspiration;
    }

    @NotNull
    public final List<AwardBean> getAwardList() {
        return this.awardList;
    }

    @NotNull
    public final String getAwardNo() {
        return this.awardNo;
    }

    @NotNull
    public final String getJackpotName() {
        return this.jackpotName;
    }

    @NotNull
    public final String getJackpotNo() {
        return this.jackpotNo;
    }

    @NotNull
    public final String getJackpotRemarks() {
        return this.jackpotRemarks;
    }

    public final int getJackpotType() {
        return this.jackpotType;
    }

    public final int getJackpotUse() {
        return this.jackpotUse;
    }

    @NotNull
    public final String getLotteryDesc() {
        return this.lotteryDesc;
    }

    @NotNull
    public final String getLotteryType() {
        int i = this.jackpotType;
        if (i == 1) {
            return "初级";
        }
        if (i != 2) {
            return i != 3 ? "" : "必得";
        }
        return "高级";
    }

    public final int getTotalInspiration() {
        return this.totalInspiration;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.jackpotType) * 31) + this.jackpotName.hashCode()) * 31) + this.awardList.hashCode()) * 31) + this.jackpotNo.hashCode()) * 31) + this.jackpotRemarks.hashCode()) * 31) + Integer.hashCode(this.jackpotUse)) * 31) + this.lotteryDesc.hashCode()) * 31) + this.awardNo.hashCode()) * 31) + Integer.hashCode(this.totalInspiration);
    }

    public final void setAwardNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.awardNo = str;
    }

    public final void setTotalInspiration(int i) {
        this.totalInspiration = i;
    }

    @NotNull
    public String toString() {
        return "JackpotBean(jackpotType=" + this.jackpotType + ", jackpotName=" + this.jackpotName + ", awardList=" + this.awardList + ", jackpotNo=" + this.jackpotNo + ", jackpotRemarks=" + this.jackpotRemarks + ", jackpotUse=" + this.jackpotUse + ", lotteryDesc=" + this.lotteryDesc + ", awardNo=" + this.awardNo + ", totalInspiration=" + this.totalInspiration + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.jackpotType);
        parcel.writeString(this.jackpotName);
        List<AwardBean> list = this.awardList;
        parcel.writeInt(list.size());
        Iterator<AwardBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.jackpotNo);
        parcel.writeString(this.jackpotRemarks);
        parcel.writeInt(this.jackpotUse);
        parcel.writeString(this.lotteryDesc);
        parcel.writeString(this.awardNo);
        parcel.writeInt(this.totalInspiration);
    }

    public /* synthetic */ JackpotBean(int i, String str, List list, String str2, String str3, int i2, String str4, String str5, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? new ArrayList() : list, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? "" : str4, (i4 & 128) == 0 ? str5 : "", (i4 & 256) == 0 ? i3 : 0);
    }
}
