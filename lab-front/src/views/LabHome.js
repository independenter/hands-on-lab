import LabTitle from '../components/LabTitle.tsx'
import LabLine from "../components/LabLine";
import LabTable from "../components/LabTable";
import React from "react";

function LabHome(){
  return (
    <div className={"page"}>
      <div className={"box"}>
        <LabTitle/>
        <LabLine/>
        <LabTable/>
      </div>
    </div>
  )
}

export default LabHome