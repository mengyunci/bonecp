/**
 * Created by mac on 16/3/23.
 */
$(function() {
    $("#navbar-1 a").click(function() {
        var center = $('body').layout('panel','center');
        if ($(this).attr("index")) {
            $("body").layout('remove','west');
            center.panel('refresh','/');
        } else {
            var show = $(this).attr("show");
            var modelId = $(this).attr("moduleId");
            var west = $('body').layout('panel','west');
            if (!west.size()) {
                $("body").layout('add',{
                    title: show,
                    region: 'west',
                    width: 220,
                    collapsible : false,
                    href:'/menuview/' + modelId
                });
            } else {
                west.panel('setTitle',show).panel('refresh','/menuview/' + modelId)
            }
            center.panel('clear');
        }
    })
});