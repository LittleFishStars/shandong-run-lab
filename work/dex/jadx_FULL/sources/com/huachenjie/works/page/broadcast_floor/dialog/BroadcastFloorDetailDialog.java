package com.huachenjie.works.page.broadcast_floor.dialog;

import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.databinding.WorksDialogBroadcastFloorDetailBinding;
import com.huachenjie.works.databinding.WorksItemBroadcastFloorBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog.ClickProxy;
import com.huachenjie.works.page.comment.CommentDialog;
import com.igexin.push.g.o;
import com.zj.adlib.f64;
import com.zj.adlib.hg0;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;
import com.zj.adlib.zj7;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u0007¢\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001f\u0010\u001c\u001a\u00060\u0017R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogBroadcastFloorDetailBinding;", "Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailVM;", "", "width", "height", "Landroid/util/Size;", "fixContainerSize", "", "", "getVariables", "getLayoutResID", "getWidth", "getHeight", "", "initView", "onPause", "onDestroy", "imageWidth", "I", "minImageHeight", "maxImageHeight", "Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog$ClickProxy;", "click$delegate", "Lkotlin/Lazy;", "getClick", "()Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog$ClickProxy;", "click", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", "bean$delegate", "getBean", "()Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "<init>", "()V", "Companion", "ClickProxy", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BroadcastFloorDetailDialog extends BaseMVVMBottomDialogFragment<WorksDialogBroadcastFloorDetailBinding, BroadcastFloorDetailVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DETAIL_BEAN_KEY = "bean";
    private final int imageWidth = jj8.a(220.0f);
    private final int minImageHeight = jj8.a(120.0f);
    private final int maxImageHeight = jj8.a(280.0f);

    /* JADX INFO: renamed from: click$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy click = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog$click$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BroadcastFloorDetailDialog.ClickProxy m872invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    /* JADX INFO: renamed from: bean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bean = LazyKt.lazy(new Function0<BroadcastFloorMessageBean>() { // from class: com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog$bean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BroadcastFloorMessageBean m871invoke() {
            Bundle arguments = this.this$0.getArguments();
            BroadcastFloorMessageBean broadcastFloorMessageBean = arguments != null ? (BroadcastFloorMessageBean) arguments.getParcelable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY) : null;
            return broadcastFloorMessageBean == null ? new BroadcastFloorMessageBean(null, null, null, null, null, 0, null, null, 0, false, 0, null, null, false, null, 32767, null) : broadcastFloorMessageBean;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog$ClickProxy;", "", "Landroid/view/View;", "v", "", "c", "a", "b", "<init>", "(Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            String appUserCode;
            Postcard postcardBuild = ARouter.getInstance().build(zj7.h.OTHER_HOME);
            BroadcastFloorMessageBean value = BroadcastFloorDetailDialog.access$getMViewModel(BroadcastFloorDetailDialog.this).i().getValue();
            if (value == null || (appUserCode = value.getAppUserCode()) == null) {
                appUserCode = "";
            }
            postcardBuild.withString("appUserCode", appUserCode).navigation();
        }

        public final void b(@Nullable View v) {
            final BroadcastFloorMessageBean value = BroadcastFloorDetailDialog.access$getMViewModel(BroadcastFloorDetailDialog.this).i().getValue();
            if (value == null) {
                return;
            }
            CommentDialog.Companion companion = CommentDialog.INSTANCE;
            String quoteNo = value.getQuoteNo();
            String appUserCode = value.getAppUserCode();
            int commentCount = value.getCommentCount();
            int i = value.isMatched() ? 8 : 7;
            final BroadcastFloorDetailDialog broadcastFloorDetailDialog = BroadcastFloorDetailDialog.this;
            CommentDialog commentDialogA = companion.a(2, quoteNo, appUserCode, commentCount, i, (32 & 32) != 0, (32 & 64) != 0 ? null : new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog$ClickProxy$clickComment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    WorksItemBroadcastFloorBinding worksItemBroadcastFloorBinding;
                    if (value.getCommentCount() != i2) {
                        value.setCommentCount(i2);
                        WorksDialogBroadcastFloorDetailBinding worksDialogBroadcastFloorDetailBindingAccess$getMBinding = BroadcastFloorDetailDialog.access$getMBinding(broadcastFloorDetailDialog);
                        TextView textView = (worksDialogBroadcastFloorDetailBindingAccess$getMBinding == null || (worksItemBroadcastFloorBinding = worksDialogBroadcastFloorDetailBindingAccess$getMBinding.f36834a) == null) ? null : worksItemBroadcastFloorBinding.f14473a;
                        if (textView == null) {
                            return;
                        }
                        textView.setText(value.formatCommentCount());
                    }
                }
            });
            FragmentManager childFragmentManager = BroadcastFloorDetailDialog.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            commentDialogA.show(childFragmentManager, CommentDialog.class.getName());
        }

        public final void c(@Nullable View v) {
            BroadcastFloorDetailDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/dialog/BroadcastFloorDetailDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "", "DETAIL_BEAN_KEY", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull BroadcastFloorMessageBean bean) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            BroadcastFloorDetailDialog broadcastFloorDetailDialog = new BroadcastFloorDetailDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, bean);
            broadcastFloorDetailDialog.setArguments(bundle);
            broadcastFloorDetailDialog.show(fragmentManager, "BroadcastFloorDetailDialog");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ WorksDialogBroadcastFloorDetailBinding access$getMBinding(BroadcastFloorDetailDialog broadcastFloorDetailDialog) {
        return (WorksDialogBroadcastFloorDetailBinding) broadcastFloorDetailDialog.getMBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BroadcastFloorDetailVM access$getMViewModel(BroadcastFloorDetailDialog broadcastFloorDetailDialog) {
        return (BroadcastFloorDetailVM) broadcastFloorDetailDialog.getMViewModel();
    }

    private final Size fixContainerSize(int width, int height) {
        if (width == 0 && height == 0) {
            int i = this.imageWidth;
            return new Size(i, i);
        }
        if (width == 0 || height == 0) {
            return new Size(this.imageWidth, this.minImageHeight);
        }
        int i2 = this.imageWidth;
        float f = (height * i2) / width;
        int i3 = this.minImageHeight;
        if (f < i3) {
            f = i3;
        }
        int i4 = this.maxImageHeight;
        if (f > i4) {
            f = i4;
        }
        return new Size(i2, (int) f);
    }

    private final BroadcastFloorMessageBean getBean() {
        return (BroadcastFloorMessageBean) this.bean.getValue();
    }

    private final ClickProxy getClick() {
        return (ClickProxy) this.click.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$0(BroadcastFloorDetailDialog broadcastFloorDetailDialog, View view) {
        Intrinsics.checkNotNullParameter(broadcastFloorDetailDialog, "this$0");
        broadcastFloorDetailDialog.getClick().a(view);
        broadcastFloorDetailDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$1(BroadcastFloorDetailDialog broadcastFloorDetailDialog, View view) {
        Intrinsics.checkNotNullParameter(broadcastFloorDetailDialog, "this$0");
        hg0 hg0Var = hg0.f42120a;
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        hg0Var.a(view, broadcastFloorDetailDialog.getBean());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4$lambda$2(BroadcastFloorDetailDialog broadcastFloorDetailDialog, View view) {
        String path;
        BroadcastFloorMessageImageBean image;
        Intrinsics.checkNotNullParameter(broadcastFloorDetailDialog, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        BroadcastFloorMessageBean value = ((BroadcastFloorDetailVM) broadcastFloorDetailDialog.getMViewModel()).i().getValue();
        if (value == null || (image = value.getImage()) == null || (path = image.getPath()) == null) {
            path = "";
        }
        PicturePreviewUtil.i(view, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(BroadcastFloorDetailDialog broadcastFloorDetailDialog, View view) {
        Intrinsics.checkNotNullParameter(broadcastFloorDetailDialog, "this$0");
        broadcastFloorDetailDialog.getClick().b(view);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_broadcast_floor_detail;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), getClick())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        WorksItemBroadcastFloorBinding worksItemBroadcastFloorBinding;
        super.initView();
        getBean().setTextContent(RichTextUtils.j(RichTextUtils.f32968a, getBean().getContent(), 0, 2, null));
        ((BroadcastFloorDetailVM) getMViewModel()).i().setValue(getBean());
        WorksDialogBroadcastFloorDetailBinding worksDialogBroadcastFloorDetailBinding = (WorksDialogBroadcastFloorDetailBinding) getMBinding();
        if (worksDialogBroadcastFloorDetailBinding == null || (worksItemBroadcastFloorBinding = worksDialogBroadcastFloorDetailBinding.f36834a) == null) {
            return;
        }
        worksItemBroadcastFloorBinding.f37006a.setVisibility(8);
        Size sizeFixContainerSize = fixContainerSize(getBean().getWidth(), getBean().getHeight());
        ViewGroup.LayoutParams layoutParams = worksItemBroadcastFloorBinding.c.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = sizeFixContainerSize.getWidth();
        }
        ViewGroup.LayoutParams layoutParams2 = worksItemBroadcastFloorBinding.c.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = sizeFixContainerSize.getHeight();
        }
        worksItemBroadcastFloorBinding.f14476a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.h01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BroadcastFloorDetailDialog.initView$lambda$4$lambda$0(this.f42020a, view);
            }
        });
        worksItemBroadcastFloorBinding.f14479a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.i01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BroadcastFloorDetailDialog.initView$lambda$4$lambda$1(this.f42241a, view);
            }
        });
        worksItemBroadcastFloorBinding.c.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.j01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BroadcastFloorDetailDialog.initView$lambda$4$lambda$2(this.f42476a, view);
            }
        });
        worksItemBroadcastFloorBinding.f14472a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.k01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BroadcastFloorDetailDialog.initView$lambda$4$lambda$3(this.f42711a, view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f64.b().j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        WorksItemBroadcastFloorBinding worksItemBroadcastFloorBinding;
        View view;
        super.onPause();
        WorksDialogBroadcastFloorDetailBinding worksDialogBroadcastFloorDetailBinding = (WorksDialogBroadcastFloorDetailBinding) getMBinding();
        if (worksDialogBroadcastFloorDetailBinding == null || (worksItemBroadcastFloorBinding = worksDialogBroadcastFloorDetailBinding.f36834a) == null || (view = worksItemBroadcastFloorBinding.f14479a) == null) {
            return;
        }
        hg0.f42120a.b(view, getBean());
    }
}
