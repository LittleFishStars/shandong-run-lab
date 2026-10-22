package com.huachenjie.mall.page.comment.detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityCommodityCommentDetailBinding;
import com.huachenjie.mall.page.comment.detail.CommentDetailActivity;
import com.huachenjie.mall.page.comment.list.CommodityCommentAdapter;
import com.zj.adlib.hk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/mall/page/comment/detail/CommentDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityCommodityCommentDetailBinding;", "Lcom/huachenjie/mall/page/comment/detail/CommentDetailVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "c0", "d0", "b0", "", "b", "Lkotlin/Lazy;", "a0", "()Ljava/lang/String;", "orderNo", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommentDetailActivity extends BaseMVVMActivity<MallActivityCommodityCommentDetailBinding, CommentDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "orderNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.comment.detail.CommentDetailActivity$orderNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("orderNo");
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mall.page.comment.detail.CommentDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/comment/detail/CommentDetailActivity$a;", "", "Landroid/content/Context;", "context", "", "orderNo", "", "a", "ORDER_NO", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String orderNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intent intent = new Intent(context, (Class<?>) CommentDetailActivity.class);
            intent.putExtra("orderNo", orderNo);
            context.startActivity(intent);
        }
    }

    public static final void e0(CommentDetailActivity commentDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(commentDetailActivity, "this$0");
        commentDetailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final String a0() {
        return (String) this.orderNo.getValue();
    }

    public final void b0() {
        if (getMBinding() != null) {
            getMViewModel().j().setValue(new CommodityCommentAdapter());
        }
    }

    public final void c0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void d0() {
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
        bindingTitleBean.setTitleName("评价详情");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.io1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentDetailActivity.e0(this.f42399a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_commodity_comment_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        CommentDetailVM mViewModel = getMViewModel();
        String strA0 = a0();
        if (strA0 == null) {
            strA0 = "";
        }
        mViewModel.k(strA0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        c0();
        d0();
        b0();
    }
}
