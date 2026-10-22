package com.zj.adlib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Pair;
import com.alibaba.ariver.permission.b;
import com.google.android.exoplayer2.offline.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class np9 {
    public static long a(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, long j, int i2, int i3, boolean z, boolean z2) throws Exception {
        int iM = m(mediaExtractor, false);
        mediaExtractor.selectTrack(iM);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
        int integer = trackFormat.getInteger("width");
        int integer2 = trackFormat.getInteger("height");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        rm9 rm9Var = new rm9(mediaExtractor, mediaMuxer, i2, integer, integer2, i3, iM, atomicBoolean, j, z, z2, i);
        bn9 bn9Var = new bn9(rm9Var, mediaExtractor, Integer.valueOf(num3.intValue() / 1000), num2 == null ? null : Integer.valueOf(num2.intValue() / 1000), null, null, null, false, iM, atomicBoolean);
        bn9Var.start();
        rm9Var.start();
        try {
            bn9Var.join();
            rm9Var.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mediaExtractor.release();
        } catch (Exception e2) {
            v61.g(e2);
        }
        if (rm9Var.d() != null) {
            throw rm9Var.d();
        }
        if (bn9Var.c() == null) {
            return rm9Var.e();
        }
        throw bn9Var.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    public static void b(List<File> list, String str, Integer num, Integer num2) throws Exception {
        String str2;
        long j;
        int iM;
        List<File> list2 = list;
        if (list2 == null || list.size() == 0) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i = 0;
        mediaMetadataRetriever.setDataSource(list2.get(0).getAbsolutePath());
        int i2 = num == null ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)) : num.intValue();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(list2.get(0).getAbsolutePath());
        int iM2 = m(mediaExtractor, false);
        boolean z = true;
        int iM3 = m(mediaExtractor, true);
        MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
        int iAddTrack = mediaMuxer.addTrack(mediaExtractor.getTrackFormat(iM2));
        boolean z2 = iM3 >= 0;
        int iAddTrack2 = z2 ? mediaMuxer.addTrack(mediaExtractor.getTrackFormat(iM3)) : 0;
        mediaMuxer.start();
        long jU = 0;
        int i3 = 0;
        long j2 = 0;
        while (i3 < list.size()) {
            if (i3 > 0) {
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(list2.get(i3).getAbsolutePath());
                iM3 = m(mediaExtractor, z);
            }
            int i4 = iM3;
            MediaExtractor mediaExtractor2 = mediaExtractor;
            if (z2) {
                jU = gg0.u(mediaExtractor2, mediaMuxer, iAddTrack2, null, null, j2, null);
                mediaExtractor2.unselectTrack(i4);
            }
            long j3 = jU;
            int i5 = i3;
            long jA = a(mediaExtractor2, mediaMuxer, iAddTrack, null, null, j2, i2, num2.intValue(), i3 == 0 ? z : i, false);
            long j4 = jA > j3 ? jA : j3;
            v61.k("片段" + i5 + "已合成,audioFrameTime:" + (j3 / 1000.0f) + " videoFrameTime:" + (jA / 1000.0f), new Object[i]);
            long j5 = j4 + 33000;
            mediaExtractor2.release();
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(list2.get(i5).getAbsolutePath());
            sb.append(".rev");
            String string = sb.toString();
            jo9.h(new jo9.c(list2.get(i5).getAbsolutePath()), string, true);
            v61.f("reverseVideoNoDecode:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms", new Object[i]);
            MediaExtractor mediaExtractor3 = new MediaExtractor();
            mediaExtractor3.setDataSource(string);
            if (z2) {
                str2 = " videoFrameTime:";
                iM = m(mediaExtractor3, true);
                long jU2 = gg0.u(mediaExtractor3, mediaMuxer, iAddTrack2, null, null, j5, null);
                mediaExtractor3.unselectTrack(iM);
                j = jU2;
            } else {
                str2 = " videoFrameTime:";
                j = j3;
                iM = i4;
            }
            String str3 = str2;
            long j6 = j;
            long jA2 = a(mediaExtractor3, mediaMuxer, iAddTrack, null, null, j5, i2, num2.intValue(), false, i5 == list.size() + (-1));
            jU = j6;
            long j7 = jA2 > jU ? jA2 : jU;
            v61.k("反序片段" + i5 + "已合成,audioFrameTime:" + (jU / 1000.0f) + str3 + (jA2 / 1000.0f), new Object[0]);
            j2 = j7 + 33000;
            mediaExtractor3.release();
            new File(string).delete();
            i3 = i5 + 1;
            i = 0;
            z = true;
            mediaExtractor = mediaExtractor3;
            iM3 = iM;
            list2 = list;
        }
        mediaMuxer.release();
    }

    public static float c(jo9.c cVar) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        int i = 0;
        mediaExtractor.selectTrack(m(mediaExtractor, false));
        long j = 0;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                mediaExtractor.release();
                return i / ((j / 1000.0f) / 1000.0f);
            }
            i++;
            mediaExtractor.advance();
            j = sampleTime;
        }
    }

    public static int d(jo9.c cVar) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        int i = 0;
        mediaExtractor.selectTrack(m(mediaExtractor, false));
        int i2 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                break;
            }
            i2++;
            mediaExtractor.advance();
        }
        mediaExtractor.release();
        float f = ((i2 - i) / i) + 1.0f;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        cVar.b(mediaMetadataRetriever);
        int i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        return i2 == i ? i3 : (int) (f * i3);
    }

    public static int e(jo9.c cVar) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            cVar.a(mediaExtractor);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(m(mediaExtractor, false));
            return trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1;
        } catch (IOException e) {
            v61.g(e);
            return -1;
        } finally {
            mediaExtractor.release();
        }
    }

    public static List<Long> f(MediaExtractor mediaExtractor) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                return arrayList;
            }
            arrayList.add(Long.valueOf(sampleTime));
            mediaExtractor.advance();
        }
    }

    public static int g(MediaCodec mediaCodec, String str) {
        try {
            return ((Integer) mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper()).intValue();
        } catch (Exception e) {
            v61.g(e);
            return -1;
        }
    }

    public static File h(Context context) {
        File file = new File(context.getCacheDir(), "video/");
        file.mkdirs();
        return file;
    }

    public static Pair<Integer, Integer> i(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i = 0;
        mediaExtractor.selectTrack(m(mediaExtractor, false));
        int i2 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                mediaExtractor.release();
                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
            }
            i2++;
            mediaExtractor.advance();
        }
    }

    public static Pair<Integer, Integer> j(jo9.c cVar) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(m(mediaExtractor, false));
        return new Pair<>(Integer.valueOf(trackFormat.getInteger("width")), Integer.valueOf(trackFormat.getInteger("height")));
    }

    public static String k(Context context, String str, String str2, String str3, String str4) {
        Uri uriInsert;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put(a.f3586e, str4);
        contentValues.put("description", str3);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "Movies/VideoProcessor");
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (uriInsert == null) {
                return null;
            }
            try {
                byte[] bArr = new byte[1024];
                FileOutputStream fileOutputStream = new FileOutputStream(contentResolver.openFileDescriptor(uriInsert, "w").getFileDescriptor());
                FileInputStream fileInputStream = new FileInputStream(str);
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                fileOutputStream.flush();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                if (uriInsert != null) {
                    contentResolver.delete(uriInsert, null, null);
                }
            }
            if (uriInsert != null) {
                return uriInsert.toString();
            }
            return null;
        } catch (Exception e2) {
            e = e2;
            uriInsert = null;
        }
    }

    public static void l(MediaExtractor mediaExtractor, int i, int i2) {
        int i3 = i2 * 1000;
        if (mediaExtractor.getSampleTrackIndex() != i) {
            mediaExtractor.selectTrack(i);
        }
        mediaExtractor.seekTo(i3, 0);
        while (i3 > 0 && mediaExtractor.getSampleTrackIndex() != i) {
            i3 -= 10000;
            mediaExtractor.seekTo(i3, 0);
        }
    }

    public static int m(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    public static List<File> n(Context context, jo9.c cVar, String str, int i, int i2, Integer num, float f, Integer num2) throws Exception {
        int i3 = (int) (i * f);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        cVar.b(mediaMetadataRetriever);
        int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        LinkedList<Pair> linkedList = new LinkedList();
        int i5 = 0;
        while (i4 > 0) {
            i4 -= i3;
            if (i4 < i2) {
                linkedList.add(new Pair(Integer.valueOf(i5), Integer.valueOf(i5 + i3 + i4)));
                break;
            }
            Integer numValueOf = Integer.valueOf(i5);
            i5 += i3;
            linkedList.add(new Pair(numValueOf, Integer.valueOf(i5)));
        }
        ArrayList arrayList = new ArrayList(linkedList.size());
        for (Pair pair : linkedList) {
            File file = new File(str, pair.first + ".mp4");
            jo9.f(context).w(cVar).A(file.getAbsolutePath()).E(((Integer) pair.first).intValue()).s(((Integer) pair.second).intValue()).D(f).p(num.intValue()).u(num2.intValue()).B();
            arrayList.add(file);
        }
        return arrayList;
    }

    public static boolean o(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i, int i2) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i && codecProfileLevel.level == i2) {
                mediaFormat.setInteger(dx7.f41301a, i);
                mediaFormat.setInteger(b.b, i2);
                return true;
            }
        }
        return false;
    }
}
