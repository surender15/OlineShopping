$(function() {
	//solving the active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProduct').addClass('active');
		break;


	default:
		$('#Home').addClass('active');
		break;
	}

	/*code for jquery dataTable
	create a dataset */
	
	var $table = $('#productListTable');
	//execute the below code only where we have this table 
	if($table.length)
		{
		var jsonUrl = '';
		if(window.categoryId =='')
		{
			jsonUrl= '/json/data/all/products';
		}
		else
			{
			jsonUrl= '/json/data/category/'+window.categoryId+'/products';
			}
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
			PageLength:5,	
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns:[
				{
					data:'code',
					mRender:function(data,type,row){
						return '<image src="../../../../images/'+data+'.jpg"  class="dataTableImg"/>';
					}
				},
				{
					data:'name',
				},
				{
					data:'brand',
				},
				{
					data:'unitPrice',
					mRender:function(data, type,row){
						return '&#8377;'+data;
					}
				},
				{
					data:'quantity',
				},
				{
					data:'id',
					bSortable:false, 	
					mRender:function(data,type,row){
						var str='';
						str+='<a href="/show/'+data+'/product" class="btn btn-primary"><span  class="glyphicon glyphicon-eye-open"></span>view</a> &#160;';
						str+='<a href="/cart/add/'+data+'/product" class="btn btn-success"><span  class="glyphicon glyphicon-shopping-cart">Add to cart</span></a>';
						return str;
					}
				}
			]
		});
		}

	//dismiss the alert after 3 seconds
	var $alert=$('.alert');
	if($alert.length){
		setTimeOut(function(){
			$alert.fadeOut('slow');
		},3000)
	}

	
});



