<#assign base=rc.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="${base}/css/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/basic/main.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/basic/kube.css">
    <script type="text/javascript" src="${base}/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${base}/js/common.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false"
     class="group wrap header panel-body panel-body-noheader panel-body-noborder layout-body"
     style="font-size: 100%; width: 100%; height: 66px;">
    <div class="content">
        <div class="navigation-toggle" data-tools="navigation-toggle" data-target="#navbar-1">
            <span>EasyUI</span>
        </div>
        <div id="elogo" class="navbar navbar-left">
            <ul>
                <li>
                    <a href="#"><img src="${base}/images/logo/shdzlogo.png" alt="至越机械"
                                              style="width: 150px;height: 50px;"/></a>
                </li>
            </ul>
        </div>
        <div id="navbar-1" class="navbar navbar-right">
            <ul>
                <li><a index="index" href="#">首页</a></li>
                <li><a show="系统管理" href="#">系统管理</a></li>
                <li><a show="MES" href="#">MES</a></li>
                <li><a show="质量管理" href="#">质量管理</a></li>
                <li><a show="MDC" href="#">MDC</a></li>
                <li><a show="用户管理" href="#">用户管理</a></li>
            </ul>
        </div>
        <div style="clear:both"></div>
    </div>
</div>

<div data-options="region:'west',title:'West',collapsible:false" style="width:220px;"></div>
<div data-options="region:'center'" style="padding:5px;background:#eee;"></div>
<div data-options="region:'south',collapsible:false,border:false" style="text-align: center">
    <span>WE  JUST  DO  WE  LIKE   ~~~~~  GO  AWAY  THE   COMPANY</span>
</div>


</body>
</html>