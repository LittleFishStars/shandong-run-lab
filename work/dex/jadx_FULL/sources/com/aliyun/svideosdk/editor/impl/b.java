package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.AliyunPip;
import com.aliyun.svideosdk.common.struct.project.AudioEffect;
import com.aliyun.svideosdk.common.struct.project.AudioFade;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip;
import com.aliyun.svideosdk.editor.AliyunIAudioController;
import com.aliyun.svideosdk.editor.AudioEffectType;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.editor.ShapeType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b implements AliyunIAudioController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25735a;
    private AliyunPip b;
    private PipVideoTrackClip c;
    private WeakReference<f> d;

    public b(NativeEditor nativeEditor, AliyunPip aliyunPip, PipVideoTrackClip pipVideoTrackClip, f fVar) {
        this.f25735a = nativeEditor;
        this.b = aliyunPip;
        this.c = pipVideoTrackClip;
        this.d = new WeakReference<>(fVar);
    }

    private static final int a(int i, boolean z) {
        return (!z ? i == 3 : i == 2) ? 0 : 1;
    }

    private void a() {
        this.c.setMixWeight(this.b.getVolume());
        this.c.setDenoiseWeight(this.b.getDenoiseWeight());
        AliyunPip.AliyunAudioEffect audioEffect = this.b.getAudioEffect();
        AliyunPip.AliyunAudioFade audioFadeIn = this.b.getAudioFadeIn();
        AliyunPip.AliyunAudioFade audioFadeOut = this.b.getAudioFadeOut();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Effect effect : this.c.getEffects()) {
            if (effect.getType() == Effect.Type.audio_effect) {
                AudioEffect audioEffect2 = (AudioEffect) effect;
                audioEffect2.mEffectType = audioEffect.mEffectType;
                audioEffect2.mEffectParam = (int) (audioEffect.mEffectParam * 100.0f);
                z = true;
            } else if (effect.getType() == Effect.Type.audio_fade) {
                AudioFade audioFade = (AudioFade) effect;
                if (audioFade.isFadeIn) {
                    audioFade.shapeType = a(audioFadeIn.shapeType, true);
                    audioFade.duration = com.aliyun.common.d.b.a(audioFadeIn.duration);
                    z2 = true;
                } else {
                    audioFade.shapeType = a(audioFadeOut.shapeType, false);
                    audioFade.duration = com.aliyun.common.d.b.a(audioFadeOut.duration);
                    z3 = true;
                }
            }
        }
        if (!z) {
            AudioEffect audioEffect3 = new AudioEffect();
            audioEffect3.mEffectType = audioEffect.mEffectType;
            audioEffect3.mEffectParam = (int) (audioEffect.mEffectParam * 100.0f);
            this.c.getEffects().add(audioEffect3);
        }
        if (!z2) {
            long j = audioFadeIn.duration;
            if (j > 0) {
                this.c.getEffects().add(new AudioFade(audioFadeIn.shapeType, j, true));
            }
        }
        if (z3) {
            return;
        }
        long j2 = audioFadeOut.duration;
        if (j2 > 0) {
            this.c.getEffects().add(new AudioFade(audioFadeOut.shapeType, j2, false));
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public int apply() {
        this.f25735a.updatePicInPic(this.b.getNativeHandle());
        a();
        if (this.d.get() == null) {
            return 0;
        }
        this.d.get().saveEffectToLocal();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController denoise(int i) {
        this.b.setDenoiseWeight(i);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public int getVolume() {
        return this.b.getVolume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController removeAudioFadeIn() {
        this.b.setAudioFadeIn(new AliyunPip.AliyunAudioFade(0, 0L, true));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController removeAudioFadeOut() {
        this.b.setAudioFadeOut(new AliyunPip.AliyunAudioFade(1, 0L, false));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController setAudioEffect(AudioEffectType audioEffectType, float f) {
        this.b.addEffect(new AliyunPip.AliyunAudioEffect(audioEffectType.getEffectType(), f));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController setAudioFadeIn(ShapeType shapeType, long j) {
        this.b.setAudioFadeIn(new AliyunPip.AliyunAudioFade(shapeType == ShapeType.SHAPE_TYPE_LINEAR ? 0 : 2, com.aliyun.common.d.b.b(j), true));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController setAudioFadeOut(ShapeType shapeType, long j) {
        this.b.setAudioFadeOut(new AliyunPip.AliyunAudioFade(shapeType == ShapeType.SHAPE_TYPE_LINEAR ? 1 : 3, com.aliyun.common.d.b.b(j), false));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public AliyunIAudioController setVolume(int i) {
        this.b.setVolume(i);
        return this;
    }
}
