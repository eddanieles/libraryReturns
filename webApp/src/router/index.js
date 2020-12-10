import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Books from '../views/Books.vue'
import Aggregate from '../views/BookReturn.vue'
import VueFormulate from '@braid/vue-formulate'

Vue.use(VueFormulate)

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/returnBook',
        name: 'Aggregate',
        component: Aggregate
    },
    {
        path: '/books',
        name: 'books',
        component: Books
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router