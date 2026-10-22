package com.huachenjie.works.page.channel.list;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChannelTabBean;
import com.huachenjie.works.databinding.WorksActivityAllChannelBinding;
import com.huachenjie.works.page.channel.list.AllChannelActivity;
import com.igexin.push.g.o;
import com.zj.adlib.qk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0002J$\u0010\u0011\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/channel/list/AllChannelActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityAllChannelBinding;", "Lcom/huachenjie/works/page/channel/list/AllChannelVM;", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "c0", "", "", "titles", "channelCodeList", "b0", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAllChannelActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllChannelActivity.kt\ncom/huachenjie/works/page/channel/list/AllChannelActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n1855#2,2:71\n*S KotlinDebug\n*F\n+ 1 AllChannelActivity.kt\ncom/huachenjie/works/page/channel/list/AllChannelActivity\n*L\n61#1:71,2\n*E\n"})
public final class AllChannelActivity extends BaseMVVMActivity<WorksActivityAllChannelBinding, AllChannelVM> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37238a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37238a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37238a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37238a.invoke(obj);
        }
    }

    public static final void d0(AllChannelActivity allChannelActivity, View view) {
        Intrinsics.checkNotNullParameter(allChannelActivity, "this$0");
        allChannelActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, AllChannelVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().i().observe(this, new a(new Function1<List<? extends ChannelTabBean>, Unit>() { // from class: com.huachenjie.works.page.channel.list.AllChannelActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ChannelTabBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ChannelTabBean> list) {
                if (list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                for (ChannelTabBean channelTabBean : list) {
                    arrayList.add(channelTabBean.getClassificationName());
                    String channelClassificationNo = channelTabBean.getChannelClassificationNo();
                    if (channelClassificationNo == null) {
                        channelClassificationNo = "";
                    }
                    arrayList2.add(channelClassificationNo);
                }
                this.this$0.b0(arrayList, arrayList2);
            }
        }));
    }

    public final void b0(List<String> titles, List<String> channelCodeList) {
        WorksActivityAllChannelBinding mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
        mBinding.f36767a.setAdapter(viewPagerAdapter);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = channelCodeList.iterator();
        while (it.hasNext()) {
            arrayList.add(AllChannelListFragment.INSTANCE.a((String) it.next()));
        }
        mBinding.f36767a.setOffscreenPageLimit(titles.size());
        viewPagerAdapter.a(titles, arrayList);
        mBinding.f13811a.setViewPager(mBinding.f36767a, titles);
        mBinding.f13811a.updateTabSelection(0);
    }

    public final void c0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ = getMViewModel().j();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName("全部频道");
        int i = R.color.color_2C3E50;
        BindingTitleBean showDivider = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.k40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllChannelActivity.d0(this.f42740a, view);
            }
        }).setShowDivider(true);
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataJ.setValue(showDivider.setStatusBarHeight(value.intValue()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_all_channel;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        c0();
    }
}
