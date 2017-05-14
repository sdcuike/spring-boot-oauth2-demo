package com.sdcuike.practice.documentation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sdcuike.practice.Application;

import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Profile("doc")
public class SpringfoxConfigTest {
    private static final String   API_URI = "/v2/api-docs";

    @Autowired
    private WebApplicationContext context;

    private MockMvc               mockMvc;

    private File                  projectDir;

    @Before
    public void setup() throws IOException {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

        ClassPathResource pathfileRes = new ClassPathResource("application.yml");
        projectDir = pathfileRes.getFile().getParentFile().getParentFile().getParentFile();
    }

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        Swagger2MarkupResultHandler.Builder builder = Swagger2MarkupResultHandler
                .outputDirectory(outputDirForFormat("asciidoc"));
        mockMvc.perform(get(API_URI).accept(MediaType.APPLICATION_JSON))
                .andDo(builder.build())
                .andExpect(status().isOk());

    }

    private String outputDirForFormat(String format) throws IOException {
        return new File(projectDir, "target/docs/" + format + "/generated").getAbsolutePath();
    }
}
