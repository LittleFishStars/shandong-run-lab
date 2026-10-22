package com.googlecode.mp4parser.srt;

import com.googlecode.mp4parser.authoring.tracks.TextTrackImpl;
import com.zj.adlib.u15;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SrtParser {
    public static TextTrackImpl parse(InputStream inputStream) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, "UTF-8"));
        TextTrackImpl textTrackImpl = new TextTrackImpl();
        while (lineNumberReader.readLine() != null) {
            String line = lineNumberReader.readLine();
            String str = "";
            while (true) {
                String line2 = lineNumberReader.readLine();
                if (line2 == null || line2.trim().equals("")) {
                    break;
                }
                str = String.valueOf(str) + line2 + "\n";
            }
            textTrackImpl.getSubs().add(new TextTrackImpl.Line(parse(line.split("-->")[0]), parse(line.split("-->")[1]), str));
        }
        return textTrackImpl;
    }

    private static long parse(String str) {
        return (Long.parseLong(str.split(u15.f19942b)[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(str.split(u15.f19942b)[1].trim()) * 60 * 1000) + (Long.parseLong(str.split(u15.f19942b)[2].split(",")[0].trim()) * 1000) + Long.parseLong(str.split(u15.f19942b)[2].split(",")[1].trim());
    }
}
