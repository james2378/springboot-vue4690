<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','product_map') || $check_field('add','product_map') || $check_field('set','product_map')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品图" prop="product_map">
								<el-upload :disabled="disabledObj['product_map_isDisabled']" id="product_map" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_product_map"
						:show-file-list="false" v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','product_map')) || (!form['sales_outbound_id'] && $check_field('add','product_map'))">
						<img v-if="form['product_map']" :src="$fullUrl(form['product_map'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','product_map')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['product_map'])" :preview-src-list="[$fullUrl(form['product_map'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_name') || $check_field('add','product_name') || $check_field('set','product_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="product_name">
												<el-input id="product_name" v-model="form['product_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','product_name')) || (!form['sales_outbound_id'] && $check_field('add','product_name'))" :disabled="disabledObj['product_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_name')">{{form['product_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
												<el-input id="product_type" v-model="form['product_type']" placeholder="请输入商品类型"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','product_type')) || (!form['sales_outbound_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','brand')) || (!form['sales_outbound_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','commodity_specifications') || $check_field('add','commodity_specifications') || $check_field('set','commodity_specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品规格" prop="commodity_specifications">
												<el-input id="commodity_specifications" v-model="form['commodity_specifications']" placeholder="请输入商品规格"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','commodity_specifications')) || (!form['sales_outbound_id'] && $check_field('add','commodity_specifications'))" :disabled="disabledObj['commodity_specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','commodity_specifications')">{{form['commodity_specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_price') || $check_field('add','sales_price') || $check_field('set','sales_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售价" prop="sales_price">
												<el-input id="sales_price" v-model="form['sales_price']" placeholder="请输入销售价"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','sales_price')) || (!form['sales_outbound_id'] && $check_field('add','sales_price'))" :disabled="disabledObj['sales_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','sales_price')">{{form['sales_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单号"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','order_number')) || (!form['sales_outbound_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_volumes') || $check_field('add','sales_volumes') || $check_field('set','sales_volumes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售数量" prop="sales_volumes">
								<el-input-number id="sales_volumes" v-model.number="form['sales_volumes']"
						v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','sales_volumes')) || (!form['sales_outbound_id'] && $check_field('add','sales_volumes'))" :disabled="disabledObj['sales_volumes_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','sales_volumes')">{{form['sales_volumes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_amount') || $check_field('add','sales_amount') || $check_field('set','sales_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售金额" prop="sales_amount">
												<el-input id="sales_amount" v-model="form['sales_amount']" placeholder="请输入销售金额"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','sales_amount')) || (!form['sales_outbound_id'] && $check_field('add','sales_amount'))"  @focus="set_sales_amount()" :disabled="disabledObj['sales_amount_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','sales_amount')">{{form['sales_amount']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_month') || $check_field('add','sales_month') || $check_field('set','sales_month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售月份" prop="sales_month">
												<el-input id="sales_month" v-model="form['sales_month']" placeholder="请输入销售月份"
							  v-if="user_group === '管理员' || (form['sales_outbound_id'] && $check_field('set','sales_month')) || (!form['sales_outbound_id'] && $check_field('add','sales_month'))" :disabled="disabledObj['sales_month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','sales_month')">{{form['sales_month']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "sales_outbound_id",
				url_add: "~/api/sales_outbound/add?",
				url_set: "~/api/sales_outbound/set?",
				url_get_obj: "~/api/sales_outbound/get_obj?",
				url_upload: "~/api/sales_outbound/upload?",

				query: {
					"sales_outbound_id": 0,
				},

				form: {
								"product_map":  '', // 商品图
										"product_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"brand":  '', // 品牌
										"commodity_specifications":  '', // 商品规格
										"sales_price":  '', // 销售价
										"order_number": this.$get_stamp(), // 订单号
										"sales_volumes":  0, // 销售数量
										"sales_amount":  '', // 销售金额
										"sales_month":  '', // 销售月份
											"sales_outbound_id": 0, // ID
						
				},
				disabledObj:{
								"product_map_isDisabled": false,
										"product_name_isDisabled": false,
										"product_type_isDisabled": false,
										"brand_isDisabled": false,
										"commodity_specifications_isDisabled": false,
										"sales_price_isDisabled": false,
										"order_number_isDisabled": false,
					          			"sales_volumes_isDisabled": false,
										"sales_amount_isDisabled": false,
										"sales_month_isDisabled": false,
										},

	
		
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


				/**
			 * 上传商品图
			 * @param {Object} param 图片参数
			 */
			upload_product_map(param){
						this.uploadFile(param.file, "product_map");
					},
	
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
										set_sales_amount(){
				this.form.sales_amount = parseFloat(this.form.sales_price) * parseFloat(this.form.sales_volumes)
			},
							
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
															// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
											
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																								$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																														


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																				return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/sales_outbound/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_outbound/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_outbound/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_outbound/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_outbound/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
																						},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
