//Default message for required fields
Ext.data.validations.presenceMessage = "El campo es obligatorio";
Ext.data.validations.emailMessage = "Direccion de email invalida";

//Fix Chrome Bug: ToolTips not wide enough to see contents
delete Ext.tip.Tip.prototype.minWidth;

Ext.define("app.view.Header", {
    extend: Ext.Container,
    xtype: "appHeader",
    id: "app-header",
    height: 52,
    layout: {type: "hbox",align: "middle"},
    initComponent: function() {
        this.items = [{xtype: "component",id: "app-header-title",html: "Ext JS Kitchen Sink",flex: 1}];
        if (!Ext.getCmp("options-toolbar")) {
            this.items.push({xtype: "themeSwitcher"})
        }
        this.callParent()
    }
});
//Ext.Window.prototype._autoTile = function() {
//    var x = 10,
//        y = 10;
//
//    Ext.WindowMgr.each(function( win ) {
//        if ( win === this )  return;
//
//        var pos = win.getPosition();
//
//        if ( pos[0] > (x - 15)
//            && pos[0] < (x + 15)
//            && pos[1] > (y - 15)
//            && pos[1] < (y + 15)
//        ) {
//            x += 15;
//            y += 15;
//        }
//    }, this);
//
//    this.setPagePosition(x, y);
//};
//
//Ext.Window.prototype.initComponent =
//	Ext.Function.createSequence(Ext.Window.prototype.initComponent,function() {
//        if ( this.autoTile ) {
//            this.on('show', this._autoTile, this, {single: true});
//        }
//    });
//Ext.Window.prototype.lastXY=0;
//Ext.Window.prototype.lastLT=0;
//Ext.override(Ext.Window, {
//    beforeShow : function(){
//        delete this.el.lastXY;
//        delete this.el.lastLT;
//        if(this.x === undefined || this.y === undefined){
//            var xy = this.el.getAlignToXY(this.container, 'c-c');
//            var pos = this.el.translatePoints(xy[0], xy[1]);
//            this.x = this.x === undefined? pos.left : this.x;
//            this.y = this.y === undefined? pos.top : this.y;
//            if (this.cascadeOnFirstShow) {
//                var prev;
//                this.manager.each(function(w) {
//                    if (w == this) {
//                        if (prev) {
//                        	var o = (typeof this.cascadeOnFirstShow == 'number') ? this.cascadeOnFirstShow : 20;
//                            var p = prev.getPosition();
//                            this.x = p[0] + o;
//                            this.y = p[1] + o;
//                        }
//                        return false;
//                    }
//                    if (w.isVisible()) prev = w;
//                }, this);
//            }
//        }
//        this.el.setLeftTop(this.x, this.y);
//
//        if(this.expandOnShow){
//            this.expand(false);
//        }
//
//        if(this.modal){
//            Ext.getBody().addClass("x-body-masked");
//            this.mask.setSize(Ext.lib.Dom.getViewWidth(true), Ext.lib.Dom.getViewHeight(true));
//            this.mask.show();
//        }
//    }
//});
Ext.define('Ext.ux.form.field.Currency', {
    extend: 'Ext.form.field.Text',

    alias: 'widget.currencyfield',

    initComponent: function (config) {
        this.callParent(arguments);
    },

    hasFocus: false,

    listeners: {
        render: function () {
            var form = this.findParentByType('form');

            form.on('afterLoadRecord', function () {
                this.toRaw();
                if (this.getRawValue() == 0) {
                    this.setRawValue('');
                } else {
                    this.toFormatted();
                }
            }, this);

            form.on('beforeUpdateRecord', function () {
                this.toRaw();
            }, this);

            form.on('afterUpdateRecord', function () {
                this.toRaw();
                if (this.getRawValue() == 0) {
                    this.setRawValue('');
                } else {
                    this.toFormatted();
                }
            }, this);
        },
        focus: function (field, e, eOpts) {
            this.toRaw();
            this.hasFocus = true;
        },
        blur: function (field, e, eOpts) {
            //Clear out commas and $
            this.toRaw();

            //If there's a value, format it
            if(field.getValue() != '') {
                this.toFormatted();
                this.hasFocus = false;
            }
        }
    },

    stripAlpha: function (value) {
        return value.replace(/[^0-9.]/g, '');
    },

    toRaw: function () {
        if (this.readOnly !== true) {
            this.setRawValue(this.stripAlpha(this.getRawValue()));
        }
    },

    toFormatted: function () {
        this.setRawValue(Ext.util.Format.currency(this.getRawValue(), '$ ', 0));
    },

    getValue: function () {
        return parseFloat(this.stripAlpha(this.getRawValue()));
    }
});

/**
 * Date range validation
 */
Ext.require('Ext.data.validations', function() {
    Ext.apply(Ext.data.validations, {

        daterangeMessage : 'La fecha {0} debe ser anterior a {1}',
//        message:'La fecha {0} debe ser anterior a {1}',
        daterange        : function(config, value, record) {
            var minValue = record.get(config.minField),
                maxValue = record.get(config.maxField);
            var ret=minValue < maxValue;
            if(!ret){
            	this.daterangeMessage = Ext.String.format(this.daterangeMessage, config.minFieldName, config.maxFieldName);
            }
            return ret;
        }
    });
});
/*
 * Override for being able date range validation
 */
Ext.require('Ext.data.Model', function() {
    Ext.data.Model.override({

        validate: function() {
            var errors      = Ext.create('Ext.data.Errors'),
                validations = this.validations,
                validators  = Ext.data.validations,
                length, validation, field, valid, type, i;

            if (validations) {
                length = validations.length;

                for (i = 0; i < length; i++) {
                    validation = validations[i];
                    field = validation.field || validation.name;
                    type  = validation.type;
                    valid = validators[type](validation, this.get(field), this); // added 3rd argument to pass model instance

                    if (!valid) {
                        errors.add({
                            field  : field,
                            message: validation.message || validators[type+'Message']
                        });
                    }
                }
            }

            return errors;
        }
    });
});