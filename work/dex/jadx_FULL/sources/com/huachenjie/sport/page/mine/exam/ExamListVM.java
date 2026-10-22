package com.huachenjie.sport.page.mine.exam;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamListData;
import com.huachenjie.sport.bean.ExamPageList;
import com.zj.adlib.n76;
import huachenjie.sdk.http.subscriber.BizSubscriber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamListVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SportModel f36666a = new SportModel();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<Integer> j = new MutableLiveData<>(1);
    public MutableLiveData<ExamListAdapter> k = new MutableLiveData<>();
    public String f = "";
    public int K = 1;

    public class a extends BizSubscriber<ExamPageList> {
        public a(boolean z) {
            super(z);
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            ExamListVM.this.n();
        }

        public void onFinish() {
            super.onFinish();
            ExamListVM.this.o();
        }

        public void onCCSuccess(ExamPageList examPageList) {
            if (examPageList != null) {
                ExamListAdapter value = ExamListVM.this.k.getValue();
                if (value == null) {
                    value = ExamListVM.this.l();
                }
                if (examPageList.getList() != null) {
                    value.setList(examPageList.getList());
                }
                ExamListVM.this.k.setValue(value);
            }
        }
    }

    public class b extends BizSubscriber<ExamDetailData> {
        public b(boolean z) {
            super(z);
        }

        public void onCCSuccess(ExamDetailData examDetailData) {
            if (examDetailData != null) {
                ARouter.getInstance().build(RoutePathConstants.Sport.o).withParcelable("detail", examDetailData).navigation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof ExamListData) {
            r(Long.valueOf(((ExamListData) item).getExamCode()));
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVM
    public String getEmptyText() {
        return "暂无理论考试";
    }

    public final ExamListAdapter l() {
        ExamListAdapter examListAdapter = new ExamListAdapter();
        examListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.r63
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                this.f44382a.m(baseQuickAdapter, view, i);
            }
        });
        return examListAdapter;
    }

    public final void n() {
        ExamListAdapter value = this.k.getValue();
        if (value == null || value.getData().isEmpty()) {
            this.j.setValue(3);
        }
    }

    public final void o() {
        ExamListAdapter value = this.k.getValue();
        if (value == null || value.getData().isEmpty()) {
            this.j.setValue(2);
        } else {
            this.j.setValue(1);
        }
    }

    public void p() {
        this.K++;
        q();
    }

    public final void q() {
        n76.e(this, this.f36666a.s(this.K, this.f)).p5(new a(true));
    }

    public final void r(Long l) {
        n76.e(this, this.f36666a.t(l)).p5(new b(true));
    }

    public void s() {
        this.K = 1;
        q();
    }
}
