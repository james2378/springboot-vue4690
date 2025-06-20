<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','product_map') || $check_field('add','product_map') || $check_field('set','product_map')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品图" prop="product_map">
								<el-upload :disabled="disabledObj['product_map_isDisabled']" id="product_map" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_product_map"
						:show-file-list="false" v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','product_map')) || (!form['warehouse_management_id'] && $check_field('add','product_map'))">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','classification_of_goods') || $check_field('add','classification_of_goods') || $check_field('set','classification_of_goods')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="货物分类" prop="classification_of_goods">
								<el-select id="classification_of_goods" v-model="form['classification_of_goods']"
						v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','classification_of_goods')) || (!form['warehouse_management_id'] && $check_field('add','classification_of_goods'))">
						<el-option v-for="o in list_classification_of_goods" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','classification_of_goods')">{{form['classification_of_goods']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_name') || $check_field('add','product_name') || $check_field('set','product_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="product_name">
												<el-input id="product_name" v-model="form['product_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','product_name')) || (!form['warehouse_management_id'] && $check_field('add','product_name'))" :disabled="disabledObj['product_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_name')">{{form['product_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
								<el-select id="product_type" v-model="form['product_type']"
						v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','product_type')) || (!form['warehouse_management_id'] && $check_field('add','product_type'))">
						<el-option v-for="o in list_product_type" :key="o['product_type']" :label="o['product_type']"
							:value="o['product_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','brand')) || (!form['warehouse_management_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','commodity_specifications') || $check_field('add','commodity_specifications') || $check_field('set','commodity_specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品规格" prop="commodity_specifications">
												<el-input id="commodity_specifications" v-model="form['commodity_specifications']" placeholder="请输入商品规格"
							  v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','commodity_specifications')) || (!form['warehouse_management_id'] && $check_field('add','commodity_specifications'))" :disabled="disabledObj['commodity_specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','commodity_specifications')">{{form['commodity_specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_number') || $check_field('add','supplier_number') || $check_field('set','supplier_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供应商编号" prop="supplier_number">
													<el-select v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','supplier_number')) || (!form['warehouse_management_id'] && $check_field('add','supplier_number'))" id="supplier_number" v-model="form['supplier_number']" :disabled="disabledObj['supplier_number_isDisabled']">
							<el-option v-for="o in list_user_supplier_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','supplier_number')" id="supplier_number" v-model="form['supplier_number']" :disabled="true">
							<el-option v-for="o in list_user_supplier_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_name') || $check_field('add','supplier_name') || $check_field('set','supplier_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供应商名称" prop="supplier_name">
												<el-input id="supplier_name" v-model="form['supplier_name']" placeholder="请输入供应商名称"
							  v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','supplier_name')) || (!form['warehouse_management_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','inventory_quantity') || $check_field('add','inventory_quantity') || $check_field('set','inventory_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="库存数量" prop="inventory_quantity">
								<el-input-number id="inventory_quantity" v-model.number="form['inventory_quantity']"
						v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','inventory_quantity')) || (!form['warehouse_management_id'] && $check_field('add','inventory_quantity'))" :disabled="disabledObj['inventory_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','inventory_quantity')">{{form['inventory_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_price') || $check_field('add','sales_price') || $check_field('set','sales_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售价" prop="sales_price">
								<el-input-number id="sales_price" v-model.number="form['sales_price']"
						v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','sales_price')) || (!form['warehouse_management_id'] && $check_field('add','sales_price'))" :disabled="disabledObj['sales_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','sales_price')">{{form['sales_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','warehouse_number') || $check_field('add','warehouse_number') || $check_field('set','warehouse_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="仓库号" prop="warehouse_number">
								<el-select id="warehouse_number" v-model="form['warehouse_number']"
						v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','warehouse_number')) || (!form['warehouse_management_id'] && $check_field('add','warehouse_number'))">
						<el-option v-for="o in list_warehouse_number" :key="o['warehouse_number']" :label="o['warehouse_number']"
							:value="o['warehouse_number']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','warehouse_number')">{{form['warehouse_number']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','storage_location_map') || $check_field('add','storage_location_map') || $check_field('set','storage_location_map')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="存储位置图" prop="storage_location_map">
								<el-upload :disabled="disabledObj['storage_location_map_isDisabled']" id="storage_location_map" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_storage_location_map"
						:show-file-list="false" v-if="user_group === '管理员' || (form['warehouse_management_id'] && $check_field('set','storage_location_map')) || (!form['warehouse_management_id'] && $check_field('add','storage_location_map'))">
						<img v-if="form['storage_location_map']" :src="$fullUrl(form['storage_location_map'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','storage_location_map')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['storage_location_map'])" :preview-src-list="[$fullUrl(form['storage_location_map'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
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
				field: "warehouse_management_id",
				url_add: "~/api/warehouse_management/add?",
				url_set: "~/api/warehouse_management/set?",
				url_get_obj: "~/api/warehouse_management/get_obj?",
				url_upload: "~/api/warehouse_management/upload?",

				query: {
					"warehouse_management_id": 0,
				},

				form: {
								"product_map":  '', // 商品图
										"classification_of_goods":  '', // 货物分类
										"product_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"brand":  '', // 品牌
										"commodity_specifications":  '', // 商品规格
										"supplier_number": 0, // 供应商编号
										"supplier_name":  '', // 供应商名称
										"inventory_quantity":  0, // 库存数量
										"sales_price":  0, // 销售价
										"warehouse_number":  '', // 仓库号
										"storage_location_map":  '', // 存储位置图
											"warehouse_management_id": 0, // ID
						
				},
				disabledObj:{
								"product_map_isDisabled": false,
										"classification_of_goods_isDisabled": false,
										"product_name_isDisabled": false,
										"product_type_isDisabled": false,
										"brand_isDisabled": false,
										"commodity_specifications_isDisabled": false,
										"supplier_number_isDisabled": false,
										"supplier_name_isDisabled": false,
					          			"inventory_quantity_isDisabled": false,
					          			"sales_price_isDisabled": false,
										"warehouse_number_isDisabled": false,
										"storage_location_map_isDisabled": false,
										},

	
						// 货物分类选项列表
				list_classification_of_goods: ['一般商品','特殊商品'],
	
		
						// 商品类型选项列表
				list_product_type: [""],
	
		
		
		
					// 用户列表
				list_user_supplier_number: [],
				
		
		
						// 仓库号选项列表
				list_warehouse_number: [""],
	
		
	
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
	
	
			
	
			
	
			
				/**
			 * 获取商品类型列表
			 */
			async get_list_product_type() {
				var json = await this.$get("~/api/product_type/get_list?");
				if(json.result && json.result.list){
					this.list_product_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
			
	
				/**
			 * 获取供应商用户列表
			 */
			async get_list_user_supplier_number() {
                // if(this.user_group !== "管理员" && this.form["supplier_number"] === 0) {
                //     this.form["supplier_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=供应商");
                if(json.result && json.result.list){
                    this.list_user_supplier_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_supplier_number(id){
				var obj = this.list_user_supplier_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
				/**
			 * 获取仓库号列表
			 */
			async get_list_warehouse_number() {
				var json = await this.$get("~/api/warehouse_number/get_list?");
				if(json.result && json.result.list){
					this.list_warehouse_number = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
						/**
			 * 上传存储位置图
			 * @param {Object} param 图片参数
			 */
			upload_storage_location_map(param){
						this.uploadFile(param.file, "storage_location_map");
					},
	
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																	
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
					bl = this.$check_action('/warehouse_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/warehouse_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/warehouse_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/warehouse_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/warehouse_management/view','get');
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
										this.get_list_product_type();
											this.get_list_user_supplier_number();
													this.get_list_warehouse_number();
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
