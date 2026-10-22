package com.kc.cw.ad.c.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f38753a;
    private String b;
    private final a c;

    @Keep
    public interface a {
        String a(String str, String str2, String str3);
    }

    public g(a aVar) {
        this.c = aVar;
    }

    private String a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    private void a(Context context) {
        if (TextUtils.isEmpty(this.f38753a)) {
            this.f38753a = context.getPackageName();
            com.kc.cw.ad.d.b.f.a("SignatureHelper", "Package name set to: " + this.f38753a);
        }
    }

    private void b(Context context) {
        String str;
        if (TextUtils.isEmpty(this.b)) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f38753a, 64).signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    com.kc.cw.ad.d.b.f.c("SignatureHelper", "No signatures found for package: " + this.f38753a);
                } else {
                    this.b = a(signatureArr[0].toByteArray());
                    com.kc.cw.ad.d.b.f.a("SignatureHelper", "SHA1 Signature calculated: " + this.b);
                }
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                str = "Package name not found: " + this.f38753a;
                com.kc.cw.ad.d.b.f.a("SignatureHelper", str, e);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                str = "SHA1 Algorithm not found";
                com.kc.cw.ad.d.b.f.a("SignatureHelper", str, e);
            }
        }
    }

    public String a(Context context, String str) {
        a(context);
        b(context);
        a aVar = this.c;
        if (aVar == null) {
            return "";
        }
        String strA = aVar.a(this.f38753a, this.b, str);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }
}
