package com.homework.course_work.service.commonConfig;

import com.homework.course_work.service.config.BookServiceConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextHierarchy({
        @ContextConfiguration(classes = BookServiceConfiguration.class)
})
public abstract class CommonConfigJPATest {

}
