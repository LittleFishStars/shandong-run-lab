package com.huachenjie.channel.page.my_channel.organize_publish;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.blankj.utilcode.util.a;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelActivityPublishOrgMessageBinding;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityPublishOrgMessageBinding;", "Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "b0", "d0", "<init>", "()V", "a", "ClickProxy", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class PublishOrgMessageActivity extends BaseMVVMActivity<ChannelActivityPublishOrgMessageBinding, PublishOrgMessageVM> {
    public static final int K = 10100;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "organizeBean";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            if (!TextUtils.isEmpty(PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).l().getValue()) && !TextUtils.isEmpty(PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).k().getValue())) {
                List<ImagePickBean> value = PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).j().getValue();
                boolean z = false;
                if (value != null && !value.isEmpty()) {
                    z = true;
                }
                if (z) {
                    if (PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).n().getValue() == null) {
                        fv5.a(R.string.channel_publish_organization_publish_org);
                        return;
                    } else {
                        PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).p();
                        return;
                    }
                }
            }
            fv5.a(R.string.channel_publish_organization_publish_hint);
        }

        public final void b(@Nullable View v) {
            PublishOrgMessageDialog.Companion companion = PublishOrgMessageDialog.INSTANCE;
            FragmentManager supportFragmentManager = PublishOrgMessageActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            String channelNo = PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).getChannelNo();
            final PublishOrgMessageActivity publishOrgMessageActivity = PublishOrgMessageActivity.this;
            companion.a(supportFragmentManager, channelNo, new Function1<OrganizeBean, Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity$ClickProxy$clickSelectOrg$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OrganizeBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrganizeBean organizeBean) {
                    Intrinsics.checkNotNullParameter(organizeBean, o.f);
                    PublishOrgMessageActivity.a0(publishOrgMessageActivity).n().setValue(organizeBean);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Landroid/content/Intent;", "a", "CHANNEL_NO", "Ljava/lang/String;", "", "ERROR_CODE_NO_PERMIT", "I", "ORGANIZE_BEAN", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String channelNo, @Nullable OrganizeBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) PublishOrgMessageActivity.class);
            intent.putExtra("channelNo", channelNo);
            if (bean != null) {
                intent.putExtra("organizeBean", bean);
            }
            return intent;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageActivity$b", "Lcom/huachenjie/base/widget/image_pick/ImagePickView$ImagePickCallback;", "", RVParams.LONG_SHOW_LOADING, "b", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", GoodsSpecificationPreviewActivity.z, "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements ImagePickView.ImagePickCallback {
        public b() {
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void a(@Nullable List<ImagePickBean> list) {
            PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).j().setValue(list);
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void b() {
            PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).c();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void showLoading() {
            PublishOrgMessageActivity.a0(PublishOrgMessageActivity.this).g();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33486a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33486a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33486a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33486a.invoke(obj);
        }
    }

    public static final /* synthetic */ PublishOrgMessageVM a0(PublishOrgMessageActivity publishOrgMessageActivity) {
        return publishOrgMessageActivity.getMViewModel();
    }

    public static final void c0(PublishOrgMessageActivity publishOrgMessageActivity, View view) {
        Intrinsics.checkNotNullParameter(publishOrgMessageActivity, "this$0");
        publishOrgMessageActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().m().observe(this, new c(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                if (num != null && num.intValue() == 10100) {
                    ri1 ri1Var = ri1.f19330a;
                    PublishOrgMessageActivity publishOrgMessageActivity = this.this$0;
                    ri1Var.b(publishOrgMessageActivity, PublishOrgMessageActivity.a0(publishOrgMessageActivity).getChannelNo(), 1);
                    a.f(MyOrganizeActivity.class);
                } else {
                    this.this$0.setResult(-1);
                }
                this.this$0.finish();
            }
        }));
    }

    public final void b0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().o().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.l37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishOrgMessageActivity.c0(this.f42988a, view);
            }
        }).setTitleName(getString(R.string.channel_publish_organization_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    public final void d0() {
        getMBinding().f33124a.initPicker(this, 5, getString(R.string.channel_publish_organization_pic_hint), UploadFileType.UPLOAD_CHANNEL_AD);
        getMBinding().f33124a.setCallback(new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_publish_org_message;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        PublishOrgMessageVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("channelNo");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.q(stringExtra);
        getMViewModel().n().setValue(getIntent().getParcelableExtra("organizeBean"));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getWindow().getDecorView().setBackgroundColor(-1);
        super.initView();
        b0();
        d0();
    }
}
