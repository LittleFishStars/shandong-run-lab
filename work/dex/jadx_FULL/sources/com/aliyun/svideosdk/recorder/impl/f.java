package com.aliyun.svideosdk.recorder.impl;

import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f implements AliyunIRecordPasterManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f25845a = new ArrayList();
    protected d b;

    public f(d dVar) {
        this.b = dVar;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public AliyunRecordPasterController addFacePaster(Source source) {
        return new AliyunRecordFacePasterController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public AliyunRecordWaterMarkController addImage(Source source) {
        return new AliyunRecordWaterMarkController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public AliyunRecordPasterController addPaster(Source source) {
        return new AliyunRecordPasterController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public void remove(a aVar) {
        this.f25845a.remove(aVar);
        this.b.b(aVar);
    }
}
