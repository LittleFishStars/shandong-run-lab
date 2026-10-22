package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.zj.adlib.mc1;
import com.zj.adlib.qe0;
import com.zj.adlib.z39;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DefaultRenderersFactory implements RenderersFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30479a = "DefaultRenderersFactory";
    public static final int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f2024b = 5000;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2030a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2031b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2032c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2033d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.mediacodec.b f2029a = new com.google.android.exoplayer2.mediacodec.b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2025a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2026a = 5000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaCodecSelector f2028a = MediaCodecSelector.f30764a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this.f2027a = context;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.f2027a, this.f2025a, this.f2028a, this.f2030a, handler, videoRendererEventListener, this.f2026a, arrayList);
        AudioSink audioSinkBuildAudioSink = buildAudioSink(this.f2027a, this.f2031b, this.f2032c, this.f2033d);
        if (audioSinkBuildAudioSink != null) {
            buildAudioRenderers(this.f2027a, this.f2025a, this.f2028a, this.f2030a, audioSinkBuildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        buildTextRenderers(this.f2027a, textOutput, handler.getLooper(), this.f2025a, arrayList);
        buildMetadataRenderers(this.f2027a, metadataOutput, handler.getLooper(), this.f2025a, arrayList);
        buildCameraMotionRenderers(this.f2027a, this.f2025a, arrayList);
        buildMiscellaneousRenderers(this.f2027a, handler, this.f2025a, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    public DefaultRenderersFactory b(boolean z) {
        this.f2029a.b(z);
        return this;
    }

    public void buildAudioRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        int i2;
        int i3;
        int i4;
        arrayList.add(new com.google.android.exoplayer2.audio.f(context, getCodecAdapterFactory(), mediaCodecSelector, z, handler, audioRendererEventListener, audioSink));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(new Class[0]).newInstance(new Object[0]));
                    Log.h(f30479a, "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating MIDI extension", e2);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            try {
                i3 = i2 + 1;
                try {
                    arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.h(f30479a, "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused3) {
                    i2 = i3;
                    i3 = i2;
                }
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating Opus extension", e3);
            }
        } catch (ClassNotFoundException unused4) {
        }
        try {
            try {
                i4 = i3 + 1;
                try {
                    arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    Log.h(f30479a, "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                    i3 = i4;
                    i4 = i3;
                }
            } catch (Exception e4) {
                throw new RuntimeException("Error instantiating FLAC extension", e4);
            }
        } catch (ClassNotFoundException unused6) {
        }
        try {
            arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
            Log.h(f30479a, "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException unused7) {
        } catch (Exception e5) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e5);
        }
    }

    @Nullable
    public AudioSink buildAudioSink(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink.c().g(qe0.c(context)).l(z).k(z2).m(z3 ? 1 : 0).f();
    }

    public void buildCameraMotionRenderers(Context context, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new mc1());
    }

    public void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.a(metadataOutput, looper));
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new z39(textOutput, looper));
    }

    public void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        int i2;
        arrayList.add(new com.google.android.exoplayer2.video.a(context, getCodecAdapterFactory(), mediaCodecSelector, j, z, handler, videoRendererEventListener, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                    Log.h(f30479a, "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating VP9 extension", e2);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            arrayList.add(i2, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
            Log.h(f30479a, "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating AV1 extension", e3);
        }
    }

    public DefaultRenderersFactory c() {
        this.f2029a.c();
        return this;
    }

    public DefaultRenderersFactory d() {
        this.f2029a.d();
        return this;
    }

    public DefaultRenderersFactory e(long j) {
        this.f2026a = j;
        return this;
    }

    public DefaultRenderersFactory f(boolean z) {
        this.f2031b = z;
        return this;
    }

    public DefaultRenderersFactory g(boolean z) {
        this.f2033d = z;
        return this;
    }

    public MediaCodecAdapter.Factory getCodecAdapterFactory() {
        return this.f2029a;
    }

    public DefaultRenderersFactory h(boolean z) {
        this.f2032c = z;
        return this;
    }

    public DefaultRenderersFactory i(boolean z) {
        this.f2030a = z;
        return this;
    }

    public DefaultRenderersFactory j(int i) {
        this.f2025a = i;
        return this;
    }

    public DefaultRenderersFactory k(MediaCodecSelector mediaCodecSelector) {
        this.f2028a = mediaCodecSelector;
        return this;
    }
}
