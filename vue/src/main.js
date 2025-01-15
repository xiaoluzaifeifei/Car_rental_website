import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementsPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/css/global.css'
import '@element-plus/icons-vue'

createApp(App).use(store).use(router).use(ElementsPlus).mount('#app')
