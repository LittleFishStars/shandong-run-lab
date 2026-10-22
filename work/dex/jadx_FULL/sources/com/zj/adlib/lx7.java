package com.zj.adlib;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class lx7 implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43181a = "/aliyun/oss/getToken";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String strHeader = request.header(UserTrackConstant.SIGN);
        if (!TextUtils.isEmpty(strHeader) && request.url().encodedPath().contains(f43181a)) {
            request = request.newBuilder().header("sd", strHeader).build();
        }
        return chain.proceed(request);
    }
}
