package com.huachenjie.sport.page.mine.appeallist;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.pulltorefresh.BaseErrorViewComponent;
import com.huachenjie.common.pulltorefresh.BasePageComponent;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.common.widget.DividerLayoutDecoration;
import com.huachenjie.sport.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zj.adlib.jj8;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AppealPageComponent extends BasePageComponent<AppealListFragment> {
    public static final String f = "RecordPageComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f36572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseErrorViewComponent f13714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseSmartRefreshLayout f13715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnAppealListener f13716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AppealRecordAdapter f13717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<DailySunshineRecord> f13718a;

    public interface OnAppealListener {
        void a(int i);
    }

    public class a implements BaseSmartRefreshLayout.StatusListener {
        public a() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onLoadMore(RefreshLayout refreshLayout) {
            AppealPageComponent.this.handleLoadMore();
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onRefresh(RefreshLayout refreshLayout) {
            AppealPageComponent.this.r();
        }
    }

    public class b implements BaseErrorViewComponent.OnRefreshClickListener {
        public b() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseErrorViewComponent.OnRefreshClickListener
        public boolean a() {
            return AppealPageComponent.this.p();
        }
    }

    public class c implements AppealRecordViewHolder.RecordClickListener {
        public c() {
        }

        @Override // com.huachenjie.sport.page.mine.appeallist.AppealRecordViewHolder.RecordClickListener
        public void a(SportRecord sportRecord) {
            if (sportRecord == null) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.Run.b).withString("runRecordCode", sportRecord.getRunRecordCode()).withString("semesterCode", sportRecord.getSemesterCode()).navigation();
        }
    }

    public AppealPageComponent(AppealListFragment appealListFragment) {
        super(appealListFragment);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f13718a = new ArrayList();
        this.f13717a = new AppealRecordAdapter(b());
        this.f36572a = (RecyclerView) a(R.id.recycler_appeal_list);
        this.f13715a = (BaseSmartRefreshLayout) a(R.id.refreshlayout_appeal_list);
        this.f13714a = new BaseErrorViewComponent(((BaseComponent) this).f33636a);
        u();
        v();
        t();
    }

    public void handleLoadMore() {
        s();
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
        this.f13715a.setStatusChangeListener(new a());
        this.f13714a.setOnRefreshClickListener(new b());
        this.f13717a.y(new c());
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean p() {
        this.f13715a.setEnableRefresh(true);
        return this.f13715a.autoRefresh();
    }

    public void q(String str) {
        if (!g()) {
            this.f13715a.finishLoadMore();
            return;
        }
        this.f13715a.finishRefreshWithNoMoreData();
        this.f13714a.A();
        this.f13718a.clear();
        this.f13717a.f();
    }

    public final void r() {
        List<DailySunshineRecord> list = this.f13718a;
        if (list != null) {
            list.clear();
        }
        i();
        s();
    }

    public final void s() {
        OnAppealListener onAppealListener = this.f13716a;
        if (onAppealListener != null) {
            onAppealListener.a(this.M);
        }
        BaseErrorViewComponent baseErrorViewComponent = this.f13714a;
        if (baseErrorViewComponent != null) {
            baseErrorViewComponent.e();
        }
    }

    public void setOnRecordListener(OnAppealListener onAppealListener) {
        this.f13716a = onAppealListener;
    }

    public final void t() {
        this.f13714a.f(R.string.no_appeal_record_prompt);
    }

    public final void u() {
        this.f36572a.setLayoutManager(new LinearLayoutManager(b()));
        this.f36572a.addItemDecoration(new DividerLayoutDecoration(b(), 1, jj8.b(1.0f, b()), ResourcesCompat.getColor(b().getResources(), R.color.color_eeeeee, null)));
        this.f36572a.setAdapter(this.f13717a);
    }

    public final void v() {
        this.f13715a.setEnableRefresh(false);
        this.f13715a.setEnableAutoLoadMore(true);
    }

    public void w(SunshineRecordListEntity sunshineRecordListEntity) {
        this.f13715a.finishLoadMore();
        if (sunshineRecordListEntity != null) {
            List<DailySunshineRecord> listY = y(sunshineRecordListEntity.getList());
            this.f13718a.addAll(listY);
            this.f13717a.d(listY);
            d(sunshineRecordListEntity.isHasNext(), this.f13715a);
            h();
        }
    }

    public final List<DailySunshineRecord> y(List<DailySunshineRecord> list) {
        if (list == null) {
            return new ArrayList();
        }
        if (!this.f13718a.isEmpty()) {
            List<DailySunshineRecord> list2 = this.f13718a;
            DailySunshineRecord dailySunshineRecord = list2.get(list2.size() - 1);
            int size = this.f13718a.size() - 1;
            DailySunshineRecord dailySunshineRecordRemove = list.remove(0);
            if (dailySunshineRecord.getMonthDate().equals(dailySunshineRecordRemove.getMonthDate())) {
                dailySunshineRecord.setTotalTime(dailySunshineRecord.getTotalTime() + dailySunshineRecordRemove.getTotalTime());
                dailySunshineRecord.setTotalCalorie(dailySunshineRecord.getTotalCalorie() + dailySunshineRecordRemove.getTotalCalorie());
                dailySunshineRecord.getList().addAll(dailySunshineRecordRemove.getList());
                this.f13717a.q(size, (DailySunshineRecord) JSON.parseObject(JSON.toJSONString(dailySunshineRecord), DailySunshineRecord.class));
            } else {
                list.add(0, dailySunshineRecordRemove);
            }
        }
        return list;
    }

    public void z(SunshineRecordListEntity sunshineRecordListEntity) {
        this.f13715a.setEnableRefresh(false);
        if (sunshineRecordListEntity == null || sunshineRecordListEntity.getList() == null || sunshineRecordListEntity.getList().isEmpty()) {
            this.f13714a.y();
            this.f13715a.finishRefreshWithNoMoreData();
            return;
        }
        this.f13715a.finishRefresh();
        this.f13718a.addAll(sunshineRecordListEntity.getList());
        this.f13717a.t(sunshineRecordListEntity.getList());
        d(sunshineRecordListEntity.isHasNext(), this.f13715a);
        h();
    }
}
