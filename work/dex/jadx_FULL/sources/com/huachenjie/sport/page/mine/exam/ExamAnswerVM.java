package com.huachenjie.sport.page.mine.exam;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.bean.ExamQuestionType;
import com.zj.adlib.a63;
import com.zj.adlib.n76;
import com.zj.adlib.s72;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamAnswerVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SportModel f36651a = new SportModel();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<Integer> j = new MutableLiveData<>(Integer.MAX_VALUE);
    public MutableLiveData<ExamQuestionData> k = new MutableLiveData<>();
    public MutableLiveData<ExamQuestionType> l = new MutableLiveData<>();
    public MutableLiveData<Integer> m = new MutableLiveData<>(1);
    public MutableLiveData<ExamViewPageAdapter> n = new MutableLiveData<>();

    public class a extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExamQuestionData f36652a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BizSubscriber f13750a;

        public a(ExamQuestionData examQuestionData, BizSubscriber bizSubscriber) {
            this.f36652a = examQuestionData;
            this.f13750a = bizSubscriber;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            ExamAnswerVM.this.j(this.f36652a.getExamCode(), this.f13750a);
        }
    }

    public class b implements RxViewUtil.CountDownAction {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f13751a;

        public b(Integer num) {
            this.f13751a = num;
        }

        @Override // com.huachenjie.common.util.RxViewUtil.CountDownAction
        public void a(long j) {
            ExamAnswerVM.this.j.setValue(Integer.valueOf((int) (((long) this.f13751a.intValue()) - j)));
            BindingTitleBean value = ExamAnswerVM.this.i.getValue();
            if (value != null) {
                value.setTitleName(ys8.c("倒计时%s", s72.n(((long) this.f13751a.intValue()) - j)));
                ExamAnswerVM.this.i.setValue(value);
            }
        }

        @Override // com.huachenjie.common.util.RxViewUtil.CountDownAction
        public void onFinish() {
            ExamAnswerVM.this.j.setValue(0);
            BindingTitleBean value = ExamAnswerVM.this.i.getValue();
            if (value != null) {
                value.setTitleName(ys8.c("考试时间到，请交卷", new Object[0]));
                ExamAnswerVM.this.i.setValue(value);
            }
        }
    }

    public CustomizeViewDialog.Builder h(BizSubscriber<JSONObject> bizSubscriber) {
        Integer value = this.j.getValue();
        if (value != null && value.intValue() <= 0) {
            this.j.setValue(0);
            return null;
        }
        ExamQuestionData value2 = this.k.getValue();
        if (value2 == null || value2.getQuestions() == null || value2.getQuestions().size() <= 0) {
            return null;
        }
        Map<Long, Set<Long>> mapD = a63.d(value2.getExamCode());
        return DialogUtil.h((mapD == null || mapD.size() < value2.getQuestions().size()) ? "你还有未完成的题目，确定交卷？" : "你确定要交卷吗？", "继续考试", "确定交卷", new a(value2, bizSubscriber));
    }

    public void i(Integer num) {
        if (num == null) {
            return;
        }
        RxViewUtil.d(0L, 1L, num.intValue(), new b(num));
    }

    public void j(Long l, BizSubscriber<JSONObject> bizSubscriber) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        n76.e(this, this.f36651a.R(l.longValue())).p5(bizSubscriber);
    }

    public void k(int i) {
        ExamQuestionData value = this.k.getValue();
        if (value == null || value.getQuestions() == null || value.getQuestions().size() <= i) {
            return;
        }
        this.l.setValue(value.getQuestions().get(i).getQuestionTypeEnum());
        this.m.setValue(Integer.valueOf(i + 1));
    }
}
