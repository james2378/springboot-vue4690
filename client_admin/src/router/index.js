import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},








	// 采购用户路由
	{
		path: '/purchasing_users/table',
		name: 'purchasing_users_table',
		component: () => import('../views/purchasing_users/table.vue'),
		meta: {
			index: 0,
			title: '采购用户列表'
		}
	},
	{
		path: '/purchasing_users/view',
		name: 'purchasing_users_view',
		component: () => import('../views/purchasing_users/view.vue'),
		meta: {
			index: 0,
			title: '采购用户详情'
		}
	},
	// 供应商路由
	{
		path: '/supplier/table',
		name: 'supplier_table',
		component: () => import('../views/supplier/table.vue'),
		meta: {
			index: 0,
			title: '供应商列表'
		}
	},
	{
		path: '/supplier/view',
		name: 'supplier_view',
		component: () => import('../views/supplier/view.vue'),
		meta: {
			index: 0,
			title: '供应商详情'
		}
	},
	// 商品类型路由
	{
		path: '/product_type/table',
		name: 'product_type_table',
		component: () => import('../views/product_type/table.vue'),
		meta: {
			index: 0,
			title: '商品类型列表'
		}
	},
	{
		path: '/product_type/view',
		name: 'product_type_view',
		component: () => import('../views/product_type/view.vue'),
		meta: {
			index: 0,
			title: '商品类型详情'
		}
	},
	// 采购管理路由
	{
		path: '/purchasing_management/table',
		name: 'purchasing_management_table',
		component: () => import('../views/purchasing_management/table.vue'),
		meta: {
			index: 0,
			title: '采购管理列表'
		}
	},
	{
		path: '/purchasing_management/view',
		name: 'purchasing_management_view',
		component: () => import('../views/purchasing_management/view.vue'),
		meta: {
			index: 0,
			title: '采购管理详情'
		}
	},
	// 入库审核路由
	{
		path: '/warehousing_audit/table',
		name: 'warehousing_audit_table',
		component: () => import('../views/warehousing_audit/table.vue'),
		meta: {
			index: 0,
			title: '入库审核列表'
		}
	},
	{
		path: '/warehousing_audit/view',
		name: 'warehousing_audit_view',
		component: () => import('../views/warehousing_audit/view.vue'),
		meta: {
			index: 0,
			title: '入库审核详情'
		}
	},
	// 仓储管理路由
	{
		path: '/warehouse_management/table',
		name: 'warehouse_management_table',
		component: () => import('../views/warehouse_management/table.vue'),
		meta: {
			index: 0,
			title: '仓储管理列表'
		}
	},
	{
		path: '/warehouse_management/view',
		name: 'warehouse_management_view',
		component: () => import('../views/warehouse_management/view.vue'),
		meta: {
			index: 0,
			title: '仓储管理详情'
		}
	},
	// 销售出库路由
	{
		path: '/sales_outbound/table',
		name: 'sales_outbound_table',
		component: () => import('../views/sales_outbound/table.vue'),
		meta: {
			index: 0,
			title: '销售出库列表'
		}
	},
	{
		path: '/sales_outbound/view',
		name: 'sales_outbound_view',
		component: () => import('../views/sales_outbound/view.vue'),
		meta: {
			index: 0,
			title: '销售出库详情'
		}
	},
	// 仓库号路由
	{
		path: '/warehouse_number/table',
		name: 'warehouse_number_table',
		component: () => import('../views/warehouse_number/table.vue'),
		meta: {
			index: 0,
			title: '仓库号列表'
		}
	},
	{
		path: '/warehouse_number/view',
		name: 'warehouse_number_view',
		component: () => import('../views/warehouse_number/view.vue'),
		meta: {
			index: 0,
			title: '仓库号详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "仓库管理系统-admin";
	document.title = title;
})

export default router
