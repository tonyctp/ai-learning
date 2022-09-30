import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import JwChat from 'jwchat';
import axios from 'axios'

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(JwChat)

new Vue({
  render: h => h(App),
}).$mount('#app')
