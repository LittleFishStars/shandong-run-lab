package com.czhj.wire.okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ByteString[] f29539a;
    final int[] b;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f29539a = byteStringArr;
        this.b = iArr;
    }

    private static int a(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    private static void a(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int iIntValue;
        int i4;
        int i5;
        int i6;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i7 = i2; i7 < i3; i7++) {
            if (list.get(i7).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        if (i == byteString.size()) {
            int i8 = i2 + 1;
            i4 = i8;
            iIntValue = list2.get(i2).intValue();
            byteString = list.get(i8);
        } else {
            iIntValue = -1;
            i4 = i2;
        }
        if (byteString.getByte(i) == byteString2.getByte(i)) {
            int iMin = Math.min(byteString.size(), byteString2.size());
            int i9 = 0;
            for (int i10 = i; i10 < iMin && byteString.getByte(i10) == byteString2.getByte(i10); i10++) {
                i9++;
            }
            long jA = 1 + j + ((long) a(buffer)) + 2 + ((long) i9);
            buffer.writeInt(-i9);
            buffer.writeInt(iIntValue);
            int i11 = i;
            while (true) {
                i5 = i + i9;
                if (i11 >= i5) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i11) & 255);
                i11++;
            }
            if (i4 + 1 == i3) {
                if (i5 != list.get(i4).size()) {
                    throw new AssertionError();
                }
                buffer.writeInt(list2.get(i4).intValue());
                return;
            } else {
                Buffer buffer2 = new Buffer();
                buffer.writeInt((int) ((((long) a(buffer2)) + jA) * (-1)));
                a(jA, buffer2, i5, list, i4, i3, list2);
                buffer.write(buffer2, buffer2.size());
                return;
            }
        }
        int i12 = 1;
        for (int i13 = i4 + 1; i13 < i3; i13++) {
            if (list.get(i13 - 1).getByte(i) != list.get(i13).getByte(i)) {
                i12++;
            }
        }
        long jA2 = j + ((long) a(buffer)) + 2 + ((long) (i12 * 2));
        buffer.writeInt(i12);
        buffer.writeInt(iIntValue);
        for (int i14 = i4; i14 < i3; i14++) {
            byte b = list.get(i14).getByte(i);
            if (i14 == i4 || b != list.get(i14 - 1).getByte(i)) {
                buffer.writeInt(b & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i15 = i4;
        while (i15 < i3) {
            byte b2 = list.get(i15).getByte(i);
            int i16 = i15 + 1;
            int i17 = i16;
            while (true) {
                if (i17 >= i3) {
                    i6 = i3;
                    break;
                } else {
                    if (b2 != list.get(i17).getByte(i)) {
                        i6 = i17;
                        break;
                    }
                    i17++;
                }
            }
            if (i16 == i6 && i + 1 == list.get(i15).size()) {
                buffer.writeInt(list2.get(i15).intValue());
            } else {
                buffer.writeInt((int) ((((long) a(buffer3)) + jA2) * (-1)));
                a(jA2, buffer3, i + 1, list, i15, i6, list2);
            }
            buffer3 = buffer3;
            i15 = i6;
        }
        Buffer buffer4 = buffer3;
        buffer.write(buffer4, buffer4.size());
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            ByteString byteString = (ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                ByteString byteString2 = (ByteString) arrayList.get(i5);
                if (!byteString2.startsWith(byteString)) {
                    break;
                }
                if (byteString2.size() == byteString.size()) {
                    throw new IllegalArgumentException("duplicate option: " + byteString2);
                }
                if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        Buffer buffer = new Buffer();
        a(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iA = a(buffer);
        int[] iArr = new int[iA];
        for (int i6 = 0; i6 < iA; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (buffer.exhausted()) {
            return new Options((ByteString[]) byteStringArr.clone(), iArr);
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.f29539a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f29539a.length;
    }
}
