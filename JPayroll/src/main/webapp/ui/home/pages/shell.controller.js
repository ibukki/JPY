sap.ui.controller("ui.home.pages.shell", {

	
	oNavigationItems : {
		"home":{text:"Welcome", viewName:"ui.home.pages.home",type:"JS"}
	},
	
	oViews : {},
	
	onInit: function() {
		   var  that = this;
		   var oShell = sap.ui.getCore().byId("main-shell");
		   var oSubNaviItem;
		   var oSubItems;
		   for(var key in this.oNavigationItems){
			   
			   var item = this.oNavigationItems[key];
			   var navItem = new sap.ui.ux3.NavigationItem({
				   id: "nav-" + key,
				   text:item.text
			   });
			   oShell.addWorksetItem(navItem);
			   
			   oSubItems = this.oNavigationItems[key].subItems;
			   if(oSubItems){
				   for(var subId in oSubItems){
					   oSubNaviItem = new sap.ui.ux3.NavigationItem({
						   id : "nav-" + key +"-sub-" + subId,
						   text:oSubItems[subId].text
					   });
					   navItem.addSubItem(oSubNaviItem);
				   }
			   }
		   }
		   
		   oShell.attachWorksetItemSelected(function(oEvent){
			   //navigation starts
			   var oWorkItem = sap.ui.getCore().byId("main-shell").getSelectedWorksetItem();
			   var viewId = oWorkItem.substring(oWorkItem.lastIndexOf("-")+1,oWorkItem.length);
			   var oCurrentView = sap.ui.getCore().byId(viewId);
			   var newViewId = oEvent.getParameter("id");
			   var oView = that.getView(newViewId);
			   oShell.setContent(oView);
		   });
		   
		   var locationUrl = location.href;
		   if(locationUrl.indexOf("#") > 0){
			   var anchor = locationUrl.split("#")[1];
			   if(anchor.indexOf("nav-") < 0){
				   anchor = "nav-" + anchor;
			   }
			   oShell.setContent(this.getView(anchor));
			   oShell.setSelectedWorksetItem(anchor);
		   }else{
			   oShell.setContent(this.getView("nav-home"));
		   }
		  
		   oShell.attachPaneBarItemSelected(function(oEvent){
			   var barId = oEvent.getParameter("id");
			   oShell.setPaneContent(that.getHelpContent(barId)); 
		   });
	},
	
	getView : function(id){
		   var viewId;
		   var viewConfig;
		   var oView;
		   //console.debug(id);
		   if(id.indexOf("sub") > 0){
			   var cArr = id.split("-");
			   var parentId = cArr[1];
			   viewId = cArr[3];
			   viewConfig = this.oNavigationItems[parentId].subItems[viewId];  
		   }else{
			   viewId = id.replace("nav-","");
			   viewConfig = this.oNavigationItems[viewId];
		   };
		   if(!viewConfig){
			   return;
		   }
		   if(!this.oViews[viewId]){
			   oView = sap.ui.view({
				   id:viewId,
				   viewName: viewConfig.viewName,
				   type:viewConfig.type
			   });
			   this.oViews[viewId] = oView;
			   oView.addStyleClass("slider");
		   }
		   location = location.protocol + "//" + location.host + location.pathname + "#" + id;
		   return this.oViews[viewId];
	   },
	   
	   getHelpContent:function(id){
		   
	   },
	   
	   onBeforeRendering: function() {
		   
	   },
	   setVersionFlag : function(){
		 for(var viewid in this.oNavigationItems){
			 var viewConfig = this.oNavigationItems[viewid];
			 if(viewConfig.version){
				 $("#nav-" + viewid).html(viewConfig.text + "<span class='version_flag'>" + viewConfig.version +"</span>");
			 }
		 }   
      }
/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.home.shell
*/
//	onInit: function() {
//
//	},

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf ui.home.shell
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf ui.home.shell
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf ui.home.shell
*/
//	onExit: function() {
//
//	}

});