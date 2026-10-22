package com.huachenjie.sport.page.mine.helpercenter;

import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ProblemData;
import com.huachenjie.sport.bean.ProblemGroupList;
import com.huachenjie.sport.bean.ProblemList;
import com.huachenjie.sport.page.mine.helpercenter.problem_tree.CustomerServiceAdapter;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.b38;
import com.zj.adlib.c25;
import com.zj.adlib.d60;
import com.zj.adlib.mh3;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00120\u00120\u00078\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "j", "Lcom/huachenjie/sport/bean/ProblemData;", "data", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Lcom/huachenjie/sport/page/mine/helpercenter/problem_tree/CustomerServiceAdapter;", "Lcom/huachenjie/sport/page/mine/helpercenter/problem_tree/CustomerServiceAdapter;", "customerServiceAdapter", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "k", "itemDecoration", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class CustomerServiceCenterVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CustomerServiceAdapter customerServiceAdapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CustomerServiceAdapter> adapter;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RecyclerView.ItemDecoration> itemDecoration;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/ProblemData;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<ProblemData> {
        public a() {
            super(CustomerServiceCenterVM.this, true);
        }

        public void onCCSuccess(@Nullable ProblemData data) {
            c25.p(data);
            if (data == null) {
                return;
            }
            CustomerServiceCenterVM.this.m(data);
        }
    }

    public CustomerServiceCenterVM() {
        CustomerServiceAdapter customerServiceAdapter = new CustomerServiceAdapter();
        this.customerServiceAdapter = customerServiceAdapter;
        this.adapter = new MutableLiveData<>(customerServiceAdapter);
        this.itemDecoration = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<CustomerServiceAdapter> i() {
        return this.adapter;
    }

    public final void j() {
        this.model.n().u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    @NotNull
    public final MutableLiveData<RecyclerView.ItemDecoration> k() {
        return this.itemDecoration;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> l() {
        return this.titleBean;
    }

    public final void m(ProblemData data) {
        ArrayList arrayList = new ArrayList();
        for (ProblemGroupList problemGroupList : data.getList()) {
            ArrayList arrayList2 = new ArrayList();
            for (ProblemList problemList : problemGroupList.getProblemList()) {
                arrayList2.add(new b38(problemList.getTitle(), problemList.getUrl()));
            }
            mh3 mh3Var = new mh3(arrayList2, problemGroupList.getCategoryName());
            mh3Var.setExpanded(false);
            arrayList.add(mh3Var);
        }
        this.customerServiceAdapter.setList(arrayList);
    }
}
