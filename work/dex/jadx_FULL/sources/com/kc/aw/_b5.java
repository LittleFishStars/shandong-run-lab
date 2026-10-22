package com.kc.aw;

import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public enum _b5 {
    NOT_SET('0'),
    NO_CLIP('1'),
    MATRIX('2'),
    CENTER('3'),
    FIT_CENTER('4'),
    CENTER_CROP('5'),
    CENTER_INSIDE('6');

    public final char _a;

    @Keep
    public static final /* synthetic */ class _a {
        public static final int[] _a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            _a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                _a[ImageView.ScaleType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                _a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                _a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                _a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                _a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    _b5(char c) {
        this._a = c;
    }
}
