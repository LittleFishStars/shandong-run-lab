package com.huachenjie.mall.page.video_enter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.VideoEnterTabBean;
import com.huachenjie.mall.databinding.MallActivityVideoEnterBinding;
import com.huachenjie.mall.page.video_enter.VideoEnterActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.zn1;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002R\u001b\u0010\u0018\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR1\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020 \u0012\u0006\b\u0001\u0012\u00020!0\u001f0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u001c¨\u0006("}, d2 = {"Lcom/huachenjie/mall/page/video_enter/VideoEnterActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityVideoEnterBinding;", "Lcom/huachenjie/mall/page/video_enter/VideoEnterVM;", "", "", "", "V", "getLayoutResID", "", "initView", "i0", "g0", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lcom/huachenjie/mall/bean/VideoEnterTabBean;", "tabBean", "", "defaultSelect", "k0", "b", "Lkotlin/Lazy;", "getType", "()I", "type", "", "c", "f0", "()Ljava/util/List;", "tabList", "", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Landroidx/databinding/ViewDataBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "d", "e0", "fragmentArray", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class VideoEnterActivity extends BaseMVVMActivity<MallActivityVideoEnterBinding, VideoEnterVM> {
    public static final int K = 0;
    public static final int L = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "type";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.video_enter.VideoEnterActivity$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m584invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("type", 0));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy tabList = LazyKt.lazy(new Function0<List<? extends VideoEnterTabBean>>() { // from class: com.huachenjie.mall.page.video_enter.VideoEnterActivity$tabList$2
        {
            super(0);
        }

        @NotNull
        public final List<VideoEnterTabBean> invoke() {
            if (this.this$0.getType() == 0) {
                String string = this.this$0.getString(R.string.mall_video_enter_type1_tab1);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.mall_video_enter_type1_tab1)");
                String string2 = this.this$0.getString(R.string.mall_video_enter_type1_tab2);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.mall_video_enter_type1_tab2)");
                return CollectionsKt.listOf(new VideoEnterTabBean[]{new VideoEnterTabBean(string, R.drawable.mall_all_video_type1, R.drawable.mall_all_video_type1_select), new VideoEnterTabBean(string2, R.drawable.mall_purchased_video_type1, R.drawable.mall_purchased_video_type1_select)});
            }
            String string3 = this.this$0.getString(R.string.mall_video_enter_type2_tab1);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.mall_video_enter_type2_tab1)");
            String string4 = this.this$0.getString(R.string.mall_video_enter_type2_tab2);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.mall_video_enter_type2_tab2)");
            return CollectionsKt.listOf(new VideoEnterTabBean[]{new VideoEnterTabBean(string3, R.drawable.mall_all_video_type2, R.drawable.mall_all_video_type2_select), new VideoEnterTabBean(string4, R.drawable.mall_purchased_video_type2, R.drawable.mall_purchased_video_type2_select)});
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy fragmentArray = LazyKt.lazy(new Function0<List<BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseStateRequestModel>>>() { // from class: com.huachenjie.mall.page.video_enter.VideoEnterActivity$fragmentArray$2
        {
            super(0);
        }

        @NotNull
        public final List<BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseStateRequestModel>> invoke() {
            return CollectionsKt.mutableListOf(new BaseMVVMFragment[]{AllVideoGoodsFragment.Companion.a(this.this$0.getType()), PurchasedVideoGoodsFragment.Companion.a(this.this$0.getType())});
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mall.page.video_enter.VideoEnterActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/mall/page/video_enter/VideoEnterActivity$a;", "", "Landroid/content/Context;", "context", "", "type", "", "a", "", "KEY_TYPE", "Ljava/lang/String;", "TYPE_AI_KAN", "I", "TYPE_YU_QING", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) VideoEnterActivity.class);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/mall/page/video_enter/VideoEnterActivity$b", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            View customView;
            View customView2;
            ImageView imageView = null;
            TextView textView = (tab == null || (customView2 = tab.getCustomView()) == null) ? null : (TextView) customView2.findViewById(R.id.tv_name);
            if (textView != null) {
                textView.setTextColor(VideoEnterActivity.this.getResources().getColor(R.color.color_650aec));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            }
            if (tab != null && (customView = tab.getCustomView()) != null) {
                imageView = (ImageView) customView.findViewById(R.id.iv_icon);
            }
            VideoEnterTabBean videoEnterTabBean = (VideoEnterTabBean) CollectionsKt.getOrNull(VideoEnterActivity.this.f0(), tab != null ? tab.getPosition() : 0);
            if (videoEnterTabBean != null) {
                int selIcon = videoEnterTabBean.getSelIcon();
                if (imageView != null) {
                    imageView.setImageResource(selIcon);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            View customView;
            View customView2;
            ImageView imageView = null;
            TextView textView = (tab == null || (customView2 = tab.getCustomView()) == null) ? null : (TextView) customView2.findViewById(R.id.tv_name);
            if (textView != null) {
                textView.setTextColor(VideoEnterActivity.this.getResources().getColor(R.color.color_B3B3B3));
            }
            if (textView != null) {
                textView.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            }
            if (tab != null && (customView = tab.getCustomView()) != null) {
                imageView = (ImageView) customView.findViewById(R.id.iv_icon);
            }
            VideoEnterTabBean videoEnterTabBean = (VideoEnterTabBean) CollectionsKt.getOrNull(VideoEnterActivity.this.f0(), tab != null ? tab.getPosition() : 0);
            if (videoEnterTabBean != null) {
                int icon = videoEnterTabBean.getIcon();
                if (imageView != null) {
                    imageView.setImageResource(icon);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    public static final void h0(VideoEnterActivity videoEnterActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(videoEnterActivity, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        videoEnterActivity.k0(tab, videoEnterActivity.f0().get(i), i == 0);
    }

    public static final void j0(VideoEnterActivity videoEnterActivity, View view) {
        Intrinsics.checkNotNullParameter(videoEnterActivity, "this$0");
        videoEnterActivity.finish();
    }

    public static /* synthetic */ void l0(VideoEnterActivity videoEnterActivity, TabLayout.Tab tab, VideoEnterTabBean videoEnterTabBean, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        videoEnterActivity.k0(tab, videoEnterTabBean, z);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final List<BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseStateRequestModel>> e0() {
        return (List) this.fragmentArray.getValue();
    }

    public final List<VideoEnterTabBean> f0() {
        return (List) this.tabList.getValue();
    }

    public final void g0() {
        getMBinding().f34885a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.mall.page.video_enter.VideoEnterActivity$initTab$1
            {
                super(this.f35273a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) this.f35273a.e0().get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f35273a.e0().size();
            }
        });
        SelectBoldTabLayout.Companion companion = SelectBoldTabLayout.INSTANCE;
        ViewPager2 viewPager2 = getMBinding().f34885a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.vp");
        companion.desensitization(viewPager2);
        new TabLayoutMediator(getMBinding().f10474a, getMBinding().f34885a, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.zj.adlib.gn9
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                VideoEnterActivity.h0(this.f41942a, tab, i);
            }
        }).attach();
        getMBinding().f10474a.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        getMBinding().f10474a.selectTab(getMBinding().f10474a.getTabAt(0));
        getMBinding().f34885a.setCurrentItem(1);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_video_enter;
    }

    public final void i0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(getType() == 0 ? R.string.mall_video_enter_title1 : R.string.mall_video_enter_title2)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.fn9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoEnterActivity.j0(this.f41715a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.color_f5f5f5));
        super.initView();
        i0();
        g0();
    }

    public final void k0(TabLayout.Tab tab, VideoEnterTabBean tabBean, boolean defaultSelect) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_item_video_enter_tab, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        textView.setText(tabBean.getName());
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_icon);
        if (defaultSelect) {
            textView.setTextColor(getResources().getColor(R.color.color_650aec));
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            imageView.setImageResource(tabBean.getSelIcon());
        } else {
            imageView.setImageResource(tabBean.getIcon());
        }
        tab.setCustomView(viewInflate);
    }
}
