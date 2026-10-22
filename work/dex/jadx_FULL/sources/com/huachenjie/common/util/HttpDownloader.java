package com.huachenjie.common.util;

import com.fl.saas.common.crash.CrashHandler;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.common.net.b;
import com.ipd.dsp.internal.q.r;
import com.zj.adlib.i4a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class HttpDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f33905a;

    public interface Callback {
        void onFailed(int code, String message);

        default void onProgress(long writeLength, long totalLength) {
        }

        void onSuccess(File file);
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        f33905a = map;
        map.put("application/x-001", ".001");
        map.put("application/x-301", ".301");
        map.put("text/h323", ".323");
        map.put("application/x-906", ".906");
        map.put("drawing/907", ".907");
        map.put("application/x-a11", ".a11");
        map.put("audio/x-mei-aac", ".acp");
        map.put("application/postscript", ".ai");
        map.put("audio/aiff", ".aiff");
        map.put("application/x-anv", ".anv");
        map.put("text/asa", ".asa");
        map.put("video/x-ms-asf", ".asf");
        map.put("text/asp", ".asp");
        map.put("audio/basic", ".au");
        map.put("video/avi", FileTypes.H);
        map.put("application/vnd.adobe.workflow", ".awf");
        map.put("application/x-bmp", ".bmp");
        map.put("application/x-bot", ".bot");
        map.put("application/x-c4t", ".c4t");
        map.put("application/x-c90", ".c90");
        map.put("application/x-cals", ".cal");
        map.put("application/s-pki.seccat", ".cat");
        map.put("application/x-netcdf", ".cdf");
        map.put("application/x-cdr", ".cdr");
        map.put("application/x-cel", ".cel");
        map.put("application/x-cgm", ".cgm");
        map.put("application/x-cit", ".cit");
        map.put("application/x-cmp", ".cmp");
        map.put("application/x-cmx", ".cmx");
        map.put("application/x-cot", ".cot");
        map.put("application/pkix-crl", ".crl");
        map.put("application/x-csi", ".csi");
        map.put("text/css", ".css");
        map.put("application/x-cut", ".cut");
        map.put("application/x-dbf", ".dbf");
        map.put("application/x-dbm", ".dbm");
        map.put("application/x-dbx", ".dbx");
        map.put("application/x-dcx", ".dcx");
        map.put("application/x-dgn", ".dgn");
        map.put("application/x-dib", ".dib");
        map.put("application/msword", ".doc");
        map.put("application/x-drw", ".drw");
        map.put("Model/vnd.dwf", ".dwf");
        map.put("application/x-dwf", ".dwf");
        map.put("application/x-dwg", ".dwg");
        map.put("application/x-dxb", ".dxb");
        map.put("application/x-dxf", ".dxf");
        map.put("application/vnd.adobe.edn", ".edn");
        map.put("application/x-emf", ".emf");
        map.put("application/x-epi", ".epi");
        map.put("application/x-ebx", ".etd");
        map.put("application/x-msdownload", ".exe");
        map.put("image/fax", ".fax");
        map.put("application/vnd.fdf", ".fdf");
        map.put("application/fractals", ".fif");
        map.put("application/x-frm", ".frm");
        map.put("application/x-gbr", ".gbr");
        map.put("application/x-gcd", ".gcd");
        map.put("image/gif", ".gif");
        map.put("application/x-gl2", ".gl2");
        map.put("application/x-gp4", ".gp4");
        map.put("application/x-hgl", ".hgl");
        map.put("application/x-hmr", ".hmr");
        map.put("application/x-hpgl", ".hpg");
        map.put("application/x-hpl", ".hpl");
        map.put("application/mac-binhex40", ".hqx");
        map.put("application/x-hrf", ".hrf");
        map.put("application/hta", ".hta");
        map.put("text/x-component", ".htc");
        map.put("text/html", ".html");
        map.put("text/webviewhtml", ".htt");
        map.put("application/x-icb", ".icb");
        map.put("image/x-icon", ".ico");
        map.put("application/x-ico", ".ico");
        map.put("application/x-iff", ".iff");
        map.put("application/x-igs", ".igs");
        map.put("application/x-iphone", ".iii");
        map.put("application/x-img", ".img");
        map.put("video/x-ivf", ".IVF");
        map.put("application/x-jpe", ".jpe");
        map.put("image/jpeg", ".jpeg");
        map.put("application/x-jpg", FileTypes.F);
        map.put("application/x-javascript", ".js");
        map.put("audio/x-liquid-file", ".la1");
        map.put("application/x-laplayer-reg", ".lar");
        map.put("application/x-latex", ".latex");
        map.put("audio/x-liquid-secure", ".lavs");
        map.put("application/x-lbm", ".lbm");
        map.put("audio/x-la-lms", ".lmsff");
        map.put("application/x-ltr", ".ltr");
        map.put("audio/mpegurl", ".m3u");
        map.put("video/mpeg4", ".m4e");
        map.put("application/x-mac", ".mac");
        map.put("application/x-troff-man", ".man");
        map.put("application/msaccess", ".mdb");
        map.put("application/x-mdb", ".mdb");
        map.put("application/x-mi", ".mi");
        map.put("audio/mid", FileTypes.f5246j);
        map.put("application/x-mil", ".mil");
        map.put("audio/x-musicnet-download", ".mnd");
        map.put("audio/x-musicnet-stream", ".mns");
        map.put("video/x-sgi-movie", ".movie");
        map.put("audio/mp1", ".mp1");
        map.put("audio/mp2", ".mp2");
        map.put("audio/mp3", FileTypes.f5253q);
        map.put("video/mp4", ".mp4");
        map.put("video/x-mpg", ".mpa");
        map.put("application/-project", ".mpd");
        map.put("video/x-mpeg", ".mpe");
        map.put("video/mpg", FileTypes.w);
        map.put("audio/rn-mpeg", ".mpga");
        map.put("video/mpeg", ".mpv2");
        map.put("application/s-project", ".mpw");
        map.put("application/x-mmxp", ".mxp");
        map.put("image/pnetvue", ".net");
        map.put("application/x-nrf", ".nrf");
        map.put("text/x-ms-odc", ".odc");
        map.put("application/x-out", ".out");
        map.put("application/pkcs10", ".p10");
        map.put("application/pkcs7-mime", ".p7m");
        map.put("application/x-pkcs7-certreqresp", ".p7r");
        map.put("application/pkcs7-signature", ".p7s");
        map.put("application/x-pc5", ".pc5");
        map.put("application/x-pci", ".pci");
        map.put("application/x-pcl", ".pcl");
        map.put("application/x-pcx", ".pcx");
        map.put("application/pdf", ".pdf");
        map.put("application/vnd.adobe.pdx", ".pdx");
        map.put("application/x-pkcs12", ".pfx");
        map.put("application/x-pgl", ".pgl");
        map.put("application/x-pic", ".pic");
        map.put("application-pki.pko", ".pko");
        map.put("application/x-perl", ".pl");
        map.put("application/x-plt", ".plt");
        map.put("image/png", ".png");
        map.put("application/x-png", ".png");
        map.put("application/vs-powerpoint", ".ppa");
        map.put("application/x-ppm", ".ppm");
        map.put("application-powerpoint", ".pps");
        map.put("applications-powerpoint", ".ppt");
        map.put("application/x-ppt", ".ppt");
        map.put("application/x-pr", ".pr");
        map.put("application/pics-rules", ".prf");
        map.put("application/x-prn", ".prn");
        map.put("application/x-prt", ".prt");
        map.put("application/x-ptn", ".ptn");
        map.put("application/powerpoint", ".pwz");
        map.put("text/vnd.rn-realtext3d", ".r3t");
        map.put("audio/vnd.rn-realaudio", ".ra");
        map.put("audio/x-pn-realaudio", ".ram");
        map.put("application/x-ras", ".ras");
        map.put("application/rat-file", ".rat");
        map.put("application/vnd.rn-recording", ".rec");
        map.put("application/x-red", ".red");
        map.put("application/x-rgb", ".rgb");
        map.put("application/vnd.rn-realsystem-rjs", ".rjs");
        map.put("application/vnd.rn-realsystem-rjt", ".rjt");
        map.put("application/x-rlc", ".rlc");
        map.put("application/x-rle", ".rle");
        map.put("application/vnd.rn-realmedia", ".rm");
        map.put("application/vnd.adobe.rmf", ".rmf");
        map.put("application/vnd.rn-realsystem-rmj", ".rmj");
        map.put("application/vnd.rn-rn_music_package", ".rmp");
        map.put("application/vnd.rn-realmedia-secure", ".rms");
        map.put("application/vnd.rn-realmedia-vbr", ".rmvb");
        map.put("application/vnd.rn-realsystem-rmx", ".rmx");
        map.put("application/vnd.rn-realplayer", ".rnx");
        map.put("image/vnd.rn-realpix", ".rp");
        map.put("audio/x-pn-realaudio-plugin", ".rpm");
        map.put("application/vnd.rn-rsml", ".rsml");
        map.put("text/vnd.rn-realtext", ".rt");
        map.put("application/x-rtf", ".rtf");
        map.put("video/vnd.rn-realvideo", ".rv");
        map.put("application/x-sam", ".sam");
        map.put("application/x-sat", ".sat");
        map.put("application/sdp", ".sdp");
        map.put("application/x-sdw", ".sdw");
        map.put("application/x-stuffit", ".sit");
        map.put("application/x-slb", ".slb");
        map.put("application/x-sld", ".sld");
        map.put("drawing/x-slk", ".slk");
        map.put("application/smil", ".smil");
        map.put("application/x-smk", ".smk");
        map.put("application/x-pkcs7-certificates", ".spc");
        map.put("application/futuresplash", ".spl");
        map.put("application/streamingmedia", ".ssm");
        map.put("application-pki.certstore", ".sst");
        map.put("application/-pki.stl", ".stl");
        map.put("application/x-sty", ".sty");
        map.put("application/x-tdf", ".tdf");
        map.put("application/x-tg4", ".tg4");
        map.put("application/x-tga", ".tga");
        map.put("application/x-tif", ".tif");
        map.put("image/tiff", ".tiff");
        map.put("drawing/x-top", ".top");
        map.put("application/x-bittorrent", ".torrent");
        map.put("text/plain", CrashHandler.FILE_NAME_SUFFIX);
        map.put("application/x-icq", ".uin");
        map.put("text/iuls", ".uls");
        map.put("text/x-vcard", ".vcf");
        map.put("application/x-vda", ".vda");
        map.put("application/x-vpeg005", ".vpg");
        map.put("application/vnd.visio", ".vsd");
        map.put("application/x-vsd", ".vsd");
        map.put("application/x-vst", ".vst");
        map.put("audio/wav", FileTypes.B);
        map.put("audio/x-ms-wax", ".wax");
        map.put("application/x-wb1", ".wb1");
        map.put("application/x-wb2", ".wb2");
        map.put("application/x-wb3", ".wb3");
        map.put(r.l, ".wbmp");
        map.put("application/x-wk3", ".wk3");
        map.put("application/x-wk4", ".wk4");
        map.put("application/x-wkq", ".wkq");
        map.put("application/x-wks", ".wks");
        map.put("video/x-ms-wm", ".wm");
        map.put("audio/x-ms-wma", ".wma");
        map.put("application/x-ms-wmd", ".wmd");
        map.put("application/x-wmf", ".wmf");
        map.put("text/vnd.wap.wml", ".wml");
        map.put("video/x-ms-wmv", ".wmv");
        map.put("video/x-ms-wmx", ".wmx");
        map.put("application/x-ms-wmz", ".wmz");
        map.put("application/x-wp6", ".wp6");
        map.put("application/x-wpd", ".wpd");
        map.put("application/x-wpg", ".wpg");
        map.put("application/-wpl", ".wpl");
        map.put("application/x-wq1", ".wq1");
        map.put("application/x-wr1", ".wr1");
        map.put("application/x-wri", ".wri");
        map.put("application/x-wrk", ".wrk");
        map.put("application/x-ws", ".ws");
        map.put("text/scriptlet", ".wsc");
        map.put("video/x-ms-wvx", ".wvx");
        map.put("application/vnd.adobe.xdp", ".xdp");
        map.put("application/vnd.adobe.xfd", ".xfd");
        map.put("application/vnd.adobe.xfdf", ".xfdf");
        map.put("application/-excel", ".xls");
        map.put("application/x-xls", ".xls");
        map.put("application/x-xlw", ".xlw");
        map.put("text/xml", ".xml");
        map.put("audio/scpls", ".xpl");
        map.put("application/x-xwd", ".xwd");
        map.put("application/x-x_b", ".x_b");
        map.put("application/x-x_t", ".x_t");
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d0 A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #5 {all -> 0x00e9, blocks: (B:24:0x0085, B:60:0x00df, B:61:0x00e2, B:62:0x00e8, B:53:0x00d0, B:54:0x00d3, B:38:0x00a9), top: B:66:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00df A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #5 {all -> 0x00e9, blocks: (B:24:0x0085, B:60:0x00df, B:61:0x00e2, B:62:0x00e8, B:53:0x00d0, B:54:0x00d3, B:38:0x00a9), top: B:66:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized String a(String str, String str2, Callback callback) {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        Closeable closeable2;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.addRequestProperty("Connection", b.t0);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    String headerField = httpURLConnection.getHeaderField("Content-Type");
                    i4a.a(headerField);
                    String str3 = f33905a.get(headerField);
                    if (str3 == null) {
                        str3 = "";
                    }
                    i4a.a(str3);
                    if (responseCode != 200) {
                        if (callback != null) {
                            callback.onFailed(responseCode, "下载失败");
                        }
                        httpURLConnection.disconnect();
                        b(null);
                        b(null);
                        return null;
                    }
                    File file = new File(str2 + str3);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        long contentLength = httpURLConnection.getContentLength();
                        inputStream = httpURLConnection.getInputStream();
                        long j = 0;
                        while (true) {
                            try {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                                j += (long) i;
                                if (callback != null) {
                                    callback.onProgress(j, contentLength);
                                }
                            } catch (Exception e) {
                                e = e;
                                Exception exc = e;
                                fileOutputStream = fileOutputStream2;
                                e = exc;
                                closeable2 = inputStream;
                                if (callback != null) {
                                    try {
                                        callback.onFailed(0, e.getMessage());
                                    } catch (Throwable th) {
                                        th = th;
                                        httpURLConnection2 = httpURLConnection;
                                        closeable = closeable2;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        b(fileOutputStream);
                                        b(closeable);
                                        throw th;
                                    }
                                }
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                b(fileOutputStream);
                                b(closeable2);
                                return null;
                            } catch (Throwable th2) {
                                httpURLConnection2 = httpURLConnection;
                                fileOutputStream = fileOutputStream2;
                                th = th2;
                                closeable = inputStream;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                b(fileOutputStream);
                                b(closeable);
                                throw th;
                            }
                        }
                        if (callback != null) {
                            callback.onSuccess(file);
                        }
                        String absolutePath = file.getAbsolutePath();
                        httpURLConnection.disconnect();
                        b(fileOutputStream2);
                        b(inputStream);
                        return absolutePath;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                    } catch (Throwable th3) {
                        fileOutputStream = fileOutputStream2;
                        th = th3;
                        closeable2 = null;
                        httpURLConnection2 = httpURLConnection;
                        closeable = closeable2;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        b(fileOutputStream);
                        b(closeable);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    closeable2 = fileOutputStream;
                    if (callback != null) {
                        callback.onFailed(0, e.getMessage());
                    }
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(fileOutputStream);
                    b(closeable2);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    closeable2 = null;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            closeable = null;
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
