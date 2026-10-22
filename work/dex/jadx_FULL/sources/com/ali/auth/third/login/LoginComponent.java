package com.ali.auth.third.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.config.AuthOption;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.LoginCookieUtils;
import com.ali.auth.third.core.history.AccountHistoryManager;
import com.ali.auth.third.core.model.ApplyTokenRequest;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.HistoryAccount;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.LoginTokenResponseData;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.RSAKey;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.core.util.Rsa;
import com.ali.auth.third.core.util.SystemUtils;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.QrLoginActivity;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginComponent {
    public static final LoginComponent INSTANCE = new LoginComponent();

    public class a extends AsyncTask<Object, Void, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23453a;
        final /* synthetic */ Activity b;

        public a(String str, Activity activity) {
            this.f23453a = str;
            this.b = activity;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            SDKLogger.d("login", "showLogin onPostExecute signResult = " + str);
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent();
                intent.setAction(AlibcProtocolConstant.APPLINK_ACTION);
                intent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?&appkey=" + KernelContext.getAppKey() + "&pluginName=taobao.oauth.code.create&apkSign=" + this.f23453a + "&sign=" + str));
                if (this.b.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    try {
                        this.b.startActivityForResult(intent, RequestCode.OPEN_TAOBAO);
                        return;
                    } catch (Throwable th) {
                        SDKLogger.d("login", "startActivityForResult fail == " + th.getMessage());
                    }
                }
            }
            LoginComponent.this.showH5Login(this.b);
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Object... objArr) {
            SDKLogger.d("login", "showLogin doInBackground");
            if (TextUtils.isEmpty(this.f23453a)) {
                return "";
            }
            try {
                return LoginComponent.this.generateTopAppLinkToken(this.f23453a);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    private LoginComponent() {
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(jSONObject.getString(string))) {
                    sb.append("&");
                    sb.append(string);
                    sb.append("=");
                    sb.append(jSONObject.getString(string));
                }
            }
        } catch (JSONException unused) {
        }
        return sb.toString();
    }

    private String a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                sb.append(key);
                sb.append(value);
            }
        }
        return sb.toString();
    }

    public static void addKey(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    public static void applyToken(int i, Map<String, String> map, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mLoginTokenService.applySsoToken";
        rpcRequest.version = "1.1";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.appName = KernelContext.getAppKey();
        applyTokenRequest.site = i;
        applyTokenRequest.t = System.currentTimeMillis();
        applyTokenRequest.sdkVersion = KernelContext.sdkVersion;
        if (map == null) {
            new HashMap();
        }
        rpcRequest.addParam("request", "{}");
        ((RpcService) KernelContext.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginTokenResponseData.class, rpcRequestCallbackWithCode);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static RpcResponse<LoginReturnData> loginByAlipayLoginToken(String str) {
        String deviceId;
        String str2;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.taobao.havana.mlogin.alipayaso";
        rpcRequest.version = "2.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (KernelContext.isMini) {
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                str2 = "app_id";
            } else {
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                str2 = "utdid";
            }
            jSONObject.put(str2, deviceId);
            jSONObject.put("appName", KernelContext.getAppKey());
            jSONObject.put("token", str);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put("site", ConfigManager.getSite());
            try {
                JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                keyValues.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                jSONObject.put(LoginConstants.EXT, keyValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
            rpcRequest.addParam(LoginConstants.EXT, JSONUtils.toJsonObject(new HashMap()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return com.ali.auth.third.login.a.a.c.invoke(rpcRequest, LoginReturnData.class);
    }

    public static RpcResponse<LoginReturnData> loginByRefreshToken() {
        CredentialManager credentialManager = CredentialManager.INSTANCE;
        if (credentialManager.getInternalSession() == null || credentialManager.getInternalSession().user == null) {
            return null;
        }
        return loginByRefreshToken(credentialManager.getInternalSession().user.userId, credentialManager.getInternalSession().autoLoginToken);
    }

    public static RpcResponse<LoginReturnData> loginByRefreshToken(String str, String str2) {
        String deviceId;
        String str3;
        HistoryAccount historyAccountFindHistoryAccount;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mLoginUnitService.autoLogin";
        rpcRequest.version = "1.0";
        try {
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(str)));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", KernelContext.getAppKey());
            jSONObject.put("token", str2);
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("t", "" + jCurrentTimeMillis);
            jSONObject.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            if (KernelContext.isMini) {
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                str3 = "app_id";
            } else {
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                str3 = "utdid";
            }
            jSONObject.put(str3, deviceId);
            if (!TextUtils.isEmpty(str) && (historyAccountFindHistoryAccount = AccountHistoryManager.getInstance().findHistoryAccount(str)) != null) {
                String str4 = historyAccountFindHistoryAccount.tokenKey;
                if (!TextUtils.isEmpty(str4)) {
                    TreeMap<String, String> treeMap = new TreeMap<>();
                    addKey(treeMap, "appKey", KernelContext.getAppKey());
                    addKey(treeMap, LoginConstants.KEY_HAVANAID, historyAccountFindHistoryAccount.userId);
                    addKey(treeMap, "timestamp", String.valueOf(jCurrentTimeMillis));
                    addKey(treeMap, "appVersion", CommonUtils.getAndroidAppVersion());
                    addKey(treeMap, "sdkVersion", KernelContext.sdkVersion);
                    String strSignMap = ((StorageService) KernelContext.getService(StorageService.class)).signMap(str4, treeMap);
                    if (!TextUtils.isEmpty(strSignMap)) {
                        jSONObject.put("deviceTokenSign", strSignMap);
                        jSONObject.put("deviceTokenKey", str4);
                        jSONObject.put("hid", historyAccountFindHistoryAccount.userId);
                    }
                }
            }
            try {
                JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                keyValues.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                keyValues.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                jSONObject.put(LoginConstants.EXT, keyValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
            rpcRequest.addParam(LoginConstants.EXT, new JSONObject());
        } catch (JSONException | Exception e2) {
            e2.printStackTrace();
        }
        return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static RpcResponse<LoginReturnData> loginBySSOToken() {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.com.taobao.mloginService.appOldAutoLogin";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", ConfigManager.getInstance().getSsoToken());
            jSONObject.put("tokenType", "taoTVsso");
            jSONObject.put("site", ConfigManager.getSite());
            rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("hid", "");
        return com.ali.auth.third.login.a.a.c.invoke(rpcRequest, LoginReturnData.class);
    }

    public static RpcResponse<String> logout() {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.taobao.havana.mlogin.logout";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", KernelContext.getAppKey());
            CredentialManager credentialManager = CredentialManager.INSTANCE;
            jSONObject.put(LoginConstants.SID, credentialManager.getInternalSession().sid);
            jSONObject.put(LoginConstants.IP, CommonUtils.getLocalIPAddress());
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(credentialManager.getInternalSession().user.userId)));
            rpcRequest.addParam("request", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String generateTopAppLinkToken(String str) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("appKey", KernelContext.getAppKey());
        treeMap.put("apkSign", str);
        treeMap.put("apiName", "taobao.oauth.code.create");
        String strA = a(treeMap);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.alibaba.havana.login.applink.generateTopAppLinkToken";
        rpcRequest.version = "1.0";
        String appKey = KernelContext.getAppKey();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", appKey);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            if (KernelContext.isMini) {
                jSONObject.put("app_id", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            }
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            rpcRequest.addParam("baseInfo", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("content", strA);
        try {
            RpcResponse rpcResponseInvoke = ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
            if (rpcResponseInvoke != null) {
                return (String) rpcResponseInvoke.returnValue;
            }
            return null;
        } catch (RpcException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    public void goQrCodeLogin(Activity activity, Map<String, Object> map) {
        Class cls;
        SDKLogger.d("login", "goQrCodeLogin start");
        if (map == null) {
            cls = QrLoginActivity.class;
        } else {
            if (TextUtils.isEmpty(map.get(Constants.USER_ACTIVITY) == null ? "" : (String) map.get(Constants.USER_ACTIVITY))) {
                cls = QrLoginActivity.class;
            } else {
                try {
                    cls = Class.forName((String) map.get(Constants.USER_ACTIVITY));
                } catch (ClassNotFoundException unused) {
                    cls = QrLoginActivity.class;
                }
            }
        }
        Intent intent = new Intent(activity, (Class<?>) cls);
        StringBuilder sb = new StringBuilder(String.format(ConfigManager.qrCodeLoginUrl, KernelContext.getAppKey()));
        if (map != null) {
            if (!TextUtils.isEmpty(map.get("domain") == null ? "" : (String) map.get("domain"))) {
                sb.append(LoginConstants.UNDER_LINE);
                sb.append(map.get("domain"));
            }
        }
        if (map != null) {
            if (!TextUtils.isEmpty(map.get("config") == null ? "" : (String) map.get("config"))) {
                String strA = a((String) map.get("config"));
                sb.append(TextUtils.isEmpty(strA) ? "" : strA);
            }
        }
        intent.putExtra("qrCodeLoginUrl", sb.toString());
        intent.putExtra("passwordLoginUrl", ConfigManager.LOGIN_HOST);
        activity.startActivityForResult(intent, RequestCode.OPEN_QR_LOGIN);
    }

    public RpcResponse<LoginReturnData> loginByCode(String str) {
        String deviceId;
        String str2;
        try {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TOP_TOKEN_LOGIN, null);
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "com.taobao.mtop.mloginService.topTokenLogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                    str2 = "app_id";
                } else {
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                    str2 = "utdid";
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("t", "" + System.currentTimeMillis());
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
                try {
                    JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                    keyValues.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                    keyValues.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                    jSONObject.put(LoginConstants.EXT, keyValues);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
                rpcRequest.addParam(LoginConstants.EXT, new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public RpcResponse<LoginReturnData> loginByIVToken(String str, String str2, String str3) {
        String deviceId;
        String str4;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mloginService.mloginTokenLogin";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (KernelContext.isMini) {
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                str4 = "app_id";
            } else {
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                str4 = "utdid";
            }
            jSONObject.put(str4, deviceId);
            jSONObject.put("appName", KernelContext.getAppKey());
            jSONObject.put("token", str);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("scene", str2);
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            try {
                JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                keyValues.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                keyValues.put(Constants.QUERY_STRING, str3);
                keyValues.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                jSONObject.put(LoginConstants.EXT, keyValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
            rpcRequest.addParam(LoginConstants.EXT, JSONUtils.toJsonObject(new HashMap()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return com.ali.auth.third.login.a.a.c.invoke(rpcRequest, LoginReturnData.class);
    }

    public RpcResponse<LoginReturnData> loginByQRCode(String str, long j, boolean z) {
        String deviceId;
        String str2;
        try {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "mtop.taobao.havana.mlogin.qrcodelogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                    str2 = "app_id";
                } else {
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                    str2 = "utdid";
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("t", "" + j);
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
                rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("supportNativeIvOnly", z);
                jSONObject3.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                rpcRequest.addParam(LoginConstants.EXT, jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public RpcResponse<LoginReturnData> loginBySsoToken(String str) {
        String deviceId;
        String str2;
        try {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_SSO_TOKEN_LOGIN, null);
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "com.taobao.mtop.mloginService.ssoLogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                    str2 = "app_id";
                } else {
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                    str2 = "utdid";
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put("tokenType", "ssoToken");
                jSONObject.put("scene", "");
                jSONObject.put("ttid", "");
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceName", Build.MODEL);
                    jSONObject2.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                    jSONObject.put(LoginConstants.EXT, jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rpcRequest.addParam(LoginConstants.TOKEN_INFO, jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject3);
                rpcRequest.addParam(LoginConstants.EXT, new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:53:0x017c A[Catch: JSONException -> 0x01b4, TRY_ENTER, TryCatch #0 {JSONException -> 0x01b4, blocks: (B:50:0x016d, B:53:0x017c, B:55:0x019d, B:54:0x0190), top: B:67:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0190 A[Catch: JSONException -> 0x01b4, TryCatch #0 {JSONException -> 0x01b4, blocks: (B:50:0x016d, B:53:0x017c, B:55:0x019d, B:54:0x0190), top: B:67:0x016d }] */
    public RpcResponse<LoginReturnData> loginByUserName(String str) throws Throwable {
        Class cls;
        RpcRequest rpcRequest;
        RpcRequest rpcRequest2;
        String deviceId;
        String str2;
        String str3;
        RpcRequest rpcRequest3;
        JSONObject jSONObject;
        HistoryAccount historyAccountMatchHistoryAccount;
        RpcRequest rpcRequest4 = new RpcRequest();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String strOptString = JSONUtils.optString(jSONObject2, "loginid");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = JSONUtils.optString(jSONObject2, "loginId");
            }
            rpcRequest4.target = "com.taobao.mtop.mloginService.login";
            rpcRequest4.version = "1.0";
            JSONObject jSONObject3 = new JSONObject();
            if (KernelContext.isMini) {
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                str2 = "app_id";
            } else {
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                str2 = "utdid";
            }
            jSONObject3.put(str2, deviceId);
            jSONObject3.put("appName", KernelContext.getAppKey());
            jSONObject3.put("loginId", strOptString);
            jSONObject3.put(LoginConstants.CLIENT_IP, CommonUtils.getLocalIPAddress());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(strOptString) || (historyAccountMatchHistoryAccount = AccountHistoryManager.getInstance().matchHistoryAccount(strOptString)) == null) {
                str3 = "ua";
                cls = RpcService.class;
                rpcRequest3 = rpcRequest4;
                jSONObject3.put("password", Rsa.encrypt(JSONUtils.optString(jSONObject2, "password"), RSAKey.getRsaPubkey()));
                jSONObject3.put("pwdEncrypted", true);
                jSONObject3.put("appVersion", CommonUtils.getAndroidAppVersion());
                jSONObject3.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject3.put("t", jCurrentTimeMillis + "");
                jSONObject3.put("ccId", JSONUtils.optString(jSONObject2, "checkCodeId"));
                jSONObject3.put("checkCode", JSONUtils.optString(jSONObject2, "checkCode"));
                try {
                    JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                    keyValues.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                    keyValues.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                    jSONObject3.put(LoginConstants.EXT, keyValues);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rpcRequest = rpcRequest3;
                try {
                    rpcRequest.addParam(LoginConstants.PARAN_LOGIN_INFO, jSONObject3);
                    jSONObject = new JSONObject();
                    if (KernelContext.isMini) {
                        String strOptString2 = JSONUtils.optString(jSONObject2, Constants.UMID);
                        jSONObject.put(LoginConstants.UMID_TOKEN, strOptString2);
                        ((StorageService) KernelContext.getService(StorageService.class)).setUmid(strOptString2);
                    } else {
                        jSONObject.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                    }
                    String str4 = str3;
                    jSONObject.put(str4, JSONUtils.optString(jSONObject2, str4));
                    rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject);
                    rpcRequest.addParam(LoginConstants.EXT, new JSONObject());
                    rpcRequest2 = rpcRequest;
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    rpcRequest2 = rpcRequest;
                }
            } else {
                String str5 = historyAccountMatchHistoryAccount.tokenKey;
                if (TextUtils.isEmpty(str5)) {
                    str3 = "ua";
                    cls = RpcService.class;
                    rpcRequest3 = rpcRequest4;
                } else {
                    cls = RpcService.class;
                    try {
                        TreeMap<String, String> treeMap = new TreeMap<>();
                        str3 = "ua";
                        rpcRequest3 = rpcRequest4;
                        try {
                            addKey(treeMap, "appKey", KernelContext.getAppKey());
                            addKey(treeMap, LoginConstants.KEY_HAVANAID, historyAccountMatchHistoryAccount.userId);
                            addKey(treeMap, "timestamp", String.valueOf(jCurrentTimeMillis));
                            addKey(treeMap, "appVersion", CommonUtils.getAndroidAppVersion());
                            addKey(treeMap, "sdkVersion", KernelContext.sdkVersion);
                            String strSignMap = ((StorageService) KernelContext.getService(StorageService.class)).signMap(str5, treeMap);
                            if (!TextUtils.isEmpty(strSignMap)) {
                                jSONObject3.put("deviceTokenSign", strSignMap);
                                jSONObject3.put("deviceTokenKey", str5);
                                jSONObject3.put("hid", historyAccountMatchHistoryAccount.userId);
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            rpcRequest = rpcRequest3;
                            e.printStackTrace();
                            rpcRequest2 = rpcRequest;
                            return ((RpcService) KernelContext.getService(cls)).invoke(rpcRequest2, LoginReturnData.class);
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        rpcRequest = rpcRequest4;
                        e.printStackTrace();
                        rpcRequest2 = rpcRequest;
                        return ((RpcService) KernelContext.getService(cls)).invoke(rpcRequest2, LoginReturnData.class);
                    }
                }
                jSONObject3.put("password", Rsa.encrypt(JSONUtils.optString(jSONObject2, "password"), RSAKey.getRsaPubkey()));
                jSONObject3.put("pwdEncrypted", true);
                jSONObject3.put("appVersion", CommonUtils.getAndroidAppVersion());
                jSONObject3.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject3.put("t", jCurrentTimeMillis + "");
                jSONObject3.put("ccId", JSONUtils.optString(jSONObject2, "checkCodeId"));
                jSONObject3.put("checkCode", JSONUtils.optString(jSONObject2, "checkCode"));
                JSONObject keyValues2 = LoginCookieUtils.getKeyValues("alimm_");
                keyValues2.put(LoginConstants.MIID, LoginCookieUtils.getValue(LoginConstants.MIID));
                keyValues2.put(LoginConstants.SDK_PLATFORM, "baichuan_mp");
                jSONObject3.put(LoginConstants.EXT, keyValues2);
                rpcRequest = rpcRequest3;
                rpcRequest.addParam(LoginConstants.PARAN_LOGIN_INFO, jSONObject3);
                jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    String strOptString3 = JSONUtils.optString(jSONObject2, Constants.UMID);
                    jSONObject.put(LoginConstants.UMID_TOKEN, strOptString3);
                    ((StorageService) KernelContext.getService(StorageService.class)).setUmid(strOptString3);
                } else {
                    jSONObject.put(LoginConstants.UMID_TOKEN, ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                }
                String str6 = str3;
                jSONObject.put(str6, JSONUtils.optString(jSONObject2, str6));
                rpcRequest.addParam(LoginConstants.RISK_CONTROL_INFO, jSONObject);
                rpcRequest.addParam(LoginConstants.EXT, new JSONObject());
                rpcRequest2 = rpcRequest;
            }
        } catch (JSONException e5) {
            e = e5;
            cls = RpcService.class;
        }
        return ((RpcService) KernelContext.getService(cls)).invoke(rpcRequest2, LoginReturnData.class);
    }

    public void showH5Login(Activity activity) {
        SDKLogger.d("login", "open H5 login");
        Intent intent = new Intent(activity, (Class<?>) LoginWebViewActivity.class);
        intent.putExtra("url", ConfigManager.LOGIN_HOST);
        intent.putExtra("title", ResourceUtils.getString(activity.getApplicationContext(), "com_taobao_tae_sdk_authorize_title"));
        activity.startActivityForResult(intent, RequestCode.OPEN_H5_LOGIN);
    }

    public void showLogin(Activity activity) {
        SDKLogger.d("login", "showLogin");
        AuthOption authOption = KernelContext.sOneTimeAuthOption;
        AuthOption authOption2 = AuthOption.H5ONLY;
        if (authOption == authOption2) {
            showH5Login(activity);
            return;
        }
        if (KernelContext.authOption == authOption2) {
            showH5Login(activity);
            return;
        }
        a aVar = new a(SystemUtils.getApkSignNumber(), activity);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        aVar.executeOnExecutor(executor, new Object[0]);
    }
}
