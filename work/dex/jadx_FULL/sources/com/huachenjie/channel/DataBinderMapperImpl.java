package com.huachenjie.channel;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.channel.databinding.ChannelActivityAddFriendBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAdvertiseBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAdvertiseCreateBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAdvertisePreviewBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAllMemberBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAllOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityAllTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityBuddyChatRoomBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityBuddyMemberManagerBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityChannelHomeBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityChannelMainBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityChooseChannelTypeBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityChooseTypePreferenceBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityCreateTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityCreateTopicChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityEditChannelInfoBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityFriendApplyListBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityFriendListBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityJoinAllChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityJoinChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityManageBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityMessageDetailBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityMyOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityNotifyBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityNotifyBuildBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityNotifyNextBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityNotifyPostBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeCreateBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeDetailBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeMemberBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeTeamBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityPublishOrgMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityTeamMemberManageBindingImpl;
import com.huachenjie.channel.databinding.ChannelActivityTopicMainBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogAddSubAdminBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogCreateSuccessBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogOpenNotificationBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogPublishOrgMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogSelectChatTeamLogoBindingImpl;
import com.huachenjie.channel.databinding.ChannelDialogTopicListBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentAdvertiseBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentChannelMainOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentChannelMainTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentFlashMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentJoinAllChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageAdminBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageBasicInfoBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageShareSettingBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentManageTopicChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelCommunicationBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyCommentBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyFansMenuBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyLikeBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyPostCommentBindingImpl;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyPostLikeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemAddFriendBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemAddSubAdminBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemAdvertiseBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemAllMemberBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemAllTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemBuddyMemberBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemChannelMainHotOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemChannelMainHotTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemChannelTypeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemChannelTypePreferenceBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemClubMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemFlashMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemFlashMessageSingleChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemFriendApplyBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemFriendListBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemFriendListGroupBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemHomeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemJoinAllChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemJoinChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageAdminSubTitleBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageAdminUserBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageChatTeamBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageChatTeamGroupBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageTopicChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageTopicChatTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemManageTopicGroupBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelChatTeamBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelChatTeamGroupBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelTopicChatBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyChannelTopicGroupBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemMyOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemNotifyBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemNotifyFansBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemNotifyFavoritesBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemNotifyMailboxBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemOrganizeMemberBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemOrganizeMemberChannelBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemOrganizeMessageBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemOrganizeTeamBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemPublishOrgMesssageClubBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemSelectChatTeamLogoBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemTeamMemberManageBindingImpl;
import com.huachenjie.channel.databinding.ChannelItemTopicListBindingImpl;
import com.huachenjie.channel.databinding.ChannelLayoutChannelMainHeaderBindingImpl;
import com.huachenjie.channel.databinding.ChannelLayoutMyChannelHeaderBindingImpl;
import com.huachenjie.channel.databinding.ChannelViewChannelMainHotOrganizeBindingImpl;
import com.huachenjie.channel.databinding.ChannelViewChannelMainHotTopicBindingImpl;
import com.huachenjie.channel.databinding.ChannelViewOrganizeDetailHeaderBindingImpl;
import com.huachenjie.channel.databinding.ChannelViewTopicMainHeaderBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
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
    public static final int f33006a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f7360a;
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
    public static final int m1 = 117;
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
        public static final SparseArray<String> f33007a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(28);
            f33007a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(3, "bgOption");
            sparseArray.put(4, "checked");
            sparseArray.put(5, "click");
            sparseArray.put(6, "commentType");
            sparseArray.put(7, "data");
            sparseArray.put(8, "fragment");
            sparseArray.put(9, "hasChat");
            sparseArray.put(10, "index");
            sparseArray.put(11, "isAdmin");
            sparseArray.put(12, "isEdit");
            sparseArray.put(13, "isLast");
            sparseArray.put(14, "isMyOrganize");
            sparseArray.put(15, "isSelf");
            sparseArray.put(16, "mState");
            sparseArray.put(17, "position");
            sparseArray.put(18, "postType");
            sparseArray.put(19, d.x);
            sparseArray.put(20, "showAll");
            sparseArray.put(21, "showRelation");
            sparseArray.put(22, "source");
            sparseArray.put(23, "statusBarHeight");
            sparseArray.put(24, "teamGroupTitle");
            sparseArray.put(25, "title");
            sparseArray.put(26, "topicGroupTitle");
            sparseArray.put(27, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f33008a;

        static {
            HashMap<String, Integer> map = new HashMap<>(117);
            f33008a = map;
            map.put("layout/channel_activity_add_friend_0", Integer.valueOf(R.layout.channel_activity_add_friend));
            map.put("layout/channel_activity_advertise_0", Integer.valueOf(R.layout.channel_activity_advertise));
            map.put("layout/channel_activity_advertise_create_0", Integer.valueOf(R.layout.channel_activity_advertise_create));
            map.put("layout/channel_activity_advertise_preview_0", Integer.valueOf(R.layout.channel_activity_advertise_preview));
            map.put("layout/channel_activity_all_member_0", Integer.valueOf(R.layout.channel_activity_all_member));
            map.put("layout/channel_activity_all_organize_0", Integer.valueOf(R.layout.channel_activity_all_organize));
            map.put("layout/channel_activity_all_topic_0", Integer.valueOf(R.layout.channel_activity_all_topic));
            map.put("layout/channel_activity_buddy_chat_room_0", Integer.valueOf(R.layout.channel_activity_buddy_chat_room));
            map.put("layout/channel_activity_buddy_member_manager_0", Integer.valueOf(R.layout.channel_activity_buddy_member_manager));
            map.put("layout/channel_activity_channel_home_0", Integer.valueOf(R.layout.channel_activity_channel_home));
            map.put("layout/channel_activity_channel_main_0", Integer.valueOf(R.layout.channel_activity_channel_main));
            map.put("layout/channel_activity_choose_channel_type_0", Integer.valueOf(R.layout.channel_activity_choose_channel_type));
            map.put("layout/channel_activity_choose_type_preference_0", Integer.valueOf(R.layout.channel_activity_choose_type_preference));
            map.put("layout/channel_activity_create_chat_team_0", Integer.valueOf(R.layout.channel_activity_create_chat_team));
            map.put("layout/channel_activity_create_topic_0", Integer.valueOf(R.layout.channel_activity_create_topic));
            map.put("layout/channel_activity_create_topic_chat_0", Integer.valueOf(R.layout.channel_activity_create_topic_chat));
            map.put("layout/channel_activity_edit_channel_info_0", Integer.valueOf(R.layout.channel_activity_edit_channel_info));
            map.put("layout/channel_activity_friend_apply_list_0", Integer.valueOf(R.layout.channel_activity_friend_apply_list));
            map.put("layout/channel_activity_friend_list_0", Integer.valueOf(R.layout.channel_activity_friend_list));
            map.put("layout/channel_activity_join_all_channel_0", Integer.valueOf(R.layout.channel_activity_join_all_channel));
            map.put("layout/channel_activity_join_channel_0", Integer.valueOf(R.layout.channel_activity_join_channel));
            map.put("layout/channel_activity_manage_0", Integer.valueOf(R.layout.channel_activity_manage));
            map.put("layout/channel_activity_message_detail_0", Integer.valueOf(R.layout.channel_activity_message_detail));
            map.put("layout/channel_activity_my_organize_0", Integer.valueOf(R.layout.channel_activity_my_organize));
            map.put("layout/channel_activity_notify_0", Integer.valueOf(R.layout.channel_activity_notify));
            map.put("layout/channel_activity_notify_build_0", Integer.valueOf(R.layout.channel_activity_notify_build));
            map.put("layout/channel_activity_notify_next_0", Integer.valueOf(R.layout.channel_activity_notify_next));
            map.put("layout/channel_activity_notify_post_0", Integer.valueOf(R.layout.channel_activity_notify_post));
            map.put("layout/channel_activity_organize_0", Integer.valueOf(R.layout.channel_activity_organize));
            map.put("layout/channel_activity_organize_create_0", Integer.valueOf(R.layout.channel_activity_organize_create));
            map.put("layout/channel_activity_organize_detail_0", Integer.valueOf(R.layout.channel_activity_organize_detail));
            map.put("layout/channel_activity_organize_member_0", Integer.valueOf(R.layout.channel_activity_organize_member));
            map.put("layout/channel_activity_organize_message_0", Integer.valueOf(R.layout.channel_activity_organize_message));
            map.put("layout/channel_activity_organize_team_0", Integer.valueOf(R.layout.channel_activity_organize_team));
            map.put("layout/channel_activity_publish_org_message_0", Integer.valueOf(R.layout.channel_activity_publish_org_message));
            map.put("layout/channel_activity_team_member_manage_0", Integer.valueOf(R.layout.channel_activity_team_member_manage));
            map.put("layout/channel_activity_topic_main_0", Integer.valueOf(R.layout.channel_activity_topic_main));
            map.put("layout/channel_dialog_add_sub_admin_0", Integer.valueOf(R.layout.channel_dialog_add_sub_admin));
            map.put("layout/channel_dialog_create_success_0", Integer.valueOf(R.layout.channel_dialog_create_success));
            map.put("layout/channel_dialog_open_notification_0", Integer.valueOf(R.layout.channel_dialog_open_notification));
            map.put("layout/channel_dialog_publish_org_message_0", Integer.valueOf(R.layout.channel_dialog_publish_org_message));
            map.put("layout/channel_dialog_select_chat_team_logo_0", Integer.valueOf(R.layout.channel_dialog_select_chat_team_logo));
            map.put("layout/channel_dialog_topic_list_0", Integer.valueOf(R.layout.channel_dialog_topic_list));
            map.put("layout/channel_fragment_advertise_0", Integer.valueOf(R.layout.channel_fragment_advertise));
            map.put("layout/channel_fragment_channel_main_organize_0", Integer.valueOf(R.layout.channel_fragment_channel_main_organize));
            map.put("layout/channel_fragment_channel_main_topic_0", Integer.valueOf(R.layout.channel_fragment_channel_main_topic));
            map.put("layout/channel_fragment_flash_message_0", Integer.valueOf(R.layout.channel_fragment_flash_message));
            map.put("layout/channel_fragment_join_all_channel_0", Integer.valueOf(R.layout.channel_fragment_join_all_channel));
            map.put("layout/channel_fragment_manage_admin_0", Integer.valueOf(R.layout.channel_fragment_manage_admin));
            map.put("layout/channel_fragment_manage_basic_info_0", Integer.valueOf(R.layout.channel_fragment_manage_basic_info));
            map.put("layout/channel_fragment_manage_chat_0", Integer.valueOf(R.layout.channel_fragment_manage_chat));
            map.put("layout/channel_fragment_manage_share_setting_0", Integer.valueOf(R.layout.channel_fragment_manage_share_setting));
            map.put("layout/channel_fragment_manage_topic_0", Integer.valueOf(R.layout.channel_fragment_manage_topic));
            map.put("layout/channel_fragment_manage_topic_chat_0", Integer.valueOf(R.layout.channel_fragment_manage_topic_chat));
            map.put("layout/channel_fragment_my_channel_0", Integer.valueOf(R.layout.channel_fragment_my_channel));
            map.put("layout/channel_fragment_my_channel_communication_0", Integer.valueOf(R.layout.channel_fragment_my_channel_communication));
            map.put("layout/channel_fragment_my_channel_organize_0", Integer.valueOf(R.layout.channel_fragment_my_channel_organize));
            map.put("layout/channel_fragment_my_channel_topic_0", Integer.valueOf(R.layout.channel_fragment_my_channel_topic));
            map.put("layout/channel_fragment_notify_comment_0", Integer.valueOf(R.layout.channel_fragment_notify_comment));
            map.put("layout/channel_fragment_notify_fans_menu_0", Integer.valueOf(R.layout.channel_fragment_notify_fans_menu));
            map.put("layout/channel_fragment_notify_like_0", Integer.valueOf(R.layout.channel_fragment_notify_like));
            map.put("layout/channel_fragment_notify_post_comment_0", Integer.valueOf(R.layout.channel_fragment_notify_post_comment));
            map.put("layout/channel_fragment_notify_post_like_0", Integer.valueOf(R.layout.channel_fragment_notify_post_like));
            map.put("layout/channel_item_add_friend_0", Integer.valueOf(R.layout.channel_item_add_friend));
            map.put("layout/channel_item_add_sub_admin_0", Integer.valueOf(R.layout.channel_item_add_sub_admin));
            map.put("layout/channel_item_advertise_0", Integer.valueOf(R.layout.channel_item_advertise));
            map.put("layout/channel_item_all_member_0", Integer.valueOf(R.layout.channel_item_all_member));
            map.put("layout/channel_item_all_topic_0", Integer.valueOf(R.layout.channel_item_all_topic));
            map.put("layout/channel_item_buddy_member_0", Integer.valueOf(R.layout.channel_item_buddy_member));
            map.put("layout/channel_item_channel_main_hot_organize_0", Integer.valueOf(R.layout.channel_item_channel_main_hot_organize));
            map.put("layout/channel_item_channel_main_hot_topic_0", Integer.valueOf(R.layout.channel_item_channel_main_hot_topic));
            map.put("layout/channel_item_channel_type_0", Integer.valueOf(R.layout.channel_item_channel_type));
            map.put("layout/channel_item_channel_type_preference_0", Integer.valueOf(R.layout.channel_item_channel_type_preference));
            map.put("layout/channel_item_club_message_0", Integer.valueOf(R.layout.channel_item_club_message));
            map.put("layout/channel_item_flash_message_0", Integer.valueOf(R.layout.channel_item_flash_message));
            map.put("layout/channel_item_flash_message_single_chat_0", Integer.valueOf(R.layout.channel_item_flash_message_single_chat));
            map.put("layout/channel_item_friend_apply_0", Integer.valueOf(R.layout.channel_item_friend_apply));
            map.put("layout/channel_item_friend_list_0", Integer.valueOf(R.layout.channel_item_friend_list));
            map.put("layout/channel_item_friend_list_group_0", Integer.valueOf(R.layout.channel_item_friend_list_group));
            map.put("layout/channel_item_home_0", Integer.valueOf(R.layout.channel_item_home));
            map.put("layout/channel_item_join_all_channel_0", Integer.valueOf(R.layout.channel_item_join_all_channel));
            map.put("layout/channel_item_join_channel_0", Integer.valueOf(R.layout.channel_item_join_channel));
            map.put("layout/channel_item_manage_admin_sub_title_0", Integer.valueOf(R.layout.channel_item_manage_admin_sub_title));
            map.put("layout/channel_item_manage_admin_user_0", Integer.valueOf(R.layout.channel_item_manage_admin_user));
            map.put("layout/channel_item_manage_chat_team_0", Integer.valueOf(R.layout.channel_item_manage_chat_team));
            map.put("layout/channel_item_manage_chat_team_group_0", Integer.valueOf(R.layout.channel_item_manage_chat_team_group));
            map.put("layout/channel_item_manage_topic_0", Integer.valueOf(R.layout.channel_item_manage_topic));
            map.put("layout/channel_item_manage_topic_chat_0", Integer.valueOf(R.layout.channel_item_manage_topic_chat));
            map.put("layout/channel_item_manage_topic_chat_topic_0", Integer.valueOf(R.layout.channel_item_manage_topic_chat_topic));
            map.put("layout/channel_item_manage_topic_group_0", Integer.valueOf(R.layout.channel_item_manage_topic_group));
            map.put("layout/channel_item_my_channel_chat_team_0", Integer.valueOf(R.layout.channel_item_my_channel_chat_team));
            map.put("layout/channel_item_my_channel_chat_team_group_0", Integer.valueOf(R.layout.channel_item_my_channel_chat_team_group));
            map.put("layout/channel_item_my_channel_organize_0", Integer.valueOf(R.layout.channel_item_my_channel_organize));
            map.put("layout/channel_item_my_channel_organize_chat_0", Integer.valueOf(R.layout.channel_item_my_channel_organize_chat));
            map.put("layout/channel_item_my_channel_topic_0", Integer.valueOf(R.layout.channel_item_my_channel_topic));
            map.put("layout/channel_item_my_channel_topic_chat_0", Integer.valueOf(R.layout.channel_item_my_channel_topic_chat));
            map.put("layout/channel_item_my_channel_topic_group_0", Integer.valueOf(R.layout.channel_item_my_channel_topic_group));
            map.put("layout/channel_item_my_organize_0", Integer.valueOf(R.layout.channel_item_my_organize));
            map.put("layout/channel_item_notify_0", Integer.valueOf(R.layout.channel_item_notify));
            map.put("layout/channel_item_notify_fans_0", Integer.valueOf(R.layout.channel_item_notify_fans));
            map.put("layout/channel_item_notify_favorites_0", Integer.valueOf(R.layout.channel_item_notify_favorites));
            map.put("layout/channel_item_notify_mailbox_0", Integer.valueOf(R.layout.channel_item_notify_mailbox));
            map.put("layout/channel_item_organize_0", Integer.valueOf(R.layout.channel_item_organize));
            map.put("layout/channel_item_organize_member_0", Integer.valueOf(R.layout.channel_item_organize_member));
            map.put("layout/channel_item_organize_member_channel_0", Integer.valueOf(R.layout.channel_item_organize_member_channel));
            map.put("layout/channel_item_organize_message_0", Integer.valueOf(R.layout.channel_item_organize_message));
            map.put("layout/channel_item_organize_team_0", Integer.valueOf(R.layout.channel_item_organize_team));
            map.put("layout/channel_item_publish_org_messsage_club_0", Integer.valueOf(R.layout.channel_item_publish_org_messsage_club));
            map.put("layout/channel_item_select_chat_team_logo_0", Integer.valueOf(R.layout.channel_item_select_chat_team_logo));
            map.put("layout/channel_item_team_member_manage_0", Integer.valueOf(R.layout.channel_item_team_member_manage));
            map.put("layout/channel_item_topic_list_0", Integer.valueOf(R.layout.channel_item_topic_list));
            map.put("layout/channel_layout_channel_main_header_0", Integer.valueOf(R.layout.channel_layout_channel_main_header));
            map.put("layout/channel_layout_my_channel_header_0", Integer.valueOf(R.layout.channel_layout_my_channel_header));
            map.put("layout/channel_view_channel_main_hot_organize_0", Integer.valueOf(R.layout.channel_view_channel_main_hot_organize));
            map.put("layout/channel_view_channel_main_hot_topic_0", Integer.valueOf(R.layout.channel_view_channel_main_hot_topic));
            map.put("layout/channel_view_organize_detail_header_0", Integer.valueOf(R.layout.channel_view_organize_detail_header));
            map.put("layout/channel_view_topic_main_header_0", Integer.valueOf(R.layout.channel_view_topic_main_header));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(117);
        f7360a = sparseIntArray;
        sparseIntArray.put(R.layout.channel_activity_add_friend, 1);
        sparseIntArray.put(R.layout.channel_activity_advertise, 2);
        sparseIntArray.put(R.layout.channel_activity_advertise_create, 3);
        sparseIntArray.put(R.layout.channel_activity_advertise_preview, 4);
        sparseIntArray.put(R.layout.channel_activity_all_member, 5);
        sparseIntArray.put(R.layout.channel_activity_all_organize, 6);
        sparseIntArray.put(R.layout.channel_activity_all_topic, 7);
        sparseIntArray.put(R.layout.channel_activity_buddy_chat_room, 8);
        sparseIntArray.put(R.layout.channel_activity_buddy_member_manager, 9);
        sparseIntArray.put(R.layout.channel_activity_channel_home, 10);
        sparseIntArray.put(R.layout.channel_activity_channel_main, 11);
        sparseIntArray.put(R.layout.channel_activity_choose_channel_type, 12);
        sparseIntArray.put(R.layout.channel_activity_choose_type_preference, 13);
        sparseIntArray.put(R.layout.channel_activity_create_chat_team, 14);
        sparseIntArray.put(R.layout.channel_activity_create_topic, 15);
        sparseIntArray.put(R.layout.channel_activity_create_topic_chat, 16);
        sparseIntArray.put(R.layout.channel_activity_edit_channel_info, 17);
        sparseIntArray.put(R.layout.channel_activity_friend_apply_list, 18);
        sparseIntArray.put(R.layout.channel_activity_friend_list, 19);
        sparseIntArray.put(R.layout.channel_activity_join_all_channel, 20);
        sparseIntArray.put(R.layout.channel_activity_join_channel, 21);
        sparseIntArray.put(R.layout.channel_activity_manage, 22);
        sparseIntArray.put(R.layout.channel_activity_message_detail, 23);
        sparseIntArray.put(R.layout.channel_activity_my_organize, 24);
        sparseIntArray.put(R.layout.channel_activity_notify, 25);
        sparseIntArray.put(R.layout.channel_activity_notify_build, 26);
        sparseIntArray.put(R.layout.channel_activity_notify_next, 27);
        sparseIntArray.put(R.layout.channel_activity_notify_post, 28);
        sparseIntArray.put(R.layout.channel_activity_organize, 29);
        sparseIntArray.put(R.layout.channel_activity_organize_create, 30);
        sparseIntArray.put(R.layout.channel_activity_organize_detail, 31);
        sparseIntArray.put(R.layout.channel_activity_organize_member, 32);
        sparseIntArray.put(R.layout.channel_activity_organize_message, 33);
        sparseIntArray.put(R.layout.channel_activity_organize_team, 34);
        sparseIntArray.put(R.layout.channel_activity_publish_org_message, 35);
        sparseIntArray.put(R.layout.channel_activity_team_member_manage, 36);
        sparseIntArray.put(R.layout.channel_activity_topic_main, 37);
        sparseIntArray.put(R.layout.channel_dialog_add_sub_admin, 38);
        sparseIntArray.put(R.layout.channel_dialog_create_success, 39);
        sparseIntArray.put(R.layout.channel_dialog_open_notification, 40);
        sparseIntArray.put(R.layout.channel_dialog_publish_org_message, 41);
        sparseIntArray.put(R.layout.channel_dialog_select_chat_team_logo, 42);
        sparseIntArray.put(R.layout.channel_dialog_topic_list, 43);
        sparseIntArray.put(R.layout.channel_fragment_advertise, 44);
        sparseIntArray.put(R.layout.channel_fragment_channel_main_organize, 45);
        sparseIntArray.put(R.layout.channel_fragment_channel_main_topic, 46);
        sparseIntArray.put(R.layout.channel_fragment_flash_message, 47);
        sparseIntArray.put(R.layout.channel_fragment_join_all_channel, 48);
        sparseIntArray.put(R.layout.channel_fragment_manage_admin, 49);
        sparseIntArray.put(R.layout.channel_fragment_manage_basic_info, 50);
        sparseIntArray.put(R.layout.channel_fragment_manage_chat, 51);
        sparseIntArray.put(R.layout.channel_fragment_manage_share_setting, 52);
        sparseIntArray.put(R.layout.channel_fragment_manage_topic, 53);
        sparseIntArray.put(R.layout.channel_fragment_manage_topic_chat, 54);
        sparseIntArray.put(R.layout.channel_fragment_my_channel, 55);
        sparseIntArray.put(R.layout.channel_fragment_my_channel_communication, 56);
        sparseIntArray.put(R.layout.channel_fragment_my_channel_organize, 57);
        sparseIntArray.put(R.layout.channel_fragment_my_channel_topic, 58);
        sparseIntArray.put(R.layout.channel_fragment_notify_comment, 59);
        sparseIntArray.put(R.layout.channel_fragment_notify_fans_menu, 60);
        sparseIntArray.put(R.layout.channel_fragment_notify_like, 61);
        sparseIntArray.put(R.layout.channel_fragment_notify_post_comment, 62);
        sparseIntArray.put(R.layout.channel_fragment_notify_post_like, 63);
        sparseIntArray.put(R.layout.channel_item_add_friend, 64);
        sparseIntArray.put(R.layout.channel_item_add_sub_admin, 65);
        sparseIntArray.put(R.layout.channel_item_advertise, 66);
        sparseIntArray.put(R.layout.channel_item_all_member, 67);
        sparseIntArray.put(R.layout.channel_item_all_topic, 68);
        sparseIntArray.put(R.layout.channel_item_buddy_member, 69);
        sparseIntArray.put(R.layout.channel_item_channel_main_hot_organize, 70);
        sparseIntArray.put(R.layout.channel_item_channel_main_hot_topic, 71);
        sparseIntArray.put(R.layout.channel_item_channel_type, 72);
        sparseIntArray.put(R.layout.channel_item_channel_type_preference, 73);
        sparseIntArray.put(R.layout.channel_item_club_message, 74);
        sparseIntArray.put(R.layout.channel_item_flash_message, 75);
        sparseIntArray.put(R.layout.channel_item_flash_message_single_chat, 76);
        sparseIntArray.put(R.layout.channel_item_friend_apply, 77);
        sparseIntArray.put(R.layout.channel_item_friend_list, 78);
        sparseIntArray.put(R.layout.channel_item_friend_list_group, 79);
        sparseIntArray.put(R.layout.channel_item_home, 80);
        sparseIntArray.put(R.layout.channel_item_join_all_channel, 81);
        sparseIntArray.put(R.layout.channel_item_join_channel, 82);
        sparseIntArray.put(R.layout.channel_item_manage_admin_sub_title, 83);
        sparseIntArray.put(R.layout.channel_item_manage_admin_user, 84);
        sparseIntArray.put(R.layout.channel_item_manage_chat_team, 85);
        sparseIntArray.put(R.layout.channel_item_manage_chat_team_group, 86);
        sparseIntArray.put(R.layout.channel_item_manage_topic, 87);
        sparseIntArray.put(R.layout.channel_item_manage_topic_chat, 88);
        sparseIntArray.put(R.layout.channel_item_manage_topic_chat_topic, 89);
        sparseIntArray.put(R.layout.channel_item_manage_topic_group, 90);
        sparseIntArray.put(R.layout.channel_item_my_channel_chat_team, 91);
        sparseIntArray.put(R.layout.channel_item_my_channel_chat_team_group, 92);
        sparseIntArray.put(R.layout.channel_item_my_channel_organize, 93);
        sparseIntArray.put(R.layout.channel_item_my_channel_organize_chat, 94);
        sparseIntArray.put(R.layout.channel_item_my_channel_topic, 95);
        sparseIntArray.put(R.layout.channel_item_my_channel_topic_chat, 96);
        sparseIntArray.put(R.layout.channel_item_my_channel_topic_group, 97);
        sparseIntArray.put(R.layout.channel_item_my_organize, 98);
        sparseIntArray.put(R.layout.channel_item_notify, 99);
        sparseIntArray.put(R.layout.channel_item_notify_fans, 100);
        sparseIntArray.put(R.layout.channel_item_notify_favorites, 101);
        sparseIntArray.put(R.layout.channel_item_notify_mailbox, 102);
        sparseIntArray.put(R.layout.channel_item_organize, 103);
        sparseIntArray.put(R.layout.channel_item_organize_member, 104);
        sparseIntArray.put(R.layout.channel_item_organize_member_channel, 105);
        sparseIntArray.put(R.layout.channel_item_organize_message, 106);
        sparseIntArray.put(R.layout.channel_item_organize_team, 107);
        sparseIntArray.put(R.layout.channel_item_publish_org_messsage_club, 108);
        sparseIntArray.put(R.layout.channel_item_select_chat_team_logo, 109);
        sparseIntArray.put(R.layout.channel_item_team_member_manage, 110);
        sparseIntArray.put(R.layout.channel_item_topic_list, 111);
        sparseIntArray.put(R.layout.channel_layout_channel_main_header, 112);
        sparseIntArray.put(R.layout.channel_layout_my_channel_header, 113);
        sparseIntArray.put(R.layout.channel_view_channel_main_hot_organize, 114);
        sparseIntArray.put(R.layout.channel_view_channel_main_hot_topic, 115);
        sparseIntArray.put(R.layout.channel_view_organize_detail_header, 116);
        sparseIntArray.put(R.layout.channel_view_topic_main_header, 117);
    }

    public final ViewDataBinding a(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/channel_activity_add_friend_0".equals(obj)) {
                    return new ChannelActivityAddFriendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_add_friend is invalid. Received: " + obj);
            case 2:
                if ("layout/channel_activity_advertise_0".equals(obj)) {
                    return new ChannelActivityAdvertiseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_advertise is invalid. Received: " + obj);
            case 3:
                if ("layout/channel_activity_advertise_create_0".equals(obj)) {
                    return new ChannelActivityAdvertiseCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_advertise_create is invalid. Received: " + obj);
            case 4:
                if ("layout/channel_activity_advertise_preview_0".equals(obj)) {
                    return new ChannelActivityAdvertisePreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_advertise_preview is invalid. Received: " + obj);
            case 5:
                if ("layout/channel_activity_all_member_0".equals(obj)) {
                    return new ChannelActivityAllMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_all_member is invalid. Received: " + obj);
            case 6:
                if ("layout/channel_activity_all_organize_0".equals(obj)) {
                    return new ChannelActivityAllOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_all_organize is invalid. Received: " + obj);
            case 7:
                if ("layout/channel_activity_all_topic_0".equals(obj)) {
                    return new ChannelActivityAllTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_all_topic is invalid. Received: " + obj);
            case 8:
                if ("layout/channel_activity_buddy_chat_room_0".equals(obj)) {
                    return new ChannelActivityBuddyChatRoomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_buddy_chat_room is invalid. Received: " + obj);
            case 9:
                if ("layout/channel_activity_buddy_member_manager_0".equals(obj)) {
                    return new ChannelActivityBuddyMemberManagerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_buddy_member_manager is invalid. Received: " + obj);
            case 10:
                if ("layout/channel_activity_channel_home_0".equals(obj)) {
                    return new ChannelActivityChannelHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_channel_home is invalid. Received: " + obj);
            case 11:
                if ("layout/channel_activity_channel_main_0".equals(obj)) {
                    return new ChannelActivityChannelMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_channel_main is invalid. Received: " + obj);
            case 12:
                if ("layout/channel_activity_choose_channel_type_0".equals(obj)) {
                    return new ChannelActivityChooseChannelTypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_choose_channel_type is invalid. Received: " + obj);
            case 13:
                if ("layout/channel_activity_choose_type_preference_0".equals(obj)) {
                    return new ChannelActivityChooseTypePreferenceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_choose_type_preference is invalid. Received: " + obj);
            case 14:
                if ("layout/channel_activity_create_chat_team_0".equals(obj)) {
                    return new ChannelActivityCreateChatTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_create_chat_team is invalid. Received: " + obj);
            case 15:
                if ("layout/channel_activity_create_topic_0".equals(obj)) {
                    return new ChannelActivityCreateTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_create_topic is invalid. Received: " + obj);
            case 16:
                if ("layout/channel_activity_create_topic_chat_0".equals(obj)) {
                    return new ChannelActivityCreateTopicChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_create_topic_chat is invalid. Received: " + obj);
            case 17:
                if ("layout/channel_activity_edit_channel_info_0".equals(obj)) {
                    return new ChannelActivityEditChannelInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_edit_channel_info is invalid. Received: " + obj);
            case 18:
                if ("layout/channel_activity_friend_apply_list_0".equals(obj)) {
                    return new ChannelActivityFriendApplyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_friend_apply_list is invalid. Received: " + obj);
            case 19:
                if ("layout/channel_activity_friend_list_0".equals(obj)) {
                    return new ChannelActivityFriendListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_friend_list is invalid. Received: " + obj);
            case 20:
                if ("layout/channel_activity_join_all_channel_0".equals(obj)) {
                    return new ChannelActivityJoinAllChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_join_all_channel is invalid. Received: " + obj);
            case 21:
                if ("layout/channel_activity_join_channel_0".equals(obj)) {
                    return new ChannelActivityJoinChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_join_channel is invalid. Received: " + obj);
            case 22:
                if ("layout/channel_activity_manage_0".equals(obj)) {
                    return new ChannelActivityManageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_manage is invalid. Received: " + obj);
            case 23:
                if ("layout/channel_activity_message_detail_0".equals(obj)) {
                    return new ChannelActivityMessageDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_message_detail is invalid. Received: " + obj);
            case 24:
                if ("layout/channel_activity_my_organize_0".equals(obj)) {
                    return new ChannelActivityMyOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_my_organize is invalid. Received: " + obj);
            case 25:
                if ("layout/channel_activity_notify_0".equals(obj)) {
                    return new ChannelActivityNotifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_notify is invalid. Received: " + obj);
            case 26:
                if ("layout/channel_activity_notify_build_0".equals(obj)) {
                    return new ChannelActivityNotifyBuildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_notify_build is invalid. Received: " + obj);
            case 27:
                if ("layout/channel_activity_notify_next_0".equals(obj)) {
                    return new ChannelActivityNotifyNextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_notify_next is invalid. Received: " + obj);
            case 28:
                if ("layout/channel_activity_notify_post_0".equals(obj)) {
                    return new ChannelActivityNotifyPostBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_notify_post is invalid. Received: " + obj);
            case 29:
                if ("layout/channel_activity_organize_0".equals(obj)) {
                    return new ChannelActivityOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize is invalid. Received: " + obj);
            case 30:
                if ("layout/channel_activity_organize_create_0".equals(obj)) {
                    return new ChannelActivityOrganizeCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize_create is invalid. Received: " + obj);
            case 31:
                if ("layout/channel_activity_organize_detail_0".equals(obj)) {
                    return new ChannelActivityOrganizeDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize_detail is invalid. Received: " + obj);
            case 32:
                if ("layout/channel_activity_organize_member_0".equals(obj)) {
                    return new ChannelActivityOrganizeMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize_member is invalid. Received: " + obj);
            case 33:
                if ("layout/channel_activity_organize_message_0".equals(obj)) {
                    return new ChannelActivityOrganizeMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize_message is invalid. Received: " + obj);
            case 34:
                if ("layout/channel_activity_organize_team_0".equals(obj)) {
                    return new ChannelActivityOrganizeTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_organize_team is invalid. Received: " + obj);
            case 35:
                if ("layout/channel_activity_publish_org_message_0".equals(obj)) {
                    return new ChannelActivityPublishOrgMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_publish_org_message is invalid. Received: " + obj);
            case 36:
                if ("layout/channel_activity_team_member_manage_0".equals(obj)) {
                    return new ChannelActivityTeamMemberManageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_team_member_manage is invalid. Received: " + obj);
            case 37:
                if ("layout/channel_activity_topic_main_0".equals(obj)) {
                    return new ChannelActivityTopicMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_activity_topic_main is invalid. Received: " + obj);
            case 38:
                if ("layout/channel_dialog_add_sub_admin_0".equals(obj)) {
                    return new ChannelDialogAddSubAdminBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_add_sub_admin is invalid. Received: " + obj);
            case 39:
                if ("layout/channel_dialog_create_success_0".equals(obj)) {
                    return new ChannelDialogCreateSuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_create_success is invalid. Received: " + obj);
            case 40:
                if ("layout/channel_dialog_open_notification_0".equals(obj)) {
                    return new ChannelDialogOpenNotificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_open_notification is invalid. Received: " + obj);
            case 41:
                if ("layout/channel_dialog_publish_org_message_0".equals(obj)) {
                    return new ChannelDialogPublishOrgMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_publish_org_message is invalid. Received: " + obj);
            case 42:
                if ("layout/channel_dialog_select_chat_team_logo_0".equals(obj)) {
                    return new ChannelDialogSelectChatTeamLogoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_select_chat_team_logo is invalid. Received: " + obj);
            case 43:
                if ("layout/channel_dialog_topic_list_0".equals(obj)) {
                    return new ChannelDialogTopicListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_dialog_topic_list is invalid. Received: " + obj);
            case 44:
                if ("layout/channel_fragment_advertise_0".equals(obj)) {
                    return new ChannelFragmentAdvertiseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_advertise is invalid. Received: " + obj);
            case 45:
                if ("layout/channel_fragment_channel_main_organize_0".equals(obj)) {
                    return new ChannelFragmentChannelMainOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_channel_main_organize is invalid. Received: " + obj);
            case 46:
                if ("layout/channel_fragment_channel_main_topic_0".equals(obj)) {
                    return new ChannelFragmentChannelMainTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_channel_main_topic is invalid. Received: " + obj);
            case 47:
                if ("layout/channel_fragment_flash_message_0".equals(obj)) {
                    return new ChannelFragmentFlashMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_flash_message is invalid. Received: " + obj);
            case 48:
                if ("layout/channel_fragment_join_all_channel_0".equals(obj)) {
                    return new ChannelFragmentJoinAllChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_join_all_channel is invalid. Received: " + obj);
            case 49:
                if ("layout/channel_fragment_manage_admin_0".equals(obj)) {
                    return new ChannelFragmentManageAdminBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_admin is invalid. Received: " + obj);
            case 50:
                if ("layout/channel_fragment_manage_basic_info_0".equals(obj)) {
                    return new ChannelFragmentManageBasicInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_basic_info is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/channel_fragment_manage_chat_0".equals(obj)) {
                    return new ChannelFragmentManageChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_chat is invalid. Received: " + obj);
            case 52:
                if ("layout/channel_fragment_manage_share_setting_0".equals(obj)) {
                    return new ChannelFragmentManageShareSettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_share_setting is invalid. Received: " + obj);
            case 53:
                if ("layout/channel_fragment_manage_topic_0".equals(obj)) {
                    return new ChannelFragmentManageTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_topic is invalid. Received: " + obj);
            case 54:
                if ("layout/channel_fragment_manage_topic_chat_0".equals(obj)) {
                    return new ChannelFragmentManageTopicChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_manage_topic_chat is invalid. Received: " + obj);
            case 55:
                if ("layout/channel_fragment_my_channel_0".equals(obj)) {
                    return new ChannelFragmentMyChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_my_channel is invalid. Received: " + obj);
            case 56:
                if ("layout/channel_fragment_my_channel_communication_0".equals(obj)) {
                    return new ChannelFragmentMyChannelCommunicationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_my_channel_communication is invalid. Received: " + obj);
            case 57:
                if ("layout/channel_fragment_my_channel_organize_0".equals(obj)) {
                    return new ChannelFragmentMyChannelOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_my_channel_organize is invalid. Received: " + obj);
            case 58:
                if ("layout/channel_fragment_my_channel_topic_0".equals(obj)) {
                    return new ChannelFragmentMyChannelTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_my_channel_topic is invalid. Received: " + obj);
            case 59:
                if ("layout/channel_fragment_notify_comment_0".equals(obj)) {
                    return new ChannelFragmentNotifyCommentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_notify_comment is invalid. Received: " + obj);
            case 60:
                if ("layout/channel_fragment_notify_fans_menu_0".equals(obj)) {
                    return new ChannelFragmentNotifyFansMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_notify_fans_menu is invalid. Received: " + obj);
            case 61:
                if ("layout/channel_fragment_notify_like_0".equals(obj)) {
                    return new ChannelFragmentNotifyLikeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_notify_like is invalid. Received: " + obj);
            case 62:
                if ("layout/channel_fragment_notify_post_comment_0".equals(obj)) {
                    return new ChannelFragmentNotifyPostCommentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_notify_post_comment is invalid. Received: " + obj);
            case 63:
                if ("layout/channel_fragment_notify_post_like_0".equals(obj)) {
                    return new ChannelFragmentNotifyPostLikeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_fragment_notify_post_like is invalid. Received: " + obj);
            case 64:
                if ("layout/channel_item_add_friend_0".equals(obj)) {
                    return new ChannelItemAddFriendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_add_friend is invalid. Received: " + obj);
            case 65:
                if ("layout/channel_item_add_sub_admin_0".equals(obj)) {
                    return new ChannelItemAddSubAdminBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_add_sub_admin is invalid. Received: " + obj);
            case 66:
                if ("layout/channel_item_advertise_0".equals(obj)) {
                    return new ChannelItemAdvertiseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_advertise is invalid. Received: " + obj);
            case 67:
                if ("layout/channel_item_all_member_0".equals(obj)) {
                    return new ChannelItemAllMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_all_member is invalid. Received: " + obj);
            case 68:
                if ("layout/channel_item_all_topic_0".equals(obj)) {
                    return new ChannelItemAllTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_all_topic is invalid. Received: " + obj);
            case 69:
                if ("layout/channel_item_buddy_member_0".equals(obj)) {
                    return new ChannelItemBuddyMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_buddy_member is invalid. Received: " + obj);
            case 70:
                if ("layout/channel_item_channel_main_hot_organize_0".equals(obj)) {
                    return new ChannelItemChannelMainHotOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_channel_main_hot_organize is invalid. Received: " + obj);
            case 71:
                if ("layout/channel_item_channel_main_hot_topic_0".equals(obj)) {
                    return new ChannelItemChannelMainHotTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_channel_main_hot_topic is invalid. Received: " + obj);
            case 72:
                if ("layout/channel_item_channel_type_0".equals(obj)) {
                    return new ChannelItemChannelTypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_channel_type is invalid. Received: " + obj);
            case 73:
                if ("layout/channel_item_channel_type_preference_0".equals(obj)) {
                    return new ChannelItemChannelTypePreferenceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_channel_type_preference is invalid. Received: " + obj);
            case 74:
                if ("layout/channel_item_club_message_0".equals(obj)) {
                    return new ChannelItemClubMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_club_message is invalid. Received: " + obj);
            case 75:
                if ("layout/channel_item_flash_message_0".equals(obj)) {
                    return new ChannelItemFlashMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_flash_message is invalid. Received: " + obj);
            case 76:
                if ("layout/channel_item_flash_message_single_chat_0".equals(obj)) {
                    return new ChannelItemFlashMessageSingleChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_flash_message_single_chat is invalid. Received: " + obj);
            case 77:
                if ("layout/channel_item_friend_apply_0".equals(obj)) {
                    return new ChannelItemFriendApplyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_friend_apply is invalid. Received: " + obj);
            case 78:
                if ("layout/channel_item_friend_list_0".equals(obj)) {
                    return new ChannelItemFriendListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_friend_list is invalid. Received: " + obj);
            case 79:
                if ("layout/channel_item_friend_list_group_0".equals(obj)) {
                    return new ChannelItemFriendListGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_friend_list_group is invalid. Received: " + obj);
            case 80:
                if ("layout/channel_item_home_0".equals(obj)) {
                    return new ChannelItemHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_home is invalid. Received: " + obj);
            case 81:
                if ("layout/channel_item_join_all_channel_0".equals(obj)) {
                    return new ChannelItemJoinAllChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_join_all_channel is invalid. Received: " + obj);
            case 82:
                if ("layout/channel_item_join_channel_0".equals(obj)) {
                    return new ChannelItemJoinChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_join_channel is invalid. Received: " + obj);
            case 83:
                if ("layout/channel_item_manage_admin_sub_title_0".equals(obj)) {
                    return new ChannelItemManageAdminSubTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_admin_sub_title is invalid. Received: " + obj);
            case 84:
                if ("layout/channel_item_manage_admin_user_0".equals(obj)) {
                    return new ChannelItemManageAdminUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_admin_user is invalid. Received: " + obj);
            case 85:
                if ("layout/channel_item_manage_chat_team_0".equals(obj)) {
                    return new ChannelItemManageChatTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_chat_team is invalid. Received: " + obj);
            case 86:
                if ("layout/channel_item_manage_chat_team_group_0".equals(obj)) {
                    return new ChannelItemManageChatTeamGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_chat_team_group is invalid. Received: " + obj);
            case 87:
                if ("layout/channel_item_manage_topic_0".equals(obj)) {
                    return new ChannelItemManageTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_topic is invalid. Received: " + obj);
            case 88:
                if ("layout/channel_item_manage_topic_chat_0".equals(obj)) {
                    return new ChannelItemManageTopicChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_topic_chat is invalid. Received: " + obj);
            case 89:
                if ("layout/channel_item_manage_topic_chat_topic_0".equals(obj)) {
                    return new ChannelItemManageTopicChatTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_topic_chat_topic is invalid. Received: " + obj);
            case 90:
                if ("layout/channel_item_manage_topic_group_0".equals(obj)) {
                    return new ChannelItemManageTopicGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_manage_topic_group is invalid. Received: " + obj);
            case 91:
                if ("layout/channel_item_my_channel_chat_team_0".equals(obj)) {
                    return new ChannelItemMyChannelChatTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_chat_team is invalid. Received: " + obj);
            case 92:
                if ("layout/channel_item_my_channel_chat_team_group_0".equals(obj)) {
                    return new ChannelItemMyChannelChatTeamGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_chat_team_group is invalid. Received: " + obj);
            case 93:
                if ("layout/channel_item_my_channel_organize_0".equals(obj)) {
                    return new ChannelItemMyChannelOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_organize is invalid. Received: " + obj);
            case 94:
                if ("layout/channel_item_my_channel_organize_chat_0".equals(obj)) {
                    return new ChannelItemMyChannelOrganizeChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_organize_chat is invalid. Received: " + obj);
            case 95:
                if ("layout/channel_item_my_channel_topic_0".equals(obj)) {
                    return new ChannelItemMyChannelTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_topic is invalid. Received: " + obj);
            case 96:
                if ("layout/channel_item_my_channel_topic_chat_0".equals(obj)) {
                    return new ChannelItemMyChannelTopicChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_topic_chat is invalid. Received: " + obj);
            case 97:
                if ("layout/channel_item_my_channel_topic_group_0".equals(obj)) {
                    return new ChannelItemMyChannelTopicGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_channel_topic_group is invalid. Received: " + obj);
            case 98:
                if ("layout/channel_item_my_organize_0".equals(obj)) {
                    return new ChannelItemMyOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_my_organize is invalid. Received: " + obj);
            case 99:
                if ("layout/channel_item_notify_0".equals(obj)) {
                    return new ChannelItemNotifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_notify is invalid. Received: " + obj);
            case 100:
                if ("layout/channel_item_notify_fans_0".equals(obj)) {
                    return new ChannelItemNotifyFansBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_notify_fans is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 101:
                if ("layout/channel_item_notify_favorites_0".equals(obj)) {
                    return new ChannelItemNotifyFavoritesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_notify_favorites is invalid. Received: " + obj);
            case 102:
                if ("layout/channel_item_notify_mailbox_0".equals(obj)) {
                    return new ChannelItemNotifyMailboxBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_notify_mailbox is invalid. Received: " + obj);
            case 103:
                if ("layout/channel_item_organize_0".equals(obj)) {
                    return new ChannelItemOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_organize is invalid. Received: " + obj);
            case 104:
                if ("layout/channel_item_organize_member_0".equals(obj)) {
                    return new ChannelItemOrganizeMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_organize_member is invalid. Received: " + obj);
            case 105:
                if ("layout/channel_item_organize_member_channel_0".equals(obj)) {
                    return new ChannelItemOrganizeMemberChannelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_organize_member_channel is invalid. Received: " + obj);
            case 106:
                if ("layout/channel_item_organize_message_0".equals(obj)) {
                    return new ChannelItemOrganizeMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_organize_message is invalid. Received: " + obj);
            case 107:
                if ("layout/channel_item_organize_team_0".equals(obj)) {
                    return new ChannelItemOrganizeTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_organize_team is invalid. Received: " + obj);
            case 108:
                if ("layout/channel_item_publish_org_messsage_club_0".equals(obj)) {
                    return new ChannelItemPublishOrgMesssageClubBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_publish_org_messsage_club is invalid. Received: " + obj);
            case 109:
                if ("layout/channel_item_select_chat_team_logo_0".equals(obj)) {
                    return new ChannelItemSelectChatTeamLogoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_select_chat_team_logo is invalid. Received: " + obj);
            case 110:
                if ("layout/channel_item_team_member_manage_0".equals(obj)) {
                    return new ChannelItemTeamMemberManageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_team_member_manage is invalid. Received: " + obj);
            case 111:
                if ("layout/channel_item_topic_list_0".equals(obj)) {
                    return new ChannelItemTopicListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_item_topic_list is invalid. Received: " + obj);
            case 112:
                if ("layout/channel_layout_channel_main_header_0".equals(obj)) {
                    return new ChannelLayoutChannelMainHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_layout_channel_main_header is invalid. Received: " + obj);
            case 113:
                if ("layout/channel_layout_my_channel_header_0".equals(obj)) {
                    return new ChannelLayoutMyChannelHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_layout_my_channel_header is invalid. Received: " + obj);
            case 114:
                if ("layout/channel_view_channel_main_hot_organize_0".equals(obj)) {
                    return new ChannelViewChannelMainHotOrganizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_view_channel_main_hot_organize is invalid. Received: " + obj);
            case 115:
                if ("layout/channel_view_channel_main_hot_topic_0".equals(obj)) {
                    return new ChannelViewChannelMainHotTopicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_view_channel_main_hot_topic is invalid. Received: " + obj);
            case 116:
                if ("layout/channel_view_organize_detail_header_0".equals(obj)) {
                    return new ChannelViewOrganizeDetailHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_view_organize_detail_header is invalid. Received: " + obj);
            case 117:
                if ("layout/channel_view_topic_main_header_0".equals(obj)) {
                    return new ChannelViewTopicMainHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for channel_view_topic_main_header is invalid. Received: " + obj);
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
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f33007a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f7360a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i4 = (i3 - 1) / 50;
        if (i4 == 0) {
            return a(dataBindingComponent, view, i3, tag);
        }
        if (i4 == 1) {
            return b(dataBindingComponent, view, i3, tag);
        }
        if (i4 != 2) {
            return null;
        }
        return c(dataBindingComponent, view, i3, tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f33008a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f7360a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
