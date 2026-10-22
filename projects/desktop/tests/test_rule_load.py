# -*- coding: utf-8 -*-
"""学校规则拉取：prepare / 刷新 / 失败回退

重点覆盖“拉取配置后规则看起来没变”的两个根因：
  · 响应失败或没有 schoolRule 时，不能用 RuleSet 默认值静默覆盖旧规则；
  · 规则卡需要 rule_loaded_at / rule_source 才能证明“这次到底拉没拉到”。
整条链路走本地 Mock 服务端，不碰真实网络。
"""
import shutil
import tempfile
import unittest
from pathlib import Path

from shandong_school_cracked.app import App


class 规则拉取测试(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-rule-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.app.login("13800138000", "any-password", False)
        cls.app.run_prepare()

    @classmethod
    def tearDownClass(cls):
        try:
            cls.app.close()
        finally:
            shutil.rmtree(cls.tmp, ignore_errors=True)

    def test_prepare后规则带更新时间与来源(self):
        st = self.app.status()
        self.assertGreater(int(st["rule_loaded_at"]), 0)
        self.assertIn(st["rule_source"], ("run/checkSunRunConfig",
                                          "run/querySunRunAbstractInfoV2"))
        # mock 的 SchoolRule 带 dayMaxDistance，应该被解析进 rule
        self.assertGreater(float(st["rule"]["dayMaxDistance"]), 0)

    def test_刷新规则接口返回最新规则(self):
        r = self.app.reload_rule()
        self.assertEqual(r["code"], 0)
        self.assertIn("rule", r["data"])
        self.assertGreater(int(r["data"]["rule_loaded_at"]), 0)

    def test_拉取失败不会把规则重置成默认值(self):
        c = self.app.client
        before = c.rule.to_dict()
        orig = c.transport.post

        def fake(name, payload=None, **kw):
            if name == "sunrun_config":
                return {"code": -1, "message": "模拟失败", "data": None}
            return orig(name, payload, **kw)

        c.transport.post = fake
        try:
            c.load_rule()
        finally:
            c.transport.post = orig
        self.assertEqual(c.rule.to_dict(), before)

    def test_响应没有schoolRule时保留旧规则(self):
        c = self.app.client
        before = c.rule.to_dict()
        orig = c.transport.post

        def fake(name, payload=None, **kw):
            if name == "sunrun_config":
                return {"code": 0, "message": "成功", "data": {"fenceCode": "X"}}
            if name == "sunrun_abstract":
                # 真实服务端在这种情况下也没规则：两个来源都空才应保留旧规则
                return {"code": 0, "message": "成功", "data": {}}
            return orig(name, payload, **kw)

        c.transport.post = fake
        try:
            c.load_rule()
        finally:
            c.transport.post = orig
        self.assertEqual(c.rule.to_dict(), before)

    def test_直接返回规则本体也能解析(self):
        c = self.app.client
        orig_rule = c.rule
        orig = c.transport.post

        def fake(name, payload=None, **kw):
            if name == "sunrun_config":
                return {"code": 0, "message": "成功", "data": {
                    "singleMinDistance": 1500, "singleMaxDistance": 5000,
                    "minPace": 200, "maxPace": 500, "dayMaxDistance": 3000,
                }}
            return orig(name, payload, **kw)

        c.transport.post = fake
        try:
            c.load_rule()
        finally:
            c.transport.post = orig
        self.assertEqual(c.rule.single_min_distance, 1500)
        self.assertEqual(c.rule.day_max_distance, 3000)
        self.assertEqual(c.rule.min_pace, 200)
        c.rule = orig_rule      # 恢复，避免污染同类里的其它用例


if __name__ == "__main__":
    unittest.main(verbosity=2)
