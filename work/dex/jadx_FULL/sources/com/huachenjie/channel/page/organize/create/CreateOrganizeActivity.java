package com.huachenjie.channel.page.organize.create;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.basic.api.RequestPermission;
import com.gyf.immersionbar.e;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeCreateBinding;
import com.huachenjie.channel.page.organize.create.CreateOrganizeActivity;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Function;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u000fB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/page/organize/create/CreateOrganizeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeCreateBinding;", "Lcom/huachenjie/channel/page/organize/create/CreateOrganizeVM;", "", "getLayoutResID", "", "", "V", "", "initView", "S", "W", "f0", "", "b", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/bean/OrganizeBean;", "c", "d0", "()Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateOrganizeActivity extends BaseMVVMActivity<ChannelActivityOrganizeCreateBinding, CreateOrganizeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "OrganizeInfo";

    @NotNull
    public static final String y = "result";

    @NotNull
    public static final String z = "finish";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channelNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy bean = LazyKt.lazy(new Function0<OrganizeBean>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$bean$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OrganizeBean m307invoke() {
            return (OrganizeBean) this.this$0.getIntent().getParcelableExtra("OrganizeInfo");
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/organize/create/CreateOrganizeActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/channel/page/organize/create/CreateOrganizeActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (CreateOrganizeActivity.this.d0() == null) {
                CreateOrganizeVM createOrganizeVMC0 = CreateOrganizeActivity.c0(CreateOrganizeActivity.this);
                String strE0 = CreateOrganizeActivity.this.e0();
                Intrinsics.checkNotNullExpressionValue(strE0, "channelNo");
                createOrganizeVMC0.k(strE0, null);
                return;
            }
            CreateOrganizeVM createOrganizeVMC1 = CreateOrganizeActivity.c0(CreateOrganizeActivity.this);
            String strE1 = CreateOrganizeActivity.this.e0();
            Intrinsics.checkNotNullExpressionValue(strE1, "channelNo");
            OrganizeBean organizeBeanD0 = CreateOrganizeActivity.this.d0();
            Intrinsics.checkNotNull(organizeBeanD0);
            createOrganizeVMC1.k(strE1, organizeBeanD0.getClubCode());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/organize/create/CreateOrganizeActivity$b;", "", "Landroid/app/Activity;", "context", "", RequestPermission.REQUEST_CODE, "", "channelNo", "Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "CHANNEL_NO", "Ljava/lang/String;", "FINISH", "ORGANIZE_INFO", com.alipay.android.phone.mobilesdk.socketcraft.e.c.j, "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity context, int requestCode, @NotNull String channelNo, @Nullable OrganizeBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) CreateOrganizeActivity.class);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra("OrganizeInfo", bean);
            context.startActivityForResult(intent, requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/channel/page/organize/create/CreateOrganizeActivity$c", "Lcom/huachenjie/base/widget/image_pick/ImagePickView$ImagePickCallback;", "", RVParams.LONG_SHOW_LOADING, "b", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", GoodsSpecificationPreviewActivity.z, "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ImagePickView.ImagePickCallback {
        public c() {
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void a(@Nullable List<ImagePickBean> list) {
            CreateOrganizeActivity.c0(CreateOrganizeActivity.this).o().setValue(list);
            CreateOrganizeActivity.c0(CreateOrganizeActivity.this).j();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void b() {
            CreateOrganizeActivity.c0(CreateOrganizeActivity.this).c();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void showLoading() {
            CreateOrganizeActivity.c0(CreateOrganizeActivity.this).g();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33518a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33518a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33518a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33518a.invoke(obj);
        }
    }

    public static final /* synthetic */ CreateOrganizeVM c0(CreateOrganizeActivity createOrganizeActivity) {
        return createOrganizeActivity.getMViewModel();
    }

    public static final void g0(CreateOrganizeActivity createOrganizeActivity, View view) {
        Intrinsics.checkNotNullParameter(createOrganizeActivity, "this$0");
        createOrganizeActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().r().observe(this, new d(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateOrganizeActivity.c0(this.this$0).j();
            }
        }));
        getMViewModel().m().observe(this, new d(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateOrganizeActivity.c0(this.this$0).j();
            }
        }));
        getMViewModel().p().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    Intent intent = new Intent();
                    intent.putExtra("result", true);
                    this.this$0.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
        getMViewModel().q().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ri1 ri1Var = ri1.f19330a;
                    CreateOrganizeActivity createOrganizeActivity = this.this$0;
                    String strE0 = createOrganizeActivity.e0();
                    Intrinsics.checkNotNullExpressionValue(strE0, "channelNo");
                    ri1Var.b(createOrganizeActivity, strE0, 1);
                    Intent intent = new Intent();
                    intent.putExtra("finish", true);
                    this.this$0.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final OrganizeBean d0() {
        return (OrganizeBean) this.bean.getValue();
    }

    public final String e0() {
        return (String) this.channelNo.getValue();
    }

    public final void f0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.lx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateOrganizeActivity.g0(this.f43178a, view);
            }
        }).setTitleName(d0() == null ? "创建组织" : "编辑").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize_create;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        f0();
        getMViewModel().s().setValue(d0() == null ? "创建组织" : "保  存");
        ImagePickView imagePickView = getMBinding().f7637a;
        if (imagePickView != null) {
            imagePickView.initPicker(this, 1, "上传封面", UploadFileType.UPLOAD_CHANNEL_AD);
        }
        ImagePickView imagePickView2 = getMBinding().f7637a;
        if (imagePickView2 != null) {
            imagePickView2.setCallback(new c());
        }
        OrganizeBean organizeBeanD0 = d0();
        if (organizeBeanD0 != null) {
            ImagePickBean imagePickBean = new ImagePickBean(1);
            imagePickBean.setUrl(organizeBeanD0.getCoverUrl());
            imagePickBean.setLocalPath(organizeBeanD0.getCoverUrl());
            getMBinding().f7637a.addData(imagePickBean);
            getMViewModel().r().setValue(organizeBeanD0.getClubName());
            getMViewModel().m().setValue(organizeBeanD0.getClubDescription());
        }
    }
}
