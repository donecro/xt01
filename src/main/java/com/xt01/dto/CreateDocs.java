package com.xt01.dto;

import io.github.yedaxia.apidocs.Docs;

public class CreateDocs {

    public static void main(String[] args) {
        Docs.DocsConfig docsConfig = new Docs.DocsConfig();
        docsConfig.setProjectPath("/Users/Donecro/Documents/微信公众号需求/xt01");
        docsConfig.setDocsPath("/Users/Donecro/Documents/微信公众号需求/xt01/src/main/webapp/WEB-INF/view/docs");
        Docs.buildHtmlDocs(docsConfig);
    }

}
