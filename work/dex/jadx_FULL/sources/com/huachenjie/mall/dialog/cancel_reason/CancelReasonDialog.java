package com.huachenjie.mall.dialog.cancel_reason;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.bean.OrderReasonListBean;
import com.huachenjie.mall.databinding.MallDialogCancelReasonBinding;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.igexin.push.g.o;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"!B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R)\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00110\u00110\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogCancelReasonBinding;", "Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonVM;", "", "initAdapter", "setDefaultChecked", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "initData", "Lkotlin/Function1;", "Lcom/huachenjie/mall/bean/OrderReasonBean;", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "", "kotlin.jvm.PlatformType", "listBean$delegate", "Lkotlin/Lazy;", "getListBean", "()Ljava/util/List;", "listBean", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCancelReasonDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelReasonDialog.kt\ncom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1855#2,2:149\n1855#2,2:151\n*S KotlinDebug\n*F\n+ 1 CancelReasonDialog.kt\ncom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog\n*L\n126#1:149,2\n108#1:151,2\n*E\n"})
public final class CancelReasonDialog extends BaseMVVMBottomDialogFragment<MallDialogCancelReasonBinding, CancelReasonVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String PRE_REASON = "preReason";

    @NotNull
    private static final String REASON_LIST_TYPE = "reasonListType";

    @NotNull
    private static final String REASON_TYPE = "reasonType";
    public static final int REASON_TYPE_ORDER = 1;
    public static final int REASON_TYPE_REFUND = 2;

    @NotNull
    private Function1<? super OrderReasonBean, Unit> callback = new Function1<OrderReasonBean, Unit>() { // from class: com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog$callback$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((OrderReasonBean) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull OrderReasonBean orderReasonBean) {
            Intrinsics.checkNotNullParameter(orderReasonBean, o.f);
        }
    };

    /* JADX INFO: renamed from: listBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listBean = LazyKt.lazy(new Function0<List<? extends OrderReasonBean>>() { // from class: com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog$listBean$2
        {
            super(0);
        }

        @NotNull
        public final List<OrderReasonBean> invoke() {
            Bundle arguments = this.this$0.getArguments();
            ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("reasonListType") : null;
            return parcelableArrayList == null ? CollectionsKt.emptyList() : parcelableArrayList;
        }
    });

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bJ6\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bJ@\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog$Companion;", "", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "vm", "Landroidx/fragment/app/FragmentManager;", "manager", "Lcom/huachenjie/mall/bean/OrderReasonBean;", "preReasonBean", "Lkotlin/Function1;", "", RenderCallContext.TYPE_CALLBACK, "d", "f", "Lcom/huachenjie/mall/bean/OrderReasonListBean;", "listBean", "", CancelReasonDialog.REASON_TYPE, "b", "", "PRE_REASON", "Ljava/lang/String;", "REASON_LIST_TYPE", "REASON_TYPE", "REASON_TYPE_ORDER", "I", "REASON_TYPE_REFUND", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, OrderReasonListBean orderReasonListBean, FragmentManager fragmentManager, int i, OrderReasonBean orderReasonBean, Function1 function1, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                orderReasonBean = null;
            }
            companion.b(orderReasonListBean, fragmentManager, i, orderReasonBean, function1);
        }

        public static /* synthetic */ void e(Companion companion, BaseViewModel baseViewModel, FragmentManager fragmentManager, OrderReasonBean orderReasonBean, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                orderReasonBean = null;
            }
            companion.d(baseViewModel, fragmentManager, orderReasonBean, function1);
        }

        public static /* synthetic */ void g(Companion companion, BaseViewModel baseViewModel, FragmentManager fragmentManager, OrderReasonBean orderReasonBean, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                orderReasonBean = null;
            }
            companion.f(baseViewModel, fragmentManager, orderReasonBean, function1);
        }

        public final void b(OrderReasonListBean listBean, FragmentManager manager, int reasonType, OrderReasonBean preReasonBean, Function1<? super OrderReasonBean, Unit> callback) {
            CancelReasonDialog cancelReasonDialog = new CancelReasonDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CancelReasonDialog.REASON_TYPE, reasonType);
            bundle.putParcelableArrayList(CancelReasonDialog.REASON_LIST_TYPE, listBean.getList());
            if (preReasonBean != null) {
                bundle.putParcelable(CancelReasonDialog.PRE_REASON, preReasonBean);
            }
            cancelReasonDialog.setArguments(bundle);
            cancelReasonDialog.setCallback(callback);
            cancelReasonDialog.show(manager, "CancelReasonDialog");
        }

        public final void d(@NotNull BaseViewModel vm, @NotNull FragmentManager manager, @Nullable OrderReasonBean preReasonBean, @NotNull Function1<? super OrderReasonBean, Unit> callback) {
            Intrinsics.checkNotNullParameter(vm, "vm");
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            BaseViewModelExtKt.b(vm, true, false, null, null, new CancelReasonDialog$Companion$showOrderReasonDialog$1(manager, preReasonBean, callback, null), 14, null);
        }

        public final void f(@NotNull BaseViewModel vm, @NotNull FragmentManager manager, @Nullable OrderReasonBean preReasonBean, @NotNull Function1<? super OrderReasonBean, Unit> callback) {
            Intrinsics.checkNotNullParameter(vm, "vm");
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            BaseViewModelExtKt.b(vm, true, false, null, null, new CancelReasonDialog$Companion$showRefundReasonDialog$1(manager, preReasonBean, callback, null), 14, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCancelReasonDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelReasonDialog.kt\ncom/huachenjie/mall/dialog/cancel_reason/CancelReasonDialog$ClickProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n1#2:149\n*E\n"})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            CancelReasonDialog.this.dismiss();
        }

        public final void b(@Nullable View v) {
            List<OrderReasonBean> data;
            Object next;
            CancelReasonAdapter value = CancelReasonDialog.access$getMViewModel(CancelReasonDialog.this).i().getValue();
            if (value != null && (data = value.getData()) != null) {
                Iterator<T> it = data.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!((OrderReasonBean) next).isChecked());
                OrderReasonBean orderReasonBean = (OrderReasonBean) next;
                if (orderReasonBean != null) {
                    CancelReasonDialog.this.getCallback().invoke(orderReasonBean);
                }
            }
            CancelReasonDialog.this.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ CancelReasonVM access$getMViewModel(CancelReasonDialog cancelReasonDialog) {
        return (CancelReasonVM) cancelReasonDialog.getMViewModel();
    }

    private final List<OrderReasonBean> getListBean() {
        return (List) this.listBean.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<CancelReasonAdapter> mutableLiveDataI = ((CancelReasonVM) getMViewModel()).i();
        final CancelReasonAdapter cancelReasonAdapter = new CancelReasonAdapter();
        cancelReasonAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ud1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CancelReasonDialog.initAdapter$lambda$2$lambda$1(cancelReasonAdapter, baseQuickAdapter, view, i);
            }
        });
        cancelReasonAdapter.setList(getListBean());
        mutableLiveDataI.setValue(cancelReasonAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(CancelReasonAdapter cancelReasonAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(cancelReasonAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Iterator<T> it = cancelReasonAdapter.getData().iterator();
        while (it.hasNext()) {
            ((OrderReasonBean) it.next()).setChecked(false);
        }
        cancelReasonAdapter.getData().get(i).setChecked(true);
        cancelReasonAdapter.notifyDataSetChanged();
    }

    private final void setDefaultChecked() {
        Bundle arguments = getArguments();
        OrderReasonBean orderReasonBean = arguments != null ? (OrderReasonBean) arguments.getParcelable(PRE_REASON) : null;
        if (orderReasonBean == null) {
            OrderReasonBean orderReasonBean2 = (OrderReasonBean) CollectionsKt.firstOrNull(getListBean());
            if (orderReasonBean2 == null) {
                return;
            }
            orderReasonBean2.setChecked(true);
            return;
        }
        for (OrderReasonBean orderReasonBean3 : getListBean()) {
            if (orderReasonBean3.getCode() == orderReasonBean.getCode()) {
                orderReasonBean3.setChecked(true);
            }
        }
    }

    @NotNull
    public final Function1<OrderReasonBean, Unit> getCallback() {
        return this.callback;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_cancel_reason;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        setDefaultChecked();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    public final void setCallback(@NotNull Function1<? super OrderReasonBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.callback = function1;
    }
}
