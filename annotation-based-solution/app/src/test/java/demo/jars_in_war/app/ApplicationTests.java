package demo.jars_in_war.app;

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

/**
 *	The tests similar to tests in the jar files 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
	
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
