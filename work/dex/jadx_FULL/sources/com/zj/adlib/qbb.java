package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.he;
import com.amap.api.col.p0003l.ij;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qbb extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f44170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public he f19053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f19055a;

    public qbb(Context context, ij ijVar, he heVar, String str, Object... objArr) {
        super(ijVar);
        this.f44170a = context;
        this.f19054a = str;
        this.f19053a = heVar;
        this.f19055a = objArr;
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        String strG = s4b.g(bArr);
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        return s4b.p("{\"pinfo\":\"" + s4b.g(this.f19053a.b(s4b.p(c()))) + "\",\"els\":[" + strG + "]}");
    }

    public final String c() {
        try {
            return String.format(s4b.v(this.f19054a), this.f19055a);
        } catch (Throwable th) {
            th.printStackTrace();
            a7b.m(th, "ofm", "gpj");
            return "";
        }
    }
}
