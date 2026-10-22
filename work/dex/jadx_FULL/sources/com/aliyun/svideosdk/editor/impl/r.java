package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.struct.project.VideoTrack;
import com.aliyun.svideosdk.editor.AliyunIPipController;
import com.aliyun.svideosdk.editor.AliyunIPipTrack;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class r implements AliyunIPipTrack {
    private int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AliyunIPipController> f25760a = new ArrayList();
    private VideoTrack c = new VideoTrack();

    public int a() {
        return this.b;
    }

    public int a(AliyunIPipController aliyunIPipController) {
        this.f25760a.add(aliyunIPipController);
        p pVar = (p) aliyunIPipController;
        pVar.a(this);
        pVar.a(a());
        this.c.getVideoTrackClips().add(pVar.c());
        return this.f25760a.size();
    }

    public void a(int i) {
        this.b = i;
    }

    public int b(AliyunIPipController aliyunIPipController) {
        if (!this.f25760a.remove(aliyunIPipController)) {
            return -1;
        }
        p pVar = (p) aliyunIPipController;
        this.c.getVideoTrackClips().remove(pVar.c());
        pVar.a((AliyunIPipTrack) null);
        return this.f25760a.size();
    }

    public VideoTrack b() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipTrack
    public List<AliyunIPipController> getPipClips() {
        return new ArrayList(this.f25760a);
    }
}
