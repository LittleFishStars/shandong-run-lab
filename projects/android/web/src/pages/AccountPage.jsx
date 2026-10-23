import React, { useEffect } from 'react';
import { Button, Typography } from '../ui';
import { List } from '../ui';
import RecordCard from '../RecordCard';

const { Text } = Typography;

/* 账户页：头像/昵称/退出 + 跑步记录列表（RecordCard 复用桌面版） */
export default function AccountPage({ status, runs, actions }) {
  const user = (status && status.user) || {};
  // 昵称优先（服务端下发的 nickName），其次登录手机号；加密的 userName 不直接当昵称用
  const nick = user.nickName || user._account_name || user.loginName
    || (/^[A-Za-z0-9+/=]{12,}$/.test(String(user.userName || '')) ? '' : user.userName)
    || '未登录';
  const avatar = user.avatar || user.defaultAvatar || 'assets/app-icon.png';

  useEffect(() => {
    if (actions.refreshUser) actions.refreshUser();   // 拉一次昵称/头像（服务端 queryCommonUserInfo）
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
          <Button type="primary" className="account-logout" onClick={actions.logout}>退出登录</Button>
        </aside>
        <section className="account-main">
          <div className="account-main-head">
            <h2>跑步记录</h2>
            {(() => {
              const doneKm = (Number(status && status.done_distance) || 0) / 1000;
              const totalKm = (Number(status && status.rule && status.rule.totalDistance) || 0) / 1000;
              if (!totalKm) return null;
              const fmt = (v) => (Number.isInteger(v) ? String(v) : v.toFixed(1));
              return (
                <span className="account-progress">
                  已完成 {fmt(doneKm)} km / 要求 {fmt(totalKm)} km
                </span>
              );
            })()}
          </div>
          {runs.error ? (
            <Text type="secondary">{runs.error}</Text>
          ) : runs.items.length ? (
            <List
              className="account-runs"
              dataSource={runs.items}
              renderItem={(item) => (
                <List.Item className="rec-item">
                  <RecordCard item={item} />
                </List.Item>
              )}
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