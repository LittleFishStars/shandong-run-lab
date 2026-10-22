package com.aliyun.svideosdk.editor.impl;

import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AliyunIPasterController;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public abstract class AliyunPasterAbstractController<MODEL> extends g implements AliyunIPasterController {
    protected MODEL mModel;
    protected AliyunPasterRender mRender;

    public AliyunPasterAbstractController(MODEL model, AliyunPasterRender aliyunPasterRender) {
        this.mModel = model;
        this.mRender = aliyunPasterRender;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j) {
        setDuration(j, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j) {
        setStartTime(j, TimeUnit.MICROSECONDS);
    }
}
