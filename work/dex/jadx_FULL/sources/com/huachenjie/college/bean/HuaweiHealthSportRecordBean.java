package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003Jc\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\fHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/huachenjie/college/bean/HuaweiHealthSportRecordBean;", "", HWHealthSportDetailActivity.x, "", "sportType", "sportName", "logoUrl", "dataSource", "startTime", "", "distanceKm", "skipNum", "", "deducted", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IZ)V", "getDataSource", "()Ljava/lang/String;", "deductStr", "getDeductStr", "getDeducted", "()Z", "setDeducted", "(Z)V", "getDistanceKm", "getLogoUrl", "getSkipNum", "()I", "sportDesc", "getSportDesc", "getSportName", "getSportRecordCode", "sportTimeStr", "getSportTimeStr", "getSportType", "getStartTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuaweiHealthSportRecordBean {

    @NotNull
    private final String dataSource;
    private boolean deducted;

    @NotNull
    private final String distanceKm;

    @NotNull
    private final String logoUrl;
    private final int skipNum;

    @NotNull
    private final String sportName;

    @NotNull
    private final String sportRecordCode;

    @NotNull
    private final String sportType;
    private final long startTime;

    public HuaweiHealthSportRecordBean() {
        this(null, null, null, null, null, 0L, null, 0, false, 511, null);
    }

    public HuaweiHealthSportRecordBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, HWHealthSportDetailActivity.x);
        Intrinsics.checkNotNullParameter(str2, "sportType");
        Intrinsics.checkNotNullParameter(str3, "sportName");
        Intrinsics.checkNotNullParameter(str4, "logoUrl");
        Intrinsics.checkNotNullParameter(str5, "dataSource");
        Intrinsics.checkNotNullParameter(str6, "distanceKm");
        this.sportRecordCode = str;
        this.sportType = str2;
        this.sportName = str3;
        this.logoUrl = str4;
        this.dataSource = str5;
        this.startTime = j;
        this.distanceKm = str6;
        this.skipNum = i;
        this.deducted = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSportRecordCode() {
        return this.sportRecordCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSportType() {
        return this.sportType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSportName() {
        return this.sportName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDataSource() {
        return this.dataSource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSkipNum() {
        return this.skipNum;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getDeducted() {
        return this.deducted;
    }

    @NotNull
    public final HuaweiHealthSportRecordBean copy(@NotNull String sportRecordCode, @NotNull String sportType, @NotNull String sportName, @NotNull String logoUrl, @NotNull String dataSource, long startTime, @NotNull String distanceKm, int skipNum, boolean deducted) {
        Intrinsics.checkNotNullParameter(sportRecordCode, HWHealthSportDetailActivity.x);
        Intrinsics.checkNotNullParameter(sportType, "sportType");
        Intrinsics.checkNotNullParameter(sportName, "sportName");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(distanceKm, "distanceKm");
        return new HuaweiHealthSportRecordBean(sportRecordCode, sportType, sportName, logoUrl, dataSource, startTime, distanceKm, skipNum, deducted);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuaweiHealthSportRecordBean)) {
            return false;
        }
        HuaweiHealthSportRecordBean huaweiHealthSportRecordBean = (HuaweiHealthSportRecordBean) other;
        return Intrinsics.areEqual(this.sportRecordCode, huaweiHealthSportRecordBean.sportRecordCode) && Intrinsics.areEqual(this.sportType, huaweiHealthSportRecordBean.sportType) && Intrinsics.areEqual(this.sportName, huaweiHealthSportRecordBean.sportName) && Intrinsics.areEqual(this.logoUrl, huaweiHealthSportRecordBean.logoUrl) && Intrinsics.areEqual(this.dataSource, huaweiHealthSportRecordBean.dataSource) && this.startTime == huaweiHealthSportRecordBean.startTime && Intrinsics.areEqual(this.distanceKm, huaweiHealthSportRecordBean.distanceKm) && this.skipNum == huaweiHealthSportRecordBean.skipNum && this.deducted == huaweiHealthSportRecordBean.deducted;
    }

    @NotNull
    public final String getDataSource() {
        return this.dataSource;
    }

    @NotNull
    public final String getDeductStr() {
        return this.deducted ? "已抵扣" : "未抵扣";
    }

    public final boolean getDeducted() {
        return this.deducted;
    }

    @NotNull
    public final String getDistanceKm() {
        return this.distanceKm;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final int getSkipNum() {
        return this.skipNum;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if (r0.equals("RUNNING") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return "运动里程：" + r2.distanceKm + "km";
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r0.equals("CYCLING") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0.equals("SWIMMING") != false) goto L18;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getSportDesc() {
        String str = this.sportType;
        switch (str.hashCode()) {
            case -2026200673:
                break;
            case -793726365:
                if (str.equals("JUMP_ROPE")) {
                    return "个数：" + this.skipNum;
                }
                return "";
            case 691184349:
                break;
            case 1945411587:
                break;
            default:
                return "";
        }
    }

    @NotNull
    public final String getSportName() {
        return this.sportName;
    }

    @NotNull
    public final String getSportRecordCode() {
        return this.sportRecordCode;
    }

    @NotNull
    public final String getSportTimeStr() {
        String str = new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault()).format(new Date(this.startTime));
        Intrinsics.checkNotNullExpressionValue(str, "SimpleDateFormat(\"MM/dd …).format(Date(startTime))");
        return str;
    }

    @NotNull
    public final String getSportType() {
        return this.sportType;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.sportRecordCode.hashCode() * 31) + this.sportType.hashCode()) * 31) + this.sportName.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.dataSource.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + this.distanceKm.hashCode()) * 31) + Integer.hashCode(this.skipNum)) * 31;
        boolean z = this.deducted;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setDeducted(boolean z) {
        this.deducted = z;
    }

    @NotNull
    public String toString() {
        return "HuaweiHealthSportRecordBean(sportRecordCode=" + this.sportRecordCode + ", sportType=" + this.sportType + ", sportName=" + this.sportName + ", logoUrl=" + this.logoUrl + ", dataSource=" + this.dataSource + ", startTime=" + this.startTime + ", distanceKm=" + this.distanceKm + ", skipNum=" + this.skipNum + ", deducted=" + this.deducted + ')';
    }

    public /* synthetic */ HuaweiHealthSportRecordBean(String str, String str2, String str3, String str4, String str5, long j, String str6, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? str6 : "", (i2 & 128) != 0 ? 0 : i, (i2 & 256) == 0 ? z : false);
    }
}
