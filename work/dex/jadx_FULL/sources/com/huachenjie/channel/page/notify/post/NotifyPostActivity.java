package com.huachenjie.channel.page.notify.post;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityNotifyPostBinding;
import com.huachenjie.channel.page.notify.post.NotifyPostActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.zj.adlib.tk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002R*\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u00100\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/channel/page/notify/post/NotifyPostActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityNotifyPostBinding;", "Lcom/huachenjie/channel/page/notify/post/NotifyPostVM;", "", "", "", "V", "getLayoutResID", "", "initView", "d0", "c0", "", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Landroidx/databinding/ViewDataBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "a", "[Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "fragmentArray", "b", "Lkotlin/Lazy;", "b0", "()I", "selectIndex", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyPostActivity extends BaseMVVMActivity<ChannelActivityNotifyPostBinding, NotifyPostVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "selectIndex";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseStateRequestModel>[] fragmentArray = {new NotifyPostLikeFragment(), new NotifyPostCommentFragment()};

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy selectIndex = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.notify.post.NotifyPostActivity$selectIndex$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m304invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("selectIndex", 0));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.post.NotifyPostActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/notify/post/NotifyPostActivity$a;", "", "Landroid/content/Context;", "context", "", "selectIndex", "", "a", "", "KEY_INDEX", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int selectIndex) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) NotifyPostActivity.class);
            intent.putExtra("selectIndex", selectIndex);
            context.startActivity(intent);
        }
    }

    public static final void e0(NotifyPostActivity notifyPostActivity, View view) {
        Intrinsics.checkNotNullParameter(notifyPostActivity, "this$0");
        notifyPostActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final int b0() {
        return ((Number) this.selectIndex.getValue()).intValue();
    }

    public final void c0() {
        getMBinding().f33103a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.channel.page.notify.post.NotifyPostActivity$initTab$1
            {
                super(this.f33509a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return this.f33509a.fragmentArray[position];
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f33509a.fragmentArray.length;
            }
        });
        String[] stringArray = getResources().getStringArray(R.array.channel_post_tab);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.channel_post_tab)");
        SelectBoldTabLayout selectBoldTabLayout = getMBinding().f7620a;
        ViewPager2 viewPager2 = getMBinding().f33103a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        selectBoldTabLayout.attachViewPager(viewPager2, stringArray);
        getMBinding().f33103a.setOffscreenPageLimit(this.fragmentArray.length);
        getMBinding().f33103a.setCurrentItem(b0());
    }

    public final void d0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_post_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.o36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyPostActivity.e0(this.f43657a, view);
            }
        }).setShowDivider(true));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_notify_post;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(-1);
        d0();
        c0();
    }
}
