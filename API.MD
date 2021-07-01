# javademo api
---
  - ## 用户api
  ---
  ```
  user:{
    id: number          //主键
    username: 用户名
    password: String
    phone: String
    status: Boolean     //为0/1
  }
  ```
  - ### 登录 /servlet
  - 约定code为200为登录成功,404为登录失败
  ```
  request{
    method:"Login"   //注意大小写
    username: String,
    password: String
  }
  response{
    code: 200
    message: string
    data: user
  }
  ```
  - ### 注册 /servlet
  - 约定code为200为登录成功,404为登录失败
  ```
  request{
    method:"Sign up"   //注意大小写
    username: String,
    password: String
  }
  response{
    code: 200
    message: string
    data: user
  }
  ```
  ---
  ## 学生api
  增删改查待定