package com.huachenjie.channel.page.message_detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.channel.databinding.ChannelActivityMessageDetailBinding;
import com.huachenjie.channel.page.message_detail.MessageDetailActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.zj.adlib.fv5;
import com.zj.adlib.tk0;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.b.ORGANIZE_ACTIVITY_DETAIL)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/page/message_detail/MessageDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityMessageDetailBinding;", "Lcom/huachenjie/channel/page/message_detail/MessageDetailVM;", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "d0", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class MessageDetailActivity extends BaseMVVMActivity<ChannelActivityMessageDetailBinding, MessageDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_delete_flag";

    @NotNull
    public static final String x = "clubMessageBean";

    @NotNull
    public static final String y = "key_show_delete";

    /* JADX INFO: renamed from: com.huachenjie.channel.page.message_detail.MessageDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/message_detail/MessageDetailActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/bean/ClubMessageBean;", "clubMessageBean", "", "showDelete", "Landroid/content/Intent;", "a", "", "KEY_CLUB_MESSAGE_BEAN", "Ljava/lang/String;", "KEY_DELETE_FLAG", "KEY_SHOW_DELETE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, ClubMessageBean clubMessageBean, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.a(context, clubMessageBean, z);
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull ClubMessageBean clubMessageBean, boolean showDelete) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(clubMessageBean, "clubMessageBean");
            Intent intent = new Intent(context, (Class<?>) MessageDetailActivity.class);
            intent.putExtra("clubMessageBean", clubMessageBean);
            intent.putExtra(MessageDetailActivity.y, showDelete);
            return intent;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33464a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33464a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33464a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33464a.invoke(obj);
        }
    }

    public static final void e0(MessageDetailActivity messageDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(messageDetailActivity, "this$0");
        MoreOptDialog moreOptDialogA = MoreOptDialog.INSTANCE.a(CollectionsKt.arrayListOf(new MoreOptBean[]{new MoreOptBean("删除", R.drawable.channel_ic_delete, 0, 4, null)}), new MessageDetailActivity$initTitle$1$1(messageDetailActivity));
        FragmentManager supportFragmentManager = messageDetailActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        moreOptDialogA.show(supportFragmentManager, MoreOptDialog.class.getSimpleName());
    }

    public static final void f0(MessageDetailActivity messageDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(messageDetailActivity, "this$0");
        messageDetailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, MessageDetailVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().k().observe(this, new b(new Function1<ClubMessageBean, Unit>() { // from class: com.huachenjie.channel.page.message_detail.MessageDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClubMessageBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ClubMessageBean clubMessageBean) {
                CommonBanner commonBanner = this.this$0.getMBinding().f7580a;
                Intrinsics.checkNotNullExpressionValue(commonBanner, "mBinding.banner");
                MessageDetailActivity messageDetailActivity = this.this$0;
                List<ImageBean> imgList = clubMessageBean.getImgList();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imgList, 10));
                for (ImageBean imageBean : imgList) {
                    arrayList.add(new CommonBannerBean(imageBean.getUrl(), imageBean.getWidth(), imageBean.getHeight(), false, 0.0f, 24, null));
                }
                CommonBanner.setImageList$default(commonBanner, messageDetailActivity, arrayList, (CommonBannerConfig) null, 4, (Object) null);
            }
        }));
        getMViewModel().l().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.message_detail.MessageDetailActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                fv5.a(R.string.channel_organize_message_del_suc);
                MessageDetailActivity messageDetailActivity = this.this$0;
                Intent intent = new Intent();
                intent.putExtra(MessageDetailActivity.t, true);
                Unit unit = Unit.INSTANCE;
                messageDetailActivity.setResult(-1, intent);
                this.this$0.finish();
            }
        }));
    }

    public final void d0() {
        boolean booleanExtra = getIntent().getBooleanExtra(y, false);
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("详情").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setRightIconResId(R.drawable.channel_ic_more).setShowRightIcon(booleanExtra).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.dm5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDetailActivity.e0(this.f41227a, view);
            }
        }).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.em5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDetailActivity.f0(this.f41469a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_message_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k().setValue(getIntent().getParcelableExtra("clubMessageBean"));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(-1);
        d0();
    }
}
