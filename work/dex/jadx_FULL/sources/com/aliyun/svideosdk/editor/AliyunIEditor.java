package com.aliyun.svideosdk.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.Visible;
import com.aliyun.common.log.struct.AliyunLogInfo;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.EffectBean;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectPicture;
import com.aliyun.svideosdk.common.struct.effect.LUTEffectBean;
import com.aliyun.svideosdk.common.struct.effect.TrackAudioStream;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectMV;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIEditor {
    @Deprecated
    int addAnimationFilter(EffectFilter effectFilter);

    int addAnimationFilter(TrackEffectFilter trackEffectFilter);

    int addFrameAnimation(ActionBase actionBase);

    @Deprecated
    int addImage(EffectPicture effectPicture);

    @Deprecated
    int addRunningDisplayMode(VideoDisplayMode videoDisplayMode, int i, long j, long j2);

    int addTailWaterMark(TrackEffectWaterMark trackEffectWaterMark, long j, TimeUnit timeUnit);

    int addTailWaterMark(String str, float f, float f2, float f3, float f4, long j);

    int applyAudioEffect(int i, AudioEffectType audioEffectType, int i2);

    int applyBlurBackground(int i, long j, long j2, float f);

    @Deprecated
    int applyDub(EffectBean effectBean);

    int applyDub(TrackAudioStream trackAudioStream);

    @Deprecated
    int applyFilter(EffectBean effectBean);

    int applyFilter(TrackEffectFilter trackEffectFilter);

    int applyLutFilter(LUTEffectBean lUTEffectBean);

    @Deprecated
    int applyMV(EffectBean effectBean);

    int applyMV(TrackEffectMV trackEffectMV);

    @Deprecated
    int applyMusic(EffectBean effectBean);

    int applyMusic(TrackAudioStream trackAudioStream);

    @Deprecated
    int applyMusicMixWeight(int i, int i2);

    int applyMusicWeight(int i, int i2);

    int applySourceChange();

    int applyWaterMark(TrackEffectWaterMark trackEffectWaterMark);

    int applyWaterMark(String str, float f, float f2, float f3, float f4);

    @Deprecated
    int audioEffect(int i, AudioEffectType audioEffectType, int i2);

    int cancelCompose();

    void clearAllAnimationFilter();

    int compose(AliyunVideoParam aliyunVideoParam, String str, AliyunIComposeCallBack aliyunIComposeCallBack);

    @Deprecated
    AliyunPasterManager createPasterManager();

    AliyunRollCaptionComposer createRollCaptionComposer();

    int deleteBlurBackground(int i, int i2);

    int deleteTimeEffect(int i);

    int denoise(int i, int i2);

    @Deprecated
    int denoise(int i, boolean z);

    int draw(long j);

    int draw(long j, TimeUnit timeUnit);

    AliyunLogInfo getAliyunLogInfo();

    long getClipStartTime(int i);

    Bitmap getCurrentFrame();

    long getCurrentPlayPosition();

    long getCurrentStreamPosition();

    long getDuration();

    AliyunEditorProject getEditorProject();

    int getFilterLastApplyId();

    int getMVLastApplyId();

    int getMusicLastApplyId();

    Paint getPaintLastApply();

    AliyunPasterManager getPasterManager();

    @Deprecated
    AliyunPasterRender getPasterRender();

    AliyunIPipManager getPipManager();

    AliyunIPlayerController getPlayerController();

    AliyunIProjectInfo getProjectInfo();

    int getRotation();

    AliyunISourcePartManager getSourcePartManager();

    long getStreamDuration();

    TimeEffectType getTimeEffect();

    int getVideoHeight();

    int getVideoWidth();

    int init(SurfaceView surfaceView, Context context);

    int init(SurfaceView surfaceView, Context context, int i, int i2);

    int invert();

    boolean isAudioSilence();

    boolean isPaused();

    boolean isPlaying();

    AliyunICanvasController obtainCanvasController(Context context, int i, int i2);

    void onDestroy();

    int pause();

    int play();

    int rate(float f, long j, long j2, boolean z);

    @Deprecated
    void removeAnimationFilter(EffectFilter effectFilter);

    void removeAnimationFilter(TrackEffectFilter trackEffectFilter);

    int removeAudioEffect(int i, AudioEffectType audioEffectType);

    int removeAudioFadeIn(int i);

    int removeAudioFadeOut(int i);

    @Deprecated
    int removeDub(EffectBean effectBean);

    int removeDub(TrackAudioStream trackAudioStream);

    int removeFilter();

    int removeFrameAnimation(ActionBase actionBase);

    @Deprecated
    void removeImage(EffectPicture effectPicture);

    @Deprecated
    int removeMusic(EffectBean effectBean);

    int removeMusic(TrackAudioStream trackAudioStream);

    @Deprecated
    int removeRunningDisplayMode(int i, int i2);

    int repeat(int i, long j, long j2, boolean z);

    int replay();

    int resetEffect(EffectType effectType);

    int resetVideoAugmentation(int i, VideoAugmentationType videoAugmentationType);

    int resume();

    int saveEffectToLocal();

    int seek(long j);

    int seek(long j, TimeUnit timeUnit);

    @Deprecated
    void setAnimationRestoredListener(OnAnimationFilterRestored onAnimationFilterRestored);

    int setAudioFadeIn(int i, ShapeType shapeType, long j);

    int setAudioFadeOut(int i, ShapeType shapeType, long j);

    void setAudioSilence(boolean z);

    int setDisplayMode(VideoDisplayMode videoDisplayMode);

    int setDisplayView(SurfaceView surfaceView);

    int setDisplayView(TextureView textureView);

    int setFillBackgroundColor(int i);

    int setHorizontalFlip(int i, boolean z);

    void setMonitorSurfaceChange(boolean z);

    void setOnAnimationRestoredListener(OnAnimationFilterRestoredListener onAnimationFilterRestoredListener);

    void setOutputPath(String str);

    int setTransition(int i, TransitionBase transitionBase);

    int setTransition(Map<Integer, TransitionBase> map);

    int setVideoAugmentation(int i, VideoAugmentationType videoAugmentationType, float f);

    int setVolume(int i);

    int stop();

    @Deprecated
    int updateAnimationFilter(EffectFilter effectFilter);

    int updateAnimationFilter(TrackEffectFilter trackEffectFilter);

    int updateCaption(AliyunCaption aliyunCaption);

    void updateCover(Source source);

    int updateTransition(int i, TransitionBase transitionBase);

    String version();
}
