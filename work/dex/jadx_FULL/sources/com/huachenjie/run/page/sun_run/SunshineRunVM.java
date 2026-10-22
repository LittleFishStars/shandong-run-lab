package com.huachenjie.run.page.sun_run;

import androidx.p002lifecycle.LiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Transformations;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.bean.SunshineRunServiceData;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.run.service.DataComponent;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.PaceErrorBigState;
import com.zj.adlib.kl7;
import com.zj.adlib.ll7;
import com.zj.adlib.r90;
import com.zj.adlib.s72;
import com.zj.adlib.y6b;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bf\u0010gJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J6\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR%\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001cR%\u0010\r\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR%\u0010\u000f\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001cR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b2\u0010\u001cR%\u0010\u0010\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b3\u0010\u001cR%\u0010\u0011\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b4\u0010\u001cR%\u00106\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00020\u00020\u00188\u0006¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b5\u0010\u001cR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\b078\u0006¢\u0006\f\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010:R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\b078\u0006¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b<\u0010:R%\u0010@\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b>\u0010\u001a\u001a\u0004\b?\u0010\u001cR%\u0010B\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u000e0\u000e0\u00188\u0006¢\u0006\f\n\u0004\b?\u0010\u001a\u001a\u0004\bA\u0010\u001cR\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\b078\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\bC\u0010:R%\u0010G\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\bE\u0010\u001a\u001a\u0004\bF\u0010\u001cR%\u0010J\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bH\u0010\u001a\u001a\u0004\bI\u0010\u001cR%\u0010L\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\bK\u0010\u001cR%\u0010M\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b(\u0010\u001a\u001a\u0004\bE\u0010\u001cR%\u0010N\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b>\u0010\u001cR%\u0010P\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bF\u0010\u001a\u001a\u0004\bO\u0010\u001cR%\u0010R\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bK\u0010\u001a\u001a\u0004\bQ\u0010\u001cR%\u0010U\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bS\u0010\u001a\u001a\u0004\bT\u0010\u001cR%\u0010X\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bV\u0010\u001a\u001a\u0004\bW\u0010\u001cR%\u0010Z\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\bY\u0010\u001a\u001a\u0004\bS\u0010\u001cR%\u0010\\\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b[\u0010\u001a\u001a\u0004\bV\u0010\u001cR%\u0010^\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b]\u0010\u001a\u001a\u0004\bH\u0010\u001cR%\u0010`\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b_\u0010\u001a\u001a\u0004\b_\u0010\u001cR%\u0010a\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\b0\b0\u00188\u0006¢\u0006\f\n\u0004\b9\u0010\u001a\u001a\u0004\b[\u0010\u001cR%\u0010b\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\u00188\u0006¢\u0006\f\n\u0004\b<\u0010\u001a\u001a\u0004\b]\u0010\u001cR%\u0010d\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010c0c0\u00188\u0006¢\u0006\f\n\u0004\b5\u0010\u001a\u001a\u0004\bY\u0010\u001cR\u0016\u0010e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00104¨\u0006h"}, d2 = {"Lcom/huachenjie/run/page/sun_run/SunshineRunVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", SchoolActivitySuccessActivity.x, "", "isPaceError", "isTooFast", "isSilence", "", "bigLimitText", "", "S", "activityVisible", "gpsDeviceOnly", "", "satelliteCount", "soundOn", "screenLocked", "showNormalMapIcon", "R", "j", "Lcom/huachenjie/run/service/DataComponent;", "dc", "i", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "M", "()Landroidx/lifecycle/MutableLiveData;", "sideTextString", "b", "s", "locationResult", "c", "k", "accuracyText", "d", "Q", "splashAdShowResult", "e", "r", "interstitialAdShowResult", "kotlin.jvm.PlatformType", "f", t.d, "activityRunVisible", y6b.f, "q", y6b.g, "I", "L", "N", "J", "D", "pauseSecs", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "B", "()Landroidx/lifecycle/LiveData;", "pauseMinText", "C", "pauseSecText", "m", "n", "distanceText", "G", "progressPercent", "H", "progressText", j.b, "t", "minKmText", "p", "K", "showMoreTarget", "u", "moreTargetKmText", "durationText", "disConditionDone", "E", "pointConditionDone", "F", "pointConditionVisible", "v", "O", "speedConditionDone", "w", "P", "speedConditionVisible", "x", "nfcConditionDone", "y", "nfcConditionVisible", j.o, "failStyle", "A", "paceText", "paceLimitText", "paceNormal", "Lcom/zj/adlib/yk6;", "paceErrorBigState", "lastBigErrViewDis", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRunVM extends BaseViewModel {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> paceText;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> paceLimitText;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> paceNormal;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PaceErrorBigState> paceErrorBigState;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long lastBigErrViewDis;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final LiveData<String> pauseMinText;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> pauseSecText;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> progressText;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> activityRunVisible;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> gpsDeviceOnly;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> satelliteCount;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showNormalMapIcon;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> soundOn;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> screenLocked;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Long> pauseSecs;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> distanceText;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> progressPercent;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> minKmText;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showMoreTarget;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> moreTargetKmText;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> durationText;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> disConditionDone;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> pointConditionDone;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> pointConditionVisible;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> speedConditionDone;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> speedConditionVisible;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> nfcConditionDone;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> nfcConditionVisible;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> failStyle;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> sideTextString = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> locationResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> accuracyText = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> splashAdShowResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> interstitialAdShowResult = new MutableLiveData<>();

    public SunshineRunVM() {
        Boolean bool = Boolean.FALSE;
        this.activityRunVisible = new MutableLiveData<>(bool);
        Boolean bool2 = Boolean.TRUE;
        this.gpsDeviceOnly = new MutableLiveData<>(bool2);
        this.satelliteCount = new MutableLiveData<>("0");
        this.showNormalMapIcon = new MutableLiveData<>(bool);
        this.soundOn = new MutableLiveData<>(bool2);
        this.screenLocked = new MutableLiveData<>(bool);
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>(120L);
        this.pauseSecs = mutableLiveData;
        this.pauseMinText = Transformations.map(mutableLiveData, new Function1<Long, String>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunVM$pauseMinText$1
            @NotNull
            public final String invoke(Long l) {
                return String.valueOf((l != null ? l.longValue() : 0L) / 60);
            }
        });
        this.pauseSecText = Transformations.map(mutableLiveData, new Function1<Long, String>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunVM$pauseSecText$1
            @NotNull
            public final String invoke(Long l) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[1];
                objArr[0] = Long.valueOf((l != null ? l.longValue() : 0L) % 60);
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                return str;
            }
        });
        this.distanceText = new MutableLiveData<>("0");
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>(0);
        this.progressPercent = mutableLiveData2;
        this.progressText = Transformations.map(mutableLiveData2, new Function1<Integer, String>() { // from class: com.huachenjie.run.page.sun_run.SunshineRunVM$progressText$1
            @NotNull
            public final String invoke(Integer num) {
                StringBuilder sb = new StringBuilder();
                sb.append(num);
                sb.append('%');
                return sb.toString();
            }
        });
        this.minKmText = new MutableLiveData<>("0km");
        this.showMoreTarget = new MutableLiveData<>(bool);
        this.moreTargetKmText = new MutableLiveData<>("");
        this.durationText = new MutableLiveData<>("00:00:00");
        this.disConditionDone = new MutableLiveData<>(bool);
        this.pointConditionDone = new MutableLiveData<>(bool);
        this.pointConditionVisible = new MutableLiveData<>(bool2);
        this.speedConditionDone = new MutableLiveData<>(bool);
        this.speedConditionVisible = new MutableLiveData<>(bool2);
        this.nfcConditionDone = new MutableLiveData<>(bool);
        this.nfcConditionVisible = new MutableLiveData<>(bool);
        this.failStyle = new MutableLiveData<>(bool);
        this.paceText = new MutableLiveData<>("0′00″");
        this.paceLimitText = new MutableLiveData<>("");
        this.paceNormal = new MutableLiveData<>(bool2);
        this.paceErrorBigState = new MutableLiveData<>(new PaceErrorBigState(false, false, 0, false, null, 31, null));
    }

    @NotNull
    public final MutableLiveData<String> A() {
        return this.paceText;
    }

    @NotNull
    public final LiveData<String> B() {
        return this.pauseMinText;
    }

    @NotNull
    public final LiveData<String> C() {
        return this.pauseSecText;
    }

    @NotNull
    public final MutableLiveData<Long> D() {
        return this.pauseSecs;
    }

    @NotNull
    public final MutableLiveData<Boolean> E() {
        return this.pointConditionDone;
    }

    @NotNull
    public final MutableLiveData<Boolean> F() {
        return this.pointConditionVisible;
    }

    @NotNull
    public final MutableLiveData<Integer> G() {
        return this.progressPercent;
    }

    @NotNull
    public final LiveData<String> H() {
        return this.progressText;
    }

    @NotNull
    public final MutableLiveData<String> I() {
        return this.satelliteCount;
    }

    @NotNull
    public final MutableLiveData<Boolean> J() {
        return this.screenLocked;
    }

    @NotNull
    public final MutableLiveData<Boolean> K() {
        return this.showMoreTarget;
    }

    @NotNull
    public final MutableLiveData<Boolean> L() {
        return this.showNormalMapIcon;
    }

    @NotNull
    public final MutableLiveData<String> M() {
        return this.sideTextString;
    }

    @NotNull
    public final MutableLiveData<Boolean> N() {
        return this.soundOn;
    }

    @NotNull
    public final MutableLiveData<Boolean> O() {
        return this.speedConditionDone;
    }

    @NotNull
    public final MutableLiveData<Boolean> P() {
        return this.speedConditionVisible;
    }

    @NotNull
    public final MutableLiveData<String> Q() {
        return this.splashAdShowResult;
    }

    public final void R(boolean activityVisible, boolean gpsDeviceOnly, int satelliteCount, boolean soundOn, boolean screenLocked, boolean showNormalMapIcon) {
        this.activityRunVisible.setValue(Boolean.valueOf(activityVisible));
        this.gpsDeviceOnly.setValue(Boolean.valueOf(gpsDeviceOnly));
        this.satelliteCount.setValue(String.valueOf(satelliteCount));
        this.soundOn.setValue(Boolean.valueOf(soundOn));
        this.screenLocked.setValue(Boolean.valueOf(screenLocked));
        this.showNormalMapIcon.setValue(Boolean.valueOf(showNormalMapIcon));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    public final void S(long distance, boolean isPaceError, boolean isTooFast, boolean isSilence, String bigLimitText) {
        boolean z;
        this.paceNormal.setValue(Boolean.valueOf(!isPaceError));
        CommonConfig commonConfigG = r90.g();
        int paceAbnormalTime = commonConfigG != null ? commonConfigG.getPaceAbnormalTime() : 0;
        PaceErrorBigState value = this.paceErrorBigState.getValue();
        boolean z2 = value != null && value.j();
        if (!isPaceError || paceAbnormalTime <= 0) {
            z = false;
        } else {
            if (!z2) {
                long j = this.lastBigErrViewDis;
                if (j != 0 && distance - j < 200) {
                    z = false;
                }
            }
            z = true;
        }
        if (z2 && !z) {
            this.lastBigErrViewDis = distance;
        }
        PaceErrorBigState paceErrorBigState = new PaceErrorBigState(z, isTooFast, paceAbnormalTime, isSilence, bigLimitText);
        if (Intrinsics.areEqual(this.paceErrorBigState.getValue(), paceErrorBigState)) {
            return;
        }
        this.paceErrorBigState.setValue(paceErrorBigState);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00be  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:52:0x0128  */
    /* JADX WARN: Code duplicated, block: B:64:0x0174  */
    /* JADX WARN: Code duplicated, block: B:70:0x018d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0206  */
    public final void i(@Nullable DataComponent dc) {
        MutableLiveData<String> mutableLiveData;
        String strJ;
        float fF1;
        int iValueOf;
        String strP;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (dc == null) {
            return;
        }
        long jS0 = dc.S0();
        Map mapN1 = dc.n1();
        if (mapN1 == null) {
            mapN1 = MapsKt.emptyMap();
        }
        Map map = mapN1;
        StartRunEntity startRunEntityS1 = dc.s1();
        boolean zC = kl7.f42851a.c(startRunEntityS1 != null ? startRunEntityS1.activityInfo : null, dc.p1());
        MutableLiveData<String> mutableLiveData2 = this.minKmText;
        ll7 ll7Var = ll7.f43096a;
        mutableLiveData2.setValue(ll7Var.j(Long.valueOf(dc.f1()), true, true, true, 1));
        this.distanceText.setValue(ll7Var.j(Long.valueOf(jS0), false, false, true, 3));
        SunshineRunServiceData sunshineRunServiceDataU1 = dc.u1();
        int moreTargetDistance = sunshineRunServiceDataU1 != null ? sunshineRunServiceDataU1.getMoreTargetDistance() : 0;
        boolean z4 = (sunshineRunServiceDataU1 != null && sunshineRunServiceDataU1.getRunDistanceMode() == 1) && moreTargetDistance > 0;
        this.showMoreTarget.setValue(Boolean.valueOf(z4));
        MutableLiveData<String> mutableLiveData3 = this.moreTargetKmText;
        String str2 = "";
        if (z4) {
            Long lValueOf = Long.valueOf(moreTargetDistance);
            mutableLiveData = mutableLiveData3;
            strJ = ll7Var.j(lValueOf, true, true, true, 1);
            if (strJ == null) {
            }
            mutableLiveData.setValue(strJ);
            if (dc.f1() > 0) {
                fF1 = (jS0 * 1.0f) / dc.f1();
            } else {
                fF1 = 0.0f;
            }
            MutableLiveData<Integer> mutableLiveData4 = this.progressPercent;
            if (fF1 >= 1.0f) {
                iValueOf = 100;
            } else {
                iValueOf = Integer.valueOf((int) (fF1 * 100));
            }
            mutableLiveData4.setValue(iValueOf);
            this.durationText.setValue(s72.o(dc.Q0(), true));
            MutableLiveData<String> mutableLiveData5 = this.paceText;
            if (jS0 == 0) {
                strP = "00'00''";
            } else {
                strP = ll7Var.p(dc.J0(), false);
            }
            mutableLiveData5.setValue(strP);
            MutableLiveData<String> mutableLiveData6 = this.paceLimitText;
            if (zC || dc.g1() == 0 || dc.e1() == 0) {
                str = "";
            } else {
                str = "配速要求：" + ll7Var.p(dc.e1(), false) + (char) 65374 + ll7Var.p(dc.g1(), false);
            }
            mutableLiveData6.setValue(str);
            if (zC && dc.g1() != 0 && dc.e1() != 0) {
                str2 = "当前配速要求" + ll7Var.p(dc.e1(), false) + (char) 65374 + ll7Var.p(dc.g1(), false);
            }
            if (zC || !dc.A1()) {
                z = false;
            } else {
                z = true;
            }
            if (dc.e1() != 0 || dc.J0() >= dc.e1()) {
                z2 = false;
            } else {
                z2 = true;
            }
            S(jS0, z, z2, dc.N1(), str2);
            MutableLiveData<Boolean> mutableLiveData7 = this.disConditionDone;
            Object obj = map.get("dis");
            Boolean bool = Boolean.TRUE;
            mutableLiveData7.setValue(Boolean.valueOf(Intrinsics.areEqual(obj, bool)));
            this.pointConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get(SQLiteMTAHelper.TABLE_POINT), bool)));
            this.speedConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get("speed"), bool)));
            this.nfcConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get("nfc"), bool)));
            MutableLiveData<Boolean> mutableLiveData8 = this.pointConditionVisible;
            if (startRunEntityS1 != null || startRunEntityS1.getClockMode() == 10 || dc.Q1() || dc.o1() == 30) {
                z3 = false;
            } else {
                z3 = true;
            }
            mutableLiveData8.setValue(Boolean.valueOf(z3));
            this.speedConditionVisible.setValue(Boolean.valueOf(zC));
            this.nfcConditionVisible.setValue(Boolean.valueOf(dc.w1()));
        }
        mutableLiveData = mutableLiveData3;
        strJ = "";
        mutableLiveData.setValue(strJ);
        if (dc.f1() > 0) {
            fF1 = (jS0 * 1.0f) / dc.f1();
        } else {
            fF1 = 0.0f;
        }
        MutableLiveData<Integer> mutableLiveData9 = this.progressPercent;
        if (fF1 >= 1.0f) {
            iValueOf = 100;
        } else {
            iValueOf = Integer.valueOf((int) (fF1 * 100));
        }
        mutableLiveData9.setValue(iValueOf);
        this.durationText.setValue(s72.o(dc.Q0(), true));
        MutableLiveData<String> mutableLiveData10 = this.paceText;
        if (jS0 == 0) {
            strP = "00'00''";
        } else {
            strP = ll7Var.p(dc.J0(), false);
        }
        mutableLiveData10.setValue(strP);
        MutableLiveData<String> mutableLiveData11 = this.paceLimitText;
        if (zC) {
            str = "";
        } else {
            str = "";
        }
        mutableLiveData11.setValue(str);
        if (zC) {
            str2 = "当前配速要求" + ll7Var.p(dc.e1(), false) + (char) 65374 + ll7Var.p(dc.g1(), false);
        }
        if (zC) {
            z = false;
        } else {
            z = false;
        }
        if (dc.e1() != 0) {
            z2 = false;
        } else {
            z2 = false;
        }
        S(jS0, z, z2, dc.N1(), str2);
        MutableLiveData<Boolean> mutableLiveData12 = this.disConditionDone;
        Object obj2 = map.get("dis");
        Boolean bool2 = Boolean.TRUE;
        mutableLiveData12.setValue(Boolean.valueOf(Intrinsics.areEqual(obj2, bool2)));
        this.pointConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get(SQLiteMTAHelper.TABLE_POINT), bool2)));
        this.speedConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get("speed"), bool2)));
        this.nfcConditionDone.setValue(Boolean.valueOf(Intrinsics.areEqual(map.get("nfc"), bool2)));
        MutableLiveData<Boolean> mutableLiveData13 = this.pointConditionVisible;
        if (startRunEntityS1 != null) {
            z3 = false;
        } else {
            z3 = false;
        }
        mutableLiveData13.setValue(Boolean.valueOf(z3));
        this.speedConditionVisible.setValue(Boolean.valueOf(zC));
        this.nfcConditionVisible.setValue(Boolean.valueOf(dc.w1()));
    }

    public final void j() {
        PaceErrorBigState value = this.paceErrorBigState.getValue();
        if (value != null && value.j()) {
            this.paceErrorBigState.setValue(PaceErrorBigState.g(value, false, false, 0, false, null, 30, null));
        }
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.accuracyText;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.activityRunVisible;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.disConditionDone;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.distanceText;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.durationText;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.failStyle;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.gpsDeviceOnly;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.interstitialAdShowResult;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.locationResult;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.minKmText;
    }

    @NotNull
    public final MutableLiveData<String> u() {
        return this.moreTargetKmText;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.nfcConditionDone;
    }

    @NotNull
    public final MutableLiveData<Boolean> w() {
        return this.nfcConditionVisible;
    }

    @NotNull
    public final MutableLiveData<PaceErrorBigState> x() {
        return this.paceErrorBigState;
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.paceLimitText;
    }

    @NotNull
    public final MutableLiveData<Boolean> z() {
        return this.paceNormal;
    }
}
