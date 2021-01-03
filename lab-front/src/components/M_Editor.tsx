import React from 'react';
import MonacoEditor from 'react-monaco-editor';

class M_Editor extends React.Component<any,any> {
  constructor(props: any) {
    super(props);
  }

  editorWillMount(monaco: any) {
    console.log(monaco)
    monaco.languages.json.jsonDefaults.setDiagnosticsOptions({
      validate: true,
      schemas: [{
        uri: "http:/foo-schema.json",
        fileMatch: ['*'],
        schema: {
          type: "object",
          properties: {
            p1: {
              enum: [ "v1", "v2"]
            },
            p2: {
              $ref: "http://myserver/bar-schema.json"
            }
          }
        }
      }]
    });
  }

  render() {
    return (
      <MonacoEditor language="json" editorWillMount={this.editorWillMount} />
    );
  }
}

export default M_Editor;