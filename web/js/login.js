var LoginPanel = function(){

    applyTo(this, new Renderable(arguments[0])); 
    this.content = ['<div class="login-panel">',
               '<div class="brand">Paper Review System</div>',
            '<div class="login">',
                    '<div class="wrapper">',
                            '<label for="username">Username</label>',
                            '<input name="username" />',
                    '</div>',
                    '<div class="wrapper">',
                            '<label for="passwd">Password</label>',
                            '<input type="password" name="passwd" />',
                    '</div>',
                    '<button class="login">Log In</button>',
                    '<div class="errors"> </div>',
            '</div>',
    '</div>'];

    this.handlers = {
        'button.login': 'handle_login',
    };

    this.handle_login = function(e){
        var xhrcall = $.ajax({
            dataType: "json",
			method: "POST",
            url: "service/login",
            data : {username: $('input[name="username"]').val(),
                    password: $('input[name="passwd"]').val()
                   },
            success: function(data){ 
				$('div.errors').html('')
				$('div.errors').show();
				$('div.errors').append(data.success);
				$('div.errors').fadeOut(5000);
            },
            error : function(xhrObj){
				var data = { error : "Unhandled Error" };
				if(xhrObj.responseText) {
					data = $.parseJSON(xhrObj.responseText);
				}
				$('div.errors').html('')
				$('div.errors').show();
				$('div.errors').append(data.error);
				$('div.errors').fadeOut(5000);
            } 
        });
        e.stopPropagation();
    };

    this.render = function(){
        $(this.render_target).append(this.content.join(''));
        this.apply_members(this.members);
        this.apply_handlers(this.handlers);
        $('title').text('Paper Review System: Login');
    }; 
};

