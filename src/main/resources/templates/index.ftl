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
</head>
<body class="easyui-layout">
<div data-options="region:'north'">
    <div region="north" border="false"
         class="group wrap header panel-body panel-body-noheader panel-body-noborder layout-body"
         style="font-size: 100%; width: 100%;" title="">
        <div class="content">
            <div class="navigation-toggle" data-tools="navigation-toggle" data-target="#navbar-1">
                <span>EasyUI</span>
            </div>
            <div id="elogo" class="navbar navbar-left">
                <ul>
                    <li>
                        <a href="/index.php"><img src="${base}/images/logo/shdzlogo.png" alt="至越机械" style="width: 150px;height: 50px;"/></a>
                    </li>
                </ul>
            </div>
            <div id="navbar-1" class="navbar navbar-right">
                <ul>
                    <li><a href="/">首页</a></li>
                    <li><a href="/demo/main/index.php">系统管理</a></li>
                    <li><a href="/tutorial/index.php">MES</a></li>
                    <li><a href="/documentation/index.php">质量管理</a></li>
                    <li><a href="/download/index.php">MDC</a></li>
                    <li><a href="/extension/index.php">用户管理</a></li>
                </ul>
            </div>
            <div style="clear:both"></div>
        </div>

    </div>
</div>

<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
<div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
<div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>


</body>
</html>