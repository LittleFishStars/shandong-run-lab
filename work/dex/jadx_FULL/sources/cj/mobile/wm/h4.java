package cj.mobile.wm;

import com.aliyun.openapiutil.Client;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h4 {
    public final b9<r2, String> dexa = new b9<>(1000);

    public String dexa(r2 r2Var) {
        String strDexa;
        synchronized (this.dexa) {
            strDexa = this.dexa.dexa(r2Var);
        }
        if (strDexa == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
                r2Var.dexa(messageDigest);
                strDexa = e9.dexa(messageDigest.digest());
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            synchronized (this.dexa) {
                this.dexa.dexb(r2Var, strDexa);
            }
        }
        return strDexa;
    }
}
