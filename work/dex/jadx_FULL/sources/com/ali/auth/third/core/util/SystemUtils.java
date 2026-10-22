package com.ali.auth.third.core.util;

import android.app.Application;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.InternalSession;
import com.ali.auth.third.core.model.User;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemUtils {
    public static String getApkPublicKeyDigest() {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(KernelContext.getApplicationContext().getPackageManager().getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 64).signatures[0].toByteArray()));
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(x509Certificate.getPublicKey().toString().getBytes());
            return CommonUtils.getHashString(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getApkSignNumber() {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(KernelContext.getApplicationContext().getPackageManager().getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 64).signatures[0].toByteArray()))).getSerialNumber().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Application getSystemApp() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toInternalSessionJSON(InternalSession internalSession) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loginTime", internalSession.loginTime);
            jSONObject.put("expireIn", internalSession.expireIn);
            jSONObject.put(LoginConstants.SID, internalSession.sid);
            jSONObject.put("mobile", internalSession.mobile);
            jSONObject.put("loginId", internalSession.loginId);
            jSONObject.put(LoginConstants.KEY_AUTOLOGINTOKEN, internalSession.autoLoginToken);
            jSONObject.put("topAccessToken", internalSession.topAccessToken);
            jSONObject.put("topAuthCode", internalSession.topAuthCode);
            jSONObject.put("topExpireTime", internalSession.topExpireTime);
            jSONObject.put("ssoToken", internalSession.ssoToken);
            User user = internalSession.user;
            if (user != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AvatarFragment.AVATAR_URL, user.avatarUrl);
                jSONObject2.put("userId", user.userId);
                jSONObject2.put("openId", user.openId);
                jSONObject2.put("openSid", user.openSid);
                jSONObject2.put("nick", user.nick);
                jSONObject2.put("deviceTokenKey", user.deviceTokenKey);
                jSONObject2.put("deviceTokenSalt", user.deviceTokenSalt);
                jSONObject.put(RichTextUtils.USER_SCHEME, jSONObject2);
            }
            Map<String, Object> map = internalSession.otherInfo;
            if (map != null) {
                jSONObject.put("otherInfo", JSONUtils.toJsonObject(map));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
