package com.zj.adlib;

import androidx.camera.video.AudioStats;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class st3 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f44773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19650a;
    public final double b;
    public final double c;

    public st3(double d, double d2, double d3, String str) {
        super(ParsedResultType.GEO);
        this.f44773a = d;
        this.b = d2;
        this.c = d3;
        this.f19650a = str;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f44773a);
        sb.append(", ");
        sb.append(this.b);
        if (this.c > AudioStats.AUDIO_AMPLITUDE_NONE) {
            sb.append(", ");
            sb.append(this.c);
            sb.append('m');
        }
        if (this.f19650a != null) {
            sb.append(" (");
            sb.append(this.f19650a);
            sb.append(')');
        }
        return sb.toString();
    }

    public double d() {
        return this.c;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f44773a);
        sb.append(',');
        sb.append(this.b);
        if (this.c > AudioStats.AUDIO_AMPLITUDE_NONE) {
            sb.append(',');
            sb.append(this.c);
        }
        if (this.f19650a != null) {
            sb.append('?');
            sb.append(this.f19650a);
        }
        return sb.toString();
    }

    public double f() {
        return this.f44773a;
    }

    public double g() {
        return this.b;
    }

    public String h() {
        return this.f19650a;
    }
}
