package com.huachenjie.channel.page.advertise;

import android.content.Context;
import android.content.Intent;
import android.util.ArrayMap;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.triver.basic.api.RequestPermission;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.databinding.ChannelActivityAdvertiseBinding;
import com.huachenjie.channel.page.advertise.AdvertiseActivity;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/huachenjie/channel/page/advertise/AdvertiseActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityAdvertiseBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "getLayoutResID", "", "", "V", "", "initView", "S", "Lcom/huachenjie/channel/bean/AdvertiseBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "j0", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "position", "i0", "f0", "e0", "K", "I", "REQUEST_CODE", "", "b", "Lkotlin/Lazy;", "d0", "()Ljava/lang/String;", "channelNo", "", "Lcom/huachenjie/channel/page/advertise/AdvertiseFragment;", "c", "Ljava/util/List;", "fragmentArray", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AdvertiseActivity extends BaseMVVMActivity<ChannelActivityAdvertiseBinding, BaseTitleViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int REQUEST_CODE = 101;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.advertise.AdvertiseActivity$channelNo$2
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
    public List<AdvertiseFragment> fragmentArray = new ArrayList();

    /* JADX INFO: renamed from: com.huachenjie.channel.page.advertise.AdvertiseActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/advertise/AdvertiseActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "", "a", "CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) AdvertiseActivity.class);
            intent.putExtra("channelNo", channelNo);
            context.startActivity(intent);
        }
    }

    public static final void g0(AdvertiseActivity advertiseActivity, View view) {
        Intrinsics.checkNotNullParameter(advertiseActivity, "this$0");
        advertiseActivity.finish();
    }

    public static final void h0(AdvertiseActivity advertiseActivity, View view) {
        Intrinsics.checkNotNullParameter(advertiseActivity, "this$0");
        BaseViewModelExtKt.b(advertiseActivity.getMViewModel(), true, false, null, null, new AdvertiseActivity$initTitle$titleBean$2$1(advertiseActivity, null), 14, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(Integer.valueOf(tk0.p0), getMViewModel());
        return arrayMap;
    }

    public final String d0() {
        return (String) this.channelNo.getValue();
    }

    public final void e0() {
        ChannelActivityAdvertiseBinding mBinding = getMBinding();
        if (mBinding != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
            mBinding.f33022a.setAdapter(viewPagerAdapter);
            List<String> listListOf = CollectionsKt.listOf(new String[]{"进行中", "未发布", "已结束"});
            AdvertiseFragment.Companion companion = AdvertiseFragment.INSTANCE;
            String strD0 = d0();
            Intrinsics.checkNotNullExpressionValue(strD0, "channelNo");
            String strD1 = d0();
            Intrinsics.checkNotNullExpressionValue(strD1, "channelNo");
            String strD2 = d0();
            Intrinsics.checkNotNullExpressionValue(strD2, "channelNo");
            this.fragmentArray = CollectionsKt.mutableListOf(new AdvertiseFragment[]{companion.a(strD0, 4), companion.a(strD1, 5), companion.a(strD2, 6)});
            mBinding.f33022a.setOffscreenPageLimit(listListOf.size());
            viewPagerAdapter.a(listListOf, this.fragmentArray);
            mBinding.f7375a.setViewPager(mBinding.f33022a, listListOf);
        }
    }

    public final void f0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.e20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertiseActivity.g0(this.f41326a, view);
            }
        }).setTitleName("频道广告").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true).setShowRightIcon(true).setRightIconResId(R.drawable.channel_ic_advertise_add).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.f20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertiseActivity.h0(this.f41576a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_advertise;
    }

    public final void i0(int position) {
        boolean z = false;
        if (position >= 0 && position < this.fragmentArray.size()) {
            z = true;
        }
        if (z && this.fragmentArray.get(position).isAdded()) {
            this.fragmentArray.get(position).refreshList();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        f0();
        e0();
    }

    public final void j0(@NotNull AdvertiseBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        CreateAdvertiseActivity.Companion companion = CreateAdvertiseActivity.INSTANCE;
        int i = this.REQUEST_CODE;
        String strD0 = d0();
        Intrinsics.checkNotNullExpressionValue(strD0, "channelNo");
        companion.a(this, i, strD0, bean);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.REQUEST_CODE && resultCode == -1) {
            if (!(data != null && data.getBooleanExtra("result", false))) {
                if (data != null && data.getBooleanExtra("finish", false)) {
                    finish();
                }
            } else {
                ChannelActivityAdvertiseBinding mBinding = getMBinding();
                ViewPager viewPager = mBinding != null ? mBinding.f33022a : null;
                if (viewPager != null) {
                    viewPager.setCurrentItem(1);
                }
                i0(1);
            }
        }
    }
}
