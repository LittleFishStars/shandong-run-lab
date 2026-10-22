package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.zj.adlib.sb0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Subtitle f31006a;
    public long b;

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void b() {
        super.b();
        this.f31006a = null;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return ((Subtitle) sb0.g(this.f31006a)).getCues(j - this.b);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return ((Subtitle) sb0.g(this.f31006a)).getEventTime(i) + this.b;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return ((Subtitle) sb0.g(this.f31006a)).getEventTimeCount();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return ((Subtitle) sb0.g(this.f31006a)).getNextEventTimeIndex(j - this.b);
    }

    public void k(long j, Subtitle subtitle, long j2) {
        super.f30577a = j;
        this.f31006a = subtitle;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.b = j;
    }
}
