package com.huachenjie.channel.page.advertise.preview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.AdvertiseImageBean;
import com.huachenjie.channel.databinding.ChannelActivityAdvertisePreviewBinding;
import com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0002R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityAdvertisePreviewBinding;", "Lcom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseVM;", "", "getLayoutResID", "", "V", "", "initView", "S", "onResume", "onPause", "onDestroy", "b0", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "b", "Lkotlin/Lazy;", "a0", "()Lcom/huachenjie/channel/bean/AdvertiseBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPreviewAdvertiseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewAdvertiseActivity.kt\ncom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1549#2:106\n1620#2,3:107\n*S KotlinDebug\n*F\n+ 1 PreviewAdvertiseActivity.kt\ncom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseActivity\n*L\n51#1:106\n51#1:107,3\n*E\n"})
public final class PreviewAdvertiseActivity extends BaseMVVMActivity<ChannelActivityAdvertisePreviewBinding, PreviewAdvertiseVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "advertiseInfo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy bean = LazyKt.lazy(new Function0<AdvertiseBean>() { // from class: com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseActivity$bean$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AdvertiseBean m250invoke() {
            return (AdvertiseBean) this.this$0.getIntent().getParcelableExtra("advertiseInfo");
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/bean/AdvertiseBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "", "ADVERTISE_INFO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull AdvertiseBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            Intent intent = new Intent(context, (Class<?>) PreviewAdvertiseActivity.class);
            intent.putExtra("advertiseInfo", bean);
            context.startActivity(intent);
        }
    }

    public static final void c0(PreviewAdvertiseActivity previewAdvertiseActivity, View view) {
        Intrinsics.checkNotNullParameter(previewAdvertiseActivity, "this$0");
        previewAdvertiseActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, PreviewAdvertiseVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final AdvertiseBean a0() {
        return (AdvertiseBean) this.bean.getValue();
    }

    public final void b0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vx6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewAdvertiseActivity.c0(this.f45481a, view);
            }
        }).setTitleName("详情").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_advertise_preview;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        b0();
        AdvertiseBean advertiseBeanA0 = a0();
        if (advertiseBeanA0 != null) {
            MutableLiveData<List<CommonBannerBean>> mutableLiveDataK = getMViewModel().k();
            List<AdvertiseImageBean> imgList = advertiseBeanA0.getImgList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imgList, 10));
            for (AdvertiseImageBean advertiseImageBean : imgList) {
                arrayList.add(new CommonBannerBean(advertiseImageBean.getUrl(), advertiseImageBean.getWidth(), advertiseImageBean.getHeight(), false, 0.0f, 24, null));
            }
            mutableLiveDataK.setValue(arrayList);
            CommonBanner commonBanner = getMBinding().f7398a;
            Intrinsics.checkNotNullExpressionValue(commonBanner, "mBinding.banner");
            List<CommonBannerBean> value = getMViewModel().k().getValue();
            Intrinsics.checkNotNull(value);
            CommonBanner.setImageList$default(commonBanner, this, value, (CommonBannerConfig) null, 4, (Object) null);
            getMViewModel().j().setValue(advertiseBeanA0.getContent());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CommonBanner commonBanner;
        ChannelActivityAdvertisePreviewBinding mBinding = getMBinding();
        if (mBinding != null && (commonBanner = mBinding.f7398a) != null) {
            commonBanner.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        CommonBanner commonBanner;
        ChannelActivityAdvertisePreviewBinding mBinding = getMBinding();
        if (mBinding != null && (commonBanner = mBinding.f7398a) != null) {
            commonBanner.stop();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        CommonBanner commonBanner;
        super.onResume();
        ChannelActivityAdvertisePreviewBinding mBinding = getMBinding();
        if (mBinding == null || (commonBanner = mBinding.f7398a) == null) {
            return;
        }
        commonBanner.start();
    }
}
