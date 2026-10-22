package com.efs.sdk.base.protocol.file.section;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbsSection {
    public static final String SEP_LINE_BREAK = "linebreak";
    public static final String SEP_ORIGIN_LINE_BREAK = "\n";
    String type;
    String name = "";
    String version = "1.0";
    String sep = "";

    public AbsSection(String str) {
        this.type = str;
    }

    public abstract String changeToStr();

    public String getDeclarationLine() {
        return "section:" + this.name + "," + this.type + "," + this.version + "," + this.sep;
    }

    public void setSep(String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}
