package com.ali.auth.third.core.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.storage.aes.AESCrypt;
import com.ali.auth.third.core.storage.aes.MD5;
import java.security.GeneralSecurityException;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonStorageServiceImpl implements StorageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f23436a;
    private Context b;
    private String c;

    public CommonStorageServiceImpl() {
        Context applicationContext = KernelContext.getApplicationContext();
        this.b = applicationContext;
        this.f23436a = applicationContext.getSharedPreferences(Constants.TB_SESSION, 0);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String decrypt(String str) {
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String encode(String str) {
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getAppKey() {
        Object obj;
        try {
            Bundle bundle = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128).metaData;
            if (bundle != null && (obj = bundle.get("com.alibaba.app.appkey")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getDDpExValue(String str) {
        return null;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getUmid() {
        return this.c;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getValue(String str, boolean z) {
        String string = this.f23436a.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        return symDecrypt(string, MD5.getMD5(KernelContext.timestamp + ""));
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putDDpExValue(String str, String str2) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    @SuppressLint({"NewApi"})
    public void putValue(String str, String str2, boolean z) {
        this.f23436a.edit().putString(str, symEncrypt(str2, MD5.getMD5(KernelContext.timestamp + ""))).apply();
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeDDpExValue(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeSafeToken(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeValue(String str, boolean z) {
        this.f23436a.edit().remove(str);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public boolean saveSafeToken(String str, String str2) {
        return false;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void setUmid(String str) {
        this.c = str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String signMap(String str, TreeMap<String, String> treeMap) {
        return null;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symDecrypt(String str, String str2) {
        try {
            return AESCrypt.decrypt(str2, str);
        } catch (GeneralSecurityException e) {
            throw new SecRuntimeException(-2, e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symEncrypt(String str, String str2) {
        try {
            return AESCrypt.encrypt(str2, str);
        } catch (GeneralSecurityException e) {
            throw new SecRuntimeException(-1, e);
        }
    }
}
