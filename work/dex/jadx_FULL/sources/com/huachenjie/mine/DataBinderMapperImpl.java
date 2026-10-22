package com.huachenjie.mine;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mine.databinding.MineActivityDressingTableBindingImpl;
import com.huachenjie.mine.databinding.MineActivityFansOrAttentionsBindingImpl;
import com.huachenjie.mine.databinding.MineActivityHistoryRecordBindingImpl;
import com.huachenjie.mine.databinding.MineActivityMyQrCodeBindingImpl;
import com.huachenjie.mine.databinding.MineActivityMyThemeBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentAvatarFrameBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentDressingTableAvatarBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentDressingTableNicknameBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentDressingTableSignatureBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentHistoryChannelBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentHistoryTopicBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentHomeBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentMyChannelBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentMyTopicBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentPostBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentShowcaseBindingImpl;
import com.huachenjie.mine.databinding.MineFragmentUserTagBindingImpl;
import com.huachenjie.mine.databinding.MineItemFansAndAttentionBindingImpl;
import com.huachenjie.mine.databinding.MineItemPostBindingImpl;
import com.huachenjie.mine.databinding.MineLayoutMineHeaderBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35281a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f11168a;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f35282a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(35);
            f35282a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "addressBean");
            sparseArray.put(3, "bannerHeight");
            sparseArray.put(4, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(5, "bgOption");
            sparseArray.put(6, "checked");
            sparseArray.put(7, "click");
            sparseArray.put(8, "commentType");
            sparseArray.put(9, "data");
            sparseArray.put(10, "fragment");
            sparseArray.put(11, WriteReviewActivity.x);
            sparseArray.put(12, "hasBuy");
            sparseArray.put(13, "hasChat");
            sparseArray.put(14, "index");
            sparseArray.put(15, "infoMargin");
            sparseArray.put(16, "isAdmin");
            sparseArray.put(17, "isEdit");
            sparseArray.put(18, "isLast");
            sparseArray.put(19, "isMyOrganize");
            sparseArray.put(20, "isSelf");
            sparseArray.put(21, "mState");
            sparseArray.put(22, "position");
            sparseArray.put(23, "postType");
            sparseArray.put(24, d.x);
            sparseArray.put(25, "showAll");
            sparseArray.put(26, "showFollow");
            sparseArray.put(27, "showRelation");
            sparseArray.put(28, "source");
            sparseArray.put(29, "statusBarHeight");
            sparseArray.put(30, "targetNo");
            sparseArray.put(31, "teamGroupTitle");
            sparseArray.put(32, "title");
            sparseArray.put(33, "topicGroupTitle");
            sparseArray.put(34, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f35283a;

        static {
            HashMap<String, Integer> map = new HashMap<>(20);
            f35283a = map;
            map.put("layout/mine_activity_dressing_table_0", Integer.valueOf(R.layout.mine_activity_dressing_table));
            map.put("layout/mine_activity_fans_or_attentions_0", Integer.valueOf(R.layout.mine_activity_fans_or_attentions));
            map.put("layout/mine_activity_history_record_0", Integer.valueOf(R.layout.mine_activity_history_record));
            map.put("layout/mine_activity_my_qr_code_0", Integer.valueOf(R.layout.mine_activity_my_qr_code));
            map.put("layout/mine_activity_my_theme_0", Integer.valueOf(R.layout.mine_activity_my_theme));
            map.put("layout/mine_fragment_avatar_frame_0", Integer.valueOf(R.layout.mine_fragment_avatar_frame));
            map.put("layout/mine_fragment_dressing_table_avatar_0", Integer.valueOf(R.layout.mine_fragment_dressing_table_avatar));
            map.put("layout/mine_fragment_dressing_table_nickname_0", Integer.valueOf(R.layout.mine_fragment_dressing_table_nickname));
            map.put("layout/mine_fragment_dressing_table_signature_0", Integer.valueOf(R.layout.mine_fragment_dressing_table_signature));
            map.put("layout/mine_fragment_history_channel_0", Integer.valueOf(R.layout.mine_fragment_history_channel));
            map.put("layout/mine_fragment_history_topic_0", Integer.valueOf(R.layout.mine_fragment_history_topic));
            map.put("layout/mine_fragment_home_0", Integer.valueOf(R.layout.mine_fragment_home));
            map.put("layout/mine_fragment_my_channel_0", Integer.valueOf(R.layout.mine_fragment_my_channel));
            map.put("layout/mine_fragment_my_topic_0", Integer.valueOf(R.layout.mine_fragment_my_topic));
            map.put("layout/mine_fragment_post_0", Integer.valueOf(R.layout.mine_fragment_post));
            map.put("layout/mine_fragment_showcase_0", Integer.valueOf(R.layout.mine_fragment_showcase));
            map.put("layout/mine_fragment_user_tag_0", Integer.valueOf(R.layout.mine_fragment_user_tag));
            map.put("layout/mine_item_fans_and_attention_0", Integer.valueOf(R.layout.mine_item_fans_and_attention));
            map.put("layout/mine_item_post_0", Integer.valueOf(R.layout.mine_item_post));
            map.put("layout/mine_layout_mine_header_0", Integer.valueOf(R.layout.mine_layout_mine_header));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(20);
        f11168a = sparseIntArray;
        sparseIntArray.put(R.layout.mine_activity_dressing_table, 1);
        sparseIntArray.put(R.layout.mine_activity_fans_or_attentions, 2);
        sparseIntArray.put(R.layout.mine_activity_history_record, 3);
        sparseIntArray.put(R.layout.mine_activity_my_qr_code, 4);
        sparseIntArray.put(R.layout.mine_activity_my_theme, 5);
        sparseIntArray.put(R.layout.mine_fragment_avatar_frame, 6);
        sparseIntArray.put(R.layout.mine_fragment_dressing_table_avatar, 7);
        sparseIntArray.put(R.layout.mine_fragment_dressing_table_nickname, 8);
        sparseIntArray.put(R.layout.mine_fragment_dressing_table_signature, 9);
        sparseIntArray.put(R.layout.mine_fragment_history_channel, 10);
        sparseIntArray.put(R.layout.mine_fragment_history_topic, 11);
        sparseIntArray.put(R.layout.mine_fragment_home, 12);
        sparseIntArray.put(R.layout.mine_fragment_my_channel, 13);
        sparseIntArray.put(R.layout.mine_fragment_my_topic, 14);
        sparseIntArray.put(R.layout.mine_fragment_post, 15);
        sparseIntArray.put(R.layout.mine_fragment_showcase, 16);
        sparseIntArray.put(R.layout.mine_fragment_user_tag, 17);
        sparseIntArray.put(R.layout.mine_item_fans_and_attention, 18);
        sparseIntArray.put(R.layout.mine_item_post, 19);
        sparseIntArray.put(R.layout.mine_layout_mine_header, 20);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(13);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.channel.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.im.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.mall.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.social_contact.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f35282a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f11168a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/mine_activity_dressing_table_0".equals(tag)) {
                    return new MineActivityDressingTableBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_activity_dressing_table is invalid. Received: " + tag);
            case 2:
                if ("layout/mine_activity_fans_or_attentions_0".equals(tag)) {
                    return new MineActivityFansOrAttentionsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_activity_fans_or_attentions is invalid. Received: " + tag);
            case 3:
                if ("layout/mine_activity_history_record_0".equals(tag)) {
                    return new MineActivityHistoryRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_activity_history_record is invalid. Received: " + tag);
            case 4:
                if ("layout/mine_activity_my_qr_code_0".equals(tag)) {
                    return new MineActivityMyQrCodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_activity_my_qr_code is invalid. Received: " + tag);
            case 5:
                if ("layout/mine_activity_my_theme_0".equals(tag)) {
                    return new MineActivityMyThemeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_activity_my_theme is invalid. Received: " + tag);
            case 6:
                if ("layout/mine_fragment_avatar_frame_0".equals(tag)) {
                    return new MineFragmentAvatarFrameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_avatar_frame is invalid. Received: " + tag);
            case 7:
                if ("layout/mine_fragment_dressing_table_avatar_0".equals(tag)) {
                    return new MineFragmentDressingTableAvatarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_dressing_table_avatar is invalid. Received: " + tag);
            case 8:
                if ("layout/mine_fragment_dressing_table_nickname_0".equals(tag)) {
                    return new MineFragmentDressingTableNicknameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_dressing_table_nickname is invalid. Received: " + tag);
            case 9:
                if ("layout/mine_fragment_dressing_table_signature_0".equals(tag)) {
                    return new MineFragmentDressingTableSignatureBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_dressing_table_signature is invalid. Received: " + tag);
            case 10:
                if ("layout/mine_fragment_history_channel_0".equals(tag)) {
                    return new MineFragmentHistoryChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_history_channel is invalid. Received: " + tag);
            case 11:
                if ("layout/mine_fragment_history_topic_0".equals(tag)) {
                    return new MineFragmentHistoryTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_history_topic is invalid. Received: " + tag);
            case 12:
                if ("layout/mine_fragment_home_0".equals(tag)) {
                    return new MineFragmentHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_home is invalid. Received: " + tag);
            case 13:
                if ("layout/mine_fragment_my_channel_0".equals(tag)) {
                    return new MineFragmentMyChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_my_channel is invalid. Received: " + tag);
            case 14:
                if ("layout/mine_fragment_my_topic_0".equals(tag)) {
                    return new MineFragmentMyTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_my_topic is invalid. Received: " + tag);
            case 15:
                if ("layout/mine_fragment_post_0".equals(tag)) {
                    return new MineFragmentPostBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_post is invalid. Received: " + tag);
            case 16:
                if ("layout/mine_fragment_showcase_0".equals(tag)) {
                    return new MineFragmentShowcaseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_showcase is invalid. Received: " + tag);
            case 17:
                if ("layout/mine_fragment_user_tag_0".equals(tag)) {
                    return new MineFragmentUserTagBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_fragment_user_tag is invalid. Received: " + tag);
            case 18:
                if ("layout/mine_item_fans_and_attention_0".equals(tag)) {
                    return new MineItemFansAndAttentionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_item_fans_and_attention is invalid. Received: " + tag);
            case 19:
                if ("layout/mine_item_post_0".equals(tag)) {
                    return new MineItemPostBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_item_post is invalid. Received: " + tag);
            case 20:
                if ("layout/mine_layout_mine_header_0".equals(tag)) {
                    return new MineLayoutMineHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mine_layout_mine_header is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f35283a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f11168a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
