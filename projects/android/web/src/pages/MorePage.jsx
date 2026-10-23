import React from 'react';
import { Button, Select, Input, InputNumber, Checkbox, Typography } from '../ui';

const { Text } = Typography;

/* 更多页：参数编辑 + 事件流 + 调试区（覆盖 §2 无 UI 方法） */
export default function MorePage({ status, params, log, actions }) {
  return (
    <div className="more-page">
      <div className="more-head">
        <h1>更多</h1>
        <Button onClick={actions.back}>返回</Button>
      </div>
      <div className="more-scroll">
        {/* 跑步参数 */}
        <div className="more-card">
          <div className="more-card-title">跑步参数</div>
          <div className="param-grid">
            <div className="field">
              <span>运行模式</span>
              <Select
                value={params.mode}
                onChange={actions.setMode}
                options={[
                  { value: 'real', label: '真实服务端' },
                  { value: 'mock', label: '本地 Mock' },
                ]}
              />
            </div>
            <div className="field">
              <span>围栏</span>
              <Select
                value={params.fence}
                onChange={actions.setFence}
                options={((status && status.fences) || []).map((f, i) => ({
                  value: i, label: f.fenceName || f.fenceCode || `围栏 ${i + 1}`,
                }))}
              />
            </div>
            <div className="field">
              <span>平均步频（步/分）</span>
              <InputNumber min={120} max={240} value={params.cadAvg}
                onChange={(v) => actions.setParam('cadAvg', v || 177)} style={{ width: '100%' }} />
            </div>
            <div className="field">
              <span>波动（± 步/分）</span>
              <InputNumber min={0} max={30} value={params.cadVar}
                onChange={(v) => actions.setParam('cadVar', v || 0)} style={{ width: '100%' }} />
            </div>
            <div className="field">
              <span>步幅（米）</span>
              <InputNumber min={0.1} step={0.01} value={params.stride}
                onChange={(v) => actions.setParam('stride', v || 0.85)} style={{ width: '100%' }} />
            </div>
            <div className="field">
              <span>配速（分'秒"/公里）</span>
              <Input value={params.pace} onChange={(e) => actions.setParam('pace', e.target.value)} />
            </div>
          </div>
          <Checkbox checked={params.autoSettle} onChange={(e) => actions.setParam('autoSettle', e.target.checked)}>
            到达目标自动结算
          </Checkbox>
          <div className="row">
            <Button type="primary" size="small" onClick={actions.saveParams}>保存参数</Button>
            <Button size="small" onClick={actions.resetDevice}>换 deviceId</Button>
          </div>
        </div>

        {/* 事件流 */}
        <div className="more-card">
          <div className="more-card-title">
            <span>事件流</span>
            <Button size="small" onClick={actions.clearLog}>清屏</Button>
          </div>
          <div className="log">
            {log.map((e) => (
              <div className={`line k-${e.kind || 'log'} lv-${e.level || 'info'}`} key={e.key}>
                <span className="t">{e.time}</span>
                <span className="m">{e.message}</span>
              </div>
            ))}
          </div>
        </div>

        {/* 调试区：覆盖 §2 无 UI 方法 */}
        <div className="more-card">
          <div className="more-card-title">调试区</div>
          <div className="debug-grid">
            <Button size="small" onClick={actions.debug.ping}>桥 ping</Button>
            <Button size="small" onClick={actions.debug.walkPlan}>规划自检</Button>
            <Button size="small" onClick={actions.debug.eventsFetch}>事件拉取</Button>
            <Button size="small" onClick={actions.debug.mockInfo}>Mock 信息</Button>
            <Button size="small" onClick={actions.debug.listAccounts}>账号列表</Button>
            <Button size="small" onClick={actions.debug.listRuns}>本地记录</Button>
            <Button size="small" onClick={actions.debug.runDetail}>记录详情</Button>
            <Button size="small" onClick={actions.debug.exportRun}>导出 JSON</Button>
            <Button size="small" onClick={actions.debug.deleteRun}>删除记录</Button>
            <Button size="small" onClick={actions.debug.uiReport}>上报布局</Button>
            <Button size="small" onClick={actions.debug.getConfig}>读取配置</Button>
            <Button size="small" onClick={actions.debug.toast}>测试 Toast</Button>
            <Button size="small" onClick={actions.debug.quit}>退出</Button>
          </div>
        </div>
      </div>
    </div>
  );
}