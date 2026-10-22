package com.huachenjie.mall.page.goods_detail;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.ViewGroupKt;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.aliyun.credentials.utils.AuthConstant;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpec;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.huachenjie.mall.databinding.MallDialogGoodsSpecificationBinding;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.nex3z.flowlayout.FlowLayout;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ar6;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001O\u0018\u0000 Y2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002Z[B\u0007¢\u0006\u0004\bW\u0010XJ\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0016\u001a\u00020\u00152\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u0019\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\rH\u0002J#\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ2\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020&0%H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0007H\u0017J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u000e\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\tJ\u000e\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u000bR\u001b\u00107\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:R\u001b\u0010>\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u0010:R\u001b\u0010B\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u0010AR\u001d\u0010E\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00104\u001a\u0004\bD\u0010:R\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010IR$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u0007\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010U\u001a\u0010\u0012\f\u0012\n T*\u0004\u0018\u00010S0S0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogGoodsSpecificationBinding;", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationVM;", "", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpec;", "specList", "", "initSpec", "", "title", "", "isFirstItem", "Landroid/widget/TextView;", "createTitle", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "", "index", "Landroidx/recyclerview/widget/RecyclerView;", "createPicRecyclerView", "labelIndex", "Lcom/nex3z/flowlayout/FlowLayout;", "createLabelView", "textView", "setSelLabelStyle", AuthConstant.INI_ENABLE, "setUnSelLabelStyle", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "item", "flLabel", "toggleTypeSel", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "initData", "initDataObserve", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onDestroyView", "str", "updateRemainTimeStr", "canExchange", "updateCanExchange", "squareType$delegate", "Lkotlin/Lazy;", "getSquareType", "()I", "squareType", "traceNo$delegate", "getTraceNo", "()Ljava/lang/String;", "traceNo", "source$delegate", "getSource", "source", "fromReward$delegate", "getFromReward", "()Z", "fromReward", "exchangeCode$delegate", "getExchangeCode", "exchangeCode", "Landroid/os/Handler;", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "Lkotlin/Function1;", "", "onSpecIndexChangedCallback", "Lkotlin/jvm/functions/Function1;", "com/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$c", "checkNumRunnable", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$c;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGoodsSpecificationDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodsSpecificationDialog.kt\ncom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,453:1\n1864#2,3:454\n*S KotlinDebug\n*F\n+ 1 GoodsSpecificationDialog.kt\ncom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog\n*L\n189#1:454,3\n*E\n"})
public final class GoodsSpecificationDialog extends BaseMVVMBottomDialogFragment<MallDialogGoodsSpecificationBinding, GoodsSpecificationVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CAN_EXCHANGE = "can_exchange";

    @NotNull
    private static final String KEY_DETAIL_BEAN = "detail_bean";

    @NotNull
    private static final String KEY_REMAIN_TIME_STR = "remain_time_str";

    @NotNull
    private static final String KEY_SEL_SPEC_INDEX_ARRAY = "sel_spec_index_array";

    @NotNull
    private final ActivityResultLauncher<Intent> launcher;

    @Nullable
    private Function1<? super int[], Unit> onSpecIndexChangedCallback;

    /* JADX INFO: renamed from: squareType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy squareType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$squareType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m537invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("squareType", 0) : 0);
        }
    });

    /* JADX INFO: renamed from: traceNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy traceNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$traceNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("traceNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: source$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy source = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$source$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("source")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: fromReward$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fromReward = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$fromReward$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m534invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("fromReward", false) : false);
        }
    });

    /* JADX INFO: renamed from: exchangeCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy exchangeCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$exchangeCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("exchangeCode");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m535invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @NotNull
    private final c checkNumRunnable = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$a;", "", "Landroid/view/View;", "view", "", "b", "c", "d", "a", "<init>", "(Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue() == null) {
                return;
            }
            Integer value = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
            if (value == null) {
                value = 1;
            }
            int iIntValue = value.intValue();
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).m().getLimitBuy() != -1 && iIntValue > GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).m().getLimitBuy()) {
                fv5.b("超过可购买数量上限");
                return;
            }
            CheckOrderActivity.Companion companion = CheckOrderActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            GoodsDetailSku value2 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue();
            Intrinsics.checkNotNull(value2);
            String skuNo = value2.getSkuNo();
            GoodsDetailSku value3 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue();
            Intrinsics.checkNotNull(value3);
            String salePrice = value3.getSalePrice();
            String traceNo = GoodsSpecificationDialog.this.getTraceNo();
            Intrinsics.checkNotNullExpressionValue(traceNo, "traceNo");
            String source = GoodsSpecificationDialog.this.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "source");
            GoodsSpecificationDialog.this.requireActivity().startActivityForResult(companion.a(context, skuNo, salePrice, iIntValue, traceNo, source, GoodsSpecificationDialog.this.getFromReward(), GoodsSpecificationDialog.this.getExchangeCode()), 1102);
            GoodsSpecificationDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsSpecificationDialog.this.dismiss();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).m().getType() == 2) {
                fv5.b("当前商品不支持调整数量");
                return;
            }
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue() != null) {
                Integer value = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
                Intrinsics.checkNotNull(value);
                if (value.intValue() <= 1) {
                    return;
                }
                MutableLiveData<Integer> mutableLiveDataP = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p();
                Integer value2 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
                mutableLiveDataP.setValue(value2 != null ? Integer.valueOf(value2.intValue() - 1) : null);
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).m().getType() == 2) {
                fv5.b("当前商品不支持调整数量");
                return;
            }
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue() != null) {
                Integer value = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
                Intrinsics.checkNotNull(value);
                if (value.intValue() >= 99) {
                    return;
                }
                GoodsDetailSku value2 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue();
                Intrinsics.checkNotNull(value2);
                int availableStock = value2.getAvailableStock();
                Integer value3 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
                Intrinsics.checkNotNull(value3);
                if (availableStock > value3.intValue()) {
                    MutableLiveData<Integer> mutableLiveDataP = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p();
                    Integer value4 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
                    mutableLiveDataP.setValue(value4 != null ? Integer.valueOf(value4.intValue() + 1) : null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("最多可购买");
                GoodsDetailSku value5 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue();
                Intrinsics.checkNotNull(value5);
                sb.append(value5.getAvailableStock());
                sb.append((char) 20214);
                fv5.b(sb.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJh\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$b;", "", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "detailBean", "", "selSpecIndexArray", "", "canExchange", "", "remainTimeStr", "", "squareType", "source", "traceNo", "fromReward", "exchangeCode", "Lkotlin/Function1;", "", "onSpecIndexChanged", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog;", "a", "KEY_CAN_EXCHANGE", "Ljava/lang/String;", "KEY_DETAIL_BEAN", "KEY_REMAIN_TIME_STR", "KEY_SEL_SPEC_INDEX_ARRAY", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GoodsSpecificationDialog a(@NotNull GoodsDetailBean detailBean, @NotNull int[] selSpecIndexArray, boolean canExchange, @NotNull String remainTimeStr, int squareType, @NotNull String source, @NotNull String traceNo, boolean fromReward, @Nullable String exchangeCode, @Nullable Function1<? super int[], Unit> onSpecIndexChanged) {
            Intrinsics.checkNotNullParameter(detailBean, "detailBean");
            Intrinsics.checkNotNullParameter(selSpecIndexArray, "selSpecIndexArray");
            Intrinsics.checkNotNullParameter(remainTimeStr, "remainTimeStr");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(traceNo, "traceNo");
            GoodsSpecificationDialog goodsSpecificationDialog = new GoodsSpecificationDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(GoodsSpecificationDialog.KEY_DETAIL_BEAN, detailBean);
            bundle.putBoolean(GoodsSpecificationDialog.KEY_CAN_EXCHANGE, canExchange);
            bundle.putInt("squareType", squareType);
            bundle.putString(GoodsSpecificationDialog.KEY_REMAIN_TIME_STR, remainTimeStr);
            bundle.putString("source", source);
            bundle.putString("traceNo", traceNo);
            bundle.putIntArray(GoodsSpecificationDialog.KEY_SEL_SPEC_INDEX_ARRAY, selSpecIndexArray);
            bundle.putBoolean("fromReward", fromReward);
            bundle.putString("exchangeCode", exchangeCode);
            goodsSpecificationDialog.setArguments(bundle);
            goodsSpecificationDialog.onSpecIndexChangedCallback = onSpecIndexChanged;
            return goodsSpecificationDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$c", "Ljava/lang/Runnable;", "", "run", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            EditText editText;
            EditText editText2;
            MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
            Editable text = null;
            String strValueOf = String.valueOf((mallDialogGoodsSpecificationBindingAccess$getMBinding == null || (editText2 = mallDialogGoodsSpecificationBindingAccess$getMBinding.f34916a) == null) ? null : editText2.getText());
            if (TextUtils.isEmpty(strValueOf)) {
                return;
            }
            try {
                i = Integer.parseInt(strValueOf);
            } catch (Exception unused) {
                i = 0;
            }
            Integer value = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().getValue();
            if (value != null && i == value.intValue()) {
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding2 = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
                if (mallDialogGoodsSpecificationBindingAccess$getMBinding2 != null && (editText = mallDialogGoodsSpecificationBindingAccess$getMBinding2.f34916a) != null) {
                    text = editText.getText();
                }
                if (!Intrinsics.areEqual(String.valueOf(text), String.valueOf(i))) {
                    GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(Integer.valueOf(i));
                    return;
                }
            }
            if (GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue() == null && i != 1) {
                GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(1);
                return;
            }
            if (i < 1) {
                GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(1);
                return;
            }
            GoodsDetailSku value2 = GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).u().getValue();
            int availableStock = value2 != null ? value2.getAvailableStock() : 1;
            if (i <= availableStock) {
                if (i > 99) {
                    GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(99);
                }
            } else {
                if (availableStock > 99) {
                    GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(99);
                    return;
                }
                if (availableStock > 0) {
                    fv5.b("最多可购买" + availableStock + (char) 20214);
                    GoodsSpecificationDialog.access$getMViewModel(GoodsSpecificationDialog.this).p().setValue(Integer.valueOf(availableStock));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            GoodsSpecificationDialog.this.getHandler().removeCallbacks(GoodsSpecificationDialog.this.checkNumRunnable);
            GoodsSpecificationDialog.this.getHandler().postDelayed(GoodsSpecificationDialog.this.checkNumRunnable, 300L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35197a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35197a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35197a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35197a.invoke(obj);
        }
    }

    public GoodsSpecificationDialog() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.kv3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GoodsSpecificationDialog.launcher$lambda$9(this.f42917a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.launcher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MallDialogGoodsSpecificationBinding access$getMBinding(GoodsSpecificationDialog goodsSpecificationDialog) {
        return (MallDialogGoodsSpecificationBinding) goodsSpecificationDialog.getMBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsSpecificationVM access$getMViewModel(GoodsSpecificationDialog goodsSpecificationDialog) {
        return (GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FlowLayout createLabelView(List<GoodsDetailSpecValue> list, final int labelIndex) {
        final FlowLayout flowLayout = new FlowLayout(getContext());
        flowLayout.setChildSpacing(SizeUtils.b(8.0f));
        flowLayout.setChildSpacingForLastRow(-65537);
        flowLayout.setRowSpacing(SizeUtils.b(12.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = SizeUtils.b(12.0f);
        flowLayout.setLayoutParams(layoutParams);
        final int i = 0;
        for (final GoodsDetailSpecValue goodsDetailSpecValue : list) {
            int i2 = i + 1;
            final TextView textView = new TextView(getContext());
            textView.setText(goodsDetailSpecValue.getSpecValue());
            textView.setTextSize(12.0f);
            textView.setGravity(17);
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, SizeUtils.b(32.0f)));
            textView.setPadding(SizeUtils.b(12.0f), 0, SizeUtils.b(12.0f), 0);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMinWidth(SizeUtils.b(48.0f));
            if (((GoodsSpecificationVM) getMViewModel()).v()[labelIndex] == i) {
                setSelLabelStyle(textView);
            } else {
                setUnSelLabelStyle(textView, Boolean.valueOf(true ^ goodsDetailSpecValue.getOutOfStock()));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lv3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoodsSpecificationDialog.createLabelView$lambda$12(this.f18091a, goodsDetailSpecValue, i, textView, flowLayout, labelIndex, view);
                }
            });
            flowLayout.addView(textView);
            i = i2;
        }
        return flowLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLabelView$lambda$12(GoodsSpecificationDialog goodsSpecificationDialog, GoodsDetailSpecValue goodsDetailSpecValue, int i, TextView textView, FlowLayout flowLayout, int i2, View view) {
        Intrinsics.checkNotNullParameter(goodsSpecificationDialog, "this$0");
        Intrinsics.checkNotNullParameter(goodsDetailSpecValue, "$item");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(flowLayout, "$labelView");
        goodsSpecificationDialog.toggleTypeSel(goodsDetailSpecValue, i, textView, flowLayout, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RecyclerView createPicRecyclerView(final ArrayList<GoodsDetailSpecValue> list, final int index) {
        RecyclerView recyclerView = new RecyclerView(requireContext());
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        final GoodsSpecificationAdapter goodsSpecificationAdapter = new GoodsSpecificationAdapter(((GoodsSpecificationVM) getMViewModel()).v()[index]);
        goodsSpecificationAdapter.addChildClickViewIds(R.id.iv_preview);
        goodsSpecificationAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.mv3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GoodsSpecificationDialog.createPicRecyclerView$lambda$8$lambda$6$lambda$4(this.f18315a, index, goodsSpecificationAdapter, baseQuickAdapter, view, i);
            }
        });
        goodsSpecificationAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.nv3
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GoodsSpecificationDialog.createPicRecyclerView$lambda$8$lambda$6$lambda$5(this.f43613a, list, index, baseQuickAdapter, view, i);
            }
        });
        goodsSpecificationAdapter.setList(list);
        recyclerView.setAdapter(goodsSpecificationAdapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = SizeUtils.b(12.0f);
        recyclerView.setLayoutParams(layoutParams);
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void createPicRecyclerView$lambda$8$lambda$6$lambda$4(GoodsSpecificationDialog goodsSpecificationDialog, int i, GoodsSpecificationAdapter goodsSpecificationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(goodsSpecificationDialog, "this$0");
        Intrinsics.checkNotNullParameter(goodsSpecificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v()[i] == i2) {
            ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v()[i] = -1;
        } else {
            ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v()[i] = i2;
        }
        ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).B(((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v());
        goodsSpecificationAdapter.e(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPicRecyclerView$lambda$8$lambda$6$lambda$5(GoodsSpecificationDialog goodsSpecificationDialog, ArrayList arrayList, int i, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(goodsSpecificationDialog, "this$0");
        Intrinsics.checkNotNullParameter(arrayList, "$list");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.iv_preview) {
            ActivityResultLauncher<Intent> activityResultLauncher = goodsSpecificationDialog.launcher;
            GoodsSpecificationPreviewActivity.Companion companion = GoodsSpecificationPreviewActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            activityResultLauncher.launch(companion.a(context, i2, arrayList, i));
        }
    }

    private final TextView createTitle(String title, boolean isFirstItem) {
        TextView textView = new TextView(getContext());
        textView.setText(title);
        textView.setTextSize(14.0f);
        textView.setTextColor(-13877680);
        textView.setTypeface(null, 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = !isFirstItem ? SizeUtils.b(20.0f) : 0;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getExchangeCode() {
        return (String) this.exchangeCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFromReward() {
        return ((Boolean) this.fromReward.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSource() {
        return (String) this.source.getValue();
    }

    private final int getSquareType() {
        return ((Number) this.squareType.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTraceNo() {
        return (String) this.traceNo.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initSpec(List<GoodsDetailSpec> specList) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        if (specList.isEmpty()) {
            return;
        }
        int i = 0;
        for (Object obj : specList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GoodsDetailSpec goodsDetailSpec = (GoodsDetailSpec) obj;
            if (goodsDetailSpec.getPictureEnable()) {
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding = (MallDialogGoodsSpecificationBinding) getMBinding();
                if (mallDialogGoodsSpecificationBinding != null && (linearLayout4 = mallDialogGoodsSpecificationBinding.c) != null) {
                    linearLayout4.addView(createTitle(goodsDetailSpec.getSpecName(), i == 0));
                }
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding2 = (MallDialogGoodsSpecificationBinding) getMBinding();
                if (mallDialogGoodsSpecificationBinding2 != null && (linearLayout3 = mallDialogGoodsSpecificationBinding2.c) != null) {
                    linearLayout3.addView(createPicRecyclerView(goodsDetailSpec.getSpecValueList(), i));
                }
            } else {
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding3 = (MallDialogGoodsSpecificationBinding) getMBinding();
                if (mallDialogGoodsSpecificationBinding3 != null && (linearLayout2 = mallDialogGoodsSpecificationBinding3.c) != null) {
                    linearLayout2.addView(createTitle(goodsDetailSpec.getSpecName(), i == 0));
                }
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding4 = (MallDialogGoodsSpecificationBinding) getMBinding();
                if (mallDialogGoodsSpecificationBinding4 != null && (linearLayout = mallDialogGoodsSpecificationBinding4.c) != null) {
                    linearLayout.addView(createLabelView(goodsDetailSpec.getSpecValueList(), i));
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$0(GoodsSpecificationDialog goodsSpecificationDialog, int i) {
        EditText editText;
        Intrinsics.checkNotNullParameter(goodsSpecificationDialog, "this$0");
        if (i == 0) {
            MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding = (MallDialogGoodsSpecificationBinding) goodsSpecificationDialog.getMBinding();
            if (TextUtils.isEmpty((mallDialogGoodsSpecificationBinding == null || (editText = mallDialogGoodsSpecificationBinding.f34916a) == null) ? null : editText.getText())) {
                ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).p().setValue(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void launcher$lambda$9(GoodsSpecificationDialog goodsSpecificationDialog, ActivityResult activityResult) {
        LinearLayout linearLayout;
        Sequence<View> children;
        Sequence sequenceFilter;
        Intrinsics.checkNotNullParameter(goodsSpecificationDialog, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            int intExtra = data != null ? data.getIntExtra(GoodsSpecificationPreviewActivity.t, -1) : -1;
            Intent data2 = activityResult.getData();
            int intExtra2 = data2 != null ? data2.getIntExtra(GoodsSpecificationPreviewActivity.x, -1) : -1;
            if (intExtra == -1 || intExtra2 == -1 || ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v()[intExtra2] == intExtra) {
                return;
            }
            ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v()[intExtra2] = intExtra;
            ((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).B(((GoodsSpecificationVM) goodsSpecificationDialog.getMViewModel()).v());
            MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding = (MallDialogGoodsSpecificationBinding) goodsSpecificationDialog.getMBinding();
            View view = (mallDialogGoodsSpecificationBinding == null || (linearLayout = mallDialogGoodsSpecificationBinding.c) == null || (children = ViewGroupKt.getChildren(linearLayout)) == null || (sequenceFilter = SequencesKt.filter(children, new Function1<View, Boolean>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog$launcher$1$recyclerView$1
                @NotNull
                public final Boolean invoke(@NotNull View view2) {
                    Intrinsics.checkNotNullParameter(view2, "child");
                    return Boolean.valueOf((view2 instanceof RecyclerView) || (view2 instanceof FlowLayout));
                }
            })) == null) ? null : (View) SequencesKt.elementAt(sequenceFilter, intExtra2);
            RecyclerView recyclerView = view instanceof RecyclerView ? (RecyclerView) view : null;
            RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            GoodsSpecificationAdapter goodsSpecificationAdapter = adapter instanceof GoodsSpecificationAdapter ? (GoodsSpecificationAdapter) adapter : null;
            if (goodsSpecificationAdapter != null) {
                goodsSpecificationAdapter.e(intExtra);
            }
            if (recyclerView != null) {
                recyclerView.scrollToPosition(intExtra);
            }
        }
    }

    private final void setSelLabelStyle(TextView textView) {
        textView.setTextColor(-1);
        textView.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(16.0f)).setSolidColor(RunIndexRecordAdapter.K).build());
    }

    private final void setUnSelLabelStyle(TextView textView, Boolean enable) {
        Boolean bool = Boolean.FALSE;
        textView.setEnabled(!Intrinsics.areEqual(enable, bool));
        textView.setTextColor(!Intrinsics.areEqual(enable, bool) ? -13877680 : RunIndexRecordAdapter.O);
        textView.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(16.0f)).setSolidColor(ar6.E).build());
    }

    public static /* synthetic */ void setUnSelLabelStyle$default(GoodsSpecificationDialog goodsSpecificationDialog, TextView textView, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        goodsSpecificationDialog.setUnSelLabelStyle(textView, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void toggleTypeSel(GoodsDetailSpecValue item, int index, TextView textView, FlowLayout flLabel, int labelIndex) {
        View childAt;
        int i = ((GoodsSpecificationVM) getMViewModel()).v()[labelIndex];
        if (i == index) {
            ((GoodsSpecificationVM) getMViewModel()).v()[labelIndex] = -1;
            setUnSelLabelStyle(textView, Boolean.valueOf(!item.getOutOfStock()));
        } else {
            if (flLabel != null && (childAt = flLabel.getChildAt(i)) != null) {
                setUnSelLabelStyle$default(this, (TextView) childAt, null, 2, null);
            }
            ((GoodsSpecificationVM) getMViewModel()).v()[labelIndex] = index;
            setSelLabelStyle(textView);
        }
        ((GoodsSpecificationVM) getMViewModel()).B(((GoodsSpecificationVM) getMViewModel()).v());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return (int) (fx7.c() * 0.75f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_goods_specification;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        GoodsDetailBean goodsDetailBean;
        Bundle arguments;
        int[] intArray;
        String string;
        super.initData();
        ((GoodsSpecificationVM) getMViewModel()).x().setValue(Integer.valueOf(getSquareType()));
        ((GoodsSpecificationVM) getMViewModel()).s().setValue(Boolean.valueOf(getSquareType() > 0));
        ((GoodsSpecificationVM) getMViewModel()).z(getFromReward());
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (goodsDetailBean = (GoodsDetailBean) arguments2.getParcelable(KEY_DETAIL_BEAN)) == null || (arguments = getArguments()) == null || (intArray = arguments.getIntArray(KEY_SEL_SPEC_INDEX_ARRAY)) == null || goodsDetailBean.getSpecList().size() != intArray.length) {
            return;
        }
        ((GoodsSpecificationVM) getMViewModel()).y(goodsDetailBean);
        ((GoodsSpecificationVM) getMViewModel()).B(intArray);
        initSpec(goodsDetailBean.getSpecList());
        Bundle arguments3 = getArguments();
        updateCanExchange(arguments3 != null ? arguments3.getBoolean(KEY_CAN_EXCHANGE) : false);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string = arguments4.getString(KEY_REMAIN_TIME_STR)) == null) {
            string = "";
        }
        updateRemainTimeStr(string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @SuppressLint({"SetTextI18n"})
    public void initDataObserve() {
        super.initDataObserve();
        ((GoodsSpecificationVM) getMViewModel()).p().observe(this, new e(new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                EditText editText;
                EditText editText2;
                Editable text;
                EditText editText3;
                EditText editText4;
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
                if (Intrinsics.areEqual(String.valueOf((mallDialogGoodsSpecificationBindingAccess$getMBinding == null || (editText4 = mallDialogGoodsSpecificationBindingAccess$getMBinding.f34916a) == null) ? null : editText4.getText()), String.valueOf(num))) {
                    return;
                }
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding2 = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
                if (mallDialogGoodsSpecificationBindingAccess$getMBinding2 != null && (editText3 = mallDialogGoodsSpecificationBindingAccess$getMBinding2.f34916a) != null) {
                    editText3.setText(String.valueOf(num));
                }
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding3 = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
                if (mallDialogGoodsSpecificationBindingAccess$getMBinding3 == null || (editText = mallDialogGoodsSpecificationBindingAccess$getMBinding3.f34916a) == null) {
                    return;
                }
                MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBindingAccess$getMBinding4 = GoodsSpecificationDialog.access$getMBinding(GoodsSpecificationDialog.this);
                editText.setSelection((mallDialogGoodsSpecificationBindingAccess$getMBinding4 == null || (editText2 = mallDialogGoodsSpecificationBindingAccess$getMBinding4.f34916a) == null || (text = editText2.getText()) == null) ? 0 : text.length());
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        EditText editText;
        super.initView();
        MallDialogGoodsSpecificationBinding mallDialogGoodsSpecificationBinding = (MallDialogGoodsSpecificationBinding) getMBinding();
        if (mallDialogGoodsSpecificationBinding != null && (editText = mallDialogGoodsSpecificationBinding.f34916a) != null) {
            editText.addTextChangedListener(new d());
        }
        KeyboardUtils.o(requireActivity(), new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.ov3
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                GoodsSpecificationDialog.initView$lambda$0(this.f43838a, i);
            }
        });
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Function1<? super int[], Unit> function1 = this.onSpecIndexChangedCallback;
        if (function1 != null) {
            function1.invoke(((GoodsSpecificationVM) getMViewModel()).v());
        }
        super.onDismiss(dialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateCanExchange(boolean canExchange) {
        ((GoodsSpecificationVM) getMViewModel()).j().setValue(Boolean.valueOf(canExchange));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateRemainTimeStr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        ((GoodsSpecificationVM) getMViewModel()).t().setValue(str);
    }
}
