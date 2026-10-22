package com.huachenjie.common.reconfig.net.exception;

import android.net.ParseException;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.security.cert.CertificateException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import retrofit2.HttpException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/b;", "", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f33873a = new b();

    @NotNull
    public final ResultException a(@NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
        if (exception instanceof HttpException) {
            return new ResultException.NetException(1000, "网络异常");
        }
        if (exception instanceof ConnectException ? true : exception instanceof SocketException) {
            return new ResultException.NetException(1001, "连接失败");
        }
        if (exception instanceof SocketTimeoutException) {
            return new ResultException.NetException(1002, "连接超时");
        }
        if (exception instanceof UnknownHostException) {
            return new ResultException.NetException(1003, "找不到服务");
        }
        if (exception instanceof CertificateException ? true : exception instanceof SSLHandshakeException) {
            return new ResultException.NetException(1004, "证书异常");
        }
        if (exception instanceof JsonParseException ? true : exception instanceof JSONException ? true : exception instanceof ParseException) {
            return new ResultException.NetException(1005, "解析异常");
        }
        return exception instanceof ResultException.ApiException ? (ResultException) exception : new ResultException.NetException(1006, AlibcProtocolConstant.UNKNOWN_ERROR);
    }
}
