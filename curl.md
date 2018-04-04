1. curl www.baidu.com

2. -i 请求的时候同时添加头信息
curl -i www.baidu.com

3. -H 添加头信息 -d post请求 --data-urlencode 编码
curl -H 'Content-Type: application/json' -d '{"id":1}'

4. -XPUT 指定请求的方式

5. -F 指定上传文件
