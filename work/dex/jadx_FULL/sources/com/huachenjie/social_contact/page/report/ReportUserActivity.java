package com.huachenjie.social_contact.page.report;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.kernel.RVStartParams;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.social_contact.bean.ReportReasonBean;
import com.huachenjie.social_contact.databinding.ActivityReportUserBinding;
import com.huachenjie.social_contact.page.report.ReportUserActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.d)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\u0004\u0018\u00010\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001b\u0010$\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u001d¨\u0006'"}, d2 = {"Lcom/huachenjie/social_contact/page/report/ReportUserActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/report/ReportUserVM;", "", "e0", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "x0", "v0", "t0", bo.g, "", "index", "w0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "", "Lkotlin/Lazy;", "o0", "()Ljava/lang/String;", UserConstants.CHAT_PARAMS.g, "b", "l0", "()I", RVStartParams.KEY_FROM_TYPE, "c", "m0", UserConstants.CHAT_PARAMS.f, "d", "n0", UserConstants.CHAT_PARAMS.h, "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReportUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportUserActivity.kt\ncom/huachenjie/social_contact/page/report/ReportUserActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,236:1\n1855#2,2:237\n*S KotlinDebug\n*F\n+ 1 ReportUserActivity.kt\ncom/huachenjie/social_contact/page/report/ReportUserActivity\n*L\n213#1:237,2\n*E\n"})
public final class ReportUserActivity extends BaseVmActivity<ReportUserVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy reportUserId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$reportUserId$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra(UserConstants.CHAT_PARAMS.g);
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$fromType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m759invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(UserConstants.CHAT_PARAMS.e, 0));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy reportCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$reportCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra(UserConstants.CHAT_PARAMS.f);
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy reportSource = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$reportSource$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m761invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(UserConstants.CHAT_PARAMS.h, 0));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/page/report/ReportUserActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/social_contact/page/report/ReportUserActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Boolean value = ((ReportUserVM) ((BaseVmActivity) ReportUserActivity.this).f8507a).j().getValue();
            if (value == null || !value.booleanValue()) {
                ((ReportUserVM) ((BaseVmActivity) ReportUserActivity.this).f8507a).j().setValue(Boolean.TRUE);
                ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) ReportUserActivity.this).f8507a;
                String strO0 = ReportUserActivity.this.o0();
                if (strO0 == null) {
                    strO0 = "";
                }
                int iL0 = ReportUserActivity.this.l0();
                String strM0 = ReportUserActivity.this.m0();
                reportUserVM.r(strO0, iL0, strM0 != null ? strM0 : "", ReportUserActivity.this.n0());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/report/ReportUserActivity$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nReportUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportUserActivity.kt\ncom/huachenjie/social_contact/page/report/ReportUserActivity$init$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,236:1\n1855#2,2:237\n*S KotlinDebug\n*F\n+ 1 ReportUserActivity.kt\ncom/huachenjie/social_contact/page/report/ReportUserActivity$init$1\n*L\n82#1:237,2\n*E\n"})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            List<String> listG = ((MediaPickerResult.Success) result).g();
            ReportUserActivity reportUserActivity = ReportUserActivity.this;
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                ((ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a).s(reportUserActivity, reportUserActivity.l0(), (String) it.next());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36289a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36289a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36289a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36289a.invoke(obj);
        }
    }

    public static final void q0(ReportUserActivity reportUserActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<ReportUserAdapter> mutableLiveDataH;
        ReportUserAdapter value;
        List<ReportReasonBean> data;
        Intrinsics.checkNotNullParameter(reportUserActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a;
        if (reportUserVM == null || (mutableLiveDataH = reportUserVM.h()) == null || (value = mutableLiveDataH.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        ReportReasonBean reportReasonBean = data.get(i);
        for (ReportReasonBean reportReasonBean2 : data) {
            reportReasonBean2.setSelected(reportReasonBean2.getCode() == reportReasonBean.getCode());
        }
        ((ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a).o().setValue(Integer.valueOf(reportReasonBean.getCode()));
        ((ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a).p().setValue(reportReasonBean.getReason());
        baseQuickAdapter.notifyDataSetChanged();
    }

    public static final void r0(ReportUserActivity reportUserActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK;
        ReportImageEvidenceAdapter value;
        Intrinsics.checkNotNullParameter(reportUserActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a;
        if (reportUserVM == null || (mutableLiveDataK = reportUserVM.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        if (TextUtils.isEmpty(value.getData().get(i))) {
            reportUserActivity.x0();
        } else {
            reportUserActivity.w0(i);
        }
    }

    public static final void s0(ReportUserActivity reportUserActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK;
        ReportImageEvidenceAdapter value;
        Integer value2;
        MutableLiveData<Integer> mutableLiveDataL;
        Intrinsics.checkNotNullParameter(reportUserActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a;
        if (reportUserVM == null || (mutableLiveDataK = reportUserVM.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        value.removeAt(i);
        ReportUserVM reportUserVM2 = (ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a;
        if (reportUserVM2 == null || (mutableLiveDataL = reportUserVM2.l()) == null || (value2 = mutableLiveDataL.getValue()) == null) {
            value2 = 1;
        }
        int iIntValue = value2.intValue();
        ReportUserVM reportUserVM3 = (ReportUserVM) ((BaseVmActivity) reportUserActivity).f8507a;
        MutableLiveData<Integer> mutableLiveDataL2 = reportUserVM3 != null ? reportUserVM3.l() : null;
        if (mutableLiveDataL2 == null) {
            return;
        }
        mutableLiveDataL2.setValue(Integer.valueOf(iIntValue - 1));
    }

    public static final void u0(ReportUserActivity reportUserActivity, View view) {
        Intrinsics.checkNotNullParameter(reportUserActivity, "this$0");
        reportUserActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).q1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(com.huachenjie.social_contact.R.layout.activity_report_user), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(\n     …m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        this.picker = MediaPicker.w(this, new b());
        t0();
        p0();
        v0();
        ActivityReportUserBinding activityReportUserBinding = (ActivityReportUserBinding) getBinding();
        if (activityReportUserBinding != null) {
            activityReportUserBinding.f12772a.getLayoutParams().height = (int) (((fx7.j() - TypedValue.applyDimension(1, 52.0f, getResources().getDisplayMetrics())) / 3) + TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics()));
            activityReportUserBinding.f36102a.setHint(ArraysKt.contains(new int[]{2, 3, 4}, l0()) ? "请输入举报理由…" : "描述中带有对方昵称和事情的简要经过更好");
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final int l0() {
        return ((Number) this.fromType.getValue()).intValue();
    }

    @Nullable
    public final String m0() {
        return (String) this.reportCode.getValue();
    }

    public final int n0() {
        return ((Number) this.reportSource.getValue()).intValue();
    }

    public final String o0() {
        return (String) this.reportUserId.getValue();
    }

    public final void p0() {
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK;
        ReportImageEvidenceAdapter value;
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK2;
        ReportImageEvidenceAdapter value2;
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK3;
        ReportImageEvidenceAdapter value3;
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK4;
        ReportImageEvidenceAdapter value4;
        MutableLiveData<ReportUserAdapter> mutableLiveDataH;
        ReportUserAdapter value5;
        MutableLiveData<ReportUserAdapter> mutableLiveDataH2;
        ReportUserAdapter value6;
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<ReportUserAdapter> mutableLiveDataH3 = reportUserVM != null ? reportUserVM.h() : null;
        if (mutableLiveDataH3 != null) {
            mutableLiveDataH3.setValue(new ReportUserAdapter());
        }
        ReportUserVM reportUserVM2 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM2 != null && (mutableLiveDataH2 = reportUserVM2.h()) != null && (value6 = mutableLiveDataH2.getValue()) != null) {
            value6.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ef7
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ReportUserActivity.q0(this.f41425a, baseQuickAdapter, view, i);
                }
            });
        }
        List listListOf = ArraysKt.contains(new int[]{2, 3, 4}, l0()) ? CollectionsKt.listOf(new ReportReasonBean[]{new ReportReasonBean("色情骚扰", 1, false), new ReportReasonBean("暴力", 2, false), new ReportReasonBean("广告", 3, false), new ReportReasonBean("欺诈", 4, false), new ReportReasonBean("其他", 7, false)}) : CollectionsKt.listOf(new ReportReasonBean[]{new ReportReasonBean("色情骚扰", 1, false), new ReportReasonBean("暴力", 2, false), new ReportReasonBean("广告", 3, false), new ReportReasonBean("欺诈", 4, false), new ReportReasonBean("头像不雅", 5, false), new ReportReasonBean("昵称不雅", 6, false), new ReportReasonBean("其他", 7, false)});
        ReportUserVM reportUserVM3 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM3 != null && (mutableLiveDataH = reportUserVM3.h()) != null && (value5 = mutableLiveDataH.getValue()) != null) {
            value5.setList(listListOf);
        }
        ReportUserVM reportUserVM4 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK5 = reportUserVM4 != null ? reportUserVM4.k() : null;
        if (mutableLiveDataK5 != null) {
            mutableLiveDataK5.setValue(new ReportImageEvidenceAdapter());
        }
        ReportUserVM reportUserVM5 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM5 != null && (mutableLiveDataK4 = reportUserVM5.k()) != null && (value4 = mutableLiveDataK4.getValue()) != null) {
            value4.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ff7
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ReportUserActivity.r0(this.f41665a, baseQuickAdapter, view, i);
                }
            });
        }
        ReportUserVM reportUserVM6 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM6 != null && (mutableLiveDataK3 = reportUserVM6.k()) != null && (value3 = mutableLiveDataK3.getValue()) != null) {
            value3.addChildClickViewIds(com.huachenjie.social_contact.R.id.iv_report_close);
        }
        ReportUserVM reportUserVM7 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM7 != null && (mutableLiveDataK2 = reportUserVM7.k()) != null && (value2 = mutableLiveDataK2.getValue()) != null) {
            value2.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.gf7
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ReportUserActivity.s0(this.f41891a, baseQuickAdapter, view, i);
                }
            });
        }
        ReportUserVM reportUserVM8 = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM8 == null || (mutableLiveDataK = reportUserVM8.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        value.setList(CollectionsKt.mutableListOf(new String[]{""}));
    }

    public final void t0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((ReportUserVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((ReportUserVM) ((BaseVmActivity) this).f8507a).q().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(com.huachenjie.social_contact.R.mipmap.ic_message_back).setTitleName("举报内容").setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.df7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportUserActivity.u0(this.f41172a, view);
            }
        }).setTitleTextColor(zn1.a(com.huachenjie.social_contact.R.color.color_2C3E50)));
    }

    public final void v0() {
        ((ReportUserVM) ((BaseVmActivity) this).f8507a).i().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$obsCommitFinish$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                this.this$0.finish();
            }
        }));
    }

    public final void w0(int index) {
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK;
        final ReportImageEvidenceAdapter value;
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM == null || (mutableLiveDataK = reportUserVM.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : value.getData()) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        PicturePreviewUtil.h(this, arrayList, index, new Function1<Integer, View>() { // from class: com.huachenjie.social_contact.page.report.ReportUserActivity$preImage$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @Nullable
            public final View invoke(int i) {
                return value.getViewByPosition(i, com.huachenjie.social_contact.R.id.iv_report_image);
            }
        });
    }

    public final void x0() {
        MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK;
        ReportImageEvidenceAdapter value;
        ReportUserVM reportUserVM = (ReportUserVM) ((BaseVmActivity) this).f8507a;
        if (reportUserVM == null || (mutableLiveDataK = reportUserVM.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        if (value.getData().size() > 3) {
            fv5.b("最多只能选择3张图片");
            return;
        }
        int size = 4 - value.getData().size();
        if (size <= 0) {
            return;
        }
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, size, 1080, 1024, false, 0.0f, 0.0f, false, 240, null);
    }
}
