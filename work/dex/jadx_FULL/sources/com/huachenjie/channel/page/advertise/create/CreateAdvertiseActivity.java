package com.huachenjie.channel.page.advertise.create;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.AdvertiseImageBean;
import com.huachenjie.channel.databinding.ChannelActivityAdvertiseCreateBinding;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.gm1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u000fB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityAdvertiseCreateBinding;", "Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseVM;", "", "getLayoutResID", "", "", "V", "", "initView", "S", "W", "g0", "", "b", "Lkotlin/Lazy;", "f0", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "c", "e0", "()Lcom/huachenjie/channel/bean/AdvertiseBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCreateAdvertiseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateAdvertiseActivity.kt\ncom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,195:1\n1549#2:196\n1620#2,3:197\n*S KotlinDebug\n*F\n+ 1 CreateAdvertiseActivity.kt\ncom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity\n*L\n113#1:196\n113#1:197,3\n*E\n"})
public final class CreateAdvertiseActivity extends BaseMVVMActivity<ChannelActivityAdvertiseCreateBinding, CreateAdvertiseVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "advertiseInfo";

    @NotNull
    public static final String y = "result";

    @NotNull
    public static final String z = "finish";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$channelNo$2
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
    public final Lazy bean = LazyKt.lazy(new Function0<AdvertiseBean>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$bean$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AdvertiseBean m248invoke() {
            return (AdvertiseBean) this.this$0.getIntent().getParcelableExtra("advertiseInfo");
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CharSequence charSequenceE = gm1.e();
            if (TextUtils.isEmpty(charSequenceE)) {
                return;
            }
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).s().setValue(charSequenceE.toString());
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (CreateAdvertiseActivity.this.e0() == null) {
                CreateAdvertiseVM createAdvertiseVMD0 = CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this);
                String strF0 = CreateAdvertiseActivity.this.f0();
                Intrinsics.checkNotNullExpressionValue(strF0, "channelNo");
                createAdvertiseVMD0.v(strF0, null);
                return;
            }
            CreateAdvertiseVM createAdvertiseVMD1 = CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this);
            String strF1 = CreateAdvertiseActivity.this.f0();
            Intrinsics.checkNotNullExpressionValue(strF1, "channelNo");
            AdvertiseBean advertiseBeanE0 = CreateAdvertiseActivity.this.e0();
            Intrinsics.checkNotNull(advertiseBeanE0);
            createAdvertiseVMD1.v(strF1, advertiseBeanE0.getChannelAdCode());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity$b;", "", "Landroid/app/Activity;", "context", "", RequestPermission.REQUEST_CODE, "", "channelNo", "Lcom/huachenjie/channel/bean/AdvertiseBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "ADVERTISE_INFO", "Ljava/lang/String;", "CHANNEL_NO", "FINISH", com.alipay.android.phone.mobilesdk.socketcraft.e.c.j, "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity context, int requestCode, @NotNull String channelNo, @Nullable AdvertiseBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) CreateAdvertiseActivity.class);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra("advertiseInfo", bean);
            context.startActivityForResult(intent, requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity$c", "Lcom/huachenjie/base/widget/image_pick/ImagePickView$ImagePickCallback;", "", RVParams.LONG_SHOW_LOADING, "b", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", GoodsSpecificationPreviewActivity.z, "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ImagePickView.ImagePickCallback {
        public c() {
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void a(@Nullable List<ImagePickBean> list) {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).n().setValue(list);
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).j();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void b() {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).c();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void showLoading() {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).g();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/channel/page/advertise/create/CreateAdvertiseActivity$d", "Lcom/huachenjie/base/widget/image_pick/ImagePickView$ImagePickCallback;", "", RVParams.LONG_SHOW_LOADING, "b", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", GoodsSpecificationPreviewActivity.z, "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements ImagePickView.ImagePickCallback {
        public d() {
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void a(@Nullable List<ImagePickBean> list) {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).q().setValue(list);
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).j();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void b() {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).c();
        }

        @Override // com.huachenjie.base.widget.image_pick.ImagePickView.ImagePickCallback
        public void showLoading() {
            CreateAdvertiseActivity.d0(CreateAdvertiseActivity.this).g();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33362a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33362a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33362a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33362a.invoke(obj);
        }
    }

    public static final /* synthetic */ CreateAdvertiseVM d0(CreateAdvertiseActivity createAdvertiseActivity) {
        return createAdvertiseActivity.getMViewModel();
    }

    public static final void h0(CreateAdvertiseActivity createAdvertiseActivity, View view) {
        Intrinsics.checkNotNullParameter(createAdvertiseActivity, "this$0");
        createAdvertiseActivity.finish();
    }

    public static final void i0(CreateAdvertiseActivity createAdvertiseActivity, CompoundButton compoundButton, boolean z2) {
        Intrinsics.checkNotNullParameter(createAdvertiseActivity, "this$0");
        createAdvertiseActivity.getMViewModel().u().setValue(Boolean.valueOf(z2));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        com.gyf.immersionbar.e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().u().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                CreateAdvertiseActivity.d0(this.this$0).j();
            }
        }));
        getMViewModel().l().observe(this, new e(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateAdvertiseActivity.d0(this.this$0).j();
            }
        }));
        getMViewModel().s().observe(this, new e(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateAdvertiseActivity.d0(this.this$0).j();
            }
        }));
        getMViewModel().o().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$initDataObserve$4
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
        getMViewModel().p().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity$initDataObserve$5
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
                    CreateAdvertiseActivity createAdvertiseActivity = this.this$0;
                    String strF0 = createAdvertiseActivity.f0();
                    Intrinsics.checkNotNullExpressionValue(strF0, "channelNo");
                    ri1Var.b(createAdvertiseActivity, strF0, 1);
                    Intent intent = new Intent();
                    intent.putExtra("finish", true);
                    this.this$0.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final AdvertiseBean e0() {
        return (AdvertiseBean) this.bean.getValue();
    }

    public final String f0() {
        return (String) this.channelNo.getValue();
    }

    public final void g0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ax1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateAdvertiseActivity.h0(this.f40631a, view);
            }
        }).setTitleName(e0() == null ? "创建广告" : "编辑广告").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_advertise_create;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        g0();
        getMViewModel().t().setValue(e0() == null ? "发  布" : "保  存");
        ImagePickView imagePickView = getMBinding().f7382a;
        if (imagePickView != null) {
            imagePickView.initPicker(this, 1, "上传封面", UploadFileType.UPLOAD_CHANNEL_AD);
        }
        ImagePickView imagePickView2 = getMBinding().f7382a;
        if (imagePickView2 != null) {
            imagePickView2.setCallback(new c());
        }
        MutableLiveData<Boolean> mutableLiveDataU = getMViewModel().u();
        AdvertiseBean advertiseBeanE0 = e0();
        mutableLiveDataU.setValue(advertiseBeanE0 != null ? Boolean.valueOf(advertiseBeanE0.getLinkType()) : Boolean.FALSE);
        SwitchCompat switchCompat = getMBinding().f7381a;
        Boolean value = getMViewModel().u().getValue();
        Intrinsics.checkNotNull(value);
        switchCompat.setChecked(value.booleanValue());
        getMBinding().f7381a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.zw1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CreateAdvertiseActivity.i0(this.f46356a, compoundButton, z2);
            }
        });
        getMBinding().f7386b.initPicker(this, 5, "上传图片", UploadFileType.UPLOAD_CHANNEL_AD);
        getMBinding().f7386b.setCallback(new d());
        AdvertiseBean advertiseBeanE1 = e0();
        if (advertiseBeanE1 != null) {
            ImagePickBean imagePickBean = new ImagePickBean(1);
            imagePickBean.setUrl(advertiseBeanE1.getCoverUrl());
            imagePickBean.setLocalPath(advertiseBeanE1.getCoverUrl());
            getMBinding().f7382a.addData(imagePickBean);
            Boolean value2 = getMViewModel().u().getValue();
            Intrinsics.checkNotNull(value2);
            if (value2.booleanValue()) {
                getMViewModel().s().setValue(advertiseBeanE1.getLinkUrl());
                return;
            }
            getMViewModel().l().setValue(advertiseBeanE1.getContent());
            List<AdvertiseImageBean> imgList = advertiseBeanE1.getImgList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imgList, 10));
            for (AdvertiseImageBean advertiseImageBean : imgList) {
                arrayList.add(new ImagePickBean(1, advertiseImageBean.getUrl(), advertiseImageBean.getWidth(), advertiseImageBean.getHeight()));
            }
            getMBinding().f7386b.setList(arrayList);
        }
    }
}
