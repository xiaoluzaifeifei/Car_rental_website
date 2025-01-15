import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
  {
    path: '',
    name: 'Introduction',
    component: () => import("@/views/Introduction")
  },
  {
    path: '/',
    name: 'layout',
    component: Layout,
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import("@/views/Home") // component不能写成components
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import("@/views/Login")
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
