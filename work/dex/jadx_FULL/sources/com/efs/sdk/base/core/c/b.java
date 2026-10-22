package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.secure.a.a(bArr, str);
        } catch (Exception e) {
            Log.e("efs.base", "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.secure.a.b(bArr, str);
        } catch (Exception e) {
            Log.e("efs.base", "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
