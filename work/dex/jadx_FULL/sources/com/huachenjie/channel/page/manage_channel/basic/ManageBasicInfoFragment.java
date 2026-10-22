package com.huachenjie.channel.page.manage_channel.basic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.p002lifecycle.Observer;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.channel.databinding.ChannelFragmentManageBasicInfoBinding;
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.noober.background.view.BLEditText;
import com.zj.adlib.qi1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.tl6;
import com.zj.adlib.zn1;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageBasicInfoBinding;", "Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoVM;", "", "", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "", "initView", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nManageBasicInfoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManageBasicInfoFragment.kt\ncom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,135:1\n65#2,16:136\n93#2,3:152\n*S KotlinDebug\n*F\n+ 1 ManageBasicInfoFragment.kt\ncom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment\n*L\n53#1:136,16\n53#1:152,3\n*E\n"})
public final class ManageBasicInfoFragment extends BaseMVVMFragment<ChannelFragmentManageBasicInfoBinding, ManageBasicInfoVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment$channelNo$2
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment$a;", "", "Landroid/view/View;", "view", "", "b", "", "url", "d", "c", "a", "<init>", "(Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment$a$a", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "b", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "onLoadFailed", "channel_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0788a extends SimpleTarget<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ManageBasicInfoFragment f33425a;
            public final /* synthetic */ String f;

            public C0788a(ManageBasicInfoFragment manageBasicInfoFragment, String str) {
                this.f33425a = manageBasicInfoFragment;
                this.f = str;
            }

            public static final void c(ManageBasicInfoFragment manageBasicInfoFragment, String str, Palette palette) {
                Intrinsics.checkNotNullParameter(manageBasicInfoFragment, "this$0");
                Intrinsics.checkNotNullParameter(str, "$url");
                int iB = tl6.f44947a.b(palette);
                ChannelBasicInfo value = ManageBasicInfoFragment.access$getMViewModel(manageBasicInfoFragment).i().getValue();
                if (value != null) {
                    value.setCoverUrl(str);
                    String strE = zn1.e(iB);
                    Intrinsics.checkNotNullExpressionValue(strE, "int2RgbString(color)");
                    value.setCoverHue(strE);
                    ManageBasicInfoFragment.access$getMViewModel(manageBasicInfoFragment).i().setValue(value);
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResourceReady(@NotNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Palette.Builder builderFrom = Palette.from(resource);
                final ManageBasicInfoFragment manageBasicInfoFragment = this.f33425a;
                final String str = this.f;
                builderFrom.generate(new Palette.PaletteAsyncListener() { // from class: com.zj.adlib.h75
                    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                    public final void onGenerated(Palette palette) {
                        ManageBasicInfoFragment.a.C0788a.c(manageBasicInfoFragment, str, palette);
                    }
                });
            }

            @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
            }
        }

        public a() {
        }

        public final void a(@Nullable View view) {
            ManageBasicInfoVM manageBasicInfoVMAccess$getMViewModel = ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this);
            Context contextRequireContext = ManageBasicInfoFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String channelNo = ManageBasicInfoFragment.this.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            manageBasicInfoVMAccess$getMViewModel.m(contextRequireContext, channelNo);
        }

        public final void b(@Nullable View view) {
            ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).j().setValue("");
        }

        public final void c(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (!TextUtils.isEmpty(url)) {
                Glide.with(ManageBasicInfoFragment.this.requireContext()).asBitmap().load(url).into(new C0788a(ManageBasicInfoFragment.this, url));
                return;
            }
            ChannelBasicInfo value = ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).i().getValue();
            if (value != null) {
                ManageBasicInfoFragment manageBasicInfoFragment = ManageBasicInfoFragment.this;
                value.setCoverUrl(url);
                value.setCoverHue("");
                ManageBasicInfoFragment.access$getMViewModel(manageBasicInfoFragment).i().setValue(value);
            }
        }

        public final void d(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            ChannelBasicInfo value = ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).i().getValue();
            if (value != null) {
                ManageBasicInfoFragment manageBasicInfoFragment = ManageBasicInfoFragment.this;
                value.setLogo(url);
                ManageBasicInfoFragment.access$getMViewModel(manageBasicInfoFragment).i().setValue(value);
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment$b;", "", "", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ManageBasicInfoFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ManageBasicInfoFragment manageBasicInfoFragment = new ManageBasicInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            manageBasicInfoFragment.setArguments(bundle);
            return manageBasicInfoFragment;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 ManageBasicInfoFragment.kt\ncom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoFragment\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n54#2,5:98\n71#3:103\n77#4:104\n*E\n"})
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            ChannelBasicInfo value = ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).i().getValue();
            if (value != null) {
                value.setChannelDescription(String.valueOf(s));
                ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).i().setValue(value);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33427a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33427a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33427a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33427a.invoke(obj);
        }
    }

    public static final /* synthetic */ ManageBasicInfoVM access$getMViewModel(ManageBasicInfoFragment manageBasicInfoFragment) {
        return manageBasicInfoFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_basic_info;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().k().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                String logo;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ri1 ri1Var = ri1.f19330a;
                    Context contextRequireContext = ManageBasicInfoFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String channelNo = ManageBasicInfoFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                    ri1Var.b(contextRequireContext, channelNo, 2);
                    qi1 qi1Var = qi1.f44215a;
                    Context contextRequireContext2 = ManageBasicInfoFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    String channelNo2 = ManageBasicInfoFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo2, "channelNo");
                    ChannelBasicInfo value = ManageBasicInfoFragment.access$getMViewModel(ManageBasicInfoFragment.this).i().getValue();
                    if (value == null || (logo = value.getLogo()) == null) {
                        logo = "";
                    }
                    qi1Var.e(contextRequireContext2, channelNo2, logo, false);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        BLEditText bLEditText;
        UploadPictureButton uploadPictureButton;
        UploadPictureButton uploadPictureButton2;
        super.initView();
        ChannelFragmentManageBasicInfoBinding mBinding = getMBinding();
        if (mBinding != null && (uploadPictureButton2 = mBinding.f7804b) != null) {
            UploadPictureButton.initPicker$default(uploadPictureButton2, this, (String) null, 0, 0, 14, (Object) null);
        }
        ChannelFragmentManageBasicInfoBinding mBinding2 = getMBinding();
        if (mBinding2 != null && (uploadPictureButton = mBinding2.f7802a) != null) {
            UploadPictureButton.initPicker$default(uploadPictureButton, this, (String) null, 0, 0, 14, (Object) null);
        }
        ChannelFragmentManageBasicInfoBinding mBinding3 = getMBinding();
        if (mBinding3 == null || (bLEditText = mBinding3.f7803a) == null) {
            return;
        }
        bLEditText.addTextChangedListener(new c());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        ManageBasicInfoVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.l(channelNo);
    }
}
