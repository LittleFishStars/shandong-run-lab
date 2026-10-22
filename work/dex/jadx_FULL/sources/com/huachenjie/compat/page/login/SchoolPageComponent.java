package com.huachenjie.compat.page.login;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.base.BaseRecyclerAdapter;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.pulltorefresh.BaseErrorViewComponent;
import com.huachenjie.common.pulltorefresh.BasePageComponent;
import com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout;
import com.huachenjie.common.widget.DividerLayoutDecoration;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.SchoolListEntity;
import com.huachenjie.compat.page.login.adapter.SchoolAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class SchoolPageComponent extends BasePageComponent<SearchSchoolActivity> {
    public static final String f = "SchoolPageComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.OnScrollListener f34108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f9227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseErrorViewComponent f9228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseSmartRefreshLayout f9229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnSchoolListener f9230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SchoolAdapter f9231a;

    public interface OnSchoolListener {
        void a(int i);

        void b(SchoolInfo schoolInfo);
    }

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 || i == 1) {
                if (Glide.with(SchoolPageComponent.this.b()).isPaused()) {
                    Glide.with(SchoolPageComponent.this.b()).resumeRequests();
                }
            } else {
                if (Glide.with(SchoolPageComponent.this.b()).isPaused()) {
                    return;
                }
                Glide.with(SchoolPageComponent.this.b()).pauseRequests();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public class b implements BaseSmartRefreshLayout.StatusListener {
        public b() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onLoadMore(RefreshLayout refreshLayout) {
            SchoolPageComponent.this.handleLoadMore();
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseSmartRefreshLayout.StatusListener
        public void onRefresh(RefreshLayout refreshLayout) {
            SchoolPageComponent.this.t();
        }
    }

    public class c implements BaseErrorViewComponent.OnRefreshClickListener {
        public c() {
        }

        @Override // com.huachenjie.common.pulltorefresh.BaseErrorViewComponent.OnRefreshClickListener
        public boolean a() {
            return SchoolPageComponent.this.r();
        }
    }

    public class d implements BaseRecyclerAdapter.OnItemClickListener {
        public d() {
        }

        @Override // com.huachenjie.common.base.BaseRecyclerAdapter.OnItemClickListener
        public void a(View view, int i) {
            if (i < SchoolPageComponent.this.f9231a.g() && SchoolPageComponent.this.f9230a != null) {
                SchoolPageComponent.this.f9230a.b(SchoolPageComponent.this.f9231a.i(i));
            }
        }
    }

    public SchoolPageComponent(SearchSchoolActivity searchSchoolActivity) {
        super(searchSchoolActivity);
        this.f34108a = new a();
    }

    public void A(SchoolListEntity schoolListEntity) {
        this.f9229a.finishLoadMore();
        if (schoolListEntity != null) {
            this.f9231a.d(schoolListEntity.getList());
            d(schoolListEntity.isHasNext(), this.f9229a);
            h();
        }
    }

    public void B(SchoolListEntity schoolListEntity) {
        this.f9229a.finishRefresh();
        this.f9229a.setEnableRefresh(false);
        if (schoolListEntity == null || schoolListEntity.getList() == null || schoolListEntity.getList().isEmpty()) {
            this.f9228a.y();
            return;
        }
        this.f9231a.t(schoolListEntity.getList());
        d(schoolListEntity.isHasNext(), this.f9229a);
        h();
    }

    public void C(int i) {
        this.f9229a.setVisibility(i);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f9231a = new SchoolAdapter(b());
        this.f9227a = (RecyclerView) a(R.id.recycler_school_list);
        this.f9229a = (BaseSmartRefreshLayout) a(R.id.refreshlayout_school_list);
        this.f9228a = new BaseErrorViewComponent(((BaseComponent) this).f33636a);
        y();
        z();
        w();
    }

    public void handleLoadMore() {
        u();
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
        this.f9229a.setStatusChangeListener(new b());
        this.f9228a.setOnRefreshClickListener(new c());
        this.f9231a.setOnItemClickListener(new d());
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean r() {
        this.f9229a.setEnableRefresh(true);
        return this.f9229a.autoRefresh();
    }

    public void s(String str) {
        if (!g()) {
            this.f9229a.finishLoadMore();
            return;
        }
        this.f9229a.finishRefresh();
        this.f9228a.A();
        this.f9231a.f();
    }

    public void setOnSchoolListener(OnSchoolListener onSchoolListener) {
        this.f9230a = onSchoolListener;
    }

    public final void t() {
        i();
        u();
    }

    public final void u() {
        OnSchoolListener onSchoolListener = this.f9230a;
        if (onSchoolListener != null) {
            onSchoolListener.a(this.M);
        }
        BaseErrorViewComponent baseErrorViewComponent = this.f9228a;
        if (baseErrorViewComponent != null) {
            baseErrorViewComponent.e();
        }
    }

    public void v() {
        BaseErrorViewComponent baseErrorViewComponent = this.f9228a;
        if (baseErrorViewComponent != null) {
            baseErrorViewComponent.e();
        }
    }

    public final void w() {
        this.f9228a.h(R.drawable.ic_no_search_school);
        this.f9228a.f(R.string.no_search_school_desc);
        this.f9228a.j(R.string.no_search_school_sub_desc);
    }

    public final void y() {
        this.f9227a.setLayoutManager(new LinearLayoutManager(b()));
        this.f9227a.addItemDecoration(new DividerLayoutDecoration(b(), 1, jj8.b(10.0f, b()), ResourcesCompat.getColor(b().getResources(), R.color.color_EFF3FC, null)));
        this.f9227a.setAdapter(this.f9231a);
    }

    public final void z() {
        this.f9229a.setEnableRefresh(false);
        this.f9229a.setEnableAutoLoadMore(true);
    }
}
