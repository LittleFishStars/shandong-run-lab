package com.huachenjie.run.page.free_record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.pulltorefresh.BaseErrorViewComponent;
import com.huachenjie.common.pulltorefresh.BasePageComponent;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.common.widget.DividerLayoutDecoration;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.FreeRecordAdapter;
import com.huachenjie.run.adapter.FreeRecordViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zj.adlib.jj8;
import com.zj.adlib.s72;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRecordPageComponent extends BasePageComponent<FreeRecordFragment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f35851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f12441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f12442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseErrorViewComponent f12443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseSmartRefreshLayout f12444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FreeRecordAdapter f12445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRecordListener f12446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<DailySunshineRecord> f12447a;
    public TextView b;
    public TextView c;
    public TextView d;

    public interface OnRecordListener {
        void a(int pageNo);
    }

    public class a implements BaseSmartRefreshLayout.StatusListener {
        public a() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onLoadMore(RefreshLayout refreshLayout) {
            FreeRecordPageComponent.this.handleLoadMore();
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onRefresh(RefreshLayout refreshLayout) {
            FreeRecordPageComponent.this.r();
        }
    }

    public class b implements BaseErrorViewComponent.OnRefreshClickListener {
        public b() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseErrorViewComponent.OnRefreshClickListener
        public boolean a() {
            return FreeRecordPageComponent.this.p();
        }
    }

    public class c implements FreeRecordViewHolder.RecordClickListener {
        public c() {
        }

        @Override // com.huachenjie.run.adapter.FreeRecordViewHolder.RecordClickListener
        public void a(SportRecord sportRecord) {
            if (sportRecord == null) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.Run.b).withString("runRecordCode", sportRecord.getRunRecordCode()).navigation();
        }
    }

    public FreeRecordPageComponent(FreeRecordFragment fragment) {
        super(fragment);
    }

    public void A(SportStatics sportStatics) {
        if (sportStatics == null) {
            return;
        }
        this.f12441a.setText(BigDecimal.valueOf(sportStatics.getTotalCalorie()).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        this.b.setText(s72.n(sportStatics.getTotalDuration()));
        this.c.setText(s72.e(sportStatics.getBestPace()));
        this.d.setText(BigDecimal.valueOf(sportStatics.getTotalDistance()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString());
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f12447a = new ArrayList();
        this.f12445a = new FreeRecordAdapter(b());
        this.f12442a = (RecyclerView) a(R.id.recycler_record_list);
        this.f12444a = (BaseSmartRefreshLayout) a(R.id.refreshlayout_record_list);
        this.f12443a = new BaseErrorViewComponent(((BaseComponent) this).f33636a);
        View viewInflate = LayoutInflater.from(b()).inflate(R.layout.run_header_free_run_record, (ViewGroup) null, false);
        this.f35851a = viewInflate;
        this.f12441a = (TextView) viewInflate.findViewById(R.id.tv_burned_calories);
        this.b = (TextView) this.f35851a.findViewById(R.id.tv_costed_time);
        this.c = (TextView) this.f35851a.findViewById(R.id.tv_best_pace);
        this.d = (TextView) this.f35851a.findViewById(R.id.tv_total_distance);
        u();
        v();
        t();
    }

    public void handleLoadMore() {
        s();
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
        this.f12444a.setStatusChangeListener(new a());
        this.f12443a.setOnRefreshClickListener(new b());
        this.f12445a.y(new c());
    }

    public boolean p() {
        this.f12444a.setEnableRefresh(true);
        return this.f12444a.autoRefresh();
    }

    public void q(String message) {
        if (!g()) {
            this.f12444a.finishLoadMore();
            return;
        }
        this.f12444a.finishRefreshWithNoMoreData();
        this.f12443a.A();
        this.f12447a.clear();
        this.f12445a.f();
    }

    public final void r() {
        List<DailySunshineRecord> list = this.f12447a;
        if (list != null) {
            list.clear();
        }
        i();
        s();
    }

    public final void s() {
        OnRecordListener onRecordListener = this.f12446a;
        if (onRecordListener != null) {
            onRecordListener.a(this.M);
        }
        BaseErrorViewComponent baseErrorViewComponent = this.f12443a;
        if (baseErrorViewComponent != null) {
            baseErrorViewComponent.e();
        }
    }

    public void setOnRecordListener(OnRecordListener listener) {
        this.f12446a = listener;
    }

    public final void t() {
        this.f12443a.f(R.string.no_sports_record_prompt);
    }

    public final void u() {
        this.f12442a.setLayoutManager(new LinearLayoutManager(b()));
        this.f12442a.addItemDecoration(new DividerLayoutDecoration(b(), 1, jj8.b(1.0f, b()), ResourcesCompat.getColor(b().getResources(), R.color.color_eeeeee, null)));
        this.f12445a.w(this.f35851a);
        this.f12442a.setAdapter(this.f12445a);
    }

    public final void v() {
        this.f12444a.setEnableRefresh(false);
        this.f12444a.setEnableAutoLoadMore(true);
    }

    public void w(SunshineRecordListEntity entity) {
        this.f12442a.setVisibility(0);
        this.f12444a.finishLoadMore();
        if (entity != null) {
            List<DailySunshineRecord> listY = y(entity.getList());
            this.f12447a.addAll(listY);
            this.f12445a.d(listY);
            d(entity.isHasNext(), this.f12444a);
            h();
        }
    }

    public final List<DailySunshineRecord> y(List<DailySunshineRecord> nextPageList) {
        if (nextPageList == null) {
            return new ArrayList();
        }
        if (!this.f12447a.isEmpty()) {
            List<DailySunshineRecord> list = this.f12447a;
            DailySunshineRecord dailySunshineRecord = list.get(list.size() - 1);
            int size = this.f12447a.size() - 1;
            DailySunshineRecord dailySunshineRecordRemove = nextPageList.remove(0);
            if (dailySunshineRecord.getMonthDate().equals(dailySunshineRecordRemove.getMonthDate())) {
                dailySunshineRecord.setTotalTime(dailySunshineRecord.getTotalTime() + dailySunshineRecordRemove.getTotalTime());
                dailySunshineRecord.setTotalCalorie(dailySunshineRecord.getTotalCalorie() + dailySunshineRecordRemove.getTotalCalorie());
                dailySunshineRecord.getList().addAll(dailySunshineRecordRemove.getList());
                this.f12445a.q(size, (DailySunshineRecord) JSON.parseObject(JSON.toJSONString(dailySunshineRecord), DailySunshineRecord.class));
            } else {
                nextPageList.add(0, dailySunshineRecordRemove);
            }
        }
        return nextPageList;
    }

    public void z(SunshineRecordListEntity entity) {
        this.f12442a.setVisibility(0);
        this.f12444a.setEnableRefresh(false);
        if (entity == null || entity.getList() == null || entity.getList().isEmpty()) {
            this.f12443a.y();
            this.f12444a.finishRefreshWithNoMoreData();
            return;
        }
        this.f12444a.finishRefresh();
        this.f12447a.addAll(entity.getList());
        this.f12445a.t(entity.getList());
        d(entity.isHasNext(), this.f12444a);
        h();
    }
}
