package com.huachenjie.run.page.activities_run;

import com.blankj.utilcode.util.ToastUtils;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.run.R;
import com.huachenjie.run.utils.StartRunUtils;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.lj0;
import com.zj.adlib.v05;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/huachenjie/run/page/activities_run/ActivityReadyActivity$initStartRunUtils$1", "Lcom/huachenjie/run/utils/StartRunUtils;", "checkLocation", "", "checkSchoolFence", "useHighAccuracy", "", "locationEnd", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityReadyActivity$initStartRunUtils$1 extends StartRunUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityReadyActivity f35771a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityReadyActivity$initStartRunUtils$1(ActivityReadyActivity activityReadyActivity, ActivityReadyVM activityReadyVM) {
        super(activityReadyActivity, activityReadyVM);
        this.f35771a = activityReadyActivity;
    }

    @Override // com.huachenjie.run.utils.StartRunUtils
    public void checkLocation() {
        if (!v05.a(this.f35771a)) {
            ToastUtils.T(R.string.location_once_failed);
            setStartRunBusy(false);
            return;
        }
        if (!this.f35771a.hasStartLocation) {
            this.f35771a.hasStartLocation = true;
            ActivityReadyActivity activityReadyActivity = this.f35771a;
            lj0.n(activityReadyActivity, 3000L, activityReadyActivity, null, false, 24, null);
            fv5.b("正在获取您的位置，请稍后再试");
            setStartRunBusy(false);
            return;
        }
        if (this.f35771a.mAddressInfo == null) {
            fv5.b("正在获取您的位置，请稍后再试");
            setStartRunBusy(false);
        } else {
            setAddressInfo(this.f35771a.mAddressInfo);
            locationEnd();
        }
    }

    @Override // com.huachenjie.run.utils.StartRunUtils
    public void checkSchoolFence(boolean useHighAccuracy) {
        if (getRunDetailBean().getSchoolDemandRule() == null || !getRunDetailBean().isValidStatus()) {
            fv5.a(R.string.run_out_of_semester_prompt);
            setStartRunBusy(false);
            return;
        }
        GeoFenceDetail value = ActivityReadyActivity.g0(this.f35771a).w().getValue();
        if (value != null) {
            HCJMapUtils hCJMapUtilsCreateMapUtils = HCJMapEntry.getInstance().createMapUtils();
            HCJAddressInfo addressInfo = getAddressInfo();
            Intrinsics.checkNotNull(addressInfo);
            double lat = addressInfo.getLat();
            HCJAddressInfo addressInfo2 = getAddressInfo();
            Intrinsics.checkNotNull(addressInfo2);
            if (hCJMapUtilsCreateMapUtils.containsLocation(new HCJLatLng(lat, addressInfo2.getLng()), value.getFenceList(), false)) {
                BaseViewModelExtKt.b(getVm(), false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.activities_run.ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$1
                    {
                        super(1);
                    }

                    @NotNull
                    public final Boolean invoke(@NotNull ResultException resultException) {
                        Intrinsics.checkNotNullParameter(resultException, o.f);
                        this.this$0.setStartRunBusy(false);
                        return Boolean.FALSE;
                    }
                }, null, new ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2(this.f35771a, this, useHighAccuracy, null), 11, null);
                return;
            }
        }
        DialogUtil.I(this.f35771a, "您不在指定围栏范围内", "你当前所在位置的不在活动指定围栏范围内，请前往活动指定围栏内再开始跑步", "我知道了", false, null);
        setStartRunBusy(false);
    }

    @Override // com.huachenjie.run.utils.StartRunUtils
    public void locationEnd() {
        locationSuccess(false);
    }
}
