package com.huachenjie.home.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.AdPopupBean;
import com.huachenjie.home.dialog.HomeAdPopupDialog;
import com.zj.adlib.er7;
import com.zj.adlib.fx7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/home/dialog/HomeAdPopupDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "Lcom/huachenjie/home/bean/AdPopupBean;", "popupBean$delegate", "Lkotlin/Lazy;", "getPopupBean", "()Lcom/huachenjie/home/bean/AdPopupBean;", "popupBean", "Lkotlin/Function0;", "onGoRecommend", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeAdPopupDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_POPUP_BEAN = "popup_bean";

    @Nullable
    private Function0<Unit> onGoRecommend;

    /* JADX INFO: renamed from: popupBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy popupBean = LazyKt.lazy(new Function0<AdPopupBean>() { // from class: com.huachenjie.home.dialog.HomeAdPopupDialog$popupBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AdPopupBean m401invoke() {
            Bundle arguments = this.this$0.getArguments();
            AdPopupBean adPopupBean = arguments != null ? (AdPopupBean) arguments.getParcelable("popup_bean") : null;
            return adPopupBean == null ? new AdPopupBean(null, false, 0, null, false, 31, null) : adPopupBean;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.HomeAdPopupDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/dialog/HomeAdPopupDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/home/bean/AdPopupBean;", "adPopupBean", "Lkotlin/Function0;", "", "onGoRecommend", "a", "", "KEY_POPUP_BEAN", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull AdPopupBean adPopupBean, @NotNull Function0<Unit> onGoRecommend) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(adPopupBean, "adPopupBean");
            Intrinsics.checkNotNullParameter(onGoRecommend, "onGoRecommend");
            HomeAdPopupDialog homeAdPopupDialog = new HomeAdPopupDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(HomeAdPopupDialog.KEY_POPUP_BEAN, adPopupBean);
            homeAdPopupDialog.setArguments(bundle);
            homeAdPopupDialog.onGoRecommend = onGoRecommend;
            homeAdPopupDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(HomeAdPopupDialog.class).getSimpleName());
        }
    }

    private final AdPopupBean getPopupBean() {
        return (AdPopupBean) this.popupBean.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(HomeAdPopupDialog homeAdPopupDialog, View view) {
        Intrinsics.checkNotNullParameter(homeAdPopupDialog, "this$0");
        er7 er7Var = er7.f41510a;
        Context contextRequireContext = homeAdPopupDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        er7Var.b(contextRequireContext, homeAdPopupDialog.getPopupBean().getClickType(), homeAdPopupDialog.getPopupBean().getClickTarget());
        if (homeAdPopupDialog.getPopupBean().getClickType() != 1) {
            homeAdPopupDialog.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HomeAdPopupDialog homeAdPopupDialog, View view) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(homeAdPopupDialog, "this$0");
        if (homeAdPopupDialog.getPopupBean().getEnableRecommendList() && (function0 = homeAdPopupDialog.onGoRecommend) != null) {
            function0.invoke();
        }
        homeAdPopupDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_ad_popup;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - (SizeUtils.b(38.0f) * 2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        ImageView imageView2;
        super.initView();
        setCancelable(false);
        View view = getView();
        if (view != null && (imageView2 = (ImageView) view.findViewById(R.id.iv_dialog_ad)) != null) {
            Glide.with(imageView2).load(getPopupBean().getImageUrl()).transform(new RoundedCorners(SizeUtils.b(20.0f))).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.e14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeAdPopupDialog.initView$lambda$1$lambda$0(this.f41318a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 == null || (imageView = (ImageView) view2.findViewById(R.id.iv_dialog_close)) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.f14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                HomeAdPopupDialog.initView$lambda$2(this.f41567a, view3);
            }
        });
    }
}
