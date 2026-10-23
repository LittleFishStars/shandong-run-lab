import React, { useEffect } from 'react';
import { Button, List, Typography } from 'antd';
import RecordCard from '../RecordCard';

const { Text } = Typography;

export default function AccountPage({ status, runs, actions }) {
  const user = (status && status.user) || {};
  // 昵称优先（服务端下发的 nickName），其次登录手机号；加密的 userName 不直接当昵称用
  const nick = user.nickName || user._account_name || user.loginName
    || (/^[A-Za-z0-9+/=]{12,}$/.test(String(user.userName || '')) ? '' : user.userName)
    || '未登录';
  const avatar = user.avatar || user.defaultAvatar || 'assets/app-icon.png';
  useEffect(() => {
    if (actions.refreshUser) actions.refreshUser();   // 拉一次昵称/头像（服务端 queryCommonUserInfo）
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <div className="account-page">
      <div className="account-head">
        <span className="account-title">账户</span>
        <Button onClick={actions.back}>返回</Button>
      </div>
      <div className="account-body">
        <aside className="account-side">
          <img
            className="account-avatar"
            src={avatar}
            alt="头像"
            onError={(e) => { e.currentTarget.src = 'assets/app-icon.png'; }}
          />
          <div className="account-name">{nick}</div>
          <Button danger type="primary" className="account-logout" onClick={actions.logout}>退出登录</Button>
        </aside>
        <section className="account-main">
          <h2>跑步记录</h2>
          {runs.error ? (
            <Text type="secondary">{runs.error}</Text>
          ) : runs.items.length ? (
            <List
              className="account-runs"
              dataSource={runs.items}
              renderItem={(item) => <List.Item className="rec-item"><RecordCard item={item} /></List.Item>}
            />
          ) : (
            <div className="account-empty">
              <Text type="secondary">
                {status && status.logged_in ? '服务器上暂无跑步记录' : '登录后才会显示跑步记录'}
              </Text>
            </div>
          )}
        </section>
      </div>
    </div>
  );
}
