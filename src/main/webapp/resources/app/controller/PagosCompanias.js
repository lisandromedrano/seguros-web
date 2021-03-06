Ext.define('app.controller.PagosCompanias', {
    extend: 'app.controller.BaseController',
    views: ['pagoscompanias.List'],
	stores:  ['PagosCompanias'],
	refs: [{
	    ref: 'grid',
	    selector: 'pagoscompaniasList'
	},{
	    ref: 'pagoscompaniasList',
	    selector: 'pagoscompaniasList'
	},{
	    ref: 'form',
	    selector: 'pagoscompaniasEdit'
	}],
	init: function() {
		var me = this;
		this.entityName="Pagos Compania";
		this.controller="pagoscompanias";
		this.model="app.model.PagosCompanias";
		this.editionFormXtype="pagoscompaniasEdit";
		this.titleField='id';
		this.afterFillFormFn=function(panel,form,record){
			//fill combos					
			panel.setTitle(record.data.companias.nombre+' - '+record.data.fecha);
			form.findField('companias.id').setValue(record.data.companias.id)
		}
		this.control({
				'pagoscompaniasList':{
					itemdblclick:me.gridRowDblClick
//					,edit:me.gridRowEdit
					,edit:function(editor, e){
						//reload combo, because it has less records, may due to an autocomplete action
						var comboStore = me.getGrid().getComboBoxStore();
						comboStore.proxy.extraParams = {
							'name' : ''
						};
						comboStore.load({
							callback : function() {
								//then we can call gridRowEdit event
//								me.gridRowEdit(editor,e);
								delete e.record.data.companias
								me.save(e.record);
							}
						})
						//truncate polizas Data
//						var companiaID=e.record.data.companias.id
//						delete e.record.data.companias
//						e.record.data.polizas={
//								id:polizaID
//						};					
//						e.record.data['companias.id']=companiaID
//						me.save(e.record);
					}
					,validateedit:me.validateedit
					,scope:me
					,beforeedit: function(editor, e) {
				    	var record=e.record;
				    	//fill combos
				    	Ext.ComponentQuery.query('datefield[name=fecha]')[0].setValue(record.data.fecha)
				    	Ext.ComponentQuery.query('companiasCombo')[0].setValue(''+record.data.companias.id)

				    }	
					,render:function(grid){
						grid.store.load();
					}
				}
				,'pagoscompaniasList > toolbar > button#add':{
					click:me.gridButtonAdd,
					scope:me
		    	}
				,'pagoscompaniasList > toolbar > button#delete':{
		    		click:me.gridRowDelete,
		    		scope: me
		    	}		    	
				,'pagoscompaniasEdit>toolbar>button#save':{
					click:me.buttonSaveClick,
					scope: me
				}
				,'pagoscompaniasList > toolbar > textfield#buscarPagoCompania':{
		    		  specialkey: function(f,e){
		    				
		                  if (e.getKey() == e.ENTER) {
		                	  var inputValue=f.value.toUpperCase();
		                	  me.getPagoscompaniasList().store.currentPage = 1;
		                	  me.getPagoscompaniasList().store.proxy.extraParams={findByName:inputValue};
		                	  me.getPagoscompaniasList().store.load();
//		                	  load({
//		                		  params:{findByName:f.value.toUpperCase()}})
		                  }
		               }
		        
		    	}
				,'companiasCombo#buscarCompania':{
					select:function(combo, records, eOpts){
//						console.log('selected');
						this.getGrid().store.proxy.extraParams={idCompania:combo.getValue()};
						this.getGrid().store.load();
					}
				}
		
			});
		this.callParent(arguments);
		
	}
	
});
