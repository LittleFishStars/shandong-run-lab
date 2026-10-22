package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.a7;
import com.beizi.fusion.co;
import com.beizi.fusion.ek;
import com.beizi.fusion.oo;
import com.beizi.fusion.so;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DevInfo {
    private static final String KEY_SDK_UID_NEW = "SDK_UID_KEY_NEW";
    private static final String KEY_SDK_UID_ORIG = "SDK_UID_KEY";
    private static final int algorithmVersion = 1;
    private String cnOaid;
    private Context context;
    private String density;
    private String densityDpi;
    private String devType;
    private String gaid;
    private String honorOaid;
    private String language;
    private String msaOaid;
    private String oaid;
    private String resolution;
    private String romVersion;
    private String root;
    private String screenSize;
    private String sdkUID;
    private String sdkUIDOrig;
    private String smOaid;
    private String os = a7.a();
    private String platform = "2";
    private String brand = a7.b();
    private String model = a7.d();

    public DevInfo(Context context) {
        this.context = context;
        this.sdkUID = co.b(context, KEY_SDK_UID_NEW);
        this.sdkUIDOrig = co.b(context, KEY_SDK_UID_ORIG);
        this.devType = a7.a(context);
        getScreenInformation(context);
        this.language = Locale.getDefault().getLanguage();
        this.root = so.b();
        if (TextUtils.isEmpty(this.sdkUID)) {
            generateSdkUID(context, this.brand, this.model);
        }
        this.romVersion = getCurrentRomVersion();
    }

    private String generateCurrentTimeMillis() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }

    private String generateFourDigitRandom() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    private void generateSdkUID(Context context, String str, String str2) {
        String strGenerateFourDigitRandom = generateFourDigitRandom();
        String strGenerateCurrentTimeMillis = generateCurrentTimeMillis();
        String str3 = oo.a(str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE + so.d(context) + LoginConstants.UNDER_LINE + 1 + LoginConstants.UNDER_LINE + strGenerateFourDigitRandom + LoginConstants.UNDER_LINE + strGenerateCurrentTimeMillis) + LoginConstants.UNDER_LINE + 1 + LoginConstants.UNDER_LINE + strGenerateFourDigitRandom + LoginConstants.UNDER_LINE + strGenerateCurrentTimeMillis;
        this.sdkUID = str3;
        co.a(context, KEY_SDK_UID_NEW, str3);
    }

    private String getCurrentRomVersion() {
        try {
            ek ekVarA = ek.a();
            ekVarA.c();
            return ekVarA.b();
        } catch (Throwable unused) {
            return null;
        }
    }

    private void getScreenInformation(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.resolution = displayMetrics.widthPixels + LoginConstants.UNDER_LINE + displayMetrics.heightPixels;
            float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            double dSqrt = Math.sqrt((double) ((f2 * f2) + (f * f)));
            double dPow = Math.pow(10.0d, 2.0d);
            this.screenSize = String.format("%.2f", Double.valueOf(Math.round(dSqrt * dPow) / dPow));
            this.density = context.getResources().getDisplayMetrics().density + "";
            this.densityDpi = context.getResources().getDisplayMetrics().densityDpi + "";
        } catch (Throwable unused) {
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCnOaid() {
        return this.cnOaid;
    }

    public String getDensity() {
        return this.density;
    }

    public String getDensityDpi() {
        return this.densityDpi;
    }

    public String getDevType() {
        return this.devType;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getHonorOaid() {
        return this.honorOaid;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getModel() {
        return this.model;
    }

    public String getMsaOaid() {
        return this.msaOaid;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOs() {
        return this.os;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getRoot() {
        return this.root;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public String getSdkUID() {
        return this.sdkUID;
    }

    public String getSdkUIDOrig() {
        return this.sdkUIDOrig;
    }

    public String getSmOaid() {
        return this.smOaid;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCnOaid(String str) {
        this.cnOaid = str;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDensityDpi(String str) {
        this.densityDpi = str;
    }

    public void setDevType(String str) {
        this.devType = str;
    }

    public void setGaid(String str) {
        this.gaid = str;
    }

    public void setHonorOaid(String str) {
        this.honorOaid = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setMsaOaid(String str) {
        this.msaOaid = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setRoot(String str) {
        this.root = str;
    }

    public void setScreenSize(String str) {
        this.screenSize = str;
    }

    public void setSdkUID(String str) {
        this.sdkUID = str;
    }

    public void setSdkUIDOrig(String str) {
        this.sdkUIDOrig = str;
    }

    public void setSmOaid(String str) {
        this.smOaid = str;
    }
}
