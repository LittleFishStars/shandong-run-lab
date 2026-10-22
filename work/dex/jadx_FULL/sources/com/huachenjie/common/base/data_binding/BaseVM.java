package com.huachenjie.common.base.data_binding;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModel;
import com.huachenjie.common.R;
import com.huachenjie.common.page.statelayout.ConvertInterface;
import com.huachenjie.common.page.statelayout.Status;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.zj.adlib.dx4;
import huachenjie.sdk.http.lifecycle.ILifeCycle;
import huachenjie.sdk.http.ui.HttpVmDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BaseVM extends ViewModel implements ILifeCycle, HttpVmDialog {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx4 f8504a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<Integer> f33644a = new MutableLiveData<>();
    public MutableLiveData<Integer> b = new MutableLiveData<>();
    public MutableLiveData<Integer> c = new MutableLiveData<>();
    public MutableLiveData<Boolean> d = new MutableLiveData<>(null);
    public MutableLiveData<String> e = new MutableLiveData<>();
    public MutableLiveData<CustomizeViewDialog.Builder> f = new MutableLiveData<>(null);
    public MutableLiveData<DialogFragment> g = new MutableLiveData<>(null);
    public MutableLiveData<Boolean> h = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LoadingDialogBean f8502a = new LoadingDialogBean(false, null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ConvertInterface f8503a = new ConvertInterface() { // from class: com.zj.adlib.yr0
        @Override // com.huachenjie.common.page.statelayout.ConvertInterface
        public final void a(Status status, View view) {
            this.f46100a.e(status, view);
        }
    };

    public static class LoadingDialogBean {
        public boolean cancelAble;
        public String msg;

        public LoadingDialogBean(boolean cancelAble, String msg) {
            this.cancelAble = cancelAble;
            this.msg = msg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Status status, View view) {
        TextView textView;
        if (view == null || status != Status.EMPTY || (textView = (TextView) view.findViewById(R.id.tv_empty)) == null) {
            return;
        }
        textView.setText(getEmptyText());
    }

    public void a() {
        this.d.setValue(Boolean.FALSE);
    }

    public void b() {
        this.d.setValue(Boolean.TRUE);
    }

    public void d() {
        this.h.setValue(Boolean.TRUE);
    }

    public void f(DialogFragment dialogFragment) {
        if (dialogFragment != null) {
            this.g.setValue(dialogFragment);
        }
    }

    public void g(CustomizeViewDialog.Builder dialog) {
        if (dialog != null) {
            this.f.setValue(dialog);
        }
    }

    public String getEmptyText() {
        return "暂无数据";
    }

    public final dx4 getLifeCycleObservable() {
        if (this.f8504a == null) {
            this.f8504a = dx4.a();
        }
        return this.f8504a;
    }

    @Override // androidx.p002lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        dx4 dx4Var = this.f8504a;
        if (dx4Var != null) {
            dx4Var.b();
        }
        this.f8504a = null;
    }
}
