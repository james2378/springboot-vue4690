<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','product_map') || $check_field('add','product_map') || $check_field('set','product_map')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品图" prop="product_map">
								<el-upload :disabled="disabledObj['product_map_isDisabled']" id="product_map" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_product_map"
						:show-file-list="false" v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','product_map')) || (!form['warehousing_audit_id'] && $check_field('add','product_map'))">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','purchase_order_number') || $check_field('add','purchase_order_number') || $check_field('set','purchase_order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="采购单号" prop="purchase_order_number">
												<el-input id="purchase_order_number" v-model="form['purchase_order_number']" placeholder="请输入采购单号"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','purchase_order_number')) || (!form['warehousing_audit_id'] && $check_field('add','purchase_order_number'))" :disabled="disabledObj['purchase_order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','purchase_order_number')">{{form['purchase_order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_name') || $check_field('add','product_name') || $check_field('set','product_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品名称" prop="product_name">
												<el-input id="product_name" v-model="form['product_name']" placeholder="请输入商品名称"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','product_name')) || (!form['warehousing_audit_id'] && $check_field('add','product_name'))" :disabled="disabledObj['product_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_name')">{{form['product_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_type') || $check_field('add','product_type') || $check_field('set','product_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品类型" prop="product_type">
												<el-input id="product_type" v-model="form['product_type']" placeholder="请输入商品类型"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','product_type')) || (!form['warehousing_audit_id'] && $check_field('add','product_type'))" :disabled="disabledObj['product_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','product_type')">{{form['product_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','brand')) || (!form['warehousing_audit_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','commodity_specifications') || $check_field('add','commodity_specifications') || $check_field('set','commodity_specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="商品规格" prop="commodity_specifications">
												<el-input id="commodity_specifications" v-model="form['commodity_specifications']" placeholder="请输入商品规格"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','commodity_specifications')) || (!form['warehousing_audit_id'] && $check_field('add','commodity_specifications'))" :disabled="disabledObj['commodity_specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','commodity_specifications')">{{form['commodity_specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supplier_number') || $check_field('add','supplier_number') || $check_field('set','supplier_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="供应商编号" prop="supplier_number">
													<el-select v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','supplier_number')) || (!form['warehousing_audit_id'] && $check_field('add','supplier_number'))" id="supplier_number" v-model="form['supplier_number']" :disabled="disabledObj['supplier_number_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','supplier_name')) || (!form['warehousing_audit_id'] && $check_field('add','supplier_name'))" :disabled="disabledObj['supplier_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supplier_name')">{{form['supplier_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','purchase_quantity') || $check_field('add','purchase_quantity') || $check_field('set','purchase_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="采购数量" prop="purchase_quantity">
												<el-input id="purchase_quantity" v-model="form['purchase_quantity']" placeholder="请输入采购数量"
							  v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','purchase_quantity')) || (!form['warehousing_audit_id'] && $check_field('add','purchase_quantity'))" :disabled="disabledObj['purchase_quantity_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','purchase_quantity')">{{form['purchase_quantity']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receipt_quantity') || $check_field('add','receipt_quantity') || $check_field('set','receipt_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库数量" prop="receipt_quantity">
								<el-input-number id="receipt_quantity" v-model.number="form['receipt_quantity']"
						v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','receipt_quantity')) || (!form['warehousing_audit_id'] && $check_field('add','receipt_quantity'))" :disabled="disabledObj['receipt_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','receipt_quantity')">{{form['receipt_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','procurement_personnel') || $check_field('add','procurement_personnel') || $check_field('set','procurement_personnel')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="采购人员" prop="procurement_personnel">
													<el-select v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','procurement_personnel')) || (!form['warehousing_audit_id'] && $check_field('add','procurement_personnel'))" id="procurement_personnel" v-model="form['procurement_personnel']" :disabled="disabledObj['procurement_personnel_isDisabled']">
							<el-option v-for="o in list_user_procurement_personnel" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','procurement_personnel')" id="procurement_personnel" v-model="form['procurement_personnel']" :disabled="true">
							<el-option v-for="o in list_user_procurement_personnel" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','review_remarks') || $check_field('add','review_remarks') || $check_field('set','review_remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核备注" prop="review_remarks">
								<el-input type="textarea" id="review_remarks" v-model="form['review_remarks']" placeholder="请输入审核备注"
						v-if="user_group === '管理员' || (form['warehousing_audit_id'] && $check_field('set','review_remarks')) || (!form['warehousing_audit_id'] && $check_field('add','review_remarks'))" :disabled="disabledObj['review_remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','review_remarks')">{{form['review_remarks']}}</div>
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
				field: "warehousing_audit_id",
				url_add: "~/api/warehousing_audit/add?",
				url_set: "~/api/warehousing_audit/set?",
				url_get_obj: "~/api/warehousing_audit/get_obj?",
				url_upload: "~/api/warehousing_audit/upload?",

				query: {
					"warehousing_audit_id": 0,
				},

				form: {
								"product_map":  '', // 商品图
										"purchase_order_number":  '', // 采购单号
										"product_name":  '', // 商品名称
										"product_type":  '', // 商品类型
										"brand":  '', // 品牌
										"commodity_specifications":  '', // 商品规格
										"supplier_number": 0, // 供应商编号
										"supplier_name":  '', // 供应商名称
										"purchase_quantity":  '', // 采购数量
										"receipt_quantity":  0, // 入库数量
										"procurement_personnel": 0, // 采购人员
										"review_remarks":  '', // 审核备注
											"warehousing_audit_id": 0, // ID
						
				},
				disabledObj:{
								"product_map_isDisabled": false,
										"purchase_order_number_isDisabled": false,
										"product_name_isDisabled": false,
										"product_type_isDisabled": false,
										"brand_isDisabled": false,
										"commodity_specifications_isDisabled": false,
										"supplier_number_isDisabled": false,
										"supplier_name_isDisabled": false,
										"purchase_quantity_isDisabled": false,
					          			"receipt_quantity_isDisabled": false,
										"procurement_personnel_isDisabled": false,
										"review_remarks_isDisabled": false,
										},

	
		
		
		
		
		
		
					// 用户列表
				list_user_supplier_number: [],
				
		
		
		
					// 用户列表
				list_user_procurement_personnel: [],
				
	
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
			 * 获取采购用户用户列表
			 */
			async get_list_user_procurement_personnel() {
                // if(this.user_group !== "管理员" && this.form["procurement_personnel"] === 0) {
                //     this.form["procurement_personnel"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=采购用户");
                if(json.result && json.result.list){
                    this.list_user_procurement_personnel = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_procurement_personnel(id){
				var obj = this.list_user_procurement_personnel.getObj({"user_id":id});
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
					bl = this.$check_action('/warehousing_audit/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/warehousing_audit/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/warehousing_audit/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/warehousing_audit/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/warehousing_audit/view','get');
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
																	this.get_list_user_supplier_number();
														this.get_list_user_procurement_personnel();
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
