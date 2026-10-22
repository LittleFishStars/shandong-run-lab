package com.ali.auth.third.core.config;

import com.ali.auth.third.core.model.SNSConfig;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ConfigManager {
    public static boolean DEBUG = false;
    public static String LOGOUT_URLS;
    public static String POSTFIX_OF_SECURITY_JPG_USER_SET;
    public static String appkey;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Environment f23410a;
    Map<String, Object> d;
    private String e;
    private String f;
    private Class<?> g;
    private SNSConfig i;
    public static final Version SDK_VERSION = new Version(2, 0, 0);
    private static final ConfigManager j = new ConfigManager();
    public static String LOGIN_HOST = "https://login.m.taobao.com/minisdk/login.htm";
    public static String bindUrl = "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s";
    public static String unbindUrl = "https://accountlink.taobao.com/sdkUnbind.htm";
    public static String LOGIN_URLS = "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)";
    public static int APP_KEY_INDEX = 0;
    public static int DAILY_APP_KEY_INDEX = 0;
    public static String POSTFIX_OF_SECURITY_JPG = "";
    public static String getQrCodeContentUrl = "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m";
    public static String qrCodeLoginUrl = "https://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    public static String qrCodeLoginUrl_daily = "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    public static String qrLoginConfirmUrl = "https://login.m.taobao.com/qrcodeLogin.htm?shortURL=%s&from=bcqrlogin";
    public static int site = 0;
    private int b = 3;
    private boolean c = true;
    private int h = 0;

    private ConfigManager() {
    }

    public static int getAppKeyIndex() {
        return (getInstance().getEnvironment() == null || !getInstance().getEnvironment().equals(Environment.TEST)) ? APP_KEY_INDEX : DAILY_APP_KEY_INDEX;
    }

    public static int getDailyAppKeyIndex() {
        return DAILY_APP_KEY_INDEX;
    }

    public static ConfigManager getInstance() {
        return j;
    }

    public static int getSite() {
        return site;
    }

    public static void setAppKeyIndex(int i) {
        APP_KEY_INDEX = i;
    }

    public static void setAppKeyIndex(int i, int i2) {
        APP_KEY_INDEX = i;
        DAILY_APP_KEY_INDEX = i2;
    }

    public static void setSite(int i) {
        site = i;
    }

    public SNSConfig getAlipay3Config() {
        return this.i;
    }

    public Environment getEnvironment() {
        return this.f23410a;
    }

    public Class<?> getFullyCustomizedLoginFragment() {
        return this.g;
    }

    public int getMaxHistoryAccount() {
        return this.b;
    }

    public String getOfflineDeviceID() {
        return this.e;
    }

    public int getOrientation() {
        return this.h;
    }

    public String getQrCodeLoginUrl() {
        return (getEnvironment() == null || !getEnvironment().equals(Environment.TEST)) ? qrCodeLoginUrl : qrCodeLoginUrl_daily;
    }

    public Map<String, Object> getScanParams() {
        return this.d;
    }

    public String getSsoToken() {
        return this.f;
    }

    public void init(int i) {
        this.f23410a = Environment.values()[i];
        LOGIN_HOST = new String[]{"https://login.waptest.tbsandbox.com/minisdk/login.htm", "https://login.waptest.taobao.com/minisdk/login.htm", "https://login.wapa.taobao.com/minisdk/login.htm", "https://login.m.taobao.com/minisdk/login.htm"}[i];
        LOGIN_URLS = new String[]{"((https|http)://)login.waptest.tbsandbox.com/login.htm(.*)", "((https|http)://)login.waptest.taobao.com/login.htm(.*)", "((https|http)://)login.wapa.taobao.com/login.htm(.*)", "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)"}[i];
        LOGOUT_URLS = new String[]{"((https|http)://)login.waptest.tbsandbox.com/logout.htm(.*)", "((https|http)://)login.waptest.taobao.com/logout.htm(.*)", "((https|http)://)login.wapa.taobao.com/logout.htm(.*)", "((https|http)://)login.m.taobao.com/logout.htm(.*)"}[i];
        bindUrl = new String[]{"http://login.waptest.tbsandbox.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.waptest.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.wapa.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s"}[i];
        unbindUrl = new String[]{"https://accountlink.daily.taobao.net/sdkUnbind.htm", "https://accountlink.daily.taobao.net/sdkUnbind.htm", "https://accountlink.taobao.com/sdkUnbind.htm", "https://accountlink.taobao.com/sdkUnbind.htm"}[i];
        qrCodeLoginUrl = new String[]{"http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.wapa.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin"}[i];
        getQrCodeContentUrl = new String[]{"http://qrlogin.daily.taobao.net/qrcodelogin/generateNoLoginQRCode.do?lt=m", "http://qrlogin.daily.taobao.net/qrcodelogin/generateNoLoginQRCode.do?lt=m", "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m", "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m"}[i];
        String str = POSTFIX_OF_SECURITY_JPG_USER_SET;
        if (str == null) {
            POSTFIX_OF_SECURITY_JPG = new String[]{"", "", "", ""}[i];
        } else {
            POSTFIX_OF_SECURITY_JPG = str;
        }
    }

    public boolean isSaveHistoryWithSalt() {
        return this.c;
    }

    public void setAlipay3Config(SNSConfig sNSConfig) {
        this.i = sNSConfig;
    }

    public void setFullyCustomizedLoginFragment(Class<?> cls) {
        this.g = cls;
    }

    public void setMaxHistoryAccount(int i) {
        this.b = i;
    }

    public void setOfflineDeviceID(String str) {
        this.e = str;
    }

    public void setOrientation(int i) {
        this.h = i;
    }

    public void setSaveHistoryWithSalt(boolean z) {
        this.c = z;
    }

    public void setScanParams(Map<String, Object> map) {
        this.d = map;
    }

    public void setSsoToken(String str) {
        this.f = str;
    }
}
