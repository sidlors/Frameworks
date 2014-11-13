
//inicio-Op1
//var proxyconzole={};
//proxyconzole.log = function(msg){console.log('proxyconsole - '+msg)};
//proxyconzole.log = function(msg){};
//fin-Op1


Ext.define('ExtUtil.Conzole',{
    statics: {
    	//enable : true,
    	enable : false,
        log: function (msg) {
        	if(this.enable){
        		console.log('Conzole:'+msg);
        	}else{}
        }
    }
});