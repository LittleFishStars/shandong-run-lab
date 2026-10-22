package com.huachenjie.common.pulltorefresh;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.BaseComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class BasePageComponent<T> extends BaseComponent<T> {
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PageRequestListener f33842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8820a;

    public interface PageRequestListener {
        void a(int pageNum);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BaseSmartRefreshLayout f8821a;

        public a(final BaseSmartRefreshLayout val$smartRefreshLayout) {
            this.f8821a = val$smartRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8821a.finishLoadMoreWithNoMoreData();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f33844a;

        public b(final RecyclerView val$recyclerView, final int val$x, final int val$y) {
            this.f33844a = val$recyclerView;
            this.K = val$x;
            this.L = val$y;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33844a.scrollBy(this.K, this.L);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestedScrollView f33845a;

        public c(final NestedScrollView val$scrollView, final int val$x, final int val$y) {
            this.f33845a = val$scrollView;
            this.K = val$x;
            this.L = val$y;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33845a.scrollBy(this.K, this.L);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f33846a;

        public d(final RecyclerView val$recyclerView, final int val$x, final int val$y) {
            this.f33846a = val$recyclerView;
            this.K = val$x;
            this.L = val$y;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33846a.scrollTo(this.K, this.L);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33847a;

        public e(final View val$scrollView, final int val$x, final int val$y) {
            this.f33847a = val$scrollView;
            this.K = val$x;
            this.L = val$y;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33847a.scrollTo(this.K, this.L);
        }
    }

    public BasePageComponent(T context) {
        super(context);
        this.M = 1;
        this.f8820a = true;
    }

    public void d(boolean hasNext, final BaseSmartRefreshLayout smartRefreshLayout) {
        this.f8820a = hasNext;
        if (hasNext) {
            smartRefreshLayout.setNoMoreData(false);
        } else {
            smartRefreshLayout.postDelayed(new a(smartRefreshLayout), 200L);
        }
    }

    public int e() {
        return this.M;
    }

    public int f(RecyclerView recyclerView) {
        int top;
        int height = 0;
        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return 0;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition != null) {
            height = viewFindViewByPosition.getHeight();
            top = viewFindViewByPosition.getTop();
        } else {
            top = 0;
        }
        return (iFindFirstVisibleItemPosition * height) - top;
    }

    public boolean g() {
        return this.M == 1;
    }

    public void h() {
        this.M++;
    }

    public void i() {
        this.f8820a = true;
        this.M = 1;
    }

    public void j(final NestedScrollView scrollView, final int x, final int y, final long delay) {
        scrollView.postDelayed(new c(scrollView, x, y), delay);
    }

    public void k(final RecyclerView recyclerView, final int x, final int y, final long delay) {
        recyclerView.postDelayed(new b(recyclerView, x, y), delay);
    }

    public void l(final View scrollView, final int x, final int y, final long delay) {
        scrollView.postDelayed(new e(scrollView, x, y), delay);
    }

    public void m(final RecyclerView recyclerView, final int x, final int y, final long delay) {
        recyclerView.postDelayed(new d(recyclerView, x, y), delay);
    }

    public void n(PageRequestListener listener) {
        this.f33842a = listener;
    }
}
