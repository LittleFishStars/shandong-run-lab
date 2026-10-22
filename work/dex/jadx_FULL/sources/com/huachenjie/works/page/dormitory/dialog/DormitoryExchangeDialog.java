package com.huachenjie.works.page.dormitory.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.huachenjie.works.bean.dorm.DormExchangeCardBean;
import com.huachenjie.works.databinding.WorksDialogDormitoryExchangeBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeDialog;
import com.noober.background.view.BLTextView;
import com.zj.adlib.fv5;
import com.zj.adlib.kq5;
import com.zj.adlib.qk0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/page/dormitory/dialog/DormitoryExchangeDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogDormitoryExchangeBinding;", "Lcom/huachenjie/works/page/dormitory/dialog/DormitoryExchangeVM;", "", "initViews", "", "getLayoutResID", "", "getVariables", "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/dorm/DormExchangeCardBean;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setOnExchangeClickListener", "initView", "getWidth", "getHeight", "onExchangeClickListener", "Lkotlin/jvm/functions/Function1;", "Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "exchangeBean$delegate", "Lkotlin/Lazy;", "getExchangeBean", "()Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "exchangeBean", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class DormitoryExchangeDialog extends BaseMVVMDialogFragment<WorksDialogDormitoryExchangeBinding, DormitoryExchangeVM> {

    @NotNull
    private static final String BEAN_KEY = "bean";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: exchangeBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy exchangeBean = LazyKt.lazy(new Function0<DormExchangeBean>() { // from class: com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeDialog$exchangeBean$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DormExchangeBean m936invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return (DormExchangeBean) arguments.getParcelable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            }
            return null;
        }
    });

    @Nullable
    private Function1<? super DormExchangeCardBean, Unit> onExchangeClickListener;

    /* JADX INFO: renamed from: com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/page/dormitory/dialog/DormitoryExchangeDialog$a;", "", "Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "bean", "Lcom/huachenjie/works/page/dormitory/dialog/DormitoryExchangeDialog;", "a", "", "BEAN_KEY", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DormitoryExchangeDialog a(@NotNull DormExchangeBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            DormitoryExchangeDialog dormitoryExchangeDialog = new DormitoryExchangeDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("bean", bean);
            dormitoryExchangeDialog.setArguments(bundle);
            return dormitoryExchangeDialog;
        }
    }

    private final DormExchangeBean getExchangeBean() {
        return (DormExchangeBean) this.exchangeBean.getValue();
    }

    private final void initViews() {
        ImageView imageView;
        BLTextView bLTextView;
        List<DormExchangeCardBean> list;
        RecyclerView recyclerView;
        final DormExchangeCardAdapter dormExchangeCardAdapter = new DormExchangeCardAdapter();
        WorksDialogDormitoryExchangeBinding mBinding = getMBinding();
        if (mBinding != null && (recyclerView = mBinding.f14077a) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.setAdapter(dormExchangeCardAdapter);
            recyclerView.addItemDecoration(new DormExchangeItemDecoration());
        }
        DormExchangeBean exchangeBean = getExchangeBean();
        if (exchangeBean != null && (list = exchangeBean.getList()) != null) {
            List<DormExchangeCardBean> list2 = list;
            dormExchangeCardAdapter.setList(list2);
            if (!list2.isEmpty()) {
                Integer value = getMViewModel().i().getValue();
                if (value == null) {
                    value = 0;
                }
                Intrinsics.checkNotNullExpressionValue(value, "mViewModel.selectedType.value ?: 0");
                dormExchangeCardAdapter.e(value.intValue());
            }
        }
        dormExchangeCardAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.lp2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DormitoryExchangeDialog.initViews$lambda$2(this.f18019a, dormExchangeCardAdapter, baseQuickAdapter, view, i);
            }
        });
        WorksDialogDormitoryExchangeBinding mBinding2 = getMBinding();
        if (mBinding2 != null && (bLTextView = mBinding2.f14079a) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mp2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DormitoryExchangeDialog.initViews$lambda$3(this.f43355a, view);
                }
            });
        }
        WorksDialogDormitoryExchangeBinding mBinding3 = getMBinding();
        if (mBinding3 == null || (imageView = mBinding3.f36864a) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.np2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DormitoryExchangeDialog.initViews$lambda$4(this.f43579a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(DormitoryExchangeDialog dormitoryExchangeDialog, DormExchangeCardAdapter dormExchangeCardAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(dormitoryExchangeDialog, "this$0");
        Intrinsics.checkNotNullParameter(dormExchangeCardAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        dormitoryExchangeDialog.getMViewModel().i().setValue(Integer.valueOf(i));
        dormExchangeCardAdapter.e(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(final DormitoryExchangeDialog dormitoryExchangeDialog, View view) {
        List<DormExchangeCardBean> list;
        Intrinsics.checkNotNullParameter(dormitoryExchangeDialog, "this$0");
        Integer value = dormitoryExchangeDialog.getMViewModel().i().getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        DormExchangeBean exchangeBean = dormitoryExchangeDialog.getExchangeBean();
        final DormExchangeCardBean dormExchangeCardBean = (exchangeBean == null || (list = exchangeBean.getList()) == null) ? null : (DormExchangeCardBean) CollectionsKt.getOrNull(list, iIntValue);
        if (dormExchangeCardBean != null) {
            kq5.b(dormitoryExchangeDialog.getContext(), "click_space_exchange_right", MapsKt.mapOf(TuplesKt.to("name", dormExchangeCardBean.getPerksName())));
            dormitoryExchangeDialog.getMViewModel().j(dormExchangeCardBean.getPerksNo(), dormExchangeCardBean.getCharmCost(), new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeDialog$initViews$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    fv5.a(R.string.works_dormitory_exchange_success);
                    Function1 function1 = this.this$0.onExchangeClickListener;
                    if (function1 != null) {
                        function1.invoke(dormExchangeCardBean);
                    }
                    this.this$0.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(DormitoryExchangeDialog dormitoryExchangeDialog, View view) {
        Intrinsics.checkNotNullParameter(dormitoryExchangeDialog, "this$0");
        dormitoryExchangeDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_dormitory_exchange;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, DormitoryExchangeVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return SizeUtils.b(300.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initViews();
    }

    public final void setOnExchangeClickListener(@NotNull Function1<? super DormExchangeCardBean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.onExchangeClickListener = listener;
    }
}
