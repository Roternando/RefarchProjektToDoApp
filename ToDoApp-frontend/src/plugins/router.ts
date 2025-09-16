// Composables
import { createRouter, createWebHashHistory } from "vue-router";

import {ROUTES_GETSTARTED, ROUTES_HOME, ROUTES_TODO} from "@/constants";
import GetStartedView from "@/views/GetStartedView.vue";
import HomeView from "@/views/HomeView.vue";
import ToDoView from "@/views/ToDoView.vue";

const routes = [
  {
    path: "/",
    name: ROUTES_HOME,
    component: HomeView,
    meta: {},
  },
  {
    path: "/getstarted",
    name: ROUTES_GETSTARTED,
    component: GetStartedView,
  },
  {
    path: "/todo",
    name: ROUTES_TODO,
    component: ToDoView,
  },
  { path: "/:catchAll(.*)*", redirect: "/" }, // CatchAll route
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
  scrollBehavior() {
    return {
      top: 0,
      left: 0,
    };
  },
});

export default router;
