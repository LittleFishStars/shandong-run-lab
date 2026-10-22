package com.huachenjie.home.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.home.R;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u0097\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\u0006\u0010=\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u0005J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020\u0005J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\u0006\u0010D\u001a\u00020\fJ\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001f¨\u0006F"}, d2 = {"Lcom/huachenjie/home/bean/InspirationRecordBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "type", "", "name", "", "consumeTime", "consumeType", "occurMonth", "result", UserTrackConstant.JUMP_TYPE, "lottery", "", "inspirationValue", "", "source", "obtainTime", "obtainType", "hasNext", CollegeTownItemFragment.ITEM_TYPE, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getConsumeTime", "()Ljava/lang/String;", "getConsumeType", "getHasNext", "()Z", "setHasNext", "(Z)V", "getInspirationValue", "()J", "getItemType", "()I", "setItemType", "(I)V", "getJumpType", "getLottery", "getName", "getObtainTime", "getObtainType", "getOccurMonth", "getResult", "getSource", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "", "formatterConsumeInspiration", "formatterConsumeTime", "formatterGetInspiration", "formatterGetTime", "formatterResult", "formatterSource", "hashCode", "isNotOfficialRecord", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InspirationRecordBean implements MultiItemEntity {

    @NotNull
    private final String consumeTime;

    @NotNull
    private final String consumeType;
    private boolean hasNext;
    private final long inspirationValue;
    private int itemType;
    private final int jumpType;
    private final boolean lottery;

    @NotNull
    private final String name;

    @NotNull
    private final String obtainTime;

    @NotNull
    private final String obtainType;

    @NotNull
    private final String occurMonth;

    @NotNull
    private final String result;

    @Nullable
    private final String source;
    private final int type;

    public InspirationRecordBean() {
        this(0, null, null, null, null, null, 0, false, 0L, null, null, null, false, 0, 16383, null);
    }

    public InspirationRecordBean(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, boolean z, long j, @Nullable String str6, @NotNull String str7, @NotNull String str8, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "consumeTime");
        Intrinsics.checkNotNullParameter(str3, "consumeType");
        Intrinsics.checkNotNullParameter(str4, "occurMonth");
        Intrinsics.checkNotNullParameter(str5, "result");
        Intrinsics.checkNotNullParameter(str7, "obtainTime");
        Intrinsics.checkNotNullParameter(str8, "obtainType");
        this.type = i;
        this.name = str;
        this.consumeTime = str2;
        this.consumeType = str3;
        this.occurMonth = str4;
        this.result = str5;
        this.jumpType = i2;
        this.lottery = z;
        this.inspirationValue = j;
        this.source = str6;
        this.obtainTime = str7;
        this.obtainType = str8;
        this.hasNext = z2;
        this.itemType = i3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getObtainTime() {
        return this.obtainTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getObtainType() {
        return this.obtainType;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final int component14() {
        return getItemType();
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getConsumeTime() {
        return this.consumeTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getConsumeType() {
        return this.consumeType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOccurMonth() {
        return this.occurMonth;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getLottery() {
        return this.lottery;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getInspirationValue() {
        return this.inspirationValue;
    }

    @NotNull
    public final InspirationRecordBean copy(int type, @NotNull String name, @NotNull String consumeTime, @NotNull String consumeType, @NotNull String occurMonth, @NotNull String result, int jumpType, boolean lottery, long inspirationValue, @Nullable String source, @NotNull String obtainTime, @NotNull String obtainType, boolean hasNext, int itemType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(consumeTime, "consumeTime");
        Intrinsics.checkNotNullParameter(consumeType, "consumeType");
        Intrinsics.checkNotNullParameter(occurMonth, "occurMonth");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(obtainTime, "obtainTime");
        Intrinsics.checkNotNullParameter(obtainType, "obtainType");
        return new InspirationRecordBean(type, name, consumeTime, consumeType, occurMonth, result, jumpType, lottery, inspirationValue, source, obtainTime, obtainType, hasNext, itemType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InspirationRecordBean)) {
            return false;
        }
        InspirationRecordBean inspirationRecordBean = (InspirationRecordBean) other;
        return this.type == inspirationRecordBean.type && Intrinsics.areEqual(this.name, inspirationRecordBean.name) && Intrinsics.areEqual(this.consumeTime, inspirationRecordBean.consumeTime) && Intrinsics.areEqual(this.consumeType, inspirationRecordBean.consumeType) && Intrinsics.areEqual(this.occurMonth, inspirationRecordBean.occurMonth) && Intrinsics.areEqual(this.result, inspirationRecordBean.result) && this.jumpType == inspirationRecordBean.jumpType && this.lottery == inspirationRecordBean.lottery && this.inspirationValue == inspirationRecordBean.inspirationValue && Intrinsics.areEqual(this.source, inspirationRecordBean.source) && Intrinsics.areEqual(this.obtainTime, inspirationRecordBean.obtainTime) && Intrinsics.areEqual(this.obtainType, inspirationRecordBean.obtainType) && this.hasNext == inspirationRecordBean.hasNext && getItemType() == inspirationRecordBean.getItemType();
    }

    @NotNull
    public final String formatterConsumeInspiration() {
        String strF = ys8.f(R.string.home_inspiration_record_consume_inspiration, Long.valueOf(this.inspirationValue));
        Intrinsics.checkNotNullExpressionValue(strF, "getString(\n            R…nspirationValue\n        )");
        return strF;
    }

    @NotNull
    public final String formatterConsumeTime() {
        String strF = ys8.f(R.string.home_inspiration_record_consume, this.consumeTime);
        Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.home_…ord_consume, consumeTime)");
        return strF;
    }

    @NotNull
    public final String formatterGetInspiration() {
        String strF = ys8.f(R.string.home_inspiration_record_get_inspiration, Long.valueOf(this.inspirationValue));
        Intrinsics.checkNotNullExpressionValue(strF, "getString(\n            R…nspirationValue\n        )");
        return strF;
    }

    @NotNull
    public final String formatterGetTime() {
        String strF = ys8.f(R.string.home_inspiration_record_get, this.obtainTime);
        Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.home_…n_record_get, obtainTime)");
        return strF;
    }

    @NotNull
    public final String formatterResult() {
        if (this.jumpType == 0) {
            String strE = ys8.e(R.string.home_inspiration_record_win_none);
            Intrinsics.checkNotNullExpressionValue(strE, "{\n            StringUtil…ecord_win_none)\n        }");
            return strE;
        }
        String strE2 = ys8.e(R.string.home_inspiration_record_win);
        Intrinsics.checkNotNullExpressionValue(strE2, "{\n            StringUtil…ion_record_win)\n        }");
        return strE2;
    }

    @NotNull
    public final String formatterSource() {
        String strF = ys8.f(R.string.home_inspiration_record_source, this.source);
        Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.home_…on_record_source, source)");
        return strF;
    }

    @NotNull
    public final String getConsumeTime() {
        return this.consumeTime;
    }

    @NotNull
    public final String getConsumeType() {
        return this.consumeType;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final long getInspirationValue() {
        return this.inspirationValue;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final boolean getLottery() {
        return this.lottery;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getObtainTime() {
        return this.obtainTime;
    }

    @NotNull
    public final String getObtainType() {
        return this.obtainType;
    }

    @NotNull
    public final String getOccurMonth() {
        return this.occurMonth;
    }

    @NotNull
    public final String getResult() {
        return this.result;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((Integer.hashCode(this.type) * 31) + this.name.hashCode()) * 31) + this.consumeTime.hashCode()) * 31) + this.consumeType.hashCode()) * 31) + this.occurMonth.hashCode()) * 31) + this.result.hashCode()) * 31) + Integer.hashCode(this.jumpType)) * 31;
        boolean z = this.lottery;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + Long.hashCode(this.inspirationValue)) * 31;
        String str = this.source;
        int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.obtainTime.hashCode()) * 31) + this.obtainType.hashCode()) * 31;
        boolean z2 = this.hasNext;
        return ((iHashCode3 + (z2 ? 1 : z2)) * 31) + Integer.hashCode(getItemType());
    }

    public final boolean isNotOfficialRecord() {
        String str = this.source;
        if (str != null) {
            return str.length() > 0;
        }
        return false;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    @NotNull
    public String toString() {
        return "InspirationRecordBean(type=" + this.type + ", name=" + this.name + ", consumeTime=" + this.consumeTime + ", consumeType=" + this.consumeType + ", occurMonth=" + this.occurMonth + ", result=" + this.result + ", jumpType=" + this.jumpType + ", lottery=" + this.lottery + ", inspirationValue=" + this.inspirationValue + ", source=" + this.source + ", obtainTime=" + this.obtainTime + ", obtainType=" + this.obtainType + ", hasNext=" + this.hasNext + ", itemType=" + getItemType() + ')';
    }

    public /* synthetic */ InspirationRecordBean(int i, String str, String str2, String str3, String str4, String str5, int i2, boolean z, long j, String str6, String str7, String str8, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? 0L : j, (i4 & 512) != 0 ? "" : str6, (i4 & 1024) != 0 ? "" : str7, (i4 & 2048) == 0 ? str8 : "", (i4 & 4096) == 0 ? z2 : false, (i4 & 8192) != 0 ? 2 : i3);
    }
}
