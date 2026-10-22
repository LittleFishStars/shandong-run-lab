package com.huachenjie.channel.page.create_channel.info;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ClassificationBean;
import com.huachenjie.channel.databinding.ChannelActivityEditChannelInfoBinding;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.zj.adlib.fv5;
import com.zj.adlib.qi1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.tl6;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityEditChannelInfoBinding;", "Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", "", "b", "Lkotlin/Lazy;", "d0", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "logoPicker", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class EditChannelInfoActivity extends BaseMVVMActivity<ChannelActivityEditChannelInfoBinding, EditChannelInfoVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_type";

    @NotNull
    public static final String x = "key_sub_type";

    @NotNull
    public static final String y = "key_channel_no";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher logoPicker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity$channelNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_channel_no");
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity$a;", "", "Landroid/view/View;", "view", "", "a", "", "url", "c", "b", "<init>", "(Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity$a$a", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "b", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "onLoadFailed", "channel_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0787a extends SimpleTarget<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EditChannelInfoActivity f33395a;
            public final /* synthetic */ String f;

            public C0787a(EditChannelInfoActivity editChannelInfoActivity, String str) {
                this.f33395a = editChannelInfoActivity;
                this.f = str;
            }

            public static final void c(EditChannelInfoActivity editChannelInfoActivity, String str, Palette palette) {
                Intrinsics.checkNotNullParameter(editChannelInfoActivity, "this$0");
                Intrinsics.checkNotNullParameter(str, "$url");
                int iB = tl6.f44947a.b(palette);
                EditChannelInfoActivity.c0(editChannelInfoActivity).j().setValue(str);
                EditChannelInfoVM editChannelInfoVMC0 = EditChannelInfoActivity.c0(editChannelInfoActivity);
                String strE = zn1.e(iB);
                Intrinsics.checkNotNullExpressionValue(strE, "int2RgbString(color)");
                editChannelInfoVMC0.r(strE);
            }

            @Override // com.bumptech.glide.request.target.Target
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResourceReady(@NotNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Palette.Builder builderFrom = Palette.from(resource);
                final EditChannelInfoActivity editChannelInfoActivity = this.f33395a;
                final String str = this.f;
                builderFrom.generate(new Palette.PaletteAsyncListener() { // from class: com.zj.adlib.wx2
                    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                    public final void onGenerated(Palette palette) {
                        EditChannelInfoActivity.a.C0787a.c(editChannelInfoActivity, str, palette);
                    }
                });
            }

            @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MediaPickerLauncher mediaPickerLauncher = EditChannelInfoActivity.this.logoPicker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoPicker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, 0, 1080, 1024, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, null);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            EditChannelInfoVM editChannelInfoVMC0 = EditChannelInfoActivity.c0(EditChannelInfoActivity.this);
            EditChannelInfoActivity editChannelInfoActivity = EditChannelInfoActivity.this;
            editChannelInfoVMC0.q(editChannelInfoActivity, editChannelInfoActivity.d0());
        }

        public final void c(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (!TextUtils.isEmpty(url)) {
                Glide.with((FragmentActivity) EditChannelInfoActivity.this).asBitmap().load(url).into(new C0787a(EditChannelInfoActivity.this, url));
            } else {
                EditChannelInfoActivity.c0(EditChannelInfoActivity.this).j().setValue("");
                EditChannelInfoActivity.c0(EditChannelInfoActivity.this).r("");
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/bean/ClassificationBean;", "type", "subType", "", "channelNo", "", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_SUB_TYPE", "KEY_TYPE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ClassificationBean type, @NotNull ClassificationBean subType, @Nullable String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(subType, "subType");
            Intent intent = new Intent(context, (Class<?>) EditChannelInfoActivity.class);
            intent.putExtra("key_type", type);
            intent.putExtra(EditChannelInfoActivity.x, subType);
            intent.putExtra("key_channel_no", channelNo);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity$c", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nEditChannelInfoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditChannelInfoActivity.kt\ncom/huachenjie/channel/page/create_channel/info/EditChannelInfoActivity$initView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
    public static final class c implements MediaPickerListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
                if (str != null) {
                    EditChannelInfoActivity.c0(EditChannelInfoActivity.this).k().setValue(str);
                    return;
                }
                return;
            }
            if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                return;
            }
            fv5.b(((MediaPickerResult.Error) result).f());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33397a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33397a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33397a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33397a.invoke(obj);
        }
    }

    public static final /* synthetic */ EditChannelInfoVM c0(EditChannelInfoActivity editChannelInfoActivity) {
        return editChannelInfoActivity.getMViewModel();
    }

    public static final void e0(EditChannelInfoActivity editChannelInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(editChannelInfoActivity, "this$0");
        editChannelInfoActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().m().observe(this, new d(new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<String, String> pair) {
                if (pair == null) {
                    return;
                }
                if (this.this$0.d0() == null) {
                    qi1.f44215a.b(this.this$0, (String) pair.getFirst(), (String) pair.getSecond());
                } else {
                    qi1.f44215a.e(this.this$0, (String) pair.getFirst(), (String) pair.getSecond(), true);
                    ri1.f19330a.b(this.this$0, (String) pair.getFirst(), 1);
                }
                ActivityLifecycleManager.l().j(zj7.a.HOME);
            }
        }));
    }

    public final String d0() {
        return (String) this.channelNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_edit_channel_info;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().p().setValue(getIntent().getParcelableExtra("key_type"));
        getMViewModel().n().setValue(getIntent().getParcelableExtra(x));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        this.logoPicker = MediaPicker.w(this, new c());
        UploadPictureButton uploadPictureButton = getMBinding().f7531a;
        Intrinsics.checkNotNullExpressionValue(uploadPictureButton, "mBinding.uploadPic");
        UploadPictureButton.initPicker$default(uploadPictureButton, this, (String) null, 0, 0, 14, (Object) null);
        MutableLiveData<BindingTitleBean> mutableLiveDataO = getMViewModel().o();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataO.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_edit_info_header_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditChannelInfoActivity.e0(this.f45479a, view);
            }
        }));
    }
}
