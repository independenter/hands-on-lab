import React, {Component} from 'react'
import J_Editor from "./J_Editor";
import "../util/HttpUtil";
import HttpUtil from "../util/HttpUtil";
import X_Term from "./X_Term";

class CoreMain extends Component<any, any>{

  constructor(props: any) {
    super(props);
    this.state = {
      data: "",
      doc: "  <h2>教程说明</h2>\n" +
        "  <p>通过本教程，你将会：</p>\n" +
        "  <ul>\n" +
        "   <li>使用 spring cloud alibaba 搭建一个最小化的微服务集群。</li>\n" +
        "   <li>并完成客户端和服务端之间的调用示例。</li>\n" +
        "   <li>学习任务管理器的关键调用链路。</li>\n" +
        "  </ul>\n" +
        "  <p>本教程整体体验时间预计在15分钟左右；</p>"
    }
  }

  componentDidMount() {
    HttpUtil.request({
      url: "/file",
      success: data => {
        this.setState({
          data: data
        })
      }
    })
  }

  render() {
    return (
      <div className={"ant-row main"} style={{flexFlow: "nowrap", height: "auto", minHeight: "calc(100% - 57px)"}}>
        <div className="ant-col content-container" style={{maxWidth: "inherit", flexGrow: 1}}>
          <div id={"app"} style={{border: "1px solid red",width: "100%",height: "100%"}}>
            <div id={"J_Editor"}>
              <J_Editor data={this.state.data}/>
            </div>
            {/*root@106.12.122.179 -p donghui@1*/}
            <div id={"xterm"}>
              <X_Term />
            </div>
            <div id={"doc"} className={"tutorial-panel"} style={{width: "350px"}}>
              <div dangerouslySetInnerHTML = {{ __html:this.state.doc }}></div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CoreMain