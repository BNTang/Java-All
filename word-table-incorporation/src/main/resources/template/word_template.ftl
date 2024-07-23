<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<w:document xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main">
    <w:body>
        <w:tbl>
            <w:tr>
                <w:tc><w:p><w:r><w:t>项目</w:t></w:r></w:p></w:tc>
                <w:tc><w:p><w:r><w:t>序号</w:t></w:r></w:p></w:tc>
                <w:tc><w:p><w:r><w:t>种类</w:t></w:r></w:p></w:tc>
                <w:tc><w:p><w:r><w:t>数量</w:t></w:r></w:p></w:tc>
                <w:tc><w:p><w:r><w:t>危害性</w:t></w:r></w:p></w:tc>
            </w:tr>
            <#list projects as project>
                <#list project.items as item>
                    <w:tr>
                        <#if item_index == 0>
                            <w:tc><w:tcPr><w:vMerge w:val="restart"/></w:tcPr><w:p><w:r><w:t>${project.name}</w:t></w:r></w:p></w:tc>
                        <#else>
                            <w:tc><w:tcPr><w:vMerge w:val="continue"/></w:tcPr><w:p></w:p></w:tc>
                        </#if>
                        <w:tc><w:p><w:r><w:t>${item_index + 1}</w:t></w:r></w:p></w:tc>
                        <w:tc><w:p><w:r><w:t>${item.type}</w:t></w:r></w:p></w:tc>
                        <w:tc><w:p><w:r><w:t>${item.quantity}</w:t></w:r></w:p></w:tc>
                        <#if item_index % 2 == 0>
                            <w:tc><w:tcPr><w:vMerge w:val="restart"/></w:tcPr><w:p><w:r><w:t>高危数量</w:t></w:r></w:p></w:tc>
                        <#else>
                            <w:tc><w:tcPr><w:vMerge w:val="continue"/></w:tcPr><w:p></w:p></w:tc>
                        </#if>
                    </w:tr>
                </#list>
            </#list>
        </w:tbl>
    </w:body>
</w:document>
