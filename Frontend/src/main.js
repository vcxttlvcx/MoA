import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import Tawk from 'vue-tawk';

import './assets/css/tiptab/main.scss';

//npm install vue-tawk --save
const TAWK_SRC_URL = 'tawk address'; //TAWK 주소

Vue.config.productionTip = false;

Vue.use(Tawk, {
    // TAWK.to API
    tawkSrc: TAWK_SRC_URL,
});

window.Kakao.init('Kakao Api key value');
new Vue({
    router,
    store,
    vuetify,
    async beforeCreate() {
        let token = localStorage.getItem('access-token');
        if (store.state.memberInfo == null && token) {
            await store.dispatch('GET_MEMBER_INFO', token);
        }
    },
    render: (h) => h(App),
}).$mount('#app');
