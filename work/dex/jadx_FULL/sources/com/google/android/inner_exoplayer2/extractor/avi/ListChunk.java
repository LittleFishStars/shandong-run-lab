package com.google.android.inner_exoplayer2.extractor.avi;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class ListChunk implements AviChunk {
    public final ImmutableList<AviChunk> children;
    private final int type;

    private ListChunk(int i, ImmutableList<AviChunk> immutableList) {
        this.type = i;
        this.children = immutableList;
    }

    @Nullable
    private static AviChunk createBox(int i, int i2, ParsableByteArray parsableByteArray) {
        if (i == 1718776947) {
            return StreamFormatChunk.parseFrom(i2, parsableByteArray);
        }
        if (i == 1751742049) {
            return AviMainHeaderChunk.parseFrom(parsableByteArray);
        }
        if (i == 1752331379) {
            return AviStreamHeaderChunk.parseFrom(parsableByteArray);
        }
        if (i != 1852994675) {
            return null;
        }
        return StreamNameChunk.parseFrom(parsableByteArray);
    }

    public static ListChunk parseFrom(int i, ParsableByteArray parsableByteArray) {
        ImmutableList.a aVar = new ImmutableList.a();
        int iLimit = parsableByteArray.limit();
        int trackType = -2;
        while (parsableByteArray.bytesLeft() > 8) {
            int littleEndianInt = parsableByteArray.readLittleEndianInt();
            int position = parsableByteArray.getPosition() + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(position);
            AviChunk from = littleEndianInt == 1414744396 ? parseFrom(parsableByteArray.readLittleEndianInt(), parsableByteArray) : createBox(littleEndianInt, trackType, parsableByteArray);
            if (from != null) {
                if (from.getType() == 1752331379) {
                    trackType = ((AviStreamHeaderChunk) from).getTrackType();
                }
                aVar.a(from);
            }
            parsableByteArray.setPosition(position);
            parsableByteArray.setLimit(iLimit);
        }
        return new ListChunk(i, aVar.e());
    }

    @Nullable
    public <T extends AviChunk> T getChild(Class<T> cls) {
        UnmodifiableIterator<AviChunk> it = this.children.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return this.type;
    }
}
