package demo.jars_in_war.method1.controller;

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

import demo.jars_in_war.method1.app.ApplicationA;

/**
 * 
 * Tests for ClassA
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationA.class)
@AutoConfigureMockMvc
public class ClassATests {

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
    public void noParamMethodAShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/methodA")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("MethodA, value = null"));
    }

    /**
     * Tests the response to requests with the given value.
     * @throws Exception
     */    
    @Test
    public void paramMethodAShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/methodA").param("value", "data1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("MethodA, value = data1"));
    }

}
