package com.huachenjie.works.page.publish.menu.channel;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.adapter.publish.PubWorkMenuChannelAdapter;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.channel.PubWorkMenuChannelFragment;
import com.zj.adlib.y57;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R2\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/channel/PubWorkMenuChannelFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/works/page/publish/menu/channel/PubWorkMenuChannelModel;", "", "initAdapter", "initSelectedChannel", "initTypeChangeView", "", "checkedId", "setCurrentStatus", "restoreDefaultList", "initView", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "entityValue", "saveExtraListValue", "updateAdapterSuccess", "", "content", "searchContentChanged", "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "selectCallback", "Lkotlin/jvm/functions/Function1;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/LinearLayout;", "llSelected$delegate", "Lkotlin/Lazy;", "getLlSelected", "()Landroid/widget/LinearLayout;", "llSelected", "Landroid/widget/RadioGroup;", "rgMenu$delegate", "getRgMenu", "()Landroid/widget/RadioGroup;", "rgMenu", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPubWorkMenuChannelFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMenuChannelFragment.kt\ncom/huachenjie/works/page/publish/menu/channel/PubWorkMenuChannelFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,181:1\n1#2:182\n*E\n"})
public final class PubWorkMenuChannelFragment extends BasePubWorkMenuFragment<PubWorkMenuChannelModel> {

    @NotNull
    private static final String BEAN_KEY = "bean";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: llSelected$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy llSelected = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.huachenjie.works.page.publish.menu.channel.PubWorkMenuChannelFragment$llSelected$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LinearLayout m952invoke() {
            return (LinearLayout) this.this$0.insertViewToPlaceholder1(R.layout.works_view_pub_work_menu_channel_selected);
        }
    });

    /* JADX INFO: renamed from: rgMenu$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rgMenu = LazyKt.lazy(new Function0<RadioGroup>() { // from class: com.huachenjie.works.page.publish.menu.channel.PubWorkMenuChannelFragment$rgMenu$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RadioGroup m953invoke() {
            return (RadioGroup) this.this$0.insertViewToPlaceholder2(R.layout.works_view_pub_work_menu_channel_selector);
        }
    });

    @Nullable
    private Function1<? super PubWorkChannelBean, Unit> selectCallback;

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.menu.channel.PubWorkMenuChannelFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/channel/PubWorkMenuChannelFragment$a;", "", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "bean", "Lcom/huachenjie/works/page/publish/menu/channel/PubWorkMenuChannelFragment;", "a", "", "BEAN_KEY", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PubWorkMenuChannelFragment a(@Nullable PubWorkChannelBean bean) {
            PubWorkMenuChannelFragment pubWorkMenuChannelFragment = new PubWorkMenuChannelFragment();
            if (bean == null) {
                return pubWorkMenuChannelFragment;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("bean", bean);
            pubWorkMenuChannelFragment.setArguments(bundle);
            return pubWorkMenuChannelFragment;
        }
    }

    private final LinearLayout getLlSelected() {
        return (LinearLayout) this.llSelected.getValue();
    }

    private final RadioGroup getRgMenu() {
        return (RadioGroup) this.rgMenu.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB = ((PubWorkMenuChannelModel) getMViewModel()).B();
        final PubWorkMenuChannelAdapter pubWorkMenuChannelAdapter = new PubWorkMenuChannelAdapter();
        y57.d(pubWorkMenuChannelAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.s27
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PubWorkMenuChannelFragment.initAdapter$lambda$3$lambda$1(this.f19502a, pubWorkMenuChannelAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        pubWorkMenuChannelAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.t27
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PubWorkMenuChannelFragment.initAdapter$lambda$3$lambda$2(this.f44834a);
            }
        });
        mutableLiveDataB.setValue(pubWorkMenuChannelAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(PubWorkMenuChannelFragment pubWorkMenuChannelFragment, PubWorkMenuChannelAdapter pubWorkMenuChannelAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pubWorkMenuChannelFragment, "this$0");
        Intrinsics.checkNotNullParameter(pubWorkMenuChannelAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Function1<? super PubWorkChannelBean, Unit> function1 = pubWorkMenuChannelFragment.selectCallback;
        if (function1 != null) {
            function1.invoke(pubWorkMenuChannelAdapter.getData().get(i));
        }
        pubWorkMenuChannelFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$3$lambda$2(PubWorkMenuChannelFragment pubWorkMenuChannelFragment) {
        Intrinsics.checkNotNullParameter(pubWorkMenuChannelFragment, "this$0");
        ((PubWorkMenuChannelModel) pubWorkMenuChannelFragment.getMViewModel()).w(false);
    }

    private final void initSelectedChannel() {
        PubWorkChannelBean pubWorkChannelBean;
        Bundle arguments = getArguments();
        if (arguments == null || (pubWorkChannelBean = (PubWorkChannelBean) arguments.getParcelable("bean")) == null) {
            return;
        }
        ((TextView) getLlSelected().findViewById(R.id.tv_selected)).setText(getString(R.string.works_publish_work_works_selected, pubWorkChannelBean.getTitle()));
        ((TextView) getLlSelected().findViewById(R.id.bt_clear)).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.q27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PubWorkMenuChannelFragment.initSelectedChannel$lambda$5$lambda$4(this.f44111a, view);
            }
        });
        getRgMenu().setPadding(0, 0, 0, getRgMenu().getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSelectedChannel$lambda$5$lambda$4(PubWorkMenuChannelFragment pubWorkMenuChannelFragment, View view) {
        Intrinsics.checkNotNullParameter(pubWorkMenuChannelFragment, "this$0");
        Function1<? super PubWorkChannelBean, Unit> function1 = pubWorkMenuChannelFragment.selectCallback;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
        pubWorkMenuChannelFragment.getLlSelected().setVisibility(8);
    }

    private final void initTypeChangeView() {
        getRgMenu().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.zj.adlib.r27
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                PubWorkMenuChannelFragment.initTypeChangeView$lambda$6(this.f44349a, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTypeChangeView$lambda$6(PubWorkMenuChannelFragment pubWorkMenuChannelFragment, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(pubWorkMenuChannelFragment, "this$0");
        pubWorkMenuChannelFragment.setCurrentStatus(i);
        pubWorkMenuChannelFragment.restoreDefaultList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void restoreDefaultList() {
        RecyclerView recyclerView;
        Integer value = ((PubWorkMenuChannelModel) getMViewModel()).C().getValue();
        PubWorksMenuPageEntity<PubWorkChannelBean> value2 = (value != null && value.intValue() == 1) ? ((PubWorkMenuChannelModel) getMViewModel()).J().getValue() : ((PubWorkMenuChannelModel) getMViewModel()).K().getValue();
        if (value2 == null) {
            ((PubWorkMenuChannelModel) getMViewModel()).y();
            return;
        }
        BasePubWorkMenuAdapter<?, ?> value3 = ((PubWorkMenuChannelModel) getMViewModel()).B().getValue();
        if (value3 != null) {
            ((PubWorkMenuChannelAdapter) value3).setList(value2.getList());
            WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
            if (worksFragmentPubWorkMenuBinding != null && (recyclerView = worksFragmentPubWorkMenuBinding.f14275a) != null) {
                recyclerView.scrollToPosition(0);
            }
            setListLoadMore(value2.getHasNext());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCurrentStatus(int checkedId) {
        ((PubWorkMenuChannelModel) getMViewModel()).C().setValue(checkedId == R.id.rb_hot ? 1 : 2);
    }

    @Nullable
    public final Function1<PubWorkChannelBean, Unit> getSelectCallback() {
        return this.selectCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((PubWorkMenuChannelModel) getMViewModel()).D().setValue(getString(R.string.works_publish_work_menu_channel));
        ((PubWorkMenuChannelModel) getMViewModel()).G().setValue(Integer.valueOf(R.drawable.works_ic_publish_channel));
        ((PubWorkMenuChannelModel) getMViewModel()).F().setValue(getString(R.string.works_publish_work_menu_works_hint));
        initAdapter();
        initSelectedChannel();
        initTypeChangeView();
        showLoading();
        ((PubWorkMenuChannelModel) getMViewModel()).C().setValue(1);
        ((PubWorkMenuChannelModel) getMViewModel()).y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void saveExtraListValue(@NotNull PubWorksMenuPageEntity<?> entityValue) {
        PubWorksMenuPageEntity<PubWorkChannelBean> value;
        Intrinsics.checkNotNullParameter(entityValue, "entityValue");
        if (entityValue.getPageNum() == 1) {
            int type = entityValue.getType();
            if (type == 1) {
                ((PubWorkMenuChannelModel) getMViewModel()).J().setValue(entityValue);
            } else if (type == 2) {
                ((PubWorkMenuChannelModel) getMViewModel()).K().setValue(entityValue);
            }
            hideLoading();
            return;
        }
        int type2 = entityValue.getType();
        if (type2 != 1) {
            if (type2 == 2 && (value = ((PubWorkMenuChannelModel) getMViewModel()).K().getValue()) != null) {
                List list = value.getList();
                List list2 = entityValue.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "pageEntity.list");
                list.addAll(list2);
                value.setPageNum(entityValue.getPageNum());
                value.setHasNext(entityValue.getHasNext());
                value.setRefreshTime(entityValue.getRefreshTime());
                return;
            }
            return;
        }
        PubWorksMenuPageEntity<PubWorkChannelBean> value2 = ((PubWorkMenuChannelModel) getMViewModel()).J().getValue();
        if (value2 != null) {
            List list3 = value2.getList();
            List list4 = entityValue.getList();
            Intrinsics.checkNotNullExpressionValue(list4, "pageEntity.list");
            list3.addAll(list4);
            value2.setPageNum(entityValue.getPageNum());
            value2.setHasNext(entityValue.getHasNext());
            value2.setRefreshTime(entityValue.getRefreshTime());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void searchContentChanged(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!(content.length() == 0)) {
            ((PubWorkMenuChannelModel) getMViewModel()).C().setValue(3);
            ((PubWorkMenuChannelModel) getMViewModel()).y();
        } else {
            getRgMenu().setVisibility(0);
            setCurrentStatus(getRgMenu().getCheckedRadioButtonId());
            restoreDefaultList();
        }
    }

    public final void setSelectCallback(@Nullable Function1<? super PubWorkChannelBean, Unit> function1) {
        this.selectCallback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void updateAdapterSuccess() {
        if (((PubWorkMenuChannelModel) getMViewModel()).I(3)) {
            getRgMenu().setVisibility(8);
        }
    }
}
