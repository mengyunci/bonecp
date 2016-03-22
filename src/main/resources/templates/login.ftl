<#assign base=rc.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>三环锻造集成制造执行系统</title>
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0 auto;
            border: 0;
            font-family: "微软雅黑";
        }

        a, a:hover, a:active, a:link {
            border: none !important;
            text-decoration: none !important
        }

        .dl-main {
            width: 600px;
            height: 400px;
            position: absolute;
            left: 50%;
            margin-left: -300px;
            top: 20%;
        }

        .logo {
            width: 600px;
        }

        .dl-main .bd {
            width: 503px;
            height: 303px;
            margin: 0 auto;
            background: url('${base}/images/login/dlbj.png') no-repeat center center;
            position: absolute;
            top: 90px;
            left: 50%;
            margin-left: -300px;
            border-radius: 15px;
        }

        .dl-main .bd .title {
            color: #fff;
            text-shadow: 2px 2px 2px #006699;
            font-size: 24px;
            font-weight: 500;
            margin: 22px auto;
            text-align: center;
        }

        .dl-main .bd table {
            padding: 0px;
            margin-left: 60px;
        }

        .dl-main .bd table .tr-text {
            height: 50px;
            padding: 0px;
            color: #fff;
            text-align: center;
            text-shadow: 1px 1px 2px #006699;
            font-size: 18px;
            font-weight: 600;
        }

        .dl-main .bd table .yhm {
            width: 250px;
            height: 30px;
            padding-left: 5px
        }

        .dl-main .bd table .mima {
            width: 250px;
            height: 30px;
            padding-left: 5px
        }

        .dl-main .bd table .tr-err {
            height: 20px;
            line-height: 16px;
            color: #f00;
            font-size: 12px;
            text-shadow: 1px 1px 1px #fff;
        }

        .dl-main .bd table .tj {
            background: url('${base}/images/login/anniu-b.png');
            color: #FFF
        }

        .radius5 {
            border-radius: 5px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px
        }

        .dl-main .bd table .btn input {
            float: left;
            width: 120px;
            line-height: 40px;
            height: 40px;
            border: none;
            color: #FFF;
            cursor: pointer
        }
    </style>
</head>

<body style="background:url(${base}/images/login/zhiyue_bg.jpg); position:absolute; top:0; left:0; z-index:-100; width:100%; height:100%">

<div class="dl-main">
    <!--logo-->
    <div class="logo"><img src="${base}/images/logo/zhiyue.png" width="500" height="91"/></div>

    <div class="bd">
        <!--标题-->
        <dd class="title">用户登录</dd>
        <!--表单-->
        <form action="${base}/login" method="post">
            <table width="450" cellpadding="0" cellspacing="0">
                <!--用户名输入框-->
                <tr class="tr-text">
                    <td width="20%" style=" text-align:center">用户名</td>
                    <td width="70%" style="text-align:left;"><input type="text" name="username" class="yhm radius5"
                                                                    placeholder="请输入用户名"/></td>
                </tr>

                <#--<!--用户名报错信息 默认隐藏&ndash;&gt;-->
                <#--<tr class="tr-err">-->
                    <#--<td>&nbsp;</td>-->
                    <#--<td class="display-none">错误提示：请输入用户名</td>-->
                <#--</tr>-->

                <!--密码输入框-->
                <tr class="tr-text">
                    <td width="20%" style="text-align:center;">密&nbsp; &nbsp;码</td>
                    <td width="70%" style="text-align:left;"><input type="password" name="password" class="mima radius5"
                                                                    placeholder="请输入密码"/></td>
                </tr>

                <!--密码报错信息 默认隐藏-->
            <#if message??>
                <tr class="tr-err">
                    <td>&nbsp;</td>
                    <td id="error_info">错误提示：${message}</td>
                </tr>
            </#if>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

                <!--按钮-->
                <tr class="tr-text">
                    <td>&nbsp;</td>
                    <td class="btn">
                        <input type="submit" class="tj" value="提交"
                               style=" background:url('${base}/images/login/anniu.png'); "/>
                        <input type="reset" name="chongzhi" class="cz" value="取消"
                               style=" background: url('${base}/images/login/anniu.png'); margin-left:15px;"/>
                    </td>
                </tr>
            </table>
        </form>

    </div>
</div>
<#--<script type="application/javascript">-->

    <#--function GetQueryString(name) {-->
        <#--var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");-->
        <#--var r = window.location.search.substr(1).match(reg);-->
        <#--if (r != null)return unescape(r[2]);-->
        <#--return null;-->
    <#--}-->
    <#--if (GetQueryString("error")) {-->
        <#--var tag = document.getElementById("error_info");-->
        <#--tag.innerHTML = "用户名或者密码错误";-->
        <#--tag.setAttribute("class", "");-->
    <#--}-->
<#--</script>-->
</body>
</html>
