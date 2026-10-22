package com.ali.auth.third.core.service.impl;

import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.CookieManagerWrapper;
import com.ali.auth.third.core.history.AccountHistoryManager;
import com.ali.auth.third.core.model.AccountContract;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.DeviceTokenRO;
import com.ali.auth.third.core.model.HistoryAccount;
import com.ali.auth.third.core.model.InternalSession;
import com.ali.auth.third.core.model.LoginDataModel;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.model.User;
import com.ali.auth.third.core.registry.a;
import com.ali.auth.third.core.service.CredentialService;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.ReflectionUtils;
import com.ali.auth.third.core.util.SystemUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CredentialManager implements CredentialService {
    public static final CredentialManager INSTANCE = new CredentialManager();
    private static final String b = "CredentialManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile InternalSession f23431a;
    public String internalSessionStoreKey = "internal_session";

    public CredentialManager() {
        try {
            a();
        } catch (Throwable unused) {
            this.f23431a = new InternalSession();
            this.f23431a.user = new User();
        }
    }

    private Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a() {
        if (KernelContext.storageService == null) {
            a(KernelContext.serviceRegistry);
        }
        String str = b;
        SDKLogger.d(str, "CredentialManager init step 1");
        String value = KernelContext.storageService.getValue("loginEnvironmentIndex", true);
        SDKLogger.d(str, "CredentialManager init step 2");
        String strValueOf = String.valueOf(KernelContext.getEnvironment().ordinal());
        if (value != null && !value.equals(strValueOf)) {
            KernelContext.storageService.putValue("loginEnvironmentIndex", strValueOf, true);
            KernelContext.storageService.removeValue(this.internalSessionStoreKey, true);
            this.f23431a = new InternalSession();
            this.f23431a.user = new User();
            return;
        }
        SDKLogger.d(str, "CredentialManager init step 3");
        String value2 = KernelContext.storageService.getValue(this.internalSessionStoreKey, true);
        SDKLogger.d(str, "CredentialManager init step 4");
        if (TextUtils.isEmpty(value2)) {
            value2 = KernelContext.storageService.getValue(this.internalSessionStoreKey, true);
        }
        if (TextUtils.isEmpty(value2)) {
            this.f23431a = new InternalSession();
            this.f23431a.user = new User();
        } else {
            this.f23431a = createInternalSession(value2);
        }
        SDKLogger.d(str, "CredentialManager init step 5");
    }

    private void a(InternalSession internalSession) {
        this.f23431a = internalSession;
        KernelContext.storageService.putValue(this.internalSessionStoreKey, SystemUtils.toInternalSessionJSON(internalSession), true);
    }

    private void a(a aVar) {
        try {
            KernelContext.isMini = false;
            KernelContext.sdkVersion = KernelContext.SDK_VERSION_STD;
        } catch (Throwable unused) {
        }
        try {
            aVar.a(new Class[]{StorageService.class}, a("com.ali.auth.third.securityguard.SecurityGuardWrapper", null, null), null);
            KernelContext.storageService = (StorageService) aVar.a(StorageService.class, null);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    public long adjustSessionExpireTime(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis > j2) {
            return j > 0 ? j + (jCurrentTimeMillis - j2) : AppInfoCenterInternal.f24637a + jCurrentTimeMillis;
        }
        return j;
    }

    public InternalSession createInternalSession(String str) {
        InternalSession internalSession = new InternalSession();
        try {
            JSONObject jSONObject = new JSONObject(str);
            internalSession.sid = JSONUtils.optString(jSONObject, LoginConstants.SID);
            internalSession.expireIn = JSONUtils.optInteger(jSONObject, "expireIn").intValue();
            User user = new User();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(RichTextUtils.USER_SCHEME);
            if (jSONObjectOptJSONObject != null) {
                user.avatarUrl = jSONObjectOptJSONObject.optString(AvatarFragment.AVATAR_URL);
                user.userId = jSONObjectOptJSONObject.optString("userId");
                user.nick = jSONObjectOptJSONObject.optString("nick");
                user.openId = jSONObjectOptJSONObject.optString("openId");
                user.openSid = jSONObjectOptJSONObject.optString("openSid");
                user.deviceTokenKey = jSONObjectOptJSONObject.optString("deviceTokenKey");
                user.deviceTokenSalt = jSONObjectOptJSONObject.optString("deviceTokenSalt");
                if (!TextUtils.isEmpty(internalSession.sid) && !TextUtils.isEmpty(user.userId)) {
                    ((RpcService) KernelContext.getService(RpcService.class)).registerSessionInfo(internalSession.sid, user.userId);
                }
            }
            internalSession.user = user;
            internalSession.loginTime = JSONUtils.optLong(jSONObject, "loginTime").longValue();
            internalSession.mobile = JSONUtils.optString(jSONObject, "mobile");
            internalSession.loginId = JSONUtils.optString(jSONObject, "loginId");
            internalSession.autoLoginToken = JSONUtils.optString(jSONObject, LoginConstants.KEY_AUTOLOGINTOKEN);
            internalSession.topAccessToken = JSONUtils.optString(jSONObject, "topAccessToken");
            internalSession.topExpireTime = JSONUtils.optString(jSONObject, "topExpireTime");
            internalSession.topAuthCode = JSONUtils.optString(jSONObject, "topAuthCode");
            internalSession.otherInfo = JSONUtils.toMap(jSONObject.optJSONObject("otherInfo"));
            internalSession.ssoToken = JSONUtils.optString(jSONObject, "ssoToken");
            internalSession.havanaSsoToken = JSONUtils.optString(jSONObject, "havanaSsoToken");
        } catch (Exception e) {
            SDKLogger.e(b, e.getMessage(), e);
        }
        return internalSession;
    }

    public InternalSession getInternalSession() {
        return this.f23431a;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public Session getSession() {
        Session session = new Session();
        session.userid = (this.f23431a == null || this.f23431a.user == null) ? "" : this.f23431a.user.userId;
        session.nick = (this.f23431a == null || this.f23431a.user == null) ? "" : this.f23431a.user.nick;
        session.avatarUrl = (this.f23431a == null || this.f23431a.user == null) ? "" : this.f23431a.user.avatarUrl;
        session.openId = (this.f23431a == null || this.f23431a.user == null) ? "" : this.f23431a.user.openId;
        session.openSid = (this.f23431a == null || this.f23431a.user == null) ? "" : this.f23431a.user.openSid;
        session.topAccessToken = this.f23431a == null ? "" : this.f23431a.topAccessToken;
        session.topAuthCode = this.f23431a == null ? "" : this.f23431a.topAuthCode;
        session.topExpireTime = this.f23431a == null ? "" : this.f23431a.topExpireTime;
        session.ssoToken = this.f23431a == null ? "" : this.f23431a.ssoToken;
        session.havanaSsoToken = this.f23431a != null ? this.f23431a.havanaSsoToken : "";
        return session;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public boolean isSessionValid() {
        String str;
        String str2 = b;
        SDKLogger.d(str2, "func isSessionValid");
        if (this.f23431a == null) {
            str = "isSessionValid()  internalSession is null";
        } else {
            if (this.f23431a.loginTime != 0 && this.f23431a.expireIn != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("isSessionValid()  ");
                sb.append(System.currentTimeMillis() / 1000 < this.f23431a.expireIn);
                SDKLogger.d(str2, sb.toString());
                return System.currentTimeMillis() / 1000 < this.f23431a.expireIn;
            }
            str = "isSessionValid()  loginTime is 0 or expireIn is 0";
        }
        SDKLogger.d(str2, str);
        return false;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public ResultCode logout() {
        CookieManagerWrapper.INSTANCE.clearCookies();
        InternalSession internalSession = new InternalSession();
        internalSession.user = new User();
        a(internalSession);
        return ResultCode.SUCCESS;
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public void refreshWhenLogin(LoginReturnData loginReturnData) {
        String[] strArr;
        if (loginReturnData == null || TextUtils.isEmpty(loginReturnData.data)) {
            return;
        }
        Constants.mBusyControl = System.currentTimeMillis();
        InternalSession internalSession = new InternalSession();
        try {
            LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
            internalSession.externalCookies = loginDataModel.externalCookies;
            User user = new User();
            user.userId = loginDataModel.userId;
            String str = loginDataModel.nick;
            if (str != null) {
                try {
                    user.nick = URLDecoder.decode(str, "UTF-8");
                } catch (Exception e) {
                    SDKLogger.e(b, e.getMessage(), e);
                }
            }
            user.openId = loginDataModel.openId;
            user.openSid = loginDataModel.openSid;
            user.avatarUrl = loginDataModel.headPicLink;
            user.email = loginDataModel.email;
            Map<String, String> map = loginDataModel.loginServiceExt;
            if (map != null && !TextUtils.isEmpty(map.get("1688ext"))) {
                try {
                    JSONObject jSONObject = new JSONObject(loginDataModel.loginServiceExt.get("1688ext"));
                    user.cbuLoginId = jSONObject.optString("loginId");
                    user.memberId = jSONObject.optString("memberId");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            DeviceTokenRO deviceTokenRO = loginReturnData.deviceToken;
            if (deviceTokenRO != null) {
                user.deviceTokenSalt = deviceTokenRO.salt;
                user.deviceTokenKey = deviceTokenRO.key;
            }
            AccountHistoryManager.getInstance().putLoginHistory(new HistoryAccount(loginDataModel.userId, user.deviceTokenKey, loginDataModel.nick, loginDataModel.phone, loginDataModel.email, loginDataModel.autoLoginToken, loginDataModel.headPicLink), user.deviceTokenSalt);
            internalSession.user = user;
            long j = loginDataModel.loginTime;
            internalSession.loginTime = j;
            internalSession.sid = loginDataModel.sid;
            internalSession.expireIn = adjustSessionExpireTime(loginDataModel.expires, j);
            internalSession.mobile = loginDataModel.loginPhone;
            internalSession.loginId = loginReturnData.showLoginId;
            internalSession.autoLoginToken = loginDataModel.autoLoginToken;
            internalSession.topAccessToken = loginDataModel.topAccessToken;
            internalSession.topAuthCode = loginDataModel.topAuthCode;
            internalSession.topExpireTime = loginDataModel.topExpireTime;
            internalSession.otherInfo = loginDataModel.extendAttribute;
            internalSession.ssoToken = loginReturnData.ssoToken;
            internalSession.havanaSsoToken = loginDataModel.havanaSsoToken;
            ((RpcService) KernelContext.getService(RpcService.class)).registerSessionInfo(loginDataModel.sid, loginDataModel.userId);
            try {
                Object obj = loginDataModel.extendAttribute.get("ssoDomainList");
                strArr = (obj == null || !(obj instanceof ArrayList)) ? null : (String[]) ((ArrayList) obj).toArray(new String[0]);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            CookieManagerWrapper.INSTANCE.injectCookie(loginDataModel.cookies, strArr);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        SDKLogger.e("session", "session = " + internalSession.toString());
        a(internalSession);
    }

    @Override // com.ali.auth.third.core.service.CredentialService
    public void refreshWhenOfflineLogin(AccountContract accountContract) {
        InternalSession internalSession = new InternalSession();
        User user = new User();
        user.nick = KernelContext.storageService.decrypt(accountContract.getNick());
        user.openId = accountContract.getOpenid();
        user.userId = KernelContext.storageService.decrypt(accountContract.getUserid());
        internalSession.user = user;
        if (this.f23431a == null || this.f23431a.user == null || !TextUtils.equals(user.userId, this.f23431a.user.userId)) {
            ((RpcService) KernelContext.getService(RpcService.class)).logout();
        } else {
            internalSession.autoLoginToken = this.f23431a.autoLoginToken;
        }
        a(internalSession);
    }
}
