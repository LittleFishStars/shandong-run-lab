package com.huachenjie.sport.page.mine.signin;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.qr_code_scan.LocationHelper;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.sport.R;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.vo6;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class NumberSignInDialog extends BaseVMDialogFragment<NumberSignInVM> {
    OnSignInSuccessCallback signInSuccessCallback;

    public interface OnSignInSuccessCallback {
        void a();
    }

    public class a implements LocationHelper.Callback {
        public a() {
        }

        @Override // com.huachenjie.base.qr_code_scan.LocationHelper.Callback
        public void a(double d, double d2) {
            HCJAddressInfo hCJAddressInfo = new HCJAddressInfo();
            hCJAddressInfo.setLat(d);
            hCJAddressInfo.setLng(d2);
            NumberSignInDialog.this.onGetLocation(hCJAddressInfo);
        }

        @Override // com.huachenjie.base.qr_code_scan.LocationHelper.Callback
        public void b(String str) {
            fv5.b(str + "，签到失败");
        }
    }

    public class b extends BizSubscriber<JSONObject> {
        public b(boolean z) {
            super(z);
        }

        public void onFailed(int i, String str) {
            NumberSignInDialog.this.dismissAllowingStateLoss();
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
        }

        public void onCCSuccess(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.containsKey("attendMessage")) {
                OnSignInSuccessCallback onSignInSuccessCallback = NumberSignInDialog.this.signInSuccessCallback;
                if (onSignInSuccessCallback != null) {
                    onSignInSuccessCallback.a();
                }
                fv5.b("签到成功");
            } else {
                fv5.b(jSONObject.getString("attendMessage"));
            }
            NumberSignInDialog.this.dismissAllowingStateLoss();
        }
    }

    public class c {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z) {
            if (z) {
                NumberSignInDialog.this.startLocation();
            } else {
                fv5.b("无定位权限，签到失败");
            }
        }

        public void b(View view) {
            vo6.j(NumberSignInDialog.this.requireContext(), "android.permission.ACCESS_FINE_LOCATION", "需要获取您的位置来确定您是否可以签到，我们需要访问您的位置权限", new PermissionResultListener() { // from class: com.zj.adlib.l46
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    this.f42994a.c(z);
                }
            });
        }
    }

    public static NumberSignInDialog newInstance(OnSignInSuccessCallback onSignInSuccessCallback) {
        NumberSignInDialog numberSignInDialog = new NumberSignInDialog();
        numberSignInDialog.setSignInCallback(onSignInSuccessCallback);
        return numberSignInDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetLocation(HCJAddressInfo hCJAddressInfo) {
        ((NumberSignInVM) ((BaseVMDialogFragment) this).mState).h(hCJAddressInfo, new b(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLocation() {
        LocationHelper.a(this.mActivity, new a(), true);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_number_sign_in), Integer.valueOf(ok0.L), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(ok0.k), new c());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(Bundle bundle) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.3f;
            attributes.softInputMode = 32;
            window.setAttributes(attributes);
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.gravity = 17;
            attributes2.width = fx7.j() - SizeUtils.b(36.0f);
            attributes2.height = -2;
            window.setAttributes(attributes2);
        }
    }

    public void setSignInCallback(OnSignInSuccessCallback onSignInSuccessCallback) {
        this.signInSuccessCallback = onSignInSuccessCallback;
    }
}
