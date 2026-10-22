package com.baidu.mapauto.auth.base;

import android.text.TextUtils;
import com.aliyun.credentials.utils.AuthConstant;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.base.b;
import com.baidu.mapauto.auth.constant.ErrorCode;
import com.baidu.mapauto.auth.util.LogUtil;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class BaseLicenseAuthDataStandardProcess<T extends b, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26595a;

    public static class ProcessException extends Exception {
        private final int mCode;

        public ProcessException(int i, String str) {
            super(str);
            this.mCode = i;
        }

        public int getCode() {
            return this.mCode;
        }
    }

    public BaseLicenseAuthDataStandardProcess(int i) {
        this.f26595a = i;
    }

    public abstract T a(String str);

    public abstract ArrayList a(int i, AuthCore.AuthParam authParam, b bVar);

    public final Map<String, Integer> a(AuthCore.AuthParam authParam) throws ProcessException {
        com.baidu.mapauto.auth.net.b bVarC;
        int i;
        Integer num;
        LogUtil logUtil;
        String str;
        boolean z = true;
        if ((this.f26595a & 1) == 1) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始请求 license  服务 ==>");
            KeyPair keyPairGenerateKeyPair = RSAUtil.generateKeyPair();
            if (keyPairGenerateKeyPair == null) {
                logUtil = LogUtil.getInstance();
                str = "生成公私钥错误";
            } else {
                String publicKeyCS1Pem = RSAUtil.getPublicKeyCS1Pem(keyPairGenerateKeyPair.getPublic());
                if (publicKeyCS1Pem == null) {
                    logUtil = LogUtil.getInstance();
                    str = "生成公钥为空";
                } else {
                    authParam.put(com.alipay.sdk.m.t.e.o, publicKeyCS1Pem);
                    try {
                        authParam.put(AuthConstant.INI_PRIVATE_KEY, RSAUtil.getPrivateKeyStr(keyPairGenerateKeyPair.getPrivate()));
                        int i2 = 1;
                        while (true) {
                            try {
                                bVarC = c(authParam);
                            } catch (Exception e) {
                                LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e.toString());
                                com.baidu.mapauto.auth.net.b bVar = new com.baidu.mapauto.auth.net.b();
                                bVar.d = e;
                                bVarC = bVar;
                            }
                            if (i2 >= 3) {
                                break;
                            }
                            if (!((bVarC != null && bVarC.d == null && (num = bVarC.f26601a) != null && num.intValue() == 200) ? TextUtils.isEmpty(bVarC.c) : true)) {
                                break;
                            }
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e2) {
                                LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e2.toString());
                            }
                            i2++;
                        }
                    } catch (Exception e3) {
                        LogUtil.getInstance().e("BaseLicenseAuthDataStandardProcess", e3.toString());
                        bVarC = null;
                    }
                }
                LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== license 服务返回结果:" + bVarC);
                i = 0;
            }
            logUtil.i("BaseLicenseAuthDataStandardProcess", str);
            bVarC = null;
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== license 服务返回结果:" + bVarC);
            i = 0;
        } else {
            bVarC = null;
            i = -1;
        }
        String strB = bVarC == null ? "" : bVarC.c;
        if (TextUtils.isEmpty(strB) && (this.f26595a & 2) == 2) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "尝试从本地缓存获取 ==>");
            strB = b(authParam);
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "<== 本地缓存服务返回结果:" + strB);
            i = 1;
        }
        if (i == -1) {
            return new HashMap(0);
        }
        if (TextUtils.isEmpty(strB)) {
            if (bVarC == null) {
                throw new ProcessException(-1001, "获取数据异常");
            }
            Exception exc = bVarC.d;
            if (exc instanceof SocketTimeoutException) {
                throw new ProcessException(ErrorCode.CODE_NET_WORK_TIMEOUT, "网络超时");
            }
            if ((exc instanceof HttpRetryException) || (exc instanceof MalformedURLException) || (exc instanceof ProtocolException) || (exc instanceof URISyntaxException) || (exc instanceof SocketException)) {
                throw new ProcessException(ErrorCode.CODE_NET_WORK_ERROR, "网络链接异常");
            }
            if ((exc instanceof UnknownHostException) || (exc instanceof UnknownServiceException)) {
                throw new ProcessException(ErrorCode.CODE_SERVER_ERROR, "服务异常");
            }
            throw new ProcessException(-1000, "网络未知异常");
        }
        b bVarA = a(strB);
        JSONObject jSONObject = bVarA.b;
        if (jSONObject == null) {
            throw new ProcessException(-1001, a(bVarC, "license 数据解析错误"));
        }
        if (!(jSONObject != null && jSONObject.optInt("status", -1) == 0)) {
            JSONObject jSONObject2 = bVarA.b;
            int iOptInt = jSONObject2 != null ? jSONObject2.optInt("status", -1) : -1;
            JSONObject jSONObject3 = bVarA.b;
            String strOptString = jSONObject3 != null ? jSONObject3.optString("message") : null;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "license 数据服务错误";
            }
            throw new ProcessException(iOptInt, a(bVarC, strOptString));
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "开始校验 license 数据");
        ArrayList<a> arrayListA = a(i, authParam, bVarA);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            for (a aVar : arrayListA) {
                int i3 = aVar.f26596a;
                AuthCore.AuthParam authParam2 = aVar.b;
                T t = aVar.c;
                if (!(((i3 != 0 && i3 != 1) || authParam2 == null || t == 0) ? false : aVar.a(i3, authParam2, t))) {
                    z = false;
                    break;
                }
            }
        }
        if (!z) {
            throw new ProcessException(ErrorCode.CODE_CHECK_SIGN_ERROR, a(bVarC, "license 校验失败"));
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "校验 license 数据完成");
        if (i == 0) {
            LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "更新本地 license 缓存");
            a(authParam, bVarA);
        }
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点开始");
        a(bVarA);
        LogUtil.getInstance().i("BaseLicenseAuthDataStandardProcess", "数据通过接入点结束");
        return b(bVarA);
    }

    public void a(b bVar) throws ProcessException {
    }

    public abstract boolean a(AuthCore.AuthParam authParam, T t);

    public abstract String b(AuthCore.AuthParam authParam);

    public abstract HashMap b(b bVar);

    public abstract com.baidu.mapauto.auth.net.b c(AuthCore.AuthParam authParam) throws Exception;

    public static String a(com.baidu.mapauto.auth.net.b bVar, String str) {
        Integer num;
        if (bVar == null || (num = bVar.f26601a) == null || num.intValue() == 200) {
            return str;
        }
        return "(" + num + ")" + str;
    }
}
