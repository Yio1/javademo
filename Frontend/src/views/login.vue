<template>
  <div class="main">
    <div class="table">
      <img
        :src="avatar"
        alt="头像"
        :class="[isLogin ? 'show' : 'hide', 'avatar']"
      />
      <h2 class="title">{{ status }}</h2>
      <el-form
        :model="studentData"
        ref="loginForm"
        label-position="left"
        label-width="40px"
        :rules="rules"
      >
        <el-form-item
          ref="idLabel"
          :class="[idLabel ? 'up' : 'row']"
          prop="id"
          label="账号"
          label-width="50px"
        >
          <el-input
            @blur="blur('id')"
            @focus="focus('id')"
            class="input"
            v-model="studentData.id"
          ></el-input>
        </el-form-item>

        <el-form-item
          ref="pwLabel"
          :class="[pwLabel ? 'up' : 'row']"
          prop="password"
          label="密码"
          label-width="50px"
        >
          <el-input
            @blur="blur('pw')"
            @focus="focus('pw')"
            class="input"
            v-model="studentData.password"
            show-password
          ></el-input>
        </el-form-item>

        <div :class="[isLogin ? 'hide' : 'show', 'sign-up']">
          <el-form-item ref="pwLabel" prop="phone" label-width="50px">
            <el-input
              placeholder="请输入电话号码"
              class="input"
              v-model="studentData.phone"
              show-password
            ></el-input>
          </el-form-item>

          <el-form-item ref="pwLabel" prop="status" label-width="50px">
            <el-input
              placeholder="请输入状态"
              class="input"
              v-model="studentData.status"
              show-password
            ></el-input>
          </el-form-item>
        </div>

        <el-button
          class="btn-login"
          type="primary"
          plain
          @click="login"
          :loading="loading"
          >登录</el-button
        >
        <el-button class="btn-login" type="primary" plain @click="SignUp"
          >注册</el-button
        >
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      studentData: {
        id: "",
        password: "",
      },
      loading: false,
      avatar: require("../assets/undraw_male_avatar_323b.png"),
      rules: {
        id: [{ required: true, message: " 请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
      idUp: "",
      pwUp: "",
      isLogin: true,
      status: "login",
    };
  },
  computed: {
    idLabel: function() {
      return this.studentData.id + this.idUp;
    },
    pwLabel: function() {
      return this.studentData.password + this.pwUp;
    },
  },
  methods: {
    login: function() {
      this.loading = true;
      // console.log(this.$refs.loginForm);
      this.$refs.loginForm.validate((res, faild) => {
        if (res) {
          this.$axios
            .get("/reg", {
              params: {
                username: this.studentData.id,
                password: this.studentData.password,
              },
            })
            .then((res) => {
              if (res.data) {
                this.$message({
                  message: "登录成功",
                  type: "success",
                });
                console.log(res);
                this.loading = false;
              } else {
                this.$message({
                  message: "登录失败",
                  type: "error",
                });
                console.log(res);
                this.loading = false;
              }
            });
        }
        console.log(faild); //错误的内容
      });
    },
    SignUp: function() {
      // this.$router.replace("/SignUp");
      this.isLogin = !this.isLogin;
      this.status = this.status == "Sign up" ? "Login" : "Sign up";
    },
    focus: function(data) {
      if (data == "id") {
        this.idUp = true;
      } else if (data == "pw") {
        this.pwUp = true;
      }
    },
    blur: function(data) {
      if (data == "id") {
        this.idUp = "";
      } else if (data == "pw") {
        this.pwUp = "";
      }
    },
  },
};
</script>

<style scoped>
.input >>> .el-input__inner:-webkit-autofill {
  transition-delay: 99999s;
  transition: color 99999s ease-out, background-color 99999s ease-out;
}
.row >>> .el-form-item__label {
  pointer-events: none;
  transition: all 0.5s;
  color: rgba(0, 0, 0, 0.5);
  position: relative;
  left: 1.6rem;
}
.up >>> .el-form-item__label {
  transition: all 0.5s;
  transform: translateY(-1.3rem);
  color: rgba(0, 0, 0, 0.5);
  position: relative;
  left: 1.6rem;
}
.input >>> .el-input__inner {
  padding: 0;
  width: 100%;
  transition: all 1s;
  border-radius: 0;
  background-color: rgb(255, 255, 255, -0);
  border: 0;
  border-bottom: 1px solid #3d3b4f;
  position: relative;
  left: -1rem;
}
.btn-login {
  border: 0;
  background: none;
}
.btn-login:hover {
  border: 0;
  background: none;
  color: #409eff;
}
.btn-login::before {
  background-color: rgba(255, 255, 255, 0);
}
.main {
  min-height: 100vh;
  background-image: linear-gradient(to right, #e0c3fc, #8ec5fc);
  display: flex;
  justify-content: center;
  align-items: center;
}
.table {
  border-radius: 4px;
  padding: 30px;
  background: rgba(255, 255, 255, 0.5);
  max-width: 30vw;
  width: 30px;
  min-width: 300px;
  transition: all 1s;
}
.avatar {
  transition: all 1s;
  max-height: 40vh;
  width: 35%;
  border-radius: 50%;
}
.sign-up {
  max-height: 30vh;
  transition: all 0.5s;
  overflow: hidden;
}
.hide {
  max-height: 0px;
  transition: all 0.5s;
  overflow: hidden;
}
@media (max-width: 499px) {
  .table {
    transition: all 1s;
    background: none;
    width: 100vw;
  }
  .input >>> .el-input__inner {
    transition: all 1s;
    border-bottom: 1px solid #dcdfe6;
    position: relative;
    left: -1rem;
  }
}
</style>
