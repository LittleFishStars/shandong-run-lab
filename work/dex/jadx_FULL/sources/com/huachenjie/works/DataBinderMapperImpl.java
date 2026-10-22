package com.huachenjie.works;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.works.databinding.WorksActivityActivityListBindingImpl;
import com.huachenjie.works.databinding.WorksActivityAllChannelBindingImpl;
import com.huachenjie.works.databinding.WorksActivityBroadcastFloorBindingImpl;
import com.huachenjie.works.databinding.WorksActivityCommentOnMeListBindingImpl;
import com.huachenjie.works.databinding.WorksActivityDormitoryBindingImpl;
import com.huachenjie.works.databinding.WorksActivityHotListBindingImpl;
import com.huachenjie.works.databinding.WorksActivityLocalDraftBindingImpl;
import com.huachenjie.works.databinding.WorksActivityPostDetailBindingImpl;
import com.huachenjie.works.databinding.WorksActivityPublishPostBindingImpl;
import com.huachenjie.works.databinding.WorksActivityPulishWorkBindingImpl;
import com.huachenjie.works.databinding.WorksActivitySearchBindingImpl;
import com.huachenjie.works.databinding.WorksActivitySettingInterestTagsBindingImpl;
import com.huachenjie.works.databinding.WorksActivityThisSchoolBindingImpl;
import com.huachenjie.works.databinding.WorksDialogAddFriendBindingImpl;
import com.huachenjie.works.databinding.WorksDialogAllotSuccessBindingImpl;
import com.huachenjie.works.databinding.WorksDialogBroadcastFloorCommentInputBindingImpl;
import com.huachenjie.works.databinding.WorksDialogBroadcastFloorDetailBindingImpl;
import com.huachenjie.works.databinding.WorksDialogBuddyApplyBindingImpl;
import com.huachenjie.works.databinding.WorksDialogChooseFriendBindingImpl;
import com.huachenjie.works.databinding.WorksDialogChooseTeamBindingImpl;
import com.huachenjie.works.databinding.WorksDialogCommentBindingImpl;
import com.huachenjie.works.databinding.WorksDialogCommentInputBindingImpl;
import com.huachenjie.works.databinding.WorksDialogCommentOptBindingImpl;
import com.huachenjie.works.databinding.WorksDialogDormitoryExchangeBindingImpl;
import com.huachenjie.works.databinding.WorksDialogJoinChannelTipBindingImpl;
import com.huachenjie.works.databinding.WorksDialogPublishEntryBindingImpl;
import com.huachenjie.works.databinding.WorksDialogPublishPostBindingImpl;
import com.huachenjie.works.databinding.WorksDialogShareWorkBindingImpl;
import com.huachenjie.works.databinding.WorksDialogSurveySuccessBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentAlumniAttentionBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentAlumniBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentAlumniChannelBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentAlumniRecommendBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentBaseCommentBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentBroadcastFloorBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentFindAlumniBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentGoodStuffBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentGoodStuffItemBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentJobHuntingBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentListChannelBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentOriginalChannelBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentOriginalChannelSubBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentPicturePromotionBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentPictureWorksDetailBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentPubWorksMenuPermissionBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchFastLenovoBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchHotSpotBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchResultBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchResultBuddyBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchResultChannelBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchResultUserBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentSearchResultWorksBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentThisSchoolBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentVideoWorkListBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentWorkListBindingImpl;
import com.huachenjie.works.databinding.WorksFragmentWorksDetailGoodsBindingImpl;
import com.huachenjie.works.databinding.WorksHeadActivityListBindingImpl;
import com.huachenjie.works.databinding.WorksHeadPictureWorksDetailBindingImpl;
import com.huachenjie.works.databinding.WorksHeadSearchHotSpotBindingImpl;
import com.huachenjie.works.databinding.WorksHeadThisSchoolBindingImpl;
import com.huachenjie.works.databinding.WorksItemActivityListBindingImpl;
import com.huachenjie.works.databinding.WorksItemAllChannelListBindingImpl;
import com.huachenjie.works.databinding.WorksItemAttentionWorksBottomBindingImpl;
import com.huachenjie.works.databinding.WorksItemAttentionWorksHeaderBindingImpl;
import com.huachenjie.works.databinding.WorksItemAttentionWorksPictureBindingImpl;
import com.huachenjie.works.databinding.WorksItemAttentionWorksVideoBindingImpl;
import com.huachenjie.works.databinding.WorksItemBroadcastFloorBannerBindingImpl;
import com.huachenjie.works.databinding.WorksItemBroadcastFloorBindingImpl;
import com.huachenjie.works.databinding.WorksItemBuddyCardBindingImpl;
import com.huachenjie.works.databinding.WorksItemChooseFriendBindingImpl;
import com.huachenjie.works.databinding.WorksItemChooseTeamBindingImpl;
import com.huachenjie.works.databinding.WorksItemChooseTeamHeadreBindingImpl;
import com.huachenjie.works.databinding.WorksItemCommentBindingImpl;
import com.huachenjie.works.databinding.WorksItemCommentMoreBindingImpl;
import com.huachenjie.works.databinding.WorksItemCommentOnMeBindingImpl;
import com.huachenjie.works.databinding.WorksItemCommentReplyBindingImpl;
import com.huachenjie.works.databinding.WorksItemDormExchangeCardBindingImpl;
import com.huachenjie.works.databinding.WorksItemDormitoryMenuBindingImpl;
import com.huachenjie.works.databinding.WorksItemFindAlumniBindingImpl;
import com.huachenjie.works.databinding.WorksItemFooterPublishPostBindingImpl;
import com.huachenjie.works.databinding.WorksItemGoodStuffBindingImpl;
import com.huachenjie.works.databinding.WorksItemHeaderPublishPostBindingImpl;
import com.huachenjie.works.databinding.WorksItemInputSelectUserBindingImpl;
import com.huachenjie.works.databinding.WorksItemOrginalChannelSubBindingImpl;
import com.huachenjie.works.databinding.WorksItemPostBindingImpl;
import com.huachenjie.works.databinding.WorksItemPostCategoryDrawerBindingImpl;
import com.huachenjie.works.databinding.WorksItemPubWorkAddMediaBindingImpl;
import com.huachenjie.works.databinding.WorksItemPubWorkMenuChannelBindingImpl;
import com.huachenjie.works.databinding.WorksItemPubWorkMenuLocationBindingImpl;
import com.huachenjie.works.databinding.WorksItemPubWorkMenuTopicBindingImpl;
import com.huachenjie.works.databinding.WorksItemPublishPostBindingImpl;
import com.huachenjie.works.databinding.WorksItemPublishWorkPicBindingImpl;
import com.huachenjie.works.databinding.WorksItemPublishWorkVideoBindingImpl;
import com.huachenjie.works.databinding.WorksItemPulishPostTagBindingImpl;
import com.huachenjie.works.databinding.WorksItemPulishWorkTagBindingImpl;
import com.huachenjie.works.databinding.WorksItemSearchFastLenovoBindingImpl;
import com.huachenjie.works.databinding.WorksItemSearchHotSpotBindingImpl;
import com.huachenjie.works.databinding.WorksItemSearchResultUserBindingImpl;
import com.huachenjie.works.databinding.WorksItemSettingInterestTagsBindingImpl;
import com.huachenjie.works.databinding.WorksItemSettingInterestTagsHeaderBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorkDetailListBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorkListPictureBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorkListVideoBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksActivityBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksAdBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksBroadcastFloorBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksDetailGoodsBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksDetailMenuBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksFirstBindingImpl;
import com.huachenjie.works.databinding.WorksItemWorksLocaleBindingImpl;
import com.huachenjie.works.databinding.WorksLayoutAlumniChannelHeaderBindingImpl;
import com.huachenjie.works.databinding.WorksLayoutPostCommentBindingImpl;
import com.huachenjie.works.databinding.WorksViewPostDetailHeaderBindingImpl;
import com.huachenjie.works.databinding.WorksViewWorksDetailGoodsBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final int A = 27;
    public static final int A0 = 79;
    public static final int B = 28;
    public static final int B0 = 80;
    public static final int C = 29;
    public static final int C0 = 81;
    public static final int D = 30;
    public static final int D0 = 82;
    public static final int E = 31;
    public static final int E0 = 83;
    public static final int F = 32;
    public static final int F0 = 84;
    public static final int G = 33;
    public static final int G0 = 85;
    public static final int H = 34;
    public static final int H0 = 86;
    public static final int I = 35;
    public static final int I0 = 87;
    public static final int J = 36;
    public static final int J0 = 88;
    public static final int K = 37;
    public static final int K0 = 89;
    public static final int L = 38;
    public static final int L0 = 90;
    public static final int M = 39;
    public static final int M0 = 91;
    public static final int N = 40;
    public static final int N0 = 92;
    public static final int O = 41;
    public static final int O0 = 93;
    public static final int P = 42;
    public static final int P0 = 94;
    public static final int Q = 43;
    public static final int Q0 = 95;
    public static final int R = 44;
    public static final int R0 = 96;
    public static final int S = 45;
    public static final int S0 = 97;
    public static final int T = 46;
    public static final int T0 = 98;
    public static final int U = 47;
    public static final int U0 = 99;
    public static final int V = 48;
    public static final int V0 = 100;
    public static final int W = 49;
    public static final int W0 = 101;
    public static final int X = 50;
    public static final int X0 = 102;
    public static final int Y = 51;
    public static final int Y0 = 103;
    public static final int Z = 52;
    public static final int Z0 = 104;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f36755a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f13800a;
    public static final int a0 = 53;
    public static final int a1 = 105;
    public static final int b = 2;
    public static final int b0 = 54;
    public static final int b1 = 106;
    public static final int c = 3;
    public static final int c0 = 55;
    public static final int c1 = 107;
    public static final int d = 4;
    public static final int d0 = 56;
    public static final int d1 = 108;
    public static final int e = 5;
    public static final int e0 = 57;
    public static final int e1 = 109;
    public static final int f = 6;
    public static final int f0 = 58;
    public static final int f1 = 110;
    public static final int g = 7;
    public static final int g0 = 59;
    public static final int g1 = 111;
    public static final int h = 8;
    public static final int h0 = 60;
    public static final int h1 = 112;
    public static final int i = 9;
    public static final int i0 = 61;
    public static final int i1 = 113;
    public static final int j = 10;
    public static final int j0 = 62;
    public static final int j1 = 114;
    public static final int k = 11;
    public static final int k0 = 63;
    public static final int k1 = 115;
    public static final int l = 12;
    public static final int l0 = 64;
    public static final int l1 = 116;
    public static final int m = 13;
    public static final int m0 = 65;
    public static final int n = 14;
    public static final int n0 = 66;
    public static final int o = 15;
    public static final int o0 = 67;
    public static final int p = 16;
    public static final int p0 = 68;
    public static final int q = 17;
    public static final int q0 = 69;
    public static final int r = 18;
    public static final int r0 = 70;
    public static final int s = 19;
    public static final int s0 = 71;
    public static final int t = 20;
    public static final int t0 = 72;
    public static final int u = 21;
    public static final int u0 = 73;
    public static final int v = 22;
    public static final int v0 = 74;
    public static final int w = 23;
    public static final int w0 = 75;
    public static final int x = 24;
    public static final int x0 = 76;
    public static final int y = 25;
    public static final int y0 = 77;
    public static final int z = 26;
    public static final int z0 = 78;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f36756a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(18);
            f36756a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(3, "checked");
            sparseArray.put(4, "click");
            sparseArray.put(5, "commentType");
            sparseArray.put(6, "data");
            sparseArray.put(7, "fragment");
            sparseArray.put(8, "index");
            sparseArray.put(9, "isSelf");
            sparseArray.put(10, "mState");
            sparseArray.put(11, "position");
            sparseArray.put(12, "postType");
            sparseArray.put(13, d.x);
            sparseArray.put(14, "showRelation");
            sparseArray.put(15, "source");
            sparseArray.put(16, "title");
            sparseArray.put(17, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f36757a;

        static {
            HashMap<String, Integer> map = new HashMap<>(116);
            f36757a = map;
            map.put("layout/works_activity_activity_list_0", Integer.valueOf(R.layout.works_activity_activity_list));
            map.put("layout/works_activity_all_channel_0", Integer.valueOf(R.layout.works_activity_all_channel));
            map.put("layout/works_activity_broadcast_floor_0", Integer.valueOf(R.layout.works_activity_broadcast_floor));
            map.put("layout/works_activity_comment_on_me_list_0", Integer.valueOf(R.layout.works_activity_comment_on_me_list));
            map.put("layout/works_activity_dormitory_0", Integer.valueOf(R.layout.works_activity_dormitory));
            map.put("layout/works_activity_hot_list_0", Integer.valueOf(R.layout.works_activity_hot_list));
            map.put("layout/works_activity_local_draft_0", Integer.valueOf(R.layout.works_activity_local_draft));
            map.put("layout/works_activity_post_detail_0", Integer.valueOf(R.layout.works_activity_post_detail));
            map.put("layout/works_activity_publish_post_0", Integer.valueOf(R.layout.works_activity_publish_post));
            map.put("layout/works_activity_pulish_work_0", Integer.valueOf(R.layout.works_activity_pulish_work));
            map.put("layout/works_activity_search_0", Integer.valueOf(R.layout.works_activity_search));
            map.put("layout/works_activity_setting_interest_tags_0", Integer.valueOf(R.layout.works_activity_setting_interest_tags));
            map.put("layout/works_activity_this_school_0", Integer.valueOf(R.layout.works_activity_this_school));
            map.put("layout/works_dialog_add_friend_0", Integer.valueOf(R.layout.works_dialog_add_friend));
            map.put("layout/works_dialog_allot_success_0", Integer.valueOf(R.layout.works_dialog_allot_success));
            map.put("layout/works_dialog_broadcast_floor_comment_input_0", Integer.valueOf(R.layout.works_dialog_broadcast_floor_comment_input));
            map.put("layout/works_dialog_broadcast_floor_detail_0", Integer.valueOf(R.layout.works_dialog_broadcast_floor_detail));
            map.put("layout/works_dialog_buddy_apply_0", Integer.valueOf(R.layout.works_dialog_buddy_apply));
            map.put("layout/works_dialog_choose_friend_0", Integer.valueOf(R.layout.works_dialog_choose_friend));
            map.put("layout/works_dialog_choose_team_0", Integer.valueOf(R.layout.works_dialog_choose_team));
            map.put("layout/works_dialog_comment_0", Integer.valueOf(R.layout.works_dialog_comment));
            map.put("layout/works_dialog_comment_input_0", Integer.valueOf(R.layout.works_dialog_comment_input));
            map.put("layout/works_dialog_comment_opt_0", Integer.valueOf(R.layout.works_dialog_comment_opt));
            map.put("layout/works_dialog_dormitory_exchange_0", Integer.valueOf(R.layout.works_dialog_dormitory_exchange));
            map.put("layout/works_dialog_join_channel_tip_0", Integer.valueOf(R.layout.works_dialog_join_channel_tip));
            map.put("layout/works_dialog_publish_entry_0", Integer.valueOf(R.layout.works_dialog_publish_entry));
            map.put("layout/works_dialog_publish_post_0", Integer.valueOf(R.layout.works_dialog_publish_post));
            map.put("layout/works_dialog_share_work_0", Integer.valueOf(R.layout.works_dialog_share_work));
            map.put("layout/works_dialog_survey_success_0", Integer.valueOf(R.layout.works_dialog_survey_success));
            map.put("layout/works_fragment_alumni_0", Integer.valueOf(R.layout.works_fragment_alumni));
            map.put("layout/works_fragment_alumni_attention_0", Integer.valueOf(R.layout.works_fragment_alumni_attention));
            map.put("layout/works_fragment_alumni_channel_0", Integer.valueOf(R.layout.works_fragment_alumni_channel));
            map.put("layout/works_fragment_alumni_recommend_0", Integer.valueOf(R.layout.works_fragment_alumni_recommend));
            map.put("layout/works_fragment_base_comment_0", Integer.valueOf(R.layout.works_fragment_base_comment));
            map.put("layout/works_fragment_broadcast_floor_0", Integer.valueOf(R.layout.works_fragment_broadcast_floor));
            map.put("layout/works_fragment_find_alumni_0", Integer.valueOf(R.layout.works_fragment_find_alumni));
            map.put("layout/works_fragment_good_stuff_0", Integer.valueOf(R.layout.works_fragment_good_stuff));
            map.put("layout/works_fragment_good_stuff_item_0", Integer.valueOf(R.layout.works_fragment_good_stuff_item));
            map.put("layout/works_fragment_job_hunting_0", Integer.valueOf(R.layout.works_fragment_job_hunting));
            map.put("layout/works_fragment_list_channel_0", Integer.valueOf(R.layout.works_fragment_list_channel));
            map.put("layout/works_fragment_original_channel_0", Integer.valueOf(R.layout.works_fragment_original_channel));
            map.put("layout/works_fragment_original_channel_sub_0", Integer.valueOf(R.layout.works_fragment_original_channel_sub));
            map.put("layout/works_fragment_picture_promotion_0", Integer.valueOf(R.layout.works_fragment_picture_promotion));
            map.put("layout/works_fragment_picture_works_detail_0", Integer.valueOf(R.layout.works_fragment_picture_works_detail));
            map.put("layout/works_fragment_pub_work_menu_0", Integer.valueOf(R.layout.works_fragment_pub_work_menu));
            map.put("layout/works_fragment_pub_works_menu_permission_0", Integer.valueOf(R.layout.works_fragment_pub_works_menu_permission));
            map.put("layout/works_fragment_search_fast_lenovo_0", Integer.valueOf(R.layout.works_fragment_search_fast_lenovo));
            map.put("layout/works_fragment_search_hot_spot_0", Integer.valueOf(R.layout.works_fragment_search_hot_spot));
            map.put("layout/works_fragment_search_result_0", Integer.valueOf(R.layout.works_fragment_search_result));
            map.put("layout/works_fragment_search_result_buddy_0", Integer.valueOf(R.layout.works_fragment_search_result_buddy));
            map.put("layout/works_fragment_search_result_channel_0", Integer.valueOf(R.layout.works_fragment_search_result_channel));
            map.put("layout/works_fragment_search_result_user_0", Integer.valueOf(R.layout.works_fragment_search_result_user));
            map.put("layout/works_fragment_search_result_works_0", Integer.valueOf(R.layout.works_fragment_search_result_works));
            map.put("layout/works_fragment_this_school_0", Integer.valueOf(R.layout.works_fragment_this_school));
            map.put("layout/works_fragment_video_work_list_0", Integer.valueOf(R.layout.works_fragment_video_work_list));
            map.put("layout/works_fragment_work_list_0", Integer.valueOf(R.layout.works_fragment_work_list));
            map.put("layout/works_fragment_works_detail_goods_0", Integer.valueOf(R.layout.works_fragment_works_detail_goods));
            map.put("layout/works_head_activity_list_0", Integer.valueOf(R.layout.works_head_activity_list));
            map.put("layout/works_head_picture_works_detail_0", Integer.valueOf(R.layout.works_head_picture_works_detail));
            map.put("layout/works_head_search_hot_spot_0", Integer.valueOf(R.layout.works_head_search_hot_spot));
            map.put("layout/works_head_this_school_0", Integer.valueOf(R.layout.works_head_this_school));
            map.put("layout/works_item_activity_list_0", Integer.valueOf(R.layout.works_item_activity_list));
            map.put("layout/works_item_all_channel_list_0", Integer.valueOf(R.layout.works_item_all_channel_list));
            map.put("layout/works_item_attention_works_bottom_0", Integer.valueOf(R.layout.works_item_attention_works_bottom));
            map.put("layout/works_item_attention_works_header_0", Integer.valueOf(R.layout.works_item_attention_works_header));
            map.put("layout/works_item_attention_works_picture_0", Integer.valueOf(R.layout.works_item_attention_works_picture));
            map.put("layout/works_item_attention_works_video_0", Integer.valueOf(R.layout.works_item_attention_works_video));
            map.put("layout/works_item_broadcast_floor_0", Integer.valueOf(R.layout.works_item_broadcast_floor));
            map.put("layout/works_item_broadcast_floor_banner_0", Integer.valueOf(R.layout.works_item_broadcast_floor_banner));
            map.put("layout/works_item_buddy_card_0", Integer.valueOf(R.layout.works_item_buddy_card));
            map.put("layout/works_item_choose_friend_0", Integer.valueOf(R.layout.works_item_choose_friend));
            map.put("layout/works_item_choose_team_0", Integer.valueOf(R.layout.works_item_choose_team));
            map.put("layout/works_item_choose_team_headre_0", Integer.valueOf(R.layout.works_item_choose_team_headre));
            map.put("layout/works_item_comment_0", Integer.valueOf(R.layout.works_item_comment));
            map.put("layout/works_item_comment_more_0", Integer.valueOf(R.layout.works_item_comment_more));
            map.put("layout/works_item_comment_on_me_0", Integer.valueOf(R.layout.works_item_comment_on_me));
            map.put("layout/works_item_comment_reply_0", Integer.valueOf(R.layout.works_item_comment_reply));
            map.put("layout/works_item_dorm_exchange_card_0", Integer.valueOf(R.layout.works_item_dorm_exchange_card));
            map.put("layout/works_item_dormitory_menu_0", Integer.valueOf(R.layout.works_item_dormitory_menu));
            map.put("layout/works_item_find_alumni_0", Integer.valueOf(R.layout.works_item_find_alumni));
            map.put("layout/works_item_footer_publish_post_0", Integer.valueOf(R.layout.works_item_footer_publish_post));
            map.put("layout/works_item_good_stuff_0", Integer.valueOf(R.layout.works_item_good_stuff));
            map.put("layout/works_item_header_publish_post_0", Integer.valueOf(R.layout.works_item_header_publish_post));
            map.put("layout/works_item_input_select_user_0", Integer.valueOf(R.layout.works_item_input_select_user));
            map.put("layout/works_item_orginal_channel_sub_0", Integer.valueOf(R.layout.works_item_orginal_channel_sub));
            map.put("layout/works_item_post_0", Integer.valueOf(R.layout.works_item_post));
            map.put("layout/works_item_post_category_drawer_0", Integer.valueOf(R.layout.works_item_post_category_drawer));
            map.put("layout/works_item_pub_work_add_media_0", Integer.valueOf(R.layout.works_item_pub_work_add_media));
            map.put("layout/works_item_pub_work_menu_channel_0", Integer.valueOf(R.layout.works_item_pub_work_menu_channel));
            map.put("layout/works_item_pub_work_menu_location_0", Integer.valueOf(R.layout.works_item_pub_work_menu_location));
            map.put("layout/works_item_pub_work_menu_topic_0", Integer.valueOf(R.layout.works_item_pub_work_menu_topic));
            map.put("layout/works_item_publish_post_0", Integer.valueOf(R.layout.works_item_publish_post));
            map.put("layout/works_item_publish_work_pic_0", Integer.valueOf(R.layout.works_item_publish_work_pic));
            map.put("layout/works_item_publish_work_video_0", Integer.valueOf(R.layout.works_item_publish_work_video));
            map.put("layout/works_item_pulish_post_tag_0", Integer.valueOf(R.layout.works_item_pulish_post_tag));
            map.put("layout/works_item_pulish_work_tag_0", Integer.valueOf(R.layout.works_item_pulish_work_tag));
            map.put("layout/works_item_search_fast_lenovo_0", Integer.valueOf(R.layout.works_item_search_fast_lenovo));
            map.put("layout/works_item_search_hot_spot_0", Integer.valueOf(R.layout.works_item_search_hot_spot));
            map.put("layout/works_item_search_result_user_0", Integer.valueOf(R.layout.works_item_search_result_user));
            map.put("layout/works_item_setting_interest_tags_0", Integer.valueOf(R.layout.works_item_setting_interest_tags));
            map.put("layout/works_item_setting_interest_tags_header_0", Integer.valueOf(R.layout.works_item_setting_interest_tags_header));
            map.put("layout/works_item_work_detail_list_0", Integer.valueOf(R.layout.works_item_work_detail_list));
            map.put("layout/works_item_work_list_picture_0", Integer.valueOf(R.layout.works_item_work_list_picture));
            map.put("layout/works_item_work_list_video_0", Integer.valueOf(R.layout.works_item_work_list_video));
            map.put("layout/works_item_works_0", Integer.valueOf(R.layout.works_item_works));
            map.put("layout/works_item_works_activity_0", Integer.valueOf(R.layout.works_item_works_activity));
            map.put("layout/works_item_works_ad_0", Integer.valueOf(R.layout.works_item_works_ad));
            map.put("layout/works_item_works_broadcast_floor_0", Integer.valueOf(R.layout.works_item_works_broadcast_floor));
            map.put("layout/works_item_works_detail_goods_0", Integer.valueOf(R.layout.works_item_works_detail_goods));
            map.put("layout/works_item_works_detail_menu_0", Integer.valueOf(R.layout.works_item_works_detail_menu));
            map.put("layout/works_item_works_first_0", Integer.valueOf(R.layout.works_item_works_first));
            map.put("layout/works_item_works_locale_0", Integer.valueOf(R.layout.works_item_works_locale));
            map.put("layout/works_layout_alumni_channel_header_0", Integer.valueOf(R.layout.works_layout_alumni_channel_header));
            map.put("layout/works_layout_post_comment_0", Integer.valueOf(R.layout.works_layout_post_comment));
            map.put("layout/works_view_post_detail_header_0", Integer.valueOf(R.layout.works_view_post_detail_header));
            map.put("layout/works_view_works_detail_goods_0", Integer.valueOf(R.layout.works_view_works_detail_goods));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(116);
        f13800a = sparseIntArray;
        sparseIntArray.put(R.layout.works_activity_activity_list, 1);
        sparseIntArray.put(R.layout.works_activity_all_channel, 2);
        sparseIntArray.put(R.layout.works_activity_broadcast_floor, 3);
        sparseIntArray.put(R.layout.works_activity_comment_on_me_list, 4);
        sparseIntArray.put(R.layout.works_activity_dormitory, 5);
        sparseIntArray.put(R.layout.works_activity_hot_list, 6);
        sparseIntArray.put(R.layout.works_activity_local_draft, 7);
        sparseIntArray.put(R.layout.works_activity_post_detail, 8);
        sparseIntArray.put(R.layout.works_activity_publish_post, 9);
        sparseIntArray.put(R.layout.works_activity_pulish_work, 10);
        sparseIntArray.put(R.layout.works_activity_search, 11);
        sparseIntArray.put(R.layout.works_activity_setting_interest_tags, 12);
        sparseIntArray.put(R.layout.works_activity_this_school, 13);
        sparseIntArray.put(R.layout.works_dialog_add_friend, 14);
        sparseIntArray.put(R.layout.works_dialog_allot_success, 15);
        sparseIntArray.put(R.layout.works_dialog_broadcast_floor_comment_input, 16);
        sparseIntArray.put(R.layout.works_dialog_broadcast_floor_detail, 17);
        sparseIntArray.put(R.layout.works_dialog_buddy_apply, 18);
        sparseIntArray.put(R.layout.works_dialog_choose_friend, 19);
        sparseIntArray.put(R.layout.works_dialog_choose_team, 20);
        sparseIntArray.put(R.layout.works_dialog_comment, 21);
        sparseIntArray.put(R.layout.works_dialog_comment_input, 22);
        sparseIntArray.put(R.layout.works_dialog_comment_opt, 23);
        sparseIntArray.put(R.layout.works_dialog_dormitory_exchange, 24);
        sparseIntArray.put(R.layout.works_dialog_join_channel_tip, 25);
        sparseIntArray.put(R.layout.works_dialog_publish_entry, 26);
        sparseIntArray.put(R.layout.works_dialog_publish_post, 27);
        sparseIntArray.put(R.layout.works_dialog_share_work, 28);
        sparseIntArray.put(R.layout.works_dialog_survey_success, 29);
        sparseIntArray.put(R.layout.works_fragment_alumni, 30);
        sparseIntArray.put(R.layout.works_fragment_alumni_attention, 31);
        sparseIntArray.put(R.layout.works_fragment_alumni_channel, 32);
        sparseIntArray.put(R.layout.works_fragment_alumni_recommend, 33);
        sparseIntArray.put(R.layout.works_fragment_base_comment, 34);
        sparseIntArray.put(R.layout.works_fragment_broadcast_floor, 35);
        sparseIntArray.put(R.layout.works_fragment_find_alumni, 36);
        sparseIntArray.put(R.layout.works_fragment_good_stuff, 37);
        sparseIntArray.put(R.layout.works_fragment_good_stuff_item, 38);
        sparseIntArray.put(R.layout.works_fragment_job_hunting, 39);
        sparseIntArray.put(R.layout.works_fragment_list_channel, 40);
        sparseIntArray.put(R.layout.works_fragment_original_channel, 41);
        sparseIntArray.put(R.layout.works_fragment_original_channel_sub, 42);
        sparseIntArray.put(R.layout.works_fragment_picture_promotion, 43);
        sparseIntArray.put(R.layout.works_fragment_picture_works_detail, 44);
        sparseIntArray.put(R.layout.works_fragment_pub_work_menu, 45);
        sparseIntArray.put(R.layout.works_fragment_pub_works_menu_permission, 46);
        sparseIntArray.put(R.layout.works_fragment_search_fast_lenovo, 47);
        sparseIntArray.put(R.layout.works_fragment_search_hot_spot, 48);
        sparseIntArray.put(R.layout.works_fragment_search_result, 49);
        sparseIntArray.put(R.layout.works_fragment_search_result_buddy, 50);
        sparseIntArray.put(R.layout.works_fragment_search_result_channel, 51);
        sparseIntArray.put(R.layout.works_fragment_search_result_user, 52);
        sparseIntArray.put(R.layout.works_fragment_search_result_works, 53);
        sparseIntArray.put(R.layout.works_fragment_this_school, 54);
        sparseIntArray.put(R.layout.works_fragment_video_work_list, 55);
        sparseIntArray.put(R.layout.works_fragment_work_list, 56);
        sparseIntArray.put(R.layout.works_fragment_works_detail_goods, 57);
        sparseIntArray.put(R.layout.works_head_activity_list, 58);
        sparseIntArray.put(R.layout.works_head_picture_works_detail, 59);
        sparseIntArray.put(R.layout.works_head_search_hot_spot, 60);
        sparseIntArray.put(R.layout.works_head_this_school, 61);
        sparseIntArray.put(R.layout.works_item_activity_list, 62);
        sparseIntArray.put(R.layout.works_item_all_channel_list, 63);
        sparseIntArray.put(R.layout.works_item_attention_works_bottom, 64);
        sparseIntArray.put(R.layout.works_item_attention_works_header, 65);
        sparseIntArray.put(R.layout.works_item_attention_works_picture, 66);
        sparseIntArray.put(R.layout.works_item_attention_works_video, 67);
        sparseIntArray.put(R.layout.works_item_broadcast_floor, 68);
        sparseIntArray.put(R.layout.works_item_broadcast_floor_banner, 69);
        sparseIntArray.put(R.layout.works_item_buddy_card, 70);
        sparseIntArray.put(R.layout.works_item_choose_friend, 71);
        sparseIntArray.put(R.layout.works_item_choose_team, 72);
        sparseIntArray.put(R.layout.works_item_choose_team_headre, 73);
        sparseIntArray.put(R.layout.works_item_comment, 74);
        sparseIntArray.put(R.layout.works_item_comment_more, 75);
        sparseIntArray.put(R.layout.works_item_comment_on_me, 76);
        sparseIntArray.put(R.layout.works_item_comment_reply, 77);
        sparseIntArray.put(R.layout.works_item_dorm_exchange_card, 78);
        sparseIntArray.put(R.layout.works_item_dormitory_menu, 79);
        sparseIntArray.put(R.layout.works_item_find_alumni, 80);
        sparseIntArray.put(R.layout.works_item_footer_publish_post, 81);
        sparseIntArray.put(R.layout.works_item_good_stuff, 82);
        sparseIntArray.put(R.layout.works_item_header_publish_post, 83);
        sparseIntArray.put(R.layout.works_item_input_select_user, 84);
        sparseIntArray.put(R.layout.works_item_orginal_channel_sub, 85);
        sparseIntArray.put(R.layout.works_item_post, 86);
        sparseIntArray.put(R.layout.works_item_post_category_drawer, 87);
        sparseIntArray.put(R.layout.works_item_pub_work_add_media, 88);
        sparseIntArray.put(R.layout.works_item_pub_work_menu_channel, 89);
        sparseIntArray.put(R.layout.works_item_pub_work_menu_location, 90);
        sparseIntArray.put(R.layout.works_item_pub_work_menu_topic, 91);
        sparseIntArray.put(R.layout.works_item_publish_post, 92);
        sparseIntArray.put(R.layout.works_item_publish_work_pic, 93);
        sparseIntArray.put(R.layout.works_item_publish_work_video, 94);
        sparseIntArray.put(R.layout.works_item_pulish_post_tag, 95);
        sparseIntArray.put(R.layout.works_item_pulish_work_tag, 96);
        sparseIntArray.put(R.layout.works_item_search_fast_lenovo, 97);
        sparseIntArray.put(R.layout.works_item_search_hot_spot, 98);
        sparseIntArray.put(R.layout.works_item_search_result_user, 99);
        sparseIntArray.put(R.layout.works_item_setting_interest_tags, 100);
        sparseIntArray.put(R.layout.works_item_setting_interest_tags_header, 101);
        sparseIntArray.put(R.layout.works_item_work_detail_list, 102);
        sparseIntArray.put(R.layout.works_item_work_list_picture, 103);
        sparseIntArray.put(R.layout.works_item_work_list_video, 104);
        sparseIntArray.put(R.layout.works_item_works, 105);
        sparseIntArray.put(R.layout.works_item_works_activity, 106);
        sparseIntArray.put(R.layout.works_item_works_ad, 107);
        sparseIntArray.put(R.layout.works_item_works_broadcast_floor, 108);
        sparseIntArray.put(R.layout.works_item_works_detail_goods, 109);
        sparseIntArray.put(R.layout.works_item_works_detail_menu, 110);
        sparseIntArray.put(R.layout.works_item_works_first, 111);
        sparseIntArray.put(R.layout.works_item_works_locale, 112);
        sparseIntArray.put(R.layout.works_layout_alumni_channel_header, 113);
        sparseIntArray.put(R.layout.works_layout_post_comment, 114);
        sparseIntArray.put(R.layout.works_view_post_detail_header, 115);
        sparseIntArray.put(R.layout.works_view_works_detail_goods, 116);
    }

    public final ViewDataBinding a(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/works_activity_activity_list_0".equals(tag)) {
                    return new WorksActivityActivityListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_activity_list is invalid. Received: " + tag);
            case 2:
                if ("layout/works_activity_all_channel_0".equals(tag)) {
                    return new WorksActivityAllChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_all_channel is invalid. Received: " + tag);
            case 3:
                if ("layout/works_activity_broadcast_floor_0".equals(tag)) {
                    return new WorksActivityBroadcastFloorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_broadcast_floor is invalid. Received: " + tag);
            case 4:
                if ("layout/works_activity_comment_on_me_list_0".equals(tag)) {
                    return new WorksActivityCommentOnMeListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_comment_on_me_list is invalid. Received: " + tag);
            case 5:
                if ("layout/works_activity_dormitory_0".equals(tag)) {
                    return new WorksActivityDormitoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_dormitory is invalid. Received: " + tag);
            case 6:
                if ("layout/works_activity_hot_list_0".equals(tag)) {
                    return new WorksActivityHotListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_hot_list is invalid. Received: " + tag);
            case 7:
                if ("layout/works_activity_local_draft_0".equals(tag)) {
                    return new WorksActivityLocalDraftBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_local_draft is invalid. Received: " + tag);
            case 8:
                if ("layout/works_activity_post_detail_0".equals(tag)) {
                    return new WorksActivityPostDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_post_detail is invalid. Received: " + tag);
            case 9:
                if ("layout/works_activity_publish_post_0".equals(tag)) {
                    return new WorksActivityPublishPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_publish_post is invalid. Received: " + tag);
            case 10:
                if ("layout/works_activity_pulish_work_0".equals(tag)) {
                    return new WorksActivityPulishWorkBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_pulish_work is invalid. Received: " + tag);
            case 11:
                if ("layout/works_activity_search_0".equals(tag)) {
                    return new WorksActivitySearchBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_search is invalid. Received: " + tag);
            case 12:
                if ("layout/works_activity_setting_interest_tags_0".equals(tag)) {
                    return new WorksActivitySettingInterestTagsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_setting_interest_tags is invalid. Received: " + tag);
            case 13:
                if ("layout/works_activity_this_school_0".equals(tag)) {
                    return new WorksActivityThisSchoolBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_activity_this_school is invalid. Received: " + tag);
            case 14:
                if ("layout/works_dialog_add_friend_0".equals(tag)) {
                    return new WorksDialogAddFriendBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_add_friend is invalid. Received: " + tag);
            case 15:
                if ("layout/works_dialog_allot_success_0".equals(tag)) {
                    return new WorksDialogAllotSuccessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_allot_success is invalid. Received: " + tag);
            case 16:
                if ("layout/works_dialog_broadcast_floor_comment_input_0".equals(tag)) {
                    return new WorksDialogBroadcastFloorCommentInputBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_broadcast_floor_comment_input is invalid. Received: " + tag);
            case 17:
                if ("layout/works_dialog_broadcast_floor_detail_0".equals(tag)) {
                    return new WorksDialogBroadcastFloorDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_broadcast_floor_detail is invalid. Received: " + tag);
            case 18:
                if ("layout/works_dialog_buddy_apply_0".equals(tag)) {
                    return new WorksDialogBuddyApplyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_buddy_apply is invalid. Received: " + tag);
            case 19:
                if ("layout/works_dialog_choose_friend_0".equals(tag)) {
                    return new WorksDialogChooseFriendBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_choose_friend is invalid. Received: " + tag);
            case 20:
                if ("layout/works_dialog_choose_team_0".equals(tag)) {
                    return new WorksDialogChooseTeamBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_choose_team is invalid. Received: " + tag);
            case 21:
                if ("layout/works_dialog_comment_0".equals(tag)) {
                    return new WorksDialogCommentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_comment is invalid. Received: " + tag);
            case 22:
                if ("layout/works_dialog_comment_input_0".equals(tag)) {
                    return new WorksDialogCommentInputBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_comment_input is invalid. Received: " + tag);
            case 23:
                if ("layout/works_dialog_comment_opt_0".equals(tag)) {
                    return new WorksDialogCommentOptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_comment_opt is invalid. Received: " + tag);
            case 24:
                if ("layout/works_dialog_dormitory_exchange_0".equals(tag)) {
                    return new WorksDialogDormitoryExchangeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_dormitory_exchange is invalid. Received: " + tag);
            case 25:
                if ("layout/works_dialog_join_channel_tip_0".equals(tag)) {
                    return new WorksDialogJoinChannelTipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_join_channel_tip is invalid. Received: " + tag);
            case 26:
                if ("layout/works_dialog_publish_entry_0".equals(tag)) {
                    return new WorksDialogPublishEntryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_publish_entry is invalid. Received: " + tag);
            case 27:
                if ("layout/works_dialog_publish_post_0".equals(tag)) {
                    return new WorksDialogPublishPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_publish_post is invalid. Received: " + tag);
            case 28:
                if ("layout/works_dialog_share_work_0".equals(tag)) {
                    return new WorksDialogShareWorkBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_share_work is invalid. Received: " + tag);
            case 29:
                if ("layout/works_dialog_survey_success_0".equals(tag)) {
                    return new WorksDialogSurveySuccessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_dialog_survey_success is invalid. Received: " + tag);
            case 30:
                if ("layout/works_fragment_alumni_0".equals(tag)) {
                    return new WorksFragmentAlumniBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_alumni is invalid. Received: " + tag);
            case 31:
                if ("layout/works_fragment_alumni_attention_0".equals(tag)) {
                    return new WorksFragmentAlumniAttentionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_alumni_attention is invalid. Received: " + tag);
            case 32:
                if ("layout/works_fragment_alumni_channel_0".equals(tag)) {
                    return new WorksFragmentAlumniChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_alumni_channel is invalid. Received: " + tag);
            case 33:
                if ("layout/works_fragment_alumni_recommend_0".equals(tag)) {
                    return new WorksFragmentAlumniRecommendBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_alumni_recommend is invalid. Received: " + tag);
            case 34:
                if ("layout/works_fragment_base_comment_0".equals(tag)) {
                    return new WorksFragmentBaseCommentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_base_comment is invalid. Received: " + tag);
            case 35:
                if ("layout/works_fragment_broadcast_floor_0".equals(tag)) {
                    return new WorksFragmentBroadcastFloorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_broadcast_floor is invalid. Received: " + tag);
            case 36:
                if ("layout/works_fragment_find_alumni_0".equals(tag)) {
                    return new WorksFragmentFindAlumniBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_find_alumni is invalid. Received: " + tag);
            case 37:
                if ("layout/works_fragment_good_stuff_0".equals(tag)) {
                    return new WorksFragmentGoodStuffBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_good_stuff is invalid. Received: " + tag);
            case 38:
                if ("layout/works_fragment_good_stuff_item_0".equals(tag)) {
                    return new WorksFragmentGoodStuffItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_good_stuff_item is invalid. Received: " + tag);
            case 39:
                if ("layout/works_fragment_job_hunting_0".equals(tag)) {
                    return new WorksFragmentJobHuntingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_job_hunting is invalid. Received: " + tag);
            case 40:
                if ("layout/works_fragment_list_channel_0".equals(tag)) {
                    return new WorksFragmentListChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_list_channel is invalid. Received: " + tag);
            case 41:
                if ("layout/works_fragment_original_channel_0".equals(tag)) {
                    return new WorksFragmentOriginalChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_original_channel is invalid. Received: " + tag);
            case 42:
                if ("layout/works_fragment_original_channel_sub_0".equals(tag)) {
                    return new WorksFragmentOriginalChannelSubBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_original_channel_sub is invalid. Received: " + tag);
            case 43:
                if ("layout/works_fragment_picture_promotion_0".equals(tag)) {
                    return new WorksFragmentPicturePromotionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_picture_promotion is invalid. Received: " + tag);
            case 44:
                if ("layout/works_fragment_picture_works_detail_0".equals(tag)) {
                    return new WorksFragmentPictureWorksDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_picture_works_detail is invalid. Received: " + tag);
            case 45:
                if ("layout/works_fragment_pub_work_menu_0".equals(tag)) {
                    return new WorksFragmentPubWorkMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_pub_work_menu is invalid. Received: " + tag);
            case 46:
                if ("layout/works_fragment_pub_works_menu_permission_0".equals(tag)) {
                    return new WorksFragmentPubWorksMenuPermissionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_pub_works_menu_permission is invalid. Received: " + tag);
            case 47:
                if ("layout/works_fragment_search_fast_lenovo_0".equals(tag)) {
                    return new WorksFragmentSearchFastLenovoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_fast_lenovo is invalid. Received: " + tag);
            case 48:
                if ("layout/works_fragment_search_hot_spot_0".equals(tag)) {
                    return new WorksFragmentSearchHotSpotBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_hot_spot is invalid. Received: " + tag);
            case 49:
                if ("layout/works_fragment_search_result_0".equals(tag)) {
                    return new WorksFragmentSearchResultBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_result is invalid. Received: " + tag);
            case 50:
                if ("layout/works_fragment_search_result_buddy_0".equals(tag)) {
                    return new WorksFragmentSearchResultBuddyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_result_buddy is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    public final ViewDataBinding b(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/works_fragment_search_result_channel_0".equals(tag)) {
                    return new WorksFragmentSearchResultChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_result_channel is invalid. Received: " + tag);
            case 52:
                if ("layout/works_fragment_search_result_user_0".equals(tag)) {
                    return new WorksFragmentSearchResultUserBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_result_user is invalid. Received: " + tag);
            case 53:
                if ("layout/works_fragment_search_result_works_0".equals(tag)) {
                    return new WorksFragmentSearchResultWorksBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_search_result_works is invalid. Received: " + tag);
            case 54:
                if ("layout/works_fragment_this_school_0".equals(tag)) {
                    return new WorksFragmentThisSchoolBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_this_school is invalid. Received: " + tag);
            case 55:
                if ("layout/works_fragment_video_work_list_0".equals(tag)) {
                    return new WorksFragmentVideoWorkListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_video_work_list is invalid. Received: " + tag);
            case 56:
                if ("layout/works_fragment_work_list_0".equals(tag)) {
                    return new WorksFragmentWorkListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_work_list is invalid. Received: " + tag);
            case 57:
                if ("layout/works_fragment_works_detail_goods_0".equals(tag)) {
                    return new WorksFragmentWorksDetailGoodsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_fragment_works_detail_goods is invalid. Received: " + tag);
            case 58:
                if ("layout/works_head_activity_list_0".equals(tag)) {
                    return new WorksHeadActivityListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_head_activity_list is invalid. Received: " + tag);
            case 59:
                if ("layout/works_head_picture_works_detail_0".equals(tag)) {
                    return new WorksHeadPictureWorksDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_head_picture_works_detail is invalid. Received: " + tag);
            case 60:
                if ("layout/works_head_search_hot_spot_0".equals(tag)) {
                    return new WorksHeadSearchHotSpotBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_head_search_hot_spot is invalid. Received: " + tag);
            case 61:
                if ("layout/works_head_this_school_0".equals(tag)) {
                    return new WorksHeadThisSchoolBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_head_this_school is invalid. Received: " + tag);
            case 62:
                if ("layout/works_item_activity_list_0".equals(tag)) {
                    return new WorksItemActivityListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_activity_list is invalid. Received: " + tag);
            case 63:
                if ("layout/works_item_all_channel_list_0".equals(tag)) {
                    return new WorksItemAllChannelListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_all_channel_list is invalid. Received: " + tag);
            case 64:
                if ("layout/works_item_attention_works_bottom_0".equals(tag)) {
                    return new WorksItemAttentionWorksBottomBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_attention_works_bottom is invalid. Received: " + tag);
            case 65:
                if ("layout/works_item_attention_works_header_0".equals(tag)) {
                    return new WorksItemAttentionWorksHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_attention_works_header is invalid. Received: " + tag);
            case 66:
                if ("layout/works_item_attention_works_picture_0".equals(tag)) {
                    return new WorksItemAttentionWorksPictureBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_attention_works_picture is invalid. Received: " + tag);
            case 67:
                if ("layout/works_item_attention_works_video_0".equals(tag)) {
                    return new WorksItemAttentionWorksVideoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_attention_works_video is invalid. Received: " + tag);
            case 68:
                if ("layout/works_item_broadcast_floor_0".equals(tag)) {
                    return new WorksItemBroadcastFloorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_broadcast_floor is invalid. Received: " + tag);
            case 69:
                if ("layout/works_item_broadcast_floor_banner_0".equals(tag)) {
                    return new WorksItemBroadcastFloorBannerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_broadcast_floor_banner is invalid. Received: " + tag);
            case 70:
                if ("layout/works_item_buddy_card_0".equals(tag)) {
                    return new WorksItemBuddyCardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_buddy_card is invalid. Received: " + tag);
            case 71:
                if ("layout/works_item_choose_friend_0".equals(tag)) {
                    return new WorksItemChooseFriendBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_choose_friend is invalid. Received: " + tag);
            case 72:
                if ("layout/works_item_choose_team_0".equals(tag)) {
                    return new WorksItemChooseTeamBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_choose_team is invalid. Received: " + tag);
            case 73:
                if ("layout/works_item_choose_team_headre_0".equals(tag)) {
                    return new WorksItemChooseTeamHeadreBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_choose_team_headre is invalid. Received: " + tag);
            case 74:
                if ("layout/works_item_comment_0".equals(tag)) {
                    return new WorksItemCommentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_comment is invalid. Received: " + tag);
            case 75:
                if ("layout/works_item_comment_more_0".equals(tag)) {
                    return new WorksItemCommentMoreBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_comment_more is invalid. Received: " + tag);
            case 76:
                if ("layout/works_item_comment_on_me_0".equals(tag)) {
                    return new WorksItemCommentOnMeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_comment_on_me is invalid. Received: " + tag);
            case 77:
                if ("layout/works_item_comment_reply_0".equals(tag)) {
                    return new WorksItemCommentReplyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_comment_reply is invalid. Received: " + tag);
            case 78:
                if ("layout/works_item_dorm_exchange_card_0".equals(tag)) {
                    return new WorksItemDormExchangeCardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_dorm_exchange_card is invalid. Received: " + tag);
            case 79:
                if ("layout/works_item_dormitory_menu_0".equals(tag)) {
                    return new WorksItemDormitoryMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_dormitory_menu is invalid. Received: " + tag);
            case 80:
                if ("layout/works_item_find_alumni_0".equals(tag)) {
                    return new WorksItemFindAlumniBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_find_alumni is invalid. Received: " + tag);
            case 81:
                if ("layout/works_item_footer_publish_post_0".equals(tag)) {
                    return new WorksItemFooterPublishPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_footer_publish_post is invalid. Received: " + tag);
            case 82:
                if ("layout/works_item_good_stuff_0".equals(tag)) {
                    return new WorksItemGoodStuffBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_good_stuff is invalid. Received: " + tag);
            case 83:
                if ("layout/works_item_header_publish_post_0".equals(tag)) {
                    return new WorksItemHeaderPublishPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_header_publish_post is invalid. Received: " + tag);
            case 84:
                if ("layout/works_item_input_select_user_0".equals(tag)) {
                    return new WorksItemInputSelectUserBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_input_select_user is invalid. Received: " + tag);
            case 85:
                if ("layout/works_item_orginal_channel_sub_0".equals(tag)) {
                    return new WorksItemOrginalChannelSubBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_orginal_channel_sub is invalid. Received: " + tag);
            case 86:
                if ("layout/works_item_post_0".equals(tag)) {
                    return new WorksItemPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_post is invalid. Received: " + tag);
            case 87:
                if ("layout/works_item_post_category_drawer_0".equals(tag)) {
                    return new WorksItemPostCategoryDrawerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_post_category_drawer is invalid. Received: " + tag);
            case 88:
                if ("layout/works_item_pub_work_add_media_0".equals(tag)) {
                    return new WorksItemPubWorkAddMediaBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pub_work_add_media is invalid. Received: " + tag);
            case 89:
                if ("layout/works_item_pub_work_menu_channel_0".equals(tag)) {
                    return new WorksItemPubWorkMenuChannelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pub_work_menu_channel is invalid. Received: " + tag);
            case 90:
                if ("layout/works_item_pub_work_menu_location_0".equals(tag)) {
                    return new WorksItemPubWorkMenuLocationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pub_work_menu_location is invalid. Received: " + tag);
            case 91:
                if ("layout/works_item_pub_work_menu_topic_0".equals(tag)) {
                    return new WorksItemPubWorkMenuTopicBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pub_work_menu_topic is invalid. Received: " + tag);
            case 92:
                if ("layout/works_item_publish_post_0".equals(tag)) {
                    return new WorksItemPublishPostBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_publish_post is invalid. Received: " + tag);
            case 93:
                if ("layout/works_item_publish_work_pic_0".equals(tag)) {
                    return new WorksItemPublishWorkPicBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_publish_work_pic is invalid. Received: " + tag);
            case 94:
                if ("layout/works_item_publish_work_video_0".equals(tag)) {
                    return new WorksItemPublishWorkVideoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_publish_work_video is invalid. Received: " + tag);
            case 95:
                if ("layout/works_item_pulish_post_tag_0".equals(tag)) {
                    return new WorksItemPulishPostTagBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pulish_post_tag is invalid. Received: " + tag);
            case 96:
                if ("layout/works_item_pulish_work_tag_0".equals(tag)) {
                    return new WorksItemPulishWorkTagBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_pulish_work_tag is invalid. Received: " + tag);
            case 97:
                if ("layout/works_item_search_fast_lenovo_0".equals(tag)) {
                    return new WorksItemSearchFastLenovoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_search_fast_lenovo is invalid. Received: " + tag);
            case 98:
                if ("layout/works_item_search_hot_spot_0".equals(tag)) {
                    return new WorksItemSearchHotSpotBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_search_hot_spot is invalid. Received: " + tag);
            case 99:
                if ("layout/works_item_search_result_user_0".equals(tag)) {
                    return new WorksItemSearchResultUserBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_search_result_user is invalid. Received: " + tag);
            case 100:
                if ("layout/works_item_setting_interest_tags_0".equals(tag)) {
                    return new WorksItemSettingInterestTagsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_setting_interest_tags is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    public final ViewDataBinding c(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 101:
                if ("layout/works_item_setting_interest_tags_header_0".equals(tag)) {
                    return new WorksItemSettingInterestTagsHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_setting_interest_tags_header is invalid. Received: " + tag);
            case 102:
                if ("layout/works_item_work_detail_list_0".equals(tag)) {
                    return new WorksItemWorkDetailListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_work_detail_list is invalid. Received: " + tag);
            case 103:
                if ("layout/works_item_work_list_picture_0".equals(tag)) {
                    return new WorksItemWorkListPictureBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_work_list_picture is invalid. Received: " + tag);
            case 104:
                if ("layout/works_item_work_list_video_0".equals(tag)) {
                    return new WorksItemWorkListVideoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_work_list_video is invalid. Received: " + tag);
            case 105:
                if ("layout/works_item_works_0".equals(tag)) {
                    return new WorksItemWorksBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works is invalid. Received: " + tag);
            case 106:
                if ("layout/works_item_works_activity_0".equals(tag)) {
                    return new WorksItemWorksActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_activity is invalid. Received: " + tag);
            case 107:
                if ("layout/works_item_works_ad_0".equals(tag)) {
                    return new WorksItemWorksAdBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_ad is invalid. Received: " + tag);
            case 108:
                if ("layout/works_item_works_broadcast_floor_0".equals(tag)) {
                    return new WorksItemWorksBroadcastFloorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_broadcast_floor is invalid. Received: " + tag);
            case 109:
                if ("layout/works_item_works_detail_goods_0".equals(tag)) {
                    return new WorksItemWorksDetailGoodsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_detail_goods is invalid. Received: " + tag);
            case 110:
                if ("layout/works_item_works_detail_menu_0".equals(tag)) {
                    return new WorksItemWorksDetailMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_detail_menu is invalid. Received: " + tag);
            case 111:
                if ("layout/works_item_works_first_0".equals(tag)) {
                    return new WorksItemWorksFirstBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_first is invalid. Received: " + tag);
            case 112:
                if ("layout/works_item_works_locale_0".equals(tag)) {
                    return new WorksItemWorksLocaleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_item_works_locale is invalid. Received: " + tag);
            case 113:
                if ("layout/works_layout_alumni_channel_header_0".equals(tag)) {
                    return new WorksLayoutAlumniChannelHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_layout_alumni_channel_header is invalid. Received: " + tag);
            case 114:
                if ("layout/works_layout_post_comment_0".equals(tag)) {
                    return new WorksLayoutPostCommentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_layout_post_comment is invalid. Received: " + tag);
            case 115:
                if ("layout/works_view_post_detail_header_0".equals(tag)) {
                    return new WorksViewPostDetailHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_view_post_detail_header is invalid. Received: " + tag);
            case 116:
                if ("layout/works_view_works_detail_goods_0".equals(tag)) {
                    return new WorksViewWorksDetailGoodsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for works_view_works_detail_goods is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.im.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.social_contact.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return a.f36756a.get(localId);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i2 = f13800a.get(layoutId);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i3 = (i2 - 1) / 50;
        if (i3 == 0) {
            return a(component, view, i2, tag);
        }
        if (i3 == 1) {
            return b(component, view, i2, tag);
        }
        if (i3 != 2) {
            return null;
        }
        return c(component, view, i2, tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = b.f36757a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f13800a.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
