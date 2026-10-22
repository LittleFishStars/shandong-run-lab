package com.huachenjie.home.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006("}, d2 = {"Lcom/huachenjie/home/bean/SignBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "day", "", "today", "", "rewardAmount", "extraCoin", "signed", "fromSign", "(IZIIZZ)V", "getDay", "()I", "dayName", "", "getDayName", "()Ljava/lang/String;", "getExtraCoin", "getFromSign", "()Z", "setFromSign", "(Z)V", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "getRewardAmount", "getSigned", "setSigned", "getToday", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignBean implements MultiItemEntity {
    private final int day;
    private final int extraCoin;
    private boolean fromSign;
    private final int rewardAmount;
    private boolean signed;
    private final boolean today;

    public SignBean() {
        this(0, false, 0, 0, false, false, 63, null);
    }

    public SignBean(int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        this.day = i;
        this.today = z;
        this.rewardAmount = i2;
        this.extraCoin = i3;
        this.signed = z2;
        this.fromSign = z3;
    }

    public static /* synthetic */ SignBean copy$default(SignBean signBean, int i, boolean z, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = signBean.day;
        }
        if ((i4 & 2) != 0) {
            z = signBean.today;
        }
        boolean z4 = z;
        if ((i4 & 4) != 0) {
            i2 = signBean.rewardAmount;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = signBean.extraCoin;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            z2 = signBean.signed;
        }
        boolean z5 = z2;
        if ((i4 & 32) != 0) {
            z3 = signBean.fromSign;
        }
        return signBean.copy(i, z4, i5, i6, z5, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getToday() {
        return this.today;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getExtraCoin() {
        return this.extraCoin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getSigned() {
        return this.signed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getFromSign() {
        return this.fromSign;
    }

    @NotNull
    public final SignBean copy(int day, boolean today, int rewardAmount, int extraCoin, boolean signed, boolean fromSign) {
        return new SignBean(day, today, rewardAmount, extraCoin, signed, fromSign);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignBean)) {
            return false;
        }
        SignBean signBean = (SignBean) other;
        return this.day == signBean.day && this.today == signBean.today && this.rewardAmount == signBean.rewardAmount && this.extraCoin == signBean.extraCoin && this.signed == signBean.signed && this.fromSign == signBean.fromSign;
    }

    public final int getDay() {
        return this.day;
    }

    @NotNull
    public final String getDayName() {
        if (this.today) {
            return "今天";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) 31532);
        sb.append(this.day);
        sb.append((char) 22825);
        return sb.toString();
    }

    public final int getExtraCoin() {
        return this.extraCoin;
    }

    public final boolean getFromSign() {
        return this.fromSign;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return (this.day != 7 || this.extraCoin <= 0) ? 1 : 2;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final boolean getSigned() {
        return this.signed;
    }

    public final boolean getToday() {
        return this.today;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.day) * 31;
        boolean z = this.today;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((iHashCode + r1) * 31) + Integer.hashCode(this.rewardAmount)) * 31) + Integer.hashCode(this.extraCoin)) * 31;
        boolean z2 = this.signed;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.fromSign;
        return i + (z3 ? 1 : z3);
    }

    public final void setFromSign(boolean z) {
        this.fromSign = z;
    }

    public final void setSigned(boolean z) {
        this.signed = z;
    }

    @NotNull
    public String toString() {
        return "SignBean(day=" + this.day + ", today=" + this.today + ", rewardAmount=" + this.rewardAmount + ", extraCoin=" + this.extraCoin + ", signed=" + this.signed + ", fromSign=" + this.fromSign + ')';
    }

    public /* synthetic */ SignBean(int i, boolean z, int i2, int i3, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3);
    }
}
