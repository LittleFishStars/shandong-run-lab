package com.alibaba.alibcprotocol.route.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CacheUtil {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f23627a;
        public String b;

        public a(String str, String str2) {
            this.f23627a = str;
            this.b = str2;
        }
    }

    private static void a(List<a> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).f23627a) && list.get(i).b != null) {
                putCache(list.get(i).f23627a, list.get(i).b);
            }
        }
    }

    public static void asyncPutEncryptedCache(String str, String str2) {
        String strDynamicEncrypt = AlibcSecurityGuard.getInstance().dynamicEncrypt(str2);
        if (TextUtils.isEmpty(str) || strDynamicEncrypt == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(str, strDynamicEncrypt));
        a(arrayList);
    }

    public static synchronized void cleanCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = AlibcBaseTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0).edit();
        editorEdit.remove(str);
        editorEdit.remove(str + "SHARE_PREFERENCE_EXPIRE");
        editorEdit.apply();
    }

    public static synchronized String getCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SharedPreferences sharedPreferences = AlibcBaseTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0);
        String string = sharedPreferences.getString(str, "");
        sharedPreferences.getLong(str + "SHARE_PREFERENCE_EXPIRE", 0L);
        return string;
    }

    public static Object getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AlibcCommonUtils.readObjectFromFile(AlibcBaseTradeCommon.context, str);
    }

    public static String getDecryptedCache(String str) {
        String cache = getCache(str);
        if (TextUtils.isEmpty(cache)) {
            return null;
        }
        return AlibcSecurityGuard.getInstance().dynamicDecrypt(cache);
    }

    public static synchronized void putCache(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = AlibcBaseTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setData(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlibcCommonUtils.writeObjectToFile(AlibcBaseTradeCommon.context, obj, str);
    }
}
