<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


										<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="商品名称">
									<el-input v-model="query.product_name"></el-input>
								</el-form-item>
				</el-col>
									<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="商品类型">
									<el-input v-model="query.product_type"></el-input>
								</el-form-item>
				</el-col>
																		<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="订单号">
									<el-input v-model="query.order_number"></el-input>
								</el-form-item>
				</el-col>
																<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/sales_outbound/table','add') || $check_action('/sales_outbound/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/sales_outbound/table','del') || $check_action('/sales_outbound/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="product_map" @sort-change="$sortChange" label="商品图"
				v-if="user_group == '管理员' || $check_field('get','product_map')" min-width="200">
						<template slot-scope="scope">
					<el-image style="width: 100px; height: 100px" :src="$fullUrl(scope.row['product_map'])"
						:preview-src-list="[$fullUrl(scope.row['product_map'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</template>
					</el-table-column>
					<el-table-column prop="product_name" @sort-change="$sortChange" label="商品名称"
				v-if="user_group == '管理员' || $check_field('get','product_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="product_type" @sort-change="$sortChange" label="商品类型"
				v-if="user_group == '管理员' || $check_field('get','product_type')" min-width="200">
					</el-table-column>
					<el-table-column prop="brand" @sort-change="$sortChange" label="品牌"
				v-if="user_group == '管理员' || $check_field('get','brand')" min-width="200">
					</el-table-column>
					<el-table-column prop="commodity_specifications" @sort-change="$sortChange" label="商品规格"
				v-if="user_group == '管理员' || $check_field('get','commodity_specifications')" min-width="200">
					</el-table-column>
					<el-table-column prop="sales_price" @sort-change="$sortChange" label="销售价"
				v-if="user_group == '管理员' || $check_field('get','sales_price')" min-width="200">
					</el-table-column>
					<el-table-column prop="order_number" @sort-change="$sortChange" label="订单号"
				v-if="user_group == '管理员' || $check_field('get','order_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="sales_volumes" @sort-change="$sortChange" label="销售数量"
				v-if="user_group == '管理员' || $check_field('get','sales_volumes')" min-width="200">
					</el-table-column>
					<el-table-column prop="sales_amount" @sort-change="$sortChange" label="销售金额"
				v-if="user_group == '管理员' || $check_field('get','sales_amount')" min-width="200">
					</el-table-column>
					<el-table-column prop="sales_month" @sort-change="$sortChange" label="销售月份"
				v-if="user_group == '管理员' || $check_field('get','sales_month')" min-width="200">
					</el-table-column>
	



            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/sales_outbound/table','set') || $check_action('/sales_outbound/view','set') || $check_action('/sales_outbound/view','get') || $check_action('//table','add') || $check_action('//view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/sales_outbound/table','set') || $check_action('/sales_outbound/view','set') || $check_action('/sales_outbound/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
				</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

										
		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/sales_outbound/get_list?like=0",
				url_del: "~/api/sales_outbound/del?",

				// 字段ID
				field: "sales_outbound_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
									"product_name": "",
											"product_type": "",
														"order_number": "",
											"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																																	}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},


																				



																							deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
																						}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
