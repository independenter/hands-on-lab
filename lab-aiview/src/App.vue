<template>
  <div id="app" className="app-box">Hello</div>
</template>

<script>
import {
  Terminal
} from 'xterm'
import 'xterm/css/xterm.css'

export default {
  name: 'app',
  mounted () {
    const term = new Terminal({
      rendererType: 'canvas', // 渲染类型
      rows: 40, // 行数
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
    })
    term.open(document.getElementById('app'))

    function runFakeTerminal () {
      if (term._initialized) {
        return
      }

      term._initialized = true

      term.prompt = () => {
        term.write('\r\ndobbdemacPro$ ')
      }

      term.writeln('Welcome to xterm.js')
      term.writeln('This is a local terminal emulation, without a real terminal in the back-end.')
      term.writeln('Type some keys and commands to play around.')
      term.writeln('')
      term.prompt()

      term.onKey(e => {
        console.log(e)
        const ev = e.domEvent
        const printable = !ev.altKey && !ev.altGraphKey && !ev.ctrlKey && !ev.metaKey
        if (ev.keyCode === 13) {
          term.prompt()
        } else if (ev.keyCode === 8) {
          // Do not delete the prompt
          if (term._core.buffer.x > 2) {
            term.write('\b \b')
          }
        } else if (printable) {
          term.write(e.key)
        }
      })
    }

    runFakeTerminal()
  }

}

</script>

<style lang="css">
html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  overflow: hidden;
}
</style>
