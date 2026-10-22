package com.huachenjie.run.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.acse.ottn.activity.AcseHelpManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hjq.permissions.Permission;
import com.huachenjie.base.aliyun.detect_face.DetectFaceFragment;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.bean.UsableGeoFence;
import com.huachenjie.common.constants.ErrorCode;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.dialog.LocationCountDownDialog;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.CheatResult;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.dialog.AlipayBindTipDialog;
import com.huachenjie.run.dialog.NfcCheckInTipDialog;
import com.huachenjie.run.model.RunRequestModel;
import com.huachenjie.run.page.MorePermissionActivity;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.activities_run.dialog.GPSErrorDialog;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.utils.StartRunUtils;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.en7;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.iy5;
import com.zj.adlib.lj0;
import com.zj.adlib.m55;
import com.zj.adlib.oj1;
import com.zj.adlib.r90;
import com.zj.adlib.v05;
import com.zj.adlib.vl2;
import com.zj.adlib.vo6;
import com.zj.adlib.ws1;
import com.zj.adlib.ye3;
import com.zj.adlib.yj7;
import com.zj.adlib.ys8;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010A\u001a\u00020=¢\u0006\u0004\b{\u0010|J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u001a\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u001a\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$H\u0002JZ\u00102\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010-\u001a\u00020,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u00182\u0006\u00101\u001a\u00020\u0010J\b\u00103\u001a\u00020\u0004H\u0014J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0014J\u001a\u00105\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0010H\u0004J\b\u00106\u001a\u00020\u0004H\u0014J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0004J\u000e\u00108\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0016R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010A\u001a\u00020=8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b:\u0010>\u001a\u0004\b?\u0010@R\"\u0010C\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR)\u0010L\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u000109090G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010I\u001a\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010NR+\u0010'\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR+\u0010)\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR+\u0010(\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010Q\u001a\u0004\bZ\u0010S\"\u0004\b[\u0010UR+\u0010*\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00168B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010Q\u001a\u0004\b]\u0010S\"\u0004\b^\u0010UR\u0018\u0010+\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010_R\"\u0010-\u001a\u00020,8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b:\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010eR\u0018\u00100\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010_R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010BR$\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020g\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010hR$\u0010p\u001a\u0004\u0018\u00010j8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR0\u0010w\u001a\u0010\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR0\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010r\u001a\u0004\bx\u0010t\"\u0004\by\u0010v¨\u0006}"}, d2 = {"Lcom/huachenjie/run/utils/StartRunUtils;", "", "Lcom/huachenjie/common/util/permission/PermissionResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "A", "x", "B", "Lcom/huachenjie/run/bean/StartRunPageParam;", "param", "F", "C", "K", "N", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", "e", "", "W", "n0", "Lcom/huachenjie/common/bean/UnfinishedRun;", "unfinishedRun", "X", "", "type", "", "runRecordCode", "d0", "checkData", "o0", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "currentFence", "useHighAccuracy", "c0", "Lcom/huachenjie/common/bean/AlertTip;", yj7.a.ALERT_TIP, "G", "Lkotlin/Function0;", "onComplete", "b0", "sportType", "goalMode", "minDistance", "targetDis", "activityRunCode", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "runDetailBean", "", "geoFenceList", "runPlanCode", ReadyActivity.t, "l0", "checkLocation", "checkSchoolFence", "checkUnFinishedRun", "locationEnd", "locationSuccess", "O", "Landroidx/appcompat/app/AppCompatActivity;", "a", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "getVm", "()Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "vm", "Z", "isStartRunBusy", "()Z", "setStartRunBusy", "(Z)V", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "T", "()Lcom/huachenjie/common/permission/RequiredSettingComponent;", "requiredSettingComponent", "Lcom/huachenjie/common/dialog/LocationCountDownDialog;", "Lcom/huachenjie/common/dialog/LocationCountDownDialog;", "gpsIngDialog", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", "U", "()I", "j0", "(I)V", "b", "R", "h0", "c", "P", "f0", "d", "V", "k0", "Ljava/lang/String;", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "getRunDetailBean", "()Lcom/huachenjie/common/bean/SunshineRunDetail;", "setRunDetailBean", "(Lcom/huachenjie/common/bean/SunshineRunDetail;)V", "Ljava/util/List;", "", "Lcom/huachenjie/run/bean/CheatResult;", "Ljava/util/Map;", "cheatResults", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "getAddressInfo", "()Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "setAddressInfo", "(Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;)V", "addressInfo", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "Q", "()Lkotlin/jvm/functions/Function1;", "g0", "(Lkotlin/jvm/functions/Function1;)V", "locationSuccessCallback", "S", "i0", "onMatchedFence", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;)V", "run_release"}, k = 1, mv = {1, 8, 0})
public class StartRunUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f36004a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartRunUtils.class, "sportType", "getSportType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartRunUtils.class, "minDistance", "getMinDistance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartRunUtils.class, "goalMode", "getGoalMode()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartRunUtils.class, "targetDis", "getTargetDis()I", 0))};

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AppCompatActivity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public SunshineRunDetail runDetailBean;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public LocationCountDownDialog gpsIngDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final BaseViewModel vm;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJAddressInfo addressInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String activityRunCode;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public List<? extends GeoFenceDetail> geoFenceList;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Map<Integer, CheatResult> cheatResults;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy requiredSettingComponent;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super HCJAddressInfo, Unit> locationSuccessCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ReadWriteProperty sportType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isStartRunBusy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public String runPlanCode;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super GeoFenceDetail, Unit> onMatchedFence;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ReadWriteProperty minDistance;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean useCreditSword;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final ReadWriteProperty goalMode;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final ReadWriteProperty targetDis;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StartRunPageParam f36005a;

        public a(StartRunPageParam startRunPageParam) {
            this.f36005a = startRunPageParam;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            StartRunUtils.this.setStartRunBusy(false);
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            StartRunUtils.this.C(this.f36005a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$b", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StartRunPageParam f36006a;

        public b(StartRunPageParam startRunPageParam) {
            this.f36006a = startRunPageParam;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            StartRunUtils.this.setStartRunBusy(false);
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            StartRunUtils.this.C(this.f36006a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {
        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            ARouter.getInstance().build(RoutePathConstants.Run.c).navigation();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.utils.StartRunUtils$checkSchoolFence$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.run.utils.StartRunUtils$checkSchoolFence$3", f = "StartRunUtils.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, GeoFenceDetail> $fenceMap;
        final /* synthetic */ boolean $useHighAccuracy;
        int label;
        final /* synthetic */ StartRunUtils this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Map<String, ? extends GeoFenceDetail> map, StartRunUtils startRunUtils, boolean z, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$fenceMap = map;
            this.this$0 = startRunUtils;
            this.$useHighAccuracy = z;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass3(this.$fenceMap, this.this$0, this.$useHighAccuracy, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RunRequestModel runRequestModel = RunRequestModel.f35764a;
                Map<String, GeoFenceDetail> map = this.$fenceMap;
                this.label = 1;
                obj = runRequestModel.g(map, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UsableGeoFence usableGeoFence = (UsableGeoFence) obj;
            String fenceCode = usableGeoFence != null ? usableGeoFence.getFenceCode() : null;
            if (fenceCode != null && fenceCode.length() != 0) {
                z = false;
            }
            if (!z) {
                Map<String, GeoFenceDetail> map2 = this.$fenceMap;
                Intrinsics.checkNotNull(usableGeoFence);
                if (map2.containsKey(usableGeoFence.getFenceCode()) && this.$fenceMap.get(usableGeoFence.getFenceCode()) != null) {
                    GeoFenceDetail geoFenceDetail = this.$fenceMap.get(usableGeoFence.getFenceCode());
                    Intrinsics.checkNotNull(geoFenceDetail);
                    if (geoFenceDetail.getClockMode() == 0) {
                        fv5.a(R.string.clock_mode_config_error);
                        this.this$0.setStartRunBusy(false);
                        return Unit.INSTANCE;
                    }
                    Function1<GeoFenceDetail, Unit> function1S = this.this$0.S();
                    if (function1S != null) {
                        function1S.invoke(geoFenceDetail);
                    }
                    this.this$0.checkUnFinishedRun(geoFenceDetail, this.$useHighAccuracy);
                    return Unit.INSTANCE;
                }
            }
            fv5.b("没有匹配到对应的围栏");
            this.this$0.setStartRunBusy(false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.utils.StartRunUtils$checkUnFinishedRun$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.run.utils.StartRunUtils$checkUnFinishedRun$2", f = "StartRunUtils.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GeoFenceDetail $currentFence;
        final /* synthetic */ boolean $useHighAccuracy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14722(GeoFenceDetail geoFenceDetail, boolean z, Continuation<? super C14722> continuation) {
            super(2, continuation);
            this.$currentFence = geoFenceDetail;
            this.$useHighAccuracy = z;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return StartRunUtils.this.new C14722(this.$currentFence, this.$useHighAccuracy, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RunRequestModel runRequestModel = RunRequestModel.f35764a;
                int iU = StartRunUtils.this.U();
                this.label = 1;
                obj = runRequestModel.e(iU, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UnfinishedRun unfinishedRun = (UnfinishedRun) obj;
            if (unfinishedRun == null) {
                StartRunUtils.this.c0(this.$currentFence, this.$useHighAccuracy);
            } else {
                StartRunUtils.this.X(unfinishedRun);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$d", "Lcom/huachenjie/run/utils/StopRunUtils$StopCallback;", "", "onFinish", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements StopRunUtils.StopCallback {
        public d() {
        }

        @Override // com.huachenjie.run.utils.StopRunUtils.StopCallback
        public void onFinish() {
            StartRunUtils.this.setStartRunBusy(false);
        }
    }

    public StartRunUtils(@NotNull AppCompatActivity appCompatActivity, @NotNull BaseViewModel baseViewModel) {
        Intrinsics.checkNotNullParameter(appCompatActivity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(baseViewModel, "vm");
        this.activity = appCompatActivity;
        this.vm = baseViewModel;
        this.requiredSettingComponent = LazyKt.lazy(new Function0<RequiredSettingComponent<AppCompatActivity>>() { // from class: com.huachenjie.run.utils.StartRunUtils$requiredSettingComponent$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RequiredSettingComponent<AppCompatActivity> m734invoke() {
                return new RequiredSettingComponent<>(this.this$0.activity);
            }
        });
        Delegates delegates = Delegates.INSTANCE;
        this.sportType = delegates.notNull();
        this.minDistance = delegates.notNull();
        this.goalMode = delegates.notNull();
        this.targetDis = delegates.notNull();
        appCompatActivity.getLifecycle().addObserver(T());
    }

    public static final void D(StartRunUtils startRunUtils, StartRunPageParam startRunPageParam, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        Intrinsics.checkNotNullParameter(startRunPageParam, "$param");
        startRunUtils.K(startRunPageParam);
    }

    public static final void E(StartRunPageParam startRunPageParam, StartRunUtils startRunUtils, View view) {
        String faceImg;
        Intrinsics.checkNotNullParameter(startRunPageParam, "$param");
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        if (startRunPageParam.getFaceEnabled() != 1) {
            fv5.b("您已关闭人脸识别功能，本学期暂不支持上传照片");
        } else {
            if (startRunPageParam.getFaceCheckData().getFaceImg() == null) {
                faceImg = "";
            } else {
                faceImg = startRunPageParam.getFaceCheckData().getFaceImg();
                Intrinsics.checkNotNull(faceImg);
            }
            com.huachenjie.base.aliyun.detect_face.a.a(new UserFaceBean(1, faceImg, startRunPageParam.getFaceCheckData().getSimilarityValue(), startRunPageParam.getFaceCheckData().getFaceAuth(), "", startRunPageParam.getFaceCheckData().getFaceTime(), startRunPageParam.getFaceCheckData().getFaceTime(), startRunPageParam.getFaceCheckData().getBodyEnable(), startRunPageParam.getFaceCheckData().getBodyRate(), startRunPageParam.getFaceCheckData().getFaceModelType(), startRunPageParam.getFaceCheckData().getCurrentFaceCheckIndex())).showNow(startRunUtils.activity.getSupportFragmentManager(), DetectFaceFragment.class.getSimpleName());
        }
        startRunUtils.isStartRunBusy = false;
    }

    public static final void H(StartRunUtils startRunUtils) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        startRunUtils.isStartRunBusy = false;
    }

    public static final void I(StartRunUtils startRunUtils) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        startRunUtils.isStartRunBusy = false;
    }

    public static final void J(StartRunUtils startRunUtils) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        startRunUtils.isStartRunBusy = false;
        Activity activityM = ActivityLifecycleManager.l().m();
        if (activityM != null) {
            activityM.finish();
        }
    }

    public static final void L(StartRunUtils startRunUtils, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        startRunUtils.isStartRunBusy = false;
    }

    public static final void M(StartRunUtils startRunUtils, StartRunPageParam startRunPageParam, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        Intrinsics.checkNotNullParameter(startRunPageParam, "$param");
        startRunUtils.N(startRunPageParam);
    }

    public static final void Y(StartRunUtils startRunUtils, UnfinishedRun unfinishedRun, int i, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        Intrinsics.checkNotNullParameter(unfinishedRun, "$unfinishedRun");
        startRunUtils.o0(unfinishedRun, i);
    }

    public static final void Z(StartRunUtils startRunUtils, UnfinishedRun unfinishedRun, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        Intrinsics.checkNotNullParameter(unfinishedRun, "$unfinishedRun");
        startRunUtils.d0(unfinishedRun.getSportType(), unfinishedRun.getRunRecordCode());
    }

    public static final void a0(StartRunUtils startRunUtils, UnfinishedRun unfinishedRun, int i, View view) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        Intrinsics.checkNotNullParameter(unfinishedRun, "$unfinishedRun");
        startRunUtils.o0(unfinishedRun, i);
    }

    public static final void e0(final StartRunUtils startRunUtils, int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        if (!z) {
            startRunUtils.isStartRunBusy = false;
        } else if (startRunUtils.activity.isFinishing() || startRunUtils.activity.isDestroyed()) {
            startRunUtils.isStartRunBusy = false;
        } else {
            BaseViewModelExtKt.b(startRunUtils.vm, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.utils.StartRunUtils$resumeRun$1$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.setStartRunBusy(false);
                    return Boolean.FALSE;
                }
            }, null, new StartRunUtils$resumeRun$1$2(i, str, startRunUtils, null), 11, null);
        }
    }

    public static final void m0(StartRunUtils startRunUtils, boolean z) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        if (!z) {
            startRunUtils.isStartRunBusy = false;
        } else if (startRunUtils.activity.isFinishing() || startRunUtils.activity.isDestroyed()) {
            startRunUtils.isStartRunBusy = false;
        } else {
            startRunUtils.x();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void y(StartRunUtils startRunUtils, String str) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        if (startRunUtils.activity.isFinishing() || startRunUtils.activity.isDestroyed()) {
            startRunUtils.isStartRunBusy = false;
            return;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case 48:
                    if (!str.equals("0")) {
                        return;
                    }
                    startRunUtils.B();
                    return;
                case 49:
                    if (!str.equals("1")) {
                        return;
                    }
                    break;
                case 50:
                    if (!str.equals("2")) {
                        return;
                    }
                    startRunUtils.B();
                    return;
                case 51:
                    if (!str.equals("3")) {
                        return;
                    }
                    break;
                case 52:
                    if (!str.equals("4")) {
                        return;
                    }
                    startRunUtils.B();
                    return;
                default:
                    return;
            }
            startRunUtils.activity.startActivity(new Intent(startRunUtils.activity, (Class<?>) MorePermissionActivity.class));
            startRunUtils.isStartRunBusy = false;
        }
    }

    public static final void z(StartRunUtils startRunUtils, int i, HCJAddressInfo hCJAddressInfo) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        if (i != 0 || hCJAddressInfo == null) {
            return;
        }
        startRunUtils.addressInfo = hCJAddressInfo;
        if (hCJAddressInfo.getGpsStatus() == 1) {
            startRunUtils.locationEnd();
        }
    }

    public final void A(PermissionResultListener listener) {
        if (!vo6.a(this.activity)) {
            T().d(1);
            listener.onResult(false);
        } else if (vo6.c(this.activity, Permission.POST_NOTIFICATIONS)) {
            en7.e(this.activity, listener);
        } else {
            T().d(2);
            listener.onResult(false);
        }
    }

    public final void B() {
        int iA = iy5.a(this.activity);
        SchoolRule schoolDemandRule = getRunDetailBean().getSchoolDemandRule();
        boolean z = true;
        if ((schoolDemandRule != null && schoolDemandRule.isForbiddenWiFi()) && 1 == iA) {
            fv5.a(R.string.use_wifi_warn);
            this.isStartRunBusy = false;
            return;
        }
        Map<Integer, CheatResult> mapA = oj1.f43759a.a(this.activity);
        this.cheatResults = mapA;
        if (mapA != null && !mapA.isEmpty()) {
            z = false;
        }
        if (z) {
            checkLocation();
        } else {
            this.isStartRunBusy = false;
        }
    }

    public final void C(final StartRunPageParam param) {
        if (param.getRunScene() != 20 || param.getFaceCheckData().getFaceAuth()) {
            K(param);
            return;
        }
        SpannableString spannableString = new SpannableString("您好，学校已开启人脸识别功能，请先完成人脸认证后开启跑步，取消认证会影响跑步成绩。");
        int iIndexOf$default = StringsKt.indexOf$default(spannableString, "会影响跑步成绩。", 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF3474A")), iIndexOf$default, iIndexOf$default + 8, 34);
        ws1.Z(this.activity).U(R.style.confirm_dialog_theme).R(R.layout.dialog_confirm_box).X("人脸认证").Q(spannableString).F(OptionsPickerHelper.e).N("立即认证").C(new View.OnClickListener() { // from class: com.zj.adlib.iq8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRunUtils.D(this.f17256a, param, view);
            }
        }).J(new View.OnClickListener() { // from class: com.zj.adlib.jq8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRunUtils.E(param, this, view);
            }
        }).Y();
    }

    public final void F(StartRunPageParam param) {
        BaseViewModelExtKt.b(this.vm, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.utils.StartRunUtils$checkRunRule$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, "e");
                if ((resultException instanceof ResultException.ApiException) && this.this$0.W((ResultException.ApiException) resultException)) {
                    z = true;
                } else {
                    this.this$0.setStartRunBusy(false);
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new StartRunUtils$checkRunRule$2(param, this, null), 11, null);
    }

    public final void G(AlertTip alertTip, StartRunPageParam param) {
        if (alertTip == null) {
            fv5.a(R.string.request_failed);
            this.isStartRunBusy = false;
            return;
        }
        int code = alertTip.getCode();
        if (code == 2022) {
            AppCompatActivity appCompatActivity = this.activity;
            String title = alertTip.getTitle();
            String str = title == null ? "" : title;
            String content = alertTip.getContent();
            DialogUtil.A(appCompatActivity, str, content == null ? "" : content, ys8.e(R.string.do_not_run), ys8.e(R.string.start_run), false, new a(param));
            return;
        }
        if (code == 2023) {
            String content2 = alertTip.getContent();
            if (content2 == null || content2.length() == 0) {
                this.isStartRunBusy = false;
                return;
            }
            String content3 = alertTip.getContent();
            Intrinsics.checkNotNullExpressionValue(content3, "alertTip.content");
            List listSplit$default = StringsKt.split$default(content3, new String[]{"|"}, false, 0, 6, (Object) null);
            StringBuilder sb = new StringBuilder();
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
            AppCompatActivity appCompatActivity2 = this.activity;
            String title2 = alertTip.getTitle();
            DialogUtil.I(appCompatActivity2, title2 == null ? "" : title2, sb.toString(), ys8.e(R.string.i_know), false, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.wp8
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    StartRunUtils.H(this.f45656a);
                }
            });
            return;
        }
        if (code != 2025) {
            if (code != 2027 && code != 2028 && code != 2030 && code != 2031) {
                if (code != 2039) {
                    if (code == 2040) {
                        AppCompatActivity appCompatActivity3 = this.activity;
                        String title3 = alertTip.getTitle();
                        String str2 = title3 == null ? "" : title3;
                        String content4 = alertTip.getContent();
                        DialogUtil.I(appCompatActivity3, str2, content4 == null ? "" : content4, ys8.e(R.string.i_know), false, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.cq8
                            @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                            public final void onClicked() {
                                StartRunUtils.J(this.f41026a);
                            }
                        });
                        return;
                    }
                    switch (code) {
                        case ErrorCode.CHECK_START_RUN_ERROR.n /* 2044 */:
                        case ErrorCode.CHECK_START_RUN_ERROR.o /* 2045 */:
                            break;
                        case ErrorCode.CHECK_START_RUN_ERROR.m /* 2046 */:
                            break;
                        default:
                            String content5 = alertTip.getContent();
                            fv5.b(content5 != null ? content5 : "");
                            this.isStartRunBusy = false;
                            break;
                    }
                    return;
                }
            }
            AppCompatActivity appCompatActivity4 = this.activity;
            String title4 = alertTip.getTitle();
            String str3 = title4 == null ? "" : title4;
            String content6 = alertTip.getContent();
            DialogUtil.I(appCompatActivity4, str3, content6 == null ? "" : content6, ys8.e(R.string.i_know), false, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.bq8
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    StartRunUtils.I(this.f40816a);
                }
            });
            return;
        }
        AppCompatActivity appCompatActivity5 = this.activity;
        String title5 = alertTip.getTitle();
        if (title5 == null) {
            title5 = "";
        }
        String content7 = alertTip.getContent();
        if (content7 == null) {
            content7 = "";
        }
        DialogUtil.A(appCompatActivity5, title5, content7, ys8.e(R.string.do_not_run), ys8.e(R.string.start_run), false, new b(param));
    }

    public final void K(final StartRunPageParam param) {
        if (param.getRunScene() == 10) {
            ft1.s(this.activity, "无感识别提示", "你已进入无感识别电子围栏，本次跑步将全程进行视频监控，请诚信锻炼，不可使用代跑、代步工具等方式！！！", false, OptionsPickerHelper.e, "我清楚了，Go", new View.OnClickListener() { // from class: com.zj.adlib.zp8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunUtils.L(this.f46315a, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.aq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunUtils.M(this.f15340a, param, view);
                }
            });
        } else {
            N(param);
        }
    }

    public final void N(StartRunPageParam param) {
        if (getRunDetailBean().getSchoolDemandRule() != null) {
            SchoolRule schoolDemandRule = getRunDetailBean().getSchoolDemandRule();
            Intrinsics.checkNotNull(schoolDemandRule);
            param.setSegmentStrideAvg(schoolDemandRule.getSegmentStrideAvg());
            SchoolRule schoolDemandRule2 = getRunDetailBean().getSchoolDemandRule();
            Intrinsics.checkNotNull(schoolDemandRule2);
            param.setSegmentStrideExceptionNum(schoolDemandRule2.getSegmentStrideExceptionNum());
        }
        param.setUseCreditSword(this.useCreditSword);
        BaseViewModelExtKt.b(this.vm, true, false, new StartRunUtils$checkStartSunRun$1(this), null, new StartRunUtils$checkStartSunRun$2(param, this, null), 8, null);
    }

    public final void O(int sportType) {
        if (this.isStartRunBusy) {
            return;
        }
        this.isStartRunBusy = true;
        j0(sportType);
        checkUnFinishedRun(null, false);
    }

    public final int P() {
        return ((Number) this.goalMode.getValue(this, f36004a[2])).intValue();
    }

    @Nullable
    public final Function1<HCJAddressInfo, Unit> Q() {
        return this.locationSuccessCallback;
    }

    public final int R() {
        return ((Number) this.minDistance.getValue(this, f36004a[1])).intValue();
    }

    @Nullable
    public final Function1<GeoFenceDetail, Unit> S() {
        return this.onMatchedFence;
    }

    public final RequiredSettingComponent<AppCompatActivity> T() {
        return (RequiredSettingComponent) this.requiredSettingComponent.getValue();
    }

    public final int U() {
        return ((Number) this.sportType.getValue(this, f36004a[0])).intValue();
    }

    public final int V() {
        return ((Number) this.targetDis.getValue(this, f36004a[3])).intValue();
    }

    public final boolean W(ResultException.ApiException e) {
        int code = e.getCode();
        if (code == 6505) {
            AlipayBindTipDialog.Companion aVar = AlipayBindTipDialog.INSTANCE;
            FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            aVar.a(supportFragmentManager);
            this.isStartRunBusy = false;
            return true;
        }
        if (code != 6506) {
            return false;
        }
        NfcCheckInTipDialog.Companion aVar2 = NfcCheckInTipDialog.INSTANCE;
        FragmentManager supportFragmentManager2 = this.activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.supportFragmentManager");
        aVar2.a(supportFragmentManager2);
        this.isStartRunBusy = false;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    public final void X(final UnfinishedRun unfinishedRun) {
        String str;
        boolean z;
        AlertTip alertTip = unfinishedRun.getAlertTip();
        if (alertTip == null) {
            alertTip = new AlertTip();
        }
        final int iH = StopRunUtils.h(unfinishedRun.getRunRecordCode());
        if (unfinishedRun.isResume()) {
            if (iH != 0) {
                switch (iH) {
                    case android.taobao.windvane.b.d.aa /* 7001 */:
                        alertTip.setContent("系统未找到本次跑步记录数据，无法为您恢复跑步，需先结束后才能再次发起阳光跑");
                        str = "";
                        z = false;
                        break;
                    case 7002:
                        alertTip.setContent("系统检测跑步数据异常，无法为您恢复跑步，需先结束后才能再次发起阳光跑");
                        str = "";
                        z = false;
                        break;
                    case 7003:
                        break;
                    default:
                        str = "";
                        z = false;
                        break;
                }
            }
            str = "继续跑步";
            z = true;
        } else {
            str = "";
            z = false;
        }
        String str2 = str;
        if (z) {
            ft1.t(this.activity, alertTip.getTitle(), alertTip.getContent(), false, "结束跑步", str2, true, new View.OnClickListener() { // from class: com.zj.adlib.fq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunUtils.Y(this.f16598a, unfinishedRun, iH, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.gq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunUtils.Z(this.f16851a, unfinishedRun, view);
                }
            });
        } else {
            ft1.t(this.activity, alertTip.getTitle(), alertTip.getContent(), false, "", "结束跑步", true, null, new View.OnClickListener() { // from class: com.zj.adlib.hq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StartRunUtils.a0(this.f17055a, unfinishedRun, iH, view);
                }
            });
        }
    }

    public final void b0(StartRunPageParam param, Function0<Unit> onComplete) {
        Intent intent = new Intent(this.activity, (Class<?>) SunshineRunActivity.class);
        intent.putExtra(SunshineRunActivity.t, false);
        intent.putExtra(SunshineRunActivity.x, param);
        this.activity.startActivity(intent);
        onComplete.invoke();
    }

    public final void c0(GeoFenceDetail currentFence, boolean useHighAccuracy) {
        if (currentFence == null) {
            this.isStartRunBusy = false;
            return;
        }
        StartRunPageParam startRunPageParam = new StartRunPageParam(null, 0, 0, null, 0.0f, 0, false, 0, null, null, null, null, 0, 0, 0, 32767, null);
        startRunPageParam.setSchoolCode(ai9.e().getSchoolCode());
        String subSchoolCode = currentFence.getSubSchoolCode();
        Intrinsics.checkNotNullExpressionValue(subSchoolCode, "currentFence.subSchoolCode");
        startRunPageParam.setSubSchoolCode(subSchoolCode);
        startRunPageParam.setFenceCode(currentFence.getFenceCode());
        HCJAddressInfo hCJAddressInfo = this.addressInfo;
        Intrinsics.checkNotNull(hCJAddressInfo);
        startRunPageParam.setLat(Double.valueOf(hCJAddressInfo.getLat()));
        HCJAddressInfo hCJAddressInfo2 = this.addressInfo;
        Intrinsics.checkNotNull(hCJAddressInfo2);
        startRunPageParam.setLng(Double.valueOf(hCJAddressInfo2.getLng()));
        startRunPageParam.setGeoFenceDetail(currentFence);
        String str = this.activityRunCode;
        if (str != null) {
            startRunPageParam.setActivityCode(str);
        }
        startRunPageParam.setRunDistanceMode(P());
        startRunPageParam.setMoreTargetDistance(V());
        startRunPageParam.setMinRunDis(R());
        startRunPageParam.setAmapGPSLevel(useHighAccuracy ? 3 : r90.g().getAmapGPSLevel());
        startRunPageParam.setRunPlanCode(this.runPlanCode);
        Map<Integer, CheatResult> mapEmptyMap = this.cheatResults;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        startRunPageParam.setCheatResult(mapEmptyMap);
        startRunPageParam.setSportType(U());
        F(startRunPageParam);
    }

    public void checkLocation() {
        if (!v05.a(this.activity)) {
            ToastUtils.T(R.string.location_once_failed);
            this.isStartRunBusy = false;
            return;
        }
        this.addressInfo = null;
        if (this.gpsIngDialog == null) {
            AppCompatActivity appCompatActivity = this.activity;
            LocationCountDownDialog locationCountDownDialog = new LocationCountDownDialog(appCompatActivity, appCompatActivity.getString(R.string.run_sunningGpsTips), 10, new Function0<Unit>() { // from class: com.huachenjie.run.utils.StartRunUtils.checkLocation.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m729invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m729invoke() {
                    StartRunUtils.this.n0();
                    StartRunUtils.this.setStartRunBusy(false);
                }
            });
            this.gpsIngDialog = locationCountDownDialog;
            locationCountDownDialog.setCountDownEndCallback(new Function0<Unit>() { // from class: com.huachenjie.run.utils.StartRunUtils.checkLocation.2
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m730invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m730invoke() {
                    StartRunUtils.this.locationEnd();
                }
            });
        }
        LocationCountDownDialog locationCountDownDialog2 = this.gpsIngDialog;
        if (locationCountDownDialog2 != null) {
            locationCountDownDialog2.show(10);
        }
        lj0.n(this.activity, 3000L, new HCJLocationListener() { // from class: com.zj.adlib.xp8
            public final void onLocationListener(int i, HCJAddressInfo hCJAddressInfo) {
                StartRunUtils.z(this.f45873a, i, hCJAddressInfo);
            }
        }, null, false, 24, null);
    }

    public void checkSchoolFence(boolean useHighAccuracy) {
        if (getRunDetailBean().getSchoolDemandRule() == null || !getRunDetailBean().isValidStatus()) {
            fv5.a(R.string.run_out_of_semester_prompt);
            this.isStartRunBusy = false;
            return;
        }
        ye3 ye3Var = ye3.f46013a;
        HCJAddressInfo hCJAddressInfo = this.addressInfo;
        Intrinsics.checkNotNull(hCJAddressInfo);
        double lat = hCJAddressInfo.getLat();
        HCJAddressInfo hCJAddressInfo2 = this.addressInfo;
        Intrinsics.checkNotNull(hCJAddressInfo2);
        Map<String, GeoFenceDetail> mapA = ye3Var.a(new HCJLatLng(lat, hCJAddressInfo2.getLng()), this.geoFenceList);
        List<? extends GeoFenceDetail> list = this.geoFenceList;
        boolean z = true;
        if (!(list == null || list.isEmpty())) {
            if (mapA != null && !mapA.isEmpty()) {
                z = false;
            }
            if (!z) {
                BaseViewModelExtKt.b(this.vm, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.utils.StartRunUtils.checkSchoolFence.2

                    /* JADX INFO: renamed from: com.huachenjie.run.utils.StartRunUtils$checkSchoolFence$2$a */
                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$checkSchoolFence$2$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
                    public static final class a extends DialogUtil.PositiveNegativeClickListener {
                        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
                        public void b() {
                            ARouter.getInstance().build(RoutePathConstants.Run.c).navigation();
                        }
                    }

                    {
                        super(1);
                    }

                    @NotNull
                    public final Boolean invoke(@NotNull ResultException resultException) {
                        Intrinsics.checkNotNullParameter(resultException, "e");
                        boolean z2 = false;
                        if ((resultException instanceof ResultException.ApiException) && resultException.getCode() == 2102) {
                            DialogUtil.A(StartRunUtils.this.activity, ys8.e(R.string.geofence_close_title), resultException.getMessage(), ys8.e(R.string.do_not_run), ys8.e(R.string.view_geofences), false, new a());
                            StartRunUtils.this.setStartRunBusy(false);
                            z2 = true;
                        } else {
                            StartRunUtils.this.setStartRunBusy(false);
                        }
                        return Boolean.valueOf(z2);
                    }
                }, null, new AnonymousClass3(mapA, this, useHighAccuracy, null), 11, null);
                return;
            }
        }
        AppCompatActivity appCompatActivity = this.activity;
        DialogUtil.A(appCompatActivity, appCompatActivity.getString(R.string.out_of_geofence_title), this.activity.getString(R.string.out_of_geofence_content), this.activity.getString(R.string.do_not_run), this.activity.getString(R.string.view_geofences), false, new c());
        this.isStartRunBusy = false;
    }

    public final void checkUnFinishedRun(@Nullable GeoFenceDetail currentFence, boolean useHighAccuracy) {
        BaseViewModelExtKt.b(this.vm, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.utils.StartRunUtils.checkUnFinishedRun.1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                StartRunUtils.this.setStartRunBusy(false);
                return Boolean.FALSE;
            }
        }, null, new C14722(currentFence, useHighAccuracy, null), 11, null);
    }

    public final void d0(final int type, final String runRecordCode) {
        A(new PermissionResultListener() { // from class: com.zj.adlib.eq8
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                StartRunUtils.e0(this.f16386a, type, runRecordCode, z);
            }
        });
    }

    public final void f0(int i) {
        this.goalMode.setValue(this, f36004a[2], Integer.valueOf(i));
    }

    public final void g0(@Nullable Function1<? super HCJAddressInfo, Unit> function1) {
        this.locationSuccessCallback = function1;
    }

    @Nullable
    public final HCJAddressInfo getAddressInfo() {
        return this.addressInfo;
    }

    @NotNull
    public final SunshineRunDetail getRunDetailBean() {
        SunshineRunDetail sunshineRunDetail = this.runDetailBean;
        if (sunshineRunDetail != null) {
            return sunshineRunDetail;
        }
        Intrinsics.throwUninitializedPropertyAccessException("runDetailBean");
        return null;
    }

    @NotNull
    public final BaseViewModel getVm() {
        return this.vm;
    }

    public final void h0(int i) {
        this.minDistance.setValue(this, f36004a[1], Integer.valueOf(i));
    }

    public final void i0(@Nullable Function1<? super GeoFenceDetail, Unit> function1) {
        this.onMatchedFence = function1;
    }

    /* JADX INFO: renamed from: isStartRunBusy, reason: from getter */
    public final boolean getIsStartRunBusy() {
        return this.isStartRunBusy;
    }

    public final void j0(int i) {
        this.sportType.setValue(this, f36004a[0], Integer.valueOf(i));
    }

    public final void k0(int i) {
        this.targetDis.setValue(this, f36004a[3], Integer.valueOf(i));
    }

    public final void l0(int sportType, int goalMode, int minDistance, int targetDis, @Nullable String activityRunCode, @NotNull SunshineRunDetail runDetailBean, @Nullable List<? extends GeoFenceDetail> geoFenceList, @Nullable String runPlanCode, boolean useCreditSword) {
        Intrinsics.checkNotNullParameter(runDetailBean, "runDetailBean");
        if (this.isStartRunBusy) {
            return;
        }
        this.isStartRunBusy = true;
        j0(sportType);
        f0(goalMode);
        h0(minDistance);
        k0(targetDis);
        this.activityRunCode = activityRunCode;
        setRunDetailBean(runDetailBean);
        this.geoFenceList = geoFenceList;
        this.runPlanCode = runPlanCode;
        this.useCreditSword = useCreditSword;
        A(new PermissionResultListener() { // from class: com.zj.adlib.dq8
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                StartRunUtils.m0(this.f41255a, z);
            }
        });
    }

    public void locationEnd() {
        n0();
        if (this.addressInfo == null) {
            ToastUtils.T(R.string.location_once_failed);
            this.isStartRunBusy = false;
            return;
        }
        if (vl2.e()) {
            HCJAddressInfo hCJAddressInfo = this.addressInfo;
            if ((hCJAddressInfo != null && hCJAddressInfo.getGpsStatus() == -1) && r90.g().getAmapGPSLevel() == 2) {
                GPSErrorDialog.INSTANCE.a(new Function0<Unit>() { // from class: com.huachenjie.run.utils.StartRunUtils.locationEnd.1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m732invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m732invoke() {
                        StartRunUtils.this.setStartRunBusy(false);
                    }
                }, new Function0<Unit>() { // from class: com.huachenjie.run.utils.StartRunUtils.locationEnd.2

                    /* JADX INFO: renamed from: com.huachenjie.run.utils.StartRunUtils$locationEnd$2$a */
                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/run/utils/StartRunUtils$locationEnd$2$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
                    public static final class a extends DialogUtil.PositiveNegativeClickListener {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ StartRunUtils f36008a;

                        public a(StartRunUtils startRunUtils) {
                            this.f36008a = startRunUtils;
                        }

                        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
                        public void a() {
                            this.f36008a.setStartRunBusy(false);
                        }

                        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
                        public void b() {
                            this.f36008a.locationSuccess(true);
                        }
                    }

                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m733invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m733invoke() {
                        DialogUtil.A(StartRunUtils.this.activity, null, "确定使用网络定位方式跑步锻炼吗？此方式定位精度略低可能会导致轨迹发生偏移、折线等情况，建议不要熄屏以便数据记录更加准确！", StartRunUtils.this.activity.getString(R.string.cancel), "立即开始", false, new a(StartRunUtils.this));
                    }
                }).show(this.activity.getSupportFragmentManager(), Reflection.getOrCreateKotlinClass(GPSErrorDialog.class).getSimpleName());
                return;
            }
        }
        locationSuccess(false);
    }

    public final void locationSuccess(boolean useHighAccuracy) {
        r90.k0(this.addressInfo);
        Function1<? super HCJAddressInfo, Unit> function1 = this.locationSuccessCallback;
        if (function1 != null) {
            HCJAddressInfo hCJAddressInfo = this.addressInfo;
            Intrinsics.checkNotNull(hCJAddressInfo);
            function1.invoke(hCJAddressInfo);
        }
        checkSchoolFence(useHighAccuracy);
    }

    public final void n0() {
        LocationCountDownDialog locationCountDownDialog;
        LocationCountDownDialog locationCountDownDialog2;
        lj0.t(this.activity, false, 2, null);
        if (this.activity.isDestroyed() || this.activity.isFinishing() || (locationCountDownDialog = this.gpsIngDialog) == null) {
            return;
        }
        Intrinsics.checkNotNull(locationCountDownDialog);
        if (!locationCountDownDialog.isShowing() || (locationCountDownDialog2 = this.gpsIngDialog) == null) {
            return;
        }
        locationCountDownDialog2.dismiss();
    }

    public final void o0(UnfinishedRun unfinishedRun, int checkData) {
        StopRunUtils.o(unfinishedRun, checkData, new d());
    }

    public final void setAddressInfo(@Nullable HCJAddressInfo hCJAddressInfo) {
        this.addressInfo = hCJAddressInfo;
    }

    public final void setRunDetailBean(@NotNull SunshineRunDetail sunshineRunDetail) {
        Intrinsics.checkNotNullParameter(sunshineRunDetail, "<set-?>");
        this.runDetailBean = sunshineRunDetail;
    }

    public final void setStartRunBusy(boolean z) {
        this.isStartRunBusy = z;
    }

    public final void x() {
        AcseHelpManager.syncUserIdState(m55.c(ai9.e().getUserId()), m55.c(ai9.e().getSchoolCode()));
        AcseHelpManager.startRunning(this.activity, true, new AcseHelpManager.OnCurrentStateCallBack() { // from class: com.zj.adlib.yp8
            @Override // com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack
            public final void onState(String str) {
                StartRunUtils.y(this.f46093a, str);
            }
        });
    }
}
