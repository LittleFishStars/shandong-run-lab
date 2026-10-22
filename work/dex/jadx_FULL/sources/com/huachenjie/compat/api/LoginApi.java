package com.huachenjie.compat.api;

import com.huachenjie.compat.bean.KeyNameInfo;
import com.huachenjie.compat.bean.SchoolListEntity;
import com.huachenjie.compat.bean.StudentInfo;
import huachenjie.sdk.http.BaseEntity;
import java.util.List;
import java.util.Map;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public interface LoginApi {
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/school/pageSchoolList")
    Observable<BaseEntity<SchoolListEntity>> a(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/fillStudentInfo")
    Observable<BaseEntity<StudentInfo>> b(@Field("schoolCode") String str, @Field("studentNumber") String str2, @Field("type") int i);

    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/bindStudent")
    Observable<BaseEntity<StudentInfo>> c(@Field("schoolCode") String str, @Field("userName") String str2, @Field("studentNumber") String str3, @Field("subschoolCode") String str4, @Field("departmentCode") String str5, @Field("classCode") String str6);

    @POST("run-front/account/gradeList")
    Observable<BaseEntity<List<KeyNameInfo>>> d();

    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/bindVisitor")
    Observable<BaseEntity<StudentInfo>> e(@Field("schoolCode") String str, @Field("userName") String str2, @Field("studentNumber") String str3, @Field("sex") int i, @Field("gradeCode") String str4, @Field("cardFrontImgUrl") String str5, @Field("cardBackImgUrl") String str6);
}
