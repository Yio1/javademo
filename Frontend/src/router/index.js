import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  { path: "/", redirect: "/Login" },
  {
    path: "/Login",
    name: "Login",
    component: () =>
      import(/* webpackChunkName: "Login" */ "../views/login.vue"),
  },
  {
    path: "/Main",
    name: "Main",
    component: () =>
      import(/* webpackChunkName: "Login" */ "../views/main.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
