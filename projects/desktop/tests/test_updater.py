"""启动检查更新：版本解析与 GitHub 响应处理（不发真实网络请求）"""
import io
import json
import unittest
from unittest import mock

from shandong_school_cracked import updater


class _Resp(io.BytesIO):
    def __enter__(self):
        return self

    def __exit__(self, *args):
        return False


class UpdaterTest(unittest.TestCase):
    def test_version_tuple(self):
        self.assertEqual(updater.version_tuple("v1.4.0"), (1, 4, 0))
        self.assertEqual(updater.version_tuple("1.3"), (1, 3, 0))
        self.assertEqual(updater.version_tuple(""), (0, 0, 0))

    def test_has_update(self):
        payload = {"tag_name": "v9.9.9", "html_url": "https://example.com/r",
                   "body": "更新内容"}
        with mock.patch.object(updater.urllib.request, "urlopen", return_value=_Resp(json.dumps(payload).encode())):
            r = updater.check_update()
        self.assertTrue(r["ok"])
        self.assertEqual(r["latest"], "9.9.9")
        self.assertTrue(r["has_update"])

    def test_same_version(self):
        cur = updater.current_version()
        payload = {"tag_name": "v" + cur, "html_url": "https://example.com/r", "body": ""}
        with mock.patch.object(updater.urllib.request, "urlopen", return_value=_Resp(json.dumps(payload).encode())):
            r = updater.check_update()
        self.assertTrue(r["ok"])
        self.assertFalse(r["has_update"])

    def test_network_error_is_silent(self):
        with mock.patch.object(updater.urllib.request, "urlopen", side_effect=OSError("offline")):
            r = updater.check_update()
        self.assertFalse(r["ok"])
        self.assertFalse(r["has_update"])
        self.assertIn("offline", r["error"])


if __name__ == "__main__":
    unittest.main()
