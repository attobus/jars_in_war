/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.jars_in_war.method2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import demo.jars_in_war.method2.app.ApplicationB;


/**
 * 
 * Tests for ClassB
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationB.class)
@AutoConfigureMockMvc
public class ClassBTests {

	/**
	 * Mock MVC for performing tests
	 */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests the response to requests with no parameters.
     * @throws Exception
     */
    @Test
    public void noParamMethodBShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/methodB")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("MethodB, value = null"));
    }

    /**
     * Tests the response to requests with the given value.
     * @throws Exception
     */
    @Test
    public void paramMethodBShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/methodB").param("value", "data2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("MethodB, value = data2"));
    }

}
