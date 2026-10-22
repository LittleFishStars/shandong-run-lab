package com.huachenjie.sport.page.mine.exam;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.huachenjie.common.widget.ExamNoticeBottomDialog;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.databinding.ActivityExamAnswerBinding;
import com.huachenjie.sport.widget.CascadeTransformer;
import com.zj.adlib.a63;
import com.zj.adlib.c25;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.p)
public class ExamAnswerActivity extends BaseVmActivity<ExamAnswerVM> implements AdCancelInterface {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Autowired(name = "data")
    public ExamQuestionData f13746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExamAnswerSheetDialog f13748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f13747a = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2.OnPageChangeCallback f36646a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnItemClickListener f13745a = new OnItemClickListener() { // from class: com.zj.adlib.w53
        @Override // com.chad.library.adapter.base.listener.OnItemClickListener
        public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            this.f45526a.w0(baseQuickAdapter, view, i);
        }
    };

    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            ((ExamAnswerVM) ((BaseVmActivity) ExamAnswerActivity.this).f8507a).k(i);
        }
    }

    public class b extends BizSubscriber<JSONObject> {
        public b(boolean z) {
            super(z);
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            if (i == 2302 || i == 2303) {
                a63.g(ExamAnswerActivity.this.f13746a.getExamCode(), null);
                a63.h(ExamAnswerActivity.this.f13746a.getExamCode(), null);
                EventBus.f().q(new ExamDetailData(ExamAnswerActivity.this.f13746a.getExamCode()));
                ExamAnswerActivity.this.finish();
            }
        }

        public void onCCSuccess(JSONObject jSONObject) {
            a63.g(ExamAnswerActivity.this.f13746a.getExamCode(), null);
            a63.h(ExamAnswerActivity.this.f13746a.getExamCode(), null);
            EventBus.f().q(new ExamDetailData(ExamAnswerActivity.this.f13746a.getExamCode()));
            ExamAnswerActivity.this.finish();
        }
    }

    public class c {
        public c() {
        }

        public void a(View view) {
            if (ExamAnswerActivity.this.f13746a.getQuestions() != null) {
                Integer value = ((ExamAnswerVM) ((BaseVmActivity) ExamAnswerActivity.this).f8507a).m.getValue();
                ExamAnswerActivity examAnswerActivity = ExamAnswerActivity.this;
                examAnswerActivity.f13748a = ExamAnswerSheetDialog.getInstance(examAnswerActivity.f13746a.getExamCode(), value == null ? 0 : value.intValue(), new ArrayList(ExamAnswerActivity.this.f13746a.getQuestions()));
                ExamAnswerActivity.this.f13748a.setOnItemClickListener(ExamAnswerActivity.this.f13745a);
                ExamAnswerActivity.this.f13748a.show(ExamAnswerActivity.this.getSupportFragmentManager(), ExamAnswerSheetDialog.class.getName());
            }
        }

        public void b(View view) {
            CustomizeViewDialog.Builder builderH = ((ExamAnswerVM) ((BaseVmActivity) ExamAnswerActivity.this).f8507a).h(ExamAnswerActivity.this.q0());
            if (builderH != null) {
                builderH.create(ExamAnswerActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).j(this.f13746a.getExamCode(), q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(Integer num) {
        ExamQuestionData examQuestionDataE = a63.e(this.f13746a.getExamCode());
        if (examQuestionDataE != null) {
            examQuestionDataE.setRemainingTime(num);
            a63.h(examQuestionDataE.getExamCode(), examQuestionDataE);
        }
        if (num.intValue() <= 0) {
            DialogUtil.J(this, "考试时间到", "考试时间到，请点击交卷", "交卷", false, false, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.v53
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    this.f45292a.s0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        ExamNoticeBottomDialog.INSTANCE.getInstance("我知道了").show(getSupportFragmentManager(), ExamNoticeBottomDialog.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        this.f13747a.b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ExamAnswerSheetDialog examAnswerSheetDialog = this.f13748a;
        if (examAnswerSheetDialog != null && examAnswerSheetDialog.isShowing()) {
            this.f13748a.dismiss();
            this.f13748a = null;
        }
        ((ActivityExamAnswerBinding) getBinding()).f13206a.setCurrentItem(i, false);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_exam_answer), Integer.valueOf(ok0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.N), this.f36646a).a(Integer.valueOf(ok0.k), this.f13747a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        r0();
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).k.setValue(this.f13746a);
        c25.y("考试code：" + this.f13746a.getExamCode());
        ExamViewPageAdapter examViewPageAdapter = new ExamViewPageAdapter(this.f13746a.getExamCode());
        examViewPageAdapter.setList(this.f13746a.getQuestions());
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).n.setValue(examViewPageAdapter);
        ((ActivityExamAnswerBinding) getBinding()).f13206a.setPageTransformer(new CascadeTransformer());
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).i(this.f13746a.getRemainingTime());
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).j.observe(this, new Observer() { // from class: com.zj.adlib.x53
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f45747a.t0((Integer) obj);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        a63.h(this.f13746a.getExamCode(), this.f13746a);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f13747a.b(null);
    }

    public BizSubscriber<JSONObject> q0() {
        return new b(true);
    }

    public final void r0() {
        ((ExamAnswerVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((ExamAnswerVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setTitleName("倒计时").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowRightIcon(true).setRightIconResId(R.drawable.ic_exam_tip).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.y53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45960a.u0(view);
            }
        }).setBackIconResId(R.drawable.ic_close_tint).setBackTintColor(-16777216).setBackShow(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.z53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46189a.v0(view);
            }
        }));
    }
}
