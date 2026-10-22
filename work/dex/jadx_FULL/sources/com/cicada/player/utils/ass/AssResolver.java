package com.cicada.player.utils.ass;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.zj.adlib.bv9;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AssResolver {
    private static final String TAG = "AssResolver";
    public static final String TEXT_PATTERN = "\\{[^\\{]+\\}";
    public static final Pattern pattern = Pattern.compile(TEXT_PATTERN);
    private AssHeader mAssHeader;
    private TextViewPool mTextViewPool;
    private int videoDisplayWidth = -1;
    private int videoDisplayHeight = -1;

    public static class ContentAttribute {
        public String fontName;
        public double fontSize;
        public int mBackColour;
        public boolean mBold;
        public int mBorderStyle;
        public boolean mItalic;
        public int mOutlineColour;
        public double mOutlineWidth;
        public int mPrimaryColour;
        public int mSecondaryColour;
        public double mShadow;
        public boolean mStrikeOut;
        public boolean mUnderline;
        public String overrideStyle;
        public String text;

        private ContentAttribute() {
        }

        public String toString() {
            return "ContentAttribute{text='" + this.text + "', overrideStyle='" + this.overrideStyle + "', fontName='" + this.fontName + "', fontSize=" + this.fontSize + ", mPrimaryColour=" + this.mPrimaryColour + ", mSecondaryColour=" + this.mSecondaryColour + ", mBold=" + this.mBold + ", mItalic=" + this.mItalic + ", mUnderline=" + this.mUnderline + ", mStrikeOut=" + this.mStrikeOut + ", mOutlineColour=" + this.mOutlineColour + ", mOutlineWidth=" + this.mOutlineWidth + ", mBorderStyle=" + this.mBorderStyle + ", mBackColour=" + this.mBackColour + ", mShadow=" + this.mShadow + '}';
        }
    }

    public static class LocationAttribute {
        public int mAlignment;
        public double mAngle;
        public double mScaleX;
        public double mScaleY;
        public int marginL;
        public int marginR;
        public int marginV;
        public double posX;
        public double posY;

        private LocationAttribute() {
        }
    }

    public AssResolver(Context context) {
        this.mTextViewPool = new TextViewPool(context);
    }

    private String convertRgbColor(String str) {
        StringBuilder sb;
        String strSubstring;
        if (str.length() == 8) {
            sb = new StringBuilder();
            sb.append(str.substring(6, 8));
            sb.append(str.substring(4, 6));
            strSubstring = str.substring(2, 4);
        } else {
            sb = new StringBuilder();
            sb.append(str.substring(4, 6));
            sb.append(str.substring(2, 4));
            strSubstring = str.substring(0, 2);
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    private void fillContentAttribute(AssStyle assStyle, LinkedList<ContentAttribute> linkedList, LocationAttribute locationAttribute) {
        Map<String, Object> overrideStyle;
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            ContentAttribute contentAttribute = linkedList.get(i);
            contentAttribute.text = contentAttribute.text.replace("\\N", "\n").replace("\\n", "\n");
            contentAttribute.fontName = assStyle.mFontName;
            contentAttribute.fontSize = scaleYSize(assStyle.mFontSize);
            contentAttribute.mBold = assStyle.mBold == 1;
            contentAttribute.mItalic = assStyle.mItalic == 1;
            contentAttribute.mStrikeOut = assStyle.mStrikeOut == 1;
            contentAttribute.mUnderline = assStyle.mUnderline == 1;
            contentAttribute.mBorderStyle = assStyle.mBorderStyle;
            contentAttribute.mOutlineWidth = scaleYSize(assStyle.mOutline);
            contentAttribute.mShadow = scaleYSize(assStyle.mShadow);
            contentAttribute.mBackColour = rgbaToArgb(assStyle.mBackColour);
            contentAttribute.mOutlineColour = rgbaToArgb(assStyle.mOutlineColour);
            contentAttribute.mPrimaryColour = rgbaToArgb(assStyle.mPrimaryColour);
            contentAttribute.mSecondaryColour = rgbaToArgb(assStyle.mSecondaryColour);
            if (!TextUtils.isEmpty(contentAttribute.overrideStyle) && (overrideStyle = parseOverrideStyle(contentAttribute.overrideStyle)) != null) {
                if (overrideStyle.containsKey("primaryColour")) {
                    contentAttribute.mPrimaryColour = ((Integer) overrideStyle.get("primaryColour")).intValue();
                }
                if (overrideStyle.containsKey("strikeOut")) {
                    contentAttribute.mStrikeOut = ((Boolean) overrideStyle.get("strikeOut")).booleanValue();
                }
                if (overrideStyle.containsKey("underline")) {
                    contentAttribute.mUnderline = ((Boolean) overrideStyle.get("underline")).booleanValue();
                }
                if (overrideStyle.containsKey("italic")) {
                    contentAttribute.mItalic = ((Boolean) overrideStyle.get("italic")).booleanValue();
                }
                if (overrideStyle.containsKey("bold")) {
                    contentAttribute.mBold = ((Boolean) overrideStyle.get("bold")).booleanValue();
                }
                if (overrideStyle.containsKey("fontSize")) {
                    contentAttribute.fontSize = scaleYSize(((Double) overrideStyle.get("fontSize")).doubleValue());
                }
                if (overrideStyle.containsKey("fontName")) {
                    contentAttribute.fontName = (String) overrideStyle.get("fontName");
                }
                if (overrideStyle.containsKey("posX")) {
                    locationAttribute.posX = ((Double) overrideStyle.get("posX")).doubleValue();
                }
                if (overrideStyle.containsKey("posY")) {
                    locationAttribute.posY = ((Double) overrideStyle.get("posY")).doubleValue();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cb A[SYNTHETIC] */
    private SpannableStringBuilder getFinalStr(LinkedList<ContentAttribute> linkedList) {
        StyleSpan styleSpan;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int length = 0;
        int length2 = 0;
        for (ContentAttribute contentAttribute : linkedList) {
            length += contentAttribute.text.length();
            spannableStringBuilder.append((CharSequence) contentAttribute.text);
            if (contentAttribute.mOutlineWidth > AudioStats.AUDIO_AMPLITUDE_NONE) {
                BorderedSpan.BorderStyle borderStyle = new BorderedSpan.BorderStyle();
                borderStyle.fontName = contentAttribute.fontName;
                borderStyle.fontSize = contentAttribute.fontSize;
                borderStyle.mPrimaryColour = contentAttribute.mPrimaryColour;
                borderStyle.mSecondaryColour = contentAttribute.mSecondaryColour;
                borderStyle.mBold = contentAttribute.mBold;
                borderStyle.mItalic = contentAttribute.mItalic;
                borderStyle.mUnderline = contentAttribute.mUnderline;
                borderStyle.mStrikeOut = contentAttribute.mStrikeOut;
                borderStyle.mOutlineColour = contentAttribute.mOutlineColour;
                borderStyle.mOutlineWidth = contentAttribute.mOutlineWidth;
                if (contentAttribute.mBorderStyle == 1) {
                    borderStyle.mShadowWidth = contentAttribute.mShadow;
                    borderStyle.mShadowColor = contentAttribute.mBackColour;
                }
                spannableStringBuilder.setSpan(new BorderedSpan(borderStyle), length2, length, 33);
            }
            spannableStringBuilder.setSpan(new TypefaceSpan(contentAttribute.fontName), length2, length, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) contentAttribute.fontSize), length2, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(contentAttribute.mPrimaryColour), length2, length, 33);
            boolean z = contentAttribute.mBold;
            if (z && contentAttribute.mItalic) {
                styleSpan = new StyleSpan(3);
            } else if (z) {
                styleSpan = new StyleSpan(1);
            } else {
                if (contentAttribute.mItalic) {
                    styleSpan = new StyleSpan(2);
                }
                if (contentAttribute.mUnderline) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), length2, length, 33);
                }
                if (contentAttribute.mStrikeOut) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), length2, length, 33);
                }
                length2 += contentAttribute.text.length();
            }
            spannableStringBuilder.setSpan(styleSpan, length2, length, 33);
            if (contentAttribute.mUnderline) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), length2, length, 33);
            }
            if (contentAttribute.mStrikeOut) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), length2, length, 33);
            }
            length2 += contentAttribute.text.length();
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x006e. Please report as an issue. */
    private RelativeLayout.LayoutParams getLayoutParams(LocationAttribute locationAttribute, float f, float f2) {
        int iScaleYSize;
        int iScaleXSize;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        double d = locationAttribute.posX;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE || locationAttribute.posY > AudioStats.AUDIO_AMPLITUDE_NONE) {
            int i = locationAttribute.mAlignment;
            double dScaleXSize = scaleXSize(d);
            double dScaleYSize = scaleYSize(locationAttribute.posY);
            switch (i) {
                case 1:
                    layoutParams.leftMargin = (int) dScaleXSize;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 2:
                default:
                    f /= 2.0f;
                    dScaleXSize -= (double) f;
                    layoutParams.leftMargin = (int) dScaleXSize;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 3:
                    dScaleXSize -= (double) f;
                    layoutParams.leftMargin = (int) dScaleXSize;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 4:
                    layoutParams.leftMargin = (int) dScaleXSize;
                    f2 /= 2.0f;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 5:
                    f /= 2.0f;
                    dScaleXSize -= (double) f;
                    layoutParams.leftMargin = (int) dScaleXSize;
                    f2 /= 2.0f;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 6:
                    dScaleXSize -= (double) f;
                    layoutParams.leftMargin = (int) dScaleXSize;
                    f2 /= 2.0f;
                    iScaleYSize = (int) (dScaleYSize - ((double) f2));
                    break;
                case 7:
                    iScaleXSize = (int) scaleXSize(dScaleXSize);
                    layoutParams.leftMargin = iScaleXSize;
                    iScaleYSize = (int) scaleYSize(dScaleYSize);
                    break;
                case 8:
                    f /= 2.0f;
                    iScaleXSize = (int) (dScaleXSize - ((double) f));
                    layoutParams.leftMargin = iScaleXSize;
                    iScaleYSize = (int) scaleYSize(dScaleYSize);
                    break;
                case 9:
                    iScaleXSize = (int) (dScaleXSize - ((double) f));
                    layoutParams.leftMargin = iScaleXSize;
                    iScaleYSize = (int) scaleYSize(dScaleYSize);
                    break;
            }
        } else {
            switch (locationAttribute.mAlignment) {
                case 1:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case 2:
                default:
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 4:
                    layoutParams.addRule(15);
                    layoutParams.addRule(9);
                    break;
                case 5:
                    layoutParams.addRule(13);
                    break;
                case 6:
                    layoutParams.addRule(15);
                    layoutParams.addRule(11);
                    break;
                case 7:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 8:
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case 9:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            layoutParams.leftMargin = locationAttribute.marginL;
            layoutParams.rightMargin = locationAttribute.marginR;
            iScaleYSize = locationAttribute.marginV;
        }
        layoutParams.topMargin = iScaleYSize;
        return layoutParams;
    }

    private LocationAttribute getLocationAttribute(AssDialogue assDialogue, AssStyle assStyle) {
        LocationAttribute locationAttribute = new LocationAttribute();
        locationAttribute.mAlignment = assStyle.mAlignment;
        locationAttribute.marginL = assStyle.mMarginL;
        locationAttribute.marginR = assStyle.mMarginR;
        locationAttribute.marginV = assStyle.mMarginV;
        int i = assDialogue.mMarginL;
        if (i != 0) {
            locationAttribute.marginL = i;
        }
        int i2 = assDialogue.mMarginR;
        if (i2 != 0) {
            locationAttribute.marginR = i2;
        }
        int i3 = assDialogue.mMarginV;
        if (i3 != 0) {
            locationAttribute.marginV = i3;
        }
        locationAttribute.mAngle = assStyle.mAngle;
        locationAttribute.mScaleX = assStyle.mScaleX;
        locationAttribute.mScaleY = assStyle.mScaleY;
        return locationAttribute;
    }

    private Map<String, Object> parseOverrideStyle(String str) {
        StringBuilder sb;
        String strSubstring;
        Object objValueOf;
        String str2;
        String strReplaceAll = str.substring(str.indexOf(bv9.b) + 1, str.lastIndexOf("}")).replaceAll("\\\\", "\\$");
        if (!strReplaceAll.contains("$")) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str3 : strReplaceAll.split("\\$")) {
            if (str3.startsWith("fn")) {
                objValueOf = str3.substring(2).trim();
                str2 = "fontName";
            } else {
                if (str3.startsWith("fs")) {
                    try {
                        map.put("fontSize", Double.valueOf(str3.substring(2).trim()));
                    } catch (Exception unused) {
                    }
                } else if (str3.startsWith("b")) {
                    objValueOf = Boolean.valueOf(str3.startsWith("b1"));
                    str2 = "bold";
                } else if (str3.startsWith("i")) {
                    objValueOf = Boolean.valueOf(str3.startsWith("i1"));
                    str2 = "italic";
                } else if (str3.startsWith("u")) {
                    objValueOf = Boolean.valueOf(str3.startsWith("u1"));
                    str2 = "underline";
                } else if (str3.startsWith("s")) {
                    objValueOf = Boolean.valueOf(str3.startsWith("s1"));
                    str2 = "strikeOut";
                } else if (str3.startsWith("c&H") || str3.startsWith("1c&H")) {
                    String strTrim = str3.substring(0, str3.lastIndexOf("&")).trim();
                    if (strTrim.startsWith("c&H")) {
                        sb = new StringBuilder();
                        sb.append("#");
                        strSubstring = strTrim.substring(3);
                    } else {
                        sb = new StringBuilder();
                        sb.append("#");
                        strSubstring = strTrim.substring(4);
                    }
                    sb.append(convertRgbColor(strSubstring.trim()));
                    objValueOf = Integer.valueOf(Color.parseColor(sb.toString()));
                    str2 = "primaryColour";
                } else if (str3.startsWith("pos")) {
                    String[] strArrSplit = str3.substring(4, str3.length() - 1).split(",");
                    map.put("posX", Double.valueOf(strArrSplit[0]));
                    objValueOf = Double.valueOf(strArrSplit[1]);
                    str2 = "posY";
                }
            }
            map.put(str2, objValueOf);
        }
        return map;
    }

    private int rgbaToArgb(int i) {
        return Color.parseColor("#" + String.format("%02x", Integer.valueOf(255 - (i & 255))) + String.format("%06x", Integer.valueOf(i >>> 8)));
    }

    private double scaleXSize(double d) {
        int i;
        int i2 = this.videoDisplayWidth;
        return (i2 <= 0 || (i = this.mAssHeader.mPlayResX) <= 0) ? d : (d * ((double) i2)) / ((double) i);
    }

    private double scaleYSize(double d) {
        int i;
        int i2 = this.videoDisplayHeight;
        return (i2 <= 0 || (i = this.mAssHeader.mPlayResY) <= 0) ? d : (d * ((double) i2)) / ((double) i);
    }

    private LinkedList<ContentAttribute> splitContent(AssDialogue assDialogue) {
        ContentAttribute contentAttribute;
        LinkedList<ContentAttribute> linkedList = new LinkedList<>();
        Matcher matcher = pattern.matcher(assDialogue.mText);
        if (matcher.find()) {
            String[] strArrSplit = assDialogue.mText.split(TEXT_PATTERN, -1);
            for (int i = 0; i < strArrSplit.length; i++) {
                if (TextUtils.isEmpty(strArrSplit[i])) {
                    contentAttribute = null;
                } else {
                    contentAttribute = new ContentAttribute();
                    contentAttribute.text = strArrSplit[i];
                }
                if (i != 0) {
                    String strGroup = matcher.group();
                    if (contentAttribute != null) {
                        contentAttribute.overrideStyle = strGroup;
                    }
                }
                if (contentAttribute != null) {
                    linkedList.add(contentAttribute);
                }
            }
        } else {
            ContentAttribute contentAttribute2 = new ContentAttribute();
            contentAttribute2.text = assDialogue.mText;
            linkedList.add(contentAttribute2);
        }
        return linkedList;
    }

    public void destroy() {
    }

    public void dismiss(AssTextView assTextView) {
        TextViewPool textViewPool = this.mTextViewPool;
        if (textViewPool != null) {
            textViewPool.recycle(assTextView);
        }
    }

    public AssTextView setAssDialog(String str) {
        AssTextView assTextViewObtain = this.mTextViewPool.obtain();
        assTextViewObtain.setContent(str);
        AssDialogue assDialogue = AssUtils.parseAssDialogue(this.mAssHeader, str);
        AssStyle assStyle = this.mAssHeader.mStyles.get(assDialogue.mStyle.replace("*", ""));
        if (assDialogue.mText.contains("{\\p0}")) {
            return assTextViewObtain;
        }
        LinkedList<ContentAttribute> linkedListSplitContent = splitContent(assDialogue);
        LocationAttribute locationAttribute = getLocationAttribute(assDialogue, assStyle);
        fillContentAttribute(assStyle, linkedListSplitContent, locationAttribute);
        assTextViewObtain.setText(getFinalStr(linkedListSplitContent), TextView.BufferType.SPANNABLE);
        assTextViewObtain.setScaleX((float) locationAttribute.mScaleX);
        assTextViewObtain.setScaleY((float) locationAttribute.mScaleY);
        assTextViewObtain.setRotation((float) locationAttribute.mAngle);
        assTextViewObtain.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        float measuredWidth = assTextViewObtain.getMeasuredWidth();
        float measuredHeight = assTextViewObtain.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = getLayoutParams(locationAttribute, measuredWidth, measuredHeight);
        layoutParams.width = (int) measuredWidth;
        layoutParams.height = (int) measuredHeight;
        assTextViewObtain.setLayoutParams(layoutParams);
        assTextViewObtain.setGravity(17);
        return assTextViewObtain;
    }

    public void setAssHeaders(String str) {
        this.mAssHeader = AssUtils.parseAssHeader(str);
    }

    public void setFontTypeMap(Map<String, Typeface> map) {
    }

    public void setVideoDisplaySize(int i, int i2) {
        this.videoDisplayWidth = i;
        this.videoDisplayHeight = i2;
    }
}
