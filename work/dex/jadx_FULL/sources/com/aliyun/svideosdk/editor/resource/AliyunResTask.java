package com.aliyun.svideosdk.editor.resource;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public abstract class AliyunResTask {
    private a mHandleCallback;
    private AliyunResModuleType mResModuleType;
    private AliyunResType mResType;
    private Source mSource;

    public interface a {
        void a(AliyunResTask aliyunResTask);
    }

    public AliyunResTask(AliyunResModuleType aliyunResModuleType, AliyunResType aliyunResType, Source source, a aVar) {
        this.mResModuleType = aliyunResModuleType;
        this.mResType = aliyunResType;
        this.mSource = source;
        this.mHandleCallback = aVar;
    }

    public AliyunResModuleType getResModuleType() {
        return this.mResModuleType;
    }

    public AliyunResType getResType() {
        return this.mResType;
    }

    public Source getSource() {
        return this.mSource;
    }

    public void onHandleCallback(Source source) {
        if (this.mHandleCallback != null) {
            if (source != null) {
                this.mSource.setId(source.getId());
                this.mSource.setPath(source.getPath());
                this.mSource.setURL(source.getURL());
            }
            this.mHandleCallback.a(this);
            this.mHandleCallback = null;
        }
    }

    public void onIgnore() {
        onHandleCallback(null);
    }

    public abstract void onRemove();
}
