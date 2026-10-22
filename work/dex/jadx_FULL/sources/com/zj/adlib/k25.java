package com.zj.adlib;

import android.text.TextUtils;
import com.huachenjie.compat.api.LoginApi;
import com.huachenjie.compat.bean.KeyNameInfo;
import com.huachenjie.compat.bean.SchoolListEntity;
import com.huachenjie.compat.bean.StudentInfo;
import huachenjie.sdk.http.BaseEntity;
import java.util.HashMap;
import java.util.List;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class k25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LoginApi f42728a;

    public static LoginApi d() {
        if (f42728a == null) {
            synchronized (k25.class) {
                if (f42728a == null) {
                    f42728a = (LoginApi) lo7.e().d(LoginApi.class);
                }
            }
        }
        return f42728a;
    }

    public Observable<BaseEntity<StudentInfo>> a(String str, String str2, String str3, String str4, String str5, String str6) {
        return d().c(str, str2, str3, str4, str5, str6);
    }

    public Observable<BaseEntity<StudentInfo>> b(String str, String str2, String str3, int i, String str4, String str5, String str6) {
        return d().e(str, str2, str3, i, str4, str5, str6);
    }

    public Observable<BaseEntity<List<KeyNameInfo>>> c() {
        return d().d();
    }

    public Observable<BaseEntity<SchoolListEntity>> e(String str, int i) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("schoolName", str);
        }
        map.put("pageSize", String.valueOf(10));
        map.put("pageNum", String.valueOf(i));
        return d().a(map);
    }

    public Observable<BaseEntity<StudentInfo>> f(String str, String str2, int i) {
        return d().b(str, str2, i);
    }
}
