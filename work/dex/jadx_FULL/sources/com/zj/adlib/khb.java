package com.zj.adlib;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class khb {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17702a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f17706b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f42823a = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double b = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double c = AudioStats.AUDIO_AMPLITUDE_NONE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f17701a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f17705b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f17707c = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17704a = false;

    public khb(String str) {
        this.f17703a = str;
    }

    public final double a(khb khbVar) {
        return khbVar != null ? thb.a(this.b, this.f42823a, khbVar.b, khbVar.f42823a) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
