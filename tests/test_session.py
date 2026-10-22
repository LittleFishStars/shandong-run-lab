# -*- coding: utf-8 -*-
"""登录态持久化：进程退出不清 token，只有显式「退出登录」才清

原版把 token 存在 SharedPreferences 里，启动直接读；本项目存在本地库 kv
（按模式分键：真实 session / Mock session_mock），这组用例守住的正是
「关掉再开不用重新登录」这条链路。
"""
import tempfile
import time
import unittest
from pathlib import Path

from shandong_school_cracked.app import App
from shandong_school_cracked.constants import CODE_NEED_LOGIN


class 登录持久化测试(unittest.TestCase):
    def setUp(self):
        self.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-sess-"))
        self.cfg = self.tmp / "config.json"
        self.app = App(data_dir=self.tmp, config_path=self.cfg, mode="mock")

    def tearDown(self):
        try:
            self.app.close()
        except Exception:
            pass

    def _login(self):
        r = self.app.login("13800138000", "pw", False)
        self.assertEqual(r.get("code"), 0, r)
        return self.app.client.transport.token, str(self.app.client.user.get("userId"))

    def test_关闭应用保留会话(self):
        token, uid = self._login()
        self.assertTrue(uid)
        key = self.app.client.kv_token_key
        self.app.close()
        s = self.app.store.kv_get(key)
        self.assertIsInstance(s, dict)
        self.assertEqual(s.get("token"), token)
        self.assertEqual(s.get("userId"), uid)

    def test_重开自动恢复会话(self):
        token, uid = self._login()
        login_at = self.app.client.user.get("loginAt")
        self.app.close()

        app2 = App(data_dir=self.tmp, config_path=self.cfg, mode="mock")
        try:
            self.assertTrue(app2.client.logged_in)
            self.assertEqual(app2.client.transport.token, token)
            self.assertEqual(app2.client.transport.user_id, uid)
            self.assertEqual(app2.client.user.get("loginAt"), login_at)
            # 用户信息也能补回来（mock 的 queryCommonUserInfo）
            self.assertTrue(app2.client.user.get("userName"))
        finally:
            app2.close()

    def test_显式退出登录才清会话(self):
        self._login()
        self.app.logout()
        self.assertFalse(self.app.client.logged_in)
        self.assertFalse(self.app.client.transport.token)
        self.assertIsNone(self.app.store.kv_get(self.app.client.kv_token_key))

        app3 = App(data_dir=self.tmp, config_path=self.cfg, mode="mock")
        try:
            self.assertFalse(app3.client.logged_in)
        finally:
            app3.close()

    def test_刷新用户信息不改登录时间(self):
        token, _uid = self._login()
        at = self.app.client.user.get("loginAt")
        r = self.app.client.load_user()
        self.assertEqual(r.get("code"), 0, r)
        s = self.app.store.kv_get(self.app.client.kv_token_key)
        self.assertEqual(s.get("loginAt"), at)       # 登录时间只由登录动作改
        self.assertEqual(s.get("token"), token)      # token 不被刷新冲掉
        self.assertEqual(s.get("userName"), self.app.client.user.get("userName"))

    def test_过期会话才被清掉(self):
        self._login()
        self.app.close()

        app2 = App(data_dir=self.tmp, config_path=self.cfg, mode="mock")
        try:
            time.sleep(0.8)                     # 等构造时那次真实校验先跑完
            app2.client.load_user = lambda: {"code": CODE_NEED_LOGIN}
            app2._restore_session_bg()
            for _ in range(60):                 # 线程异步，轮询最多 3 秒
                if not app2.client.logged_in:
                    break
                time.sleep(0.05)
            self.assertFalse(app2.client.logged_in)
            self.assertFalse(app2.client.transport.token)
            self.assertIsNone(app2.store.kv_get(app2.client.kv_token_key))
        finally:
            app2.close()

    def _login_as(self, phone):
        r = self.app.login(phone, "pw", False)
        self.assertEqual(r.get("code"), 0, r)
        return str(self.app.client.user.get("userId")), self.app.client.transport.token

    def test_多账号登记与切换(self):
        uid1, token1 = self._login_as("13800138001")
        uid2, token2 = self._login_as("13800138002")
        self.assertNotEqual(uid1, uid2)
        lst = self.app.list_accounts()
        self.assertEqual(len(lst), 2)
        self.assertEqual(lst[0]["userId"], uid2)        # 最近登录的在前
        self.assertTrue(lst[0]["current"])
        self.assertIn("****", lst[0]["loginName"])     # 手机号脱敏

        r = self.app.switch_account(uid1)              # 不重新输密码
        self.assertEqual(r.get("code"), 0, r)
        self.assertEqual(self.app.client.transport.token, token1)
        self.assertEqual(str(self.app.client.user.get("userId")), uid1)

        # 历史账号落库：新进程也能看到、能选（Mock 服务端每次重启，旧 token 不认；
        # 真实服务端 token 是持久的，切换由同进程用例覆盖）
        self.app.close()
        app2 = App(data_dir=self.tmp, config_path=self.cfg, mode="mock")
        try:
            ids = [a["userId"] for a in app2.list_accounts()]
            self.assertIn(uid1, ids)
            self.assertIn(uid2, ids)
        finally:
            app2.close()

    def test_移除账号(self):
        uid1, _ = self._login_as("13800138003")
        uid2, _ = self._login_as("13800138004")
        self.app.forget_account(uid1)
        self.assertEqual([a["userId"] for a in self.app.list_accounts()], [uid2])
        # 移除当前账号 = 顺带退出登录
        self.app.forget_account(uid2)
        self.assertFalse(self.app.client.logged_in)
        self.assertEqual(self.app.list_accounts(), [])


if __name__ == "__main__":
    unittest.main()
