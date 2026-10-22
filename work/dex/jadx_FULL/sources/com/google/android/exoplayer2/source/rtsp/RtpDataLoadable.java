package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.Loader;
import com.zj.adlib.d72;
import com.zj.adlib.ek7;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.sb0;
import com.zj.adlib.zf2;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtpDataLoadable implements Loader.Loadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExtractorOutput f4319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RtpDataChannel.Factory f4320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventListener f4321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f4322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ek7 f4323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f4324a;
    public volatile long b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f4318a = gj9.y();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile long f4317a = -9223372036854775807L;

    public interface EventListener {
        void a(String str, RtpDataChannel rtpDataChannel);
    }

    public RtpDataLoadable(int i, f fVar, EventListener eventListener, ExtractorOutput extractorOutput, RtpDataChannel.Factory factory) {
        this.f30949a = i;
        this.f4322a = fVar;
        this.f4321a = eventListener;
        this.f4319a = extractorOutput;
        this.f4320a = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, RtpDataChannel rtpDataChannel) {
        this.f4321a.a(str, rtpDataChannel);
    }

    public void c() {
        ((ek7) sb0.g(this.f4323a)).f();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.f4324a = true;
    }

    public void d(long j, long j2) {
        this.f4317a = j;
        this.b = j2;
    }

    public void e(int i) {
        if (((ek7) sb0.g(this.f4323a)).e()) {
            return;
        }
        this.f4323a.g(i);
    }

    public void f(long j) {
        if (j == -9223372036854775807L || ((ek7) sb0.g(this.f4323a)).e()) {
            return;
        }
        this.f4323a.h(j);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        final RtpDataChannel rtpDataChannelA = null;
        try {
            rtpDataChannelA = this.f4320a.a(this.f30949a);
            final String strE = rtpDataChannelA.e();
            this.f4318a.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4392a.b(strE, rtpDataChannelA);
                }
            });
            zf2 zf2Var = new zf2((DataReader) sb0.g(rtpDataChannelA), 0L, -1L);
            ek7 ek7Var = new ek7(this.f4322a.f4412a, this.f30949a);
            this.f4323a = ek7Var;
            ek7Var.b(this.f4319a);
            while (!this.f4324a) {
                if (this.f4317a != -9223372036854775807L) {
                    this.f4323a.seek(this.b, this.f4317a);
                    this.f4317a = -9223372036854775807L;
                }
                if (this.f4323a.c(zf2Var, new iv6()) == -1) {
                    break;
                }
            }
        } finally {
            d72.a(rtpDataChannelA);
        }
    }
}
