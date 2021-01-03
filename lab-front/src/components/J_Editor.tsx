import React from "react";
import AceEditor from "react-ace";

import 'ace-builds/src-noconflict/mode-sql'; // sql模式的包
import 'ace-builds/src-noconflict/mode-mysql';// mysql模式的包
import 'ace-builds/src-noconflict/theme-eclipse';// eclipse的主题样式

import "ace-builds/src-noconflict/mode-java";
import 'ace-builds/src-noconflict/ext-language_tools';

class J_Editor extends React.Component<any, any>{
  constructor(props: any) {
    super(props);
  }

  render() {
    return (
      <AceEditor
        mode='mysql'
        theme="eclipse"
        name="app_code_editor"
        fontSize={14}
        showPrintMargin
        showGutter
        onChange={value => {
          console.log(value); // 输出代码编辑器内值改变后的值
        }}
        value={this.props.data}
        wrapEnabled
        highlightActiveLine  //突出活动线
        enableSnippets  //启用代码段
        style={{ width: '100%', height: '100%' }}
        setOptions={{
          enableBasicAutocompletion: true,   //启用基本自动完成功能
          enableLiveAutocompletion: true,   //启用实时自动完成功能 （比如：智能代码提示）
          enableSnippets: true,  //启用代码段
          showLineNumbers: true,
          tabSize: 2,
        }}
      />
    )
  }
}

export default J_Editor;