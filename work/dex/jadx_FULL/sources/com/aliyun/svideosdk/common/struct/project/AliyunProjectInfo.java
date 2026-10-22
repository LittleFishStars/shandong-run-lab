package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.svideosdk.common.struct.effect.EffectBean;
import com.aliyun.svideosdk.common.struct.effect.EffectPicture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliyunProjectInfo implements AliyunIProjectInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AliyunEditorProject f25672a;

    public AliyunProjectInfo(AliyunEditorProject aliyunEditorProject) {
        this.f25672a = aliyunEditorProject;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo
    public List<EffectBean> getMusicList() {
        ArrayList arrayList = new ArrayList();
        Iterator<AudioTrack> it = this.f25672a.getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == AudioTrackClip.Type.Music) {
                    EffectBean effectBean = new EffectBean();
                    effectBean.setId(audioTrackClip.getClipId());
                    effectBean.setOldId(audioTrackClip.getClipId());
                    effectBean.setDuration((long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f));
                    effectBean.setPath(audioTrackClip.getSource().getPath());
                    effectBean.setSource(audioTrackClip.getSource());
                    effectBean.setStartTime((long) (audioTrackClip.getTimelineIn() * 1000000.0f));
                    effectBean.setStreamDuration((long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f));
                    effectBean.setStreamStartTime((long) (audioTrackClip.getIn() * 1000000.0f));
                    effectBean.setWeight(audioTrackClip.getMixWeight());
                    arrayList.add(effectBean);
                }
            }
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo
    public List<EffectPicture> getPictureList() {
        ArrayList arrayList = new ArrayList();
        Iterator<PasterTrack> it = this.f25672a.getPasterTrackByType(PasterTrack.Type.photo).iterator();
        while (it.hasNext()) {
            PhotoPasterTrack photoPasterTrack = (PhotoPasterTrack) it.next();
            EffectPicture effectPicture = new EffectPicture(photoPasterTrack.getSource().getPath());
            effectPicture.end = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
            effectPicture.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
            effectPicture.width = photoPasterTrack.getWidth();
            effectPicture.height = photoPasterTrack.getHeight();
            effectPicture.mirror = photoPasterTrack.isMirror();
            effectPicture.rotation = photoPasterTrack.getRotation();
            effectPicture.x = photoPasterTrack.getX();
            effectPicture.y = photoPasterTrack.getY();
            effectPicture.setViewId(photoPasterTrack.getId());
            effectPicture.setOldId(photoPasterTrack.getId());
            arrayList.add(effectPicture);
        }
        return arrayList;
    }
}
