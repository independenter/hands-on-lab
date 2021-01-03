import { Terminal } from "xterm"
import "xterm/css/xterm.css"
import * as React from 'react'

class X_Term extends React.Component<any, any>{
  private terminal: Terminal = new Terminal({
    rendererType: 'canvas', // 渲染类型
    rows: 7, // 行数
    convertEol: true, // 启用时，光标将设置为下一行的开头
    scrollback: 10, // 终端中的回滚量
    disableStdin: false, // 是否应禁用输入。
    cursorStyle: 'underline', // 光标样式
    cursorBlink: true, // 光标闪烁
    theme: {
      foreground: 'yellow', // 字体
      background: '#060101', // 背景色
      cursor: 'help' // 设置光标
    }
  });
  private _xterm!: HTMLDivElement | null;
  constructor(props: any) {
    super(props);
  }

  componentDidMount() {
    this.terminal.open(this._xterm!)

    this.terminal.write("Welcome to xterm.js")
  }

  render() {
    return (
      <div className={"hello"} ref={xterm => this._xterm = xterm}>

      </div>
    );
  }
}

export default X_Term