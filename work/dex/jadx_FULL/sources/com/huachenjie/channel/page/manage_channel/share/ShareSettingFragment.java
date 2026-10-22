package com.huachenjie.channel.page.manage_channel.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.channel.databinding.ChannelFragmentManageShareSettingBinding;
import com.huachenjie.channel.utils.channel.ChannelRefreshReceiver;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.noober.background.view.BLImageView;
import com.zj.adlib.dn1;
import com.zj.adlib.en6;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.tw0;
import com.zj.adlib.wf3;
import java.io.File;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageShareSettingBinding;", "Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingVM;", "", "", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "", "initView", "onDestroyView", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver$delegate", "getReceiver", "()Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ShareSettingFragment extends BaseMVVMFragment<ChannelFragmentManageShareSettingBinding, ShareSettingVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channel_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: receiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy receiver = LazyKt.lazy(new Function0<ChannelRefreshReceiver>() { // from class: com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment$receiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelRefreshReceiver m280invoke() {
            String channelNo = this.this$0.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            final ShareSettingFragment shareSettingFragment = this.this$0;
            return new ChannelRefreshReceiver(channelNo, new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment$receiver$2.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    if (i == 2) {
                        shareSettingFragment.setMHasLoadData(false);
                    }
                }
            });
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingFragment$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingFragment;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelBasicInfo value = ShareSettingFragment.access$getMViewModel(ShareSettingFragment.this).i().getValue();
            gm1.b(value != null ? value.getChannelNumber() : null);
            fv5.b(ShareSettingFragment.this.getString(R.string.channel_manage_channel_copy_success));
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelFragmentManageShareSettingBinding channelFragmentManageShareSettingBindingAccess$getMBinding = ShareSettingFragment.access$getMBinding(ShareSettingFragment.this);
            Bitmap bitmapC = tw0.c(channelFragmentManageShareSettingBindingAccess$getMBinding != null ? channelFragmentManageShareSettingBindingAccess$getMBinding.f7820a : null);
            String str = en6.K() + System.currentTimeMillis();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            ImageUtils.B0(bitmapC, str, Bitmap.CompressFormat.PNG, true);
            if (wf3.n(file.getPath(), ShareSettingFragment.this.requireContext())) {
                fv5.b(ShareSettingFragment.this.getString(R.string.channel_manage_channel_save_success));
            } else {
                fv5.b(ShareSettingFragment.this.getString(R.string.channel_manage_channel_save_fail));
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingFragment$b;", "", "", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/share/ShareSettingFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShareSettingFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ShareSettingFragment shareSettingFragment = new ShareSettingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            shareSettingFragment.setArguments(bundle);
            return shareSettingFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33444a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33444a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33444a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33444a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChannelFragmentManageShareSettingBinding access$getMBinding(ShareSettingFragment shareSettingFragment) {
        return shareSettingFragment.getMBinding();
    }

    public static final /* synthetic */ ShareSettingVM access$getMViewModel(ShareSettingFragment shareSettingFragment) {
        return shareSettingFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final ChannelRefreshReceiver getReceiver() {
        return (ChannelRefreshReceiver) this.receiver.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_share_setting;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().i().observe(this, new c(new Function1<ChannelBasicInfo, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChannelBasicInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChannelBasicInfo channelBasicInfo) {
                ChannelFragmentManageShareSettingBinding channelFragmentManageShareSettingBindingAccess$getMBinding;
                BLImageView bLImageView;
                if (channelBasicInfo == null) {
                    return;
                }
                Bitmap bitmapE = dn1.e("https://www.huachenjie.cn/?channel=" + channelBasicInfo.getChannelNo(), SizeUtils.b(80.0f));
                if (bitmapE == null || (channelFragmentManageShareSettingBindingAccess$getMBinding = ShareSettingFragment.access$getMBinding(ShareSettingFragment.this)) == null || (bLImageView = channelFragmentManageShareSettingBindingAccess$getMBinding.b) == null) {
                    return;
                }
                bLImageView.setImageBitmap(bitmapE);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ri1 ri1Var = ri1.f19330a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ri1Var.a(contextRequireContext, getReceiver());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        ShareSettingVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.j(channelNo);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ri1 ri1Var = ri1.f19330a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ri1Var.c(contextRequireContext, getReceiver());
        super.onDestroyView();
    }
}
