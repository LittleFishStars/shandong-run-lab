package com.byazt.ng;

import android.text.TextUtils;
import android.util.Base64;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 71})
public class x {
    public static volatile x c;
    public Key tt;
    public Cipher ve;

    private x() {
        try {
            this.tt = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.byazt.bp.tt.tt().q(), 0)));
            this.ve = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static x c() {
        if (c == null) {
            synchronized (x.class) {
                if (c == null) {
                    c = new x();
                }
            }
        }
        return c;
    }

    public String c(byte[] bArr) throws Exception {
        byte[] bArrDoFinal;
        if (bArr == null) {
            return null;
        }
        if (this.ve == null) {
            this.tt = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.byazt.bp.tt.tt().q(), 0)));
            this.ve = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.ve.init(1, this.tt);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArrDoFinal = this.ve.doFinal(bArr, i, 117);
                } else {
                    bArrDoFinal = this.ve.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String c(com.byazt.yl.ve veVar) {
        if (veVar == null || MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(veVar.getAdTitle())) {
                jSONObject.putOpt("t", veVar.getAdTitle());
            }
            if (!TextUtils.isEmpty(veVar.getAdDescription())) {
                jSONObject.putOpt("d", veVar.getAdDescription());
            }
            jSONObject.putOpt("e", String.valueOf(veVar.getCpm()));
            if (!TextUtils.isEmpty(veVar.getAppName())) {
                jSONObject.putOpt(com.alipay.sdk.m.w.a.w, veVar.getAppName());
            }
            if (!TextUtils.isEmpty(veVar.getAuthorName())) {
                jSONObject.putOpt("aun", veVar.getAuthorName());
            }
        } catch (JSONException e) {
            m.c(e);
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return c(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            m.c(e2);
            return null;
        }
    }
}
