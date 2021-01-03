import React,{Component} from "react";
import LabItem from "./LabItem";
import HttpUtil from "../util/HttpUtil";

class LabTable extends Component<any, any>{
  constructor(props: any) {
    super(props);
    this.state = {
      items: []
    };
  }

  componentDidMount() {
    HttpUtil.request({
      url: '/lab',
      success: data => {
        let items = data.map((item: any,index: number) => {
          return <LabItem key={index} title={item.title} difficulty={item.difficulty} time={item.time}
                          desc={item.description} href={item.href} open={item.open}/>
        })
        this.setState({
          items: items
        })
      }
    })
  }

  render() {
    return (
      <div className={"row"} style={{ flexWrap:'wrap' }}>
        {this.state.items}
      </div>
    );
  }
}

export default LabTable