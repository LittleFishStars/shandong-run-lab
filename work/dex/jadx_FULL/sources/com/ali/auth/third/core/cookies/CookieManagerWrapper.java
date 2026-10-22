package com.ali.auth.third.core.cookies;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.FileUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CookieManagerWrapper {
    public static final CookieManagerWrapper INSTANCE = new CookieManagerWrapper();
    private static final String b = "CookieManagerWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f23412a;

    private CookieManagerWrapper() {
    }

    public void clearCookies() {
        String[] strArr;
        Object obj;
        SDKLogger.e("clearCookies", "into clearCookies ");
        CookieSyncManager.createInstance(KernelContext.getApplicationContext());
        SDKLogger.e("clearCookies", "into clearCookies removeSessionCookie finish");
        if (this.f23412a == null) {
            String fileData = FileUtils.readFileData(KernelContext.getApplicationContext(), Constants.COOKIES);
            if (!TextUtils.isEmpty(fileData)) {
                SDKLogger.d(b, "get cookie from storage:" + fileData);
                this.f23412a = TextUtils.split(fileData, Constants.COOKIE_SPLIT);
            }
        }
        SDKLogger.e("clearCookies", "into clearCookies readFileData finish");
        if (this.f23412a != null) {
            ArrayList<c> arrayList = new ArrayList();
            for (String str : this.f23412a) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        c cookie = LoginCookieUtils.parseCookie(str);
                        if (!"munb".equals(cookie.c)) {
                            String httpDomin = LoginCookieUtils.getHttpDomin(cookie);
                            LoginCookieUtils.expiresCookies(cookie);
                            a.a().setCookie(httpDomin, cookie.toString());
                            if (TextUtils.equals(cookie.f23416a, ".taobao.com")) {
                                arrayList.add(cookie);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                CredentialManager credentialManager = CredentialManager.INSTANCE;
                strArr = (credentialManager.getInternalSession().otherInfo == null || (obj = credentialManager.getInternalSession().otherInfo.get("ssoDomainList")) == null || !(obj instanceof ArrayList)) ? null : (String[]) ((ArrayList) obj).toArray(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (strArr != null && strArr.length > 0 && !arrayList.isEmpty()) {
                for (c cVar : arrayList) {
                    String str2 = cVar.f23416a;
                    for (String str3 : strArr) {
                        if (!"munb".equals(cVar.c)) {
                            cVar.f23416a = str3;
                            String httpDomin2 = LoginCookieUtils.getHttpDomin(cVar);
                            LoginCookieUtils.expiresCookies(cVar);
                            a.a().setCookie(httpDomin2, cVar.toString());
                        }
                    }
                    cVar.f23416a = str2;
                }
            }
            SDKLogger.d(b, "injectCookie cookies is null");
            this.f23412a = null;
            FileUtils.writeFileData(KernelContext.getApplicationContext(), Constants.COOKIES, "");
        }
        SDKLogger.e("clearCookies", "into clearCookies reset cookie finish");
        a.a().removeExpiredCookie();
        SDKLogger.e("clearCookies", "into clearCookies removeExpiredCookie finish");
        a.a().flush();
        SDKLogger.e("clearCookies", "into clearCookies  finish");
    }

    public synchronized void injectCookie(String[] strArr, String[] strArr2) {
        this.f23412a = strArr;
        if (KernelContext.context != null) {
            if (strArr != null) {
                SDKLogger.d(b, "injectCookie cookies != null");
                ArrayList<c> arrayList = new ArrayList();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            c cookie = LoginCookieUtils.parseCookie(str);
                            String httpDomin = LoginCookieUtils.getHttpDomin(cookie);
                            String string = cookie.toString();
                            SDKLogger.d(b, "add cookie: " + string);
                            a.a().setCookie(httpDomin, string);
                            if (TextUtils.equals(cookie.f23416a, ".taobao.com")) {
                                arrayList.add(cookie);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (strArr2 != null && strArr2.length > 0 && !arrayList.isEmpty()) {
                    for (c cVar : arrayList) {
                        String str2 = cVar.f23416a;
                        for (String str3 : strArr2) {
                            cVar.f23416a = str3;
                            String httpDomin2 = LoginCookieUtils.getHttpDomin(cVar);
                            String string2 = cVar.toString();
                            SDKLogger.d(b, "add cookies to domain:" + str3 + ", cookie = " + string2);
                            a.a().setCookie(httpDomin2, string2);
                        }
                        cVar.f23416a = str2;
                    }
                }
                a.a().flush();
                if (this.f23412a != null) {
                    FileUtils.writeFileData(KernelContext.context, Constants.COOKIES, TextUtils.join(Constants.COOKIE_SPLIT, strArr));
                }
            } else {
                clearCookies();
            }
        }
    }

    public synchronized void refreshCookie() {
        if (this.f23412a == null) {
            try {
                String fileData = FileUtils.readFileData(KernelContext.getApplicationContext(), Constants.COOKIES);
                if (!TextUtils.isEmpty(fileData)) {
                    SDKLogger.d(b, "get cookie from storage:" + fileData);
                    this.f23412a = TextUtils.split(fileData, Constants.COOKIE_SPLIT);
                }
            } catch (Throwable unused) {
            }
        }
        String[] strArr = this.f23412a;
        if (strArr != null) {
            injectCookie(strArr, null);
        }
    }
}
