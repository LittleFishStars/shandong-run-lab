package com.huachenjie.channel.page.all_channel;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.JoinAllChannelEntity;
import com.huachenjie.channel.bean.JoinChannelCategoryBean;
import com.huachenjie.channel.bean.JoinChannelCategoryListBean;
import com.huachenjie.channel.databinding.ChannelActivityJoinAllChannelBinding;
import com.huachenjie.channel.page.all_channel.JoinAllChannelActivity;
import com.huachenjie.channel.page.join_channel.JoinChannelActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.igexin.push.g.o;
import com.zj.adlib.tk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/channel/page/all_channel/JoinAllChannelActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityJoinAllChannelBinding;", "Lcom/huachenjie/channel/page/all_channel/JoinAllChannelVM;", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/channel/bean/JoinAllChannelEntity;", "h0", "pageEntity", "i0", "e0", "Lcom/huachenjie/channel/bean/JoinChannelCategoryListBean;", "listBean", "d0", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nJoinAllChannelActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JoinAllChannelActivity.kt\ncom/huachenjie/channel/page/all_channel/JoinAllChannelActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n1549#2:99\n1620#2,3:100\n*S KotlinDebug\n*F\n+ 1 JoinAllChannelActivity.kt\ncom/huachenjie/channel/page/all_channel/JoinAllChannelActivity\n*L\n76#1:99\n76#1:100,3\n*E\n"})
public final class JoinAllChannelActivity extends BaseMVVMActivity<ChannelActivityJoinAllChannelBinding, JoinAllChannelVM> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33366a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33366a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33366a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33366a.invoke(obj);
        }
    }

    public static final void f0(JoinAllChannelActivity joinAllChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(joinAllChannelActivity, "this$0");
        joinAllChannelActivity.finish();
    }

    public static final void g0(JoinAllChannelActivity joinAllChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(joinAllChannelActivity, "this$0");
        joinAllChannelActivity.startActivity(new Intent(joinAllChannelActivity, (Class<?>) JoinChannelActivity.class));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, JoinAllChannelVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().k().observe(this, new a(new Function1<JoinChannelCategoryListBean, Unit>() { // from class: com.huachenjie.channel.page.all_channel.JoinAllChannelActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JoinChannelCategoryListBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(JoinChannelCategoryListBean joinChannelCategoryListBean) {
                JoinAllChannelActivity joinAllChannelActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(joinChannelCategoryListBean, o.f);
                joinAllChannelActivity.d0(joinChannelCategoryListBean);
            }
        }));
    }

    public final void d0(final JoinChannelCategoryListBean listBean) {
        ViewPager2 viewPager2 = getMBinding().f33084a;
        viewPager2.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.channel.page.all_channel.JoinAllChannelActivity$initTab$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.f8270a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                String categoryNo;
                List<JoinChannelCategoryBean> list;
                JoinChannelCategoryBean joinChannelCategoryBean;
                JoinChannelCategoryListBean value = this.f8270a.getMViewModel().k().getValue();
                if (value == null || (list = value.getList()) == null || (joinChannelCategoryBean = list.get(position)) == null || (categoryNo = joinChannelCategoryBean.getCategoryNo()) == null) {
                    categoryNo = "";
                }
                return JoinAllChannelFragment.Companion.a(categoryNo);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return listBean.getList().size();
            }
        });
        SelectBoldTabLayout selectBoldTabLayout = getMBinding().f7560a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPager");
        List<JoinChannelCategoryBean> list = listBean.getList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JoinChannelCategoryBean) it.next()).getCategoryName());
        }
        selectBoldTabLayout.attachViewPager(viewPager2, arrayList);
    }

    public final void e0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(getString(R.string.channel_join_all_channel_title));
        int i = R.color.color_2C3E50;
        BindingTitleBean rightSubIconClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.mo4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinAllChannelActivity.f0(this.f43348a, view);
            }
        }).setShowDivider(true).setShowRightSubIcon(true).setRightSubIconResId(R.drawable.common_ic_search_black).setRightSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.no4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinAllChannelActivity.g0(this.f43572a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(rightSubIconClick.setStatusBarHeight(value.intValue()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_join_all_channel;
    }

    @Nullable
    public final JoinAllChannelEntity h0(@NotNull String categoryNo) {
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
        return getMViewModel().j().get(categoryNo);
    }

    public final void i0(@NotNull String categoryNo, @NotNull JoinAllChannelEntity pageEntity) {
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
        Intrinsics.checkNotNullParameter(pageEntity, "pageEntity");
        getMViewModel().j().put(categoryNo, pageEntity);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().l();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        e0();
    }
}
