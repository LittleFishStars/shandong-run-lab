package com.aliyun.svideosdk.common.struct.project;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.aliyun.Visible;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.common.utils.g;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunEditorProject {

    @SuppressLint({"SimpleDateFormat"})
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final String DRAFT_DIR = "svideo_res/draft";
    public static final String PROJECT_FILENAME = "project.aliyunvideo.json";
    public static final int PROJECT_VERSION = 1;
    public static final String TEMPLATE_DRAFT_DIR = "svideo_res/template_draft";

    @SerializedName("Cover")
    private Source mCover;

    @SerializedName("CreationTime")
    private String mCreationTime;

    @SerializedName("CustomCover")
    private boolean mCustomCover;

    @SerializedName("Duration")
    private float mDuration;

    @SerializedName("ModifiedTime")
    private String mModifiedTime;
    private transient File mProjectDir;
    private transient File mProjectFile;

    @SerializedName("ProjectId")
    private String mProjectId;

    @SerializedName("ResourceSize")
    private long mResourceSize;

    @SerializedName("Status")
    private String mStatus;

    @SerializedName("Template")
    private Source mTemplate;

    @SerializedName(AliyunVodKey.KEY_VOD_TITLE)
    private String mTitle;

    @SerializedName("Version")
    private int mVersion = 1;

    @SerializedName("Config")
    private Config mConfig = new Config();

    @SerializedName("Timeline")
    public Timeline mTimeline = new Timeline();
    private String mRequestID = null;

    private void clearGlobalTrack(GlobalTrack.Type type) {
        if (this.mTimeline.getGlobalTracks().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (GlobalTrack globalTrack : getTimeline().getGlobalTracks()) {
            if (globalTrack.getType() == type) {
                arrayList.add(globalTrack);
            }
        }
        getTimeline().getGlobalTracks().removeAll(arrayList);
    }

    private long getFileSize(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return g.e(file);
    }

    private GlobalTrack getGlobalTrack(GlobalTrack.Type type) {
        if (this.mTimeline.getGlobalTracks().isEmpty()) {
            return null;
        }
        for (GlobalTrack globalTrack : getTimeline().getGlobalTracks()) {
            if (globalTrack.getType() == type) {
                return globalTrack;
            }
        }
        return null;
    }

    public static File getProjectFile(File file) {
        File file2 = new File(file, PROJECT_FILENAME);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file2;
    }

    public void addAction(ActionBase actionBase) {
        if (actionBase.isStream()) {
            VideoTrackClip videoTrackClipById = getVideoTrackClipById(actionBase.getTargetId());
            if (videoTrackClipById != null) {
                videoTrackClipById.getActions().add(actionBase);
                return;
            }
            return;
        }
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if ((pasterTrack instanceof PhotoPasterTrack) && pasterTrack.getId() == actionBase.getTargetId()) {
                ((PhotoPasterTrack) pasterTrack).getActions().add(actionBase);
                return;
            }
        }
        if (getWaterMark() != null && getWaterMark().getId() == actionBase.getTargetId()) {
            getWaterMark().getActions().add(actionBase);
        }
        if (getTailWaterMark() == null || getTailWaterMark().getId() != actionBase.getTargetId()) {
            return;
        }
        getTailWaterMark().getActions().add(actionBase);
    }

    public void addAnimationFilter(Filter filter) {
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void addAudioTrackClip(AudioTrackClip audioTrackClip) {
        AudioTrack audioTrack = new AudioTrack();
        audioTrack.getAudioTrackClips().add(audioTrackClip);
        audioTrack.setDuration(audioTrackClip.getOut() - audioTrackClip.getIn());
        this.mTimeline.getAudioTracks().add(audioTrack);
    }

    public void addEffect(int i, Effect effect) {
        removeEffect(i, effect);
        VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(effect);
            return;
        }
        AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.getEffects().add(effect);
        }
    }

    public void addPasterTrack(PasterTrack pasterTrack) {
        getTimeline().getPasterTracks().add(pasterTrack);
    }

    public void addTimeFilter(TimeFilter timeFilter) {
        if (timeFilter != null) {
            if (this.mTimeline.getEffectTracks().isEmpty()) {
                this.mTimeline.getEffectTracks().add(new EffectTrack());
            }
            this.mTimeline.getEffectTracks().add(timeFilter);
        }
    }

    public void clearAnimationFilters() {
        ArrayList arrayList = new ArrayList();
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.animation_filter) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public void clearColorEffect() {
        clearEffectTrack(EffectTrack.Type.filter);
    }

    public void clearEffectTrack(EffectTrack.Type type) {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == type) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public void clearMusic() {
        if (getTimeline().getAudioTracks().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == AudioTrackClip.Type.Music) {
                    arrayList.add(audioTrackClip);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            removeAudioTrackClip(((AudioTrackClip) it2.next()).getClipId());
        }
    }

    public void clearRollCaptionTrack() {
        RollCaptionTrack rollCaptionTrack = getRollCaptionTrack();
        if (rollCaptionTrack != null) {
            getTimeline().getPasterTracks().remove(rollCaptionTrack);
        }
    }

    public void clearTimeFilters() {
        ArrayList arrayList = new ArrayList();
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.time_effect) {
                arrayList.add(effectTrack);
            }
        }
        this.mTimeline.getEffectTracks().removeAll(arrayList);
    }

    public List<Filter> getAllAnimationFilters() {
        ArrayList arrayList = new ArrayList();
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.animation_filter) {
                arrayList.add((Filter) effectTrack);
            }
        }
        return new ArrayList(arrayList);
    }

    public List<TimeFilter> getAllTimeFilters() {
        ArrayList arrayList = new ArrayList();
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.time_effect) {
                arrayList.add((TimeFilter) effectTrack);
            }
        }
        return new ArrayList(arrayList);
    }

    public int getAudioId() {
        ArrayList arrayList = new ArrayList();
        Iterator<AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getType() == AudioTrackClip.Type.Music) {
                    arrayList.add(audioTrackClip);
                }
            }
        }
        if (arrayList.size() == 0) {
            return 0;
        }
        return ((AudioTrackClip) arrayList.get(arrayList.size() - 1)).getSource().getIntId();
    }

    public AudioTrackClip getAudioTrackClipById(int i) {
        Iterator<AudioTrack> it = getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (audioTrackClip.getClipId() == i) {
                    return audioTrackClip;
                }
            }
        }
        return null;
    }

    public PaintTrack getCanvasTrack() {
        return (PaintTrack) getGlobalTrack(GlobalTrack.Type.paint);
    }

    public Filter getColorEffect() {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return null;
        }
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.filter) {
                return (Filter) effectTrack;
            }
        }
        return null;
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public Source getCover() {
        return this.mCover;
    }

    public String getCreationTime() {
        return this.mCreationTime;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public MVFilter getMVEffect() {
        if (this.mTimeline.getEffectTracks().isEmpty()) {
            return null;
        }
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getType() == EffectTrack.Type.mv) {
                return (MVFilter) effectTrack;
            }
        }
        return null;
    }

    public String getModifiedTime() {
        return this.mModifiedTime;
    }

    public PasterTrack getPasterTrackByID(int i) {
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getId() == i) {
                return pasterTrack;
            }
        }
        return null;
    }

    public List<PasterTrack> getPasterTrackByType(PasterTrack.Type type) {
        ArrayList arrayList = new ArrayList();
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getType() == type) {
                arrayList.add(pasterTrack);
            }
        }
        return arrayList;
    }

    public File getProjectDir() {
        return this.mProjectDir;
    }

    public File getProjectFile() {
        return this.mProjectFile;
    }

    public String getProjectId() {
        return this.mProjectId;
    }

    public String getRequestID() {
        return this.mRequestID;
    }

    public long getResourceSize() {
        return this.mResourceSize;
    }

    public RollCaptionTrack getRollCaptionTrack() {
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getType() == PasterTrack.Type.roll_captions) {
                return (RollCaptionTrack) pasterTrack;
            }
        }
        return null;
    }

    public TailWaterMark getTailWaterMark() {
        return (TailWaterMark) getGlobalTrack(GlobalTrack.Type.tail_watermark);
    }

    public Source getTemplate() {
        return this.mTemplate;
    }

    public Timeline getTimeline() {
        return this.mTimeline;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Uri getUri() {
        File file = this.mProjectFile;
        if (file == null) {
            return null;
        }
        return Uri.fromFile(file);
    }

    public int getVersion() {
        return this.mVersion;
    }

    public VideoTrackClip getVideoTrackClipById(int i) {
        Iterator<VideoTrack> it = getTimeline().getVideoTracks().iterator();
        while (it.hasNext()) {
            for (VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                if (videoTrackClip.getClipId() == i) {
                    return videoTrackClip;
                }
            }
        }
        return null;
    }

    public WaterMark getWaterMark() {
        return (WaterMark) getGlobalTrack(GlobalTrack.Type.watermark);
    }

    public boolean isCustomCover() {
        return this.mCustomCover;
    }

    public void refreshTimeLine() {
        float timelineOut;
        VideoTrackClip videoTrackClip = null;
        for (VideoTrackClip videoTrackClip2 : getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip == null) {
                videoTrackClip2.setTimelineIn(0.0f);
                timelineOut = videoTrackClip2.getOut() - videoTrackClip2.getIn();
            } else {
                videoTrackClip2.setTimelineIn(videoTrackClip.getTimelineOut());
                timelineOut = videoTrackClip.getTimelineOut() + (videoTrackClip2.getOut() - videoTrackClip2.getIn());
            }
            videoTrackClip2.setTimelineOut(timelineOut);
            videoTrackClip = videoTrackClip2;
        }
        if (videoTrackClip != null) {
            getTimeline().getPrimaryTrack().setDuration(videoTrackClip.getTimelineOut());
            setDuration(videoTrackClip.getTimelineOut());
            getTimeline().setDuration(getDuration());
        }
    }

    public void removeActionById(int i) {
        Iterator<VideoTrack> it = getTimeline().getVideoTracks().iterator();
        while (it.hasNext()) {
            for (VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                for (ActionBase actionBase : videoTrackClip.getActions()) {
                    if (actionBase.getId() == i) {
                        videoTrackClip.getActions().remove(actionBase);
                        return;
                    }
                }
            }
        }
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof PhotoPasterTrack) {
                PhotoPasterTrack photoPasterTrack = (PhotoPasterTrack) pasterTrack;
                for (ActionBase actionBase2 : photoPasterTrack.getActions()) {
                    if (actionBase2.getId() == i) {
                        photoPasterTrack.getActions().remove(actionBase2);
                        return;
                    }
                }
            }
        }
        if (getWaterMark() != null) {
            for (ActionBase actionBase3 : getWaterMark().getActions()) {
                if (actionBase3.getId() == i) {
                    getWaterMark().getActions().remove(actionBase3);
                    return;
                }
            }
        }
        if (getTailWaterMark() != null) {
            for (ActionBase actionBase4 : getTailWaterMark().getActions()) {
                if (actionBase4.getId() == i) {
                    getTailWaterMark().getActions().remove(actionBase4);
                    return;
                }
            }
        }
    }

    public void removeAnimationFilter(int i) {
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getId() == i) {
                this.mTimeline.getEffectTracks().remove(effectTrack);
                return;
            }
        }
    }

    public void removeAudioTrackClip(int i) {
        for (AudioTrack audioTrack : getTimeline().getAudioTracks()) {
            for (AudioTrackClip audioTrackClip : audioTrack.getAudioTrackClips()) {
                if (audioTrackClip.getClipId() == i) {
                    audioTrack.getAudioTrackClips().remove(audioTrackClip);
                    if (audioTrack.getAudioTrackClips().isEmpty()) {
                        getTimeline().getAudioTracks().remove(audioTrack);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void removeCanvasTrack() {
        clearGlobalTrack(GlobalTrack.Type.paint);
    }

    public void removeEffect(int i, Effect effect) {
        VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (Effect effect2 : videoTrackClipById.getEffects()) {
                if (effect.getType() == effect2.getType()) {
                    if (effect.getType() != Effect.Type.audio_fade) {
                        videoTrackClipById.getEffects().remove(effect2);
                        return;
                    } else if (((AudioFade) effect2).isFadeIn == ((AudioFade) effect).isFadeIn) {
                        videoTrackClipById.getEffects().remove(effect2);
                        return;
                    }
                }
            }
        }
        AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            for (Effect effect3 : audioTrackClipById.getEffects()) {
                if (effect.getType() == effect3.getType()) {
                    if (effect.getType() != Effect.Type.audio_fade) {
                        audioTrackClipById.getEffects().remove(effect3);
                        return;
                    } else if (((AudioFade) effect3).isFadeIn == ((AudioFade) effect).isFadeIn) {
                        audioTrackClipById.getEffects().remove(effect3);
                        return;
                    }
                }
            }
        }
    }

    public void removePasterTrack(int i) {
        for (PasterTrack pasterTrack : getTimeline().getPasterTracks()) {
            if (pasterTrack.getId() == i) {
                getTimeline().getPasterTracks().remove(pasterTrack);
                return;
            }
        }
    }

    public void removeTimeFilter(int i) {
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack.getId() == i) {
                this.mTimeline.getEffectTracks().remove(effectTrack);
                return;
            }
        }
    }

    public void removeVideoTrackClip(int i) {
        for (VideoTrack videoTrack : getTimeline().getVideoTracks()) {
            for (VideoTrackClip videoTrackClip : videoTrack.getVideoTrackClips()) {
                if (videoTrackClip.getClipId() == i) {
                    videoTrack.getVideoTrackClips().remove(videoTrackClip);
                    return;
                }
            }
        }
    }

    public void setCanvasTrack(PaintTrack paintTrack) {
        removeCanvasTrack();
        if (paintTrack != null) {
            getTimeline().getGlobalTracks().add(paintTrack);
        }
    }

    public void setColorEffect(Filter filter) {
        clearEffectTrack(EffectTrack.Type.filter);
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void setCover(Source source) {
        this.mCover = source;
    }

    public void setCreationTime(String str) {
        this.mCreationTime = str;
    }

    public void setCustomCover(boolean z) {
        this.mCustomCover = z;
    }

    public void setDenoise(int i, int i2) {
        VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.setDenoiseWeight(i2);
            return;
        }
        AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.setDenoiseWeight(i2);
        }
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public void setLutEffect(Filter filter) {
        clearEffectTrack(EffectTrack.Type.lut_filter);
        if (filter != null) {
            this.mTimeline.getEffectTracks().add(filter);
        }
    }

    public void setMVEffect(MVFilter mVFilter) {
        clearEffectTrack(EffectTrack.Type.mv);
        if (mVFilter != null) {
            this.mTimeline.getEffectTracks().add(mVFilter);
        }
    }

    public void setModifiedTime(String str) {
        this.mModifiedTime = str;
    }

    public void setMusicWeight(int i, int i2) {
        VideoTrackClip videoTrackClipById = getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.setMixWeight(i2);
            return;
        }
        AudioTrackClip audioTrackClipById = getAudioTrackClipById(i);
        if (audioTrackClipById != null) {
            audioTrackClipById.setMixWeight(i2);
            return;
        }
        MVFilter mVEffect = getMVEffect();
        if (mVEffect == null || mVEffect.getId() != i) {
            return;
        }
        mVEffect.setMixWeight(i2);
    }

    public void setProjectDir(File file, File file2) {
        this.mProjectDir = file;
        this.mProjectFile = file2;
    }

    public void setProjectId(String str) {
        this.mProjectId = str;
    }

    public void setRequestID(String str) {
        this.mRequestID = str;
    }

    public void setResourceSize(long j) {
        this.mResourceSize = j;
    }

    public void setRollCaptionTrack(RollCaptionTrack rollCaptionTrack) {
        clearRollCaptionTrack();
        if (rollCaptionTrack != null) {
            getTimeline().getPasterTracks().add(rollCaptionTrack);
        }
    }

    public void setTailWaterMark(TailWaterMark tailWaterMark) {
        clearGlobalTrack(GlobalTrack.Type.tail_watermark);
        if (tailWaterMark != null) {
            getTimeline().getGlobalTracks().add(tailWaterMark);
        }
    }

    public void setTemplate(Source source) {
        this.mTemplate = source;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public void setWaterMark(WaterMark waterMark) {
        clearGlobalTrack(GlobalTrack.Type.watermark);
        if (waterMark != null) {
            getTimeline().getGlobalTracks().add(waterMark);
        }
    }

    public void updateAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter != null) {
            for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
                if (effectTrack.getId() == effectFilter.getViewId() && effectTrack.getType() == EffectTrack.Type.animation_filter) {
                    Filter filter = (Filter) effectTrack;
                    filter.setTimelineIn(effectFilter.getStartTime() / 1000.0f);
                    filter.setTimelineOut((effectFilter.getStartTime() + effectFilter.getDuration()) / 1000.0f);
                    filter.setEffectConfig(effectFilter.getEffectConfig());
                }
            }
        }
    }

    public void updateFileSize() {
        ArrayList<Source> arrayList = new ArrayList();
        Iterator<VideoTrack> it = this.mTimeline.getVideoTracks().iterator();
        while (it.hasNext()) {
            for (VideoTrackClip videoTrackClip : it.next().getVideoTrackClips()) {
                if (videoTrackClip.getSource() != null && !arrayList.contains(videoTrackClip.getSource())) {
                    arrayList.add(videoTrackClip.getSource());
                }
                for (Effect effect : videoTrackClip.getEffects()) {
                    if (effect.getType() == Effect.Type.transition) {
                        TransitionBase transitionBase = (TransitionBase) effect;
                        if (transitionBase.mType == 5 && transitionBase.getCustomSource() != null && !arrayList.contains(transitionBase.getCustomSource())) {
                            arrayList.add(transitionBase.getCustomSource());
                        }
                    }
                }
            }
        }
        Iterator<AudioTrack> it2 = this.mTimeline.getAudioTracks().iterator();
        while (it2.hasNext()) {
            for (AudioTrackClip audioTrackClip : it2.next().getAudioTrackClips()) {
                if (audioTrackClip.getSource() != null && !arrayList.contains(audioTrackClip.getSource())) {
                    arrayList.add(audioTrackClip.getSource());
                }
            }
        }
        for (PasterTrack pasterTrack : this.mTimeline.getPasterTracks()) {
            if (pasterTrack instanceof PhotoPasterTrack) {
                PhotoPasterTrack photoPasterTrack = (PhotoPasterTrack) pasterTrack;
                if (photoPasterTrack.getSource() != null && !arrayList.contains(photoPasterTrack.getSource())) {
                    arrayList.add(photoPasterTrack.getSource());
                }
            }
            if (pasterTrack instanceof CaptionTrack) {
                CaptionTrack captionTrack = (CaptionTrack) pasterTrack;
                if (captionTrack.getFont() != null && !arrayList.contains(captionTrack.getFont())) {
                    arrayList.add(captionTrack.getFont());
                }
                if (captionTrack.getFontEffectSource() != null && !arrayList.contains(captionTrack.getFontEffectSource())) {
                    arrayList.add(captionTrack.getFontEffectSource());
                }
            }
            if (pasterTrack instanceof BubbleCaptionTrack) {
                BubbleCaptionTrack bubbleCaptionTrack = (BubbleCaptionTrack) pasterTrack;
                if (bubbleCaptionTrack.getFont() != null && !arrayList.contains(bubbleCaptionTrack.getFont())) {
                    arrayList.add(bubbleCaptionTrack.getFont());
                }
            }
            if (pasterTrack instanceof RollCaptionTrack) {
                for (RollCaptionTrackClip rollCaptionTrackClip : ((RollCaptionTrack) pasterTrack).getRollCaptionTrackClips()) {
                    if (rollCaptionTrackClip.getFont() != null && !arrayList.contains(rollCaptionTrackClip.getFont())) {
                        arrayList.add(rollCaptionTrackClip.getFont());
                    }
                }
            }
        }
        for (GlobalTrack globalTrack : this.mTimeline.getGlobalTracks()) {
            if (globalTrack instanceof WaterMark) {
                WaterMark waterMark = (WaterMark) globalTrack;
                if (waterMark.getSource() != null && !arrayList.contains(waterMark.getSource())) {
                    arrayList.add(waterMark.getSource());
                }
            }
            if (globalTrack instanceof PaintTrack) {
                PaintTrack paintTrack = (PaintTrack) globalTrack;
                if (paintTrack.getSource() != null && !arrayList.contains(paintTrack.getSource())) {
                    arrayList.add(paintTrack.getSource());
                }
            }
        }
        for (EffectTrack effectTrack : this.mTimeline.getEffectTracks()) {
            if (effectTrack instanceof MVFilter) {
                MVFilter mVFilter = (MVFilter) effectTrack;
                if (mVFilter.getSource() != null && !arrayList.contains(mVFilter.getSource())) {
                    arrayList.add(mVFilter.getSource());
                }
            }
            if (effectTrack instanceof Filter) {
                Filter filter = (Filter) effectTrack;
                if (filter.getSource() != null && !arrayList.contains(filter.getSource())) {
                    arrayList.add(filter.getSource());
                }
            }
        }
        if (getCover() != null && !arrayList.contains(getCover())) {
            arrayList.add(getCover());
        }
        long fileSize = 0;
        for (Source source : arrayList) {
            if (!q.b(source.getPath())) {
                fileSize += getFileSize(new File(source.getPath()));
            }
        }
        setResourceSize(fileSize / 1024);
    }

    public void updateTransition(int i, TransitionBase transitionBase) {
        for (VideoTrackClip videoTrackClip : getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getClipId() == i) {
                TransitionBase transition = videoTrackClip.getTransition();
                if (transition != null) {
                    transition.setEffectConfig(transitionBase.getEffectConfig());
                    return;
                }
                return;
            }
        }
    }
}
