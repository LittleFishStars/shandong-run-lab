package com.aliyun.svideosdk.importer.impl;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.aliyun.common.c.b.c;
import com.aliyun.svideosdk.common.AliyunIClipConstructor;
import com.aliyun.svideosdk.common.impl.b;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode;
import com.aliyun.svideosdk.common.struct.common.AliyunImageClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.ProjectUtil;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl;
import com.aliyun.svideosdk.importer.AliyunIImport;
import com.aliyun.svideosdk.transcode.NativeParser;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class a implements AliyunIImport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AliyunEditorProject f25774a;
    private com.aliyun.common.b.a b = new ProjectJSONSupportImpl();
    private AliyunVideoParam c;
    private AliyunIClipConstructor d;
    private c e;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        if (context == null) {
            throw new RuntimeException("AliyunIImport init failed,because context is invalid");
        }
        if (this.f25774a == null) {
            this.f25774a = ProjectUtil.newProject(ProjectUtil.newProjectDir(context.getExternalFilesDir(null).getAbsolutePath() + File.separator + AliyunEditorProject.DRAFT_DIR));
        }
        if (this.f25774a == null) {
            throw new RuntimeException("AliyunIImport init failed");
        }
        String strA = com.aliyun.common.c.c.a.a();
        this.e = new c(context, strA);
        this.f25774a.setRequestID(strA);
        this.d = new b(this.f25774a.getTimeline().getPrimaryTrack().getVideoTrackClips());
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addImage(String str, long j, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) {
        if (str == null || !new File(str).exists()) {
            return -20003013;
        }
        return this.d.addImage(str, j, transitionBase, aliyunDisplayMode);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(int i, AliyunClip aliyunClip) {
        return this.d.addMediaClip(i, aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(AliyunClip aliyunClip) {
        return this.d.addMediaClip(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(String str, long j, long j2, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) {
        Log.d("Test", "addVideo:videoPath:" + str + ",startTime:" + j + ",endTime:" + j2 + "overlapDuration:" + (transitionBase == null ? 0L : transitionBase.getOverlapDuration()));
        if (str == null || !new File(str).exists()) {
            return -20003004;
        }
        if (j2 > j) {
            return this.d.addVideo(str, j, j2, transitionBase, aliyunDisplayMode);
        }
        throw new RuntimeException("video duration invalid");
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0026 A[EXC_TOP_SPLITTER, PHI: r2 r6
      0x0026: PHI (r2v6 android.media.MediaMetadataRetriever) = (r2v4 android.media.MediaMetadataRetriever), (r2v7 android.media.MediaMetadataRetriever) binds: [B:38:0x007b, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]
      0x0026: PHI (r6v8 long) = (r6v4 long), (r6v9 long) binds: [B:38:0x007b, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(String str, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) throws Throwable {
        Exception e;
        MediaMetadataRetriever mediaMetadataRetriever;
        long j;
        NativeParser nativeParser;
        long j2;
        if (str == null || !new File(str).exists()) {
            return -20003004;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        nativeParser = null;
        NativeParser nativeParser2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                j2 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.d("AliYunLog", "MediaMetadataRetriever failed and use NativeParser", e);
                    try {
                        try {
                            nativeParser = new NativeParser();
                            try {
                                nativeParser.init(str);
                                j = Long.parseLong(nativeParser.getValue(3)) / 1000;
                                nativeParser.release();
                            } catch (Exception unused) {
                                nativeParser2 = nativeParser;
                                Log.e("AliYunLog", "NativeParser failed, tempFilePath :" + str, e);
                                j = 0;
                                if (nativeParser2 != null) {
                                    nativeParser2.release();
                                    nativeParser = nativeParser2;
                                    nativeParser.dispose();
                                    j2 = j;
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                } else {
                                    j2 = j;
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                }
                                return addVideo(str, 0L, j2, transitionBase, aliyunDisplayMode);
                            } catch (Throwable th) {
                                th = th;
                                nativeParser2 = nativeParser;
                                if (nativeParser2 != null) {
                                    nativeParser2.release();
                                    nativeParser2.dispose();
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                        }
                        nativeParser.dispose();
                        j2 = j;
                        if (mediaMetadataRetriever != null) {
                        }
                        return addVideo(str, 0L, j2, transitionBase, aliyunDisplayMode);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            mediaMetadataRetriever = null;
        } catch (Throwable th5) {
            th = th5;
            mediaMetadataRetriever = mediaMetadataRetriever2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            return addVideo(str, 0L, j2, transitionBase, aliyunDisplayMode);
        } catch (Exception e6) {
            Log.e("AliYunLog", "addVideo failed, videoPath = " + str, e6);
            return -20004001;
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteLastMediaClip() {
        return this.d.deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int deleteMediaClip() {
        return this.d.deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteMediaClip(int i) {
        return this.d.deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void deleteMediaClip(AliyunClip aliyunClip) {
        this.d.deleteMediaClip(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public String generateProjectConfigure() {
        if (this.d.getMediaClipCount() == 0) {
            return null;
        }
        List<VideoTrackClip> videoTrackClips = this.f25774a.getTimeline().getPrimaryTrack().getVideoTrackClips();
        videoTrackClips.clear();
        for (AliyunClip aliyunClip : this.d.getAllClips()) {
            MainVideoTrackClip mainVideoTrackClip = new MainVideoTrackClip();
            mainVideoTrackClip.setSource(new Source(aliyunClip.getSource()));
            mainVideoTrackClip.setTransition(aliyunClip.getTransition());
            mainVideoTrackClip.setDisplayMode(aliyunClip.getDisplayMode().ordinal());
            mainVideoTrackClip.setWidth(aliyunClip.getClipWidth());
            mainVideoTrackClip.setHeight(aliyunClip.getClipHeight());
            if (aliyunClip.getMediaType() == MediaType.ANY_VIDEO_TYPE && (aliyunClip instanceof AliyunVideoClip)) {
                mainVideoTrackClip.setType(0);
                AliyunVideoClip aliyunVideoClip = (AliyunVideoClip) aliyunClip;
                mainVideoTrackClip.setIn(aliyunVideoClip.getStartTime() / 1000.0f);
                mainVideoTrackClip.setOut(aliyunVideoClip.getEndTime() / 1000.0f);
                mainVideoTrackClip.setDuration(aliyunVideoClip.getDuration() / 1000.0f);
                c cVar = this.e;
                if (cVar != null) {
                    cVar.a(aliyunVideoClip.getSource(), aliyunVideoClip.getStartTime(), aliyunVideoClip.getStartTime(), mainVideoTrackClip.getTransition() == null ? 0L : mainVideoTrackClip.getTransition().getOverlapDuration());
                }
            } else if (aliyunClip.getMediaType() == MediaType.ANY_IMAGE_TYPE && (aliyunClip instanceof AliyunImageClip)) {
                mainVideoTrackClip.setType(1);
                mainVideoTrackClip.setIn(0.0f);
                mainVideoTrackClip.setOut(((AliyunImageClip) aliyunClip).getDuration() / 1000.0f);
                mainVideoTrackClip.setDuration(9.223372E18f);
                mainVideoTrackClip.setType(1);
                c cVar2 = this.e;
                if (cVar2 != null) {
                    cVar2.d();
                }
            }
            videoTrackClips.add(mainVideoTrackClip);
        }
        this.f25774a.refreshTimeLine();
        AliyunVideoParam aliyunVideoParam = this.c;
        if (aliyunVideoParam != null) {
            int outputWidth = aliyunVideoParam.getOutputWidth();
            int outputHeight = this.c.getOutputHeight();
            this.f25774a.getConfig().setOutputWidth(outputWidth);
            this.f25774a.getConfig().setOutputHeight(outputHeight);
            this.f25774a.getConfig().setGop(this.c.getGop());
            this.f25774a.getConfig().setFps(this.c.getFrameRate());
            this.f25774a.getConfig().setBitrate(this.c.getBitrate());
            this.f25774a.getConfig().setCrf(this.c.getCrf());
            this.f25774a.getConfig().setDisplayMode(this.c.getScaleMode().ordinal());
            this.f25774a.getConfig().setVideoQuality(this.c.getVideoQuality().ordinal());
            this.f25774a.getConfig().setVideoCodec(this.c.getVideoCodec().ordinal());
            this.f25774a.getConfig().setScale(this.c.getScaleRate());
            this.f25774a.getConfig().setAudioChannel(this.c.getAudioChannel().getValue());
            this.f25774a.getConfig().setAudioSampleRate(this.c.getAudioSampleRate().getValue());
        }
        c cVar3 = this.e;
        if (cVar3 != null) {
            cVar3.e();
        }
        AliyunEditorProject aliyunEditorProject = this.f25774a;
        ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.b);
        return this.f25774a.getProjectFile().getAbsolutePath();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public List<AliyunClip> getAllClips() {
        return this.d.getAllClips();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public AliyunClip getMediaClip(int i) {
        return this.d.getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int getMediaClipCount() {
        return this.d.getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public AliyunClip getMediaPart(int i) {
        return this.d.getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int getMediaPartCount() {
        return this.d.getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public void release() {
        this.f25774a = null;
        c cVar = this.e;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeMedia(int i) {
        this.d.deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeVideo(String str) throws IllegalAccessException {
        this.d.removeVideo(str);
    }

    @Override // com.aliyun.svideosdk.importer.AliyunIImport
    public void setVideoParam(AliyunVideoParam aliyunVideoParam) {
        this.c = aliyunVideoParam;
        int outputWidth = aliyunVideoParam.getOutputWidth();
        int outputHeight = aliyunVideoParam.getOutputHeight();
        if (outputWidth % 2 != 0) {
            aliyunVideoParam.setOutputWidth(outputWidth - 1);
        }
        if (outputHeight % 2 != 0) {
            aliyunVideoParam.setOutputHeight(outputHeight - 1);
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void swap(int i, int i2) {
        this.d.swap(i, i2);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void updateAllClips(List<AliyunClip> list) {
        this.d.updateAllClips(list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int updateMediaClip(int i, AliyunClip aliyunClip) {
        return this.d.updateMediaClip(i, aliyunClip);
    }
}
