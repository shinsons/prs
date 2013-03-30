
function applyTo(a, b) {
    for(var i in b){
        a[i] = b[i];
    }
};

var Renderable = function(){

    this.content = '';
    this.render_target = arguments[0];
    this.members = {};
    this.handlers = {};

    this.apply_members = function(members) {
        for(v in members){
            if(members[v].render){
                $(v).append(members[v].render());
            }
        }
    };

    this.apply_handlers = function(handlers){
        // only need click handlers at this point.
        for(v in handlers){
            $(v).on('click', $.proxy(this[handlers[v]], this));
        }

    };

    this.render = function(){
        $(this.render_target).append(this.content.join(''));
        this.apply_members(this.members);
        this.apply_handlers(this.handlers);

    };
};
