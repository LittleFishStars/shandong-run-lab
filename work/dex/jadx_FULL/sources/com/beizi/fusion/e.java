package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum e implements f2.a {
    ASNP_AES("@/.D>XVX5zhOdwj8", "\u007f}{y<usqomkigeca");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27202a;
    private final String b;

    e(String str, String str2) {
        this.f27202a = str;
        this.b = str2;
    }

    @Override // com.beizi.fusion.f2.a
    public String a() {
        return a(this.b);
    }

    @Override // com.beizi.fusion.f2.a
    public String b() {
        return a(this.f27202a);
    }

    private String a(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, (char) (sb.charAt(i) - i));
            }
            return sb.toString();
        } catch (Exception e) {
            om.a(e);
            return "";
        }
    }
}
