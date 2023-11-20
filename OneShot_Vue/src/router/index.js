import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import OrderMenuView from '@/views/OrderMenuView.vue'
import OrderBrandView from '@/views/OrderBrandView.vue'
import LoginView from '@/views/LoginView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/order',
      name: 'order-brand',
      component: OrderBrandView
    },
    {
      path: '/order/:orderCode',
      name: 'order-menu',
      component: OrderMenuView
    },
  ]
})

export default router
