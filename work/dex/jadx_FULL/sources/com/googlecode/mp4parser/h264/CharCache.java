package com.googlecode.mp4parser.h264;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CharCache {
    private char[] cache;
    private int pos;

    public CharCache(int i) {
        this.cache = new char[i];
    }

    public void append(String str) {
        char[] charArray = str.toCharArray();
        char[] cArr = this.cache;
        int length = cArr.length;
        int i = this.pos;
        int length2 = length - i;
        if (charArray.length < length2) {
            length2 = charArray.length;
        }
        System.arraycopy(charArray, 0, cArr, i, length2);
        this.pos += length2;
    }

    public void clear() {
        this.pos = 0;
    }

    public int length() {
        return this.pos;
    }

    public String toString() {
        return new String(this.cache, 0, this.pos);
    }

    public void append(char c) {
        int i = this.pos;
        char[] cArr = this.cache;
        if (i < cArr.length - 1) {
            cArr[i] = c;
            this.pos = i + 1;
        }
    }
}
