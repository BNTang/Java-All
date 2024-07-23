<table border="1">
    <thead>
    <tr>
        <th>项目</th>
        <th>序号</th>
        <th>种类</th>
        <th>数量</th>
        <th>危害性</th>
    </tr>
    </thead>
    <tbody>
    <#list data as row>
        <tr>
            <#if row.mergeRows??>
                <td rowspan="${row.mergeRows}">${row.project}</td>
            <#else>
                <td>${row.project}</td>
            </#if>
            <td>${row.serialNumber}</td>
            <td>${row.category}</td>
            <td>${row.quantity}</td>
            <td>${row.risk}</td>
        </tr>
    </#list>
    </tbody>
</table>
