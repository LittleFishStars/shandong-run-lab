package com.huachenjie.mine.page.my_theme;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineActivityMyThemeBinding;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.ik0;
import com.zj.adlib.u66;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0014B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mine/page/my_theme/MyThemeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mine/databinding/MineActivityMyThemeBinding;", "Lcom/huachenjie/mine/page/my_theme/MyThemeViewModel;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "", "path", "f0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "b", "Lkotlin/Lazy;", "d0", "()Ljava/lang/String;", MyThemeActivity.t, "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyThemeActivity extends BaseMVVMActivity<MineActivityMyThemeBinding, MyThemeViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "themeImg";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy themeImg = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.my_theme.MyThemeActivity$themeImg$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(MyThemeActivity.t)) == null) ? "" : stringExtra;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/my_theme/MyThemeActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/mine/page/my_theme/MyThemeActivity;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            MediaPickerLauncher mediaPickerLauncher = MyThemeActivity.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, 0, 1080, 1024, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.my_theme.MyThemeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/mine/page/my_theme/MyThemeActivity$b;", "", "Landroid/content/Context;", "context", "", MyThemeActivity.t, "", PerfId.startActivity, "THEME_IMG", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull String themeImg) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(themeImg, MyThemeActivity.t);
            Intent intent = new Intent(context, (Class<?>) MyThemeActivity.class);
            intent.putExtra(MyThemeActivity.t, themeImg);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/mine/page/my_theme/MyThemeActivity$c", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements MediaPickerListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
            if (str == null) {
                return;
            }
            MyThemeActivity.a0(MyThemeActivity.this).k().setValue(str);
            MyThemeActivity.this.f0(str);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mine/page/my_theme/MyThemeActivity$d", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements UploadCallback {
        public d() {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            fv5.b("上传失败");
            MyThemeActivity.a0(MyThemeActivity.this).c();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            if (TextUtils.isEmpty(fileUrl)) {
                fv5.b("上传失败");
                MyThemeActivity.a0(MyThemeActivity.this).c();
            } else {
                MyThemeViewModel myThemeViewModelA0 = MyThemeActivity.a0(MyThemeActivity.this);
                Intrinsics.checkNotNull(fileUrl);
                myThemeViewModelA0.l(fileUrl);
            }
        }
    }

    public static final /* synthetic */ MyThemeViewModel a0(MyThemeActivity myThemeActivity) {
        return myThemeActivity.getMViewModel();
    }

    public static final void e0(MyThemeActivity myThemeActivity, View view) {
        Intrinsics.checkNotNullParameter(myThemeActivity, "this$0");
        myThemeActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.white).G1(false).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    public final String d0() {
        return (String) this.themeImg.getValue();
    }

    public final void f0(String path) {
        getMViewModel().g();
        u66.d(this, UploadFileType.UPLOAD_USER_THEME, path, new d());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_activity_my_theme;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k().setValue(d0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        int iIntValue;
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("自定义背景");
        bindingTitleBean.setTitleTextColor(-1);
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ev5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyThemeActivity.e0(this.f41531a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_white);
        bindingTitleBean.setBackTintColor(-1);
        mutableLiveDataI.setValue(bindingTitleBean);
        this.picker = MediaPicker.w(this, new c());
    }
}
