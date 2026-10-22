package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.editor.AliyunIEditor;
import com.aliyun.svideosdk.editor.AliyunISourcePartManager;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class t extends com.aliyun.svideosdk.common.impl.b implements AliyunISourcePartManager {
    private AliyunIEditor b;

    public t(List<VideoTrackClip> list, AliyunIEditor aliyunIEditor) {
        super(list);
        this.b = aliyunIEditor;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISourcePartManager
    public int applySourceChange() {
        return this.b.applySourceChange();
    }
}
