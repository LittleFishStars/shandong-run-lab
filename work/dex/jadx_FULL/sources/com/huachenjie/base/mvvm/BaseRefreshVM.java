package com.huachenjie.base.mvvm;

import androidx.annotation.NonNull;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Deprecated
public abstract class BaseRefreshVM extends BaseVM {
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<? extends BaseRefreshAdapter> j = new MutableLiveData<>();
    public MutableLiveData<Boolean> k = new MutableLiveData<>(Boolean.FALSE);
    public int K = 1;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends BizSubscriber<PageEntity<T>> {
        public a() {
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            BaseRefreshVM baseRefreshVM = BaseRefreshVM.this;
            int i = baseRefreshVM.K;
            if (i != 1) {
                baseRefreshVM.K = i - 1;
                return;
            }
            baseRefreshVM.k.setValue(Boolean.FALSE);
            BaseRefreshVM.this.j().setList(null);
            BaseRefreshVM.this.j().p();
        }

        public void onCCSuccess(PageEntity<T> data) {
            BaseRefreshVM baseRefreshVM = BaseRefreshVM.this;
            if (baseRefreshVM.K == 1) {
                baseRefreshVM.k.setValue(Boolean.FALSE);
                if (data == null || data.getList() == null || data.getList().isEmpty()) {
                    BaseRefreshVM.this.j().setList(null);
                    BaseRefreshVM.this.j().p();
                } else {
                    BaseRefreshVM.this.j().l();
                    BaseRefreshVM.this.j().setList(data.getList());
                }
            } else if (data == null || data.getList() == null || data.getList().isEmpty()) {
                BaseRefreshVM.this.K--;
            } else {
                BaseRefreshVM.this.j().addData((Collection) data.getList());
            }
            if (data == null || !data.getHasNext()) {
                BaseRefreshVM.this.j().getLoadMoreModule().loadMoreEnd();
            } else {
                BaseRefreshVM.this.j().getLoadMoreModule().loadMoreComplete();
            }
            BaseRefreshVM.this.i(data);
        }
    }

    public <T> BizSubscriber<PageEntity<T>> h() {
        return new a();
    }

    public <T> void i(PageEntity<T> data) {
    }

    @NonNull
    public abstract BaseRefreshAdapter j();

    public void k() {
        int i = this.K + 1;
        this.K = i;
        l(i);
    }

    public abstract void l(int pageNum);

    public void m() {
        this.k.setValue(Boolean.TRUE);
        this.K = 1;
        l(1);
    }
}
