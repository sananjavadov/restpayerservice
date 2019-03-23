package az.smr.restpayerservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JuridicalPayerTest {

    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext c;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(c)
                .build();
    }
    
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/j/1602504081"))
								
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.response").value("ok"))
					.andExpect(jsonPath("$.voen").value("1602504081"))
					.andExpect(jsonPath("$.name").value("\"VİTA APTEKLƏRİ\" Məhdud Məsuliyyətli Cəmiyyəti"));
					
	}
}
