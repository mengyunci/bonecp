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
//        $.ajax({
//           url:"${ctxPath}/menu/all",
//            data: {'userCode' : 'xwzhb'},
//            success : function(data) {
//                if (data.length) {
//                    data.forEach(function (item) {
//                        treeView(item);
//                    })
//                }
//                $("#sidebar_left_tree").html(html);
//                $(".treeview-menu>li:not('.treeview')").on("click",function () {
//                    $(".treeview-menu>li:not('.treeview')").removeClass("active");
//                    $(this).addClass("active");
//                    $("#xch_content_section").load($(this).children("a").attr("data-url"));
//                })
//            }
//        });
//        var html = "";
//        function treeView(item) {
//            if (!item.children) {
//                if (item.leaf) {
//                    html += '<li><a href="#" data-url="' +item.url + '"><i class="fa fa-circle-o"></i>' + item.text +'</a></li>';
//                } else {
//                    html += '<ul class="treeview-menu">' + treeView(item)+ '</ul>';
//                }
//            } else {
//                if (!item.leaf) {
//                    html += '<li class="treeview"><a href="#"><i class="fa fa-dashboard"></i> <span>' + item.text + '</span><i class="fa fa-angle-left pull-right"></i></span></a><ul class="treeview-menu">';
//                    item.children.forEach(function (i) {
//                        treeView(i)
//                    });
//                    html += '</ul></li>';
//                }
//            }
//        }
</script>
