package br.com.wpattern.frameworks.test.spring.data;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ctx-wpattern-frameworks-spring-data.xml" })
public abstract class AbstractSpringDataTest {

}
