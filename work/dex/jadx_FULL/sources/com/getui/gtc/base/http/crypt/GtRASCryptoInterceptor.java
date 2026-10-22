package com.getui.gtc.base.http.crypt;

import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.ResponseBody;
import com.getui.gtc.base.http.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GtRASCryptoInterceptor implements Interceptor {
    private final String keyId;
    private final String publicKeyStr;

    public GtRASCryptoInterceptor(String str, String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null) {
            throw new RuntimeException("GtRASCryptoInterceptor Error: request body is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        requestBodyBody.writeTo(gZIPOutputStream);
        gZIPOutputStream.finish();
        Util.closeQuietly(gZIPOutputStream);
        Util.closeQuietly(byteArrayOutputStream);
        try {
            builderNewBuilder.addHeader("GT_C_T", "1").addHeader("GT_C_K", this.keyId);
            String strValueOf = String.valueOf(System.currentTimeMillis());
            builderNewBuilder.addHeader("GT_T", strValueOf);
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            PublicKey publicKey = CryptTools.parsePublicKey("RSA", this.publicKeyStr);
            SecretKey secretKeyGenerateKey = CryptTools.generateKey("AES", 128);
            byte[] bArrEncrypt = CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", publicKey, secretKeyGenerateKey.getEncoded());
            byte[] bArr2 = new byte[bArrEncrypt.length + 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArrEncrypt, 0, bArr2, 16, bArrEncrypt.length);
            builderNewBuilder.addHeader("GT_C_V", Base64.encodeToString(bArr2, 2));
            byte[] bytes = strValueOf.getBytes();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr3 = new byte[bytes.length + byteArray.length];
            System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
            System.arraycopy(byteArray, 0, bArr3, bytes.length, byteArray.length);
            String strEncodeToString = Base64.encodeToString(CryptTools.digest("SHA1", bArr3), 2);
            builderNewBuilder.addHeader("GT_C_S", strEncodeToString);
            builderNewBuilder.body(RequestBody.create(requestBodyBody.contentType(), CryptTools.encrypt("AES/CFB/NoPadding", secretKeyGenerateKey, new IvParameterSpec(CryptTools.digest("MD5", strEncodeToString.getBytes())), byteArray)));
            Response responseProceed = chain.proceed(builderNewBuilder.build());
            if (responseProceed.code() != 200) {
                return responseProceed;
            }
            Response.Builder builderRequest = responseProceed.newBuilder().request(request);
            List<String> list = responseProceed.getHeaders().get("GT_ERR");
            if (list != null && list.size() > 0 && "0".equals(list.get(0))) {
                builderRequest.removeHeader("GT_ERR");
                List<String> list2 = responseProceed.getHeaders().get("GT_T");
                if (list2 == null || list2.size() <= 0) {
                    throw new SecurityException("GT_T header not found");
                }
                byte[] bytes2 = list2.get(0).getBytes();
                IvParameterSpec ivParameterSpec = new IvParameterSpec(CryptTools.digest("MD5", bytes2));
                builderRequest.removeHeader("GT_T");
                List<String> list3 = responseProceed.getHeaders().get("GT_C_S");
                if (list3 == null || list3.size() <= 0) {
                    throw new SecurityException("GT_C_S header not found");
                }
                byte[] bArrDecode = Base64.decode(list3.get(0), 2);
                byte[] bArrDecrypt = CryptTools.decrypt("AES/CFB/NoPadding", secretKeyGenerateKey, ivParameterSpec, responseProceed.body().bytes());
                byte[] bArr4 = new byte[bArrDecrypt.length + bytes2.length];
                System.arraycopy(bytes2, 0, bArr4, 0, bytes2.length);
                System.arraycopy(bArrDecrypt, 0, bArr4, bytes2.length, bArrDecrypt.length);
                if (!Arrays.equals(CryptTools.digest("SHA1", bArr4), bArrDecode)) {
                    throw new SecurityException("response body sign check failed");
                }
                builderRequest.removeHeader("GT_C_S");
                builderRequest.body(ResponseBody.create(responseProceed.body().contentType(), bArrDecrypt));
                return builderRequest.build();
            }
            if (list == null) {
                throw new SecurityException("GT_ERR header not found");
            }
            throw new SecurityException("GT_ERR header is " + list.get(0));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("GtRASCryptoInterceptor Error", e);
        }
    }
}
