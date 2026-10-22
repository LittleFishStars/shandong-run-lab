package com.huachenjie.mall.dialog.poster;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ImageUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.PosterBackgroundBean;
import com.huachenjie.mall.databinding.MallDialogCreatePosterBinding;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.zj.adlib.ai9;
import com.zj.adlib.dn1;
import com.zj.adlib.en6;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.i4a;
import com.zj.adlib.tw0;
import com.zj.adlib.wf3;
import com.zj.adlib.y57;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.ImageBody;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006$"}, d2 = {"Lcom/huachenjie/mall/dialog/poster/CreatePosterDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogCreatePosterBinding;", "Lcom/huachenjie/mall/dialog/poster/CreatePosterVM;", "Landroid/content/Context;", "context", "Lhuachenjie/sdk/share/FlavourName;", "flavourName", "", "shareToWechat", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "initData", "", "shareNo$delegate", "Lkotlin/Lazy;", "getShareNo", "()Ljava/lang/String;", CreatePosterDialog.SHARE_NO, "goodsDes$delegate", "getGoodsDes", CreatePosterDialog.SHARE_GOODS_DES, "goodsNo$delegate", "getGoodsNo", "goodsNo", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CreatePosterDialog extends BaseMVVMDialogFragment<MallDialogCreatePosterBinding, CreatePosterVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GOODS_NO = "goodsNo";

    @NotNull
    public static final String SHARE_GOODS_DES = "goodsDes";

    @NotNull
    public static final String SHARE_NO = "shareNo";

    /* JADX INFO: renamed from: shareNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.dialog.poster.CreatePosterDialog$shareNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(CreatePosterDialog.SHARE_NO)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: goodsDes$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy goodsDes = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.dialog.poster.CreatePosterDialog$goodsDes$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(CreatePosterDialog.SHARE_GOODS_DES)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: goodsNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy goodsNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.dialog.poster.CreatePosterDialog$goodsNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("goodsNo")) == null) ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/dialog/poster/CreatePosterDialog$a;", "", "Landroid/view/View;", "view", "", "a", "d", "b", "c", "<init>", "(Lcom/huachenjie/mall/dialog/poster/CreatePosterDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreatePosterDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreatePosterDialog createPosterDialog = CreatePosterDialog.this;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            createPosterDialog.shareToWechat(context, FlavourName.WX_MOMENT);
        }

        public final void c(@NotNull View view) {
            ConstraintLayout constraintLayout;
            Intrinsics.checkNotNullParameter(view, "view");
            MallDialogCreatePosterBinding mallDialogCreatePosterBindingAccess$getMBinding = CreatePosterDialog.access$getMBinding(CreatePosterDialog.this);
            if (mallDialogCreatePosterBindingAccess$getMBinding == null || (constraintLayout = mallDialogCreatePosterBindingAccess$getMBinding.f10524a) == null) {
                return;
            }
            Bitmap bitmapC = tw0.c(constraintLayout);
            String str = en6.K() + System.currentTimeMillis();
            i4a.a("图片路径:" + str);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                i4a.a("存在同名文件,已删除");
            }
            ImageUtils.B0(bitmapC, str, Bitmap.CompressFormat.PNG, true);
            i4a.a("新文件大小:" + file.length());
            if (wf3.n(file.getPath(), view.getContext())) {
                fv5.b("图片保存成功");
            } else {
                fv5.b("图片保存失败");
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreatePosterDialog createPosterDialog = CreatePosterDialog.this;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            createPosterDialog.shareToWechat(context, FlavourName.WX_SESSION);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.dialog.poster.CreatePosterDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/mall/dialog/poster/CreatePosterDialog$b;", "", "", CreatePosterDialog.SHARE_NO, CreatePosterDialog.SHARE_GOODS_DES, "goodsNo", "Lcom/huachenjie/mall/dialog/poster/CreatePosterDialog;", "a", "GOODS_NO", "Ljava/lang/String;", "SHARE_GOODS_DES", "SHARE_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CreatePosterDialog a(@NotNull String shareNo, @NotNull String goodsDes, @NotNull String goodsNo) {
            Intrinsics.checkNotNullParameter(shareNo, CreatePosterDialog.SHARE_NO);
            Intrinsics.checkNotNullParameter(goodsDes, CreatePosterDialog.SHARE_GOODS_DES);
            Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
            CreatePosterDialog createPosterDialog = new CreatePosterDialog();
            Bundle bundle = new Bundle();
            bundle.putString(CreatePosterDialog.SHARE_NO, shareNo);
            bundle.putString(CreatePosterDialog.SHARE_GOODS_DES, goodsDes);
            bundle.putString("goodsNo", goodsNo);
            createPosterDialog.setArguments(bundle);
            return createPosterDialog;
        }
    }

    public static final /* synthetic */ MallDialogCreatePosterBinding access$getMBinding(CreatePosterDialog createPosterDialog) {
        return createPosterDialog.getMBinding();
    }

    private final String getGoodsDes() {
        return (String) this.goodsDes.getValue();
    }

    private final String getGoodsNo() {
        return (String) this.goodsNo.getValue();
    }

    private final String getShareNo() {
        return (String) this.shareNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(PosterBgAdapter posterBgAdapter, CreatePosterDialog createPosterDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(posterBgAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(createPosterDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        PosterBackgroundBean posterBackgroundBean = posterBgAdapter.getData().get(i);
        createPosterDialog.getMViewModel().n().setValue(posterBackgroundBean.getPosterUrl());
        posterBgAdapter.e(posterBackgroundBean.getPosterNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareToWechat(Context context, FlavourName flavourName) {
        ConstraintLayout constraintLayout;
        MallDialogCreatePosterBinding mBinding = getMBinding();
        if (mBinding == null || (constraintLayout = mBinding.f10524a) == null) {
            return;
        }
        y88.i(context, new ImageBody(flavourName, "", tw0.c(constraintLayout)), new ShareListener() { // from class: com.huachenjie.mall.dialog.poster.CreatePosterDialog.shareToWechat.1
            public void onCancel(@Nullable FlavourName flavour) {
                fv5.b("分享取消");
            }

            public void onFailed(@NotNull FlavourName flavour, int code, @NotNull String message) {
                Intrinsics.checkNotNullParameter(flavour, "flavour");
                Intrinsics.checkNotNullParameter(message, "message");
                fv5.b("分享失败");
            }

            public void onSuccess(@NotNull FlavourName flavour) {
                Intrinsics.checkNotNullParameter(flavour, "flavour");
                fv5.b("分享成功");
                CreatePosterDialog.this.dismissAllowingStateLoss();
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_create_poster;
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
        CommonUserInfo commonUserInfoE = ai9.e();
        getMViewModel().j().setValue(commonUserInfoE.getAvatar());
        getMViewModel().l().setValue(commonUserInfoE.getNickName());
        getMViewModel().k().setValue(getGoodsDes());
        CreatePosterVM mViewModel = getMViewModel();
        String shareNo = getShareNo();
        Intrinsics.checkNotNullExpressionValue(shareNo, SHARE_NO);
        mViewModel.p(shareNo);
        getMViewModel().o();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        MutableLiveData<PosterBgAdapter> mutableLiveDataI = getMViewModel().i();
        final PosterBgAdapter posterBgAdapter = new PosterBgAdapter();
        y57.d(posterBgAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.mx1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CreatePosterDialog.initView$lambda$1$lambda$0(posterBgAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(posterBgAdapter);
        Bitmap bitmapG = dn1.g("goodDetail?goodsNo=" + getGoodsNo(), 150, -16777216, -1, null, 0, null, 0, 0.0f, 496, null);
        MallDialogCreatePosterBinding mBinding = getMBinding();
        if (mBinding == null || (imageView = mBinding.b) == null) {
            return;
        }
        imageView.setImageBitmap(bitmapG);
    }
}
