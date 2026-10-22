package com.zj.adlib;

import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.run.page.rule.RuleV3Activity;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/kl7;", "", "Lcom/huachenjie/common/bean/ActivityRunDetailBean;", "activityInfo", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "runDetail", "", "e", "Lcom/huachenjie/common/bean/SchoolRule;", RuleV3Activity.x, "", "c", "Lcom/huachenjie/common/bean/StartRunEntity;", "startRunEntity", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "fenceDetail", "", "a", "d", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "b", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class kl7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kl7 f42851a = new kl7();

    public final int a(@Nullable StartRunEntity startRunEntity, @Nullable GeoFenceDetail fenceDetail) {
        if (startRunEntity != null) {
            return startRunEntity.getClockMode();
        }
        if (fenceDetail != null) {
            return fenceDetail.getClockMode();
        }
        return 2;
    }

    @Nullable
    public final HCJLatLng b(@Nullable StartRunEntity startRunEntity) {
        List<TargetPoints> targetPoints;
        if (((startRunEntity == null || (targetPoints = startRunEntity.getTargetPoints()) == null) ? 0 : targetPoints.size()) > 0) {
            Intrinsics.checkNotNull(startRunEntity);
            return new HCJLatLng(startRunEntity.getTargetPoints().get(0).getLat(), startRunEntity.getTargetPoints().get(0).getLng());
        }
        if (r90.o() != null) {
            return new HCJLatLng(r90.o().getLat(), r90.o().getLng());
        }
        return null;
    }

    public final boolean c(@Nullable ActivityRunDetailBean activityInfo, @Nullable SchoolRule schoolRule) {
        if (activityInfo == null) {
            return (schoolRule != null ? schoolRule.getMinPace() : 0L) > 0;
        }
        return activityInfo.getActivityMinPace() > 0;
    }

    public final boolean d(@Nullable StartRunEntity startRunEntity, @Nullable GeoFenceDetail fenceDetail) {
        return a(startRunEntity, fenceDetail) == 2 || a(startRunEntity, fenceDetail) == 3;
    }

    public final long e(@Nullable ActivityRunDetailBean activityInfo, @Nullable SunshineRunDetail runDetail) {
        SchoolRule schoolDemandRule;
        if (activityInfo != null) {
            return activityInfo.getSingleMinDistance();
        }
        if (runDetail == null || (schoolDemandRule = runDetail.getSchoolDemandRule()) == null) {
            return 0L;
        }
        return schoolDemandRule.getSingleMinDistance();
    }
}
