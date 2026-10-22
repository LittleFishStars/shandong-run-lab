package com.zj.adlib;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.bean.AddressBean;
import com.huachenjie.common.bean.SendMsgEntity;
import com.huachenjie.compat.api.CompatApi;
import com.huachenjie.compat.bean.ConfirmPhoneEntity;
import com.huachenjie.compat.bean.DepartmentClassBean;
import com.huachenjie.compat.bean.MyCourseInfo;
import com.huachenjie.compat.bean.PersonalInfo;
import com.huachenjie.compat.bean.StudentCard;
import com.huachenjie.compat.bean.SubSchoolBean;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class rq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CompatApi f44512a;

    public static CompatApi e() {
        if (f44512a == null) {
            synchronized (rq1.class) {
                if (f44512a == null) {
                    f44512a = (CompatApi) lo7.e().d(CompatApi.class);
                }
            }
        }
        return f44512a;
    }

    public Observable<BaseEntity<JSONObject>> a(String str, String str2, String str3) {
        return e().j(str, str2, str3);
    }

    public Observable<BaseEntity<ConfirmPhoneEntity>> b(String str, String str2, String str3, int i) {
        return e().a(str, str2, str3, i);
    }

    public Observable<BaseEntity<MyCourseInfo>> c() {
        return e().l();
    }

    public Observable<BaseEntity<JSONObject>> d(String str) {
        return e().k(str);
    }

    public Observable<BaseEntity<PageEntity<String>>> f() {
        return e().h();
    }

    public Observable<BaseEntity<JSONObject>> g(String str) {
        return e().c(str);
    }

    public Observable<BaseEntity<PersonalInfo>> h() {
        return e().e(new HashMap());
    }

    public Observable<BaseEntity<PageEntity<SubSchoolBean>>> i() {
        return e().n();
    }

    public Observable<BaseEntity<List<DepartmentClassBean>>> j(String str) {
        return e().d(str);
    }

    public Observable<BaseEntity<StudentCard>> k() {
        return e().b(new HashMap());
    }

    public Observable<BaseEntity<UserFaceBean>> l() {
        return e().i();
    }

    public Observable<BaseEntity<Object>> m(String str, String str2, String str3, String str4) {
        return e().f(str, str2, str3, str4);
    }

    public Observable<BaseEntity<SendMsgEntity>> n(String str, int i, String str2) {
        return e().o(str, i, str2);
    }

    public Observable<BaseEntity<Object>> o(String str, String str2, String str3, AddressBean addressBean, String str4, String str5) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("departmentCode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("classCode", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("subSchoolCode", str3);
        }
        if (addressBean != null) {
            map.put("address", addressBean);
        }
        if (!TextUtils.isEmpty(str4)) {
            map.put("nation", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            map.put("birthday", str5);
        }
        return e().g(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map)));
    }

    public Observable<BaseEntity<JSONObject>> p(String str, String str2) {
        return e().m(str, str2);
    }
}
