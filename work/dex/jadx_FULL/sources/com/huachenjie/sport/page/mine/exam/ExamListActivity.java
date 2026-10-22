package com.huachenjie.sport.page.mine.exam;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivityExamListBinding;
import com.huachenjie.sport.page.mine.exam.ExamListActivity;
import com.igexin.push.g.o;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.n)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamListActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/exam/ExamListVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "h0", "initView", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ExamListActivity extends BaseVmActivity<ExamListVM> {
    public static final void i0(ExamListActivity examListActivity, View view) {
        Intrinsics.checkNotNullParameter(examListActivity, "this$0");
        examListActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        Integer numValueOf = Integer.valueOf(R.layout.activity_exam_list);
        Integer numValueOf2 = Integer.valueOf(ok0.L);
        Q q = ((BaseVmActivity) this).f8507a;
        Intrinsics.checkNotNull(q);
        return new i62(numValueOf, numValueOf2, q);
    }

    public final void h0() {
        MutableLiveData<Integer> mutableLiveData;
        ExamListVM examListVM = (ExamListVM) ((BaseVmActivity) this).f8507a;
        Integer value = null;
        MutableLiveData<BindingTitleBean> mutableLiveData2 = examListVM != null ? examListVM.i : null;
        if (mutableLiveData2 == null) {
            return;
        }
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        ExamListVM examListVM2 = (ExamListVM) ((BaseVmActivity) this).f8507a;
        if (examListVM2 != null && (mutableLiveData = ((BaseVM) examListVM2).f33644a) != null) {
            value = mutableLiveData.getValue();
        }
        Intrinsics.checkNotNull(value);
        mutableLiveData2.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("理论考试").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackTintColor(-16777216).setBackIconResId(R.drawable.ic_back_black).setBackShow(true).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.q63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamListActivity.i0(this.f44135a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        h0();
        initView();
        ExamListVM examListVM = (ExamListVM) ((BaseVmActivity) this).f8507a;
        if (examListVM != null) {
            examListVM.s();
        }
    }

    public final void initView() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityExamListBinding");
        ((ActivityExamListBinding) binding).f13233a.openIntervalCallback(500L, new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.exam.ExamListActivity.initView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                ExamListVM examListVM = (ExamListVM) ((BaseVmActivity) ExamListActivity.this).f8507a;
                if (examListVM != null) {
                    examListVM.f = str;
                }
                ExamListVM examListVM2 = (ExamListVM) ((BaseVmActivity) ExamListActivity.this).f8507a;
                if (examListVM2 != null) {
                    examListVM2.s();
                }
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
