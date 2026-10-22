package com.huachenjie.sport.page.mine.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamResultData;
import com.huachenjie.sport.databinding.ActivityExamHistoryResultsBinding;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.su9;
import com.zj.adlib.zn1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "n0", "initView", "k0", "", "a", "Lkotlin/Lazy;", "j0", "()Ljava/lang/String;", ExamHistoryResultsActivity.x, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ExamHistoryResultsActivity extends BaseVmActivity<ExamHistoryResultsVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String x = "examCode";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy examCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity$examCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra(ExamHistoryResultsActivity.x);
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.p63
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            ExamHistoryResultsActivity.p0(this.f43913a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsActivity$a;", "", "Landroid/content/Context;", "context", "", ExamHistoryResultsActivity.x, "", "a", "EXAM_CODE", "Ljava/lang/String;", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String examCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(examCode, ExamHistoryResultsActivity.x);
            Intent intent = new Intent(context, (Class<?>) ExamHistoryResultsActivity.class);
            intent.putExtra(ExamHistoryResultsActivity.x, examCode);
            context.startActivity(intent);
        }
    }

    public static final void l0(ExamHistoryResultsAdapter examHistoryResultsAdapter, ExamHistoryResultsActivity examHistoryResultsActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(examHistoryResultsAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(examHistoryResultsActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ExamDetailData examDetailData = examHistoryResultsAdapter.getData().get(i);
            if (examDetailData.getResult() == null) {
                return;
            }
            Context context = view.getContext();
            String strJ0 = examHistoryResultsActivity.j0();
            ExamResultData result = examDetailData.getResult();
            su9.h(context, strJ0, result != null ? result.getExamStudentResultCode() : null);
        } catch (Exception unused) {
        }
    }

    public static final void m0(ExamHistoryResultsActivity examHistoryResultsActivity) {
        Intrinsics.checkNotNullParameter(examHistoryResultsActivity, "this$0");
        ((ExamHistoryResultsVM) ((BaseVmActivity) examHistoryResultsActivity).f8507a).m();
    }

    public static final void o0(ExamHistoryResultsActivity examHistoryResultsActivity, View view) {
        Intrinsics.checkNotNullParameter(examHistoryResultsActivity, "this$0");
        examHistoryResultsActivity.finish();
    }

    public static final void p0(ExamHistoryResultsActivity examHistoryResultsActivity) {
        Intrinsics.checkNotNullParameter(examHistoryResultsActivity, "this$0");
        ((ExamHistoryResultsVM) ((BaseVmActivity) examHistoryResultsActivity).f8507a).o();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        Integer numValueOf = Integer.valueOf(R.layout.activity_exam_history_results);
        Integer numValueOf2 = Integer.valueOf(ok0.p0);
        Q q = ((BaseVmActivity) this).f8507a;
        Intrinsics.checkNotNull(q);
        i62 i62VarA = new i62(numValueOf, numValueOf2, q).a(Integer.valueOf(ok0.R), this.onRefreshListener);
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…fresh, onRefreshListener)");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        n0();
        initView();
        ExamHistoryResultsVM examHistoryResultsVM = (ExamHistoryResultsVM) ((BaseVmActivity) this).f8507a;
        String strJ0 = j0();
        if (strJ0 == null) {
            strJ0 = "";
        }
        examHistoryResultsVM.p(strJ0);
        ((ExamHistoryResultsVM) ((BaseVmActivity) this).f8507a).o();
    }

    public final void initView() {
        k0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final String j0() {
        return (String) this.examCode.getValue();
    }

    public final void k0() {
        if (((ActivityExamHistoryResultsBinding) getBinding()) != null) {
            final ExamHistoryResultsAdapter examHistoryResultsAdapter = new ExamHistoryResultsAdapter();
            examHistoryResultsAdapter.addChildClickViewIds(R.id.tv_look_exam_paper);
            examHistoryResultsAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.n63
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ExamHistoryResultsActivity.l0(examHistoryResultsAdapter, this, baseQuickAdapter, view, i);
                }
            });
            examHistoryResultsAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.o63
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    ExamHistoryResultsActivity.m0(this.f43678a);
                }
            });
            ((ExamHistoryResultsVM) ((BaseVmActivity) this).f8507a).h().setValue(examHistoryResultsAdapter);
        }
    }

    public final void n0() {
        MutableLiveData<Integer> mutableLiveData;
        ExamHistoryResultsVM examHistoryResultsVM = (ExamHistoryResultsVM) ((BaseVmActivity) this).f8507a;
        Integer value = null;
        MutableLiveData<BindingTitleBean> mutableLiveData2 = examHistoryResultsVM != null ? examHistoryResultsVM.i : null;
        if (mutableLiveData2 == null) {
            return;
        }
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        ExamHistoryResultsVM examHistoryResultsVM2 = (ExamHistoryResultsVM) ((BaseVmActivity) this).f8507a;
        if (examHistoryResultsVM2 != null && (mutableLiveData = ((BaseVM) examHistoryResultsVM2).f33644a) != null) {
            value = mutableLiveData.getValue();
        }
        Intrinsics.checkNotNull(value);
        mutableLiveData2.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("历史成绩单").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackTintColor(-16777216).setBackIconResId(R.drawable.ic_back_black).setBackShow(true).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.m63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamHistoryResultsActivity.o0(this.f43230a, view);
            }
        }));
    }
}
