package com.huachenjie.sport.page.mine.exam;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.callback.DefaultCallback;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ExamAttendFlag;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.bean.ExamStatus;
import com.zj.adlib.a63;
import com.zj.adlib.fv5;
import com.zj.adlib.i63;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamDetailVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SportModel f36656a = new SportModel();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<ExamDetailData> j = new MutableLiveData<>();
    public MutableLiveData<Boolean> k = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExamNotFinishTipDialog f13752a = null;

    public class a extends BizSubscriber<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultCallback f36657a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ExamQuestionData f13753a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, ExamQuestionData examQuestionData, DefaultCallback defaultCallback) {
            super(z);
            this.f13753a = examQuestionData;
            this.f36657a = defaultCallback;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            int i = baseEntity.code;
            if (i == 2300) {
                DefaultCallback defaultCallback = this.f36657a;
                if (defaultCallback != null) {
                    defaultCallback.a();
                }
                ExamDetailVM.this.w(this.f13753a.getExamCode());
                return true;
            }
            if (i == 2302 || i == 2303) {
                DefaultCallback defaultCallback2 = this.f36657a;
                if (defaultCallback2 != null) {
                    defaultCallback2.a();
                }
                ExamDetailVM.this.k.setValue(Boolean.TRUE);
                ExamDetailVM.this.r(this.f13753a.getExamCode());
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.containsKey("remainingTime")) {
                ExamDetailVM.this.k.setValue(Boolean.TRUE);
                fv5.b("恢复失败");
            } else {
                this.f13753a.setRemainingTime(jSONObject.getInteger("remainingTime"));
                ARouter.getInstance().build(RoutePathConstants.Sport.p).withParcelable("data", this.f13753a).navigation();
            }
            DefaultCallback defaultCallback = this.f36657a;
            if (defaultCallback != null) {
                defaultCallback.a();
            }
        }
    }

    public class b extends BizSubscriber<ExamQuestionData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExamAttendFlag f36658a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f13756a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, ExamAttendFlag examAttendFlag, Long l) {
            super(z);
            this.f36658a = examAttendFlag;
            this.f13756a = l;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            switch (baseEntity.code) {
                case 2300:
                    if (this.f36658a == ExamAttendFlag.NotSubmit) {
                        ExamDetailVM.this.w(this.f13756a);
                        return true;
                    }
                    ExamDetailVM.this.k.setValue(Boolean.TRUE);
                    ExamDetailVM.this.r(this.f13756a);
                    break;
                case 2301:
                case 2302:
                case 2303:
                    ExamDetailVM.this.k.setValue(Boolean.TRUE);
                    ExamDetailVM.this.r(this.f13756a);
                    break;
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(ExamQuestionData examQuestionData) {
            if (examQuestionData != null) {
                ARouter.getInstance().build(RoutePathConstants.Sport.p).withParcelable("data", examQuestionData).navigation();
            }
        }
    }

    public class c extends DialogVMSubscriber<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultCallback f36659a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f13758a;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HttpVmDialog httpVmDialog, boolean z, boolean z2, Long l, DefaultCallback defaultCallback) {
            super(httpVmDialog, z);
            this.c = z2;
            this.f13758a = l;
            this.f36659a = defaultCallback;
        }

        public void onFailed(int i, String str) {
            super.onFailed(i, str);
            if (i == 2302 || i == 2303) {
                if (!this.c) {
                    ExamDetailVM.this.k.setValue(Boolean.TRUE);
                }
                ExamDetailVM.this.r(this.f13758a);
            }
        }

        public void onFinish() {
            if (this.c) {
                ExamDetailVM.this.k.setValue(Boolean.TRUE);
            }
            DefaultCallback defaultCallback = this.f36659a;
            if (defaultCallback != null) {
                defaultCallback.a();
            }
        }

        public void onCCSuccess(JSONObject jSONObject) {
            if (!this.c) {
                ExamDetailVM.this.k.setValue(Boolean.TRUE);
            }
            ExamDetailVM.this.r(this.f13758a);
        }
    }

    public class d extends BizSubscriber<ExamDetailData> {
        public d(boolean z) {
            super(z);
        }

        public void onCCSuccess(ExamDetailData examDetailData) {
            if (examDetailData != null) {
                ExamDetailVM.this.j.setValue(examDetailData);
            }
        }
    }

    public class e extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExamAttendFlag f36661a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f13760a;

        public e(ExamAttendFlag examAttendFlag, Long l) {
            this.f36661a = examAttendFlag;
            this.f13760a = l;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            ExamDetailVM.this.d();
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            ExamDetailVM.this.x(this.f36661a, this.f13760a);
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36662a;

        static {
            int[] iArr = new int[ExamStatus.values().length];
            f36662a = iArr;
            try {
                iArr[ExamStatus.InExam.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36662a[ExamStatus.ExamOver.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ExamDetailVM() {
        EventBus.f().v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(ExamQuestionData examQuestionData) {
        y(examQuestionData.getExamCode(), false, new i63(this));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit p(ExamQuestionData examQuestionData) {
        s(examQuestionData, new i63(this));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Long l) {
        y(l, true, null);
    }

    public final void n() {
        ExamNotFinishTipDialog examNotFinishTipDialog = this.f13752a;
        if (examNotFinishTipDialog != null) {
            examNotFinishTipDialog.dismissAllowingStateLoss();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVM, androidx.p002lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        EventBus.f().A(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ExamDetailData examDetailData) {
        r(examDetailData.getExamCode());
    }

    public final void r(Long l) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        n76.e(this, this.f36656a.t(l)).p5(new d(true));
    }

    public void s(ExamQuestionData examQuestionData, DefaultCallback defaultCallback) {
        if (examQuestionData == null) {
            fv5.b("数据异常，恢复失败");
        } else {
            n76.e(this, this.f36656a.M(examQuestionData.getExamCode())).p5(new a(true, examQuestionData, defaultCallback));
        }
    }

    public final void t(ExamAttendFlag examAttendFlag, Long l) {
        g(DialogUtil.l("你有未完成的考试", "当前有一个未完成的考试\n是否重新开始考试？", OptionsPickerHelper.e, "重新开始考试", false, false, new e(examAttendFlag, l), false));
    }

    public boolean u() {
        int i;
        ExamDetailData value = this.j.getValue();
        if (value == null) {
            return false;
        }
        ExamStatus examStatusEnum = value.getExamStatusEnum();
        ExamAttendFlag examAttendFlagEnum = value.getExamAttendFlagEnum();
        if (examAttendFlagEnum != ExamAttendFlag.NotSubmit || ((i = f.f36662a[examStatusEnum.ordinal()]) != 1 && i != 2)) {
            return false;
        }
        ExamQuestionData examQuestionDataE = a63.e(value.getExamCode());
        Map<Long, Set<Long>> mapD = a63.d(value.getExamCode());
        if (examQuestionDataE == null || examQuestionDataE.getQuestions() == null) {
            t(examAttendFlagEnum, value.getExamCode());
        } else {
            v(examQuestionDataE, mapD != null ? mapD.size() : 0);
        }
        return true;
    }

    public final void v(final ExamQuestionData examQuestionData, int i) {
        n();
        ExamNotFinishTipDialog onRightClickListener = ExamNotFinishTipDialog.INSTANCE.a(i, examQuestionData.getQuestions().size()).setOnLeftClickListener(new Function0() { // from class: com.zj.adlib.k63
            public final Object invoke() {
                return this.f17593a.o(examQuestionData);
            }
        }).setOnRightClickListener(new Function0() { // from class: com.zj.adlib.l63
            public final Object invoke() {
                return this.f17885a.p(examQuestionData);
            }
        });
        this.f13752a = onRightClickListener;
        f(onRightClickListener);
    }

    public final void w(final Long l) {
        g(DialogUtil.u("考试时间到", "考试时间到，请点击交卷", "交卷", false, false, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.j63
            @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
            public final void onClicked() {
                this.f42517a.q(l);
            }
        }));
    }

    public void x(ExamAttendFlag examAttendFlag, Long l) {
        n76.e(this, this.f36656a.Q(l)).p5(new b(true, examAttendFlag, l));
    }

    public void y(Long l, boolean z, DefaultCallback defaultCallback) {
        n76.e(this, this.f36656a.R(l.longValue())).p5(new c(this, true, z, l, defaultCallback));
    }
}
