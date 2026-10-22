package com.getui.gtc.base.http.crypt;

import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.ResponseBody;
import com.getui.gtc.base.http.Util;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PtRASCryptoInterceptor implements Interceptor {
    private SecretKey aesKey;
    private String encryptedAesKey;
    private String keyId;
    private String publicKeyStr;
    private PublicKey rsaPublicKey;

    public PtRASCryptoInterceptor(String str, String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
        try {
            this.rsaPublicKey = CryptTools.parsePublicKey("RSA", str2);
            SecretKey secretKeyGenerateKey = CryptTools.generateKey("AES", 128);
            this.aesKey = secretKeyGenerateKey;
            this.encryptedAesKey = Base64.encodeToString(CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, secretKeyGenerateKey.getEncoded()), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null) {
            throw new RuntimeException("PtRASCryptoInterceptor Error: request body is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        requestBodyBody.writeTo(byteArrayOutputStream);
        Util.closeQuietly(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String str = new String(byteArray, requestBodyBody.contentType().charset());
        try {
            boolean zStartsWith = request.url().toString().toLowerCase().startsWith("https");
            builderNewBuilder.addHeader("X-TP", zStartsWith ? "4" : "3").addHeader("X-KD", this.keyId).addHeader("X-V", "1.0.1.0");
            if (!zStartsWith) {
                builderNewBuilder.addHeader("X-TL", "10");
                SecretKey secretKeyGenerateKey = CryptTools.generateKey("AES", 128);
                this.aesKey = secretKeyGenerateKey;
                this.encryptedAesKey = Base64.encodeToString(CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, secretKeyGenerateKey.getEncoded()), 2);
            }
            builderNewBuilder.addHeader("X-AK", this.encryptedAesKey);
            String strEncodeToString = Base64.encodeToString(CryptTools.digest("SHA256", (this.keyId + Base64.encodeToString(this.aesKey.getEncoded(), 2) + str).getBytes()), 2);
            builderNewBuilder.addHeader("X-SG", strEncodeToString);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(CryptTools.digest(TKDownloadReason.KSAD_TK_MD5, strEncodeToString.getBytes()));
            builderNewBuilder.body(RequestBody.create(requestBodyBody.contentType(), CryptTools.encrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, byteArray)));
            Response responseProceed = chain.proceed(builderNewBuilder.build());
            if (responseProceed.code() != 200) {
                return responseProceed;
            }
            Response.Builder builderRequest = responseProceed.newBuilder().request(request);
            builderRequest.body(ResponseBody.create(responseProceed.body().contentType(), CryptTools.decrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, responseProceed.body().bytes())));
            return builderRequest.build();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("PtRASCryptoInterceptor Error", e);
        }
    }
}
