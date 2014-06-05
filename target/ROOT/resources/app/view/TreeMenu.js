var store = Ext.create('Ext.data.TreeStore', {
    root: {
        expanded: true,
        children: [
            { text: "detention", leaf: true },
            { text: "homework", expanded: true, children: [
                { text: "book report", leaf: true },
                { text: "alegrbra", leaf: true}
            ] },
            { text: "buy lottery tickets", leaf: true }
        ]
    }
});
Ext.define("app.view.TreeMenu", {
    extend: 'Ext.tree.Panel',
	alias:'widget.treemenu',
    store: store,
    rootVisible: false
});