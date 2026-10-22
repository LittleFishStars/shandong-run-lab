package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.common.math.c;
import com.zj.adlib.go6;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, c.f6376a, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 172, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 174, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 192, 193, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, go6.g, 215, 216, 217, 218, 219, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 222, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 224, 225, 226, 227, 228, 229, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 231, 232, 233, 234, 235, 236, 237, MatroskaExtractor.T, 239, 240, 241, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 249, 250, 251, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 253})
public class ExtensionDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(ExtensionDescriptor.class.getName());
    ByteBuffer data;

    public static int[] allTags() {
        int[] iArr = new int[148];
        for (int i = 106; i < 254; i++) {
            int i2 = i - 106;
            log.finest("pos:" + i2);
            iArr[i2] = i;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public int getContentSize() {
        return this.data.remaining();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.data = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + this.data.remaining());
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public ByteBuffer serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getSize());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, this.tag);
        writeSize(byteBufferAllocate, getContentSize());
        byteBufferAllocate.put(this.data.duplicate());
        return byteBufferAllocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        return "ExtensionDescriptortag=" + this.tag + ",bytes=" + Hex.encodeHex(this.data.array()) + '}';
    }
}
