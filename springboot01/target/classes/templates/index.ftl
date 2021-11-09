<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title>首页</title>
</head>
<body>

${name}

<br/>

<#if sex=="1">
    男
<#elseif sex=="2">
    女
<#else>
    其他
</#if>

<br/>


<#list listResult as user>
    ${user}
</#list>


<br/>

</body>
</html>
