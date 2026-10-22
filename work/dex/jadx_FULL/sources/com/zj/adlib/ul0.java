package com.zj.adlib;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.OnBarListener;
import com.gyf.immersionbar.OnKeyboardListener;
import com.gyf.immersionbar.OnNavigationBarListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ul0 implements Cloneable {

    @ColorInt
    public int R;

    @ColorInt
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f20088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnBarListener f20090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnKeyboardListener f20091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnNavigationBarListener f20092a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f20095b;

    @ColorInt
    public int K = 0;

    @ColorInt
    public int L = -16777216;
    public int M = -16777216;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float f45169a = 0.0f;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float b = 0.0f;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float c = 0.0f;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float d = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20094a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f20096b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BarHide f20089a = BarHide.FLAG_SHOW_BAR;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f20097c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f20098d = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f20099e = false;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f20100f = false;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float e = 0.0f;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f20101g = true;

    @ColorInt
    public int N = -16777216;

    @ColorInt
    public int O = -16777216;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<View, Map<Integer, Integer>> f20093a = new HashMap();

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float g = 0.0f;

    @ColorInt
    public int P = 0;

    @ColorInt
    public int Q = -16777216;

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float h = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f20102h = false;
    public boolean i = true;
    public boolean j = false;
    public boolean k = false;
    public int T = 18;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public boolean o = true;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ul0 m1069clone() {
        try {
            return (ul0) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
