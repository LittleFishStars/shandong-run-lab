package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements IDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SecretKey f37370a;
    private final d b;
    private boolean c = false;

    public f(d dVar) {
        this.b = dVar;
    }

    private void a() {
        try {
            this.f37370a = j.a(this.b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'.");
            this.f37370a = null;
        }
        this.c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.c) {
            a();
        }
        if (this.f37370a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(j.a(this.f37370a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                Log.e("AGC_LocalResource", "decrypt exception:" + e.getMessage());
            }
        }
        return str2;
    }
}
