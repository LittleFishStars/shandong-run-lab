package com.aliyun.svideosdk.multirecorder.impl.c;

import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.struct.common.AliyunBorderParam;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface e extends d {

    public enum a {
        BITMAP,
        TEXTURE_OES_ID
    }

    public interface b<T> {
        void a(T t);
    }

    public interface c {
        void a(e eVar);

        void a(e eVar, AliyunBorderParam aliyunBorderParam, int i, int i2);

        void a(e eVar, AliyunLayoutParam aliyunLayoutParam);

        void a(e eVar, boolean z);

        void b(e eVar);

        void c(e eVar);
    }

    void a(AliyunRecordVideoSource aliyunRecordVideoSource, AliyunLayoutParam aliyunLayoutParam, com.aliyun.svideosdk.multirecorder.impl.b bVar);

    void a(b bVar);

    void a(c cVar);

    boolean a();

    AliyunRecordVideoSource b();

    a e();

    boolean f();

    boolean h();
}
