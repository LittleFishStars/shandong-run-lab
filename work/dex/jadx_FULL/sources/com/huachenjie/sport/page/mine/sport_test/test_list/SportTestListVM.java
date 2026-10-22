package com.huachenjie.sport.page.mine.sport_test.test_list;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.SportTestListBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "m", "", "getEmptyText", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lkotlin/Lazy;", "j", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/bean/SportTestListBean;", "listData", "", "kotlin.jvm.PlatformType", t.d, "undoLayoutState", y6b.g, "finishLayoutState", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestListVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m798invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestListBean> listData = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> undoLayoutState = new MutableLiveData<>(1);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> finishLayoutState = new MutableLiveData<>(1);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/test_list/SportTestListVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/SportTestListBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<SportTestListBean> {
        public a() {
            super(SportTestListVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            SportTestListVM.this.l().setValue(3);
            SportTestListVM.this.h().setValue(3);
        }

        public void onCCSuccess(@Nullable SportTestListBean data) {
            if (data == null) {
                SportTestListVM.this.l().setValue(2);
                SportTestListVM.this.h().setValue(2);
                return;
            }
            if (data.getUndoneTests() == null || data.getUndoneTests().isEmpty()) {
                SportTestListVM.this.l().setValue(2);
            } else {
                SportTestListVM.this.l().setValue(1);
            }
            if (data.getCompletedTests() == null || data.getCompletedTests().isEmpty()) {
                SportTestListVM.this.h().setValue(2);
            } else {
                SportTestListVM.this.h().setValue(1);
            }
            SportTestListVM.this.i().setValue(data);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVM
    @NotNull
    public String getEmptyText() {
        return "暂无体测";
    }

    @NotNull
    public final MutableLiveData<Integer> h() {
        return this.finishLayoutState;
    }

    @NotNull
    public final MutableLiveData<SportTestListBean> i() {
        return this.listData;
    }

    @NotNull
    public final SportModel j() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<Integer> l() {
        return this.undoLayoutState;
    }

    public final void m() {
        j().F().u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }
}
