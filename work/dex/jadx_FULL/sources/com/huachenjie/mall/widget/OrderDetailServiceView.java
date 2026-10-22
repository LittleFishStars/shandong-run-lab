package com.huachenjie.mall.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coroutines.BindingAdapter;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallViewOrderDetailServiceBinding;
import com.huachenjie.mall.widget.OrderDetailServiceView.a;
import com.zj.adlib.dj1;
import com.zj.adlib.hk0;
import com.zj.adlib.r57;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u000f\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/widget/OrderDetailServiceView;", "Landroid/widget/FrameLayout;", "", "f", "Ljava/lang/String;", "getShopAccid", "()Ljava/lang/String;", "setShopAccid", "(Ljava/lang/String;)V", "shopAccid", y6b.f, "getShopNo", "setShopNo", "shopNo", "Lcom/huachenjie/mall/databinding/MallViewOrderDetailServiceBinding;", "a", "Lkotlin/Lazy;", "getServiceBinding", "()Lcom/huachenjie/mall/databinding/MallViewOrderDetailServiceBinding;", "serviceBinding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class OrderDetailServiceView extends FrameLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy serviceBinding;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String shopAccid;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String shopNo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/widget/OrderDetailServiceView$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/mall/widget/OrderDetailServiceView;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            Activity activityX = com.blankj.utilcode.util.a.x(OrderDetailServiceView.this.getContext());
            if (activityX != null) {
                r57.i(activityX);
            }
        }

        public final void b(@Nullable View v) {
            dj1.b0(OrderDetailServiceView.this.getShopAccid(), OrderDetailServiceView.this.getShopNo(), null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.widget.OrderDetailServiceView$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/widget/OrderDetailServiceView$b;", "", "Lcom/huachenjie/mall/widget/OrderDetailServiceView;", "view", "", "shopAccid", "shopNo", "", "a", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @BindingAdapter(requireAll = false, value = {"orderShopAccid", "shopNo"})
        @JvmStatic
        public final void a(@NotNull OrderDetailServiceView view, @Nullable String shopAccid, @Nullable String shopNo) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (shopAccid == null) {
                shopAccid = "";
            }
            view.setShopAccid(shopAccid);
            if (shopNo == null) {
                shopNo = "";
            }
            view.setShopNo(shopNo);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrderDetailServiceView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final MallViewOrderDetailServiceBinding getServiceBinding() {
        Object value = this.serviceBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-serviceBinding>(...)");
        return (MallViewOrderDetailServiceBinding) value;
    }

    @BindingAdapter(requireAll = false, value = {"orderShopAccid", "shopNo"})
    @JvmStatic
    public static final void setOrderDetailAccid(@NotNull OrderDetailServiceView orderDetailServiceView, @Nullable String str, @Nullable String str2) {
        INSTANCE.a(orderDetailServiceView, str, str2);
    }

    @NotNull
    public final String getShopAccid() {
        return this.shopAccid;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    public final void setShopAccid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shopAccid = str;
    }

    public final void setShopNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shopNo = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrderDetailServiceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailServiceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shopAccid = "";
        this.shopNo = "";
        this.serviceBinding = LazyKt.lazy(new Function0<MallViewOrderDetailServiceBinding>() { // from class: com.huachenjie.mall.widget.OrderDetailServiceView$serviceBinding$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MallViewOrderDetailServiceBinding m585invoke() {
                ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getContext()), R.layout.mall_view_order_detail_service, this.this$0, true);
                MallViewOrderDetailServiceBinding mallViewOrderDetailServiceBinding = (MallViewOrderDetailServiceBinding) viewDataBindingInflate;
                mallViewOrderDetailServiceBinding.setVariable(hk0.k, this.this$0.new a());
                return mallViewOrderDetailServiceBinding;
            }
        });
        getServiceBinding().getRoot();
    }
}
