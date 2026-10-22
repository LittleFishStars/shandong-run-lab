package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.InvalidReason;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.SunshineRunServiceData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class wv8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SunshineRunServiceData f45698a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45699a;

        static {
            int[] iArr = new int[PauseTimerType.values().length];
            f45699a = iArr;
            try {
                iArr[PauseTimerType.REST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45699a[PauseTimerType.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45699a[PauseTimerType.SPEED_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45699a[PauseTimerType.FACE_RECOGNITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45699a[PauseTimerType.NFC_CHECK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public wv8(SunshineRunServiceData data) {
        this.f45698a = data;
    }

    public final long a() {
        if (c() <= 0) {
            return 0L;
        }
        return BigDecimal.valueOf(c()).divide(BigDecimal.valueOf(Math.max(0.01d, (d() * 1.0f) / 1000.0f)), 0, RoundingMode.HALF_UP).longValue();
    }

    public final long b() {
        return this.f45698a.getCurrentTime() + this.f45698a.getSaveCurrentTime();
    }

    public final long c() {
        return (this.f45698a.getCurrentTime() + this.f45698a.getSaveCurrentTime()) / 1000;
    }

    public final long d() {
        if (this.f45698a.getRunData() == null) {
            return 0L;
        }
        return this.f45698a.getRunData().getDistance();
    }

    public List<InvalidReason> e(int cheatType) {
        String strE;
        ArrayList arrayList = new ArrayList();
        if (this.f45698a.getSchoolRule() == null) {
            return arrayList;
        }
        if (cheatType == 6) {
            InvalidReason invalidReason = new InvalidReason();
            invalidReason.setInvalidType(25);
            invalidReason.setInvalidDetail(ys8.e(R.string.valid_reason_disable_gps));
            arrayList.add(invalidReason);
        }
        if (r()) {
            InvalidReason invalidReason2 = new InvalidReason();
            invalidReason2.setInvalidType(58);
            invalidReason2.setInvalidDetail(ys8.e(R.string.reason_section_step_distance_err));
            arrayList.add(invalidReason2);
        }
        if (d() < g()) {
            InvalidReason invalidReason3 = new InvalidReason();
            invalidReason3.setInvalidType(2);
            invalidReason3.setInvalidDetail(ys8.f(R.string.distance_not_completed, BigDecimal.valueOf(g()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString()));
            arrayList.add(invalidReason3);
        }
        if (this.f45698a.getClockMode() == 1) {
            int iK = k();
            int i = i();
            if (iK < n().getRequiredPointCounts()) {
                InvalidReason invalidReason4 = new InvalidReason();
                invalidReason4.setInvalidType(1);
                invalidReason4.setInvalidDetail(ys8.e(R.string.required_point_not_passed));
                arrayList.add(invalidReason4);
            } else if (i < n().getOptionalPointGoalCounts()) {
                InvalidReason invalidReason5 = new InvalidReason();
                invalidReason5.setInvalidType(1);
                invalidReason5.setInvalidDetail(String.format(ys8.e(R.string.some_point_not_completed), Integer.valueOf(iK + i), Integer.valueOf((n().getTotalGoalCounts() - iK) - i)));
                arrayList.add(invalidReason5);
            }
        } else if (q()) {
            int iJ = j();
            int size = (o() == null || o().getTargetPoints() == null) ? 0 : o().getTargetPoints().size();
            if (size <= 0) {
                size = 3;
            }
            int i2 = size - iJ;
            if (i2 > 0 && iJ < size) {
                InvalidReason invalidReason6 = new InvalidReason();
                invalidReason6.setInvalidType(1);
                invalidReason6.setInvalidDetail(String.format(ys8.e(R.string.some_point_not_completed), Integer.valueOf(iJ), Integer.valueOf(i2)));
                arrayList.add(invalidReason6);
            }
        }
        long jA = a();
        if (b() > 0 && !s(jA)) {
            InvalidReason invalidReason7 = new InvalidReason();
            invalidReason7.setInvalidType(3);
            boolean zIsRunActivityFlag = o().isRunActivityFlag();
            if (h() == 0 || jA >= h()) {
                strE = null;
            } else {
                strE = ys8.e(zIsRunActivityFlag ? R.string.invalid_reason_pace_too_fast_activity : R.string.invalid_reason_pace_too_fast_normal);
            }
            if (f() != 0 && jA > f()) {
                strE = ys8.e(zIsRunActivityFlag ? R.string.invalid_reason_pace_too_slow_activity : R.string.invalid_reason_pace_too_slow_normal);
            }
            if (strE != null) {
                invalidReason7.setInvalidDetail(ys8.c(strE, s72.e(f()), s72.e(h())));
            }
            arrayList.add(invalidReason7);
            if (l(PauseTimerType.SPEED_ERROR) <= 0) {
                InvalidReason invalidReason8 = new InvalidReason();
                invalidReason8.setInvalidType(53);
                if (this.f45698a.getCommonConfig() != null) {
                    invalidReason8.setInvalidDetail("跑步过程中，配速持续异常超过" + this.f45698a.getCommonConfig().getPaceAbnormalTime() + "秒");
                }
            }
        }
        return arrayList;
    }

    public final long f() {
        if (this.f45698a.getStartRunEntity() != null && this.f45698a.getStartRunEntity().isRunActivityFlag()) {
            return this.f45698a.getStartRunEntity().getActivityInfo().getActivityMaxPace();
        }
        if (m() != null) {
            return m().getMaxPace();
        }
        return 0L;
    }

    public final long g() {
        if (this.f45698a.getSportType() == 6) {
            return this.f45698a.getMoreTargetDistance();
        }
        if (this.f45698a.getStartRunEntity() != null && this.f45698a.getStartRunEntity().isRunActivityFlag()) {
            return this.f45698a.getStartRunEntity().getActivityInfo().getSingleMinDistance();
        }
        if (m() != null) {
            return m().getSingleMinDistance();
        }
        return 0L;
    }

    public final long h() {
        if (this.f45698a.getStartRunEntity() != null && this.f45698a.getStartRunEntity().isRunActivityFlag()) {
            return this.f45698a.getStartRunEntity().getActivityInfo().getActivityMinPace();
        }
        if (m() != null) {
            return m().getMinPace();
        }
        return 0L;
    }

    public final int i() {
        int i = 0;
        if (this.f45698a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f45698a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            for (TargetPoints targetPoints2 : targetPoints) {
                if (targetPoints2.getPassStatus() && targetPoints2.getType() == 1) {
                    i++;
                }
            }
        }
        return i;
    }

    public final int j() {
        int i = 0;
        if (this.f45698a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f45698a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            Iterator<TargetPoints> it = targetPoints.iterator();
            while (it.hasNext()) {
                if (it.next().getPassStatus()) {
                    i++;
                }
            }
        }
        return i;
    }

    public final int k() {
        int i = 0;
        if (this.f45698a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f45698a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            for (TargetPoints targetPoints2 : targetPoints) {
                if (targetPoints2.getPassStatus() && targetPoints2.getType() == 2) {
                    i++;
                }
            }
        }
        return i;
    }

    public final long l(@Nullable PauseTimerType type) {
        if (type == null) {
            return Math.min(Math.min(this.f45698a.getPauseLeftTime(), this.f45698a.getAutoPauseLeftTime()), this.f45698a.getSpeedErrPauseLeftTime());
        }
        int i = a.f45699a[type.ordinal()];
        if (i == 1) {
            return this.f45698a.getPauseLeftTime();
        }
        if (i == 2) {
            return this.f45698a.getAutoPauseLeftTime();
        }
        if (i == 3) {
            return this.f45698a.getSpeedErrPauseLeftTime();
        }
        if (i == 4) {
            return this.f45698a.getFaceCheckData().getFaceLeftTime();
        }
        if (i != 5) {
            return 0L;
        }
        return this.f45698a.getNfcCheckLeftTime();
    }

    public final SchoolRule m() {
        return this.f45698a.getSchoolRule();
    }

    public final GeoFenceDetail n() {
        return this.f45698a.getSchoolGeoFenceDetail();
    }

    public final StartRunEntity o() {
        return this.f45698a.getStartRunEntity();
    }

    public final boolean p() {
        return m() != null && m().isGpsWhiteFlag();
    }

    public final boolean q() {
        SunshineRunServiceData sunshineRunServiceData = this.f45698a;
        if (sunshineRunServiceData == null) {
            return false;
        }
        return 2 == sunshineRunServiceData.getClockMode() || 3 == this.f45698a.getClockMode();
    }

    public final boolean r() {
        return (this.f45698a.getRunData() == null || o() == null || (o().getCheatLevel() != 3 && o().getCheatLevel() != 4) || this.f45698a.getRunData().getLastSegmentStepExceptionNum() <= this.f45698a.getSegmentStrideExceptionNum() || o().isWhiteFlag() || p()) ? false : true;
    }

    public final boolean s(long pace) {
        if (this.f45698a.getSchoolRule() == null || f() == 0 || h() == 0) {
            return true;
        }
        return pace >= f() && pace <= h();
    }
}
