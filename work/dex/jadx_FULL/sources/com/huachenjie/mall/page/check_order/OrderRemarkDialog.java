package com.huachenjie.mall.page.check_order;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import androidx.activity.ComponentDialog;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallDialogOrderRemarkBinding;
import com.huachenjie.mall.page.check_order.OrderRemarkDialog;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.hk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0017J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogOrderRemarkBinding;", "Lcom/huachenjie/mall/page/check_order/OrderRemarkVM;", "", "showKeyboard", "hideKeyboard", "", "getWidth", "getHeight", "", "", "getVariables", "getLayoutResID", "initView", "initData", "", "checkConfirm", "onDestroyView", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Lkotlin/Function1;", "", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public class OrderRemarkDialog extends BaseMVVMDialogFragment<MallDialogOrderRemarkBinding, OrderRemarkVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_REMARK = "key_remark";

    @Nullable
    private Function1<? super String, Unit> callback;

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.mall.page.check_order.OrderRemarkDialog$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m503invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OrderRemarkDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (OrderRemarkDialog.this.checkConfirm()) {
                Function1<String, Unit> callback = OrderRemarkDialog.this.getCallback();
                if (callback != null) {
                    String value = OrderRemarkDialog.access$getMViewModel(OrderRemarkDialog.this).j().getValue();
                    if (value == null) {
                        value = "";
                    }
                    callback.invoke(value);
                }
                OrderRemarkDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.check_order.OrderRemarkDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog$b;", "", "", "remark", "Lkotlin/Function1;", "", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog;", "a", "KEY_REMARK", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderRemarkDialog a(@NotNull String remark, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(remark, "remark");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            OrderRemarkDialog orderRemarkDialog = new OrderRemarkDialog();
            Bundle bundle = new Bundle();
            bundle.putString(OrderRemarkDialog.KEY_REMARK, remark);
            orderRemarkDialog.setArguments(bundle);
            orderRemarkDialog.setCallback(callback);
            return orderRemarkDialog;
        }
    }

    public static final /* synthetic */ OrderRemarkVM access$getMViewModel(OrderRemarkDialog orderRemarkDialog) {
        return orderRemarkDialog.getMViewModel();
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideKeyboard() {
        BLEditText bLEditText;
        MallDialogOrderRemarkBinding mBinding = getMBinding();
        if (mBinding == null || (bLEditText = mBinding.f10592a) == null) {
            return;
        }
        KeyboardUtils.k(bLEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(OrderRemarkDialog orderRemarkDialog, View view) {
        Intrinsics.checkNotNullParameter(orderRemarkDialog, "this$0");
        orderRemarkDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(OrderRemarkDialog orderRemarkDialog, int i) {
        Intrinsics.checkNotNullParameter(orderRemarkDialog, "this$0");
        orderRemarkDialog.getMViewModel().i().setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(OrderRemarkDialog orderRemarkDialog) {
        Intrinsics.checkNotNullParameter(orderRemarkDialog, "this$0");
        orderRemarkDialog.showKeyboard();
    }

    private final void showKeyboard() {
        BLEditText bLEditText;
        MallDialogOrderRemarkBinding mBinding = getMBinding();
        if (mBinding == null || (bLEditText = mBinding.f10592a) == null) {
            return;
        }
        KeyboardUtils.s(bLEditText);
    }

    public boolean checkConfirm() {
        return true;
    }

    @Nullable
    public final Function1<String, Unit> getCallback() {
        return this.callback;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_order_remark;
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
        MutableLiveData<String> mutableLiveDataJ = getMViewModel().j();
        Bundle arguments = getArguments();
        mutableLiveDataJ.setValue(arguments != null ? arguments.getString(KEY_REMARK) : null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView() {
        BLRelativeLayout bLRelativeLayout;
        Window window;
        super.initView();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setDimAmount(0.0f);
        }
        MallDialogOrderRemarkBinding mBinding = getMBinding();
        if (mBinding != null && (bLRelativeLayout = mBinding.f10593a) != null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            bLRelativeLayout.setAnimation(translateAnimation);
            bLRelativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.xd6
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return OrderRemarkDialog.initView$lambda$4$lambda$1(view, motionEvent);
                }
            });
            View view = getView();
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yd6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        OrderRemarkDialog.initView$lambda$4$lambda$2(this.f46005a, view2);
                    }
                });
            }
            KeyboardUtils.o(requireActivity(), new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.zd6
                @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
                public final void a(int i) {
                    OrderRemarkDialog.initView$lambda$4$lambda$3(this.f46238a, i);
                }
            });
        }
        getHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.ae6
            @Override // java.lang.Runnable
            public final void run() {
                OrderRemarkDialog.initView$lambda$5(this.f40515a);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new ComponentDialog(requireContext(), getTheme()) { // from class: com.huachenjie.mall.page.check_order.OrderRemarkDialog.onCreateDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context, i);
                Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
            }

            @Override // android.app.Dialog, android.content.DialogInterface
            public void dismiss() {
                OrderRemarkDialog.this.hideKeyboard();
                super.dismiss();
            }
        };
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            KeyboardUtils.v(window);
        }
        getHandler().removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    public final void setCallback(@Nullable Function1<? super String, Unit> function1) {
        this.callback = function1;
    }
}
