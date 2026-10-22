package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunRollCaptionComposer {

    @Visible
    public interface StyleEditor {
        void done();

        StyleEditor setDefaultTextSize(int i, int i2);

        StyleEditor setTextColor(int i);

        StyleEditor setTextFont(Source source);

        @Deprecated
        StyleEditor setTextFont(String str);

        StyleEditor setTextStrokeColor(int i);
    }

    StyleEditor editCaptionFamilyStyle();

    StyleEditor editCaptionStyle(int i);

    void hide();

    void reset();

    boolean show();

    void updateCaptionList(List<String> list);
}
