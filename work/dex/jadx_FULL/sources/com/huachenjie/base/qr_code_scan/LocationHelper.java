package com.huachenjie.base.qr_code_scan;

import android.app.Activity;
import android.app.Dialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
import com.baidu.location.LocationClientOption;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.i4a;
import com.zj.adlib.lj0;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class LocationHelper {

    public interface Callback {
        void a(double lat, double lng);

        void b(String errorMsg);
    }

    public class a implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f32941a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Callback f7224a;

        public a(final Dialog val$loadingDialog, final Callback val$callback) {
            this.f32941a = val$loadingDialog;
            this.f7224a = val$callback;
        }

        public void onLocationListener(int i, HCJAddressInfo hcjAddressInfo) {
            Dialog dialog = this.f32941a;
            if (dialog != null && dialog.isShowing()) {
                this.f32941a.dismiss();
            }
            if (hcjAddressInfo == null) {
                this.f7224a.b("定位失败");
            } else {
                this.f7224a.a(hcjAddressInfo.getLat(), hcjAddressInfo.getLng());
            }
        }
    }

    public static void a(Activity activity, Callback callback, boolean showLoadingDialog) {
        if (callback == null) {
            return;
        }
        if (!(activity instanceof AppCompatActivity)) {
            callback.b("定位参数异常");
            return;
        }
        if (ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            callback.b("无定位权限");
            return;
        }
        final Dialog dialogN = showLoadingDialog ? DialogUtil.n(activity, "定位中...") : null;
        if (dialogN != null) {
            try {
                dialogN.show();
            } catch (Exception e) {
                i4a.b("LocationHelper", "startLocation error:" + e);
                if (dialogN != null) {
                    dialogN.dismiss();
                }
                callback.b("定位异常");
                return;
            }
        }
        ((AppCompatActivity) activity).getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.huachenjie.base.qr_code_scan.LocationHelper.1
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner owner) {
                Dialog dialog = dialogN;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                dialogN.dismiss();
            }
        });
        lj0.o(activity, false, LocationClientOption.LocationMode.Hight_Accuracy, new a(dialogN, callback));
    }
}
