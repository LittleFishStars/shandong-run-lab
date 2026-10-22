package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult = new ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i) {
        this.mBreakMode = i;
    }

    public int[] setText(String str) {
        BreakIterator wordInstance = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i = this.mBreakMode;
        if (i == 1) {
            wordInstance = BreakIterator.getWordInstance();
        } else if (i == 2) {
            wordInstance = BreakIterator.getCharacterInstance();
        }
        wordInstance.setText(str);
        int iFirst = wordInstance.first();
        while (true) {
            int i2 = iFirst;
            iFirst = wordInstance.next();
            if (iFirst == -1) {
                break;
            }
            this.breakResult.add(Integer.valueOf(i2));
        }
        this.breakResult.add(Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        Integer[] numArr = new Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }
}
