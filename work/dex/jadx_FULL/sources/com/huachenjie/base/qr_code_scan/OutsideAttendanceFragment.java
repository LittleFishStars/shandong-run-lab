package com.huachenjie.base.qr_code_scan;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.common.bean.ClockTime;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.dx4;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.lifecycle.ILifeCycle;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0003345B\u0007¢\u0006\u0004\b0\u00101J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\"\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J1\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020!H\u0016R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010/¨\u00066"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment;", "Landroidx/fragment/app/Fragment;", "Lhuachenjie/sdk/http/lifecycle/ILifeCycle;", "", "outsideConfigCode", "timeFrameCode", "img", "lng", "lat", "", "qrCodeClock", "requestClockTimeList", "Lcom/huachenjie/common/bean/ClockTimeData;", "clockTimeData", "dealClockTimeData", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", RequestPermission.REQUEST_CODE, "startForResult", "", "Lcom/huachenjie/common/bean/ClockTime;", "clockTimeList", "Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$a;", "checkClockTimeList", "clockType", "startClock", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroyView", "Lcom/zj/adlib/dx4;", "getLifeCycleObservable", "Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;", "getCallback", "()Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;", "setCallback", "(Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;)V", "Lcom/zj/adlib/gq1;", "commonModel", "Lcom/zj/adlib/gq1;", "behavior", "Lcom/zj/adlib/dx4;", "Ljava/lang/Integer;", "<init>", "()V", "Companion", "a", "b", "SignInCallback", "base_release"}, k = 1, mv = {1, 8, 0})
public final class OutsideAttendanceFragment extends Fragment implements ILifeCycle {
    public static final int CODE_REQUEST_PERIOD = 1001;
    public static final int CODE_REQUEST_PHOTO = 1002;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "OutsideAttendanceFragment";

    @Nullable
    private dx4 behavior;
    public SignInCallback callback;

    @Nullable
    private Integer clockType;

    @NotNull
    private final gq1 commonModel = new gq1();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;", "", "", "success", "", "code", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public interface SignInCallback {
        void a(boolean success, int code);
    }

    /* JADX INFO: renamed from: com.huachenjie.base.qr_code_scan.OutsideAttendanceFragment$a, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$a;", "", "", "a", "", "b", "size", "code", "c", "toString", "hashCode", "other", "", "equals", "I", "f", "()I", y6b.g, "(I)V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", y6b.f, "(Ljava/lang/String;)V", "<init>", "(ILjava/lang/String;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class CheckClockTimeResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public int size;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
        @NotNull
        public String code;

        public CheckClockTimeResult(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "code");
            this.size = i;
            this.code = str;
        }

        public static /* synthetic */ CheckClockTimeResult d(CheckClockTimeResult checkClockTimeResult, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = checkClockTimeResult.size;
            }
            if ((i2 & 2) != 0) {
                str = checkClockTimeResult.code;
            }
            return checkClockTimeResult.c(i, str);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        @NotNull
        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final CheckClockTimeResult c(int size, @NotNull String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new CheckClockTimeResult(size, code);
        }

        @NotNull
        public final String e() {
            return this.code;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckClockTimeResult)) {
                return false;
            }
            CheckClockTimeResult checkClockTimeResult = (CheckClockTimeResult) other;
            return this.size == checkClockTimeResult.size && Intrinsics.areEqual(this.code, checkClockTimeResult.code);
        }

        public final int f() {
            return this.size;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.code = str;
        }

        public final void h(int i) {
            this.size = i;
        }

        public int hashCode() {
            return (Integer.hashCode(this.size) * 31) + this.code.hashCode();
        }

        @NotNull
        public String toString() {
            return "CheckClockTimeResult(size=" + this.size + ", code=" + this.code + ')';
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.qr_code_scan.OutsideAttendanceFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$b;", "", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment;", "a", "", "CODE_REQUEST_PERIOD", "I", "CODE_REQUEST_PHOTO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OutsideAttendanceFragment a(@NotNull FragmentManager supportFragmentManager) {
            Intrinsics.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
            Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(OutsideAttendanceFragment.TAG);
            if (fragmentFindFragmentByTag != null && (fragmentFindFragmentByTag instanceof OutsideAttendanceFragment)) {
                return (OutsideAttendanceFragment) fragmentFindFragmentByTag;
            }
            OutsideAttendanceFragment outsideAttendanceFragment = new OutsideAttendanceFragment();
            supportFragmentManager.beginTransaction().add(outsideAttendanceFragment, OutsideAttendanceFragment.TAG).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return outsideAttendanceFragment;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<Object> {
        public c() {
            super(true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.b("签到成功");
            OutsideAttendanceFragment.this.getCallback().a(true, 200);
        }

        public void onFailed(int code, @Nullable String message) {
            if (code == 4044) {
                OutsideAttendanceFragment.this.getCallback().a(false, code);
            } else {
                super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$d", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/ClockTimeData;", "data", "", "onCCSuccess", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends BizSubscriber<ClockTimeData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OutsideAttendanceFragment f32944a;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, OutsideAttendanceFragment outsideAttendanceFragment) {
            super(true);
            this.f = str;
            this.g = str2;
            this.f32944a = outsideAttendanceFragment;
        }

        public void onCCSuccess(@Nullable ClockTimeData data) {
            if (data == null) {
                fv5.b("不在签到时段");
                return;
            }
            data.setLng(this.f);
            data.setLat(this.g);
            this.f32944a.dealClockTimeData(data);
        }
    }

    private final CheckClockTimeResult checkClockTimeList(List<ClockTime> clockTimeList) {
        List<ClockTime> list = clockTimeList;
        if (list == null || list.isEmpty()) {
            return new CheckClockTimeResult(0, "");
        }
        CheckClockTimeResult checkClockTimeResult = new CheckClockTimeResult(0, "");
        for (ClockTime clockTime : clockTimeList) {
            if (clockTime.getStartTimeStatus() == 2 || clockTime.getEndTimeStatus() == 2) {
                checkClockTimeResult.h(checkClockTimeResult.f() + 1);
                checkClockTimeResult.g(clockTime.getTimeFrameCode());
            }
        }
        return checkClockTimeResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealClockTimeData(ClockTimeData clockTimeData) {
        CheckClockTimeResult checkClockTimeResultCheckClockTimeList = checkClockTimeList(clockTimeData.getClockTimeList());
        if (checkClockTimeResultCheckClockTimeList.f() == 0) {
            fv5.b("不在考勤时段内");
            return;
        }
        if (checkClockTimeResultCheckClockTimeList.f() != 1) {
            Postcard postcardWithParcelable = ARouter.getInstance().build(RoutePathConstants.Sport.u).withParcelable(UserConstants.MINE_PARAMS.i, clockTimeData);
            Intrinsics.checkNotNullExpressionValue(postcardWithParcelable, "postcard");
            startForResult(postcardWithParcelable, 1001);
        } else {
            if (!clockTimeData.getImgFlag()) {
                qrCodeClock(clockTimeData.getOutsideConfigCode(), checkClockTimeResultCheckClockTimeList.e(), "", clockTimeData.getLng(), clockTimeData.getLat());
                return;
            }
            Postcard postcardWithString = ARouter.getInstance().build(RoutePathConstants.Sport.v).withParcelable(UserConstants.MINE_PARAMS.i, clockTimeData).withString(UserConstants.MINE_PARAMS.k, checkClockTimeResultCheckClockTimeList.e());
            Intrinsics.checkNotNullExpressionValue(postcardWithString, "postcard");
            startForResult(postcardWithString, 1002);
        }
    }

    private final void qrCodeClock(String outsideConfigCode, String timeFrameCode, String img, String lng, String lat) {
        n76.e(this, this.commonModel.u(outsideConfigCode, timeFrameCode, img, lng, lat, this.clockType)).p5(new c());
    }

    private final void requestClockTimeList(String outsideConfigCode, String lng, String lat) {
        if (TextUtils.isEmpty(outsideConfigCode)) {
            fv5.b("请扫描正确的二维码");
        } else {
            n76.e(this, this.commonModel.i(outsideConfigCode)).p5(new d(lng, lat, this));
        }
    }

    public static /* synthetic */ void startClock$default(OutsideAttendanceFragment outsideAttendanceFragment, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        outsideAttendanceFragment.startClock(str, str2, str3, num);
    }

    private final void startForResult(Postcard postcard, int requestCode) {
        try {
            LogisticsCenter.completion(postcard);
            Intent intent = new Intent(getActivity(), postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityFromFragment(this, intent, requestCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public final SignInCallback getCallback() {
        SignInCallback signInCallback = this.callback;
        if (signInCallback != null) {
            return signInCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException(RenderCallContext.TYPE_CALLBACK);
        return null;
    }

    @NotNull
    public dx4 getLifeCycleObservable() {
        if (this.behavior == null) {
            this.behavior = dx4.a();
        }
        dx4 dx4Var = this.behavior;
        Intrinsics.checkNotNull(dx4Var);
        return dx4Var;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if ((requestCode == 1001 || requestCode == 1002) && data != null) {
            String stringExtra = data.getStringExtra(UserConstants.MINE_PARAMS.j);
            String stringExtra2 = data.getStringExtra(UserConstants.MINE_PARAMS.k);
            String stringExtra3 = data.getStringExtra(UserConstants.MINE_PARAMS.l);
            String stringExtra4 = data.getStringExtra(UserConstants.MINE_PARAMS.m);
            String stringExtra5 = data.getStringExtra(UserConstants.MINE_PARAMS.n);
            qrCodeClock(stringExtra == null ? "" : stringExtra, stringExtra2 == null ? "" : stringExtra2, stringExtra3 == null ? "" : stringExtra3, stringExtra4 == null ? "" : stringExtra4, stringExtra5 == null ? "" : stringExtra5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        dx4 dx4Var = this.behavior;
        if (dx4Var != null) {
            dx4Var.b();
        }
        super.onDestroyView();
    }

    public final void setCallback(@NotNull SignInCallback signInCallback) {
        Intrinsics.checkNotNullParameter(signInCallback, "<set-?>");
        this.callback = signInCallback;
    }

    public final void startClock(@NotNull String outsideConfigCode, @NotNull String lng, @NotNull String lat, @Nullable Integer clockType) {
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        Intrinsics.checkNotNullParameter(lng, "lng");
        Intrinsics.checkNotNullParameter(lat, "lat");
        this.clockType = clockType;
        requestClockTimeList(outsideConfigCode, lng, lat);
    }
}
