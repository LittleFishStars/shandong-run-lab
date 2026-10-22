package com.huachenjie.sport.page.mine.helpercenter;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.helpercenter.FeedBackV2Activity;
import com.huachenjie.sport.widget.photowall.PhotoWall;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.k)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/FeedBackV2Activity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/helpercenter/FeedBackV2VM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initView", "m0", "j0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFeedBackV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackV2Activity.kt\ncom/huachenjie/sport/page/mine/helpercenter/FeedBackV2Activity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public final class FeedBackV2Activity extends BaseVmActivity<FeedBackV2VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public MediaPickerLauncher picker;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/FeedBackV2Activity$a", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements MediaPickerListener {
        public a() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result instanceof MediaPickerResult.Success) {
                String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
                if (str == null) {
                    return;
                }
                ((FeedBackV2VM) ((BaseVmActivity) FeedBackV2Activity.this).f8507a).s(FeedBackV2Activity.this, str);
                return;
            }
            if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                return;
            }
            fv5.b(((MediaPickerResult.Error) result).f());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/FeedBackV2Activity$b", "Lcom/huachenjie/sport/widget/photowall/PhotoWall$OnItemClickListener;", "Landroid/view/View;", "v", "", "index", "", "b", "c", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements PhotoWall.OnItemClickListener {
        public b() {
        }

        public static final void e(FeedBackV2Activity feedBackV2Activity) {
            Intrinsics.checkNotNullParameter(feedBackV2Activity, "this$0");
            feedBackV2Activity.m0();
        }

        @Override // com.huachenjie.sport.widget.photowall.PhotoWall.OnItemClickListener
        public void a() {
            if (((FeedBackV2VM) ((BaseVmActivity) FeedBackV2Activity.this).f8507a).k().getValue() == null) {
                return;
            }
            List<String> value = ((FeedBackV2VM) ((BaseVmActivity) FeedBackV2Activity.this).f8507a).k().getValue();
            Intrinsics.checkNotNull(value);
            if (value.size() == 3) {
                fv5.b("最多上传三张图片");
                return;
            }
            if (!KeyboardUtils.n(FeedBackV2Activity.this)) {
                FeedBackV2Activity.this.m0();
                return;
            }
            KeyboardUtils.l(FeedBackV2Activity.this.getWindow());
            Handler handler = new Handler(Looper.getMainLooper());
            final FeedBackV2Activity feedBackV2Activity = FeedBackV2Activity.this;
            handler.postDelayed(new Runnable() { // from class: com.zj.adlib.re3
                @Override // java.lang.Runnable
                public final void run() {
                    FeedBackV2Activity.b.e(feedBackV2Activity);
                }
            }, 300L);
        }

        @Override // com.huachenjie.sport.widget.photowall.PhotoWall.OnItemClickListener
        public void b(@Nullable View v, int index) {
        }

        @Override // com.huachenjie.sport.widget.photowall.PhotoWall.OnItemClickListener
        public void c(@Nullable View v, int index) {
            List<String> value = ((FeedBackV2VM) ((BaseVmActivity) FeedBackV2Activity.this).f8507a).k().getValue();
            if (value != null) {
                FeedBackV2Activity feedBackV2Activity = FeedBackV2Activity.this;
                value.remove(index);
                ((FeedBackV2VM) ((BaseVmActivity) feedBackV2Activity).f8507a).k().setValue(value);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36679a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36679a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36679a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36679a.invoke(obj);
        }
    }

    public static final void k0(FeedBackV2Activity feedBackV2Activity, View view) {
        Intrinsics.checkNotNullParameter(feedBackV2Activity, "this$0");
        ((FeedBackV2VM) ((BaseVmActivity) feedBackV2Activity).f8507a).h();
    }

    public static final void l0(FeedBackV2Activity feedBackV2Activity, View view) {
        Intrinsics.checkNotNullParameter(feedBackV2Activity, "this$0");
        feedBackV2Activity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_feedback_v2), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        this.picker = MediaPicker.w(this, new a());
        j0();
        initView();
    }

    public final void initView() {
        ((PhotoWall) findViewById(R.id.photo)).setOnItemClickListener(new b());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((FeedBackV2VM) ((BaseVmActivity) this).f8507a).n().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.mine.helpercenter.FeedBackV2Activity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                    alertDataBean.setTitle("提交失败");
                    alertDataBean.setContent("您输入的内容存在敏感词");
                    alertDataBean.setContentColor(-16777216);
                    alertDataBean.setConfirm("确定");
                    alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
                    AlertDialog.INSTANCE.a(alertDataBean).show(FeedBackV2Activity.this.getSupportFragmentManager(), "SHOW_FEEDBACK_FAIL");
                }
            }
        }));
    }

    public final void j0() {
        e.p3(this).l3().T2(false).a1();
        BindingTitleBean backClick = new BindingTitleBean().setTitleName("意见反馈").setRightButtonText("提交").setShowRightText(true).setBackIconResId(R.drawable.ic_back_white).setBackground(zn1.a(R.color.color_main_v2)).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.pe3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBackV2Activity.k0(this.f43960a, view);
            }
        }).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.qe3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBackV2Activity.l0(this.f44189a, view);
            }
        });
        Integer value = ((BaseVM) ((FeedBackV2VM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value != null) {
            backClick.setStatusBarHeight(value.intValue());
        }
        ((FeedBackV2VM) ((BaseVmActivity) this).f8507a).o().setValue(backClick);
    }

    public final void m0() {
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, 0, 1080, 1024, false, 0.0f, 0.0f, false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, null);
    }
}
