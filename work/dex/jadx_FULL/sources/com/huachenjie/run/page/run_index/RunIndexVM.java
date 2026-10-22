package com.huachenjie.run.page.run_index;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.core.content.res.ResourcesCompat;
import androidx.p002lifecycle.LiveData;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.Transformations;
import com.alibaba.ariver.kernel.RVParams;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.AliPay;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.StudentDoneRule;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.weimai_hh.SpanHonghuUtil;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.dq1;
import com.zj.adlib.fe9;
import com.zj.adlib.h46;
import com.zj.adlib.ll7;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¢\u0001\u0010£\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J0\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00042\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R0\u0010/\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010.R#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\"8\u0006¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0006¢\u0006\f\n\u0004\b2\u0010%\u001a\u0004\b3\u0010'R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002050\"8\u0006¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'R%\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000205\u0018\u00010\u00060\"8\u0006¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010<R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010<\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0C8\u0006¢\u0006\f\n\u0004\b$\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040C8\u0006¢\u0006\f\n\u0004\b+\u0010D\u001a\u0004\bH\u0010FR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00190\"8\u0006¢\u0006\f\n\u0004\bJ\u0010%\u001a\u0004\bK\u0010'R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\b$\u0010N\u001a\u0004\bO\u0010PR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\bR\u0010PR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\b0\u0010N\u001a\u0004\bT\u0010PR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\b2\u0010N\u001a\u0004\bV\u0010PR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00150M8\u0006¢\u0006\f\n\u0004\b6\u0010N\u001a\u0004\bX\u0010PR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\b9\u0010N\u001a\u0004\bZ\u0010PR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\bJ\u0010N\u001a\u0004\b\\\u0010PR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\b^\u0010N\u001a\u0004\b_\u0010PR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\ba\u0010N\u001a\u0004\bb\u0010PR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\bd\u0010N\u001a\u0004\be\u0010PR\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\bg\u0010N\u001a\u0004\bh\u0010PR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\bj\u0010N\u001a\u0004\bk\u0010PR\u001d\u0010o\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0006¢\u0006\f\n\u0004\bm\u0010N\u001a\u0004\bn\u0010PR%\u0010s\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010p0p0M8\u0006¢\u0006\f\n\u0004\bq\u0010N\u001a\u0004\br\u0010PR\u001d\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00150M8\u0006¢\u0006\f\n\u0004\bt\u0010N\u001a\u0004\bu\u0010PR\u001f\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150M8\u0006¢\u0006\f\n\u0004\bw\u0010N\u001a\u0004\bx\u0010PR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\f\n\u0004\bz\u0010N\u001a\u0004\b<\u0010PR\"\u0010|\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010%R%\u0010~\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040C8\u0006¢\u0006\f\n\u0004\b0\u0010D\u001a\u0004\b}\u0010FR\u001f\u0010\u0083\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b0\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u0085\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\"8\u0006¢\u0006\r\n\u0004\ba\u0010%\u001a\u0005\b\u0084\u0001\u0010'R#\u0010\u0086\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00150\u00150\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010%R \u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150M8\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010N\u001a\u0005\b\u0088\u0001\u0010PR\u001f\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\f0C8\u0006¢\u0006\r\n\u0004\b2\u0010D\u001a\u0005\b\u008a\u0001\u0010FR\u001f\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\f0C8\u0006¢\u0006\r\n\u0004\b6\u0010D\u001a\u0005\b\u008c\u0001\u0010FR \u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0006¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010N\u001a\u0005\b\u008f\u0001\u0010PR'\u0010\u0092\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040C8\u0006¢\u0006\r\n\u0004\b9\u0010D\u001a\u0005\b\u0091\u0001\u0010FR'\u0010\u0094\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00040\u00040\"8\u0006¢\u0006\r\n\u0004\bg\u0010%\u001a\u0005\b\u0093\u0001\u0010'R'\u0010\u0096\u0001\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\f0\f0\"8\u0006¢\u0006\r\n\u0004\bj\u0010%\u001a\u0005\b\u0095\u0001\u0010'R,\u0010\u009a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0097\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bm\u0010%\u001a\u0005\b\u0098\u0001\u0010'\"\u0005\b\u0099\u0001\u0010.R\u0017\u0010\u009b\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010_R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b2\u0010\u0080\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0013\u0010¡\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b \u0001\u0010?¨\u0006¤\u0001"}, d2 = {"Lcom/huachenjie/run/page/run_index/RunIndexVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "s0", "", "w", "", "Lcom/huachenjie/common/bean/SemesterBean;", "semesterList", "A0", "", "meters", "", "y", "x", "Lcom/huachenjie/common/util/weimai_hh/SpanHonghuUtil$SpanBuilder;", "builder", "text", "v", "w0", "v0", "", "sportType", RVParams.LONG_SHOW_LOADING, "Lkotlin/Function1;", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "onSuccess", "t0", "y0", "q0", "r0", "z0", "C", "x0", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "j0", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/common/bean/CommonUserInfo;", "kotlin.jvm.PlatformType", "b", "k0", "D0", "(Landroidx/lifecycle/MutableLiveData;)V", "userInfo", "c", "X", "d", "W", "selectedSemester", "Lcom/huachenjie/run/bean/RunPlanBean;", "e", "D", ReadyActivity.x, "f", "T", "runPlanList", "Z", "isLoadPlanList", "N", "()Z", "B0", "(Z)V", "hasLoadPlanList", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "V", "()Landroidx/lifecycle/MediatorLiveData;", "runRecordSectionTitle", "h0", "showSwitchRunPlan", y6b.f, "i0", ReadyActivity.y, "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "a0", "()Landroidx/lifecycle/LiveData;", "showGoalKm", "c0", "showGoalTimes", "H", "goalKmValue", "M", "goalTimesValue", "L", "goalSeekProgress", "J", "goalProgressPercentText", "b0", "showGoalProgressDoneLabel", y6b.g, "I", "goalProgressCurrentText", "i", "K", "goalProgressTotalText", "j", "E", "effectiveLabel", "k", "F", "effectiveValue", t.d, "g0", "showMorningCount", "m", "R", "morningValue", "Landroid/text/SpannableStringBuilder;", "n", "A", "awardValue", j.b, "G", "freePunchCount", "p", "l0", "userStatus", "q", "showFreePunch", "isBindAlipay", "Y", "showAlipayBind", "Lcom/huachenjie/base/api/BaseModel;", "Lkotlin/Lazy;", "B", "()Lcom/huachenjie/base/api/BaseModel;", "baseModel", "e0", "showMedalWall", "inspirationTotal", "r", "P", "leftEntryIcon", "Q", "leftEntryTitle", "O", "leftEntryDesc", "s", "d0", "showLeftEntryDesc", "f0", "showMedalWallGoView", "m0", "isActivity", j.o, "activityRunBannerText", "Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter;", "U", "C0", "runRecordAdapter", "recordPageIndex", "Landroid/graphics/Typeface;", "S", "()Landroid/graphics/Typeface;", "numberTypeface", "n0", "isCurrentSemester", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunIndexVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunIndexVM.kt\ncom/huachenjie/run/page/run_index/RunIndexVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
public final class RunIndexVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int recordPageIndex;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showGoalKm;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> runRecordSectionTitle;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isLoadPlanList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showGoalTimes;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> showSwitchRunPlan;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean hasLoadPlanList;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> goalKmValue;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> showAlipayBind;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy baseModel;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> goalTimesValue;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> leftEntryTitle;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SemesterBean> selectedSemester;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy numberTypeface;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Integer> goalSeekProgress;

    /* JADX INFO: renamed from: e, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> leftEntryDesc;

    /* JADX INFO: renamed from: e, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunPlanBean> currentRunPlan;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> goalProgressPercentText;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> showMedalWallGoView;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<RunPlanBean>> runPlanList;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showGoalProgressDoneLabel;

    /* JADX INFO: renamed from: g, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SunshineRunDetail> sunshineRunDetail;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> goalProgressCurrentText;

    /* JADX INFO: renamed from: h, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isBindAlipay;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> goalProgressTotalText;

    /* JADX INFO: renamed from: i, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showMedalWall;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> effectiveLabel;

    /* JADX INFO: renamed from: j, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> inspirationTotal;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> effectiveValue;

    /* JADX INFO: renamed from: k, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isActivity;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showMorningCount;

    /* JADX INFO: renamed from: l, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> activityRunBannerText;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final LiveData<String> morningValue;

    /* JADX INFO: renamed from: m, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public MutableLiveData<RunIndexRecordAdapter> runRecordAdapter;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final LiveData<SpannableStringBuilder> awardValue;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Integer> freePunchCount;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Integer> userStatus;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showFreePunch;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Integer> leftEntryIcon;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final LiveData<Boolean> showLeftEntryDesc;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public MutableLiveData<CommonUserInfo> userInfo = new MutableLiveData<>(ai9.e());

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SemesterBean>> semesterList = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/run/page/run_index/RunIndexVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/base/bean/BindInfo;", "data", "", "onCCSuccess", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<BindInfo> {
        public a() {
            super(false);
        }

        public void onCCSuccess(@Nullable BindInfo data) {
            AliPay aliPay;
            RunIndexVM.this.isBindAlipay.setValue(Boolean.valueOf((data == null || (aliPay = data.getAliPay()) == null) ? false : Intrinsics.areEqual(aliPay.getBindStatus(), Boolean.TRUE)));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35927a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35927a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35927a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35927a.invoke(obj);
        }
    }

    public RunIndexVM() {
        MutableLiveData<SemesterBean> mutableLiveData = new MutableLiveData<>();
        this.selectedSemester = mutableLiveData;
        MutableLiveData<RunPlanBean> mutableLiveData2 = new MutableLiveData<>();
        this.currentRunPlan = mutableLiveData2;
        MutableLiveData<List<RunPlanBean>> mutableLiveData3 = new MutableLiveData<>();
        this.runPlanList = mutableLiveData3;
        final MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$runRecordSectionTitle$1$update$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m685invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m685invoke() {
                String runPlanName;
                MediatorLiveData<String> mediatorLiveData2 = mediatorLiveData;
                if (this.w()) {
                    RunPlanBean value = this.D().getValue();
                    runPlanName = value != null ? value.getRunPlanName() : null;
                    if (runPlanName == null) {
                        runPlanName = "";
                    }
                } else {
                    runPlanName = "跑步记录";
                }
                mediatorLiveData2.setValue(runPlanName);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new b(new Function1<SemesterBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$runRecordSectionTitle$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemesterBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemesterBean semesterBean) {
                function0.invoke();
            }
        }));
        mediatorLiveData.addSource(mutableLiveData2, new b(new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$runRecordSectionTitle$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunPlanBean runPlanBean) {
                function0.invoke();
            }
        }));
        function0.invoke();
        this.runRecordSectionTitle = mediatorLiveData;
        final MediatorLiveData<Boolean> mediatorLiveData2 = new MediatorLiveData<>();
        final Function0<Unit> function1 = new Function0<Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showSwitchRunPlan$1$update$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m686invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m686invoke() {
                MediatorLiveData<Boolean> mediatorLiveData3 = mediatorLiveData2;
                boolean z = false;
                if (this.w()) {
                    List<RunPlanBean> value = this.T().getValue();
                    if ((value != null ? value.size() : 0) > 1) {
                        z = true;
                    }
                }
                mediatorLiveData3.setValue(Boolean.valueOf(z));
            }
        };
        mediatorLiveData2.addSource(mutableLiveData, new b(new Function1<SemesterBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showSwitchRunPlan$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemesterBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemesterBean semesterBean) {
                function1.invoke();
            }
        }));
        mediatorLiveData2.addSource(mutableLiveData2, new b(new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showSwitchRunPlan$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunPlanBean runPlanBean) {
                function1.invoke();
            }
        }));
        mediatorLiveData2.addSource(mutableLiveData3, new b(new Function1<List<? extends RunPlanBean>, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showSwitchRunPlan$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<RunPlanBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<RunPlanBean> list) {
                function1.invoke();
            }
        }));
        function1.invoke();
        this.showSwitchRunPlan = mediatorLiveData2;
        MutableLiveData<SunshineRunDetail> mutableLiveData4 = new MutableLiveData<>();
        this.sunshineRunDetail = mutableLiveData4;
        this.showGoalKm = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showGoalKm$1
            @NotNull
            public final Boolean invoke(SunshineRunDetail sunshineRunDetail) {
                boolean z = false;
                if (sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 2) {
                    z = true;
                }
                return Boolean.valueOf(!z);
            }
        });
        this.showGoalTimes = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showGoalTimes$1
            @NotNull
            public final Boolean invoke(SunshineRunDetail sunshineRunDetail) {
                boolean z = true;
                if (!(sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 1)) {
                    if (!(sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 2)) {
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        this.goalKmValue = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalKmValue$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                SchoolRule schoolDemandRule;
                return String.valueOf((sunshineRunDetail == null || (schoolDemandRule = sunshineRunDetail.getSchoolDemandRule()) == null) ? 0 : schoolDemandRule.getDisKM());
            }
        });
        this.goalTimesValue = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalTimesValue$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                SchoolRule schoolDemandRule;
                return String.valueOf((sunshineRunDetail == null || (schoolDemandRule = sunshineRunDetail.getSchoolDemandRule()) == null) ? 0 : schoolDemandRule.getTotalTimes());
            }
        });
        this.goalSeekProgress = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Integer>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalSeekProgress$1
            @NotNull
            public final Integer invoke(SunshineRunDetail sunshineRunDetail) {
                StudentDoneRule studentDoneRuleInfo;
                Float f = (sunshineRunDetail == null || (studentDoneRuleInfo = sunshineRunDetail.getStudentDoneRuleInfo()) == null) ? null : studentDoneRuleInfo.completionRate;
                float fFloatValue = f == null ? 0.0f : f.floatValue();
                return Integer.valueOf(fFloatValue <= 0.0f ? 0 : RangesKt.coerceIn((int) (fFloatValue * 100), 1, 100));
            }
        });
        this.goalProgressPercentText = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalProgressPercentText$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                StudentDoneRule studentDoneRuleInfo;
                Float f = (sunshineRunDetail == null || (studentDoneRuleInfo = sunshineRunDetail.getStudentDoneRuleInfo()) == null) ? null : studentDoneRuleInfo.completionRate;
                float fFloatValue = f == null ? 0.0f : f.floatValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%.2f%%", Arrays.copyOf(new Object[]{Float.valueOf(fFloatValue * 100)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                return str;
            }
        });
        this.showGoalProgressDoneLabel = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showGoalProgressDoneLabel$1
            @NotNull
            public final Boolean invoke(SunshineRunDetail sunshineRunDetail) {
                boolean z = false;
                if (sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
        this.goalProgressCurrentText = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalProgressCurrentText$1
            {
                super(1);
            }

            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                StudentDoneRule studentDoneRuleInfo = sunshineRunDetail != null ? sunshineRunDetail.getStudentDoneRuleInfo() : null;
                String strX = this.this$0.x(studentDoneRuleInfo != null ? studentDoneRuleInfo.getDoneDistance() : 0L);
                StringBuilder sb = new StringBuilder();
                sb.append(studentDoneRuleInfo != null ? studentDoneRuleInfo.getDoneTargetTimes() : 0);
                sb.append((char) 27425);
                String string = sb.toString();
                Integer numValueOf = sunshineRunDetail != null ? Integer.valueOf(sunshineRunDetail.getPlanType()) : null;
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    return string;
                }
                if (numValueOf == null || numValueOf.intValue() != 1) {
                    return strX;
                }
                return strX + (char) 12289 + string;
            }
        });
        this.goalProgressTotalText = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$goalProgressTotalText$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                SchoolRule schoolDemandRule;
                int disKM = 0;
                if (sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 2) {
                    StringBuilder sb = new StringBuilder();
                    SchoolRule schoolDemandRule2 = sunshineRunDetail.getSchoolDemandRule();
                    sb.append(schoolDemandRule2 != null ? schoolDemandRule2.getTotalTimes() : 0);
                    sb.append((char) 27425);
                    return sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                if (sunshineRunDetail != null && (schoolDemandRule = sunshineRunDetail.getSchoolDemandRule()) != null) {
                    disKM = schoolDemandRule.getDisKM();
                }
                sb2.append(disKM);
                sb2.append("km");
                return sb2.toString();
            }
        });
        this.effectiveLabel = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$effectiveLabel$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                boolean z = false;
                if (sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 2) {
                    z = true;
                }
                return z ? "有效跑步 (次)" : "有效里程 (km)";
            }
        });
        this.effectiveValue = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$effectiveValue$1
            {
                super(1);
            }

            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                StudentDoneRule studentDoneRuleInfo = sunshineRunDetail != null ? sunshineRunDetail.getStudentDoneRuleInfo() : null;
                if (sunshineRunDetail != null && sunshineRunDetail.getPlanType() == 2) {
                    return String.valueOf(studentDoneRuleInfo != null ? studentDoneRuleInfo.getDoneTargetTimes() : 0);
                }
                return this.this$0.y(studentDoneRuleInfo != null ? studentDoneRuleInfo.getDoneDistance() : 0L);
            }
        });
        this.showMorningCount = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showMorningCount$1
            @NotNull
            public final Boolean invoke(SunshineRunDetail sunshineRunDetail) {
                return Boolean.valueOf(((sunshineRunDetail != null ? sunshineRunDetail.getSchoolDemandRule() : null) == null || CollectionUtils.r(sunshineRunDetail.getSchoolDemandRule().getMorningTimeFragment())) ? false : true);
            }
        });
        this.morningValue = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, String>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$morningValue$1
            @NotNull
            public final String invoke(SunshineRunDetail sunshineRunDetail) {
                StudentDoneRule studentDoneRuleInfo;
                Integer morningTimes = (sunshineRunDetail == null || (studentDoneRuleInfo = sunshineRunDetail.getStudentDoneRuleInfo()) == null) ? null : studentDoneRuleInfo.getMorningTimes();
                return String.valueOf(morningTimes == null ? 0 : morningTimes.intValue());
            }
        });
        this.awardValue = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, SpannableStringBuilder>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$awardValue$1
            {
                super(1);
            }

            public final SpannableStringBuilder invoke(SunshineRunDetail sunshineRunDetail) {
                Integer num;
                StudentDoneRule studentDoneRuleInfo = sunshineRunDetail != null ? sunshineRunDetail.getStudentDoneRuleInfo() : null;
                String strM = ll7.m(ll7.f43096a, Long.valueOf((studentDoneRuleInfo == null || (num = studentDoneRuleInfo.awardDistance) == null) ? 0 : num.intValue()), false, false, 1, 6, null);
                Integer num2 = studentDoneRuleInfo != null ? studentDoneRuleInfo.awardTimes : null;
                String strValueOf = String.valueOf(num2 != null ? num2.intValue() : 0);
                SpanHonghuUtil.SpanBuilder spanBuilderA = SpanHonghuUtil.a();
                RunIndexVM runIndexVM = this.this$0;
                Intrinsics.checkNotNullExpressionValue(spanBuilderA, o.f);
                runIndexVM.v(spanBuilderA, strM);
                SpanHonghuUtil.SpanBuilder spanBuilderA2 = spanBuilderA.a("km", 12).a(" / ", 12);
                RunIndexVM runIndexVM2 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(spanBuilderA2, o.f);
                runIndexVM2.v(spanBuilderA2, strValueOf);
                return spanBuilderA2.a("次", 12).q();
            }
        });
        this.freePunchCount = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Integer>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$freePunchCount$1
            @NotNull
            public final Integer invoke(SunshineRunDetail sunshineRunDetail) {
                return Integer.valueOf(sunshineRunDetail != null ? sunshineRunDetail.getSwordChargingNum() : 0);
            }
        });
        this.userStatus = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Integer>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$userStatus$1
            @Nullable
            public final Integer invoke(SunshineRunDetail sunshineRunDetail) {
                if (sunshineRunDetail != null) {
                    return Integer.valueOf(sunshineRunDetail.getUserStatus());
                }
                return null;
            }
        });
        LiveData<Boolean> map = Transformations.map(mutableLiveData4, new Function1<SunshineRunDetail, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showFreePunch$1
            @NotNull
            public final Boolean invoke(SunshineRunDetail sunshineRunDetail) {
                return Boolean.valueOf((sunshineRunDetail != null && sunshineRunDetail.isCreditSwordStatus()) && !dq1.e().getVisionEnable());
            }
        });
        this.showFreePunch = map;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(bool);
        this.isBindAlipay = mutableLiveData5;
        final MediatorLiveData<Boolean> mediatorLiveData3 = new MediatorLiveData<>(bool);
        mediatorLiveData3.addSource(mutableLiveData5, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showAlipayBind$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.E0(mediatorLiveData3, this);
            }
        }));
        mediatorLiveData3.addSource(mutableLiveData2, new b(new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showAlipayBind$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunPlanBean runPlanBean) {
                RunIndexVM.E0(mediatorLiveData3, this);
            }
        }));
        this.showAlipayBind = mediatorLiveData3;
        this.baseModel = LazyKt.lazy(new Function0<BaseModel>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$baseModel$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BaseModel m683invoke() {
                return new BaseModel();
            }
        });
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(bool);
        this.showMedalWall = mutableLiveData6;
        MutableLiveData<Integer> mutableLiveData7 = new MutableLiveData<>(0);
        this.inspirationTotal = mutableLiveData7;
        this.leftEntryIcon = Transformations.map(mutableLiveData6, new Function1<Boolean, Integer>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryIcon$1
            @NotNull
            public final Integer invoke(Boolean bool2) {
                Intrinsics.checkNotNullExpressionValue(bool2, o.f);
                return Integer.valueOf(bool2.booleanValue() ? R.drawable.run_ic_index_medal : com.huachenjie.common.R.drawable.common_ic_flash_coins_small);
            }
        });
        final MediatorLiveData<String> mediatorLiveData4 = new MediatorLiveData<>();
        mediatorLiveData4.addSource(mutableLiveData6, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryTitle$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.p0(this.this$0, mediatorLiveData4);
            }
        }));
        mediatorLiveData4.addSource(map, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryTitle$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.p0(this.this$0, mediatorLiveData4);
            }
        }));
        mediatorLiveData4.addSource(mutableLiveData7, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryTitle$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                RunIndexVM.p0(this.this$0, mediatorLiveData4);
            }
        }));
        p0(this, mediatorLiveData4);
        this.leftEntryTitle = mediatorLiveData4;
        final MediatorLiveData<String> mediatorLiveData5 = new MediatorLiveData<>();
        mediatorLiveData5.addSource(mutableLiveData6, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryDesc$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.o0(this.this$0, mediatorLiveData5);
            }
        }));
        mediatorLiveData5.addSource(map, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryDesc$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.o0(this.this$0, mediatorLiveData5);
            }
        }));
        mediatorLiveData5.addSource(mutableLiveData7, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$leftEntryDesc$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                RunIndexVM.o0(this.this$0, mediatorLiveData5);
            }
        }));
        o0(this, mediatorLiveData5);
        this.leftEntryDesc = mediatorLiveData5;
        this.showLeftEntryDesc = Transformations.map(mediatorLiveData5, new Function1<String, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showLeftEntryDesc$1
            @NotNull
            public final Boolean invoke(String str) {
                return Boolean.valueOf(!(str == null || str.length() == 0));
            }
        });
        final MediatorLiveData<Boolean> mediatorLiveData6 = new MediatorLiveData<>(bool);
        mediatorLiveData6.addSource(mutableLiveData6, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showMedalWallGoView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.F0(mediatorLiveData6, this);
            }
        }));
        mediatorLiveData6.addSource(map, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$showMedalWallGoView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool2) {
                RunIndexVM.F0(mediatorLiveData6, this);
            }
        }));
        this.showMedalWallGoView = mediatorLiveData6;
        this.isActivity = new MutableLiveData<>(bool);
        this.activityRunBannerText = new MutableLiveData<>("");
        this.runRecordAdapter = new MutableLiveData<>();
        this.recordPageIndex = 1;
        this.numberTypeface = LazyKt.lazy(new Function0<Typeface>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$numberTypeface$2
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Typeface m684invoke() {
                return ResourcesCompat.getFont(Utils.a(), R.font.shandong_ding);
            }
        });
    }

    public static final void E0(MediatorLiveData<Boolean> mediatorLiveData, RunIndexVM runIndexVM) {
        boolean z = false;
        if (!Intrinsics.areEqual(runIndexVM.isBindAlipay.getValue(), Boolean.TRUE)) {
            RunPlanBean value = runIndexVM.currentRunPlan.getValue();
            if ((value != null ? value.getTouchCheckType() : 0) != 0) {
                z = true;
            }
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
    }

    public static final void F0(MediatorLiveData<Boolean> mediatorLiveData, RunIndexVM runIndexVM) {
        Boolean value = runIndexVM.showMedalWall.getValue();
        Boolean bool = Boolean.TRUE;
        mediatorLiveData.setValue(Boolean.valueOf(Intrinsics.areEqual(value, bool) && !Intrinsics.areEqual(runIndexVM.showFreePunch.getValue(), bool)));
    }

    public static final void o0(RunIndexVM runIndexVM, MediatorLiveData<String> mediatorLiveData) {
        String string;
        Integer value = runIndexVM.inspirationTotal.getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        Boolean value2 = runIndexVM.showFreePunch.getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value2, bool)) {
            string = "";
        } else if (Intrinsics.areEqual(runIndexVM.showMedalWall.getValue(), bool)) {
            string = "前往查看";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(iIntValue);
            sb.append(')');
            string = sb.toString();
        }
        mediatorLiveData.setValue(string);
    }

    public static final void p0(RunIndexVM runIndexVM, MediatorLiveData<String> mediatorLiveData) {
        String str;
        Integer value = runIndexVM.inspirationTotal.getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        Boolean value2 = runIndexVM.showMedalWall.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value2, bool)) {
            str = "勋章墙";
        } else if (Intrinsics.areEqual(runIndexVM.showFreePunch.getValue(), bool)) {
            str = fe9.b.FLASH_COINS;
        } else {
            str = "闪金币 (" + iIntValue + ')';
        }
        mediatorLiveData.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void u0(RunIndexVM runIndexVM, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        runIndexVM.t0(i, z, function1);
    }

    @NotNull
    public final LiveData<SpannableStringBuilder> A() {
        return this.awardValue;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x004d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x004b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[LOOP:1: B:14:0x0035->B:33:?, LOOP_END, SYNTHETIC] */
    public final void A0(List<SemesterBean> semesterList) {
        SemesterBean semesterBean;
        boolean z;
        Object next;
        SemesterBean semesterBeanD = ai9.d();
        Object obj = null;
        if (semesterBeanD != null) {
            Iterator<T> it = semesterList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((SemesterBean) next).getSemesterCode(), semesterBeanD.getSemesterCode()));
            semesterBean = (SemesterBean) next;
            if (semesterBean == null) {
                for (Object obj2 : semesterList) {
                    z = true;
                    if (((SemesterBean) obj2).getStatus() == 1) {
                        z = false;
                    }
                    if (z) {
                        obj = obj2;
                        break;
                    }
                }
                semesterBean = (SemesterBean) obj;
            }
        } else {
            while (r7.hasNext()) {
                z = true;
                if (((SemesterBean) obj2).getStatus() == 1) {
                    z = false;
                }
                if (z) {
                    obj = obj2;
                    break;
                }
            }
            semesterBean = (SemesterBean) obj;
        }
        if (semesterBean != null) {
            this.selectedSemester.setValue(semesterBean);
        }
    }

    public final BaseModel B() {
        return (BaseModel) this.baseModel.getValue();
    }

    public final void B0(boolean z) {
        this.hasLoadPlanList = z;
    }

    public final void C() {
        BaseViewModelExtKt.b(this, false, false, null, null, new RunIndexVM$getCurrentActivity$1(this, null), 13, null);
    }

    public final void C0(@NotNull MutableLiveData<RunIndexRecordAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.runRecordAdapter = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<RunPlanBean> D() {
        return this.currentRunPlan;
    }

    public final void D0(@NotNull MutableLiveData<CommonUserInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.userInfo = mutableLiveData;
    }

    @NotNull
    public final LiveData<String> E() {
        return this.effectiveLabel;
    }

    @NotNull
    public final LiveData<String> F() {
        return this.effectiveValue;
    }

    @NotNull
    public final LiveData<Integer> G() {
        return this.freePunchCount;
    }

    @NotNull
    public final LiveData<String> H() {
        return this.goalKmValue;
    }

    @NotNull
    public final LiveData<String> I() {
        return this.goalProgressCurrentText;
    }

    @NotNull
    public final LiveData<String> J() {
        return this.goalProgressPercentText;
    }

    @NotNull
    public final LiveData<String> K() {
        return this.goalProgressTotalText;
    }

    @NotNull
    public final LiveData<Integer> L() {
        return this.goalSeekProgress;
    }

    @NotNull
    public final LiveData<String> M() {
        return this.goalTimesValue;
    }

    /* JADX INFO: renamed from: N, reason: from getter */
    public final boolean getHasLoadPlanList() {
        return this.hasLoadPlanList;
    }

    @NotNull
    public final MediatorLiveData<String> O() {
        return this.leftEntryDesc;
    }

    @NotNull
    public final LiveData<Integer> P() {
        return this.leftEntryIcon;
    }

    @NotNull
    public final MediatorLiveData<String> Q() {
        return this.leftEntryTitle;
    }

    @NotNull
    public final LiveData<String> R() {
        return this.morningValue;
    }

    public final Typeface S() {
        return (Typeface) this.numberTypeface.getValue();
    }

    @NotNull
    public final MutableLiveData<List<RunPlanBean>> T() {
        return this.runPlanList;
    }

    @NotNull
    public final MutableLiveData<RunIndexRecordAdapter> U() {
        return this.runRecordAdapter;
    }

    @NotNull
    public final MediatorLiveData<String> V() {
        return this.runRecordSectionTitle;
    }

    @NotNull
    public final MutableLiveData<SemesterBean> W() {
        return this.selectedSemester;
    }

    @NotNull
    public final MutableLiveData<List<SemesterBean>> X() {
        return this.semesterList;
    }

    @NotNull
    public final MediatorLiveData<Boolean> Y() {
        return this.showAlipayBind;
    }

    @NotNull
    public final LiveData<Boolean> Z() {
        return this.showFreePunch;
    }

    @NotNull
    public final LiveData<Boolean> a0() {
        return this.showGoalKm;
    }

    @NotNull
    public final LiveData<Boolean> b0() {
        return this.showGoalProgressDoneLabel;
    }

    @NotNull
    public final LiveData<Boolean> c0() {
        return this.showGoalTimes;
    }

    @NotNull
    public final LiveData<Boolean> d0() {
        return this.showLeftEntryDesc;
    }

    @NotNull
    public final MutableLiveData<Boolean> e0() {
        return this.showMedalWall;
    }

    @NotNull
    public final MediatorLiveData<Boolean> f0() {
        return this.showMedalWallGoView;
    }

    @NotNull
    public final LiveData<Boolean> g0() {
        return this.showMorningCount;
    }

    @NotNull
    public final MediatorLiveData<Boolean> h0() {
        return this.showSwitchRunPlan;
    }

    @NotNull
    public final MutableLiveData<SunshineRunDetail> i0() {
        return this.sunshineRunDetail;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> j0() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<CommonUserInfo> k0() {
        return this.userInfo;
    }

    @NotNull
    public final LiveData<Integer> l0() {
        return this.userStatus;
    }

    @NotNull
    public final MutableLiveData<Boolean> m0() {
        return this.isActivity;
    }

    public final boolean n0() {
        if (this.selectedSemester.getValue() == null) {
            return true;
        }
        SemesterBean value = this.selectedSemester.getValue();
        return value != null && value.getStatus() == 1;
    }

    public final void q0() {
        this.recordPageIndex++;
        s0();
    }

    public final void r0() {
        BaseViewModelExtKt.b(this, false, false, null, null, new RunIndexVM$queryMedalWall$1(this, null), 13, null);
    }

    public final void s0() {
        String semesterCode;
        SemesterBean value = this.selectedSemester.getValue();
        if (value == null || (semesterCode = value.getSemesterCode()) == null) {
            return;
        }
        RunPlanBean value2 = this.currentRunPlan.getValue();
        String runPlanCode = value2 != null ? value2.getRunPlanCode() : null;
        if (runPlanCode == null) {
            runPlanCode = "";
        }
        String str = runPlanCode;
        final boolean z = this.recordPageIndex == 1;
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.run_index.RunIndexVM$queryRecordList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                RunIndexRecordAdapter value3;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (z && (value3 = this.U().getValue()) != null) {
                    value3.setList(null);
                    value3.i();
                }
                return Boolean.FALSE;
            }
        }, null, new RunIndexVM$queryRecordList$2(this, semesterCode, str, z, null), 11, null);
    }

    public final void t0(int sportType, boolean showLoading, @Nullable Function1<? super SunshineRunDetail, Unit> onSuccess) {
        String semesterCode;
        SemesterBean value = this.selectedSemester.getValue();
        if (value == null || (semesterCode = value.getSemesterCode()) == null) {
            return;
        }
        RunPlanBean value2 = this.currentRunPlan.getValue();
        String runPlanCode = value2 != null ? value2.getRunPlanCode() : null;
        if (runPlanCode == null) {
            runPlanCode = "";
        }
        BaseViewModelExtKt.b(this, showLoading, false, null, null, new RunIndexVM$queryRunDetail$1(semesterCode, runPlanCode, sportType, this, onSuccess, null), 14, null);
    }

    public final void v(SpanHonghuUtil.SpanBuilder builder, String text) {
        int length = builder.q().length();
        builder.a(text, 24);
        Typeface typefaceS = S();
        if (typefaceS != null) {
            builder.q().setSpan(new SpanUtils.CustomTypefaceSpan(typefaceS), length, builder.q().length(), 33);
        }
    }

    public final void v0() {
        SemesterBean value;
        String semesterCode;
        if (this.isLoadPlanList || (value = this.selectedSemester.getValue()) == null || (semesterCode = value.getSemesterCode()) == null) {
            return;
        }
        this.isLoadPlanList = true;
        BaseViewModelExtKt.b(this, true, false, null, null, new RunIndexVM$queryRunPlanList$1(semesterCode, this, null), 14, null);
    }

    public final boolean w() {
        SemesterBean value = this.selectedSemester.getValue();
        return (value == null || value.getPlanOptionFlag()) && this.currentRunPlan.getValue() != null;
    }

    public final void w0() {
        BaseViewModelExtKt.b(this, true, false, null, null, new RunIndexVM$querySemesterList$1(this, null), 14, null);
    }

    public final String x(long meters) {
        return y(meters) + "km";
    }

    public final void x0() {
        n76.d(B().f()).i(new a());
    }

    public final String y(long meters) {
        return h46.f42049a.j(Float.valueOf((float) (Math.floor(meters / ((long) 100)) / 10.0d)), 1);
    }

    public final void y0() {
        this.recordPageIndex = 1;
        s0();
    }

    @NotNull
    public final MutableLiveData<String> z() {
        return this.activityRunBannerText;
    }

    public final void z0() {
        BaseViewModelExtKt.b(this, false, false, null, null, new RunIndexVM$requestInspiration$1(this, null), 13, null);
    }
}
