<ul id="tree_type"></ul>
<script type="text/javascript">
    var center = $('body').layout('panel','center');
//    if (!center.tabs('options')) {
//        center.tabs();
//    }
    $('#tree_type').tree({
        url:'/menu/${moduleId}',
        onClick: function(node) {
            if (node.url && !node.checked) {

//                center.panel('refresh',node.url);
                $("#panel_center").tabs('add',{
                    title:'New Tab',
                    content:'Tab Body'
                });
            }
        }
    });
</script>