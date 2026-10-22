package com.huachenjie.run.page.sunshine_run.success;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.run.bean.EmaAnswerBean;
import com.huachenjie.run.bean.EmaOptionBean;
import com.huachenjie.run.bean.EmaQuestionBean;
import com.huachenjie.run.bean.EmaSelectionBean;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.RunFinishBannerData;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.fe9;
import com.zj.adlib.y6b;
import com.zj.adlib.zz8;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0017\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002R%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR%\u0010&\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\n0\n0\u00188\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR%\u0010)\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00130\u00130\u00188\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR%\u0010,\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\n0\n0\u00188\u0006¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001eR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160\u00188\u0006¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR%\u00102\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00130\u00130\u00188\u0006¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR%\u00105\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\n0\n0\u00188\u0006¢\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010\u001eR%\u00107\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\n0\n0\u00188\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b6\u0010\u001eR%\u0010:\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000108080\u00188\u0006¢\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b9\u0010\u001eR\u0017\u0010@\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010AR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010ER\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010HR0\u0010O\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130Lj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010N¨\u0006R"}, d2 = {"Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Lcom/huachenjie/run/bean/EmaAnswerBean;", "emaAnswer", "", "v", "", "index", "A", "u", "", "x", "B", "distanceMeter", "C", "(Ljava/lang/Integer;)V", "y", j.o, "D", "", "question", "totalText", "Landroid/text/SpannableStringBuilder;", "j", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "s", "()Landroidx/lifecycle/MutableLiveData;", "myAvgSpeed", "Lcom/huachenjie/run/bean/FinishRunResult;", "c", "t", "resultLiveData", "d", "w", "isActivityRunLiveD", "e", t.d, "calorieText", "f", "r", "moodSurveyVisible", y6b.f, "n", "moodQuestionSpan", y6b.g, j.b, "moodRewardText", "i", "p", "moodSubmitHighlight", "q", "moodSubmitSuccess", "Lcom/huachenjie/run/bean/RunFinishBannerData;", "k", "bannerData", "Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter;", "a", "Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter;", "m", "()Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter;", "moodAdapter", "Ljava/lang/String;", "answerNo", "", "Lcom/huachenjie/run/bean/EmaQuestionBean;", "Ljava/util/List;", "emaQuestions", "K", "I", "questionIndex", "L", DressingTableActivity.x, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "selectionMap", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunSuccessVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunSuccessVM.kt\ncom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n1#2:174\n1#2:185\n1603#3,9:175\n1855#3:184\n1856#3:186\n1612#3:187\n*S KotlinDebug\n*F\n+ 1 SunshineRunSuccessVM.kt\ncom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessVM\n*L\n97#1:185\n97#1:175,9\n97#1:184\n97#1:186\n97#1:187\n*E\n"})
public final class SunshineRunSuccessVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int questionIndex;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int selectedIndex;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SunshineRunSuccessMoodAdapter moodAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final LinkedHashMap<String, String> selectionMap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public List<EmaQuestionBean> emaQuestions;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Long> myAvgSpeed = new MutableLiveData<>(0L);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FinishRunResult> resultLiveData = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isActivityRunLiveD;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> calorieText;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> moodSurveyVisible;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String answerNo;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SpannableStringBuilder> moodQuestionSpan;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> moodRewardText;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> moodSubmitHighlight;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> moodSubmitSuccess;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunFinishBannerData> bannerData;

    public SunshineRunSuccessVM() {
        Boolean bool = Boolean.FALSE;
        this.isActivityRunLiveD = new MutableLiveData<>(bool);
        this.calorieText = new MutableLiveData<>("0kcal");
        this.moodSurveyVisible = new MutableLiveData<>(bool);
        this.moodQuestionSpan = new MutableLiveData<>();
        this.moodRewardText = new MutableLiveData<>("");
        this.moodSubmitHighlight = new MutableLiveData<>(bool);
        this.moodSubmitSuccess = new MutableLiveData<>(bool);
        this.bannerData = new MutableLiveData<>(new RunFinishBannerData(null, 1, null));
        this.moodAdapter = new SunshineRunSuccessMoodAdapter();
        this.emaQuestions = CollectionsKt.emptyList();
        this.selectedIndex = -1;
        this.selectionMap = new LinkedHashMap<>();
    }

    public final void A(int index) {
        EmaOptionBean emaOptionBean;
        EmaQuestionBean emaQuestionBean = (EmaQuestionBean) CollectionsKt.getOrNull(this.emaQuestions, this.questionIndex);
        if (emaQuestionBean == null || (emaOptionBean = (EmaOptionBean) CollectionsKt.getOrNull(emaQuestionBean.getOptions(), index)) == null) {
            return;
        }
        this.selectionMap.put(emaQuestionBean.getQuestionNo(), emaOptionBean.getOptionNo());
        this.selectedIndex = index;
        this.moodAdapter.h(index);
        D();
    }

    public final void B() {
        String str = this.answerNo;
        if (str == null) {
            str = "";
        }
        if ((str.length() == 0) || this.selectionMap.size() < this.emaQuestions.size()) {
            return;
        }
        List<EmaQuestionBean> list = this.emaQuestions;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            EmaSelectionBean emaSelectionBean = null;
            if (!it.hasNext()) {
                break;
            }
            EmaQuestionBean emaQuestionBean = (EmaQuestionBean) it.next();
            String str2 = this.selectionMap.get(emaQuestionBean.getQuestionNo());
            if (str2 != null) {
                String questionNo = emaQuestionBean.getQuestionNo();
                Intrinsics.checkNotNullExpressionValue(str2, "optionNo");
                emaSelectionBean = new EmaSelectionBean(questionNo, str2);
            }
            if (emaSelectionBean != null) {
                arrayList.add(emaSelectionBean);
            }
        }
        if (arrayList.size() != this.emaQuestions.size()) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new SunshineRunSuccessVM$submitMoodAnswers$1(str, arrayList, this, null), 14, null);
    }

    public final void C(@Nullable Integer distanceMeter) {
        String plainString = BigDecimal.valueOf(ai9.e().getSex() == 2 ? 65L : 53L).multiply(BigDecimal.valueOf(distanceMeter != null ? distanceMeter.intValue() : 0)).multiply(new BigDecimal("1.036")).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toPlainString();
        this.calorieText.setValue(plainString + "kcal");
    }

    public final void D() {
        this.moodSubmitHighlight.setValue(Boolean.valueOf(x() && this.selectedIndex >= 0));
    }

    public final SpannableStringBuilder j(String question, String totalText) {
        if (question.length() == 0) {
            return new SpannableStringBuilder("");
        }
        if (totalText.length() == 0) {
            return new SpannableStringBuilder(question);
        }
        String str = question + ' ' + totalText;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new zz8(Color.parseColor("#1A0BD3FF"), Color.parseColor("#00B6DE"), SizeUtils.i(10.0f), SizeUtils.b(14.0f), SizeUtils.b(4.0f), SizeUtils.b(7.0f), 0), question.length() + 1, str.length(), 33);
        return spannableStringBuilder;
    }

    @NotNull
    public final MutableLiveData<RunFinishBannerData> k() {
        return this.bannerData;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.calorieText;
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: from getter */
    public final SunshineRunSuccessMoodAdapter getMoodAdapter() {
        return this.moodAdapter;
    }

    @NotNull
    public final MutableLiveData<SpannableStringBuilder> n() {
        return this.moodQuestionSpan;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.moodRewardText;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.moodSubmitHighlight;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.moodSubmitSuccess;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.moodSurveyVisible;
    }

    @NotNull
    public final MutableLiveData<Long> s() {
        return this.myAvgSpeed;
    }

    @NotNull
    public final MutableLiveData<FinishRunResult> t() {
        return this.resultLiveData;
    }

    public final void u() {
        if (this.questionIndex >= CollectionsKt.getLastIndex(this.emaQuestions)) {
            return;
        }
        this.questionIndex++;
        z();
    }

    public final void v(@Nullable EmaAnswerBean emaAnswer) {
        Integer rewardAmount;
        String str = null;
        List<EmaQuestionBean> questions = emaAnswer != null ? emaAnswer.getQuestions() : null;
        if (questions == null) {
            questions = CollectionsKt.emptyList();
        }
        this.answerNo = emaAnswer != null ? emaAnswer.getAnswerNo() : null;
        this.selectionMap.clear();
        this.emaQuestions = questions;
        this.questionIndex = 0;
        this.moodSurveyVisible.setValue(Boolean.valueOf(!questions.isEmpty()));
        MutableLiveData<String> mutableLiveData = this.moodRewardText;
        if (emaAnswer != null && (rewardAmount = emaAnswer.getRewardAmount()) != null) {
            if (!(rewardAmount.intValue() > 0)) {
                rewardAmount = null;
            }
            if (rewardAmount != null) {
                str = rewardAmount.intValue() + fe9.b.FLASH_COINS;
            }
        }
        if (str == null) {
            str = "";
        }
        mutableLiveData.setValue(str);
        z();
    }

    @NotNull
    public final MutableLiveData<Boolean> w() {
        return this.isActivityRunLiveD;
    }

    public final boolean x() {
        return (this.emaQuestions.isEmpty() ^ true) && this.questionIndex >= CollectionsKt.getLastIndex(this.emaQuestions);
    }

    public final void y() {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessVM$queryBannerList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.k().setValue(new RunFinishBannerData(null, 1, null));
                return Boolean.FALSE;
            }
        }, null, new SunshineRunSuccessVM$queryBannerList$2(this, null), 10, null);
    }

    public final void z() {
        this.selectedIndex = -1;
        this.moodAdapter.h(-1);
        EmaQuestionBean emaQuestionBean = (EmaQuestionBean) CollectionsKt.getOrNull(this.emaQuestions, this.questionIndex);
        SunshineRunSuccessMoodAdapter sunshineRunSuccessMoodAdapter = this.moodAdapter;
        List<EmaOptionBean> options = emaQuestionBean != null ? emaQuestionBean.getOptions() : null;
        if (options == null) {
            options = CollectionsKt.emptyList();
        }
        sunshineRunSuccessMoodAdapter.setList(options);
        MutableLiveData<SpannableStringBuilder> mutableLiveData = this.moodQuestionSpan;
        String content = emaQuestionBean != null ? emaQuestionBean.getContent() : null;
        String string = "";
        if (content == null) {
            content = "";
        }
        if (this.emaQuestions.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) 20849);
            sb.append(this.emaQuestions.size());
            sb.append((char) 39064);
            string = sb.toString();
        }
        mutableLiveData.setValue(j(content, string));
        D();
    }
}
