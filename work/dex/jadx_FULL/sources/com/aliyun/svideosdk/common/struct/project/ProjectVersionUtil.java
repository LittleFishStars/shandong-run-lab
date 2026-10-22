package com.aliyun.svideosdk.common.struct.project;

import androidx.constraintlayout.motion.widget.Key;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.CanvasInfo;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.ActionFade;
import com.aliyun.svideosdk.common.struct.effect.ActionRotate;
import com.aliyun.svideosdk.common.struct.effect.ActionRotateBy;
import com.aliyun.svideosdk.common.struct.effect.ActionRotateTo;
import com.aliyun.svideosdk.common.struct.effect.ActionScale;
import com.aliyun.svideosdk.common.struct.effect.ActionTranslate;
import com.aliyun.svideosdk.common.struct.effect.ActionWipe;
import com.aliyun.svideosdk.common.struct.effect.BlurBackground;
import com.aliyun.svideosdk.common.struct.effect.EffectConfig;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.effect.TransitionCircle;
import com.aliyun.svideosdk.common.struct.effect.TransitionFade;
import com.aliyun.svideosdk.common.struct.effect.TransitionFiveStar;
import com.aliyun.svideosdk.common.struct.effect.TransitionShutter;
import com.aliyun.svideosdk.common.struct.effect.TransitionTranslate;
import com.aliyun.svideosdk.editor.AudioEffectType;
import com.aliyun.svideosdk.editor.TimeEffectType;
import com.google.common.net.e;
import com.google.gson.Gson;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProjectVersionUtil {
    private static TransitionBase a(JSONObject jSONObject) {
        TransitionShutter transitionShutter;
        TransitionTranslate transitionTranslate;
        TransitionCircle transitionCircle;
        TransitionFiveStar transitionFiveStar;
        TransitionFade transitionFade;
        TransitionBase transitionBase;
        TransitionBase transitionBase2 = null;
        transitionBase2 = null;
        transitionBase2 = null;
        transitionBase2 = null;
        if (jSONObject != null && jSONObject.has("mType")) {
            int iOptInt = jSONObject.optInt("mType");
            if (iOptInt == 0) {
                transitionShutter = new TransitionShutter();
                transitionShutter.setLineWidth((float) jSONObject.optDouble("mLineWidth"));
                transitionShutter.setOrientation(jSONObject.optInt("mOrientation"));
            } else if (iOptInt == 1) {
                transitionTranslate = new TransitionTranslate();
                transitionTranslate.setDirection(jSONObject.optInt("mDirection"));
            } else if (iOptInt == 2) {
                transitionCircle = new TransitionCircle();
            } else if (iOptInt == 3) {
                transitionFiveStar = new TransitionFiveStar();
            } else if (iOptInt == 4) {
                transitionFade = new TransitionFade();
            } else if (iOptInt == 5) {
                String strOptString = jSONObject.optString("mFilePath");
                if (!q.b(strOptString)) {
                    transitionBase = new TransitionBase();
                    transitionBase.setParamsString(jSONObject.optString("mParamsString"));
                    transitionBase.setCustomSource(new Source(strOptString));
                }
            }
            if (transitionBase2 != null) {
                transitionBase2 = transitionShutter;
                transitionBase2 = transitionTranslate;
                transitionBase2 = transitionCircle;
                transitionBase2 = transitionFiveStar;
                transitionBase2 = transitionFade;
                transitionBase2 = transitionBase;
                transitionBase2.setOverlapDuration(jSONObject.optLong("mOverlapDuration"));
            }
        }
        transitionBase2 = transitionShutter;
        transitionBase2 = transitionTranslate;
        transitionBase2 = transitionCircle;
        transitionBase2 = transitionFiveStar;
        transitionBase2 = transitionFade;
        transitionBase2 = transitionBase;
        return transitionBase2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0176  */
    /* JADX WARN: Code duplicated, block: B:26:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x01ae A[SYNTHETIC] */
    private static List<ActionBase> a(JSONArray jSONArray) {
        String strOptString;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    ActionBase actionBase = null;
                    switch (jSONObjectOptJSONObject.optInt("mType")) {
                        case 0:
                            ActionFade actionFade = new ActionFade();
                            actionFade.setFromAlpha((float) jSONObjectOptJSONObject.optDouble("mFromAlpha"));
                            actionFade.setToAlpha((float) jSONObjectOptJSONObject.optDouble("mToAlpha"));
                            actionBase = actionFade;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 1:
                            ActionScale actionScale = new ActionScale();
                            actionScale.setFromScale((float) jSONObjectOptJSONObject.optDouble("mFromScale"));
                            actionScale.setToScale((float) jSONObjectOptJSONObject.optDouble("mToScale"));
                            actionScale.setScaleAnchorEnable(jSONObjectOptJSONObject.optBoolean("mScaleAnchorEnable"));
                            actionScale.setScaleAnchorBaseScale((float) jSONObjectOptJSONObject.optDouble("mScaleAnchorBaseScale"));
                            actionScale.setScaleAnchorX((float) jSONObjectOptJSONObject.optDouble("mScaleAnchorX"));
                            actionScale.setScaleAnchorY((float) jSONObjectOptJSONObject.optDouble("mScaleAnchorY"));
                            actionBase = actionScale;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 2:
                            ActionTranslate actionTranslate = new ActionTranslate();
                            actionTranslate.setFromPointX((float) jSONObjectOptJSONObject.optDouble("mFromPointX"));
                            actionTranslate.setFromPointY((float) jSONObjectOptJSONObject.optDouble("mFromPointY"));
                            actionTranslate.setToPointX((float) jSONObjectOptJSONObject.optDouble("mToPointX"));
                            actionTranslate.setToPointY((float) jSONObjectOptJSONObject.optDouble("mToPointY"));
                            actionBase = actionTranslate;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 3:
                            ActionRotate actionRotate = new ActionRotate();
                            actionRotate.setClockwise(jSONObjectOptJSONObject.optBoolean("mClockwise"));
                            actionRotate.setCenterCoordinateSys(jSONObjectOptJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotate.setCenterX((float) jSONObjectOptJSONObject.optDouble("mCenterX"));
                            actionRotate.setCenterY((float) jSONObjectOptJSONObject.optDouble("mCenterY"));
                            actionRotate.setRepeat(jSONObjectOptJSONObject.optBoolean("mRepeat"));
                            actionRotate.setDurationPerCircle((long) jSONObjectOptJSONObject.optDouble("mDurationPerCircle"));
                            actionBase = actionRotate;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 4:
                            ActionRotateBy actionRotateBy = new ActionRotateBy();
                            actionRotateBy.setCenterCoordinateSys(jSONObjectOptJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotateBy.setCenterX((float) jSONObjectOptJSONObject.optDouble("mCenterX"));
                            actionRotateBy.setCenterY((float) jSONObjectOptJSONObject.optDouble("mCenterY"));
                            actionRotateBy.setFromDegree((float) jSONObjectOptJSONObject.optDouble("mFromDegree"));
                            actionRotateBy.setRotateDegree((float) jSONObjectOptJSONObject.optDouble("mRotateDegree"));
                            actionBase = actionRotateBy;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 5:
                            ActionRotateTo actionRotateTo = new ActionRotateTo();
                            actionRotateTo.setCenterCoordinateSys(jSONObjectOptJSONObject.optInt("mCenterCoordinateSys"));
                            actionRotateTo.setCenterX((float) jSONObjectOptJSONObject.optDouble("mCenterX"));
                            actionRotateTo.setCenterY((float) jSONObjectOptJSONObject.optDouble("mCenterY"));
                            actionRotateTo.setFromDegree((float) jSONObjectOptJSONObject.optDouble("mFromDegree"));
                            actionRotateTo.setRotateToDegree((float) jSONObjectOptJSONObject.optDouble("mRotateToDegree"));
                            actionBase = actionRotateTo;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 6:
                            ActionWipe actionWipe = new ActionWipe();
                            actionWipe.setDirection(jSONObjectOptJSONObject.optInt("mDirection"));
                            actionWipe.setWipeMode(jSONObjectOptJSONObject.optInt("mWipeMode"));
                            actionBase = actionWipe;
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                        case 7:
                            jSONObjectOptJSONObject.optString("VertexShader");
                            jSONObjectOptJSONObject.optString("FragmentShader");
                            throw null;
                        default:
                            if (actionBase != null) {
                                actionBase.setTargetId(jSONObjectOptJSONObject.optInt("mTargetId"));
                                actionBase.setStartTime(jSONObjectOptJSONObject.optInt("mStartTime"));
                                actionBase.setDuration(jSONObjectOptJSONObject.optInt("mDuration"));
                                actionBase.setIsStream(jSONObjectOptJSONObject.optBoolean("mIsStream"));
                                strOptString = jSONObjectOptJSONObject.optString("mAnimationConfig");
                                if (!q.b(strOptString)) {
                                    actionBase.setAnimationConfig(strOptString);
                                }
                                arrayList.add(actionBase);
                            }
                            break;
                    }
                }
            }
        }
        return arrayList;
    }

    private static List<AudioTrackClip> a(JSONArray jSONArray, AudioTrackClip.Type type) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                AudioTrackClip audioTrackClip = new AudioTrackClip();
                audioTrackClip.setType(type);
                audioTrackClip.setSource(new Source(jSONObjectOptJSONObject.optString("mPath")));
                audioTrackClip.setIn(jSONObjectOptJSONObject.optLong("mStreamStartTime") / 1000000.0f);
                audioTrackClip.setOut(audioTrackClip.getIn() + (jSONObjectOptJSONObject.optLong("mStreamDuration") / 1000000.0f));
                audioTrackClip.setTimelineIn(jSONObjectOptJSONObject.optLong("mStartTime") / 1000000.0f);
                audioTrackClip.setTimelineOut(jSONObjectOptJSONObject.optLong("mStreamDuration") / 1000000.0f);
                audioTrackClip.setMixWeight(jSONObjectOptJSONObject.optInt("mWeight") * 10);
                audioTrackClip.setDenoiseWeight((int) jSONObjectOptJSONObject.optDouble("mDenoiseWeight"));
                audioTrackClip.getEffects().addAll(b(jSONObjectOptJSONObject.optJSONArray("mAudioEffects")));
                audioTrackClip.getEffects().addAll(c(jSONObjectOptJSONObject.optJSONArray("mAudioFades")));
                arrayList.add(audioTrackClip);
            }
        }
        return arrayList;
    }

    private static List<Effect> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                AudioEffect audioEffect = new AudioEffect();
                audioEffect.mEffectType = AudioEffectType.values()[jSONObjectOptJSONObject.optInt("mType")];
                audioEffect.mEffectParam = jSONObjectOptJSONObject.optInt("mEffectParam");
                arrayList.add(audioEffect);
            }
        }
        return arrayList;
    }

    private static List<Effect> c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new AudioFade(jSONObjectOptJSONObject.optInt("shapeType"), jSONObjectOptJSONObject.optLong("duration"), jSONObjectOptJSONObject.optBoolean("isFadeIn")));
            }
        }
        return arrayList;
    }

    private static List<Effect> d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new BlurBackground(0, 0, jSONObjectOptJSONObject.optLong("mStartTimeMills"), jSONObjectOptJSONObject.optLong("mDurationMills"), jSONObjectOptJSONObject.optInt("mBlurRadius")));
            }
        }
        return arrayList;
    }

    private static List<Effect> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new RunningDisplayMode(0, 0, jSONObjectOptJSONObject.optLong("mStartTimeMills"), jSONObjectOptJSONObject.optLong("mDurationMills"), jSONObjectOptJSONObject.optInt("mDisplayMode")));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:99:0x04a1 A[Catch: all -> 0x08d4, TryCatch #0 {all -> 0x08d4, blocks: (B:3:0x0008, B:6:0x00c1, B:9:0x00c8, B:11:0x00ce, B:13:0x00da, B:16:0x00e1, B:18:0x00e7, B:20:0x00f4, B:24:0x0112, B:26:0x011f, B:28:0x012b, B:30:0x01a5, B:31:0x01ac, B:32:0x01fa, B:34:0x0200, B:36:0x020c, B:37:0x0214, B:38:0x022b, B:39:0x0233, B:42:0x0246, B:43:0x0297, B:45:0x02a0, B:47:0x02fd, B:49:0x0306, B:50:0x0340, B:52:0x034c, B:53:0x037e, B:56:0x038a, B:57:0x03c1, B:59:0x03ce, B:62:0x03d5, B:64:0x03db, B:66:0x041a, B:69:0x0435, B:71:0x0444, B:70:0x0439, B:72:0x044d, B:74:0x0457, B:77:0x045e, B:79:0x0464, B:101:0x04ce, B:100:0x04c3, B:99:0x04a1, B:89:0x0488, B:90:0x048a, B:93:0x0495, B:91:0x048f, B:92:0x0492, B:102:0x04d2, B:104:0x04d8, B:105:0x04e3, B:106:0x04fe, B:108:0x0504, B:109:0x052e, B:112:0x0542, B:115:0x0549, B:117:0x054f, B:118:0x05ae, B:120:0x05b6, B:123:0x05bd, B:125:0x05c3, B:127:0x063e, B:128:0x0646, B:130:0x0694, B:131:0x069c, B:133:0x06a8, B:134:0x06b0, B:135:0x06c3, B:137:0x06cc, B:139:0x06d2, B:140:0x06d8, B:142:0x06de, B:144:0x071b, B:145:0x0723, B:146:0x072d, B:147:0x0738, B:149:0x0740, B:152:0x0747, B:154:0x074d, B:169:0x083f, B:170:0x08a6, B:161:0x0767, B:163:0x0772, B:165:0x07ee, B:166:0x07ff, B:162:0x076d, B:167:0x082a, B:171:0x08ac), top: B:175:0x0008 }] */
    public static AliyunEditorProject readProject(File file, JSONObject jSONObject) {
        String str;
        String str2;
        GifPasterTrack gifPasterTrack;
        PhotoPasterTrack photoPasterTrack;
        SubTitleTrack subTitleTrack;
        TimeEffectType timeEffectType;
        try {
            AliyunEditorProject aliyunEditorProject = new AliyunEditorProject();
            aliyunEditorProject.getConfig().setGop(jSONObject.optInt("mGop"));
            aliyunEditorProject.getConfig().setVideoQuality(jSONObject.optInt("mVideoQuality"));
            aliyunEditorProject.getConfig().setBitrate(jSONObject.optInt("mBitrate"));
            aliyunEditorProject.getConfig().setFps(jSONObject.optInt("mFps"));
            aliyunEditorProject.getConfig().setCrf(jSONObject.optInt("mCrf"));
            aliyunEditorProject.getConfig().setVideoCodec(jSONObject.optInt("mVideoCodec"));
            aliyunEditorProject.getConfig().setScale((float) jSONObject.optDouble("mScaleRate"));
            aliyunEditorProject.getConfig().setOutputWidth(jSONObject.optInt("mOutputWidth"));
            aliyunEditorProject.getConfig().setOutputHeight(jSONObject.optInt("mOutputHeight"));
            aliyunEditorProject.getConfig().setMute(jSONObject.optBoolean("isSilence"));
            aliyunEditorProject.getConfig().setVolume(jSONObject.optInt("mPrimaryVolume"));
            aliyunEditorProject.getConfig().setBackgroundColor(jSONObject.optInt("mFillBackgroundColor"));
            List<ActionBase> listA = a(jSONObject.optJSONArray("mActions"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mTrackList");
            String str3 = "mDuration";
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONObject(i).optJSONArray("mClipList");
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        int i2 = 0;
                        while (i2 < jSONArrayOptJSONArray2.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                            MainVideoTrackClip mainVideoTrackClip = new MainVideoTrackClip();
                            JSONArray jSONArray = jSONArrayOptJSONArray2;
                            boolean zEquals = "ANY_VIDEO_TYPE".equals(jSONObjectOptJSONObject.optString("mediaType"));
                            String str4 = str3;
                            mainVideoTrackClip.setIn(jSONObjectOptJSONObject.optLong("startTime") / 1000.0f);
                            mainVideoTrackClip.setOut(jSONObjectOptJSONObject.optLong(zEquals ? "endTime" : str4) / 1000.0f);
                            mainVideoTrackClip.setDuration(zEquals ? mainVideoTrackClip.getOut() - mainVideoTrackClip.getIn() : 2.1474836E9f);
                            mainVideoTrackClip.setMixWeight(jSONObjectOptJSONObject.optInt("mMusicWeight") * 10);
                            mainVideoTrackClip.setDenoiseWeight((int) jSONObjectOptJSONObject.optDouble("denoiseWeight"));
                            mainVideoTrackClip.setType(!zEquals ? 1 : 0);
                            mainVideoTrackClip.setSource(new Source(jSONObjectOptJSONObject.optString("src")));
                            mainVideoTrackClip.setRotation(jSONObjectOptJSONObject.optInt(Key.ROTATION));
                            mainVideoTrackClip.setDisplayMode(jSONObjectOptJSONObject.optInt("mDisplayMode"));
                            mainVideoTrackClip.setBrightness((float) jSONObjectOptJSONObject.optDouble("mBrightness"));
                            mainVideoTrackClip.setContrast((float) jSONObjectOptJSONObject.optDouble("mContrast"));
                            mainVideoTrackClip.setVignette((float) jSONObjectOptJSONObject.optDouble("mVignette"));
                            mainVideoTrackClip.setSaturation((float) jSONObjectOptJSONObject.optDouble("mSaturation"));
                            mainVideoTrackClip.setSharpness((float) jSONObjectOptJSONObject.optDouble("mSharpness"));
                            TransitionBase transitionBaseA = a(jSONObjectOptJSONObject.optJSONObject("mTransition"));
                            if (transitionBaseA != null) {
                                mainVideoTrackClip.getEffects().add(transitionBaseA);
                            }
                            mainVideoTrackClip.getEffects().addAll(e(jSONObjectOptJSONObject.optJSONArray("mRunningDisplayModes")));
                            mainVideoTrackClip.getEffects().addAll(d(jSONObjectOptJSONObject.optJSONArray("mBlurBackgrounds")));
                            mainVideoTrackClip.getEffects().addAll(b(jSONObjectOptJSONObject.optJSONArray("mAudioEffects")));
                            mainVideoTrackClip.getEffects().addAll(c(jSONObjectOptJSONObject.optJSONArray("mAudioFades")));
                            int iOptInt = jSONObjectOptJSONObject.optInt("mId");
                            for (ActionBase actionBase : listA) {
                                if (actionBase.getTargetId() == iOptInt) {
                                    mainVideoTrackClip.getActions().add(actionBase);
                                }
                            }
                            aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().add(mainVideoTrackClip);
                            i2++;
                            jSONArrayOptJSONArray2 = jSONArray;
                            str3 = str4;
                        }
                    }
                    i++;
                    str3 = str3;
                }
            }
            String str5 = str3;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("waterMark");
            String str6 = "uri";
            String str7 = "height";
            if (jSONObjectOptJSONObject2 != null) {
                WaterMark waterMark = new WaterMark();
                waterMark.setSource(new Source(jSONObjectOptJSONObject2.optString("uri")));
                waterMark.setWidth((float) jSONObjectOptJSONObject2.optDouble("width"));
                waterMark.setHeight((float) jSONObjectOptJSONObject2.optDouble("height"));
                waterMark.setX((float) jSONObjectOptJSONObject2.optDouble("xCoord"));
                waterMark.setY((float) jSONObjectOptJSONObject2.optDouble("yCoord"));
                waterMark.getActions().addAll(a(jSONObjectOptJSONObject2.optJSONArray("mActions")));
                aliyunEditorProject.getTimeline().getGlobalTracks().add(waterMark);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tailWaterMark");
            if (jSONObjectOptJSONObject3 != null) {
                TailWaterMark tailWaterMark = new TailWaterMark();
                tailWaterMark.setSource(new Source(jSONObjectOptJSONObject3.optString("mImgPath")));
                tailWaterMark.setWidth((float) jSONObjectOptJSONObject3.optDouble("mSizeX"));
                tailWaterMark.setHeight((float) jSONObjectOptJSONObject3.optDouble("mPosX"));
                tailWaterMark.setX((float) jSONObjectOptJSONObject3.optDouble("mPosX"));
                tailWaterMark.setY((float) jSONObjectOptJSONObject3.optDouble("mPosY"));
                str = str5;
                tailWaterMark.setDuration(jSONObjectOptJSONObject3.optLong(str));
                tailWaterMark.getActions().addAll(a(jSONObjectOptJSONObject3.optJSONArray("mActions")));
                aliyunEditorProject.getTimeline().getGlobalTracks().add(tailWaterMark);
            } else {
                str = str5;
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("canvasInfo");
            if (jSONObjectOptJSONObject4 != null) {
                PaintTrack paintTrack = new PaintTrack();
                paintTrack.setSource(new Source(jSONObject.optString("canvasPath")));
                paintTrack.setCanvasInfo((CanvasInfo) new Gson().fromJson(jSONObjectOptJSONObject4.toString(), CanvasInfo.class));
                paintTrack.setTimelineIn(0.0f);
                paintTrack.setTimelineOut(2.1474836E9f);
                aliyunEditorProject.getTimeline().getGlobalTracks().add(paintTrack);
            }
            String strOptString = jSONObject.optString("mVideoMV");
            if (!q.b(strOptString)) {
                MVFilter mVFilter = new MVFilter();
                mVFilter.setSource(new Source(strOptString));
                mVFilter.setTimelineIn(0.0f);
                mVFilter.setTimelineOut(2.1474836E9f);
                mVFilter.setMute(jSONObject.optBoolean("mNeedClearMvAudio"));
                mVFilter.setMixWeight(jSONObject.optInt("mMvAudioWeight"));
                aliyunEditorProject.getTimeline().getEffectTracks().add(mVFilter);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("mColorFilter");
            String str8 = "mResPath";
            if (jSONObjectOptJSONObject5 != null) {
                Filter filter = new Filter(new Source(jSONObjectOptJSONObject5.optString("mResPath")));
                filter.setType(EffectTrack.Type.filter);
                filter.setTimelineIn(jSONObjectOptJSONObject5.optInt("mStartTime") / 1000.0f);
                filter.setTimelineOut(filter.getTimelineIn() + (jSONObjectOptJSONObject5.optInt(str) / 1000.0f));
                aliyunEditorProject.getTimeline().getEffectTracks().add(filter);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("mAnimationFilters");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                int i3 = 0;
                while (i3 < jSONArrayOptJSONArray3.length()) {
                    JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    JSONArray jSONArray2 = jSONArrayOptJSONArray3;
                    Filter filter2 = new Filter(jSONObjectOptJSONObject6.optString(str8));
                    filter2.setType(EffectTrack.Type.animation_filter);
                    filter2.setTimelineIn(jSONObjectOptJSONObject6.optInt("mStartTime") / 1000.0f);
                    String str9 = str8;
                    filter2.setTimelineOut(filter2.getTimelineIn() + (jSONObjectOptJSONObject6.optInt(str) / 1000.0f));
                    boolean zOptBoolean = jSONObjectOptJSONObject6.optBoolean("mInvert");
                    JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject6.optJSONObject("mEffectConfig");
                    if (jSONObjectOptJSONObject7 != null) {
                        filter2.setEffectConfig((EffectConfig) new Gson().fromJson(jSONObjectOptJSONObject7.toString(), EffectConfig.class));
                    }
                    if (zOptBoolean) {
                        arrayList.add(filter2);
                    } else {
                        aliyunEditorProject.getTimeline().getEffectTracks().add(filter2);
                    }
                    i3++;
                    jSONArrayOptJSONArray3 = jSONArray2;
                    str8 = str9;
                    str6 = str6;
                }
            }
            String str10 = str6;
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("mTimeFilters");
            if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                int i4 = 0;
                while (i4 < jSONArrayOptJSONArray4.length()) {
                    JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray4.optJSONObject(i4);
                    TimeFilter timeFilter = new TimeFilter();
                    int iOptInt2 = jSONObjectOptJSONObject8.optInt("mType");
                    if (iOptInt2 == TimeEffectType.TIME_EFFECT_TYPE_NONE.ordinal()) {
                        jSONArrayOptJSONArray4 = jSONArrayOptJSONArray4;
                    } else {
                        if (iOptInt2 == 1) {
                            timeEffectType = TimeEffectType.TIME_EFFECT_TYPE_RATE;
                        } else if (iOptInt2 != 2) {
                            if (iOptInt2 == 3) {
                                timeEffectType = TimeEffectType.TIME_EFFECT_TYPE_INVERT;
                            }
                            if (iOptInt2 != 1 || iOptInt2 == 2) {
                                timeFilter.setStartTime(jSONObjectOptJSONObject8.optLong("mStartTime"));
                                timeFilter.setDuration(jSONObjectOptJSONObject8.optLong(str));
                                timeFilter.setParam((float) jSONObjectOptJSONObject8.optDouble("mParam"));
                                timeFilter.setNeedOriginDuration(jSONObjectOptJSONObject8.optBoolean("mIsNeedOriginDuration"));
                            }
                            aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                        } else {
                            timeEffectType = TimeEffectType.TIME_EFFECT_TYPE_REPEAT;
                        }
                        timeFilter.setTimeFilterType(timeEffectType.ordinal());
                        if (iOptInt2 != 1) {
                            timeFilter.setStartTime(jSONObjectOptJSONObject8.optLong("mStartTime"));
                            timeFilter.setDuration(jSONObjectOptJSONObject8.optLong(str));
                            timeFilter.setParam((float) jSONObjectOptJSONObject8.optDouble("mParam"));
                            timeFilter.setNeedOriginDuration(jSONObjectOptJSONObject8.optBoolean("mIsNeedOriginDuration"));
                        } else {
                            timeFilter.setStartTime(jSONObjectOptJSONObject8.optLong("mStartTime"));
                            timeFilter.setDuration(jSONObjectOptJSONObject8.optLong(str));
                            timeFilter.setParam((float) jSONObjectOptJSONObject8.optDouble("mParam"));
                            timeFilter.setNeedOriginDuration(jSONObjectOptJSONObject8.optBoolean("mIsNeedOriginDuration"));
                        }
                        aliyunEditorProject.getTimeline().getEffectTracks().add(timeFilter);
                    }
                    i4++;
                    jSONArrayOptJSONArray4 = jSONArrayOptJSONArray4;
                }
            }
            if (!arrayList.isEmpty()) {
                aliyunEditorProject.getTimeline().getEffectTracks().addAll(arrayList);
            }
            List<AudioTrackClip> listA2 = a(jSONObject.optJSONArray("mAudioMixes"), AudioTrackClip.Type.Music);
            listA2.addAll(a(jSONObject.optJSONArray("mAudioMixes"), AudioTrackClip.Type.Dubs));
            for (AudioTrackClip audioTrackClip : listA2) {
                AudioTrack audioTrack = new AudioTrack();
                audioTrack.getAudioTrackClips().add(audioTrackClip);
                audioTrack.setDuration(audioTrackClip.getOut() - audioTrackClip.getIn());
                aliyunEditorProject.getTimeline().getAudioTracks().add(audioTrack);
            }
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("mStaticImages");
            float f = 1000000.0f;
            if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                    JSONObject jSONObjectOptJSONObject9 = jSONArrayOptJSONArray5.optJSONObject(i5);
                    PhotoPasterTrack photoPasterTrack2 = new PhotoPasterTrack();
                    photoPasterTrack2.setSource(new Source(jSONObjectOptJSONObject9.optString("path")));
                    photoPasterTrack2.setX((float) jSONObjectOptJSONObject9.optDouble("x"));
                    photoPasterTrack2.setY((float) jSONObjectOptJSONObject9.optDouble("y"));
                    photoPasterTrack2.setWidth((float) jSONObjectOptJSONObject9.optDouble("width"));
                    photoPasterTrack2.setHeight((float) jSONObjectOptJSONObject9.optDouble("height"));
                    photoPasterTrack2.setRotation((float) jSONObjectOptJSONObject9.optDouble(Key.ROTATION));
                    photoPasterTrack2.setMirror(jSONObjectOptJSONObject9.optBoolean("mirror"));
                    photoPasterTrack2.setTimelineIn(jSONObjectOptJSONObject9.optLong("start") / 1000000.0f);
                    photoPasterTrack2.setTimelineOut(jSONObjectOptJSONObject9.optLong("end") / 1000000.0f);
                }
            }
            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("captionList");
            if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                int i6 = 0;
                while (i6 < jSONArrayOptJSONArray5.length()) {
                    JSONObject jSONObjectOptJSONObject10 = jSONArrayOptJSONArray5.optJSONObject(i6);
                    CaptionTrack captionTrack = new CaptionTrack();
                    captionTrack.setTimelineIn(jSONObjectOptJSONObject10.optLong("startTime") / f);
                    String str11 = str7;
                    captionTrack.setTimelineOut(captionTrack.getTimelineIn() + (jSONObjectOptJSONObject10.optLong("duration") / 1000000.0f));
                    captionTrack.setRotation((float) jSONObjectOptJSONObject10.optDouble(Key.ROTATION));
                    captionTrack.setScale((float) jSONObjectOptJSONObject10.optDouble("scale"));
                    captionTrack.setText(jSONObjectOptJSONObject10.optString("text"));
                    captionTrack.setX((float) jSONObjectOptJSONObject10.optDouble("x"));
                    captionTrack.setY((float) jSONObjectOptJSONObject10.optDouble("y"));
                    captionTrack.setWidth((float) jSONObjectOptJSONObject10.optDouble("width"));
                    captionTrack.setHeight((float) jSONObjectOptJSONObject10.optDouble(str11));
                    captionTrack.setFontSize((float) jSONObjectOptJSONObject10.optDouble("fontSize"));
                    String strOptString2 = jSONObjectOptJSONObject10.optString("fontPath");
                    if (!q.b(strOptString2)) {
                        captionTrack.setFont(new Source(strOptString2));
                    }
                    captionTrack.setTypeface(jSONObjectOptJSONObject10.optInt("fontTypeface"));
                    captionTrack.setTextColor(jSONObjectOptJSONObject10.optInt("fontColor"));
                    captionTrack.setOutlineColor(jSONObjectOptJSONObject10.optInt("outlineColor"));
                    captionTrack.setOutlineWidth((float) jSONObjectOptJSONObject10.optDouble("outlineWidth"));
                    captionTrack.setShadowColor(jSONObjectOptJSONObject10.optInt("shadowColor"));
                    captionTrack.setShadowOffsetX((float) jSONObjectOptJSONObject10.optDouble("shadowOffsetX"));
                    captionTrack.setShadowOffsetY((float) jSONObjectOptJSONObject10.optDouble("shadowOffsetY"));
                    String strOptString3 = jSONObjectOptJSONObject10.optString("fontEffectTempldate");
                    if (!q.b(strOptString3)) {
                        captionTrack.setFontEffectSource(new Source(strOptString3));
                    }
                    String strOptString4 = jSONObjectOptJSONObject10.optString("bubbleEffectTempldate");
                    if (!q.b(strOptString4)) {
                        captionTrack.setSource(new Source(strOptString4));
                    }
                    aliyunEditorProject.getTimeline().getPasterTracks().add(captionTrack);
                    i6++;
                    str7 = str11;
                    f = 1000000.0f;
                }
            }
            String str12 = str7;
            JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("mRollCaptionDescriptorList");
            if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
                RollCaptionTrack rollCaptionTrack = new RollCaptionTrack();
                for (int i7 = 0; i7 < jSONArrayOptJSONArray7.length(); i7++) {
                    JSONObject jSONObjectOptJSONObject11 = jSONArrayOptJSONArray7.optJSONObject(i7);
                    RollCaptionTrackClip rollCaptionTrackClip = new RollCaptionTrackClip();
                    rollCaptionTrackClip.setText(jSONObjectOptJSONObject11.optString("mCaptionText"));
                    rollCaptionTrackClip.setTimelineIn(jSONObjectOptJSONObject11.optLong("mStartTs") / 1000.0f);
                    rollCaptionTrackClip.setTextColor(jSONObjectOptJSONObject11.optInt("mTextColor"));
                    rollCaptionTrackClip.setOutlineColor(jSONObjectOptJSONObject11.optInt("mTextStrokeColor"));
                    String strOptString5 = jSONObjectOptJSONObject11.optString("mFont");
                    if (!q.b(strOptString5)) {
                        rollCaptionTrackClip.setFont(new Source(strOptString5));
                    }
                    rollCaptionTrack.getRollCaptionTrackClips().add(rollCaptionTrackClip);
                }
                aliyunEditorProject.getTimeline().getPasterTracks().add(rollCaptionTrack);
            }
            JSONArray jSONArrayOptJSONArray8 = jSONObject.optJSONArray("pasterList");
            if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() > 0) {
                int i8 = 0;
                while (i8 < jSONArrayOptJSONArray8.length()) {
                    JSONObject jSONObjectOptJSONObject12 = jSONArrayOptJSONArray8.optJSONObject(i8);
                    int iOptInt3 = jSONObjectOptJSONObject12.optInt("type");
                    if (iOptInt3 == 0) {
                        str2 = str10;
                        gifPasterTrack = new GifPasterTrack();
                        gifPasterTrack.setSource(new Source(jSONObjectOptJSONObject12.optString(str2)));
                    } else if (iOptInt3 == 1 || iOptInt3 == 2) {
                        subTitleTrack = iOptInt3 == 1 ? new SubTitleTrack() : new BubbleCaptionTrack();
                        subTitleTrack.setText(jSONObjectOptJSONObject12.optString("text"));
                        subTitleTrack.setTextColor(jSONObjectOptJSONObject12.optInt("textColor"));
                        subTitleTrack.setTextStrokeColor(jSONObjectOptJSONObject12.optInt("textStrokeColor"));
                        subTitleTrack.setTextBackgroundColor(jSONObjectOptJSONObject12.optInt("textLabelColor"));
                        subTitleTrack.setTextRotation((float) jSONObjectOptJSONObject12.optDouble("textRotation"));
                        subTitleTrack.setTextMaxLines(jSONObjectOptJSONObject12.optInt("mTextMaxLines"));
                        subTitleTrack.setTextAlignment(jSONObjectOptJSONObject12.optInt("mTextAlignment"));
                        subTitleTrack.setTextWidth((float) jSONObjectOptJSONObject12.optDouble("textWidth"));
                        subTitleTrack.setTextHeight((float) jSONObjectOptJSONObject12.optDouble("textHeight"));
                        subTitleTrack.setTextPaddingX((float) jSONObjectOptJSONObject12.optDouble("mTextPaddingX"));
                        subTitleTrack.setTextPaddingY((float) jSONObjectOptJSONObject12.optDouble("mTextPaddingY"));
                        subTitleTrack.setTextSize((float) jSONObjectOptJSONObject12.optDouble("mTextSize"));
                        if (iOptInt3 == 1) {
                            subTitleTrack.setFont(new Source(jSONObjectOptJSONObject12.optString(e.f6416j)));
                            str2 = str10;
                        } else {
                            str2 = str10;
                            subTitleTrack.setSource(new Source(jSONObjectOptJSONObject12.optString(str2)));
                            ((BubbleCaptionTrack) subTitleTrack).setTextCenterX((float) jSONObjectOptJSONObject12.optDouble("textOffsetX"));
                            ((BubbleCaptionTrack) subTitleTrack).setTextCenterY((float) jSONObjectOptJSONObject12.optDouble("textOffsetY"));
                        }
                    } else {
                        str2 = str10;
                        photoPasterTrack = null;
                    }
                    if (photoPasterTrack != null) {
                        photoPasterTrack = gifPasterTrack;
                        photoPasterTrack = subTitleTrack;
                        photoPasterTrack = subTitleTrack;
                        photoPasterTrack.setTimelineIn(jSONObjectOptJSONObject12.optLong("start") / 1000000.0f);
                        photoPasterTrack.setTimelineOut(jSONObjectOptJSONObject12.optLong("end") / 1000000.0f);
                        photoPasterTrack.setMirror(jSONObjectOptJSONObject12.optBoolean("mirror"));
                        photoPasterTrack.setRotation((float) jSONObjectOptJSONObject12.optDouble(Key.ROTATION));
                        photoPasterTrack.setX((float) jSONObjectOptJSONObject12.optDouble("x"));
                        photoPasterTrack.setY((float) jSONObjectOptJSONObject12.optDouble("y"));
                        photoPasterTrack.setWidth((float) jSONObjectOptJSONObject12.optDouble("width"));
                        photoPasterTrack.setHeight((float) jSONObjectOptJSONObject12.optDouble(str12));
                        photoPasterTrack.getActions().addAll(a(jSONObjectOptJSONObject12.optJSONArray(AssistPushConsts.MSG_TYPE_ACTIONS)));
                        aliyunEditorProject.getTimeline().getPasterTracks().add(photoPasterTrack);
                    } else {
                        photoPasterTrack = gifPasterTrack;
                        photoPasterTrack = subTitleTrack;
                        photoPasterTrack = subTitleTrack;
                    }
                    i8++;
                    str10 = str2;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            aliyunEditorProject.setTitle(file.getName());
            aliyunEditorProject.setCreationTime(AliyunEditorProject.DATE_FORMAT.format(new Date(jCurrentTimeMillis)));
            aliyunEditorProject.setModifiedTime(aliyunEditorProject.getCreationTime());
            aliyunEditorProject.refreshTimeLine();
            aliyunEditorProject.setVersion(0);
            return aliyunEditorProject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
