package com.huachenjie.base.qr_code_scan;

import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fv5;
import com.zj.adlib.i40;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/ScanAlipayQRCodeActivity;", "Lcom/huachenjie/base/qr_code_scan/ScanQRCodeActivity;", "", "result", "", "n0", "", bo.g, "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ScanAlipayQRCodeActivity extends ScanQRCodeActivity {
    @Override // com.huachenjie.base.qr_code_scan.ScanQRCodeActivity
    public boolean n0(@Nullable String result) {
        return i40.f42272a.a(result);
    }

    @Override // com.huachenjie.base.qr_code_scan.ScanQRCodeActivity
    public void p0(@Nullable String result) {
        if (i40.f42272a.b(this, result)) {
            finish();
        } else {
            fv5.b("请先安装支付宝APP");
            g0();
        }
    }
}
