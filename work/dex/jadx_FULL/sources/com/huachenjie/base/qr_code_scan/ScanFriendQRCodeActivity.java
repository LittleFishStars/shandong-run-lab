package com.huachenjie.base.qr_code_scan;

import android.net.Uri;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Route(path = RoutePathConstants.Base.c)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/ScanFriendQRCodeActivity;", "Lcom/huachenjie/base/qr_code_scan/ScanQRCodeActivity;", "", "result", "", "n0", "", bo.g, "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ScanFriendQRCodeActivity extends ScanQRCodeActivity {
    @Override // com.huachenjie.base.qr_code_scan.ScanQRCodeActivity
    public boolean n0(@Nullable String result) {
        if (TextUtils.isEmpty(result)) {
            return false;
        }
        Intrinsics.checkNotNull(result);
        if (!StringsKt.startsWith$default(result, UserConstants.URL_PARAMS.f33738a, false, 2, (Object) null)) {
            return false;
        }
        String queryParameter = Uri.parse(result).getQueryParameter(UserConstants.URL_PARAMS.b);
        return !(queryParameter == null || queryParameter.length() == 0);
    }

    @Override // com.huachenjie.base.qr_code_scan.ScanQRCodeActivity
    public void p0(@Nullable String result) {
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", Uri.parse(result).getQueryParameter(UserConstants.URL_PARAMS.b)).navigation();
        finish();
    }
}
