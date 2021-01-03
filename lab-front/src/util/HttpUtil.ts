interface IRequest{
  method?: string,
  headers?: HeadersInit,
  mode?: RequestMode,
  cache?: RequestCache,
  url: string,
  success?: (data: any) => void;
  error?: (error: any) => void;
  complete?: () => void;
}

class HttpUtil{
  public static  printLog(){
    console.log("打印日志")
  }

  public static request(request: IRequest){
    return fetch(request.url, {
      method: request.method || "GET",
      headers: request.headers || {
        'Content-Type':'application/json;charset=UTF-8'
      },
      mode: request.mode || 'cors',
      cache: request.cache || 'default'
    }).then(res => res.json())
      .then((res: any) => {
        if(res.code === 0) {
          if (request.success){
            request.success(res.data)
          }
        }else{
          alert(res.message || "操作失败")
        }
      }).catch((error: any) => {
        if(request.error){
          request.error (error)
        }
      });
  }
}

export default HttpUtil;