package com.huachenjie.common.reconfig.net.exception;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "(I)V", "getCode", "()I", "message", "", "getMessage", "()Ljava/lang/String;", "ApiException", "NetException", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException$NetException;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ResultException extends RuntimeException {
    private final int code;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException$ApiException;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ApiException extends ResultException {
        private final int code;

        @Nullable
        private final String message;

        public ApiException(int i, @Nullable String str) {
            super(i, null);
            this.code = i;
            this.message = str;
        }

        @Override // com.huachenjie.common.reconfig.net.exception.ResultException
        public int getCode() {
            return this.code;
        }

        @Override // com.huachenjie.common.reconfig.net.exception.ResultException, java.lang.Throwable
        @Nullable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException$NetException;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class NetException extends ResultException {
        public static final int CERTIFICATE_ERROR = 1004;
        public static final int CONNECT_ERROR = 1001;
        public static final int CONNECT_TIMEOUT = 1002;
        public static final int HTTP_ERROR = 1000;
        public static final int PARSE_ERROR = 1005;
        public static final int UNKNOWN = 1006;
        public static final int UNKNOWN_HOST = 1003;
        private final int code;

        @NotNull
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetException(int i, @NotNull String str) {
            super(i, null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.code = i;
            this.message = str;
        }

        @Override // com.huachenjie.common.reconfig.net.exception.ResultException
        public int getCode() {
            return this.code;
        }

        @Override // com.huachenjie.common.reconfig.net.exception.ResultException, java.lang.Throwable
        @NotNull
        public String getMessage() {
            return this.message;
        }
    }

    private ResultException(int i) {
        this.code = i;
    }

    public /* synthetic */ ResultException(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        String message = super.getMessage();
        return message == null ? AlibcProtocolConstant.UNKNOWN_ERROR : message;
    }
}
