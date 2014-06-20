sap.ui.jsview("ui.home.shell", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf ui.home.shell
	*/ 
	getControllerName : function() {
		return "ui.home.shell";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf ui.home.shell
	*/ 
	createContent : function(oController) {
		var oShell = new sap.ui.ux3.Shell({
            id: "main-shell",
            appTitle: "Shell Test",
            showLogoutButton: false,
            showFeederTool: false,
            showSearchTool: true,
            showInspectorTool: false,
            headerItems:[new sap.ui.commons.Label({text:"bubuwork"})],
            paneBarItems:[new sap.ui.ux3.NavigationItem({
  			  text:"Help",
  			  id:"pane-bar-help",
  			  icon:"images/help.png"
  		  })]
        });
  	  
        return oShell;
	}

});
