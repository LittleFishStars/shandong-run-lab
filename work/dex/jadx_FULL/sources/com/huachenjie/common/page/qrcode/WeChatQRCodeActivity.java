package com.huachenjie.common.page.qrcode;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.alibaba.android.arouter.utils.TextUtils;
import com.google.zxing.android.activity.CaptureActivity;
import com.hjq.permissions.Permission;
import com.huachenjie.common.R;
import com.huachenjie.common.page.qrcode.WeChatQRCodeActivity;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.zj.adlib.fv5;
import com.zj.adlib.i40;
import com.zj.adlib.v41;
import com.zj.adlib.vo6;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0002R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/common/page/qrcode/WeChatQRCodeActivity;", "Lcom/google/zxing/android/activity/CaptureActivity;", "Landroid/os/Bundle;", "icicle", "", "onCreate", "initView", "", "result", "Z", "q0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "", "c", "showAlbum", "Landroid/app/Dialog;", "Lkotlin/Lazy;", "getMLoadingDialog", "()Landroid/app/Dialog;", "mLoadingDialog", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class WeChatQRCodeActivity extends CaptureActivity {

    @NotNull
    public static final String x = "result";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mLoadingDialog = LazyKt.lazy(new Function0<Dialog>() { // from class: com.huachenjie.common.page.qrcode.WeChatQRCodeActivity$mLoadingDialog$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Dialog m350invoke() {
            return DialogUtil.p(this.this$0, false);
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean showAlbum;

    public static final void n0(WeChatQRCodeActivity weChatQRCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(weChatQRCodeActivity, "this$0");
        weChatQRCodeActivity.finish();
    }

    public static final void o0(WeChatQRCodeActivity weChatQRCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(weChatQRCodeActivity, "this$0");
        weChatQRCodeActivity.q0();
    }

    public static final void p0(WeChatQRCodeActivity weChatQRCodeActivity, boolean z) {
        Intrinsics.checkNotNullParameter(weChatQRCodeActivity, "this$0");
        if (z) {
            weChatQRCodeActivity.h0();
        }
    }

    @Override // com.google.zxing.android.activity.CaptureActivity
    public void Z(@Nullable String result) {
        if (TextUtils.isEmpty(result)) {
            return;
        }
        i40 i40Var = i40.f42272a;
        if (i40Var.a(result)) {
            if (!i40Var.b(this, result)) {
                fv5.b("请先安装支付宝APP");
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra("result", result);
            setResult(-1, intent);
            finish();
        }
    }

    public final Dialog getMLoadingDialog() {
        Object value = this.mLoadingDialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLoadingDialog>(...)");
        return (Dialog) value;
    }

    public final void initView() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.du9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeChatQRCodeActivity.n0(this.f41276a, view);
            }
        });
        View viewFindViewById = findViewById(R.id.iv_scan_album);
        View viewFindViewById2 = findViewById(R.id.tv_scan_album);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.eu9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeChatQRCodeActivity.o0(this.f41528a, view);
            }
        };
        viewFindViewById.setVisibility(this.showAlbum ? 0 : 8);
        viewFindViewById2.setVisibility(this.showAlbum ? 0 : 8);
        viewFindViewById.setOnClickListener(onClickListener);
        viewFindViewById2.setOnClickListener(onClickListener);
    }

    @Override // com.google.zxing.android.activity.CaptureActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();
        this.showAlbum = intent != null ? intent.getBooleanExtra(QRCodeResultFragment.EXTRA_SHOW_ALBUM, false) : false;
        setContentView(R.layout.activity_camera_pre);
        this.picker = MediaPicker.w(this, new MediaPickerListener() { // from class: com.huachenjie.common.page.qrcode.WeChatQRCodeActivity.onCreate.1
            @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
            public void b(@NotNull MediaPickerResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result instanceof MediaPickerResult.Success) {
                    String str = (String) CollectionsKt.firstOrNull(((MediaPickerResult.Success) result).g());
                    if (str == null) {
                        WeChatQRCodeActivity.this.g0();
                        return;
                    } else {
                        v41.e(LifecycleOwnerKt.getLifecycleScope(WeChatQRCodeActivity.this), (CoroutineContext) null, (CoroutineStart) null, new WeChatQRCodeActivity$onCreate$1$onResult$1(WeChatQRCodeActivity.this, str, null), 3, (Object) null);
                        return;
                    }
                }
                if (result instanceof MediaPickerResult.a) {
                    WeChatQRCodeActivity.this.g0();
                } else if (result instanceof MediaPickerResult.Error) {
                    fv5.b(((MediaPickerResult.Error) result).f());
                    WeChatQRCodeActivity.this.g0();
                }
            }
        });
        initView();
        vo6.j(this, Permission.CAMERA, "为了您能正常使用扫描二维码功能，我们需要访问您终端设备的摄像头权限", new PermissionResultListener() { // from class: com.zj.adlib.fu9
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                WeChatQRCodeActivity.p0(this.f41759a, z);
            }
        });
    }

    public final void q0() {
        i0();
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.w(mediaPickerLauncher, 0, 0, false, 0.0f, 0.0f, false, 63, null);
    }
}
