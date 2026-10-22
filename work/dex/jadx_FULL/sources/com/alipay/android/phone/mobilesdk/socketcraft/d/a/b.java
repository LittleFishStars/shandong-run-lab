package com.alipay.android.phone.mobilesdk.socketcraft.d.a;

import com.alipay.android.phone.mobilesdk.socketcraft.f.a.c;
import com.alipay.mobile.common.transport.utils.LogCatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements c {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, String str2) {
        LogCatUtil.info(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, String str2) {
        LogCatUtil.verbose(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void c(String str, String str2) {
        LogCatUtil.debug(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void d(String str, String str2) {
        LogCatUtil.warn(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void e(String str, String str2) {
        LogCatUtil.error(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void f(String str, String str2) {
        LogCatUtil.printInfo(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, Throwable th) {
        LogCatUtil.warn(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, Throwable th) {
        LogCatUtil.error(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void c(String str, Throwable th) {
        LogCatUtil.printError(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, String str2, Throwable th) {
        LogCatUtil.warn(str, str2, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, String str2, Throwable th) {
        LogCatUtil.error(str, str2, th);
    }
}
