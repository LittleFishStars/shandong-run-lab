package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.base.Splitter;
import com.google.common.net.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y38 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20770a = "SefReader";
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 2192;
    public static final int h = 2816;
    public static final int i = 2817;
    public static final int j = 2819;
    public static final int k = 2820;
    public static final int l = 1397048916;
    public static final int m = 12;
    public static final int n = 8;
    public static final int o = 12;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f20773b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Splitter f45950a = Splitter.h(c.b);
    public static final Splitter b = Splitter.h('*');

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<a> f20772a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20771a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45951a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f20774a;
        public final int b;

        public a(int i, long j, int i2) {
            this.f45951a = i;
            this.f20774a = j;
            this.b = i2;
        }
    }

    public static int b(String str) throws ParserException {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return g;
            case "Super_SlowMotion_Edit_Data":
                return j;
            case "Super_SlowMotion_Data":
                return h;
            case "Super_SlowMotion_Deflickering_On":
                return k;
            case "Super_SlowMotion_BGM":
                return i;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    public static SlowMotionData f(om6 om6Var, int i2) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> listO = b.o(om6Var.D(i2));
        for (int i3 = 0; i3 < listO.size(); i3++) {
            List<String> listO2 = f45950a.o(listO.get(i3));
            if (listO2.size() != 3) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listO2.get(0)), Long.parseLong(listO2.get(1)), 1 << (Integer.parseInt(listO2.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedContainer(null, e2);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public final void a(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        om6 om6Var = new om6(8);
        extractorInput.readFully(om6Var.d(), 0, 8);
        this.f20773b = om6Var.r() + 8;
        if (om6Var.o() != 1397048916) {
            iv6Var.f42452a = 0L;
        } else {
            iv6Var.f42452a = extractorInput.getPosition() - ((long) (this.f20773b - 12));
            this.f20771a = 2;
        }
    }

    public int c(ExtractorInput extractorInput, iv6 iv6Var, List<Metadata.Entry> list) throws IOException {
        int i2 = this.f20771a;
        long j2 = 0;
        if (i2 == 0) {
            long length = extractorInput.getLength();
            if (length != -1 && length >= 8) {
                j2 = length - 8;
            }
            iv6Var.f42452a = j2;
            this.f20771a = 1;
        } else if (i2 == 1) {
            a(extractorInput, iv6Var);
        } else if (i2 == 2) {
            d(extractorInput, iv6Var);
        } else {
            if (i2 != 3) {
                throw new IllegalStateException();
            }
            e(extractorInput, list);
            iv6Var.f42452a = 0L;
        }
        return 1;
    }

    public final void d(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        long length = extractorInput.getLength();
        int i2 = (this.f20773b - 12) - 8;
        om6 om6Var = new om6(i2);
        extractorInput.readFully(om6Var.d(), 0, i2);
        for (int i3 = 0; i3 < i2 / 12; i3++) {
            om6Var.T(2);
            short sU = om6Var.u();
            if (sU == 2192 || sU == 2816 || sU == 2817 || sU == 2819 || sU == 2820) {
                this.f20772a.add(new a(sU, (length - ((long) this.f20773b)) - ((long) om6Var.r()), om6Var.r()));
            } else {
                om6Var.T(8);
            }
        }
        if (this.f20772a.isEmpty()) {
            iv6Var.f42452a = 0L;
        } else {
            this.f20771a = 3;
            iv6Var.f42452a = this.f20772a.get(0).f20774a;
        }
    }

    public final void e(ExtractorInput extractorInput, List<Metadata.Entry> list) throws IOException {
        long position = extractorInput.getPosition();
        int length = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - ((long) this.f20773b));
        om6 om6Var = new om6(length);
        extractorInput.readFully(om6Var.d(), 0, length);
        for (int i2 = 0; i2 < this.f20772a.size(); i2++) {
            a aVar = this.f20772a.get(i2);
            om6Var.S((int) (aVar.f20774a - position));
            om6Var.T(4);
            int iR = om6Var.r();
            int iB = b(om6Var.D(iR));
            int i3 = aVar.b - (iR + 8);
            if (iB == 2192) {
                list.add(f(om6Var, i3));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f20772a.clear();
        this.f20771a = 0;
    }
}
