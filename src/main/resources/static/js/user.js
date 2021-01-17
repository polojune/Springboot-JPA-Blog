let index = {
		 init: function(){
			  $("#btn-save").on("click",()=>{//function(){} , ()=>{} this를 바인딩 하기 위해 
				   this.save();
			  });
			  /*  	  
			  $("#btn-login").on("click",()=>{//function(){} , ()=>{} this를 바인딩 하기 위해 
				   this.login();
			  });
			  */
			  $("#btn-update").on("click",()=>{//function(){} , ()=>{} this를 바인딩 하기 위해 
				   this.update();
			  });
			  
		 },
		 	
    save:function(){
    	//alert("user의 save함수 호출됨 ");
    	 let data = {
    			 username: $("#username").val(), 
    			 password: $("#password").val(), 
    			 email: $("#email").val(),
    	 }
    	
    	 //console.log(data);
    	 
    	 //ajax호출시 default가 비동기 호출 
    	 $.ajax({
    		   //회원가입 수행 요청 
    		   type:"post", 
    		   url:"/auth/joinProc",
    		   data: JSON.stringify(data),
    		   contentType:"application/json;chartset=utf-8",
    		   dataType:"json"
    	 }).done(function(resp){
    	   		 //console.log(resp);
    		 if(resp.status == 500) {
    			 alert("회원가입이 실패하였습니다. "); 
    		 }else {
    			 alert("회원가입이 완료되었습니다. "); 
    			 location.href = "/";
			}
    	
    	 }).fail(function(error){
    		  alert(JSON.stringify(error));
    	 });
    },
  /*  
    login:function(){
    	//alert("user의 save함수 호출됨 ");
    	 let data = {
    			 username: $("#username").val(), 
    			 password: $("#password").val(), 
    			 
    	 }
    	
    	 //console.log(data);   	 
    	 //ajax호출시 default가 비동기 호출 
    	 $.ajax({
    		   //회원가입 수행 요청 
    		   type:"post", 
    		   url:"/api/user/login",
    		   data: JSON.stringify(data),
    		   contentType:"application/json;chartset=utf-8",
    		   dataType:"json"
    	 }).done(function(resp){
    		 alert("로그인이 완료되었습니다. "); 
    		 //console.log(resp);
    		 location.href = "/";
    	 }).fail(function(error){
    		  alert(JSON.stringify(error));
    	 });
    }
    */
			  update:function(){
			    	//alert("user의 save함수 호출됨 ");
			    	 let data = {
			    			 id: $("#id").val(), 
			    			 username: $("#username").val(),
			    			 password: $("#password").val(), 
			    			 email: $("#email").val(),
			    	 }
			    	
			    	 //console.log(data);
			    	 
			    	 //ajax호출시 default가 비동기 호출 
			    	 $.ajax({
			    		   //회원가입 수행 요청 
			    		   type:"put", 
			    		   url:"/user",
			    		   data: JSON.stringify(data),
			    		   contentType:"application/json;chartset=utf-8",
			    		   dataType:"json"
			    	 }).done(function(resp){
			    		 alert("회원수정이 완료되었습니다. "); 
			    		 //console.log(resp);
			    		 location.href = "/";
			    	 }).fail(function(error){
			    		  alert(JSON.stringify(error));
			    	 });
			    },
}

index.init();