package com.huachenjie.mall.page.comment.write;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.WriteReviewAddImageBean;
import com.huachenjie.mall.bean.WriteReviewImageBean;
import com.huachenjie.mall.databinding.MallActivityWriteReviewBinding;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.widget.CommentStarView;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.wd6;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0018B\u0007¢\u0006\u0004\b\"\u0010#J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/huachenjie/mall/page/comment/write/WriteReviewActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityWriteReviewBinding;", "Lcom/huachenjie/mall/page/comment/write/WriteReviewVM;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "w0", "s0", "t0", "k0", "o0", "index", "v0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "", "b", "Lkotlin/Lazy;", "j0", "()Ljava/lang/String;", "orderNo", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "c", "i0", "()Lcom/huachenjie/base/bean/OrderGoodsBean;", WriteReviewActivity.x, "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWriteReviewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WriteReviewActivity.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1855#2,2:217\n*S KotlinDebug\n*F\n+ 1 WriteReviewActivity.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewActivity\n*L\n196#1:217,2\n*E\n"})
public final class WriteReviewActivity extends BaseMVVMActivity<MallActivityWriteReviewBinding, WriteReviewVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "orderNo";

    @NotNull
    public static final String x = "goodsBean";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewActivity$orderNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("orderNo");
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy goodsBean = LazyKt.lazy(new Function0<OrderGoodsBean>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewActivity$goodsBean$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OrderGoodsBean m508invoke() {
            return (OrderGoodsBean) this.this$0.getIntent().getParcelableExtra(WriteReviewActivity.x);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/comment/write/WriteReviewActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/comment/write/WriteReviewActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            WriteReviewVM writeReviewVMG0 = WriteReviewActivity.g0(WriteReviewActivity.this);
            String strJ0 = WriteReviewActivity.this.j0();
            if (strJ0 == null) {
                strJ0 = "";
            }
            writeReviewVMG0.x(strJ0);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.comment.write.WriteReviewActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/comment/write/WriteReviewActivity$b;", "", "Landroid/content/Context;", "context", "", "orderNo", "Lcom/huachenjie/base/bean/OrderGoodsBean;", WriteReviewActivity.x, "", "a", "GOODS_BEAN", "Ljava/lang/String;", "ORDER_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String orderNo, @NotNull OrderGoodsBean goodsBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intrinsics.checkNotNullParameter(goodsBean, WriteReviewActivity.x);
            Intent intent = new Intent(context, (Class<?>) WriteReviewActivity.class);
            intent.putExtra("orderNo", orderNo);
            intent.putExtra(WriteReviewActivity.x, goodsBean);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/mall/page/comment/write/WriteReviewActivity$c", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nWriteReviewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WriteReviewActivity.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewActivity$initView$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1855#2,2:217\n*S KotlinDebug\n*F\n+ 1 WriteReviewActivity.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewActivity$initView$1\n*L\n73#1:217,2\n*E\n"})
    public static final class c implements MediaPickerListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            List<String> listG = ((MediaPickerResult.Success) result).g();
            WriteReviewActivity writeReviewActivity = WriteReviewActivity.this;
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                WriteReviewActivity.g0(writeReviewActivity).w(writeReviewActivity, (String) it.next());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35157a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35157a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35157a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35157a.invoke(obj);
        }
    }

    public static final /* synthetic */ WriteReviewVM g0(WriteReviewActivity writeReviewActivity) {
        return writeReviewActivity.getMViewModel();
    }

    public static final void l0(WriteReviewActivity writeReviewActivity, View view) {
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        writeReviewActivity.w0();
    }

    public static final void m0(WriteReviewImageAdapter writeReviewImageAdapter, WriteReviewActivity writeReviewActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(writeReviewImageAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (((WriteReviewImageBean) writeReviewImageAdapter.getData().get(i)).getPostType() == 1) {
            writeReviewActivity.w0();
        } else {
            writeReviewActivity.v0(i);
        }
    }

    public static final void n0(WriteReviewImageAdapter writeReviewImageAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(writeReviewImageAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.iv_delete) {
            return;
        }
        if (writeReviewImageAdapter.getData().size() == 2) {
            writeReviewImageAdapter.setList(null);
            writeReviewImageAdapter.h();
            return;
        }
        if (writeReviewImageAdapter.getData().size() == 6 && ((WriteReviewImageBean) writeReviewImageAdapter.getData().get(5)).getPostType() == 0) {
            writeReviewImageAdapter.removeAt(i);
            writeReviewImageAdapter.addData(new WriteReviewAddImageBean(1));
            return;
        }
        writeReviewImageAdapter.removeAt(i);
        WriteReviewImageBean writeReviewImageBean = (WriteReviewImageBean) CollectionsKt.last(writeReviewImageAdapter.getData());
        if (writeReviewImageBean.getPostType() == 1 && (writeReviewImageBean instanceof WriteReviewAddImageBean)) {
            WriteReviewAddImageBean writeReviewAddImageBean = (WriteReviewAddImageBean) writeReviewImageBean;
            writeReviewAddImageBean.setOptionalNum(writeReviewAddImageBean.getOptionalNum() + 1);
            writeReviewImageAdapter.notifyItemChanged(writeReviewImageAdapter.getData().size() - 1);
        }
    }

    public static final void p0(WriteReviewActivity writeReviewActivity, int i) {
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        writeReviewActivity.getMViewModel().q().setValue(Integer.valueOf(i));
    }

    public static final void q0(WriteReviewActivity writeReviewActivity, int i) {
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        writeReviewActivity.getMViewModel().t().setValue(Integer.valueOf(i));
    }

    public static final void r0(WriteReviewActivity writeReviewActivity, int i) {
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        writeReviewActivity.getMViewModel().u().setValue(Integer.valueOf(i));
        writeReviewActivity.getMViewModel().l();
    }

    public static final void u0(WriteReviewActivity writeReviewActivity, View view) {
        Intrinsics.checkNotNullParameter(writeReviewActivity, "this$0");
        writeReviewActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().o().observe(this, new d(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                WriteReviewActivity.g0(this.this$0).l();
            }
        }));
        getMViewModel().v().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    WriteReviewSuccessActivity.Companion companion = WriteReviewSuccessActivity.INSTANCE;
                    WriteReviewActivity writeReviewActivity = this.this$0;
                    String strJ0 = writeReviewActivity.j0();
                    if (strJ0 == null) {
                        strJ0 = "";
                    }
                    companion.a(writeReviewActivity, strJ0);
                    wd6 wd6Var = wd6.f20422a;
                    WriteReviewActivity writeReviewActivity2 = this.this$0;
                    String strJ1 = writeReviewActivity2.j0();
                    wd6Var.b(writeReviewActivity2, strJ1 != null ? strJ1 : "", 4);
                    this.this$0.finish();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_write_review;
    }

    public final OrderGoodsBean i0() {
        return (OrderGoodsBean) this.goodsBean.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        this.picker = MediaPicker.w(this, new c());
        getMViewModel().r().setValue(i0());
        s0();
        t0();
        k0();
        o0();
    }

    public final String j0() {
        return (String) this.orderNo.getValue();
    }

    public final void k0() {
        getMBinding();
        final WriteReviewImageAdapter writeReviewImageAdapter = new WriteReviewImageAdapter();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_empty_write_review_image, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.x0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteReviewActivity.l0(this.f45724a, view);
            }
        });
        y57.d(writeReviewImageAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.y0a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WriteReviewActivity.m0(writeReviewImageAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        writeReviewImageAdapter.addChildClickViewIds(R.id.iv_delete);
        y57.b(writeReviewImageAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.z0a
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WriteReviewActivity.n0(writeReviewImageAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        writeReviewImageAdapter.g(viewInflate);
        writeReviewImageAdapter.h();
        getMViewModel().s().setValue(writeReviewImageAdapter);
    }

    public final void o0() {
        MallActivityWriteReviewBinding mBinding = getMBinding();
        mBinding.f10487a.setOnStarChangedCallback(new CommentStarView.OnStarChangedCallback() { // from class: com.zj.adlib.b1a
            @Override // com.huachenjie.mall.widget.CommentStarView.OnStarChangedCallback
            public final void a(int i) {
                WriteReviewActivity.p0(this.f40657a, i);
            }
        });
        mBinding.f10488b.setOnStarChangedCallback(new CommentStarView.OnStarChangedCallback() { // from class: com.zj.adlib.c1a
            @Override // com.huachenjie.mall.widget.CommentStarView.OnStarChangedCallback
            public final void a(int i) {
                WriteReviewActivity.q0(this.f40881a, i);
            }
        });
        mBinding.c.setOnStarChangedCallback(new CommentStarView.OnStarChangedCallback() { // from class: com.zj.adlib.d1a
            @Override // com.huachenjie.mall.widget.CommentStarView.OnStarChangedCallback
            public final void a(int i) {
                WriteReviewActivity.r0(this.f41088a, i);
            }
        });
    }

    public final void s0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void t0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("写评价");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.a1a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteReviewActivity.u0(this.f40432a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    public final void v0(int index) {
        final WriteReviewImageAdapter value = getMViewModel().s().getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WriteReviewImageBean writeReviewImageBean : value.getData()) {
            if (!TextUtils.isEmpty(writeReviewImageBean.getImagePath())) {
                arrayList.add(writeReviewImageBean.getImagePath());
            }
        }
        PicturePreviewUtil.h(this, arrayList, index, new Function1<Integer, View>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewActivity$preImage$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            @Nullable
            public final View invoke(int i) {
                return value.getViewByPosition(i, R.id.iv_commodity_image);
            }
        });
    }

    public final void w0() {
        WriteReviewImageAdapter value = getMViewModel().s().getValue();
        if (value == null) {
            return;
        }
        if (value.getData().size() > 6) {
            fv5.b("最多只能选择6张图片");
            return;
        }
        int iMin = Math.min(7 - value.getData().size(), 6);
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, iMin, 1080, 1024, false, 0.0f, 0.0f, false, 240, null);
    }
}
