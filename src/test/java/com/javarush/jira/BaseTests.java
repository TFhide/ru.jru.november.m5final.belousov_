package com.javarush.jira;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:schema/changelogTest.sql", "classpath:data/init_data.sql"},
        config = @SqlConfig(encoding = "UTF-8"))
abstract class BaseTests {
}
