package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.math.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e97 extends AbstractRSSReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41377a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 11;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16243a;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int[] f16240f = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final int[] f16241g = {4, 20, 52, 104, 204};
    public static final int[] h = {0, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 1388, 2948, 3988};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f16237a = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[][] f16238b = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 91}, new int[]{62, 186, 136, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 151, 31, 93, 68, 204, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, c.f6376a, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[][] f16239c = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<hb3> f16242a = new ArrayList(11);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<kb3> f16244b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final int[] f16245e = new int[2];

    public static ug7 i(List<hb3> list) throws NotFoundException, FormatException {
        String strB = AbstractExpandedDecoder.a(rv0.a(list)).b();
        xg7[] xg7VarArrA = list.get(0).a().a();
        xg7[] xg7VarArrA2 = list.get(list.size() - 1).a().a();
        ug7 ug7Var = new ug7(strB, null, new xg7[]{xg7VarArrA[0], xg7VarArrA[1], xg7VarArrA2[0], xg7VarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return ug7Var;
    }

    public static int m(qv0 qv0Var, int i) {
        return qv0Var.m(i) ? qv0Var.p(qv0Var.r(i)) : qv0Var.r(qv0Var.p(i));
    }

    public static boolean o(bh3 bh3Var, boolean z, boolean z2) {
        return (bh3Var.c() == 0 && z && z2) ? false : true;
    }

    public static boolean p(Iterable<hb3> iterable, Iterable<kb3> iterable2) {
        boolean z;
        boolean z2;
        Iterator<kb3> it = iterable2.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            kb3 next = it.next();
            Iterator<hb3> it2 = iterable.iterator();
            do {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                hb3 next2 = it2.next();
                Iterator<hb3> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
            } while (z2);
        } while (!z);
        return true;
    }

    public static boolean q(List<hb3> list) {
        boolean z;
        for (int[] iArr : f16239c) {
            if (list.size() <= iArr.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i).a().c() != iArr[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void s(Collection<hb3> collection, Collection<kb3> collection2) {
        boolean z;
        Iterator<kb3> it = collection2.iterator();
        while (it.hasNext()) {
            kb3 next = it.next();
            if (next.a().size() != collection.size()) {
                Iterator<hb3> it2 = next.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    } else if (!collection.contains(it2.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    public static void u(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f16242a.clear();
        this.f16243a = false;
        try {
            return i(k(i, qv0Var));
        } catch (NotFoundException unused) {
            this.f16242a.clear();
            this.f16243a = true;
            return i(k(i, qv0Var));
        }
    }

    public final void e(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int iD = se5.d(getOddCounts());
        int iD2 = se5.d(getEvenCounts());
        boolean z5 = true;
        if (iD > 13) {
            z2 = true;
            z = false;
        } else if (iD < 4) {
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = false;
        }
        if (iD2 > 13) {
            z4 = true;
            z3 = false;
        } else if (iD2 < 4) {
            z3 = true;
            z4 = false;
        } else {
            z3 = false;
            z4 = false;
        }
        int i2 = (iD + iD2) - i;
        boolean z6 = (iD & 1) == 1;
        boolean z7 = (iD2 & 1) == 0;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z6) {
                    if (z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z2 = true;
                } else {
                    if (!z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z4 = true;
                }
            } else if (z6) {
                if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD < iD2) {
                    z4 = true;
                } else {
                    z3 = true;
                    z2 = true;
                }
            } else if (z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            z5 = z;
        } else if (z6) {
            if (z7) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            z3 = true;
            z5 = z;
        }
        if (z5) {
            if (z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z2) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    public final boolean f() {
        hb3 hb3Var = this.f16242a.get(0);
        p62 p62VarB = hb3Var.b();
        p62 p62VarC = hb3Var.c();
        if (p62VarC == null) {
            return false;
        }
        int iA = p62VarC.a();
        int i = 2;
        for (int i2 = 1; i2 < this.f16242a.size(); i2++) {
            hb3 hb3Var2 = this.f16242a.get(i2);
            iA += hb3Var2.b().a();
            i++;
            p62 p62VarC2 = hb3Var2.c();
            if (p62VarC2 != null) {
                iA += p62VarC2.a();
                i++;
            }
        }
        return ((i + (-4)) * 211) + (iA % 211) == p62VarB.b();
    }

    public final List<hb3> g(List<kb3> list, int i) throws NotFoundException {
        while (i < this.f16244b.size()) {
            kb3 kb3Var = this.f16244b.get(i);
            this.f16242a.clear();
            Iterator<kb3> it = list.iterator();
            while (it.hasNext()) {
                this.f16242a.addAll(it.next().a());
            }
            this.f16242a.addAll(kb3Var.a());
            if (q(this.f16242a)) {
                if (f()) {
                    return this.f16242a;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(kb3Var);
                try {
                    return g(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List<hb3> h(boolean z) {
        List<hb3> listG = null;
        if (this.f16244b.size() > 25) {
            this.f16244b.clear();
            return null;
        }
        this.f16242a.clear();
        if (z) {
            Collections.reverse(this.f16244b);
        }
        try {
            listG = g(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.f16244b);
        }
        return listG;
    }

    public p62 j(qv0 qv0Var, bh3 bh3Var, boolean z, boolean z2) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        Arrays.fill(dataCharacterCounters, 0);
        if (z2) {
            OneDReader.recordPatternInReverse(qv0Var, bh3Var.b()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(qv0Var, bh3Var.b()[1], dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float fD = se5.d(dataCharacterCounters) / 17;
        float f2 = (bh3Var.b()[1] - bh3Var.b()[0]) / 15.0f;
        if (Math.abs(fD - f2) / f2 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
            float f3 = (dataCharacterCounters[i3] * 1.0f) / fD;
            int i4 = (int) (0.5f + f3);
            if (i4 < 1) {
                if (f3 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f3 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                oddCounts[i5] = i4;
                oddRoundingErrors[i5] = f3 - i4;
            } else {
                evenCounts[i5] = i4;
                evenRoundingErrors[i5] = f3 - i4;
            }
        }
        e(17);
        int iC = (((bh3Var.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i6 = 0;
        int i7 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (o(bh3Var, z, z2)) {
                i6 += oddCounts[length2] * f16238b[iC][length2 * 2];
            }
            i7 += oddCounts[length2];
        }
        int i8 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (o(bh3Var, z, z2)) {
                i8 += evenCounts[length3] * f16238b[iC][(length3 * 2) + 1];
            }
        }
        int i9 = i6 + i8;
        if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = (13 - i7) / 2;
        int i11 = f16240f[i10];
        return new p62((f97.b(oddCounts, i11, true) * f16241g[i10]) + f97.b(evenCounts, 9 - i11, false) + h[i10], i9);
    }

    public List<hb3> k(int i, qv0 qv0Var) throws NotFoundException {
        boolean z = false;
        while (!z) {
            try {
                List<hb3> list = this.f16242a;
                list.add(t(qv0Var, list, i));
            } catch (NotFoundException e2) {
                if (this.f16242a.isEmpty()) {
                    throw e2;
                }
                z = true;
            }
        }
        if (f()) {
            return this.f16242a;
        }
        boolean z2 = !this.f16244b.isEmpty();
        v(i);
        if (z2) {
            List<hb3> listH = h(false);
            if (listH != null) {
                return listH;
            }
            List<hb3> listH2 = h(true);
            if (listH2 != null) {
                return listH2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void l(qv0 qv0Var, List<hb3> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int iS = qv0Var.s();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.f16243a) {
            z = !z;
        }
        boolean z2 = false;
        while (i < iS) {
            z2 = !qv0Var.m(i);
            if (!z2) {
                break;
            } else {
                i++;
            }
        }
        int i2 = 0;
        boolean z3 = z2;
        int i3 = i;
        while (i < iS) {
            if (qv0Var.m(i) != z3) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        u(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.f16245e;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        u(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public List<kb3> n() {
        return this.f16244b;
    }

    public final bh3 r(qv0 qv0Var, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.f16245e[0] - 1;
            while (i5 >= 0 && !qv0Var.m(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.f16245e;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.f16245e;
            int i7 = iArr2[0];
            int iR = qv0Var.r(iArr2[1] + 1);
            i2 = iR;
            i3 = i7;
            i4 = iR - this.f16245e[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new bh3(AbstractRSSReader.parseFinderValue(decodeFinderCounters, f16237a), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.f16242a.clear();
        this.f16244b.clear();
    }

    public hb3 t(qv0 qv0Var, List<hb3> list, int i) throws NotFoundException {
        bh3 bh3VarR;
        p62 p62VarJ;
        boolean z = list.size() % 2 == 0;
        if (this.f16243a) {
            z = !z;
        }
        int iM = -1;
        boolean z2 = true;
        do {
            l(qv0Var, list, iM);
            bh3VarR = r(qv0Var, i, z);
            if (bh3VarR == null) {
                iM = m(qv0Var, this.f16245e[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        p62 p62VarJ2 = j(qv0Var, bh3VarR, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            p62VarJ = j(qv0Var, bh3VarR, z, false);
        } catch (NotFoundException unused) {
            p62VarJ = null;
        }
        return new hb3(p62VarJ2, p62VarJ, bh3VarR);
    }

    public final void v(int i) {
        boolean zC = false;
        int i2 = 0;
        boolean zC2 = false;
        while (i2 < this.f16244b.size()) {
            kb3 kb3Var = this.f16244b.get(i2);
            if (kb3Var.b() > i) {
                zC = kb3Var.c(this.f16242a);
                break;
            } else {
                zC2 = kb3Var.c(this.f16242a);
                i2++;
            }
        }
        if (zC || zC2 || p(this.f16242a, this.f16244b)) {
            return;
        }
        this.f16244b.add(i2, new kb3(this.f16242a, i));
        s(this.f16242a, this.f16244b);
    }
}
