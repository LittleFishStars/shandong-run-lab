package com.huachenjie.mall.page.apply_refund;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.databinding.MallActivityApplyRefundBinding;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.huachenjie.mall.page.apply_refund.ApplyRefundActivity;
import com.huachenjie.mall.page.apply_refund.ApplyRefundActivity.ClickProxy;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.qa4;
import com.zj.adlib.wd6;
import com.zj.adlib.y57;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
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
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u0018B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u001f\u0010\u0016\u001a\u00060\u0011R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityApplyRefundBinding;", "Lcom/huachenjie/mall/page/apply_refund/ApplyRefundVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "t0", "k0", "r0", "n0", "Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity$ClickProxy;", "b", "Lkotlin/Lazy;", "j0", "()Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity$ClickProxy;", "click", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "<init>", "()V", "ClickProxy", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ApplyRefundActivity extends BaseMVVMActivity<MallActivityApplyRefundBinding, ApplyRefundVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "orderGoodsBean";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy click = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundActivity$click$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ApplyRefundActivity.ClickProxy m495invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "b", "a", "c", "<init>", "(Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            ApplyRefundFileAdapter value = ApplyRefundActivity.h0(ApplyRefundActivity.this).m().getValue();
            if (value == null) {
                return;
            }
            int size = value.getData().isEmpty() ? 6 : (6 - value.getData().size()) + 1;
            MediaPickerLauncher mediaPickerLauncher = ApplyRefundActivity.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.H(mediaPickerLauncher, size, 0, 0, 60, false, 22, null);
        }

        public final void b(@Nullable View v) {
            CancelReasonDialog.Companion companion = CancelReasonDialog.INSTANCE;
            ApplyRefundVM applyRefundVMH0 = ApplyRefundActivity.h0(ApplyRefundActivity.this);
            FragmentManager supportFragmentManager = ApplyRefundActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            OrderReasonBean value = ApplyRefundActivity.h0(ApplyRefundActivity.this).o().getValue();
            final ApplyRefundActivity applyRefundActivity = ApplyRefundActivity.this;
            companion.f(applyRefundVMH0, supportFragmentManager, value, new Function1<OrderReasonBean, Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundActivity$ClickProxy$clickSelectReason$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OrderReasonBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrderReasonBean orderReasonBean) {
                    Intrinsics.checkNotNullParameter(orderReasonBean, o.f);
                    ApplyRefundActivity.h0(applyRefundActivity).o().setValue(orderReasonBean);
                }
            });
        }

        public final void c(@Nullable View v) {
            ApplyRefundActivity.h0(ApplyRefundActivity.this).s();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.apply_refund.ApplyRefundActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/mall/page/apply_refund/ApplyRefundActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/bean/OrderGoodsBean;", WriteReviewActivity.x, "Landroid/content/Intent;", "a", "", "KEY_ORDER_GOODS_BEAN", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull OrderGoodsBean goodsBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(goodsBean, WriteReviewActivity.x);
            Intent intent = new Intent(context, (Class<?>) ApplyRefundActivity.class);
            intent.putExtra(ApplyRefundActivity.t, goodsBean);
            return intent;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/mall/page/apply_refund/ApplyRefundActivity$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) throws IOException {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                ApplyRefundActivity.h0(ApplyRefundActivity.this).t(((MediaPickerResult.Success) result).f());
            } else {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35141a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35141a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35141a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35141a.invoke(obj);
        }
    }

    public static final /* synthetic */ ApplyRefundVM h0(ApplyRefundActivity applyRefundActivity) {
        return applyRefundActivity.getMViewModel();
    }

    public static final void l0(ApplyRefundFileAdapter applyRefundFileAdapter, ApplyRefundActivity applyRefundActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(applyRefundFileAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(applyRefundActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.iv_del) {
            applyRefundFileAdapter.removeAt(i);
            if (((ApplyRefundFileBean) CollectionsKt.last(applyRefundFileAdapter.getData())).getPostType() == 1) {
                applyRefundActivity.getMViewModel().j(applyRefundFileAdapter);
            } else if (!applyRefundFileAdapter.getData().isEmpty()) {
                ApplyRefundFileBean applyRefundFileBean = (ApplyRefundFileBean) CollectionsKt.last(applyRefundFileAdapter.getData());
                String strF = ys8.f(R.string.mall_activity_apply_refund_size_remain, String.valueOf((6 - applyRefundFileAdapter.getData().size()) + 1));
                Intrinsics.checkNotNullExpressionValue(strF, "getString(\n             …                        )");
                applyRefundFileBean.setName(strF);
                applyRefundFileAdapter.notifyItemChanged(applyRefundFileAdapter.getData().size() - 1);
            }
            applyRefundActivity.getMViewModel().r().setValue(Boolean.valueOf(applyRefundFileAdapter.getData().size() > 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m0(ApplyRefundFileAdapter applyRefundFileAdapter, ApplyRefundActivity applyRefundActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(applyRefundFileAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(applyRefundActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((ApplyRefundFileBean) applyRefundFileAdapter.getItem(i)).getPostType() == 2) {
            applyRefundActivity.j0().a(null);
            return;
        }
        ApplyRefundFileBean applyRefundFileBean = (ApplyRefundFileBean) applyRefundFileAdapter.getData().get(i);
        if (applyRefundFileBean.getCover() == null) {
            String path = applyRefundFileBean.getPath();
            PicturePreviewUtil.i(view, path != null ? path : "");
        } else {
            VideoPlayerActivity.Companion companion = VideoPlayerActivity.INSTANCE;
            String path2 = applyRefundFileBean.getPath();
            companion.a(applyRefundActivity, path2 != null ? path2 : "");
        }
    }

    public static final void o0(Function0 function0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "$checkPriceCallback");
        if (z) {
            return;
        }
        function0.invoke();
    }

    public static final boolean p0(Function0 function0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(function0, "$checkPriceCallback");
        function0.invoke();
        qa4.b(textView);
        return true;
    }

    public static final void q0(ApplyRefundActivity applyRefundActivity, int i) {
        Intrinsics.checkNotNullParameter(applyRefundActivity, "this$0");
        if (i == 0) {
            applyRefundActivity.getMBinding().f34764a.clearFocus();
        }
    }

    public static final void s0(ApplyRefundActivity applyRefundActivity, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(applyRefundActivity, "this$0");
        applyRefundActivity.getMViewModel().q().setValue(Integer.valueOf(i == R.id.rb_type1 ? 1 : 2));
    }

    public static final void u0(ApplyRefundActivity applyRefundActivity, View view) {
        Intrinsics.checkNotNullParameter(applyRefundActivity, "this$0");
        applyRefundActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), j0())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().k().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                wd6.f20422a.b(this.this$0, "", 5);
                this.this$0.setResult(-1);
                fv5.a(R.string.mall_activity_apply_refund_input_suc);
                this.this$0.finish();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ApplyRefundActivity applyRefundActivity = this.this$0;
                RefundDetailActivity.Companion companion = RefundDetailActivity.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                applyRefundActivity.startActivity(companion.a(applyRefundActivity, str));
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_apply_refund;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().l().setValue(getIntent().getParcelableExtra(t));
        MutableLiveData<String> mutableLiveDataN = getMViewModel().n();
        OrderGoodsBean value = getMViewModel().l().getValue();
        mutableLiveDataN.setValue(value != null ? value.getRefundAmountMax() : null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        this.picker = MediaPicker.w(this, new b());
        t0();
        k0();
        r0();
        n0();
    }

    public final ClickProxy j0() {
        return (ClickProxy) this.click.getValue();
    }

    public final void k0() {
        final ApplyRefundFileAdapter value = getMViewModel().m().getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.iv_del);
            y57.b(value, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.pa0
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ApplyRefundActivity.l0(value, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.qa0
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ApplyRefundActivity.m0(value, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    public final void n0() {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundActivity$initPrice$checkPriceCallback$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m496invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m496invoke() {
                String refundAmountMax;
                OrderGoodsBean value = ApplyRefundActivity.h0(this.this$0).l().getValue();
                double d = (value == null || (refundAmountMax = value.getRefundAmountMax()) == null) ? 0.0d : Double.parseDouble(refundAmountMax);
                if (ys8.j(this.this$0.getMBinding().f34764a.getText().toString())) {
                    EditText editText = this.this$0.getMBinding().f34764a;
                    OrderGoodsBean value2 = ApplyRefundActivity.h0(this.this$0).l().getValue();
                    editText.setText(value2 != null ? value2.getRefundAmountMax() : null);
                    return;
                }
                double d2 = Double.parseDouble(this.this$0.getMBinding().f34764a.getText().toString());
                if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || d2 > d) {
                    EditText editText2 = this.this$0.getMBinding().f34764a;
                    OrderGoodsBean value3 = ApplyRefundActivity.h0(this.this$0).l().getValue();
                    editText2.setText(value3 != null ? value3.getRefundAmountMax() : null);
                } else {
                    EditText editText3 = this.this$0.getMBinding().f34764a;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                    editText3.setText(str);
                }
            }
        };
        getMBinding().f34764a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.zj.adlib.ma0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ApplyRefundActivity.o0(function0, view, z);
            }
        });
        getMBinding().f34764a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.na0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ApplyRefundActivity.p0(function0, textView, i, keyEvent);
            }
        });
        KeyboardUtils.o(this, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.oa0
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                ApplyRefundActivity.q0(this.f43704a, i);
            }
        });
    }

    public final void r0() {
        getMBinding().f10127a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.zj.adlib.la0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                ApplyRefundActivity.s0(this.f43022a, radioGroup, i);
            }
        });
    }

    public final void t0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_activity_apply_refund_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ra0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyRefundActivity.u0(this.f44406a, view);
            }
        }));
    }
}
