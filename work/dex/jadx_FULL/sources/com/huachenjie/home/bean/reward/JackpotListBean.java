package com.huachenjie.home.bean.reward;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006)"}, d2 = {"Lcom/huachenjie/home/bean/reward/JackpotListBean;", "Landroid/os/Parcelable;", "jackpotType", "", "jackpotNo", "", "jackpotName", "awardList", "", "Lcom/huachenjie/home/bean/reward/AwardListBean;", "jackpotUse", "jackpotRemarks", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "getAwardList", "()Ljava/util/List;", "getJackpotName", "()Ljava/lang/String;", "getJackpotNo", "getJackpotRemarks", "getJackpotType", "()I", "getJackpotUse", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JackpotListBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<JackpotListBean> CREATOR = new Creator();

    @NotNull
    private final List<AwardListBean> awardList;

    @NotNull
    private final String jackpotName;

    @NotNull
    private final String jackpotNo;

    @NotNull
    private final String jackpotRemarks;
    private final int jackpotType;
    private final int jackpotUse;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<JackpotListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JackpotListBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(AwardListBean.CREATOR.createFromParcel(parcel));
            }
            return new JackpotListBean(i, string, string2, arrayList, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JackpotListBean[] newArray(int i) {
            return new JackpotListBean[i];
        }
    }

    public JackpotListBean() {
        this(0, null, null, null, 0, null, 63, null);
    }

    public JackpotListBean(int i, @NotNull String str, @NotNull String str2, @NotNull List<AwardListBean> list, int i2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "jackpotNo");
        Intrinsics.checkNotNullParameter(str2, "jackpotName");
        Intrinsics.checkNotNullParameter(list, "awardList");
        Intrinsics.checkNotNullParameter(str3, "jackpotRemarks");
        this.jackpotType = i;
        this.jackpotNo = str;
        this.jackpotName = str2;
        this.awardList = list;
        this.jackpotUse = i2;
        this.jackpotRemarks = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JackpotListBean copy$default(JackpotListBean jackpotListBean, int i, String str, String str2, List list, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = jackpotListBean.jackpotType;
        }
        if ((i3 & 2) != 0) {
            str = jackpotListBean.jackpotNo;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = jackpotListBean.jackpotName;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            list = jackpotListBean.awardList;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            i2 = jackpotListBean.jackpotUse;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            str3 = jackpotListBean.jackpotRemarks;
        }
        return jackpotListBean.copy(i, str4, str5, list2, i4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getJackpotType() {
        return this.jackpotType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJackpotNo() {
        return this.jackpotNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getJackpotName() {
        return this.jackpotName;
    }

    @NotNull
    public final List<AwardListBean> component4() {
        return this.awardList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getJackpotUse() {
        return this.jackpotUse;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getJackpotRemarks() {
        return this.jackpotRemarks;
    }

    @NotNull
    public final JackpotListBean copy(int jackpotType, @NotNull String jackpotNo, @NotNull String jackpotName, @NotNull List<AwardListBean> awardList, int jackpotUse, @NotNull String jackpotRemarks) {
        Intrinsics.checkNotNullParameter(jackpotNo, "jackpotNo");
        Intrinsics.checkNotNullParameter(jackpotName, "jackpotName");
        Intrinsics.checkNotNullParameter(awardList, "awardList");
        Intrinsics.checkNotNullParameter(jackpotRemarks, "jackpotRemarks");
        return new JackpotListBean(jackpotType, jackpotNo, jackpotName, awardList, jackpotUse, jackpotRemarks);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JackpotListBean)) {
            return false;
        }
        JackpotListBean jackpotListBean = (JackpotListBean) other;
        return this.jackpotType == jackpotListBean.jackpotType && Intrinsics.areEqual(this.jackpotNo, jackpotListBean.jackpotNo) && Intrinsics.areEqual(this.jackpotName, jackpotListBean.jackpotName) && Intrinsics.areEqual(this.awardList, jackpotListBean.awardList) && this.jackpotUse == jackpotListBean.jackpotUse && Intrinsics.areEqual(this.jackpotRemarks, jackpotListBean.jackpotRemarks);
    }

    @NotNull
    public final List<AwardListBean> getAwardList() {
        return this.awardList;
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

    public int hashCode() {
        return (((((((((Integer.hashCode(this.jackpotType) * 31) + this.jackpotNo.hashCode()) * 31) + this.jackpotName.hashCode()) * 31) + this.awardList.hashCode()) * 31) + Integer.hashCode(this.jackpotUse)) * 31) + this.jackpotRemarks.hashCode();
    }

    @NotNull
    public String toString() {
        return "JackpotListBean(jackpotType=" + this.jackpotType + ", jackpotNo=" + this.jackpotNo + ", jackpotName=" + this.jackpotName + ", awardList=" + this.awardList + ", jackpotUse=" + this.jackpotUse + ", jackpotRemarks=" + this.jackpotRemarks + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.jackpotType);
        parcel.writeString(this.jackpotNo);
        parcel.writeString(this.jackpotName);
        List<AwardListBean> list = this.awardList;
        parcel.writeInt(list.size());
        Iterator<AwardListBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.jackpotUse);
        parcel.writeString(this.jackpotRemarks);
    }

    public /* synthetic */ JackpotListBean(int i, String str, String str2, List list, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? new ArrayList() : list, (i3 & 16) == 0 ? i2 : 0, (i3 & 32) != 0 ? "" : str3);
    }
}
