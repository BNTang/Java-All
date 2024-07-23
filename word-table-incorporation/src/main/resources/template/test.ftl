<#assign w = "http://schemas.openxmlformats.org/wordprocessingml/2006/main">
<#-- 文档开始 -->
<w:wordDocument>
    <w:body>
        <w:tbl>
            <w:tblPr>
                <w:tblStyle w:val="TableGrid" />
                <w:tblW w:w="0" w:type="auto" />
                <w:tblLook w:val="04A0" />
            </w:tblPr>
            <#-- 表格标题行 -->
            <w:tr>
                <w:tc>
                    <w:tcPr>
                        <w:tcW w:width="2130" w:type="dxa" />
                        <w:shd w:val="clear" w:color="auto" w:fill="F2F2F2" />
                    </w:tcPr>
                    <w:p>
                        <w:pPr>
                            <w:jc w:val="center" />
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                        </w:pPr>
                        <w:r>
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                            <w:t>星期</w:t>
                        </w:r>
                    </w:p>
                </w:tc>
                <w:tc>
                    <w:tcPr>
                        <w:tcW w:width="2130" w:type="dxa" />
                        <w:shd w:val="clear" w:color="auto" w:fill="F2F2F2" />
                    </w:tcPr>
                    <w:p>
                        <w:pPr>
                            <w:jc w:val="center" />
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                        </w:pPr>
                        <w:r>
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                            <w:t>姓名</w:t>
                        </w:r>
                    </w:p>
                </w:tc>
                <w:tc>
                    <w:tcPr>
                        <w:tcW w:width="2130" w:type="dxa" />
                        <w:shd w:val="clear" w:color="auto" w:fill="F2F2F2" />
                    </w:tcPr>
                    <w:p>
                        <w:pPr>
                            <w:jc w:val="center" />
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                        </w:pPr>
                        <w:r>
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                            <w:t>日期</w:t>
                        </w:r>
                    </w:p>
                </w:tc>
                <w:tc>
                    <w:tcPr>
                        <w:tcW w:width="2130" w:type="dxa" />
                        <w:shd w:val="clear" w:color="auto" w:fill="F2F2F2" />
                    </w:tcPr>
                    <w:p>
                        <w:pPr>
                            <w:jc w:val="center" />
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                        </w:pPr>
                        <w:r>
                            <w:rPr>
                                <w:rFonts w:hint="eastAsia" />
                                <w:b w:val="on" />
                            </w:rPr>
                            <w:t>内容</w:t>
                        </w:r>
                    </w:p>
                </w:tc>
            </w:tr>
            <#-- 表格循环开始 -->
            <#list userList as user>
            <#-- 行开始 -->
                <w:tr>
                    <#-- 星期列的合并判断 -->
                    <w:tc>
                        <w:tcPr>
                            <w:tcW w:width="2130" w:type="dxa" />
                            <#if user.map.week == "1">
                                <#if user.map.pre == "0">
                                    <w:vMerge w:val="restart" />
                                <#else>
                                    <w:vMerge />
                                </#if>
                            <#else>
                                <#if user.map.pre!= "0">
                                    <w:vMerge />
                                </#if>
                            </#if>
                        </w:tcPr>
                        <w:p>
                            <w:pPr>
                                <w:jc w:val="center" />
                            </w:pPr>
                            <w:r>
                                <w:rPr>
                                    <w:rFonts w:hint="eastAsia" />
                                </w:rPr>
                                <w:t>${user.week}</w:t>
                            </w:r>
                        </w:p>
                    </w:tc>
                    <w:tc>
                        <w:tcPr>
                            <w:tcW w:width="2130" w:type="dxa" />
                        </w:tcPr>
                        <w:p>
                            <w:pPr>
                                <w:jc w:val="center" />
                            </w:pPr>
                            <w:r>
                                <w:rPr>
                                    <w:rFonts w:hint="eastAsia" />
                                </w:rPr>
                                <w:t>${user.name}</w:t>
                            </w:r>
                        </w:p>
                    </w:tc>
                    <w:tc>
                        <w:tcPr>
                            <w:tcW w:width="2130" w:type="dxa" />
                        </w:tcPr>
                        <w:p>
                            <w:pPr>
                                <w:jc w:val="center" />
                            </w:pPr>
                            <w:r>
                                <w:rPr>
                                    <w:rFonts w:hint="eastAsia" />
                                </w:rPr>
                                <w:t>${user.date}</w:t>
                            </w:r>
                        </w:p>
                    </w:tc>
                    <w:tc>
                        <w:tcPr>
                            <w:tcW w:width="2130" w:type="dxa" />
                        </w:tcPr>
                        <w:p>
                            <w:pPr>
                                <w:jc w:val="center" />
                            </w:pPr>
                            <w:r>
                                <w:rPr>
                                    <w:rFonts w:hint="eastAsia" />
                                </w:rPr>
                                <w:t>${user.content}</w:t>
                            </w:r>
                        </w:p>
                    </w:tc>
                </w:tr>
            </#list>
            <#-- 表格循环结束 -->
        </w:tbl>
    </w:body>
</w:wordDocument>
