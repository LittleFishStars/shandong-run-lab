package com.huachenjie.sport.page.mine.exam;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.widget.ExamNoticeBottomDialog;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamAttendFlag;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.zj.adlib.a63;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.su9;
import com.zj.adlib.zn1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.o)
public class ExamDetailActivity extends BaseVmActivity<ExamDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "detail")
    public ExamDetailData f36654a;

    public class a {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit d() {
            ((ExamDetailVM) ((BaseVmActivity) ExamDetailActivity.this).f8507a).x(ExamAttendFlag.NotStart, ExamDetailActivity.this.f36654a.getExamCode());
            return null;
        }

        public void b(View view) {
            ExamDetailData value = ((ExamDetailVM) ((BaseVmActivity) ExamDetailActivity.this).f8507a).j.getValue();
            if (value == null || value.getResult() == null) {
                return;
            }
            su9.h(view.getContext(), String.valueOf(value.getExamCode()), value.getResult().getExamStudentResultCode());
        }

        public void c(View view) {
            if (((ExamDetailVM) ((BaseVmActivity) ExamDetailActivity.this).f8507a).u()) {
                return;
            }
            ExamNoticeBottomDialog companion = ExamNoticeBottomDialog.INSTANCE.getInstance("我已阅读，开始考试");
            companion.setCloseCallback(new Function0() { // from class: com.zj.adlib.h63
                public final Object invoke() {
                    return this.f42058a.d();
                }
            });
            companion.show(ExamDetailActivity.this.getSupportFragmentManager(), ExamNoticeBottomDialog.class.getName());
        }
    }

    public static /* synthetic */ void p0(ExamDetailData examDetailData, View view) {
        ExamHistoryResultsActivity.INSTANCE.a(view.getContext(), examDetailData.formatExamCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        ExamNoticeBottomDialog.INSTANCE.getInstance("我知道了").show(getSupportFragmentManager(), ExamNoticeBottomDialog.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(Boolean bool) {
        if (!bool.booleanValue() || ((ExamDetailVM) ((BaseVmActivity) this).f8507a).j.getValue() == null) {
            return;
        }
        ExamDetailData value = ((ExamDetailVM) ((BaseVmActivity) this).f8507a).j.getValue();
        a63.h(value.getExamCode(), null);
        a63.g(value.getExamCode(), null);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_exam_detail), Integer.valueOf(ok0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        if (this.f36654a == null) {
            finish();
        }
        ((ExamDetailVM) ((BaseVmActivity) this).f8507a).j.setValue(this.f36654a);
        ((ExamDetailVM) ((BaseVmActivity) this).f8507a).u();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((ExamDetailVM) ((BaseVmActivity) this).f8507a).j.observe(this, new Observer() { // from class: com.zj.adlib.b63
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f40685a.t0((ExamDetailData) obj);
            }
        });
        ((ExamDetailVM) ((BaseVmActivity) this).f8507a).k.observe(this, new Observer() { // from class: com.zj.adlib.c63
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f40909a.u0((Boolean) obj);
            }
        });
    }

    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final void t0(final ExamDetailData examDetailData) {
        BindingTitleBean backClick;
        boolean z = (examDetailData == null || examDetailData.getResult() == null) ? false : true;
        String str = z ? "成绩单" : "考试详情";
        if (z) {
            backClick = new BindingTitleBean().setStatusBarHeight(((BaseVM) ((ExamDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setTitleName(str).setShowRightText(examDetailData.showHistory()).setShowRightIcon(false).setRightButtonText("历史成绩").setRightButtonTextColor(zn1.a(R.color.color_898fa2)).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.d63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamDetailActivity.p0(examDetailData, view);
                }
            }).setBackTintColor(-16777216).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.e63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41356a.q0(view);
                }
            });
        } else {
            backClick = new BindingTitleBean().setStatusBarHeight(((BaseVM) ((ExamDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setTitleName(str).setShowRightText(false).setShowRightIcon(true).setRightIconResId(R.drawable.ic_exam_tip).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.f63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41605a.r0(view);
                }
            }).setBackTintColor(-16777216).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.g63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41828a.s0(view);
                }
            });
        }
        ((ExamDetailVM) ((BaseVmActivity) this).f8507a).i.setValue(backClick);
    }
}
